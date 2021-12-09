# Understanding a Task's Status and Details<a name="data-repo-task-status"></a>

 A data repository task can have one of the following statuses:
+ **PENDING** indicates that Amazon FSx has not started the task\.
+ **EXECUTING** indicates that Amazon FSx is processing the task\.
+ **FAILED** indicates that Amazon FSx didn't successfully process the task\. For example, there might be files that the task failed to process\. The task details provide more information about the failure\. For more information about failed tasks, see [Troubleshooting Failed Data Repository Tasks](failed-tasks.md)\.
+ **SUCCEEDED** indicates that Amazon FSx completed the task successfully\.
+ **CANCELED** indicates that the task was canceled and not completed\.
+ **CANCELING** indicates that Amazon FSx is in the process of canceling the task\.

After a task is created, you can view the following detailed information for a data repository task using the Amazon FSx console, CLI, or API:
+ The task type\. `EXPORT_TO_REPOSITORY` is the only type supported\. 
+ The file system that the task ran on\.
+ The task creation time\.
+ The task status\.
+ The total number of files that the task processed\.
+ The total number of files that the task successfully processed\.
+ The total number of files that the task failed to process\. This value is greater than zero when the task status is FAILED\. Detailed information about files that failed is available in a task completion report\. For more information, see [Working with Task Completion Reports](task-completion-report.md)\.
+ The time that the task started\.
+ The time that the task status was last updated\. Task status is updated every 30 seconds\.

For more information about accessing existing data repository tasks, see [Accessing Data Repository Tasks](managing-data-repo-task.md#view-data-repo-tasks)\.