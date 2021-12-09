# Cancel Job<a name="cancel-job"></a>

**Topics**
+ [Description](#cancel-job-description)
+ [Requests](#cancel-job-requests)
+ [Responses](#cancel-job-responses)
+ [Errors](#cancel-job-response-errors)
+ [Examples](#cancel-job-examples)

## Description<a name="cancel-job-description"></a>

To cancel a job that Elastic Transcoder has not begun to process, send a DELETE request to the `/2012-09-25/jobs/jobId` resource\. Elastic Transcoder might still return the job if you submit a `Read Job`, `List Job by Pipeline`, or `List Job by Status` request, but Elastic Transcoder won't transcode the input file, and you won't be charged for the job\.

**Note**  
You can only cancel a job that has a status of **Submitted**\. To prevent a pipeline from starting to process a job while you're getting the job identifier, use [Update Pipeline Status](update-pipeline-status.md) to temporarily pause the pipeline\.

## Requests<a name="cancel-job-requests"></a>

### Syntax<a name="cancel-job-request-syntax"></a>

```
DELETE /2012-09-25/jobs/[jobId](#cancel-job-request-job-id) HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Request Parameter<a name="cancel-job-request-parameters"></a>

This operation takes the following request parameter\. 

**jobId**  
The identifier of the job that you want to cancel\.   
To get a list of the jobs \(including their `jobId`\) that have a status of `Submitted`, use the [List Jobs by Status](list-jobs-by-status.md) API action\.

### Request Headers<a name="cancel-job-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="cancel-job-request-body"></a>

This operation does not have a request body\.

## Responses<a name="cancel-job-responses"></a>

### Syntax<a name="cancel-job-response-syntax"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Success":"true"
}
```

### Response Headers<a name="cancel-job-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="cancel-job-response-body"></a>

The response body contains the following JSON object\.

**Success**  
If the job is successfully canceled, the value of `Success` is `true`\.

## Errors<a name="cancel-job-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="cancel-job-examples"></a>

The following example request cancels the job that has the ID `3333333333333-abcde3`\.

### Sample Request<a name="cancel-job-examples-sample-request"></a>

```
DELETE /2012-09-25/jobs/3333333333333-abcde3 HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Sample Response<a name="cancel-job-examples-sample-response"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Success":"true"
}
```