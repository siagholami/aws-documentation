# Managing User Accounts in Amazon QuickSight Enterprise Edition<a name="managing-users-enterprise"></a>

AWS administrators can use this topic to learn more about managing user accounts in Amazon QuickSight Enterprise edition\. For information about managing user accounts in Amazon QuickSight Standard edition, see [Managing User Accounts in Amazon QuickSight Standard Edition](managing-users.md)\.

In Enterprise edition, you can manage users through any of the following: 
+ Active Directory\. You can add and remove Microsoft Active Directory directory groups to create and deactivate user accounts\. You can access the directory groups directly or by using the AD Connector\. 
+ Federated logins\.
+ Inviting users by email\.

To do this, you must have both administrative privileges in Amazon QuickSight and also appropriate AWS permissions\. For more information on the necessary AWS permissions, see [Setting Your IAM Policy](set-iam-policy.md)\. If you are using directory groups, you need to be a network administrator\.

Each Amazon QuickSight Enterprise edition account can have an unlimited number of user accounts\. User names that contain a semicolon \(` ; `\) aren't supported\.

Use the following procedures to add, view, and deactivate Amazon QuickSight Enterprise edition user accounts\.

**Important**  
You can't remap Amazon QuickSight users or groups from one identity store to another\. For example, if you are migrating from an on\-premises Active Directory to AWS Directory Service, or the other way around, you have to unsubscribe and resubscribe to Amazon QuickSight\. This functionality applies because even if the user's aliases remain the same, the underlying identity data changes\. To make the transition easier, request in advance that your users document all their Amazon QuickSight assets and settings before the migration\. 

## Adding User Accounts<a name="add-user-accounts-enterprise"></a>

Whether you are using federated logins or inviting users by email or using Active Directory, an Amazon QuickSight administrator can directly add users to Amazon QuickSight\. If you are using Microsoft Active Directory, you can also manage users through groups\. You can create multiple user accounts at once by choosing one or more Active Directory groups to integrate with Amazon QuickSight\. All users in the selected groups are authorized to sign in to Amazon QuickSight\. You can also add user accounts individually by adding those users to Active Directory groups that are already integrated with Amazon QuickSight\.

