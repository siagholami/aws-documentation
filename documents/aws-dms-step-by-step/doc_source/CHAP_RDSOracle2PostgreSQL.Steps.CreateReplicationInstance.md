# Step 5: Create an AWS DMS Replication Instance<a name="CHAP_RDSOracle2PostgreSQL.Steps.CreateReplicationInstance"></a>

After validating the schema structure between source and target databases, continue with the core part of this walkthrough, which is the data migration\. The following illustration shows a high\-level view of the migration process\.

![\[AWS Database Migration Service migration process\]](http://docs.aws.amazon.com/dms/latest/sbs/images/datarep-conceptual2.png)

An AWS DMS replication instance performs the actual data migration between source and target\. The replication instance also caches the transaction logs during the migration\. How much CPU and memory capacity a replication instance has influences the overall time required for the migration\.

**To create an AWS DMS replication instance**

1. Sign in to the AWS Management Console, and select AWS DMS at [https://console\.aws\.amazon\.com/dms/](https://console.aws.amazon.com/dms/)\. Next, choose **Create Migration**\. If you are signed in as an AWS Identity and Access Management \(IAM\) user, then you must have the appropriate permissions to access AWS DMS\. For more information on the permissions required, see [IAM Permissions Needed to Use AWS DMS](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Security.IAMPermissions.html)\.

1. Choose **Next** to start a database migration from the console's Welcome page\.

1. On the **Create replication instance** page, specify your replication instance information\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2PostgreSQL.Steps.CreateReplicationInstance.html)

1. For the **Advanced** section, specify the following information\.     
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2PostgreSQL.Steps.CreateReplicationInstance.html)

   For information about the KMS master key, see [Setting an Encryption Key and Specifying KMS Permissions](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Security.EncryptionKey.html)\.

1. Click **Next**\.