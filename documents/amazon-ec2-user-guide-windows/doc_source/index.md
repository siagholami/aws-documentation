# Amazon Elastic Compute Cloud User Guide for Windows Instances

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
+ [What is Amazon EC2?](concepts.md)
   + [Amazon EC2 basic infrastructure for Windows](EC2Win_Infrastructure.md)
+ [Setting up with Amazon EC2](get-set-up-for-amazon-ec2.md)
+ [Tutorial: Getting started with Amazon EC2 Windows instances](EC2_GetStarted.md)
+ [Best practices for Windows on Amazon EC2](ec2-best-practices.md)
+ [Amazon Machine Images (AMI)](AMIs.md)
   + [Managed AWS Windows AMIs](windows-ami-version-history.md)
      + [Details about AWS Windows AMI versions](windows-ami-versions.md)
      + [Amazon EC2 Windows Server AMIs for STIG compliance](ami-windows-stig.md)
   + [Finding a Windows AMI](finding-an-ami.md)
   + [Shared AMIs](sharing-amis.md)
      + [Finding shared AMIs](usingsharedamis-finding.md)
      + [Making an AMI public](sharingamis-intro.md)
      + [Sharing an AMI with specific AWS accounts](sharingamis-explicit.md)
      + [Using bookmarks](using-bookmarks.md)
      + [Guidelines for shared Windows AMIs](windows-amis-guidelines.md)
   + [Paid AMIs](paid-amis.md)
   + [Create a custom Windows AMI](Creating_EBSbacked_WinAMI.md)
      + [How the creation of a custom AMI works](process-creating-a-windows-ami-ebs.md)
      + [Create a Windows AMI from a running instance](how-to-create-windows-ebs-ami.md)
      + [Use Sysprep to create a standard Amazon Machine Image](ami-create-standard.md)
   + [Using encryption with EBS-backed AMIs](AMIEncryption.md)
   + [Copying an AMI](CopyingAMIs.md)
   + [Obtaining billing information](ami-billing-info.md)
   + [Deregistering your Windows AMI](deregister-ami.md)
