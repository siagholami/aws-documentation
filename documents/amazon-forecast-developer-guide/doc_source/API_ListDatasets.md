# ListDatasets<a name="API_ListDatasets"></a>

Returns a list of datasets created using the [CreateDataset](API_CreateDataset.md) operation\. For each dataset, a summary of its properties, including its Amazon Resource Name \(ARN\), is returned\. To retrieve the complete set of properties, use the ARN with the [DescribeDataset](API_DescribeDataset.md) operation\.

## Request Syntax<a name="API_ListDatasets_RequestSyntax"></a>

```
{
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListDatasets_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [MaxResults](#API_ListDatasets_RequestSyntax) **   <a name="forecast-ListDatasets-request-MaxResults"></a>
The number of items to return in the response\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListDatasets_RequestSyntax) **   <a name="forecast-ListDatasets-request-NextToken"></a>
If the result of the previous request was truncated, the response includes a `NextToken`\. To retrieve the next set of results, use the token in the next request\. Tokens expire after 24 hours\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 3000\.  
Required: No

## Response Syntax<a name="API_ListDatasets_ResponseSyntax"></a>

```
{
   "Datasets": [ 
      { 
         "CreationTime": number,
         "DatasetArn": "string",
         "DatasetName": "string",
         "DatasetType": "string",
         "Domain": "string",
         "LastModificationTime": number
      }
   ],
   "NextToken": "string"
}
```

## Response Elements<a name="API_ListDatasets_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Datasets](#API_ListDatasets_ResponseSyntax) **   <a name="forecast-ListDatasets-response-Datasets"></a>
An array of objects that summarize each dataset's properties\.  
Type: Array of [DatasetSummary](API_DatasetSummary.md) objects

 ** [NextToken](#API_ListDatasets_ResponseSyntax) **   <a name="forecast-ListDatasets-response-NextToken"></a>
If the response is truncated, Amazon Forecast returns this token\. To retrieve the next set of results, use the token in the next request\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 3000\.

## Errors<a name="API_ListDatasets_Errors"></a>

 **InvalidNextTokenException**   
The token is not valid\. Tokens expire after 24 hours\.  
HTTP Status Code: 400

## See Also<a name="API_ListDatasets_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/ListDatasets) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/ListDatasets) 