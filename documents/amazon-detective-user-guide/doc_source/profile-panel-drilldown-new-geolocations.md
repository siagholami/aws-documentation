# Activity details for a geolocation<a name="profile-panel-drilldown-new-geolocations"></a>

The activity details for **Newly observed geolocations** show the API calls that were issued from a geolocation during the scope time\. The API calls include all calls issued from the geolocation\. They are not limited to calls that used the finding or profile entity\.

To display the activity details, do one of the following:
+ On the map, choose a geolocation\.
+ In the list, choose **Details** for a geolocation\.

The activity details replace the geolocation list\. To return to the geolocation list, choose **Return to all results**\.

## Content of the activity details<a name="profile-panel-drilldown-geolocation-content"></a>

Each tab provides information about all of the API calls that were issued from the geolocation during the scope time\.

For each IP address, resource, and API method, the list shows the number of successful and failed API calls\.

The activity details contain the following tabs:

**Observed IP addresses**  
Initially displays the list of IP addresses that were used to issue API calls from the selected geolocation\.  
You can expand each IP address to display the resources that issued API calls from that IP address\. The list displays the resource name\. To see the principal ID, pause on the name\.  
You can then expand each resource to display the specific API calls that were issued from that IP address by that resource\.  

![\[View of the Observed IP addresses tab of the Newly observed geolocations panel with an entry expanded to show the hierarchy of IP address, resources, and API methods.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_geo_ips.png)

**Resource**  
Initially displays the list of resources that issued API calls from the selected geolocation\. The list displays the resource name\. To see the principal ID, pause on the name\. For each resource, the **Resource** tab also displays the associated AWS account\.  
You can expand each user or role to display the list of API calls that were issued by that resource\.  
You can then expand each API call to display the list of IP addresses from which the resource issued the API call\.  

![\[View of the Resource tab of the Newly observed geolocations panel, with an entry expanded to show the hierarchy of user or role, API methods, and IP addresses.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_geo_resources.png)

## Sorting the activity details<a name="drilldown-geolocation-sort"></a>

You can sort the activity details by any of the list columns\.

When you sort using the first column, only the top\-level list is sorted\. The lower level lists are always sorted by the count of successful API calls\.

## Filtering the activity details<a name="drilldown-geolocation-filter"></a>

You can use the filtering options to focus on specific subsets or aspects of the activity represented in the activity details\.

On all of the tabs, you can filter the list by any of the values in the first column\.

**To add a filter**

1. Choose the filter box\.

1. From **Properties**, choose the property to use for the filtering\.

1. Provide the value to use for the filtering\. The filter supports partial values\. For example, when you filter by API method, if you filter by **Instance**, the results include any API operation that has `Instance` in its name\. So both `ListInstanceAssociations` and `UpdateInstanceInformation` would match\.

   For API methods and IP addresses, you can either specify a value or choose a built\-in filter\.

   For **Common API substrings**, choose the substring that represents the type of operation, such as `List`, `Create`, or `Delete`\. Each API method name starts with the operation type\.

   For **CIDR patterns**, you can choose to include only public IP addresses, private IP addresses, or IP addresses that match a specific CIDR pattern\.

1. If you have multiple filters, choose a Boolean option to set how those filters are connected\.  
![\[List of available connectors between individual filters for the activity details filter.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_geo_filterconnectors.png)

1. To remove a filter, choose the **x** icon in the top right corner\.

1. To clear all of the filters, choose **Clear filter**\.