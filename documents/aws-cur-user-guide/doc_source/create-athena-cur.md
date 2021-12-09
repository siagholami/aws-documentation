# Creating New Cost and Usage Reports<a name="create-athena-cur"></a>

This process shows how you can create new AWS Cost and Usage Reports to use with Athena\.<a name="create-athena-cur-steps"></a>

**To create new Cost and Usage Reports**

1. Sign in to the Billing and Cost Management console at [https://console\.aws\.amazon\.com/billing/home\#/](http://console.aws.amazon.com/billing)

1. On the navigation pane, choose **Cost & Usage Reports**\.

1. Choose **Create report**\.

1. For **Report name**, enter a name for your report\.

1. For **Additional report details**, select **Include resource IDs** to include the IDs of each individual resource in the report\.

1. For **Data refresh settings**, select whether you want the Cost and Usage Reports to refresh if AWS applies refunds, credits, or support fees to your account after finalizing your bill\. When a report refreshes, a new report is uploaded to Amazon S3\.

1. Choose **Next**\.

1. For **S3 bucket**, choose **Configure**\.

1. In the **Configure S3 Bucket** dialog box, do one of the following:
   + Select an existing bucket from the drop down list and choose **Next**\.
   + Enter a bucket name and the Region where you want to create a new bucket and choose **Next**\.

1. Select **I have confirmed that this policy is correct** and choose **Save**\.

1. For **Report path prefix**, enter the report path prefix that you want prepended to the name of your report\. You must provide a report path prefix to use Athena with AWS CUR\.

1. For **Time granularity**, choose **Hourly** if you want the line items in the report to be aggregated by the hour\. Choose **Daily** if you want the line items in the report to be aggregated by the day\.

1. For **Report versioning**, choose whether you want each version of the report to overwrite the previous version of the report or to be delivered in addition to the previous versions\.

1. For **Enable report data integration for**, select whether you want to upload your AWS CUR to Amazon Athena, Amazon Redshift, or Amazon QuickSight\. The report is compressed in the following formats:
   + **Athena**: parquet compression
   + **Amazon Redshift or Amazon QuickSight**: \.gz compression

1. Choose **Next**\.

1. After you have reviewed the settings for your report, choose **Review and Complete**\.

Before moving on to the next procedure, you must wait for the first AWS CUR to be delivered to your Amazon S3 bucket\. It might take up to 8 hours for AWS to deliver your first report\.