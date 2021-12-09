--------

--------

# ListFaqs<a name="API_ListFaqs"></a>

Gets a list of FAQ lists associated with an index\.

## Request Syntax<a name="API_ListFaqs_RequestSyntax"></a>

```
{
   "IndexId": "string",
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListFaqs_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [IndexId](#API_ListFaqs_RequestSyntax) **   <a name="Kendra-ListFaqs-request-IndexId"></a>
The index that contains the FAQ lists\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [MaxResults](#API_ListFaqs_RequestSyntax) **   <a name="Kendra-ListFaqs-request-MaxResults"></a>
The maximum number of FAQs to return in the response\. If there are fewer results in the list, this response contains only the actual results\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListFaqs_RequestSyntax) **   <a name="Kendra-ListFaqs-request-NextToken"></a>
If the result of the previous request to `ListFaqs` was truncated, include the `NextToken` to fetch the next set of FAQs\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.  
Required: No

## Response Syntax<a name="API_ListFaqs_ResponseSyntax"></a>

```
{
   "FaqSummaryItems": [ 
      { 
         "CreatedAt": number,
         "Id": "string",
         "Name": "string",
         "Status": "string",
         "UpdatedAt": number
      }
   ],
   "NextToken": "string"
}
```

## Response Elements<a name="API_ListFaqs_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [FaqSummaryItems](#API_ListFaqs_ResponseSyntax) **   <a name="Kendra-ListFaqs-response-FaqSummaryItems"></a>
information about the FAQs associated with the specified index\.  
Type: Array of [FaqSummary](API_FaqSummary.md) objects

 ** [NextToken](#API_ListFaqs_ResponseSyntax) **   <a name="Kendra-ListFaqs-response-NextToken"></a>
The `ListFaqs` operation returns a page of FAQs at a time\. The maximum size of the page is set by the `MaxResults` parameter\. If there are more jobs in the list than the page size, Amazon Kendra returns the `NextPage` token\. Include the token in the next request to the `ListFaqs` operation to return the next page of FAQs\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.

## Errors<a name="API_ListFaqs_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_ListFaqs_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/ListFaqs) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ListFaqs) 