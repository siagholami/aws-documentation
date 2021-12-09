# S3Object<a name="API_S3Object"></a>

Information about an S3 object\.

## Contents<a name="API_S3Object_Contents"></a>

 **bucket**   <a name="robomaker-Type-S3Object-bucket"></a>
The bucket containing the object\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][a-z0-9.\-]*[a-z0-9]`   
Required: Yes

 **etag**   <a name="robomaker-Type-S3Object-etag"></a>
The etag of the object\.  
Type: String  
Required: No

 **key**   <a name="robomaker-Type-S3Object-key"></a>
The key of the object\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `.*`   
Required: Yes

## See Also<a name="API_S3Object_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/S3Object) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/S3Object) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/S3Object) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/S3Object) 