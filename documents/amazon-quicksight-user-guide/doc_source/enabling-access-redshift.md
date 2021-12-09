# Authorizing Connections from Amazon QuickSight to Amazon Redshift Clusters<a name="enabling-access-redshift"></a>

For Amazon QuickSight to connect to an Amazon Redshift instance, you must create a new security group for that instance\. This security group contains an inbound rule authorizing access from the appropriate IP address range for the Amazon QuickSight servers in that region\. To learn more about authorizing Amazon QuickSight connections, see [Manually Enabling Access to an Amazon Redshift Cluster in a VPC](#redshift-vpc-access) or [Manually Enabling Access to an Amazon Redshift Cluster That Is Not in a VPC](#redshift-classic-access)\.

To create and assign a security group for an Amazon Redshift cluster, you must have AWS credentials that permit access to that cluster\.

Enabling connection from Amazon QuickSight servers to your cluster is just one of several prerequisites for creating a data set based on an AWS database data source\. For more information about what is required, see [Creating Data Sets from New Database Data Sources](creating-database-data-sets.md)\.

## Manually Enabling Access to an Amazon Redshift Cluster in a VPC<a name="redshift-vpc-access"></a>

Use the following procedure to enable Amazon QuickSight access to an Amazon Redshift cluster in a VPC\.

**To enable Amazon QuickSight access to an Amazon Redshift cluster in a VPC**

1. Sign in to the AWS Management Console and open the Amazon Redshift console at [https://console\.aws\.amazon\.com/redshift/](https://console.aws.amazon.com/redshift/)\.

1. Choose the details page icon next to the cluster you want to make available, as shown following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/redshift-details.png)

1. Locate **Port** in the **Cluster Database Properties** section\. Note the **Port** value\. 

1. Locate **VPC ID** in the **Cluster Properties** section, note the **VPC ID** value\. Choose **View VPCs** to open the Amazon VPC Management Console\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/redshift-vpc.png)

1. On the Amazon VPC Management Console, choose **Security Groups** in the navigation pane\.

1. Choose **Create Security Group**\.

1. On the **Create Security Group** page, enter the security group information as follows:
   + For **Name tag** and **Group name**, type **Amazon\-QuickSight\-access**\.
   + For **Description**, type **Amazon\-QuickSight\-access**\.
   + For **VPC**, choose the VPC for your instance\. This is the VPC with the VPC ID that you noted\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/security-group.png)

1. Choose **Yes, Create**\.

1. Your new security group should be displayed on the screen\. Choose the security group\. Then, choose **Inbound Rules** from the tab list\. 

   Choose **Edit** to create a new rule\. Use the following values:
   + For **Type**, choose **Custom TCP Rule**\.
   + For **Protocol**, choose **TCP \(6\)**\.
   + For **Port Range**, enter the port number of the Amazon Redshift cluster to which you are providing access\. This is the port number you noted in an earlier step\.
   + For **Source**, type the CIDR address block for the region where you'll be using QuickSight\. For example, here is the CIDR address block for EU \(Ireland\): `52.210.255.224/27`\. For more information on the IP address ranges for Amazon QuickSight in supported regions, see [AWS Regions and IP Address Ranges](regions.md)\.
**Note**  
If you have activated Amazon QuickSight in multiple regions, you can create inbound rules for each Amazon QuickSight endpoint CIDR\. Doing this allows Amazon QuickSight to have access to the Amazon RDS DB instance from any region defined in the inbound rules\.   
An Amazon QuickSight user or administrator who uses Amazon QuickSight in multiple regions is treated as a single user\. In other words, even if you are using Amazon QuickSight in every region, both your Amazon QuickSight account and your users are global\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-rule.png)

1. Choose **Save** to save your new inbound rule\.

1. Return to the **Clusters** page of the Amazon Redshift Management Console, and then open the details page for the cluster that you want to enable access to\.

   Choose **Cluster**, and then choose **Modify**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/redshift-cluster-modify.png)

