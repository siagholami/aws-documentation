# Amazon FSx for Lustre Lustre User Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What Is Amazon FSx for Lustre?](what-is.md)
+ [Setting Up](setting-up.md)
+ [Getting Started with Amazon FSx for Lustre](getting-started.md)
   + [Prerequisites](prerequisites.md)
   + [Step 1: Create Your Amazon FSx for Lustre File System](getting-started-step1.md)
   + [Step 2: Install and Configure the Lustre Client on Your Instance Before Mounting Your File System](getting-started-step2.md)
   + [Step 3: Run Your Analysis](getting-started-step3.md)
   + [(Optional) Step 4: Check Amazon FSx File System Status](file-system-lifecycle-states.md)
   + [Step 5: Clean Up Resources](getting-started-step4.md)
+ [Using Available Deployment Options for Amazon FSx for Lustre File Systems](using-fsx-lustre.md)
+ [Using data repositories with Amazon FSx for Lustre](fsx-data-repositories.md)
   + [Overview of data repositories](overview-data-repo.md)
   + [Linking your file system to an S3 bucket](create-fs-linked-data-repo.md)
   + [Importing files from your S3 bucket](importing-files.md)
      + [Automatically import updates from your S3 bucket](autoimport-data-repo.md)
      + [Preloading Files into Your File System](preload-file-contents-hsm.md)
   + [Data repository tasks](data-repository-tasks.md)
      + [Understanding a Task's Status and Details](data-repo-task-status.md)
      + [Using Data Repository Tasks](managing-data-repo-task.md)
      + [Working with Task Completion Reports](task-completion-report.md)
      + [Troubleshooting Failed Data Repository Tasks](failed-tasks.md)
   + [Exporting changes to the data repository](export-changed-data-meta.md)
      + [Using data repository tasks to export data and metadata changes](export-data-repo-task.md)
      + [Exporting files using HSM commands](exporting-files-hsm.md)
   + [Releasing data from your file system](release-files.md)
   + [Using Amazon FSx with Your On-Premises Data Repository](fsx-on-premises.md)
+ [Amazon FSx for Lustre Performance](performance.md)
+ [Accessing File Systems](accessing-fs.md)
   + [Installing the Lustre Client](install-lustre-client.md)
   + [Mounting from an Amazon EC2 Instance](mounting-ec2-instance.md)
   + [Mounting Amazon FSx File Systems from On-Premises or a Peered Amazon VPC](mounting-on-premises.md)
   + [Mounting Your Amazon FSx File System Automatically](mount-fs-auto-mount-onreboot.md)
   + [Unmounting File Systems](unmounting-fs.md)
   + [Working with Amazon EC2 Spot Instances](working-with-ec2-spot-instances.md)
+ [Working with Backups](using-backups-fsx.md)
   + [Setting Up a Custom Backup Schedule](custom-backup-schedule-fsx.md)
+ [Monitoring Amazon FSx for Lustre](monitoring_overview.md)
   + [How to Use Amazon FSx for Lustre Metrics](how_to_use_metrics.md)
   + [Accessing CloudWatch Metrics](accessingmetrics.md)
   + [Creating CloudWatch Alarms to Monitor Amazon FSx for Lustre](creating_alarms.md)
+ [Security in Amazon FSx for Lustre](security.md)
   + [Data Protection in Amazon FSx for Lustre](data-protection.md)
      + [Data Encryption in Amazon FSx for Lustre](encryption-fsxl.md)
         + [Encrypting Data at Rest](encryption-at-rest.md)
         + [Encrypting Data in Transit](encryption-in-transit-fsxl.md)
         + [How Amazon FSx for Lustre Uses AWS KMS](FSXKMS.md)
      + [Internetwork Traffic Privacy](internetwork-privacy.md)
   + [File System Access Control with Amazon VPC](limit-access-security-groups.md)
   + [Amazon VPC Network ACLs](limit-access-acl.md)
   + [Administration Access Control with IAM for Amazon FSx for Lustre Resources](access-control-overview.md)
      + [Using Service-Linked Roles for Amazon FSx for Lustre](using-service-linked-roles.md)
      + [Amazon FSx for Lustre API Permissions: Actions, Resources, and Conditions Reference](fsx-api-permissions-ref.md)
   + [Compliance Validation for Amazon FSx for Lustre](SERVICENAME-compliance.md)
+ [Logging Amazon FSx for Lustre API Calls with AWS CloudTrail](logging-using-cloudtrail.md)
+ [Amazon FSx for Lustre Maintenance Windows](maintenance-windows.md)
+ [Quotas](limits.md)
+ [Troubleshooting](troubleshooting.md)
+ [Document History](doc-history.md)