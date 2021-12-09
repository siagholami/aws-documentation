# Use Visual Studio with AWS CodeStar<a name="setting-up-ide-vs"></a>

You can use Visual Studio to make code changes and develop software in an AWS CodeStar project\. 

**Note**  
The information in this topic applies only to AWS CodeStar projects that store their source code in CodeCommit\. If your AWS CodeStar project stores its source code in GitHub, you can use a tool such as the GitHub Extension for Visual Studio\. For more information, see the [Overview](https://visualstudio.github.com/index.html) page on the GitHub Extension for Visual Studio website and [Getting Started with GitHub for Visual Studio](https://github.com/github/VisualStudio/blob/master/docs/getting-started/index.md) on the GitHub website\.

To use Visual Studio to edit code in the source repository for an AWS CodeStar project, you must install a version of the AWS Toolkit for Visual Studio that supports AWS CodeStar\. You must be a member of the AWS CodeStar project team with the owner or contributor role\.

To use Visual Studio, you also need:
+ An IAM user that has been added to an AWS CodeStar project as a team member\.
+ AWS credentials for your IAM user \(for example, your access key and secret key\)\.
+ Sufficient permissions to install Visual Studio and the AWS Toolkit for Visual Studio on your local computer\.

The Toolkit for Visual Studio is a software package you can add to Visual Studio\. It is installed and managed in the same way as other software packages in Visual Studio\. 

**To install the Toolkit for Visual Studio with the AWS CodeStar module and configure access to your project repository**

1. Install Visual Studio on your local computer\. 

1. Download and install the Toolkit for Visual Studio and save the \.zip file to a local folder or directory\. On the **Getting Started with the AWS Toolkit for Visual Studio** page, enter or import your AWS credentials, and then choose** Save and Close**\.

1. In **Visual Studio**, open **Team Explorer**\. In **Hosted Service Providers**, find **CodeCommit**, and choose **Connect**\.

1. In **Manage Connections**, choose **Clone**\. Choose your project's repository and the folder on your local computer where you want to clone the repository, and then choose **OK**\.

1. If you are prompted to create Git credentials, choose **Yes**\. The toolkit attempts to create credentials on your behalf\. Save the credentials file in a secure location\. This is the only opportunity you have to save these credentials\. If the toolkit cannot create credentials on your behalf, or if you chose **No**, you must create and provide your own Git credentials\. For more information, see [To set up your computer to commit changes \(IAM user\)](getting-started.md#getting-started-git-credentials) or follow the online directions\.

   When you have finished cloning the project, you're ready to start editing your code in Visual Studio and committing and pushing your changes to your project's repository in CodeCommit\. 