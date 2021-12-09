# Identity and Access Management<a name="tke-iam"></a>

AWS Identity and Access Management \(IAM\) lets you control who can access your AWS resources and what they can do with them\. The AWS Explorer lets you create and manage IAM users, groups, and roles\. You can also set a password policy for users, which lets you specify password requirements like minimum length, and lets you specify whether users are allowed to change their own passwords\.

**Note**  
It is a best practice for *all users, even the account owner*, to access AWS resources as IAM users\. This ensures that if the credentials for one of the IAM users are compromised, the affected credentials can be revoked without needing to change the root credentials for the account\.

## About AWS Identity and Access Management<a name="about-iamlong"></a>

Instead of sharing the password and security credentials for your account \(the access key ID and secret access key\), you can create *IAM users* that can each have their own password and security credentials\. You can then attach *policies* to users; in the policies you specify permissions that determine what actions a user can take and what resources the user is allowed access to\.

For convenience, instead of adding policies to individual users, you can create *IAM groups* \(for example, *Admins* and *Developers*\) attach policies to them, and then add users to those groups\. You can also create *roles* that have policies with permissions\. Roles can be assumed by users who are in other accounts, by services, and by users who do not have an IAM identity\. For more information about IAM, see the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\.

## Create an IAM User<a name="tke-create-an-iam-user"></a>

You create IAM users so that others in your organization can have their own AWS identity\. You can assign permissions to an IAM user either by attaching an IAM policy to the user or by assigning the user to a group\. IAM users that are assigned to a group derive their permissions from the policies that are attached to the group\. For more information, see [Create an IAM Group](#tke-create-an-iam-group) and [Add an IAM User to an IAM Group](#tke-add-an-iam-user-to-an-iam-group)\.

Using the Toolkit, you can also generate AWS credentials \(access key ID and secret access key\) for the IAM user\. For more information, see [Manage Credentials for an IAM User](#tke-generate-credentials-for-an-iam-user)\.

**To create an IAM User**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Users** node, and then select **Create New Users**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-create-menu.png)

1. In the **Create New Users** dialog box, enter up to five names for new IAM users, and then click **Finish**\. For information about constraints on names for IAM users, see [Limitations on IAM Entities](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html) in the IAM User Guide\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-create-dlg.png)

For information about adding a user to a group, see [Add an IAM User to an IAM Group](#tke-add-an-iam-user-to-an-iam-group)\. For information about how to create a policy and attach it to the user, see [Attach an IAM Policy to a User, Group, or Role](#tke-create-an-iam-policy)\.

## Create an IAM Group<a name="tke-create-an-iam-group"></a>

You can add IAM users to groups in order to make it easier to manage permissions\. Any permissions that are attached to the group apply to any users in that group\. For more information about IAM groups, see [Working with Users and Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the IAM User Guide\.

When you create a group, you can create a policy that includes the permissions that members of the group will have\.

**To create an IAM group**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Groups** node, and then select **Create New Group**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-group-create-menu.png)

1. Enter a name for the new IAM group and then click **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-group-create-dlg.png)

1. Enter a name for the policy that establishes what members of the group are allowed to do\. Enter the policy as a JSON document, and then click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-create-group-permissions.png)

   The policy name must be unique within your account\. The JSON that you enter for the policy must validate, or you will not be able to save the policy\. For information about how to create a policy, see [Overview of Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) in the IAM User Guide\.

1. Click **Finish**\.

For information about attaching additional policies to the IAM group, see [Attach an IAM Policy to a User, Group, or Role](#tke-create-an-iam-policy)\.

## Add an IAM User to an IAM Group<a name="tke-add-an-iam-user-to-an-iam-group"></a>

If an IAM user is added to a group, any policies that are attached to the group are also in effect for the user\. For more information about IAM users, see [Users and Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the IAM User Guide\.

**To add an IAM user to a IAM group**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Groups** node, and then select **Open Groups Editor**\. Note that you add IAM users to IAM groups from the **Groups** node in **AWS Explorer** rather than from the **Users** node\.

1. In the **Groups** editor, select the group you want to add users to, and then click the **Users** tab\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-group-users-tab.png)

1. On the right\-hand side of the bottom pane, click the **Add Users** button\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-group-add-users-button.png)

