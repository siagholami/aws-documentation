--------

--------

# ListIndices<a name="API_ListIndices"></a>

Lists the Amazon Kendra indexes that you have created\.

## Request Syntax<a name="API_ListIndices_RequestSyntax"></a>

```
{
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListIndices_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [MaxResults](#API_ListIndices_RequestSyntax) **   <a name="Kendra-ListIndices-request-MaxResults"></a>
The maximum number of data sources to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListIndices_RequestSyntax) **   <a name="Kendra-ListIndices-request-NextToken"></a>
If the previous response was incomplete \(because there is more data to retrieve\), Amazon Kendra returns a pagination token in the response\. You can use this pagination token to retrieve the next set of indexes \(`DataSourceSummaryItems`\)\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.  
Required: No

## Response Syntax<a name="API_ListIndices_ResponseSyntax"></a>

```
{
   "IndexConfigurationSummaryItems": [ 
      { 
         "CreatedAt": number,
         "Edition": "string",
         "Id": "string",
         "Name": "string",
         "Status": "string",
         "UpdatedAt": number
      }
   ],
   "NextToken": "string"
}
```

## Response Elements<a name="API_ListIndices_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [IndexConfigurationSummaryItems](#API_ListIndices_ResponseSyntax) **   <a name="Kendra-ListIndices-response-IndexConfigurationSummaryItems"></a>
An array of summary information for one or more indexes\.  
Type: Array of [IndexConfigurationSummary](API_IndexConfigurationSummary.md) objects

 ** [NextToken](#API_ListIndices_ResponseSyntax) **   <a name="Kendra-ListIndices-response-NextToken"></a>
If the response is truncated, Amazon Kendra returns this token that you can use in the subsequent request to retrieve the next set of indexes\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.

## Errors<a name="API_ListIndices_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_ListIndices_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/ListIndices) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ListIndices) 