# Supported deployments and features of AWS Launch Wizard<a name="launch-wizard-sap-deployments"></a>

**Supported deployments**  
AWS Launch Wizard currently supports the deployment of AWS resources for the following SAP systems and patterns\. SAP HANA database software is optionally installed and customer provided\. 
+ **SAP HANA database on a single Amazon EC2 instance\.** Deploy SAP HANA in a single\-node, scale\-up architecture, with up to 24TB of memory\.
+ **SAP Netweaver on SAP HANA system on a single Amazon EC2 instance\.** Deploy an SAP application on the same Amazon EC2 instance as your SAP HANA Database\. 
+ **SAP HANA database on multiple EC2 instances\.** Deploy SAP HANA in a multi\-node, scale\-out architecture\.
+ **SAP Netweaver system on multiple EC2 instances\.** Deploy an SAP Netweaver system using a distributed deployment model, which includes an ASCS/PAS server, single/multiple SAP HANA servers running SAP HANA databases, and multiple application servers\.
+ **Cross\-AZ SAP HANA database high availability setup\.** Deploy SAP HANA with high availability configured across two Availability Zones\. 
+ **Cross\-AZ SAP Netweaver system setup\.** Deploy Amazon EC2 instances for ASCS/ERS and SAP HANA databases across two Availability Zones, and spread the deployment of application servers across them\.

AWS Launch Wizard provides the following features:

**Topics**
+ [Instance selection and configuration](#launch-wizard-sap-features-app-deployment)
+ [AWS resource selection](#launch-wizard-sap-features-resource-selection)
+ [Cost estimation](#launch-wizard-sap-features-cost)
+ [Reusable infrastructure settings](#launch-wizard-sap-features-code-templates)
+ [SNS notification](#launch-wizard-sap-features-sns)
+ [Application resource groups](#launch-wizard-sap-features-resource-groups)
+ [AWS Data Provider for SAP](#launch-wizard-sap-features-data-provider)

## Instance selection and configuration<a name="launch-wizard-sap-features-app-deployment"></a>

When you input the application requirements, Launch Wizard deploys the necessary AWS resources for a production\-ready application\. This means that you do not have to figure out how to select the right instances and configure them to run supported SAP applications\. 

## AWS resource selection<a name="launch-wizard-sap-features-resource-selection"></a>

Launch Wizard considers CPU/Memory or SAPS requirements that you provide to determine the most appropriate instance types and other resources for your SAP application\. You can modify the recommended defaults\. 

## Cost estimation<a name="launch-wizard-sap-features-cost"></a>

Launch Wizard provides a cost estimate for the complete deployment that is itemized for each individual resource being deployed\. The estimated cost automatically updates each time you change a resource type configuration in the wizard\. The provided estimates are only for general comparisons\. They are based on On\-Demand instance costs\. Actual costs may be lower\.

## Reusable infrastructure settings<a name="launch-wizard-sap-features-code-templates"></a>

You can save the settings for your AWS infrastructure for the SAP landscape to reuse when you want to deploy SAP systems that function similarly within a landscape\. For example, a development configuration can be created for the first development instance, which can later be reused to deploy other development systems\.

Some example scenarios for which DevOps and SAP architecture teams can create templates include:
+ Organize the SAP systems within a landscape\.
+ Save infrastructure settings, including VPC, subnets, key pairs, and security groups to ensure that systems that must be deployed with the same settings are correctly deployed\. 
+ Set up connectivity between the systems using the same configuration template so they can communicate with each other when security groups are created with Launch Wizard\.
+ Use the same GID for SAPSYS group across different configuration templates to ensure that SAP transport files systems are mounted properly\.

## SNS notification<a name="launch-wizard-sap-features-sns"></a>

You can provide an [ SNS topic](https://docs.aws.amazon.com/sns/latest/dg/welcome.html) so that Launch Wizard will send you notifications and alerts about the status of a deployment\.

## Application resource groups<a name="launch-wizard-sap-features-resource-groups"></a>

Launch Wizard creates a resource group for all of the AWS resources created for your SAP system\. You can manage the resources through the Amazon EC2 console or by using Systems Manager\.

## AWS Data Provider for SAP<a name="launch-wizard-sap-features-data-provider"></a>

Deploying and running the Amazon Web Services \(AWS\) Data Provider for SAP is a prerequisite for running SAP systems on AWS\. Launch Wizard automatically deploys AWS Data Provider for SAP on every EC2 instance that it launches\. AWS Data Provider for SAP is a tool that collects performance\-related data from AWS services\. It makes this data available to SAP applications to help monitor and improve the performance of business transactions\. AWS Data Provider for SAP uses operating system, network, and storage data that is most relevant to the operation of the SAP infrastructure\. Its data sources include Amazon EC2 and Amazon CloudWatch\. 