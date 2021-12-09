--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Autostarting Amazon EC2 Instances with Launch Templates<a name="ec2-autostart"></a>

You can automatically start your Amazon EC2 instances on your AWS Snowball Edge device using launch templates and Snowball client launch configuration commands\. 

A *launch template* contains the configuration information necessary to create an Amazon EC2 instance on your Snowball Edge\. You can use a launch template to store launch parameters so you don't have to specify them every time that you start an EC2 instance on your Snowball Edge\.

When you use autostart configurations on your Snowball Edge, you configure the parameters that you want your Amazon EC2 instance to start with\. After your Snowball Edge is configured, when you reboot and unlock it, it uses your autostart configuration to launch an instance with the parameters that you specified\. If an instance that you launched using an autostart configuration is stopped, the instance starts running when you unlock your device\.

**Note**  
After you first configure an autostart configuration, restart your device to launch it\. All subsequent instance launches \(after planned or unplanned reboots\) happen automatically after your device is unlocked\.

A launch template can specify the Amazon Machine Image \(AMI\) ID, instance type, user data, security groups, and tags for an Amazon EC2 instance when you launch that instance\.

To automatically launch EC2 instances on your Snowball Edge, take the following steps:

1. When you order your AWS Snowball Edge device, create a job with compute instances\. For more information, see [Creating a Job with Compute Instances](create-ec2-edge-job.md)\.

1. After receiving your Snowball Edge, unlock it\.

1. Use the EC2 API command `aws ec2 create-launch-template` to create a launch template\.

1. Use the Snowball client command `snowballEdge create-autostart-configuration` to bind your EC2 launch template to your network configuration\. For more information, see [Creating a Launch Configuration to Autostart Amazon EC2 Instances](using-ec2-edge-client.md#ec2-edge-create-autostart-config)\. 

1. Reboot, then unlock your device\. Your EC2 instances are automatically started using the attributes specified in your launch template and your Snowball client command `create-autostart-configuration`\.

To view the status of your running instances, use the EC2 API command `describe-autostart-configurations`\.

**Note**  
There is no console or job management API for AWS Snowball support for launch templates\. You use EC2 and Snowball client CLI commands to automatically start EC2 instances on your AWS Snowball Edge device\.