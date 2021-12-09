# Amazon Inspector assessment targets<a name="inspector_applications"></a>

You can use Amazon Inspector to evaluate whether your AWS assessment targets \(your collections of AWS resources\) have potential security issues that you should address\. 

**Important**  
Currently, your assessment targets can consist only of EC2 instances that run on supported operating systems\. For information about supported operating systems and supported AWS Regions, see [Amazon Inspector supported operating systems and Regions](inspector_supported_os_regions.md)\. 

**Note**  
For information about launching EC2 instances, see the [ Amazon Elastic Compute Cloud documentation](https://aws.amazon.com/documentation/ec2/)\. 

**Topics**
+ [Tagging resources to create an assessment target](#tagging)
+ [Amazon Inspector assessment target limits](#inspector-application-limits)
+ [Creating an assessment target](#create_application_via_console)
+ [Deleting an assessment target](#delete_assessment_target_via_console)

## Tagging resources to create an assessment target<a name="tagging"></a>

To create an assessment target for Amazon Inspector to assess, you start by tagging the EC2 instances that you want to include in your target\. Tags are words or phrases that act as metadata for identifying and organizing your instances and other AWS resources\. Amazon Inspector uses the tags that you create to identify the instances that belong to your target\. 

Every AWS tag consists of a key and value pair of your choice\. For example, you might choose to name your key "Name" and your value "MyFirstInstance"\. After you tag your instances, you use the Amazon Inspector console to add the instances to your assessment target\. It is not necessary that any instance match more than one tag key\-value pair\.

When you tag your EC2 instances to build assessment targets, you can create your own custom tag keys or use tag keys created by others in the same AWS account\. You can also use the tag keys that AWS automatically creates\. For example, AWS automatically creates a **Name** tag key for the EC2 instances that you launch\.

You can add tags to EC2 instances when you create them, or you can add, change, or remove those tags one at a time on the console page for each EC2 instance\. You can also add tags to multiple EC2 instances at once using the Tag Editor\.

For more information, see [ Tag Editor](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/tag-editor.html)\. For more information about tagging EC2 instances, see [Resources and Tags](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_Resources.html)\.

## Amazon Inspector assessment target limits<a name="inspector-application-limits"></a>

You can create up to 50 assessment targets per AWS account\. For more information, see [Amazon Inspector service limits](inspector_limits.md)\. 

## Creating an assessment target<a name="create_application_via_console"></a>

 You can use the Amazon Inspector console to create assessment targets\.

**To create an assessment target**

1. Sign in to the AWS Management Console and open the Amazon Inspector console at [https://console\.aws\.amazon\.com/inspector/](https://console.aws.amazon.com/inspector/)\.

1. In the navigation pane, choose **Assessment Targets**, and then choose **Create**\.

1. For **Name**, enter a name for your assessment target\.

1. Do one of the following:
   + To include all EC2 instances in this AWS account and Region in this assessment target, select the **All instances** check box\.
**Note**  
The limit on the maximum number of agents that you can include in an assessment run applies when you use this option\. For more information, see [Amazon Inspector service limits](inspector_limits.md)\.
   + To choose the EC2 instances that you want to include in this assessment target, for **Use Tags**, enter the tag key names and key\-value pairs\.

1. \(Optional\) While creating a target, you can select the **Install Agents** check box to install the agent on all EC2 instances in this target\. To use this option, your EC2 instances must have the SSM Agent installed and an IAM role that allows Run Command\. The SSM Agent is installed, by default, on Amazon EC2 Windows instances and Amazon Linux instances\. Amazon EC2 Systems Manager requires an IAM role for EC2 instances that process commands and a separate role for users that execute commands\. For more information, see [Installing and Configuring SSM Agent](http://docs.aws.amazon.com/systems-manager/latest/userguide/ssm-agent.html) and [Configuring Security Roles for System Manager](http://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-access.html)\. 
**Important**  
If an EC2 instance already has an agent running on it, using this option replaces the agent currently running on the instance with the latest agent version\.
**Note**  
For your existing assessment targets, you can choose the **Install Agents with Run Command button** to install the agent on all EC2 instances in this target\.
**Note**  
You can also install the agent on multiple EC2 instances \(both Linux\-based and Windows\-based instances with the same command\) remotely by using the Systems Manager Run Command\. For more information, see [Installing the Amazon Inspector Agent on Multiple EC2 Instances Using the Systems Manager Run Command](inspector_installing-uninstalling-agents.md#install-run-command)\. 

1. Choose **Save**\.

**Note**  
You can use the **Preview Target** button on the **Assessment Targets** page to review all EC2 instances included in the assessment target\. For each EC2 instance, you can review the hostname, instance ID, IP address, and, if applicable, the status of the agent\. The agent status can have the following values: **HEALTHY**, **UNHEALTHY**, and **UNKNOWN**\. Amazon Inspector displays an **UNKNOWN** status when it can't determine whether there is an agent running on the EC2 instance\.

## Deleting an assessment target<a name="delete_assessment_target_via_console"></a>

To delete an assessment target, perform the following procedure\.

**To delete an assessment target**
+ On the **Assessment targets** page, choose the target that you want to delete, and then choose **Delete**\. When prompted for confirmation, choose **Yes**\.
**Important**  
When you delete an assessment target, all assessment templates, assessment runs, findings, and versions of the reports that are associated with the target are also deleted\.

You can also delete an assessment target by using the [https://docs.aws.amazon.com/inspector/latest/APIReference/API_DeleteAssessmentTarget.html](https://docs.aws.amazon.com/inspector/latest/APIReference/API_DeleteAssessmentTarget.html) API\. 