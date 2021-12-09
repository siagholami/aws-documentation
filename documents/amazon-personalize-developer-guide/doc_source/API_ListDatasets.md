# ListDatasets<a name="API_ListDatasets"></a>

Returns the list of datasets contained in the given dataset group\. The response provides the properties for each dataset, including the Amazon Resource Name \(ARN\)\. For more information on datasets, see [CreateDataset](API_CreateDataset.md)\.

## Request Syntax<a name="API_ListDatasets_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListDatasets_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_ListDatasets_RequestSyntax) **   <a name="personalize-ListDatasets-request-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group that contains the datasets to list\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [maxResults](#API_ListDatasets_RequestSyntax) **   <a name="personalize-ListDatasets-request-maxResults"></a>
The maximum number of datasets to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListDatasets_RequestSyntax) **   <a name="personalize-ListDatasets-request-nextToken"></a>
A token returned from the previous call to `ListDatasetImportJobs` for getting the next set of dataset import jobs \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListDatasets_ResponseSyntax"></a>

```
{
   "datasets": [ 
      { 
         "creationDateTime": number,
         "datasetArn": "string",
         "datasetType": "string",
         "lastUpdatedDateTime": number,
         "name": "string",
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListDatasets_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [datasets](#API_ListDatasets_ResponseSyntax) **   <a name="personalize-ListDatasets-response-datasets"></a>
An array of `Dataset` objects\. Each object provides metadata information\.  
Type: Array of [DatasetSummary](API_DatasetSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListDatasets_ResponseSyntax) **   <a name="personalize-ListDatasets-response-nextToken"></a>
A token for getting the next set of datasets \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListDatasets_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListDatasets_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListDatasets) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListDatasets) 