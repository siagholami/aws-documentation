# HRNN Recipe<a name="native-recipe-hrnn"></a>

The Amazon Personalize hierarchical recurrent neural network \(HRNN\) recipe models changes in user behavior to provide recommendations during a session\. A session is a set of user interactions within a given timeframe with a goal of finding a specific item to fill a need, for example\. By weighting a user's recent interactions higher, you can provide more relevant recommendations during a session\.

HRNN accommodates user intent and interests, which can change over time\. It takes ordered user histories and automatically weights them to make better inferences\. HRNN uses a gating mechanism to model the discount weights as a learnable function of the items and timestamps\.

Amazon Personalize derives the features for each user from your dataset\. If you have done real\-time data integration, these features are updated in real time according to user activity\. To get a recommendation, you provide only the `USER_ID`\. If you also provide an `ITEM_ID`, Amazon Personalize ignores it\.

The HRNN recipe has the following properties:
+  **Name** – `aws-hrnn`
+  **Recipe Amazon Resource Name \(ARN\)** – `arn:aws:personalize:::recipe/aws-hrnn`
+  **Algorithm ARN** – `arn:aws:personalize:::algorithm/aws-hrnn`
+  **Feature transformation ARN** – `arn:aws:personalize:::feature-transformation/JSON-percentile-filtering`
+  **Recipe type** – `USER_PERSONALIZATION`

The following table describes the hyperparameters for the HRNN recipe\. A *hyperparameter* is an algorithm parameter that you can adjust to improve model performance\. Algorithm hyperparameters control how the model performs\. Featurization hyperparameters control how to filter the data to use in training\. The process of choosing the best value for a hyperparameter is called hyperparameter optimization \(HPO\)\. For more information, see [Hyperparameters and HPO](customizing-solution-config-hpo.md)\. 

The table also provides the following information for each hyperparameter:
+ **Range**: \[lower bound, upper bound\]
+ **Value type**: Integer, Continuous \(float\), Categorical \(Boolean, list, string\)
+ **HPO tunable**: Can the parameter participate in HPO?


| Name | Description | 
| --- | --- | 
| Algorithm Hyperparameters | 
| hidden\_dimension |  The number of hidden variables used in the model\. *Hidden variables* recreate users' purchase history and item statistics to generate ranking scores\. Specify a greater number of hidden dimensions when your Interactions dataset includes more complicated patterns\. Using more hidden dimensions requires a larger dataset and more time to process\. To decide on the optimal value, use HPO\. To use HPO, set `performHPO` to `true` when you call [CreateSolution](API_CreateSolution.md) and [CreateSolutionVersion](API_CreateSolutionVersion.md) operations\. Default value: 43 Range: \[32, 256\] Value type: Integer HPO tunable: Yes  | 
| bptt |  Determines whether to use the back\-propagation through time technique\. *Back\-propagation through time* is a technique that updates weights in recurrent neural network\-based algorithms\. Use `bptt` for long\-term credits to connect delayed rewards to early events\. For example, a delayed reward can be a purchase made after several clicks\. An early event can be an initial click\. Even within the same event types, such as a click, it’s a good idea to consider long\-term effects and maximize the total rewards\. To consider long\-term effects, use larger `bptt` values\. Using a larger `bptt` value requires larger datasets and more time to process\. Default value: 32 Range: \[2, 32\] Value type: Integer HPO tunable: Yes  | 
| recency\_mask |  Determines whether the model should consider the latest popularity trends in the Interactions dataset\. Latest popularity trends might include sudden changes in the underlying patterns of interaction events\. To train a model that places more weight on recent events, set `recency_mask` to `true`\. To train a model that equally weighs all past interactions, set `recency_mask` to `false`\. To get good recommendations using an equal weight, you might need a larger training dataset\. Default value: `True` Range: `True` or `False` Value type: Boolean HPO tunable: Yes  | 
| Featurization Hyperparameters | 
| min\_user\_history\_length\_percentile |  The minimum percentile of user history lengths to include in model training\. *History length* is the total amount of data about a user\. Use `min_user_history_length_percentile` to exclude a percentage of users with short history lengths\. Users with a short history often show patterns based on item popularity instead of the user's personal needs or wants\. Removing them can train models with more focus on underlying patterns in your data\. Choose an appropriate value after you review user history lengths, using a histogram or similar tool\. We recommend setting a value that retains the majority of users, but removes the edge cases\.  For example, setting `min__user_history_length_percentile to 0.05` and `max_user_history_length_percentile to 0.95` includes all users except those with history lengths at the bottom or top 5%\. Default value: 0\.0 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| max\_user\_history\_length\_percentile |  The maximum percentile of user history lengths to include in model training\. *History length* is the total amount of data about a user\. Use `max_user_history_length_percentile` to exclude a percentage of users with long history lengths because data for these users tend to contain noise\. For example, a robot might have a long list of automated interactions\. Removing these users limits noise in training\. Choose an appropriate value after you review user history lengths using a histogram or similar tool\. We recommend setting a value that retains the majority of users but removes the edge cases\. For example, setting `min__user_history_length_percentile to 0.05` and `max_user_history_length_percentile to 0.95` includes all users except those with history lengths at the bottom or top 5%\. Default value: 0\.99 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 

## HRNN Sample Notebooks<a name="hrnn-sample-notebooks"></a>

The following Jupyter notebooks show how to use the HRNN recipe: 
+  For a sample notebook that shows how to use HRNN with a hold\-out set, see [Amazon Personalize with temporal evaluation on hold\-out set](https://github.com/aws-samples/amazon-personalize-samples/blob/master/next_steps/core_use_cases/user_personalization/personalize_hrnn_metadata_example.ipynb)\.
+  For a sample notebook that shows how to use HRNN with the `PutEvents` API, see [Using the PutEvents API with Amazon Personalize](https://github.com/aws-samples/amazon-personalize-samples/blob/master/next_steps/core_use_cases/user_personalization/personalize_hrrn_example.ipynb)\.