# ListSolutions<a name="API_ListSolutions"></a>

Returns a list of solutions that use the given dataset group\. When a dataset group is not specified, all the solutions associated with the account are listed\. The response provides the properties for each solution, including the Amazon Resource Name \(ARN\)\. For more information on solutions, see [CreateSolution](API_CreateSolution.md)\.

## Request Syntax<a name="API_ListSolutions_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListSolutions_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_ListSolutions_RequestSyntax) **   <a name="personalize-ListSolutions-request-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [maxResults](#API_ListSolutions_RequestSyntax) **   <a name="personalize-ListSolutions-request-maxResults"></a>
The maximum number of solutions to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListSolutions_RequestSyntax) **   <a name="personalize-ListSolutions-request-nextToken"></a>
A token returned from the previous call to `ListSolutions` for getting the next set of solutions \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListSolutions_ResponseSyntax"></a>

```
{
   "nextToken": "string",
   "solutions": [ 
      { 
         "creationDateTime": number,
         "lastUpdatedDateTime": number,
         "name": "string",
         "solutionArn": "string",
         "status": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListSolutions_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListSolutions_ResponseSyntax) **   <a name="personalize-ListSolutions-response-nextToken"></a>
A token for getting the next set of solutions \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

 ** [solutions](#API_ListSolutions_ResponseSyntax) **   <a name="personalize-ListSolutions-response-solutions"></a>
A list of the current solutions\.  
Type: Array of [SolutionSummary](API_SolutionSummary.md) objects  
Array Members: Maximum number of 100 items\.

## Errors<a name="API_ListSolutions_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListSolutions_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListSolutions) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListSolutions) 