+ [Amazon EC2 instances](Instances.md)
   + [Instance types](instance-types.md)
      + [General purpose instances](general-purpose-instances.md)
         + [Burstable performance instances](burstable-performance-instances.md)
            + [CPU credits and baseline utilization for burstable performance instances](burstable-credits-baseline-concepts.md)
            + [Unlimited mode for burstable performance instances](burstable-performance-instances-unlimited-mode.md)
               + [Unlimited mode concepts](burstable-performance-instances-unlimited-mode-concepts.md)
               + [Unlimited mode examples](unlimited-mode-examples.md)
            + [Standard mode for burstable performance instances](burstable-performance-instances-standard-mode.md)
               + [Standard mode concepts](burstable-performance-instances-standard-mode-concepts.md)
               + [Standard mode examples](standard-mode-examples.md)
            + [Working with burstable performance instances](burstable-performance-instances-how-to.md)
            + [Monitoring your CPU credits](burstable-performance-instances-monitoring-cpu-credits.md)
      + [Compute optimized instances](compute-optimized-instances.md)
      + [Memory optimized instances](memory-optimized-instances.md)
      + [Storage optimized instances](storage-optimized-instances.md)
      + [Windows accelerated computing instances](accelerated-computing-instances.md)
         + [Installing NVIDIA drivers on Windows instances](install-nvidia-driver.md)
         + [Activate NVIDIA GRID Virtual Applications](activate_grid.md)
         + [Optimizing GPU settings](optimize_gpu.md)
      + [Finding an Amazon EC2 instance type](instance-discovery.md)
      + [Changing the instance type](ec2-instance-resize.md)
      + [Getting recommendations for an instance type](ec2-instance-recommendations.md)
   + [Instance purchasing options](instance-purchasing-options.md)
      + [On-Demand Instances](ec2-on-demand-instances.md)
      + [Reserved Instances](ec2-reserved-instances.md)
         + [Regional and zonal Reserved Instances (scope)](reserved-instances-scope.md)
         + [Types of Reserved Instances (offering classes)](reserved-instances-types.md)
         + [How Reserved Instances are applied](apply_ri.md)
         + [How you are billed](concepts-reserved-instances-application.md)
         + [Buying Reserved Instances](ri-market-concepts-buying.md)
         + [Reserved Instance Marketplace](ri-market-general.md)
         + [Modifying Reserved Instances](ri-modifying.md)
         + [Exchanging Convertible Reserved Instances](ri-convertible-exchange.md)
      + [Scheduled Reserved Instances](ec2-scheduled-instances.md)
      + [Spot Instances](using-spot-instances.md)
         + [Best practices for EC2 Spot](spot-best-practices.md)
         + [How Spot Instances work](how-spot-instances-work.md)
         + [How Spot Fleet works](spot-fleet.md)
         + [Spot Instance pricing history](using-spot-instances-history.md)
         + [Savings from purchasing Spot Instances](spot-savings.md)
         + [Spot Instance requests](spot-requests.md)
            + [Spot Instance request example launch specifications](spot-request-examples.md)
         + [Spot Fleet requests](spot-fleet-requests.md)
            + [Spot Fleet example configurations](spot-fleet-examples.md)
         + [CloudWatch metrics for Spot Fleet](spot-fleet-cloudwatch-metrics.md)
         + [Automatic scaling for Spot Fleet](spot-fleet-automatic-scaling.md)
            + [Scale Spot Fleet using a target tracking policy](spot-fleet-target-tracking.md)
            + [Scale Spot Fleet using step scaling policies](spot-fleet-step-scaling.md)
            + [Scale Spot Fleet using scheduled scaling](spot-fleet-scheduled-scaling.md)
         + [Spot request status](spot-request-status.md)
         + [Spot Instance interruptions](spot-interruptions.md)
         + [Spot Instance data feed](spot-data-feeds.md)
         + [Spot Instance considerations](using-spot-limits.md)
      + [Dedicated Hosts](dedicated-hosts-overview.md)
         + [Working with Dedicated Hosts](how-dedicated-hosts-work.md)
         + [Working with shared Dedicated Hosts](dh-sharing.md)
         + [Host recovery](dedicated-hosts-recovery.md)
         + [Tracking configuration changes](dedicated-hosts-aws-config.md)
      + [Dedicated Instances](dedicated-instance.md)
      + [On-Demand Capacity Reservations](ec2-capacity-reservations.md)
         + [Capacity Reservation pricing and billing](capacity-reservations-pricing-billing.md)
         + [Working with Capacity Reservations](capacity-reservations-using.md)
         + [Working with shared Capacity Reservations](capacity-reservation-sharing.md)
         + [CloudWatch metrics for On-Demand Capacity Reservations](capacity-reservation-cw-metrics.md)
   + [Instance lifecycle](ec2-instance-lifecycle.md)
      + [Launch your instance](LaunchingAndUsingInstances.md)
         + [Launching an instance using the Launch Instance Wizard](launching-instance.md)
         + [Launching an instance from a launch template](ec2-launch-templates.md)
         + [Launching an instance using parameters from an existing instance](launch-more-like-this.md)
         + [Launching an AWS Marketplace instance](launch-marketplace-console.md)
         + [Launching instances using an EC2 Fleet](ec2-fleet.md)
            + [EC2 Fleet configuration strategies](ec2-fleet-configuration-strategies.md)
            + [Managing an EC2 Fleet](manage-ec2-fleet.md)
               + [EC2 Fleet example configurations](ec2-fleet-examples.md)
      + [Connecting to your Windows instance](connecting_to_windows_instance.md)
      + [Stop and start your instance](Stop_Start.md)
      + [Hibernate your Windows instance](Hibernate.md)
      + [Reboot your instance](ec2-instance-reboot.md)
      + [Instance retirement](instance-retirement.md)
      + [Terminate your instance](terminating-instances.md)
      + [Recover your instance](ec2-instance-recover.md)
   + [Configuring your Windows instance](ec2-windows-instances.md)
      + [Configuring a Windows instance using EC2Launch v2](ec2launch-v2.md)
         + [EC2Launch v2 overview](ec2launch-v2-overview.md)
         + [Install the latest version of EC2Launch v2](ec2launch-v2-install.md)
         + [Migrate to EC2Launch v2](ec2launch-v2-migrate.md)
         + [Stop, restart, delete, or uninstall EC2Launch v2](ec2-launch-v2-manage.md)
         + [Verify the EC2Launch v2 version](ec2launch-v2-verify-version.md)
         + [Subscribe to EC2Launch v2 service notifications](ec2launch-v2-sns.md)
         + [EC2Launch v2 settings](ec2launch-v2-settings.md)
         + [Troubleshooting EC2Launch v2](ec2launchv2-troubleshooting.md)
         + [EC2Launch v2 version histories](ec2launchv2-versions.md)
      + [Configuring a Windows instance using EC2Launch](ec2launch.md)
         + [Installing the latest version of EC2Launch](ec2launch-download.md)
         + [EC2Launch version history](ec2launch-version-details.md)
      + [Configuring a Windows Instance Using the EC2Config Service](ec2config-service.md)
         + [Installing the Latest Version of EC2Config](UsingConfig_Install.md)
         + [EC2Config Version History](ec2config-version-details.md)
         + [Troubleshooting Issues with the EC2Config Service](repair-ec2config.md)
      + [Paravirtual Drivers for Windows Instances](xen-drivers-overview.md)
         + [Upgrading PV Drivers on Your Windows Instances](Upgrading_PV_drivers.md)
         + [Troubleshooting PV Drivers](pvdrivers-troubleshooting.md)
      + [AWS NVMe drivers for Windows instances](aws-nvme-drivers.md)
      + [Optimizing CPU options](instance-optimize-cpu.md)
      + [Setting the time for a Windows instance](windows-set-time.md)
      + [Setting the password for a Windows instance](ec2-windows-passwords.md)
      + [Adding Windows components Using installation media](windows-optional-components.md)
      + [Configuring a secondary private IPv4 address for your Windows instance](config-windows-multiple-ip.md)
      + [Running commands on your Windows instance at launch](ec2-windows-user-data.md)
      + [Instance metadata and user data](ec2-instance-metadata.md)
         + [Configuring the instance metadata service](configuring-instance-metadata-service.md)
         + [Retrieving instance metadata](instancedata-data-retrieval.md)
         + [Working with instance user data](instancedata-add-user-data.md)
         + [Retrieving dynamic data](instancedata-dynamic-data-retrieval.md)
         + [Instance metadata categories](instancedata-data-categories.md)
         + [Instance identity documents](instance-identity-documents.md)
            + [Using the PKCS7 signature to verify the instance identity document](verify-pkcs7.md)
            + [Using the base64-encoded signature to verify the instance identity document](verify-signature.md)
            + [Using the RSA-2048 signature to verify the instance identity document](verify-rsa2048.md)
      + [Best Practices and Recommendations for SQL Server Clustering in EC2](aws-sql-clustering.md)
   + [Upgrading an Amazon EC2 Windows instance to a newer version of Windows Server](serverupgrade.md)
      + [Performing an in-place upgrade](os-inplaceupgrade.md)
      + [Performing an automated upgrade](automated-upgrades.md)
      + [Migrating to latest generation instance types](migrating-latest-types.md)
      + [Windows to Linux replatforming assistant for Microsoft SQL Server Databases](replatform-sql-server.md)
         + [Setting up](replatform-sql-server-setting-up.md)
         + [Getting started](replatform-sql-server-getting-started.md)
      + [Troubleshooting an upgrade](os-upgrade-trbl.md)
   + [Identify EC2 Windows instances](identify_ec2_instances.md)
