# Using Amazon CloudWatch with AWS Global Accelerator<a name="cloudwatch-monitoring"></a>

AWS Global Accelerator publishes data points to Amazon CloudWatch for your accelerators\. CloudWatch enables you to retrieve statistics about those data points as an ordered set of time\-series data, known as *metrics*\. Think of a metric as a variable to monitor, and the data points as the values of that variable over time\. For example, you can monitor traffic through an accelerator over a specified time period\. Each data point has an associated time stamp and an optional unit of measurement\.

You can use metrics to verify that your system is performing as expected\. For example, you can create a CloudWatch alarm to monitor a specified metric and initiate an action \(such as sending a notification to an email address\) if the metric goes outside what you consider an acceptable range\.

Global Accelerator reports metrics to CloudWatch only when requests are flowing through the accelerator\. If requests are flowing through the accelerator, Global Accelerator measures and sends its metrics in 60\-second intervals\. If there are no requests flowing through the accelerator or there is no data for a metric, the metric is not reported\.

For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

**Topics**
+ [Global Accelerator metrics](#cloudwatch-metrics-global-accelerator)
+ [Metric dimensions for accelerators](#cloudwatch-metric-dimensions-aga)
+ [Statistics for Global Accelerator metrics](#cloudwatch-metric-statistics)
+ [View CloudWatch metrics for your accelerators](#view-metric-data)

## Global Accelerator metrics<a name="cloudwatch-metrics-global-accelerator"></a>

The `AWS/GlobalAccelerator` namespace includes the following metrics\.


| Metric | Description | 
| --- | --- | 
| NewFlowCount |  The total number of new TCP and UDP flows \(or connections\) established from clients to endpoints in the time period\. **Reporting criteria**: There is a nonzero value\. **Statistics**: The only useful statistic is `Sum`\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/cloudwatch-monitoring.html)  | 
| ProcessedBytesIn |  The total number of incoming bytes processed by the accelerator, including TCP/IP headers\. This count includes traffic to endpoints, minus health check traffic\. **Reporting criteria**: There is a nonzero value\. **Statistics**: The only useful statistic is `Sum`\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/cloudwatch-monitoring.html)  | 
| ProcessedBytesOut |  The total number of outgoing bytes processed by the accelerator, including TCP/IP headers\. This count includes traffic from endpoints, minus health check traffic\. **Reporting criteria**: There is a nonzero value\. **Statistics**: The only useful statistic is `Sum`\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/cloudwatch-monitoring.html)  | 

## Metric dimensions for accelerators<a name="cloudwatch-metric-dimensions-aga"></a>

To filter the metrics for your accelerator, use the following dimensions\.


| Dimension | Description | 
| --- | --- | 
| Accelerator |  Filters the metric data by accelerator\. Specify the accelerator by the accelerator id \(the final portion of the accelerator ARN\)\. For example, if the ARN is `arn:aws:globalaccelerator::012345678901:accelerator/1234abcd-abcd-1234-abcd-1234abcdefgh`, you specify the following: **1234abcd\-abcd\-1234\-abcd\-1234abcdefgh**\.   | 
| Listener |  Filters the metric data by listener\. Specify the listener by the listener id \(the final portion of the listener ARN\)\. For example, if the ARN is `arn:aws:globalaccelerator::012345678901:accelerator/1234abcd-abcd-1234-abcd-1234abcdefgh/listener/0123wxyz`, you specify the following: **0123wxyz**\.  | 
| EndpointGroup |  Filters the metric data by endpoint group\. Specify the endpoint group by the AWS Region, for example, **us\-east\-1** \(all lowercase\)\.  | 
| SourceRegion |  Filters the metric data by source region, which is the geographic area of the AWS Regions where your application endpoints are running\. Source region is one of the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/cloudwatch-monitoring.html) \*Excluding South Korea and India  | 
| DestinationEdge |  Filters the metric data by destination edge, which is the geographic area of the AWS edge locations that serve your client traffic\. Destination edge is one of the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/cloudwatch-monitoring.html) \*Excluding South Korea and India  | 
| TransportProtocol |  Filters the metric data by transport protocol: UDP or TCP\.  | 
| AcceleratorIPAddress |  Filters the metric data by the IP address of the accelerator: that is, one of the static IP addresses assigned to an accelerator\.  | 

