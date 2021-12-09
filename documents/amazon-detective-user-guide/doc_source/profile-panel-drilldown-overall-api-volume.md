# Activity details for Overall API call volume<a name="profile-panel-drilldown-overall-api-volume"></a>

The activity details for **Overall API call volume** show the API calls that were issued during a selected time interval\.

To display the activity details, choose a time interval\.

## Content of the activity details<a name="drilldown-api-volume-content"></a>

Each tab provides information about the set of API calls that were issued during the selected time interval\.

For each entry, the activity details show the number of successful and failed calls\. The **Observed IP addresses** tab also shows the location of each IP address\.

The activity details contain the following tabs:

**Observed IP addresses**  
Initially displays the list of IP addresses used to issue API calls\.  
You can expand each IP address to display the list of API calls that were issued from that IP address\.  
You can then expand each API call to display the list of AKIDs that issued that API call from that IP address\.  

![\[View of the Observed IP addresses tab of the Overall API call volume panel, with an entry expanded to show the hierarchy of IP address, API calls, and AKIDs.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_api_ipaddress.png)

**API method**  
Initially displays the list of API calls that were issued\.  
You can expand each API method to display the list of IP addresses from which the calls were issued\.  
You can then expand each IP address to display the list of AKIDs that issued that API call from that IP address\.  

![\[View of the API method tab of the Overall API call volume panel, with an entry expanded to show the hierarchy of API call, IP addresses, and AKIDs.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_api_apimethods.png)

**Access Key ID**  
Initially displays the list of AKIDs that were used to issue API calls\.  
You can expand each AKID to display the list of IP addresses from which the AKID issued API calls\.  
You can then expand each IP address to display the list of API calls that were issued from that IP address using that AKID\.  

![\[View of the Access key ID tab of the Overall API call volume panel, with an entry expanded to show the hierarchy of AKIDs, IP addresses, and API calls.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_api_akids.png)

## Sorting the activity details<a name="drilldown-api-volume-sort"></a>

You can sort the activity details by any of the list columns\.

When you sort using the first column, only the top\-level list is sorted\. The lower level lists are always sorted by the count of successful API calls\.

## Filtering the activity details<a name="drilldown-api-volume-filter"></a>

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
![\[List of available connectors between individual filters for the activity details filter.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/screen_profile_panel_drilldown_filterconnectors.png)

1. To remove a filter, choose the **x** icon in the top right corner\.

1. To clear all of the filters, choose **Clear filter**\.