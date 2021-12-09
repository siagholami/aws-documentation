# Evaluating a Solution Version<a name="working-with-training-metrics"></a>

Amazon Personalize generates a number of metrics when it creates a solution version\. These metrics allow you to evaluate the performance of the solution version before you create a campaign and provide recommendations\. Metrics allow you to view the effects of modifying a solution's hyperparameters\. You can also compare the metrics between solutions that use the same training data but created with different recipes\.

To get performance metrics, Amazon Personalize splits the input interactions data by randomly selecting 90% of users and their related interactions as training data and the other 10% as testing data\. The solution version is then created using the training data\. Afterwards, the solution version is given the oldest 90% of each user's testing data as input, and the recommendations it generates are compared against the real interactions given by the most recent 10% of testing data\.

For user\-personalization, it's recommended to run multiple recipes on your data to determine the optimal solution\. As a baseline, run the [Popularity\-Count](native-recipe-popularity.md) recipe, which recommends the top K most popular items\.

**Important**  
In order for Amazon Personalize to generate solution version metrics, you must have at least 10 datapoints in your input dataset group\.

## Metrics<a name="working-with-training-metrics-metrics"></a>

You retrieve the metrics for a specific solution version by calling the [GetSolutionMetrics](API_GetSolutionMetrics.md) operation\.

**Retrieve metrics using the AWS Python SDK**

1. Create a solution version\. For more information, see [Creating a Solution](training-deploying-solutions.md)\.

1. Use the following code to retrieve metrics\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   response = personalize.get_solution_metrics(
       solutionVersionArn = 'solution version arn')
   
   print(response['metrics'])
   ```

The following is an example of the output from a solution version created using the [HRNN](native-recipe-hrnn.md) recipe with the default solution configuration\.

```
{
    "solutionVersionArn": "arn:aws:personalize:us-west-2:acct-id:solution/MovieSolution/<version-id>",
    "metrics": {
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
```

The above metrics are described below using the following terms:
+ *Relevant recommendation* refers to a recommendation that matches a value in the testing data for the particular user\.
+ *Rank* refers to the position of a recommended item in the list of recommendations\. Position 1 \(the top of the list\) is presumed to be the most relevant to the user\.
+ *Query* refers to the internal equivalent of a [GetRecommendations](API_RS_GetRecommendations.md) call\.

For each metric, higher numbers are better\.

**coverage**  
The proportion of unique recommended items from all queries out of the total number of unique items in the training data \(includes both the Items and Interactions datasets\)\.

**mean\_reciprocal\_rank\_at\_25**  
The mean of the reciprocal ranks of the first relevant recommendation out of the top 25 recommendations over all queries\.  
This metric is appropriate if you're interested in the single highest ranked recommendation\.

**normalized\_discounted\_cumulative\_gain\_at\_K**  
Discounted gain assumes that recommendations lower on a list of recommendations are less relevant than higher recommendations\. Therefore, each recommendation is discounted \(given a lower weight\) by a factor dependent on its position\. To produce the cumulative discounted gain \(DCG\) at K, each relevant discounted recommendation in the top K recommendations is summed together\. The normalized discounted cumulative gain \(NDCG\) is the DCG divided by the ideal DCG such that NDCG is between 0 \- 1\. \(The ideal DCG is where the top K recommendations are sorted by relevance\.\)  
Amazon Personalize uses a weighting factor of `1/log(1 + position)`, where the top of the list is position `1`\.  
This metric rewards relevant items that appear near the top of the list, because the top of a list usually draws more attention\.

**precision\_at\_K**  
The number of relevant recommendations out of the top K recommendations divided by K\.  
This metric rewards precise recommendation of the relevant items\.

## Example<a name="working-with-training-metrics-example"></a>

The following is a simple example where, to generate metrics, a solution version produces a list of recommendations for a specific user\. The second and fifth recommendations match records in the testing data for this user\. These are the relevant recommendations\. If `K` is set at `5`, the following metrics are generated for the user\.

**reciprocal\_rank**  
Calculation: 1/2  
Result: 0\.5000

**normalized\_discounted\_cumulative\_gain\_at\_5**  
Calculation: \(1/log\(1 \+ 2\) \+ 1/log\(1 \+ 5\)\) / \(1/log\(1 \+ 1\) \+ 1/log\(1 \+ 2\)\)  
Result: 0\.6241

**precision\_at\_5**  
Calculation: 2/5  
Result: 0\.4000

Now that you have evaluated your solution version, create a campaign by deploying the optimum solution version\. For more information, see [Creating a Campaign](campaigns.md)\.

## More Info<a name="metrics-see-also"></a>

For a sample Jupyter notebook that shows you how to retrieve metrics based on hold\-out data, see [Personalize with temporal evaluation on hold\-out set](https://github.com/aws-samples/amazon-personalize-samples/blob/master/next_steps/core_use_cases/user_personalization/personalize_hrnn_metadata_example.ipynb)\.