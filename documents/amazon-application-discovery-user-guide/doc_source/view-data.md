# View Collected Data Using the Console<a name="view-data"></a>

After starting the data collection process of your Discovery Connector or Discovery Agent, you can use the console to view their collected data about your servers and VMs\. Data appears in the console approximately 15 minutes after turning on data collection\. This data can also be viewed in a csv  format by exporting the collected data by making API calls through the AWS CLI\. Exporting collected data is covered in the next section [Export Collected Data](export-data.md)\. 

**To view collected data about discovered servers**

1. In the console's navigation pane, choose **Servers**\. The discovered servers appear in the servers list\.

1. For details comprised of the collected data, choose the server name link in the **Server info** column\. Doing so displays a screen that describes detail information such as system information, performance metrics, and more\.

To learn more about using the console to view, sort, and tag servers discovered by your Discovery Connectors or Discovery Agents, see [ AWS Application Discovery Service Console Walkthroughs](console-walkthrough.md)\.

## Matching Logic for Discovered Servers and Applications<a name="add-match-logic"></a>

AWS Application Discovery Service has built\-in matching logic that identifies when servers that it discovers match existing entries\. When this logic finds a match, it updates the information for the already\-existing discovered server with new values\. This matching logic handles duplicate servers from multiple sources including Migration Hub import, Discovery Connector, Discovery Agent, and other migration tools\. For more information about Migration Hub import, see [AWS Migration Hub Import](https://docs.aws.amazon.com/migrationhub/latest/ug/migration-hub-import.html)\.

When server discovery occurs, each entry is cross\-checked with previously imported records to ensure that the imported server does not already exist\. If no match is found, a new record is created and a new unique server identifier is assigned\. If a match is found, then a new entry is still created, but it's assigned the same unique server identifier as the existing server\. When viewing this server in the Migration Hub console, you only find one unique entry for the server\.

Server attributes associated with this entry are merged to show attribute values from a previously available record as well as the newly imported record\. If there is more than one value for a given server attribute from multiple sources, e\.g\., two different values within for `Total RAM` associated with a given server discovered using import and also by the Discovery Agent, then the value that was most recently updated is shown in the matched record for the server\.

### Matching Fields<a name="matching-fields"></a>

The following fields are used to match servers when discovery tools are used\.
+ **ExternalId** – This is the primary field used to match servers\. If the value in this field is identical to another `ExternalId` in another entry, then Application Discovery Service matches the two entries, regardless of whether the other fields match or not\.
+ **IPAddress**
+ **HostName**
+ **MacAddress**
+ **VMware\.MoRefId** and **VMware\.vCenterId** – Both of these values must be identical to the respective fields in another entry for Application Discovery Service to perform a match\.