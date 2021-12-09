# DescribeRecipe<a name="API_DescribeRecipe"></a>

Describes a recipe\.

A recipe contains three items:
+ An algorithm that trains a model\.
+ Hyperparameters that govern the training\.
+ Feature transformation information for modifying the input data before training\.

Amazon Personalize provides a set of predefined recipes\. You specify a recipe when you create a solution with the [CreateSolution](API_CreateSolution.md) API\. `CreateSolution` trains a model by using the algorithm in the specified recipe and a training dataset\. The solution, when deployed as a campaign, can provide recommendations using the [GetRecommendations](https://docs.aws.amazon.com/personalize/latest/dg/API_RS_GetRecommendations.html) API\.

## Request Syntax<a name="API_DescribeRecipe_RequestSyntax"></a>

```
{
   "recipeArn": "string"
}
```

## Request Parameters<a name="API_DescribeRecipe_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [recipeArn](#API_DescribeRecipe_RequestSyntax) **   <a name="personalize-DescribeRecipe-request-recipeArn"></a>
The Amazon Resource Name \(ARN\) of the recipe to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeRecipe_ResponseSyntax"></a>

```
{
   "recipe": { 
      "algorithmArn": "string",
      "creationDateTime": number,
      "description": "string",
      "featureTransformationArn": "string",
      "lastUpdatedDateTime": number,
      "name": "string",
      "recipeArn": "string",
      "recipeType": "string",
      "status": "string"
   }
}
```

## Response Elements<a name="API_DescribeRecipe_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [recipe](#API_DescribeRecipe_ResponseSyntax) **   <a name="personalize-DescribeRecipe-response-recipe"></a>
An object that describes the recipe\.  
Type: [Recipe](API_Recipe.md) object

## Errors<a name="API_DescribeRecipe_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeRecipe_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeRecipe) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeRecipe) 