# Managing application resources with AWS Launch Wizard for SQL Server<a name="launch-wizard-managing"></a>

After your SQL Server Always On application is deployed, you can manage it by following these steps\.

1. From the navigation pane, choose **Deployments**\.

1. From the **Deployments** page, select **Actions**\. You can select to do the following:

   1. **Manage resources on the EC2 console**\. You are taken to the Amazon EC2 console, where you can view and manage your SQL Server Always On application resources\. For example, you can view and manage EC2, Amazon EBS, Active Directory, Amazon VPC, Subnets, NAT Gateways, and Elastic IPs\. 

   1. **Access SQL Server using RDGW instance**\. Connect to SQL Server via Remote Desktop Protocol\. For more information, see [Connecting to your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.htm) in the *User Guide for Windows Instances*\.

   1. **View resource group with SSM**\. You are taken to the Systems Manager console to view your resource groups\.

   1. **View SSM deployment template**\. You are taken to the Systems Manager console to view your documents\.

   1. **View CloudWatch application Logs**\. You are taken to CloudWatch Logs, where you can monitor, store, and access your SQL Server Always On application log files\. 

   1. **View your CloudFormation template**\. This is the CloudFormation template created by your most recent deployment, and it can be accessed through the CloudFormation console\. For help with finding and using your CloudFormation template, see [Viewing AWS CloudFormation Stack Data and Resources on the AWS Management Console](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-console-view-stack-data-resources.html)\.

   1. If you have not set up monitoring for your application on CloudWatch Application Insights, you have the option to **Set up monitoring on CloudWatch Application Insights**\. You are taken to the CloudWatch Application Insights console to set up monitoring for your application\. 

      If you have set up monitoring for your application on CloudWatch Application Insights, you can **View insights on Amazon CloudWatch**\. You are taken to the application monitoring dashboards on the CloudWatch Application Insights console\.

1. To delete a deployment, select the application that you want to delete and select **Delete**\. You are prompted to confirm your action\.
**Important**  
You lose all specification settings for the SQL Server Always On application when you delete a deployment\. Launch Wizard attempts to delete only the AWS resources that it created in your account as part of the deployment\. If you created resources outside of Launch Wizard, for example resources that reside in a VPC created by Launch Wizard, the deletion may fail\. Launch Wizard does not delete any Active Directory objects in your Active Directory, nor any of the records in your DNS server\. Launch Wizard has no control over your Active Directory domain user password over time, which is required to clean up Active Directory objects or DNS records\. We recommend that you remove these entries from your Active Directory after Launch Wizard deletes the deployment\. For key operations performed against your Active Directory resulting in new records or entries, see [AWS Managed Active Directory](launch-wizard-setting-up.md#launch-wizard-ad-managed)\.

1. To drill down into details regarding your SQL Server Always On application resources, select the **Application name**\. You can then view the **Deployment events** and **Summary** details for your application by using the tabs at the top of the page\.