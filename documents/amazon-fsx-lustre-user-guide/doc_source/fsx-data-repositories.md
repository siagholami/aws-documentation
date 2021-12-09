# Using data repositories with Amazon FSx for Lustre<a name="fsx-data-repositories"></a>

Amazon FSx for Lustre provides high\-performance file systems optimized for fast workload processing\. It can support workloads such as machine learning, high performance computing \(HPC\), video processing, financial modeling, and electronic design automation \(EDA\)\. These workloads commonly require data to be presented using a scalable, high\-speed file system interface for data access, and typically have datasets stored on long\-term durable data repositories like Amazon S3, or on\-premises storage\. Amazon FSx for Lustre is natively integrated with data repositories such as Amazon S3, making it easy to process data sets with the Lustre file system\.

**Topics**
+ [Overview of data repositories](overview-data-repo.md)
+ [Linking your file system to an S3 bucket](create-fs-linked-data-repo.md)
+ [Importing files from your S3 bucket](importing-files.md)
+ [Data repository tasks](data-repository-tasks.md)
+ [Exporting changes to the data repository](export-changed-data-meta.md)
+ [Releasing data from your file system](release-files.md)
+ [Using Amazon FSx with Your On\-Premises Data Repository](fsx-on-premises.md)

**Note**  
File system backups are not supported on file systems that are linked to a data repository\. For more information, see [Working with Backups](using-backups-fsx.md)\.