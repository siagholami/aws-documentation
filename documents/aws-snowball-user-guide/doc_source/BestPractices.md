--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Best Practices for AWS Snowball<a name="BestPractices"></a>

Following, you can find information to help you get the maximum benefit from and satisfaction with AWS Snowball \(Snowball\)\.

## Security Best Practices for AWS Snowball<a name="security-best-practices"></a>

Following are approaches that we recommend to promote security when using Snowball:
+ If you notice anything that looks suspicious about the Snowball, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/), and a new Snowball will be shipped to you\.
+ We recommend that you don't save a copy of the unlock code in the same location in the workstation as the manifest for that job\. Saving the unlock code and manifest separately helps prevent unauthorized parties from gaining access to the Snowball\. For example, you might take this approach: First, save a copy of the manifest to the workstation\. Then, email the unlock code to the AWS Identity and Access Management \(IAM\) user to perform the data transfer from the workstation\. This approach limits access to the Snowball to individuals who have access to files saved on the workstation and also that IAM user's email address\.
+ Whenever you transfer data between your on\-premises data centers and a Snowball, logs are automatically generated and saved to your workstation\. These logs are saved in plaintext format and can contain file name and path information for the files that you transfer\. To protect this potentially sensitive information, we strongly suggest that you delete these logs after the job that the logs are associated with enters **Completed** status\. For more information about logs, see [Snowball Logs](copy-command-reference.md#snowballlogs)\.

## Network Best Practices for AWS Snowball<a name="network-best-practices"></a>

Following are approaches that we recommend for using Snowball with a network:
+ Your workstation should be the local host for your data\. For performance reasons, we don't recommend reading files across a network when using Snowball to transfer data\. If you must transfer data across a network, batch the local cache before copying to the Snowball so the copy operation can go as fast as possible\.
+ Because the workstation is considered to be the bottleneck for transferring data, we highly recommend that your workstation be a powerful computer, able to meet high demands in terms of processing, memory, and networking\. For more information, see [Workstation Specifications](specifications.md#workstationspecs)\.
+ You can run simultaneous instances of the Snowball client in multiple terminals, each using the copy operation to speed up your data transfer\. For more information about using the Snowball client see [Commands for the Snowball Client](using-client-commands.md)\.
+ To prevent corrupting your data, don't disconnect the Snowball or change its network settings while transferring data\.
+ Files must be in a static state while being copied\. Files that are modified while they are being transferred are not imported into Amazon S3\.

## Resource Best Practices for AWS Snowball<a name="resource-best-practices"></a>

Following are approaches that we recommend for working with Snowball and your data resources, along with a few additional important points:
+ The 10 free days for performing your on\-premises data transfer start the day after the Snowball arrives at your data center, and stop when you ship the device back out\.
+ The **Job created** status is the only status in which you can cancel a job\. When a job changes to a different status, it can’t be canceled\.
+ For import jobs, don't delete your local copies of the transferred data until the import into Amazon S3 is successful at the end of the process\. As part of your process, be sure to verify the results of the data transfer\.
+ We recommend that you have no more than 500,000 files or directories within each directory\.