# View, Export, and Explore Server Data<a name="discovered_servers"></a>

The **Servers** page provides system configuration and performance data about each server instance known to the data collection tools\. You can view server information, sort servers with filters, tag servers with key\-value pairs, and export detailed server and system information\. 

**Topics**
+ [Viewing and Sorting Servers](#sort-view-servers)
+ [Tagging Servers](#tag-servers)
+ [Exporting Server Data](#export-server-data)
+ [Data Exploration in Athena](#explore-data-console)
+ [Applications](#applications)

## Viewing and Sorting Servers<a name="sort-view-servers"></a>

You can view information about the servers discovered by the data collection tools, and you can sort through the servers using filters\.

### Viewing Servers<a name="view-servers"></a>

You can get a general view and a detailed view of the servers discovered by the data collection tools\. 

**To view discovered servers**

1. In the navigation pane, choose **Servers**\. The discovered servers appear in the servers list\. 

1. For more detail about a server, choose its server link in the **Server info** column\. Doing so displays a screen that describes the server\.

The server's detail screen displays system information and performance metrics\. You can also find a button to export network dependencies and processes information\. To export detailed server information, see [Exporting Server Data](#export-server-data)\.

### Sorting Servers with Search Filters<a name="sort-servers"></a>

To easily find specific servers, apply search filters to sort through all the servers discovered by the collection tools\. You can search and filter on numerous criteria\.

**To sort servers by applying search filters**

1. In the navigation pane, choose **Servers**\.

1. Click inside the search bar, and choose a search criterion from the list\.

1. Choose an operator from the next list\.

1. Type in a case\-sensitive value for the search criterion you selected, and press Enter\.

1. Multiple filters can be applied by repeating steps 2 \- 4\.

## Tagging Servers<a name="tag-servers"></a>

To assist migration planning and help stay organized, you can create multiple tags for each server\. *Tags *are user\-defined key\-value pairs that can store any custom data or metadata about servers\. You can tag an individual server or multiple servers in a single operation\. Application Discovery Service tags are similar to AWS tags, but the two types of tag cannot be used interchangeably\. 

You can add or remove multiple tags for one or more servers from the main **Servers** page\. On a server's detail page, you can add or remove one or more tags for the selected server\. You can do any type of tagging task involving multiple servers or tags in a single operation\. You can also remove tags\.<a name="add-tags"></a>

**To add tags to one or more servers**

1. In the navigation pane, choose **Servers**\.

1. In the **Server info** column, choose the server link for the server that you want to add tags for\. To add tags to more than one server at a time, click inside the check boxes of multiple servers\.

1. Choose **Add tag**\.

1. In the dialog box, type a value in the **Key** field, and optionally a value in the **Value** field\.

   Add more tags by choosing **Additional tag ** and adding more information\.

1. Choose **Add Tags**\. A green confirmation message will be displayed at the top of the screen\.

1. Optionally, tags can be added for an individual server from its detail page by choosing **Actions**, and then **Add tag** and repeating the above steps\.<a name="remove-tags"></a>

**To remove tags from one or more servers**

1. In the navigation pane, choose **Servers**\.

1. In the **Server info** column, choose the server link for the server that you want to remove tags from\. Click inside the check boxes of multiple servers to remove tags from more than one server at a time\.

1. For **Actions**, choose **Remove tag**\.

1. Select each tag you want to remove, or choose **select all**\.

1. Choose **Remove**\. A green confirmation message appears at the top of the screen\.

1. Optionally, tags can be removed for an individual server from its detail page by choosing **Actions**, and then **Remove tag** and repeating the above steps\.

## Exporting Server Data<a name="export-server-data"></a>

To export network dependencies and process information for one server at a time, you can use a server's detail screen\. You can find the export jobs for a server in a table located in the **Exports** section of the server's detail screen\. If no export jobs yet exist, the table is empty\. You can simultaneously export up to five collections of data\.

**Note**  
Exporting server data from the console is only available for data collected by an agent running on that server\. If you want to download data collected by a connector, see [Export System Performance Data for All Servers](export-data.md#export-data-api)\. Or, if you want to bulk export data for all servers where agents have been installed, see [Data Exploration in Amazon Athena](explore-data.md)\.<a name="export"></a>

**To export detailed server data**

1. In the navigation pane, choose **Servers**\.

1. In the **Server info** column, choose the ID of the server for which you want to export data\. 

1. In the **Exports** section at the bottom of the screen, choose **Export server details**\.

1. For **Export server details**, fill in **Start date** and **Time**\. 
**Note**  
The start time can't be more than 72 hours before the current time\.

1. Choose **Export** to start the job\. The initial status is **In\-progress**; to update the status, click the refresh icon for the **Exports** section\.

1. When the export job is complete, choose **Download** and save the \.zip file\.

1. Unzip the saved file\. A set of \.csv files contains the export data, similar to the following:
   + *<AWS account ID>*\_destinationProcessConnection\.csv
   + *<AWS account ID>*\_networkInterface\.csv
   + *<AWS account ID>*\_osInfo\.csv
   + *<AWS account ID>*\_process\.csv
   + *<AWS account ID>*\_sourceProcessConnection\.csv
   + *<AWS account ID>*\_systemPerformance\.csv

   You can open the \.csv files in Microsoft Excel and review the exported server data\. 

   Among the files, you can find a JSON file containing data about the export task and its results\. 

## Data Exploration in Athena<a name="explore-data-console"></a>

Data Exploration in Amazon Athena allows you to analyze the data collected from all the discovered on\-premises servers by Discovery Agents in one place\. Once Data Exploration in Amazon Athena is enabled from the Migration Hub console \(or by using the StartContinousExport API\) and the data collection for agents is turned on, data collected by agents will automatically get stored in your S3 bucket at regular intervals\. For more information, see [Data Exploration in Amazon Athena](explore-data.md)\.

## Applications<a name="applications"></a>

Some of your discovered servers might need to be migrated together to remain functional\. In this case, you can logically define and group discovered servers into applications\. 

As part of the grouping process, you can search, filter, and add tags\.

**To group servers into a new or existing application**

1. In the navigation pane, choose **Servers**\.

1. In the servers list, select each server that you want to group into a new or existing application\.

   To help choose servers for your group, you can search and filter on any criteria that you specify in the server list\. Click inside the search bar and choose an item from the list, choose an operator from the next list, and then type in your criteria\.

1. Optional: For each selected server, choose **Add tag**, type a value for **Key**, and then optionally type a value for **Value**\.

1. Choose **Group as application** to create your application, or add to an existing one\. 

1. In the **Group as application** dialog box, choose **Group as a new application** or **Add to an existing application**\.

   1. If you chose **Group as a new application**, type a name for **Application name**\. Optionally, you can type a description for **Application description**\.

   1. If you chose **Add to an existing application**, select the name of the application to add to in the list\.

1. Choose **Save**\. 