# Getting started with AWS IoT SiteWise Monitor<a name="monitor-getting-started"></a>

If you're the AWS administrator for your organization, you create portals from the AWS IoT SiteWise console\. Complete the following steps to create a portal so that members of your organization can view your AWS IoT SiteWise data:

1. Enable AWS SSO if it's not already enabled

1. Configure and create a portal

1. Add portal administrators and send invitation emails

1. Add portal users

You complete these steps in the AWS IoT SiteWise console\.

After you create a portal, the portal administrator can view your AWS IoT SiteWise assets and assign them to projects in the portal\. Project owners can then create dashboards to visualize the properties of the assets that help project viewers understand how your devices, processes, and equipment are performing\.

You can follow a tutorial that walks through the steps required to set up a portal with a project, dashboards, and multiple users for a specific scenario using wind farm data\. For more information, see [Visualizing and sharing wind farm data in AWS IoT SiteWise Monitor](monitor-wind-farm.md)\.

## Creating a portal<a name="monitor-create-portal"></a>

You create a SiteWise Monitor portal in the AWS IoT SiteWise console\.

**To create a portal**

1. Sign in to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/home)\.

1. In the navigation pane, choose **Monitor**, **Getting started**\.  
![\[The left navigation pane of the AWS IoT SiteWise console with Getting started highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-choose-monitor-getting-started-console.png)

1. Choose **Create Portal**\.  
![\[The AWS IoT SiteWise Monitor Getting started page with Create portal highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-choose-create-portal-console.png)

   Next, you must provide some basic information to configure your portal\.

## Enabling AWS SSO<a name="monitor-enable-sso"></a>

AWS SSO provides identity federation for SiteWise Monitor so that you can control access to your portals\. With AWS SSO, your users sign in with their corporate email and password instead of an AWS account\. For more information about AWS SSO, see the [AWS Single Sign\-On User Guide](https://docs.aws.amazon.com/singlesignon/latest/userguide/)\.

**Note**  
<a name="cross-region-sso"></a>You can configure AWS SSO in only one Region at a time\. SiteWise Monitor connects to the Region that you configured for AWS SSO\. This means that you use one Region for AWS SSO access, but you can create portals in any Region\.

If you already enabled AWS SSO, you can skip to [Configuring your portal](#monitor-configure-portal)\.

In this procedure, SiteWise Monitor performs the following steps for you:

1. Enables AWS Organizations, a prerequisite for AWS SSO\. For more information, see [AWS Organizations User Guide](https://docs.aws.amazon.com/organizations/latest/userguide/)\.

1. Creates an AWS organization and sets your AWS account as the master account\.

1. Enables AWS SSO in the current AWS Region\.

**To enable AWS SSO**

1. Enter the **Email address**, **First name**, and **Last name** for the user that you want as your portal administrator\. The given email address will receive an email to set a password for the new AWS SSO user\. If you want to be the portal administrator, enter your email and name to create an AWS SSO identity to use with your portal\. You can create more users later\.

   For more information, see [Manage identities in AWS SSO](https://docs.aws.amazon.com/singlesignon/latest/userguide/manage-your-directory-sso.html) in the *AWS Single Sign\-On User Guide*\.  
![\[The Enable AWS Single Sign-On (SSO) page of the Create portal process.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-enable-sso-console.png)

1. Choose **Create user** to create the portal administrator user and enable AWS SSO\.

   All portal users, including the portal administrator, must sign in with their AWS SSO identity\. These credentials are typically not the same credentials that you use to sign in to the AWS Management Console\.

## Configuring your portal<a name="monitor-configure-portal"></a>

Your users use portals to view your data\. You can customize a portal's name, description, branding, support contact email, and permissions\.

![\[The "Portal configuration" page used to create a portal.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-configure-portal-console.png)

**To configure a portal**

1. Enter a name for your portal\.

1. \(Optional\) Enter a description for your portal\. If you have multiple portals, use meaningful descriptions to help you keep track of what each portal contains\.

1. \(Optional\) Upload an image to display your brand in the portal\. Choose a square, PNG image\. If you upload a non\-square image, the portal scales the image down to a square\.

1. Enter an email address that portal users can contact when they have an issue with the portal and need help to resolve it\.

1. \(Optional\) Add tags for your portal\. For more information, see [Tagging your AWS IoT SiteWise resources](tag-resources.md)\.

1. \(Optional\) Choose an existing service role for your portal\. By default, SiteWise Monitor creates a new service role for each portal\. This role allows your portal users to access your AWS IoT SiteWise resources\. For more information, see [Using service roles for AWS IoT SiteWise Monitor](monitor-service-role.md)\.

1. Choose **Create portal**\.
**Note**  
At this point in the process, AWS IoT SiteWise creates your portal\. If you close the console, you can finish the setup process by adding administrators and users\. For more information, see [Adding or removing portal administrators](administer-portals.md#portal-change-admins)\. If you don't want to keep this portal, delete it so it doesn't consume resources\. For more information, see [Deleting a portal](administer-portals.md#portal-delete-portal)\.

A message appears when your portal is created\.

![\[An example successful portal creation message.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-create-portal-success-console.png)

Next, you must invite one or more portal administrators to the portal\. So far, you created a portal but no one can access it\.

## Inviting administrators<a name="monitor-invite-administrators"></a>

To get started in your new portal, you must assign a portal administrator\. The portal administrator creates projects, chooses project owners, and assigns assets to projects\. Portal administrators can see all of your AWS IoT SiteWise assets\.

If you're using SiteWise Monitor for the first time, you can choose the user that you created earlier to be the portal administrator\. If you haven't created users, or you want to add another user as a portal administrator, you can create an AWS SSO user from this page\. Alternatively, you can connect an external identity provider to AWS SSO\. For more information, see the [AWS Single Sign\-On User Guide](https://docs.aws.amazon.com/singlesignon/latest/userguide/)\.

**To invite administrators**

1. Select the check boxes for the users that you want as your portal administrators\. This adds the users to the **Selected users** list\.
**Note**  
If you use AWS SSO as your identity store, and you're signed in to your AWS Organizations master account, you can choose **Create user** to create an AWS SSO user\. AWS SSO sends the new user an email for them to set their password\. You can then assign the user to the portal as an administrator\. For more information, see [Manage identities in AWS SSO](https://docs.aws.amazon.com/singlesignon/latest/userguide/manage-your-identity-source-sso.html.html)\.  
![\[The invite administrators step of the portal creation process.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-invite-portal-administrators-console.png)

1. \(Optional\) Choose **Send invite to selected users**\. Your email client opens, and an invitation is populated in the message body, as shown in the following example\.  
![\[The invitation email body that is sent to your portal administrators.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-send-portal-administrator-invitation-console.png)

   You can customize the email before you send it to your portal administrators\. You can also send the email to your portal administrators later\. If you're trying SiteWise Monitor for the first time and adding your new account as the portal administrator, you don't need to email yourself\.

1. If you add a user that you don't want as an administrator, clear the check box for that user\.

1. When you're finished inviting portal administrators, choose **Next**\.

You can change the list of portal administrators later\. For more information, see [Adding or removing portal administrators](administer-portals.md#portal-change-admins)\.

**Note**  
Because only a portal administrator can create projects and assign assets to them, your portal is of limited use until you specify at least one portal administrator\.

As the last step, you add users who can access your new portal\.

## Adding portal users<a name="monitor-add-portal-users"></a>

You control which users have access to your portals\. In each portal, the portal administrators create one or more projects and assign portal users as owners or viewers for each project\. Each project owner can invite additional portal users to own or view the project\.

If you see the user that you want to add in the **Directory** list, complete the following steps\.

**To add portal users**

1. Choose users from the **Users** list to add to the portal\. If you're using SiteWise Monitor for the first time, you don't need to add your portal administrator as a portal user\.
**Note**  
If you use AWS SSO as your identity store, and you're signed in to your AWS Organizations master account, you can choose **Create user** to create an AWS SSO user\. AWS SSO sends the new user an email for them to set their password\. You can then assign the user to the portal as a user\. For more information, see [Manage identities in AWS SSO](https://docs.aws.amazon.com/singlesignon/latest/userguide/manage-your-identity-source-sso.html.html)\.  
![\[The assign users step of the portal creation process.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-assign-portal-users-console.png)

1. If you add a user that you don't want to have access to the portal, clear the check box for that user\.

1. When you're finished selecting users, choose **Assign users**\.

Congratulations\! You successfully created a portal, assigned portal administrators, and assigned users who can use that portal when invited to do so\. Your portal administrators can now create projects and add assets to those projects\. Then, your project owners can create dashboards to visualize the data for each project's assets\.

If you need to make changes to the portal, see [Administering your SiteWise Monitor portals](administer-portals.md)\.

To get started in the portal, see [Getting started](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/getting-started) in the *SiteWise Monitor Application Guide*\.