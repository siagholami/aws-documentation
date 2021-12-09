--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Snowball Notifications<a name="notifications"></a>

Snowball is designed to take advantage of the robust notifications delivered by Amazon Simple Notification Service \(Amazon SNS\)\. While creating a job, you can provide a list of comma\-separated email addresses to receive email notifications for your job\.

You can also choose from the status list which job status values trigger these notifications\. For more information about the different job status values, see [Job Statuses](jobs.md#job-status)\.

You can configure Amazon SNS to send text messages for these status notifications from the Amazon SNS console\. For more information, see [Sending and Receiving SMS Notifications Using Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/SMSMessages.html)\.

**Note**  
These notifications are optional, and are free if you're within your first million Amazon SNS requests for the month\. For more information about Amazon SNS pricing, see [https://aws.amazon.com/sns/pricing](https://aws.amazon.com/sns/pricing)\.

After you create your job, every email address that you specified to get Amazon SNS notifications receives an email from AWS Notifications asking for confirmation to the topic subscription\. For each email address to receive additional notifications, a user of the account must confirm the subscription by choosing **Confirm subscription**\.

The Amazon SNS notification emails are tailored for each triggering state, and include a link to the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.