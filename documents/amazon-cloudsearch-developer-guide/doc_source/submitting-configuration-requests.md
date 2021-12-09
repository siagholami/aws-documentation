# Submitting Configuration Requests in Amazon CloudSearch<a name="submitting-configuration-requests"></a>

**Important**  
The easiest way to submit configuration requests is to use the Amazon CloudSearch console, Amazon CloudSearch command line tools, or the AWS SDK for Java, JavaScript, \.NET, PHP, Ruby, or Python \(Boto\)\. The command line tools and SDKs handle the signing process for you and ensure that Amazon CloudSearch configuration requests are properly formed\. For more information about the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\. 

 You submit Amazon CloudSearch configuration requests to the Amazon CloudSearch endpoint for your region using the AWS Query protocol\. For the current list of supported regions and endpoints, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#cloudsearch_region)\.

 AWS Query requests are HTTP or HTTPS requests submitted via HTTP GET or POST with a Query parameter named Action\. You must specify the API version in all configuration requests and that version must match the API version specified when the domain was created\. 

Requests submitted to the Configuration API are authenticated using your AWS access key ID and secret access key\. Use IAM user access keys instead of AWS root account access keys\. IAM lets you securely control access to AWS services and resources in your AWS account\. For more information about getting credentials, see [How Do I Get Security Credentials?](https://docs.aws.amazon.com/general/latest/gr/getting-aws-sec-creds.html) in the *AWS General Reference*\. 

You must include authorization parameters and a digital signature in every request\. Amazon CloudSearch supports AWS Signature Version 4\. For detailed signing instructions, see [Signature V4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the AWS General Reference\.

**Note**  
Amazon CloudSearch throttles excessive requests to the configuration service\. Throttling occurs *by action*, so excessive `DescribeDomains` requests don't cause Amazon CloudSearch to throttle `DescribeIndexFields` requests\. The request limit changes based on the needs of the service, but allows many calls to each action per hour\.

## Structure of a Configuration Request<a name="submitting-configuration-requests-structure"></a>

This reference shows Amazon CloudSearch configuration requests as URLs, which can be used directly in a browser\. \(Although the GET requests are shown as URLs, the parameter values are shown unencoded to make them easier to read\. Keep in mind that you must URL encode parameter values when submitting requests\.\) The URL contains three parts:
+ Endpoint—the Web service entry point to act on, `cloudsearch.us-east-1.amazonaws.com`\. 
+ Action—the Amazon CloudSearch configuration action you want to perform\. For a complete list of actions, see [Actions](API_Operations.md)\. 
+ Parameters—any request parameters required for the specified action\. Each query request must also include some common parameters to handle authentication\. For more information, see [Request Authentication](#configuration-request-authentication)\.

You must specify the `Version` parameter in every Amazon CloudSearch configuration request\. The current Amazon CloudSearch API version is 2013\-01\-01\.

For example, the following GET request creates a new search domain called *movies*:

```
https://cloudsearch.us-east-1.amazonaws.com
?Action=CreateDomain
&DomainName=movies
&Version=2013-01-01
&X-Amz-Algorithm=AWS4-HMAC-SHA256
&X-Amz-Credential=AKIAIOSFODNN7EXAMPLE/20120712/us-east-1/cloudsearch/aws4
_request
&X-Amz-Date=2012-07-12T21:41:29.094Z
&X-Amz-SignedHeaders=host
&X-Amz-Signature=c7600a00fea082dac002b247f9d6812f25195fbaf7f0a6fc4ce08a39666c6a10
3c8dcb
```

## Request Authentication<a name="configuration-request-authentication"></a>

Requests submitted to the Configuration API are authenticated using your AWS access keys\. You must include authorization parameters and a digital signature in every request\. Amazon CloudSearch supports AWS Signature Version 4\. For detailed signing instructions, see [Signature V4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the AWS General Reference\.

To create a signature for a request, you create a canonicalized version of the query string and compute an [RFC 2104\-compliant](http://www.ietf.org/rfc/rfc2104.txt) HMAC signature using a signing key derived from your AWS Secret Access key\. 

**Note**  
If you are just getting started signing your own AWS requests, take a look at how the SDKs implement signing\. The source for most of the AWS SDKs is available at [https://github\.com/aws](https://github.com/aws)\.

For example, to construct a `CreateDomain` request, you need the following information:

```
Region name: us-east-1
Service name: cloudsearch
API version: 2013-01-01
Date: 2014-03-12T21:41:29.094Z
Access key: AKIAIOSFODNN7EXAMPLE
Secret key: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
Action: CreateDomain
Action Parameters: DomainName=movies
```

The canonical query string for a `CreateDomain` request looks like this: 

```
Action=CreateDomain
&DomainName=movies
&Version=2013-01-01
&X-Amz-Algorithm=AWS4-HMAC-SHA256
&X-Amz-Credential=AKIAIOSFODNN7EXAMPLE/20120712/us-east-1/cloudsearch/aws4
_request
&X-Amz-Date=2012-07-12T21:41:29.094Z
&X-Amz-SignedHeaders=host
```

The final signed request looks like this: 

```
https://cloudsearch.us-east-1.amazonaws.com
?Action=CreateDomain
&DomainName=movies
&Version=2013-01-01
&X-Amz-Algorithm=AWS4-HMAC-SHA256
&X-Amz-Credential=AKIAIOSFODNN7EXAMPLE/20120712/us-east-1/cloudsearch/aws4
_request
&X-Amz-Date=2014-03-12T21:41:29.094Z
&X-Amz-SignedHeaders=host
&X-Amz-Signature=c7600a00fea082dac002b247f9d6812f25195fbaf7f0a6fc4ce08a39666c6a10
```