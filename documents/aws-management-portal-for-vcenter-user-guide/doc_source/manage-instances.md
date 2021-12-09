# Managing EC2 Instances Using AWS Management Portal for vCenter<a name="manage-instances"></a>

You can launch an EC2 instance using the management portal\. First, create a template from an environment set up by an administrator, then deploy the instance from the template\. You can view, stop, start, and terminate the instance\. Note that your ability to complete these tasks depends on the permissions granted to you by your administrator\.

![\[Deploying an instance from a template\]](http://docs.aws.amazon.com/amp/latest/userguide/images/user_tasks.png)

**Topics**
+ [Viewing Regions](#view-regions)
+ [Viewing an Environment](#view-environment)
+ [Managing Key Pairs](#import-key-pair)
+ [Managing Templates](#manage-templates)
+ [Deploying an EC2 Instance](#deploy-instance)
+ [Viewing an EC2 Instance](#view-instance)
+ [Connecting to an EC2 Instance](#connect-to-instance)
+ [Stopping and Starting an EC2 Instance](#stop-start-instance)
+ [Rebooting an EC2 Instance](#reboot-instance)
+ [Creating an Image from an EC2 Instance](#create-image)
+ [Terminating an EC2 Instance](#terminate-instance)

## Viewing Regions<a name="view-regions"></a>

The first time that you log in to the management portal, you are asked to select the regions to display in the dashboard\. You can update the regions displayed in the dashboard at any time\. For example, if you don't have AWS resources in some regions, you can exclude them from the dashboard\. If later on you need to create resources in a region that's not displayed, you can include it in the dashboard\.

**To select the regions to display**

1. From the menu in the upper\-right corner, select **Region Preferences**\.

1. Choose the regions to display\.

1. Click **Save**\.

## Viewing an Environment<a name="view-environment"></a>

Your AWS resources are organized and managed using environments\. The permissions that you've been granted by your administrator determine whether you can view an environment, along with its templates and instances\. 

**To view an environment**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region for the environment, and then select the environment\.

1. To display information about the environment, click the **Summary** tab\.

1. To list the instances deployed using the templates of this environment, click the **Instances** tab\.

## Managing Key Pairs<a name="import-key-pair"></a>

Amazon EC2 uses public\-key cryptography to encrypt and decrypt login information for your instance\. Public\-key cryptography uses a public key to encrypt a piece of data, such as a password, then the recipient uses the private key to decrypt the data\. The public and private keys are known as a *key pair*\.

To connect to your instance, you must create a key pair, import the public key to the environment for the instance, and select it when you create the template from which you'll deploy the instance\. You'll use the private key when you connect to the instance that you launch using this template\.

The permissions that you've been granted by your administrator determine whether you can import a key pair\.

**To import a key pair**

1. Create an RSA key pair using a tool like ssh\-keygen\. Save the public key to a local file, and the private key to a different local file with the `.pem` extension\. For more information, see [Amazon EC2 Key Pairs](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html) in the *Amazon EC2 User Guide*\.

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region for the environment, and then select the environment\.

1. Click the **Key Pairs** tab\.

1. Right\-click in the unused space in the tab and select **Import Key Pair**\.

1. In the **Import Key Pair** dialog box, click **Browse**\. Select the public key file that you created in step 1 and then click **Import**\.

When you no longer need to deploy instances using a key pair, or if you lose the private key, you can delete the public key that you imported\. The permissions that you've been granted by your administrator determine whether you can delete a key pair\.

**To delete a key pair**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region for the environment, and then select the environment\.

1. Click the **Key Pairs** tab\.

1. Right\-click the key pair and select **Delete Key Pair**\.

1. When prompted to confirm, click **Yes**\.

## Managing Templates<a name="manage-templates"></a>

A template specifies the information that Amazon EC2 requires when configuring an instance\. The permissions that you've been granted by your administrator determine whether you can create a template\.

**To create a template**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand a region for the template, and then select the environment for the template\.

1. On the **Getting Started** tab, click **Create a template**\. If this task isn't listed, your administrator didn't grant you permission to create templates in this environment\.

1. Enter a name for the template in **Name**\.

1. By default, the Quick Start AMIs, a selection of popular AMIs, are displayed\. To filter by platform, click **Windows** or **Linux**\. To use a specific AMI, select **Search by AMI ID** from **AMIs from**, type the ID of the AMI, and then click **Load**\.

   Note that the root device for a Linux AMI is either an Amazon EBS volume or an instance store volume\. For more information about how the root device type affects the instance, see [Storage for the Root Device](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ComponentsAMIs.html#storage-for-the-root-device) in the *Amazon EC2 User Guide*\.

1. Select an AMI and then click **Next**\.

1. Select an instance type from **Instance Type**\. Note that this list includes only the instance types supported by the selected region\.

1. \(Optional\) If you'd like to connect to your instance, select **Associate Public IP Address**\.

1. Select a subnet and then click **Next**\.

1. \(Optional\) Review the storage devices specified by the AMI\. To add a new storage device to the list, click **Add**\. In the **Add Volume** dialog box, select a volume type, a device name, and either a volume size or a snapshot, and then click **Add**\.

1. When you are finished adding volumes, click **Next**\.

1. Select one or more security groups, and then click **Next**\.

1. Click **Select one of your existing key pairs**, select a key pair from the list, and then click **Finish**\. If the list is empty, there are no imported key pairs for this environment\. For more information, see [Managing Key Pairs](#import-key-pair)\.

You can create a new template by starting with an existing one\.

**To copy and update a template**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region and the environment for the template, and then select the template\.

1. On the **Getting Started** tab, click **Copy to a new template**\. If this task isn't listed, your administrator didn't grant you permission to create templates in this environment\.

1. Click **Next** to review each page\. When you have finished making changes to the new template, click **Finish**\.

You can delete a template only after you terminate all instances that were launched using the template\. For more information, see [Terminating an EC2 Instance](#terminate-instance)\. The permissions that you've been granted by your administrator determine whether you can delete a template\.

**To delete a template**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region and the environment for the template, and then select the template\.

1. On the **Getting Started** tab, click **Delete the template**\. If this task isn't listed, your administrator didn't grant you permission to delete templates in this environment\.

1. In the **Delete Template** dialog box, click **Yes**\.

## Deploying an EC2 Instance<a name="deploy-instance"></a>

You deploy an EC2 instance into a subnet using a template\. The permissions that you've been granted by your administrator determine whether you can deploy an EC2 instance\.

**To deploy an EC2 instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region and the environment for the instance, and then select the template\.

1. On the **Getting Started** tab, click **Deploy an instance**\. If this task isn't listed, your administrator didn't grant you permission to deploy instances in this environment\.

1. Enter a name for the instance in **Name**\.

1. \(Optional\) Specify one or more tags for your instance\. For each tag, click **Add**, type the tag key, and type the tag value\.

1. When you are finished adding tags, click **Next**\.

1. Select a subnet for the instance to run in and then click **Next**\. Note that the subnet list includes only the subnets for the selected template\.

1. Review the configuration for your instance\. To make changes, click **Back**\. When you are ready to deploy the instance, click **Finish**\.

## Viewing an EC2 Instance<a name="view-instance"></a>

You can describe one or more EC2 instances\. The permissions that you've been granted by your administrator determine whether you can describe EC2 instances\.

**To view an EC2 instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region for the instance, and then select an environment\.

1. To display information about the instances deployed using the templates of this environment, click the **Instances** tab\. Note that this tab also contains any instances that you migrated from a VM\.

1. Select a template\. To display information about the instances deployed using this template, click the **Instances** tab\.

1. Expand a template that you've used to deploy instances, and then select an instance\.

1. To display information about the instance, click the **Summary** tab\. To display performance data for the instance, click the **Performance** tab\.

## Connecting to an EC2 Instance<a name="connect-to-instance"></a>

You can log in to an EC2 instance if you have the private key \(`.pem` file\) of the key pair associated with the template that you used to launch the instance\. If you need to connect to your instance, but there isn't a key pair associated with the template, you must terminate the instance, create \(or ask your administrator to create\) a new template \(selecting a key pair in the process\), and launch a new instance from the new template\.

The tool that you'll use to connect to your instance depends on whether the instance is a Windows instance or a Linux instance\.

**To connect to an EC2 Windows instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Summary** tab, locate the public DNS name\. You'll need this information to connect to your instance\.

1. On the **Summary** tab, click **Get Windows Password**\. Follow the directions to get the password for the Administrator account for your instance, using the private key of the key pair for the template that you used to launch the instance\. You'll need this password to connect to your instance\.

1. Connect to the instance using an RDP client\. Specify the public DNS name for the instance as the computer name and specify Administrator as the user name\. When prompted for credentials, use the password that you got in the previous step\.

   If you can't connect to the instance successfully, see [Troubleshooting Windows Instances](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/troubleshooting-windows-instances.html) in the *Amazon EC2 User Guide for Windows Instances*\.

**To connect to an EC2 Linux instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Summary** tab, locate the public DNS name\. You'll need this information to connect to your instance\.

1. Connect to the instance using PuTTY\. For more information, see [Connect to Linux Instances Using PuTTY](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/putty.html) in the *Amazon EC2 User Guide for Linux Instances*\.

## Stopping and Starting an EC2 Instance<a name="stop-start-instance"></a>

You can stop and start an instance only if it has an Amazon EBS volume as its root device\. If you stop and start an instance, you'll lose any data on the instance store volumes for the instance\.

The permissions that you've been granted by your administrator determine whether you can stop and start an EC2 instance\.

**To stop and start an EC2 instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Getting Started** tab, click **Stop the instance**\. If this task isn't listed, your administrator didn't grant you permission to stop instances in this environment\.

1. When you are ready for the instance to run again, select the instance and click **Start the instance**\.

## Rebooting an EC2 Instance<a name="reboot-instance"></a>

An instance reboot is equivalent to an operating system reboot\. In most cases, it takes only a few minutes to reboot your instance\. 

The permissions that you've been granted by your administrator determine whether you can reboot an EC2 instance\.

**To reboot an EC2 instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Getting Started** tab, click **Reboot the instance**\. If this task isn't listed, your administrator didn't grant you permission to reboot instances in this environment\.

## Creating an Image from an EC2 Instance<a name="create-image"></a>

You can create an Amazon Machine Image \(AMI\) from an Amazon EBS\-backed instance as follows\.

**To create an Amazon EBS\-backed image**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Getting Started** tab, click **Create image**\. If this task isn't listed, your administrator didn't grant you permission to create images in this environment\.

1. In the **Create image** dialog box, do the following:

   1. Specify a name and description for the image\.

   1. \(Optional\) To include additional volumes, click **Add New Volume**, and select the volume type and device name\. For EBS volumes, you must also specify a volume size or a snapshot\.

   1. Click **Create**\.

## Terminating an EC2 Instance<a name="terminate-instance"></a>

When you've decided that you no longer need an instance, you can terminate it\. After you terminate an instance, you can't connect to or recover the instance\. For more information about the difference between stopping and terminating an instance, see [Instance Lifecycle](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html) in the *Amazon EC2 User Guide*\.

The permissions that you've been granted by your administrator determine whether you can terminate an EC2 instance\.

**To terminate an EC2 instance**

1. From vCenter, click **Home** and then click **AWS Management Portal**\.

1. From the dashboard, expand the region, the environment, and the template for the instance\.

1. Select the instance\.

1. On the **Getting Started** tab, click **Terminate the instance**\. If this task isn't listed, your administrator didn't grant you permission to terminate instances in this environment\.