--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using AWS OpsHub for Snow Family to Manage Devices<a name="aws-opshub"></a>

The Snow Family Devices now offer a user\-friendly tool, AWS OpsHub for Snow Family, that you can use to manage your devices and local AWS services\. You use AWS OpsHub on a client computer to perform tasks such as unlocking and configuring single or clustered devices, transferring files, and launching and managing instances running on Snow Family Devices\. You can use AWS OpsHub to manage both the Storage Optimized and Compute Optimized device types and the Snow device\. The AWS OpsHub application is available at no additional cost to you\.

AWS OpsHub takes all the existing operations available in the Snowball API and presents them as a simple graphical user interface\. This interface helps you quickly and easily migrate data to the AWS Cloud and deploy edge computing applications on Snow Family Devices\. 

AWS OpsHub provides a unified view of AWS services that are running on Snow Family Devices and automates operational tasks through AWS Systems Manager\. With AWS OpsHub, users with different levels of technical expertise can easily manage a large number of Snow Family Devices\. With just a few clicks, you can unlock devices, transfer files, manage Amazon EC2 instances, and monitor device metrics\.

When your Snow device arrives at your site, you download, install, and launch the AWS OpsHub application on a client machine, such as a laptop\. After installation, you can unlock the device and start managing it and using supported AWS services locally\. AWS OpsHub provides a dashboard that summarizes key metrics such as storage capacity and active instances on your device\. It also provides a selection of the AWS services that are supported on the Snow Family Devices\. Within minutes, you can begin transferring files to the device\.

**Topics**
+ [Unlocking a Device](connect-unlock-device.md)
+ [Managing AWS Services on Your Device](manage-services.md)
+ [Managing Your Devices](manage-device.md)
+ [Automating Your Management Tasks](automate-task.md)