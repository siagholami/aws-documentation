# Step 6: Create AWS DMS Source and Target Endpoints<a name="CHAP_SQLServer2Aurora.Steps.CreateSourceTargetEndpoints"></a>

While your replication instance is being created, you can specify the source and target database endpoints using the AWS Management Console\. However, you can test connectivity only after the replication instance has been created, because the replication instance is used in the connection\.

**To specify source or target database endpoints using the console**

1. In the AWS DMS console, specify your connection information for the source SQL Server database and the target Aurora MySQL database\. The following table describes the source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.CreateSourceTargetEndpoints.html)

   The following table describes the advanced source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.CreateSourceTargetEndpoints.html)

   The following table describes the target settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.CreateSourceTargetEndpoints.html)

   The following table describes the advanced target settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_SQLServer2Aurora.Steps.CreateSourceTargetEndpoints.html)

   The following is an example of the completed page\.  
![\[Completed Replication Task Page showing Replication instance created successfully\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-dmsconnect.png)

   For information about extra connection attributes, see [Using Extra Connection Attributes with AWS Database Migration Service](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Introduction.ConnectionAttributes.html)\.

1. After the endpoints and replication instance are created, test the endpoint connections by choosing **Run test** for the source and target endpoints\.

1. Drop foreign key constraints and triggers on the target database\.

   During the full load process, AWS DMS does not load tables in any particular order, so it might load the child table data before parent table data\. As a result, foreign key constraints might be violated if they are enabled\. Also, if triggers are present on the target database, they might change data loaded by AWS DMS in unexpected ways\.

   ```
   ALTER TABLE 'table_name' DROP FOREIGN KEY 'fk_name';
                           
   DROP TRIGGER 'trigger_name';
   ```

1. If you dropped foreign key constraints and triggers on the target database, generate a script that enables the foreign key constraints and triggers\. 

   Later, when you want to add them to your migrated database, you can just run this script\.

1. \(Optional\) Drop secondary indexes on the target database\.

   Secondary indexes \(as with all indexes\) can slow down the full load of data into tables because they must be maintained and updated during the loading process\. Dropping them can improve the performance of your full load process\. If you drop the indexes, you must to add them back later, after the full load is complete\.

   ```
   ALTER TABLE 'table_name' DROP INDEX  'index_name';                      
   ```

1. Choose **Next**\.