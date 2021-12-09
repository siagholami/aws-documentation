# Setting Up Permissions<a name="aws-personalize-set-up-permissions"></a>

 To use Amazon Personalize, you have to set up permissions that allow IAM users to access the Amazon Personalize console and API operations\. You also have to set up permissions that allow Amazon Personalize to perform tasks on your behalf and to access resources that you own\. 

We recommend creating an AWS Identity and Access Management \(IAM\) user with access restricted to Amazon Personalize operations\. You can add other permissions as needed\. For more information, see [Amazon Personalize Identity\-Based Policies](security_iam_service-with-iam.md#security_iam_service-with-iam-id-based-policies)\. 

**Note**  
 We recommend [creating a new IAM policy](#set-up-required-permissions) that grants only the permissions necessary to use Amazon Personalize\. 

**To set up permissions**

1.  Attach a policy to your Amazon Personalize IAM user or group that allows full access to Amazon Personalize\. 
   +  Create a new IAM policy and attach it to your IAM user or group \(see [Creating a New IAM Policy](#set-up-required-permissions)\)\. 

     **or**
   + Attach the `AmazonPersonalizeFullAccess` AWS managed policy to your IAM user or group \(see [AWS Managed Policies](security_iam_id-based-policy-examples.md#using-managed-policies)\)\.

1.  Attach the `AmazonS3FullAccess` AWS managed policy to your user or group to grant permissions to access Amazon S3 and create an Amazon S3 bucket\. For more information on granting permission to your Amazon S3 resources see [Using Bucket Policies and User Policies](https://docs.aws.amazon.com/AmazonS3/latest/dev/using-iam-policies.html) in the *Amazon S3 Developer Guide*\.

1.  Optionally attach the `CloudWatchFullAccess` AWS managed policy to your IAM user or group to grant permissions to monitor Amazon Personalize with CloudWatch\. See [AWS Managed Policies](security_iam_id-based-policy-examples.md#using-managed-policies)\. 

1.  Create an IAM role for Amazon Personalize and attach the policy from step 1 to the new role\. See [Creating an IAM Role for Amazon Personalize](#set-up-create-role-with-permissions)\. 

## Creating a New IAM Policy<a name="set-up-required-permissions"></a>

Create an IAM policy that provides users and Amazon Personalize full access to your Amazon Personalize resources\. Then attach the policy to your IAM user or group\. 

**To create and attach an IAM policy**

1. Sign in to the IAM console \([https://console\.aws\.amazon\.com/iam](https://console.aws.amazon.com/iam)\)\. 

1. In the navigation pane, choose **Policies**\. 

1. Choose **Create policy**\. 

1. Choose the **JSON** tab\. 

1.  Paste following JSON policy document in the text field\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "personalize:*"
               ],
               "Resource": "*"
           },
           {
               "Effect": "Allow",
               "Action": [
                   "iam:PassRole"
               ],
               "Resource": "*",
               "Condition": {
                   "StringEquals": {
                       "iam:PassedToService": "personalize.amazonaws.com"
                   }
               }
           }
       ]
   }
   ```

1. When you have finished, choose **Review policy**\. 

1. On the **Review policy** page, for **Name**, enter a name for the policy\. Optionally, enter a description for **Description**\. 

1. In **Summary**, review the policy to see the permissions it grants, then choose **Create policy**\.

1.  Attach the new policy to your IAM user or group\. 

   For information on attaching a policy to a user, see [Changing Permissions for an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html) in the *IAM User Guide*\. For information on attaching a policy to a group, see [Attaching a Policy to an IAM Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_groups_manage_attach-policy.html) in the *IAM User Guide*\. 

## Creating an IAM Role for Amazon Personalize<a name="set-up-create-role-with-permissions"></a>

In the following procedure, you create an IAM role that allows Amazon Personalize to access your resources and perform tasks on your behalf\.

1. Sign in to the IAM console \([https://console\.aws\.amazon\.com/iam](https://console.aws.amazon.com/iam)\)\.

1. In the navigation pane, choose **Roles**\.

1. Choose **Create role**\.

1. For **Select type of trusted entity**, choose **AWS service**\.

1. For **Choose the service that will use this role**, choose **Amazon Personalize**\. 

1. Choose **Next: Permissions**\.

1. For **Attach permissions policies**, either choose the policy you created in [Creating a New IAM Policy](#set-up-required-permissions) or choose `AmazonPersonalizeFullAccess` \(see [AWS Managed Policies](security_iam_id-based-policy-examples.md#using-managed-policies)\)\.

   1. To display the policy in the list, type part of the policy name in the **Filter policies** query filter\.

   1. Choose the check box next to the policy name\.

1. Choose **Next: Tags**\. You don't need to add any tags, so choose **Next: Review**\.

1. In the **Review** section, for **Role name**, enter a name for the role \(for example, `PersonalizeRole`\)\. Update the description for the role in **Role description**, then choose **Create role**\.

1. Choose the new role to open the role's summary page\.

1. Copy the **Role ARN** value and save it\. You need it to import a dataset into Amazon Personalize\.

   Next, you need upload training data and grant Amazon Personalize access to your Amazon S3 bucket\. See [Creating the Training Data](gs-prerequisites.md#gs-upload-to-bucket)\.