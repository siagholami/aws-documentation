# DynamoDB Metrics and Dimensions<a name="metrics-dimensions"></a>

When you interact with DynamoDB, it sends the following metrics and dimensions to CloudWatch\. You can use the following procedures to view the metrics for DynamoDB\.

**To view metrics \(console\)**

Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Select the **DynamoDB** namespace\.

**To view metrics \(CLI\)**
+ At a command prompt, use the following command:

  ```
  1. aws cloudwatch list-metrics --namespace "AWS/DynamoDB"
  ```

CloudWatch displays the following metrics for DynamoDB:

## DynamoDB Dimensions and Metrics<a name="dynamodb-metrics-dimensions"></a>

The metrics and dimensions that DynamoDB sends to Amazon CloudWatch are listed here\.

### DynamoDB Metrics<a name="dynamodb-metrics"></a>

**Note**  
Amazon CloudWatch aggregates the following DynamoDB metrics at one\-minute intervals:  
`ConditionalCheckFailedRequests`
`ConsumedReadCapacityUnits`
`ConsumedWriteCapacityUnits`
`ReadThrottleEvents`
`ReturnedBytes`
`ReturnedItemCount`
`ReturnedRecordsCount`
`SuccessfulRequestLatency`
`SystemErrors`
`TimeToLiveDeletedItemCount`
`ThrottledRequests`
`TransactionConflict`
`UserErrors`
`WriteThrottleEvents`
For all other DynamoDB metrics, the aggregation granularity is five minutes\.

Not all statistics, such as *Average* or *Sum*, are applicable for every metric\. However, all of these values are available through the Amazon DynamoDB console, or by using the CloudWatch console, AWS CLI, or AWS SDKs for all metrics\. In the following table, each metric has a list of valid statistics that are applicable to that metric\.


