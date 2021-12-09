# Getting started as an AWS IoT SiteWise Monitor project viewer<a name="project-viewer-getting-started"></a>

When you're invited to a project as a viewer, someone in your organization has set up a project and a set of dashboards to provide you with a consistent way to view data for your company's devices, equipment, and processes\. In AWS IoT SiteWise, those devices, equipment, and processes are referred to as assets\. AWS IoT SiteWise Monitor provides you with an easy way to view the properties of a set of assets\. Because the project owner has set up dashboards to visualize those properties, everyone who views the project has the same view of the data and can draw insights from the data\. As a project viewer, you can view all of the dashboards in the project\. You can adjust the time range for the data shown in the dashboard\. And you can explore the properties of individual assets to see a property that isn't on the dashboard\.

You can only view the assets that are associated with the project to which you've been invited\. To request additional assets, contact your project owner\. The project owner can also update the dashboards to change the visualizations or show additional properties\.

As a project viewer, you can do the following tasks:
+ [Signing in to a portal](getting-started.md#portal-login)
+ [Exploring shared dashboards](#project-viewer-exploring-dashboards)
+ [Exploring project assets and their data](#project-viewer-exploring-assets)

## Exploring shared dashboards<a name="project-viewer-exploring-dashboards"></a>

As a viewer for one or more AWS IoT SiteWise Monitor projects, you can view the dashboards to understand the data for your devices, equipment, and processes\. You can adjust the time range for the visualizations in each dashboard to gain insights into your data\.

The following procedure assumes that you are signed in the AWS IoT SiteWise Monitor portal\.

**To explore shared dashboards**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project whose dashboards you want to view\.  
![\[The Projects page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-user-choose-project-console.png)

1. In the **Dashboards** section of the project details page, choose the name of the dashboard to view\. You can also select the check box next to the dashboard, and then choose **Open**\.  
![\[The "Dashboards" section of the projects page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-project-viewer-view-dashboard-console.png)

1. You can browse the visualizations in the dashboard\.  
![\[An example dashboard.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-project-viewer-view-dashboard-console.png)

   Do any of the following actions to adjust the displayed time range for your data:<a name="modify-visualization-time-range"></a>
   + <a name="modify-visualization-zoom-in-selected"></a>Click and drag a time range on one of the line or bar charts to zoom in to the selected time range\.
   + <a name="modify-visualization-zoom-in-point"></a>Double\-click on a time range to zoom in on the selected point\.
   + <a name="modify-visualization-zoom-out-point"></a>Press Shift and then double\-click on a time range to zoom out from the selected point\.
   + <a name="modify-visualization-shift-range"></a>Press Shift and then drag the mouse on a time range to shift the range left or right\.
   + <a name="modify-visualization-predefined-time"></a>Use the drop\-down list to choose a predefined time range to view\.
   + Use the time range control to open the calendar and specify a start and end time for your range\.

   Each visualization shows the latest reported value for the selected time range\.

1. If you're a project owner or portal administrator, you can modify the dashboard\. For more information see [Adding visualizations](add-visualizations.md)\.

## Exploring project assets and their data<a name="project-viewer-exploring-assets"></a>

While you will typically use the dashboards that the project owner prepared for you, you can also view property values for the assets included in a project\. You might, for example, want to check the model, install date, or location for a piece of equipment\.

**Note**  
As a project viewer, you can view only those assets that are contained in projects to which you have access\.

The following procedure assumes that you signed in the AWS IoT SiteWise Monitor portal\.

**To explore project assets and their data**
+ In the navigation bar, choose the **Assets** icon\.  
![\[The "Assets" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-asset-library-console.png)

  The **Assets** page appears\.  
![\[The "Asset library" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-project-owner-console.png)

  See the following areas of the page\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/project-viewer-getting-started.html)