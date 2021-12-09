# RecipeSummary<a name="API_RecipeSummary"></a>

Provides a summary of the properties of a recipe\. For a complete listing, call the [DescribeRecipe](API_DescribeRecipe.md) API\.

## Contents<a name="API_RecipeSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-RecipeSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the recipe was created\.  
Type: Timestamp  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-RecipeSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the recipe was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-RecipeSummary-name"></a>
The name of the recipe\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **recipeArn**   <a name="personalize-Type-RecipeSummary-recipeArn"></a>
The Amazon Resource Name \(ARN\) of the recipe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-RecipeSummary-status"></a>
The status of the recipe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_RecipeSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/RecipeSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/RecipeSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/RecipeSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/RecipeSummary) 