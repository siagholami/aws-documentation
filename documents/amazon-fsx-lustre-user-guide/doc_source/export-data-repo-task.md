# Using data repository tasks to export data and metadata changes<a name="export-data-repo-task"></a>

Use the following procedures to export data and metadata changes by using the Amazon FSx console and CLI\.

## To export changes \(Console\)<a name="create-data-repo-task-console"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the navigation pane, choose **File systems**, then choose the Lustre file system that you want to create the task for\.

1. For **Actions**, choose **Export to data repository**\. This choice is not available if the file system isn't linked to a data repository on S3\. The **Create data repository task** page appears\.  
![\[Create data repository task page\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/create-exprt-task-dialog1.png)

   **Data repository task type** is set to **Export to repository**, which is the only task type currently supported\. The **Export destination** value is the export prefix that you defined when you created the file system\.

1. \(Optional\) Specify up to 32 directories or files to export from your Amazon FSx file system by providing the paths to those directories or files in **File system export paths**\. The paths you provide need to be relative to the mount point of the file system\. If the mount point is `/mnt/fsx` and `/mnt/fsx/path1` is a directory or file on the file system you want to export, then the path to provide is `path1`\.
**Note**  
If a path that you provide isn't valid, the task fails\.

1. \(Optional\) Choose **Enable** under **Completion report** to generate a task completion report after the task completes\. A *task completion report* provides details about the files processed by the task that meet the scope provided in **Report scope**\. To specify the location for Amazon FSx to deliver the report, enter a relative path on the file system's linked S3 bucket for **Report path**\.

1. Choose **Create data repository task**\. 

   A notification at the top of the **File systems** page shows the task that you just created in progress\. 

To view the task status and details, choose **Data repository tasks \(Lustre\)** on the navigation pane\. The default sort order shows the most recent task at the top of the list\. 

To view a task summary from this page, choose **Task ID** for the task you just created\. The **Summary** page for the task appears\. 

## To export changes \(CLI\)<a name="create-data-repo-task-cli"></a>
+ Use the [https://docs.aws.amazon.com/cli/latest/reference/fsx/create-data-repository-task.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/create-data-repository-task.html) CLI command to export data and metadata changes on your Amazon FSx for Lustre file system\. The corresponding API operation is [ `CreateDataRepositoryTask`](https://docs.aws.amazon.com/fsx/latest/APIReference/API_CreateDataRepositoryTask.html)\.

  ```
  $ aws fsx create-data-repository-task \
      --file-system-id fs-0123456789abcdef0 \
      --type EXPORT_TO_REPOSITORY \
      --paths path1,path2/file1 \
      --report Enabled=true,Scope=FAILED_FILES_ONLY,Format=REPORT_CSV_20191124,Path=s3://dataset-01/reports
  ```

  After successfully creating the data repository task, Amazon FSx returns the task description as JSON, as shown in the following example\.

  ```
  {
      "Task": {
          "TaskId": "task-123f8cd8e330c1321",
          "Type": "EXPORT_TO_REPOSITORY",
          "Lifecycle": "PENDING",
          "FileSystemId": "fs-0123456789abcdef0",
          "Paths": ["path1", "path2/file1"],
          "Report": {
              "Path":"s3://dataset-01/reports",
              "Format":"REPORT_CSV_20191124",
              "Enabled":true,
              "Scope":"FAILED_FILES_ONLY"
          },
          "CreationTime": "1545070680.120",
          "ClientRequestToken": "10192019-drt-12",
          "ResourceARN": "arn:aws:fsx:us-east-1:123456789012:task:task-123f8cd8e330c1321"
      }
  }
  ```

After creating the task to export data to the linked data repository on S3, you can check the status of the export\. For more information about viewing data repository tasks, see [Accessing Data Repository Tasks](managing-data-repo-task.md#view-data-repo-tasks)\.