# Step 3: Create User Groups<a name="setting-up-non-admin-groups"></a>

Create a user group for each of the policies that you created in [Step 2: Create Policies](setting-up-non-admin-policies.md)\. This way, when you create additional users you can add the users to a group rather than attaching individual policies to each user\. 

**To create groups for users who need access to AWS Elemental MediaTailor**

1. In the navigation pane of the IAM console, choose **Groups**\.

1. On the **Groups** page, choose **Create New Group** and create an administrator group using the **MediaTailorAllAccess** policy: 

   1. On the **Set Group Name** page, enter a name for the group, such as **MediaTailorAdmins**\. Choose **Next Step**\.

   1. On the **Attach Policy** page, for **Filter**, choose **Customer Managed**\.

   1. In the policy list, choose the **MediaTailorAllAccess** policy that you created\.

   1. On the **Review** page, verify that the correct policy is added to this group, and then choose **Create Group**\.

1. On the **Groups** page, choose **Create New Group** and create a read\-only group using the **MediaTailorReadOnlyAccess** policy: 

   1. On the **Set Group Name** page, enter a name for the group, such as **MediaTailorReadOnly**\. Choose **Next Step**\.

   1. On the **Attach Policy** page, for **Filter**, choose **Customer Managed**\.

   1. In the policy list, choose the **MediaTailorReadOnlyAccess** policy that you created\.

   1. On the **Review** page, verify that the correct policy is added to this group, and then choose **Create Group**\.