# Export Collected Data<a name="export-data"></a>

After starting the data collection process of your Discovery Connector or Discovery Agent, you can export their collected data  about your servers and VMs\. This data can be exported either by interacting with the console or by making API calls through the AWS CLI depending on which discovery tool you used to collect data\.
+ **Discovery Agent**, you can export the collected data either from the console or from the AWS CLI\.
+ **Discovery Connector**, you can only export the collected data from the AWS CLI\.

Instructions are provided below for both ways by expanding your method of choice:

## Export System Performance Data for All Servers<a name="export-data-api"></a>

Collected data from all the Discovery Connectors and Discovery Agents running on your hosts and VMs can be bulk exported from the AWS CLI\. If not already installed, the AWS CLI must first be installed in your environment\.

**To install the AWS CLI and export collected data**

1. If you have not already done so, install the AWS CLI appropriate to your OS type \(Windows or Mac/Linux\)\. See the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/) for instructions\.

1. Open the Command prompt \(Windows\) or Terminal \(MAC/Linux\)\.

   1. Type `aws configure` and press Enter\.

   1. Enter your AWS Access Key Id and AWS Secret Access Key\.

   1. Enter `us-west-2` for the Default Region Name\.

   1. Enter `text` for Default Output Format\.

1. Type the following command to generate an export ID:

   ```
   aws discovery start-export-task
   ```

1. Using the export ID generated in the previous step, type the following command to generate an S3 URL as a value for the parameter `"configurationsDownloadUrl"`:

   ```
   aws discovery describe-export-tasks --export-ids <export ID>
   ```

1. Copy the URL generated in the previous step and paste it in a browser to download the zip file with collected data of the discovered servers\.

## Export Agent Collected Data Using the Console<a name="export-data-console"></a>

Exporting agent collected data from the console is limited to one agent when you are on the detail page for a specific server\. There, you can find the server's export jobs listed at the bottom of the screen, underneath **Exports**\. If no export jobs yet exist, the table is empty\. You can run up to five exports of server data at a time\.

**To export collected data about a discovered server**

1. In the navigation pane, choose **Servers**\.

1. In the **Server info** column, choose the link for the server that you want to export data for\. 

1. In the **Exports** section at the bottom of the screen, choose **Export server details**\.

1. For **Export server details**, fill in **Start date** and **Time**\.   
**Note**  
The start time can't be more than 72 hours prior from the current time\.

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

**Note**  
For information on generating and exporting Amazon EC2 instance recommendations in the AWS Migration Hub console, see [Amazon EC2 Instance Recommendations](https://docs.aws.amazon.com/migrationhub/latest/ug/ec2-recommendations.html) in the *AWS Migration Hub User Guide*\.