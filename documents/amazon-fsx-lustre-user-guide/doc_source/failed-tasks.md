# Troubleshooting Failed Data Repository Tasks<a name="failed-tasks"></a>

When a data repository task fails, you can find the number of files that Amazon FSx failed to process in **Files failed to export** on the console's **Task status **page\. Or you can use the CLI or API and view the task's `Status: FailedCount` property\. For information about accessing this information, see [Accessing Data Repository Tasks](managing-data-repo-task.md#view-data-repo-tasks)\. 

Amazon FSx also provides information about the specific files and directories that failed in a task completion report\. The task completion report contains the file or directory path on the Lustre file system that failed, its status, and the failure reason\. For more information, see [Working with Task Completion Reports](task-completion-report.md)\.

A data repository task can fail for several reasons, including those listed following\.


| Error Code | Explanation | 
| --- | --- | 
|  `PathSizeTooLong`  |  The task path is too long\. The number of characters in the path for an exported file or directory can't exceed 1,024\. This character number includes the export prefix set for the file system, plus the path to the exported file or directory\.  | 
|  `FileSizeTooLarge`  |  The file size for the export is too large\. The maximum file size that Amazon FSx can export is 5 TiB\.  | 
|  `S3AccessDenied`  |  Access was denied to Amazon S3\. The Amazon FSx file system must have permission to perform the `s3:PutObject` operation to export to a linked data repository on S3\. This permission is granted in the `AWSServiceRoleForFSxS3Access_fs-0123456789abcdef0` service\-linked role\. For more information, see [Using Service\-Linked Roles for Amazon FSx for Lustre](using-service-linked-roles.md)\.  | 
|  `S3Error`  |  Amazon FSx encountered an S3\-related error that wasn't `S3AccessDenied`\.  | 
|  `ResourceBusy`  | Amazon FSx was unable to export the file because it was being modified by another client on the file system\. You can retry the DataRepositoryTask after your workflow has finished writing to the file\. | 
|  `InternalError`  |  An error occurred within the Amazon FSx file system\. Generally, this error code means that The Amazon FSx file system that the failed task ran on is in a FAILED lifecycle state\. When this occurs, the affected files might not be recoverable due to data loss\. Otherwise, you can use hierarchical storage management \(HSM\) commands to export the files and directories to the data repository on S3\. For more information, see [Exporting files using HSM commands](exporting-files-hsm.md)\.  | 