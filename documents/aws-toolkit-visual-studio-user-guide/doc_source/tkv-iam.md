# Identity and Access Management<a name="tkv-iam"></a>

AWS Identity and Access Management \(IAM\) enables you to more securely manage access to your AWS accounts and resources\. With IAM, you can create multiple users in your primary \(*root*\) AWS account\. These users can have their own credentials: password, access key ID, and secret key, but all IAM users share a single account number\.

You can manage each IAM user's level of resource access by attaching IAM policies to the user\. For example, you can attach a policy to an IAM user that gives the user access to the Amazon S3 service and related resources in your account, but which doesn't provide access to any other services or resources\.

For more efficient access management, you can create IAM groups, which are collections of users\. When you attach a policy to the group, it will affect all users who are members of that group\.

In addition to managing permissions at the user and group level, IAM also supports the concept of IAM roles\. Like users and groups, you can attach policies to IAM roles\. You can then associate the IAM role with an Amazon EC2 instance\. Applications that run on the EC2 instance are able to access AWS using the permissions provided by the IAM role\. For more information about using IAM roles with the Toolkit, see [Create an IAM Role](#create-an-iam-role-tkv)\. For more information about IAM, go to the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/Welcome.html)\.

## Create and Configure an IAM User<a name="tkv-create-an-iam-user"></a>

IAM users enable you to grant others access to your AWS account\. Because you are able to attach policies to IAM users, you can precisely limit the resources an IAM user can access and the operations they can perform on those resources\.

As a best practice, all users who access an AWS account should do so as IAM users—even the owner of the account\. This ensures that if the credentials for one of the IAM users are compromised, just those credentials can be deactivated\. There is no need to deactivate or change the root credentials for the account\.

From the Toolkit for Visual Studio, you can assign permissions to an IAM user either by attaching an IAM policy to the user or by assigning the user to a group\. IAM users who are assigned to a group derive their permissions from the policies attached to the group\. For more information, see [Create an IAM Group](#create-an-iam-group-tkv) and [Add an IAM User to an IAM Group](#add-an-iam-user-to-an-iam-group-tkv)\.

From the Toolkit for Visual Studio, you can also generate AWS credentials \(access key ID and secret key\) for the IAM user\. For more information, see [Generate Credentials for an IAM User](#generate-credentials-for-an-iam-user-tkv) 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/inline-refresh-button.png)

The Toolkit for Visual Studio supports specifying IAM user credentials for accessing services through AWS Explorer\. Because IAM users typically do not have full access to all AWS services, some of the functionality in AWS Explorer might not be available\. If you use AWS Explorer to change resources while the active account is an IAM user and then switch the active account to the root account, the changes might not be visible until you refresh the view in AWS Explorer\. To refresh the view, choose the refresh \(\) button\.

For information about how to configure IAM users from the AWS Management Console, go to [Working with Users and Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_WorkingWithGroupsAndUsers.html) in the IAM User Guide\.

 *To create an IAM user* 

1. In AWS Explorer, expand the **AWS Identity and Access Management** node, open the context \(right\-click\) menu for **Users** and then choose **Create User**\.

1. In the **Create User** dialog box, type a name for the IAM user and choose **OK**\. This is the IAM [friendly name](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html)\. For information about constraints on names for IAM users, go to the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-user-create-dlg.png)

The new user will appear as a subnode under **Users** under the **AWS Identity and Access Management** node\.

For information about how to create a policy and attach it to the user, see [Create an IAM Policy](#tkv-create-an-iam-policy)\.

## Create an IAM Group<a name="create-an-iam-group-tkv"></a>

Groups provide a way of applying IAM policies to a collection of users\. For information about how to manage IAM users and groups, go to [Working with Users and Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_WorkingWithGroupsAndUsers.html) in the IAM User Guide\.

 *To create an IAM group* 

1. In AWS Explorer, under **Identity and Access Management**, open the context \(right\-click\) menu for **Groups** and choose **Create Group**\.

1. In the **Create Group** dialog box, type a name for the IAM group and choose **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-group-create-dlg.png)

The new IAM group will appear under the **Groups** subnode of **Identity and Access Management**\.

For information about to create a policy and attach it to the IAM group, see [Create an IAM Policy](#tkv-create-an-iam-policy)\.

## Add an IAM User to an IAM Group<a name="add-an-iam-user-to-an-iam-group-tkv"></a>

IAM users who are members of an IAM group derive access permissions from the policies attached to the group\. The purpose of an IAM group is to make it easier to manage permissions across a collection of IAM users\.

For information about how the policies attached to an IAM group interact with the policies attached to IAM users who are members of that IAM group, go to [Managing IAM Policies in the IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingPolicies.html)\.

In AWS Explorer, you add IAM users to IAM groups from the **Users** subnode, not the **Groups** subnode\.

 *To add an IAM user to a IAM group* 

1. In AWS Explorer, under **Identity and Access Management**, open the context \(right\-click\) menu for **Users** and choose **Edit**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-group-assign.png)

1. The left pane of the **Groups** tab displays the available IAM groups\. The right pane displays the groups of which the specified IAM user is already a member\.

   To add the IAM user to a group, in the left pane, choose the IAM group and then choose the **>** button\.

   To remove the IAM user from a group, in the right pane, choose the IAM group and then choose the **<** button\.

   To add the IAM user to all of the IAM groups, choose the **>>** button\. Similarly, to remove the IAM user from all of the groups, choose the **<<** button\.

   To choose multiple groups, choose them in sequence\. You do not need to hold down the Control key\. To clear a group from your selection, simply choose it a second time\.

1. When you have finished assigning the IAM user to IAM groups, choose **Save**\.

## Generate Credentials for an IAM User<a name="generate-credentials-for-an-iam-user-tkv"></a>

With Toolkit for Visual Studio, you can generate the access key ID and secret key used to make API calls to AWS\. These keys can also be specified to access AWS services through the Toolkit\. For more information about how to specify credentials for use with the Toolkit, see creds\. For more information about how to safely handle credentials, see [Best Practices for Managing AWS Access Keys](https://docs.aws.amazon.com/general/latest/gr/aws-access-keys-best-practices.html)\.

The Toolkit cannot be used to generate a password for an IAM user\.

 *To generate credentials for an IAM user* 

1. In AWS Explorer, open the context \(right\-click\) menu for an IAM user and choose **Edit**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-user-creds-list.png)

1. To generate credentials, on the **Access Keys** tab, choose **Create**\.

   You can generate only two sets of credentials per IAM user\. If you already have two sets of credentials and need to create an additional set, you must delete one of the existing sets\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-user-creds-create.png)

   If you want the Toolkit to save an encrypted copy of your secret access key to your local drive, select **Save the secret access key locally\. AWS only returns the secret access key when created**\. You can also copy the secret access key from the dialog box and save it in a secure location\.

1. Choose **OK**\.

After you generate the credentials, you can view them from the **Access Keys** tab\. If you selected the option to have the Toolkit save the secret key locally, it will be displayed here\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-user-show-creds.png)

