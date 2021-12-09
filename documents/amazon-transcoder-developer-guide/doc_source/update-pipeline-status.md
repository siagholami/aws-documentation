# Update Pipeline Status<a name="update-pipeline-status"></a>

**Topics**
+ [Description](#update-pipeline-status-description)
+ [Requests](#update-pipeline-status-requests)
+ [Responses](#update-pipeline-status-responses)
+ [Errors](#update-pipeline-status-response-errors)
+ [Example](#update-pipeline-status-examples)

## Description<a name="update-pipeline-status-description"></a>

To pause or reactivate a pipeline, so the pipeline stops or restarts processing jobs, update the status for the pipeline\. Send a POST request to the `/2012-09-25/pipelines/pipelineId/status` resource\. 

Changing the pipeline status is useful if you want to cancel one or more jobs\. You can't cancel jobs after Elastic Transcoder has started processing them; if you pause the pipeline to which you submitted the jobs, you have more time to get the job IDs for the jobs that you want to cancel, and to send a `Delete Job` request\. 

## Requests<a name="update-pipeline-status-requests"></a>

### Syntax<a name="update-pipeline-status-request-syntax"></a>

```
POST /2012-09-25/pipelines/[pipelineId](#update-pipeline-status-request-pipeline-id)/status HTTP/1.1
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
   "[Status](#update-pipeline-status-request-status)":"new status for the pipeline"
}
```

### Request Parameters<a name="update-pipeline-status-request-parameters"></a>

This operation takes the following request parameter\. 

**pipelineId**  
The identifier of the pipeline that you want to pause or reactivate\. 

### Request Headers<a name="update-pipeline-status-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="update-pipeline-status-request-body"></a>

The JSON string in the request body contains the following object\. 

**Status**  
The new status of the pipeline:  
+ `Active`: Enable the pipeline, so it starts processing jobs\.
+ `Paused`: Disable the pipeline, so it stops processing jobs\.

## Responses<a name="update-pipeline-status-responses"></a>

### Syntax<a name="update-pipeline-status-response-syntax"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Id":"ID for the pipeline",
   "Status":"new status for the pipeline"
}
```

### Response Headers<a name="update-pipeline-status-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="update-pipeline-status-response-body"></a>

When you update status for a pipeline, Elastic Transcoder returns the values that you specified in the request\. For more information, see [Request Body](#update-pipeline-status-request-body)\.

## Errors<a name="update-pipeline-status-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Example<a name="update-pipeline-status-examples"></a>

The following example request enables the pipeline that has the ID `1111111111111-abcde1`\.

### Sample Request<a name="update-pipeline-status-examples-sample-request"></a>

```
POST /2012-09-25/pipelines/1111111111111-abcde1/status HTTP/1.1
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
   "Status":"Active"
}
```

### Sample Response<a name="update-pipeline-status-examples-sample-response"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Id":"1111111111111-abcde1",
   "Status":"Active"
}
```