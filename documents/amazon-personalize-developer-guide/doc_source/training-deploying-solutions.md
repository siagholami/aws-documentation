# Creating a Solution<a name="training-deploying-solutions"></a>

A solution version is the term Amazon Personalize uses for a trained machine learning model that makes recommendations to customers\. Creating a solution entails optimizing the model to deliver the best results for a specific business need\. Amazon Personalize uses recipes to create these personalized solutions\.

A recipe in Amazon Personalize is made up of an algorithm with hyperparameters, and a feature transformation\. An algorithm is a mathematical expression that when trained becomes the model\. The algorithm contains parameters whose unknown values are determined by training on input data\. Hyperparameters are external to the algorithm and specify details of the training process, such as the number of training passes to run over the complete dataset or the number of hidden layers to use\.

Amazon Personalize provides a number of predefined recipes that allow you to make recommendations with no knowledge of machine learning\. The predefined recipes are also useful for quick experimentation\. For more information, see [Choosing a Recipe](working-with-predefined-recipes.md)\.

A solution is created by calling the [CreateSolution](API_CreateSolution.md) and [CreateSolutionVersion](API_CreateSolutionVersion.md) operations\. `CreateSolution` creates the configuration for training a model\. `CreateSolutionVersion` starts the training process, which results in a specific version of the solution\. A new version of the solution is created each time you call `CreateSolutionVersion`\. A condensed, reorganized version of the `CreateSolution` request is shown\. The various options and configuration objects are discussed in the following sections\.

```
{
    "name": "string",
    "datasetGroupArn": "string",
    "performAutoML": boolean,
    "recipeArn": "string",
    "performHPO": boolean,
    "eventType": "string",
    "solutionConfig": { 
        "autoMLConfig": { 
            "metricName": "string",
            "recipeList": [ "string" ]
        },
        "eventValueThreshold": "string",
        "algorithmHyperParameters": { },
        "featureTransformationParameters": { },
        "hpoConfig": { }
    },
}
```

**Customize the Training**

To customize the training, supply the `solutionConfig` parameter\. The `SolutionConfig` object allows you to override the default solution and recipe parameters\. For more information see [Overriding Default Recipe Parameters](customizing-solution-config.md)\.

**Create a solution version using the AWS Python SDK**

1. Create and import a dataset into a dataset group\. For more information, see [Preparing and Importing Data](data-prep.md)\.

1. Create the solution version using the dataset group and the following code\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   print ('Creating solution')
   response = personalize.create_solution(
       name = "SolutionName",
       datasetGroupArn = "Dataset group arn",
       performAutoML = True)
   
   # Get the solution ARN.
   solution_arn = response['solutionArn']
   print('Solution ARN: ' + solution_arn)
   
   # Use the solution ARN to get the solution status.
   solution_description = personalize.describe_solution(solutionArn = solution_arn)['solution']
   print('Solution status: ' + solution_description['status'])
   
   # Use the solution ARN to create a solution version.
   print ('Creating solution version')
   response = personalize.create_solution_version(solutionArn = solution_arn)
   solution_version_arn = response['solutionVersionArn']
   print('Solution version ARN: ' + solution_version_arn)
   
   # Use the solution version ARN to get the solution version status.
   solution_version_description = personalize.describe_solution_version(
       solutionVersionArn = solution_version_arn)['solutionVersion']
   print('Solution version status: ' + solution_version_description['status'])
   ```

Training a model takes time\. To check the current solution version status, call the [DescribeSolutionVersion](API_DescribeSolutionVersion.md) operation and pass the ARN of the solution version returned from the `CreateSolutionVersion` operation\. Training is complete when the `status` is `ACTIVE`\.

Now that you have a solution version, evaluate it using metrics supplied by Amazon Personalize\. For more information, see [Evaluating a Solution Version](working-with-training-metrics.md)\.