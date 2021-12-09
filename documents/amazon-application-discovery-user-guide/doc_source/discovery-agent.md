# AWS Application Discovery Agent<a name="discovery-agent"></a>

The AWS Discovery Agent is AWS software that you install on on\-premises servers and VMs targeted for discovery and migration\. Agents capture system configuration, system performance, running processes, and details of the network connections between systems\. Agents support most Linux and Windows operating systems, and you can deploy them on physical on\-premises servers, Amazon EC2 instances, and virtual machines\. 

**Note**  
Before you deploy the Discovery Agent, you must choose a [Migration Hub home region](https://docs.aws.amazon.com/migrationhub/latest/ug/home-region.html)\. You must register your agent in your home region\.

The Discovery Agent runs in your local environment and requires root privileges\. When you start the Discovery Agent, it connects securely with your home region and registers with Discovery Agent\.
+ For example, if `eu-central-1` is your home region, it registers `arsenal-discovery.eu-central-1.amazonaws.com` with Application Discovery Service\.
+ Or substitute your home region as needed for all other regions except us\-west\-2\.
+ If `us-west-2` is your home region, it registers `arsenal.us-west-2.amazonaws.com` with Application Discovery Service\. 

**How it works**

After registration, it pings the service at 15\-minute intervals for configuration information\. When you send a command that tells an agent to start data collection, it starts collecting data for the host or VM where it resides\.

The collected data includes system specifications, times series utilization or performance data, network connections, and process data\. You can use this information to map your IT assets and their network dependencies\. All of these data points can help you determine the cost of running these servers in AWS and also plan for migration\.

Data is transmitted securely by the Discovery Agents to Application Discovery Service using Transport Layer Security \(TLS\) encryption\. Agents are configured to upgrade automatically when new versions become available\. You can change this configuration setting if desired\.

**Tip**  
Before downloading and beginning Discovery Agent installation, be sure to read through all of the required prerequisites in [Prerequisites for Agent Installation](gen-prep-agents.md)

**Topics**
+ [Data Collected by the Discovery Agent](agent-data-collected.md)
+ [Prerequisites for Agent Installation](gen-prep-agents.md)
+ [Agent Installation on Linux](install_on_linux.md)
+ [Agent Installation on Windows](install_on_windows.md)
+ [Start Discovery Agent Data Collection](start-agent-data-collection.md)