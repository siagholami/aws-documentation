# EncryptionConfig<a name="API_EncryptionConfig"></a>

An AWS Key Management Service \(KMS\) key and an AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the key\. You can specify this optional object in the [CreateDataset](API_CreateDataset.md) and [CreatePredictor](API_CreatePredictor.md) requests\.

## Contents<a name="API_EncryptionConfig_Contents"></a>

 **KMSKeyArn**   <a name="forecast-Type-EncryptionConfig-KMSKeyArn"></a>
The Amazon Resource Name \(ARN\) of the KMS key\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:aws:kms:.*:key/.*`   
Required: Yes

 **RoleArn**   <a name="forecast-Type-EncryptionConfig-RoleArn"></a>
The ARN of the IAM role that Amazon Forecast can assume to access the AWS KMS key\.  
Passing a role across AWS accounts is not allowed\. If you pass a role that isn't in your account, you get an `InvalidInputException` error\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## See Also<a name="API_EncryptionConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/EncryptionConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/EncryptionConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/EncryptionConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/EncryptionConfig) 