If you saved the secret key yourself and would also like the Toolkit to save it, in the **Secret Access Key** box, type the secret access key, and then select **Save the secret access key locally**\.

To deactivate the credentials, choose **Make Inactive**\. \(You might do this if you suspect the credentials have been compromised\. You can reactivate the credentials if you receive an assurance they are secure\.\)

## Create an IAM Role<a name="create-an-iam-role-tkv"></a>

The Toolkit for Visual Studio supports the creation and configuration of IAM roles\. Just as with users and groups, you can attach policies to IAM roles\. You can then associate the IAM role with an Amazon EC2 instance\. The association with the EC2 instance is handled through an *instance profile*, which is a logical container for the role\. Applications that run on the EC2 instance are automatically granted the level of access specified by the policy associated with the IAM role\. This is true even when the application hasn't specified other AWS credentials\.

For example, you can create a role and attach a policy to that role that limits access to Amazon S3 only\. After associating this role with an EC2 instance, you can then run an application on that instance and the application will have access to Amazon S3, but not to any other services or resources\. The advantage of this approach is that you don't need to be concerned with securely transferring and storing AWS credentials on the EC2 instance\.

For more information about IAM roles, go to [Working with IAM Roles in the IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html)\. For examples of programs accessing AWS using the IAM role associated with an Amazon EC2 instance, go to the AWS developer guides for [Java](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/java-dg-roles), [\.NET](https://docs.aws.amazon.com/sdk-for-net/latest/developer-guide/net-dg-hosm.html), [PHP](https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials_assume_role.html), and Ruby \([Setting Credentials Using IAM](https://docs.aws.amazon.com/sdk-for-ruby/latest/developer-guide/setup-config.html#aws-ruby-sdk-credentials-iam), [Creating an IAM Role](https://docs.aws.amazon.com/sdk-for-ruby/latest/developer-guide/iam-example-create-role.html), and [Working with IAM Policies](https://docs.aws.amazon.com/sdk-for-ruby/latest/developer-guide/iam-example-working-with-policies.html)\)\.

 *To create an IAM role* 

1. In AWS Explorer, under **Identity and Access Management**, open the context \(right\-click\) menu for **Roles** and then choose **Create Roles**\.

1. In the **Create Role** dialog box, type a name for the IAM role and choose **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-role-create-dlg.png)

The new IAM role will appears under **Roles** in **Identity and Access Management**\.

For information about how to create a policy and attach it to the role, see [Create an IAM Policy](#tkv-create-an-iam-policy)\.

## Create an IAM Policy<a name="tkv-create-an-iam-policy"></a>

Policies are fundamental to IAM\. Policies can be associated with IAM *entities* such as users, groups, or roles\. Policies specify the level of access enabled for a user, group, or role\.

 *To create an IAM policy* 

In AWS Explorer, expand the **AWS Identity and Access Management** node, then expand the node for the type of entity \(**Groups**, **Roles**, or **Users**\) to which you will attach the policy\. For example, open a context menu for an IAM role and choose **Edit**\.

A tab associated with the role will appear in the AWS Explorer\. Choose the **Add Policy** link\.

In the **New Policy Name** dialog box, type a name for the policy \(for example, s3\-access\)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-policy-create-dlg.png)

In the policy editor, add policy statements to specify the level of access to provide to the role \(in this example, winapp\-instance\-role\-2 associated with the policy\. In this example, a policy provides full access to Amazon S3, but no access to any other resources\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/iam-policy-specify.png)

For more precise access control, you can expand the subnodes in the policy editor to allow or disallow actions associated with AWS services\.

When you have edited the policy, choose the **Save** link\.