# Monitoring CodeGuru Reviewer with Amazon CloudWatch<a name="monitoring"></a>

 You can use Amazon CloudWatch to monitor the number of recommendations created for your source code in an associated repository over time\. 

The recommendations are available for three *dimensions*: 
+  `ProviderType` — View the number of recommendations for a provider type\. You can view the count of recommendations in all repositories in AWS CodeCommit, your Bitbucket account, your GitHub account, or your GitHub Enterprise Server account, over a period of time\. 
+  `CodeReviewType` — View the number of recommendations a code review types\. The one available code review type is `PullRequest`\. Use it to view the count of recommendations in one pull request\. 
+  `RepositoryName` — View the count of recommendations for one repository over a period of time\. 

 You can set a CloudWatch alarm that notifies you when the number of recommendations exceeds a threshold you set\. 

 For more information about creating and using CloudWatch alarms and metrics, see [Using Amazon CloudWatch metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html)\. 

 You can track the following metric for each dimension over a period of time\. 


****  

|   Metric   |   Description   | 
| --- | --- | 
| RecommendationsPublishedCount |  The number of recommendations over a period of time per `ProviderType`, `CodeReviewType`, or `RepositoryName` for completed code reviews\. Units: Count Valid CloudWatch statistic: Count Valid CloudWatch period: 1 hour  | 

**Topics**
+ [Monitoring profiling groups with CloudWatch metrics](cloudwatch-metric.md)
+ [Monitoring CodeGuru Reviewer recommendations with CloudWatch alarms](cloudwatch-alarm.md)