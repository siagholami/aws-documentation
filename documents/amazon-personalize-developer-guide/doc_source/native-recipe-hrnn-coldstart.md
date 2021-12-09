# HRNN\-Coldstart Recipe<a name="native-recipe-hrnn-coldstart"></a>

Use the HRNN\-Coldstart recipe to predict the items that a user will interact with when you frequently add new items and interactions and want to get recommendations for those items immediately\. The HRNN\-Coldstart recipe is similar to the [HRNN\-Metadata](native-recipe-hrnn-metadata.md) recipe, but it allows you to get recommendations for new items\. 

In addition, you can use the HRNN\-Coldstart recipe when you want to exclude from training items that have a long list of interactions either because of a recent popularity trend or because the interactions might be highly unusual and introduce noise in training\. With HRNN\-Coldstart, you can filter out less relevant items to create a subset for training\. The subset of items, called *cold items*, are items that have related interaction events in the Interactions dataset\. An item is considered a cold item when it has the following:
+ Fewer interactions than a specified number of maximum interactions\. You specify this value in the recipe's `cold_start_max_interactions` hyperparameter\.
+ A shorter relative duration than the maximum duration\. You specify this value in the recipe's `cold_start_max_duration` hyperparameter\.

To reduce the number of cold items, set a lower value for `cold_start_max_interactions` or `cold_start_max_duration`\. To increase the number of cold items, set a greater value for `cold_start_max_interactions` or `cold_start_max_duration`\.

HRNN\-Coldstart has the following cold item limits:
+ `Maximum cold start items`: 80,000
+ `Minimum cold start items`: 100

If the number of cold items is outside this range, attempts to create a solution will fail\.

The HRNN\-Coldstart recipe has the following properties:
+  **Name** – `aws-hrnn-coldstart`
+  **Recipe Amazon Resource Name \(ARN\)** – `arn:aws:personalize:::recipe/aws-hrnn-coldstart`
+  **Algorithm ARN** – `arn:aws:personalize:::algorithm/aws-hrnn-coldstart`
+  **Feature transformation ARN** – `arn:aws:personalize:::feature-transformation/featurize_coldstart`
+  **Recipe type** – `USER_PERSONALIZATION`

For more information, see [Choosing a Recipe](working-with-predefined-recipes.md)\.

The following table describes the hyperparameters for the HRNN\-Coldstart recipe\. A *hyperparameter* is an algorithm parameter that you can adjust to improve model performance\. Algorithm hyperparameters control how the model performs\. Featurization hyperparameters control how to filter the data to use in training\. The process of choosing the best value for a hyperparameter is called hyperparameter optimization \(HPO\)\. For more information, see [Hyperparameters and HPO](customizing-solution-config-hpo.md)\. 

The table also provides the following information for each hyperparameter:
+ **Range**: \[lower bound, upper bound\]
+ **Value type**: Integer, Continuous \(float\), Categorical \(Boolean, list, string\)
+ **HPO tunable**: Can the parameter participate in HPO?


| Name | Description | 
| --- | --- | 
| Algorithm Hyperparameters | 
| hidden\_dimension | The number of hidden variables used in the model\. *Hidden variables* recreate users' purchase history and item statistics to generate ranking scores\. Specify a greater number of hidden dimensions when your Interactions dataset includes more complicated patterns\. Using more hidden dimensions requires a larger dataset and more time to process\. To decide on the optimal value, use HPO\. To use HPO, set `performHPO` to `true` when you call [CreateSolution](API_CreateSolution.md) and [CreateSolutionVersion](API_CreateSolutionVersion.md) operations\. Default value: 149 Range: \[32, 256\] Value type: Integer HPO tunable: Yes  | 
| bptt | Determines whether to use the back\-propagation through time technique\. *Back\-propagation through time* is a technique that updates weights in recurrent neural network\-based algorithms\. Use `bptt` for long\-term credits to connect delayed rewards to early events\. For example, a delayed reward can be a purchase made after several clicks\. An early event can be an initial click\. Even within the same event types, such as a click, it’s a good idea to consider long\-term effects and maximize the total rewards\. To consider long\-term effects, use larger `bptt` values\. Using a larger `bptt` value requires larger datasets and more time to process\. Default value: 32 Range: \[2, 32\] Value type: Integer HPO tunable: Yes  | 
| recency\_mask |  Determines whether the model should consider the latest popularity trends in the Interactions dataset\. Latest popularity trends might include sudden changes in the underlying patterns of interaction events\. To train a model that places more weight on recent events, set `recency_mask` to `true`\. To train a model that equally weighs all past interactions, set `recency_mask` to `false`\. To get good recommendations using an equal weight, you might need a larger training dataset\. Default value: `True` Range: `True` or `False` Value type: Boolean HPO tunable: Yes  | 
| Featurization Hyperparameters | 
| cold\_start\_max\_interactions |  The maximum number of user\-item interactions an item can have to be considered a cold item\. Default value: 15 Range: Positive integers Value type: Integer HPO tunable: No  | 
| cold\_start\_max\_duration | The maximum duration in days relative to the starting point for a user\-item interaction to be considered a cold start item\. To set the starting point of the user\-item interaction, set the `cold_start_relative_from` hyperparameter\. Default value: 5\.0 Range: Positive floats Value type: Float HPO tunable: No  | 
| cold\_start\_relative\_from |  Determines the starting point for the HRNN\-Coldstart recipe to calculate `cold_start_max_duration`\. To calculate from the current time, choose `currentTime`\. To calculate `cold_start_max_duration` from the timestamp of the latest item in the Interactions dataset, choose `latestItem`\. This setting is useful if you frequently add new items\. Default value: `latestItem` Range: `currentTime`, `latestItem` Value type: String HPO tunable: No  | 
| min\_user\_history\_length\_percentile |  The minimum percentile of user history lengths to include in model training\. *History length* is the total amount of data about a user\. Use `min_user_history_length_percentile` to exclude a percentage of users with short history lengths\. Users with a short history often show patterns based on item popularity instead of the user's personal needs or wants\. Removing them can train models with more focus on underlying patterns in your data\. Choose an appropriate value after you review user history lengths, using a histogram or similar tool\. We recommend setting a value that retains the majority of users, but removes the edge cases\.  For example, setting `min__user_history_length_percentile to 0.05` and `max_user_history_length_percentile to 0.95` includes all users except those with history lengths at the bottom or top 5%\. Default value: 0\.0 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| max\_user\_history\_length\_percentile |  The maximum percentile of user history lengths to include in model training\. *History length* is the total amount of data about a user\. Use `max_user_history_length_percentile` to exclude a percentage of users with long history lengths because data for these users tend to contain noise\. For example, a robot might have a long list of automated interactions\. Removing these users limits noise in training\. Choose an appropriate value after you review user history lengths using a histogram or similar tool\. We recommend setting a value that retains the majority of users but removes the edge cases\. For example, setting `min__user_history_length_percentile to 0.05` and `max_user_history_length_percentile to 0.95` includes all users except those with history lengths at the bottom or top 5%\. Default value: 0\.99 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 

## HRNN\-Coldstart Sample Notebook<a name="hrnn-coldstart-sample-notebooks"></a>

For a sample Jupyter notebook that shows how to use the HRNN\-Coldstart recipe, see [Handling cold or new items with Amazon Personalize](https://github.com/aws-samples/amazon-personalize-samples/blob/master/next_steps/core_use_cases/user_personalization/personalize_hrnn_coldstart_example.ipynb)\.