# Editing Your Cost and Usage Reports Configuration<a name="edit-cur"></a>

You can use the **Cost & Usage Reports** page in the Billing and Cost Management console to edit Cost and Usage Reports\.

**Note**  
Report names can't be edited\. If you chose **Overwrite** for **Report versioning**, you're unable to edit the report name, whether the report includes resource IDs, time granularity, or the report versioning\. If you delete a report set to **Overwrite** and create a new report with the same name, Amazon S3 bucket, and path prefix, your data could corrupt and become inaccurate\.<a name="edit-cur-steps"></a>

**To edit Cost and Usage Reports**

1. Sign in to the Billing and Cost Management console at [https://console\.aws\.amazon\.com/billing/home\#/](http://console.aws.amazon.com/billing)

1. On the navigation pane, choose **Cost & Usage Reports**\.

1. Select the report that you want to edit and choose **Edit report**\.

1. \(Versioned reports only\) For **Additional report details**, select **include resource IDs** to add IDs for individual resources\.

1. Select the **Data refresh settings** if you want AWS Cost and Usage Reports to refresh when AWS applies refunds, credits, or support fees to your account after your bill is finalized\.

   When a report refreshes, a new report is uploaded to Amazon S3\.

1. Choose **Next**\.

1. For **S3 bucket**, enter the name of the Amazon S3 bucket where you want the reports delivered\.

1. Choose **Verify**\.
**Note**  
The bucket must have appropriate permissions to be valid\. For more information on adding permissions to the bucket, see [ Setting Bucket and Object Access Permissions](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/set-permissions.html) in the *[Amazon Simple Storage Service Console User Guide](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/)*\. 

1. For **Report path prefix**, enter the report path prefix that you want prepended to the name of your report\. 

1. \(Versioned reports only\) For **Time granularity**, choose one of the following:
   + **Hourly**: If you want the line items in the report to be aggregated by the hour\.
   + **Daily**: If you want the line items in the report to be aggregated by the day\.

1. \(Versioned reports only\) For **Report versioning**, choose whether you want each version of the report to overwrite the previous version of the report, or to be delivered in addition to the previous versions\.

1. For **Enable report data integration for**, select whether you want to upload your AWS CUR to Amazon Athena, Amazon Redshift, or Amazon QuickSight\. The report is compressed in the following formats:
   + **Athena**: Parquet compression
   + **Amazon Redshift or Amazon QuickSight**: \.gz compression

1. Choose **Save**\.