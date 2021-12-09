# Administering your SiteWise Monitor portals<a name="administer-portals"></a>

You might need to update portal details, change administrators, or add users to your portals\. This section explains how you can complete these basic administrative tasks for your SiteWise Monitor portals\.

1. Sign in to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/home)\.

1. In the navigation pane, choose **Monitor**, **Portals**\.  
![\[Left navigation pane in the AWS IoT SiteWise console with Portals highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-choose-portals-console.png)

1. Choose a portal, and then choose **View details** \(or choose the portal's **Name**\)\.

1. You can perform any of the following administrative tasks:
   + [Changing a portal's name, description, branding, support email, and permissions](#portal-change-details)
   + [Adding or removing portal administrators](#portal-change-admins)
   + [Sending email invitations to portal administrators](#send-email-invitations-to-portal)
   + [Adding or removing portal users](#portal-change-users)
   + [Deleting a portal](#portal-delete-portal)

For information about how to create a portal, see [Getting started with AWS IoT SiteWise Monitor](monitor-getting-started.md)\.

## Changing a portal's name, description, branding, support email, and permissions<a name="portal-change-details"></a>

You can change a portal's name, description, branding, support email, and permissions\.

1. On the portal details page, in the **Portal details** section, choose **Edit**\.  
![\[Portal details section of the portal details page with Edit highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-view-portal-details-console.png)

1. Update the **Name**, **Description**, **Portal branding**, **Support contact email**, or **Permissions**\.

1. When you're finished, choose **Save**\.

## Adding or removing portal administrators<a name="portal-change-admins"></a>

In a few steps, you can add or remove users as administrators for a portal\.

![\[Portal administrators section of the portal details page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-portal-administrators-console.png)

**To add portal administrators**

1. On the portal details page, in the **Portal administrators** section, choose **Assign users**\.

1. On the **Assign administrators** page, select the check boxes for the users to add to the portal as administrators\.
**Note**  
If you use AWS SSO as your identity store, and you're signed in to your AWS Organizations master account, you can choose **Create user** to create an AWS SSO user\. AWS SSO sends the new user an email for them to set their password\. You can then assign the user to the portal as an administrator\. For more information, see [Manage identities in AWS SSO](https://docs.aws.amazon.com/singlesignon/latest/userguide/manage-your-identity-source-sso.html.html)\.  
![\[The "Assign administrators" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-portal-assign-administrators-console.png)

1. Choose **Assign administrators**\.

**To remove portal administrators**
+ On the portal details page, in the **Portal administrators** section, select the check box for each user to remove, and then choose **Remove from portal**\.
**Note**  
Leaving a portal without a portal administrator is not recommended\.

## Sending email invitations to portal administrators<a name="send-email-invitations-to-portal"></a>

You can send email invitations to portal administrators through their AWS SSO email address\.

1. On the portal details page, in the **Portal administrators** section, select the check boxes for the portal administrators\.  
![\[Portal administrators section of the portal details page with "Send invitations" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-select-portal-administrator-console.png)

1. Choose **Send invitations**\. Your email client opens, and an invitation is populated in the message body, as shown in the following example\.  
![\[The invitation email body that is sent to your portal administrators.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-send-portal-administrator-invitation-console.png)

   You can customize the email before you send it to your portal administrators\.

## Adding or removing portal users<a name="portal-change-users"></a>

You choose which users have access to your portals\. Portal users appear in the list of users within a SiteWise Monitor portal\. From this list, portal administrators can add project owners, and project owners can add project viewers\.

**Note**  
Your portal administrators and portal users might contact you through a portal's support email if they need you to add or remove a user\.

**To add portal users**

1. On the portal details page, in the **Portal users** section, choose **Assign users**\.

1. On the **Assign users** page, select the check box for the users to add to the portal\.
**Note**  
If you use AWS SSO as your identity store, and you're signed in to your AWS Organizations master account, you can choose **Create user** to create an AWS SSO user\. AWS SSO sends the new user an email for them to set their password\. You can then assign the user to the portal as a user\. For more information, see [Manage identities in AWS SSO](https://docs.aws.amazon.com/singlesignon/latest/userguide/manage-your-identity-source-sso.html.html)\.  
![\[The "Assign users" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-portal-assign-users-console.png)

1. Choose **Assign users**\.

**To remove portal users**
+ On the portal details page, in the **Portal users** section, select the check box for the users to remove from the portal, and then choose **Remove from portal**\.

## Deleting a portal<a name="portal-delete-portal"></a>

You might delete a portal if you created it for testing purposes or if you created a duplicate of a portal that already exists\.

**Note**  
You must first manually delete all dashboards and projects in a portal before you can delete a portal\. For more information, see [Deleting projects](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/delete-projects) and [Deleting dashboards](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/delete-dashboards) in the *SiteWise Monitor Application Guide*\.

1. On the portal details page, choose **Delete**\.
**Important**  
When you delete a portal, you lose all projects that the portal contains, and all dashboards in each project\. This action can't be undone\. Your asset data isn't affected\.  
![\[Portal details page with Delete highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-portal-console.png)

1. In the **Delete portals** dialog box, choose **Remove admins and users**\.

   You must remove the administrators and users from a portal before you can delete it\. If your portal doesn't have administrators or users, the button doesn't appear, and you can skip to the next step\.  
![\["Delete portals" dialog box with "Remove administrators and users" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-portal-remove-users-console.png)

1. If you're sure that you want to delete the entire portal, enter **delete** in the field to confirm deletion\.  
![\["Delete portals" dialog box with "Delete" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-portal-confirm-delete-console.png)

1. Choose **Delete**\.