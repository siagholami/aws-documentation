--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using Block Storage With Your Amazon EC2 Instances<a name="edge-ebs"></a>

Block Storage on Snowball Edge enables you to add or remove block storage based on the needs of your applications\. Volumes that are attached to an Amazon EC2 instance are exposed as storage volumes that persist independently from the life of the instance\. You can manage block storage using the familiar Amazon EBS API\.

Certain Amazon EBS commands are supported by using the EC2 endpoint\. Supported commands include `attach-volume`, `create-volume`, `delete-volume`, `detach-volume`, and `describe-volumes`\. For more information on these commands, see [List of Supported Amazon EC2 AWS CLI Commands on a Snowball Edge](using-ec2-endpoint.md#list-cli-commands-ec2-edge)\.

**Important**  
Make sure to unmount any file systems on the device within your operating system before detaching the volume\. Failure to do so can potentially result in data loss\.

Following, you can find Amazon EBS volume quotas and differences between Amazon EBS volumes on your device and Amazon EBS volumes in the cloud:
+ Amazon EBS volumes are only available to EC2 instances running on the device hosting the volumes\.
+ Volume types are limited to either capacity\-optimized HDD \(`sbg1`\) or >performance\-optimized SSD \(`sbp1`\)\. The default volume type is `sbg1`\.
+ Snowball Edge shares HDD memory between Amazon S3 objects and Amazon EBS\. If you use HDD\-based block storage on Snowball Edge, that will reduce the amount of memory available for Amazon S3 objects\. Likewise, Amazon S3 objects will reduce the amount of memory available for Amazon EBS block storage on HDD volumes\.
+ Amazon EC2 root volumes always use the IDE driver\. Additional Amazon EBS volumes will preferentially use the Virtio driver if available\. If the Virtio driver isn't available, SBE will default to the IDE driver\. The Virtio driver allows for better performance and is recommended\.
+ When creating Amazon EBS volumes, the `encrypted` parameter isn't supported\. However, all data on your device is encrypted by default\. \.
+ Volumes can be from 1 GB to 10 TB in size\.
+ Up to 10 Amazon EBS volumes can be attached to a single EC2 instance\.
+ There is no formal limit to the number of Amazon EBS volumes you can have on your AWS Snowball Edge device\. However, total Amazon EBS volume capacity is limited by the available space on your device\.