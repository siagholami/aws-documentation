# Updating Pipeline Notifications in Elastic Transcoder<a name="updating-pipeline-notifications"></a>

When you create a pipeline, you can optionally configure Elastic Transcoder to send a message to an Amazon Simple Notification Service \(Amazon SNS\) topic when the status of a job changes, including when Elastic Transcoder starts or finishes processing a job, and when Elastic Transcoder encounters a warning or error condition while processing a job\. You can change whether you want Elastic Transcoder to send a message, and, if so, you can change which SNS topic to send the message to\. 

Amazon SNS offers a variety of notification options, including the ability to send Amazon SNS messages to Amazon Simple Queue Service \(Amazon SQS\) queues\. For more information, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.

The following procedure explains how to update notifications using the console\. For information about how to update notifications using the API, see [Update Pipeline Notifications](update-pipeline-notifications.md)\.

**To update pipeline notifications using the Elastic Transcoder console**

1. Sign in to the AWS Management Console and open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation bar of the Elastic Transcoder console, select the region in which you want to pause or reactivate a pipeline\.

1. In the navigation \(left\) pane, click **Pipelines**\.

1. Select the check box next to the pipeline for which you want to change notifications\.

1. Click **Edit**\.

1. Change values as applicable\. For more information, see [Settings that You Specify When You Create an Elastic Transcoder Pipeline](pipeline-settings.md)\.

1. Click **Save** to save your changes\.