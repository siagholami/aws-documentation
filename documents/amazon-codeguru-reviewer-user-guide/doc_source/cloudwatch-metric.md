# Monitoring profiling groups with CloudWatch metrics<a name="cloudwatch-metric"></a>

 You can view Amazon CodeGuru Reviewer metrics in the Amazon CloudWatch console\. <a name="cloudswatch-console-procedure"></a>

**To access profiling group metrics**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1.  In the navigation pane, choose **Metrics**\. 

1.  On the **All metrics** tab, choose **AWS/CodeGuruReviewer**\. 

1.  Choose the dimension you want metrics for: **ProviderType**, **CodeReviewType**, or **RepositoryName**\. The graph on the page displays metrics for recommendations for all selected items that are available for the selected dimension\. 