# List Pipelines<a name="list-pipelines"></a>

**Topics**
+ [Description](#list-pipelines-description)
+ [Requests](#list-pipelines-requests)
+ [Responses](#list-pipelines-responses)
+ [Errors](#list-pipelines-response-errors)
+ [Examples](#list-pipelines-examples)

## Description<a name="list-pipelines-description"></a>

To get a list of the pipelines associated with the current AWS account, send a GET request to the `/2012-09-25/pipelines/` resource\.

## Requests<a name="list-pipelines-requests"></a>

### Syntax<a name="list-pipelines-request-syntax"></a>

To get information about all of the pipelines associated with the current AWS account, send the following GET request\. 

```
GET /2012-09-25/pipelines/[Ascending](#list-pipelines-request-ascending)=true|false&
[PageToken](#list-pipelines-request-pageToken)=value for accessing the next page of results HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Request Parameters<a name="list-pipelines-request-parameters"></a>

This operation takes the following request parameters\. Elastic Transcoder returns all of the pipelines\.

**Ascending**  
To list pipelines in chronological order by the date and time that they were submitted, enter `true`\. To list pipelines in reverse chronological order, enter `false`\.

**PageToken**  
When Elastic Transcoder returns more than one page of results, use `PageToken` in subsequent `GET` requests to get each successive page of results\.

### Request Headers<a name="list-pipelines-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="list-pipelines-request-body"></a>

This operation does not have a request body\.

## Responses<a name="list-pipelines-responses"></a>

### Syntax<a name="list-pipelines-response-syntax"></a>

```
Status: 200 OK
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Pipelines":[
      {
         "[Id](#list-pipelines-response-id)":"Id for the new pipeline",
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
         },
         "[Status](get-pipeline.md#get-pipeline-response-status)":"Active|Paused"
      },
      {...}
   ],
   "[NextPageToken](#list-pipelines-response-next-page-token)":value for accessing the next page of results|null
}
```

### Response Headers<a name="list-pipelines-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="list-pipelines-response-body"></a>

The JSON string in the response body returns the values that you specified when you created the pipelines\. For more detail about the individual objects, see [Settings that You Specify When You Create an Elastic Transcoder Pipeline](pipeline-settings.md)\.

In addition, Elastic Transcoder returns the following values\.

**\(Automatic\) Id**  
Identifier for the pipeline\. You use this value to identify the pipeline in which you want to perform a variety of operations, for example, creating a job or a preset\. 

**\(Automatic\) Status**  
The current status of the pipeline:  
+ `Active`: The pipeline is processing jobs\.
+ `Paused`: The pipeline is not currently processing jobs\.

**\(Automatic\) NextPageToken**  
A value that you use to access the second and subsequent pages of results, if any\. When the pipelines fit on one page or when you've reached the last page of results, the value of `NextPageToken` is `null`\.

## Errors<a name="list-pipelines-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="list-pipelines-examples"></a>

The following example request gets a list of the pipelines associated with the current AWS account\.

### Sample Request<a name="list-pipelines-examples-sample-request"></a>

```
GET /2012-09-25/pipelines HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Sample Response<a name="list-pipelines-examples-sample-response"></a>

```
Status: 200 OK
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT
{
   "Pipelines":[
      {
         "Id":"1111111111111-abcde1",
         "Name":"Tokyo-Default",
         "InputBucket":"salesoffice-tokyo.example.com-source",
         "OutputBucket":"salesoffice-tokyo.example.com-output",
         "Role":"arn:aws:iam::123456789012:role/Elastic_Transcoder_Default
            _Role",
         "AwsKmsKeyArn":"base64 encoded key from KMS",
         "Notifications":{
            "Progressing":"",
            "Complete":"",
            "Warning":"",
            "Error":"arn:aws:sns:us-east-1:111222333444:ETS_Errors"
         },
         "ContentConfig":{
            "Bucket":"salesoffice-tokyo.example.com-public-promos",
            "Permissions":[
               {
                  "GranteeType":"Email",
                  "Grantee":"marketing-promos-tokyo@example.com",
                  "Access":[
                     "FullControl"
                  ]
               }
            ],
            "StorageClass":"Standard"
         },
         "ThumbnailConfig":{
            "Bucket":"salesoffice-tokyo.example.com-public-promos-
               thumbnails",
            "Permissions":[
               {
                  "GranteeType":"Email",
                  "Grantee":"marketing-promos-tokyo@example.com",
                  "Access":[
                     "FullControl"
                  ]
               }
            ],
            "StorageClass":"ReducedRedundancy"
         },
         "Status":"Active"
      },
      {
         "Id":"2222222222222-abcde2",
         "Name":"Amsterdam-Default",
         "InputBucket":"salesoffice-amsterdam.example.com-source",
         "OutputBucket":"salesoffice-amsterdam.example.com-output",
         "Role":"arn:aws:iam::123456789012:role/Elastic_Transcoder_Default
            _Role",
         "AwsKmsKeyArn":"base64 encoded key from KMS",
         "Notifications":{
            "Progressing":"",
            "Complete":"",
            "Warning":"",
            "Error":"arn:aws:sns:us-east-1:111222333444:ETS_Errors"
         },
         "ContentConfig":{
            "Bucket":"salesoffice-amsterdam.example.com-public-promos",
            "Permissions":[
               {
                  "GranteeType":"Email",
                  "Grantee":"marketing-promos-amsterdam@example.com",
                  "Access":[
                     "FullControl"
                  ]
               }
            ],
            "StorageClass":"Standard"
         },
         "ThumbnailConfig":{
            "Bucket":"salesoffice-amsterdam.example.com-public-promos-
               thumbnails",
            "Permissions":[
               {
                  "GranteeType":"Email",
                  "Grantee":"marketing-promos-amsterdam@example.com",
                  "Access":[
                     "FullControl"
                  ]
               }
            ],
            "StorageClass":"ReducedRedundancy"
         },
         "Status":"Active"
      }
   ]
}
```