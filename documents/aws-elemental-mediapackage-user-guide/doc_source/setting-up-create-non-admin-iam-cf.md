# Step 1: \(Optional\) Create a Policy for Amazon CloudFront<a name="setting-up-create-non-admin-iam-cf"></a>

If you or your users will create Amazon CloudFront distributions from the AWS Elemental MediaPackage live console, create a policy that allows access to CloudFront\.

For more information about using CloudFront with AWS Elemental MediaPackage, see [Working with Content Delivery Networks \(CDNs\)](cdns.md)\.

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
               "Effect": "Allow",
               "Action": [
                   "cloudfront:GetDistribution",
                   "cloudfront:CreateDistributionWithTags",
                   "cloudfront:UpdateDistribution",
                   "tag:GetResources"
               ],
               "Resource": "*"
           }
       ]
   }
   ```

1. Choose **Review policy**\.
**Note**  
You can switch between the **Visual editor** and **JSON** tabs any time\. However, if you make changes or choose **Review policy** in the **Visual editor** tab, IAM might restructure your policy to optimize it for the visual editor\. For more information, see [Policy Restructuring](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_policies.html#troubleshoot_viseditor-restructure) in the *IAM User Guide*\.

1. On the **Review policy** page, enter a **Name** and an optional **Description** for the policy that you are creating\. Review the policy **Summary** to see the permissions that are granted by your policy\. Then choose **Create policy** to save your work\.