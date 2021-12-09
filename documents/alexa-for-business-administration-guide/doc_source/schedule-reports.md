# Create a Scheduled Report<a name="schedule-reports"></a>

You can create a scheduled report that gets delivered automatically to your S3 bucket every day or every week\.

**To create a scheduled report**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Usage reports**, and then choose the **Schedule report** button on the **Scheduled reports** tab\.

1. Enter a **Name** for the report, then choose the **Frequency**, **Delivery day**, **Format**, **S3 bucket name**, and **Path prefix**\.
**Note**  
Using a zip file format containing individual ,csv files is usually better for archive use cases, and using an unpacked structure is easier for automated processing of data or ETL\. The file name for zip files and partition for unpacked files include the date range associated with the data\. The file/partition name or the date column in the spreadsheet corresponds to the last day of the date range\. For example, for a 7\-day aggregate, the date column is the final day of the date range\.

1. When you're done, choose **Create**\.

You can view your scheduled reports at any time on the **Schedule reports** tab or from the Alexa for Business **Dashboard**\. On the **Dashboard**, under the **Usage Reports** section, choose the button to view your daily or weekly reports and open the S3 location associated with those reports\.

To stop the delivery of scheduled reports, choose **Remove schedule reports** on the **Schedule reports** tab\.