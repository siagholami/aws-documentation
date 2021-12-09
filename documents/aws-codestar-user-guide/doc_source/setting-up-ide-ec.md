# Use Eclipse with AWS CodeStar<a name="setting-up-ide-ec"></a>

You can use Eclipse to make code changes and develop software in an AWS CodeStar project\. You can edit your AWS CodeStar project code with Eclipse and then commit and push your changes to the source repository for the AWS CodeStar project\.

**Note**  
The information in this topic applies only to AWS CodeStar projects that store their source code in CodeCommit\. If your AWS CodeStar project stores its source code in GitHub, you can use a tool such as EGit for Eclipse\. For more information, see the [EGit Documentation](http://www.eclipse.org/egit/documentation/) on the EGit website\. 

If the AWS CodeStar project stores its source code in CodeCommit, you must install a version of the AWS Toolkit for Eclipse that supports AWS CodeStar\. You must also be a member of the AWS CodeStar project team with the owner or contributor role\.

To use Eclipse, you also need:
+ An IAM user that has been added to an AWS CodeStar project as a team member\.
+ If the AWS CodeStar project stores its source code in CodeCommit, [Git credentials](getting-started.md#git-credentials) \(user name and password\) for the IAM user\.
+ Sufficient permissions to install Eclipse and the AWS Toolkit for Eclipse on your local computer\.

**Topics**
+ [Step 1: Install AWS Toolkit for Eclipse](#setting-up-ide-ec-install)
+ [Step 2: Import Your AWS CodeStar Project to Eclipse](#setting-up-ide-ec-config)
+ [Step 3: Edit AWS CodeStar Project Code in Eclipse](#setting-up-ide-ec-edit)

## Step 1: Install AWS Toolkit for Eclipse<a name="setting-up-ide-ec-install"></a>

The Toolkit for Eclipse is a software package you can add to Eclipse\. It is installed and managed in the same way as other software packages in Eclipse\. The AWS CodeStar toolkit is included as part of the Toolkit for Eclipse\.

**To install the Toolkit for Eclipse with the AWS CodeStar module**

1. Install Eclipse on your local computer\. Supported versions of Eclipse include Luna, Mars, and Neon\.

1. Download and install the Toolkit for Eclipse\. For more information, see the [AWS Toolkit for Eclipse Getting Started Guide](https://docs.aws.amazon.com/AWSToolkitEclipse/latest/GettingStartedGuide/setup-install.html)\.

1. In Eclipse, choose **Help**, and then choose **Install New Software**\.

1. In **Available Software**, choose **Add**\.

1. In **Add Repository**, choose **Archive**, browse to the location where you saved the \.zip file, and open the file\. Leave **Name** blank, and then choose **OK**\. 

1. In **Available Software**, choose **Select all** to select **AWS Core Management Tools** and **Developer Tools**, and then choose **Next**\. 

1. In **Install Details**, choose **Next**\.

1. In **Review Licenses**, review the license agreements\. Choose **I accept the terms of the license agreement**, and then choose **Finish**\. Restart Eclipse\.

## Step 2: Import Your AWS CodeStar Project to Eclipse<a name="setting-up-ide-ec-config"></a>

After you have installed the Toolkit for Eclipse, you can import AWS CodeStar projects and edit, commit, and push code from the IDE\. 

**Note**  
You can add multiple AWS CodeStar projects to a single workspace in Eclipse, but you must update your project credentials when you change from one project to another\.

**To import an AWS CodeStar project**

1. From the AWS menu, choose **Import AWS CodeStar Project**\. Alternatively, choose **File**, and then choose **Import**\. In **Select**, expand **AWS**, and then choose ** AWS CodeStar Project**\. 

   Choose **Next**\.

1. In **AWS CodeStar Project Selection**, choose your AWS profile and the AWS Region where the AWS CodeStar project is hosted\. If you do not have an AWS profile configured with an access key and secret key on your computer, choose **Configure AWS accounts** and follow the instructions\. 

   In **Select AWS CodeStar project and repository**, choose your AWS CodeStar project\. In **Configure Git credentials**, enter the user name and password you generated for access to the project's repository\. \(If you don't have Git credentials, see [Getting Started](getting-started.md#git-credentials)\.\) Choose **Next**\.  
![\[Choosing an AWS CodeStar project in Eclipse\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/adh-ide-eclipse1.png)

1. All branches of the project's repository are selected by default\. If you don't want to import one or more branches, clear the boxes, and then choose **Next**\.

1. In **Local Destination**, choose a destination where the import wizard creates the local repo on your computer, and then choose **Finish**\. 

1. In **Project Explorer**, expand the project tree to browse the files in the AWS CodeStar project\.

## Step 3: Edit AWS CodeStar Project Code in Eclipse<a name="setting-up-ide-ec-edit"></a>

 After you have imported an AWS CodeStar project into an Eclipse workspace, you can edit the code for the project, save your changes, and commit and push your code to the source repository for the project\. This is the same process you follow for any Git repository using the EGit plugin for Eclipse\. For more information, see the [EGit User Guide](https://wiki.eclipse.org/EGit/User_Guide) on the Eclipse website\. 

**To edit project code and make your first commit to the source repository for an AWS CodeStar project**

1. In **Project Explorer**, expand the project tree to browse the files in the AWS CodeStar project\. 

1. Edit one or more code files and save your changes\. 

1. When you are ready to commit your changes, open the context menu for that file, choose **Team**, and then choose **Commit**\. 

   You can skip this step if the **Git Staging** window is already open in your project view\.

1. In **Git Staging**, stage your changes by moving changed files into **Staged Changes**\. Enter a commit message in **Commit Message**, and then choose **Commit and Push**\.  
![\[Pushing a change to an AWS CodeStar project in Eclipse\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/adh-ide-eclipse2.png)

To view the deployment of your code changes, return to the dashboard for your project\. For more information, see [Step 3: View Your Project](getting-started.md#getting-started-view)\.