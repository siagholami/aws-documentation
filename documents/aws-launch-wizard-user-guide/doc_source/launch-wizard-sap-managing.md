# Managing application resources with AWS Launch Wizard for SAP<a name="launch-wizard-sap-managing"></a>

After you have deployed an SAP application, you can manage and update it by following these steps\.

**Manage deployments**

1. From the left navigation pane, choose **SAP**\.

1. Under the**Deployments** tab, select the check box next to the application that you want to manage, and then choose **Actions**\. You can do the following:

   1. **Manage resources on the EC2 console**\. You are redirected to the Amazon EC2 console, where you can view and manage your SAP application resources, such as Amazon EC2, Amazon EBS, Amazon VPC, Subnets, NAT Gateways, and Elastic IPs\. 

   1. **View resource group with Systems Manager**\. In the Systems Manager console, you can manage your application with built\-in integrations through resource groups\. Launch Wizard automatically tags your deployment with resource groups\. When you access Systems Manager through Launch Wizard, the resources are automatically filtered for you based on your resource group\. You can manage, patch, and maintain your applications in Systems Manager\.

   1. **View CloudWatch application logs\. **

   1. **View CloudFormation template\. **

1. To delete a deployment, select the application that you want to delete, and select **Delete**\. You are prompted to confirm the deletion\.
**Important**  
When you delete a deployment, Launch Wizard attempts to delete only the AWS resources it created in your account as part of the deployment\. Launch Wizard considers certain resources, such as security groups, infrastructure configuration templates created during a deployment, and EFS file systems created for a transport directory, as shared resources between multiple deployments\. Shared resources are not deleted when you delete a deployment\.

1. For more information about your application resources, choose the **Application name**\. You can then view the **Deployment events** and **Summary** details for your application using the tabs at the top of the page\.

**Delete infrastructure configuration**

1. From the left navigation pane, choose **SAP**\.

1. Under the**Saved infrastructure configurations** tab, select the configuration name you want to delete, and then choose **Delete**\. You are prompted to confirm the deletion\. 
**Important**  
When you delete an infrastructure configuration, it will not be available for future deployments\. Resources created from the configuration, such as VPCs, availability groups, subnets, and key pair names are not deleted\. 

1. For more information about an infrastructure configuration, choose the **Configuration name**\. 