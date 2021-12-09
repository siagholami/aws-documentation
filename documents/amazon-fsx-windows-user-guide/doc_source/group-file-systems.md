# Grouping Multiple File Systems with DFS Namespaces<a name="group-file-systems"></a>

Amazon FSx for Windows File Server supports the use of Microsoft's Distributed File System \(DFS\) Namespaces\. You can use DFS Namespaces to group file shares on multiple file systems into one common folder structure \(a namespace\) that you use to access the entire file dataset\. DFS Namespaces can help you to organize and unify access to your file shares across multiple file systems\. DFS Namespaces can also help to scale file data storage beyond what each file system supports \(64 TB\) for large file datasets—up to hundreds of petabytes\.

## Setting Up DFS Namespaces for Grouping Multiple File Systems<a name="group-fsx-namespace"></a>

You can use DFS Namespaces to group multiple file systems under a single namespace\. In the example that follows, the domain\-based namespace \(example\.com\\corp\) is created on two namespace servers, consolidating file shares stored on multiple Amazon FSx file systems \(finance, marketing, sales, home\_directories\)\. This allows your users to access file shares using a common namespace\. Given this, they don't need to specify file\-system DNS names for each of the file systems hosting the file shares\.

These steps guide you through creating a single namespace \(example\.com\\corp\) on two namespace servers\. You also set up four file shares under the namespace, each transparently redirecting users to shares hosted on separate Amazon FSx file systems\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/FSx-common-namespace.png)

**To group multiple file systems into a common DFS namespace**

1. If you don't already have DFS Namespace servers running, you can launch a pair of highly available DFS Namespace servers using the [setup\-DFSN\-servers\.template](https://solution-references.s3.amazonaws.com/fsx/dfs/setup-DFSN-servers.template) AWS CloudFormation template\. For more information on creating an AWS CloudFormation stack, see [Creating a Stack on the AWS CloudFormation Console](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-console-create-stack.html) in the *AWS CloudFormation User Guide*\.

1. Connect to one of the DFS Namespace servers launched in the previous step as a user in the **AWS Delegated Administrators** group\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. Access the DFS Management Console by opening\. Open the **Start** menu and run **dfsmgmt\.msc**\. This opens the DFS Management GUI tool\.

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

1. Open the context \(right\-click\) menu for the namespace you just created, choose **New Folder**, type in the name of the folder \(for example, `finance` for **Name**, and choose **OK**\.

1. Type in the DNS name of the file share that you want the DFS Namespace folder to point to in UNC format \(for example, `\\fs-0123456789abcdef0.example.com\finance`\) for **Path to folder target** and choose **OK**\.

1. If the share doesn't exist:

   1. Choose **Yes** to create it\.

   1. From the **Create Share** dialog, choose **Browse**\.

   1. Choose an existing folder, or create a new folder under **D$**, and choose **OK**\.

   1. Set the appropriate share permissions, and choose **OK**\.

1. From the **New Folder** dialog, choose **OK**\. The new folder will be created under the namespace\.

1. Repeat the last four steps for other folders you want to share under the same namespace\.