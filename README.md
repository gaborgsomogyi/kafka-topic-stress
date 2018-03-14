## A Kafka app which tests rapid topic creation/deletion.

### With sleep between delete and create:
```
>>> 19/05/30 21:58:40 INFO topicstress.KafkaTopicStress$: New topic: 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:40 INFO zk.AdminZkClient: Creating topic 5e75edba-ecf2-4879-8118-73d28f4afff6 with configuration {} and initial partition assignment Map(0 -> ArrayBuffer(0))
>>> 19/05/30 21:58:40 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x1005b2e4df90000 type:setData cxid:0xaa zxid:0x55 txntype:-1 reqpath:n/a Error Path:/config/topics/5e75edba-ecf2-4879-8118-73d28f4afff6 Error:KeeperErrorCode = NoNode for /config/topics/5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:40 INFO controller.KafkaController: [Controller id=0] New topics: [Set(5e75edba-ecf2-4879-8118-73d28f4afff6)], deleted topics: [Set()], new partition replica assignment [Map(5e75edba-ecf2-4879-8118-73d28f4afff6-0 -> Vector(0))]
>>> 19/05/30 21:58:40 INFO controller.KafkaController: [Controller id=0] New partition creation callback for 5e75edba-ecf2-4879-8118-73d28f4afff6-0
>>> 19/05/30 21:58:40 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:40 INFO log.Log: [Log partition=5e75edba-ecf2-4879-8118-73d28f4afff6-0, dir=/private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3] Loading producer state till offset 0 with message format version 2
>>> 19/05/30 21:58:40 INFO log.Log: [Log partition=5e75edba-ecf2-4879-8118-73d28f4afff6-0, dir=/private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3] Completed load of log with 1 segments, log start offset 0 and log end offset 0 in 3 ms
>>> 19/05/30 21:58:40 INFO log.LogManager: Created log for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 in /private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3 with properties {compression.type -> producer, message.format.version -> 2.2-IV1, file.delete.delay.ms -> 60000, max.message.bytes -> 1000012, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, message.downconversion.enable -> true, min.insync.replicas -> 1, segment.jitter.ms -> 0, preallocate -> false, min.cleanable.dirty.ratio -> 0.5, index.interval.bytes -> 4096, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, segment.ms -> 604800000, segment.bytes -> 1073741824, retention.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760, flush.messages -> 1}.
>>> 19/05/30 21:58:40 INFO cluster.Partition: [Partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 broker=0] No checkpointed highwatermark is found for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0
>>> 19/05/30 21:58:40 INFO cluster.Replica: Replica loaded for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 with initial high watermark 0
>>> 19/05/30 21:58:40 INFO cluster.Partition: [Partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 broker=0] 5e75edba-ecf2-4879-8118-73d28f4afff6-0 starts at Leader Epoch 0 from offset 0. Previous Leader Epoch was: -1
>>> 19/05/30 21:58:40 INFO controller.KafkaController: [Controller id=0] Starting topic deletion for topics 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:40 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Handling deletion for topics 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:40 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Deletion of topic 5e75edba-ecf2-4879-8118-73d28f4afff6 (re)started
>>> 19/05/30 21:58:40 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Topic deletion callback for 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:40 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Partition deletion callback for 5e75edba-ecf2-4879-8118-73d28f4afff6-0
>>> 19/05/30 21:58:40 INFO group.GroupCoordinator: [GroupCoordinator 0]: Removed 0 offsets associated with deleted partitions: 5e75edba-ecf2-4879-8118-73d28f4afff6-0.
>>> 19/05/30 21:58:40 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:40 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:40 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:40 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:40 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:40 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:40 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:40 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:40 INFO log.LogCleaner: The cleaning for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 is aborted and paused
>>> 19/05/30 21:58:40 INFO log.LogCleaner: The cleaning for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 is aborted
>>> 19/05/30 21:58:40 INFO log.LogManager: Log for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 is renamed to /private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3/5e75edba-ecf2-4879-8118-73d28f4afff6-0.0515a27415ae452fa8a04898dbb53de7-delete and is scheduled for deletion
>>> 19/05/30 21:58:40 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Handling deletion for topics 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:40 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Deletion of topic 5e75edba-ecf2-4879-8118-73d28f4afff6 successfully completed
>>> 19/05/30 21:58:40 INFO controller.KafkaController: [Controller id=0] New topics: [Set()], deleted topics: [Set()], new partition replica assignment [Map()]
>>> 19/05/30 21:58:41 INFO zk.AdminZkClient: Creating topic 5e75edba-ecf2-4879-8118-73d28f4afff6 with configuration {} and initial partition assignment Map(0 -> ArrayBuffer(0))
>>> 19/05/30 21:58:41 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x1005b2e4df90000 type:setData cxid:0xc5 zxid:0x63 txntype:-1 reqpath:n/a Error Path:/config/topics/5e75edba-ecf2-4879-8118-73d28f4afff6 Error:KeeperErrorCode = NoNode for /config/topics/5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:41 INFO controller.KafkaController: [Controller id=0] New topics: [Set(5e75edba-ecf2-4879-8118-73d28f4afff6)], deleted topics: [Set()], new partition replica assignment [Map(5e75edba-ecf2-4879-8118-73d28f4afff6-0 -> Vector(0))]
>>> 19/05/30 21:58:41 INFO controller.KafkaController: [Controller id=0] New partition creation callback for 5e75edba-ecf2-4879-8118-73d28f4afff6-0
>>> 19/05/30 21:58:41 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:41 INFO log.Log: [Log partition=5e75edba-ecf2-4879-8118-73d28f4afff6-0, dir=/private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3] Loading producer state till offset 0 with message format version 2
>>> 19/05/30 21:58:41 INFO log.Log: [Log partition=5e75edba-ecf2-4879-8118-73d28f4afff6-0, dir=/private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3] Completed load of log with 1 segments, log start offset 0 and log end offset 0 in 2 ms
>>> 19/05/30 21:58:41 INFO log.LogManager: Created log for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 in /private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3 with properties {compression.type -> producer, message.format.version -> 2.2-IV1, file.delete.delay.ms -> 60000, max.message.bytes -> 1000012, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, message.downconversion.enable -> true, min.insync.replicas -> 1, segment.jitter.ms -> 0, preallocate -> false, min.cleanable.dirty.ratio -> 0.5, index.interval.bytes -> 4096, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, segment.ms -> 604800000, segment.bytes -> 1073741824, retention.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760, flush.messages -> 1}.
>>> 19/05/30 21:58:41 INFO cluster.Partition: [Partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 broker=0] No checkpointed highwatermark is found for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0
>>> 19/05/30 21:58:41 INFO cluster.Replica: Replica loaded for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 with initial high watermark 0
>>> 19/05/30 21:58:41 INFO cluster.Partition: [Partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 broker=0] 5e75edba-ecf2-4879-8118-73d28f4afff6-0 starts at Leader Epoch 0 from offset 0. Previous Leader Epoch was: -1
>>> 19/05/30 21:58:41 INFO controller.KafkaController: [Controller id=0] Starting topic deletion for topics 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:41 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Handling deletion for topics 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:41 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Deletion of topic 5e75edba-ecf2-4879-8118-73d28f4afff6 (re)started
>>> 19/05/30 21:58:41 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Topic deletion callback for 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:41 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Partition deletion callback for 5e75edba-ecf2-4879-8118-73d28f4afff6-0
>>> 19/05/30 21:58:41 INFO group.GroupCoordinator: [GroupCoordinator 0]: Removed 0 offsets associated with deleted partitions: 5e75edba-ecf2-4879-8118-73d28f4afff6-0.
>>> 19/05/30 21:58:41 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:41 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:41 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:41 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:41 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:41 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set()
>>> 19/05/30 21:58:41 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:41 INFO server.ReplicaAlterLogDirsManager: [ReplicaAlterLogDirsManager on broker 0] Removed fetcher for partitions Set(5e75edba-ecf2-4879-8118-73d28f4afff6-0)
>>> 19/05/30 21:58:41 INFO log.LogCleaner: The cleaning for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 is aborted and paused
>>> 19/05/30 21:58:41 INFO log.LogCleaner: The cleaning for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 is aborted
>>> 19/05/30 21:58:41 INFO log.LogManager: Log for partition 5e75edba-ecf2-4879-8118-73d28f4afff6-0 is renamed to /private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-9b9fbcff-4618-43a4-a9aa-bbfea03a1fa3/5e75edba-ecf2-4879-8118-73d28f4afff6-0.d66f3c56b5cf41179760570bb3d39bd3-delete and is scheduled for deletion
>>> 19/05/30 21:58:41 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Handling deletion for topics 5e75edba-ecf2-4879-8118-73d28f4afff6
>>> 19/05/30 21:58:41 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Deletion of topic 5e75edba-ecf2-4879-8118-73d28f4afff6 successfully completed
>>> 19/05/30 21:58:41 INFO controller.KafkaController: [Controller id=0] New topics: [Set()], deleted topics: [Set()], new partition replica assignment [Map()]
```

