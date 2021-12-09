# Step 3b: Create a user group<a name="setting-up-create-nonadmin-IAM-users-user-groups"></a>

You can create a user group for each policy and assign users to a group rather than attaching individual policies to each user\. Using the following procedure, create two user groups: one for the **MediaConnectAllAccess** policy and one for the **MediaConnectReadOnlyAccess** policy\.

**To create user groups**

1. In the navigation pane of the IAM console, choose **Groups**\.

1. On the **Groups** page, create an administrator group using the `MediaConnectAllAccess` policy:

   1. Choose **Create New Group**\.

   1. On the **Set Group Name** page, enter a name for the group, such as **MediaConnectAdmins**\.

   1. Choose **Next Step**\.

   1. On the **Attach Policy** page, for **Filter**, choose **Customer Managed**\.

   1. In the policy list, choose the **MediaConnectAllAccess** policy that you created in the procedure in [Step 3a: Create a Policy](setting-up-create-nonadmin-IAM-users-policies.md)\.

   1. Choose **Next Step**\.

   1. On the **Review** page, verify that the correct policies are added to this group, and then choose **Create Group**\.

1. On the **Groups** page, create a read\-only group using the `MediaConnectReaders` policy:

   1. Choose **Create New Group**\.

   1. On the **Set Group Name** page, enter a name for the group, such as **MediaConnectReaders**\.

   1. Choose **Next Step**\.

   1. On the **Attach Policy** page, for **Filter**, choose **Customer Managed**\.

   1. In the policy list, choose the **MediaConnectReadOnlyAccess** policy that you created in the procedure in [Step 3a: Create a Policy](setting-up-create-nonadmin-IAM-users-policies.md)\.

   1. Choose **Next Step**\.

   1. On the **Review** page, verify that the correct policies are added to this group, and then choose **Create Group**\.