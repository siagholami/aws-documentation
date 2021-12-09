# AWS Service Catalog CloudWatch Metrics<a name="cloudwatch-metrics"></a>

You can monitor your AWS Service Catalog resources using Amazon CloudWatch, which collects and processes raw data from AWS Service Catalog into readable metrics\. These statistics are recorded for a period of two weeks, so that you can access historical information and gain a better perspective on how your service is performing\. AWS Service Catalog metric data is automatically sent to CloudWatch in 1\-minute periods\. For more information about CloudWatch, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

**Topics**
+ [Enabling CloudWatch Metrics](#enable_cloudwatch)
+ [Available Metrics and Dimensions](#available_cloudwatch_metrics)
+ [Viewing AWS Service Catalog Metrics](viewing-cloudwatch-metrics.md)

## Enabling CloudWatch Metrics<a name="enable_cloudwatch"></a>

Amazon CloudWatch metrics are enabled by default\.

## Available Metrics and Dimensions<a name="available_cloudwatch_metrics"></a>

The metrics and dimensions that AWS Service Catalog sends to Amazon CloudWatch are listed below\.

### AWS Service Catalog Metrics<a name="service-catalog-metrics"></a>

The `AWS/ServiceCatalog` namespace includes the following metrics\.


| Metric | Description | 
| --- | --- | 
|  `ProvisionedProductLaunch`  |  The number of provisioned products launched for a given product and provisioning artifact in a specified time period\. Units: Count Valid statistics: Minimum, Maximum, Sum, Average  | 

### Dimensions for AWS Service Catalog Metrics<a name="service-catalog-metrics-dimensions"></a>

AWS Service Catalog sends the following dimensions to CloudWatch\.


| Dimension | Description | 
| --- | --- | 
| `State` |  This dimension filters the data you request for all provisioned products launched with this specified state\. This helps you categorize your data by the state of launch\. Valid State: SUCCEEDED, FAILED  | 
| `ProductId` |  This dimension filters the data you request for the identified product id only\. This helps you to pinpoint an exact product from which to be launched\.  | 
| `ProvisioningArtifactId` |  This dimension filters the data you request for the identified provisioning artifact id only\. This helps you to pinpoint an exact version of products from which to be launched\.  | 