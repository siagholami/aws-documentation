# What Is AWS Launch Wizard for SQL Server?<a name="what-is-launch-wizard"></a>

AWS Launch Wizard is a service that guides you through the sizing, configuration, and deployment of Microsoft SQL Server Always On applications on AWS, which follow [AWS cloud application best practices](https://d1.awsstatic.com/whitepapers/AWS_Cloud_Best_Practices.pdf)\.

AWS Launch Wizard reduces the time it takes to deploy SQL Server high availability solution to the cloud\. You input your application requirements, including performance, number of nodes, and connectivity on the service console, and AWS Launch Wizard identifies the right AWS resources to deploy and run your SQL Server Always On application\. AWS Launch Wizard provides an estimated cost of deployment, and gives you the ability to modify your resources and instantly view the updated cost assessment\. When you approve, AWS Launch Wizard provisions and configures the selected resources in a few hours to create a fully\-functioning production\-ready SQL Server Always On application\. It also creates custom AWS CloudFormation templates, which can be reused and customized for subsequent deployments\.

Once deployed, your SQL Server Always On application is ready to use and can be accessed on the EC2 console\. You can manage your SQL Server Always On application with [AWS Systems Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/what-is-systems-manager.html)\.

**Topics**
+ [Supported operating systems and SQL versions](#launch-wizard-os)
+ [Features of AWS Launch Wizard](launch-wizard-features.md)
+ [Components](launch-wizard-components.md)
+ [Related services](related-services.md)
+ [How AWS Launch Wizard works](how-launch-wizard-works.md)
+ [Deployment options](launch-wizard-deployment-options.md)

## Supported operating systems and SQL versions<a name="launch-wizard-os"></a>

AWS Launch Wizard supports the following operating systems and SQL Server versions:
+ Windows Server 2019/2016/2012 R2
+ Enterprise and Standard Editions of Microsoft SQL Server 2019/2017/2016