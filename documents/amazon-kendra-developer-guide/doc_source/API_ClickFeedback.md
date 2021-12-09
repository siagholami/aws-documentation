--------

--------

# ClickFeedback<a name="API_ClickFeedback"></a>

Gathers information about when a particular result was clicked by a user\. Your application uses the [SubmitFeedback](API_SubmitFeedback.md) operation to provide click information\.

## Contents<a name="API_ClickFeedback_Contents"></a>

 **ClickTime**   <a name="Kendra-Type-ClickFeedback-ClickTime"></a>
The Unix timestamp of the date and time that the result was clicked\.  
Type: Timestamp  
Required: Yes

 **ResultId**   <a name="Kendra-Type-ClickFeedback-ResultId"></a>
The unique identifier of the search result that was clicked\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 73\.  
Required: Yes

## See Also<a name="API_ClickFeedback_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ClickFeedback) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ClickFeedback) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ClickFeedback) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ClickFeedback) 