+ [Amazon Elastic Graphics](elastic-graphics.md)
   + [Working with Elastic Graphics](working-with-elastic-graphics.md)
   + [Using CloudWatch metrics to monitor Elastic Graphics](elastic-graphics-cloudwatch.md)
   + [Troubleshooting](elastic-graphics-troubleshooting.md)
+ [Monitoring Amazon EC2](monitoring_ec2.md)
   + [Automated and manual monitoring](monitoring_automated_manual.md)
   + [Best practices for monitoring](monitoring_best_practices.md)
   + [Monitoring the status of your instances](monitoring-instances-status-check.md)
      + [Status checks for your instances](monitoring-system-instance-status-check.md)
      + [Scheduled events for your instances](monitoring-instances-status-check_sched.md)
   + [Monitoring your instances using CloudWatch](using-cloudwatch.md)
      + [Enable or disable detailed monitoring for your instances](using-cloudwatch-new.md)
      + [List the available CloudWatch metrics for your instances](viewing_metrics_with_cloudwatch.md)
      + [Get statistics for metrics for your instances](monitoring_get_statistics.md)
         + [Get statistics for a specific instance](US_SingleMetricPerInstance.md)
         + [Aggregate statistics across instances](GetSingleMetricAllDimensions.md)
         + [Aggregate statistics by Auto Scaling group](GetMetricAutoScalingGroup.md)
         + [Aggregate statistics by AMI](US_SingleMetricPerAMI.md)
      + [Graph metrics for your instances](graphs-in-the-aws-management-console.md)
      + [Create a CloudWatch alarm for an instance](using-cloudwatch-createalarm.md)
      + [Create alarms that stop, terminate, reboot, or recover an instance](UsingAlarmActions.md)
   + [Automating Amazon EC2 with CloudWatch Events](automating_with_cloudwatch_events.md)
   + [Logging Amazon EC2 and Amazon EBS API calls with AWS CloudTrail](monitor-with-cloudtrail.md)
   + [Monitor your .NET and SQL Server applications with CloudWatch Application Insights](monitoring-appinsights.md)
