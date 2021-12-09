# What Are AWS Cost and Usage Reports?<a name="what-is-cur"></a>

The AWS Cost and Usage Reports \(AWS CUR\) contains the most comprehensive set of cost and usage data available\. You can use Cost and Usage Reports to publish your AWS billing reports to an Amazon Simple Storage Service \(Amazon S3\) bucket that you own\. You can receive reports that break down your costs by the hour or month, by product or product resource, or by tags that you define yourself\. AWS updates the report in your bucket once a day in comma\-separated value \(CSV\) format\. You can view the reports using spreadsheet software such as Microsoft Excel or Apache OpenOffice Calc, or access them from an application using the Amazon S3 API\. 

AWS Cost and Usage Reports tracks your AWS usage and provides estimated charges associated with your account\. Each report contains line items for each unique combination of AWS products, usage type, and operation that you use in your AWS account\. You can customize the AWS Cost and Usage Reports to aggregate the information either by the hour or by the day\.

AWS Cost and Usage Reports can do the following:
+ Deliver report files to your Amazon S3 bucket
+ Update the report up to three times a day
+ Create, retrieve, and delete your reports using the AWS CUR API Reference

## How Cost and Usage Reports Work<a name="how-cur-works"></a>

Each update is cumulative, so each version of the Cost and Usage Reports includes all of the line items and information from the previous version\. The reports generated throughout the month are estimated, and subject to change during the rest of the month as you continue to use your AWS services\. AWS finalizes the report at the end of each month\. Finalized reports have the calculations for your blended and unblended costs, and cover all of your usage for the month\.

AWS might update reports after they have been finalized if AWS applies refunds, credits, or support fees to your usage for the month\. You can set this as a preference when creating or editing your report\. The report is available within 24 hours of the date that you create a report on the **Cost & Usage Reports** page of the Billing and Cost Management console\.

## Using the Data Dictionary<a name="reading-cur"></a>

You can analyze your usage and cost in detail once you've set up your report\. We've provided a Data Dictionary that lists the columns you'll see in your report, along with definitions and examples\.

To see a your line item definitions and download a full list of corresponding services, see [Data Dictionary](data-dictionary.md)\.

## Downloading AWS Cost and Usage Reports<a name="download-cur"></a>

You can download your report from the Amazon S3 console, query the report using Amazon Athena, or upload the report into Amazon Redshift or Amazon QuickSight\.
+ For more information about creating an Amazon S3 bucket and using Athena to query your data, see [Querying Cost and Usage Reports Using Amazon Athena](cur-query-athena.md)\.
+ For more information about uploading to Amazon Redshift, see [Loading Report Data to Amazon Redshift](cur-query-other.md#cur-query-other-rs)\.
+ For more information about uploading to Amazon QuickSight, see [Loading Report Data to Amazon QuickSight](cur-query-other.md#cur-query-other-qs)\.

## Consolidated Billing Users<a name="cur-consolidated-billing"></a>

If you use the consolidated billing feature in AWS Organizations, the Amazon S3 bucket that you designate to receive the billing reports must be owned by the master account in your organization\. You can't receive billing reports in a bucket that is owned by a member account\. If you use consolidated billing, you can also have your costs broken down by member account\.

For more information on consolidated billing, see [Consolidated Billing for Organizations](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/consolidated-billing.html) in the *AWS Billing and Cost Management User Guide*