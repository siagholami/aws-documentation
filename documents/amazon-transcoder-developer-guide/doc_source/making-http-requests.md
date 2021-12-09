# Making HTTP Requests to Elastic Transcoder<a name="making-http-requests"></a>

Elastic Transcoder REST requests are HTTPS requests as defined in RFC 2616\. \(For more information, go to [http://www\.ietf\.org/rfc/rfc2616\.txt](http://www.ietf.org/rfc/rfc2616.txt)\.\) This section describes the structure of an Elastic Transcoder REST request\. For detailed descriptions of the actions that you can perform, see [Pipeline Operations](operations-pipelines.md), [Job Operations](operations-jobs.md), and [Preset Operations](operations-presets.md)\.

A typical REST action consists of sending an HTTPS request to Elastic Transcoder and waiting for the response\. Like any HTTP request, a REST request to Elastic Transcoder contains a request method, a URI, request headers, and sometimes a query string or request body\. The response contains an HTTP status code, response headers, and sometimes a response body\.

**Topics**
+ [HTTP Header Contents](#http-request-header)
+ [HTTP Request Body](#http-request-body)
+ [HTTP Responses](#http-response-header)

## HTTP Header Contents<a name="http-request-header"></a>

Elastic Transcoder requires the following information in the header of an HTTP request:

**Host \(Required\)**  
The Elastic Transcoder endpoint that specifies where your resources are created\. The value must be a named regional endpoint\. We recommend that you use the same endpoint for your Amazon S3 buckets and for your Elastic Transcoder pipelines and jobs\. If you use different endpoints, you'll incur additional charges for data transferred between the region that contains your Amazon S3 buckets and the region in which Elastic Transcoder does the encoding\. In addition, the time required for the data transfer will delay access to the transcoded file\.  
For a list of supported Elastic Transcoder endpoints, go to the [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#elastictranscoder_region) section in the *Amazon Web Services General Reference*\.  
For more information on cross\-regional fees, see Data Transfer Pricing in [Amazon S3 Pricing](http://aws.amazon.com/s3/pricing/)\.

**x\-amz\-date or Date \(Required\)**  
The date used to create the signature contained in the `Authorization` header\. Specify the date in ISO 8601 standard format, in UTC time, as in the following example: `X-Amz-Date: 20130613T203622Z`\.  
You must include either `x-amz-date` or `Date`\. \(Some HTTP client libraries don't let you set the `Date` header\)\. When an `x-amz-date` header is present, the system ignores any `Date` header when authenticating the request\.  
The time stamp must be within 15 minutes of the AWS system time when the request is received\. If it isn't, the request fails with the `RequestExpired` error code to prevent someone else from replaying your requests\. 

**Authorization \(Required\)**  
The information required for request authentication\. For more information about constructing this header, see [Signing Requests](signing-requests.md)\.

**Content\-Type \(Conditional\)**  
Specifies JSON and the version, for example, `Content-Type: application/x-amz-json-1.0`\.  
Condition: Required for POST requests\.

**Content\-Length \(Conditional\)**  
Length of the message \(without the headers\) according to RFC 2616\.  
Condition: Required if the request body itself contains information \(most toolkits add this header automatically\)\.

The following is an example header for an HTTP request to create a pipeline\.

```
POST /2012-09-25/pipelines HTTP/1.1
host: elastictranscoder.us-east-1.amazonaws.com:443
x-amz-date: 20120116T174952Z
Authorization: AWS4-HMAC-SHA256 Credential=AccessKeyID/20120116/us-east-1/elastictranscoder/aws4_request,SignedHeaders=host;x-amz-date;x-amz-target,Signature=145b1567ab3c50d929412f28f52c45dbf1e63ec5c66023d232a539a4afd11fd9
content-type: application/x-amz-json-1.0
content-length: 231
connection: Keep-Alive
```

## HTTP Request Body<a name="http-request-body"></a>

Many Elastic Transcoder API actions require you to include JSON\-formatted data in the body of the request\. The JSON conforms to the Elastic Transcoder schema\.

**Note**  
JSON values in the request body are strings\. 

**Example Request**  
The following example request uses a simple JSON statement to create a job that transcodes a file named `sample.mp4` and saves it as `sams-birthday.mp4`\.  

```
POST /2012-09-25/jobs HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.us-east-1.amazonaws.com:443
Content-Length: 300
 
{
   "Input":{
      "Key":"sample.mp4",
      "FrameRate":"auto",
      "Resolution":"auto",
      "AspectRatio":"auto",
      "Interlaced":"auto",
      "Container":"mp4"
   },
   "OutputKeyPrefix":"family-videos/",
   "Outputs":[
      {
         "Key":"sams-birthday.mp4",
         "ThumbnailPattern":"thumbnails/sams-birthday-{count}",
         "Rotate":"0",
         "PresetId":"1351620000000-100080"
      }
   ],
   "PipelineId":"1111111111111-abcde1"
}
```

## HTTP Responses<a name="http-response-header"></a>

All Elastic Transcoder API actions include JSON\-formatted data in the response\. The JSON conforms to the Elastic Transcoder schema\.

**Note**  
JSON values in the response are strings\. 

Here are some important headers in the HTTP response and how you should handle them in your application, if applicable:

**HTTP/1\.1**  
This header is followed by a status code\. Status code `200` indicates a successful operation\. For information about error codes, see [API Error Codes \(Client and Server Errors\)](error-handling.md#api-error-codes)\.  
Type: String

**x\-amzn\-RequestId**  
A value created by Elastic Transcoder that uniquely identifies your request, for example, K2QH8DNOU907N97FNA2GDLL8OBVV4KQNSO5AEMVJF66Q9ASUAAJG\. If you have a problem with Elastic Transcoder, AWS can use this value to troubleshoot the problem\. We recommend that you log these values\.  
Type: String

**Content\-Length**  
The length of the response body in bytes\.  
Type: String

**Date**  
The date and time that Elastic Transcoder responded, for example, `Sun, 25 Mar 2012 12:00:00 GMT`\. The format of the date must be one of the full date formats specified by RFC 2616, section 3\.3\.   
Type: String