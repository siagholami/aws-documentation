# Creating CloudWatch Alarms to Monitor Elastic Transcoder<a name="creating-alarms"></a>

You can create a CloudWatch alarm that sends an Amazon SNS message when the alarm changes state\. An alarm watches a single metric over a time period you specify, and performs one or more actions based on the value of the metric relative to a given threshold over a number of time periods\. The action is a notification sent to an Amazon SNS topic or Auto Scaling policy\. Alarms invoke actions for sustained state changes only\. CloudWatch alarms do not invoke actions simply because they are in a particular state; the state must have changed and been maintained for a specified number of periods\.<a name="track-standby"></a>

**How can I track the wait time before my job is started?**

You can use the `Standyby Time` metric to track how long it takes a pipeline to start your transcoding jobs\.

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Create Alarm**\. This launches the **Create Alarm Wizard**\. 

1. Choose **AWS/ElasticTranscoder Metrics** and scroll through the Elastic Transcoder metrics to locate the **Standby Time** metric\. Select the **Standby Time** metric to create an alarm on and choose **Next**\. 

1. Fill in the **Name**, **Description**, and **Whenever** values for the metric\. 

1. For **Actions**, choose an existing Amazon SNS topic\.

   For more information about Amazon SNS notifications, see [Create a Topic](https://docs.aws.amazon.com/sns/latest/dg/CreateTopic.html) in the Amazon Simple Notification Service Developer Guide\.

1. Choose **Create Alarm**\.<a name="track-jobs-errored"></a>

**How can I be notified when a job fails due to an error?**

You can use the `Job Errored` metric to track how many jobs failed in your pipeline due to invalid input parameters\.

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Create Alarm**\. This launches the **Create Alarm Wizard**\. 

1. Choose **AWS/ElasticTranscoder Metrics** and scroll through the Elastic Transcoder metrics to locate the **Job Errored** metric\. Select the **Job Errored** metric to create an alarm on and choose **Next**\. 

1. Fill in the **Name**, **Description**, and **Whenever** values for the metric\. 

1. For **Actions**, choose an existing Amazon SNS topic\.

   For more information about Amazon SNS notifications, see [Create a Topic](https://docs.aws.amazon.com/sns/latest/dg/CreateTopic.html) in the Amazon Simple Notification Service Developer Guide\.

1. Choose **Create Alarm**\.<a name="track-jobs-completed"></a>

**How can I be notitifed when a job completes?**

You can use the `Jobs Completed` metric to track how many jobs a pipeline has transcoded\.

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Create Alarm**\. This launches the **Create Alarm Wizard**\. 

1. Choose **AWS/ElasticTranscoder Metrics** and scroll through the Elastic Transcoder metrics to locate the **Jobs Completed** metric\. Select the **Jobs Completed** metric to create an alarm on and choose **Next**\. 

1. Fill in the **Name**, **Description**, and **Whenever** values for the metric\. 

1. For **Actions**, choose an existing Amazon SNS topic\.

   For more information about Amazon SNS notifications, see [Create a Topic](https://docs.aws.amazon.com/sns/latest/dg/CreateTopic.html) in the Amazon Simple Notification Service Developer Guide\.

1. Choose **Create Alarm**\.