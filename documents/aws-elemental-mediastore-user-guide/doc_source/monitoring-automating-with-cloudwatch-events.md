# CloudWatch Events<a name="monitoring-automating-with-cloudwatch-events"></a>

Amazon CloudWatch Events enables you to automate your AWS services and respond automatically to system events such as application availability issues or resource changes\. Events from AWS services are delivered to CloudWatch Events in near real time\. You can write simple rules to indicate which events are of interest to you, and what automated actions to take when an event matches a rule\.

When a file is uploaded to a container or removed from a container, two events are fired in succession in the CloudWatch service:

1. [AWS Elemental MediaStore object state change event](monitoring-cloudwatch-events-object-state-change.md)

1. [AWS Elemental MediaStore container state change event](monitoring-cloudwatch-events-container-state-change.md)

For information about subscribing to these events, see [Amazon CloudWatch](https://docs.aws.amazon.com/cloudwatch/)\.

The actions that can be automatically triggered include the following:
+ Invoking an AWS Lambda function
+ Invoking Amazon EC2 Run Command
+ Relaying the event to Amazon Kinesis Data Streams
+ Activating an AWS Step Functions state machine
+ Notifying an Amazon SNS topic or an AWS SMS queue

Some examples of using CloudWatch Events with AWS Elemental MediaStore include the following:
+ Activating a Lambda function whenever a container is created
+ Notifying an Amazon SNS topic when an object is deleted

For more information, see the [Amazon CloudWatch Events User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/)\.

**Topics**
+ [AWS Elemental MediaStore object state change event](monitoring-cloudwatch-events-object-state-change.md)
+ [AWS Elemental MediaStore container state change event](monitoring-cloudwatch-events-container-state-change.md)