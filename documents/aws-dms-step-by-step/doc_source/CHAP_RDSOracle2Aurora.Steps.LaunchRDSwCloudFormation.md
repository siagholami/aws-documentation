# Step 1: Launch the RDS Instances in a VPC by Using the CloudFormation Template<a name="CHAP_RDSOracle2Aurora.Steps.LaunchRDSwCloudFormation"></a>

First, you need to provision the necessary AWS resources for this walkthrough\.

**To use AWS CloudFormation to create Amazon RDS resources for this walkthrough**

1. Sign in to the AWS Management Console and open the AWS CloudFormation console at [https://console\.aws\.amazon\.com/cloudformation](https://console.aws.amazon.com/cloudformation/)\.

1. Choose **Create stack**\.

1. On the **Select Template **page, choose **Specify an Amazon S3 template URL **and paste the following URL into the adjacent text box:

    **https://dms\-sbs\.s3\.amazonaws\.com/Oracle\_Aurora\_RDS\_For\_DMSDemo\.template**  
![\[AWS Database Migration Service replication instance\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora2.png)

1. Choose **Next**\. On the **Specify Details** page, provide parameter values as shown following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.LaunchRDSwCloudFormation.html)  
![\[AWS Database Migration Service Specify Details page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora3.png)

1. Choose **Next**\. On the **Options** page, shown following, choose **Next**\.  
![\[AWS Database Migration Service Options page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora4.png)

1. On the **Review** page, review the details, and if they are correct choose **Create Stack**\. You can get the estimated cost of running this CloudFormation template by choosing **Cost**\.  
![\[AWS Database Migration Service replication instance\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora5.png)

1. AWS can take about 20 minutes or more to create the stack with Amazon RDS Oracle and Amazon Aurora MySQL instances\.   
![\[AWS Database Migration Service Create Stack page\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora6.png)

1.  After the stack is created, choose **Stack**, select the DMSdemo stack, and then choose **Outputs**\. Record the JDBC connection strings, **OracleJDBCConnectionString** and **AuroraJDBCConnectionString**, for use later in this walkthrough to connect to the Oracle and Aurora MySQL DB instances\.  
![\[AWS Database Migration Service replication instance\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora5.5.png)

**Note**  
Oracle 12c SE Two License version 12\.1\.0\.2\.v4 is available in all regions\. However, Amazon Aurora MySQL is not available in all regions\. Amazon Aurora MySQL is currently available in US East \(N\. Virginia\), US West \(Oregon\), EU \(Ireland\), Asia Pacific \(Tokyo\), Asia Pacific \(Mumbai\), Asia Pacific \(Sydney\), and Asia Pacific \(Seoul\)\. If you try to create a stack in a region where Aurora MySQL is not available, creation fails with the error `Invalid DB Engine for AuroraCluster`\.