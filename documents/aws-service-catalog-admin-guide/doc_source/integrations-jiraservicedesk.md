# AWS Service Management Connector for Jira Service Desk<a name="integrations-jiraservicedesk"></a>

 To help customers integrate provisioning secure, compliant, and pre\-approved AWS products into their Jira Service Desk portal, AWS created the AWS Service Management Connector for Jira Service Desk \(formerly the AWS Service Management Connector\)\. 

 The AWS Service Management Connector for Jira Service Desk allows Jira Service Desk end users to provision, manage, and operate AWS resources natively via Atlassian’s Jira Service Desk\. Jira Service Desk administrators can provide pre\-approved, secured, and governed AWS resources to end users via AWS Service Catalog, execute automation playbooks via AWS Systems Manager, and track resources in a configuration item view powered by AWS Config seamlessly on the Jira Service Desk with the AWS Service Management Connector\. 

 Jira Service Desk end users can browse, request, and provision pre\-secured AWS solutions, view configuration item details on provisioned products, and execute workflows within Jira Service Desk on AWS resources\. This simplifies AWS product request actions for Jira Service Desk users and provides Jira Service Desk governance and oversight over AWS products\. 

 The AWS\-supplied connector is available at no charge in the Atlassian Marketplace\. This new feature is generally available in all AWS Regions where AWS Service Catalog, AWS Config, and AWS Systems Manager services are available\. 

