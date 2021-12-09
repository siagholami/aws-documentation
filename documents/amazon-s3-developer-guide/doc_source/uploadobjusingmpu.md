# Uploading objects using multipart upload API<a name="uploadobjusingmpu"></a>

Multipart upload allows you to upload a single object as a set of parts\. Each part is a contiguous portion of the object's data\. You can upload these object parts independently and in any order\. If transmission of any part fails, you can retransmit that part without affecting other parts\. After all parts of your object are uploaded, Amazon S3 assembles these parts and creates the object\. In general, when your object size reaches 100 MB, you should consider using multipart uploads instead of uploading the object in a single operation\.

Using multipart upload provides the following advantages:
+  Improved throughput \- You can upload parts in parallel to improve throughput\. 
+ Quick recovery from any network issues \- Smaller part size minimizes the impact of restarting a failed upload due to a network error\.
+ Pause and resume object uploads \- You can upload object parts over time\. Once you initiate a multipart upload there is no expiry; you must explicitly complete or stop the multipart upload\.
+ Begin an upload before you know the final object size \- You can upload an object as you are creating it\. 

**Topics**
+ [Multipart upload overview](mpuoverview.md)
+ [Using the AWS Java SDK for multipart upload \(high\-level API\)](usingHLmpuJava.md)
+ [Using the AWS Java SDK for a multipart upload \(low\-level API\)](mpListPartsJavaAPI.md)
+ [Using the AWS SDK for \.NET for multipart upload \(high\-level API\)](usingHLmpuDotNet.md)
+ [Using the AWS SDK for \.NET for multipart upload \(low\-level API\)](usingLLmpuDotNet.md)
+ [Using the AWS PHP SDK for multipart upload](usingHLmpuPHP.md)
+ [Using the AWS PHP SDK for multipart upload \(low\-level API\)](usingLLmpuPHP.md)
+ [Using the AWS SDK for Ruby for Multipart Upload](uploadobjusingmpu-ruby-sdk.md)
+ [Using the REST API for multipart upload](UsingRESTAPImpUpload.md)
+ [Using the AWS Command Line Interface for multipart upload](UsingCLImpUpload.md)
+ [ Using the AWS SDK for JavaScript in Node\.js for Multipart Upload](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/S3.html#createMultipartUpload-property)