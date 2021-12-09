# Step 5: Cleaning up resources<a name="cleanup"></a>

When your migration is complete, delete the migration policy and role that you created from the IAM console\.

**To delete the IAM policy and role**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Policies**\.

1. Search for and select the policy that you created\.

1. For **Policy actions**, choose **Delete**\.

1. Choose **Delete**\.

1. Choose **Roles**\.

1. Search for and select the role that you created\.

1. Choose **Delete role**, **Delete**\.

When a scheduled migration starts, your Amazon WorkDocs user account **Storage** setting is automatically changed to **Unlimited**\. After the migration, you can change your **Storage** settings by editing your user account from the admin control panel\. For more information, see [Editing users](edit_user.md)\.