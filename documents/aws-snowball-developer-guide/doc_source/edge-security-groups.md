--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Security Groups in Snowball Edge Devices<a name="edge-security-groups"></a>

A *security group *acts as a virtual firewall that controls the traffic for one or more instances\. When you launch an instance, you associate one or more security groups with the instance\. You can add rules to each security group to allow traffic to or from its associated instances\. For more information, see [Amazon EC2 Security Groups for Linux Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html) in the Amazon EC2 User Guide for Linux Instances\.

Security groups in Snowball Edge devices are similar to security groups in the AWS Cloud\. Virtual private clouds \(VPCs\) aren't supported on Snowball Edge devices\.

Following, you can find the other differences between Snowball Edge security groups and EC2\-VPC security groups:
+ Each Snowball Edge has a limit of 50 security groups\.
+ The default security group allows all inbound and outbound traffic\.
+ Traffic between local instances can use either the private instance IP address or a public IP address\. For example, suppose that you want to connect using SSH from instance A to instance B\. In this case, your target IP address can be either the public IP or private IP address of instance B, if the security group rule allows the traffic\.
+ Only the parameters listed for AWS CLI actions and API calls are supported\. These typically are a subset of those supported in EC2\-VPC instances\.

For more information on supported AWS CLI actions, see [List of Supported Amazon EC2 AWS CLI Commands on a Snowball Edge](using-ec2-endpoint.md#list-cli-commands-ec2-edge)\. For more information on supported API operations, see [Supported Amazon EC2 API Operations](using-ec2-endpoint.md#using-ec2-adapter-supported-api)\.