# InputDataConfig<a name="API_InputDataConfig"></a>

The input configuration properties for requesting a batch translation job\.

## Contents<a name="API_InputDataConfig_Contents"></a>

 **ContentType**   <a name="Translate-Type-InputDataConfig-ContentType"></a>
The multipurpose internet mail extension \(MIME\) type of the input files\. Valid values are `text/plain` for plaintext files and `text/html` for HTML files\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[-\w.]+\/[-\w.+]+$`   
Required: Yes

 **S3Uri**   <a name="Translate-Type-InputDataConfig-S3Uri"></a>
The URI of the AWS S3 folder that contains the input file\. The folder must be in the same Region as the API endpoint you are calling\.  
Type: String  
Length Constraints: Maximum length of 1024\.  
Pattern: `s3://[a-z0-9][\.\-a-z0-9]{1,61}[a-z0-9](/.*)?`   
Required: Yes

## See Also<a name="API_InputDataConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/InputDataConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/InputDataConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/InputDataConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/InputDataConfig) 