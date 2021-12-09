# Step 4: Use AWS SCT to Convert the SQL Server Schema to Aurora MySQL<a name="CHAP_SQLServer2Aurora.Steps.ConvertSchema"></a>

Before you migrate data to Amazon Aurora MySQL, convert the Microsoft SQL Server schema to an Aurora MySQL schema using the AWS Schema Conversion Tool \(AWS SCT\)\.

**To convert a SQL Server schema to an Aurora MySQL schema**

1. In AWS SCT, choose **File**, **New Project**\. Create a new project named **AWS Schema Conversion Tool SQL Server to Aurora MySQL**\. 

1. In the **New Project** dialog box, enter the following information, and then choose **OK**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.ConvertSchema.html)  
![\[Creating a new project in the AWS Schema Conversion Tool\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-newsctproj.png)

1. Choose **Connect to Microsoft SQL Server**\. In the **Connect to Microsoft SQL Server** dialog box, enter the following information, and then choose **Test Connection**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.ConvertSchema.html)  
![\[Test Connection to SQL Server Database in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctconnectsqlserv.png)

1. Choose **OK** to close the alert box\. Then choose **OK** to close the dialog box and start the connection to the SQL Server DB instance\. The database structure on the SQL Server DB instance is shown\.

1. Choose **Connect to Amazon Aurora \(MySQL compatible\)**\. In the **Connect to Amazon Aurora \(MySQL compatible\)** dialog box, enter the following information, and then choose **Test Connection**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.ConvertSchema.html)  
![\[Test Connection to Aurora MySQL Database in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctconnectaur.png)

1. Choose **OK** to close the alert box\. Then choose **OK** to close the dialog box and start the connection to the Aurora MySQL DB instance\.

1. Open the context \(right\-click\) menu for the schema to migrate, and then choose **Convert schema**\.  
![\[Choosing Convert schema in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctconvert.png)

1. Choose **Yes** for the confirmation message\. AWS SCT then converts your schemas to the target database format\.  
![\[AWS SCT schema conversion\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctconverted.png)

   AWS SCT analyzes the schema and creates a database migration assessment report for the conversion to Aurora MySQL\.

1. Choose **Assessment Report View** from **View** to check the report\.

   The report breaks down by each object type and by how much manual change is needed to convert it successfully\.  
![\[Database migration report in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctreport.png)

   Generally, packages, procedures, and functions are more likely to have some issues to resolve because they contain the most custom PL/SQL code\. AWS SCT also provides hints about how to fix these objects\.

1. Choose the **Action Items** tab\.  
![\[Action Items in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctaction.png)

   The **Action Items** tab shows each issue for each object that requires attention\.

   For each conversion issue, you can complete one of the following actions:
   + Modify the objects on the source SQL Server database so that AWS SCT can convert the objects to the target Aurora MySQL database\.

     1. Modify the objects on the source SQL Server database\.

     1. Repeat the previous steps to convert the schema and check the assessment report\.

     1. If necessary, repeat this process until there are no conversion issues\.

     1. Choose **Main View** from **View**\. Open the context \(right\-click\) menu for the target Aurora MySQL schema, and choose **Apply to database** to apply the schema changes to the Aurora MySQL database, and confirm that you want to apply the schema changes\.  
![\[Apply Schema changes to the database\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-sctapply.png)
   + Instead of modifying the source schema, modify scripts that AWS SCT generates before applying the scripts on the target Aurora MySQL database\.

     1. Choose **Main View** from **View**\. Open the context \(right\-click\) menu for the target Aurora MySQL schema name, and choose **Save as SQL**\. Next, choose a name and destination for the script\.

     1. In the script, modify the objects to correct conversion issues\.

        You can also exclude foreign key constraints, triggers, and secondary indexes from the script because they can cause problems during the migration\. After the migration is complete, you can create these objects on the Aurora MySQL database\.

     1. Run the script on the target Aurora MySQL database\.

   For more information, see [ Converting Database Schema to Amazon RDS by Using the AWS Schema Conversion Tool](http://docs.aws.amazon.com/SchemaConversionTool/latest/userguide/CHAP_SchemaConversionTool.Converting.html) in the *AWS Schema Conversion Tool User Guide*\.

1. \(Optional\) Use AWS SCT to create mapping rules\.

   1. Under **Settings**, select **Mapping Rules**\.

   1. Create additional mapping rules that are required based on the action items\.

   1. Save the mapping rules\.

   1. Choose **Export script for DMS** to export a JSON format of all the transformations that the AWS DMS task will use\. Choose **Save**\.