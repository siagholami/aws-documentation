# Update Pipeline Notifications<a name="update-pipeline-notifications"></a>

**Topics**
+ [Description](#update-pipeline-notifications-description)
+ [Requests](#update-pipeline-notifications-requests)
+ [Responses](#update-pipeline-notifications-responses)
+ [Errors](#update-pipeline-notifications-response-errors)
+ [Examples](#update-pipeline-notifications-examples)

## Description<a name="update-pipeline-notifications-description"></a>

To update only Amazon Simple Notification Service \(Amazon SNS\) notifications for a pipeline, send a POST request to the `/2012-09-25/pipelines/pipelineId/notifications` resource\.

**Important**  
When you change notifications, your changes take effect immediately\. Jobs that you have already submitted and that Elastic Transcoder has not started to process are affected in addition to jobs that you submit after you change notifications\.

## Requests<a name="update-pipeline-notifications-requests"></a>

### Syntax<a name="update-pipeline-notifications-request-syntax"></a>

```
POST /2012-09-25/pipelines/[pipelineId](#update-pipeline-notifications-request-pipeline-id)/notifications HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256 
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
Content-Length: number of characters in the JSON string
{
   "[Id](#update-pipeline-notifications-request-id)":"pipelineId",
   "Notifications":{
      "[Progressing](#update-pipeline-notifications-request-notifications-progressing)":"SNS topic to notify when
         Elastic Transcoder has started to process the job",
      "[Complete](#update-pipeline-notifications-request-notifications-completed)":"SNS topic to notify when
         Elastic Transcoder has finished processing the job",
      "[Warning](#update-pipeline-notifications-request-notifications-warning)":"SNS topic to notify when
      	Elastic Transcoder returns a warning",
      "[Error](#update-pipeline-notifications-request-notifications-error)":"SNS topic to notify when
         Elastic Transcoder returns an error"
   }
}
```

### Request Parameters<a name="update-pipeline-notifications-request-parameters"></a>

This operation takes the following request parameter\. 

**pipelineId**  
The identifier of the pipeline for which you want to change notification settings\. 

### Request Headers<a name="update-pipeline-notifications-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="update-pipeline-notifications-request-body"></a>

The JSON string in the request body contains the following objects\. 

**Id**  
The ID of the pipeline that you want to update\.

**Notifications:Progressing**  
The topic ARN for the Amazon Simple Notification Service \(Amazon SNS\) topic that you want to notify when Elastic Transcoder has started to process a job in this pipeline\. This is the ARN that Amazon SNS returned when you created the topic\. For more information, see [Create a Topic](https://docs.aws.amazon.com/sns/latest/dg/CreateTopic.html) in the *Amazon Simple Notification Service Developer Guide*\.  
To receive notifications, you must also subscribe to the new topic in the Amazon SNS console\.
Amazon SNS offers a variety of notification options, including the ability to send Amazon SNS messages to Amazon Simple Queue Service queues\. For more information, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.

**Notifications:Complete**  
The topic ARN for the Amazon SNS topic that you want to notify when Elastic Transcoder has finished processing a job in this pipeline\. This is the ARN that Amazon SNS returned when you created the topic\. 

**Notifications:Warning**  
The topic ARN for the Amazon SNS topic that you want to notify when Elastic Transcoder encounters a warning condition while processing a job in this pipeline\. This is the ARN that Amazon SNS returned when you created the topic\. 

**Notifications:Error**  
The topic ARN for the Amazon SNS topic that you want to notify when Elastic Transcoder encounters an error condition while processing a job in this pipeline\. This is the ARN that Amazon SNS returned when you created the topic\. 

## Responses<a name="update-pipeline-notifications-responses"></a>

### Syntax<a name="update-pipeline-notifications-response-syntax"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Pipeline":{
      "Id":"ID for the new pipeline",
      "Notifications":{
         "Progressing":"SNS topic to notify when Elastic Transcoder has started to process the job",
         "Complete":"SNS topic to notify when Elastic Transcoder has finished processing the job",
         "Warning":"SNS topic to notify when Elastic Transcoder returns a warning",
         "Error":"SNS topic to notify when Elastic Transcoder returns an error"
      }
   }
}
```

### Response Headers<a name="update-pipeline-notifications-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="update-pipeline-notifications-response-body"></a>

When you update notifications for a pipeline, Elastic Transcoder returns the values that you specified in the request\. For more information, see [Request Body](#update-pipeline-notifications-request-body)\.

## Errors<a name="update-pipeline-notifications-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="update-pipeline-notifications-examples"></a>

The following example request updates the notifications for a pipeline\.

### Sample Request<a name="update-pipeline-notifications-examples-sample-request"></a>

```
POST /2012-09-25/pipelines/1111111111111-abcde1/notifications HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256 
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
Content-Length: number of characters in the JSON string
{
   "Id":"1111111111111-abcde1",
   "Notifications":{
      "Progressing":"",
      "Complete":"",
      "Warning":"",
      "Error":"arn:aws:sns:us-east-1:111222333444:ETS_Errors"
   }
}
```

### Sample Response<a name="update-pipeline-notifications-examples-sample-response"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Id":"1111111111111-abcde1",
   "Notifications":{
      "Progressing":"",
      "Complete":"",
      "Warning":"",
      "Error":"arn:aws:sns:us-east-1:111222333444:ETS_Errors"
   }
}
```