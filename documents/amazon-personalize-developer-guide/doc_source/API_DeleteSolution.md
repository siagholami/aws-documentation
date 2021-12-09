# DeleteSolution<a name="API_DeleteSolution"></a>

Deletes all versions of a solution and the `Solution` object itself\. Before deleting a solution, you must delete all campaigns based on the solution\. To determine what campaigns are using the solution, call [ListCampaigns](API_ListCampaigns.md) and supply the Amazon Resource Name \(ARN\) of the solution\. You can't delete a solution if an associated `SolutionVersion` is in the CREATE PENDING or IN PROGRESS state\. For more information on solutions, see [CreateSolution](API_CreateSolution.md)\.

## Request Syntax<a name="API_DeleteSolution_RequestSyntax"></a>

```
{
   "solutionArn": "string"
}
```

## Request Parameters<a name="API_DeleteSolution_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [solutionArn](#API_DeleteSolution_RequestSyntax) **   <a name="personalize-DeleteSolution-request-solutionArn"></a>
The ARN of the solution to delete\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Elements<a name="API_DeleteSolution_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_DeleteSolution_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DeleteSolution_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DeleteSolution) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DeleteSolution) 