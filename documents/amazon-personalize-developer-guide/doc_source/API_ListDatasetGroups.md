# ListDatasetGroups<a name="API_ListDatasetGroups"></a>

Returns a list of dataset groups\. The response provides the properties for each dataset group, including the Amazon Resource Name \(ARN\)\. For more information on dataset groups, see [CreateDatasetGroup](API_CreateDatasetGroup.md)\.

## Request Syntax<a name="API_ListDatasetGroups_RequestSyntax"></a>

```
{
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListDatasetGroups_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [maxResults](#API_ListDatasetGroups_RequestSyntax) **   <a name="personalize-ListDatasetGroups-request-maxResults"></a>
The maximum number of dataset groups to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListDatasetGroups_RequestSyntax) **   <a name="personalize-ListDatasetGroups-request-nextToken"></a>
A token returned from the previous call to `ListDatasetGroups` for getting the next set of dataset groups \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListDatasetGroups_ResponseSyntax"></a>

```
{
   "datasetGroups": [ 
      { 
         "creationDateTime": number,
         "datasetGroupArn": "string",
         "failureReason": "string",
         "lastUpdatedDateTime": number,
         "name": "string",
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListDatasetGroups_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [datasetGroups](#API_ListDatasetGroups_ResponseSyntax) **   <a name="personalize-ListDatasetGroups-response-datasetGroups"></a>
The list of your dataset groups\.  
Type: Array of [DatasetGroupSummary](API_DatasetGroupSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListDatasetGroups_ResponseSyntax) **   <a name="personalize-ListDatasetGroups-response-nextToken"></a>
A token for getting the next set of dataset groups \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListDatasetGroups_Errors"></a>

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListDatasetGroups_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListDatasetGroups) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListDatasetGroups) 