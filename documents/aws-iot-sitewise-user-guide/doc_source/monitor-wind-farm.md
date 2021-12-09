# Visualizing and sharing wind farm data in AWS IoT SiteWise Monitor<a name="monitor-wind-farm"></a>

You can configure AWS IoT SiteWise Monitor to visualize and share your industrial data through managed web applications\. Each web application is called a portal\. Each portal contains projects, and you choose which data is available in each project\. 

You can then specify people in your company that can access each portal\. Your users sign in to portals using AWS Single Sign\-On accounts, so you can use your existing identity store or an AWS\-managed one\.

You, and your users with sufficient permissions, can create dashboards in each project to visualize your industrial data in meaningful ways\. Then, your users can view these dashboards to quickly gain insights into your data and monitor your operation\. You can configure administrative or read\-only permissions to each project for every user in your company\. For more information, see [Monitoring data with AWS IoT SiteWise Monitor](monitor-data.md)\.

In this tutorial, you build on the AWS IoT SiteWise demo that provides a sample set of data for a wind farm\. You configure a portal in SiteWise Monitor and create a project and dashboards to visualize the wind farm data\. You also create additional users and then give them permissions to own or view the project and its dashboards\.

**Note**  
When you use SiteWise Monitor, you're charged per AWS SSO user that signs in to a portal \(per month\)\. In this tutorial, you create three users, but you only need to sign in with one user\. After you complete this tutorial, you incur charges for one user\. For more information, see [AWS IoT SiteWise Pricing](https://aws.amazon.com/iot-sitewise/pricing/)\.

