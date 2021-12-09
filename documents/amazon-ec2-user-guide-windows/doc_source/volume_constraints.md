# Constraints on the size and configuration of an EBS volume<a name="volume_constraints"></a>

The size of an Amazon EBS volume is constrained by the physics and arithmetic of block data storage, as well as by the implementation decisions of operating system \(OS\) and file system designers\. AWS imposes additional limits on volume size to safeguard the reliability of its services\.

The following sections describe the most important factors that limit the usable size of an EBS volume and offer recommendations for configuring your EBS volumes\.

**Topics**
+ [Storage capacity](#ebs-storage-capacity)
+ [Service limitations](#aws_limits)
+ [Partitioning schemes](#partitioning)
+ [Data block sizes](#block_size)

## Storage capacity<a name="ebs-storage-capacity"></a>

The following table summarizes the theoretical and implemented storage capacities for the most commonly used file systems on Amazon EBS, assuming a 4,096 byte block size\.


| Partitioning scheme | Max addressable blocks  | Theoretical max size \(blocks × block size\) | Ext4 implemented max size\* | XFS implemented max size\*\* | NTFS implemented max size | Max supported by EBS | 
| --- | --- | --- | --- | --- | --- | --- | 
| MBR | 232 | 2 TiB | 2 TiB | 2 TiB | 2 TiB | 2 TiB | 
| GPT | 264 |  64 ZiB  | 1 EiB =10242 TiB \(50 TiB certified on RHEL7\) |  500 TiB \(certified on RHEL7\)  | 256 TiB | 16 TiB | 

\* [https://ext4.wiki.kernel.org/index.php/Ext4_Howto](https://ext4.wiki.kernel.org/index.php/Ext4_Howto) and [https://access.redhat.com/solutions/1532](https://access.redhat.com/solutions/1532)

\*\* [https://access.redhat.com/solutions/1532](https://access.redhat.com/solutions/1532)

## Service limitations<a name="aws_limits"></a>

Amazon EBS abstracts the massively distributed storage of a data center into virtual hard disk drives\. To an operating system installed on an EC2 instance, an attached EBS volume appears to be a physical hard disk drive containing 512\-byte disk sectors\. The OS manages the allocation of data blocks \(or clusters\) onto those virtual sectors through its storage management utilities\. The allocation is in conformity with a volume partitioning scheme, such as master boot record \(MBR\) or GUID partition table \(GPT\), and within the capabilities of the installed file system \(ext4, NTFS, and so on\)\. 

EBS is not aware of the data contained in its virtual disk sectors; it only ensures the integrity of the sectors\. This means that AWS actions and OS actions are independent of each other\. When you are selecting a volume size, be aware of the capabilities and limits of both, as in the following cases: 
+ EBS currently supports a maximum volume size of 16 TiB\. This means that you can create an EBS volume as large as 16 TiB, but whether the OS recognizes all of that capacity depends on its own design characteristics and on how the volume is partitioned\.
+ Amazon EC2 requires Windows boot volumes to use MBR partitioning\. As discussed in [Partitioning schemes](#partitioning), this means that boot volumes cannot be larger than 2 TiB\. Windows data volumes are not subject to this limitation and can use GPT partitioning\. If a Windows boot volume that is 2 TiB or larger is converted to use a dynamic MBR partition table, you will see an error for the volume in Disk Manager\.
+ Windows non\-boot volumes that are 2 TiB \(2048 GiB\) or larger must use a GPT partition table to access the entire volume\. If an EBS volume over 2 TiB in size is attached to a Windows instance at launch, it is automatically formatted with a GPT partition table\. If you attach an EBS volume over 2 TiB in size to a Windows instance after launch, you must initialize it with a GPT table manually\. For more information, see [Making an Amazon EBS volume available for use on Windows](ebs-using-volumes.md)\.

## Partitioning schemes<a name="partitioning"></a>

Among other impacts, the partitioning scheme determines how many logical data blocks can be uniquely addressed in a single volume\. For more information, see [Data block sizes](#block_size)\. The common partitioning schemes in use are *master boot record* \(MBR\) and *GUID partition table* \(GPT\)\. The important differences between these schemes can be summarized as follows\.

### MBR<a name="mbr-partitioning"></a>

MBR uses a 32\-bit data structure to store block addresses\. This means that each data block is mapped with one of 232 possible integers\. The maximum addressable size of a volume is given by:

```
(232 - 1) × Block size = Number of addressable blocks
```

The block size for MBR volumes is conventionally limited to 512 bytes\. Therefore:

```
(232 - 1) × 512 bytes = 2 TiB - 512 bytes
```

Engineering workarounds to increase this 2\-TiB limit for MBR volumes have not met with widespread industry adoption\. Consequently, Linux and Windows never detect an MBR volume as being larger than 2 TiB even if AWS shows its size to be larger\. 

### GPT<a name="gpt-partitioning"></a>

GPT uses a 64\-bit data structure to store block addresses\. This means that each data block is mapped with one of 264 possible integers\. The maximum addressable size of a volume is given by:

```
(264 - 1) × Block size = Number of addressable blocks
```

The block size for GPT volumes is commonly 4,096 bytes\. Therefore:

```
(264 - 1) × 4,096 bytes
   = 264 x 4,096 bytes - 1 x 4,096 bytes
   = 264 x 212 bytes - 4,096 bytes
   = 270 x 26 bytes - 4,096 bytes
   = 64 ZiB - 4,096 bytes
```

Real\-world computer systems don't support anything close to this theoretical maximum\. Implemented file\-system size is currently limited to 50 TiB for ext4 and 256 TiB for NTFS—both of which exceed the 16\-TiB limit imposed by AWS\.

## Data block sizes<a name="block_size"></a>

Data storage on a modern hard drive is managed through *logical block addressing*, an abstraction layer that allows the operating system to read and write data in logical blocks without knowing much about the underlying hardware\. The OS relies on the storage device to map the blocks to its physical sectors\. EBS advertises 512\-byte sectors to the operating system, which reads and writes data to disk using data blocks that are a multiple of the sector size\. 

The industry default size for logical data blocks is currently 4,096 bytes \(4 KiB\)\. Because certain workloads benefit from a smaller or larger block size, file systems support non\-default block sizes that can be specified during formatting\. Scenarios in which non\-default block sizes should be used are outside the scope of this topic, but the choice of block size has consequences for the storage capacity of the volume\. The following table shows storage capacity as a function of block size:


| Block size | Max volume size | 
| --- | --- | 
| 4 KiB \(default\) | 16 TiB | 
| 8 KiB | 32 TiB | 
| 16 KiB | 64 TiB | 
| 32 KiB | 128 TiB | 
| 64 KiB \(maximum\) | 256 TiB | 

The EBS\-imposed limit on volume size \(16 TiB\) is currently equal to the maximum size enabled by 4\-KiB data blocks\.