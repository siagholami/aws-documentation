# Monitoring AWS Elemental MediaTailor with Amazon CloudWatch Metrics<a name="monitoring-cloudwatch-metrics"></a>

You can monitor AWS Elemental MediaTailor metrics using CloudWatch\. CloudWatch collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

**To view metrics using the CloudWatch console**

1. Open the CloudWatch console at [https://console.aws.amazon.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Under **All metrics**, choose the **MediaTailor** namespace\. 

1. Select the metric dimension to view the metrics \(for example, **originID**\)\.

1. Specify the time period that you want to view\. 

**To view metrics using the AWS CLI**
+ At a command prompt, use the following command:

  ```
  aws cloudwatch list-metrics --namespace "AWS/MediaTailor"
  ```

## AWS Elemental MediaTailor CloudWatch Metrics<a name="metrics"></a>

The AWS Elemental MediaTailor namespace includes the following metrics\. These metrics are published by default to your account\. 


| Metric | Description | 
| --- | --- | 
| AdDecisionServer\.Ads |  The count of ads included in ad decision server \(ADS\) responses for the time period that you specified\.  | 
| AdDecisionServer\.Duration | The total duration, in milliseconds, of all ads that MediaTailor received from the ADS for the time period that you specified\.  | 
| AdDecisionServer\.Errors |  The number of non\-HTTP 200 status code responses, empty responses, and timed\-out responses that MediaTailor received from the ADS in the time period that you specified\.  | 
| AdDecisionServer\.FillRate | The simple average of the rates at which the responses from the ADS filled the corresponding individual ad avails for the time period that you specified\. To get the weighted average, calculate the `AdDecisionServer.Duration` as a percentage of the `Avail.Duration`\. For more information about simple and weighted averages, see [Simple and Weighted Averages](#metrics-simple-average)\. | 
| AdDecisionServer\.Timeouts |  The number of timed\-out requests to the ADS in the time period that you specified\.  | 
| AdNotReady |  The number of times that the ADS pointed at an ad that wasn't yet transcoded by the internal transcoder service in the time period that you specified\. A high value for this metric might contribute to a low overall `Avail.FillRate`\.  | 
| Avail\.Duration | The total duration, in milliseconds, of all ad avails that MediaTailor encountered in the time period that you specified\.  | 
| Avail\.FilledDuration | The total duration, in milliseconds, of ad avail time that MediaTailor filled with ads in the time period that you specified\. | 
| Avail\.FillRate |  The simple average of the rates at which MediaTailor filled the individual ad avails for the time period that you specified\.  To get the weighted average, calculate the `Avail.FilledDuration` as a percentage of the `Avail.Duration`\. For more information about simple and weighted averages, see [Simple and Weighted Averages](#metrics-simple-average)\. The maximum `Avail.FillRate` that MediaTailor can attain is bounded by the `AdDecisionServer.FillRate`\. If the `Avail.FillRate` is low, compare it to the `AdDecisionServer.FillRate`\. If the `AdDecisionServer.FillRate` is low, your ADS might not be returning enough ads for the avail durations\.   | 
| GetManifest\.Errors |  The number of errors received while MediaTailor was generating manifests in the time period that you specified\.  | 
|  `Origin.Errors`  |  The number of non\-HTTP 200 status code responses and timed\-out responses that MediaTailor received from the origin server in the time period that you specified\.  | 
| Origin\.Timeouts |  The number of timed\-out requests to the origin server in the time period that you specified\.  | 

### Simple and Weighted Averages<a name="metrics-simple-average"></a>

You can retrieve the simple average and the weighted average for the responses from the ADS to ad requests from MediaTailor and for how MediaTailor fills ad avails: 
+ The *simple averages* are provided in the `AdDecisionServer.FillRate` and the `Avail.FillRate`\. These are the averages of the fill rate percentages for the individual avails for the time period\. The simple averages don't take into account any differences between the durations of the individual avails\.
+ The *weighted averages* are the fill rate percentages for the sum of all avail durations\. These are calculated as \(`AdDecisionServer.Duration`\*100\)/`Avail.Duration` and \(`Avail.FilledDuration`\*100\)/`Avail.Duration`\. These averages reflect the differences in duration of each ad avail, giving more weight to those with longer duration\. 

For a time period that contains just a single ad avail, the simple average provided by the `AdDecisionServer.FillRate` is equal to the weighted average provided by \(`AdDecisionServer.Duration`\*100\)/`Avail.Duration`\. The simple average provided by the `Avail.FillRate` is equal to the weighted average provided by \(`Avail.FilledDuration`\*100\)/`Avail.Duration`\. 

**Example**

Assume the time period that you specified has the following two ad avails:
+ The first ad avail has 90 seconds duration:
  + The ADS response for the avail provides 45 seconds of ads \(50% filled\)\. 
  + MediaTailor fills 45 seconds worth of the ad time available \(50% filled\)\.
+ The second ad avail has 120 seconds duration: 
  + The ADS response for the avail provides 120 seconds of ads \(100% filled\)\. 
  + MediaTailor fills 90 seconds worth of the ad time available \(75% filled\)\.

The metrics are as follows: 
+ `Avail.Duration` is 210, the sum of the two ad avail durations: 90 \+ 120\.
+ `AdDecisionServer.Duration` is 165, the sum of the two response durations: 45 \+ 120\.
+ `Avail.FilledDuration` is 135, the sum of the two filled durations: 45 \+ 90\. 
+ `AdDecisionServer.FillRate` is 75%, the average of the percentages filled for each avail: \(50% \+ 100%\) / 2\. This is the simple average\.
+ The weighted average for the ADS fill rates is 78\.57%, which is `AdDecisionServer.Duration` as a percentage of the `Avail.Duration`: \(165\*100\) / 210\. This calculation accounts for the differences in the durations\. 
+ `Avail.FillRate` is 62\.5%, the average of the filled percentages for each avail: \(50% \+ 75%\) / 2\. This is the simple average\.
+ The weighted average for the MediaTailor avail fill rates is 64\.29%, which is the `Avail.FilledDuration` as a percentage of the `Avail.Duration`: \(135\*100\) / 210\. This calculation accounts for the differences in the durations\. 

The highest `Avail.FillRate` that MediaTailor can attain for any ad avail is 100%\. The ADS might return more ad time than is available in the avail, but MediaTailor can only fill the time available\. 

## AWS Elemental MediaTailor CloudWatch Dimensions<a name="dimensions"></a>

You can filter the AWS Elemental MediaTailor data using the following dimension\.


| Dimension | Description | 
| --- | --- | 
|  `Configuration Name`  |  Indicates the configuration that the metric belongs to\.  | 