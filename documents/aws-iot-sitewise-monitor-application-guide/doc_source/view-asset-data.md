# Viewing asset data<a name="view-asset-data"></a>

On the **Assets** page, you can look at all properties of any asset that is associated with the projects to which you have access\. Portal administrators have access to all assets in the portal and can use the **Assets** page to explore individual assets before adding them to projects\. Dashboards provide a common visualization for all project viewers\. The following procedures describe how to view asset data on the **Assets** page and how to view asset data from a project page\. For information about viewing asset data in dashboards, see [Viewing dashboards](view-dashboards.md)\.

**To view asset data on the Assets page**

1. Log in to your AWS IoT SiteWise Monitor portal\. For more information, see [Signing in to an AWS IoT SiteWise Monitor portal](getting-started.md#portal-login)\.

1. In the navigation bar, choose the **Assets** icon\.  
![\[The "Assets" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-asset-library-console.png)

1. <a name="asset-library-choose-project"></a>\(Optional\) Choose a project in the projects drop\-down list to show only assets from a specific project\.  
![\[The "Assets" page, with the projects drop-down list called out.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-choose-project-console.png)

1. Choose an asset in the **Assets** hierarchy\. 

   Some assets might have a few static properties, called attributes\. For example, a factory's properties, such as location, have only a single value and typically don't change over time\.  
![\[The "Assets" page, with a factory asset and its properties.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-choose-asset-console.png)

1. Choose the arrow next to an asset to view all children of that asset, then choose an equipment asset\. AWS IoT SiteWise Monitor shows attributes, such as installation date, and time series data, such as availability or overall equipment effectiveness \(OEE\)\.  
![\[The "Assets" page, with an equipment asset and its properties.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-choose-child-asset-console.png)

1. Do any of the following actions to adjust the displayed time range for your data:<a name="modify-visualization-time-range"></a>
   + <a name="modify-visualization-zoom-in-selected"></a>Click and drag a time range on one of the line or bar charts to zoom in to the selected time range\.
   + <a name="modify-visualization-zoom-in-point"></a>Double\-click on a time range to zoom in on the selected point\.
   + <a name="modify-visualization-zoom-out-point"></a>Press Shift and then double\-click on a time range to zoom out from the selected point\.
   + <a name="modify-visualization-shift-range"></a>Press Shift and then drag the mouse on a time range to shift the range left or right\.
   + <a name="modify-visualization-predefined-time"></a>Use the drop\-down list to choose a predefined time range to view\.
   + Use the time range control to open the calendar and specify a start and end time for your range\.

1. Select the check boxes for two or more assets to compare their properties and property values\.  
![\[The "Assets" page, with two equipment assets selected, and their properties displayed side-by-side.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-compare-assets-console.png)