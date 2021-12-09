# Step 2: Upload a List of Segment Members to Amazon S3<a name="tutorials-send-an-email-upload-contacts"></a>

To create a segment of customers that you can use with this tutorial in Amazon Pinpoint, you first have to upload a spreadsheet that contains those customers' contact details to an Amazon S3 *bucket*\. 

In Amazon S3, a bucket is a container that you use to store files and folders\. Each bucket can have its own permission settings\. For example, you can set up a bucket so that its contents are accessible to anyone who has the address of the bucket\. Or you could set it up so that its contents are only available to you\. To learn more about Amazon S3, see [Introduction to Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html) in the *Amazon Simple Storage Service Developer Guide*\.

**To create a list of contacts and upload it to Amazon S3**

1. In a spreadsheet application, create a spreadsheet that contains information about the contacts that you want to send email to\. Use the following template as an example\. Change the values in the **Address**, **User\.UserAttributes\.FirstName**, and **User\.UserAttributes\.LastName** fields to represent the people who you want to contact\. Don't change the column headings or the values in the **ChannelType** column\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/tutorials-send-an-email-upload-contacts.html)
**Note**  
You can include additional fields if necessary\. For a list of other fields you can specify, see the table in [Supported Attributes](segments-importing.md#segments-importing-available-attributes)\.

1. Replace the values in the template with names and email addresses of people you want to contact\.
**Important**  
If this is your first time using Amazon Pinpoint, your account is in the sandbox\. When your account is in the sandbox, you can only send email to verified identities\. If you want to send email to identities you haven't verified, complete the procedure in [Requesting Production Access for Email](channels-email-setup-production-access.md)\.

   When you finish, save the file to your computer in comma\-separated values \(CSV\) format\.

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose **Create bucket**\.

1. On the **Create bucket** dialog box, for **Bucket name**, type a name for the bucket, and then choose **Create**\.

1. In the list of buckets, choose the bucket that you created in the previous step\.

1. Choose **Create folder**\. Type a name for the folder, and then choose **Save**\.

   Make a note of both the name of the bucket and the name of the folder \(you need to provide both of these values in a later step\)\.

1. In the folder you just created, choose **Upload**, and then choose **Add files**\. Upload the spreadsheet that you created earlier in this section\.

**Next:** [Create a Segment »](tutorials-send-an-email-create-segment.md)