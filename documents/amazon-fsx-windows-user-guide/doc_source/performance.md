# Amazon FSx for Windows File Server Performance<a name="performance"></a>

Amazon FSx for Windows File Server offers file systems to meet a variety of performance needs\. Following is an overview of Amazon FSx file system performance, with a discussion of the available performance and throughput options and useful performance tips\.

**Topics**
+ [Overview](#perf-overview)
+ [Performance Details](#performance-details-fsxw)
+ [Measuring Performance Using CloudWatch Metrics](#measure-performance-cw)

## Overview<a name="perf-overview"></a>

File system performance is measured by its latency, throughput, and I/O operations per second \(IOPS\)\.

### Latency<a name="latency-fsxW"></a>

 Amazon FSx for Windows File Server file servers employ a fast, in\-memory cache to achieve consistent sub\-millisecond latencies for actively accessed data\. For data that is not in the in\-memory cache, that is, for file operations that need to be served by performing I/O on the underlying storage volumes, Amazon FSx provides sub\-millisecond file operation latencies with solid state drive \(SSD\) storage, and single\-digit millisecond latencies with hard disk drive \(HDD\) storage\. 

### Throughput and IOPS<a name="throughput-and-iops-fsxw"></a>

 Amazon FSx file systems provide up to multiple GB/s of throughput and hundreds of thousands of IOPS\. The specific amount of throughput and IOPS that your workload can drive on your file system depends on the throughput capacity and storage capacity configuration of your file system, along with the nature of your workload, including the size of the active working set\. 

### Single\-Client Performance<a name="single-client-performance"></a>

With Amazon FSx, you can get up to the full throughput and IOPS levels for your file system from a single client accessing it\. Amazon FSx supports *SMB Multichannel*\. This feature enables it to provide up to multiple GB/s throughput and hundreds of thousands of IOPS for a single client accessing your file system\. SMB Multichannel uses multiple network connections between the client and server simultaneously to aggregate network bandwidth for maximal utilization\.

## Performance Details<a name="performance-details-fsxw"></a>

To understand the Amazon FSx performance model in detail, you can examine the architectural components of an Amazon FSx file system\. Your client compute instances, whether they exist in AWS or on\-premises, access your file system through an elastic network interface \(ENI\)\. This network interface resides in the Amazon VPC that you associate with your file system\. Behind the file system ENI is the Windows file server that is serving data over the network to the clients accessing the file system\. Amazon FSx provides a fast in\-memory cache on the file server to enhance performance for the most frequently accessed data\. Behind the file server are the storage volumes, or disks, hosting your file system data\. 

These components are illustrated in the following diagram\.

![\[Amazon FSx for Windows File Server architecture.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/perf-architecture-fsxW.png)

 Corresponding with these architectural components–network interface, in\-memory cache, and storage volumes–are the three primary performance characteristics of an Amazon FSx for Windows File Server file system that determine the overall throughput and IOPS performance\.
+ Network I/O performance: throughput/IOPS of requests between the clients and the file server \(in aggregate\)
+ In\-memory cache size on the file server: size of active working set that can be accommodated for caching
+ Disk I/O performance: throughput/IOPS of requests between the file server and the storage volumes

There are two factors that determine these performance characteristics for your file system: the amount of storage capacity and throughput capacity that you configure for it\. The first two performance characteristics – network I/O performance and in\-memory cache size – are solely determined by throughput capacity, while the third one – disk I/O performance – is determined by a combination of throughput capacity and storage capacity\.

File\-based workloads are typically spiky, characterized by short, intense periods of high I/O with plenty of idle time between bursts\. To support spiky workloads, in addition to the baseline speeds that a file system can sustain 24/7, Amazon FSx provides the capability to burst to higher speeds for periods of time for both network I/O and disk I/O operations\. Amazon FSx uses a network I/O credit mechanism to allocate throughput and IOPS based on average utilization — file systems accrue credits when their throughput and IOPS usage is below their baseline limits, and can use these credits when they perform I/O operations\. 

### Impact of Storage Capacity on Performance<a name="storage-capacity-and-performance"></a>

The type and amount of storage capacity impacts the performance of your file system\. You need to configure the type and amount of storage capacity necessary for your file system to deliver the desired performance levels for your workload\.

The maximum disk throughput and IOPS levels your file system can achieve is the lower of:
+ the disk performance level provided by your file server, based on the throughput capacity you select for your file system
+ the disk performance level provided by the type and amount of storage capacity you select for your file system

Your file system's storage provides the following levels of disk throughput and IOPS:


| Storage type | Disk throughput \(MB/s per TiB of storage\) | Disk IOPS \(IOPs per TiB of storage\) | 
| --- | --- | --- | 
| SSD | 750 | 3,000 | 
| HDD | 12 baseline; 80 burst \(up to a max\. of 1 GB/s per file system\)  | 12 baseline; 80 burst | 

You can increase a file system's storage capacity at any time\. For more information, see [Managing Storage Capacity](managing-storage-capacity.md)\.

### Impact of Throughput Capacity on Performance<a name="impact-throughput-cap-performance"></a>

Every Amazon FSx file system has a throughput capacity that you configure when the file system is created\. The throughput capacity determines the level of network I/O performance, that is, the speed at which the file server hosting your file system can serve file data over the network to clients accessing it\. Higher levels of throughput capacity come with more memory for caching data on the file server, and higher levels of disk I/O performance supported by the file server\.

 When you create a file system using the AWS Management Console, Amazon FSx automatically picks the recommended throughput capacity level for your file system based on the amount of storage capacity you select\. While the recommended throughput capacity should be sufficient for most workloads, you have the option to override the recommendation and select a specific throughput capacity level to meet your application's needs\. You can increase or decrease the amount of throughput capacity at any time after you create it\. For more information, see [Managing Throughput Capacity](managing-throughput-capacity.md)\. 

The following table shows the full set of specifications for throughput capacity, along with baseline and burst levels, and amount of memory for caching on the file server\. 


| FSx throughput capacity \(MBps\) | Network throughput capacity \(MBps\) | Network IOPS | Memory \(GB\) – for caching | Disk throughput \(MBps\) | Disk IOPS | 
| --- |--- |--- |--- |--- |--- |
| **** | **Baseline** | **Burst** | **** | **** | **Baseline** | **Burst** | **** | 
| --- |--- |--- |--- |--- |--- |--- |--- |
| 8 | 8 | 600 | Thousands baseline; tens of thousands burst | 0\.5 | 8 | 260 |  Hundreds to thousands baseline; tens of thousands burst  | 
| --- |--- |--- |--- |--- |--- |--- |--- |
| 16 | 16 | 600 | 1 | 16 | 260 | 
| --- |--- |--- |--- |--- |--- |
| 32 | 32 | 600 | 2 | 32 | 260 | 
| --- |--- |--- |--- |--- |--- |
| 64 | 64 | 600 | Tens of thousands baseline | 4 | 64 | 350 | 
| --- |--- |--- |--- |--- |--- |--- |
| 128 | 150 | 1,250 | 8 | 128 | 600 | 
| --- |--- |--- |--- |--- |--- |
| 256 | 300 | 1,250 | Hundreds of thousands baseline | 16 | 256 | 600 | Tens of thousands baseline | 
| --- |--- |--- |--- |--- |--- |--- |--- |
| 512 | 600 | 1,250 | 32 | 512 |  –  | 
| --- |--- |--- |--- |--- |--- |
| 1,024 | 1,500 |  –  | 64 | 1,024 |  –  | 
| --- |--- |--- |--- |--- |--- |
| 2,048 | 3,125 |  –  | 128 | 2,048 |  –  | 
| --- |--- |--- |--- |--- |--- |

### Example: Storage Capacity and Throughput Capacity<a name="throughput-example-fsxw"></a>

The following example illustrates how storage capacity and throughput capacity impact file system performance\. 

 A file system that is configured with 2 TiB of HDD storage capacity and 32 MBps of throughput capacity has the following throughput levels:
+ Network throughput – 32 MBps baseline and 600 MBps burst \(see throughput capacity table\)
+ Disk throughput – 24 MBps baseline and 160 MBps burst, which is the lower of the disk throughput levels of 32 MBps baseline and 260 MBps burst supported by the file server \(based on throughput capacity\), and the disk throughput levels of 24 MBps baseline \(12 MBps per TB \* 2 TB\) and 160 MBps burst \(80 MBps per TB \* 2 TB\) supported by the storage capacity\.

 Your workload accessing the file system will therefore be able to drive up to 32 MBps baseline and 600 MBps burst throughput for file operations performed on actively accessed data cached in the file server in\-memory cache, and up to 24 MBps baseline and 160 MBps burst throughput for file operations that need to go all the way to the disk, for example, due to cache misses\. 

## Measuring Performance Using CloudWatch Metrics<a name="measure-performance-cw"></a>

You can use Amazon CloudWatch to measure and monitor your file system's throughput and IOPS\. For more information, see [How to Use Amazon FSx for Windows File Server Metrics](how_to_use_metrics.md)\.