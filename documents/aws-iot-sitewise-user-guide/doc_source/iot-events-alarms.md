# Configuring alarms for asset property values with AWS IoT Events<a name="iot-events-alarms"></a>

You can configure alarms for your data to send alert notifications to you and your team when your equipment or processes perform sub\-optimally\. Optimal performance of a machine or process means that the values for certain metrics should be within a range of high and low limits\. When these metrics are outside their operating range, equipment operators must be notified so they can fix the issue\. Alarms let you quickly identify issues and notify operators to maximize performance of your equipment and processes\.

You can use AWS IoT Events to build complex event monitoring applications, such as an alarm detection system, in the AWS Cloud\. Then, you can stream asset data from AWS IoT SiteWise to AWS IoT Events to trigger alarm events for your data\. For more information, see [What is AWS IoT Events?](https://docs.aws.amazon.com/iotevents/latest/developerguide/) in the *AWS IoT Events Developer Guide*\.

AWS IoT Events lets you send a message to Amazon Simple Notification Service when an event occurs\. You can create subscriptions in Amazon SNS to configure who receives notifications for your alarms\. For more information, see [What is Amazon SNS?](https://docs.aws.amazon.com/sns/latest/dg/) in the *Amazon Simple Notification Service Developer Guide*\.

In this tutorial, you configure resources in AWS IoT Events, Amazon SNS, and AWS Lambda to create a reusable alarm detection system in the AWS Cloud\. Then, you learn how to use this system to configure alarms for your asset properties in AWS IoT SiteWise\.

**Topics**
+ [Prerequisites](#alarm-tutorial-prerequisites)
+ [Configuring an alarm detection system](alarm-tutorial-configure-alarm-system.md)
+ [Configuring alarms](alarm-tutorial-configure-alarms.md)

## Prerequisites<a name="alarm-tutorial-prerequisites"></a>

To complete this tutorial, you need the following:
+ An AWS account\. If you don't have one, see [Setting up an AWS account](set-up-aws-account.md)\.
+ A development computer running Windows, macOS, Linux, or Unix to access the AWS Management Console\. For more information, see [Getting Started with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.
+ An IAM user with administrator permissions\.
+ Python 3 installed on your computer\.
+ AWS SDK for Python \(Boto3\) installed on your computer and configured with your AWS authentication credentials\. This tutorial requires version 1\.12\.49 or later of the SDK for Python \(Boto3\)\. For more information, see [Quickstart](http://boto3.amazonaws.com/v1/documentation/api/latest/guide/quickstart.html) in the *AWS SDK for Python \(Boto3\) Getting Started*\.