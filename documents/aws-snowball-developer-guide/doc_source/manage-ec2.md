--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using Amazon EC2 Compute Instances Locally<a name="manage-ec2"></a>

You can use AWS OpsHub to run pre\-installed software on virtual servers \(instances\) locally on your device, and also to manage Amazon EC2 instances on your device\. 

**Topics**
+ [Launching an EC2 Instance](#launch-instance)
+ [Stopping an EC2 Instance](#stop-instance)
+ [Starting an EC2 Instance](#start-instance)
+ [Terminating an EC2 Instance](#terminate-instance)
+ [Using Storage Volumes Locally](#manage-ebs-volumes)

## Launching an EC2 Instance<a name="launch-instance"></a>

Follow these steps to launch an Amazon EC2 instance using AWS OpsHub\.

**To launch an Amazon EC2 instance**

1. Open the AWS OpsHub application\.

1. In the **Start computing** section on the dashboard, choose **Get started**\. Or, choose the **Services** menu at the top, and then choose **Compute \(EC2\)** to open the **Compute** page\. All your compute resources appear in the **Resources** section\.

1. If you have Amazon EC2 instances running on your device, they appear in the **Instance name** column under **Instances**\. You can see details of each instance on this page\.

1. Choose **Launch instance**\. The launch instance wizard opens\.

1. For **Device**, choose the Snow device that you want to launch the EC2 instance on\. 

1. For **Image \(AMI\)**, choose an Amazon Machine Image \(AMI\) from the list\. This AMI is used to launch your instance\.

1. For **Instance type**, choose one from the list\.

1. Choose how you want to attach an IP address to the instance\. You have the following options:
   + **Create public IP address \(VNI\)**—choose this option to create a new IP address using a physical network interface\. Choose a physical network interface and IP address assignment\.
   + **Use existing IP address \(VNI\)**—choose this option to use an existing IP address and then use existing virtual network interfaces\. Choose a physical network interface and a virtual network interface\.
   + **Do not attach IP address**—choose this option if you don't want to attach an IP address\. 

1. Choose **Launch**\. You should see your instance launching in the **Compute instances** section\. The **State** is **Pending** and then changes to **Running** when done\.

## Stopping an EC2 Instance<a name="stop-instance"></a>

Use the following steps to use AWS OpsHub to stop an Amazon EC2 instance\.

**To stop an EC2 instance**

1. Open the AWS OpsHub application\.

1. In the **Start computing** section of the dashboard, choose **Get started**\. Or, choose the **Services** menu at the top, and then choose **Compute \(EC2\)** to open the **Compute** page\. 

   All your compute resources appear in the **Resources** section\.

1. If you have Amazon EC2 instances running on your device, they appear in the **Instance name** column under **Instances**\.

1. Choose the instance that you want to stop, and choose **Stop**\. The **State** changes to **Stopping**, and then to **Stopped** when done\.

## Starting an EC2 Instance<a name="start-instance"></a>

Use these steps to start an Amazon EC2 instance using AWS OpsHub\.

**To start an EC2 instance**

1. Open the AWS OpsHub application\.

1. In the **Start computing** section of the dashboard, choose **Get started**\. Or, choose the **Services** menu at the top, and then choose **Compute \(EC2\)** to open the **Compute** page\. 

   Your compute resources appear in the **Resources** section\.

1. In the **Instance name** column, under **Instances**, find the instance that you want to start\.

1. Choose the instance, and then choose **Start**\. The **State** changes to **Pending**, and then changes to **Running** when done\.

## Terminating an EC2 Instance<a name="terminate-instance"></a>

After you terminate an Amazon EC2 instance, you can't restart the instance\.

**To terminate an EC2 instance**

1. Open the AWS OpsHub application\.

1. In the **Start computing** section on the dashboard, choose **Get started**\. Or, choose the **Services** menu at the top, and then choose **Compute \(EC2\)** to open the **Compute** page\. You can see all your compute resources in the **Resources** section\.

1. In the **Instance name** column, under **Instances**, find the instance that you want to terminate\.

1. Choose the instance, and choose **Terminate**\. The **State** changes to **Terminating**, and then to **Terminated** when done\. 

   After the instance is terminated, you can't restart it\.

## Using Storage Volumes Locally<a name="manage-ebs-volumes"></a>

Amazon EC2 instances use Amazon EBS volumes for storage\. In this procedure, you create a storage volume and attach it to your instance using AWS OpsHub\.

**To create a storage volume**

1. Open the AWS OpsHub application\.

1. In the **Start computing** section on the dashboard, choose **Get started**\. Or, choose the **Services** menu at the top, and then choose **Compute \(EC2\)** to open the **Compute** page\. 

1. Choose the **Storage volumes** tab\. If you have storage volumes on your device, the details about the volumes appear under **Storage volumes**\.

1. Choose **Create volume** to open the **Create volume** page\.

1. Choose the device that you want to create the volume on, enter the size \(in GiBs\) that you want to create, and choose the type of volume\.

1. Choose **Submit**\. The **State** is **Creating**, and changes to **Available** when done\. You can see your volume and details about it in the **Volumes** tab\.

**To attach a storage volume to your instance**

1. Choose the volume that you created, and then choose **Attach volume**\.

1. For **Compute instance Id**, choose the instance you want to attach the volume to\.

1. For **Volume Device Name**, enter the device name of your volume \(for example, **/dev/sdh** or **xvdh**\)\.

1. Choose **Attach**\.

If you no longer need the volume, you can detach it from the instance and then delete it\.