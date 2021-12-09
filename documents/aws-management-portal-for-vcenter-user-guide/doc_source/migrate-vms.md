# Migrating Your Virtual Machine to Amazon EC2 Using AWS Connector for vCenter<a name="migrate-vms"></a>

You can launch an EC2 instance from a virtual machine that you migrate from VMware vCenter to Amazon EC2\. You'll use the AWS Connector for vCenter to migrate your virtual machines to Amazon EC2\.

The following diagram illustrates the migration process\. When you request a migration, we create a conversion task\. When the conversion task completes successfully, your imported instance is available\.

![\[Migrating a VM to Amazon EC2\]](http://docs.aws.amazon.com/amp/latest/userguide/images/import.png)

To migrate from vCenter 6\.5, to specify the BYOL license type during migration, or to use incremental migration, use AWS Server Migration Service instead\. For more information, see the [AWS SMS User Guide](http://docs.aws.amazon.com/server-migration-service/latest/userguide/)\.

**Topics**
+ [Prerequisites](#migrate-prerequisites)
+ [Limitations](#migrate-limitations)
+ [VM Import Authorization](#authorize-vmimport)
+ [Migrating Your Virtual Machine](#migrate-vm)
+ [Backing Up Your Instance](#back-up-instance)
+ [Exporting a Migrated EC2 Instance](#export-instance)
+ [Troubleshooting Migration](#troubleshooting-migration)

## Prerequisites<a name="migrate-prerequisites"></a>
+ An administrator must install and configure the connector\. The connector is part of AWS Management Portal for vCenter\. For more information, see [Setting Up AWS Management Portal for vCenter](setting-up.md)\.
+ An administrator must create at least one environment and grant you permission to migrate a virtual machine into one or more environments\. This environment is in addition to the default environment and must be explicitly created\. For more information, see [Managing Environments](administer-resources.md#manage-environments)\.
+ Ensure that your VM uses one of the supported operating systems and that you select one of the supported instance types\. For more information, see [VM Import/Export Prerequisites](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/VMImportPrerequisites.html) in the *Amazon EC2 User Guide*\.
+ Attach the `VMImportExportRoleForAWSConnector` policy to the **vmimport** role that you created per [VM Import Service Role](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/VMImportPrerequisites.html#vmimport-service-role) in the *Amazon EC2 User Guide*\.
+ Ensure that your VM does not have a disk whose compressed size is greater than 215 GB\.

## Limitations<a name="migrate-limitations"></a>
+ Review [VM Import/Export Requirements and Limitations](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/VMImportPrerequisites.html#vmimport-limitations) in the *Amazon EC2 User Guide*\.
+ Amazon EC2 limits the number of active migrations to 5 per region\. If the connector is already in the process of migrating 4 virtual machines, it queues any additional migration tasks until one of the active migration tasks completes successfully or is canceled\.

## VM Import Authorization<a name="authorize-vmimport"></a>

Your users don't have direct access to AWS\. The following diagram describes the process by which a user can migrate a VM to Amazon EC2\.

![\[The VM Import authorization process\]](http://docs.aws.amazon.com/amp/latest/userguide/images/vmimport_architecture.png)

1. The vSphere client authorizes import to the environment\.

1. The management portal verifies that the user has permission to migrate VMs to the environment and returns a token\.

1. The vSphere client sends an import request to the connector along with the token\.

1. The connector verifies the token\.

1. The connector verifies that the user has permission to export the VM\.

1. The connector starts the migration\.

1. The connector sends a response to the vSphere client with the import task ID\.

## Migrating Your Virtual Machine<a name="migrate-vm"></a>

To migrate a VM to Amazon EC2, use vCenter with the connector\. The connector can migrate up to four VMs concurrently\.

**Warning**  
You can't create a migration task while the connector is updating\.

**To migrate your virtual machine to Amazon EC2**

1. From vCenter, click **Home** and then click **VMs and Templates**\.

1. Select the VM\.

1. Right\-click the VM, and then click **Migrate VM to EC2**\. If your administrator did not grant you permission to migrate VMs, you'll see a message to ask your administrator to grant you permission\.

1. Complete the form as follows:

   1. Select the operating system running on the VM\.

   1. Select the region and environment for the resulting EC2 instance\. The list of environments contains only the environments to which your administrator has granted you permission\.

   1. Select a subnet, instance type, and security group for the instance\.

   1. \(Optional\) Enter a private IP address\. If you don't specify a private IP address, we'll select one for you\.

   1. Select a security group\. The list of security groups contains only the security groups associated with the environment you've selected\.

   1. Click **Begin migration to Amazon EC2**\.

   1. \[Prior to connector 2\.4\.0\] If the connector displays a warning that there are already four active migration tasks and that this will affect the speed of these tasks, you can either continue or cancel the migration task\.

1. After the migration begins, we display the import task ID if the migration task started immediately or the queued task ID otherwise\. Note the ID if you want to monitor the migration task\. Otherwise, you can close the import window and your vSphere client after the connector notifies you that the import task was created or queued, and the migration will continue\.

1. \(Optional\) To monitor the status of the migration, do the following:

   1. From vCenter, click **Home** and then click **AWS Management Portal**\.

   1. Expand the region for the instance, select the environment, and then click the **VM\-to\-EC2 Migrations** tab\.

   1. Find the entry with the import task ID or queued task ID that you noted earlier\. The ID of the instance is shown in the **Instance ID** field\.

1. To start the EC2 instance after the migration has completed, expand the environment, expand **Imported Instances**, select the instance, and then click the **Summary** tab\. The ID of the instance should be the instance ID that you noted from the **VM\-to\-EC2 Migrations** tab\. On the **Getting Started** tab, click **Start instance**\.

## Backing Up Your Instance<a name="back-up-instance"></a>

After you start an instance, it runs until it is terminated\. If your instance is terminated, you can't connect to or recover the instance\. To ensure that you can start a new instance with the same software as an migrated instance if needed, create an Amazon Machine Image \(AMI\) from the instance, and then create a template that specifies the AMI\.

To create an AMI, you must use the Amazon EC2 console or command line tools\. For information about creating an AMI using Amazon EC2, see the following topics in the *Amazon EC2 User Guide*\.


| Platform | Root Volume | Topic | 
| --- | --- | --- | 
|  Linux  |  EBS  |  [Creating an Amazon EBS\-Backed Linux AMI](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami-ebs.html)  | 
|  Linux  |  instance store  |  [Creating an Instance Store\-Backed Linux AMI](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami-instance-store.html)  | 
|  Windows  |  EBS  |  [Creating an Amazon EBS\-Backed Windows AMI](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/Creating_EBSbacked_WinAMI.html)  | 
|  Windows  |  instance store  |  [Creating an Instance Store\-Backed Windows AMI](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/Creating_InstanceStoreBacked_WinAMI.html)  | 

For information about creating a template so that you can launch instances from the AMI that you've created from your migrated instance, see [Managing Templates](manage-instances.md#manage-templates)\.

## Exporting a Migrated EC2 Instance<a name="export-instance"></a>

To export an EC2 instance that you previously migrated from a VM, use the management portal in vCenter\. The process for exporting an instance creates an OVA file and stores it in an Amazon S3 bucket in your AWS account\.

If you have not previously exported an EC2 instance using vCenter, you must first specify the name that we will use for the S3 buckets that we create for instance export\. AWS creates one S3 bucket in each region for this purpose, with a name that follows the form `export-to-s3-`*name*`-`*region*\.

**Requirements**
+ You must be an administrator of the management portal to export an EC2 instance\.
+ You can configure instance export using the AWS credentials of either an administrator or an IAM user\. To allow an IAM user to complete these steps, verify that the user has the permissions described in [Creating the Required Accounts and Users](install-option-connector.md#connector-accounts-fp)\.

**Limits**
+ There is a limit of five concurrent export tasks per region\.
+ You can't export an instance that is currently being exported\.

**To prepare for instance export**

1. Open the AWS Management Portal for vCenter [setup console](https://amp.aws.amazon.com/VCPlugin.html#setup)\.

1. On the **AWS Management Portal for vCenter** page, click **Configure Instance Export**, and then click **Create New**\.

1. On the **Configure Instance Export** page, do the following:

   1. Complete the bucket name in **S3 bucket names** as prompted\.

   1. Click **I agree that AWS Management Portal for vCenter may do the following on my behalf**\.

   1. Click **Create**\.

**To export a migrated instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Getting Started** tab, click **Export instance to S3**\.

1. In the **Export instance to S3** dialog box, enter a name for the OVA file in **S3 object file prefix** and then click **Export**\.

   After the export begins, we display the export task ID\. Note this ID if you want to monitor the status of the export task\.

1. \(Optional\) To monitor the status of the export process, select the environment for the instance and then click the **EC2\-to\-S3 Migrations** tab\. This tab displays all instance export tasks from the last seven days\. Find the task with the export task ID that you noted earlier\. If you need to cancel the export task while it is in progress, right\-click the row, click **Cancel Export Task**, and click **Continue** when prompted for confirmation\.

1. To access the OVA file after the export process has completed, do the following:

   1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

   1. From the navigation bar, select the region that contains the EC2 instance that you exported\. The OVA file is stored in an S3 bucket in the same region as the EC2 instance\.

   1. From the **Buckets** pane, select the bucket for your exported instances \(`export-to-s3-`*name*`-`*region*\) and then select the OVA file\.

   1. Click **Actions** and then click **Download**\. Follow the directions to complete the download\.

Alternatively, you can export an EC2 instance using the Amazon EC2 CLI instead of using the connector\. For more information, see [Exporting Amazon EC2 Instances](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ExportingEC2Instances.html) in the *Amazon EC2 User Guide*\.

## Troubleshooting Migration<a name="troubleshooting-migration"></a>

<a name="import-service-role"></a>**Error: Additional permissions are required to migrate multidisk virtual machines**

When migrating a virtual machine, you receive the error "To migrate a virtual machine with more than one disk, log into the management portal setup page and grant the additional permissions required by the VM Import/Export service\."

Use the following procedure to grant the required permissions:

1. Open the AWS Management Portal for vCenter [setup console](https://amp.aws.amazon.com/VCPlugin.html#setup)\.

1. If you see an error message indicating that your Import service role is missing, click **Fix Error**\.

1. \(Optional\) Click **View Policy** to review the policy for the import service role\.

1. Click **I agree that AWS Management Portal for vCenter may create the above roles on my behalf**\.

1. Click **Save**\.

**Error: Connector is unable to reach ESX host**

You receive the following error when migrating a virtual machine: "Connector is unable to reach ESX host \[*hostname*\] to migrate virtual machine \[*name*\]"\.

If the hostname specified in the error message is not the fully\-qualified domain name of an ESX host, use the following procedure to configure the DNS suffix search list so that connector can append the suffix and resolve the ESX hostname:

1. Locate the connector VM in the vSphere client, right\-click it, and select **Open Console**\.

1. Log in as ec2\-user\. For more information, see [Logging into the Virtual Machine Console](manage-connector.md#access-virtual-machine-console)\.

1. Run the sudo setup\.rb command\. This command displays the following menu:

   ```
   Choose one of the following options
   1. Reset password
   2. Reconfigure network settings
   3. Restart services
   4. Factory reset
   5. Delete unused upgrade-related files
   6. Enable/disable SSL certificate validation
   7. Display connector's SSL certificate
   8. Generate log bundle
   9. Exit
   Please enter your option [1-9]:
   ```

1. Type `2`, and then press Enter\. The command displays the following menu:

   ```
   Reconfigure your network:
   1. Renew or acquire a DHCP lease
   2. Set up a static IP
   3. Set up a web proxy for AWS communication
   4. Set up a DNS suffix search list
   5. Exit
   Please enter your option [1-5]:
   ```

1. Type `4`, and then press Enter\. The command displays the current DNS suffix search list\. Follow the directions to update the search list to include the domain name of the ESX host from the error message\.

**Connector can't validate the certificates of the host**

By default, the connector validates the certificates of all entities that it communicates with over HTTPS, including vCenter and ESXi servers\. This is essential to prevent man\-in\-the\-middle attacks\. However, if you are migrating a virtual machine from ESX version 4\.1 or earlier to Amazon EC2, the connector can't validate the certificates of the host, so the migration fails\.

To work around this problem, you can do one of the following:
+ **Option 1**: Update to ESX 5\.0 or later\.
+ **Option 2**: Disable ESX certificate validation, migrate the virtual machine, and then re\-enable ESX certificate validation as follows:

  1. From your web browser, open the connector management console \(https://*ip\_address*/, where *ip\_address* is the IP address of the management console\) and log in using your password\.

  1. Click **Register the Connector**\.

  1. On the **Register Plugin** page, under **ESX SSL certificate options**, click **Ignore any ESX certificate errors**, and then click **Register**\.
**Important**  
We recommend that you keep ESX certificate validation enabled unless you are migrating virtual machines from ESX 4\.1 or earlier\.

  1. When you have finished migrating the virtual machine, return to the **Register Plugin** page of the connector management console, click **Trust vCenter to validate ESX certificates**, and then click **Register**\.