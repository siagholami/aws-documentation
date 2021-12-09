# TerminologyProperties<a name="API_TerminologyProperties"></a>

The properties of the custom terminology\.

## Contents<a name="API_TerminologyProperties_Contents"></a>

 **Arn**   <a name="Translate-Type-TerminologyProperties-Arn"></a>
 The Amazon Resource Name \(ARN\) of the custom terminology\.   
Type: String  
Pattern: `^arn:aws((-us-gov)|(-iso)|(-iso-b)|(-cn))?:translate:[a-zA-Z0-9-]+:[0-9]{12}:terminology/.+?/.+?$`   
Required: No

 **CreatedAt**   <a name="Translate-Type-TerminologyProperties-CreatedAt"></a>
The time at which the custom terminology was created, based on the timestamp\.  
Type: Timestamp  
Required: No

 **Description**   <a name="Translate-Type-TerminologyProperties-Description"></a>
The description of the custom terminology properties\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `[\P{M}\p{M}]{0,256}`   
Required: No

 **EncryptionKey**   <a name="Translate-Type-TerminologyProperties-EncryptionKey"></a>
The encryption key for the custom terminology\.  
Type: [EncryptionKey](API_EncryptionKey.md) object  
Required: No

 **LastUpdatedAt**   <a name="Translate-Type-TerminologyProperties-LastUpdatedAt"></a>
The time at which the custom terminology was last update, based on the timestamp\.  
Type: Timestamp  
Required: No

 **Name**   <a name="Translate-Type-TerminologyProperties-Name"></a>
The name of the custom terminology\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `^([A-Za-z0-9-]_?)+$`   
Required: No

 **SizeBytes**   <a name="Translate-Type-TerminologyProperties-SizeBytes"></a>
The size of the file used when importing a custom terminology\.  
Type: Integer  
Required: No

 **SourceLanguageCode**   <a name="Translate-Type-TerminologyProperties-SourceLanguageCode"></a>
The language code for the source text of the translation request for which the custom terminology is being used\.  
Type: String  
Length Constraints: Minimum length of 2\. Maximum length of 5\.  
Required: No

 **TargetLanguageCodes**   <a name="Translate-Type-TerminologyProperties-TargetLanguageCodes"></a>
The language codes for the target languages available with the custom terminology file\. All possible target languages are returned in array\.  
Type: Array of strings  
Length Constraints: Minimum length of 2\. Maximum length of 5\.  
Required: No

 **TermCount**   <a name="Translate-Type-TerminologyProperties-TermCount"></a>
The number of terms included in the custom terminology\.  
Type: Integer  
Required: No

## See Also<a name="API_TerminologyProperties_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/TerminologyProperties) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/TerminologyProperties) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/TerminologyProperties) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/TerminologyProperties) 