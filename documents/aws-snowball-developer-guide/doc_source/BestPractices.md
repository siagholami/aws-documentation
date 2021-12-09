--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Best Practices for the AWS Snowball Edge Device<a name="BestPractices"></a>

To help get the maximum benefit from and satisfaction with your AWS Snowball Edge device, we recommend that you follow these best practices\.

**Security**
+ If you notice anything that looks suspicious about the AWS Snowball Edge device, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/), and a new AWS Snowball Edge device will be shipped to you\.
+ We recommend that you don't save a copy of the unlock code in the same location in the workstation as the manifest for that job\. Saving these separately helps prevent unauthorized parties from gaining access to the AWS Snowball Edge device\. For example, you can save a copy of the manifest to your local server, and email the code to a user that unlocks the device\. This approach limits access to the AWS Snowball Edge device to individuals who have access to files saved on the server and also that user's email address\.
+ The credentials displayed when you run the Snowball client command `snowballEdge credentials` are a pair of keys: an access key and a secret key\. These keys are only associated with the job and the local resources on the device\. They don't map to your AWS account or any other AWS account\. If you try to use these keys to access services and resources in the AWS Cloud, they fail, because they work only for the local resources associated with your job\.

For information about how to use AWS Identity and Access Management policies to control access, see [AWS\-Managed \(Predefined\) Policies for AWS Snowball Edge](access-control-managing-permissions.md#access-policy-examples-aws-managed)\.

**Network**
+ We recommend that you only use one method of reading and writing data to a local bucket on an AWS Snowball Edge device at a time\. Using both the file interface and the Amazon S3 Adapter for Snowball on the same bucket at the same time can result in read/write conflicts\.
+ To prevent corrupting your data, don't disconnect an AWS Snowball Edge device or change its network settings while transferring data\.
+ Files should be in a static state while being written to the device\. Files that are modified while they are being written can result in read/write conflicts\.
+ For more information about improving performance of your AWS Snowball Edge device, see [Performance](#performance)\.

**Resource Management**
+ The 10 free days for performing your on\-premises data transfer start the day after the AWS Snowball Edge device arrives at your data center\. This applies to all Snowball types\.
+ The **Job created** status is the only status in which you can cancel a job\. When a job changes to a different status, it can’t be canceled\. This functionality is also true for clusters\.
+ For import jobs, don't delete your local copies of the transferred data until the import into Amazon S3 is successful at the end of the process\. As part of your process, be sure to verify the results of the data transfer\.

## Performance<a name="performance"></a>

Following, you can find information about AWS Snowball Edge device performance\. Here, we discuss performance in general terms, because on\-premises environments each have a different way of doing things—different network technologies, different hardware, different operating systems, different procedures, and so on\.

The following table outlines how your network's transfer rate impacts how long it takes to fill a Snowball Edge with data\. Transferring smaller files reduces your transfer speed due to decreased overhead\. If you have many small files, we recommend that you zip them up into larger archives before transferring them onto a Snowball\.


| Rate \(MB/s\) | 82 TB Transfer Time | 
| --- | --- | 
| 800 | 1\.22 days | 
| 450 | 2\.11 days | 
| 400 | 2\.37 days | 
| 300 | 3\.16 days | 
| 277 | 3\.42 days | 
| 200 | 4\.75 days | 
| 100 | 9\.49 days | 
| 60 | 15\.53 days | 
| 30 | 31\.06 days | 
| 10 | 85\.42 days | 

To provide meaningful guidance about performance, the following sections describe how to determine when to use the AWS Snowball Edge device and how to get the most out of the service\.

### Performance Recommendations<a name="perf-recommendations"></a>

The following recommendations are highly suggested, because they have the largest impact in improving the performance of your data transfer:
+ We recommend that you have no more than 500,000 files or directories within each directory\.
+ We recommend that all files transferred to a Snowball be no smaller than 1 MB in size\.
+ If you have many files smaller than 1 MB in size each, we recommend that you zip them up into larger archives before transferring them onto a Snowball\.

### Speeding Up Data Transfer<a name="transferspeed"></a>

One of the major ways that you can improve the performance of an AWS Snowball Edge device is to speed up the transfer of data going to and from a device\. In general, you can improve the transfer speed from your data source to the device in the following ways, ordered from largest to smallest positive impact on performance:

1. **Perform multiple write operations at one time** – You can perform multiple write operations at one time\. You can do this by running each command from multiple terminal windows on a computer with a network connection to a single AWS Snowball Edge device\.

1. **Transfer small files in batches ** – Each copy operation has some overhead because of encryption\. To speed the process up, batch files together in a single archive\. When you batch files together, they can be auto\-extracted when they are imported into Amazon S3\. For more information, see [Batching Small Files](batching-small-files.md)\.

1. **Write from multiple computers** – A single AWS Snowball Edge device can be connected to many computers on a network\. Each computer can connect to any of the three network interfaces at once\.

1. **Don't perform other operations on files during transfer** – Renaming files during transfer, changing their metadata, or writing data to the files during a copy operation has a negative impact on transfer performance\. We recommend that your files remain in a static state while you transfer them\. 

1. **Reduce local network use** – Your AWS Snowball Edge device communicates across your local network\. Because of this, reducing other local network traffic between the AWS Snowball Edge device, the switch it's connected to, and the computer that hosts your data source can improve data transfer speeds\.

1. **Eliminate unnecessary hops** – We recommend that you set up your AWS Snowball Edge device, your data source, and the computer running the terminal connection between them so that they're the only machines communicating across a single switch\. Doing so can result in improved data transfer speeds\.

**Note**  
The data transfer rate using the file interface is typically between 25 MB/s and 40 MB/s\. If you need to transfer data faster than this, use the Amazon S3 adapter for Snowball, which has a data transfer rate typically between 250 MB/s and 400 MB/s\. For more information on using the file interface, see [Transferring Files to AWS Snowball Edge Using the File Interface](using-fileinterface.md)\. For more information on using the Amazon S3 adapter, see [Transferring Files Using the Amazon S3 Adapter](using-adapter.md)\. 