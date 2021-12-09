# Creating CloudWatch Alarms to Monitor Amazon FSx for Lustre<a name="creating_alarms"></a>

You can create a CloudWatch alarm that sends an Amazon SNS message when the alarm changes state\. An alarm watches a single metric over a time period you specify, and performs one or more actions based on the value of the metric relative to a given threshold over a number of time periods\. The action is a notification sent to an Amazon SNS topic or Auto Scaling policy\.

Alarms invoke actions for sustained state changes only\. CloudWatch alarms don't invoke actions simply because they are in a particular state; the state must have changed and been maintained for a specified number of periods\. 

The following procedures outline how to create alarms for Amazon FSx for Lustre\.

**To set alarms using the CloudWatch console**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Create Alarm**\. Doing this launches the Create Alarm Wizard\. 

1. Choose **FSx Metrics** and scroll through the Amazon FSx for Lustre metrics to locate the metric that you want to place an alarm on\. To display just the Amazon FSx for Lustre metrics in this dialog box, search on the file system ID of your file system\. Choose the metric to create an alarm on, and choose **Next**\.

1.  Enter the **Name**, **Description**, **Whenever** values for the metric\. 

1. If you want CloudWatch to send you an email when the alarm state is reached, for **Whenever this alarm**, choose **State is ALARM**\. For **Send notification to**, choose an existing SNS topic\. If you choose **Create topic**, you can set the name and email addresses for a new email subscription list\. This list is saved and appears in this box for future alarms\.
**Note**  
If you use **Create topic** to create a new Amazon SNS topic, verify the email addresses before sending them notifications\. Emails are only sent when the alarm enters an alarm state\. If this alarm state change happens before the email addresses are verified, they don't receive a notification\.

1. Preview the alarm you're about to create in the **Alarm Preview** area\. If it appears as expected, choose **Create Alarm**\. 

**To set an alarm using the AWS CLI**
+ Call `[put\-metric\-alarm](https://docs.aws.amazon.com/cli/latest/reference/put-metric-alarm.html)`\. For more information, see *[AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/)*\.

**To set an alarm using the CloudWatch API**
+ Call `[PutMetricAlarm](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_PutMetricAlarm.html)`\. For more information, see *[Amazon CloudWatch API Reference](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/)*\. 