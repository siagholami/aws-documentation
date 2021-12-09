# Creating Cost and Usage Reports<a name="cur-create"></a>

You can use the **Cost & Usage Reports** page of the Billing and Cost Management console to create Cost and Usage Reports\.

**Note**  
It can take up to 24 hours for AWS to start delivering reports to your Amazon S3 bucket\. After delivery starts, AWS updates the AWS Cost and Usage Reports files at least once a day\.
Detailed billing reports \(DBRs\) don't refresh automatically, whether you select **Data refresh settings** or not\. To refresh a DBR, open a support case\. For more information, see [Contacting Customer Support About Your Bill](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-get-answers.html) in the *AWS Billing and Cost Management User Guide*\.<a name="create-cur-steps"></a>

**To create Cost and Usage Reports**

1. Sign in to the Billing and Cost Management console at [https://console\.aws\.amazon\.com/billing/home\#/](http://console.aws.amazon.com/billing)

1. On the navigation pane, choose **Cost & Usage Reports**\.

1. Choose **Create report**\.

1. For **Report name**, enter a name for your report\.

1. For **Additional report details**, select **Include resource IDs** to include the IDs of each individual resource in the report\.

1. For **Data refresh settings**, select whether you want the AWS Cost and Usage Reports to refresh if AWS applies refunds, credits, or support fees to your account after finalizing your bill\. When a report refreshes, a new report is uploaded to Amazon S3\.

1. Choose **Next**\.

1. For **S3 bucket**, choose **Configure**\.

1. In the **Configure S3 Bucket** dialog box, do one of the following:
   + Select an existing bucket from the drop down list and choose **Next**\.
   + Enter a bucket name and the Region where you want to create a new bucket and choose **Next**\.

1. Select **I have confirmed that this policy is correct** and choose **Save**\.

1. For **Report path prefix**, enter the report path prefix that you want prepended to the name of your report\. 

   This step is optional for Amazon Redshift or Amazon QuickSight, but required for Amazon Athena\.

   If you don't specify a prefix, the default prefix is the name that you specified for the report in step 4 and the date range for the report, in the following format:

   `/report-name/date-range/`

1. For **Time granularity**, choose one of the following:
   + **Hourly** if you want the line items in the report to be aggregated by the hour\.
   + **Daily** if you want the line items in the report to be aggregated by the day\.

1. For **Report versioning**, choose whether you want each version of the report to overwrite the previous version of the report or to be delivered in addition to the previous versions\.

1. For **Enable report data integration for**, select whether you want to upload your Cost and Usage Reports to Amazon Athena, Amazon Redshift, or Amazon QuickSight\. The report is compressed in the following formats:
   + **Athena**: parquet compression
   + **Amazon Redshift or Amazon QuickSight**: \.gz compression

1. Choose **Next**\.

1. After you have reviewed the settings for your report, choose **Review and Complete**\. 