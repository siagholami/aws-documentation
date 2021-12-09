# Step 1: Create user groups<a name="setting-up-IAM-users-create-nonadmin-user-groups"></a>

You can create a user group for each AWS Elemental MediaStore policy and assign users to a group rather than attaching individual policies to each user\. Using the following procedure, create two user groups: one for the `AWSElementalMediaStoreFullAccess` policy and one for the `AWSElementalMediaStoreReadOnly` policy\.

**Note**  
`AWSElementalMediaStoreFullAccess` and `AWSElementalMediaStoreReadOnly` are AWS managed policies\.

**To create user groups**

1. In the navigation pane of the IAM console, choose **Groups**, and then choose **Create New Group**\. 

1. On the **Groups** page, choose **Create New Group**, and then create an administrator group using the `AWSElementalMediaStoreFullAccess` policy\.

   1. On the **Set Group Name** page, enter a name for the group such as **MediaStoreAdmins**\.

   1. Choose **Next Step**\.

   1. On the **Attach Policy** page, for **Filter**, choose **AWS Managed**, and then enter **mediastore**\.

   1. In the policy list, choose the **AWSElementalMediaStoreFullAccess** policy\.

   1. Choose **Next Step**\.

   1. On the **Review** page, choose **Create Group**\.

1. On the **Groups** page, choose **Create New Group**, and then create a read\-only group using the `AWSElementalMediaStoreReadOnly` policy\.

   1. On the **Set Group Name** page, enter a name for the group such as **MediaStoreReaders**\.

   1. Choose **Next Step**\.

   1. On the **Attach Policy** page, for **Filter**, choose **AWS Managed**, and then enter **mediastore**\.

   1. In the policy list, choose the **AWSElementalMediaStoreReadOnly** policy\.

   1. Choose **Next Step**\.

   1. On the **Review** page, choose **Create Group**\.