1. In the **Add Users to Group** dialog box, select the users you want to add, and then click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-group-add-users-to-group-dlg.png)

## Manage Credentials for an IAM User<a name="tke-generate-credentials-for-an-iam-user"></a>

For each user, you can add a password\. IAM users use a password to work with AWS resources in the AWS Management Console\.

**To create a password for an IAM user**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Users** node, and then select **Open Users Editor**\.

1. In the users listing, select the user you want to create a password for, and then click the **Summary** tab\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-summary-tab.png)

1. On the right\-hand side of the bottom pane, click the **Update Password** button\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-update-password-button.png)

1. In the **Update User Password** dialog box, enter a password and then click **OK**\.
**Note**  
The new password will overwrite any existing password\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-update-user-password-dlg.png)

For each user you can also generate a set of access keys \(an access key ID and a secret access key\)\. These keys can be used to represent the user for programmatic access to AWS—for example, to use the AWS command\-line interface \(CLI\), to sign programmatic requests using the SDK, or to access AWS services through the Toolkit\. \(For information about how to specify credentials for use with the Toolkit, see [Set up AWS Credentials](setup-credentials.md)\.\)

**To generate access keys for an IAM user**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Users** node, and then select **Open Users Editor**\.

1. In the users listing, select the user you want to generate keys for, and then click the **Summary** tab\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-summary-tab.png)

1. Click the **Manage Access Keys** button\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-users-manage-access-keys-button.png)

   A window is displayed where you can manage access keys for the user\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-user-create-access-key-listing-dlg.png)

1. Click the **Create Access Key** button\.

   The **Manage Access Key** dialog box is displayed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-user-manage-access-key-dlg.png)

1. Click the **Download** button to download a comma\-separated value \(CSV\) file that contains the credentials that were generated\.
**Note**  
This will be your only opportunity to view and download these access keys\. If you lose these keys, you must delete them and create a new set of access keys\.

You can generate only two sets of credentials per IAM user\. If you already have two sets of credentials and you need to create an additional set, you must delete one of the existing sets first\.

You can also deactivate credentials\. In that case, the credentials still exist, but any requests to AWS that are made using those credentials will fail\. This is useful if you want to temporarily disable access to AWS for that set of credentials\. You can reactivate credentials that were previously deactivated\.

**To delete, deactivate, or reactivate access keys for an IAM user**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Users** node, and then select **Open Users Editor**\.

1. In the users listing, select the user you want to manage access keys for, click the **Summary** tab, and then click the **Manage Access Keys** button\.

1. In the window that lists the access keys for that user, right\-click the credentials you want to manage and then choose one of the following:
   +  **Delete Access Key** 
   +  **Make Inactive** 
   +  **Make Active**   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-user-delete-inactivate-keys-menu.png)

## Create an IAM Role<a name="tke-create-an-iam-role"></a>

Using the AWS Toolkit, you can create IAM *roles*\. The role can then be *assumed* by entities that you want to allow access to your AWS resources\. Policies that you attach to the role determine who can assume the role \(the *trusted entity* or *principal*\) and what those entities are allowed to do\.

In the Toolkit, you can specify the following trusted entities:
+ An AWS service\. For example, you can specify that an Amazon EC2 can call other AWS services or that AWS Data Pipeline is allowed to manage Amazon EC2 instances\. This is known as a *service role*\.
+ A different account that you own\. If you have multiple AWS accounts, you might need to let users in one account use a role to get permissions to access resources that are in another account of yours\.
+ A third\-party account\. You might let a third\-party vendor manage your AWS resources\. In that case, you can create a role in which the trusted entity is the third party’s AWS account\.

After you specify who the trusted entity is, you can specify a policy that determines what the role is allowed to do\.

For example, you could create a role and attach a policy to that role that limits access to only one of your Amazon S3 buckets\. You can then associate the role with an Amazon EC2 instance\. When an application runs on the Amazon EC2 instance, the application can access only the Amazon S3 bucket that you allowed access to in the role’s policy\.

For more information about IAM roles, see [IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) in the IAM User Guide\.

