# Create Pipeline<a name="create-pipeline"></a>

**Topics**
+ [Description](#create-pipeline-description)
+ [Requests](#create-pipeline-requests)
+ [Responses](#create-pipeline-responses)
+ [Errors](#create-pipeline-response-errors)
+ [Examples](#create-pipeline-examples)

## Description<a name="create-pipeline-description"></a>

To create a pipeline, send a POST request to the `/2012-09-25/pipelines/` resource\.

## Requests<a name="create-pipeline-requests"></a>

### Syntax<a name="create-pipeline-request-syntax"></a>

```
POST /2012-09-25/pipelines HTTP/1.1
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
   "Name":"pipeline name",
   "InputBucket":"Amazon S3 bucket that contains files to transcode 
      and graphics to use as watermarks",
   "OutputBucket":"Use this, or use ContentConfig:Bucket plus 
      ThumbnailConfig:Bucket",
   "Role":"IAM role ARN",
   "AwsKmsKeyArn":"AWS-KMS key arn of the AWS-KMS key you want to 
      use with this pipeline",
   "Notifications":{
      "Progressing":"SNS topic to notify when
         Elastic Transcoder has started to process the job",
      "Complete":"SNS topic to notify when
         Elastic Transcoder has finished processing the job",
      "Warning":"SNS topic to notify when
         Elastic Transcoder encounters a warning condition"
      "Error":"SNS topic to notify when
         Elastic Transcoder encounters an error condition"
   },
   "ContentConfig":{
      "Bucket":"Use this plus ThumbnailConfig:Bucket,
         or use OutputBucket",
      "Permissions":[
         {
            "GranteeType":"Canonical|Email|Group",
            "Grantee":"AWS user ID or CloudFront origin access identity"|
                      "registered email address for AWS account"|
                      AllUsers|AuthenticatedUsers|LogDelivery",
            "Access":[
               "Read|ReadAcp|WriteAcp|FullControl",
               ...
            ]
         },
         {...}
      ],
      "StorageClass":"Standard|ReducedRedundancy"
   },
   "ThumbnailConfig":{
      "Bucket":"Use this plus ContentConfig:Bucket,
         or use OutputBucket",
      "Permissions":[
         {
            "GranteeType":"Canonical|Email|Group",
            "Grantee":"AWS user ID or CloudFront origin access identity"|
                      "registered email address for AWS account"|
                      AllUsers|AuthenticatedUsers|LogDelivery",
            "Access":[
               "Read|ReadAcp|WriteAcp|FullControl",
               ...
            ]
         },
         {...}
      ],
      "StorageClass":"Standard|ReducedRedundancy"
   }
}
```

### Request Parameters<a name="create-pipeline-request-parameters"></a>

This operation does not use request parameters\.

### Request Headers<a name="create-pipeline-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="create-pipeline-request-body"></a>

The JSON string in the request body contains the input objects for the `CreatePipeline` operation\. For more information about the input objects, see [Settings that You Specify When You Create an Elastic Transcoder Pipeline](pipeline-settings.md)\. 

## Responses<a name="create-pipeline-responses"></a>

### Syntax<a name="create-pipeline-response-syntax"></a>

```
Status: 201 Created
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Pipeline":{
      "[Id](#create-pipeline-response-id)":"Id for the new pipeline",
      "Name":"pipeline name",
      "InputBucket":"Amazon S3 bucket that contains files to transcode
         and graphics to use as watermarks",
      "OutputBucket":"Use this, or use ContentConfig:Bucket plus 
         ThumbnailConfig:Bucket",
      "Role":"IAM role ARN",
      "AwsKmsKeyArn":"AWS-KMS key arn of the AWS-KMS key you want to
            use with this pipeline",
      "Notifications":{
         "Progressing":"SNS topic to notify when
            Elastic Transcoder has started to process the job",
         "Complete":"SNS topic to notify when
            Elastic Transcoder has finished processing the job",
         "Warning":"SNS topic to notify when
            Elastic Transcoder encounters a warning condition",
         "Error":"SNS topic to notify when
            Elastic Transcoder encounters an error condition"
      },
      "ContentConfig":{
         "Bucket":"Use this plus ThumbnailConfig:Bucket,
            or use OutputBucket",
         "Permissions":[
            {
               "GranteeType":"Canonical|Email|Group",
               "Grantee":"AWS user ID or CloudFront origin access identity"|
                         "registered email address for AWS account|
                         AllUsers|AuthenticatedUsers|LogDelivery",
               "Access":[
                  "Read|ReadAcp|WriteAcp|FullControl",
                  ...
               ]
            },
            {...}
         ],
         "StorageClass":"Standard|ReducedRedundancy"
      },
      "ThumbnailConfig":{
         "Bucket":"Use this plus ContentConfig:Bucket,
            or use OutputBucket",
         "Permissions":[
            {
               "Access":[
                  "Read|ReadAcp|WriteAcp|FullControl",
                  ...
               ],
               "Grantee":"AWS user ID or CloudFront origin access identity"|
                         "registered email address for AWS account|
                         AllUsers|AuthenticatedUsers|LogDelivery",
               "GranteeType":"Canonical|Email|Group"
            },
            {...}
         ],
         "StorageClass":"Standard|ReducedRedundancy"
      },
      "[Status](#create-pipeline-response-status)":"Active|Paused"
   },
   "[\(Automatic\) Warnings](#create-pipeline-response-warnings)": [
      {
         "[Code](#create-pipeline-response-warning-code)": "6000|6001|6002|6003|6004|6005|6006|6007|6008", 
         "[Message](#create-pipeline-response-warning-message)": "The code message"
      },
      {...}
   ]
}
```

### Response Headers<a name="create-pipeline-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="create-pipeline-response-body"></a>

When you create a pipeline, Elastic Transcoder returns the values that you specified in the request\. For more information, see [Request Body](#create-pipeline-request-body)\.

In addition, Elastic Transcoder returns the following values\.

**\(Automatic\) Id**  
Identifier for the pipeline\. You use this value to identify the pipeline in which you want to perform a variety of operations, for example, creating a job or a preset\. 

**\(Automatic\) Status**  
The current status of the pipeline:  
+ `Active`: The pipeline is processing jobs\.
+ `Paused`: The pipeline is not currently processing jobs\.

#### \(Automatic\) Warnings<a name="create-pipeline-response-warnings"></a>

When you create a pipeline that uses resources in other regions, Elastic Transcoder returns one or more warnings\. Your pipeline is still created, but might have increased processing times and incur cross\-regional charges\. The warnings are in the following format:

**Code** — The warning code\.  
**Message** — the message associated with the warning code\.

The warning codes and messages that can be returned are as follows:

**6000**  
The input bucket and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the input bucket and the pipeline\. 

**6001**  
The ContentConfig bucket and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the ContentConfig bucket and the pipeline\. 

**6002**  
The ThumbnailConfig bucket and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the ThumbnailConfig bucket and the pipeline\. 

**6003**  
The SNS notification topic for progressing events and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the SNS notification topic and the pipeline\.

**6004**  
The SNS notification topic for warning events and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the SNS notification topic and the pipeline\.

**6005**  
The SNS notification topic for completion events and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the SNS notification topic and the pipeline\.

**6006**  
The SNS notification topic for error events and the pipeline are in different regions, which increases processing time for jobs in the pipeline and can incur additional charges\. To decrease processing time and prevent cross\-regional charges, use the same region for the SNS notification topic and the pipeline\. 

**6007**  
The AWS KMS key and ContentConfig bucket specified for this pipeline are in different regions, which causes outputs using s3\-aws\-kms encryption mode to fail\. To use s3\-aws\-kms encryption mode, use the same region for the KMS key and the ContentConfig bucket\. 

**6008**  
The AWS KMS key and ThumbnailConfig bucket specified for this pipeline are in different regions, which causes outputs using s3\-aws\-kms encryption mode to fail\. To use s3\-aws\-kms encryption mode, use the same region for the KMS key and the ThumbnailConfig bucket\. 

## Errors<a name="create-pipeline-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="create-pipeline-examples"></a>

The following example request creates a pipeline named `Default`\.

### Sample Request<a name="create-pipeline-examples-sample-request"></a>

```
POST /2012-09-25/pipelines HTTP/1.1
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
   "Name":"Default",
   "InputBucket":"salesoffice.example.com-source",
   "Role":"arn:aws:iam::123456789012:role/Elastic_Transcoder_Default_Role",
   "AwsKmsKeyArn":"base64-encoded key from KMS",
   "Notifications":{
      "Progressing":"",
      "Complete":"",
      "Warning":"",
      "Error":"arn:aws:sns:us-east-1:111222333444:ET_Errors"
   },
   "ContentConfig":{
      "Bucket":"salesoffice.example.com-public-promos",
      "Permissions":[
         {
            "GranteeType":"Email",
            "Grantee":"marketing-promos@example.com",
            "Access":[
               "FullControl"
            ]
         }
      ],
      "StorageClass":"Standard"
   },
   "ThumbnailConfig":{
      "Bucket":"salesoffice.example.com-public-promos-thumbnails",
      "Permissions":[
         {
            "GranteeType":"Email",
            "Grantee":"marketing-promos@example.com",
            "Access":[
               "FullControl"
            ]
         }
      ],
      "StorageClass":"ReducedRedundancy"
   }
}
```

### Sample Response<a name="create-pipeline-examples-sample-response"></a>

```
Status: 201 Created
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Pipeline":{
     "Id":"1111111111111-abcde1",
     "Name":"Default",
     "InputBucket":"salesoffice.example.com-source",
     "Role":"arn:aws:iam::123456789012:role/Elastic_Transcoder_Default_Role",
     "AwsKmsKeyArn":"base64-encoded key from KMS",
     "Notifications":{
         "Complete":"",
         "Error":"arn:aws:sns:us-east-1:111222333444:ET_Errors",
         "Progressing":"",
         "Warning":""
      },
      "ContentConfig":{
         "Bucket":"salesoffice.example.com-public-promos",
         "Permissions":[
            {
               "GranteeType":"Email",
               "Grantee":"marketing-promos@example.com",
               "Access":[
                  "FullControl"
               ]
            }
         ],
         "StorageClass":"Standard"
      },
      "ThumbnailConfig":{
         "Bucket":"salesoffice.example.com-public-promos-thumbnails",
         "Permissions":[
            {
               "GranteeType":"Email",
               "Grantee":"marketing-promos@example.com",
               "Access":[
                  "FullControl"
               ]
            }
         ],
         "StorageClass":"ReducedRedundancy"
      },
      "Status":"Active"
   },
   "Warnings": [
      {
         "Code": "6000", 
         "Message": "The input bucket and the pipeline are in different 
            regions, which increases processing time for jobs in the 
            pipeline and can incur additional charges. To decrease 
            processing time and prevent cross-regional charges, use the 
            same region for the input bucket and the pipeline."
      },
      {...}
   ]
}
```