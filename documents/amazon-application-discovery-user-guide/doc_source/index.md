# AWS Application Discovery Service User Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What Is AWS Application Discovery Service?](what-is-appdiscovery.md)
+ [Setting Up AWS Application Discovery Service](setting-up.md)
   + [Step 1: Sign Up for AWS](setting-up-signup.md)
   + [Step 2: Create IAM Users](setting-up-iam.md)
+ [AWS Application Discovery Agent](discovery-agent.md)
   + [Data Collected by the Discovery Agent](agent-data-collected.md)
   + [Prerequisites for Agent Installation](gen-prep-agents.md)
   + [Agent Installation on Linux](install_on_linux.md)
   + [Agent Installation on Windows](install_on_windows.md)
   + [Start Discovery Agent Data Collection](start-agent-data-collection.md)
+ [AWS Agentless Discovery Connector](discovery-connector.md)
   + [Data Collected by the Discovery Connector](agentless-data-collected.md)
   + [Download the Discovery Connector](setting-up-agentless.md)
   + [Deploy the Discovery Connector](deploy-connector-appliance.md)
   + [Configure the AWS Discovery Connector](configure-connector.md)
   + [Start Discovery Connector data collection](start-connector-data-collection.md)
   + [Troubleshooting the Discovery Connector](agentless-troubleshooting.md)
+ [Migration Hub Import](discovery-import.md)
+ [View, Export, and Explore Discovered Data](view-and-export.md)
   + [View Collected Data Using the Console](view-data.md)
   + [Export Collected Data](export-data.md)
   + [Data Exploration in Amazon Athena](explore-data.md)
      + [Enabling Data Exploration in Amazon Athena](ce-prep-agents.md)
      + [Working with Data Exploration in Amazon Athena](working-with-data-athena.md)
+ [AWS Application Discovery Service Console Walkthroughs](console-walkthrough.md)
   + [Main Dashboard](dashboard.md)
   + [Data Collection Tools](data_collection.md)
   + [View, Export, and Explore Server Data](discovered_servers.md)
+ [Querying Discovered Configuration Items](discovery-api-queries.md)
+ [Security in AWS Application Discovery Service](security.md)
   + [Identity and Access Management for AWS Application Discovery Service](security-iam.md)
      + [How AWS Application Discovery Service Works with IAM](security_iam_service-with-iam.md)
      + [AWS Managed (Predefined) Policies for Application Discovery Service](security-iam-managed-policies.md)
      + [AWS Application Discovery Service Identity-Based Policy Examples](security_iam_id-based-policy-examples.md)
      + [Using Service-Linked Roles for Application Discovery Service](using-service-linked-roles.md)
         + [Service-Linked Role Permissions for Application Discovery Service](service-linked-role-permissions.md)
         + [Creating a Service-Linked Role for Application Discovery Service](create-service-linked-role.md)
         + [Deleting a Service-Linked Role for Application Discovery Service](delete-service-linked-role.md)
      + [Troubleshooting AWS Application Discovery Service Identity and Access](security_iam_troubleshoot.md)
   + [Logging and monitoring in AWS Application Discovery Service](logging-monitoring.md)
      + [Logging Application Discovery Service API Calls with AWS CloudTrail](logging-using-cloudtrail.md)
+ [AWS Application Discovery Service Limits](ads_service_limits.md)
+ [Troubleshooting Data Exploration in Amazon Athena](troubleshooting.md)
+ [Document History for AWS Application Discovery Service](doc-history.md)
+ [AWS glossary](glossary.md)