**To create an IAM role**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node, right\-click the **Roles** node, and then select **Create New Role**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-role-create-menu.png)

1. Enter a name for the IAM role and then click **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-role-create-dlg.png)

1. Select the trusted entity for the role\. To create a service role, select **AWS Service Roles** and then select a service role from the drop\-down list\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-create-role-service-role.png)

   To provide access for a user that’s defined in a different AWS account that you own, select **Account ID** and enter the AWS account number of the other account\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-create-role-cross-account.png)

   To provide access for a third\-party account, select **Account ID** and enter the third party’s AWS account number\. If the third party has provided you with an [external ID](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user_externalid.html), enter that as well\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-create-role-third-party.png)

1. Click **Next**\.

1. Enter a name for the policy that establishes what the role is allowed to do\. Then enter the policy as a JSON document, and click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-create-role-permissions.png)

   The policy name must be unique within your account\. The JSON that you enter for the policy must validate, or you will not be able to save the policy\. For information about how to create a policy, see [Overview of Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) in the *Using IAM* guide\.

1. Click **Finish**\.

   The new IAM role appears in the **Roles** editor\.

For examples that show how to access AWS using the IAM role associated with an Amazon EC2 instance, see [Using IAM Roles to Grant Access to AWS Resources on Amazon EC2](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-roles.html) in the AWS SDK for Java Developer Guide\.

## Attach an IAM Policy to a User, Group, or Role<a name="tke-create-an-iam-policy"></a>

Policies are documents that define permissions\. For example, a policy that’s attached to a user can specify what AWS actions the user is allowed to call and what resources the user is allowed to perform the actions on\. If the policy is attached to a group, the permissions apply to users in the group\. If the policy is attached to a role, the permissions apply to whoever assumes the role\.

The process for attaching a policy to a user or group is similar\. For roles, you can attach a policy that specifies what the role is allowed to do\. You use a separate process to attach or edit the policy that determines who is allowed to assume the role \(that is, to manage the trust relationship\.\)

**Note**  
If you attached a policy to a user, group, or role previously, you can use this procedure to attach an additional policy\. To edit an existing policy on a user, group, or role, use the IAM console, command\-line tools, or API calls\.

**To create an IAM policy for a user, group, or role**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node and then double\-click the **Groups** node, the **Users** node, or the **Roles** node\.

1. Select the group, user, or role you want to attach the policy to, and then click the **Permissions** tab\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-groups-permissions-tab.png)

1. On the right\-hand side of the bottom pane, click the **Attach Policy** button\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-groups-attach-policy-btn.png)

1. In the **Manage Group Policy**, **Manage User Policy**, or **Manage Role Permissions** dialog box, enter a name for the policy\. Then enter the policy as a JSON document, and click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-groups-manage-group-policy-dlg.png)

   The policy name must be unique within your account\. The JSON that you enter for the policy must validate, or you will not be able to save the policy\. For information about how to create a policy, see [Overview of IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) in the IAM User Guide\.

**To create or manage a trust relationship for a role**

1. In **AWS Explorer**, expand the **AWS Identity and Access Management** node and then double\-click the **Roles** node\.

1. In the **Roles** editor, select the role you want to manage, and then click the **Trust Relationships** tab\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-roles-trustrelationships-tab.png)

1. On the right\-hand side of the bottom pane, click the **Edit Trust Relationship** button\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-role-trustrelationship-btn.png)

1. In the **Edit Trust Relationship** dialog box, edit the JSON policy document and then click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-roles-edittrustrelationship-dlg.png)

## Set Password Policy<a name="tke-set-password-policy"></a>

In the AWS Toolkit for Eclipse you can set a password policy for your account\. This lets you make sure that passwords that are created for IAM users follow certain guidelines for length and complexity\. It also lets you specify whether users are allowed to change their own passwords\. For more information, see [Managing an IAM Password Policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_passwords_account-policy.html) in the IAM User Guide\.

**To create an IAM policy for a user or group**

1. In **AWS Explorer**, under **Identity and Access Management**, double\-click the **Password Policy** node\.

1. In the **Password Policy** pane, specify the policy options that you want for your AWS account, and then click **Apply Password Policy**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/iam-password-policy.png)