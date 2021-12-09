# AWS Send SNS or SQS Message task<a name="send-message"></a>

## Synopsis<a name="synopsis"></a>

Sends a message to an Amazon Simple Notification Service \(SNS\) topic or to an Amazon Simple Queue Service \(SQS\) queue\.

## Description<a name="description"></a>

This task accepts a message to be sent to an Amazon SNS topic or to an Amazon SQS queue\. If the message is to be sent to a queue, you can configure an optional delay \(in seconds\)\. If you don't specify a delay, the task assumes the default delay that is associated with the queue\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Send Message

### AWS Credentials<a name="aws-credentials"></a>

Specifies the AWS credentials to be used by the task in the build agent environment\.

You can specify credentials using a service endpoint \(of type AWS\) in the task configuration or you can leave unspecified\. If unspecified the task will attempt to obtain credentials from the following sources in order:
+ From task variables named *AWS\.AccessKeyID*, *AWS\.SecretAccessKey* and optionally *AWS\.SessionToken*\.
+ From credentials set in environment variables in the build agent process\. When using environment variables in the build agent process you may use the standard AWS environment variables: *AWS\_ACCESS\_KEY\_ID*, *AWS\_SECRET\_ACCESS\_KEY* and optionally *AWS\_SESSION\_TOKEN*\.
+ If the build agent is running on an Amazon EC2 instance, from the instance metadata associated with the EC2 instance\. For credentials to be available from EC2 instance metadata the instance must have been started with an instance profile referencing a role granting permissions to the task to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.

### AWS Region<a name="aws-region"></a>

The AWS Region code \(for example, us\-east\-1, us\-west\-2\) of the Region containing the AWS resources the task will use or create\. For more information, see [Regions and endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

If a Region is not specified in the task configuration the task will attempt to obtain the Region to be used using the standard AWS environment variable *AWS\_REGION* in the build agent process's environment\. Tasks running in build agents hosted on Amazon EC2 instances \(Windows or Linux\) will also attempt to obtain the Region using the instance metadata associated with the EC2 instance if no Region is configured on the task or set in the environment variable\.

 **Note:** The Regions listed in the picker are those known at the time this software was released\. New Regions that are not listed may still be used by entering the *region code* of the Region \(for example, *us\_west\_2*\)\.

### Message Target\*<a name="message-target"></a>

The destination for the message\. A message can be sent to a Amazon SNS \(SNS\) topic or a Amazon SQS \(SQS\) queue\.

### Message<a name="message"></a>

The message content to send\. The maximum size for both queue and topic targets is 256KB \(262144 bytes, not 262144 characters\)\.

For more information on the allowed values and content see the respective service help pages for [Publish](https://docs.aws.amazon.com/sns/latest/api/API_Publish.html) and [SendMessage](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/APIReference/API_SendMessage.html)\.

### Topic ARN\*<a name="topic-arn"></a>

The Amazon Resource Name \(ARN\) of the Amazon SNS topic to which the message will be sent\. Required when *Message Target* is set to *SNS Topic*\.

### Queue Url\*<a name="queue-url"></a>

The URL of the Amazon SQS queue to which the message will be sent\. Required when *Message Target* is set to *SQS Queue*\.

### Delay \(seconds\)<a name="delay-seconds"></a>

Available for Amazon SQS queues only\.

The length of time, in seconds, for which to delay a specific message\. Valid values: 0 to 900\. Maximum: 15 minutes\. Messages with a positive DelaySeconds value become available for processing after the delay period is finished\. If you don't specify a value, the default value for the queue applies\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ sns:GetTopicAttributes
+ sns:Publish
+ sqs:GetQueueAttributes
+ sqs:SendMessage