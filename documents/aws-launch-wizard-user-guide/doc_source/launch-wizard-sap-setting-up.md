# Setting up for AWS Launch Wizard for SAP<a name="launch-wizard-sap-setting-up"></a>

This section describes the prerequisites that you must verify to deploy an SAP application with AWS Launch Wizard\. 

## General prerequisites<a name="launch-wizard-sap-prerequisites"></a>

The following general prerequisites must be met to deploy an application with Launch Wizard\.
+ You must create an Amazon VPC that consists of private subnet\(s\) in a minimum of two Availability Zones\. The subnets must have outbound internet access\. For more information on how to create and set up a VPC, see [Getting Started with Amazon VPC](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-getting-started.html) in the *Amazon VPC User Guide*\.
+ You must create an IAM user and attach the **AmazonLaunchWizardFullaccess** policy\. See the [following sections](#launch-wizard-sap-iam) for the steps to attach the policy to the IAM user\.
+ If you want to install an SAP HANA database, you must download the software from the SAP Software Download page and upload it to an Amazon S3 bucket\. For steps on how to download the software and upload it to an Amazon S3 bucket, see [Making SAP HANA software available for AWS Launch Wizard to deploy HANA databaseMaking SAP HANA software available for Launch Wizard ](launch-wizard-sap-structure.md)\.
+ Depending on the operating system version you want to use for the SAP deployment, an SAP Marketplace subscription may be required\. For a complete list of supported operating system versions, see [Supported operating system versions for SAP deployments](launch-wizard-sap-ascs-support-os.md)\.

## AWS Identity and Access Management \(IAM\)<a name="launch-wizard-sap-iam"></a>

Establishing the AWS Identity and Access Management \(IAM\) role and setting up the IAM user for permissions are typically performed by **an IAM administrator** for your organization\. The steps are as follows: 
+ A one\-time creation of IAM roles that Launch Wizard uses to deploy SAP systems on AWS\.
+ The creation of IAM users who can grant permission for Launch Wizard to deploy applications\.

### One\-time creation of IAM role<a name="launch-wizard-sap-iam-role"></a>

On the **Choose Application** page of Launch Wizard, under **Permissions**, Launch Wizard displays the IAM roles required for Launch Wizard to access other AWS services on your behalf\. These roles are **AmazonEC2RoleForLaunchWizard** and **AmazonLambdaRoleForLaunchWizard**\. Select **Next**, and Launch Wizard attempts to discover the IAM roles in your account\. If either role does not exist in your account, Launch Wizard attempts to create the roles with the same names, **AmazonEC2RoleForLaunchWizard** and **AmazonLambdaRoleForLaunchWizard**\. 

The **AmazonEC2RoleForLaunchWizard** role is comprised of two IAM managed policies: **AmazonSSMManagedInstanceCore** and **AmazonEC2RolePolicyForLaunchWizard**\. The **AmazonLambdaRoleForLaunchWizard** is also comprised of two IAM managed policies: **AWSLambdaVPCAccessExecutionRole** and **AmazonLambdaRolePolicyForLaunchWizardSAP**\. The **AmazonEC2RoleForLaunchWizard** role is used by the instance profile for the Amazon EC2 instances that Launch Wizard launches into your account as part of the deployment\. The **AmazonLambdaRoleForLaunchWizard** role is used by the Lambda function invoked by the service in your account to perform certain deployment\-related actions, such as validation of route tables, and preconfiguration and configuration tasks for HA mode enabling\. 

After the IAM roles are created, the IAM administrator can either continue with the deployment process or optionally delegate the application deployment process to another IAM user, as described in the following section\. At this point in the IAM set up process, the IAM administrator can exit the Launch Wizard service\. 

### Creating and enabling IAM users to use Launch Wizard<a name="launch-wizard-iam-user-setup"></a>

To deploy an SAP system with Launch Wizard, the user must be assigned the **AmazonLaunchWizardFullaccess** policy\. The following steps guide the IAM administrator through the process of attaching an IAM policy to an IAM user to grant that user permission to access and deploy applications from Launch Wizard\. 

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam)\.

1. In the left navigation pane, choose **Policies**\.

1. Choose **Users**\.

1. Select the check box for the **User name** to attach the policy\.

1. Choose **Add permissions**\.

1. Choose **Attach existing policies directly**\.

1. Search for the policy named **AmazonLaunchWizardFullaccess** and select the check box to the left of the policy name\.

1. Choose **Next: Review**\.

1. Verify that the correct policy is listed, and then choose **Add permissions**\.

**Important**  
You must log in with the user associated with this IAM policy when you use Launch Wizard\.