| Metric | Description | 
| --- | --- | 
| AccountMaxReads |  The maximum number of read capacity units that can be used by an account\. This limit does not apply to on\-demand tables or global secondary indexes\. Units: `Count` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| AccountMaxTableLevelReads |  The maximum number of read capacity units that can be used by a table or global secondary index of an account\. For on\-demand tables this limit caps the maximum read request units a table or a global secondary index can use\. Units: `Count` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| AccountMaxTableLevelWrites |  The maximum number of write capacity units that can be used by a table or global secondary index of an account\. For on\-demand tables this limit caps the maximum write request units a table or a global secondary index can use\. Units: `Count` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| AccountMaxWrites |  The maximum number of write capacity units that can be used by an account\. This limit does not apply to on\-demand tables or global secondary indexes\. Units: `Count` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| AccountProvisionedReadCapacityUtilization |  The percentage of provisioned read capacity units utilized by an account\. Units: `Percent` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| AccountProvisionedWriteCapacityUtilization |  The percentage of provisioned write capacity units utilized by an account\. Units: `Percent` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ConditionalCheckFailedRequests |  The number of failed attempts to perform conditional writes\. The `PutItem`, `UpdateItem`, and `DeleteItem` operations let you provide a logical condition that must evaluate to true before the operation can proceed\. If this condition evaluates to false, `ConditionalCheckFailedRequests` is incremented by one\.  A failed conditional write will result in an HTTP 400 error \(Bad Request\)\. These events are reflected in the `ConditionalCheckFailedRequests` metric, but not in the `UserErrors` metric\.  Units: `Count` Dimensions: `TableName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ConsumedReadCapacityUnits |  The number of read capacity units consumed over the specified time period, so you can track how much of your provisioned throughput is used\. You can retrieve the total consumed read capacity for a table and all of its global secondary indexes, or for a particular global secondary index\. For more information, see [Read/Write Capacity Mode](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html)\.  Use the `Sum` statistic to calculate the consumed throughput\. For example, get the `Sum` value over a span of one minute, and divide it by the number of seconds in a minute \(60\) to calculate the average `ConsumedReadCapacityUnits` per second \(recognizing that this average does not highlight any large but brief spikes in read activity that occurred during that minute\)\. You can compare the calculated value to the provisioned throughput value that you provide DynamoDB\.  Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ConsumedWriteCapacityUnits |  The number of write capacity units consumed over the specified time period, so you can track how much of your provisioned throughput is used\. You can retrieve the total consumed write capacity for a table and all of its global secondary indexes, or for a particular global secondary index\. For more information, see [Read/Write Capacity Mode](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html)\.  Use the `Sum` statistic to calculate the consumed throughput\. For example, get the `Sum` value over a span of one minute, and divide it by the number of seconds in a minute \(60\) to calculate the average `ConsumedWriteCapacityUnits` per second \(recognizing that this average does not highlight any large but brief spikes in write activity that occurred during that minute\)\. You can compare the calculated value to the provisioned throughput value that you provide DynamoDB\.  Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| MaxProvisionedTableReadCapacityUtilization |  The percentage of provisioned read capacity units utilized by the highest provisioned read table or global secondary index of an account\. Units: `Percent` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| MaxProvisionedTableWriteCapacityUtilization |  The percentage of provisioned write capacity utilized by the highest provisioned write table or global secondary index of an account\. Units: `Percent` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| OnlineIndexConsumedWriteCapacity |  The number of write capacity units consumed when adding a new global secondary index to a table\. If the write capacity of the index is too low, incoming write activity during the backfill phase might be throttled\. This can increase the time it takes to create the index\. You should monitor this statistic while the index is being built to determine whether the write capacity of the index is underprovisioned\. You can adjust the write capacity of the index using the `UpdateTable` operation, even while the index is still being built\. The `ConsumedWriteCapacityUnits` metric for the index does not include the write throughput consumed during index creation\.  Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| OnlineIndexPercentageProgress |  The percentage of completion when a new global secondary index is being added to a table\. DynamoDB must first allocate resources for the new index, and then backfill attributes from the table into the index\. For large tables, this process might take a long time\. You should monitor this statistic to view the relative progress as DynamoDB builds the index\. Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| OnlineIndexThrottleEvents |  The number of write throttle events that occur when adding a new global secondary index to a table\. These events indicate that the index creation will take longer to complete, because incoming write activity is exceeding the provisioned write throughput of the index\. You can adjust the write capacity of the index using the `UpdateTable` operation, even while the index is still being built\. The `WriteThrottleEvents` metric for the index does not include any throttle events that occur during index creation\.  Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| PendingReplicationCount |  \(This metric is for DynamoDB global tables\.\) The number of item updates that are written to one replica table, but that have not yet been written to another replica in the global table\. Units: `Count`  Dimensions: `TableName, ReceivingRegion` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ProvisionedReadCapacityUnits | The number of provisioned read capacity units for a table or a global secondary index\.The TableName dimension returns the ProvisionedReadCapacityUnits for the table, but not for any global secondary indexes\. To view ProvisionedReadCapacityUnits for a global secondary index, you must specify both TableName and GlobalSecondaryIndex\.Units: `Count`Dimensions: `TableName, GlobalSecondaryIndexName`Valid Statistics:[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) | 
| ProvisionedWriteCapacityUnits |  The number of provisioned write capacity units for a table or a global secondary index\. The `TableName` dimension returns the `ProvisionedWriteCapacityUnits` for the table, but not for any global secondary indexes\. To view `ProvisionedWriteCapacityUnits` for a global secondary index, you must specify both `TableName` and `GlobalSecondaryIndex`\. Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ReadThrottleEvents |  Requests to DynamoDB that exceed the provisioned read capacity units for a table or a global secondary index\. A single request can result in multiple events\. For example, a `BatchGetItem` that reads 10 items is processed as 10 `GetItem` events\. For each event, `ReadThrottleEvents` is incremented by one if that event is throttled\. The `ThrottledRequests` metric for the entire `BatchGetItem` is not incremented unless *all 10* of the `GetItem` events are throttled\. The `TableName` dimension returns the `ReadThrottleEvents` for the table, but not for any global secondary indexes\. To view `ReadThrottleEvents` for a global secondary index, you must specify both `TableName` and `GlobalSecondaryIndex`\.  Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ReplicationLatency |  \(This metric is for DynamoDB global tables\.\) The elapsed time between an updated item appearing in the DynamoDB stream for one replica table, and that item appearing in another replica in the global table\.  Units: `Milliseconds`  Dimensions: `TableName, ReceivingRegion` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ReturnedBytes |  The number of bytes returned by `GetRecords` operations \(Amazon DynamoDB Streams\) during the specified time period\. Units: `Bytes` Dimensions: `Operation, StreamLabel, TableName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ReturnedItemCount |  The number of items returned by `Query` or `Scan` operations during the specified time period\. The number of items *returned* is not necessarily the same as the number of items that were evaluated\. For example, suppose that you requested a `Scan` on a table that had 100 items, but specified a `FilterExpression` that narrowed the results so that only 15 items were returned\. In this case, the response from `Scan` would contain a `ScanCount` of 100 and a `Count` of 15 returned items\. Units: `Count` Dimensions: `TableName, Operation` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ReturnedRecordsCount |  The number of stream records returned by `GetRecords` operations \(Amazon DynamoDB Streams\) during the specified time period\. Units: `Count` Dimensions: `Operation, StreamLabel, TableName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| SuccessfulRequestLatency |  The successful requests to DynamoDB or Amazon DynamoDB Streams during the specified time period\. `SuccessfulRequestLatency` can provide two different kinds of information: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) `SuccessfulRequestLatency` reflects activity only within DynamoDB or Amazon DynamoDB Streams, and does not take into account network latency or client\-side activity\.  Units: `Milliseconds`  Dimensions: `TableName, Operation` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| SystemErrors |  The requests to DynamoDB or Amazon DynamoDB Streams that generate an HTTP 500 status code during the specified time period\. An HTTP 500 usually indicates an internal service error\. Units: `Count` Dimensions: `TableName, Operation` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| TimeToLiveDeletedItemCount |  The number of items deleted by Time to Live \(TTL\) during the specified time period\. This metric helps you monitor the rate of TTL deletions on your table\.  Units: `Count` Dimensions: TableName Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| ThrottledRequests |  Requests to DynamoDB that exceed the provisioned throughput limits on a resource \(such as a table or an index\)\. `ThrottledRequests` is incremented by one if any event within a request exceeds a provisioned throughput limit\. For example, if you update an item in a table with global secondary indexes, there are multiple events—a write to the table, and a write to each index\. If one or more of these events are throttled, then `ThrottledRequests` is incremented by one\.  In a batch request \(`BatchGetItem` or `BatchWriteItem`\), `ThrottledRequests` is incremented only if *every* request in the batch is throttled\. If any individual request within the batch is throttled, one of the following metrics is incremented:   `ReadThrottleEvents` – For a throttled `GetItem` event within `BatchGetItem`\.   `WriteThrottleEvents` – For a throttled `PutItem` or `DeleteItem` event within `BatchWriteItem`\.    To gain insight into which event is throttling a request, compare `ThrottledRequests` with the `ReadThrottleEvents` and `WriteThrottleEvents` for the table and its indexes\.  A throttled request will result in an HTTP 400 status code\. All such events are reflected in the `ThrottledRequests` metric, but not in the `UserErrors` metric\.  Units: `Count` Dimensions: `TableName, Operation` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| TransactionConflict |  Rejected item\-level requests due to transactional conflicts between concurrent requests on the same items\. For more information, see [Transaction Conflict Handling in DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/transaction-apis.html#transaction-conflict-handling)\.  Units: `Count` Dimensions: `TableName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| UserErrors |  Requests to DynamoDB or Amazon DynamoDB Streams that generate an HTTP 400 status code during the specified time period\. An HTTP 400 usually indicates a client\-side error, such as an invalid combination of parameters, an attempt to update a nonexistent table, or an incorrect request signature\. All such events are reflected in the `UserErrors` metric, except for the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) `UserErrors` represents the aggregate of HTTP 400 errors for DynamoDB or Amazon DynamoDB Streams requests for the current AWS Region and the current AWS account\. Units: `Count` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
| WriteThrottleEvents |  Requests to DynamoDB that exceed the provisioned write capacity units for a table or a global secondary index\. A single request can result in multiple events\. For example, a `PutItem` request on a table with three global secondary indexes would result in four events—the table write, and each of the three index writes\. For each event, the `WriteThrottleEvents` metric is incremented by one if that event is throttled\. For single `PutItem` requests, if any of the events are throttled, `ThrottledRequests` is also incremented by one\. For `BatchWriteItem`, the `ThrottledRequests` metric for the entire `BatchWriteItem` is not incremented unless all of the individual `PutItem` or `DeleteItem` events are throttled\. The `TableName` dimension returns the `WriteThrottleEvents` for the table, but not for any global secondary indexes\. To view `WriteThrottleEvents` for a global secondary index, you must specify both `TableName` and `GlobalSecondaryIndex`\.  Units: `Count` Dimensions: `TableName, GlobalSecondaryIndexName` Valid Statistics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 

### Dimensions for DynamoDB Metrics<a name="dynamodb-metric-dimensions"></a>

The metrics for DynamoDB are qualified by the values for the account, table name, global secondary index name, or operation\. You can use the CloudWatch console to retrieve DynamoDB data along any of the dimensions in the table below\.


|  Dimension  |  Description  | 
| --- | --- | 
|  GlobalSecondaryIndexName  |  This dimension limits the data to a global secondary index on a table\. If you specify `GlobalSecondaryIndexName`, you must also specify `TableName`\.  | 
|  Operation  |  This dimension limits the data to one of the following DynamoDB operations: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) In addition, you can limit the data to the following Amazon DynamoDB Streams operation: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html)  | 
|  ReceivingRegion  |  This dimension limits the data to a particular AWS region\. It is used with metrics originating from replica tables within a DynamoDB global table\.  | 
|  StreamLabel  |  This dimension limits the data to a specific stream label\. It is used with metrics originating from Amazon DynamoDB Streams `GetRecords` operations\.  | 
|  TableName  |  This dimension limits the data to a specific table\. This value can be any table name in the current region and the current AWS account\.  | 