+ [Networking in Amazon EC2](ec2-networking.md)
   + [Amazon EC2 instance IP addressing](using-instance-addressing.md)
      + [Multiple IP addresses](MultipleIP.md)
   + [Bring your own IP addresses (BYOIP) in Amazon EC2](ec2-byoip.md)
   + [Elastic IP addresses](elastic-ip-addresses-eip.md)
   + [Elastic network interfaces](using-eni.md)
      + [Requester-managed network interfaces](requester-managed-eni.md)
   + [Enhanced networking on Windows](enhanced-networking.md)
      + [Enabling enhanced networking with the Elastic Network Adapter (ENA) on Windows instances](enhanced-networking-ena.md)
         + [Operating system optimizations](enhanced-networking-os.md)
      + [Enabling enhanced networking with the Intel 82599 VF interface on Windows instances](sriov-networking.md)
   + [Placement groups](placement-groups.md)
   + [Network maximum transmission unit (MTU) for your EC2 instance](network_mtu.md)
   + [Virtual private clouds](using-vpc.md)
   + [Ports and Protocols for Windows Amazon Machine Images (AMIs)](ports-and-protocols.md)
   + [EC2-Classic](ec2-classic-platform.md)
      + [ClassicLink](vpc-classiclink.md)
      + [Migrating from EC2-Classic to a VPC](vpc-migrate.md)
+ [Security in Amazon EC2](ec2-security.md)
   + [Infrastructure security in Amazon EC2](infrastructure-security.md)
   + [Amazon EC2 and interface VPC endpoints](interface-vpc-endpoints.md)
   + [Resilience in Amazon EC2](disaster-recovery-resiliency.md)
   + [Data protection in Amazon EC2](data-protection.md)
   + [Identity and access management for Amazon EC2](security-iam.md)
      + [IAM policies for Amazon EC2](iam-policies-for-amazon-ec2.md)
         + [Policy structure](iam-policy-structure.md)
         + [Granting permission to tag resources during creation](supported-iam-actions-tagging.md)
         + [Controlling access to EC2 resources using resource tags](control-access-with-tags.md)
         + [Example policies for working with the AWS CLI or an AWS SDK](ExamplePolicies_EC2.md)
         + [Example policies for working in the Amazon EC2 console](iam-policies-ec2-console.md)
      + [IAM roles for Amazon EC2](iam-roles-for-amazon-ec2.md)
      + [Authorizing inbound traffic for your Windows instances](authorizing-access-to-an-instance.md)
   + [Amazon EC2 key pairs and Windows instances](ec2-key-pairs.md)
   + [Amazon EC2 security groups for Windows instances](ec2-security-groups.md)
      + [Working with security groups](working-with-security-groups.md)
      + [Security group rules reference](security-group-rules-reference.md)
   + [Configuration management in Amazon EC2](configuration-management.md)
   + [Update management in Amazon EC2](update-management.md)
   + [Change management in Amazon EC2](change-management.md)
   + [Compliance validation for Amazon EC2](compliance-validation.md)
   + [Audit and accountability in Amazon EC2](audit-accountability.md)
