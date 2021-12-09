# Step 3: Create a Segment<a name="tutorials-send-an-email-create-segment"></a>

Now that you've uploaded a spreadsheet that contains the contact information for your customers, you can use that spreadsheet to create a new *segment* in Amazon Pinpoint\.

A segment is a group of customers that you want to target for a campaign\. Usually, members of a segment have certain characteristics in common with each other\. For example, segment members might all live in the same city, or they might have purchased the same item from you in the past\. 

When you create a segment in Amazon Pinpoint, you can reuse it later in a different campaign\.

**To create a segment based on a spreadsheet that's stored in Amazon S3**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. Choose the project that you created in the first section of this topic\.

1. In the navigation pane, choose **Segments**, and then choose **Create a segment**\.

1. On the **Create a segment** page, do the following:

   1. Choose **Import a segment**\.

   1. For **Segment name**, enter a name for the segment\.

   1. For **Amazon S3 URL**, enter the following:

      ```
      s3://bucketName/folderName
      ```

      Replace `bucketName` with the name of the Amazon S3 bucket that you created in the previous section\. Replace `folderName` with the name of the folder that you created in the previous section\.

   1. Under **IAM role**, choose **Automatically create a role**, and then type a name for the role\.

   1. Under **What type of file are you importing?**, choose **Comma\-Separated Values \(CSV\)**\.

   1. Choose **Create segment**\. The **Scheduled imports** page appears\.

1. Wait for a few minutes, and then refresh the page\. If the value in the **Import status** column is **Completed**, proceed to the next section\. Otherwise, repeat this step until the segment import process is complete\.

**Next:** [Create a Campaign »](tutorials-send-an-email-create-campaign.md)