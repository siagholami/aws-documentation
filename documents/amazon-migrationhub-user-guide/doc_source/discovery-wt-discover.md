# Phase 1: Discover<a name="discovery-wt-discover"></a>

The discovery phase has the following steps: 
+ Choose and Deploy AWS Discovery Tools\.
+ View Discovered Servers\.
+ Group Servers as Applications\.

**Topics**
+ [Discover Step 1: Choose and Deploy AWS Discovery Tools](#discovery-wt-aws-disco-tools)
+ [Discover Step 2: View Discovered Servers](#discovery-wt-view-disco-servers)
+ [Discover Step 3: Group Servers as Applications](#discovery-wt-group-as-applications)

## Discover Step 1: Choose and Deploy AWS Discovery Tools<a name="discovery-wt-aws-disco-tools"></a>

If you landed here from Step 3 of [Perform Discovery and Then Migrate](gs-new-user-discovery.md), or if you already have AWS discovery tools implemented and would like to deploy more, the following steps will show you how to deploy either an [AWS Agentless Discovery Connector](#discovery-agent-less-wt) or an [AWS Application Discovery Agent](#discovery-agent-wt)\. If you have already performed discovery using an AWS Migration Partner discovery tool or have existing data from data sources such as a Configuration Management Database \(CMDB\) or IT Asset Management System \(ITAM\), you can use Migration Hub import to upload them\. For more information, see [Migration Hub Import](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-import.html) in the *Application Discovery Service User Guide*\.

To help you decide whether to choose a Discovery Connector or a Discovery Agent, the following comparison chart is provided\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/migrationhub/latest/ug/images/AgentConnectorCompTbl.png)

### Discovery Using the AWS Agentless Discovery Connector<a name="discovery-agent-less-wt"></a>

These steps walk you through the discovery process using an AWS Agentless Discovery Connector for collecting data about your on\-premises resources\.

The Discovery Connector is a VMWare appliance \(OVA\) and can only collect information about VMWare VMs\. 

You use a Discovery Connector because it lets you quickly assess your infrastructure using a tool that isn’t specific to any operating system, without having to install anything on the servers themselves\.

**To discover resources using an agentless connector**

1. If you are proceeding from Step 3 of [Perform Discovery and Then Migrate](gs-new-user-discovery.md), choose **Download connector**; else, in the navigation pane, under **Discover**, choose **Tools**, and then choose **Download connector**\.

1. Deploy and configure the agentless connector by following the instructions specified in [Setting up Agentless Discovery](http://docs.aws.amazon.com/application-discovery/latest/userguide/setting-up-agentless.html) from the AWS Application Discovery Service User Guide\.

1. After you have successfully installed the agentless connector, return to the **Data Collectors** page on the Migration Hub console and choose the refresh icon\.

1. Select the check box of the connector\(s\) you want to start\.

1. Choose **Start data collection**\.

   1. To install additional connectors, repeat the above procedure\.

### Discovery Using the AWS Application Discovery Agent<a name="discovery-agent-wt"></a>

These steps walk you through the discovery process using an AWS Application Discovery Agent for collecting data about your on\-premises resources\.

You can install Discovery Agents on both your VMs and physical servers to not only discover your on\-premises servers, but also to capture technical specifications, system performance, network dependencies, and process information\. Network dependency and process information is available, but only for export\. Use the Application Discovery Service CLI to export the data and analyze it outside of the Migration Hub\. For more information, see [describe\-export\-tasks](http://docs.aws.amazon.com/cli/latest/reference/discovery/describe-export-tasks.html)\.

The beneﬁt of using a Discovery Agent is that it provides more detailed information than using the agentless Discovery Connector\. This information includes system performance and resource utilization\. In contrast, the beneﬁt of using a discovery connector is that it provides a more efficient and faster on\-premises infrastructure assessment\. 

**To discover resources using an agent**

1. If you are proceeding from Step 3 of [Perform Discovery and Then Migrate](gs-new-user-discovery.md), choose **Download agent**, then in the dropdown, select either **Windows** or **Linux**; else, the **Download agent** button can be accessed by choosing **Tools** under **Discover** in the navigation pane\.

1. Deploy and configure the agent by following the instructions specified in [Setting up Agent Based Discovery](http://docs.aws.amazon.com/application-discovery/latest/userguide/setting-up-agents.html) from the AWS Application Discovery Service User Guide\.

1. After you have successfully installed the agent, return to the **Data Collectors** page on the Migration Hub console and choose the refresh icon\.

1. Select the check box of the agent\(s\) you want to start\.

1. Choose **Start data collection**\.

   1. To install additional agents, repeat the above procedure\.

## Discover Step 2: View Discovered Servers<a name="discovery-wt-view-disco-servers"></a>

These steps walk you through viewing your servers that have been discovered after you have deployed and started your AWS discovery tool\.

**To view discovered servers**

1. In the navigation pane, choose **Servers**\. The discovered servers will be present in the servers list on this page\. If you wish to see server details, proceed through the remaining steps\.

1. Choose the server ID listed in the **Server ID** column\. Doing so displays a screen that describes the server you selected\.

1. The server's detail screen displays system information and performance metrics and a button for you to export network dependencies and processes information\. 

## Discover Step 3: Group Servers as Applications<a name="discovery-wt-group-as-applications"></a>

These steps walk you through the process of grouping servers as applications\. Because applications can have multiple servers, it can help simplify migration tracking to group them into a logical unit\. 

The following steps will show you how to select the server\(s\) you want to group for your application, how to create your application and name it, and how to add identifying tags\.

**Tip**  
You can import application groups in bulk using the AWS CLI for Application Discovery Service and calling `CreateApplication` API \(see [AWS Application Discovery Service API guide](http://docs.aws.amazon.com/application-discovery/latest/APIReference/API_CreateApplication.html)\)\.

**To group servers into a new or existing application**

1. In the navigation pane, choose **Servers**\.

1. In the severs list, select the check\-box for each of the servers you wish to group into a new or existing application\.

   1. You can also search and filter on any of the criteria specified in the headers of the server list\. Click inside the search bar and choose an item from the dropdown, then choose an operator from the next dropdown, and then type in your criteria\.

   1. Optionally, for each selected server, you can add a descriptive tag by choosing **Add tag**\. Doing so shows a dialog box where you can type a value for **Key**, and optionally a value for **Value**\.

1. Create your application, or add to an existing one, by choosing **Group as application**\.

1. In the **Group as application** dialog box, select either **Group as a new application** or **Add to an existing application**\.

   1. If you chose **Group as a new application**, type a name in the **Application name** field\. Optionally, you can type a description for **Application description**\.

   1. If you chose **Add to an existing application**, select the radio button next to the application name in the list box\.

1. Choose **Save**\. A green confirmation message is displayed at the top of the screen\.

**Next steps**

Once you have completed the three steps of the Discover phase, proceed to
+ [Phase 2: Migrate](discovery-wt-migrate.md)