# Using Data Repository Tasks<a name="managing-data-repo-task"></a>

You can create, duplicate, view details, and cancel data repository tasks using the Amazon FSx console, CLI, or API\.

**Note**  
We recommend that you download the latest AWS CLI so that you have access to all the required functionality\. For more information, see [Installing the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) in the *AWS Command Line Interface User Guide*\. Look for the **Upgrade** section for your operating system\.

## Creating a Data Repository Task<a name="creating-data-repo-task"></a>

You can create a data repository task by using the Amazon FSx console, CLI, or API\. After you create a task, you can view the task's progress and status by using the console, CLI, or API\. 

### To Create a Data Repository Task \(Console\)<a name="create-data-repo-task-console"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the navigation pane, choose **File systems**, then choose the Lustre file system that you want to create the task for\.

1. For **Actions**, choose **Export to data repository**\. This choice is not available if the file system isn't linked to a data repository on S3\. The **Create data repository task** page appears\.  
![\[Create data repository task page\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/create-exprt-task-dialog1.png)

   **Data repository task type** is set to **Export to repository**, which is the only task type currently supported\. The **Export destination** value is the export prefix that you defined when you created the file system\.

1. \(Optional\) Specify up to 32 directories or files to export from your Amazon FSx file system by providing the paths to those directories or files in **File system export paths**\. The paths you provide need to be relative to the mount point of the file system\. If the mount point is `/mnt/fsx` and `/mnt/fsx/path1` is a directory or file on the file system you want to export, then the path to provide is `path1`\.
**Note**  
If a path that you provide isn't valid, the task fails\.

1. \(Optional\) Choose **Enable** under **Completion report** to generate a task completion report after the task completes\. A *task completion report* provides details about the files processed by the task that meet the scope provided in **Report scope**\. To specify the location for Amazon FSx to deliver the report, enter a relative path on the file system's linked S3 data repository for **Report path**\.

1. Choose **Create data repository task**\. 

   A notification at the top of the **File systems** page shows the task that you just created in progress\. 

To view the task status and details, choose **Data repository tasks \(Lustre\)** on the navigation pane\. The default sort order shows the most recent task at the top of the list\. 

To view a task summary from this page, choose **Task ID** for the task you just created\. The **Summary** page for the task appears\. 

### To Create a Data Repository Task \(CLI\)<a name="create-data-repo-task-cli"></a>

The following procedure creates an export to repository task\. Amazon FSx generates a task completion report after the task completes\. If you don't want to generate a report, set `--report Enabled` to `false`\. For more information about task completion reports, see [Working with Task Completion Reports](task-completion-report.md)\.
+ To create a data repository task, use the [https://docs.aws.amazon.com/cli/latest/reference/fsx/create-data-repository-task.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/create-data-repository-task.html) CLI command\. The corresponding API operation is [ `CreateDataRepositoryTask`](https://docs.aws.amazon.com/fsx/latest/APIReference/API_CreateDataRepositoryTask.html)\.

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
        "CreationTime": "1545070680.240",
        "ClientRequestToken": "10192019-drt-12",
        "ResourceARN": "arn:aws:fsx:us-east-1:123456789012:task:task-123f8cd8e330c1321"
    }
}
```

After Amazon FSx begins processing the task, the task's status information becomes available\. To view task details and status using the CLI, see [To Retrieve Data Repository Tasks and Task Details \(CLI\)](#task-details-cli)\.

## Duplicating a Task<a name="recreate-task"></a>

You can duplicate an existing data repository task in the Amazon FSx console\. When you duplicate a task, an exact copy of the existing task is displayed in the **Create data repository task** page\. You can make changes to the paths to export, as needed, before creating and running the new task\. 

You can duplicate a task from the task details view or from the **Data repository tasks** page\.

**To duplicate an existing task**

You can duplicate a task from the task details page or for the Data repository tasks page\.

1. Choose a task on the **Data repository tasks \(Lustre\)** page\.

1. Choose **Duplicate task**\. The **Create data repository task** page appears\. All settings for the new task are identical to those for the task that you're duplicating\.

1. Change or add the paths that you want to export to\. The paths you provide need to be relative to the mount point of the file system\. If the mount point is `/mnt/fsx` and `/mnt/fsx/path1` is a directory or file on the file system you want to export, then the path to provide is `path1`\.

1. Choose **Create data repository task** to create the task\.

## Accessing Data Repository Tasks<a name="view-data-repo-tasks"></a>

After you create a data repository task, you can access the task, and all existing tasks in your account, using the Amazon FSx console, CLI, and API\. Amazon FSx provides the following detailed task information: 
+ All existing tasks\.
+ All tasks for a specific file system\.
+ All tasks with a specific lifecycle status\. For more information about task lifecycle status values, see [Understanding a Task's Status and Details](data-repo-task-status.md)\.

You can access all existing data repository tasks in your account by using the Amazon FSx console, CLI, or API, as described following\.

### To View Data Repository Tasks and Task Details \(Console\)<a name="access-all-tasks-console"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the navigation pane, choose **Data repository tasks \(Lustre\)**\. The **Data repository tasks** page appears, showing existing tasks\.

1. To see a task's details, choose **Task ID** or **Task name** in the **Data repository tasks** page\. The task detail page appears\.  
![\[Data repository tasks page\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/task-details-rprt.png)

### To Retrieve Data Repository Tasks and Task Details \(CLI\)<a name="task-details-cli"></a>

Using the Amazon FSx [https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-data-repository-tasks.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-data-repository-tasks.html) CLI command, you can view all the data repository tasks, and their details, in your account\. [https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeDataRepositoryTasks.html](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeDataRepositoryTasks.html) is the equivalent API command\.
+ Use the following command to view all data repository task objects in your account\.

  ```
  aws fsx describe-data-repository-tasks
  ```

  If the command is successful, Amazon FSx returns the response in JSON format\.

  ```
  {
      "DataRepositoryTasks": [
          {
              "Lifecycle": "EXECUTING",
              "Paths": [],
              "Report": {
                  "Path":"s3://dataset-01/reports",
                  "Format":"REPORT_CSV_20191124",
                  "Enabled":true,
                  "Scope":"FAILED_FILES_ONLY"
              },
              "StartTime": 1591863862.288,
              "EndTime": ,
              "Type": "EXPORT_TO_REPOSITORY",
              "Tags": [],
              "TaskId": "task-0123456789abcdef3",
              "Status": {
                  "SucceededCount": 4255,
                  "TotalCount": 4200,
                  "FailedCount": 55,
                  "LastUpdatedTime": 1571863875.289
              },
              "FileSystemId": "fs-0123456789a7",
              "CreationTime": 1571863850.075,
              "ResourceARN": "arn:aws:fsx:us-east-1:1234567890:task/task-0123456789abcdef3"
          },
          {
              "Lifecycle": "FAILED",
              "Paths": [],
              "Report": {
                  "Enabled": false,
              },
              "StartTime": 1571863862.288,
              "EndTime": 1571863905.292,
              "Type": "EXPORT_TO_REPOSITORY",
              "Tags": [],
              "TaskId": "task-0123456789abcdef1",
              "Status": {
                  "SucceededCount": 1153,
                  "TotalCount": 1156,
                  "FailedCount": 3,
                  "LastUpdatedTime": 1571863875.289
              },
              "FileSystemId": "fs-0123456789abcdef0",
              "CreationTime": 1571863850.075,
              "ResourceARN": "arn:aws:fsx:us-east-1:1234567890:task/task-0123456789abcdef1"
          },
          {
              "Lifecycle": "SUCCEEDED",
              "Paths": [],
              "Report": {
                  "Path":"s3://dataset-04/reports",
                  "Format":"REPORT_CSV_20191124",
                  "Enabled":true,
                  "Scope":"FAILED_FILES_ONLY"
              },
              "StartTime": 1571863862.288,
              "EndTime": 1571863905.292,
              "Type": "EXPORT_TO_REPOSITORY",
              "Tags": [],
              "TaskId": "task-04299453935122318",
              "Status": {
                  "SucceededCount": 258,
                  "TotalCount": 258,
                  "FailedCount": 0,
                  "LastUpdatedTime": 1771848950.012,
              },
              "FileSystemId": "fs-0123456789abcdef0",
              "CreationTime": 1771848950.012,
              "ResourceARN": "arn:aws:fsx:us-east-1:1234567890:task/task-0123456789abcdef0"
          }
      ]
  }
  ```

### Viewing Tasks by File System<a name="view-tasks-by-fs"></a>

You can view all tasks for a specific file system using the Amazon FSx console, CLI, or API, as described following\.

#### To View Tasks by File System \(Console\)<a name="tasks-by-fs-console"></a>

1. Choose **File systems** on the navigation pane\. The **File systems** page appears\.

1. Choose the file system that you want to view data repository tasks for\. The file system details page appears\.

1. On the file system details page, choose the **Data repository** tab\. Any tasks for this file system appear on the **Data repository tasks** panel\.  
![\[Tasks for a file system panel\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/images/tasks-by-file-system.png)

#### To Retrieve Tasks by File System \(CLI\)<a name="task-by-fs-cli"></a>
+ Use the following command to view all data repository tasks for file system `fs-0123456789abcdef0`\.

  ```
  aws fsx describe-data-repository-tasks \
      --filters Name=file-system-id,Values=fs-0123456789abcdef0
  ```

  If the command is successful, Amazon FSx returns the response in JSON format\.

  ```
  {
      "DataRepositoryTasks": [
          {
              "Lifecycle": "FAILED",
              "Paths": [],
              "Report": {
                  "Path":"s3://dataset-04/reports",
                  "Format":"REPORT_CSV_20191124",
                  "Enabled":true,
                  "Scope":"FAILED_FILES_ONLY"
              },
              "StartTime": 1571863862.288,
              "EndTime": 1571863905.292,
              "Type": "EXPORT_TO_REPOSITORY",
              "Tags": [],
              "TaskId": "task-0123456789abcdef1",
              "Status": {
                  "SucceededCount": 1153,
                  "TotalCount": 1156,
                  "FailedCount": 3,
                  "LastUpdatedTime": 1571863875.289
              },
              "FileSystemId": "fs-0123456789abcdef0",
              "CreationTime": 1571863850.075,
              "ResourceARN": "arn:aws:fsx:us-east-1:1234567890:task/task-0123456789abcdef1"
          },
          {
              "Lifecycle": "SUCCEEDED",
              "Paths": [],
              "Report": {
                  "Enabled": false,
              },
              "StartTime": 1571863862.288,
              "EndTime": 1571863905.292,
              "Type": "EXPORT_TO_REPOSITORY",
              "Tags": [],
              "TaskId": "task-0123456789abcdef0",
              "Status": {
                  "SucceededCount": 258,
                  "TotalCount": 258,
                  "FailedCount": 0,
                  "LastUpdatedTime": 1771848950.012,
              },
              "FileSystemId": "fs-0123456789abcdef0",
              "CreationTime": 1771848950.012,
              "ResourceARN": "arn:aws:fsx:us-east-1:1234567890:task/task-0123456789abcdef0"
          }
      ]
  }
  ```

## Canceling a Data Repository Task<a name="cancel-data-repo-task"></a>

You can cancel a data repository task while it's in either the PENDING or EXECUTING state\. When you cancel a task, the following occurs:
+ Amazon FSx doesn't process any files that are in the queue to be processed\.
+ Amazon FSx continues processing any files that are currently in process\.
+ Amazon FSx doesn't revert any files that the task already processed\.

### To Cancel a Data Repository Task \(Console\)<a name="w81aac15c15c15c13b7b1"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the navigation pane, choose **Data repository tasks \(Lustre\)**\. The **Data repository tasks** page appears, displaying existing tasks\.

1. Choose **Task ID** or **Task name** for the task that you want to cancel\.

1. Choose **Cancel task** to cancel the task\.

1. Enter the task ID to confirm the cancellation request\.

### To Cancel a Data Repository Task \(CLI\)<a name="w81aac15c15c15c13b7b3"></a>

Use the Amazon FSx [https://docs.aws.amazon.com/cli/latest/reference/fsx/cancel-data-repository-task.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/cancel-data-repository-task.html) CLI command, to cancel a task\. [ `CancelDataRepositoryTask`](https://docs.aws.amazon.com/fsx/latest/APIReference/API_CancelDataRepositoryTask.html) is the equivalent API command\.
+ Use the following command to view all data repository task objects in your account\.

  ```
  aws fsx cancel-data-repository-task \
      --task-id fs-0123456789abcdef0
  ```

  If the command is successful, Amazon FSx returns the response in JSON format\.

  ```
  {
      "Status": "CANCELING",
      "TaskId": "task-0123456789abcdef0"
  }
  ```