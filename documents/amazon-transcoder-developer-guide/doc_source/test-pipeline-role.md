# Test Role<a name="test-pipeline-role"></a>

**Topics**
+ [Description](#test-pipeline-role-description)
+ [Requests](#test-pipeline-role-requests)
+ [Responses](#test-pipeline-role-responses)
+ [Errors](#test-pipeline-role-response-errors)
+ [Examples](#test-pipeline-role-examples)

## Description<a name="test-pipeline-role-description"></a>

To test the settings for a pipeline to ensure that Elastic Transcoder can create and process jobs, send a POST request to the `/2012-09-25/roleTests` resource\.

## Requests<a name="test-pipeline-role-requests"></a>

### Syntax<a name="test-pipeline-role-request-syntax"></a>

```
POST /2012-09-25/roleTests HTTP/1.1
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
   "[InputBucket](#test-pipeline-role-request-inputbucket)":"Amazon S3 bucket that contains files to transcode",
   "[OutputBucket](#test-pipeline-role-request-outputbucket)":"Amazon S3 bucket in which to save transcoded files",
   "[Role](#test-pipeline-role-request-role)":"IAM ARN for the role to test",
   "[Topics](#test-pipeline-role-request-topics)": [
      "ARN of SNS topic to test"
   ]
}
```

### Request Parameters<a name="test-pipeline-role-request-parameters"></a>

This operation does not use request parameters\.

### Request Headers<a name="test-pipeline-role-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="test-pipeline-role-request-body"></a>

The JSON string in the request body contains the following objects\. 

**InputBucket**  
The Amazon S3 bucket in which you saved the media files that you want to transcode\. `Test Role` tries to read from this bucket\. 

**OutputBucket**  
The Amazon S3 bucket in which you want Elastic Transcoder to save the transcoded files\. `Test Role` tries to read from this bucket\.

**Role**  
The IAM Amazon Resource Name \(ARN\) for the role that you want Elastic Transcoder to use to transcode jobs\. `Test Role` tries to assume the specified role\.

**Topics**  
The ARNs of one or more Amazon Simple Notification Service \(Amazon SNS\) topics to which you want `Test Role` to send test notifications\. If you aren't using Amazon SNS notifications, you can specify an empty list\. 

## Responses<a name="test-pipeline-role-responses"></a>

### Syntax<a name="test-pipeline-role-response-syntax"></a>

```
Status: 200 OK
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "[Messages](#test-pipeline-role-response-messages)": [
      "error messages, if any"
   ],
   "[Success](#test-pipeline-role-response-success)": "true | false"
}
```

### Response Headers<a name="test-pipeline-role-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="test-pipeline-role-response-body"></a>

When you test settings for a pipeline, Elastic Transcoder returns the following values\.

**Messages**  
If the value of `Success` is `false`, `Messages` contains an array of one or more messages that explain which tests failed\.

**Success**  
If the operation is successful, this value is `true`; otherwise, the value is `false`\.

## Errors<a name="test-pipeline-role-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="test-pipeline-role-examples"></a>

### Sample Request<a name="test-pipeline-role-examples-sample-request"></a>

```
POST /2012-09-25/roleTests HTTP/1.1
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
   "InputBucket":"salesoffice.example.com-source",
   "OutputBucket":"salesoffice.example.com-public-promos",
   "Role":"arn:aws:iam::123456789012:role/transcode-service",
   "Topics": 
      ["arn:aws:sns:us-east-1:111222333444:ETS_Errors", 
       "arn:aws:sns:us-east-1:111222333444:ETS_Progressing"]
}
```

### Sample Response<a name="test-pipeline-role-examples-sample-response"></a>

```
Status: 201 Created
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Messages":[
      "The role arn:aws:iam::123456789012:role/transcode-service does not have access to the bucket: salesoffice.example.com-source",
      "The role arn:aws:iam::123456789012:role/transcode-service does not have access to the topic: arn:aws:sns:us-east-1:111222333444:ETS_Errors"
   ], 
   "Success": "false"
}
```