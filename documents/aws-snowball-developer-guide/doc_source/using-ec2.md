--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using Amazon EC2 Compute Instances<a name="using-ec2"></a>

This topic provides an overview of using Amazon EC2 compute instances on an AWS Snowball Edge device, including conceptual information, procedures, and examples\.

**Note**  
These features are not supported in the Asia Pacific \(Mumbai\) AWS Region\.

## Overview<a name="ec2-overview-edge"></a>

You can run Amazon EC2 compute instances hosted on a Snowball Edge with the `sbe1`, `sbe-c`, and `sbe-g` instance types\. The `sbe1` instance type works on devices with the Snowball Edge Storage Optimized option\. The `sbe-c` instance type works on devices with the Snowball Edge Compute Optimized option\. Both the `sbe-c` and `sbe-g` instance types work on devices with the Snowball Edge Compute Optimized with GPU option\.

All three compute instance types supported for use on Snowball Edge device options are unique to Snowball Edge devices\. Like their cloud\-based counterparts, these instances require Amazon Machine Images \(AMIs\) to launch\. You choose the AMI to be that base image for an instance in the cloud, before you create your Snowball Edge job\.

To use a compute instance on a Snowball Edge, create a job and specify your AMIs\. You can do this from the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2), with the AWS CLI, or with one of the AWS SDKs\. Typically, there are some housekeeping prerequisites that you must perform before creating your job, to use your instances\.

After your device arrives, you can start managing your AMIs and instances\. You can manage your compute instances on a Snowball Edge through an Amazon EC2–compatible endpoint\. This type of endpoint supports many of the Amazon EC2 CLI commands and actions for the AWS SDKs\. You can't use the AWS Management Console on the Snowball Edge to manage your AMIs and compute instances\.

When you're done with your device, return it to AWS\. If the device was used in an import job, the data transferred using the Amazon S3 Adapter for Snowball or the file interface is imported into Amazon S3\. Otherwise, we perform a complete erasure of the device when it is returned to AWS\. This erasure follows the National Institute of Standards and Technology \(NIST\) 800\-88 standards\.

**Important**  
Using encrypted AMIs on Snowball Edge devices is not supported\.
Data in compute instances running on a Snowball Edge isn't imported into AWS\.

### Compute Instances on Clusters<a name="ec2-overview-cluster"></a>

You can use compute instances on clusters of Snowball Edge devices\. The procedures and guidance for doing so are the same as for using compute instances on a standalone device\.

When you create a cluster job with AMIs, a copy of each AMI exists on each node in the cluster\. For that reason, there can only be 10 AMIs associated with a cluster of devices, regardless of the number of nodes on the cluster\. When you launch an instance in a cluster, you declare the node to host the instance in your command, and the instance runs on a single node\.

Clusters must be either compute optimized or storage optimized\. You can have a cluster of compute optimized nodes, and some number of them can have GPUs\. You can have a cluster made entirely of storage optimized nodes\. A cluster can't be made of a combination of compute optimized nodes and storage optimized nodes\.

### Pricing for Compute Instances on Snowball Edge<a name="pricing-for-ec2-edge"></a>

There are additional costs associated with using compute instances\. For more information, see [AWS Snowball Edge Pricing](http://aws.amazon.com/snowball-edge/pricing)\.

## Prerequisites<a name="ec2-edge-prereqs"></a>

Before creating your job, keep the following information in mind:
+ Before you add any AMIs to your job creation request, make sure that you have an AMI created in your AWS account of the supported image type\. Currently, supported AMIs are based on the [CentOS 7 \(x86\_64\) \- with Updates HVM](https://aws.amazon.com/marketplace/pp/B00O7WM7QW), [Ubuntu Server 14\.04 LTS \(HVM\)](https://aws.amazon.com/marketplace/pp/B00JV9TBA6), and [Ubuntu 16\.04 LTS \- Xenial \(HVM\)](https://aws.amazon.com/marketplace/pp/B01JBL2M0O) images\. You can get any one of these images from the [AWS Marketplace](https://aws.amazon.com/marketplace)\.
+ All AMIs must be based on Amazon Elastic Block Store \(Amazon EBS\), with a single volume\.
+ If you are planning connecting to a compute instance running on a Snowball Edge, you must use Secure Shell \(SSH\)\. To do so, you first add the key pair\. For more information, see [Configure an AMI to Use SSH to Connect to Compute Instances Launched on the Device](create-ec2-edge-job.md#important-create-ec2-edge-job)\.

**Important**  
For AWS services to work properly on a Snowball Edge, you must allow the ports for the services\. For details, see [Ports Required to Use AWS Services on an AWS Snowball Edge Device](port-requirements.md)\.