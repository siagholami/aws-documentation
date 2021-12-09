# AWS Service Catalog Connector for ServiceNow<a name="integrations-servicenow"></a>

To help customers integrate provisioning secure, compliant, and pre\-approved AWS products into their ServiceNow portal, AWS created the AWS Service Catalog Connector for ServiceNow\.

AWS Service Catalog Connector for ServiceNow synchronizes AWS Service Catalog portfolios and products with the ServiceNow Service Catalog to enable ServiceNow users to request approved AWS products via ServiceNow\.

**Topics**
+ [Background](#background)
+ [Getting Started](#getting-started)
+ [Release Notes](#release-notes)
+ [Baseline Permissions](baseline-permissions.md)
+ [Configuring AWS Service Catalog](configure-sc.md)
+ [Creating StackSet Constraints](stackset-constraints.md)
+ [Relating Budgets to Products and Portfolios](servicenow-budgets.md)
+ [Configuring ServiceNow](configure-snow.md)
+ [Validating Configurations](validate-configurations.md)
+ [ServiceNow Additional Administrator Features](additional-configurations.md)
+ [Upgrade Instructions](upgrade-instructions.md)

## Background<a name="background"></a>

AWS Service Catalog allows you to centrally manage commonly deployed AWS services and provisioned software products\. It helps your organization achieve consistent governance and compliance requirements, while enabling users to quickly deploy only the approved AWS services they need\.

[ServiceNow](https://www.servicenow.com/) is an enterprise service management platform that places a service‑oriented lens on the activities, tasks, and processes that make up day‑to‑day work life to enable a modern work environment\. [ServiceNow Service Catalog](https://www.servicenow.com/products/it-service-automation-applications/service-catalog.html) is a self\-service application that end users can use to order IT services based on request fulfillment approvals and workflows\.

## Getting Started<a name="getting-started"></a>

Before installing the AWS Service Catalog Connector for ServiceNow, verify that you have the necessary permissions in your AWS account and ServiceNow instance\.

For a video showing how to integrate AWS products into your ServiceNow portal, see [Integrate AWS products into Your ServiceNow Portal](https://youtu.be/cf_nWrr-CfU)\.

### AWS prerequisites<a name="aws-prereqs"></a>

To get started you need an AWS account to configure your AWS portfolios and products\. For details, see [Setting Up for AWS Service Catalog](setup.md)\.

For each AWS account, the Connector for ServiceNow also requires two AWS Identity and Access Management \(IAM\) users and two IAM roles:
+ An IAM user to sync AWS Service Catalog portfolios and products to ServiceNow Service Catalog items\.
+ An IAM role configured as an AWS Service Catalog end user and assigned to each portfolio\.
+ An IAM end user to assume the previous end user role\. This end user has a baseline of permissions to provision AWS services in the ServiceNow Service Catalog\. This ServiceNow end user is linked to the end user role in IAM\.
+ An IAM launch role used to place baseline AWS service permissions into the AWS Service Catalog launch constraints\. Configuring this role enables segregation of duty by provisioning product resources on behalf of the ServiceNow end user\.

Baseline permissions enable an end user to provision the following AWS services: Amazon Simple Storage Service and Amazon Elastic Compute Cloud\. To allow end users to provision AWS services beyond the baseline permissions, you must include the additional AWS service permissions to the launch role\. For information about initial permissions setup actions, see [Baseline Permissions](baseline-permissions.md)\.

**Note**  
 To use an AWS CloudFormation template to set up the AWS configurations of the Connector for ServiceNow, see the two JSON AWS Configurations for: [Connector for ServiceNow v2\.3\.4 \- AWS Commercial Regions](https://servicecatalogconnector.s3.amazonaws.com/SC_ConnectorForServiceNowv2.3.4+-AWS_Configurations_final.json) and [Connector for ServiceNow v2\.3\.4 \- AWS GovCloud West Region](https://servicecatalogconnector.s3.amazonaws.com/SC_ConnectorForServiceNowv2.3.4+-AWS_Configurations_GovCloud_final.json)\. 

### ServiceNow Prerequisites<a name="servicenow-prereqs"></a>

In addition to the AWS account, you need a ServiceNow instance to install the ServiceNow Connector scoped application\. The initial installation should occur in either an enterprise sandbox or a [ServiceNow Personal Developer Instance](https://developer.servicenow.com/app.do#!/document/content/app_store_doc_getting_started_newyork_topic_lyf_bf2_3r?v=newyork) \(PDI\), depending on your organization’s technology governance requirements\. The ServiceNow administrator needs the admin role to install the Connector for ServiceNow scoped application\.

## Release Notes<a name="release-notes"></a>

**Version 2\.3\.4** of the AWS Service Catalog Connector for ServiceNow includes a fix to the ServiceNow platform regression supporting the scoped app call `Object.getPrototypeOf(...)` to create and return an object safe for cross\-scope access\. Prior to this fix, customers would receive a `prototype_not_allowed` error when validating regions within the AWS Service Catalog Connector on the latest ServiceNow platform releases or patches \(Orlando, New York, and Madrid\)\.

This version also includes prior AWS Service Catalog Connector for ServiceNow features such as:
+ The ability for administrators to view portfolio and product budgets and actual costs\. \(Requires budgets to be associated within AWS Service Catalog\.\)
+ Support for AWS GovCloud West region\.
+ The ability for end users to choose accounts and regions for StackSet deployments\.
+ The ability to view provisioned product events and outputs in the ServiceNow request item\. This includes closure of ServiceNow request items when products are terminated\.

This version also includes prior AWS Service Catalog Connector for ServiceNow features such as:
+ Support for AWS CloudFormation StackSets, enabling launch of AWS Service Catalog products across multiple regions and accounts\.
+ Support for AWS CloudFormation Change Sets, enabling a preview of resource changes from a launch or update\.
+ Display of AWS Service Catalog portfolios \(including correlated products\) as sub\-categories in the ServiceNow Service Catalog\.
+ Support AWS Service Catalog self\-service actions using AWS Systems Manager documents\.
+ Support AWS Service Catalog post\-provision operational actions to update and terminate products\.
+ Rendering of AWS Service Catalog products in the ServiceNow Portal page\.
+ Multi\-account support\.
+ Validation of AWS Regions and identities associated with syncing AWS and ServiceNow\.
+ Synchronization of product details in the My Asset/CMDB view\.