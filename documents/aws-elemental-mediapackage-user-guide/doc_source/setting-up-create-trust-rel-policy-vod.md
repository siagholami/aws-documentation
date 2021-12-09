# Amazon S3 Access for VOD Workflows<a name="setting-up-create-trust-rel-policy-vod"></a>

If you're using MediaPackage to ingest a VOD asset from an Amazon S3 bucket and to package and deliver that asset, you need a policy that allows you to do these things in Amazon S3:
+ `GetObject`: MediaPackage can retrieve the VOD asset from the bucket\.
+ `GetBucketLocation`: MediaPackage can retrieve the Region for the bucket\. The bucket must be in the same region as the MediaPackage VOD resources\.
+ `GetBucketRequestPayment`: MediaPackage can retrieve the payment request information\. MediaPackage uses this information to verify that the bucket doesn't require the requester to pay for the content requests\.

If you also use MediaPackage for live\-to\-VOD asset harvesting, add the `PutObject` action to the policy\. For more information the required policy for live\-to\-VOD workflows, see [Amazon S3 Access for Live\-to\-VOD Workflows](setting-up-create-trust-rel-policy-ltov.md)\.

**To use the JSON policy editor to create a policy**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation column on the left, choose **Policies**\. 

   If this is your first time choosing **Policies**, the **Welcome to Managed Policies** page appears\. Choose **Get Started**\.

1. At the top of the page, choose **Create policy**\.

1. Choose the **JSON** tab\.

1. Enter the following JSON policy document:

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Action": [
                   "s3:GetObject",
                   "s3:GetBucketLocation",
                   "s3:GetBucketRequestPayment",
                   "s3:ListBucket"
               ],
               "Resource": [
                   "arn:aws:s3:::{bucket_name}/*",
                   "arn:aws:s3:::{bucket_name}"
               ],
               "Effect": "Allow"
           }
       ]
   }
   ```

1. Choose **Review policy**\.
**Note**  
You can switch between the **Visual editor** and **JSON** tabs any time\. However, if you make changes or choose **Review policy** in the **Visual editor** tab, IAM might restructure your policy to optimize it for the visual editor\. For more information, see [Policy Restructuring](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_policies.html#troubleshoot_viseditor-restructure) in the *IAM User Guide*\.

1. On the **Review policy** page, enter a **Name** and an optional **Description** for the policy that you are creating\. Review the policy **Summary** to see the permissions that are granted by your policy\. Then choose **Create policy** to save your work\.