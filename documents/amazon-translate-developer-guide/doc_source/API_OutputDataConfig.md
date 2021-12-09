# OutputDataConfig<a name="API_OutputDataConfig"></a>

The output configuration properties for a batch translation job\.

## Contents<a name="API_OutputDataConfig_Contents"></a>

 **S3Uri**   <a name="Translate-Type-OutputDataConfig-S3Uri"></a>
The URI of the S3 folder that contains a translation job's output file\. The folder must be in the same Region as the API endpoint that you are calling\.  
Type: String  
Length Constraints: Maximum length of 1024\.  
Pattern: `s3://[a-z0-9][\.\-a-z0-9]{1,61}[a-z0-9](/.*)?`   
Required: Yes

## See Also<a name="API_OutputDataConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/OutputDataConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/OutputDataConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/OutputDataConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/OutputDataConfig) 