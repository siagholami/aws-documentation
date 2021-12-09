# Monitoring AWS IoT 1\-Click with Amazon CloudWatch<a name="1click-cloudwatch"></a>

AWS IoT 1\-Click automatically monitors devices on your behalf and reports metrics through [Amazon CloudWatch](https://aws.amazon.com/cloudwatch/)\. These metrics are reported in the device region where the devices were registered by the manufacturer\. For more information about device regions, see [How AWS IoT 1\-Click Works](1click-devices.md)\. You can find the metrics in the Amazon CloudWatch dashboard under the **IoT1Click** namespace\.

Amazon CloudWatch Events enables you to automate your AWS services and respond automatically to system events, such as application availability issues or resource changes\. Events from AWS services are delivered to CloudWatch Events in near real time\. You can write simple rules to indicate which events are of interest to you and which automated actions to take when an event matches a rule\. The following actions that can be triggered:
+ Invoking an AWS Lambda function\.
+ Invoking Amazon EC2 Run Command\.
+ Relaying the event to Amazon Kinesis Data Streams\.
+ Activating an AWS Step Functions state machine\.
+ Notifying an Amazon SNS topic or an AWS SMS queue\.

AWS IoT 1\-Click tracks and reports the following metrics:
+ **TotalEvents** tracks the number of events published by devices\. This metric can be viewed and graphed by device event, project, device type, or product type\.
+ **RemainingLife** represents the approximate percentage of life remaining for a device\. AWS IoT 1\-Click reports this number based on the manufacturer’s rating of the device\. For example, if a button is designed to last for approximately 2000 clicks, and 500 clicks have been recorded, the **RemainingLife** value is reported as 75%\. The **RemainingLife** metric can be viewed and graphed by project, device type, or product type\. Customers can use the **RemainingLife** metric to set up alarms that are triggered when devices fall below a certain threshold\. Customers can then query the **RemainingLife** of devices by using the `GetDeviceHealthParameters` method to identify devices that have low **RemainingLife** values\.
+ **CallbackInvocationErrors** tracks failures in invoking the callbacks \(Lambda functions\) when the device emits an event\. The **CallbackInvocationErrors** metric can be viewed and graphed by invoked callback \(Lambda function ARNs set as callbacks\) or by project\. Customers can set up alarms for the **CallbackInvocationErrors** metric to be notified when AWS IoT 1\-Click was unable to route events from their devices to their configured Lambda functions\.

For more information, see the [Amazon CloudWatch Events User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/)\.