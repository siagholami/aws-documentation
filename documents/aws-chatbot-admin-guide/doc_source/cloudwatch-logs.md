# Accessing Amazon CloudWatch Logs for AWS Chatbot<a name="cloudwatch-logs"></a>

AWS provides event logging with Amazon CloudWatch Logs\. With CloudWatch Logs for AWS Chatbot, you can see all the events handled by AWS Chatbot\. You can also see details of any error that may have prevented a notification from appearing in your Amazon Chime or Slack chat room\.

Possible errors that you can see with CloudWatch Logs include lack of permissions, unsupported events, and events throttled by the chat client\. For more information about these errors, see [Troubleshooting AWS Chatbot](chatbot-troubleshooting.md)\.

You can choose to enable logging for all events, or only for errors\.

**Note**  
There is an additional charge for using CloudWatch Logs\. For more details, see [Amazon CloudWatch Pricing](https://aws.amazon.com/cloudwatch/pricing)\.

## Enabling CloudWatch Logs<a name="enabling-cloudwatch-logs"></a>

You can enable CloudWatch Logs during the setup flow of your Amazon Chime or Slack channel configuration\. For existing channels, you can edit the configuration to enable logging\.

**To enable CloudWatch Logs for a new configuration**

1. On the **Configure channel** page, during the setup flow, under **Configuration details**, choose **Send logs to CloudWatch\.**

1. Choose either **All events** or **Errors only**\.

1. Continue the setup flow, then choose **Configure channel**\.

**To enable CloudWatch Logs for an existing configuration**

1. In the AWS Chatbot console, under **Configured clients**, navigate to the chat client you want to edit\.

1. From the list of existing configurations, choose the configuration you want to edit, then choose **Edit**\.

1. On the **Edit** page, choose **Send logs to CloudWatch\.**

1. Choose either **All events** or **Errors only**\.

1. Choose **Save**\.

## Viewing CloudWatch Logs<a name="viewing-cloudwatch-logs"></a>

Your AWS Chatbot logs will be sent to CloudWatch under a designated CloudWatch Logs group for your configuration\. The group name is **/aws/chatbot/**configuration\-name****\. To learn more about log groups and other CloudWatch concepts such as log events and log streams, see [Amazon CloudWatch Logs Concepts](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/CloudWatchLogsConcepts.html) in the *Amazon CloudWatch Logs User Guide*\.

You can view your logs in the Amazon CloudWatch console\. Note that you must specify **US East \(N\. Virginia\)** for the Region\. For more information, see [View Log Data Sent to CloudWatch Logs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/Working-with-log-groups-and-streams.html#ViewingLogData) in the *Amazon CloudWatch Logs User Guide*\.