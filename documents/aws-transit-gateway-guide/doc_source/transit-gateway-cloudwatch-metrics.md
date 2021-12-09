# CloudWatch metrics for your transit gateways<a name="transit-gateway-cloudwatch-metrics"></a>

Amazon VPC publishes data points to Amazon CloudWatch for your transit gateways and transit gateway attachments\. CloudWatch enables you to retrieve statistics about those data points as an ordered set of time series data, known as *metrics*\. Think of a metric as a variable to monitor, and the data points as the values of that variable over time\. Each data point has an associated timestamp and an optional unit of measurement\.

You can use metrics to verify that your system is performing as expected\. For example, you can create a CloudWatch alarm to monitor a specified metric and initiate an action \(such as sending a notification to an email address\) if the metric goes outside what you consider an acceptable range\.

Amazon VPC measures and sends its metrics to CloudWatch in 60\-second intervals\.

For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

**Topics**
+ [Transit gateway metrics](#transit-gateway-metrics)
+ [Metric dimensions for transit gateways](#transit-gateway-dimensions)

## Transit gateway metrics<a name="transit-gateway-metrics"></a>

The `AWS/TransitGateway` namespace includes the following metrics\.


| Metric | Description | 
| --- | --- | 
| BytesIn |  The number of bytes received by the transit gateway\.  | 
| BytesOut |  The number of bytes sent from the transit gateway\.  | 
| PacketsIn |  The number of packets received by the transit gateway\.  | 
| PacketsOut |  The number of packets sent by the transit gateway\.  | 
| PacketDropCountBlackhole |  The number of packets dropped because they matched a `blackhole` route\.  | 
| PacketDropCountNoRoute |  The number of packets dropped because they did not match a route\.  | 

### Attachment\-level metrics<a name="transit-gateway-attachment-metrics"></a>

The following metrics are available for transit gateway attachments\. All [attachment types](how-transit-gateways-work.md#tgw-attachments-overview) are supported\. All attachment metrics are published to the transit gateway owner's account\. Individual attachment metrics are also published to the attachment owner's account \(the attachment owner can only view metrics for their own attachment\)\.


| Metric | Description | 
| --- | --- | 
| BytesIn |  The number of bytes received by the transit gateway from the attachment\.  | 
| BytesOut |  The number of bytes sent from the transit gateway to the attachment\.  | 
| PacketsIn |  The number of packets received by the transit gateway from the attachment\.  | 
| PacketsOut |  The number of packets sent by the transit gateway to the attachment\.  | 
| PacketDropCountBlackhole |  The number of packets dropped because they matched a `blackhole` route on the transit gateway attachment\.  | 
| PacketDropCountNoRoute |  The number of packets dropped because they did not match a route on the transit gateway attachment\.  | 

## Metric dimensions for transit gateways<a name="transit-gateway-dimensions"></a>

To filter the metrics for your transit gateways, use the following dimensions\.


| Dimension | Description | 
| --- | --- | 
| TransitGateway |  Filters the metric data by transit gateway\.  | 
| TransitGatewayAttachment |  Filters the metric data by transit gateway attachment\.  | 