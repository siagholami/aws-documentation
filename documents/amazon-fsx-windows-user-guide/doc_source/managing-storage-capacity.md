# Managing Storage Capacity<a name="managing-storage-capacity"></a>

As you need additional storage, you can increase the storage capacity that is configured on your Amazon FSx for Windows File Server file system\. You can do so using the Amazon FSx console, the Amazon FSx API, or the AWS Command Line Interface \(AWS CLI\)\. 

**Note**  
Support for file systems created before June 1, 2020, is coming soon\.

When you increase the storage capacity of your Amazon FSx file system, behind the scenes, Amazon FSx adds a new, larger set of disks to your file system\. The new capacity is available for use within minutes\. When the new storage capacity becomes available, you are billed only for the new storage capacity\. 

Amazon FSx runs a storage optimization process in the background to transparently migrate data from the old disks to the new, larger disks\. For most file systems, storage optimization takes a few hours up to a few days, with minimal noticeable impact on your workload performance\. 

The following illustration shows the four main steps of the process that Amazon FSx uses when increasing a file system's storage capacity\.

![\[Diagram of 4 steps: 1. storage capacity increase request, 2. FSx adds new larger disks, 3. FSx migrates data, and 4. FSx removes old disks.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/storage-scaling-flow-stacked-double.png)

You can track the storage optimization progress at any time using the Amazon FSx console, CLI, and API\. For more information, see [Monitoring Storage Capacity Increases](#monitoring-storage-capacity-increase)\.

**Topics**
+ [Important Points to Know When Increasing Storage Capacity](#storage-capacity-important-to-know)
+ [When to Increase Storage Capacity](#when-to-modify-storage-capacity)
+ [Storage Capacity Increases and File System Performance](#storage-capacity-increase-and-performance)
+ [How to Increase Storage Capacity](#increase-storage-capacity)
+ [Monitoring Storage Capacity Increases](#monitoring-storage-capacity-increase)

## Important Points to Know When Increasing Storage Capacity<a name="storage-capacity-important-to-know"></a>

 Here are a few important items to consider when increasing storage capacity: 
+ **Increase only** – You can only *increase* the amount of storage capacity for a file system; you cannot decrease storage capacity\.
+ **Minimum increase** – Each storage capacity increase must be a minimum of 10 percent of the file system's current storage capacity, up to the maximum allowed value of 65,536 GiB\.
+ **Minimum throughput capacity** – To increase storage capacity, a file system must have a minimum throughput capacity of 16 MB/s\. This is because the storage optimization step is a throughput\-intensive process\.
+ **Time between increases** – You can't make further storage capacity increases on a file system until 6 hours after the last increase was requested, or until the storage optimization process has completed, whichever time is longer\.

## When to Increase Storage Capacity<a name="when-to-modify-storage-capacity"></a>

Increase your file system's storage capacity when it's running low on free storage capacity\. Use the `FreeStorageCapacity` CloudWatch metric to monitor the amount of free storage available on the file system\. You can create an Amazon CloudWatch alarm on this metric and get notified when it drops below a specific threshold\. For more information, see [Monitoring with Amazon CloudWatch](monitoring-cloudwatch.md)\.

## Storage Capacity Increases and File System Performance<a name="storage-capacity-increase-and-performance"></a>

Most workloads experience minimal performance impact while Amazon FSx runs the storage optimization process in the background after the new storage capacity is available\. Write\-heavy applications with large active datasets could temporarily experience up to a one\-half reduction in the write performance\. For these cases, you can first increase your file system's throughput capacity *before* increasing storage capacity\. This enables you to continue providing the same level of throughput to meet your application’s performance needs\. For more information, see [Managing Throughput Capacity](managing-throughput-capacity.md)\.

## How to Increase Storage Capacity<a name="increase-storage-capacity"></a>

You can increase a file system's storage capacity using the Amazon FSx console, the AWS CLI, or the Amazon FSx API\.

### To increase storage capacity for a file system \(console\)<a name="increase-storage-console"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. Navigate to **File systems** and choose the Windows file system that you want to increase storage capacity for\.

1. For **Actions**, choose **Update storage**\. Or, in the **Summary** panel, choose **Update** next to the file system's **Storage capacity**\. 

   The **Update storage capacity** window appears\.  
![\[Console screenshot showing the Update storage capacity pane.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/update-storage-capacity-modal.png)

1. For **Input type**, choose **Percentage** to enter the new storage capacity as a percentage change from the current value, or choose **Absolute** to enter the new value in GiB\.

1. Enter the **Desired storage capacity**\.
**Note**  
The desired capacity value must be at least 10 percent larger than the current value, up to the maximum value of 65,536 GiB\.

1. Choose **Update** to initiate the storage capacity update\.

1. You can monitor the update progress on the **File systems** detail page, in the **Updates** tab\.

### To increase storage capacity for a file system \(CLI\)<a name="increase-storage-console"></a>

To increase the storage capacity for an Amazon FSx for Windows File Server file system, use the AWS CLI command [update\-file\-system](https://docs.aws.amazon.com/cli/latest/reference/fsx/update-file-system.html)\. Set the following parameters:
+ `--file-system-id` to the ID of the file system you are updating\.
+ `--storage-capacity` to a value that is at least 10 percent greater than the current value\.

You can monitor the progress of the update by using the AWS CLI command [describe\-file\-systems](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html)\. Look for the `administrative-actions` in the output\. 

For more information, see [AdministrativeAction](https://docs.aws.amazon.com/fsx/latest/APIReference/API_AdministrativeAction.html)\.

## Monitoring Storage Capacity Increases<a name="monitoring-storage-capacity-increase"></a>

You can monitor the progress of a storage capacity increase using the Amazon FSx console, the API, or the AWS CLI\.

### Monitoring Increases in the Console<a name="monitor-storage-action-console"></a>

In the **Updates** tab in the **File system details** window, you can view the 10 most recent updates for each update type\.

![\[Console screenshot showing recent updates list.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/fs-updates-panel.png)

For storage capacity updates, you can view the following information\.

****Update type****  
Supported types are **Storage capacity**, **Storage optimization**, and **Throughput capacity**\.

****Target value****  
The desired value to update the file system's storage capacity to\.

****Status****  
The current status of the update\. For storage capacity updates, the possible values are as follows:  
+ **Pending** – Amazon FSx has received the update request, but has not started processing it\.
+ **In progress** – Amazon FSx is processing the update request\.
+ **Updated optimizing** – Amazon FSx has increased the file system's storage capacity\. The storage optimization process is now moving the file system data to the new larger disks\.
+ **Completed** – The storage capacity increase completed successfully\.
+ **Failed** – The storage capacity increase failed\. Choose the question mark \(**?**\) to see details on why the storage update failed\.

****Progress %****  
Displays the progress of the storage optimization process as percent complete\.

****Request time****  
The time that Amazon FSx received the update action request\.

### Monitoring Increases with the AWS CLI and API<a name="monitor-storage-action-cli-api"></a>

You can view and monitor file system storage capacity increase requests using the [describe\-file\-systems](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html) AWS CLI command and the [DescribeFileSystems](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html) API action\. The `AdministrativeActions` array lists the 10 most recent update actions for each administrative action type\. When you increase a file system's storage capacity, two `AdministrativeActions` are generated: a `FILE_SYSTEM_UPDATE` and a `STORAGE_OPTIMIZATION` action\. 

The following example shows an excerpt of the response of a describe\-file\-systems CLI command\. The file system has a storage capacity of 300 GB, and there is a pending administrative action to increase the storage capacity to 1000 GB\.

```
{
    "FileSystems": [
        {
            "OwnerId": "111122223333",
            .
            .
            .
            "StorageCapacity": 300,
            "AdministrativeActions": [
                {
                     "AdministrativeActionType": "FILE_SYSTEM_UPDATE",
                     "RequestTime": 1581694764.757,
                     "Status": "PENDING",
                     "TargetFileSystemValues": {
                         "StorageCapacity": 1000
                     }
                },
                {
                    "AdministrativeActionType": "STORAGE_OPTIMIZATION",
                    "RequestTime": 1581694764.757,
                    "Status": "PENDING",
                }
            ]
```

Amazon FSx processes the `FILE_SYSTEM_UPDATE` action first, adding the new larger storage disks to the file system\. When the new storage is available to the file system, the `FILE_SYSTEM_UPDATE` status changes to `UPDATED_OPTIMIZING`\. The storage capacity shows the new larger value, and Amazon FSx begins processing the `STORAGE_OPTIMIZATION` administrative action\. This is shown in the following excerpt of the response of a describe\-file\-systems CLI command\. 

The `ProgressPercent` property displays the progress of the storage optimization process\. After the storage optimization process completes successfully, the status of the `FILE_SYSTEM_UPDATE` action changes to `COMPLETED`, and the `STORAGE_OPTIMIZATION` action no longer appears\.

```
{
    "FileSystems": [
        {
            "OwnerId": "111122223333",
            .
            .
            .
            "StorageCapacity": 1000,
            "AdministrativeActions": [
                {
                    "AdministrativeActionType": "FILE_SYSTEM_UPDATE",
                    "RequestTime": 1581694764.757,
                    "Status": "UPDATED_OPTIMIZING",
                    "TargetFileSystemValues": {
                        "StorageCapacity": 1000
                }
                },
                {
                    "AdministrativeActionType": "STORAGE_OPTIMIZATION",
                    "RequestTime": 1581694764.757,
                    "Status": "IN_PROGRESS",
                    "ProgressPercent": 50,
                }
            ]
```

 If the storage capacity increase fails, the status of the `FILE_SYSTEM_UPDATE` action changes to `FAILED`\. The `FailureDetails` property provides information about the failure, shown in the following example\.

```
{
    "FileSystems": [ 
        { 
            "OwnerId": "111122223333",
            .
            .
            .
            "StorageCapacity": 300,
            "AdministrativeActions": [ 
                { 
                    "AdministrativeActionType": "FILE_SYSTEM_UPDATE",
                    "FailureDetails": { 
                        "Message": "string"
                    },
                    "RequestTime": 1581694764.757,
                    "Status": "FAILED",
                    "TargetFileSystemValues": 
                        "StorageCapacity": 1000
                }
            ]
```

For information about troubleshooting failed actions, see [Troubleshooting Failed Storage and Throughput Updates](admin-actions-ts.md)\.