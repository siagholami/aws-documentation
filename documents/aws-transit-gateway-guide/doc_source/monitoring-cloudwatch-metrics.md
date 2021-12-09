# Monitoring your global network with Amazon CloudWatch metrics<a name="monitoring-cloudwatch-metrics"></a>

You can monitor Network Manager using CloudWatch, which collects raw data and processes it into readable, near\-real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

You can view CloudWatch metrics in your global network for your registered transited gateways, your associated Site\-to\-Site VPN connections, and your on\-premises resources\. You can view metrics per transit gateway and per transit gateway attachment, per global network\.

For more information about the supported metrics, see the following topics:
+ [CloudWatch metrics for your transit gateways](https://docs.aws.amazon.com/vpc/latest/tgw/transit-gateway-cloudwatch-metrics.html)
+ [Monitoring VPN tunnels using Amazon CloudWatch](https://docs.aws.amazon.com/vpn/latest/s2svpn/monitoring-cloudwatch-vpn.html)
+ [CloudWatch metrics for on\-premises resources](cw-metrics-on-premises.md)

For examples of creating alarms, see [Creating Amazon CloudWatch Alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html) in the *Amazon CloudWatch User Guide*\.