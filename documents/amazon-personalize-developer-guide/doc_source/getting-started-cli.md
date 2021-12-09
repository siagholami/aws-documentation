# Getting Started \(AWS CLI\)<a name="getting-started-cli"></a>

In this exercise, you use the AWS Command Line Interface \(AWS CLI\) to explore Amazon Personalize\. You create a campaign that returns movie recommendations for a given user ID\.

Before you start this exercise, do the following:
+ Review the Getting Started [Getting Started Prerequisites](gs-prerequisites.md)\.
+ Set up the AWS CLI, as specified in [Setting Up the AWS CLI](aws-personalize-set-up-aws-cli.md)\.

After you finish this exercise, see [Clean Up Resources](gs-cleanup.md)\.

**Note**  
The CLI commands in this exercise were tested on Linux\. For information about using the CLI commands on Windows, see [Specifying Parameter Values for the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html) in the *AWS Command Line Interface User Guide*\.

## Step 1: Import Training Data<a name="gs-create-ds"></a>

Follow the steps to create a dataset group, add a dataset to the group, and then populate the dataset using the movie ratings data\.

1. Create a dataset group by running the following command\. You can encrypt the dataset group by passing a [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/overview.html) key ARN and the ARN of an IAM role that has access permissions to that key as input parameters\. For more information about the API, see [CreateDatasetGroup](API_CreateDatasetGroup.md)\.

   ```
   aws personalize create-dataset-group --name MovieRatingDatasetGroup --kms-key-arn arn:aws:kms:us-west-2:01234567890:key/1682a1e7-a94d-4d92-bbdf-837d3b62315e --role-arn arn:aws:iam::01234567890:KMS-key-access
   ```

   The dataset group ARN is displayed, for example:

   ```
   {
     "datasetGroupArn": "arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieRatingDatasetGroup"
   }
   ```

   Use the `describe-dataset-group` command to display the dataset group you created, specifying the returned dataset group ARN\.

   ```
   aws personalize describe-dataset-group \
   --dataset-group-arn arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieRatingDatasetGroup
   ```

   The dataset group and its properties are displayed, for example:

   ```
   {
       "datasetGroup": {
           "name": "MovieRatingDatasetGroup",
           "datasetGroupArn": "arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieRatingDatasetGroup",
           "status": "ACTIVE",
           "creationDateTime": 1542392161.262,
           "lastUpdatedDateTime": 1542396513.377
       }
   }
   ```
**Note**  
Wait until the dataset group's `status` shows as ACTIVE before creating a dataset in the group\. This operation is usually quick\.

   If you don't remember the dataset group ARN, use the `list-dataset-groups` command to display all the dataset groups that you created, along with their ARNs\.

   ```
   aws personalize list-dataset-groups
   ```
**Note**  
The `describe-object` and `list-objects` commands are available for most Amazon Personalize objects\. These commands are not shown in the remainder of this exercise but they are available\.

