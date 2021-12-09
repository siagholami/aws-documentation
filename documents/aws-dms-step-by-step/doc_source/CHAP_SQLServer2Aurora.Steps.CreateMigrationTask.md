# Step 7: Create and Run Your AWS DMS Migration Task<a name="CHAP_SQLServer2Aurora.Steps.CreateMigrationTask"></a>

Using an AWS DMS task, you can specify what schema to migrate and the type of migration\. You can migrate existing data, migrate existing data and replicate ongoing changes, or replicate data changes only\.

**To create a migration task**

1. In the AWS DMS console, on the **Create task** page, specify the task options\. The following table describes the settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.CreateMigrationTask.html)

   The page should look similar to the following:  
![\[Create task page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-dmstask.png)

1. Under **Task settings**, specify the settings\. The following table describes the settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.CreateMigrationTask.html)

1. Leave the Advanced settings at their default values\.

1. If you created and exported mapping rules with AWS SCT in the last step in [Step 4: Use AWS SCT to Convert the SQL Server Schema to Aurora MySQL](CHAP_SQLServer2Aurora.Steps.ConvertSchema.md), choose **Table mappings**, and select the **JSON** tab\. Then select **Enable JSON editing**, and enter the table mappings you saved\.

   If you did not create mapping rules, then proceed to the next step\.

1. Choose **Create task**\. The task starts immediately\.

The **Tasks** section shows you the status of the migration task\.

![\[Tasks section showing the source, target, type, and completion status for a task\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-dmsmonitor.png)

If you chose **Enable logging** during setup, you can monitor your task\. You can then view the Amazon CloudWatch metrics\.

**To monitor a data migration task in progress**

1. On the navigation pane, choose **Tasks**\. 

1. Choose your migration task\.

1. Choose the **Task monitoring** tab, and monitor the task in progress on that tab\.

   When the full load is complete and cached changes are applied, the task stops on its own\.

1. On the target Aurora MySQL database, if you disabled foreign key constraints and triggers, enable them using the script that you saved previously\.

1. On the target Aurora MySQL database, re\-create the secondary indexes if you removed them previously\.

1. If you chose to use AWS DMS to replicate changes, in the AWS DMS console, start the AWS DMS task by choosing **Start/Resume** for the task\.

   Important replication instance metrics to monitor include the following:
   + CPU
   + FreeableMemory
   + DiskQueueDepth
   + CDCLatencySource
   + CDCLatencyTarget

   The AWS DMS task keeps the target Aurora MySQL database up to date with source database changes\. AWS DMS keeps all the tables in the task up to date until it's time to implement the application migration\. The latency is zero, or close to zero, when the target has caught up to the source\. 

   For more information, see [Monitoring AWS Database Migration Service Tasks](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Monitoring.html)\.