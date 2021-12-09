# Prerequisites<a name="iotevents-getting-started-prereqs"></a>

If you don't have an AWS account, create one\. 

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

1. Create two Amazon Simple Notification Service \(Amazon SNS\) topics\.

   This tutorial \(and the corresponding example\) assume that you created two Amazon SNS topics\. The ARNs of these topics are shown as: `arn:aws:sns:us-east-1:123456789012:underPressureAction` and `arn:aws:sns:us-east-1:123456789012:pressureClearedAction`\. Replace these values with the ARNs of Amazon SNS topics that you create\. For more information, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.

   As an alternative to publishing alerts to Amazon SNS topics, you can have the detectors send MQTT messages with a topic that you specify\. With this option, you can verify that your detector model is creating instances and that those instances are sending alerts by using the AWS IoT Core console to subscribe to and monitor messages sent to those MQTT topics\. You can also define the MQTT topic name dynamically at runtime by using an input or variable created in the detector model\. 

1. Choose an AWS Region that supports AWS IoT Events\. For more information, see [AWS IoT Events](https://docs.aws.amazon.com/general/latest/gr/rande.html#iotevents_region) in the *AWS General Reference*\. For help, see [Working with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html) in the *Getting Started with the AWS Management Console*\.