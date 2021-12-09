--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Transferring Data from Amazon EC2 Compute Instances to Amazon S3 Buckets on the Same Snowball Edge<a name="data-transfer-ec2-s3-edge"></a>

You can transfer data between compute instances and Amazon S3 buckets on the same Snowball Edge device\. This is done by using the supported AWS CLI commands and the appropriate endpoints\. For example, assume that you want to move data from a directory in my `sbe1.xlarge` instance into the Amazon S3 bucket, `myBucket` on the same device\. Assume also that you're using the Amazon S3 endpoint `192.0.2.1:8080`\. You use the following procedure\.

**Note**  
This procedure only works if you've followed the instructions in [Configure an AMI to Use SSH to Connect to Compute Instances Launched on the Device](create-ec2-edge-job.md#important-create-ec2-edge-job)\.

**To transfer data between a compute instance and a bucket on the same Snowball Edge**

1. Use SSH to connect to your compute instance\.

1. Download and install the AWS CLI\. If your instance doesn't already have the AWS CLI, download and install it\. For more information, see [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html)\. 

1. Configure the AWS CLI on your compute instance to work with the Amazon S3 endpoint on the Snowball Edge\. For more information, see [Getting and Using Local Amazon S3 Credentials](using-adapter.md#adapter-credentials)\.

1. Use the supported Amazon S3 AWS CLI commands to transfer data\. For example:

   ```
   aws s3 cp ~/june2018/results s3://myBucket/june2018/results --recursive --endpoint http://192.0.2.1:8080
   ```