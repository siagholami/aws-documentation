# Creating a New Amazon S3 Bucket For Your Reports<a name="create-athena-bucket"></a>

This process shows how you create new Amazon S3 buckets for your cost and usage reports\.

**Note**  
If you are part of AWS Organizations, only the master \(payer\) account can create this bucket\. AWS CUR data can be only delivered to a bucket owned by the master account\.<a name="create-athena-bucket-steps"></a>

**To create a new Amazon S3 bucket for your AWS CUR reports**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose **Create Bucket**\.

1. In the dialog box, for **Bucket Name**, enter the name for your bucket\.

   Your bucket name must be all lowercase, 3 to 63 characters long, and can't contain spaces\. You can also use numbers, hyphens \(\-\), and periods \(\.\)\.

1. Choose the Region that you want your Amazon S3 bucket to be in\.

1. Choose **Next**\.

1. Choose **Next**\.

1.  \(Optional\) If you choose **Grant Amazon Simple Storage Service Log Delivery group write access to this bucket**, you can enable access logs that track who accesses your Amazon S3 bucket\. Choose the bucket that you want the access logs to be delivered to and the name of a folder that you want the logs to be stored in\. 

1. Choose **Next**\.

1. Choose **Create bucket**\.

1. From the list of buckets, choose the bucket that you want to receive reports in\.

1. Choose **Permissions**\.

1. Choose **Bucket Policy**\.

1. Paste the following text into the bucket policy editor\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
     {
       "Effect": "Allow",
       "Principal": {
         "Service": "billingreports.amazonaws.com"
       },
       "Action": [
         "s3:GetBucketAcl",
         "s3:GetBucketPolicy"
       ],
       "Resource": "arn:aws:s3:::bucketname"
     },
     {
       "Effect": "Allow",
       "Principal": {
         "Service": "billingreports.amazonaws.com"
       },
       "Action": "s3:PutObject",
       "Resource": "arn:aws:s3:::bucketname/*"
     }
     ]
   }
   ```

1. Replace *bucketname* with the name of your bucket\.

1. Choose **Save**\.