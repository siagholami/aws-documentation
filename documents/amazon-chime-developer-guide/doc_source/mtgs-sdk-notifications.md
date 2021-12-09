# Amazon Chime SDK event notifications<a name="mtgs-sdk-notifications"></a>

The Amazon Chime SDK supports sending meeting event notifications to Amazon EventBridge, Amazon Simple Queue Service \(Amazon SQS\), and Amazon Simple Notification Service \(Amazon SNS\)\.

## Sending notifications to EventBridge<a name="chime-sdk-eventbridge-notifications"></a>

We recommend sending Amazon Chime SDK event notifications to EventBridge\. For detailed information about using the Amazon Chime SDK with EventBridge, see [Automating the Amazon Chime SDK with EventBridge](https://docs.aws.amazon.com/chime/latest/ag/automating-chime-with-cloudwatch-events.html#events-sdk) in the *Amazon Chime Administrator Guide*\. For information about EventBridge, see the [Amazon EventBridge User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/)\.

## Sending notifications to Amazon SQS and Amazon SNS<a name="chime-sdk-sqs-sns-notifications"></a>

You can use the [CreateMeeting](https://docs.aws.amazon.com/chime/latest/APIReference/API_CreateMeeting.html) API in the *Amazon Chime API Reference* to send Amazon Chime SDK meeting event notifications to one Amazon SQS queue and one Amazon SNS topic per meeting\. This can help reduce notification latency\. For more information about Amazon SQS, see the [Amazon Simple Queue Service Developer Guide](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/)\. For more information about Amazon SNS, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.

The notifications sent to Amazon SQS and Amazon SNS contain the same information as the notifications that Amazon Chime sends to EventBridge\. The Amazon Chime SDK supports sending meeting event notifications to queues and topics in the US East \(N\. Virginia\) \(**us\-east\-1**\) AWS Region\. Event notifications might be delivered out of order of occurrence\.

## Granting the Amazon Chime SDK access to Amazon SQS and Amazon SNS<a name="chime-sdk-sqs-sns-permissions"></a>

If you have an Amazon SQS queue or Amazon SNS topic configured in the **us\-east\-1** Region and you want to send Amazon Chime SDK events to it, you must grant the Amazon Chime SDK permission to publish messages to the Amazon Resource Name \(ARN\) of the queue or topic\. To do this, attach an AWS Identity and Access Management \(IAM\) policy to the queue or topic that grants the appropriate permissions to the Amazon Chime SDK\. For more information, see [Identity and access management in Amazon SQS](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-authentication-and-access-control.html) in the *Amazon Simple Queue Service Developer Guide* and [Example cases for Amazon SNS access control ](https://docs.aws.amazon.com/sns/latest/dg/sns-access-policy-use-cases.html) in the *Amazon Simple Notification Service Developer Guide*\.

**Example : Allow the Amazon Chime SDK to publish events to an Amazon SQS queue**  
The following example IAM policy grants the Amazon Chime SDK permission to publish meeting event notifications to the specified Amazon SQS queue\.  

```
{
 "Version": "2008-10-17",
 "Id": "example-ID",
 "Statement": [
  {
   "Sid": "example-statement-ID",
   "Effect": "Allow",
   "Principal": {
     "Service": "chime.amazonaws.com"  
   },
   "Action": [
    "sqs:SendMessage",
    "sqs:GetQueueUrl"
   ],
   "Resource": "arn:aws:sqs:us-east-1:111122223333:queueName",
  }
 ]
}
```
If the Amazon SQS queue is enabled for server\-side encryption \(SSE\), you must take an additional step\. Attach an IAM policy to the associated AWS KMS key that grants the Amazon Chime SDK permission to the AWS KMS actions needed to encrypt data added to the queue\.  

```
{
    "Version": "2012-10-17",
    "Id": "example-ID",
    "Statement": [
        {
            "Sid": "example-statement-ID",
            "Effect": "Allow",
            "Principal": {
                "Service": "chime.amazonaws.com"
            },
            "Action": [
                "kms:GenerateDataKey",
                "kms:Decrypt"
            ],
            "Resource": "*"
        }
    ]
}
```

**Example : Allow the Amazon Chime SDK to publish events to an Amazon SNS topic**  
The following example IAM policy grants the Amazon Chime SDK permission to publish meeting event notifications to the specified Amazon SNS topic\.  

```
{
 "Version": "2008-10-17",
 "Id": "example-ID",
 "Statement": [
  {
   "Sid": "allow-chime-sdk-access-statement-id",
   "Effect": "Allow",
   "Principal": {
     "Service": "chime.amazonaws.com"  
   },
   "Action": [
    "SNS:Publish"
   ],
   "Resource": "arn:aws:sns:us-east-1:111122223333:topicName"
  }
 ]
}
```