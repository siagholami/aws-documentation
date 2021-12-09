# TerminologyData<a name="API_TerminologyData"></a>

The data associated with the custom terminology\.

## Contents<a name="API_TerminologyData_Contents"></a>

 **File**   <a name="Translate-Type-TerminologyData-File"></a>
The file containing the custom terminology data\. Your version of the AWS SDK performs a Base64\-encoding on this field before sending a request to the AWS service\. Users of the SDK should not perform Base64\-encoding themselves\.  
Type: Base64\-encoded binary data object  
Length Constraints: Maximum length of 10485760\.  
Required: Yes

 **Format**   <a name="Translate-Type-TerminologyData-Format"></a>
The data format of the custom terminology\. Either CSV or TMX\.  
Type: String  
Valid Values:` CSV | TMX`   
Required: Yes

## See Also<a name="API_TerminologyData_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/TerminologyData) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/TerminologyData) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/TerminologyData) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/TerminologyData) 