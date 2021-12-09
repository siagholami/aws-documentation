# Ingesting data using AWS IoT Core rules<a name="iot-rules"></a>

You can send data to AWS IoT SiteWise from AWS IoT things and other AWS services by using rules in AWS IoT Core\. Rules transform MQTT messages and perform actions to interact with AWS services\. The AWS IoT SiteWise rule action forwards messages data to the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation from the AWS IoT SiteWise API\. For more information, see [Rules](https://docs.aws.amazon.com/iot/latest/developerguide/iot-rules.html) and [AWS IoT SiteWise action](https://docs.aws.amazon.com/iot/latest/developerguide/iot-rule-actions.html#iotsitewise-rule) in the *AWS IoT Developer Guide*\.

You can follow a tutorial that walks through the steps required to set up a rule that ingests data from AWS IoT things through their device shadows\. For more information, see [Ingesting data to AWS IoT SiteWise from AWS IoT things](ingest-data-from-iot-things.md)\.

You can also send data from AWS IoT SiteWise to other AWS services\. For more information, see [Interacting with other AWS services](interact-with-other-services.md)\.

**Topics**
+ [Granting AWS IoT the required access](#grant-rule-access)
+ [Configuring the AWS IoT SiteWise rule action](#configure-rule-action)
+ [Reducing costs with basic ingest](#basic-ingest-rules)
+ [Troubleshooting the AWS IoT SiteWise rule action](#troubleshoot-rule-action)

## Granting AWS IoT the required access<a name="grant-rule-access"></a>

You use IAM roles to control the AWS resources to which each rule has access\. Before you create a rule, you must create an IAM role with a policy that allows access to the required AWS resource\. AWS IoT assumes this role when executing a rule\.

If you create the rule action in the AWS IoT console, you can choose an root asset to easily create a role that has access to a selected asset hierarchy\. For more information about how to manually define a role for a rule, see [Granting AWS IoT the required access](https://docs.aws.amazon.com/iot/latest/developerguide/iot-create-role.html) and [Pass role permissions](https://docs.aws.amazon.com/iot/latest/developerguide/pass-role.html) in the *AWS IoT Developer Guide*\.

For the AWS IoT SiteWise rule action, you must define a role that allows `iotsitewise:BatchPutAssetPropertyValue` access to the asset properties to which the rule sends data\. To improve security, you can specify an AWS IoT SiteWise asset hierarchy path in the `Condition` property\. 

The following example trust policy allows access to a specific asset and its children\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "iotsitewise:BatchPutAssetPropertyValue",
      "Resource": "*",
      "Condition": {
        "StringLike": {
          "iotsitewise:assetHierarchyPath": [
            "/root node asset ID",
            "/root node asset ID/*"
          ]
        }
      }
    }
  ]
}
```

You can remove the `Condition` from the policy to allow access to all of your assets\. The following example trust policy allows access to all of your assets in the current Region\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "iotsitewise:BatchPutAssetPropertyValue",
      "Resource": "*"
    }
  ]
}
```

## Configuring the AWS IoT SiteWise rule action<a name="configure-rule-action"></a>

The AWS IoT SiteWise rule action sends data from the MQTT message that trigged the rule to asset properties in AWS IoT SiteWise\. You can upload multiple data entries to different asset properties at the same time, so that you can send updates for all sensors of a device in one message\. You can also upload multiple data points at once for each data entry\.

**Note**  
When you send data to AWS IoT SiteWise with the rule action, your data must meet all of the requirements of the `BatchPutAssetPropertyValue` operation\. For example, your data can't have a timestamp older than 15 minutes from current Unix epoch time\. For more information, see [Ingesting data with the AWS IoT SiteWise API]()\.

For each data entry in the rule action, you identify an asset property and specify the timestamp, quality, and value of each data point for that asset property\. The rule action expects strings for all parameters\.

To identify an asset property in an entry, specify one of the following:
+ The **Asset ID** \(`assetId`\) and **Property ID** \(`propertyId`\) of the asset property that you're sending data to\. If you choose this option in the AWS IoT console, you can use a drop\-down list to choose an asset model and property from AWS IoT SiteWise in the current Region\.
+ The **Property alias** \(`propertyAlias`\), which is a data stream alias \(for example, `/company/windfarm/3/turbine/7/temperature`\)\. To use this option, you must first set your asset property's alias\. To learn how to set property aliases, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

For the timestamp in each entry, you can use the timestamp reported by your equipment or the timestamp provided by AWS IoT Core\. The timestamp has two parameters:
+ **Time in seconds** \(`timeInSeconds`\) – The Unix epoch time, in seconds, at which the sensor or equipment reported the data\.
+ **Offset in nanos** \(`offsetInNanos`\) – \(Optional\) The nanosecond offset from the time in seconds\.

**Important**  
If your timestamp is a string, has a decimal portion, or isn't in seconds, AWS IoT SiteWise rejects the request\. You must convert the timestamp to seconds and nanosecond offset\. Use features of the AWS IoT rules engine to convert the timestamp\. For more information, see the following:  
[Getting timestamps for devices that don't report accurate time](#rule-timestamp-function)
[Converting timestamps that are in string format](#rule-time-to-epoch-function)

You can use substitution templates for several parameters in the action to perform calculations, invoke functions, and pull values from the message payload\. For more information, see [Substitution templates](https://docs.aws.amazon.com/iot/latest/developerguide/iot-substitution-templates.html) in the *AWS IoT Developer Guide*\.

**Note**  
Because an expression in a substitution template is evaluated separately from the `SELECT` statement, you can't use a substitution template to reference an alias created using an `AS` clause\. You can reference only information present in the original payload, in addition to supported functions and operators\.

**Topics**
+ [Getting timestamps for devices that don't report accurate time](#rule-timestamp-function)
+ [Converting timestamps that are in string format](#rule-time-to-epoch-function)
+ [Converting nanosecond\-precision timestamp strings](#rule-convert-precise-timestamp-string)
+ [Example rule configurations](#rule-action-examples)

### Getting timestamps for devices that don't report accurate time<a name="rule-timestamp-function"></a>

If your sensor or equipment doesn't report accurate time data, you can get the current Unix epoch time from the AWS IoT rules engine with [timestamp\(\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-function-timestamp)\. This function outputs time in milliseconds, so you must convert the value to time in seconds and offset in nanoseconds\. To do so, use the following conversions:
+ For **Time in seconds** \(`timeInSeconds`\), use **$\{floor\(timestamp\(\) / 1E3\)\}** to convert the time from milliseconds to seconds\.
+ For **Offset in nanos** \(`offsetInNanos`\), use **$\{\(timestamp\(\) % 1E3\) \* 1E6\}** to calculate the nanosecond offset of the timestamp\.

### Converting timestamps that are in string format<a name="rule-time-to-epoch-function"></a>

If your sensor or equipment reports time data in string format \(for example, `2020-03-03T14:57:14.699Z`\), you can use [time\_to\_epoch\(String, String\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-sql-function-time-to-epoch)\. This function inputs the timestamp and format pattern as parameters and outputs time in milliseconds\. Then, you must convert the time to time in seconds and offset in nanoseconds\. To do so, use the following conversions:
+ For **Time in seconds** \(`timeInSeconds`\), use **$\{floor\(time\_to\_epoch\("2020\-03\-03T14:57:14\.699Z", "yyyy\-MM\-dd'T'HH:mm:ss'Z'"\) / 1E3\)\}** to convert the timestamp string to milliseconds, and then to seconds\.
+ For **Offset in nanos** \(`offsetInNanos`\), use **$\{\(time\_to\_epoch\("2020\-03\-03T14:57:14\.699Z", "yyyy\-MM\-dd'T'HH:mm:ss'Z'"\) % 1E3\) \* 1E6\}** to calculate the nanosecond offset of the timestamp string\.

**Note**  
The `time_to_epoch` function supports up to millisecond\-precision timestamp strings\. To convert strings with microsecond or nanosecond precision, you can configure an AWS Lambda function that your rule calls to convert the timestamp into numerical values\. For more information, see [Converting nanosecond\-precision timestamp strings](#rule-convert-precise-timestamp-string)\.

### Converting nanosecond\-precision timestamp strings<a name="rule-convert-precise-timestamp-string"></a>

If your device sends timestamp information in string format with nanosecond precision \(for example, `2020-03-03T14:57:14.699728491Z`\), use the following procedure to configure your rule action\. You can create an AWS Lambda function that converts the timestamp from a string into **Time in seconds** \(`timeInSeconds`\) and **Offset in nanos** \(`offsetInNanos`\)\. Then, you can use [aws\_lambda\(functionArn, inputJson\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-func-aws-lambda) in your rule action parameters to invoke that Lambda function and use the output in your rule\.

**Note**  
This section contains advanced instructions that assume that you're familiar with how to create the following resources:  
Lambda functions\. For more information, see [Create a Lambda function with the console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) or [Using Lambda with the AWS CLI](https://docs.aws.amazon.com/lambda/latest/dg/gettingstarted-awscli.html) in the *AWS Lambda Developer Guide*\.
AWS IoT rules with the AWS IoT SiteWise rule action\. For more information, see [Ingesting data using AWS IoT Core rules](#iot-rules)\.

**To create an AWS IoT SiteWise rule action that parses timestamp strings**

1. Create a Lambda function with the following properties:
   + **Function name** – Use a descriptive function name \(for example, **ConvertNanosecondTimestampFromString**\)\.
   + **Runtime** – Use a Python 3 runtime, such as **Python 3\.8** \(`python3.8`\)\.
   + **Permissions** – Create a role with basic Lambda permissions \(**AWSLambdaBasicExecutionRole**\)\.
   + **Layers** – Add the **AWSLambda\-Python38\-SciPy1x** layer for the Lambda function to use `numpy`\.
   + **Function code** – Use the following function code, which consumes a string argument named `timestamp` and outputs `timeInSeconds` and `offsetInNanos` values for that timestamp\.

     ```
     import json
     import math
     import numpy
     
     # Converts a timestamp string into timeInSeconds and offsetInNanos in Unix epoch time.
     # The input timestamp string can have up to nanosecond precision.
     def lambda_handler(event, context):
         timestamp_str = event['timestamp']
         # Parse the timestamp string as nanoseconds since Unix epoch.
         nanoseconds = numpy.datetime64(timestamp_str, 'ns').item()
         time_in_seconds = math.floor(nanoseconds / 1E9)
         # Slice to avoid precision issues.
         offset_in_nanos = int(str(nanoseconds)[-9:])
         return {
             'timeInSeconds': time_in_seconds,
             'offsetInNanos': offset_in_nanos
         }
     ```

     This Lambda function inputs timestamp strings in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format using [datetime64](https://numpy.org/doc/stable/reference/arrays.datetime.html) from NumPy\.
**Note**  
If your timestamp strings aren't in ISO 8601 format, you can implement a solution with pandas that defines the timestamp format\. For more information, see [pandas\.to\_datetime](https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.to_datetime.html)\.

1. When you configure the AWS IoT SiteWise action for your rule, use the following substitution templates for **Time in seconds** \(`timeInSeconds`\) and **Offset in nanos** \(`offsetInNanos`\)\. These substitution templates assume that your message payload contains the timestamp string in `timestamp`\. The `aws_lambda` function consumes a JSON structure for its second parameter, so you can modify the below substitution templates if needed\.
   + For **Time in seconds** \(`timeInSeconds`\), use the following substitution template\.

     ```
     ${aws_lambda('arn:aws:lambda:region:account-id:function:ConvertNanosecondTimestampFromString', {'timestamp': timestamp}).timeInSeconds}
     ```
   + For **Offset in nanos** \(`offsetInNanos`\), use the following substitution template\.

     ```
     ${aws_lambda('arn:aws:lambda:region:account-id:function:ConvertNanosecondTimestampFromString', {'timestamp': timestamp}).offsetInNanos}
     ```

   For each parameter, replace *region* and *account\-id* with your Region and AWS account ID\. If you used a different name for your Lambda function, change that as well\.

1. Grant AWS IoT permissions to invoke your function with the `lambda:InvokeFunction` permission\. For more information, see [aws\_lambda\(functionArn, inputJson\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-func-aws-lambda)\.

1. Test your rule \(for example, use the AWS IoT MQTT test client\) and verify that AWS IoT SiteWise receives the data that you send\.

   If your rule doesn't work as expected, see [Troubleshooting an AWS IoT SiteWise rule action](troubleshoot-rule.md)\.

**Note**  
This solution invokes the Lambda function twice for each timestamp string\. You can create another rule to reduce the number of Lambda function invocations if your rule handles multiple data points that have the same timestamp in each payload\.  
To do so, create a rule with a republish action that invokes the Lambda and publishes the original payload with the timestamp string converted to `timeInSeconds` and `offsetInNanos`\. Then, create a rule with an AWS IoT SiteWise rule action to consume the converted payload\. With this approach, you reduce the number of times that the rule invokes the Lambda but increase the number of AWS IoT rule actions run\. Consider the pricing of each service if you apply this solution to your use case\.

### Example rule configurations<a name="rule-action-examples"></a>

This section contains example rule configurations that you can use to create a rule with an AWS IoT SiteWise action\.

**Example rule action that uses property aliases as message topics**  
The following example creates a rule with an AWS IoT SiteWise action that uses the topic \(through [topic\(\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-function-topic)\) as the property alias to identify asset properties\. You can use this example to define one rule for ingesting double\-type data to all wind turbines in all wind farms\. This example requires that you define property aliases on all turbine assets' properties\. You would need to define a second, similar rule to ingest integer\-type data\.  

```
aws iot create-topic-rule \
  --rule-name SiteWiseWindFarmRule \
  --topic-rule-payload file://sitewise-rule-payload.json
```
The example payload in `sitewise-rule-payload.json` contains the following content\.  

```
{
  "sql": "SELECT * FROM '/company/windfarm/+/turbine/+/+' WHERE type = 'double'",
  "description": "Sends data to the wind turbine asset property with the same alias as the topic",
  "ruleDisabled": false,
  "awsIotSqlVersion": "2016-03-23",
  "actions": [
    {
      "iotSiteWise": {
        "putAssetPropertyValueEntries": [
          {
            "propertyAlias": "${topic()}",
            "propertyValues": [
              {
                "timestamp": {
                  "timeInSeconds": "${timeInSeconds}"
                },
                "value": {
                  "doubleValue": "${value}"
                }
              }
            ]
          }
        ],
        "roleArn": "arn:aws:iam::account-id:role/MySiteWiseActionRole"
      }
    }
  ]
}
```
With this rule action, you can send the following message to a wind turbine property alias \(for example, `/company/windfarm/3/turbine/7/temperature`\) as a topic to ingest data\.  

```
{
  "type": "double",
  "value": "38.3",
  "timeInSeconds": "1581368533"
}
```

**Example rule action that uses timestamp\(\) to determine time**  
The following example creates a rule with an AWS IoT SiteWise action that identifies an asset property by IDs and uses [timestamp\(\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-function-timestamp) to determine the current time\.  

```
aws iot create-topic-rule \
  --rule-name SiteWiseAssetPropertyRule \
  --topic-rule-payload file://sitewise-rule-payload.json
```
The example payload in `sitewise-rule-payload.json` contains the following content\.  

```
{
  "sql": "SELECT * FROM 'my/asset/property/topic'",
  "description": "Sends device data to an asset property",
  "ruleDisabled": false,
  "awsIotSqlVersion": "2016-03-23",
  "actions": [
    {
      "iotSiteWise": {
        "putAssetPropertyValueEntries": [
          {
            "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
            "propertyId": "a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
            "propertyValues": [
              {
                "timestamp": {
                  "timeInSeconds": "${floor(timestamp() / 1E3)}",
                  "offsetInNanos": "${(timestamp() % 1E3) * 1E6}"
                },
                "value": {
                  "doubleValue": "${value}"
                }
              }
            ]
          }
        ],
        "roleArn": "arn:aws:iam::account-id:role/MySiteWiseActionRole"
      }
    }
  ]
}
```
With this rule action, you can send the following message to the `my/asset/property/topic` to ingest data\.  

```
{
  "type": "double",
  "value": "38.3"
}
```

## Reducing costs with basic ingest<a name="basic-ingest-rules"></a>

AWS IoT Core provides a feature called Basic Ingest that you can use to send data through AWS IoT Core without incurring [AWS IoT messaging costs](http://aws.amazon.com/iot-core/pricing/)\. Basic Ingest optimizes data flow for high volume data ingestion workloads by removing the publish/subscribe message broker from the ingestion path\. You can use Basic Ingest if you know which rules your messages should be routed to\.

To use Basic Ingest, you send messages directly to a specific rule using a special topic, `$aws/rules/rule-name`\. For example, to send a message to a rule named `SiteWiseWindFarmRule`, you send a message to the topic `$aws/rules/SiteWiseWindFarmRule`\.

If your rule action uses substitution templates that contain [topic\(Decimal\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-function-topic), you can pass the original topic at the end of the Basic Ingest special topic, such as `$aws/rules/rule-name/original-topic`\. For example, to use Basic Ingest with the wind farm property alias example from the previous section, you can send messages to the following topic\.

```
$aws/rules/SiteWiseWindFarmRule//company/windfarm/3/turbine/7/temperature
```

**Note**  
The above example includes a second slash \(`//`\) because AWS IoT removes the Basic Ingest prefix \(`$aws/rules/rule-name/`\) from the topic that's visible to the rule action\. In this example, the rule receives the topic `/company/windfarm/3/turbine/7/temperature`\.

For more information, see [Reducing messaging costs with basic ingest](https://docs.aws.amazon.com/iot/latest/developerguide/iot-basic-ingest.html) in the *AWS IoT Developer Guide*\.

## Troubleshooting the AWS IoT SiteWise rule action<a name="troubleshoot-rule-action"></a>

To troubleshoot your AWS IoT SiteWise rule action in AWS IoT Core, you can configure CloudWatch Logs or you can configure a republish error action for your rule\. For more information, see [Troubleshooting an AWS IoT SiteWise rule action](troubleshoot-rule.md)\.