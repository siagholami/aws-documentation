# Source<a name="API_Source"></a>

Information about a source\.

## Contents<a name="API_Source_Contents"></a>

 **architecture**   <a name="robomaker-Type-Source-architecture"></a>
The taget processor architecture for the application\.  
Type: String  
Valid Values:` X86_64 | ARM64 | ARMHF`   
Required: No

 **etag**   <a name="robomaker-Type-Source-etag"></a>
A hash of the object specified by `s3Bucket` and `s3Key`\.  
Type: String  
Required: No

 **s3Bucket**   <a name="robomaker-Type-Source-s3Bucket"></a>
The s3 bucket name\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][a-z0-9.\-]*[a-z0-9]`   
Required: No

 **s3Key**   <a name="robomaker-Type-Source-s3Key"></a>
The s3 object key\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `.*`   
Required: No

## See Also<a name="API_Source_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/Source) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/Source) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/Source) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/Source) 