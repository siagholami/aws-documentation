# Using Data Dashboards in Amazon QuickSight<a name="using-dashboards"></a>

**Topics**
+ [View data](#viewing-dashboard-data)
+ [Filter data](#filtering-dashboard-data)
+ [Sort data](#sorting-dashboard-data)
+ [Export data](#export-dashboard-to-csv)
+ [Interact with Data](#using-visuals-on-a-dashboard)
+ [Get email reports](#subscribing-to-a-dashboard-report-for-readers)

## Viewing Dashboard Data<a name="viewing-dashboard-data"></a>

In Amazon QuickSight, you can view data dashboards in email or interact with them on a webpage or your mobile device\. If you are an Amazon QuickSight reader, you don't need a monthly subscription\. To learn how to get the most out of reading your dashboards, use the following section\. 

Each dashboard is like a sheet from a newspaper that is filled with data visualizations\. You can focus on any graph or chart\. You can filter, and sort, and update chart colors\. Dashboard that have controls embedded at the top give you easier access and control over what you see in some or all of the visuals on that sheet\. 

Any changes that you make to a dashboard are only temporary\. They don't change the data, and they don't affect other users\. If you want to save your settings and you have authoring access, use **Save as** to create your own private copy of the dashboard\. If you want to share your changes with other users, you can work with the dashboard owner to update the dashboard on the server\. This way, everyone can see the same version of data in the same way\. 

## Filtering Dashboard Data<a name="filtering-dashboard-data"></a>

You can filter data in a visual in three ways:
+ If your dashboard has filtering controls at the top of the screen, you can use them to filter all the visuals at once\.
+ You can use the filter icon at the top of each visual to filter visuals one at a time\. 
+ You can create your own filters by using the filter pane on the left side of the page\.

## Sorting Dashboard Data<a name="sorting-dashboard-data"></a>

You can sort data in a visual in three ways: 
+ You can hover over the label for the field you want to sort by, and choose the sort icon\. 
+ You can choose the filter icon at the top right of the visual you want to sort\.
+ You can click or tap on the field and choose **Sort** from the context menu\.

## Exporting Data from a Dashboard<a name="export-dashboard-to-csv"></a>

To export data from an analysis or dashboard to a comma\-separated value \(CSV\) file, use the `v`\-shaped menu at the top right of a visual\. Data exports only for the visual you choose\. 

## Using the Visuals on Your Dashboard<a name="using-visuals-on-a-dashboard"></a>

When you choose a data point on a visual, several actions are available\. You can click or tap on a data point, for example on a bar in a bar chart, on a point where the line bends on a line chart, and so on\. The available actions vary slightly based on what type of visual it is\. The following screenshot shows a list of actions available on most chart types\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/visual-data-point-context-menu-bar-chart.png)

These actions are as follows:
+ Focus on or exclude

  You can focus on or exclude specific data in a field in that visual, for example regions, metrics, or dates\. 
+ Drill up or drill down

  If your dashboard contains data on which you can drill down or up, you can drill up to a higher level or drill down to explore deeper details\. 
+ Custom URL actions

  If your dashboard contains URL actions, you can activate them by choosing a data point on a visual\. For example, you might be able to email someone directly from the visual, or open another URL and send it data points \(values\) from this one\.
+ Change chart colors or specific field colors

  You can change all the chart colors to a specific color\. Alternatively, you can choose a specific field value to change its color, if that field is part of the color well \(usually in the legend\)\. 

## Subscribing to Your Dashboard<a name="subscribing-to-a-dashboard-report-for-readers"></a>

You can subscribe to a dashboard in report form, and receive it in an email\. You can also adjust your report settings\.

Use the following procedure to change your subscription and report settings for a specific dashboard\.

1. First, open a dashboard that is shared with you\.

1. Choose the **Reports** icon at top right\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/subscribe-to-report-1.png)

1. The **Change report preferences** screen appears\. This screen shows the current report schedule, in addition to the subscription and optimization options\.

   For **Subscription**, choose **Subscribe** to start receiving reports, or **Unsubscribe** to stop receiving reports\.

   Under **Optimize**, choose the device you prefer to view the report on\. 
   + If you usually use a mobile device or you prefer to view reports in a portrait format, choose **Viewing on a mobile device**\. When you receive the report, the visuals display in a single vertical column\. 
   + If you usually use a desktop or you prefer to view reports in a landscape format, choose **Viewing on a desktop**\. When you receive the report, the visuals display in the same layout shown in your dashboard on your desktop\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/subscribe-to-report-2.png)

1. Choose **Update** to confirm your choices, or choose **Cancel** to discard your changes\.