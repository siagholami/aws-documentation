# \(Optional\) Step 4: Monitor AWS Elemental MediaPackage Activity<a name="monitor-emp"></a>

Use Amazon CloudWatch to track AWS Elemental MediaPackage activity, such as the counts of bytes that MediaPackage has received and sent, response times, and request counts\. Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

**To view metrics using the CloudWatch console**

1. Open the CloudWatch console at [https://console.aws.amazon.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Under **All metrics**, choose the **AWS/MediaPackage** namespace\.

1. Select the metric dimension to view the metrics \(for example, choose `channel` to view metrics per channel\)\. 

For a list of AWS Elemental MediaPackage metrics, see [AWS Elemental MediaPackage Live Content Metrics](metrics.md)\.