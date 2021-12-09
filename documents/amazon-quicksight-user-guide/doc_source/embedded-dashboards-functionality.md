# Functionality of Embedded Amazon QuickSight Dashboards<a name="embedded-dashboards-functionality"></a>

Embedded dashboards provide the same level of interactivity as Amazon QuickSight \. Embedded dashboards support the following interactions available in Amazon QuickSight dashboards today:
+ Drill\-down: implicit \(time hierarchies\) and explicit \(defined by the user\)
+ Custom actions \(link to a new tab\)
+ On\-screen filters 
+ Download to CSV
+ Sorting on visuals 
+ Email report opt\-in
+ Reset dashboard to defaults option
+ Undo/redo actions on the dashboard

All features available to a reader on the web dashboard experience are available to an embedded user\. Authors of dashboards can determine whether to enable features such as advanced filtering \(left filter panel, filter restatement icon and focus/exclude options\) and download to CSV option\.

Embedded dashboards support features that provide a customized view of data with features, such as row\-level security and dynamic default values for filters\. You can customize dashboards using the regular Amazon QuickSight dashboard customization options\. From the JavaScript SDK, Amazon QuickSight also supports the following:
+ Create an iframe of the preferred size to contain the Amazon QuickSight dashboard
+ Dynamically authenticate the user 
+ Enable or disable email report subscription options 
+ Enable or disable undo/redo options on embedding chrome 

To allow you to customize the dashboard with your app's theme, Amazon QuickSight hides the top navigation bar\. When you publish a dashboard, you can also choose to hide the advanced filtering options and the on\-sheet filter controls\. That way you can instead use controls that are embedded in your app\. You can also pass in fragments via the dashboard URL to further customize the view of the data\. 