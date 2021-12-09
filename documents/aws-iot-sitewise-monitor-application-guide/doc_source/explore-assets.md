# Exploring assets<a name="explore-assets"></a>

In AWS IoT SiteWise, an asset represents a device, a process, or a piece of equipment\. You can use AWS IoT SiteWise Monitor to explore and visualize the property values for your assets\. Each project in AWS IoT SiteWise Monitor is associated with a set of assets by the portal administrator\. If you're a portal administrator, you can see all of the assets in the portal\. If you're a project owner or a project viewer, you can see only the assets that are associated with the projects for which you are an owner or a viewer\.

Assets can have different properties\. Some properties don't change over time, such as the asset's location, model, serial number, and so on\. Other properties have a series of values that are produced over time\. Properties can update at different rates\. You might have a temperature sensor that updates every second, and a product quality metric that updates every hour\. 

You can perform the following asset\-related tasks:


| Task | Roles that can perform the task | 
| --- | --- | 
| [Viewing asset data](view-asset-data.md) | Portal administrators can see all assets for the portal\. Project owners and viewers can see only those assets that are associated with the projects to which they are invited\. | 
| [Adding assets to projects](add-assets-to-projects-ea.md) | Only a portal administrator can change the list of assets that are associated with a project\. | 
| [Adding asset properties to dashboards](add-assets-to-dashboards.md) | Project owners add asset properties to dashboards\. Portal administrators don't typically edit dashboards\. Project viewers can't edit dashboards\. | 