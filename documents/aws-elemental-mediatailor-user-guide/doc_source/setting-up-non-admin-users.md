# Step 4: Create Users<a name="setting-up-non-admin-users"></a>

Create IAM users for the individuals who require access to AWS Elemental MediaTailor\. Next, add each user to the appropriate user group to ensure that they have the right level of permissions\. If you already have users created, skip past the user creation steps to modify the permissions for the users\.

**To create users who can access AWS Elemental MediaTailor**

1. In the navigation pane of the IAM console, choose **Users**, and then choose **Add user**\.

1. For **User name**, enter the name that the user will use to sign in to MediaTailor\.

1. Select the check box next to **AWS Management Console access**, select **Custom password**, and then enter the new user's password in the box\. You can optionally select **Require password reset** to force the user to create a password the next time the user signs in\.

1. Choose **Next: Permissions**\.

1. On the **Set permissions for user** page, choose **Add user to group**\.

1. Modify the permissions for the users in the group list\. Choose the group with the appropriate attached policy\. Remember that permissions levels are as follows:
   + The group with the **MediaTailorAllAccess** policy allows all actions on all resources in MediaTailor\.
   + The group with the **MediaTailorReadOnlyAccess** policy allows read\-only rights for all resources in MediaTailor\.

1. Choose **Next: Review** to see the list of group memberships to be added to the new user\. When you are ready to proceed, choose **Create user**\.