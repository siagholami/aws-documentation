# Step 3: Create Users<a name="setting-up-create-user"></a>

Create IAM users for the individuals who require access to AWS Elemental MediaPackage\. Add the appropriate policies to users to ensure that they have the right level of permissions\.

**To create users who can access MediaPackage**

1. In the navigation pane of the IAM console, choose **Users**, and then choose **Add user**\.

1. For **User name**, enter the name that the user will use to sign in to MediaPackage\.

1. Select the check box next to **AWS Management Console access**, select **Custom password**, and then enter the new user's password in the box\. You can optionally select **Require password reset** to force the user to create a password the next time the user signs in\.

1. Choose **Next: Permissions**\.

1. On the **Set permissions for user** page, choose **Attach existing policies directly**\.

1. In the policy list, search for and add the policy with the appropriate MediaPackage permissions level\.
   + For access to live functionality:
     + Use **AWSElementalMediaPackageFullAccess** to allow the user to perform all actions on all live resources in MediaPackage\.
     + Use **AWSElementalMediaPackageReadOnly** to provide the user read\-only rights for all live resources in MediaPackage\.
   + For access to video on demand \(VOD\) functionality, use the policy that you created in [Step 2: \(Optional\) Create a Policy for AWS Elemental MediaPackage VOD](setting-up-create-non-admin-iam-vod.md)\.

1. Add policies to allow the MediaPackage console to make calls to Amazon CloudWatch on the user's behalf\. Without these policies, the user is able to use the service's API only \(not the console\)\. Choose one of these options:
   + Use **ReadOnlyAccess** to allow MediaPackage to communicate with CloudWatch, and also provide the user read\-only access to all AWS services on your account\.
   + Use **CloudWatchReadOnlyAccess**, **CloudWatchEventsReadOnlyAccess**, and **CloudWatchLogsReadOnlyAccess** to allow MediaPackage to communicate with CloudWatch, and limit the user's read\-only access to CloudWatch\.

1. \(Optional\) If this user will create Amazon CloudFront distributions from the MediaPackage console, attach the policy that you created in [Step 1: \(Optional\) Create a Policy for Amazon CloudFront](setting-up-create-non-admin-iam-cf.md)\.

1. Choose **Next: Review** to see the list of policies to be added to the new user\. When you are ready to proceed, choose **Create user**\.