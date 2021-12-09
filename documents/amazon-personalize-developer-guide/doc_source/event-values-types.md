# Filtering Records from a User\-Interactions Training Dataset<a name="event-values-types"></a>

If your Interactions dataset includes data that you don't want to use for training, you can filter out those records by setting a threshold for a value, such as price, or by specifying a type of event, such as purchase or click\. By filtering, you can train using only a relevant subset of your data or remove noise to train a more optimized model\.

You can filter records from an Interactions dataset two ways:
+ **Set a threshold to exclude records based on a specific value by specifying an event value in your recipe** \- If the records include an amount that is associated with a specific event—for example, the price a user paid is associated with the purchase of an item—you can set a specific value in a recipe as a threshold to exclude records from training\. The amount is called an *event value*\. 
+ **Exclude records of a certain type by specifying an event type in your recipe** – A dataset often includes specific types of activities, for example, `“purchase”`, `“click”`, or `"wishlisted"`\. These are called *event types*\. To include only records for specific event types in training, filter your dataset by event type in your recipe\.

Likewise, an Interactions dataset often includes specific types of activities, for example, `“purchase”`, `“click”`, or `"wishlisted"`\. These are called *event types*\. To include only records for specific event types in training, filter your dataset by event type in your recipe\.

To filter by event value or event type, you create an Interactions schema for the recipe that you use to create your solution\. To use a more specific subset in training, you can also filter a dataset by an event value and event type\.

## Filtering Records by Event Value and Event Type<a name="event-values-types-example"></a>

In the following procedure, you use the AWS SDK for Python \(Boto3\) to create an Interaction schema that filters a training dataset\. You can use a Jupyter \(iPython\) notebook to accomplish the same task\. For more information, see [Getting Started Using Amazon Personalize APIs with Jupyter \(iPython\) Notebooks](getting-started-python.md#gs-jupyter-notebook)\.

**Prerequisites: **Complete the prerequisites and verify that your Python environment is set up as described in [Getting Started \(AWS SDK for Python\)](getting-started-python.md)\.

**To filter records used in a training dataset by event value or event type**

1. Create an Interaction schema and include the `EVENT_TYPE` and `EVENT_VALUE` fields using `"name"` and `"type"` key\-value pairs as shown\.

   ```
   import boto3
   import json
    
    
   personalize = boto3.client('personalize')
    
   # Create a name for your schema
   schema_name = 'YourSchemaName'
    
   # Define the schema for your dataset
   schema = {
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
               "name": "EVENT_VALUE",
               "type": "float"
           },
           {
               "name": "EVENT_TYPE",
               "type": "string"
           },
           { 
               "name": "TIMESTAMP",
               "type": "long"
           }
       ],
       "version": "1.0"
   }
    
   # Create the schema for Amazon Personalize
   create_schema_response = personalize.create_schema(
       name = schema_name,
       schema = json.dumps(schema)
   )
    
   #To get the schema ARN, use the following lines
   schema_arn = create_schema_response['schemaArn']
   print('Schema ARN:' + schema_arn )
   ```

1. Format your input data to match your schema\. For a code sample, see [Formatting Your Input Data](data-prep-formatting.md)\.

1. Upload your data to an Amazon Simple Storage Service \(Amazon S3\) bucket\. For a code sample, see [Uploading to an S3 Bucket](data-prep-upload-s3.md)\.

1. Import your data into Amazon Personalize with the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) API\. Be sure to record your dataset group Amazon Resource Name \(ARN\) because you will need it when you create the solution\. For a code sample, see [Import Your Data Using the AWS Python SDK](data-prep-importing.md#python-import-ex)\.

1. Get the ARN of the recipe that you want to use when you create your solution\. You'll need it when you create the solution\.

   ```
   import boto3
    
   personalize = boto3.client('personalize')
   
   # Display the ARNs of the recipes
   recipe_list = personalize.list_recipes()
   for recipe in recipe_list['recipes']:
       print(recipe['recipeArn'])
       
   # Store the ARN of the recipe that you want to use
    recipe_arn = "arn:aws:personalize:::recipe/aws-recipe-name"
   ```

1. Call the [CreateSolution](API_CreateSolution.md) API\. If you want to specify the event type, for example `“purchase”`, set it in the `eventType` parameter\. If you want to specify an event value, for example `10`, set it in the `eventValueThreshold` parameter\. You can also specify both an event type and an event value\.

   ```
   import boto3
    
   personalize = boto3.client('personalize')
   
   # Create the solution
   create_solution_response = personalize.create_solution(
       name = "your-solution-name",
       datasetGroupArn = dataset_group_arn,
       recipeArn = recipe_arn,
       "eventType": "purchase",
       solutionConfig = {
           "eventValueThreshold": "10"
       }
   )
   
   # Store the solution ARN
   solution_arn = create_solution_response['solutionArn']
   
   # Use the solution ARN to get the solution status
   solution_description = personalize.describe_solution(solutionArn = solution_arn)['solution']
   print('Solution status: ' + solution_description['status'])
   ```

1. When you have the solution, use it to train a model by specifying its solution ARN in a [CreateSolutionVersion](API_CreateSolutionVersion.md) request\.

   ```
   import boto3
    
   personalize = boto3.client('personalize')
   
   # Create a solution version
   create_solution_version_response = personalize.create_solution_version(solutionArn = solution_arn)
   
   
   # Store the solution version ARN
   solution_version_arn = create_solution_version_response['solutionVersionArn']
       
   # Use the solution version ARN to get the solution version status.
   solution_version_description = personalize.describe_solution_version(
       solutionVersionArn = solution_version_arn)['solutionVersion']
   print('Solution version status: ' + solution_version_description['status'])
   ```

Training is complete when the status is `ACTIVE`\. For more information, see [Creating a Solution](training-deploying-solutions.md)\.

After you train a model, you should evaluate its performance\. To optimize your model, you might want to adjust the `eventValueThreshold` or other hyperparameters\. For more information, see [Evaluating a Solution Version](working-with-training-metrics.md)\. 