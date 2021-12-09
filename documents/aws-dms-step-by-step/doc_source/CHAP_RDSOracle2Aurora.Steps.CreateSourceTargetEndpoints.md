# Step 8: Create AWS DMS Source and Target Endpoints<a name="CHAP_RDSOracle2Aurora.Steps.CreateSourceTargetEndpoints"></a>

While your replication instance is being created, you can specify the source and target database endpoints using the AWS Management Console\. However, you can only test connectivity after the replication instance has been created, because the replication instance is used in the connection\.

**To specify source or target database endpoints using the AWS console**

1. Specify your connection information for the source Oracle database and the target Amazon Aurora MySQL database\. The following table describes the source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.CreateSourceTargetEndpoints.html)

   The following table describes the target settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.CreateSourceTargetEndpoints.html)

   The completed page should look like the following:  
![\[Advanced section\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora19.5.png)

1. In order to disable foreign key checks during the initial data load, you must add the following commands to the target Aurora MySQL DB instance\. In the **Advanced** section, shown following, type the following commands for **Extra connection attributes**: `initstmt=SET FOREIGN_KEY_CHECKS=0, autocommit=1`

   The first command disables foreign key checks during a load, and the second command commits the transactions that DMS executes\.  
![\[Advanced section\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora20.png)

1. Choose **Next**\.