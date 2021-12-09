# Using Available Deployment Options for Amazon FSx for Lustre File Systems<a name="using-fsx-lustre"></a>

Amazon FSx for Lustre provides a high performance, parallel file system that stores data across multiple network file servers to maximize performance and reduce bottlenecks\. These servers have multiple disks\. To spread load, Amazon FSx shards file system data into smaller chunks and spreads them across disks and servers using a process called striping\. For more information about Amazon FSx for Lustre data striping, see [Striping Data in Your File System](performance.md#striping-data)\.

It's a best practice to link a highly durable long\-term data repository residing on Amazon S3 with your Amazon FSx for Lustre high\-performance file system\.

In this scenario, you store your datasets on the S3 data repository\. When you create your Amazon FSx for Lustre file system, you link it to your S3 data repository\. At this point, the objects in your S3 bucket are listed as files and directories on your FSx file system\. Amazon FSx then automatically copies the file contents from S3 to your Lustre file system when a file is accessed for the first time on the Amazon FSx file system\. After your compute workload runs, or at any time, you can use a data repository task to export changes back to S3\. For more information, see [Using data repositories with Amazon FSx for Lustre](fsx-data-repositories.md) and [Using data repository tasks to export data and metadata changes](export-data-repo-task.md)\. 

## File System Deployment Options for Amazon FSx for Lustre<a name="lustre-deployment-types"></a>

Amazon FSx for Lustre provides two file system deployment options: scratch and persistent\.

### Scratch File Systems<a name="scratch-file-system"></a>

*Scratch file systems* are designed for temporary storage and shorter\-term processing of data\. Data is not replicated and doesn't persist if a file server fails\. Scratch file systems provide high burst throughput of up to six times the baseline throughput of 200 MBps per TiB of storage capacity\. For more information, see [Aggregate File System Performance](performance.md#fsx-aggregate-perf)\. 

Use scratch file systems when you need cost\-optimized storage for short\-term, processing\-heavy workloads\. 

The following diagram shows the architecture for an Amazon FSx for Lustre scratch file system\.

![\[Amazon FSx for Lustre scratch file system architecture\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/fsx-lustre-scratch-architecture.png)

On a scratch file system, file servers are not replaced if they fail and data is not replicated\. If a file server or a storage disk becomes unavailable on a scratch file system, files stored on other servers are still accessible\. If clients try to access data that is on the unavailable server or disk, clients experience an immediate I/O error\. 

The following table illustrates the availability or durability that scratch file systems of example sizes are designed for, over the course of a day and a week\. As larger file systems have more file servers and more disks, the probabilities of failure are increased\. 


| File System Size \(TiB\) | Number of File Servers | Availability/Durability Over One Day | Availability/Durability Over One Week | 
| --- | --- | --- | --- | 
|  1\.2  | 2 | 99\.9% | 99\.4% | 
| 2\.4 | 2 | 99\.9% | 99\.4% | 
| 4\.8 | 3 | 99\.8% | 99\.2% | 
|  9\.6  | 5 | 99\.8% | 98\.6% | 
| 50\.4 | 22 | 99\.1% | 93\.9% | 

### Persistent File Systems<a name="persistent-file-system"></a>

*Persistent file systems* are designed for longer\-term storage and workloads\. The file servers are highly available and data is automatically replicated within the same Availability Zone \(AZ\) that is associated with the file system\. The data volumes attached to the file servers are replicated independently from the file servers to which they are attached\. 

Use persistent file systems for workloads that run for extended periods or indefinitely, and that might be sensitive to disruptions in availability\. 

The following diagram shows the architecture for an Amazon FSx for Lustre persistent file system, with replicated, highly available file servers and data volumes within a single AZ\.

![\[Amazon FSx for Lustre persistent file system archtecture.\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/fsx-lustre-persistent-architecture.png)

 Amazon FSx continuously monitors persistent file systems for hardware failures, and automatically replaces infrastructure components in the event of a failure\. On a persistent file system, if a file server becomes unavailable, it is replaced automatically within minutes of failure\. During that time, client requests for data on that server transparently retry and eventually succeed after the file server is replaced\. Data on persistent file systems is replicated on disks and any failed disks are automatically replaced, transparently\. 

You choose the file system deployment type when you create a new file system, using the AWS Management Console, the AWS CLI, or the Amazon FSx for Lustre API\. For more information, see [Step 1: Create Your Amazon FSx for Lustre File System](getting-started-step1.md) and [CreateFileSystemLustreConfiguration](https://docs.aws.amazon.com/fsx/latest/APIReference/API_CreateFileSystemLustreConfiguration.html) in the *Amazon FSx API Reference*\.