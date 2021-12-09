--------

--------

# FaqSummary<a name="API_FaqSummary"></a>

Provides information about a frequently asked questions and answer contained in an index\.

## Contents<a name="API_FaqSummary_Contents"></a>

 **CreatedAt**   <a name="Kendra-Type-FaqSummary-CreatedAt"></a>
The UNIX datetime that the FAQ was added to the index\.  
Type: Timestamp  
Required: No

 **Id**   <a name="Kendra-Type-FaqSummary-Id"></a>
The unique identifier of the FAQ\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: No

 **Name**   <a name="Kendra-Type-FaqSummary-Name"></a>
The name that you assigned the FAQ when you created or updated the FAQ\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: No

 **Status**   <a name="Kendra-Type-FaqSummary-Status"></a>
The current status of the FAQ\. When the status is `ACTIVE` the FAQ is ready for use\.  
Type: String  
Valid Values:` CREATING | UPDATING | ACTIVE | DELETING | FAILED`   
Required: No

 **UpdatedAt**   <a name="Kendra-Type-FaqSummary-UpdatedAt"></a>
The UNIX datetime that the FAQ was last updated\.  
Type: Timestamp  
Required: No

## See Also<a name="API_FaqSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/FaqSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/FaqSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/FaqSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/FaqSummary) 