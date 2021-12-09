# Create a Report<a name="create-report"></a>

You can create an individual report to immediately deliver to your S3 bucket\.

**To create a report**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Usage reports**, and then choose the **Create report** button on the **Create report** tab\.

1. Choose the **Time frame** and **Delivery option** of the report, then choose **Create**\.
**Note**  
If you choose **Deliver to my S3 bucket**, additionally specify the **Format**, **S3 bucket name**, and **Path prefix**\. Using a zip file format containing individual \.csv files is usually better for archive use cases, and using an unpacked structure is easier for automated processing of data or ETL\. The file name for zip files and partition for unpacked files include the date range associated with the data\. The file/partition name or the date column in the spreadsheet corresponds to the last day of the date range\. For example, for a 7\-day aggregate, the date column is the final day of the date range\.

You can view the status of reports that you created on the **Create report** tab under **Report** status\.