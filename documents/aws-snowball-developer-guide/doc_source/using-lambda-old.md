--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using AWS Lambda with an AWS Snowball Edge<a name="using-lambda-old"></a>

Following, you can find an overview of AWS Lambda powered by AWS Greengrass as used in an AWS Snowball Edge device\. With this feature, you can run Lambda functions locally on a Snowball Edge\. There is no charge for AWS Lambda powered by AWS Greengrass functions executed locally on an appliance\. However, there might be charges for functions that create or use resources in the AWS Cloud\. To use AWS Lambda powered by AWS Greengrass functions with Snowball Edge, you must create your jobs in an AWS Region supported by AWS IoT Greengrass\. For a list of valid regions, see [AWS Greengrass](https://docs.aws.amazon.com/general/latest/gr/rande.html#greengrass_region) in the *AWS General Reference*\.

**Note**  
If you created your job after July 17, 2018, this information doesn't apply to your device\. Instead, see [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)\.

## Before You Start<a name="function-recommendations-old"></a>

Before you create a Python\-language Lambda function to run on your Snowball Edge, we recommend that you familiarize yourself with the following services, concepts, and related topics\.

### Prerequisites for AWS IoT Greengrass<a name="greengrass-rec-old"></a>

AWS IoT Greengrass is software that extends AWS Cloud capabilities to local devices\. AWS IoT Greengrass makes it possible for local devices to collect and analyze data closer to the source of information, while also securely communicating with each other on local networks\. More specifically, developers who use AWS IoT Greengrass can author serverless code \(Lambda functions\) in the AWS Cloud\. They can then conveniently deploy this code to devices for local execution of applications\.

The following AWS IoT Greengrass concepts are important to understand when using AWS IoT Greengrass with a Snowball Edge:
+ **AWS IoT Greengrass Requirements** – For a full list of AWS IoT Greengrass requirements, see [Requirements](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-gs.html#gg-requirements) in the *AWS IoT Greengrass Developer Guide*\. AWS IoT Greengrass supports Python version 2\.7, and each Lambda function has a minimum RAM requirement of 128 MB\.
+ **AWS IoT Greengrass Core** – Each Snowball Edge has the AWS IoT Greengrass core software\. For more information on the AWS IoT Greengrass core software, see [Greengrass Core Software](https://docs.aws.amazon.com/greengrass/latest/developerguide/what-is-gg.html#gg-core) in the *AWS IoT Greengrass Developer Guide*\.
+ **AWS IoT Greengrass Group** – A Snowball Edge is part of an AWS IoT Greengrass group as the group's core device\. For more information on groups, see [AWS Greengrass Groups](https://docs.aws.amazon.com/greengrass/latest/developerguide/what-is-gg.html#gg-group) in the *AWS IoT Greengrass Developer Guide*\.
+ **MQTT** – AWS IoT Greengrass uses the industry\-standard, lightweight Message Queue Telemetry Transport \(MQTT\) protocol to communicate within a group\. Within a Snowball Edge, there is an IoT device associated with the Amazon S3 Adapter for Snowball\. When data is written using [Amazon S3 PUT object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectPUT.html) operations on buckets specified at job creation, these operations trigger MQTT messages\. These messages in turn trigger any associated Lambda functions\. In addition, any MQTT\-compatible device or software in your AWS IoT Greengrass group can trigger the Lambda functions, if you define the related MQTT message to do so\.
+ **Associated service role** – Before you can use AWS IoT Greengrass with a Snowball Edge as a core device, you must associate an AWS IoT Greengrass service role with your account\. This association allows AWS IoT Greengrass to access your Lambda functions and AWS IoT resources\. For more information, see [Associating an AWS IoT Greengrass Service Role with Your Account](function-getting-started.md#gg-associate-role)\.

### Prerequisites for AWS Lambda<a name="lambda-rec-old"></a>

AWS Lambda is a compute service that lets you run code without provisioning or managing servers\. The following Lambda concepts are important to understand when using Lambda with a Snowball Edge:
+ **Lambda functions** – Your custom code, uploaded and published to Lambda and used on a Snowball Edge\. For more information, see [Lambda Functions](https://docs.aws.amazon.com/lambda/latest/dg/lambda-introduction-function.html) in the *AWS Lambda Developer Guide*\.
+ **Lambda console** – The management console in which you'll upload, update, and publish your Python\-language Lambda functions for use on a Snowball Edge\. For a sample on how to use the [Lambda console](https://console.aws.amazon.com/lambda), see [Step 2: Create a HelloWorld Lambda Function and Explore the Console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) in the *AWS Lambda Developer Guide*\.
+ **Python** – The high\-level programming language used for your Lambda functions powered by AWS IoT Greengrass on a Snowball Edge\. AWS IoT Greengrass supports Python version 2\.7\.

### Related Topics<a name="function-related-old"></a>

The following topics are related to running AWS Lambda powered by AWS Greengrass functions on a Snowball Edge:
+ [Limitations for Lambda Powered by AWS IoT Greengrass](limits.md#function-limits)
+ [Customer Managed Policy Examples](access-policy-examples-for-sdk-cli.md)

**Next:**  
[Getting Started with Lambda Powered by AWS IoT Greengrass](function-getting-started.md)