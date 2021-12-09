# Tutorial: Accessing CloudWatch Metrics for Amazon MQ<a name="amazon-mq-accessing-metrics"></a>

Amazon MQ and Amazon CloudWatch are integrated so you can use CloudWatch to view and analyze metrics for your ActiveMQ broker and the broker's destinations \(queues and topics\)\. You can view and analyze your Amazon MQ metrics from the CloudWatch console, the AWS CLI, or the CloudWatch CLI\. CloudWatch metrics for Amazon MQ are automatically polled from the broker and then pushed to CloudWatch every minute\.

For a full list of Amazon MQ metrics, see [Monitoring Amazon MQ Brokers Using Amazon CloudWatch](security-logging-monitoring-cloudwatch.md)\.

For information about creating a CloudWatch alarm for a metrics, see [Create or Edit a CloudWatch Alarm](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/ConsoleAlarms.html) in the *Amazon CloudWatch User Guide*\.

**Note**  
There is no charge for the Amazon MQ metrics reported in CloudWatch\. These metrics are provided as part of the Amazon MQ service\.  
CloudWatch monitors only the first 200 destinations\.

**Topics**
+ [AWS Management Console](#amazon-mq-accessing-metrics-console)
+ [AWS Command Line Interface](#amazon-mq-accessing-metrics-aws-cli)
+ [Amazon CloudWatch API](#amazon-mq-accessing-metrics-cw-api)

## AWS Management Console<a name="amazon-mq-accessing-metrics-console"></a>

The following example shows you how to access CloudWatch metrics for Amazon MQ using the AWS Management Console\.

**Note**  
If you're already signed into the Amazon MQ console, on the broker **Details** page, choose **Actions**, **View CloudWatch metrics**\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-view-cloudwatch-metrics.png)

1. Sign in to the [CloudWatch console](https://console.aws.amazon.com/cloudwatch/)\.

1. On the navigation panel, choose **Metrics**\.

1. Select the **AmazonMQ** metric namespace\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-cloudwatch-queue-metrics-namespace.png)

1. Select one of the following metric dimensions:
   + **Broker Metrics**
   + **Queue Metrics by Broker**
   + **Topic Metrics by Broker**

   In this example, **Broker Metrics** is selected\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-cloudwatch-queue-metrics-dimension.png)

1. You can now examine your Amazon MQ metrics:
   + To sort the metrics, use the column heading\.
   + To graph the metric, select the check box next to the metric\.
   + To filter by metric, choose the metric name and then choose **Add to search**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-cloudwatch-queue-metrics-examine.png)

## AWS Command Line Interface<a name="amazon-mq-accessing-metrics-aws-cli"></a>

To access Amazon MQ metrics using the AWS CLI, use the `[get\-metric\-statistics](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/get-metric-statistics.html)` command\.

For more information, see [Get Statistics for a Metric](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/getting-metric-statistics.html) in the *Amazon CloudWatch User Guide*\.

## Amazon CloudWatch API<a name="amazon-mq-accessing-metrics-cw-api"></a>

To access Amazon MQ metrics using the CloudWatch API, use the `[GetMetricStatistics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_GetMetricStatistics.html)` action\.

For more information, see [Get Statistics for a Metric](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/getting-metric-statistics.html) in the *Amazon CloudWatch User Guide*\.