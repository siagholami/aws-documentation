# CloudWatch Metrics for Amazon Personalize<a name="cloudwatch-metrics"></a>

This section contains information about the Amazon CloudWatch metrics available for Amazon Personalize\. You can also see an aggregate view of Amazon Personalize metrics from the Amazon Personalize console\. For more information, see [Monitoring Amazon Personalize](personalize-monitoring.md)\.

The following table lists the Amazon Personalize metrics\. All metrics support these statistics: `Average, Minimum, Maximum, Sum`\.


| Metric | Description | 
| --- | --- | 
| DatasetImportJobRequests |  The number of successful [CreateDatasetImportJob](API_CreateDatasetImportJob.md) API calls\. Dimensions: `DatasetGroupArn, DatasetArn, DatasetImportJobArn`  | 
| DatasetImportJobError |  The number of `CreateDatasetImportJob` API calls that resulted in an error\. Dimensions: `DatasetGroupArn, DatasetArn, DatasetImportJobArn`  | 
| DatasetImportJobExecutionTime |  The time between the `CreateDatasetImportJob` API call and the completion \(or failure\) of the operation\. Dimensions: `DatasetGroupArn, DatasetArn, DatasetImportJobArn` Unit: Seconds  | 
| DatasetSize |  The size of data imported by the dataset import job\. Dimensions: `DatasetGroupArn, DatasetArn, DatasetImportJobArn` Unit: Bytes  | 
| SolutionTrainingJobRequests |  The number of successful [CreateSolutionVersion](API_CreateSolutionVersion.md) API calls\. Dimensions: `SolutionArn, SolutionVersionArn`  | 
| SolutionTrainingJobError |  The number of `CreateSolutionVersion` API calls that resulted in an error\. Dimensions: `SolutionArn, SolutionVersionArn`  | 
| SolutionTrainingJobExecutionTime |  The time between the `CreateSolutionVersion` API call and the completion \(or failure\) of the operation\. Dimensions: `SolutionArn, SolutionVersionArn` Unit: Seconds  | 
| GetPersonalizedRankingRequests |  The number of successful [GetPersonalizedRanking](API_RS_GetPersonalizedRanking.md) API calls\. Dimension: `CampaignArn`  | 
| GetPersonalizedRanking4xxErrors |  The number of `GetPersonalizedRanking` API calls that returned a 4xx HTTP response code\. Dimension: `CampaignArn`  | 
| GetPersonalizedRanking5xxErrors |  The number of `GetPersonalizedRanking` API calls that returned a 5xx HTTP response code\. Dimension: `CampaignArn`  | 
| GetPersonalizedRankingLatency |  The time between receiving the `GetPersonalizedRanking` API call and the sending of recommendations \(excludes 4xx and 5xx errors\)\. Dimension: `CampaignArn` Unit: Milliseconds  | 
| GetRecommendationsRequests |  The number of successful [GetRecommendations](API_RS_GetRecommendations.md) API calls\. Dimension: `CampaignArn`  | 
| GetRecommendations4xxErrors |  The number of `GetRecommendations` API calls that returned a 4xx HTTP response code\. Dimension: `CampaignArn`  | 
| GetRecommendations5xxErrors |  The number of `GetRecommendations` API calls that returned a 5xx HTTP response code\. Dimension: CampaignArn  | 
| GetRecommendationsLatency |  The time between receiving the `GetRecommendations` API call and the sending of recommendations \(excludes 4xx and 5xx errors\)\. Dimension: `CampaignArn` Unit: Milliseconds  | 
| PutEventsRequests |  The number of successful [PutEvents](API_UBS_PutEvents.md) API calls\. Dimension:` EventTrackerArn`  | 
| PutEvents4xxErrors |  The number of `PutEvents` API calls that returned a 4xx HTTP response code\. Dimension: `EventTrackerArn`  | 
| PutEvents5xxErrors |  The number of `PutEvents` API calls that returned a 5xx HTTP response code\. Dimension: `EventTrackerArn`  | 
| PutEventsLatency |  The time taken for the completion of the `PutEvents` API call \(excludes 4xx and 5xx errors\)\. Dimension: `EventTrackerArn` Unit: Milliseconds  | 