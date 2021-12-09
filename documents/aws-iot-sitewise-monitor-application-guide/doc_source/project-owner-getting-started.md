# Getting started as an AWS IoT SiteWise Monitor project owner<a name="project-owner-getting-started"></a>

Each portal in the AWS IoT SiteWise Monitor contains one or more projects\. A project is the unit of sharing\. If you invite viewers to your project, they can see all dashboards that you created in that project, as well as explore the assets that are associated with the project\. If you want viewers to have access to different subsets of your dashboards, you must ask your portal administrator to split the project\. As the owner of one or more projects, you can do the following tasks:
+ [Signing in to a portal](getting-started.md#portal-login)
+ [Exploring project assets and their data](#project-owner-exploring-assets)
+ [Creating dashboards to visualize data](#project-owner-creating-dashboards)
+ [Configuring visualizations to understand data](#project-owner-configuring-visualizations)
+ [Assigning viewers to the project](#project-owner-inviting-viewers)

## Exploring project assets and their data<a name="project-owner-exploring-assets"></a>

You can explore the list of assets to which you have access to view their properties, and compare properties between two assets\. If you need additional assets in your project, you must contact your portal administrator\.

**Note**  
As a project owner, you can view only those assets that are contained in projects to which you have access\.

The following procedure assumes that you signed in the AWS IoT SiteWise Monitor portal\.

**To explore project assets and their data**
+ In the navigation bar, choose the **Assets** icon\.  
![\[The "Assets" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-asset-library-console.png)

  The **Assets** page appears\.  
![\[The "Assets" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-project-owner-console.png)

  See the following areas of the page\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/project-owner-getting-started.html)

## Creating dashboards to visualize data<a name="project-owner-creating-dashboards"></a>

The primary activity for a project owner is to create dashboards that contain one or more visualizations that show the values of asset properties\. Creating a dashboard is quick and easy\.

**To create dashboards**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project in which you want to create a dashboard\.  
![\[The "Projects" page as a project owner.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-user-choose-project-console.png)

1. <a name="project-create-dashboard"></a>In the **Dashboards** section, choose **Create dashboard**\.  
![\[The dashboards list on the project details page with "Create dashboard" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-create-dashboard-console.png)

Next, you add one or more visualizations of asset properties to your dashboard\. 

## Configuring visualizations to understand data<a name="project-owner-configuring-visualizations"></a>

Each dashboard can display one or more visualizations of the values of the asset properties in your project\. You can add a visualization for any property, and customize the details of the visualization\.

**To configure visualizations**

1. <a name="dashboard-configure-dashboard"></a>In the dashboard editor, change the dashboard name from the default, **New dashboard**, to something that describes the content****\.  
![\[The dashboard editor.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-name-dashboard-console.png)

1. <a name="dashboard-add-visualization"></a>Browse the list of project assets on the right side of the dashboard\. When you find a property to visualize, drag it to the dashboard\.
**Note**  
You can drag multiple properties onto a single visualization\.  
![\[The dashboard editor.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-add-visualization-console.png)

1. <a name="dashboard-choose-visualization-type"></a>To change how your property displays, choose the visualization type\.  
![\[A sample visualization with the visualization type icon highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-edit-visualization-type-console.png)

   For more information about the available visualization types, see [Choosing visualization types](choose-visualization-types.md)\. To customize details of the visualization, see [Customizing visualizations](customize-visualizations.md)\.

1. <a name="dashboard-configure-thresholds"></a>To add thresholds to your property, choose the visualization configuration icon\. For more information, see [Configuring thresholds](configure-thresholds.md)\.  
![\[A sample visualization with the visualization configuration icon highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-edit-visualization-configuration-console.png)

1. To move a visualization, choose the control icon in the upper left and then drag the visualization to a new location\.  
![\[An example visualization with the gripper and resize controls highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-edit-visualization-bounds-console.png)

1. To change the size of a visualization, use the resize control in the lower right\. Drag the corner to a new size and shape\. Visualizations snap to the grid when resized, so you only have coarse control over the size\.

1. <a name="dashboard-save-changes"></a>After you finish editing the dashboard, choose **Save dashboard** to save your changes\. The dashboard editor closes\. If you try to close a dashboard that has unsaved changes, you're prompted to save them\.

1. Repeat these steps to add and configure more visualizations to the dashboard\.

1. When you finish making changes, choose **Save dashboard** in the upper\-right corner\.  
![\[Shows the "Save dashboard" button in the upper right of the dashboard.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-finish-edits-console.png)

When you're ready to share your dashboard, you can add viewers to your project to explore dashboards\. You can see and change who you invited to the project on the project details page\. 

## Assigning viewers to the project<a name="project-owner-inviting-viewers"></a>

You can assign viewers to your project from the project details page\.<a name="add-viewers-project"></a>

**To assign viewers to a project**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project to which to assign viewers\.  
![\[The "Projects" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-user-choose-project-console.png)

1. In the **Project viewers** section of the project details page, choose **Add viewers** if the project has no viewers, or **Edit viewers**\.  
![\[The "Project viewers" section of a project page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-add-viewers-console.png)

1. In the **Project viewers** dialog box, select the check boxes for the users to be viewers for this project\.  
![\[Shows the "Project viewers" dialog.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-choose-viewers-console.png)
**Note**  
You can only add viewers if they're portal users\. If you don't see a user listed, contact your AWS administrator to add them to the list of portal users\.

1. Choose the **>>** icon to add those users as project viewers\.

1. Choose **Save** to save your changes\.

<a name="invite-viewers-project-intro"></a>Next, you can send emails to your project viewers so they can sign in and start exploring the dashboards in the project\.<a name="invite-viewers-project"></a>

**To send email invitations to project viewers**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project to which to invite project viewers\.  
![\[The "Projects" page with "Create project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-user-choose-project-console.png)

1. In the **Project viewers** section of the project details page, select the check boxes for the project viewers to receive an email, and then choose **Send invitations**\.  
![\[The "Project viewers" section of the project details page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-invite-viewers-console.png)

1. Your preferred email client opens, prepopulated with the recipients and the email body with details from your project\. You can customize the email before you send it to the project viewers\.