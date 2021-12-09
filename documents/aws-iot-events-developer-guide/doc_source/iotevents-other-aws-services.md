# Working with other AWS services<a name="iotevents-other-aws-services"></a>

<a name="work-with-aws-services-intro"></a>AWS IoT Events supports the following actions that let you work with AWS services: <a name="work-with-aws-services"></a>
+ [`iotTopicPublish`](#iotevents-iotcore) to publish a message on an MQTT topic\.
+ [`iotEvents`](#iotevents-iteinput) to send data to AWS IoT Events as an input value\.
+ [`iotSiteWise`](#iotevents-iotsitewise) to send data to an asset property in AWS IoT SiteWise\.
+ [`dynamoDB`](#iotevents-dynamodb) to send data to an Amazon DynamoDB table\.
+ [`dynamoDBv2`](#iotevents-dynamodbv2) to send data to an Amazon DynamoDB table\.
+ [`firehose`](#iotevents-firehose) to send data to an Amazon Kinesis Data Firehose stream\.
+ [`lambda`](#iotevents-lambda) to invoke an AWS Lambda function\.
+ [`sns`](#iotevents-sns) to send data as a push notification\.
+ [`sqs`](#iotevents-sqs) to send data to an Amazon SQS queue\.

**Important**  
You must choose the same AWS Region for both AWS IoT Events and the AWS services to work with\. For the list of supported Regions, see [AWS IoT Events endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-events.html) in the *Amazon Web Services General Reference*\.
You must use the same AWS Region when you create other AWS resources for the AWS IoT Events actions\. If you switch AWS Regions, you might have issues accessing the AWS resources\.

By default, AWS IoT Events generates a standard payload in JSON for any action\. This action payload contains all attribute\-value pairs that have the information about the detector model instance and the event that triggered the action\. To configure the action payload, you can use a content expression\. For more information, see [Using expressions](iotevents-expressions.md) and the [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) data type in the *AWS IoT Events API Reference*\.

## AWS IoT Core<a name="iotevents-iotcore"></a>

------
#### [ IoT topic publish action ]

The `iotTopicPublish` action lets you publish an MQTT message through the AWS IoT message broker\. For the list of supported Regions, see [AWS IoT Core endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-core.html) in the *Amazon Web Services General Reference*\.

The AWS IoT message broker connects AWS IoT clients by sending messages from publishing clients to subscribing clients\. For more information, see [Message broker for AWS IoT](https://docs.aws.amazon.com/iot/latest/developerguide/iot-message-broker.html) in the *AWS IoT Developer Guide*\.

------
#### [ More information \(2\) ]

When you publish an MQTT message, you must specify the following parameters\.

**`mqttTopic`**  
The MQTT topic that receives the message\.  
You can define an MQTT topic name dynamically at runtime using variables or input values created in the detector model\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `iot:Publish` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [IotTopicPublishAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_IotTopicPublishAction.html) in the *AWS IoT Events API Reference*\.

------

## AWS IoT Events<a name="iotevents-iteinput"></a>

------
#### [ IoT Events action ]

The `iotEvents` action lets you send data to AWS IoT Events as input\. For the list of supported Regions, see [AWS IoT Events endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-events.html) in the *Amazon Web Services General Reference*\.

AWS IoT Events lets you to monitor your equipment or device fleets for failures or changes in operation, and to trigger actions when such events occur\. For more information, see [What is AWS IoT Events?](https://docs.aws.amazon.com/iotevents/latest/developerguide/what-is-iotevents.html) in the *AWS IoT Events Developer Guide*\.

------
#### [ More information \(2\) ]

When you send data to AWS IoT Events, you must specify the following parameters\.

**`inputName`**  
The name of the AWS IoT Events input that receives the data\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `iotevents:BatchPutMessage` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [IotEventsAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_IotEventsAction.html) in the *AWS IoT Events API Reference*\.

------

## AWS IoT SiteWise<a name="iotevents-iotsitewise"></a>

------
#### [ IoT SiteWise action ]

The `iotSiteWise` action lets you send data to an asset property in AWS IoT SiteWise\. For the list of supported Regions, see [AWS IoT SiteWise endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-sitewise.html) in the *Amazon Web Services General Reference*\.

AWS IoT SiteWise is a managed service that lets you collect, organize, and analyze data from industrial equipment at scale\. For more information, see [What is AWS IoT SiteWise?](https://docs.aws.amazon.com/iot-sitewise/latest/userguide/what-is-sitewise.html) in the *AWS IoT SiteWise User Guide*\.

------
#### [ More information \(11\) ]

When you send data to an asset property in AWS IoT SiteWise, you must specify the following parameters\.

**Important**  
To receive the data, you must use an existing asset property in AWS IoT SiteWise\.  
If you use the AWS IoT Events console, you must specify `propertyAlias` to identify the target asset property\.
If you use the AWS CLI, you must specify either `propertyAlias` or both `assetId` and `propertyId` to identify the target asset property\.
For more information, see [Mapping industrial data streams to asset properties](https://docs.aws.amazon.com/iot-sitewise/latest/userguide/connect-data-streams.html) in the *AWS IoT SiteWise User Guide*\.

**`propertyAlias`**  
\(Optional\) The alias of the asset property\. You can also specify an expression\.

**`assetId`**  
\(Optional\) The ID of the asset that has the specified property\. You can also specify an expression\.

**`propertyId`**  
\(Optional\) The ID of the asset property\. You can also specify an expression\.

**`entryId`**  
\(Optional\) A unique identifier for this entry\. You can use the entry ID to track which data entry causes an error in case of failure\. The default is a new unique identifier\. You can also specify an expression\.

**`propertyValue`**  
A structure that contains details about the property value\.     
**`quality`**  
\(Optional\) The quality of the asset property value\. The value must be `GOOD`, `BAD`, or `UNCERTAIN`\. You can also specify an expression\.  
**`timestamp`**  
\(Optional\) A structure that contains timestamp information\. If you don't specify this value, the default is the event time\.    
**`timeInSeconds`**  
The timestamp, in seconds, in the Unix epoch format\. The valid range is between 1\-31556889864403199\. You can also specify an expression\.  
**`offsetInNanos`**  
\(Optional\) The nanosecond offset converted from `timeInSeconds`\. The valid range is between 0\-999999999\. You can also specify an expression\.  
**`value`**  
A structure that contains an asset property value\.   
You must specify one of the following value types, depending on the `dataType` of the specified asset property\. For more information, see [AssetProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_AssetProperty.html) in the *AWS IoT SiteWise API Reference*\.  
**`booleanValue`**  
\(Optional\) The asset property value is a Boolean value that must be `TRUE` or `FALSE`\. You can also specify an expression\. If you use an expression, the evaluated result should be a Boolean value\.  
**`doubleValue`**  
\(Optional\) The asset property value is a double\. You can also specify an expression\. If you use an expression, the evaluated result should be a double\.  
**`integerValue`**  
\(Optional\) The asset property value is an integer\. You can also specify an expression\. If you use an expression, the evaluated result should be an integer\.  
**`stringValue`**  
\(Optional\) The asset property value is a string\. You can also specify an expression\. If you use an expression, the evaluated result should be a string\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `iotsitewise:BatchPutAssetPropertyValue` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [IotSiteWiseAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_IotSiteWiseAction.html) in the *AWS IoT Events API Reference*\.

------

## Amazon DynamoDB<a name="iotevents-dynamodb"></a>

------
#### [ DynamoDB action ]

The `dynamoDB` action lets you send data to a DynamoDB table\. One column of the DynamoDB table receives all attribute\-value pairs in the action payload that you specify\. For the list of supported Regions, see [Amazon DynamoDB endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/ddb.html) in the *Amazon Web Services General Reference*\.

Amazon DynamoDB is a fully managed NoSQL database service that provides fast and predictable performance with seamless scalability\. For more information, see [What is DynamoDB?](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html) in the *Amazon DynamoDB Developer Guide*\.

------
#### [ More information \(10\) ]

When you send data to one column of a DynamoDB table, you must specify the following parameters\.

**`tableName`**  
The name of the DynamoDB table that receives the data\. The `tableName` value must match the table name of the DynamoDB table\. You can also specify an expression\.

**`hashKeyField`**  
The name of the hash key \(also called partition key\)\. The `hashKeyField` value must match the partition key of the DynamoDB table\. You can also specify an expression\.

**`hashKeyType`**  
\(Optional\) The data type of the hash key\. The value of the hash key type must be `STRING` or `NUMBER`\. The default is `STRING`\. You can also specify an expression\.

**`hashKeyValue`**  
The value of the hash key\. The `hashKeyValue` uses substitution templates\. These templates provide data at runtime\. You can also specify an expression\.

**`rangeKeyField`**  
\(Optional\) The name of the range key \(also called the sort key\)\. The `rangeKeyField` value must match the sort key of the DynamoDB table\. You can also specify an expression\.

**`rangeKeyType`**  
\(Optional\) The data type of the range key\. The value of the hash key type must be `STRING` or `NUMBER`\. The default is `STRING`\. You can also specify an expression\.

**`rangeKeyValue`**  
\(Optional\) The value of the range key\. The `rangeKeyValue` uses substitution templates\. These templates provide data at runtime\. You can also specify an expression\.

**operation**  
\(Optional\) The type of operation to perform\. You can also specify an expression\. The operation value must be one of the following values:  
+ `INSERT` \- Insert data as a new item into the DynamoDB table\. This is the default value\. 
+ `UPDATE` \- Update an existing item of the DynamoDB table with new data\.
+ `DELETE` \- Delete an existing item from the DynamoDB table\. 

**`payloadField`**  
\(Optional\) The name of the DynamoDB column that receives the action payload\. The default name is `payload`\. You can also specify an expression\. 

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.  
If the specified payload type is a string, `DynamoDBAction` sends non\-JSON data to the DynamoDB table as binary data\. The DynamoDB console displays the data as Base64\-encoded text\. The `payloadField` value is `payload-field_raw`\. You can also specify an expression\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `dynamodb:PutItem` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [DynamoDBAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_DynamoDBAction.html) in the *AWS IoT Events API Reference*\.

------

## Amazon DynamoDB\(v2\)<a name="iotevents-dynamodbv2"></a>

------
#### [ DynamoDBv2 action ]

The `dynamoDBv2` action lets you write data to a DynamoDB table\. A separate column of the DynamoDB table receives one attribute\-value pair in the action payload that you specify\. For the list of supported Regions, see [Amazon DynamoDB endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/ddb.html) in the *Amazon Web Services General Reference*\.

Amazon DynamoDB is a fully managed NoSQL database service that provides fast and predictable performance with seamless scalability\. For more information, see [What is DynamoDB?](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html) in the *Amazon DynamoDB Developer Guide*\.

------
#### [ More information \(2\) ]

When you send data to multiple columns of a DynamoDB table, you must specify the following parameters\.

**`tableName`**  
The name of the DynamoDB table that receives the data\. You can also specify an expression\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.  
The payload type must be JSON\. You can also specify an expression\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `dynamodb:PutItem` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [DynamoDBv2Action](https://docs.aws.amazon.com/iotevents/latest/apireference/API_DynamoDBv2Action.html) in the *AWS IoT Events API Reference*\.

------

## Amazon Kinesis Data Firehose<a name="iotevents-firehose"></a>

------
#### [ Firehose action ]

The `firehose` action lets you send data to an Kinesis Data Firehose delivery stream\. For the list of supported Regions, see [Amazon Kinesis Data Firehose endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/fh.html) in the *Amazon Web Services General Reference*\.

Amazon Kinesis Data Firehose is a fully managed service for delivering real\-time streaming data to destinations such as Amazon Simple Storage Service \(Amazon Simple Storage Service\), Amazon Redshift, Amazon Elasticsearch Service \(Amazon ES\), and Splunk\. For more information, see [What is Amazon Kinesis Data Firehose?](https://docs.aws.amazon.com/firehose/latest/dev/what-is-this-service.html) in the *Amazon Kinesis Data Firehose Developer Guide*\.

------
#### [ More information \(3\) ]

When you send data to an Kinesis Data Firehose delivery stream, you must specify the following parameters\.

**`deliveryStreamName`**  
The name of the Kinesis Data Firehose delivery stream that receives the data\.

**`separator`**  
\(Optional\) You can use a character separator to separate continuous data sent to the Kinesis Data Firehose delivery stream\. The separator value must be `'\n'`\(newline\), `'\t'` \(tab\), `'\r\n'` \(Windows new line\), or `','` \(comma\)\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `firehose:PutRecord` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [FirehoseAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_FirehoseAction.html) in the *AWS IoT Events API Reference*\.

------

## AWS Lambda<a name="iotevents-lambda"></a>

------
#### [ Lambda action ]

The `lambda` action lets you call a Lambda function\. For the list of supported Regions, see [AWS Lambda endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/lambda-service.html) in the *Amazon Web Services General Reference*\.

AWS Lambda is a compute service that lets you run code without provisioning or managing servers\. For more information, see [What is AWS Lambda?](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html) in the *AWS Lambda Developer Guide*\.

------
#### [ More information \(2\) ]

When you call a Lambda function, you must specify the following parameters\.

**`functionArn`**  
The ARN of the Lambda function to call\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `lambda:InvokeFunction` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [LambdaAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_LambdaAction.html) in the *AWS IoT Events API Reference*\.

------

## Amazon Simple Notification Service<a name="iotevents-sns"></a>

------
#### [ SNS action ]

The `sns` topic publish action lets you publish an Amazon SNS message\. For the list of supported Regions, see [Amazon Simple Notification Service endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/sns.html) in the *Amazon Web Services General Reference*\.

Amazon Simple Notification Service \(Amazon Simple Notification Service\) is a web service that coordinates and manages the delivery or sending of messages to subscribing endpoints or clients\. For more information, see [What is Amazon SNS?](https://docs.aws.amazon.com/sns/latest/dg/welcome.html) in the *Amazon Simple Notification Service Developer Guide*\.

------
#### [ More information \(2\) ]

When you publish an Amazon SNS message, you must specify the following parameters\.

**`targetArn`**  
The ARN of the Amazon SNS target that receives the message\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `sns:Publish` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [SNSTopicPublishAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SNSTopicPublishAction.html) in the *AWS IoT Events API Reference*\.

------

## Amazon Simple Queue Service<a name="iotevents-sqs"></a>

------
#### [ SQS action ]

The `sns` action lets you send data to an Amazon SQS queue\. For the list of supported Regions, see [Amazon Simple Queue Service endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/sqs-service.html) in the *Amazon Web Services General Reference*\.

Amazon Simple Queue Service \(Amazon SQS\) offers a secure, durable, and available hosted queue that lets you integrate and decouple distributed software systems and components\. For more information, see [What is Amazon Simple Queue Service>](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html) in the *Amazon Simple Queue Service Developer Guide*\.

------
#### [ More information \(3\) ]

When you send data to an Amazon SQS queue, you must specify the following parameters\.

**`queueUrl`**  
The URL of the Amazon SQS queue that receives the data\.

**`useBase64`**  
\(Optional\) AWS IoT Events encodes the data into Base64 text, if you specify `TRUE`\. The default is `FALSE`\.

**`payload`**  
\(Optional\) The default payload contains all attribute\-value pairs that have the information about the detector model instance and the event triggered the action\. You can also customize the payload\. For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html) in the *AWS IoT Events API Reference*\.

**Note**  
Make sure that the policy attached to your AWS IoT Events service role grants the `sqs:SendMessage` permission\. For more information, see [Identity and access management for AWS IoT Events](security-iam.md)\.

For more information, see [SNSTopicPublishAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SNSTopicPublishAction.html) in the *AWS IoT Events API Reference*\.

------

You can also use Amazon SNS and the AWS IoT Core rules engine to trigger an AWS Lambda function\. This makes it possible to take actions using other services, such as Amazon Connect, or even a company enterprise resource planning \(ERP\) application\.

**Note**  
To collect and process large streams of data records in real time, you can use other AWS services, such as [Amazon Kinesis](https://docs.aws.amazon.com/kinesis/index.html)\. From there, you can complete an initial analysis and then send the results to AWS IoT Events as an input to a detector\. 