# Monitoring Amazon Inspector using Amazon CloudWatch<a name="using-cloudwatch"></a>

You can monitor Amazon Inspector using Amazon CloudWatch, which collects and processes raw data into readable, near real\-time metrics\. By default, Amazon Inspector sends metric data to CloudWatch in 5\-minute periods\. You can use the AWS Management Console, the AWS CLI, or an API to view the metrics that Amazon Inspector sends to CloudWatch\. 

For more information about Amazon CloudWatch, see the [Amazon CloudWatch User Guide](http://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html)\.

## Amazon Inspector CloudWatchmetrics<a name="inspector_metrics"></a>

The Amazon Inspector namespace includes the following metrics\.

**`AssessmentTargetARN` metrics:**


| Metric | Description | 
| --- | --- | 
|  `TotalMatchingAgents`  |  Number of agents that match this target  | 
|  `TotalHealthyAgents`  |  Number of agents that match this target that are healthy  | 
|  `TotalAssessmentRuns`  |  Number of assessment runs for this target  | 
|  `TotalAssessmentRunFindings`  |  Number of findings for this target  | 

**`AssessmentTemplateARN` metrics:**


| Metric | Description | 
| --- | --- | 
|  `TotalMatchingAgents`  |  Number of agents that match this template  | 
|  `TotalHealthyAgents`  |  Number of agents that match this template that are healthy  | 
|  `TotalAssessmentRuns`  |  Number of assessment runs for this template  | 
|  `TotalAssessmentRunFindings`  |  Number of findings for this template  | 

**Aggregate metrics**


| Metric | Description | 
| --- | --- | 
|  `TotalAssessmentRuns`   |  Number of assessment runs in this AWS account  | 