**Topics**
+ [Prerequisites](#monitor-tutorial-prerequisites)
+ [Creating a portal in SiteWise Monitor](#monitor-tutorial-create-portal)
+ [Signing in to a portal](#monitor-tutorial-sign-in-portal)
+ [Creating a wind farm project](#monitor-tutorial-create-project)
+ [Creating dashboards to visualize wind farm data](#monitor-tutorial-create-dashboard)
+ [Exploring the portal](#monitor-tutorial-explore-portal)
+ [Cleaning up resources after the tutorial](#monitor-tutorial-clean-up-resources)

## Prerequisites<a name="monitor-tutorial-prerequisites"></a>

To complete this tutorial, you need the following:
+ An AWS account\. If you don't have one, see [Setting up an AWS account](set-up-aws-account.md)\.
+ A development computer running Windows, macOS, Linux, or Unix to access the AWS Management Console\. For more information, see [Getting Started with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.
+ An IAM user with administrator permissions\.
+ A running AWS IoT SiteWise wind farm demo\. When you set up the demo, it defines models and assets in AWS IoT SiteWise and streams data to them to represent a wind farm\. For more information, see [Using the AWS IoT SiteWise demo](getting-started-demo.md)\.
+ If you enabled AWS SSO in your account, sign in to your AWS Organizations master account\. For more information, see [AWS Organizations terminology and concepts](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_getting-started_concepts.html)\. If you haven't enabled AWS SSO, you will enable it in this tutorial and set your account as the master account\.

  If you can't sign in to your AWS Organizations master account, you can partially complete the tutorial as long as you have an AWS SSO account in your organization\. In this case, you can create the portal and dashboards, but you can't create new AWS SSO users to assign to projects\.

## Creating a portal in SiteWise Monitor<a name="monitor-tutorial-create-portal"></a>

In this procedure, you create a portal in SiteWise Monitor\. Each portal is a managed web application that you and your users can sign in to with AWS Single Sign\-On accounts\. AWS SSO lets you use your company's existing identity store or create one managed by AWS\. Your company's employees can sign in without creating separate AWS accounts\.

**To create a portal**

1. Sign in to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. Review the [AWS Regions](getting-started.md#requirements) where AWS IoT SiteWise is supported and switch Regions, if needed\. You must run the AWS IoT SiteWise demo in the same Region\.

1. In the left navigation pane, choose **Portals**\.

1. Choose **Create portal**\.

1. If you already enabled AWS SSO, skip to step 6\. Otherwise, complete the following steps to enable AWS SSO:

   1. On the **Enable AWS Single Sign\-On \(SSO\)** page, enter your **Email address**, **First name**, and **Last name** to create an AWS SSO user for yourself to be the portal administrator\. Use an email address you can access so that you can receive an email to set a password for your new AWS SSO user\.

      In a portal, the portal administrator creates projects and assigns users to projects\. You can create more users later\.  
![\[The "Enable AWS Single Sign-On (SSO)" page of the "Create portal" process.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-enable-sso-console.png)

   1. Choose **Create user**\.

1. On the **Portal configuration** page, complete the following steps:

   1. Enter a name for your portal, such as **WindFarmPortal**\.

   1. \(Optional\) Enter a description for your portal\. If you have multiple portals, use meaningful descriptions to keep track of what each portal contains\.

   1. \(Optional\) Upload an image to display in the portal\.

   1. Enter an email address that portal users can contact when they have an issue with the portal and need help from your company's AWS administrator to resolve it\.

   1. Choose **Create portal**\.

1. On the **Invite administrators** page, you can assign AWS SSO users to the portal as administrators\. Portal administrators manage permissions and projects within a portal\. On this page, do the following:

   1. Select a user to be the portal administrator\. If you enabled AWS SSO earlier in this tutorial, select the user that you created\.  
![\[The "Invite administrators" page of the "Create portal" process.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/sitewise-invite-portal-administrators-console.png)

   1. \(Optional\) Choose **Send invite to selected users**\. Your email client opens, and an invitation appears in the message body\. You can customize the email before you send it to your portal administrators\. You can also send the email to your portal administrators later\. If you're trying SiteWise Monitor for the first time and will be the portal administrator, you don't need to email yourself\.

   1. Choose **Next**\.

1. On the **Assign users** page, you can assign AWS SSO users to the portal\. Portal administrators can later assign these users as project owners or viewers\. Project owners can create dashboards in projects\. Project viewers have read\-only access to the projects that they're assigned\. On this page, you can create AWS SSO users to add to the portal\.
**Note**  
If you aren't signed in to your AWS Organizations master account, you can't create AWS SSO users\. Choose **Assign users** to create the portal without portal users, and then skip this step\.

   On this page, do the following:

   1. Complete the following steps twice to create two AWS SSO users:

      1. Choose **Create user** to open a dialog box where you enter details for the new user\.

      1. Enter an **Email address**, **First name**, and **Last name** for the new user\. AWS SSO sends the user an email for them to set their password\. If you want to sign in to the portal as these users, choose an email address that you can access\. Each email address must be unique\. Your users sign in to the portal using their email address as their usernames\.  
![\[The "Portal details" page with "Assign users" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sso-widget-create-user-console.png)

      1. Choose **Create user**\.

   1. Select the two AWS SSO users that you created in the previous step\.  
![\[The "Assign users" page with the new AWS SSO users highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/sitewise-choose-users-to-assign-console.png)

   1. Choose **Assign users** to add these users to the portal\.

   The portals page opens with your new portal listed\.

## Signing in to a portal<a name="monitor-tutorial-sign-in-portal"></a>

In this procedure, you sign in to your new portal using the AWS SSO user that you added to the portal\.

**To sign in to a portal**

1. On the **Portals** page, choose your new portal's **Link** to open your portal in a new tab\.  
![\[The "Portals" page with the wind farm portal's link highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/sitewise-choose-portal-link-console.png)

1. If you created your first AWS SSO user earlier in the tutorial, use the following steps to create a password for your user:

   1. Check your email for the subject line **Invitation to join AWS Single Sign\-On**\.

   1. Open that invitation email and choose **Accept invitation**\.

   1. In the new window, set a password for your AWS SSO user\.

   If you want to sign in later to the portal as the second and third AWS SSO users that you created earlier, you can also complete these steps to set passwords for those users\.
**Note**  
If you didn't receive an email, you can generate a password for your user in the AWS SSO console\. For more information, see [Reset a user password](https://docs.aws.amazon.com/singlesignon/latest/userguide/resetuserpwd.html) in the *AWS Single Sign\-On User Guide*\.

1. Enter your AWS SSO **Username** and **Password**\. If you created your AWS SSO user earlier in this tutorial, your **Username** is the email address of the portal administrator user that you created\.

   All portal users, including the portal administrator, must sign in with their AWS SSO user credentials\. These credentials are typically not the same credentials that you use to sign in to the AWS Management Console\.  
![\[The portal sign-in page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/portal-sign-in-console.png)

1. Choose **Sign in**\.

   Your portal opens\.

## Creating a wind farm project<a name="monitor-tutorial-create-project"></a>

In this procedure, you create a project in your portal\. Projects are resources that define a set of permissions, assets, and dashboards, which you can configure to visualize asset data in that project\. With projects, you define who has access to which subsets of your operation and how those subsets' data is visualized\. You can assign portal users as owners or viewers of each project\. Project owners can create dashboards to visualize data and share the project with other users\. Project viewers can view dashboards but not edit them\. For more information about roles in SiteWise Monitor, see [SiteWise Monitor roles](monitor-data.md#monitor-roles)\.

**To create a wind farm project**

1. In the left navigation pane in your portal, choose the **Assets** tab\. On the **Assets** page, you can explore all assets available in the portal and add assets to projects\.

1. In the asset browser, choose **Demo Wind Farm Asset**\. When you choose an asset, you can explore that asset's live and historical data\. You can also press Shift to select multiple assets and compare their data side\-by\-side\.

1. Choose **Add asset to project** in the upper left\. Projects contain dashboards that your portal users can view to explore your data\. Each project has access to a subset of your assets in AWS IoT SiteWise\. When you add an asset to a project, all users with access to that project can also access data for that asset and its children\.  
![\[The "Assets" page with the demo wind farm asset and "Add asset to project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/portal-add-asset-project-console.png)

1. In the **Add asset to project** dialog box, choose **Create new project**, and then choose **Next**\.  
![\[The "Add asset to project" dialog box with "Create new project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/portal-choose-new-project-console.png)

1. In the **Create new project** dialog box, enter a **Project name** and **Project description** for your project, and then choose **Add asset to project**\.  
![\[The "Create new project" dialog box.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/portal-create-new-project-console.png)

   Your new project's page opens\.

1. On the project's page, you can add portal users as owners or viewers of this project\.
**Note**  
If you aren't signed in to your AWS Organizations master account, you might not have portal users to assign to this project, so you can skip this step\.

   On this page, do the following:

   1. Under **Project owners**, choose **Add owners** or **Edit users**\.  
![\[The "Project details" page with "Assign users" and "Edit users" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/project-add-owners-console.png)

   1. Choose the user to add as a project owner \(for example, **Mary Major**\), and then choose the **>>** icon\.  
![\[The "Project owners" dialog box with a user highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/project-choose-owner-console.png)

   1. Choose **Save**\.

      Your AWS SSO user **Mary Major** can sign in to this portal to edit the dashboards in this project and share this project with other users in this portal\.

   1. Under **Project viewers**, choose **Add viewers** or **Edit users**\.

   1. Choose the user to add as a project viewer \(for example, **Mateo Jackson**\), and then choose the **>>** icon\.

   1. Choose **Save**\.

      Your AWS SSO user **Mateo Jackson** can sign in to this portal to view, but not edit, the dashboards in the wind farm project\.

## Creating dashboards to visualize wind farm data<a name="monitor-tutorial-create-dashboard"></a>

In this procedure, you create dashboards to visualize the demo wind farm data\. Dashboards contain customizable visualizations of your project's asset data\. Each visualization can have a different type, such as a line chart, bar chart, or KPI display\. You can choose the visualization type that works best for your data\. Project owners can edit dashboards, while project viewers can only view them to gain insights\.

**To create a dashboard with visualizations**

1. On your new project's page, choose **Create dashboard** to create a dashboard and open its edit page\.

   In a dashboard's edit page, you can drag asset properties from the asset hierarchy to the dashboard to create visualizations\. Then, you can edit each visualization's title, legend titles, type, size, and location in the dashboard\.

1. Enter a name your dashboard\.  
![\[The "Dashboard" edit page with the dashboard name highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/dashboard-edit-console.png)

1. Drag **Total Average Power** from the **Demo Wind Farm Asset** to the dashboard to create a visualization\.  
![\[The "Dashboard" edit page with the "Average Total Power" property highlighted to demonstrate dragging an asset property to the dashboard.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/dashboard-add-total-power-console.png)

1. Choose **Demo Turbine Asset 1** to show properties for that asset, and then drag **Wind Speed** to the dashboard to create a visualization for wind speed\.  
![\[The "Dashboard" edit page with a wind turbine's "Wind Speed" property highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/dashboard-add-wind-speed-console.png)

1. Add **Wind Speed** to the new wind speed visualization for each **Demo Turbine Asset 2**, **3**, and **4** \(in that order\)\.

   Your **Wind Speed** visualization should look similar to the following screenshot\.  
![\[A "Wind Speed" visualization that contains four demo wind turbine assets' wind speeds.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/dashboard-add-all-wind-speeds-console.png)

1. Repeat steps 4 and 5 for the wind turbines' **Torque \(KiloNewton Meter\)** properties to create a visualization for wind turbine torque\.

1. Choose the visualization type icon for the **Torque \(KiloNewton Meter\)** visualization, and then choose the bar chart icon\.  
![\[A "Torque (KiloNewton Meter)" visualization with the visualization type and bar chart icons highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/dashboard-change-torque-visualization-type-console.png)

1. Repeat steps 4 and 5 for the wind turbines' **Wind Direction** properties to create a visualization for wind direction\.

1. Choose the visualization type icon for the **Wind Direction** visualization, and then choose the KPI chart icon \(**30%**\)\.  
![\[A "Wind Direction" visualization with the visualization type and KPI chart icons highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/dashboard-change-wind-direction-visualization-type-console.png)

1. \(Optional\) Make other changes to each visualization's title, legend titles, type, size, and location as needed\.

1. Choose **Save dashboard** in the upper right to save your dashboard\.

   Your dashboard should look similar to the following screenshot\.  
![\[A complete wind farm dashboard.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/wind-farm-dashboard-console.png)

1. \(Optional\) Create an additional dashboard for each wind turbine asset\.

   As a best practice, we recommend that you create a dashboard for each asset so that your project viewers can investigate any issues with each individual asset\. You can only add up to 5 assets to each visualization, so you must create multiple dashboards for your hierarchical assets in many scenarios\.

   A dashboard for a demo wind turbine might look similar to the following screenshot\.  
![\[A complete wind turbine dashboard.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/wind-turbine-dashboard-console.png)

1. \(Optional\) Change the timeline or select data points on a visualization to explore the data in your dashboard\. For more information, see [Viewing dashboards](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/view-dashboards.html) in the *AWS IoT SiteWise Monitor Application Guide*\.

## Exploring the portal<a name="monitor-tutorial-explore-portal"></a>

In this procedure, you can explore the portal as other SiteWise Monitor roles\.

**To explore the portal and finish the tutorial**

1. \(Optional\) If you added other users to the project as owners or viewers, you can sign in to the portal as these users\. This lets you explore the portal as a user with fewer permissions than a portal administrator\.
**Important**  
You're charged for each AWS SSO user that signs in to a portal, so you incur charges if you sign in as additional users\. For more information, see [AWS IoT SiteWise Pricing](https://aws.amazon.com/iot-sitewise/pricing/)\.

   To explore the portal as other users, do the following:

   1. Choose **Log out** in the bottom left of the portal to exit the web application\.

   1. Choose **Sign out** in the upper right of the AWS SSO application portal to sign out of your AWS SSO account\.

   1. Sign in to the portal as the AWS SSO user that you assigned as a project owner or project viewer\. For more information, see [Signing in to a portal](#monitor-tutorial-sign-in-portal)\.

1. You've completed the tutorial\. When you finish exploring your demo wind farm in SiteWise Monitor, follow the next procedure to clean up your resources\.

## Cleaning up resources after the tutorial<a name="monitor-tutorial-clean-up-resources"></a>

After you complete the tutorial, you can clean up your resources\. You aren't charged for SiteWise Monitor if users don't sign in to your portal, but you can delete your portal and AWS SSO users\. Your demo wind farm assets are deleted at the end of the duration that you chose when you created the demo, or you can delete the demo manually\. For more information, see [Deleting the AWS IoT SiteWise demo](getting-started-demo.md#delete-getting-started-demo)\.

Use the following procedures to delete your portal and AWS SSO users\.

**To delete a portal**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Portals**\.

1. Choose your portal, **WindFarmPortal**, and then choose **Delete**\.

   When you delete a portal or project, the assets associated to deleted projects aren't affected\.  
![\[The "Portals" page with the wind farm portal and "Delete" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/sitewise-choose-delete-portal-console.png)

1. In the **Delete portal** dialog box, choose **Remove administrators and users**\.  
![\[The "Delete portal" dialog box with "Remove administrators and users" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-portal-remove-users-console.png)

1. Enter **delete** to confirm deletion, and then choose **Delete**\.  
![\[The "Delete portal" dialog box with "Delete" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-portal-confirm-delete-console.png)

**To delete AWS SSO users**

1. Navigate to the [AWS SSO console](https://console.aws.amazon.com/singlesignon)\.

1. In the left navigation pane, choose **Users**\.

1. Select the check box for each user to delete, and then choose **Delete users**\.  
![\[AWS SSO "Users" page with "Delete users" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/sso-choose-delete-users-console.png)

1. In the **Delete users** dialog box, enter **DELETE**, and then choose **Delete users**\.  
![\[AWS SSO "Delete users" dialog box.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/monitor-wind-farm/sso-delete-users-console.png)