# Viewing and Querying AWS Elemental MediaTailor ADS Logs<a name="monitor-cloudwatch-ads-logs"></a>

You can view and query AWS Elemental MediaTailor ADS logs using Amazon CloudWatch Logs Insights\. MediaTailor sends event logs to CloudWatch for normal processing and error conditions\. The logs adhere to a JSON schema\. Through CloudWatch Logs Insights, you can select logs by time frame, and then run queries against them\. 

For general information, see [Analyze Log Data with CloudWatch Logs Insights](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/AnalyzingLogData.html)\. 

**Note**  
To access the logs, you need permissions to access Amazon CloudWatch\. For instructions, see [Setting Up Permissions for Amazon CloudWatch](monitoring-permissions.md)\. 

**To view and query ADS logs using the CloudWatch console**

1. Open the CloudWatch console at [https://console.aws.amazon.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, under **Logs**, choose **Insights**\.

1. In the search bar, enter **ads\_inter**, and then from the dropdown list select `MediaTailor/AdDecisionServerInteractions`\.

1. \(Optional\) Adjust the time period that you want to study\. 

1. \(Optional\) Change the query in the dialog box\. For general guidance, see [CloudWatch Logs Insights Query Syntax](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/CWL_QuerySyntax.html)\. For examples of queries for MediaTailor ADS, see [Querying the ADS Logs](querying-the-ads-logs.md)\.

1. Choose **Run query**\. The query might take a few seconds, during which time **Cancel** appears in place of **Run query**\. 

1. \(Optional\) To export the results as a CSV file, choose **Actions**, and then choose **Download query results \(CSV\)**\. 

**Note**  
The console limits the number of records that it returns in query results and that it exports, so for bulk data, use the API, AWS CLI, or an SDK\.

**Topics**
+ [ADS Log Description](ads-log-description.md)
+ [Querying the ADS Logs](querying-the-ads-logs.md)
+ [ADS Log JSON Schema](ads-log-json-schema.md)