--------

--------

# SubmitFeedback<a name="API_SubmitFeedback"></a>

Enables you to provide feedback to Amazon Kendra to improve the performance of the service\. 

## Request Syntax<a name="API_SubmitFeedback_RequestSyntax"></a>

```
{
   "ClickFeedbackItems": [ 
      { 
         "ClickTime": number,
         "ResultId": "string"
      }
   ],
   "IndexId": "string",
   "QueryId": "string",
   "RelevanceFeedbackItems": [ 
      { 
         "RelevanceValue": "string",
         "ResultId": "string"
      }
   ]
}
```

## Request Parameters<a name="API_SubmitFeedback_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [ClickFeedbackItems](#API_SubmitFeedback_RequestSyntax) **   <a name="Kendra-SubmitFeedback-request-ClickFeedbackItems"></a>
Tells Amazon Kendra that a particular search result link was chosen by the user\.   
Type: Array of [ClickFeedback](API_ClickFeedback.md) objects  
Required: No

 ** [IndexId](#API_SubmitFeedback_RequestSyntax) **   <a name="Kendra-SubmitFeedback-request-IndexId"></a>
The identifier of the index that was queried\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [QueryId](#API_SubmitFeedback_RequestSyntax) **   <a name="Kendra-SubmitFeedback-request-QueryId"></a>
The identifier of the specific query for which you are submitting feedback\. The query ID is returned in the response to the [Query](API_Query.md) operation\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 36\.  
Required: Yes

 ** [RelevanceFeedbackItems](#API_SubmitFeedback_RequestSyntax) **   <a name="Kendra-SubmitFeedback-request-RelevanceFeedbackItems"></a>
Provides Amazon Kendra with relevant or not relevant feedback for whether a particular item was relevant to the search\.  
Type: Array of [RelevanceFeedback](API_RelevanceFeedback.md) objects  
Required: No

## Response Elements<a name="API_SubmitFeedback_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_SubmitFeedback_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ResourceUnavailableException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_SubmitFeedback_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/SubmitFeedback) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SubmitFeedback) 