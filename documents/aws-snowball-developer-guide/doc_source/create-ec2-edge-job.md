--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Creating a Job with Compute Instances<a name="create-ec2-edge-job"></a>

In this section, you create your first compute instance job\.

**Important**  
Be aware of the following points before you create your job:  
Make sure that the vCPU, memory, and storage values associated with your AMI match the type of instance that you want to create\.
If you're going to use SSH to connect to the instance *after* you launch the instance on your Snowball Edge, you must first perform the following procedure\. You can't update the AMIs on your Snowball Edge after the fact\. You must do this step before creating the job\.

## Configure an AMI to Use SSH to Connect to Compute Instances Launched on the Device<a name="important-create-ec2-edge-job"></a>

To use Secure Shell \(SSH\) to connect to your compute instances on Snowball Edge devices, you must perform the following procedure\. This procedure adds the SSH key to the AMI before creating your job\. We also recommend that you use this procedure to set up your applications on the instance that you plan to use as the AMI for your job\.

**Important**  
If you don't follow this procedure, you can't connect to your instances with SSH when you receive your Snowball Edge device\.

**To put an SSH key into an AMI**

1. Launch a new instance in the AWS Cloud based on the [CentOS 7 \(x86\_64\) \- with Updates HVM](https://aws.amazon.com/marketplace/pp/B00O7WM7QW), [Ubuntu Server 14\.04 LTS \(HVM\)](https://aws.amazon.com/marketplace/pp/B00JV9TBA6), or [Ubuntu 16\.04 LTS \- Xenial \(HVM\)](https://aws.amazon.com/marketplace/pp/B01JBL2M0O) image\.

   When you launch your instance, make sure that the storage size that you assign to the instance is appropriate for your later use on the Snowball Edge\. In the Amazon EC2 console, you do this in **Step 4: Add Storage**\. For a list of the supported sizes for compute instance storage volumes on a Snowball Edge, see [Quotas for Compute Instances on a Snowball Edge](ec2-edge-limits.md)\.

1. Install and configure the applications that you want to run on the Snowball Edge, and test that they work as expected\.

1. Make a copy of the PEM/PPK file that you used for the SSH key pair to create this instance\. Save this file to the server that you plan to use to communicate with the Snowball Edge\. This file is required for using SSH to connect to the launched instance on your device, so make a note of the path to this file\.

1. Save the instance as an AMI\. For more information, see [Creating an Amazon EBS\-Backed Linux AMI](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami-ebs.html) in the* Amazon EC2 User Guide for Linux Instances\.*

1. Repeat this procedure for each of the instances that you want to connect to using SSH\. Make sure that you make copies of your different SSH key pairs and take note of the AMIs they're associated with\.

## Creating Your Job in the Console<a name="create-ec2-edge-console"></a>

Your next step is to create a job\. Your job can be of any job type, including a cluster\. Using the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2), and follow the instructions provided in [Create Your First Job](create-job.md), add these additional steps when you get to the **Step 3: Give job details** page in the job creation wizard\.

1. Choose **Enable compute with EC2**\.

1. Choose **Add an AMI**\.

1. In the dialog box that opens, choose an AMI and choose **Save**\.

1. Add up to 10 total AMIs to your job\.

1. Continue creating your job as normal\.

## Creating Your Job in the AWS CLI<a name="create-ec2-edge-cli"></a>

You can also create your job using the AWS CLI\. To do this, open a terminal and run the following command, replacing the red text with your actual values:

```
aws snowball create-job --job-type IMPORT --resources '{"S3Resources":[{"BucketArn":"arn:aws:s3:::bucket-name"}],"Ec2AmiResources":[{"AmiId":"ami-12345678"}]}' --description Example --address-id ADIEXAMPLE60-1234-1234-5678-41fEXAMPLE57  --kms-key-arn arn:aws:kms:us-west-2:012345678901:key/eEXAMPLE-1234-1234-5678-5b4EXAMPLE8e --role-arn arn:aws:iam::012345678901:role/snowball-local-s3-lambda-us-west-2-role --snowball-capacity-preference T100 --shipping-option SECOND_DAY --snowball-type EDGE
```

After it arrives and you unlock your device, use the Snowball client to get your local credentials\. For more information, see [Getting Credentials](using-client-commands.md#client-credentials)\.