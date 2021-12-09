# Notifications of Job Status<a name="notifications"></a>

Elastic Transcoder can notify you when the status of a job changes\. You can configure Elastic Transcoder to send you notifications for any combination \(or none\) of the following changes in status:
+ **Progressing:** Elastic Transcoder has started to process a job in the pipeline\.
+ **Complete:** Elastic Transcoder has finished processing a job in the pipeline\.
+ **Warning:** Elastic Transcoder encountered a warning condition while processing a job in the pipeline\.
+ **Error:** Elastic Transcoder encountered an error condition while processing a job in the pipeline\.

Elastic Transcoder sends notifications by using Amazon Simple Notification Service \(Amazon SNS\)\. Amazon SNS offers a variety of notification options, including the ability to send messages to HTTP endpoints, email addresses, and Amazon Simple Queue Service \(Amazon SQS\) queues\. For more information about these and other options, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\. 

Notifications are useful for designing event\-driven applications\. If you use notifications to determine when jobs have completed, you can eliminate polling, and you won't encounter the `Limit Exceeded` exceptions \(HTTP status code 429\) that sometimes result from polling\. 

You configure notifications when you create or update a pipeline\. For every job that you submit to that pipeline, Elastic Transcoder sends the associated notifications\. 

**Important**  
When you change notifications, your changes take effect immediately\. Jobs that you have already submitted and that Elastic Transcoder has not started to process are affected in addition to jobs that you submit after you change notifications\.

To configure Elastic Transcoder to notify you of changes in job status when you're using the Elastic Transcoder API:

1. Create one or more Amazon SNS topics, and subscribe to each topic\. For more information, see the [Amazon Simple Notification Service documentation](http://aws.amazon.com/documentation/sns/)\.

   If you already have Amazon SNS topics that you want to use, you can skip this step\.

1. Create a pipeline or update an existing pipeline\. For each change in status for which you want notification \(Progressing, Complete, Warning, Error\), specify the applicable Amazon SNS topic that you created in Step 1\. For more information, see [Create Pipeline](create-pipeline.md), [Update Pipeline](update-pipeline.md), or [Update Pipeline Notifications](update-pipeline-notifications.md)\.

1. Test notifications for `Progressing` and `Complete` statuses by submitting a job to Elastic Transcoder\.

You can also use the Elastic Transcoder console to configure notifications\. If you use the console, you can create Amazon SNS topics as you create or update the pipeline\. However, you still need to use the Amazon SNS console, API, or CLI to subscribe to the new topics\.

When Elastic Transcoder sends you notification of a change in status, the message returned in the notification is in the following JSON format\. Note that the message includes the status for each output as well as a state for the job:

```
{
   "state" : "PROGRESSING|COMPLETED|WARNING|ERROR",
   "errorCode" : "the code of any error that occurred",
   "messageDetails" : "the notification message you created in Amazon SNS",
   "version" : "API version that you used to create the job",
   "jobId" : "value of Job:Id object that Elastic Transcoder 
             returns in the response to a Create Job request",
   "pipelineId" : "value of PipelineId object 
                  in the Create Job request",
   "input" : {
      job Input settings
   },
   "outputKeyPrefix" : "prefix for file names in Amazon S3 bucket",
   "outputs": [
      {
         applicable job Outputs settings,
         "status" : "Progressing|Complete|Warning|Error"
      },
      {...}
   ],
   "playlists": [
      {
         applicable job playlists settings
      }
   ],
   "userMetadata": {
      "metadata key": "metadata value"
   }
}
```