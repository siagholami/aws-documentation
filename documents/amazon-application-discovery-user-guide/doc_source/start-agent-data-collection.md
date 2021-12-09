# Start Discovery Agent Data Collection<a name="start-agent-data-collection"></a>

Now that you have deployed and configured the Discovery Agent, you must complete the final step of actually turning on its data collection process\. You can turn on data collection through the console or by making API calls through the AWS CLI\. Instructions are provided below for both ways, by expanding your method of choice:

------
#### [ Using the Migration Hub Console ]

Start the Discovery Agent data collection process on the **Data Collectors** page of the Migration Hub console\. Be sure you've selected a [Migration Hub home region](https://docs.aws.amazon.com/migrationhub/latest/ug/home-region.html) before you start data collection\. All of your data is stored in your home region\.

**To start data collection**

1. In the navigation pane, choose **Data Collectors**\.

1. Choose the **Agents** tab\.

1. Select the check box of the agent you want to start\.
**Tip**  
If you installed multiple agents but only want to start data collection on certain hosts, the **Hostname** column in the agent's row identifies the host the agent is installed on\.

1. Choose **Start data collection**\.

------
#### [ Using the AWS CLI ]

To start the Discovery Agent data collection process from the AWS CLI the AWS CLI must first be installed in your environment, and you must set the CLI to use your selected [Migration Hub home region](https://docs.aws.amazon.com/migrationhub/latest/ug/home-region.html)\.

**To install the AWS CLI and start data collection**

1. If you have not already done so, install the AWS CLI appropriate to your OS type \(Windows or Mac/Linux\)\. See the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/) for instructions\.

1. Open the Command prompt \(Windows\) or Terminal \(MAC/Linux\)\.

   1. Type `aws configure` and press Enter\.

   1. Enter your AWS Access Key ID and AWS Secret Access Key\.

   1. Enter your home region for the Default Region Name, for example *`us-west-2`*\. \(We are assuming that `us-west-2` is your home region in this example\.\)

   1. Enter `text` for Default Output Format\.

1. Type the following command:

   ```
   aws discovery start-data-collection-by-agent-ids --agent-ids <agent ID>
   ```

   1. If you don't know the ID of the agent you want to start, enter the following command to see the agent's ID:

     ```
     aws discovery describe-agents
     ```

------