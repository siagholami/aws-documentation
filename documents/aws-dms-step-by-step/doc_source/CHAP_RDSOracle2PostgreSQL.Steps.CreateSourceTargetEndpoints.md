# Step 6: Create AWS DMS Source and Target Endpoints<a name="CHAP_RDSOracle2PostgreSQL.Steps.CreateSourceTargetEndpoints"></a>

While your replication instance is being created, you can specify the source and target database endpoints using the AWS Management Console\. However, you can only test connectivity after the replication instance has been created, because the replication instance is used in the connection\.

**To specify source and target database endpoints using the console**

1. Specify your connection information for the source Oracle database and the target PostgreSQL database\. The following table describes the source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2PostgreSQL.Steps.CreateSourceTargetEndpoints.html)

   The following table describes the advanced source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2PostgreSQL.Steps.CreateSourceTargetEndpoints.html)

   For information about extra connection attributes, see [Using Extra Connection Attributes with AWS Database Migration Service](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Introduction.ConnectionAttributes.html)\.

   The following table describes the target settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2PostgreSQL.Steps.CreateSourceTargetEndpoints.html)

   The following is an example of the completed page\.  
![\[Completed replication task connections page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2postgressql19.5.png)

1. After the endpoints and replication instance have been created, test each endpoint connection by choosing **Run test** for the source and target endpoints\.

1. Drop foreign key constraints and triggers on the target database\.

   During the full load process, AWS DMS does not load tables in any particular order, so it may load the child table data before parent table data\. As a result, foreign key constraints might be violated if they are enabled\. Also, if triggers are present on the target database, then it may change data loaded by AWS DMS in unexpected ways\.

1. If you do not have one, then generate a script that enables the foreign key constraints and triggers\. 

   Later, when you want to add them to your migrated database, you can just run this script\.

1. \(Optional\) Drop secondary indexes on the target database\.

   Secondary indexes \(as with all indexes\) can slow down the full load of data into tables since they need to be maintained and updated during the loading process\. Dropping them can improve the performance of your full load process\. If you drop the indexes, then you will need to add them back later after the full load is complete\.

1. Choose **Next**\.