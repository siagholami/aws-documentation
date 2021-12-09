# CloudWatch metrics for on\-premises resources<a name="cw-metrics-on-premises"></a>

Network Manager publishes data points to Amazon CloudWatch for your on\-premises resources, including devices and links\. CloudWatch enables you to retrieve statistics about those data points as an ordered set of time series data, known as metrics\. Each data point has an associated timestamp and an optional unit of measurement\. 

You can use metrics to verify that your system is performing as expected\. For example, you can create a CloudWatch alarm to monitor a specified metric and initiate an action \(such as sending a notification to an email address\) if the metric goes outside what you consider an acceptable range\. 

## Device metrics<a name="cw-metrics-devices"></a>

The `AWS/NetworkManager` namespace includes the following metrics for devices\.


| Metric | Description | 
| --- | --- | 
|  BytesIn | The number of bytes received by the device\. | 
|  BytesOut | The number of bytes sent by the device\. | 
| VpnTunnelsDown | The number of VPN tunnels on the device that have a DOWN status\. Static VPN tunnels with a DOWN status, and BGP VPN tunnels with any state other than ESTABLISHED, are included in the count\. | 

## Metric dimensions for devices<a name="cw-metrics-devices-dimensions"></a>

To filter the metrics for your devices, use the following dimensions\.


| Dimension | Description | 
| --- | --- | 
| DeviceId | Filters the metric data by the device\. | 

## Link metrics<a name="cw-metrics-links"></a>

The `AWS/NetworkManager` namespace includes the following metrics for links\.


| Metric | Description | 
| --- | --- | 
| BytesIn | The number of bytes received by the on\-premises network using this link\. | 
| BytesOut | The number of bytes sent from the on\-premises network using this link\. | 

## Metric dimensions for links<a name="cw-metrics-links-dimensions"></a>

To filter the metrics for your links, use the following dimensions\.


| Dimension | Description | 
| --- | --- | 
| LinkId | Filters the metric data by the link\. | 