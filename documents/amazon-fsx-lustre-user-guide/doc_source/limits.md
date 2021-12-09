# Quotas<a name="limits"></a>

Following, you can find out about quotas when working with Amazon FSx for Lustre\.

## Quotas That You Can Increase<a name="soft-limits"></a>

Following are the quotas for Amazon FSx for Lustre per AWS account, per AWS Region, which you can increase for specific [deployment types](using-fsx-lustre.md#lustre-deployment-types) by contacting AWS Support\.


****  

| Resource | Default limit | Can be increased up to | 
| --- | --- | --- | 
| Number of file systems | 100 | Thousands | 
| Number of file updates from S3 per file system | 10 million / month | Hundreds of millions / month | 
| Total storage for all file systems |  US East \(Ohio\) Region – 100,800 GiB US East \(N\. Virginia\) Region – 100,800 GiB US West \(N\. California\) Region – 25,200 GiB US West \(Oregon\) Region – 100,800 GiB Asia Pacific \(Hong Kong\) Region – 25,200 GiB Asia Pacific \(Mumbai\) Region – 25,200 GiB Asia Pacific \(Seoul\) Region – 25,200 GiB Asia Pacific \(Singapore\) Region – 25,200 GiB Asia Pacific \(Sydney\) Region – 100,800 GiB Asia Pacific \(Tokyo\) Region – 100,800 GiB Canada \(Central\) Region – 25,200 GiB Europe \(Frankfurt\) Region – 100,800 GiB Europe \(Ireland\) Region – 100,800 GiB Europe \(London\) Region – 25,200 GiB Europe \(Stockholm\) Region – 25,200 GiB  | Petabytes | 

**To request a quota increase**

1. Open the [AWS Support Center](https://console.aws.amazon.com/support/home#/) page, sign in if necessary, and then choose **Create case**\.

1. For **Create case**, choose **Account and billing support**\.

1. In the **Case details** panel make the following entries:
   + For **Type** choose **Account**\.
   + For **Category** choose **Other Account Issues**\.
   + For **Subject** enter **Amazon FSx for Lustre service limit increase request**\.
   + Provide a detailed **Description** of your request, including the following for each file system you are requeting an increase for:
     + The file system ID and region\.
     + The file system's deployment type \- SCRATCH\_1, SCRATCH\_2, or PERSISTENT\_1\.

       If PERSISTENT\_1, provide the throughput tier \- 50 MB/s, 100 MB/s, or 200 MB/s\.
     + The file system's Preferred Availability Zone\.
     + The FSx quota that you want increased, and the value you want it increased to, if known\.
     + The reason why you are seeking the quota increase\.

1. Provide your preferred **Contact options** and choose **Submit**\.

## Resource Quotas for Each File System<a name="limits-MFS-resources-file-system"></a>

Following are the limits on Amazon FSx for Lustre resources for each file system in an AWS Region\. 


****  

| Resource | Limit per file system | 
| --- | --- | 
| Number of tags | 50 | 

For information on throughput capacity, see [Amazon FSx for Lustre Performance](performance.md)\.