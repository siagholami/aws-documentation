# Step 4: Test the Connectivity to the Amazon Redshift Database<a name="CHAP_RDSOracle2Redshift.Steps.ConnectRedshift"></a>

Next, test your connection to your Amazon Redshift database\.

**To test the connection to your Amazon Redshift database using SQL Workbench/J**

1. In SQL Workbench/J, choose **File**, then choose **Connect window**\. Choose the **Create a new connection profile** icon\. Connect to the Amazon Redshift database in SQL Workbench/J by using the information shown following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.ConnectRedshift.html)

1. Test the connection by choosing **Test**\. Choose **OK** to close the dialog box, then choose **OK** to create the connection profile\.  
![\[Connecting to the Amazon Redshift DB instance for AWS Database Migration Service\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift10.png)
**Note**  
If your connection is unsuccessful, ensure that the IP address you assigned when creating the CloudFormation template is the one you are attempting to connect from\. This issue is the most common one when trying to connect to an instance\.

1. Verify your connectivity to the Amazon Redshift DB instance by running a sample SQL command, such as `select current_date;`\.