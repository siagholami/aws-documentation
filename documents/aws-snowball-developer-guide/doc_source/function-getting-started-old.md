--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Getting Started with Lambda Powered by AWS IoT Greengrass<a name="function-getting-started-old"></a>

To get started with AWS Lambda powered by AWS Greengrass functions on a Snowball Edge, take the following steps:

1. [Associating an AWS IoT Greengrass Service Role with Your Account](#gg-associate-role-old)

1. [Configuring AWS IoT Greengrass with a Snowball Edge](#gg-config-old)

1. [Creating Your Job](#function-create-job-old)

1. [Using Lambda Powered by AWS Greengrass Functions on a Snowball Edge](#use-functions-old)

## Associating an AWS IoT Greengrass Service Role with Your Account<a name="gg-associate-role-old"></a>

Before you can use AWS IoT Greengrass with a Snowball Edge as a core device, you must associate an AWS IoT Greengrass service role with your account\. This association allows AWS IoT Greengrass to access your Lambda functions and AWS IoT resources\. If you try to create a job for a Snowball Edge before you associate the service role, the job creation request fails\.

The following procedures show how to configure and store your AWS IoT Greengrass settings in the cloud\. This configuration means that you can push Lambda function changes to the Snowball Edge and changes to other devices in your AWS IoT Greengrass group\. The first procedure uses the AWS Identity and Access Management \(IAM\) console, and the second procedure uses the AWS Command Line Interface \(AWS CLI\)\. 

**To create an AWS IoT Greengrass service role in the IAM console**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. For **Role Type**, choose **AWS Greengrass Role**\.

1. Select **AWSGreengrassResourceAccessPolicy**, and then choose **Next Step**\.

1. Type a name for your role, and then choose **Create Role**\.

After creating the role, make a note of the role Amazon Resource Name \(ARN\), and use it in the next procedure\.

**To associate the AWS IoT Greengrass service role with your account**

1. Install the AWS CLI on your computer, if you haven't already\. For more information, see [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) in the *AWS Command Line Interface User Guide*\.

1. Configure the AWS CLI on your computer, if you haven't already\. For more information, see [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.

1. Open a terminal on your computer and run the following AWS CLI command, with the AWS IoT Greengrass role ARN you created in the first procedure\.

   ```
   aws greengrass associate-service-role-to-account --role-arn arn:aws:iam::123EXAMPLE12:role/GreengrassRole
   ```

Now you can create a job for a Snowball Edge and use AWS Lambda powered by AWS Greengrass\.

## Configuring AWS IoT Greengrass with a Snowball Edge<a name="gg-config-old"></a>

When you create a compute job for a Snowball Edge, the service automatically configures the following AWS IoT Greengrass elements:
+ **AWS IoT Greengrass Core Software** – The AWS IoT Greengrass distributable has been pre\-installed on the Snowball Edge\.
+ **AWS IoT Greengrass Group** – When you create a compute job, an AWS IoT Greengrass group named `JobID_group` is created and provisioned\. The core of this group is named `JobID_core`, and it has a device in it named `JobID_s3adapter`\. The Amazon S3 Adapter for Snowball is registered as an IoT device in your AWS IoT Greengrass group\. This registration is because the adapter sends MQTT messages for every Amazon S3 PUT object action for the buckets on the Snowball Edge\.

If you have other configuration changes that you want to make for the AWS IoT Greengrass group associated with a Snowball Edge, you can make them after you unlock the device and connect it to the internet\.

## Creating Your Job<a name="function-create-job-old"></a>

Create a job in the AWS Snowball Management Console and associate the Amazon Resource Name \(ARN\) for at least one published Lambda function with a bucket\. For a walkthrough on creating your first job, see [Getting Started with AWS Snowball Edge: Your First Job](common-get-start.md)\. 

All the Lambda functions that you choose during job creation are triggered by MQTT messages sent by the IoT device associated with the Amazon S3 Adapter for Snowball\. These MQTT messages are triggered whenever an [Amazon S3 PUT object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectPUT.html) action is made against the bucket on the AWS Snowball Edge device\.

## Connecting to the Internet to Update AWS IoT Greengrass Group Certificates<a name="function-update-certs-old"></a>

When the Snowball Edge arrives, unlock the device, and then connect it to the internet for at least one minute\. Connecting the device to the internet allows the AWS IoT Greengrass service in the cloud to send the AWS IoT Greengrass certificates that are needed to operate the Snowball Edge\. After that, you can disconnect the device from the internet\. The associated AWS IoT Greengrass group then functions in offline mode\.

**Important**  
When the IP address for any device in the local AWS IoT Greengrass group changes, reconnect the Snowball Edge to the internet so it can get new certificates\.

## Using Lambda Powered by AWS Greengrass Functions on a Snowball Edge<a name="use-functions-old"></a>

Unless programmed otherwise, Lambda functions are triggered by MQTT messages sent by the IoT device associated with the Amazon S3 Adapter for Snowball\. These MQTT messages are in turn triggered by Amazon S3 PUT object actions\. Amazon S3 PUT object actions occur through the file interface \(with a write operation\), the AWS CLI \(using the Amazon S3 Adapter for Snowball\), or programmatically through one of the SDKs or a REST application of your own design\.

You can use your AWS Lambda powered by AWS Greengrass functions to execute Python code against public endpoints among AWS services in the cloud\. For this Python code execution to work, your AWS Snowball Edge device needs to be connected to the internet\. For more information, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)\.

### Updating Existing Functions<a name="update-functions-old"></a>

You can update existing Lambda functions in the console\. If you do, and if your AWS Snowball Edge device is connected to the internet, a deployment agent notifies each Lambda function of the updated AWS IoT Greengrass group configuration\. For more information, see [Create a Deployment](https://docs.aws.amazon.com/lambda/latest/dg/create-deployment.html) in the *AWS IoT Greengrass Developer Guide*\.

### Adding New Functions<a name="add-new-functions-old"></a>

After your Snowball Edge arrives and you unlock it and connect it to the internet, you can add or remove additional Lambda functions\. These new Lambda functions don't have to be triggered by Amazon S3 PUT object actions\. Instead, the event that you programmed to trigger the new functions performs function triggering, as with typical Lambda functions running in an AWS IoT Greengrass group\. 

### Testing Lambda Powered by AWS IoT Greengrass Functions<a name="testing-functions-old"></a>

While testing your Python\-coded function in the Lambda console, you might encounter errors\. If that happens, see [Retries on Errors](https://docs.aws.amazon.com/lambda/latest/dg/retries-on-errors.html) in the *AWS Lambda Developer Guide*\.