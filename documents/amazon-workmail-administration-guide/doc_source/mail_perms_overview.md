# Working with mailbox permissions<a name="mail_perms_overview"></a>

You can use mailbox permissions in Amazon WorkMail to grant users or groups the right to work in other users' mailboxes\. Mailbox permissions apply to an entire mailbox, enabling multiple users to access the same mailbox without sharing the credentials for that mailbox\. Users with mailbox permissions can read and modify mailbox data and send email from the shared mailbox\.

The following list shows the permissions that you can grant:
+ **Send On Behalf**: Enables a user or group to send email on behalf of another user\. The mailbox owner appears in the **From:** header, and the sender appears in the **Sender:** header\. 
+ **Send As**: Enables a user or group to send email as the mailbox owner, without showing the actual sender of the message\. The mailbox owner appears in both the **From:** and **Sender:** headers\.
+ **Full Access**: Enables full read and write access to the mailbox, including permissions to modify folder\-level permissions\.

**Note**  
Granting mailbox permissions to a group extends those permissions to all the members of that group, including members of nested groups\.

When you grant mailbox permissions, the Amazon WorkMail AutoDiscover service automatically updates access to those mailboxes for the users or groups you added\. 

For the Microsoft Outlook client in Windows, users with full access permissions can automatically access the shared mailboxes\. Allow up to 60 minutes for the changes to propagate, or restart Microsoft Outlook\. 

For the Amazon WorkMail web application and other email clients, users with full access permissions can manually open the shared mailboxes\. Opened mailboxes stay open, even between sessions, unless the user closes them\.

**Topics**
+ [Mailbox and folder permissions](#mail_vs_folder)
+ [Enabling mailbox permissions](#enable_mail_perms)
+ [Editing mailbox permissions](#edit_mail_perms)
+ [Removing mailbox permissions](#remove_mail_perms)
+ [Managing group permissions](#manage_group_perms)

## Mailbox and folder permissions<a name="mail_vs_folder"></a>

Mailbox permissions apply to all folders in a mailbox\. These permissions can only be enabled by the AWS account holder or the IAM user authorized to call the Amazon WorkMail management API\. To apply the permissions to mailboxes or groups as a whole, log in to the AWS Management Console or use the Amazon WorkMail API\. You can manage up to 100 mailbox and group permissions from the console\. To manage more permissions, use the Amazon WorkMail API\.

Folder permissions apply only to a single folder\. These permissions can be set by end users, either by using an email client or by using the Amazon WorkMail web application\.

## Enabling mailbox permissions<a name="enable_mail_perms"></a>

You can enable other users to access a mailbox using the Amazon WorkMail web application\.

**To enable mailbox permissions**

1. In the Amazon WorkMail application, on the **User details** page under **Permissions**, choose **Add or remove**\.

1. Under **Users and groups**, select the user or group to share your inbox and choose **>>** to add them to the **Permissions** list\. Choose **Save**\. 

1. On the **Permissions** tab, select the level of permissions to grant and choose **Save**\. 

Updated permissions can take up to five minutes to propagate\.

## Editing mailbox permissions<a name="edit_mail_perms"></a>

You can edit existing mailbox permissions for Amazon WorkMail\.

**To edit mailbox permissions**

1. In the Amazon WorkMail application, on the **User details** page under **Permissions**, choose **Edit**\.

1. Select the permissions to change and choose **Save**\. 

Updated permissions can take up to five minutes to propagate\.

## Removing mailbox permissions<a name="remove_mail_perms"></a>

You can remove existing mailbox permissions for Amazon WorkMail\.

**To remove mailbox permissions**

1. In the Amazon WorkMail application, on the **User details** page under **Permissions**, choose **Add or remove**\.

1. Under **Users and groups**, select the user or group and remove them from the **Permissions** list\.

1. Choose **Save**\.

Updated permissions can take up to five minutes to propagate\.

## Managing group permissions<a name="manage_group_perms"></a>

You can add or remove group permissions for Amazon WorkMail\.

**Note**  
**Full Access** permissions are not available for groups, because groups do not have a mailbox to access\.

**To manage group permissions**

1. In the Amazon WorkMail application, on the **Groups** page under **WorkMail groups**, select the group to manage\.

1. Under **Permissions**, choose **Add or remove**\.

1. Under **Users and groups**, select the group to add or remove\. Add or remove them from the **Permissions** list and choose **Save**\.
**Note**  
If you added a group to the **Permissions** list, select the level of permissions to grant under the **Permissions** tab and choose **Save**\.

Updated permissions can take up to five minutes to propagate\.