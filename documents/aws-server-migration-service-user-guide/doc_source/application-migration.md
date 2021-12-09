# Migrate applications using AWS SMS<a name="application-migration"></a>

AWS Server Migration Service supports the automated migration of multi\-server application stacks from your on\-premises data center to Amazon EC2\. Where server migration is accomplished by replicating a single server as an Amazon Machine Image \(AMI\), application migration replicates all of the servers in an application as AMIs and generates an AWS CloudFormation template to launch them in a coordinated fashion\.

Applications can be further subdivided into groups that allow you to launch tiers of servers in a defined order\. The following diagram provides a sample case of a database\-backed web application:

![\[Tiered launching of an application using groups.\]](http://docs.aws.amazon.com/server-migration-service/latest/userguide/images/app_migration.png)

In this example, the application is divided into four groups, each with three servers\. The AWS CloudFormation template starts the servers in the following order: databases, file servers, web servers, and application servers\.

After your servers are organized into applications and launch groups, you can specify a replication frequency, provide configuration scripts, and configure a target VPC in which to launch them\. When you launch an application, AWS SMS configures it based on the generated template\.

Application migration relies on the procedures for discovering on\-premises resources described in [Install the Server Migration Connector](SMS_setup.md)\. After you have imported a server catalog into AWS SMS using the Server Migration Connector, you can configure settings for applications, replication, and launch, as well as monitor migration status, in the **Applications** section of the AWS SMS console\. You can also perform these tasks using the resources for AWS SMS in the AWS SMS API, AWS CLI, or AWS SDKs\.

**Considerations**
+ You can replicate your on\-premises servers to AWS for up to 90 days per server\. Usage time is calculated from the time a server replication begins until you terminate the replication job\. After 90 days, your replication job is automatically terminated\. You can request an extension from AWS Support\.
+ During the AMI creation process, AWS SMS sets the `DeleteOnTermination` attribute for the root volume to false, overriding the default\. You can delete the root volume manually after you terminate the instance, or you can set the attribute to true so that Amazon EC2 deletes the root volume on instance termination\. For more information, see [Preserving Amazon EBS volumes on instance termination](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/terminating-instances.html#preserving-volumes-on-termination) in the *Amazon EC2 User Guide*\.
+ Application migration from Microsoft Azure environments is supported, but the Server Migration Connector for Azure does not currently guarantee the closeness of the server snapshots in the application\.

## Use application migration<a name="using-application-migration"></a>

You can perform the following tasks\.

**Topics**
+ [Create an application](#create-application)
+ [Configure replication settings](#configure-replication-settings)
+ [Configure launch settings](#configure-launch-settings)
+ [Start replication](#start-replication)
+ [Launch an application](#launch-application)
+ [Generate a CloudFormation template](#generate-cfn-template)

### Create an application<a name="create-application"></a>

**To create an application**

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. Choose **Applications**\. 

1. Choose **Create new application**\. 

1. On the **Application settings** page, provide the following information and then choose **Next**:
   + **Application name** — Specify a name for the application\.
   + **Application description** — Optionally, specify a description for the application\.
   + **Role name** — Choose **Allow automation role creation** to have AWS SMS create a service\-linked role on your behalf or **Use my own role** to specify an existing IAM role\. For more information, see [Service\-linked roles for AWS SMS](using-service-linked-roles.md)\. This option is not available if AWS SMS has already created the service\-linked role on your behalf\.

1. On the **Select servers** page, select the available servers to include in the application\. You can use the search bar to filter the table contents on specific values\. Choose **Next: Add servers to groups**\.

1. On the **Add servers to groups** page, you can create groups, delete groups, add selected servers from your application to groups, and remove servers from groups\. Ungrouped servers are associated with a default group\.

   Complete the following steps to add one or more servers to a new group:

   1. Select the servers to be added to the new group\.

   1. Choose **Add servers to group**\.

   1. Choose **Add to new group** and provide a name for the group\.

   1. Choose **Add**\. The list of servers now displays the associated group for each server that you selected\.

1. If you delete a group, the servers are associated with the default group\. To delete a group, complete the following steps:

   1. Choose **Delete group**\.

   1. For **Group to delete**, choose the group\.

   1. Choose **Delete**\.

1. On the **Add tags** page, optionally tag your applications\. A tag is a key/value pairs that propagates to all servers created when the application is launched\. Choose **Next**\.

1. On the **Review** page, edit your settings as needed\. When you are finished, choose **Create**\. From the status page, you can proceed directly to configure replication settings\.

### Configure replication settings<a name="configure-replication-settings"></a>

**To configure replication settings for an application**

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. Choose **Applications** to view the available applications\.

1. Select the name of the application\.

1. Choose **Actions**, **Configure replication settings**\.

1. On the **Replication settings** page, provide the following information and then choose **Next**:
   + **Replication job type** — Specify the replication period \(every 1\-24 hours\) or choose **One\-time migration**\.
   + **Start replication run** — Choose **Immediately** to schedule a replication run to start immediately or **At a later time and date** to start replication at the specified date and time, up to 30 days in the future\.
   + **Enable automatic AMI deletion** — To enable automatic AMI deletion, choose **Yes** and specify the maximum number of AMIs to keep \(from 1\-270\)\. To disable automatic AMI deletion, choose **No**\.
   + **Enable AMI encryption** — To enable AMI encryption, choose **Yes** and specify an encryption key \(using its key ID, Amazon Resource Name, or alias\) or leave blank to use the default key for EBS encryption\. To disable AMI encryption, choose **No**\.

1. The **Server\-specific settings** page displays the application servers and their group memberships\. You can edit the following server settings for individual servers or choose **Edit multiple servers** to update these settings across groups\. When you are finished, choose **Next**\.
   + **License type** — Choose **Auto**, **AWS**, or **BYOL**\.
   + **Quiesce** — \[VMware only\] Before taking a snapshot of the VM, halt data input/output and store the system memory state\.

1. On the **Review** page, verify the replication settings and choose **Save**\. From the status page, you can proceed directly to configure launch settings\.

### Configure launch settings<a name="configure-launch-settings"></a>

Before you can configure network settings, you must set up a virtual private cloud, subnet, and security group, as described for the [RunInstances](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_RunInstances.html) Amazon EC2 API action\.

**To configure launch settings for an application**

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. Choose **Applications** to view the available applications\.

1. Select the name of the application to configure and choose **Actions**, **Configure launch settings**\.

1. On the **Configure launch settings** page, provide the following information and then choose **Next**:
   + **IAM CloudFormation role** — Choose **Allow automation role creation** to have AWS SMS create a service\-linked role on your behalf or **Use my own role** to specify an existing IAM role\. For more information, see [Service\-linked roles for AWS SMS](using-service-linked-roles.md)\. This option is not available if AWS SMS has already created the service\-linked role on your behalf\.
   + **Automatically launch after replication** — Select this option to launch the application automatically after replication is complete\.
   + **Specify launch order** — Configure a launch order for your groups\.

1. On the **Configure target instance details** page, you can edit the following server settings for individual server or choose **Edit multiple servers** to update these settings across groups\. When you are finished, choose **Next**\.
   + **Logical ID** — Specify the AWS CloudFormation resource ID or leave the default value\. This parameter is used as the logical ID of the CloudFormation template that AWS SMS generates for the application\. For more information, see [Resources](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/resources-section-structure.html) in the *AWS CloudFormation User Guide*\.
   + **Instance type** — Select the EC2 instance type for the server\. This field is required\.
   + **Key pair** — Select the SSH key pair required to connect to the server\. This field is required\. If an IAM user does not have permission for `ec2:DescribeKeyPairs`, the list is empty\.
   + **Configuration script** — A configuration script, located in Amazon S3, to run when starting EC2 instances launched as part of an application\. The bucket must have the following prefix: `sms-app-`\.
   + **Script type** — Choose **Shell script** or **PowerShell script**\.

1. On the **Configure target network and security** page, you can edit the following server settings for individual servers or choose **Edit multiple servers** to update these settings across groups:
   + **VPC** — The virtual private cloud for the application\. This field is required\. If an IAM user does not have permission for `ec2:DescribeVpcs`, the list is empty\.
   + **Subnet** — The subnet for the application\. This field is required\. If an IAM user does not have permission for `ec2:DescribeSubnets`, the list is empty\.
   + **Security group** — The security group for the application\. This field is required\. If an IAM user does not have permission for `ec2:DescribeSecurityGroups`, the list is empty\.
   + **Publicly accessible** — Indicates whether the application should be accessible from the internet\.

   Choose **Application validation** to configure application validation or **Review** to skip to the final step of this procedure\.

1. \(Optional\) You can run validation scripts on your EC2 instances using AWS Systems Manager\. On the **Application validation** page, provide the following information, and then choose **Instance validation** to configure instance validation or **Review** to skip to the final step of this procedure:
   + **Validation name** — A name for the validation\.
   + **Validation script** — The location, in Amazon S3, of the validation script\. The bucket must have the following prefix: `sms-app-`\.
   + **Script type** — Choose **Shell script** or **PowerShell script**\.
   + **SSM managed instance** — The ID of the EC2 instance\. The instance must be managed by AWS Systems Manager and have the following tag: UserForSMSApplicationValidation=true\.
   + **Output location** — The location, in Amazon S3, for the output of the validation script\. The bucket must have the following prefix: `sms-app-`\.
   + **Execution command** — The command to run the script \(for example, \./script\.sh\)\.
   + **Timeout in minutes** — The maximum time needed to run the script \(from 1\-480\)\. The default is 15\.

1. \(Optional\) You can run a script when your EC2 instance first boots using Amazon EC2 user data\. On the **Instance validation** page, provide the following information, and then choose **Next**:
   + **Permissions** — To allow AWS SMS to get the validation script from Amazon S3 and run it on the instance using EC2 user data, you must create a role that grants AWS SMS the permissions from the **ServerMigrationServiceRoleForInstanceValidation** policy\. Choose **Create a new role with default role policy** to have AWS SMS create the role on your behalf \(IAM users must have administrator permissions\) or **Use an existing role** \(IAM users must have permission to pass a role to the `ec2.amazonaws.com` service\)\.
   + **Validation name** — A name for the validation\.
   + **Validation scripts** — The location, in Amazon S3, of the validation script\. The bucket must have the following prefix: `sms-app-`\.

1. On the **Review** page, verify the launch configuration settings and choose **Save**\.

### Start replication<a name="start-replication"></a>

**To start replicating an application**

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. Choose **Applications** to view the available applications\.

1. Choose the name of the application to replicate\.

1. On the application details page, choose **Actions**, **Start replication**\.

1. In the **Start replication** window, choose **Start**\. Replication can take anywhere from 30 minutes to several days depending on the disk size\. On the application details page, you can observe the status of the replication in the **Replication status** field\. If the replication fails, you may be able to find the reason in the **Replication status message** field\.

### Launch an application<a name="launch-application"></a>

**To launch an application**

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. Choose **Applications**\. On the **Applications** page, you can view the available applications\.

1. Choose the name of the application to launch\.

1. On the application details page, choose **Actions**, **Launch application**\. A replication job must complete before you perform this action\.

1. In the **Launch application** window, choose **Launch**\. On the application details page, you can observe the status of the launch in the **Launch status** field\. If the launch fails, you may be able to find the reason in the **Launch status message** field\.

### Generate a CloudFormation template<a name="generate-cfn-template"></a>

Use the following procedure if you want to examine the AWS CloudFormation template that is auto\-generated when you launch the application\.

**To generate an AWS CloudFormation template for the application**

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. Choose **Applications**\. On the **Applications** page, you can view the available applications\.

1. Choose the name of the application for which to create a template\.

1. On the application details page, choose **Actions**, **Generate template**\. A replication job must complete before you perform this action\.

1. In the **Generate template** window, choose **Generate**\.

## Import applications from Migration Hub<a name="migration-hub"></a>

Application Migration supports the import and migration of applications discovered by AWS Migration Hub\.

**To import applications from Migration Hub**

1. To enable application catalog import, complete the [AWS Server Migration Service \(SMS\)](https://docs.aws.amazon.com/migrationhub/latest/ug/new-customer-setup.html#sms-managed) instructions in the Migration Hub user guide\.
**Note**  
Taking this action exports the SMS server catalog and makes it visible on Migration Hub\.

1. In the SMS console, on the **Applications** page, choose **Import applications**\.

1. In the **Import applications** window, you can optionally provide a value in the **Role name** field\. If no role name is specified, the default role name *sms* is used\. Choose **Import**\.
**Note**  
SMS imports application\-related servers from Migration Hub only if they exist in the SMS Server Catalog and are not part of an existing SMS application\. As a result, some applications may be only partially imported\. 

1. After import completes, the applications imported from Migration Hub appear in the **Applications** table\. Imported applications can be migrated but cannot be edited in SMS\. They can, however, be edited in Migration Hub\. After editing, re\-import\.
**Note**  
An application cannot be re\-imported if it is being actively replicated or launched by SMS\. If this conflict occurs, stop the replication or launch and re\-import\.