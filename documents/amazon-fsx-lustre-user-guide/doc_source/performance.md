# Amazon FSx for Lustre Performance<a name="performance"></a>

Amazon FSx for Lustre, built on Lustre, the popular high\-performance file system, provides scale\-out performance that increases linearly with a ﬁle system’s size\. Lustre file systems scale horizontally across multiple file servers and disks\. This scaling gives each client direct access to the data stored on each disk to remove many of the bottlenecks present in traditional file systems\. Amazon FSx for Lustre builds on Lustre's scalable architecture to support high levels of performance across large numbers of clients\.

## How Lustre File Systems Work<a name="how-lustre-fs-work"></a>

 Each Amazon FSx for Lustre file system is comprised of the file servers that the clients communicate with, and a set of disks attached to each file server that store your data\. Each file server employs a fast, in\-memory cache to enhance performance for the most frequently accessed data\. When a client accesses data that's stored in the in\-memory cache, the file server doesn't need to read it from disk, which reduces latency and increases the total amount of throughput you can drive\. The following diagram illustrates the paths of a write operation, a read operation served from disk, and a read operation served from in\-memory cache: 

![\[Amazon FSx for Lustre performance architecture.\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/LustrePerfDiagram.png)

 When you read data that is stored on the file server's in\-memory cache, file system performance is determined by the network throughput\. When you write data to your file system, or when you read data that is not stored on the in\-memory cache, file system performance is determined by the lower of the network throughput and disk throughput\. 

## Aggregate File System Performance<a name="fsx-aggregate-perf"></a>

The throughput that an Amazon FSx for Lustre file system supports is proportional to its storage capacity\. Amazon FSx for Lustre file systems scale to hundreds of GBps of throughput and millions of IOPS\. Amazon FSx for Lustre also supports concurrent access to the same file or directory from thousands of compute instances\. This access enables rapid data checkpointing from application memory to storage, which is a common technique in high\-performance computing \(HPC\)\.

Amazon FSx for Lustre file systems provide burst read throughput using a network I/O credit mechanism to allocate network bandwidth based on average bandwidth utilization\. The file systems accrue credits when their network bandwidth usage is below their baseline limits, and can use these credits when they perform network data transfers\.

The following table shows the disk and network throughput and IOPS for each TiB of file system storage capacity, for Amazon FSx for Lustre deployment options:


| Deployment Type | Network throughput \(MB/s per TiB of file system storage provisioned\) | Network IOPS \(IOPS per TiB of file system storage provisioned\) | Memory for caching \(GiB per TiB of file system storage provisioned\) | Disk throughput \(MB/s per TiB of file system storage provisioned\) | Disk IOPS \(IOPS per TiB of file system storage provisioned\) | 
| --- |--- |--- |--- |--- |--- |
| **** | **Baseline** | **Burst** | **** | **** | **Baseline** | **Burst** | **** | 
| --- |--- |--- |--- |--- |--- |--- |--- |
| SCRATCH\_1 | 200 | 350 | Tens of thousands baseline | 17 | 200 \(read\)200 \(write\) | – | Thousands sustained | 
| --- |--- |--- |--- |--- |--- |--- |--- |
| SCRATCH\_2 | 200 | 1300 | Tens of thousands baselineHundreds of thousands burst | 6\.7 | 200 \(read\)100 \(write\) | – | 
| --- |--- |--- |--- |--- |--- |--- |
| PERSISTENT\-50 | 250 | 1,300\* | 2\.2 | 50 | 240 | Thousands sustained and burst | 
| --- |--- |--- |--- |--- |--- |--- |
| PERSISTENT\-100 | 500 | 1,300\* | 4\.4 | 100 | 240 | 
| --- |--- |--- |--- |--- |--- |
| PERSISTENT\-200 | 750 | 1,300\* | 8\.8 | 200 | 240 | 
| --- |--- |--- |--- |--- |--- |

**Note**  
\*Persistent file systems in the following AWS Regions provide network burst up to 530 MB/s per TiB of storage: Europe \(Frankfurt\), Europe \(London\), Europe \(Stockholm\), Asia Pacific \(Hong Kong\), Asia Pacific \(Singapore\), Canada \(Central\), and US West \(Los Angeles\)\.

### Example: Aggregate Baseline and Burst Throughput<a name="example-persistant-throughput"></a>

The following example illustrates how storage capacity and disk throughput impact file system performance\.

A persistent file system with a storage capacity of 4\.8 TiB and 50 MB/s per TiB of throughput per unit of storage provides an aggregate baseline disk throughput of 234 MB/s and a burst disk throughput of 1\.125 GB/s\.

Regardless of file system size, Amazon FSx for Lustre provides consistent, submillisecond latencies for file operations\.

## File System Storage Layout<a name="storage-layout"></a>

All file data in Lustre is stored on disks called object storage targets \(OSTs\)\. All file metadata \(including file names, timestamps, permissions, and more\) is stored on disks called metadata targets \(MDTs\)\. Amazon FSx for Lustre file systems are composed of a single MDT and multiple OSTs, each of which is built on SSD storage\. Each OST is approximately 1\.17 TiB in size\. Amazon FSx for Lustre automatically spreads your file data across the OSTs that make up your file system to balance storage capacity with throughput and IOPS load\. 

To view the listing and storage usage of the MDT and OSTs that make up your file system, run the following command from a client that has the file system mounted\. To view the storage capacity and consumption of each disk, run the following command\.

```
lfs df -h mount/path
```

The output of this command looks like the following\.

**Example**  

```
UUID                             bytes       Used   Available Use% Mounted on
mountname-MDT0000_UUID           68.7G       5.4M       68.7G   0% /fsx[MDT:0]
mountname-OST0000_UUID            1.1T       4.5M        1.1T   0% /fsx[OST:0]
mountname-OST0001_UUID            1.1T       4.5M        1.1T   0% /fsx[OST:1]

filesystem_summary:               2.2T       9.0M        2.2T   0% /fsx
```

## Striping Data in Your File System<a name="striping-data"></a>

Using Lustre, you can configure how files are striped across OSTs\. When a file is striped across multiple OSTs, read or write requests to the file are spread across those OSTs, increasing the aggregate throughput or IOPS your applications can drive through it\. 

By default, each file created in Amazon FSx for Lustre using standard Linux tools is stored on a single disk\. For files imported from Amazon S3, the file system’s `ImportedFileChunkSize` parameter determines how many OSTs imported files will be striped across\. Files larger than the `ImportedFileChunkSize` will be stored on multiple OSTs\.

You can view the striping configuration of a file or directory using the following command:

```
lfs getstripe filename
```

This command reports a file’s stripe count, stripe size, and stripe offset\. The *stripe count *is how many OSTs the file is striped across\. The *stripe size *is how much continuous data is stored on an OST\. The *stripe offset *is the index of the first OST that the file is striped across\. For more information, see [Configuring Lustre File Striping](http://wiki.lustre.org/Configuring_Lustre_File_Striping) on wiki\.lustre\.org\.

A file’s striping parameters are set when the file is first created\. Use the following command to create a new, empty file with a determined striping configuration\.

```
lfs setstripe filename --stripe-count # of OSTs --stripe-size # of bytes
```

To modify the striping of an existing file, you can create a new file with the desired striping configuration using the `lfs setstripe` command\. You then copy the original file into this new file\.

## Monitoring Performance and Usage<a name="performance-monitoring"></a>

Every minute, Amazon FSx for Lustre emits usage metrics for each disk \(MDT and OST\) to Amazon CloudWatch\.

To view aggregate file system usage details, you can look at the Sum statistic of each metric\. For example, the Sum of the `DataReadBytes` statistic reports the total read throughput seen by all the OSTs in a file system\. Similarly, the Sum of the `FreeDataStorageCapacity` statistic reports the total available storage capacity for file data in the file system\.

For more information on monitoring your file system’s performance, see [Monitoring Amazon FSx for Lustre](monitoring_overview.md)\.

## Performance Tips<a name="performance-tips"></a>

When using Amazon FSx for Lustre, keep the following performance tips in mind\. For service limits, see [Quotas](limits.md)\.
+ **Average I/O size** – Because Amazon FSx for Lustre is a network file system, each file operation goes through a round trip between the client and Amazon FSx for Lustre, incurring a small latency overhead\. Due to this per\-operation latency, overall throughput generally increases as the average I/O size increases, because the overhead is amortized over a larger amount of data\.
+ **Request model** – By enabling asynchronous writes to your file system, pending write operations are buffered on the Amazon EC2 instance before they are written to Amazon FSx for Lustre asynchronously\. Asynchronous writes typically have lower latencies\. When performing asynchronous writes, the kernel uses additional memory for caching\. A file system that has enabled synchronous writes issues synchronous requests to Amazon FSx for Lustre\. Every operation goes through a round trip between the client and Amazon FSx for Lustre\.
**Note**  
Your chosen request model has tradeoffs in consistency \(if you're using multiple Amazon EC2 instances\) and speed\.
+ **Amazon EC2 instances** – Applications that perform a large number of read and write operations likely need more memory or computing capacity than applications that don't\. When launching your Amazon EC2 instances for your compute\-intensive workload, choose instance types that have the amount of these resources that your application needs\. The performance characteristics of Amazon FSx for Lustre file systems don't depend on the use of Amazon EBS–optimized instances\.
+ **Workload balance across OSTs** – In some cases, your workload isn’t driving the aggregate throughput that your file system can provide \(200 MB/s per TiB of storage\)\. If so, you can use CloudWatch metrics to troubleshoot if performance is affected by an imbalance in your workload’s I/O patterns\. To identify if this is the cause, look at the Maximum CloudWatch metric for Amazon FSx for Lustre\.

  In some cases, this statistic shows a load at or above 240 MBps of throughput \(the throughput capacity of a single 1\.2\-TiB Amazon FSx for Lustre disk\)\. In such cases, your workload is not evenly spread out across your disks\. If this is the case, you can use the `lfs setstripe` command to modify the striping of files your workload is most frequently accessing\. For optimal performance, stripe files with high throughput requirements across all the OSTs comprising your file system\.

  If your files are imported from a data repository, you can take another approach to stripe your high\-throughput files evenly across your OSTs\. To do this, you can modify the `ImportedFileChunkSize` parameter when creating your next Amazon FSx for Lustre file system\.

  For example, suppose that your workload uses a 7\.0\-TiB file system \(which is made up of 6x 1\.17\-TiB OSTs\) and needs to drive high throughput across 2\.4\-GiB files\. In this case, you can set the `ImportedFileChunkSize` value to `(2.4 GiB / 6 OSTs) = 400 MiB` so that your files are spread evenly across your file system’s OSTs\.