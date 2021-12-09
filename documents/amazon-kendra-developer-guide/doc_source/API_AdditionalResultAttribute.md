--------

--------

# AdditionalResultAttribute<a name="API_AdditionalResultAttribute"></a>

An attribute returned from an index query\.

## Contents<a name="API_AdditionalResultAttribute_Contents"></a>

 **Key**   <a name="Kendra-Type-AdditionalResultAttribute-Key"></a>
The key that identifies the attribute\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Required: Yes

 **Value**   <a name="Kendra-Type-AdditionalResultAttribute-Value"></a>
An object that contains the attribute value\.  
Type: [AdditionalResultAttributeValue](API_AdditionalResultAttributeValue.md) object  
Required: Yes

 **ValueType**   <a name="Kendra-Type-AdditionalResultAttribute-ValueType"></a>
The data type of the `Value` property\.  
Type: String  
Valid Values:` TEXT_WITH_HIGHLIGHTS_VALUE`   
Required: Yes

## See Also<a name="API_AdditionalResultAttribute_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/AdditionalResultAttribute) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/AdditionalResultAttribute) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/AdditionalResultAttribute) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/AdditionalResultAttribute) 