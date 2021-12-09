# Related services<a name="related-services-sap"></a>

The following AWS services are used when you deploy an SAP application with AWS Launch Wizard\.

**Topics**
+ [AWS CloudFormation](#launch-wizard-sap-related-services-cloudformation)
+ [Amazon Virtual Private Cloud security groups](#launch-wizard-sap-related-services-vpc)
+ [Amazon Elastic File System](#launch-wizard-sap-related-services-efs)
+ [Amazon EC2 Systems Manager](#launch-wizard-sap-related-services-SSM)
+ [Amazon Simple Notification Service \(SNS\)](#launch-wizard-related-services-sns)
+ [Amazon Route 53](#launch-wizard-related-services-route53)

## AWS CloudFormation<a name="launch-wizard-sap-related-services-cloudformation"></a>

[AWS CloudFormation ](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/Welcome.html) is a service that helps you model and set up your AWS resources, and lets you spend more time focusing on your applications that run in AWS\. You create a template that describes all of the AWS resources that you want \(for example, Amazon EC2 instances or Amazon RDS DB instances\), and AWS CloudFormation takes care of provisioning and configuring those resources for you\. With AWS Launch Wizard for SAP, you don’t need to build AWS CloudFormation templates to deploy your application\. Instead, AWS Launch Wizard combines infrastructure provisioning and application configuration \(code that runs on EC2 instances to configure the application\) into a unified AWS CloudFormation template\. The AWS CloudFormation template is then invoked by AWS Launch Wizard’s backend service to provision an application in your account\.

## Amazon Virtual Private Cloud security groups<a name="launch-wizard-sap-related-services-vpc"></a>

[Amazon Virtual Private Cloud security groups](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html) act as a virtual firewall for your instance to control inbound and outbound traffic\. When you launch an instance in a VPC, you can assign up to five security groups to the instances\. AWS Launch Wizard displays the security groups that will be assigned to the EC2 instances that run the SAP applications\. This allows the components to communicate\.

## Amazon Elastic File System<a name="launch-wizard-sap-related-services-efs"></a>

[Amazon EFS](https://docs.aws.amazon.com//efs/latest/ug/whatisefs.htm) provides file storage in the AWS Cloud\. With Amazon EFS, you can create a file system, mount the file system on an Amazon EC2 instance, and then read and write data to and from your file system\. For more information, see [Amazon Elastic File System setup for transport directory](how-launch-wizard-sap-works.md#launch-wizard-sap-efs)\.

## Amazon EC2 Systems Manager<a name="launch-wizard-sap-related-services-SSM"></a>

[Amazon EC2 Systems Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/what-is-systems-manager.html) is an AWS service that you can use to view and control your infrastructure on AWS\. Using the Amazon EC2 Systems Manager console, you can view operational data from multiple AWS services and automate operational tasks across your AWS resources\. SSM helps you maintain security and compliance by scanning your managed instances and reporting on, or taking corrective action on, any policy violations that it detects\.

## Amazon Simple Notification Service \(SNS\)<a name="launch-wizard-related-services-sns"></a>

[Amazon Simple Notification Service \(SNS\)](https://docs.aws.amazon.com/sns/latest/dg/welcome.html) is a highly available, durable, secure, fully managed pub/sub messaging service that provides topics for high\-throughput, push\-based, many\-to\-many messaging\. Using Amazon SNS topics, your publisher systems can fan out messages to a large number of subscriber endpoints and send notifications to end users using mobile push, SMS, and email\. You can use SNS topics for your Launch Wizard deployments to stay up\-to\-date on deployment progress\. For more information, see the [https://docs.aws.amazon.com/sns/latest/dg/welcome.html](https://docs.aws.amazon.com/sns/latest/dg/welcome.html)\.

## Amazon Route 53<a name="launch-wizard-related-services-route53"></a>

[Amazon Route 53](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/Welcome.html) is a highly available and scalable Domain Name System \(DNS\) web service\. You can use Route 53 to perform three main functions in any combination: domain registration, DNS routing, and health checking\. Launch Wizard integrates with Route 53 hosted zones, which are containers for records\. The records contain information about how you want to route traffic for a specific domain, such as example\.com, and its subdomains \(acme\.example\.com, zenith\.example\.com\)\. There are two types of hosted zones: public and private hosted zones\. We recommend that you use private hosted zones for SAP applications unless an application must be directly accessible from the internet\. 