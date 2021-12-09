# Choosing a Recipe<a name="working-with-predefined-recipes"></a>

 Amazon Personalize provides recipes, based on common use cases, for training models\. A *recipe* is a machine learning algorithm or algorithm variant that you use with settings, or hyperparameters, and a dataset group to train an Amazon Personalize model\. With recipes, you can create a personalization system without prior machine learning experience\.

The predefined recipes use the following during training:
+ Predefined attributes of your data
+ Predefined feature transformations 
+ Predefined algorithms 
+ Initial parameter settings for the algorithms

To optimize your model, you can override many of these parameters when you create a solution\. For more information, see [Hyperparameters and HPO](customizing-solution-config-hpo.md)\.

 Choose a specific recipe based on what you want to accomplish and how familiar you are with the recipes\. Each recipe is designed for a specific use case\. When creating a solution, choose the recipe that best fits your needs\. See [Amazon Personalize Recipe Categories](#recipe-categories) for a list of Amazon Personalize recipes by category\. 

## Amazon Personalize Recipe Categories<a name="recipe-categories"></a>

Amazon Personalize provides three types of recipes\. Besides behavioral differences, each type has different requirements for getting recommendations, as shown in the following table\.


| Recipe type | API | Requirements | Recipes | 
| --- | --- | --- | --- | 
| USER\_PERSONALIZATION | [GetRecommendations](API_RS_GetRecommendations.md) |  `userId`: Required `itemId`: Optional `inputList`: NA  |  [User\-Personalization](native-recipe-new-item-USER_PERSONALIZATION.md) [HRNN](native-recipe-hrnn.md) [HRNN\-Metadata](native-recipe-hrnn-metadata.md) [HRNN\-Coldstart](native-recipe-hrnn-coldstart.md) [Popularity\-Count](native-recipe-popularity.md)  | 
| PERSONALIZED\_RANKING | [GetPersonalizedRanking](API_RS_GetPersonalizedRanking.md) |  `userId`: Required `itemId`: NA `inputList`: list of itemId's  |  [Personalized\-Ranking](native-recipe-search.md)  | 
| RELATED\_ITEMS | [GetRecommendations](API_RS_GetRecommendations.md) |  `userId`: Not used `itemId`: Required `inputList`: NA  |  [SIMS](native-recipe-sims.md)  | 

## Viewing Available Amazon Personalize Recipes<a name="listing-recipes"></a>

To see a list of available recipes:
+ In the Amazon Personalize console, choose a dataset group\. From the navigation pane, choose **Solutions and recipes**, and choose the **Recipes** tab\. 
+ With the AWS SDK for Python \(Boto3\), call the [ListRecipes](API_ListRecipes.md) API\. 
+ With the AWS CLI, use the following command\.

  ```
  aws personalize list-recipes
  ```

To get information about a recipe using the SDK for Python \(Boto3\), call the [DescribeRecipe](API_DescribeRecipe.md) API\. To get information about a recipe using the AWS CLI, use the following command\.

```
aws personalize describe-recipe --recipe-arn recipe_arn
```

## Using AutoML to Choose an HRNN Recipe \(API Only\)<a name="training-solution-auto-ml"></a>

Amazon Personalize can automatically choose the most appropriate hierarchical recurrent neural network \(HRNN\) recipe based on its analysis of the input data\. This option is called AutoML\. To perform AutoML, set the `performAutoML` parameter to `true` when you call the [CreateSolution](API_CreateSolution.md) API\. 

You can also specify the list of recipes that Amazon Personalize examines to determine the optimal recipe, based on a metric you specify\. In this case, you call the `CreateSolution` operation, specify `true` for the `performAutoML` parameter, omit the `recipeArn` parameter, and include the `solutionConfig` parameter, specifying the `metricName` and `recipeList` as part of the `autoMLConfig` object\. 

How a recipe is chosen is shown in the following table\. Either `performAutoML`or `recipeArn` must be specified but not both\. AutoML is only performed using the HRNN recipes\.


| performAutoML | recipeArn | solutionConfig | Result | 
| --- | --- | --- | --- | 
| true | omit | omitted | Amazon Personalize chooses the recipe | 
| true | omit | autoMLConfig: metricName and recipeList specified | Amazon Personalize chooses a recipe from the list that optimizes the metric | 
| omit | specified | omitted | You specify the recipe | 
| omit | specified | specified | You specify the recipe and override the default training properties | 

**Note**  
When `performAutoML` is `true`, all parameters of the `solutionConfig` object are ignored except for `autoMLConfig`\.