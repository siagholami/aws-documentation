# Managing user accounts<a name="manage-users"></a>

Create users or enable existing users and edit user email addresses, create user email aliases, edit user details, and reset user passwords from Amazon WorkMail\.

**Topics**
+ [Creating users](#add_new_user)
+ [Enabling existing users](#enable_existing_user)
+ [Editing user email addresses](#edit_user_email_addresses)
+ [Editing user details](#edit_user_details)
+ [Resetting user passwords](#reset_user_password)
+ [Troubleshooting Amazon WorkMail password policies](#password-policies)

## Creating users<a name="add_new_user"></a>

When you create users, Amazon WorkMail creates mailboxes for them\. Users can log in and access their mail from the Amazon WorkMail web application, mobile device, or Microsoft Outlook on macOS or PC\.

**To create a user**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the AWS Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users** to see a list of all users in the directory\. This includes enabled, disabled, and system users as defined by the underlying directory\.

1. To create a user, choose **Create User**\.

1. On the **Add the details for your new user** screen, enter the user's first and last name, username, and display name and then choose **Next**\.

1. On the **Set up email address and password** screen, enter the user's email address and password, and choose **Add user**\.

## Enabling existing users<a name="enable_existing_user"></a>

When Amazon WorkMail is integrated with your corporate Active Directory or you already have users available in your Simple AD directory, you can enable these users in Amazon WorkMail\.

**To enable an existing directory user**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users** to see a list of all the users in the directory, including enabled, disabled, and system users\.

1. From the list of disabled users, select the users to enable and choose **Enable user**\.

1. In the **Enable user\(s\)** dialog box, review the primary email address and choose **Enable**\.

## Editing user email addresses<a name="edit_user_email_addresses"></a>

You can assign multiple email addresses to a single user and the default email address is used as the default sending address for outgoing email\. 

You can also add one or more email aliases, which can be used to send or receive email from a different address or domain\. For more information, see [Send as an alias](https://docs.aws.amazon.com/workmail/latest/userguide/send_alias.html)\.

**To edit a user's email address**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users**, and then in the list of users, select the name of the user to edit\.

1. On the **General** tab, choose **Edit**, **Add email address**, and then type the email address to add to this user\.

1. To set the new email address as the default, choose **Set as default**\.

## Editing user details<a name="edit_user_details"></a>

You can edit a user's first and last name, email address, display name, address, phone number, and company details\. You can also set a user's mailbox quota to as little as 1 MB or as much as 51,200 MB \(50 GB\)\. Users are notified when they reach 90 percent of their set mailbox quota\.

Changing a user's mailbox quota does not affect pricing\. For more information about pricing, see [Amazon WorkMail Pricing](http://aws.amazon.com/workmail/pricing/)\.

**Note**  
If you are integrating Amazon WorkMail with an AD Connector directory, you can't edit these details from the AWS Management Console\. Instead, you must edit them using your Active Directory management tools\. Limitations apply when your organization is in interoperability mode\. For more information, see [Limitations in interoperability mode](interoperability.md#interop_limitations)\.

**To edit a user's details**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users** and select the name of the user to edit\.

1. On the **General** tab, choose **Edit**, and then update any of the fields as appropriate\. To update a user's mailbox quota, choose the **Quota** tab\.

1. Choose **Save**\.

## Resetting user passwords<a name="reset_user_password"></a>

If a user forgets a password or is having trouble signing in to Amazon WorkMail, you can reset the password\. If you are integrating Amazon WorkMail with an AD Connector directory, you have to reset the user password in Active Directory\.

**To reset a user password**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users**\.

1. In the list of users, select the name of the user to edit and choose **Reset password**\.

1. In the **Reset Password** dialog box, type the new password and choose **Reset**\.

## Troubleshooting Amazon WorkMail password policies<a name="password-policies"></a>

If resetting the password is unsuccessful, verify that the new password meets the password policy requirements\.

The password policy requirements depend on which directory type is used by your Amazon WorkMail organization\.

**Amazon WorkMail directory and Simple AD directory password policy**  
By default, passwords for an Amazon WorkMail directory or Simple AD directory must be:
+ Non\-empty\.
+ At least eight characters\.
+ Less than 64 characters\.
+ Composed of Basic Latin or Latin\-1 supplement characters\.

Passwords must also contain characters from three out of five of the following groups:
+ Uppercase characters
+ Lowercase characters
+ Numerical digits
+ Special characters \(for example, `<`, `~`, or `!`\)
+ Latin\-1 supplement characters \(for example, `é`, `ü`, or `ñ`\)

Amazon WorkMail directory password policies cannot be changed\.

To change a Simple AD password policy, use the AD administration tools on an Amazon Elastic Compute Cloud \(Amazon EC2\) Windows instance of your Simple AD directory\. For more information, see [Installing the Active Directory administration tools](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/simple_ad_install_ad_tools.html) in the *AWS Directory Service Administration Guide*\.

**AWS Managed Microsoft AD Directory password policy**  
For information about the default password policy for an AWS Managed Microsoft AD directory, see [Manage Password Policies for AWS Managed Microsoft AD](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_password_policies.html) in the *AWS Directory Service Administration Guide*\.

**AD Connector password policy**  
AD Connector uses the password policy of the Active Directory domain that it is connected to\.