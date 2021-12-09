# Start Discovery Connector data collection<a name="start-connector-data-collection"></a>

After you have deployed and configured the Discovery Connector in your VMware environment, you must complete the final step of actually turning on its data collection process\. You can turn on data collection through the console or by making API calls through the AWS CLI\. Instructions are provided below for both methods\.

------
#### [ Using the Migration HubConsole ]

You start the Discovery Connector data collection process on the **Data Collectors** page of the Migration Hub console\.

**To start data collection**

1. In the navigation pane, choose **Data Collectors**\.

1. Choose the **Connectors** tab\.

1. Select the check box of the connector you want to start\.

1. Choose **Start data collection**\.

**Note**  
If you don’t see inventory information after starting data collection with the connector, confirm that you have registered the connector with your vCenter Server\.

------
#### [ Using the AWS CLI ]

To start the Discovery Connector data collection process from the AWS CLI, the AWS CLI must first be installed in your environment\.

**To install the AWS CLI and start data collection**

1. Install the AWS CLI for your operating system \(Linux, macOS, or Windows\)\. See the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/) for instructions\.

1. Open the Command prompt \(Windows\) or Terminal \(Linux or macOS\)\.

   1. Type `aws configure` and press Enter\.

   1. Enter your AWS Access Key ID and AWS Secret Access Key\.

   1. Enter your home region, for example `us-west-2`, for the Default Region Name\.

   1. Enter `text` for Default Output Format\.

1. Type the following command:

   ```
   aws discovery start-data-collection-by-agent-ids --agent-ids <connector ID>
   ```

   1. If you don't know the ID of the connector you want to start, enter the following command exactly as shown to see the connector's ID:

     ```
     aws discovery describe-agents --filters condition=EQUALS,name=hostName,values=connector
     ```

**Note**  
If you don’t see inventory information after starting data collection with the connector, confirm that you have registered the connector with your vCenter Server\.

------