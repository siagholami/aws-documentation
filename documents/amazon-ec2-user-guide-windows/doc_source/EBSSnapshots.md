# Amazon EBS snapshots<a name="EBSSnapshots"></a>

You can back up the data on your Amazon EBS volumes to Amazon S3 by taking point\-in\-time snapshots\. Snapshots are *incremental* backups, which means that only the blocks on the device that have changed after your most recent snapshot are saved\. This minimizes the time required to create the snapshot and saves on storage costs by not duplicating data\. Each snapshot contains all of the information that is needed to restore your data \(from the moment when the snapshot was taken\) to a new EBS volume\. 

When you create an EBS volume based on a snapshot, the new volume begins as an exact replica of the original volume that was used to create the snapshot\. The replicated volume loads data in the background so that you can begin using it immediately\. If you access data that hasn't been loaded yet, the volume immediately downloads the requested data from Amazon S3, and then continues loading the rest of the volume's data in the background\. For more information, see [Creating Amazon EBS snapshots](ebs-creating-snapshot.md)\.

When you delete a snapshot, only the data unique to that snapshot is removed\. For more information, see [Deleting an Amazon EBS snapshot](ebs-deleting-snapshot.md)\.

**Snapshot events**  
You can track the status of your EBS snapshots through CloudWatch Events\. For more information, see [EBS snapshot events](ebs-cloud-watch-events.md#snapshot-events)\.

**Application\-consistent snapshots**  
Using Systems Manager Run Command, you can take application\-consistent snapshots of all EBS volumes attached to your Amazon EC2 Windows instances\. The snapshot process uses the Windows [Volume Shadow Copy Service \(VSS\)](https://technet.microsoft.com/en-us/library/ee923636(v=ws.10).aspx) to take image\-level backups of VSS\-aware applications, including data from pending transactions between these applications and the disk\. You don't need to shut down your instances or disconnect them when you back up all attached volumes\. For more information, see [Creating a VSS Application\-Consistent Snapshot](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/application-consistent-snapshots.html)\.

**Multi\-volume snapshots**  
Snapshots can be used to create a backup of critical workloads, such as a large database or a file system that spans across multiple EBS volumes\. Multi\-volume snapshots allow you to take exact point\-in\-time, data coordinated, and crash\-consistent snapshots across multiple EBS volumes attached to an EC2 instance\. You are no longer required to stop your instance or to coordinate between volumes to ensure crash consistency, because snapshots are automatically taken across multiple EBS volumes\. For more information, see the steps for creating a multi\-volume EBS snapshot under [Creating Amazon EBS snapshots](ebs-creating-snapshot.md) \.

**Snapshot pricing**  
Charges for your snapshots are based on the amount of data stored\. Because snapshots are incremental, deleting a snapshot might not reduce your data storage costs\. Data referenced exclusively by a snapshot is removed when that snapshot is deleted, but data referenced by other snapshots is preserved\. For more information, see [Amazon Elastic Block Store Volumes and Snapshots](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/checklistforunwantedcharges.html#checkebsvolumes) in the *AWS Billing and Cost Management User Guide*\.

**Topics**
+ [How incremental snapshots work](#how_snapshots_work)
+ [Copying and sharing snapshots](#copy-and-share)
+ [Encryption support for snapshots](#encryption-support)
+ [Creating Amazon EBS snapshots](ebs-creating-snapshot.md)
+ [Creating a VSS Application\-Consistent Snapshot](application-consistent-snapshots.md)
+ [Deleting an Amazon EBS snapshot](ebs-deleting-snapshot.md)
+ [Copying an Amazon EBS snapshot](ebs-copy-snapshot.md)
+ [Viewing Amazon EBS snapshot information](ebs-describing-snapshots.md)
+ [Sharing an Amazon EBS snapshot](ebs-modifying-snapshot-permissions.md)
+ [Accessing the contents of an EBS snapshot](ebs-accessing-snapshot.md)
+ [Automating the Amazon EBS snapshot lifecycle](snapshot-lifecycle.md)

## How incremental snapshots work<a name="how_snapshots_work"></a>

This section provides illustrations of how an EBS snapshot captures the state of a volume at a point in time, and also how successive snapshots of a changing volume create a history of those changes\.

In the diagram below, Volume 1 is shown at three points in time\. A snapshot is taken of each of these three volume states\. 
+ In State 1, the volume has 10 GiB of data\. Because Snap A is the first snapshot taken of the volume, the entire 10 GiB of data must be copied\.
+ In State 2, the volume still contains 10 GiB of data, but 4 GiB have changed\. Snap B needs to copy and store only the 4 GiB that changed after Snap A was taken\. The other 6 GiB of unchanged data, which are already copied and stored in Snap A, are *referenced* by Snap B rather than \(again\) copied\. This is indicated by the dashed arrow\.
+ In State 3, 2 GiB of data have been added to the volume, for a total of 12 GiB\. Snap C needs to copy the 2 GiB that were added after Snap B was taken\. As shown by the dashed arrows, Snap C also references 4 GiB of data stored in Snap B, and 6 GiB of data stored in Snap A\. 
+ The total storage required for the three snapshots is 16 GiB\.

 **Relations among multiple snapshots of a volume** 

![\[Snapshots capturing an initial volume state and two subsequent states after data has been changed.\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/images/snapshot_1a.png)

**Note**  
If you copy a snapshot and encrypt it to a new CMK, a complete \(non\-incremental\) copy is always created, resulting in additional delay and storage costs\.

For more information about how data is managed when you delete a snapshot, see [Deleting an Amazon EBS snapshot](ebs-deleting-snapshot.md)\.

## Copying and sharing snapshots<a name="copy-and-share"></a>

You can share a snapshot across AWS accounts by modifying its access permissions\. You can make copies of your own snapshots as well as snapshots that have been shared with you\. For more information, see [Sharing an Amazon EBS snapshot](ebs-modifying-snapshot-permissions.md)\.

A snapshot is constrained to the AWS Region where it was created\. After you create a snapshot of an EBS volume, you can use it to create new volumes in the same Region\. For more information, see [Creating a volume from a snapshot](ebs-creating-volume.md#ebs-create-volume-from-snapshot)\. You can also copy snapshots across Regions, making it possible to use multiple Regions for geographical expansion, data center migration, and disaster recovery\. You can copy any accessible snapshot that has a `completed` status\. For more information, see [Copying an Amazon EBS snapshot](ebs-copy-snapshot.md)\.

## Encryption support for snapshots<a name="encryption-support"></a>

EBS snapshots fully support EBS encryption\.
+ Snapshots of encrypted volumes are automatically encrypted\.
+ Volumes that you create from encrypted snapshots are automatically encrypted\.
+ Volumes that you create from an unencrypted snapshot that you own or have access to can be encrypted on\-the\-fly\.
+ When you copy an unencrypted snapshot that you own, you can encrypt it during the copy process\.
+ When you copy an encrypted snapshot that you own or have access to, you can reencrypt it with a different key during the copy process\.
+ The first snapshot you take of an encrypted volume that has been created from an unencrypted snapshot is always a full snapshot\.
+ The first snapshot you take of a reencrypted volume, which has a different CMK compared to the source snapshot, is always a full snapshot\.

**Note**  
If you copy a snapshot and encrypt it to a new CMK, a complete \(non\-incremental\) copy is always created, resulting in additional delay and storage costs\.

Complete documentation of possible snapshot encryption scenarios is provided in [Creating Amazon EBS snapshots](ebs-creating-snapshot.md) and in [Copying an Amazon EBS snapshot](ebs-copy-snapshot.md)\.

For more information, see [Amazon EBS encryption](EBSEncryption.md)\.