--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Supported REST API Actions<a name="using-adapter-supported-api"></a>

Following, you can find REST API actions that you can use with a Snowball Edge\.

**Topics**
+ [Supported REST API Actions for Snowball Edge](#using-adapter-snowball-api)
+ [Supported REST API Actions for Amazon S3](#using-adapter-s3api)

## Supported REST API Actions for Snowball Edge<a name="using-adapter-snowball-api"></a>

### HEAD Snowball Edge<a name="adapter-snowball-head-api"></a>

#### Description<a name="adapter-snowball-head-api-description"></a>

Currently, there's only one Snowball Edge REST API operation, which you can use to return status information for a specific device\. This operation returns the status of a Snowball Edge\. This status includes information that can be used by AWS Support for troubleshooting purposes\.

You can't use this operation with the AWS SDKs or the AWS CLI\. We recommend that you use `curl` or an HTTP client\. The request doesn't need to be signed for this operation\.

#### Request<a name="adapter-snowball-head-api-request"></a>

In the following example, the IP address for the Snowball Edge is 192\.0\.2\.0\. Replace this value with the IP address of your actual device\.

```
curl -X HEAD http://192.0.2.0:8080
```

#### Response<a name="adapter-snowball-head-api-response"></a>

```
<Status xsi:schemaLocation="http://s3.amazonaws.com/doc/2006-03-01/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <snowballIp>127.0.0.1</snowballIp>
    <snowballPort>8080</snowballPort>
    <snowballId>device-id</snowballId>
    <totalSpaceInBytes>499055067136</totalSpaceInBytes>
    <freeSpaceInBytes>108367699968</freeSpaceInBytes>
    <jobId>job-id</jobId>
    <snowballServerVersion>1.0.1</snowballServerVersion>
    <snowballServerBuild>DevBuild</snowballServerBuild>
    <snowballClientVersion>Version 1.0</snowballClientVersion>
    <snowballRoundTripLatencyInMillis>33</snowballRoundTripLatencyInMillis>
</Status>
```

## Supported REST API Actions for Amazon S3<a name="using-adapter-s3api"></a>

Following, you can find the list of Amazon S3 REST API actions that are supported for using the Amazon S3 Adapter for Snowball\. The list includes links to information about how the API actions work with Amazon S3\. The list also covers any differences in behavior between the Amazon S3 API action and the AWS Snowball Edge device counterpart\. All responses coming back from an AWS Snowball Edge device declare `Server` as `AWSSnowball`, as in the following example\.

```
HTTP/1.1 200 OK
x-amz-id-2: JuKZqmXuiwFeDQxhD7M8KtsKobSzWA1QEjLbTMTagkKdBX2z7Il/jGhDeJ3j6s80
x-amz-request-id: 32FE2CEB32F5EE25
Date: Fri, 08 2016 21:34:56 GMT
Server: AWSSnowball
```

Amazon S3 REST API calls require SigV4 signing\. If you're using the AWS CLI or an AWS SDK to make these API calls, the SigV4 signing is handled for you\. Otherwise, you need to implement your own SigV4 signing solution\. For more information, see [Authenticating Requests \(AWS Signature Version 4\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/sig-v4-authenticating-requests.html) in the *Amazon Simple Storage Service Developer Guide\.*
+ [GET Bucket \(List Objects\) version 1](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketGET.html)  – Supported\. However, the only supported delimiter is a forward slash\. Only version 1 is supported\. GET Bucket \(List Objects\) version 2 is not supported\.
+ [GET Service](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTServiceGET.html) 
+ [HEAD Bucket](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketHEAD.html) 
+ [HEAD Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectHEAD.html)  
+ [GET Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectGET.html) – When an object is uploaded to an AWS Snowball Edge device using `GET Object`, an entity tag \(ETag\) is not generated unless the object was uploaded using multipart upload\. The ETag is a hash of the object\. The ETag reflects changes only to the contents of an object, not its metadata\. The ETag might or might not be an MD5 digest of the object data\. For more information on ETags, see [Common Response Headers](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTCommonResponseHeaders.html) in the *Amazon Simple Storage Service API Reference\.*
+ [PUT Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectPUT.html) – When an object is uploaded to an AWS Snowball Edge device using `PUT Object`, an ETag is not generated unless the object was uploaded using multipart upload\.
+ [DELETE Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectDELETE.html) 
+ [Initiate Multipart Upload](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadInitiate.html) – In this implementation, initiating a multipart upload request for an object already on the AWS Snowball Edge device first deletes that object\. It then copies it in parts to the AWS Snowball Edge device\. 
+ [List Multipart Uploads](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadListMPUpload.html)  
+ [Upload Part](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadUploadPart.html)  
+ [Complete Multipart Upload](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadComplete.html)  
+ [Abort Multipart Upload](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadAbort.html)  

**Note**  
Any Amazon S3 REST API actions not listed here are not supported\. Using any unsupported REST API actions with your Snowball Edge returns an error message saying that the action is not supported\.