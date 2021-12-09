# Automatically import updates from your S3 bucket<a name="autoimport-data-repo"></a>

By default, when you create new file system, Amazon FSx automatically imports the file metadata \(the name, ownership, timestamp, and permissions\) of the objects in the linked S3 bucket at file system creation\. You can also configure your Amazon FSx for Lustre file system to automatically import metadata of objects that are added to or changed in your S3 bucket after file creation\. Amazon FSx for Lustre imports the metadata for new and changed files after creation in the same manner as it imports file metadata at file system creation\. When Amazon FSx imports changed files to the file system, if the changed object in the S3 bucket no longer contains its metadata, Amazon FSx maintains the current metadata values of the file, rather than using default permissions\. 

**Note**  
Import settings are only available on Amazon FSx for Lustre file systems created after 3:00 pm EDT, July 23, 2020\. 

 You can set import preferences when you create a new file system, and you can update the preferences setting on existing file systems using the FSx management console, the CLI, and the AWS API\. Import preferences can have the following settings:
+ **Import objects that are added to my bucket** \- \(Default\) Amazon FSx automatically imports any new objects added to the linked S3 bucket that do not currently exist in the FSx file system\. Amazon FSx does not import updates to existing files to the FSx file system\. Amazon FSx does not delete files from the file system that are deleted from the linked S3 bucket\.
+ **Import objects that are added to or changed in my bucket** \- Amazon FSx automatically imports any new objects added to the S3 bucket and any existing objects that are changed after file system creation, or after you set the import preferences to this option\. Amazon FSx does not delete objects from the file system that are deleted from the linked S3 bucket\. 
+ **Do not import any objects** \- Amazon FSx only imports files from the linked S3 bucket when the file system is created\. FSx does not import any new or changed objects after choosing this option\.

The following conditions are required for Amazon FSx to automatically import new or changed files from the linked S3 bucket:
+ The file system and its linked S3 bucket are located in the same AWS Region\.
+ The S3 bucket does not have a misconfigured **Lifecycle state**\. For more information, see [Data repository lifecycle state](overview-data-repo.md#data-repository-lifecycles)\.
+ Your account has the permissions required to configure and receive event notifications on the linked S3 bucket\.

When you set the import preferences, Amazon FSx creates an event notification configuration on the linked S3 bucket named FSx\. Do not modify or delete the FSx event notification configuration on the S3 bucket – doing so will prevent the automatic import of new or changed files to your file system\.
+ If you update an existing file system's import setting to **Import objects that are added to my bucket**, only files added to your linked S3 bucket after you update the import setting are reflected in your file system\.
+ If you update an existing file system's import settings to **Import objects that are added to or changed in my bucket**, only files added or changed in your linked S3 bucket after you update the import setting are reflected in your file system\.

 When Amazon FSx imports a file that has changed on the linked S3 bucket, it overwrites the local file with the imported version, even if the file is write\-locked\.

Amazon FSx makes a best effort to import updates from your linked S3 bucket\. Amazon FSx cannot import S3 bucket changes in the following situations:
+ Amazon FSx does not have permission to open your changed or new S3 object\.
+ If the FSx event notification configuration on the linked S3 bucket is deleted or changed\.

It is a best practice to periodically sweep your linked S3 bucket and compare changes to the list of files on your file system, especially if your application requires a guarantee around importing changes\.

## Types of file changes supported<a name="file-change-support"></a>

Amazon FSx supports importing the following changes to files and folders that occur in the linked S3 bucket:
+ changes to file contents
+ changes to file or folder metadata
+ changes to symlink target or metadata

## Updating import preferences<a name="manage-autoimport"></a>

You can set a file system's import preferences when you create a new file system\. For more information, see [Linking your file system to an S3 bucket](create-fs-linked-data-repo.md)\. You can also change your import preferences after a file system has been created using the AWS Management Console, the AWS Command Line Interface \(AWS CLI\), and the Amazon FSx API, as shown in the following procedures\. 

### To update import preferences on an existing file system \(console\)<a name="manage-autoimport-console"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. From the dashboard, choose **File systems**\.

1. Select the file system that you want to manage and display the file system details\.

1. Choose **Data repository** to view the data repository settings\. You can modify the import preferences if the Lifecycle state is AVAILABLE or MISCONFIGURED\. For more information, see [Data repository lifecycle state](overview-data-repo.md#data-repository-lifecycles)\.

1. Choose **Update import preferences** from the **Actions** pull down menu to display the **Update import preferences** dialog box\.

1. Choose the new setting, then choose **Update** to make the change\.

### To update import preferences on an existing file system \(CLI\)<a name="manage-autoimport-cli"></a>
+ To update import preferences, use the [https://docs.aws.amazon.com/cli/latest/reference/fsx/update-file-system.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/update-file-system.html) CLI command\. The corresponding API operation is [ `UpdateFileSystem`](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html)\.

  ```
  $ aws fsx update-file-system \
      --file-system-id fs-0123456789abcdef0 \
      --lustre-configuration AutoImportPolicy=NEW_CHANGED
  ```

After successfully updating the file system's `AutoImportPolicy`, Amazon FSx returns the description of the updated file system as JSON, as shown in the following example\.

```
{

    "FileSystems": [
        {
            "OwnerId": "111122223333",
            "CreationTime": 1549310341.483,
            "FileSystemId": "fs-0123456789abcdef0",
            "FileSystemType": "LUSTRE",
            "Lifecycle": "UPDATING",
            "StorageCapacity": 3600,
            "VpcId": "vpc-123456",
            "SubnetIds": [
                "subnet-123456"
            ],
            "NetworkInterfaceIds": [
                "eni-039fcf55123456789"
            ],
            "DNSName": "fs-0123456789abcdef0.fsx.us-east-2.amazonaws.com",
            "ResourceARN": "arn:aws:fsx:us-east-2:123456:file-system/fs-0123456789abcdef0",
            "Tags": [
                {
                    "Key": "Name",
                    "Value": "Lustre-TEST-1"
                }
            ],
            "LustreConfiguration": {
                "WeeklyMaintenanceStartTime": "2:04:30",
                "DeploymentType": "PERSISTENT_1",
                "DataRepositoryConfiguration": {
                    "AutoImportPolicy": "NEW_CHANGED",
                    "Lifecycle": "UPDATING",
                    "ImportPath": "s3://lustre-export-test-bucket/",
                    "ExportPath": "s3://lustre-export-test-bucket/export",
                    "ImportedFileChunkSize": 1024
                }
            }
        }
    ]
}
```