### Without sleep between delete and create:
```
>>> 19/05/30 22:00:53 INFO topicstress.KafkaTopicStress$: New topic: 789291df-cdf3-44c5-a94d-5f5bf04c85fb
>>> 19/05/30 22:00:53 INFO zk.AdminZkClient: Creating topic 789291df-cdf3-44c5-a94d-5f5bf04c85fb with configuration {} and initial partition assignment Map(0 -> ArrayBuffer(0))
>>> 19/05/30 22:00:53 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x1005b3060030000 type:setData cxid:0x3e zxid:0x1d txntype:-1 reqpath:n/a Error Path:/config/topics/789291df-cdf3-44c5-a94d-5f5bf04c85fb Error:KeeperErrorCode = NoNode for /config/topics/789291df-cdf3-44c5-a94d-5f5bf04c85fb
>>> 19/05/30 22:00:53 INFO controller.KafkaController: [Controller id=0] New topics: [Set(789291df-cdf3-44c5-a94d-5f5bf04c85fb)], deleted topics: [Set()], new partition replica assignment [Map(789291df-cdf3-44c5-a94d-5f5bf04c85fb-0 -> Vector(0))]
>>> 19/05/30 22:00:53 INFO controller.KafkaController: [Controller id=0] New partition creation callback for 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0
>>> 19/05/30 22:00:53 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(789291df-cdf3-44c5-a94d-5f5bf04c85fb-0)
>>> 19/05/30 22:00:54 INFO log.Log: [Log partition=789291df-cdf3-44c5-a94d-5f5bf04c85fb-0, dir=/private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-07ea54e6-1605-4d79-bd99-2aeca729353b] Loading producer state till offset 0 with message format version 2
>>> 19/05/30 22:00:54 INFO log.Log: [Log partition=789291df-cdf3-44c5-a94d-5f5bf04c85fb-0, dir=/private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-07ea54e6-1605-4d79-bd99-2aeca729353b] Completed load of log with 1 segments, log start offset 0 and log end offset 0 in 56 ms
>>> 19/05/30 22:00:54 INFO log.LogManager: Created log for partition 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0 in /private/var/folders/t_/w90m85fn2gjb1v0c24wrfrxm0000gp/T/spark-07ea54e6-1605-4d79-bd99-2aeca729353b with properties {compression.type -> producer, message.format.version -> 2.2-IV1, file.delete.delay.ms -> 60000, max.message.bytes -> 1000012, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, message.downconversion.enable -> true, min.insync.replicas -> 1, segment.jitter.ms -> 0, preallocate -> false, min.cleanable.dirty.ratio -> 0.5, index.interval.bytes -> 4096, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, segment.ms -> 604800000, segment.bytes -> 1073741824, retention.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760, flush.messages -> 1}.
>>> 19/05/30 22:00:54 INFO cluster.Partition: [Partition 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0 broker=0] No checkpointed highwatermark is found for partition 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0
>>> 19/05/30 22:00:54 INFO cluster.Replica: Replica loaded for partition 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0 with initial high watermark 0
>>> 19/05/30 22:00:54 INFO cluster.Partition: [Partition 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0 broker=0] 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0 starts at Leader Epoch 0 from offset 0. Previous Leader Epoch was: -1
>>> 19/05/30 22:00:54 INFO controller.KafkaController: [Controller id=0] Starting topic deletion for topics 789291df-cdf3-44c5-a94d-5f5bf04c85fb
>>> 19/05/30 22:00:54 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Handling deletion for topics 789291df-cdf3-44c5-a94d-5f5bf04c85fb
>>> 19/05/30 22:00:54 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Deletion of topic 789291df-cdf3-44c5-a94d-5f5bf04c85fb (re)started
>>> 19/05/30 22:00:54 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Topic deletion callback for 789291df-cdf3-44c5-a94d-5f5bf04c85fb
>>> 19/05/30 22:00:54 INFO controller.TopicDeletionManager: [Topic Deletion Manager 0], Partition deletion callback for 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0
>>> 19/05/30 22:00:54 INFO group.GroupCoordinator: [GroupCoordinator 0]: Removed 0 offsets associated with deleted partitions: 789291df-cdf3-44c5-a94d-5f5bf04c85fb-0.
>>> 19/05/30 22:00:54 INFO server.AdminManager: [Admin Manager on Broker 0]: Error processing create topic request for topic 789291df-cdf3-44c5-a94d-5f5bf04c85fb with arguments (numPartitions=1, replicationFactor=1, replicasAssignments={}, configs={})
org.apache.kafka.common.errors.TopicExistsException: Topic '789291df-cdf3-44c5-a94d-5f5bf04c85fb' already exists.
Exception in thread "main" java.util.concurrent.ExecutionException: org.apache.kafka.common.errors.TopicExistsException: Topic '789291df-cdf3-44c5-a94d-5f5bf04c85fb' already exists.
	at org.apache.kafka.common.internals.KafkaFutureImpl.wrapAndThrow(KafkaFutureImpl.java:45)
	at org.apache.kafka.common.internals.KafkaFutureImpl.access$000(KafkaFutureImpl.java:32)
	at org.apache.kafka.common.internals.KafkaFutureImpl$SingleWaiter.await(KafkaFutureImpl.java:89)
	at org.apache.kafka.common.internals.KafkaFutureImpl.get(KafkaFutureImpl.java:260)
	at com.kafka.topicstress.KafkaTopicStress$.main(KafkaTopicStress.scala:147)
	at com.kafka.topicstress.KafkaTopicStress.main(KafkaTopicStress.scala)
Caused by: org.apache.kafka.common.errors.TopicExistsException: Topic '789291df-cdf3-44c5-a94d-5f5bf04c85fb' already exists.
```

### Conclusion
Even if `delete.topic.enable` enabled and the actual Kafka code says the following [here](https://github.com/apache/kafka/blob/932a1b7d7e2b7ea8c145552c3d050a0999ce13dc/core/src/main/scala/kafka/server/AdminManager.scala#L185):
```
  /**
    * Delete topics and wait until the topics have been completely deleted.
    * The callback function will be triggered either when timeout, error or the topics are deleted.
    */
```
topic deletion doesn't wait for fully completion. Such completion can be checked with ZKUtils
which is deprecated from Kafka version 2.0.0. Several applications are using it but seems like
there is no real alternative provided.
