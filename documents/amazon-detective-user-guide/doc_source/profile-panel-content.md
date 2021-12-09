# Profile panel content<a name="profile-panel-content"></a>

Profile panels use different types of visualizations to present different types of information\.

## Types of information on a profile panel<a name="profile-panel-data-types"></a>

Profile panels typically provide the following types of data:


|  Panel data type  |  Description  | 
| --- | --- | 
|  High\-level information about a finding or entity  |  The simplest type of panel provides some basic information about a finding or entity\. Examples of information included on an information panel include the identifier, name, type, and creation date\. ![\[Example of a profile panel containing high-level information about a finding or entity.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_item_details.png) Most finding and entity profiles contain an information panel for that finding or entity\. Finding profiles can also include an information panel about the involved entity\.  | 
|  General summary of activity over time  |  Displays a summary of activity for an entity over time\. This type of panel provides an overall view of how an entity is behaving during the scope time\. ![\[Example of a profile panel containing an overview of activity over time for an entity.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_activity_summary.png) Here are some examples of summary data provided on Detective profile panels: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/detective/latest/userguide/profile-panel-content.html)  | 
|  Summary of activity grouped by values  |  Displays a summary of activity for an entity, grouped by specific values\. You can see this type of profile panel on the profile for an Amazon EC2 instance\. The profile panel shows the average volume of Amazon VPC flow data to and from an Amazon EC2 instance for common ports that are associated with specific types of services\. ![\[Example of a profile panel showing a summary of activity grouped by specific values.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_grouped_summary.png)  | 
|  Activity that only started during the scope time  |  During an investigation, it is valuable to see what activity only began to occur at the same time as the finding activity\. For example, are there API calls, geographic locations, or user agents that were not seen before? ![\[Example of a profile panel that highlights activity not observed before the scope time.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_newly_observed.png) If the behavior graph is still in training mode, the profile panel displays a notification message\. The message is removed when the behavior graph has accumulated at least two weeks of data\. For more information about training mode, see [Training period for new behavior graphs](detective-data-training-period.md)\.  | 
|  Activity that changed significantly during the scope time  |  Similar to the new activity panels, profile panels can also display activity that changed significantly during the scope time\. For example, a user might regularly issue a certain API call a few times a week\. If the same user suddenly issues the same call multiple times in a single day, that might be evidence of malicious activity\. ![\[Example of a profile panel showing activity that changed significantly during the scope time.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_changed_activity.png) If the behavior graph is still in training mode, the profile panel displays a notification message\. The message is removed when the behavior graph has accumulated at least two weeks of data\. For more information about training mode, see [Training period for new behavior graphs](detective-data-training-period.md)\.  | 

## Types of profile panel visualizations<a name="profile-panel-display-types"></a>

Profile panel content can take one of the following forms:


|  Visualization type  |  Description  | 
| --- | --- | 
|  Key\-value pairs  |  The simplest type of visualization is a set of key\-value pairs\. A finding or entity information panel is the most common example of a key\-value pair panel\. ![\[Example of a profile panel containing key/value pairs.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_key_value.png) Key\-value pairs can also be used to add additional information to other types of panels\. From a key\-value pair panel, if a value is an identifier of a finding or entity, then you can pivot to its profile\.  | 
|  Table  |  A table is a simple multiple\-column list of items\. ![\[Example of a profile panel containing a simple table.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_table.png) Users can sort, filter, and page through the table\. You can change the number of entries to display per page\. See [Setting the number of rows per page for profile panel tables](profile-panel-table-preferences.md)\. If a value in the table is an identifier of a finding or entity, then you can pivot to its profile\.  | 
|  Timeline  |  A timeline visualization shows an aggregated value for each time interval across time\. ![\[Example of a profile panel containing timelines.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_timeline.png) The timeline highlights the current scope time, and includes additional peripheral time before and after the scope time\. The peripheral time provides context for the activity in the scope time\. Pause on a time interval to display a summary of the data for that time interval\.  | 
|  Expandable table  |  An expandable table combines tables and timelines\. ![\[Example of a profile panel containing an expandable table.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_expandable_table.png) The visualization starts as a table\. Users can sort, filter, and page through the table\. You can change the number of entries to display per page\. See [Setting the number of rows per page for profile panel tables](profile-panel-table-preferences.md)\. You can then expand each row to show a timeline visualization specific to that row\.  | 
|  Bar chart  |  A bar chart shows values based on groupings\. Depending on the chart, you might be able to choose a bar to display a timeline of related activity\. ![\[Example of a profile panel containing a bar chart.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_bar_chart.png)  | 
|  Geolocation chart  |  A geolocation chart displays a map that is marked to highlight data based on geographic location\. It can be followed by a table containing details about individual geolocations\. ![\[Example of a profile panel containing a geolocation chart.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_geolocation.png) Note that when processing incoming geographic data, Detective rounds the latitude and longitude values to a single decimal point\.  | 

## Other notes on profile panel content<a name="profile-panel-other-notes"></a>

When viewing the content of a profile panel, be aware of the following items:

****Approximate count data warning****  
This warning indicates that items with extremely low counts do not appear due to the volume of applicable data\.  
To ensure a completely accurate count, reduce the amount of data\. The easiest way to do that is to reduce the length of the scope time\. See [Managing the scope time used on finding and entity profiles](scope-time-managing.md)\.

****Rounding for geographic locations****  
Detective rounds all latitude and longitude values to a single decimal point\.