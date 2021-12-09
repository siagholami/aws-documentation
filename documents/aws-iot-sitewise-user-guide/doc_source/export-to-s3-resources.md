# Resources created from the template<a name="export-to-s3-resources"></a>

When you create a stack from the template, AWS CloudFormation creates the following resources\. Most resources' names include a prefix that you can customize when you create the stack\.

**Resource name parameters**
+ `BucketName` – The name of the S3 bucket created from this template that receives asset data\.
+ `GlobalResourcePrefix` – A prefix for names of global resources created from this template\. Defaults to `sitewise-export-to-s3`\.
+ `LocalResourcePrefix` – A prefix for names of resources created from this template in the current Region\. Defaults to `sitewise_export_to_s3`\.


**Resources created by the AWS CloudFormation template**  

| Resource | Description | Name | 
| --- | --- | --- | 
| [S3](https://docs.aws.amazon.com/AmazonS3/latest/dev/) bucket for processed data | This bucket contains two folders\. One folder receives the flattened, formatted data from the Kinesis Data Firehose delivery stream, and the other folder receives asset metadata\. | $\{BucketName\} | 
| [AWS Glue](https://docs.aws.amazon.com/glue/latest/dg/) database | This database contains the AWS Glue table that this stack creates\. | $\{LocalResourcePrefix\}\_firehose\_glue\_database | 
| [AWS Glue](https://docs.aws.amazon.com/glue/latest/dg/) table | The Kinesis Data Firehose delivery stream uses this table to format data to Parquet format\. | $\{LocalResourcePrefix\}\_firehose\_glue\_table | 
| [AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/) function that transforms data | This function flattens the array of values in property value notification messages sent from AWS IoT SiteWise\. | $\{LocalResourcePrefix\}\_lambda\_transform\_function | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) role for the transform Lambda function | This role allows Lambda to store execution logs for the transform function\. | $\{GlobalResourcePrefix\}\-lambda\-transform\-role | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) policy for the transform Lambda function role | This policy allows Lambda to store execution logs for the transform function\. | $\{GlobalResourcePrefix\}\-lambda\-transform\-policy | 
| [CloudWatch Logs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/) log group for the transform function | This log group contains logs for the transform function\. | /aws/lambda/$\{LocalResourcePrefix\}\_lambda\_transform\_function | 
| [Lambda](https://docs.aws.amazon.com/lambda/latest/dg/) function that collects asset metadata | This function retrieves details about assets in AWS IoT SiteWise and stores the details in an Amazon S3 bucket that this stack creates\. | $\{LocalResourcePrefix\}\_lambda\_metadata\_function | 
| [Lambda](https://docs.aws.amazon.com/lambda/latest/dg/) layer for the metadata function | This layer provides an AWS SDK that contains AWS IoT SiteWise operations that the metadata function uses\. | $\{LocalResourcePrefix\}\_lambda\_metadata\_layer | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) role for the metadata Lambda function | This role allows Lambda to retrieve details about assets in AWS IoT SiteWise\. | $\{GlobalResourcePrefix\}\-lambda\-metadata\-role | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) policy for the metadata Lambda function role | This policy allows Lambda to retrieve details about assets in AWS IoT SiteWise\. | $\{GlobalResourcePrefix\}\-lambda\-metadata\-policy | 
| [EventBridge](https://docs.aws.amazon.com/eventbridge/latest/userguide/) scheduled event for the metadata Lambda function | This scheduled event runs the metadata Lambda every 6 hours to update the asset metadata bucket\. | $\{LocalResourcePrefix\}\-metadata\-event | 
| [CloudWatch Logs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/) log group for the metadata function | This log group contains logs for the metadata function\. | /aws/lambda/$\{LocalResourcePrefix\}\_lambda\_metadata\_function | 
| [AWS IoT](https://docs.aws.amazon.com/iot/latest/developerguide/) rule | This rule queries property value notification messages and sends asset data to an Amazon Kinesis Data Firehose delivery stream\. | $\{LocalResourcePrefix\}\_iot\_topic\_rule | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) role for the AWS IoT rule | This role allows AWS IoT to send data to the Kinesis Data Firehose delivery stream\. | $\{GlobalResourcePrefix\}\-core\-firehose\-role | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) policy for the AWS IoT rule role | This policy allows AWS IoT to send data to the Kinesis Data Firehose delivery stream\. | $\{GlobalResourcePrefix\}\-core\-firehose\-policy | 
| [Kinesis Data Firehose](https://docs.aws.amazon.com/firehose/latest/dev/) delivery stream | This delivery stream consumes data from the AWS IoT rule, flattens the data with a Lambda function, and delivers the data to Amazon S3\. | $\{LocalResourcePrefix\}\_firehose\_delivery\_stream | 
| [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/) role for the delivery stream | This role allows Kinesis Data Firehose to perform operations on the S3 bucket, AWS Glue table, Lambda functions, and CloudWatch Logs log group\. | $\{GlobalResourcePrefix\}\-firehose\-delivery\-role | 
| [CloudWatch Logs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/) log group for the delivery stream | This log group contains a log stream, S3 Delivery, that receives logs about the Kinesis Data Firehose delivery stream\. | /aws/kinesisfirehose/$\{LocalResourcePrefix\}\_firehose\_delivery\_stream | 