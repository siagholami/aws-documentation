# SourceConfig<a name="API_SourceConfig"></a>

Information about a source configuration\.

## Contents<a name="API_SourceConfig_Contents"></a>

 **architecture**   <a name="robomaker-Type-SourceConfig-architecture"></a>
The target processor architecture for the application\.  
Type: String  
Valid Values:` X86_64 | ARM64 | ARMHF`   
Required: No

 **s3Bucket**   <a name="robomaker-Type-SourceConfig-s3Bucket"></a>
The Amazon S3 bucket name\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][a-z0-9.\-]*[a-z0-9]`   
Required: No

 **s3Key**   <a name="robomaker-Type-SourceConfig-s3Key"></a>
The s3 object key\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `.*`   
Required: No

## See Also<a name="API_SourceConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/SourceConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/SourceConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/SourceConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/SourceConfig) 