+ [Storage](Storage.md)
   + [Amazon Elastic Block Store (Amazon EBS)](AmazonEBS.md)
      + [Amazon EBS volumes](ebs-volumes.md)
         + [Amazon EBS volume types](ebs-volume-types.md)
         + [Constraints on the size and configuration of an EBS volume](volume_constraints.md)
         + [Creating an Amazon EBS volume](ebs-creating-volume.md)
         + [Attaching an Amazon EBS volume to an instance](ebs-attaching-volume.md)
         + [Making an Amazon EBS volume available for use on Windows](ebs-using-volumes.md)
         + [Viewing information about an Amazon EBS volume](ebs-describing-volumes.md)
         + [Replacing an Amazon EBS volume using a previous snapshot](ebs-restoring-volume.md)
         + [Monitoring the status of your volumes](monitoring-volume-status.md)
         + [Detaching an Amazon EBS volume from a Windows instance](ebs-detaching-volume.md)
         + [Deleting an Amazon EBS volume](ebs-deleting-volume.md)
      + [Amazon EBS snapshots](EBSSnapshots.md)
         + [Creating Amazon EBS snapshots](ebs-creating-snapshot.md)
         + [Creating a VSS Application-Consistent Snapshot](application-consistent-snapshots.md)
            + [Before You Begin](application-consistent-snapshots-prereqs.md)
            + [Getting Started](application-consistent-snapshots-getting-started.md)
            + [Creating a VSS Application-Consistent Snapshot Using the AWS CLI, AWS Tools for Windows PowerShell, or the AWSEC2-ManageVssIO SSM Document](application-consistent-snapshots-creating-commands.md)
            + [Restoring Volumes from VSS-Enabled EBS snapshots](application-consistent-snapshots-restore.md)
            + [AWS VSS component package version history](application-consistent-snapshots-details.md)
         + [Deleting an Amazon EBS snapshot](ebs-deleting-snapshot.md)
         + [Copying an Amazon EBS snapshot](ebs-copy-snapshot.md)
         + [Viewing Amazon EBS snapshot information](ebs-describing-snapshots.md)
         + [Sharing an Amazon EBS snapshot](ebs-modifying-snapshot-permissions.md)
         + [Accessing the contents of an EBS snapshot](ebs-accessing-snapshot.md)
            + [Logging API Calls for the EBS direct APIs with AWS CloudTrail](logging-ebs-apis-using-cloudtrail.md)
            + [Idempotency for StartSnapshot API](ebs-direct-api-idempotency.md)
         + [Automating the Amazon EBS snapshot lifecycle](snapshot-lifecycle.md)
      + [Amazon EBS data services](ebs-data-services.md)
         + [Amazon EBS Elastic Volumes](ebs-modify-volume.md)
            + [Requirements when modifying volumes](modify-volume-requirements.md)
            + [Requesting modifications to your EBS Volumes](requesting-ebs-volume-modifications.md)
            + [Monitoring the progress of volume modifications](monitoring-volume-modifications.md)
            + [Extending a Windows file system after resizing a volume](recognize-expanded-volume-windows.md)
         + [Amazon EBS encryption](EBSEncryption.md)
         + [Amazon EBS fast snapshot restore](ebs-fast-snapshot-restore.md)
      + [Amazon EBS and NVMe on Windows instances](nvme-ebs-volumes.md)
      + [Amazon EBS???optimized instances](ebs-optimized.md)
      + [Amazon EBS volume performance on Windows instances](EBSPerformance.md)
         + [I/O characteristics and monitoring](ebs-io-characteristics.md)
         + [Initializing Amazon EBS volumes](ebs-initialize.md)
         + [RAID Configuration on Windows](raid-config.md)
         + [Benchmark EBS volumes](benchmark_procedures.md)
      + [Amazon CloudWatch metrics for Amazon EBS](using_cloudwatch_ebs.md)
      + [Amazon CloudWatch Events for Amazon EBS](ebs-cloud-watch-events.md)
   + [Amazon EC2 instance store](InstanceStorage.md)
      + [Add instance store volumes to your EC2 instance](add-instance-store-volumes.md)
      + [SSD instance store volumes](ssd-instance-store.md)
   + [File storage](file-storage.md)
      + [Using Amazon S3 with Amazon EC2](AmazonS3.md)
      + [Using Amazon EFS with Amazon EC2](AmazonEFS.md)
      + [Using Amazon FSx for Windows File Server with Amazon EC2](storage_fsx.md)
   + [Instance volume limits](volume_limits.md)
   + [Device naming on Windows instances](device_naming.md)
   + [Block device mapping](block-device-mapping-concepts.md)
   + [Mapping disks to volumes on your Windows instance](ec2-windows-volumes.md)
   + [Tutorial: Deploy Storage Spaces Direct (S2D) on Amazon EC2](ec2-tutorial-s2d.md)