1. Create a schema file in JSON format by saving the following code to a file named `MovieRatingSchema.json`\. The schema matches the headers you previously added to `ratings.csv`\. The schema name is `Interactions`, which matches one of the three types of datasets recognized by Amazon Personalize\. For more information, see [Datasets and Dataset Groups](how-it-works.md#how-it-works-dataset)\.

   ```
   {
     "type": "record",
     "name": "Interactions",
     "namespace": "com.amazonaws.personalize.schema",
     "fields": [
         {
             "name": "USER_ID",
             "type": "string"
         },
         {
             "name": "ITEM_ID",
             "type": "string"
         },
         {
             "name": "TIMESTAMP",
             "type": "long"
         }
     ],
     "version": "1.0"
   }
   ```

1. Create a schema by running the following command\. Specify the file you saved in the previous step\. The example shows the file as belonging to the current folder\. For more information about the API, see [CreateSchema](API_CreateSchema.md)\.

   ```
   aws personalize create-schema \
     --name MovieRatingSchema \
     --schema file://MovieRatingSchema.json
   ```

   The schema Amazon Resource Name \(ARN\) is displayed, for example:

   ```
   {
     "schemaArn": "arn:aws:personalize:us-west-2:acct-id:schema/MovieRatingSchema"
   }
   ```

1. Create an empty dataset by running the following command\. Provide the dataset group ARN and schema ARN that were returned in the previous steps\. The `dataset-type` must match the schema `name` from the previous step\. For more information about the API, see [CreateDataset](API_CreateDataset.md)\.

   ```
   aws personalize create-dataset \
     --name MovieRatingDataset \
     --dataset-group-arn arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieRatingDatasetGroup \
     --dataset-type Interactions \
     --schema-arn arn:aws:personalize:us-west-2:acct-id:schema/MovieRatingSchema
   ```

   The dataset ARN is displayed, for example:

   ```
   {
     "datasetArn": "arn:aws:personalize:us-west-2:acct-id:dataset/MovieRatingDatasetGroup/INTERACTIONS"
   }
   ```

1. Add the training data to the dataset\.

   1. Create a dataset import job by running the following command\. Provide the dataset ARN and Amazon S3 bucket name that were returned in the previous steps\. Supply the AWS Identity and Access Management \(IAM\) role ARN you created in [Creating an IAM Role for Amazon Personalize](aws-personalize-set-up-permissions.md#set-up-create-role-with-permissions)\. For more information about the API, see [CreateDatasetImportJob](API_CreateDatasetImportJob.md)\.

      ```
      aws personalize create-dataset-import-job \
        --job-name MovieRatingImportJob \
        --dataset-arn arn:aws:personalize:us-west-2:acct-id:dataset/MovieRatingDatasetGroup/INTERACTIONS \
        --data-source dataLocation=s3://bucketname/ratings.csv \
        --role-arn roleArn
      ```

      The dataset import job ARN is displayed, for example:

      ```
      {
        "datasetImportJobArn": "arn:aws:personalize:us-west-2:acct-id:dataset-import-job/MovieRatingImportJob"
      }
      ```

   1. Check the status by using the `describe-dataset-import-job` command\. Provide the dataset import job ARN that was returned in the previous step\. For more information about the API, see [DescribeDatasetImportJob](API_DescribeDatasetImportJob.md)\.

      ```
      aws personalize describe-dataset-import-job \
        --dataset-import-job-arn arn:aws:personalize:us-west-2:acct-id:dataset-import-job/MovieRatingImportJob
      ```

      The properties of the dataset import job, including its status, are displayed\. Initially, the `status` shows as CREATE PENDING, for example:

      ```
      {
        "datasetImportJob": {
            "jobName": "MovieRatingImportJob",
            "datasetImportJobArn": "arn:aws:personalize:us-west-2:acct-id:dataset-import-job/MovieRatingImportJob",
            "datasetArn": "arn:aws:personalize:us-west-2:acct-id:dataset/MovieRatingDatasetGroup/INTERACTIONS",
            "dataSource": {
                "dataLocation": "s3://<bucketname>/ratings.csv"
            },
            "roleArn": "role-arn",
            "status": "CREATE PENDING",
            "creationDateTime": 1542392161.837,
            "lastUpdatedDateTime": 1542393013.377
        }
      }
      ```

      The dataset import is complete when the status shows as ACTIVE\. Then you are ready to train the model using the specified dataset\.
**Note**  
Importing takes time\. Wait until the dataset import is complete before training the model using the dataset\.

## Step 2: Create a Solution \(Train the Model\)<a name="gs-create-solution"></a>

Two steps are required to initially train a model\. First, you create the configuration for training the model using the [CreateSolution](API_CreateSolution.md) operation\. Second, you train the model using the [CreateSolutionVersion](API_CreateSolutionVersion.md) operation\.

You train a model using a recipe and your training data\. Amazon Personalize provides a set of predefined recipes\. For more information, see [Choosing a Recipe](working-with-predefined-recipes.md)\. For this exercise, you use AutoML, which allows Amazon Personalize to pick the best recipe based on the dataset you created in the preceding step\.

1. Create the configuration for training a model by running the following command\.

   ```
   aws personalize create-solution \
     --name MovieSolution \
     --dataset-group-arn arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieRatingDatasetGroup \
     --perform-auto-ml
   ```

   The solution ARN is displayed, for example:

   ```
   {
     "solutionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution"
   }
   ```

1. Check the *create* status using the `describe-solution` command\. Provide the solution ARN that was returned in the previous step\. For more information about the API, see [DescribeSolution](API_DescribeSolution.md)\.

   ```
   aws personalize describe-solution \
     --solution-arn arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution
   ```

   The properties of the solution and the create `status` are displayed\. Initially, the status shows as CREATE PENDING, for example:

   ```
   {
     "solution": {
         "name": "MovieSolution",
         "solutionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution",
         "datasetGroupArn": "arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieRatingDatasetGroup",
         "performAutoML": true,
         "performHPO": false,
         "solutionConfig": {
             "autoMLConfig": {
                 "metricName": "precision_at_25",
                 "recipeList": [
                     "arn:aws:personalize:::recipe/aws-hrnn"
                 ]
             }
         },
         "creationDateTime": 1543864685.016,
         "lastUpdatedDateTime": 1543864685.016,
         "status": "CREATE PENDING"
     }
   }
   ```

   Note the `metricName` and `recipeList`\. Because you specified `performAutoML`, Amazon Personalize chooses the recipe from the list that optimizes that metric\. Because we didn't supply any metadata, the only recipe in the list is the [HRNN](native-recipe-hrnn.md) recipe\.

   When the create `status` shows as ACTIVE, the solution configuration is complete and the model is ready for training\.

1. Now that the configuration is ACTIVE, train the model by running the following command\.

   ```
   aws personalize create-solution-version \
     --solution-arn arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution
   ```

   The solution version ARN is displayed, for example:

   ```
   {
     "solutionVersionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/<version-id>"
   }
   ```

   Check the *training* status of the solution version by using the `describe-solution-version` command\. Provide the solution version ARN that was returned in the previous step\. For more information about the API, see [DescribeSolutionVersion](API_DescribeSolutionVersion.md)\.

   ```
   aws personalize describe-solution-version \
     --solution-version-arn arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/version-id
   ```

   The properties of the solution version and the training `status` are displayed\. Initially, the status shows as CREATE PENDING, for example:

   ```
   {
     "solutionVersion": {
         "solutionVersionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/<version-id>",
         ...,
         "status": "CREATE PENDING"
     }
   }
   ```

1. When the latest solution version training `status` shows as ACTIVE, the training is complete\. The `describe-solution-version` response now includes `recipeArn`, which shows the recipe used to train the model as determined by Amazon Personalize, for example:

   ```
   {
     "solutionVersion": {
         "solutionVersionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/<version-id>",
         "performAutoML": true,
         "recipeArn": "arn:aws:personalize:::recipe/aws-hrnn",
         "solutionConfig": {
             "autoMLConfig": {
                 "metricName": "precision_at_25",
                 "recipeList": [
                     "arn:aws:personalize:::recipe/aws-hrnn"
                 ]
             }
         },
         ...
         "status": "ACTIVE"
     }
   }
   ```

   Now you can check the solution version metrics and create a campaign using the solution version\.
**Note**  
Training takes time\. Wait until training is complete \(the *training* status of the solution version shows as ACTIVE\) before using this version of the solution in a campaign\. For quicker training, instead of using `perform-auto-ml`, select a specific recipe using the `recipe-arn` parameter\.

1. You can validate the performance of the solution version by reviewing its metrics\. Get the metrics for the solution version by running the following command\. Provide the solution version ARN that was returned previously\. For more information about the API, see [GetSolutionMetrics](API_GetSolutionMetrics.md)\.

   ```
   aws personalize get-solution-metrics \
     --solution-version-arn arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/version-id
   ```

   A sample response is shown:

   ```
   {
     "solutionVersionArn": "arn:aws:personalize:us-west-2:acct-id:solution/www-solution/<version-id>",
     "metrics": {
         "arn:aws:personalize:us-west-2:acct-id:model/awspersonalizehrnnmodel-7923fda9": {
         "coverage": 0.27,
         "mean_reciprocal_rank_at_25": 0.0379,
         "normalized_discounted_cumulative_gain_at_5": 0.0405,
         "normalized_discounted_cumulative_gain_at_10": 0.0513,
         "normalized_discounted_cumulative_gain_at_25": 0.0828,
         "precision_at_5": 0.0136,
         "precision_at_10": 0.0102,
         "precision_at_25": 0.0091
       }
     }
   }
   ```

## Step 3: Create a Campaign \(Deploy the Solution\)<a name="gs-create-campaign"></a>

Before you can get recommendations, you must deploy a version of the solution\. Deploying a solution is also known as creating a campaign\. Once you've created your campaign, your client application can get recommendations using the [GetRecommendations](API_RS_GetRecommendations.md) API\.

1. Create a campaign by running the following command\. Provide the solution version ARN that was returned in the previous step\. For more information about the API, see [CreateCampaign](API_CreateCampaign.md)\.

   ```
   aws personalize create-campaign \
     --name MovieRecommendationCampaign \
     --solution-version-arn arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/version-id \
     --min-provisioned-tps 10
   ```

   A sample response is shown:

   ```
   {
     "campaignArn": "arn:aws:personalize:us-west-2:acct-id:campaign/MovieRecommendationCampaign"
   }
   ```

1. Check the deployment status by running the following command\. Provide the campaign ARN that was returned in the previous step\. For more information about the API, see [DescribeCampaign](API_DescribeCampaign.md)\.

   ```
   aws personalize describe-campaign \
     --campaign-arn arn:aws:personalize:us-west-2:acct-id:campaign/MovieRecommendationCampaign
   ```

   A sample response is shown:

   ```
   {
     "campaign": { 
         "name": "MovieRecommendationCampaign",
         "campaignArn": "arn:aws:personalize:us-west-2:acct-id:campaign/MovieRecommendationCampaign",
         "solutionVersionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/<version-id>",
         "minProvisionedTPS": "10",
         "creationDateTime": 1543864775.923,
         "lastUpdatedDateTime": 1543864791.923,
         "status": "CREATE IN_PROGRESS"
     }
   }
   ```
**Note**  
Wait until the `status` shows as ACTIVE before getting recommendations from the campaign\.

## Step 4: Get Recommendations<a name="gs-test"></a>

Get recommendations by running the `get-recommendations` command\. Provide the campaign ARN that was returned in the previous step\. In the request, you specify a user ID from the movie ratings dataset\. For more information about the API, see [GetRecommendations](API_RS_GetRecommendations.md)\.

**Note**  
Not all recipes support the `GetRecommendations` API\. For more information, see [Choosing a Recipe](working-with-predefined-recipes.md)\.  
The AWS CLI command you call in this step, `personalize-runtime`, is different than in previous steps\.

```
aws personalize-runtime get-recommendations \
  --campaign-arn arn:aws:personalize:us-west-2:acct-id:campaign/MovieRecommendationCampaign \
  --user-id 123
```

In response, the campaign returns a list of item recommendations \(movie IDs\) the user might like\. The list is sorted in descending order of relevance for the user\.

```
{
  "itemList": [
      {
          "itemId": "14"
      },
      {
          "itemId": "15"
      },
      {
          "itemId": "275"
      },
      {
          "itemId": "283"
      },
      {
          "itemId": "273"
      },
      ...
  ]
}
```