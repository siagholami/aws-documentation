# What is AWS Launch Wizard for SAP?<a name="what-is-launch-wizard-sap"></a>

AWS Launch Wizard for SAP is a service that guides you through the sizing, configuration, and deployment of SAP applications on AWS, and follows [AWS cloud application best practices](https://d1.awsstatic.com/whitepapers/AWS_Cloud_Best_Practices.pdf)\.

AWS Launch Wizard reduces the time it takes to deploy SAP applications on AWS\. You input your application requirements, including SAP HANA settings, SAP landscape settings, and deployment details on the service console, and Launch Wizard identifies the AWS resources to deploy and run your SAP application\. Launch Wizard provides an estimated cost of deployment, and you can modify your resources and instantly view the updated cost\. When you approve your settings, Launch Wizard provisions and configures the selected resources\. It then optionally installs an SAP HANA database to deploy and run SAP HANA and SAP Netweaver\-based applications\. For subsequent deployments, Launch Wizard creates custom AWS CloudFormation templates that can be reused and customized\.

After you deploy an SAP application, you can access it from the Amazon EC2 console\. You can manage your SAP applications with [AWS Systems Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/what-is-systems-manager.html)\.

**Topics**
+ [Supported deployments and features of AWS Launch Wizard](launch-wizard-sap-deployments.md)
+ [Components](launch-wizard-sap-components.md)
+ [Related services](related-services-sap.md)
+ [How AWS Launch Wizard for SAP works](how-launch-wizard-sap-works.md)