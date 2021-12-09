# Activity details for Overall VPC flow volume<a name="profile-panel-drilldown-overall-vpc-volume"></a>

The activity details for **Overall VPC flow volume** show the interactions between an EC2 instance and IP addresses during a selected time range\.

To display the activity details, choose **View flow details**\.

## Content of the activity details<a name="drilldown-vpc-volume-content"></a>

When you first display the activity details, the content reflects the activity during the current scope time\.

The activity details contain an entry for each unique combination of IP address, local port, remote port, protocol, and direction\.

Each entry displays the volume of inbound traffic, the volume of outbound traffic, and whether the access request was accepted or rejected\. On finding profiles, the **Annotations** column indicates when an IP address is related to the current finding\.

![\[Activity details for the Overall VPC flow volume profile panel.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_vpc_initial.png)

## Sorting the activity details<a name="drilldown-vpc-volume-sort"></a>

You can sort the activity details by any of the columns in the table\.

By default, the activity details are sorted first by the annotations, then by the inbound traffic\.

## Filtering the activity details<a name="drilldown-vpc-volume-filter"></a>

To focus on specific activity, you can filter the activity details by the following values:
+ IP address
+ Local or remote port
+ Direction
+ Protocol
+ Whether the request was accepted or rejected

**To add and remove filters**

1. Choose the filter box\.

1. From **Properties**, choose the property to use for the filtering\.

1. Provide the value to use for the filtering\. The filter supports partial values\.

   To filter by IP address, you can either specify a value or choose a built\-in filter\.

   For **CIDR patterns**, you can choose to only include public IP addresses, private IP addresses, or IP addresses that match a specific CIDR pattern\.

1. If you have multiple filters, choose a Boolean option to set how those filters are connected\.  
![\[List of available connectors between individual filters for the activity details filter.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_vpc_filterconnectors.png)

1. To remove a filter, choose the **x** icon in the top right corner\.

1. To clear all of the filters, choose **Clear filter**\.

## Selecting the time range for the activity details<a name="drilldown-vpc-volume-time-range"></a>

The time range for the activity details is highlighted on the profile panel charts\.

By default, the activity details are for the current scope time\. You can change the time range for the activity details\.

**To change the time range for the activity details**

1. Choose **Edit**\.

1. On **Edit time window**, choose the start and end time to use\.

1. Choose **Update time window**\.

The time range for the activity details is highlighted on the profile panel charts\.

![\[Highlighted time window for the activity details on the Overall VPC flow volume profile panel.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_vpc_timehighlight.png)

## Displaying the volume of traffic for selected rows<a name="drilldown-vpc-volume-chart-details"></a>

When you identify rows that are of interest, you can display on the main charts the volume of traffic over time for those rows\.

For each row to add to the charts, select the check box\. For each selected row, the volume is displayed as a line on the inbound or outbound charts\.

![\[Traffic for selected activity details rows displayed on the main charts for the Overall VPC flow volume profile panel.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_vpc_select_rows.png)

To focus on the traffic volume for the selected entries, you can hide the overall volume\. To show or hide the overall traffic volume, toggle **Overall traffic**\.

![\[Traffic for selected activity details rows displayed on the main charts on the Overall VPC flow volume profile panel . Overall traffic is hidden.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_vpc_overall_off.png)