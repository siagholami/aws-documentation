# ListRecipes<a name="API_ListRecipes"></a>

Returns a list of available recipes\. The response provides the properties for each recipe, including the recipe's Amazon Resource Name \(ARN\)\.

## Request Syntax<a name="API_ListRecipes_RequestSyntax"></a>

```
{
   "maxResults": number,
   "nextToken": "string",
   "recipeProvider": "string"
}
```

## Request Parameters<a name="API_ListRecipes_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [maxResults](#API_ListRecipes_RequestSyntax) **   <a name="personalize-ListRecipes-request-maxResults"></a>
The maximum number of recipes to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListRecipes_RequestSyntax) **   <a name="personalize-ListRecipes-request-nextToken"></a>
A token returned from the previous call to `ListRecipes` for getting the next set of recipes \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

 ** [recipeProvider](#API_ListRecipes_RequestSyntax) **   <a name="personalize-ListRecipes-request-recipeProvider"></a>
The default is `SERVICE`\.  
Type: String  
Valid Values:` SERVICE`   
Required: No

## Response Syntax<a name="API_ListRecipes_ResponseSyntax"></a>

```
{
   "nextToken": "string",
   "recipes": [ 
      { 
         "creationDateTime": number,
         "lastUpdatedDateTime": number,
         "name": "string",
         "recipeArn": "string",
         "status": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListRecipes_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListRecipes_ResponseSyntax) **   <a name="personalize-ListRecipes-response-nextToken"></a>
A token for getting the next set of recipes\.  
Type: String  
Length Constraints: Maximum length of 1300\.

 ** [recipes](#API_ListRecipes_ResponseSyntax) **   <a name="personalize-ListRecipes-response-recipes"></a>
The list of available recipes\.  
Type: Array of [RecipeSummary](API_RecipeSummary.md) objects  
Array Members: Maximum number of 100 items\.

## Errors<a name="API_ListRecipes_Errors"></a>

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListRecipes_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListRecipes) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListRecipes) 