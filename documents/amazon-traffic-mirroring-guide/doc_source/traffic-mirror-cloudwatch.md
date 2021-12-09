# Monitoring Mirrored Traffic Using Amazon CloudWatch<a name="traffic-mirror-cloudwatch"></a>

You can monitor your mirrored traffic using Amazon CloudWatch, which collects information from your a network interface that is part of a traffic mirror session, and creates readable, near real\-time metrics\. You can use this information to monitor and troubleshoot Traffic Mirroring\. 

For more information about Amazon CloudWatch, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\. For more information about pricing, see [Amazon CloudWatch Pricing](http://aws.amazon.com/cloudwatch/pricing)\.

## Traffic Mirroring Metrics and Dimensions<a name="metrics-dimensions-traffic-mirror"></a>

The following metrics are available for your mirrored traffic\.


| Metric | Description | 
| --- | --- | 
|  `NetworkMirrorIn`  |  The number of bytes received on all network interfaces by the instance that are mirrored\.  The number reported is the number of bytes received during the period\. If you are using basic \(five\-minute\) monitoring, you can divide this number by 300 to find Bytes/second\. If you have detailed \(one\-minute\) monitoring, divide it by 60\.  Units: Bytes  | 
|  `NetworkMirrorOut`  |  The number of bytes sent out on all network interfaces by the instance that are mirrored\.  The number reported is the number of bytes sent during the period\. If you are using basic \(five\-minute\) monitoring, you can divide this number by 300 to find Bytes/second\. If you have detailed \(one\-minute\) monitoring, divide it by 60\.  Units: Bytes  | 
|  `NetworkPacketsMirrorIn`  |  The number of packets received on all network interfaces by the instance that are mirrored\. This metric is available for basic monitoring only\.  Units: Count  | 
| NetworkPacketsMirrorOut |  The number of packets sent out on all network interfaces by the instance that are mirrored\. This metric is available for basic monitoring only\.  Units: Count  | 
|  `NetworkSkipMirrorIn`  |  The number of bytes received, that meet the traffic mirror filter rules, that did not get mirrored because of production traffic taking priority\.  Units: Bytes  | 
|  `NetworkSkipMirrorOut`  |  The number of bytes sent out, that meet the traffic mirror filter rules, that did not get mirrored because of production traffic taking priority\. Units: Bytes  | 
|  `NetworkPacketsSkipMirrorIn`  |  The number of packets received, that meet the traffic mirror filter rules, that did not get mirrored because of production traffic taking priority\. This metric is available for basic monitoring only\.  Units: Count  | 
| NetworkPacketsSkipMirrorOut |  The number of packets sent out, that meet the traffic mirror filter rules, that did not get mirrored because of production traffic taking priority\. This metric is available for basic monitoring only\.  Units: Count  | 

To filter the metric data, use the following dimensions\.


| Dimension | Description | 
| --- | --- | 
| AutoScalingGroupName | This dimension filters the data you request for all instances in a specified capacity group\. An Auto Scaling group is a collection of instances you define if you're using Auto Scaling\. This dimension is available only for Amazon EC2 metrics when the instances are in such an Auto Scaling group\. Available for instances with Detailed or Basic Monitoring enabled\.  | 
| ImageId | This dimension filters the data you request for all instances running this Amazon EC2 Amazon Machine Image \(AMI\)\. Available for instances with Detailed Monitoring enabled\.  | 
| InstanceId | This dimension filters the data you request for the identified instance only\. This helps you pinpoint an exact instance from which to monitor data\. Available for instances with Detailed or Basic Monitoring enabled\.  | 
| InstanceType | This dimension filters the data you request for all instances running with this specified instance type\. This helps you categorize your data by the type of instance running\. For example, you might compare data from an m1\.small instance and an m1\.large instance to determine which has the better business value for your application\. Available for instances with Detailed Monitoring enabled\.  | 

## Viewing Traffic Mirroring CloudWatch Metrics<a name="viewing-traffic-mirror-metrics"></a>

You can view the metrics for Traffic Mirroring as follows\.

**To view metrics using the CloudWatch console**

Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Under **All metrics**, choose the **EC2** metric namespace\.

1. To view the metrics, select the metric dimension\.

**To view metrics using the AWS CLI**  
At a command prompt, use the following command to list the metrics that are available for Traffic Mirroring:

```
aws cloudwatch list-metrics --namespace "AWS/EC2"
```

The Traffic Mirroring metrics are included with the EC2 metrics\.