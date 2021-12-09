# Uploading Your Report Partitions<a name="upload-report-partitions"></a>

To query your Cost and Usage Reports data, you need to upload the data into your Athena table\. You must do this for each new AWS CUR report that AWS delivers to you\.<a name="upload-partitions"></a>

**To upload your latest partitions**

1. Open the Athena console at [https://console\.aws\.amazon\.com/athena/](https://console.aws.amazon.com/athena/home)\.

1. Choose the **\.\.\.** next to your table\.

1. Choose **Load Partitions**\.

If you don't upload your partitions, Athena returns either no results or an error message that indicates missing data\.