To see what groups are integrated with your Amazon QuickSight account, use the procedure in [Viewing User Account Details](#view-user-accounts-enterprise)\. For more information about adding a user to a Microsoft Active Directory directory group, see [Add Users and Groups \(Simple AD and Microsoft Active Directory\)](https://docs.aws.amazon.com/directoryservice/latest/admin-guide//creating_ad_users_and_groups.html)\. Or you can read more about how to [connect to a directory using AD Connector](https://docs.aws.amazon.com//directoryservice/latest/admin-guide/directory_ad_connector.html)\.

Users who are invited by email are notified how to sign in\. Other users aren't automatically notified of their access to Amazon QuickSight\. You or your assigned Amazon QuickSight administrator must provide users with your Amazon QuickSight account name, the sign\-in URL \([https://quicksight\.aws\.amazon\.com/](https://quicksight.aws.amazon.com/)\), and instructions to sign in\. 

**Note**  
Although you can manage users through Active Directory groups or as AWS Identity and Access Management \(IAM\) users, you don't have to do it this way\. You can instead choose to invite Amazon QuickSight–only users by email\. Choose the **Manage Users** feature of the **Manage QuickSight** page, and enter an email address to invite someone to join your Amazon QuickSight account\. Each user gets an email containing a link to Amazon QuickSight\. Using the invitation link, the user can then set up a user name and password in Amazon QuickSight\. Users can also request access through self\-provisioning\. For more information on requesting access, see [Provisioning Users for Amazon QuickSight](provisioning-users.md)\.  
Amazon QuickSight subscriptions based on Active Directory can only have users provisioned in Active Directory\.

## Viewing User Account Details<a name="view-user-accounts-enterprise"></a>

Use the following procedure to view the users or groups that are integrated with Amazon QuickSight\. 

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Manage Users**\. On this screen, you can see which users were active this month\. You can also see deleted users\. 

1. \(Optional\) If you are using Microsoft Active Directory and you have the correct administrative permissions, you can view the directory groups integrated with Amazon QuickSight\. 

   Choose **Manage groups**\. 

1. \(Optional\) If you are managing groups, then enter your AWS or IAM credentials on the AWS sign\-in page that appears\.

## Deactivating Active Directory User Accounts<a name="deactivate-user-groups-enterprise"></a>

Deactivating a group or user account removes that group or user's access to Amazon QuickSight resources, like analyses or data sets\. However, it doesn't delete resources they own and it doesn't release their [SPICE](welcome.md#spice) capacity\. After deactivating a user, you can delete the user from your Amazon QuickSight account\. When you delete a user, Amazon QuickSight gives you the option to either delete the user's resources or transfer their resources to another user\.

To deactivate a user account individually, remove that user from all Microsoft Active Directory directory groups that are integrated with Amazon QuickSight\. To view the groups integrated with your Amazon QuickSight account, use the procedure in [Viewing User Account Details](#view-user-accounts-enterprise)\. 

If you later need to reactivate a user account, put the user into a group with access to Amazon QuickSight\. This restores their access to Amazon QuickSight and to any existing resources that are still associated with that user account\. 

**Note**  
You can't upgrade or downgrade a user by transferring them between groups\. For more information, see [Updating Enterprise User Accounts](#updating-user-accounts-enterprise)\.

You can activate or deactivate multiple user accounts at once by adding or removing one or more Microsoft Active Directory directory groups from integration with Amazon QuickSight\. 

**Important**  
Removing all groups and users doesn't remove any resources and doesn't cancel your subscription to Amazon QuickSight\.

Use the following procedure to remove a Microsoft Active Directory directory group from Amazon QuickSight\.

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Manage Users**\.

1. Choose **Manage groups**\.

1. On the AWS sign\-in page, enter your AWS or IAM credentials\.

1. Locate the group that you want to remove under either the **Administrator groups** or the **User groups** section, and then choose the `x`\-shaped delete icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/deactivate-groups.png)

1.  In the **Manage users** screen, You can view each deactivated user in the **Deleted user** section\. This is located beneath the **Active users this month** section\. 

    To transfer the user's resources, click on the **Action** "x" button beside that user's name\. You are prompted to decide what to do with resources owned solely by that user\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/transfer-resources.png)

   Choose one of the following:
   +  Transfer ownership of all orphaned resources to a different user in this account\. 
   +  Delete all orphaned resources\. \(This frees the user's [SPICE](welcome.md#spice) capacity\.\) 
**Warning**  
You can't undo this action\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/confirm-deleted-account.png)

   Whichever action you choose applies to all resources owned solely by that user\. If you transfer the user's resources, Amazon QuickSight reassigns them to the user you choose\. It doesn't make unnecessary duplicates of those resources\.

## Updating Enterprise User Accounts<a name="updating-user-accounts-enterprise"></a>

You can upgrade or downgrade between author and admin users in the **Manage users** tab of the **Manage QuickSight** screen\. If you are using directory groups, you can instead move a user into the appropriate group\. To do this, you need both administrative privileges in Amazon QuickSight and also appropriate AWS permissions\. Some limitations apply on upgrading or downgrading user access in this automated way\. 

To downgrade authors to the readers, you delete the users and then recreate them as readers\. After you choose to remove a user, you are prompted to transfer or delete their assets\. If you are using directory groups, also move that user into the appropriate group\. Just moving them into another group doesn't change their access the way it does for transfers between admin and author\.

You can change a user's name by first creating a new user and then deleting the original user\. By using this approach, you can transfer their assets directly back to them\. If you are using a directory service, you can temporarily transfer their assets to a different user\. Then, make your changes in Active Directory\. The next time the user signs in to Amazon QuickSight, they are asked to create a new account\. After they create the new account, the user possessing their assets can transfer all assets back to them\. 

## Deleting Enterprise User Accounts<a name="delete-a-user-account-enterprise"></a>

Deleting a user account works the same way in both the Standard and Enterprise editions of Amazon QuickSight\. User accounts can be deleted by an Amazon QuickSight administrator\. To delete a user account, use the procedure in [Deleting a User Account](managing-quicksight-users.md#delete-a-user-account)\.