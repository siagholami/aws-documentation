# Step 1: Launch the RDS Instances in a VPC by Using the CloudFormation Template<a name="CHAP_RDSOracle2Redshift.Steps.LaunchRDSwCloudFormation"></a>

First, you need to provision the necessary AWS resources for this walkthrough\.

**To use AWS CloudFormation to create Amazon RDS resources for this walkthrough**

1. Sign in to the AWS Management Console and open the AWS CloudFormation console at [https://console\.aws\.amazon\.com/cloudformation](https://console.aws.amazon.com/cloudformation/)\.

1. Choose **Create New Stack**\.

1. On the **Select Template **page, choose **Specify an Amazon S3 template URL **and paste the following URL into the adjacent text box:

    **https://dms\-sbs\.s3\.amazonaws\.com/Oracle\_Redshift\_For\_DMSDemo\.template**  
![\[AWS Database Migration Service replication instance\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift2.png)

1. Choose **Next**\. On the **Specify Details** page, provide parameter values as shown following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.LaunchRDSwCloudFormation.html)  
![\[AWS Database Migration Service Specify Details page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift3.png)

1. Choose **Next**\. On the **Options** page, choose **Next**\.

1. On the **Review** page, review the details, and if they are correct choose **Create**\.   
![\[AWS Database Migration Service replication instance\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift5.png)

1. AWS can take about 20 minutes or more to create the stack with an Amazon RDS Oracle instance and an Amazon Redshift cluster\.   
![\[AWS Database Migration Service Create Stack page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift6.png)

1.  After the stack is created, select the **OracletoRedshiftDWusingDMS** stack, and then choose the **Outputs** view\. Record the JDBC connection strings, **OracleJDBCConnectionString** and **RedshiftJDBCConnectionString**, for use later in this walkthrough to connect to the Oracle and Amazon Redshift databases\.