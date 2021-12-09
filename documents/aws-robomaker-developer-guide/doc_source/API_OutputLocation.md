# OutputLocation<a name="API_OutputLocation"></a>

The output location\.

## Contents<a name="API_OutputLocation_Contents"></a>

 **s3Bucket**   <a name="robomaker-Type-OutputLocation-s3Bucket"></a>
The S3 bucket for output\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][a-z0-9.\-]*[a-z0-9]`   
Required: No

 **s3Prefix**   <a name="robomaker-Type-OutputLocation-s3Prefix"></a>
The S3 folder in the `s3Bucket` where output files will be placed\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `.*`   
Required: No

## See Also<a name="API_OutputLocation_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/OutputLocation) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/OutputLocation) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/OutputLocation) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/OutputLocation) 