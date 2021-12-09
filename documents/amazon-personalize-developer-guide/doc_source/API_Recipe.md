# Recipe<a name="API_Recipe"></a>

Provides information about a recipe\. Each recipe provides an algorithm that Amazon Personalize uses in model training when you use the [CreateSolution](API_CreateSolution.md) operation\. 

## Contents<a name="API_Recipe_Contents"></a>

 **algorithmArn**   <a name="personalize-Type-Recipe-algorithmArn"></a>
The Amazon Resource Name \(ARN\) of the algorithm that Amazon Personalize uses to train the model\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **creationDateTime**   <a name="personalize-Type-Recipe-creationDateTime"></a>
The date and time \(in Unix format\) that the recipe was created\.  
Type: Timestamp  
Required: No

 **description**   <a name="personalize-Type-Recipe-description"></a>
The description of the recipe\.  
Type: String  
Required: No

 **featureTransformationArn**   <a name="personalize-Type-Recipe-featureTransformationArn"></a>
The ARN of the FeatureTransformation object\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-Recipe-lastUpdatedDateTime"></a>
The date and time \(in Unix format\) that the recipe was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-Recipe-name"></a>
The name of the recipe\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **recipeArn**   <a name="personalize-Type-Recipe-recipeArn"></a>
The Amazon Resource Name \(ARN\) of the recipe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **recipeType**   <a name="personalize-Type-Recipe-recipeType"></a>
One of the following values:  
+ PERSONALIZED\_RANKING
+ RELATED\_ITEMS
+ USER\_PERSONALIZATION
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **status**   <a name="personalize-Type-Recipe-status"></a>
The status of the recipe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_Recipe_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/Recipe) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/Recipe) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/Recipe) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/Recipe) 