+ [Resources and tags](EC2_Resources.md)
   + [Resource locations](resources.md)
   + [Resource IDs](resource-ids.md)
   + [Listing and filtering your resources](Using_Filtering.md)
   + [Tagging your Amazon EC2 resources](Using_Tags.md)
   + [Amazon EC2 service quotas](ec2-resource-limits.md)
   + [Amazon EC2 usage reports](usage-reports.md)
+ [Tutorials for Amazon EC2 instances running Windows Server](ec2-tutorials.md)
   + [Tutorial: Deploying a WordPress blog on your Amazon EC2 instance running Windows Server](EC2Win_CreateWordPressBlog.md)
   + [Tutorial: Installing a WAMP Server on an Amazon EC2 Instance Running Windows Server](install-WAMP.md)
   + [Tutorial: Installing a WIMP server on an Amazon EC2 instance running Windows Server](install-WIMP.md)
   + [Tutorial: Increase the availability of your application on Amazon EC2](ec2-increase-availability.md)
   + [Tutorial: Setting Up a Windows HPC Cluster on Amazon EC2](ConfigWindowsHPC.md)
+ [Troubleshooting EC2 Windows instances](troubleshooting-windows-instances.md)
   + [Troubleshooting instance launch issues](troubleshooting-launch.md)
   + [Troubleshooting connecting to your Windows instance](troubleshoot-connect-windows-instance.md)
   + [Troubleshoot an unreachable instance](screenshot-service.md)
   + [Resetting a lost or expired Windows administrator password](ResettingAdminPassword.md)
      + [Resetting the Windows administrator password using EC2Config](ResettingAdminPassword_EC2Config.md)
      + [Resetting the Windows administrator password using EC2Launch](ResettingAdminPassword_EC2Launch.md)
   + [Troubleshooting stopping your instance](TroubleshootingInstancesStopping.md)
   + [Troubleshooting terminating (shutting down) your instance](TroubleshootingInstancesShuttingDown.md)
   + [Troubleshooting Sysprep](sysprep-troubleshoot.md)
   + [Using EC2Rescue for Windows Server](Windows-Server-EC2Rescue.md)
      + [Using EC2Rescue for Windows Server GUI](ec2rw-gui.md)
      + [Using EC2Rescue for Windows Server with the command line](ec2rw-cli.md)
      + [Using EC2Rescue for Windows Server with Systems Manager Run Command](ec2rw-ssm.md)
   + [Sending a diagnostic interrupt (for advanced users)](diagnostic-interrupt.md)
   + [Common issues with Windows instances](common-issues.md)
   + [Common messages troubleshooting Windows instances](common-messages.md)
+ [AWS Systems Manager for Microsoft System Center VMM](scvmm.md)
   + [Setting Up AWS Systems Manager for Microsoft SCVMM](scvmm-set-up.md)
   + [Managing EC2 Instances Using AWS Systems Manager for Microsoft SCVMM](scvmm-manage-ec2.md)
   + [Importing Your Virtual Machine Using AWS Systems Manager for Microsoft SCVMM](scvmm-import-vm.md)
   + [Troubleshooting AWS Systems Manager for Microsoft SCVMM](scvmm-troubleshoot.md)
+ [AWS Management Pack for Microsoft System Center](AWSManagementPack.md)
   + [Downloading the AWS Management Pack](DownloadAWSmp.md)
   + [Deploying the AWS Management Pack](DeployingAWSmp.md)
      + [Step 1: Installing the AWS Management Pack](ConfiguringAWSmp.md)
      + [Step 2: Configuring the Watcher Node](ConfiguringWatcherNode.md)
      + [Step 3: Create an AWS Run As Account](CreateRunAsAccount.md)
      + [Step 4: Run the Add Monitoring Wizard](RunAddMonitoringWizard.md)
      + [Step 5: Configure Ports and Endpoints](ConfigurePortsAndEndpoints.md)
   + [Using the AWS Management Pack](UsingAWSmp.md)
   + [Upgrading the AWS Management Pack](upgrading-awsmp.md)
   + [Uninstalling the AWS Management Pack](uninstalling-awsmp.md)
   + [Troubleshooting the AWS Management Pack](TroubleshootingAWSmp.md)
+ [Document history](DocumentHistory.md)