# Managing User Access Inside Amazon QuickSight<a name="managing-quicksight-users"></a>

Amazon QuickSight administrators can use the following topics to manage user access to Amazon QuickSight and Amazon QuickSight access to AWS resources\.

**Topics**
+ [Managing User Accounts in Amazon QuickSight Standard Edition](managing-users.md)
+ [Managing User Accounts in Amazon QuickSight Enterprise Edition](managing-quicksight-users-enterprise.md)
+ [Inviting Users to Access Amazon QuickSight](#inviting-users)
+ [Viewing Amazon QuickSight User Account Details](#view-user-accounts)
+ [Deleting a User Account](#delete-a-user-account)

## Inviting Users to Access Amazon QuickSight<a name="inviting-users"></a>

In Standard edition, and in Enterprise edition using SSO, you can invite any person with a valid email address to use Amazon QuickSight\. When they sign up, a new Amazon QuickSight\-only user account is created for them\. You can also invite IAM users in your AWS account to use Amazon QuickSight\. In this case, they can use their IAM credentials to sign in to Amazon QuickSight\. Any IAM user you invite must have a password associated with their IAM credentials, and you must also have an email address for them\. 

User accounts are created in two steps\. First, you invite a user to join Amazon QuickSight\. Doing this creates an inactive user account in Amazon QuickSight, and sends an invitation email to the user\. When the user accepts the invitation and signs in for the first time, the user creates a password to activate the user account\.

For information about signing in for the first time, see [Signing In to Amazon QuickSight](signing-in.md)\.

Use the following procedure to invite a user to access Amazon QuickSight\.

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Manage Users**\. In this screen, you can manage users who already exist in your account\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/invite-users.png)

1. Choose **Invite users**\.

1. In the **Invite users to this account** screen, enter a new user name for a person to whom you want to grant access to Amazon QuickSight\. If the user is an IAM user, enter their IAM user name\. Then press **\+**\. A user's IAM user name can be the same as their email address\.

   Repeat this step until you have entered everyone you want to invite\. Then proceed to the next step to enter details\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/invite-users2.png)

1. For **Email**, type an email address for the user account\. If your company uses single sign\-on \(SSO\), the user's email domain must match yours\.

1. For **Role**, choose the role to assign to each person you are inviting\. A *role *determines the permission level to grant to that user account\.
   + Choose **ADMIN** if you want the user to be able to both use Amazon QuickSight for authoring and for performing administrative tasks like managing users or purchasing [SPICE](welcome.md#spice) capacity\.

     There are some differences in what administrative tasks IAM admin users and that Amazon QuickSight admin users can perform, because some administrative tasks require permissions in AWS, which Amazon QuickSight–only users lack\.
     + Admin users can manage users, [SPICE](welcome.md#spice) capacity, and subscriptions\. 
     + Admin users who are also IAM admin users can also manage users, SPICE capacity, and subscriptions\. In addition, they can manage Amazon QuickSight permissions to AWS resources, upgrade to Enterprise edition, and unsubscribe from Amazon QuickSight\.

     If you want to create an admin user with IAM admin access, check with your AWS administrator and make sure that the IAM user has the all necessary statements in their IAM permissions policy to work with Amazon QuickSight resources\. For more information about what statements are required, see [Setting Your IAM Policy](set-iam-policy.md)\.
   + Choose **AUTHOR** if you want the user to author analyses and dashboards in Amazon QuickSight but not perform any administrative tasks\.
   + In Enterprise edition, you can choose **READER** if you want the user to to be able to interact with shared dashboards, but not author analyses and dashboards, or perform any administrative tasks\.

1. For **IAM User**, verify that it says **Yes** for accounts that are associated with IAM users, and **No** for those that are Amazon QuickSight\-only\.

1. \(Optional\) To delete a user, choose the delete icon at the end of the relevant row\.

1. Choose **Invite**\.

### Resend an Invitation to a User<a name="resend-invitation"></a>

The sign\-up URL in the invitation email expires after 24 hours\. Use the following procedure if you need to resend an invitation to someone\.

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Manage Users**\.

1. Find the entry for the person you want to re\-invite, and choose **Resend invitation** for that user\.

1. Choose **Confirm**\.

## Viewing Amazon QuickSight User Account Details<a name="view-user-accounts"></a>

You can view Amazon QuickSight user accounts on the **Manage Users** page\. Use the following procedure to view a user account\.

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Manage Users**\.

1. Type a search term for **Search for a user** to search for a specific user account\. Any user name or email address that starts with the search term is shown\. Search is case\-insensitive and wildcards aren't supported\. To clear the search results and view all user accounts, delete the search term\.

1. Review the user name, email, assigned role, and status\. The status field shows either **ACTIVE** or **INACTIVE** to indicate whether or not the user has responded to the invitation email and activated an account\.

## Deleting a User Account<a name="delete-a-user-account"></a>

User accounts can be deleted by either an AWS administrator or an Amazon QuickSight administrator\. Deleting a user account works the same in both the Standard and Enterprise editions of Amazon QuickSight\. 

Deleting a user account removes or transfers their resources\. In Enterprise edition, the network administrator can temporarily deactivate a user account by removing it from the network group that has access to Amazon QuickSight\. If a user is deleted, but not deactivated, that user can still access Amazon QuickSight as a new user\. For more information about deactivating an Enterprise user account, see [Deactivating Active Directory User Accounts](managing-users-enterprise.md#deactivate-user-groups-enterprise)\.

Use the following procedure to delete a user account\. 

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Manage Users**\.

1. Locate the user account you want to delete and then choose the delete icon at the end of that row\.

1. Choose to either delete or transfer any resources owned by the user and then choose **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/xfer-user1.png)

1. Do one of the following:
   + If you chose to transfer user resources, type the user name of the account to transfer them to and then choose **Delete and transfer resources**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/xfer-user2.png)
   + If you chose to delete user resources, choose **Delete**\. You can't undo this action\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/xfer-user3.png)