# Walkthrough 6: Scaling Out Performance with Shards<a name="scale-out-performance"></a>

Amazon FSx for Windows File Server supports the use of the Microsoft Distributed File System \(DFS\)\. By using DFS Namespaces, you can scale out performance \(both read and write\) to serve I/O\-intensive workloads by spreading your file data across multiple Amazon FSx file systems\. At the same time, you can still present a unified view under a common namespace to your applications\. This solution involves dividing your file data into smaller datasets or *shards* and storing them across different file systems\. Applications accessing your data from multiple instances can achieve high levels of performance by reading and writing to these shards in parallel\.

You can use this solution when your workload requires uniformly distributed read/write access to your file data \(for example, if each subset of compute instances accesses a different portion of your file data\)\.

## Setting Up DFS Namespaces for Scale\-Out Performance<a name="fsx-scaleout-performance"></a>

The following procedure guides you through creating a DFS solution on Amazon FSx for scale\-out performance\. In this example, the data stored in the *corp* namespace is sharded alphabetically\. Data files ‘A\-F’, ‘G\-M’ and ‘N\-Z’ are all stored on different file shares\. Based on the type of data, I/O size, and I/O access pattern, you should decide how to best shard your data across multiple file shares\. Choose a sharding convention that distributes I/O evenly across all the file shares you plan on using\. Keep in mind that each namespace supports up to 50,000 file shares and hundreds of petabytes of storage capacity in aggregate\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/FSx-scale-out-performance.png)

**To set up DFS Namespaces for scale\-out performance**

1. If you don't already have DFS Namespace servers running, you can launch a pair of highly available DFS Namespace servers using the [setup\-DFSN\-servers\.template](https://s3.amazonaws.com/solution-references/fsx/dfs/setup-DFSN-servers.template) AWS CloudFormation template\. For more information on creating an AWS CloudFormation stack, see [Creating a Stack on the AWS CloudFormation Console](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-console-create-stack.html) in the *AWS CloudFormation User Guide*\.

1. Connect to one of the DFS Namespace servers launched in the previous step as a user in the **AWS Delegated Administrators** group\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. Access the DFS Management Console\. Open the **Start** menu and run **dfsmgmt\.msc**\. This opens the DFS Management GUI tool\.

1. Choose **Action** then **New Namespace**, type in the computer name of the first DFS Namespace server you launched for **Server** and choose **Next**\.

1. For **Name**, type in the namespace you're creating \(for example, **corp**\)\.

1. Choose **Edit Settings** and set the appropriate permissions based on your requirements\. Choose **Next**\.

1. Leave the default **Domain\-based namespace** option selected, leave the **Enable Windows Server 2008 mode** option selected, and choose **Next**\.
**Note**  
Windows Server 2008 mode is the latest available option for Namespaces\.

1. Review the namespace settings and choose **Create**\.

1. With the newly created namespace selected under **Namespaces** in the navigation bar, choose **Action** then **Add Namespace Server**\.

1. Type in the computer name of the second DFS Namespace server you launched for **Namespace server**\.

1. Choose **Edit Settings**, set the appropriate permissions based on your requirements, and choose **OK**\.

1. Open the context \(right\-click\) menu for the namespace you just created, choose **New Folder**, enter the name of the folder for the first shard \(for example, `A-F` for **Name**\), and choose **Add**\.

1. Type in the DNS name of the file share hosting this shard in UNC format \(for example, `\\fs-0123456789abcdef0.example.com\A-F`\) for **Path to folder target** and choose **OK**\.

1. If the share doesn't exist:

   1. Choose **Yes** to create it\.

   1. From the **Create Share** dialog, choose **Browse**\.

   1. Choose an existing folder, or create a new folder under **D$**, and choose **OK**\.

   1. Set the appropriate share permissions, and choose **OK**\.

1. With the folder target now added for the shard, choose **OK**\.

1. Repeat the last four steps for other shards you want to add to the same namespace\.