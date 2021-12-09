# Monitoring AWS IoT SiteWise with Amazon CloudWatch metrics<a name="monitor-cloudwatch-metrics"></a>

You can monitor AWS IoT SiteWise using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

AWS IoT SiteWise publishes the metrics and dimensions listed in the sections below to the `AWS/IoTSiteWise` namespace\.

**Tip**  
AWS IoT SiteWise publishes metrics on a one minute interval\. When you view these metrics in graphs in the CloudWatch console, we recommend that you choose a **Period** of **1 minute**\. This lets you see the highest available resolution of your metric data\.

**Contents**
+ [Gateway metrics](#gateway-metrics)

## Gateway metrics<a name="gateway-metrics"></a>

AWS IoT SiteWise publishes the following gateway metrics\. All gateway metrics are published on a one minute interval\.

**Important**  
To receive gateway metrics, you must use at least version 6 of the AWS IoT SiteWise connector on your gateway\. For more information, see [AWS IoT SiteWise connector](https://docs.aws.amazon.com/greengrass/latest/developerguide/iot-sitewise-connector.html) in the *AWS IoT Greengrass Developer Guide*\.


**Gateway metrics**  

| Metric | Description | 
| --- | --- | 
| Gateway\.Heartbeat |  Generated every minute for each gateway \(`gatewayId`\) connected\.  | 
| Gateway\.PublishSuccessCount |  The number of data points that a gateway \(`gatewayId`\) successfully published\.  | 
| Gateway\.PublishFailureCount |  The number of data points that a gateway \(`gatewayId`\) failed to publish\. This metric counts errors that result from the gateway's calls to the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation\. For more information about troubleshooting gateways, see [Troubleshooting an AWS IoT SiteWise gateway](troubleshooting-gateway.md)\.  | 
| Gateway\.ProcessFailureCount |  The number of data points that a gateway \(`gatewayId`\) failed to process\. This metric count errors that occur between the gateway and the gateway's sources, including errors reported by sources\. For more information about troubleshooting gateways, see [Troubleshooting an AWS IoT SiteWise gateway](troubleshooting-gateway.md)\.  | 


**Gateway source metrics**  

| Metric | Description | 
| --- | --- | 
| OPCUACollector\.Heartbeat |  Generated every minute for each OPC\-UA source \(`sourceName`\) connected to a gateway \(`gatewayId`\)\.  | 
| OPCUACollector\.ActiveDataStreamCount |  The number of data streams that a gateway \(`gatewayId`\) subscribed to for an OPC\-UA source \(`sourceName`\)\.  | 
| OPCUACollector\.IncomingValuesCount |  The number of data points that a gateway \(`gatewayId`\) received for an OPC\-UA source \(`sourceName`\)\.  | 