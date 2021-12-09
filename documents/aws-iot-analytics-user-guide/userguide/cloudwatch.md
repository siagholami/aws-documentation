# Setting Up CloudWatch Logs<a name="cloudwatch"></a>

AWS IoT Analytics supports logging with Amazon CloudWatch\. You can enable and configure Amazon CloudWatch logging for AWS IoT Analytics using the `PutLoggingOptions` command\. This section describes that command and the permissions you must set using AWS Identity and Access Management \(IAM\) and Amazon CloudWatch\.

For more information about CloudWatch Logs see the [Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/WhatIsCloudWatchLogs.html)\. For more information about AWS IAM, see the [AWS Identity and Access Management User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/index.html)\.

**Note**  
Before you enable AWS IoT Analytics logging, make sure you understand the CloudWatch Logs access permissions\. Users with access to CloudWatch Logs can see your debugging information\. See [Authentication and Access Control for Amazon CloudWatch Logs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/auth-and-access-control-cw.html)\.

## Create a Logging Role<a name="aws-iot-analytics-cloudwatch-logging-role"></a>

First, you must create an AWS IAM role with permissions to perform the logging\. Use the [AWS IAM console](https://console.aws.amazon.com/iam/home) or the AWS IAM commands:
+  [CreateRole](https://docs.aws.amazon.com/cli/latest/reference/iam/create-role.html) 

   `aws iam create-role ...` 
+  [PutRolePolicy](https://docs.aws.amazon.com/cli/latest/reference/iam/put-role-policy.html) 

   `aws iam put-role-policy ...` 

You use the ARN of this role later when you call the AWS IoT Analytics `PutLoggingOptions` command\. Here are the trust policy \(used in `CreateRole`\) and the role policy \(used in `PutRolePolicy`\) you should attach to this AWS IAM role\.

 `trust policy`:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": [
                "Service": "iotanalytics.amazonaws.com"
            ],
            "Action": "sts:AssumeRole"
        }
    ]
}
```

 `role policy`:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "logs:CreateLogGroup",
                "logs:CreateLogStream"
            ],
            "Resource": [
                "arn:aws:logs:*:*:*"
            ]
        }
    ]
}
```

In addition, you must give AWS IoT Analytics permission to put log events to Amazon CloudWatch using the Amazon CloudWatch command:
+  [PutResourcePolicy](https://docs.aws.amazon.com/cli/latest/reference/logs/put-resource-policy.html) 

   `aws logs put-resource-policy ...` 

Use the following resource policy:

 `resource policy`:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "Service": "iotanalytics.amazonaws.com"
            },
            "Action": "logs:PutLogEvents",
            "Resource": "*"
        }
    ]
}
```

## Configure and Enable Logging<a name="aws-iot-analytics-cloudwatch-enable-logging"></a>

Use the `PutLoggingOptions` command to configure and enable Amazon CloudWatch logging for AWS IoT Analytics\. The `roleArn` in the `loggingOptions` field should be the ARN of the role you created in the previous section\. You can also use the `DescribeLoggingOptions` command to check your logging options settings\.

### PutLoggingOptions<a name="putloggingoptions"></a>

Sets or updates the AWS IoT Analytics logging options\.

Note that if you update the value of any `loggingOptions` field, it takes up to one minute for the change to take effect\. Also, if you change the policy attached to the role you specified in the `roleArn` field \(for example, to correct an invalid policy\) it takes up to 5 minutes for that change to take effect\.

 *CLI Synopsis*:

```
aws iotanalytics  put-logging-options
 --logging-options <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "loggingOptions": {
    "roleArn": "string",
    "level": "string",
    "enabled": "boolean"
  }
}
```

 *fields*:
+ loggingOptions

   *type*: LoggingOptions

  The new values of the AWS IoT Analytics logging options\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that grants permission to AWS IoT Analytics to perform logging\.
+ level

   *type*: string

  The logging level\. Currently, only "ERROR" is supported\. enum: ERROR
+ enabled

   *type*: boolean

  If true, logging is enabled for AWS IoT Analytics\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

### DescribeLoggingOptions<a name="describeloggingoptions"></a>

Retrieves the current settings of the AWS IoT Analytics logging options\.

 *CLI Synopsis*:

```
aws iotanalytics  describe-logging-options
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
}
```

 *fields*:

Output:

```
{
  "loggingOptions": {
    "roleArn": "string",
    "level": "string",
    "enabled": "boolean"
  }
}
```

 *fields*:
+ loggingOptions

   *type*: LoggingOptions

  The current settings of the AWS IoT Analytics logging options\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that grants permission to AWS IoT Analytics to perform logging\.
+ level

   *type*: string

  The logging level\. Currently, only "ERROR" is supported\. enum: ERROR
+ enabled

   *type*: boolean

  If true, logging is enabled for AWS IoT Analytics\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## Namespace, Metrics and Dimensions<a name="aws-iot-analytics-cloudwatch-metrics"></a>

AWS IoT Analytics puts the following metrics into the Amazon CloudWatch repository:


****  

| Namespace | 
| --- | 
|  AWS/IoTAnalytics  | 
| 


****  

| Metric | Description | 
| --- | --- | 
|  ActionExecution  |  The number of actions executed\.  | 
| 
|  ActivityExecutionError  |  The number of errors generated while executing the pipeline activity\.  | 
| 
|  IncomingMessages  |  The number of messages coming into the channel\.  | 
| 


****  

| Dimension | Description | 
| --- | --- | 
|  ActionType  |  The type of action that is being monitored\.  | 
| 
|  ChannelName  |  The name of the channel that is being monitored\.  | 
| 
|  DatasetName  |  The name of the data set that is being monitored\.  | 
| 
|  DatastoreName  |  The name of the data store that is being monitored\.  | 
| 
|  PipelineActivityName  |  The name of the pipeline activity that is being monitored\.  | 
| 
|  PipelineActivityType  |  The type of the pipeline activity that is being monitored\.  | 
| 
|  PipelineName  |  The name of the pipeline that is being monitored\.  | 
| 