# Tutorial: Working with Amazon DynamoDB and Apache Hive<a name="EMRforDynamoDB.Tutorial"></a>

In this tutorial, you will launch an Amazon EMR cluster, and then use Apache Hive to process data stored in a DynamoDB table\.

*Hive* is a data warehouse application for Hadoop that allows you to process and analyze data from multiple sources\. Hive provides a SQL\-like language, *HiveQL*, that lets you work with data stored locally in the Amazon EMR cluster or in an external data source \(such as Amazon DynamoDB\)\.

For more information, see to the [Hive Tutorial](https://cwiki.apache.org/confluence/display/Hive/Tutorial)\.

**Topics**
+ [Before You Begin](#EMRforDynamoDB.Tutorial.BeforeYouBegin)
+ [Step 1: Create an Amazon EC2 Key Pair](EMRforDynamoDB.Tutorial.EC2KeyPair.md)
+ [Step 2: Launch an Amazon EMR Cluster](EMRforDynamoDB.Tutorial.LaunchEMRCluster.md)
+ [Step 3: Connect to the Master Node](EMRforDynamoDB.Tutorial.ConnectToMasterNode.md)
+ [Step 4: Load Data into HDFS](EMRforDynamoDB.Tutorial.LoadDataIntoHDFS.md)
+ [Step 5: Copy Data to DynamoDB](EMRforDynamoDB.Tutorial.CopyDataToDDB.md)
+ [Step 6: Query the Data in the DynamoDB Table](EMRforDynamoDB.Tutorial.QueryDataInDynamoDB.md)
+ [Step 7: \(Optional\) Clean Up](EMRforDynamoDB.Tutorial.CleanUp.md)

## Before You Begin<a name="EMRforDynamoDB.Tutorial.BeforeYouBegin"></a>

For this tutorial, you will need the following:
+ An AWS account\. If you do not have one, see [Signing Up for AWS](SettingUp.DynamoWebService.md#SettingUp.DynamoWebService.SignUpForAWS)\.
+ An SSH client \(Secure Shell\)\. You use the SSH client to connect to the master node of the Amazon EMR cluster and run interactive commands\. SSH clients are available by default on most Linux, Unix, and Mac OS X installations\. Windows users can download and install the [PuTTY](http://www.chiark.greenend.org.uk/~sgtatham/putty/) client, which has SSH support\.

**Next Step**  
[Step 1: Create an Amazon EC2 Key Pair](EMRforDynamoDB.Tutorial.EC2KeyPair.md)