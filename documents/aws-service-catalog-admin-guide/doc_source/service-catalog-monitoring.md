# Monitoring in AWS Service Catalog<a name="service-catalog-monitoring"></a>

You can monitor your AWS Service Catalog resources using Amazon CloudWatch, which collects and processes raw data from AWS Service Catalog into readable metrics\. These statistics are recorded for a period of two weeks, so that you can access historical information and gain a better perspective on how your service is performing\. AWS Service Catalog metric data is automatically sent to CloudWatch in 1\-minute periods\. For more information about CloudWatch, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

 For a list of available metrics and dimensions, see [AWS Service Catalog CloudWatch Metrics](cloudwatch-metrics.md)\. 

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS Service Catalog and your AWS solutions\. You should collect monitoring data from all of the parts of your AWS solution so that you can more easily debug a multi\-point failure if one occurs\. Before you start monitoring AWS Service Catalog, you should create a monitoring plan that includes answers to the following questions:
+ What are your monitoring goals?
+ What resources will you monitor?
+ How often will you monitor these resources?
+ What monitoring tools will you use?
+ Who will perform the monitoring tasks?
+ Who should be notified when something goes wrong?