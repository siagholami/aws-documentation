# AppliedTerminology<a name="API_AppliedTerminology"></a>

The custom terminology applied to the input text by Amazon Translate for the translated text response\. This is optional in the response and will only be present if you specified terminology input in the request\. Currently, only one terminology can be applied per TranslateText request\.

## Contents<a name="API_AppliedTerminology_Contents"></a>

 **Name**   <a name="Translate-Type-AppliedTerminology-Name"></a>
The name of the custom terminology applied to the input text by Amazon Translate for the translated text response\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `^([A-Za-z0-9-]_?)+$`   
Required: No

 **Terms**   <a name="Translate-Type-AppliedTerminology-Terms"></a>
The specific terms of the custom terminology applied to the input text by Amazon Translate for the translated text response\. A maximum of 250 terms will be returned, and the specific terms applied will be the first 250 terms in the source text\.   
Type: Array of [Term](API_Term.md) objects  
Required: No

## See Also<a name="API_AppliedTerminology_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/AppliedTerminology) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/AppliedTerminology) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/AppliedTerminology) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/AppliedTerminology) 