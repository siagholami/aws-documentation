# What is AWS IoT SiteWise Monitor?<a name="what-is-monitor-app"></a>

AWS IoT SiteWise Monitor is a feature of AWS IoT SiteWise that provides portals in the form of managed web applications\. You can use these applications to view and share your operational data\. You can see data from your processes, devices, and equipment that are connected to AWS IoT SiteWise\. Domain experts, such as process engineers, can use these portals to quickly get insights into their operational data to understand device and equipment behavior\. They can use these insights to improve efficiency of devices, processes, or equipment and innovate on new initiatives\.

Because AWS IoT SiteWise captures data over time, you can use AWS IoT SiteWise Monitor to view operational data over time\. With AWS IoT SiteWise Monitor, you can uncover insights that might otherwise be difficult to find\.

<a name="example-dashboard-para"></a>The following is an example dashboard that displays data for a wind farm\.

<a name="example-dashboard-image"></a>![\[A sample SiteWise Monitor dashboard.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/monitor-wind-farm-dashboard-console.png)

## SiteWise Monitor roles<a name="monitor-roles"></a>

Three roles use AWS IoT SiteWise Monitor portals:

**Portal administrator**  
Each SiteWise Monitor portal has one or more portal administrators\. Portal administrators use the portal to create projects that contain collections of assets and dashboards\. The portal administrator then assigns assets and owners to each project\. By controlling access to the project, portal administrators specify which assets that project owners and viewers can see\.

**Project owner**  
Each SiteWise Monitor project has owners\. Project owners create visualizations in the form of dashboards to represent operational data in a consistent manner\. When dashboards are ready to share, the project owner can invite viewers to the project\. Project owners can also assign other owners to the project\.

**Project viewer**  
Each SiteWise Monitor project has viewers\. Project viewers can connect to the portal to view the dashboards that project owners created\. In each dashboard, project viewers can adjust the time range to better understand operational data\. Project viewers can only view dashboards in the projects to which they have access\.

<a name="perform-multiple-roles-para"></a>Depending on your organization, the same person might perform multiple roles\.

The following image illustrates how these three roles, in addition to the AWS administrator who creates portals, interact in a SiteWise Monitor portal\. 

<a name="monitor-roles-diagram"></a>![\[AWS IoT SiteWise Monitor roles and what they do.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/monitor-roles.png)

<a name="manage-access-with-sso-para"></a>You can manage who has access to your data by using AWS Single Sign\-On\. Your portal users don't need to access your AWS account\. They can sign in to SiteWise Monitor from a desktop or mobile browser using their corporate credentials or AWS SSO user credentials\.

Users other than the AWS administrator can access portals when they receive an email that contains a link to the portal\.

## SiteWise Monitor concepts<a name="monitor-concepts"></a>

If you received an invitation to sign in to an AWS IoT SiteWise Monitor portal, then you already have access to data from AWS IoT SiteWise\. To get the most benefit from the AWS IoT SiteWise Monitor portal, you should be familiar with the following concepts:<a name="monitor-concepts-list"></a>

**Portal**  <a name="monitor-concept-portal"></a>
An SiteWise Monitor portal is a web application that you can use to visualize and share your AWS IoT SiteWise data\. A portal has one or more administrators and contains zero or more projects\.

**Project**  <a name="monitor-concept-project"></a>
Each SiteWise Monitor portal contains a set of projects\. Each project has a subset of your AWS IoT SiteWise assets associated with it\. Project owners create one or more dashboards to provide a consistent way to view the data associated with those assets\. Project owners can invite viewers to the project to allow them to view the assets and dashboards in the project\. The project is the basic unit of sharing within SiteWise Monitor\. Project owners can invite users who were given access to the portal by the AWS administrator\. A user must have access to a portal before a project in that portal can be shared with that user\.

**Asset**  
When data is ingested into AWS IoT SiteWise from your industrial equipment, your devices, equipment, and processes are each represented as assets\. Each asset has data associated with it\. For example, a piece of equipment might have a serial number, a location, a make and model, and an install date\. It might also have time series values for availability, performance, quality, temperature, pressure, and so on\. The portal administrator assigns sets of assets to each project\. 

**Dashboard**  <a name="monitor-concept-dashboard"></a>
Each project contains a set of dashboards\. Dashboards provide a set of visualizations for the values of a set of assets\. Project owners create the dashboards and the visualizations that it contains\. When a project owner is ready to share the set of dashboards, the owner can invite viewers to the project, which gives them access to all dashboards in the project\. If you want a different set of viewers for different dashboards, you must divide the dashboards between projects\. When viewers look at dashboards, they can adjust the time range\.

**Visualization**  <a name="monitor-concept-visualization"></a>
In each dashboard, project owners decide how to display the values for the properties of the assets associated with the project\. Availability might best be represented as a line chart, while other values might be displayed as bar charts or key performance indicators \(KPIs\)\. Project owners customize each visualization to provide the best understanding of the data for that asset\.