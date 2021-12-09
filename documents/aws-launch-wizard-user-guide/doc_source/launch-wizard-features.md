# Features of AWS Launch Wizard<a name="launch-wizard-features"></a>

**Topics**
+ [Simple application deployment](#launch-wizard-features-app-deployment)
+ [AWS resource selection](#launch-wizard-features-resource-selection)
+ [Cost estimation](#launch-wizard-features-cost)
+ [Reusable code templates](#launch-wizard-features-code-templates)
+ [SNS notification](#launch-wizard-features-sns)
+ [Always On Availability Groups \(SQL Server\)](#launch-wizard-features-allways-on)
+ [Early input validation](#launch-wizard-features-input-validation)
+ [Application resource groups for easy discoverability](#launch-wizard-features-resource-groups)
+ [One\-click monitoring](#launch-wizard-features-application-insights)

## Simple application deployment<a name="launch-wizard-features-app-deployment"></a>

AWS Launch Wizard makes it easy for you to deploy third\-party applications on AWS, such as Microsoft SQL Server\. When you input the application requirements, AWS Launch Wizard deploys the necessary AWS resources for a production\-ready application\. This means that you do not have to manage separate infrastructure pieces or spend time provisioning and configuring your SQL Server Always On application\. 

## AWS resource selection<a name="launch-wizard-features-resource-selection"></a>

Launch Wizard considers performance, memory, bandwidth, and other application features to determine the best instance type, EBS volumes, and other resources for your SQL Server Always On application\. You can modify the recommended defaults\. 

## Cost estimation<a name="launch-wizard-features-cost"></a>

Launch Wizard provides a cost estimate for the complete deployment that is itemized for each individual resource being deployed\. The estimated cost automatically updates each time you change a resource type configuration in the wizard\. However, note that the provided estimates are only for general comparisons\. They are based on On\-Demand costs and actual costs may be lower\.

## Reusable code templates<a name="launch-wizard-features-code-templates"></a>

Launch Wizard creates a CloudFormation stack that can be reused to customize and replicate your infrastructure in multiple environments\. Code in the template helps you provision resources\. You can access and use the templates created by your Launch Wizard deployment from the CloudFormation console\. For more information about CloudFormation stacks, see [Working With Stacks](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacks.html)\.

## SNS notification<a name="launch-wizard-features-sns"></a>

You can provide an [ SNS topic](https://docs.aws.amazon.com/sns/latest/dg/welcome.html) that allows Launch Wizard to send you notifications and alerts about the status of a deployment\.

## Always On Availability Groups \(SQL Server\)<a name="launch-wizard-features-allways-on"></a>

Always On Availability Groups \(AOAG\) is a Microsoft SQL Server feature that is supported by the AWS SQL Server installation\. AOAG augments the availability of a set of user databases\. An availability group supports a failover environment for a discrete set of user databases, known as availability databases\. If one of these databases fails, another database takes over its workload with no impact on availability\. Always On Availability improves database availability, enabling more efficient resource usage\. For more information about the concepts and benefits of Always On Availability, see [ Always On Availability Groups \(SQL Server\)](https://docs.microsoft.com/en-us/sql/database-engine/availability-groups/windows/always-on-availability-groups-sql-server?view=sql-server-2017)\.

## Early input validation<a name="launch-wizard-features-input-validation"></a>

You can leverage your existing infrastructure \(such as VPC or Active Directory\) with Launch Wizard\. This may lead to deployment failures if your existing infrastructure does not meet certain deployment prerequisites\. For example, for a SQL Server Always On deployment in your existing VPC, the VPC must have at least one public subnet and two private subnets\. It also must have outbound connectivity to Amazon S3, Systems Manager, and AWS CloudFormation service endpoints\. If these requirements are not met, the deployment will fail\. This failure can take more than an hour to detect if you are in a later stage of the deployment\. Launch Wizard's validation framework detects these types of issues early in the application deployment process by verifying key application and infrastructure specifications before provisioning\. Verification takes approximately 15 minutes\. You can then take appropriate actions to adjust your VPC configuration\. Launch Wizard performs the following infrastructure validations:
+ Resource limits at the AWS account level: 
  + VPC 
  + Internet gateway 
  + Number of CloudFormation stacks
+ Additionally, Launch Wizard performs the following application\-specific verifications:
  + Active Directory credentials
  + Public subnet outbound connectivity
  + Private subnet outbound connectivity
  + Custom Windows AMI:
    + SQL Server installed and running on instance
    + Compliant versions of Windows and SQL Server

**Note**  
Some validations, for example for valid Active Directory credentials, require Application Wizard to launch a t2\.large EC2 instance in your account for a few minutes\. After it runs the necessary validations, Launch Wizard terminates the instance\.

## Application resource groups for easy discoverability<a name="launch-wizard-features-resource-groups"></a>

Launch Wizard creates a resource group for all of the AWS resources created for your SQL Server Always On application\. You can manage the resources through the EC2 console or with Systems Manager\. When you access Systems Manager through Launch Wizard, the resources are automatically filtered for you based on your resource group\. You can manage, patch, and maintain your SQL Server Always On applications in Systems Manager\.

## One\-click monitoring<a name="launch-wizard-features-application-insights"></a>

Launch Wizard integrates with [CloudWatch Application Insights](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/cloudwatch-application-insights.html) to provide a one\-click monitoring setup experience for deploying SQL Server HA workloads on AWS\. When you select the option to set up monitoring and insights with Application Insights on the Launch Wizard console, Application Insights automatically sets up relevant metrics, logs, and alarms on CloudWatch, and starts monitoring newly deployed workloads\. You can view automated insights and detected problems, along with the health of your SQL Server HA workloads, on the CloudWatch console\.