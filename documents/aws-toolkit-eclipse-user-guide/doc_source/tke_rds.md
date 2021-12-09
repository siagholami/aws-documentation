# Connecting to Amazon Relational Database Service \(Amazon RDS\)<a name="tke_rds"></a>

In this section, we’ll use the AWS Toolkit for Eclipse to connect to a database instance on the Amazon Relational Database Service \(Amazon RDS\)\. Before stepping through the process described below, you will need to have an RDS database instance associated with your AWS account\. You can create a database instance on RDS using the [AWS Management Console](https://console.aws.amazon.com/console/home)\. When you create a database instance, set the TCP port that the database uses to receive connections to a value that is accessible from your location\. For example, if you are behind a firewall, choose a TCP port to which your firewall allows connections\. For more information, see the [Amazon RDS User Guide](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/)\.

1. In **AWS Explorer**, expand the **Amazon RDS** node\. You should see a list of the database instances that are associated with your AWS account\. Right\-click one of these instances, and then click **Connect** \.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-rds-aws-explorer-connect.png)

1. The AWS Toolkit for Eclipse displays an authentication dialog box\. Enter the master password that you specified when you created the database instance\. Click **Finish**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-rds-auth.png)

1. The AWS Toolkit for Eclipse brings up the connection to the database instance in the Eclipse Data Source Explorer\. From here, you can inspect the structure and data in the database\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-rds-data-source-explorer.png)