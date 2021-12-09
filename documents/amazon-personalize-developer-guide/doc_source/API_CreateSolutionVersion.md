# CreateSolutionVersion<a name="API_CreateSolutionVersion"></a>

Trains or retrains an active solution\. A solution is created using the [CreateSolution](API_CreateSolution.md) operation and must be in the ACTIVE state before calling `CreateSolutionVersion`\. A new version of the solution is created every time you call this operation\.

 **Status** 

A solution version can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED

To get the status of the version, call [DescribeSolutionVersion](API_DescribeSolutionVersion.md)\. Wait until the status shows as ACTIVE before calling `CreateCampaign`\.

If the status shows as CREATE FAILED, the response includes a `failureReason` key, which describes why the job failed\.

**Related APIs**
+  [ListSolutionVersions](API_ListSolutionVersions.md) 
+  [DescribeSolutionVersion](API_DescribeSolutionVersion.md) 
+  [ListSolutions](API_ListSolutions.md) 
+  [CreateSolution](API_CreateSolution.md) 
+  [DescribeSolution](API_DescribeSolution.md) 
+  [DeleteSolution](API_DeleteSolution.md) 

## Request Syntax<a name="API_CreateSolutionVersion_RequestSyntax"></a>

```
{
   "solutionArn": "string",
   "trainingMode": "string"
}
```

## Request Parameters<a name="API_CreateSolutionVersion_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [solutionArn](#API_CreateSolutionVersion_RequestSyntax) **   <a name="personalize-CreateSolutionVersion-request-solutionArn"></a>
The Amazon Resource Name \(ARN\) of the solution containing the training configuration information\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

 ** [trainingMode](#API_CreateSolutionVersion_RequestSyntax) **   <a name="personalize-CreateSolutionVersion-request-trainingMode"></a>
The scope of training to be performed when creating the solution version\. The `FULL` option trains the solution version based on the entirety of the input solution's training data, while the `UPDATE` option processes only the data that has changed in comparison to the input solution\. Choose `UPDATE` when you want to incrementally update your solution version instead of creating an entirely new one\.  
The `UPDATE` option can only be used when you already have an active solution version created from the input solution using the `FULL` option and the input solution was trained with the [User\-Personalization Recipe](native-recipe-new-item-USER_PERSONALIZATION.md) or the [HRNN\-Coldstart Recipe](native-recipe-hrnn-coldstart.md) recipe\.
Type: String  
Valid Values:` FULL | UPDATE`   
Required: No

## Response Syntax<a name="API_CreateSolutionVersion_ResponseSyntax"></a>

```
{
   "solutionVersionArn": "string"
}
```

## Response Elements<a name="API_CreateSolutionVersion_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [solutionVersionArn](#API_CreateSolutionVersion_ResponseSyntax) **   <a name="personalize-CreateSolutionVersion-response-solutionVersionArn"></a>
The ARN of the new solution version\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateSolutionVersion_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_CreateSolutionVersion_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateSolutionVersion) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateSolutionVersion) 