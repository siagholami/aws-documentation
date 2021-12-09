# AWS Launch Wizard security<a name="launch-wizard-security"></a>

Cloud security at AWS is the highest priority\. As an AWS customer, you benefit from a data center and network architecture that is built to meet the requirements of the most security\-sensitive organizations\.

Security is a shared responsibility between AWS and you\. The [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/) describes this as security *of* the cloud and security *in* the cloud:
+ **Security of the cloud** – AWS is responsible for protecting the infrastructure that runs AWS services in the AWS Cloud\. AWS also provides you with services that you can use securely\. Third\-party auditors regularly test and verify the effectiveness of our security as part of the [AWS Compliance Programs](http://aws.amazon.com/compliance/programs/)\. To learn about the compliance programs that apply to AWS Launch Wizard, see [AWS Services in Scope by Compliance Program](http://aws.amazon.com/compliance/services-in-scope/)\.
+ **Security in the cloud** – Your responsibility is determined by the AWS service that you use\. You are also responsible for other factors including the sensitivity of your data, your company’s requirements, and applicable laws and regulations\. 

This documentation helps you understand how to apply the shared responsibility model when using AWS Launch Wizard\. The following topics show you how to configure Launch Wizard to meet your security and compliance objectives\. You also learn how to use other AWS services that help you to monitor and secure your Launch Wizard resources\. 

AWS Launch Wizard deployes Amazon EC2 instances into Amazon VPCs\. For security information for Amazon EC2 and Amazon VPC, see the security sections in the [Amazon EC2 Getting Started Guide](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_Network_and_Security.html) and the [Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Security.html)\.

**Topics**
+ [Infrastructure security in Launch Wizard](#infrastructure-security)
+ [Resilience in Launch Wizard](#disaster-recovery-resiliency)
+ [Data protection in Launch Wizard](#data-protection)
+ [Identity and Access Management for AWS Launch Wizard](#identity-access-management)
+ [Update management in Launch Wizard](#update-management)

## Infrastructure security in Launch Wizard<a name="infrastructure-security"></a>

As a managed service, Launch Wizard is protected by the AWS global network security procedures that are described in the [Amazon Web Services: Overview of Security Processes](https://d0.awsstatic.com/whitepapers/Security/AWS_Security_Whitepaper.pdf) whitepaper\.

## Resilience in Launch Wizard<a name="disaster-recovery-resiliency"></a>

The AWS global infrastructure is built around AWS Regions and Availability Zones\. Regions provide multiple physically separated and isolated Availability Zones, which are connected through low\-latency, high\-throughput, and highly redundant networking\. With Availability Zones, you can design and operate applications and databases that automatically fail over between Availability Zones without interruption\. Availability Zones are more highly available, fault tolerant, and scalable than traditional single or multiple data center infrastructures\.

For more information about AWS Regions and Availability Zones, see [AWS Global Infrastructure](http://aws.amazon.com/about-aws/global-infrastructure/)\.

AWS Launch Wizard sets up an application across multiple Availability Zones to ensure automatic failover between Availability Zones without interruption\. Availability Zones are more highly available, fault tolerant, and scalable than traditional single or multiple datacenter infrastructures\. 

## Data protection in Launch Wizard<a name="data-protection"></a>

AWS Launch Wizard \(Launch Wizard\) conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN Partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\.

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls within AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you do not put sensitive identifying information, such as your customers' account numbers, into free\-form fields or metadata, such as function names and tags\. Any data that you enter into metadata might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credential information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

## Identity and Access Management for AWS Launch Wizard<a name="identity-access-management"></a>

AWS Launch Wizard uses AWS managed policies to grant permissions to users and services\.

### AWS managed policies<a name="iam-policy-examples"></a>

**AmazonEC2RolePolicyForLaunchWizard**  
AWS Launch Wizard creates an IAM role with the name **AmazonEC2RoleForLaunchWizard ** in your account if the role already does not already exist in your account\. If the role exists, the role is attached to the instance profile for the Amazon EC2 instances that Launch Wizard will launch into your account\. This role is comprised of two IAM managed policies: **AmazonSSMManagedInstanceCore** and **AmazonEC2RolePolicyForLaunchWizard**\.

**AmazonSSMManagedInstanceCore**

 This policy enables AWS Systems Manager service core functionality on Amazon EC2\. For information, see [Create an IAM Instance Profile for Systems Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/setup-instance-profile.html)\.

**AmazonLaunchWizardFullaccess** This policy provides full access to AWS Launch Wizard through the AWS Management Console\. It also grants permissions to perform the following actions: 
+ Create and delete Amazon EC2 instances
+ Create and delete Amazon VPCs
+ Create and deleteSubnets
+ Create and delete CloudWatch Logs with specific tag keys
+ Create and delete Managed Active Directory
+ Read Service quota information
+ Push SNS notifications
+ Create and delete Systems Manager automations
+ Invoke SSM run commands
+ Create and delete AWS CloudFormation stacks
+ Grant IAM role\-related permissions with a specific role prefix

**AWSLambdaVPCAccessExecutionRole**  
This policy provides minimum permissions for a Lambda function to execute while accessing a resource within a VPC\. These permissions include create, describe, delete network interfaces, and write permissions to CloudWatch Logs\.

**AmazonLambdaRolePolicyForLaunchWizardSAP**  
This policy provides minimum permissions to enable SAP provisioning scenarios on Launch Wizard\. It allows invocation of Lambda functions to be able to perform certain actions, such as validation of route tables and perform pre\-configuration and configuration tasks for HA mode enabling\.

## Update management in Launch Wizard<a name="update-management"></a>

We recommend that you regularly patch, update, and secure the operating system and applications on your EC2 instances\. You can use [AWS Systems Manager Patch Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-patch.html) to automate the process of installing security\-related updates for both the operating system and applications\. Alternatively, you can use any automatic update services or recommended processes for installing updates that are provided by the application vendor\.