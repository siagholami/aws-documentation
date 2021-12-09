# Getting Recommendations<a name="getting-recommendations"></a>

After you have created a campaign, you can use it in your applications to get recommendations\. The following topics explain how and when to use each recommendation type\.

**Topics**
+ [How Recommendation Scoring Works](#how-scores-work)
+ [Getting Real\-Time Recommendations](getting-real-time-recommendations.md)
+ [Getting Batch Recommendations](recommendations-batch.md)
+ [Filtering Recommendations](filter.md)

## How Recommendation Scoring Works<a name="how-scores-work"></a>

To make recommendations, Amazon Personalize generates scores for the items in your Items dataset based on a user's interaction data and metadata\. These scores represent the relative certainty that Amazon Personalize has in which item the user will select next\. Higher scores represent greater certainty\.

The formulas that calculate scores depend on the recommendation use case and the recipe that was used to train the model\. You can view item scores in the Amazon Personalize console or by using the [Amazon Personalize Runtime](https://docs.aws.amazon.com/personalize/latest/dg/API_Operations_Amazon_Personalize_Runtime.html) APIs\. For more information on how scores are calculated and what they mean, see [Getting Real\-Time Recommendations](getting-real-time-recommendations.md) and [Getting Batch Recommendations](recommendations-batch.md)\.