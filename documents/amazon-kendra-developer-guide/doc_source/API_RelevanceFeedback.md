--------

--------

# RelevanceFeedback<a name="API_RelevanceFeedback"></a>

Provides feedback on how relevant a document is to a search\. Your application uses the [SubmitFeedback](API_SubmitFeedback.md) operation to provide relevance information\.

## Contents<a name="API_RelevanceFeedback_Contents"></a>

 **RelevanceValue**   <a name="Kendra-Type-RelevanceFeedback-RelevanceValue"></a>
Whether to document was relevant or not relevant to the search\.  
Type: String  
Valid Values:` RELEVANT | NOT_RELEVANT`   
Required: Yes

 **ResultId**   <a name="Kendra-Type-RelevanceFeedback-ResultId"></a>
The unique identifier of the search result that the user provided relevance feedback for\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 73\.  
Required: Yes

## See Also<a name="API_RelevanceFeedback_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/RelevanceFeedback) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/RelevanceFeedback) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/RelevanceFeedback) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/RelevanceFeedback) 