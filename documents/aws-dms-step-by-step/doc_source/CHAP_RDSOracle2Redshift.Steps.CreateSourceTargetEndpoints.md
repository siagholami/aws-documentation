# Step 8: Create AWS DMS Source and Target Endpoints<a name="CHAP_RDSOracle2Redshift.Steps.CreateSourceTargetEndpoints"></a>

While your replication instance is being created, you can specify the source and target database endpoints using the AWS Management Console\. However, you can only test connectivity after the replication instance has been created, because the replication instance is used in the connection\.

**To specify source or target database endpoints using the AWS console**

1. Specify your connection information for the source Oracle database and the target Amazon Redshift database\. The following table describes the source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.CreateSourceTargetEndpoints.html)

   The following table describes the target settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.CreateSourceTargetEndpoints.html)

   The completed page should look like the following\.  
![\[Advanced section\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift19.5.png)

1. Wait for the status to say **Replication instance created successfully\.**\.

1. To test the source and target connections, choose **Run Test** for the source and target connections\.

1. Choose **Next**\.