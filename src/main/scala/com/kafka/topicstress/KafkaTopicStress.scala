package com.kafka.topicstress

import java.io.IOException
import java.net.InetSocketAddress
import java.util.{Collections, Properties, UUID}

import kafka.server.{KafkaConfig, KafkaServer}
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.admin.{AdminClient, NewTopic}
import org.apache.kafka.common.network.ListenerName
import org.apache.log4j.LogManager
import org.apache.zookeeper.server.{NIOServerCnxnFactory, ZooKeeperServer}

object KafkaTopicStress {

  @transient lazy val log = LogManager.getLogger(getClass)

  private class EmbeddedZookeeper(val zkConnect: String) {
    val snapshotDir = Utils.createTempDir()
    val logDir = Utils.createTempDir()

    val zookeeper = new ZooKeeperServer(snapshotDir, logDir, 500)
    val (ip, port) = {
      val splits = zkConnect.split(":")
      (splits(0), splits(1).toInt)
    }
    val factory = new NIOServerCnxnFactory()
    factory.configure(new InetSocketAddress(ip, port), 16)
    factory.startup(zookeeper)

    val actualPort = factory.getLocalPort

    def shutdown() {
      factory.shutdown()
      // The directories are not closed even if the ZooKeeper server is shut down.
      // Please see ZOOKEEPER-1844, which is fixed in 3.4.6+. It leads to test failures
      // on Windows if the directory deletion failure throws an exception.
      try {
        Utils.deleteRecursively(snapshotDir)
      } catch {
        case e: IOException =>
          log.error(e.getMessage)
      }
      try {
        Utils.deleteRecursively(logDir)
      } catch {
        case e: IOException =>
          log.error(e.getMessage)
      }
    }
  }

  private val zkHost = "127.0.0.1"
  private var zkPort = 0
  private var zookeeper: EmbeddedZookeeper = _
  private var zkReady = false

  private val brokerHost = "127.0.0.1"
  private var brokerPort = 0
  private var brokerConf: KafkaConfig = _
  private var server: KafkaServer = _
  private var brokerReady = false

  private var adminClient: AdminClient = null

  def zkAddress: String = {
    assert(zkReady, "Zookeeper not setup yet or already torn down, cannot get zookeeper address")
    s"$zkHost:$zkPort"
  }

  def brokerAddress: String = {
    assert(brokerReady, "Kafka not setup yet or already torn down, cannot get broker address")
    s"$brokerHost:$brokerPort"
  }

  private def setup(): Unit = {
    // Zookeeper server startup
    zookeeper = new EmbeddedZookeeper(s"$zkHost:$zkPort")
    // Get the actual zookeeper binding port
    zkPort = zookeeper.actualPort
    zkReady = true

    // Kafka broker startup
    brokerConf = new KafkaConfig(brokerConfiguration, doLog = false)
    server = new KafkaServer(brokerConf)
    server.startup()
    brokerPort = server.boundPort(new ListenerName("PLAINTEXT"))
    brokerReady = true

    val props = new Properties()
    props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, s"$brokerAddress")
    adminClient = AdminClient.create(props)
  }

  protected def brokerConfiguration: Properties = {
    val props = new Properties()
    props.put("broker.id", "0")
    props.put("host.name", "127.0.0.1")
    props.put("advertised.host.name", "127.0.0.1")
    props.put("port", brokerPort.toString)
    props.put("log.dir", Utils.createTempDir().getAbsolutePath)
    props.put("zookeeper.connect", zkAddress)
    props.put("zookeeper.connection.timeout.ms", "60000")
    props.put("log.flush.interval.messages", "1")
    props.put("replica.socket.timeout.ms", "1500")
    props.put("delete.topic.enable", "true")
    props.put("group.initial.rebalance.delay.ms", "10")

    // Change the following settings as we have only 1 broker
    props.put("offsets.topic.num.partitions", "1")
    props.put("offsets.topic.replication.factor", "1")
    props.put("transaction.state.log.replication.factor", "1")
    props.put("transaction.state.log.min.isr", "1")

    props
  }

  def teardown(): Unit = {
    brokerReady = false
    zkReady = false

    if (adminClient != null) {
      adminClient.close()
    }

    if (server != null) {
      server.shutdown()
      server.awaitShutdown()
      server = null
    }

    if (zookeeper != null) {
      zookeeper.shutdown()
      zookeeper = null
    }
  }

  def main(args: Array[String]): Unit = {
    setup()

    while (true) {
      val topic = UUID.randomUUID().toString
      log.info(s"New topic: $topic")
      val newTopic = new NewTopic(topic, 1, 1)
      adminClient.createTopics(Collections.singleton(newTopic)).all().get()
      adminClient.deleteTopics(Collections.singleton(topic)).all().get()
      // Thread.sleep(500)
      adminClient.createTopics(Collections.singleton(newTopic)).all().get()
      adminClient.deleteTopics(Collections.singleton(topic)).all().get()
    }

    teardown()
  }
}
