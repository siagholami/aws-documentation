# Delete Pipeline<a name="delete-pipeline"></a>

**Topics**
+ [Description](#delete-pipeline-description)
+ [Requests](#delete-pipeline-requests)
+ [Responses](#delete-pipeline-responses)
+ [Errors](#delete-pipeline-response-errors)
+ [Example](#delete-pipeline-example)

## Description<a name="delete-pipeline-description"></a>

To delete a pipeline, send a DELETE request to the `/2012-09-25/pipelines/pipelineId` resource\. You can only delete a pipeline that has never been used or that is not currently in use \(doesn't contain any active jobs\)\. If the pipeline is currently in use, `Delete Pipeline` returns an error\. 

## Requests<a name="delete-pipeline-requests"></a>

### Syntax<a name="delete-pipeline-request-syntax"></a>

```
DELETE /2012-09-25/pipelines/[pipelineId](#delete-pipeline-request-pipeline-id) HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Request Parameters<a name="delete-pipeline-request-parameters"></a>

This operation takes the following request parameter\. 

**pipelineId**  
The identifier of the pipeline that you want to delete\. 

### Request Headers<a name="delete-pipeline-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="delete-pipeline-request-body"></a>

This operation does not have a request body\.

## Responses<a name="delete-pipeline-responses"></a>

### Syntax<a name="delete-pipeline-response-syntax"></a>

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

### Response Headers<a name="delete-pipeline-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="delete-pipeline-response-elements"></a>

The response body contains the following JSON object\.

**Success**  
If the pipeline is successfully deleted, the value of `Success` is `true`\.

## Errors<a name="delete-pipeline-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Example<a name="delete-pipeline-example"></a>

The following example request deletes the pipeline 1111111111111\-abcde1\.

### Sample Request<a name="delete-pipeline-examples-sample-request"></a>

```
DELETE /2012-09-25/pipelines/1111111111111-abcde1 HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Sample Response<a name="delete-pipeline-examples-sample-response"></a>

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