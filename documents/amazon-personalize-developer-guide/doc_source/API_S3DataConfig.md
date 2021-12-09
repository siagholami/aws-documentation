# S3DataConfig<a name="API_S3DataConfig"></a>

The configuration details of an Amazon S3 input or output bucket\.

## Contents<a name="API_S3DataConfig_Contents"></a>

 **kmsKeyArn**   <a name="personalize-Type-S3DataConfig-kmsKeyArn"></a>
The Amazon Resource Name \(ARN\) of the Amazon Key Management Service \(KMS\) key that Amazon Personalize uses to encrypt or decrypt the input and output files of a batch inference job\.  
Type: String  
Required: No

 **path**   <a name="personalize-Type-S3DataConfig-path"></a>
The file path of the Amazon S3 bucket\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: Yes

## See Also<a name="API_S3DataConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/S3DataConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/S3DataConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/S3DataConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/S3DataConfig) 