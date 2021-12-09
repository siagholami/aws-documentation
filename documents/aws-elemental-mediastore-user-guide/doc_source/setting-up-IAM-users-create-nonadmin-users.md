# Step 2: Create users<a name="setting-up-IAM-users-create-nonadmin-users"></a>

Create IAM users for the individuals who require access to AWS Elemental MediaStore, and add each user to the appropriate user group to ensure that they have the right level of permissions\.

**To create users**

1. In the navigation pane of the IAM console, choose **Users**, and then choose **Add user**\.

1. For **User name**, enter the name that the user will use to sign in to MediaStore\.

1. Select the check box next to **AWS Management Console access**, select **Custom password**, and then enter the new user's password in the box\. You can optionally select **Require password reset** to force the user to create a password the next time the user signs in\.

1. Choose **Next: Permissions**\.

1. On the **Set permissions for user** page, choose **Add user to group**\.

1. In the group list, choose the group with the appropriate attached policy\. Remember that permissions levels are as follows:
   + The **MediaStoreAdmins** group has permissions that allow all actions on all resources in MediaStore\.
   + The **MediaStoreReaders** group has permissions that allow read\-only rights for all resources in MediaStore\.

1. Choose **Next: Review** to see the list of group memberships that will be added to the new user\. 

1. When you are ready to proceed, choose **Create user**\.