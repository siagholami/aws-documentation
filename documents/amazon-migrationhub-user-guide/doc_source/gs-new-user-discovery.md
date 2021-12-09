# Perform Discovery and Then Migrate<a name="gs-new-user-discovery"></a>

You can get data about your servers and applications into the AWS Migration Hub console for migration tracking in three ways; Migration Hub import, the AWS Agentless Discovery Connector, and the AWS Application Discovery Agent\.
+ **Migration Hub import** – With Migration Hub import, you can import information about your on\-premises servers and applications into Migration Hub, including server specifications and utilization data\. You can also use this data to track the status of application migrations\. For more information, see [Migration Hub Import](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-import.html) in the *Application Discovery Service User Guide*\.
+ **AWS Agentless Discovery Connector** – The Discovery Connector is a VMware appliance that can collect information about VMware virtual machines \(VMs\)\. You install the Discovery Connector as a VM in your VMware vCenter Server environment using an Open Virtualization Archive \(OVA\) file\. Using the Discovery Connector minimizes the time required for initial on\-premises infrastructure assessment\. For more information, see [AWS Agentless Discovery Connector](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-connector.html) in the *Application Discovery Service User Guide*\.
+ **AWS Application Discovery Agent** – The Discovery Agent is AWS software that you install on your on\-premises servers and VMs to capture system configuration, system performance, running processes, and details of the network connections between systems\. Agents support most Linux and Windows operating systems, and you can deploy them on physical on\-premises servers, Amazon EC2 instances, and virtual machines\. For more information, see [AWS Application Discovery Agent](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-agent.html) in the *Application Discovery Service User Guide*\.

Discovering your servers first is an optional starting point for migrations by gathering detailed server information and then grouping the discovered servers into applications to be migrated and tracked\.

Use this section to guide you through the console screens that Migration Hub presents to the first\-time user, for viewing, comparing, and downloading AWS discovery tools\. *If you are not sure about the differences between the two AWS discovery tools, Discovery Connectors and Discovery Agents, see the [AWS discovery tools comparison chart](discovery-wt-discover.md#discovery-wt-aws-disco-tools)*\.

Once you've completed the new user screens, refer to the [AWS Migration Hub Walkthroughs](walkthroughs.md) for remaining steps\.

1. If you chose **Get started with discovery** in the new user screen, the **Perform Discovery and Then Migrate** screen is displayed\. Choose **View AWS discovery tools**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/migrationhub/latest/ug/images/workflow1modal.png)

1. This takes you to the **Discovery Tools** page where you can download AWS discovery tools\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/migrationhub/latest/ug/images/DataCollectionTools.png)

1. To proceed with next steps, see [Phase 1: Discover](discovery-wt-discover.md) of the [Option 1: Perform Discovery and Then Migrate](discovery-walkthroughs.md) walkthrough\.