**Topics**
+ [Background](#jsd-integration-background)
+ [Jira Service Desk Supported Versions and Releases](#jsd-supported-versions)
+ [Getting Started](#jsd-integration-getting-started)
+ [Release Notes](#jsd-integration-release-notes)
+ [Baseline Permissions](jsd-integration-baseline-permissions.md)
+ [Configuring AWS Service Catalog](jsd-integration-configure-sc.md)
+ [Configuring Jira Service Desk](jsd-integration-configure-jsd.md)
+ [IT Lifecycle Management Setup and Use Case](jsd-it-lifecycle.md)
+ [Validating Configurations](jsd-validate-configurations.md)
+ [Jira Additional Administrator Features](jsd-admin-features.md)

## Background<a name="jsd-integration-background"></a>

 [AWS Service Catalog](https://aws.amazon.com/servicecatalog) allows you to centrally manage commonly deployed AWS services and provisioned software products\. It helps your organization meet consistent governance and compliance requirements, while enabling users to quickly deploy only the approved AWS services they need\. 

 [AWS Config](https://aws.amazon.com/config) enables you to assess, audit, and evaluate the configurations of your AWS resources\. AWS Config continuously monitors and records your AWS resource configurations and allows you to automate the evaluation of recorded configurations against desired configurations\. 

 [AWS Systems Manager](https://aws.amazon.com/systems-manager) gives you visibility and control of your infrastructure on AWS\. Systems Manager provides a unified user interface so you can view operational data from multiple AWS services and allows you to automate operational tasks across your AWS resources\. 

[Atlassian Jira Service Desk](https://www.atlassian.com/software/jira/service-desk/) is service desk software for modern IT teams\. Jira Service Desk request types enable self\-service for developers and end users to order IT services based on request fulfillment approvals and workflows\.

## Jira Service Desk Supported Versions and Releases<a name="jsd-supported-versions"></a>

 The AWS Service Management Connector for Jira Service Desk supports Jira Service Desk Server and Data Center versions\. Jira software \(Jira Service Desk\) releases are supported for the current and one previous version in each of the major, minor, and point release streams:
+ Jira 8\.8\.0 \(JSD 4\.8\.0\)
+ Jira 8\.7\.1 \(JSD 4\.7\.1\)
+ Jira 8\.7\.0 \(JSD 4\.7\.0\)
+ Jira 8\.6\.1 \(JSD 4\.6\.1\)
+ Jira 8\.5\.4 \(JSD 4\.5\.4\)
+ Jira 7\.13\.13 \(JSD 3\.16\.13\)

A Jira Service Desk Cloud Connector is also available in the Atlassian Marketplace\. For more information, see [AWS Service Catalog for Jira Service Desk Cloud](https://marketplace.atlassian.com/apps/1221551/aws-service-catalog-for-jsd-cloud?hosting=cloud)\.

## Getting Started<a name="jsd-integration-getting-started"></a>

 Before installing the AWS Service Management Connector for Jira Service Desk, you need an AWS account and an Atlassian instance with [Jira Service Desk pre\-installed](https://confluence.atlassian.com/servicedeskserver043/installing-jira-service-desk-974367443.html)\. Verify that you have the necessary permissions in your AWS account and Jira Service Desk software\. 

For a video showing how to integrate AWS products into your Jira Service Desk portal, see [Integrate AWS Products into Your Jira Service Desk Portal](https://youtu.be/omm4qV1-ynI)\.

For a zip file containing Connector add\-on code as well as AWS Configuration files, download and extract the [AWS Service Management Connector for JSD\-Configuration Files](https://servicecatalogconnector.s3.amazonaws.com/AWS+Service+Management+Connector+for+JSD+-++Configuration+Files.zip)\.

**Note**  
 The [Jira Products on AWS Reference Deployment Quick Start](https://aws.amazon.com/quickstart/architecture/jira/) is available to use AWS resources for infrastructure required to install Jira Service Desk data center version\.

### AWS prerequisites<a name="jsd-integration-aws-prereqs"></a>

 To get started:
+ To use AWS Service Catalog with the Connector, you need an AWS account to configure your AWS portfolios and products\. For details, see [Setting Up for AWS Service Catalog](setup.md)\.
+ To see AWS Config details, the service settings need to be configured to record data for the resource types of interest\. It is recommended to include provisioned products and AWS CloudFormation stacks in addition to the major resource types used by your team\. For details,see [Setting Up AWS Config with the Console](https://docs.aws.amazon.com/config/latest/developerguide/gs-console.html)\.
+ To use AWS Systems Manager Automation with the Connector, no AWS\-side setup is required\. A number of automation documents are provided by AWS as standard\. If you have additional automation documents you wish to use, they will be available in the Connector\. For details, see [Working with Automation Documents \(Playbooks\)](https://docs.aws.amazon.com/systems-manager/latest/userguide/automation-documents.html)\.

 For each AWS account, the Connector for Jira Service Desk also requires API access with [Baseline Permissions](baseline-permissions.md) as described below\.

### Jira Service Desk prerequisites<a name="jsd-prereqs"></a>

 In addition to your AWS account, you need the Jira Service Desk software installed on your Atlassian instance before you can install the AWS Service Management Connector add\-on\. The Jira Service Desk administrator needs the admin role in order to install the AWS Service Management Connector add\-on\. 

 Before configuring your AWS connector, ensure that you follow Atlassian recommendations for securing your Jira Service Desk instances\. For more information, see [Preventing Security Attacks](https://confluence.atlassian.com/adminjiraserver0713/preventing-security-attacks-964984188.html)\. 

 The Connector for Jira Service Desk add\-on is available to download in the [Atlassian Marketplace](https://marketplace.atlassian.com/apps/1221283/aws-service-catalog-connector-for-jsd)\. 

## Release Notes<a name="jsd-integration-release-notes"></a>

 **Version 1\.5\.0** of the AWS Service Management Connector for Jira Service Desk \(formerly the AWS Service Management Connector\) includes: 

**AWS Service Catalog integration features**
+ Rendering AWS Service Catalog portfolios and products in the Jira Service Desk Customer Portal and Jira Agent views\.
+ The ability for Jira Service Desk administrators to associate Jira Service Desk approval groups to AWS Service Catalog portfolios to require approvals for Jira Service Desk user product requests\.
+ The ability for Jira Service Desk users to request AWS Service Catalog products through Jira Service Desk\.
+ The ability for administrators to view portfolio and product budgets and actual costs\. \(Requires budgets to be associated within AWS Service Catalog\.\)
+ Support for AWS Service Catalog self\-service actions for Jira Service Desk users to update and terminate products\.
+ Support for AWS CloudFormation StackSets, enabling launch of AWS Service Catalog products across multiple regions and accounts\.
+ Support for AWS CloudFormation Change Sets, enabling a preview of resource changes prior to a launch or update\.

**AWS Config integration features**
+ Rendering of AWS Config configuration item details on provisioned AWS products via Jira Service Desk request\.
+ The ability to view the configuration item relationships in a tree structure\.
+ The ability to associate AWS Config items details to Jira issues\.

**AWS Systems Manager integration features**
+ Rendering of AWS Systems Manager automation documents in the Jira Service Desk Customer Portal and Jira Agent views\.
+ The ability for Jira Service Desk administrators to associate AWS Systems Manager automation to Jira projects\.
+ The ability for Jira Service Desk users to request and execute AWS Systems Manager automation documents through Jira Service Desk\.
+ The ability to create Jira issues \(incidents\) that provide actionable remediation suggestions via a Connector specific AWS Systems Manager automation document\.
+ Support for multiple AWS accounts\.
+ Support for FIPS endpoints and usage in the AWS GovCloud West region\.
+ Support for the latest releases of Jira Service Desk Server and Data Center versions\.