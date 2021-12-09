# Step 4: Test the Connectivity to the Aurora MySQL DB Instance<a name="CHAP_RDSOracle2Aurora.Steps.ConnectAurora"></a>

Next, test your connection to your Aurora MySQL DB instance\.

**To test the connection to your Aurora MySQL DB instance using SQL Workbench/J**

1. In SQL Workbench/J, choose **File**, then choose **Connect window**\. Choose the Create a new connection profile icon\. using the following information: Connect to the Aurora MySQL DB instance in SQL Workbench/J by using the information as shown following    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.ConnectAurora.html)

1. Test the connection by choosing **Test**\. Choose **OK** to close the dialog box, then choose OK to create the connection profile\.  
![\[Connecting to the Aurora MySQL DB instance for AWS Database Migration Service\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora10.png)
**Note**  
If your connection is unsuccessful, ensure that the IP address you assigned when creating the CloudFormation template is the one you are attempting to connect from\. This is the most common issue when trying to connect to an instance\.

1. Log on to the Aurora MySQL instance by using the master admin credentials\.

1. Verify your connectivity to the Aurora MySQL DB instance by running a sample SQL command, such as `SHOW DATABASES;`\.  
![\[Connecting to the Aurora MySQL DB instance for AWS Database Migration Service\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora10.5.png)