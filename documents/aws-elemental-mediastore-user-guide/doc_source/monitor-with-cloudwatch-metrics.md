# Monitoring AWS Elemental MediaStore with Amazon CloudWatch metrics<a name="monitor-with-cloudwatch-metrics"></a>

You can monitor AWS Elemental MediaStore using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

For AWS Elemental MediaStore, you might want to watch `BytesDownloaded` and send an email to yourself when that metric reaches a certain threshold\.

**To view metrics using the CloudWatch console**

Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Under **All metrics**, choose the **AWS/MediaStore** namespace\.

1. Choose the metric dimension to view the metrics\. For example, choose `Request metrics by container` to view metrics for the different types of requests that have been sent to the container\.

**To view metrics using the AWS CLI**
+ At a command prompt, use the following command:

  ```
  aws cloudwatch list-metrics --namespace "AWS/MediaStore"
  ```

## AWS Elemental MediaStore metrics<a name="monitor-with-cloudwatch-metrics-for-mediastore"></a>

The following table lists metrics that AWS Elemental MediaStore sends to CloudWatch\.

**Note**  
To view metrics, you must [add a metric policy](policies-metric-add.md#policies-metric-add.title) to the container to allow MediaStore to send metrics to Amazon CloudWatch\.


| Metric | Description | 
| --- | --- | 
| RequestCount |  The total number of HTTP requests made to a MediaStore container, separated by operation type \(`Put`, `Get`, `Delete`, `Describe`, `List`\)\. Units: Count Valid dimensions:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Sum  | 
| 4xxErrorCount |  The number of HTTP requests made to MediaStore that resulted in a 4xx error\. Units: Count Valid dimensions:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Sum  | 
| 5xxErrorCount |  The number of HTTP requests made to MediaStore that resulted in a 5xx error\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Sum  | 
| BytesUploaded |  The number of bytes uploaded for requests made to a MediaStore container, where the request includes a body\. Units: Bytes Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Average \(bytes per request\), Sum \(bytes per period\), Sample Count, Min \(same as P0\.0\), Max \(same as p100\), any percentile between p0\.0 and p99\.9  | 
| BytesDownloaded |  The number of bytes downloaded for requests made to a MediaStore container, where the response includes a body\. Units: Bytes Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Average \(bytes per request\), Sum \(bytes per period\), Sample Count, Min \(same as P0\.0\), Max \(same as p100\), any percentile between p0\.0 and p99\.9  | 
| TotalTime |  The number of milliseconds that the request was in flight from the server's perspective\. This value is measured from the time that MediaStore receives your request, to the time that it sends the last byte of the response\. This value is measured from the server's perspective because measurements made from the client's perspective are affected by network latency\. Units: Milliseconds Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Average, Min \(same as P0\.0\), Max \(same as p100\), any percentile between p0\.0 and p100  | 
| TurnaroundTime |  The number of milliseconds that MediaStore spent processing your request\. This value is measured from the time that MediaStore receives the last byte of your request, to the time that it sends the first byte of the response\. Units: Milliseconds Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediastore/latest/ug/monitor-with-cloudwatch-metrics.html) Valid statistics: Average, Min \(same as P0\.0\), Max \(same as p100\), any percentile between p0\.0 and p100  | 