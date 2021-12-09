# ListFilters<a name="API_ListFilters"></a>

Lists all filters that belong to a given dataset group\.

## Request Syntax<a name="API_ListFilters_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListFilters_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_ListFilters_RequestSyntax) **   <a name="personalize-ListFilters-request-datasetGroupArn"></a>
The ARN of the dataset group that contains the filters\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [maxResults](#API_ListFilters_RequestSyntax) **   <a name="personalize-ListFilters-request-maxResults"></a>
The maximum number of filters to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListFilters_RequestSyntax) **   <a name="personalize-ListFilters-request-nextToken"></a>
A token returned from the previous call to `ListFilters` for getting the next set of filters \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListFilters_ResponseSyntax"></a>

```
{
   "Filters": [ 
      { 
         "creationDateTime": number,
         "datasetGroupArn": "string",
         "failureReason": "string",
         "filterArn": "string",
         "lastUpdatedDateTime": number,
         "name": "string",
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListFilters_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Filters](#API_ListFilters_ResponseSyntax) **   <a name="personalize-ListFilters-response-Filters"></a>
A list of returned filters\.  
Type: Array of [FilterSummary](API_FilterSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListFilters_ResponseSyntax) **   <a name="personalize-ListFilters-response-nextToken"></a>
A token for getting the next set of filters \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListFilters_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListFilters_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListFilters) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListFilters) 