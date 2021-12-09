# Application Auto Scaling Events and EventBridge<a name="monitoring-eventbridge"></a>

Application Auto Scaling integrates with Amazon EventBridge to notify you of certain events that affect scaling\. Events from AWS services are delivered to EventBridge in near real time\. You can write simple rules to indicate which events are of interest to you, and what automated actions to take when an event matches a rule\. For example, you could be notified when a resource has scaled to its maximum capacity\. The actions that can be automatically triggered include the following:
+ Invoking an AWS Lambda function
+ Invoking an Amazon EC2 Run Command
+ Relaying the event to Amazon Kinesis Data Streams
+ Activating an AWS Step Functions state machine
+ Notifying an Amazon SNS topic or an AWS SMS queue

For more information, see [Getting Started with Amazon EventBridge](https://docs.aws.amazon.com/eventbridge/latest/userguide/eventbridge-getting-set-up.html) in the *Amazon EventBridge User Guide*\. 

The following is the format of Application Auto Scaling events with monitoring support in Amazon EventBridge\.

**Event for State Change: Scaled to Max**  
The following event is sent when you reach the maximum capacity limit that you specified in the scaling configuration for that resource\. 

```
{
  "version": "0",
  "id": "7bf73129-1428-4cd3-a780-95db273d1602",
  "detail-type": "Application Auto Scaling Scaling Activity State Change",
  "source": "aws.application-autoscaling",
  "account": "123456789012",
  "time": "2019-06-12T10:23:40Z",
  "region": "us-west-2",
  "resources": [],
  "detail": {
    "startTime": "2019-06-12T10:20:43Z",
    "endTime": "2019-06-12T10:23:40Z",
    "newDesiredCapacity": 8,
    "oldDesiredCapacity": 5,
    "minCapacity": 2,
    "maxCapacity": 8,
    "resourceId": "table/my-table",
    "scalableDimension": "dynamodb:table:WriteCapacityUnits",
    "serviceNamespace": "dynamodb",
    "statusCode": "Successful",
    "scaledToMax": true,
    "direction": "scale-out",
}
```

**Sample Event Pattern for Scaled to Max Event**  
Rules use event patterns to select events and route them to targets\. The following is a sample Application Auto Scaling event pattern\.

```
{
  "source": [
    "aws.application-autoscaling"
  ],
  "detail-type": [
    "Application Auto Scaling Scaling Activity State Change"
  ],
  "detail": {
    "scaledToMax": [
      true 
    ]
  } 
}
```