# EncryptionKey<a name="API_EncryptionKey"></a>

The encryption key used to encrypt the custom terminologies used by Amazon Translate\.

## Contents<a name="API_EncryptionKey_Contents"></a>

 **Id**   <a name="Translate-Type-EncryptionKey-Id"></a>
The Amazon Resource Name \(ARN\) of the encryption key being used to encrypt the custom terminology\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 400\.  
Pattern: `(arn:aws((-us-gov)|(-iso)|(-iso-b)|(-cn))?:kms:)?([a-z]{2}-[a-z]+(-[a-z]+)?-\d:)?(\d{12}:)?(((key/)?[a-zA-Z0-9-_]+)|(alias/[a-zA-Z0-9:/_-]+))`   
Required: Yes

 **Type**   <a name="Translate-Type-EncryptionKey-Type"></a>
The type of encryption key used by Amazon Translate to encrypt custom terminologies\.  
Type: String  
Valid Values:` KMS`   
Required: Yes

## See Also<a name="API_EncryptionKey_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/EncryptionKey) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/EncryptionKey) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/EncryptionKey) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/EncryptionKey) 