## Statistics for Global Accelerator metrics<a name="cloudwatch-metric-statistics"></a>

CloudWatch provides statistics based on the metric data points published by Global Accelerator\. Statistics are aggregations of metric data over a specified period of time\. When you request statistics, the returned data stream is identified by the metric name and dimension\. A dimension is a name/value pair that uniquely identifies a metric\. For example, you can request the processed bytes out for an accelerator where the bytes are served from AWS edge locations in Europe \(destination edge is "EU"\)\.

The following are examples of metric/dimension combinations that you might find useful:
+ View the amount of traffic served \(such as ProcessedBytesOut\) by each of your two accelerator IP addresses to validate that your DNS configuration is correct\.
+ View the geographical distribution of your user traffic and monitor how much of it is local \(for example, North America to North America\) or global \(for example, Australia or India to North America\)\. To determine this, view the metrics ProcessedBytesIn or ProcessedBytesOut with the dimensions DestinationEdge and SourceRegion set to specific values\.

## View CloudWatch metrics for your accelerators<a name="view-metric-data"></a>

You can view the CloudWatch metrics for your accelerators using the CloudWatch console or the AWS CLI\. In the console, metrics are displayed as monitoring graphs\. The monitoring graphs show data points only if the accelerator is active and receiving requests\. 

You must view CloudWatch metrics for Global Accelerator in the US West \(Oregon\) Region, both in the console or when using the AWS CLI\. When you use the AWS CLI, specify the US West \(Oregon\) Region for your command by including the following parameter: `--region us-west-2`\. 

**To view metrics using the CloudWatch console**

1. Open the CloudWatch console at [ https://us\-west\-2\.console\.aws\.amazon\.com/cloudwatch/home?region=us\-west\-2](https://us-west-2.console.aws.amazon.com/cloudwatch/home?region=us-west-2)\.

1. In the navigation pane, choose **Metrics**\.

1. Select the **GlobalAccelerator** namespace\.

1. \(Optional\) To view a metric across all dimensions, type its name in the search field\.

**To view metrics using the AWS CLI**  
Use the following [list\-metrics](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/list-metrics.html) command to list the available metrics:

```
aws cloudwatch list-metrics --namespace AWS/GlobalAccelerator --region us-west-2
```

**To get the statistics for a metric using the AWS CLI**  
Use the following [get\-metric\-statistics](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/get-metric-statistics.html) command to get statistics for a specified metric and dimension\. Note that CloudWatch treats each unique combination of dimensions as a separate metric\. You can't retrieve statistics using combinations of dimensions that were not specifically published\. You must specify the same dimensions that were used when the metrics were created\.

The following example lists the total processed bytes in, per minute, for your accelerator serving from the North America \(NA\) destination edge\.

```
aws cloudwatch get-metric-statistics --namespace AWS/GlobalAccelerator \
--metric-name ProcessedBytesIn \
--region us-west-2 \
--statistics Sum --period 60 \
--dimensions Name=Accelerator,Value=1234abcd-abcd-1234-abcd-1234abcdefgh Name=DestinationEdge,Value=NA \
--start-time 2019-12-18T20:00:00Z --end-time 2019-12-18T21:00:00Z
```

The following is example output from the command:

```
{
    "Label": "ProcessedBytesIn",
    "Datapoints": [
        {
            "Timestamp": "2019-12-18T20:45:00Z",
            "Sum": 2410870.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:47:00Z",
            "Sum": 0.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:46:00Z",
            "Sum": 0.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:42:00Z",
            "Sum": 1560.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:48:00Z",
            "Sum": 0.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:43:00Z",
            "Sum": 1343.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:49:00Z",
            "Sum": 0.0,
            "Unit": "Bytes"
        },
        {
            "Timestamp": "2019-12-18T20:44:00Z",
            "Sum": 35791560.0,
            "Unit": "Bytes"
        }
    ]
}
```