--------

--------

# ListDataSources<a name="API_ListDataSources"></a>

Lists the data sources that you have created\.

## Request Syntax<a name="API_ListDataSources_RequestSyntax"></a>

```
{
   "IndexId": "string",
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListDataSources_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [IndexId](#API_ListDataSources_RequestSyntax) **   <a name="Kendra-ListDataSources-request-IndexId"></a>
The identifier of the index that contains the data source\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [MaxResults](#API_ListDataSources_RequestSyntax) **   <a name="Kendra-ListDataSources-request-MaxResults"></a>
The maximum number of data sources to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListDataSources_RequestSyntax) **   <a name="Kendra-ListDataSources-request-NextToken"></a>
If the previous response was incomplete \(because there is more data to retrieve\), Amazon Kendra returns a pagination token in the response\. You can use this pagination token to retrieve the next set of data sources \(`DataSourceSummaryItems`\)\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.  
Required: No

## Response Syntax<a name="API_ListDataSources_ResponseSyntax"></a>

```
{
   "NextToken": "string",
   "SummaryItems": [ 
      { 
         "CreatedAt": number,
         "Id": "string",
         "Name": "string",
         "Status": "string",
         "Type": "string",
         "UpdatedAt": number
      }
   ]
}
```

## Response Elements<a name="API_ListDataSources_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [NextToken](#API_ListDataSources_ResponseSyntax) **   <a name="Kendra-ListDataSources-response-NextToken"></a>
If the response is truncated, Amazon Kendra returns this token that you can use in the subsequent request to retrieve the next set of data sources\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.

 ** [SummaryItems](#API_ListDataSources_ResponseSyntax) **   <a name="Kendra-ListDataSources-response-SummaryItems"></a>
An array of summary information for one or more data sources\.  
Type: Array of [DataSourceSummary](API_DataSourceSummary.md) objects

## Errors<a name="API_ListDataSources_Errors"></a>

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

## See Also<a name="API_ListDataSources_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/ListDataSources) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ListDataSources) 