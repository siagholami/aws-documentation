# ListSolutionVersions<a name="API_ListSolutionVersions"></a>

Returns a list of solution versions for the given solution\. When a solution is not specified, all the solution versions associated with the account are listed\. The response provides the properties for each solution version, including the Amazon Resource Name \(ARN\)\. For more information on solutions, see [CreateSolution](API_CreateSolution.md)\.

## Request Syntax<a name="API_ListSolutionVersions_RequestSyntax"></a>

```
{
   "maxResults": number,
   "nextToken": "string",
   "solutionArn": "string"
}
```

## Request Parameters<a name="API_ListSolutionVersions_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [maxResults](#API_ListSolutionVersions_RequestSyntax) **   <a name="personalize-ListSolutionVersions-request-maxResults"></a>
The maximum number of solution versions to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListSolutionVersions_RequestSyntax) **   <a name="personalize-ListSolutionVersions-request-nextToken"></a>
A token returned from the previous call to `ListSolutionVersions` for getting the next set of solution versions \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

 ** [solutionArn](#API_ListSolutionVersions_RequestSyntax) **   <a name="personalize-ListSolutionVersions-request-solutionArn"></a>
The Amazon Resource Name \(ARN\) of the solution\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

## Response Syntax<a name="API_ListSolutionVersions_ResponseSyntax"></a>

```
{
   "nextToken": "string",
   "solutionVersions": [ 
      { 
         "creationDateTime": number,
         "failureReason": "string",
         "lastUpdatedDateTime": number,
         "solutionVersionArn": "string",
         "status": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListSolutionVersions_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListSolutionVersions_ResponseSyntax) **   <a name="personalize-ListSolutionVersions-response-nextToken"></a>
A token for getting the next set of solution versions \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

 ** [solutionVersions](#API_ListSolutionVersions_ResponseSyntax) **   <a name="personalize-ListSolutionVersions-response-solutionVersions"></a>
A list of solution versions describing the version properties\.  
Type: Array of [SolutionVersionSummary](API_SolutionVersionSummary.md) objects  
Array Members: Maximum number of 100 items\.

## Errors<a name="API_ListSolutionVersions_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_ListSolutionVersions_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListSolutionVersions) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListSolutionVersions) 