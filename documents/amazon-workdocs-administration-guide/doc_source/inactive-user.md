# Disabling users<a name="inactive-user"></a>

You can disable a user's access by changing their status to **Inactive**\.

**To change user status to **Inactive****

1. From the admin control panel, under **Manage Users**, choose the pencil icon \(![\[pencil icon\]](http://docs.aws.amazon.com/workdocs/latest/adminguide/images/pencil_icon.png)\) next to the user's name\.

1. Choose **Inactive**, and choose **Save Changes**

The inactivated user no longer has access to your Amazon WorkDocs site\.

**Note**  
Changing a user to **Inactive** status does not delete their files, folders, or feedback from your Amazon WorkDocs site\. However, you can transfer files and folders to an active user\. For more information, see [Transferring document ownership](transfer-docs.md)\.

## Deleting pending users \(Simple AD only\)<a name="delete_user_cloud"></a>

You can only delete Simple AD users that are in **Pending** status\. To delete one of these users, choose the trash can icon \(![\[trash can icon\]](http://docs.aws.amazon.com/workdocs/latest/adminguide/images/trash_can_icon.png)\) next to the user's name\.

Your Amazon WorkDocs site must always have at least one active user that is not a guest user\. If you want to delete all users, you must delete your entire Amazon WorkDocs site\.

We do not recommend that you delete registered users\. Instead, you should switch a user from **Active** to **Inactive** status, so that they do not have access to your Amazon WorkDocs site\. 