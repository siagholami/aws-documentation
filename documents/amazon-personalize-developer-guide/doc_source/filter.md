# Filtering Recommendations<a name="filter"></a>

When getting recommendations with Amazon Personalize, you can filter results based on custom criteria\. For example, you might not want to recommend products that a user has already purchased, or recommend movies that a user has already watched\. By filtering your recommendations, you can control the items that will be recommended to users\.

You create filters for a dataset group and apply filters to real\-time and batch recommendations at the campaign level\. To filter items, you first create a filter, which includes a SQL\-like filter expression based on a chosen event type or criteria\. You then apply the filter to a [GetRecommendations](API_RS_GetRecommendations.md), [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md) or [GetPersonalizedRanking](API_RS_GetPersonalizedRanking.md) call, or apply it to a campaign on the **Test campaign results** panel in the console\. You can create, edit, delete, and apply filters using the Amazon Personalize console, the AWS Command Line Interface, and the AWS SDK\. 

 For information on the number of filters you can create see [Service Quotas](limits.md#limits-table)\. 

**Note**  
To filter recommendations using a campaign you deployed before July 30, 2020, you must re\-deploy the campaign by using the [UpdateCampaign](API_UpdateCampaign.md) call or by creating a new campaign\.

**Topics**
+ [Filter Expressions](filter-expressions.md)
+ [Filtering Real\-time Recommendations](filter-real-time.md)
+ [Filtering Batch Recommendations](filter-batch.md)