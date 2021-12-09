# Step 7: Create an AWS DMS Replication Instance<a name="CHAP_RDSOracle2Redshift.Steps.CreateReplicationInstance"></a>

After we validate the schema structure between source and target databases, as described preceding, we proceed to the core part of this walkthrough, which is the data migration\. The following illustration shows a high\-level view of the migration process\.

![\[AWS Database Migration Service migration process\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift-Step7-DMSOverview.png)

A DMS replication instance performs the actual data migration between source and target\. The replication instance also caches the transaction logs during the migration\. How much CPU and memory capacity a replication instance has influences the overall time required for the migration\.

**To create an AWS DMS replication instance**

1. Sign in to the AWS Management Console, open the AWS DMS console at [https://console\.aws\.amazon\.com/dms/](https://console.aws.amazon.com/dms/), and choose **Create Migration**\. If you are signed in as an AWS Identity and Access Management \(IAM\) user, you must have the appropriate permissions to access AWS DMS\. For more information on the permissions required, see [IAM Permissions Needed to Use AWS DMS](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Security.IAMPermissions.html)\.

1. Choose **Create migration** to start a database migration\.

1. On the **Welcome** page, choose **Next**\.

1. On the **Create replication instance** page, specify your replication instance information as shown following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.CreateReplicationInstance.html)

1. For the **Advanced** section, leave the default settings as they are, and choose **Next**\. 