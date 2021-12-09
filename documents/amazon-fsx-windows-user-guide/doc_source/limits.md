# Quotas<a name="limits"></a>

Following, you can find out about quotas when working with Amazon FSx for Windows File Server\.

**Topics**
+ [Quotas That You Can Increase](#soft-limits)
+ [Resource Quotas for Each File System](#limits-MFS-resources-file-system)
+ [Additional Considerations](#limits-additional-considerations)
+ [Quotas Specific to Microsoft Windows](#ntfs-limits)

## Quotas That You Can Increase<a name="soft-limits"></a>

Following are the quotas for Amazon FSx for Windows File Server for each AWS account, per AWS Region, that you can increase by contacting AWS Support\.


****  

| Resource | Default Limit | Can Be Increased Up To | 
| --- | --- | --- | 
| Number of file systems | 100 | Thousands | 
| Total SSD storage for all file systems | 512 TiB | Multiple PiBs | 
| Total HDD storage for all file systems | 512 TiB | Multiple PiBs | 
| Total throughput capacity for all file systems | 10 GBps | Hundreds of GBps | 
| Total number of user\-initiated backups for all file system |  500  | Thousands | 

**To request a quota increase**

1. Open the [AWS Support Center](https://console.aws.amazon.com/support/home#/) page, sign in if necessary, and then choose **Create case**\.

1. For **Create case**, choose **Account and billing support**\.

1. In the **Case details** panel make the following entries:
   + For **Type** choose **Account**\.
   + For **Category** choose **Other Account Issues**\.
   + For **Subject** enter **Amazon FSx for Windows File Server service limit increase request**\.
   + Provide a detailed **Description** of your request, including:
     + The FSx quota that you want increased, and the value you want it increased to, if known\.
     + The reason why you are seeking the quota increase\.
     + The file system id and region for each file system you are requesting an increase for\.

1. Provide your preferred **Contact options** and choose **Submit**\.

## Resource Quotas for Each File System<a name="limits-MFS-resources-file-system"></a>

Following are the quotas on Amazon FSx for Windows File Server resources for each file system in an AWS Region\. 


****  

| Resource | Limit per file system | 
| --- | --- | 
| Number of tags | 50 | 
| Minimum storage capacity, SSD file systems | 32 GiB | 
| Minimum storage capacity, HDD file systems | 2,000 GiB | 
| Maximum storage capacity, SSD and HDD | 64 TiB | 
| Minimum throughput capacity | 8 MBps | 
| Maximum throughput capacity | 2,048 MBps | 
| Maximum number of file shares | 100,000 | 
| Retention period for automated backups | 35 days | 

For information on throughput capacity, see [Amazon FSx for Windows File Server PerformancePerformance](performance.md)\.

## Additional Considerations<a name="limits-additional-considerations"></a>

In addition, note the following:
+ You can use each AWS Key Management Service \(AWS KMS\) key on up to 125 Amazon FSx file systems\.
+ For a list of AWS Regions where you can create file systems, see [Amazon FSx Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/fsxn.html) in the *AWS General Reference*\.
+ You map your file shares from Amazon EC2 instances in your virtual private cloud \(VPC\) with their Domain Name Service \(DNS\) names\. You can also map your file share on your EC2\-Classic instances \(which are not in a VPC\), but you must link them to your VPC by using ClassicLink\. For more information about using ClassicLink, see [ClassicLink](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html) in the *Amazon EC2 User Guide for Linux Instances*\.

## Quotas Specific to Microsoft Windows<a name="ntfs-limits"></a>

For more information, see [NTFS](https://docs.microsoft.com/en-us/windows/desktop/FileIO/filesystem-functionality-comparison#limits) limits on the Microsoft Windows Dev Center\.