# SIMS Recipe<a name="native-recipe-sims"></a>

The Item\-to\-item similarities \(SIMS\) recipe is based on the concept of collaborative filtering\. A SIMS model leverages user\-item interaction data to recommend items similar to a given item\. In the absence of sufficient user behavior data for an item, this recipe recommends popular items\.

This predefined recipe has the following properties:
+  **Name** – `aws-sims`
+  **Recipe Amazon Resource Name \(ARN\)** – `arn:aws:personalize:::recipe/aws-sims`
+  **Algorithm ARN** – `arn:aws:personalize:::algorithm/aws-sims`
+  **Feature transformation ARN** – `arn:aws:personalize:::feature-transformation/sims`
+  **Recipe type** – `RELATED_ITEMS`

The following table describes the hyperparameters for the SIMS recipe\. A *hyperparameter* is an algorithm parameter that you can adjust to improve model performance\. Algorithm hyperparameters control how the model performs\. Featurization hyperparameters control how to filter the data to use in training\. The process of choosing the best value for a hyperparameter is called hyperparameter optimization \(HPO\)\. For more information, see [Hyperparameters and HPO](customizing-solution-config-hpo.md)\. 

The table also provides the following information for each hyperparameter:
+ **Range**: \[lower bound, upper bound\]
+ **Value type**: Integer, Continuous \(float\), Categorical \(Boolean, list, string\)
+ **HPO tunable**: Can the parameter participate in hyperparameter optimization \(HPO\)?


| Name | Description | 
| --- | --- | 
| Algorithm Hyperparameters | 
| popularity\_discount\_factor |  Affects the balance between popularity and correlation when you calculate similarity\. If you calculate similarities to a specific item, a value of `0` makes the most popular items appear as recommendations regardless of their correlation\. A value of `1` makes most items that have co\-interactions \(shared interaction\) with the specific item appear as recommendations regardless of their popularity\. Using either extreme might create an overly long list of recommend items\. For most cases, a value around 0\.5 works best\. Default value: 0\.5 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: Yes  | 
| min\_cointeraction\_count |  The minimum number of co\-interactions you need to calculate the similarity between a pair of items\. For example, a value of `3` means that you need three or more users who interacted with both items for the algorithm to calculate their similarity\. Default value: 3 Range: \[0, 10\] Value type: Integer HPO tunable: Yes  | 
| Featurization Hyperparameters | 
| min\_user\_history\_length\_percentile |  The minimum percentile of user history lengths to include in model training\. *History length* is the total amount of available data on a user\. Use `min_user_history_length_percentile` to exclude a percentage of users with short history lengths\. Users with a short history often show patterns based on item popularity instead of the user's personal needs or wants\. Removing them can train models with more focus on underlying patterns in your data\. Choose an appropriate value after you review user history lengths, using a histogram or similar tool\. We recommend setting a value that retains the majority of users, but removes the edge cases\. Default value: 0\.005 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| max\_user\_history\_length\_percentile |  The maximum percentile of user history lengths to include in model training\. History length is the total amount of available data on a user\. Use `max_user_history_length_percentile` to exclude a percentage of users with long history lengths\. Users with a long history tend to contain noise\. For example, a robot might have a long list of automated interactions\. Removing these users limits noise in training\. Choose an appropriate value after you review user history lengths using a histogram or similar tool\. We recommend setting a value that retains the majority of users but removes the edge cases\. For example, `min_hist_length_percentile = 0.05` and `max_hist_length_percentile = 0.95` includes all users except ones with history lengths at the bottom or top 5%\. Default value: 0\.995 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| min\_item\_interaction\_count\_percentile |  The minimum percentile of item interaction counts to include in model training\. Use `min_item_interaction_count_percentile` to exclude a percentage of items with a short history of interactions\. Items with a short history often are new items\. Removing them can train models with more focus on items with a known history\. Choose an appropriate value after you review user history lengths, using a histogram or similar tool\. We recommend setting a value that retains the majority of items, but removes the edge cases\. Default value: 0\.01 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 
| max\_item\_interaction\_count\_percentile |  The maximum percentile of item interaction counts to include in model training\. Use `max_item_interaction_count_percentile` to exclude a percentage of items with a long history of interactions\. Items with a long history tend to be older and might be out of date\. For example, a movie release that is out of print\. Removing these items can focus on more relevant items\. Choose an appropriate value after you review user history lengths using a histogram or similar tool\. We recommend setting a value that retains the majority of items but removes the edge cases\. For example, `min_item_interaction_count_percentile = 0.05` and `max_item_interaction_count_percentile = 0.95` includes all items except ones with an interaction count at the bottom or top 5%\. Default value: 0\.9 Range: \[0\.0, 1\.0\] Value type: Float HPO tunable: No  | 

## SIMS Sample Notebook<a name="native-recipe-sims-more-info"></a>

For a sample Jupyter notebook that shows you how to use the SIMS recipe, see [Finding similar items \+ HPO](https://github.com/aws-samples/amazon-personalize-samples/blob/master/next_steps/core_use_cases/related_items/personalize_sims_example.ipynb)\.