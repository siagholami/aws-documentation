# Step 9: Create and Run Your AWS DMS Migration Task<a name="CHAP_RDSOracle2Redshift.Steps.CreateMigrationTask"></a>

Using an AWS DMS task, you can specify what schema to migrate and the type of migration\. You can migrate existing data, migrate existing data and replicate ongoing changes, or replicate data changes only\. This walkthrough migrates existing data only\.

**To create a migration task**

1. On the **Create Task** page, specify the task options\. The following table describes the settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.CreateMigrationTask.html)

   The page should look like the following\.  
![\[Create task page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift23.png)

1. On the **Task Settings** section, specify the settings as shown in the following table\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.CreateMigrationTask.html)

   The section should look like the following\.  
![\[Create task page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift23.5.png)

1. In the **Selection rules** section, specify the settings as shown in the following table\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.CreateMigrationTask.html)

   The section should look like the following:  
![\[Add selection rule page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift24.png)

1. Choose **Add selection rule**\.

1. Choose **Create task**\.

5\. Choose **Create task**\. The task begins immediately\. The **Tasks** section shows you the status of the migration task\.

![\[Tasks page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift25.5.png)