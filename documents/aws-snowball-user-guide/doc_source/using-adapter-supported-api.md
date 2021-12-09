--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Supported REST API Actions<a name="using-adapter-supported-api"></a>

Following, you can find REST API actions that you can use with the Snowball\.

**Topics**
+ [Supported REST API Actions for Snowball](#using-adapter-snowball-api)
+ [Supported REST API Actions for Amazon S3](#using-adapter-s3api)

## Supported REST API Actions for Snowball<a name="using-adapter-snowball-api"></a>

### HEAD Snowball<a name="adapter-snowball-head-api"></a>

#### Description<a name="adapter-snowball-head-api-description"></a>

Currently, there's only one Snowball REST API operation, which can be used to return status information for a specific device\. This operation returns the status of a Snowball\. This status includes information that can be used by AWS Support for troubleshooting purposes\.

You can't use this operation with the AWS SDKs or the AWS CLI\. We recommend that you use `curl` or an HTTP client\. The request doesn't need to be signed for this operation\.

#### Request<a name="adapter-snowball-head-api-request"></a>

In the below example, the IP address for the Snowball is 192\.0\.2\.0\. Replace this value with the IP address of your actual device\.

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

Following, you can find the list of Amazon S3 REST API actions that are supported for using the Amazon S3 Adapter for Snowball\. The list includes links to information about how the API actions work with Amazon S3\. The list also covers any differences in behavior between the Amazon S3 API action and the Snowball counterpart\. All responses coming back from a Snowball declare `Server` as `AWSSnowball`, as in the following example\.

```
HTTP/1.1 200 OK
x-amz-id-2: JuKZqmXuiwFeDQxhD7M8KtsKobSzWA1QEjLbTMTagkKdBX2z7Il/jGhDeJ3j6s80
x-amz-request-id: 32FE2CEB32F5EE25
Date: Fri, 08 2016 21:34:56 GMT
Server: AWSSnowball
```
+ [GET Bucket \(List Objects\) version 1](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketGET.html)  – In this implementation of the GET operation, the following is true:
  + Pagination is not supported\.
  + Markers are not supported\.
  + Delimiters are not supported\.
  + When the list is returned, the list is not sorted\.
  + Only version 1 is supported\. GET Bucket \(List Objects\) Version 2 is not supported\.
  + The Snowball adapter is not optimized for large list operations\. For example, you might have a case with over a million objects per folder where you want to list the objects after you transfer them to the device\. In this type of case, we recommend that you order a Snowball Edge for your job instead\.
+ [GET Service](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTServiceGET.html) 
+ [HEAD Bucket](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketHEAD.html) 
+ [HEAD Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectHEAD.html)  
+ [GET Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectGET.html) – When an object is uploaded to a Snowball using `GET Object`, an entity tag \(ETag\) is not generated unless the object was uploaded using multipart upload\. The ETag is a hash of the object\. The ETag reflects changes only to the contents of an object, not its metadata\. The ETag might or might not be an MD5 digest of the object data\. For more information on ETags, see [Common Response Headers](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTCommonResponseHeaders.html) in the* Amazon Simple Storage Service API Reference\.*
+ [PUT Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectPUT.html) – When an object is uploaded to a Snowball using `PUT Object`, an ETag is not generated unless the object was uploaded using multipart upload\.
+ [DELETE Object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectDELETE.html) 
+ [Initiate Multipart Upload](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadInitiate.html) – In this implementation, initiating a multipart upload request for an object already on the Snowball first deletes that object and then copies it in parts to the Snowball\. 
+ [List Multipart Uploads](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadListMPUpload.html)  
+ [Upload Part](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadUploadPart.html)  
+ [Complete Multipart Upload](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadComplete.html)  
+ [Abort Multipart Upload](https://docs.aws.amazon.com/AmazonS3/latest/API/mpUploadAbort.html)  

**Note**  
Any Amazon S3 REST API actions not listed here are not supported\. Using any unsupported REST API actions with your Snowball Edge returns an error message saying that the action is not supported\.