1. The currently assigned security groups are already chosen for **VPC Security Groups**\. Press CTRL and choose **Amazon\-QuickSight\-access** in addition to the other selected groups\.

1. Choose **Modify**\.

## Manually Enabling Access to an Amazon Redshift Cluster That Is Not in a VPC<a name="redshift-classic-access"></a>

Use the following procedure to access an Amazon Redshift cluster that is not in a VPC\.

**To access an Amazon Redshift cluster that is not in a VPC**

1. Sign in to the AWS Management Console and open the Amazon Redshift console at [https://console\.aws\.amazon\.com/redshift/](https://console.aws.amazon.com/redshift/)\.

1. Choose **Security** in the navigation pane\.

1. Choose **Create Cluster Security Group**\.

1. Type **Amazon\-QuickSight\-access** for the **Cluster Security Group Name** and **Description** values, and then choose **Create**\.

1. Select the details icon next to the security group, as shown following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/redshift-security-group-detail.png)

1. Choose **Add Connection Type**\.

1. Enter the connection information\.
   + For **Connection Type**, choose **CIDR/IP**\.
   + For **CIDR/IP to Authorize**, type the appropriate CIDR address block\. The supported IP address ranges for Amazon QuickSight regions, see [AWS Regions and IP Address Ranges](regions.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/redshift-cidr.png)

1. Choose **Authorize**\.

1. Return to the **Clusters** page of the Amazon Redshift console, open the details page for the cluster that you want to enable access to, choose **Cluster**, and then choose **Modify**\. 

1. The currently assigned security groups are already chosen for **Cluster Security Group**\. Press CTRL and choose **Amazon\-QuickSight\-access** in addition to the other selected groups\.

1. Choose **Modify**\.

## Enabling Access to Amazon Redshift Spectrum<a name="redshift-spectrum-access"></a>

Using Amazon Redshift Spectrum, you can connect Amazon QuickSight to an external catalog with Amazon Redshift\. For example, you can access the Athena catalog  and query unstructured data on your Amazon S3 data lake using an Amazon Redshift cluster instead of the Athena query engine\. 

You can also combine data sets that include data stored in Amazon Redshift and in S3\. Then you can access them using the SQL syntax in Amazon Redshift\. 

After you've registered your data catalog \(for Athena\) or external schema \(for a [Hive metastore](https://aws.amazon.com/blogs/big-data/migrate-external-table-definitions-from-a-hive-metastore-to-amazon-athena/)\), you can use Amazon QuickSight to select the external schema and the Amazon Redshift Spectrum tables\. This process works just as for any other Amazon Redshift tables in your cluster\. You don't need to load or transform your data\. 

For more information on using Amazon Redshift Spectrum, see [Using Amazon Redshift Spectrum to Query External Data](https://docs.aws.amazon.com/redshift/latest/dg/c-using-spectrum.html) in the *Amazon Redshift Database Developer Guide\.*

To connect using Redshift Spectrum, you need to do the following:
+ Create or identify an IAM role associated with the Amazon Redshift cluster\.
+ Add the IAM policies `AmazonS3ReadOnlyAccess` and `AmazonAthenaFullAccess` to the IAM role\.
+ Register an external schema or data catalog for the tables that you plan to use\.

Redshift Spectrum lets you separate storage from compute, so you can scale them separately\. You only pay for the queries that you run\.

To connect to Redshift Spectrum tables, you don't need to grant Amazon QuickSight access to Amazon S3 or Athena\. Amazon QuickSight only needs access to the Amazon Redshift cluster\. For full details on configuring Redshift Spectrum, see [Getting Started with Amazon Redshift Spectrum](https://docs.aws.amazon.com/redshift/latest/dg/c-getting-started-using-spectrum.html) in the *Amazon Redshift Database Developer Guide\.* 