# User\-Personalization Recipe<a name="native-recipe-new-item-USER_PERSONALIZATION"></a>

The User\-Personalization \(aws\-user\-personalization\) recipe is optimized for all USER\_PERSONALIZATION recommendation scenarios\. When recommending items, it uses automatic item exploration\.

With automatic exploration, Amazon Personalize automatically tests different item recommendations, learns from how users interact with these recommended items, and boosts recommendations for items that drive better engagement and conversion\. This improves item discovery and engagement when you have a fast\-changing catalog, or when new items, such as news articles or promotions, are more relevant to users when fresh\. 

You can balance how much to explore \(where items with less interactions data or relevance are recommended more frequently\) against how much to exploit \(where recommendations are based on what we know or relevance\)\. Amazon Personalize automatically adjusts future recommendations based on implicit user feedback\.

**Working with Impressions Data**

 Unlike other recipes, which solely use positive interactions \(clicking, watching, or purchasing\), the User\-Personalization recipe can also use impressions data\. Impressions are lists of items that were visible to the user when they interacted with \(clicked, watched, purchased, and so on\) a particular item\. 

Using this information, a solution trained with the User\-Personalization recipe can quickly infer the suitability of new items based on how frequently an item has been ignored, and change recommendation accordingly\. For more information see [Impressions Data](data-prep-formatting.md#data-prep-impressions-data)\. 

## Properties and Hyperparameters<a name="bandit-hyperparameters"></a>

The User\-Personalization recipe has the following properties:
+  **Name** – `aws-user-personalization`
+  **Recipe Amazon Resource Name \(ARN\)** – `arn:aws:personalize:::recipe/aws-user-personalization`
+  **Algorithm ARN** – `arn:aws:personalize:::algorithm/aws-user-personalization`

For more information, see [Choosing a Recipe](working-with-predefined-recipes.md)\.

The following table describes the hyperparameters for the User\-Personalization recipe\. A *hyperparameter* is an algorithm parameter that you can adjust to improve model performance\. Algorithm hyperparameters control how the model performs\. Featurization hyperparameters control how to filter the data to use in training\. The process of choosing the best value for a hyperparameter is called hyperparameter optimization \(HPO\)\. For more information, see [Hyperparameters and HPO](customizing-solution-config-hpo.md)\. 

The table also provides the following information for each hyperparameter:
+ **Range**: \[lower bound, upper bound\]
+ **Value type**: Integer, Continuous \(float\), Categorical \(Boolean, list, string\)
+ **HPO tunable**: Can the parameter participate in HPO?


| Name | Description | 
| --- | --- | 
| Algorithm Hyperparameters | 
| hidden\_dimension |  The number of hidden variables used in the model\. *Hidden variables* recreate users' purchase history and item statistics to generate ranking scores\. Specify a greater number of hidden dimensions when your Interactions dataset includes more complicated patterns\. Using more hidden dimensions requires a larger dataset and more time to process\. To decide on the optimal value, use HPO\. To use HPO, set `performHPO` to `true` when you call [CreateSolution](API_CreateSolution.md) and [CreateSolutionVersion](API_CreateSolutionVersion.md) operations\. Default value: 149 Range: \[32, 256\] Value type: Integer HPO tunable: Yes  | 
| bptt |  Determines whether to use the back\-propagation through time technique\. *Back\-propagation through time* is a technique that updates weights in recurrent neural network\-based algorithms\. Use `bptt` for long\-term credits to connect delayed rewards to early events\. For example, a delayed reward can be a purchase made after several clicks\. An early event can be an initial click\. Even within the same event types, such as a click, it’s a good idea to consider long\-term effects and maximize the total rewards\. To consider long\-term effects, use larger `bptt` values\. Using a larger `bptt` value requires larger datasets and more time to process\. Default value: 32 Range: \[2, 32\] Value type: Integer HPO tunable: Yes  | 
| recency\_mask |  Determines whether the model should consider the latest popularity trends in the Interactions dataset\. Latest popularity trends might include sudden changes in the underlying patterns of interaction events\. To train a model that places more weight on recent events, set `recency_mask` to `true`\. To train a model that equally weighs all past interactions, set `recency_mask` to `false`\. To get good recommendations using an equal weight, you might need a larger training dataset\. Default value: `True` Range: `True` or `False` Value type: Boolean HPO tunable: Yes  | 
| Featurization Hyperparameters | 
| min\_user\_history\_length\_percentile |  The minimum percentile of user history lengths to include in model training\. *History length* is the total amount of data about a user\. Use `min_user_history_length_percentile` to exclude a percentage of users with short history lengths\. Users with a short history often show patterns based on item popularity instead of the user's personal needs or wants\. Removing them can train models with more focus on underlying patterns in your data\. Choose an appropriate value after you review user history lengths, using a histogram or similar tool\. We recommend setting a value that retains the majority of users, but removes the edge cases\.  For example, setting `min_user_history_length_percentile to 0.05` and `max_user_history_length_percentile to 0.95` includes all users except those with history lengths at the bottom or top 5%\. Default value: 0\.0 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| max\_user\_history\_length\_percentile |  The maximum percentile of user history lengths to include in model training\. *History length* is the total amount of data about a user\. Use `max_user_history_length_percentile` to exclude a percentage of users with long history lengths because data for these users tend to contain noise\. For example, a robot might have a long list of automated interactions\. Removing these users limits noise in training\. Choose an appropriate value after you review user history lengths using a histogram or similar tool\. We recommend setting a value that retains the majority of users but removes the edge cases\. For example, setting `min_user_history_length_percentile to 0.05` and `max_user_history_length_percentile to 0.95` includes all users except those with history lengths at the bottom or top 5%\. Default value: 0\.99 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| Item Exploration Configuration Hyperparameters | 
| exploration\_weight |  Determines how frequently recommendations include items with less interactions data or relevance\. The closer the value is to 1\.0, the more exploration\. At zero, no exploration occurs and recommendations are based on current data \(relevance\)\. Default value: 0\.3 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| exploration\_item\_age\_cut\_off |  Determines items to be explored based on time frame since latest interaction\. Provide the maximum item age, in days since the latest interaction, to define the scope of item exploration\. The larger the value, the more items are considered during exploration\. Default value: 30\.0 Range: Positive floats Value type: Float HPO tunable: No  | 

## Training with the User\-Personalization recipe \(Console\)<a name="training-user-personalization-recipe-console"></a>

To use the User\-Personalization recipe to generate recommendations in the console, first train a new solution version using the recipe\. Then deploy a campaign using the solution version and use the campaign to get recommendations\.

**Training a new solution version with the User\-Personalization recipe \(console\)**

1. Open the Amazon Personalize console at [https://console\.aws\.amazon\.com/personalize/](https://console.aws.amazon.com/personalize/) and sign into your account\. 

1. Create a dataset group with a new schema and upload your dataset with impressions data\. Optionally include [CREATION\_TIMESTAMP](data-prep-formatting.md#creation-timestamp-data) data in your Items dataset so Amazon Personalize can more accurately calculate the age of an item and identify cold items\. 

   For more information on creating dataset groups and uploading training data, see [Step 1: Import Training Data](getting-started-console.md#getting-started-console-import-dataset) in the Getting Started tutorial\.

1. On the **Dataset groups** page, choose the new dataset group that contains the dataset or datasets with impressions data\. 

1. In the navigation pane, choose **Solutions and recipes** and choose **Create solution**\.

1. On the **Create solution** page, for the **Solution name**, enter the name of your new solution\.

1. For **Recipe**, choose **aws\-user\-personalization**\. The **Solution configuration** section appears providing several configuration options\. 

1.  Specify the following: 
   +  **Event type:** If your data has multiple event types, enter the event type, such as click or download, to use for training\. 
   +  **Event value threshold:** Enter a value to define which events to use for training\. Only events with a value greater than or equal to this value will be used for training\. 

   For example, suppose that your application rates user interest in videos based on the percentage of a video watched by the user, with values greater than 70 indicating high interest\. If you want to use only high\-interest events for training, for the **Event type** enter *watched* and for **Event value threshold** enter *70*\. Only videos with a *watched* value greater than *70* will be used for training\.

1. Optionally configure hyperparameters for your solution\. For a list of User\-Personalization recipe properties and hyperparameters, see [Properties and Hyperparameters](#bandit-hyperparameters)\. 

1. Choose **Next**\. You can review your settings on the **Create solution version** page\.

1. Choose **Finish** to create the solution version\.

   On the solution details page, you can track training progress in the **Solution versions** section\. When training is complete, the status is **Active**\.

**Creating a campaign and getting recommendations \(console\)**

 When your solution version status is **Active** you are ready to create your campaign and get recommendations as follows: 

1. On either the solution details page or the **Campaigns** page, choose **Create new campaign**\.

1.  On the **Create new campaign** page, for **Campaign details**, provide the following information: 
   + **Campaign name:** Enter the name of the campaign\. The text you enter here appears on the Campaign dashboard and details page\.
   + **Solution:** Choose the solution that you just created\.
   + **Solution version ID:** Choose the ID of the solution version that you just created\.
   + **Minimum provisioned transactions per second:** Set the minimum provisioned transactions per second that Amazon Personalize supports\. For more information, see the [CreateCampaign](API_CreateCampaign.md) operation\.

1. For **Campaign configuration**, provide the following information:
   + **Exploration weight:** Configure how much to explore, where recommendations include items with less interactions data or relevance more frequently the more exploration you specify\. The closer the value is to 1, the more exploration\. At zero, no exploration occurs and recommendations are based on current data \(relevance\)\.
   + **Exploration item age cut off**: Enter the maximum item age, in days since the latest interaction, to define the scope of item exploration\. To increase the number of items Amazon Personalize considers during exploration, enter a greater value\. 

      For example, if you enter 10, only items with interactions data from the 10 days since the latest interaction in the dataset are considered during exploration\. 
**Note**  
Recommendations might include items without interactions data from outside this time frame\. This is because these items are relevant to the user's interests, and exploration wasn't required to identify them\.

1. Choose **Create campaign**\.

1. On the campaign details page, when the campaign status is **Active**, you can use the campaign to get recommendations and record impressions\. For more information, see [Step 4: Get Recommendations](getting-started-console.md#getting-started-console-get-recommendations) in "Getting Started\."

## Training with the User\-Personalization Recipe \( SDK\)<a name="training-user-personalization-recipe"></a>

When you have created a dataset group and uploaded your dataset\(s\) with impressions data, you can train a solution with the User\-Personalization recipe\. Optionally include [CREATION\_TIMESTAMP](data-prep-formatting.md#creation-timestamp-data) data in your dataset so Amazon Personalize can more accurately calculate the age of an item and identify cold start items\. For more information on creating dataset groups and uploading training data see [Datasets and Schemas](how-it-works-dataset-schema.md)\.

**To train a solution with the User\-Personalization recipe using the AWS SDK**

1. Create a new solution using the `create_solution` method\.

   Replace `solution name` with your solution name and `dataset group arn` with the Amazon Resource Name \(ARN\) of your dataset group\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   print('Creating solution')
   create_solution_response = personalize.create_solution(name='solution name', 
                               recipeArn= arn:aws:personalize:::recipe/aws-user-personalization, 
                               datasetGroupArn = 'dataset group arn',
                               )
   solution_arn = create_solution_response['solutionArn']
   print('solution_arn: ', solution_arn)
   ```

   For a list of aws\-user\-personalization recipe properties and hyperparameters, see [Properties and Hyperparameters](#bandit-hyperparameters)\.

1. Create a new *solution version* with the updated training data and set `trainingMode` to `FULL` using the following code snippet\. Replace the `solution arn` with the ARN of your solution\.

   ```
   import boto3
           
   personalize = boto3.client('personalize')
           
   create_solution_version_response = personalize.create_solution_version(solutionArn = 'solution arn', 
                                                                  trainingMode='FULL')
   
   new_solution_version_arn = create_solution_version_response['solutionVersionArn']
   print('solution_version_arn:', new_solution_version_arn)
   ```

1. When Amazon Personalize is finished creating your solution version, create your campaign with the following parameters:
   + Provide a new `campaign name` and the `solution version arn` generated in step 2\.
   + Modify the `explorationWeight` item exploration configuration hyperparameter to configure how much to explore\. Items with less interactions data or relevance are recommended more frequently the closer the value is to 1\.0\. The default value is 0\.3\.
   + Modify the `explorationItemAgeCutOff` item exploration configuration hyperparameter parameter to provide the maximum duration, in days relative to the latest interaction, for which items should be explored\. The larger the value, the more items are considered during exploration\.

   Use the following Python snippet to create a new campaign with an emphasis on exploration with exploration cut\-off at 30 days\.

   ```
   import boto3
           
   personalize = boto3.client('personalize')
   
   create_campaign_response = personalize.create_campaign(
       name = 'campaign name',
       solutionVersionArn = 'solution version arn',
       minProvisionedTPS = 1,
       campaignConfig = {"itemExplorationConfig": {"explorationWeight": "0.3", "explorationItemAgeCutOff": "30"}}
   )
   
   campaign_arn = create_campaign_response['campaignArn']
   print('campaign_arn:', campaign_arn)
   ```
**Note**  
Creating a campaign usually takes a few minutes but can take over an hour\.

## Getting Recommendations and Recording Impressions \(SDK\)<a name="user-personalization-get-recommendations-recording-impressions"></a>

When your campaign is created, you can use it to get recommendations for a user and record impressions\. For information on getting batch recommendations using the AWS SDK see [Getting Batch Recommendations \(AWS Python SDK\)](recommendations-batch.md#batch-sdk)\.

**To get recommendations and record impressions**

1. Call the `get_recommendations` method\. Change the `campaign arn` to the ARN of your new campaign and `user id` to the userId of the user\.

   ```
   import boto3
               
   rec_response = personalize_runtime.get_recommendations(campaignArn = 'campaign arn', userId = 'user id')
   print(rec_response['recommendationId'])
   ```

1. Create a new event tracker for sending PutEvents requests\. Replace `event tracker name` with the name of your event tracker and `dataset group arn` with the ARN of your dataset group\.

   ```
   import boto3
           
   personalize = boto3.client('personalize')
   
   event_tracker_response = personalize.create_event_tracker( 
       name = 'event tracker name',
       datasetGroupArn = 'dataset group arn'
   )
   event_tracker_arn = event_tracker_response['eventTrackerArn']
   event_tracking_id = event_tracker_response['trackingId']
   print('eventTrackerArn:{},\n eventTrackingId:{}'.format(event_tracker_arn, event_tracking_id))
   ```

1.  Use the `recommendationId` from step 1 and the `event tracking id` from step 2 to create a new `PutEvents` request\. This request logs the new impression data from the user’s session\. Change the `user id` to the ID of the user\. 

   ```
   import boto3
               
   personalize_events.put_events(
        trackingId = 'event tracking id',
        userId= 'user id',
        sessionId = '1',
        eventList = [{
        'sentAt': datetime.now().timestamp(),
        'eventType' : 'click',
        'itemId' : rec_response['itemList'][0]['itemId'],        
        'recommendationId': rec_response['recommendationId'],
        'impression': [item['itemId'] for item in rec_response['itemList']],
        }]
   )
   ```

## Sample Jupyter Notebook<a name="bandits-sample-notebooks"></a>

For a sample Jupyter notebook that shows how to use the User\-Personalization recipe, see [User Personalization with Exploration](https://github.com/aws-samples/amazon-personalize-samples/blob/master/next_steps/core_use_cases/user_personalization/user-personalization-with-exploration.ipynb)\.