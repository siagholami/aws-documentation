# Getting Started with AWS CodeStar<a name="getting-started"></a>

In this tutorial, you use AWS CodeStar to create a web application\. This project includes sample code in a source repository, a continuous deployment toolchain, and a project dashboard where you can view and monitor your project\.

By following the steps, you:
+ Create a project in AWS CodeStar\.
+ Explore the project\.
+ Commit a code change\.
+ See your code change deployed automatically\.
+ Add other people to work on your project\.
+ Clean up project resources when they're no longer needed\.

**Note**  
If you haven't already, first complete the steps in [Setting Up AWS CodeStar](setting-up.md), including [Step 2: Create the AWS CodeStar Service Role](setting-up.md#setting-up-create-service-role)\. You must be signed in with an account that is an administrative user in IAM\. To create a project, you must sign in to the AWS Management Console using an IAM user that has the **`AWSCodeStarFullAccess`** policy\. 

**Topics**
+ [Step 1: Create an AWS CodeStar Project](#getting-started-create)
+ [Step 2: Add Display Information for Your AWS CodeStar User Profile](#getting-started-add-owner)
+ [Step 3: View Your Project](#getting-started-view)
+ [Step 4: Customize the Team Wiki Tile and the Project Dashboard](#getting-started-custom)
+ [Step 5: Commit a Change](#getting-started-commit)
+ [Step 6: Add More Team Members](#getting-started-add-team-member)
+ [Step 7: Clean Up](#getting-started-clean)
+ [Step 8: Get Your Project Ready for a Production Environment](#getting-started-production-ready)
+ [Next Steps](#getting-started-next-steps)
+ [Tutorial: Creating and Managing a Serverless Project in AWS CodeStar](sam-tutorial.md)
+ [Tutorial: Create a Project in AWS CodeStar with the AWS CLI](cli-tutorial.md)
+ [Tutorial: Create an Alexa Skill Project in AWS CodeStar](alexa-tutorial.md)

## Step 1: Create an AWS CodeStar Project<a name="getting-started-create"></a>

In this step, you create a JavaScript \(Node\.js\) software development project for a web application\. You use an AWS CodeStar project template to create the project\. 

**Note**  
The AWS CodeStar project template used in this tutorial uses the following options:  
**Application category**: Web application
**Programming language**: Node\.js
**AWS Service**: Amazon EC2
If you choose other options, your experience might not match what's documented in this tutorial\.<a name="adh-create-project"></a>

**To create a project in AWS CodeStar**

1. Sign in to the AWS Management Console, and then open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Make sure that you are signed in to the AWS Region where you want to create the project and its resources\. For example, to create a project in US East \(Ohio\), make sure you have selected that AWS Region\. For information about AWS Regions where AWS CodeStar is available, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#codestar_region) in the *AWS General Reference* \.

1. On the **AWS CodeStar** page, choose **Create a new project**\. \(If you are the first user to create a project, choose **Start a project**\.\)

1. On the **Choose a project template** page, choose the project type from the list of AWS CodeStar project templates\. You can use the filter bar to narrow your choices\. For example, for a web application project written in Node\.js to be deployed to Amazon EC2 instances, select the **Web application**, **Node\.js**, and **Amazon EC2** check boxes\. Then choose from the templates available for that set of options\.

   For more information, see [AWS CodeStar Project Templates](templates.md)\.

1. In **Project name**, enter a name for the project, such as *My First Project*\. The ID for the project is derived from this project name, but is limited to 15 characters\. 

   For example, the default ID for a project named *My First Project* is *my\-first\-projec*\. This project ID is the basis for the names of all resources associated with the project\. AWS CodeStar uses this project ID as part of the URL for your code repository and for the names of related security access roles and policies in IAM\. After the project is created, the project ID cannot be changed\. To edit the project ID before you create the project, choose **Edit**\. 

   For information about the limits on project names and project IDs, see [Limits in AWS CodeStar](limits.md)\.
**Note**  
Project IDs must be unique for your AWS account in an AWS Region\. 

1. Choose the repository provider, **AWS CodeCommit** or **GitHub**\. 

1. If you chose **AWS CodeCommit**, for **Repository name**, accept the default AWS CodeCommit repository name, or enter a different one\. Then skip ahead to step 8\.

1. If you chose **GitHub**, choose **Connect with GitHub**\. 

   1. If the **Sign in to GitHub** page is displayed, enter your GitHub user name or email address and password, and then choose **Sign in**\.
**Note**  
You must have a GitHub account to complete this page\. For more information, see [Join GitHub](https://github.com/join) on the GitHub website\.

   1. If the **Two\-factor authentication** page is displayed, for **Authentication code**, enter the code that GitHub sends you, and then choose **Verify**\.

   1. On the **Authorize AWS CodeStar** page, choose **Authorize**\.
**Note**  
When you choose **Authorize**, you allow AWS CodeStar to create a GitHub repository for your personal GitHub account, or for any GitHub organization where you have permissions\. \(A green check in **Organization access** is used to indicate permissions\.\)  
To add a GitHub organization to the **Organization access** list, follow the instructions in [Inviting Users to Join Your Organization](https://help.github.com/articles/inviting-users-to-join-your-organization/) on the GitHub Help website\. After you join the organization, refresh the **Authorize AWS CodeStar** page to see the organization in the list\.   
To get permissions to authorize a GitHub organization that is in the list, but does not have a green check, choose **Grant**\. If you see **Request** instead, choose it, and then follow the instructions in [Approving OAuth Apps for Your Organization](https://help.github.com/articles/approving-oauth-apps-for-your-organization/) on the GitHub Help website\. Refresh the **Authorize AWS CodeStar** page to see the **Grant** button\.

   1. For **Owner**, choose the GitHub organization or your personal GitHub account\.

   1. For **Repository name**, accept the default GitHub repository name, or enter a different one\.

   1. Choose **Public repository** or **Private repository**\.
**Note**  
Depending on your GitHub account type, GitHub might not allow you to create a private repository\. For more information, see [GitHub Pricing](https://github.com/pricing) on the GitHub website\. Also, if you want to use AWS Cloud9 as your development environment, you must choose a public repository\.

   1. \(Optional\) For **Repository description**, enter a description for the GitHub repository\.

1. Choose **Next**\.

1. Review the resources and configuration details\. Choose **Edit Amazon EC2 Configuration** \(where available\) if your project is deployed to Amazon EC2 instances and you want to make changes\. For example, you can choose from available instance types for your project\. 
**Note**  
Different Amazon EC2 instance types provide different levels of computing power and might have different associated costs\. For more information, see [Amazon EC2 Instance Types](https://aws.amazon.com/ec2/instance-types/) and [Amazon EC2 Pricing](https://aws.amazon.com/ec2/pricing/)\.  
If you have more than one virtual private cloud \(VPC\) or multiple subnets created in Amazon Virtual Private Cloud, you can also choose the VPC and subnet to use\. However, if you choose an Amazon EC2 instance type that is not supported on dedicated instances, you cannot choose a VPC whose instance tenancy is set to **Dedicated**\.   
For more information, see [What Is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Introduction.html) and [Dedicated Instance Basics](https://docs.aws.amazon.com/vpc/latest/userguide/dedicated-instance.html#dedicated-howitworks)\.

1. Leave the **AWS CodeStar would like permission to administer AWS resources on your behalf** check box selected\. Otherwise, you cannot create a project\. For more information about the service role, see [AWS CodeStar Service Role Policy and Permissions](access-permissions-service-role.md)\.

   Choose **Next** or **Create project**\. \(The displayed choice depends on your project template\.\) 

1. In **Choose an Amazon EC2 Key Pair**, choose the Amazon EC2 key pair you created in [Step 4: Create an Amazon EC2 Key Pair for AWS CodeStar Projects](setting-up.md#setting-up-create-ec2-key)\. Select **I acknowledge that I have access to the private key file for this key pair**, and then choose **Create project**\.

1. It might take a few minutes to create the project \(including the repository\)\. After your project has a repository, you can use the **Set up tools** page to configure access to it, or you can choose **Skip** and configure access later\. After your project has been created, you can use the links on the **Welcome** tile to configure other items, such as your [user profile in AWS CodeStar](working-with-user-info.md)\. 

## Step 2: Add Display Information for Your AWS CodeStar User Profile<a name="getting-started-add-owner"></a>

When you create a project, you're added to the project team as an owner\. If this is the first time you've used AWS CodeStar, you are asked to provide:
+ Your display name to show to other users\.
+ The email address to show to other users\.

This information is used in your AWS CodeStar user profile\. User profiles are not project\-specific, but are limited to an AWS Region\. You must create a user profile in each AWS Region in which you belong to projects\. Each profile can contain different information, if you prefer\.

Enter a user name and email address, and then choose **Next**\.

**Note**  
This user name and email address is used in your AWS CodeStar user profile\. If your project uses resources outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\), those resource providers might have their own user profiles, with different user names and email addresses\. For more information, see the resource provider's documentation\.

## Step 3: View Your Project<a name="getting-started-view"></a>

Your AWS CodeStar project dashboard is where you and your team view the status of your project resources, including the latest commits to your project, the state of your continuous delivery pipeline, and the performance of your instances\. This information is displayed on tiles that are dedicated to a resource\. To see more information about any of these resources, choose the details link on the tile\. The AWS service console opens on the details page for that resource\.

You can change where each tile appears on your dashboard by dragging and dropping it to a new location\. You can also use the ellipsis menu on each tile to remove that tile from the display\. To add a tile, in the dashboard, choose **Add tile**\.

In your new project, you see the following tiles:
+ The **Welcome** tile contains links to actions you might want to perform\. Unlike other tiles, you cannot move this tile to another location, or add it back after closing it\. 
+ The **Continuous deployment** tile displays a summary view of the continuous delivery pipeline for your project\. The pipeline deploys the web application code when there is a change in your repository\. Because your project is new, the pipeline immediately starts deploying the sample code\. You can see the processing and completion of each stage as your web application is deployed\.     

  You can also see if a stage has a problem or requires approval\. To see details about the state of the pipeline, its stages and actions, or to add or edit a stage, choose **CodePipeline details**\.
+ The **Application endpoints** tile displays links to the endpoints where you can view your software\.    Choose the link to view your application or service\.
+ The **Commit history** tile displays the recent commit history of the repository\. When you first create a project, the most recent commit is the one made by AWS CodeStar\. This commit started running the sample code through the pipeline\. When you make another commit, it appears in the history, too\. That code change starts running through the pipeline automatically\. To view the commits of a different branch, use the branch selector button\. To view all commits or details about the commits or repository, choose **CodeCommit details** \(if the code is stored in CodeCommit\) or **Open in GitHub** \(if the source code is stored in GitHub\)\.
+ The **Application activity** tile displays Amazon CloudWatch metrics for your project\. For example, it displays the CPU utilization of any Amazon EC2 instances deployed to by AWS Elastic Beanstalk or CodeDeploy resources in your pipeline\. In projects that use AWS Lambda, it displays invocation and error metrics for the Lambda function\. This information is displayed by the hour\. If you used the suggested AWS CodeStar project template for this tutorial, you should see a noticeable spike in activity as your application is first deployed to those instances\. You can refresh monitoring to see changes in your instance health, which can help you identify problems or the need for more resources\. 
**Note**  
If your AWS CodeStar project includes more than one metric, you can filter the display by choosing a metric in the tile\.
+ The **JIRA** tile is for integrating your AWS CodeStar project with an Atlassian JIRA project\. Configuring this tile makes it possible for you and your project team to track JIRA issues from the project dashboard\. To configure this tile, choose **Connect**, and then follow the instructions\.
+ There is also a **Team wiki** tile\. You can customize the contents of this tile to store team notes, link to useful resources for your team project, provide samples, and so on\. You customize this tile in the next step\.

## Step 4: Customize the Team Wiki Tile and the Project Dashboard<a name="getting-started-custom"></a>

Each AWS CodeStar project includes a customizable team wiki tile that can be used for any purpose \(for example, adding links to team resources or showing code snippets for a preferred development style\)\. This tile supports both plain text and formatted content\. In this step, you customize this tile to include a link to the AWS DevOps blog\.

**To customize the team wiki tile**

1. In the project dashboard, on the team wiki tile, choose the ellipsis menu, and then choose **Edit**\.

1. In **Widget title**, enter **Team links**\. In **Markdown content**, add an item to the list and paste the following:

   ```
   [AWS DevOps Blog](https://aws.amazon.com/blogs/devops/)
   ```

   Choose **Save**\.

1. Choose the link on the tile to test it\.

**To customize your dashboard appearance**

1. Choose one of the tiles on the dashboard\. Drag and drop it to a new position\. You can rearrange dashboard tiles to put the most important information in the most visible position\.

1. To remove a tile, choose the ellipsis menu \(**…**\) on the tile, and then choose **Remove from Dashboard**\.

1. To add a tile, at the top of the dashboard, choose **Add tile** and then choose the tile to add\. You can only have one of each kind of tile on your dashboard\.

## Step 5: Commit a Change<a name="getting-started-commit"></a>

First, take a look at the sample code that was included in your project, and see what the application looks like\. On the **Application endpoints** tile, choose the link to your endpoint\. Your sample web application is displayed in a new window or browser tab\. This is the project sample that AWS CodeStar built and deployed\. 

If you'd like to look at the code, in the navigation bar, choose **Code**\. Your project's repository opens in a new tab or window\. Read the contents of the repository's readme file \(`README.md`\), and browse the content of those files\.

In this step, you make a change to the code and then push the change to your repository\. You can do this in one of several ways: 
+ If the project's code is stored in a CodeCommit or GitHub repository, you can use AWS Cloud9 to work with the code directly from your web browser, without installing any tools\. For more information, see [Create an AWS Cloud9 Environment for a Project](setting-up-ide-cloud9.md#setting-up-ide-cloud9-create)\.
+ If the project's code is stored in a CodeCommit repository, and you have Visual Studio or Eclipse installed, you can use the AWS Toolkit for Visual Studio or AWS Toolkit for Eclipse to more easily connect to the code\. For more information, see [Use an IDE with AWS CodeStar](setting-up-ide.md)\. If you don't have Visual Studio or Eclipse, install a Git client, and follow the instructions later in this step\.
+ If the project's code is stored in a GitHub repository, you can use your IDE's tools for connecting to GitHub\.
  + For Visual Studio, you can use a tools such as the GitHub Extension for Visual Studio\. For more information, see the [Overview](https://visualstudio.github.com/index.html) page on the GitHub Extension for Visual Studio website and [Getting Started with GitHub for Visual Studio](https://github.com/github/VisualStudio/blob/master/docs/getting-started/index.md) on the GitHub website\.
  + For Eclipse, you can use a tool such as EGit for Eclipse\. For more information, see the [EGit Documentation](http://www.eclipse.org/egit/documentation/) on the EGit website\.
  + For other IDEs, consult your IDE's documentation\.
+ For other types of code repositories, see the repository provider's documentation\. 

The following instructions show you how to make a minor change to the sample\. <a name="git-credentials"></a><a name="getting-started-git-credentials"></a>

**To set up your computer to commit changes \(IAM user\)**
**Note**  
In this procedure, we assume that your project's code is stored in a CodeCommit repository\. For other types of code repositories, see the repository provider's documentation, and then skip ahead to the next procedure, [To clone the project repository and make a change](#clone-repo)\.  
If the code is stored in CodeCommit and you are already using CodeCommit or you used the AWS CodeStar console to create an AWS Cloud9 development environment for the project, you don't need more configuration\. Skip ahead to the next procedure, [To clone the project repository and make a change](#clone-repo)\.

1. [Install Git](https://git-scm.com/downloads) on your local computer\.

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

   Sign in as the IAM user who will use Git credentials for connections to your AWS CodeStar project repository in CodeCommit\.

1. In the IAM console, in the navigation pane, choose **Users**, and from the list of users, choose your IAM user\. 

1. On the user details page, choose the **Security Credentials** tab, and in **HTTPS Git credentials for CodeCommit**, choose **Generate**\.  
![\[Generating Git credentials in the IAM console\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/codecommit-iam-gc1.png)
**Note**  
You cannot choose your own user name or password for Git credentials\. For more information, see [Use Git Credentials and HTTPS with CodeCommit](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_ssh-keys.html#git-credentials-code-commit)\.

1. Copy the user name and password that IAM generated for you\. You can choose **Show** and then copy and paste this information into a secure file on your local computer, or you can choose **Download credentials** to download this information as a \.CSV file\. You need this information to connect to CodeCommit\.  
![\[Downloading Git credentials from the IAM console\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/codecommit-iam-gc2.png)

   After you have saved your credentials, choose **Close**\.
**Important**  
This is your only chance to save the user name and password\. If you do not save them, you can copy the user name from the IAM console, but you cannot look up the password\. You must reset the password and then save it\.

**To set up your computer to commit changes \(federated user\)**

You can use the console to upload files to your repository, or you can use Git to connect from your local computer\. If you are using federated access, follow these steps to use Git to connect to and clone your repository from your local computer\.
**Note**  
In this procedure, we assume that your project's code is stored in a CodeCommit repository\. For other types of code repositories, see the repository provider's documentation, and then skip ahead to the next procedure, [To clone the project repository and make a change](#clone-repo)\.

1. [Install Git](https://git-scm.com/downloads) on your local computer\.

1. [Install the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/installing.html)\.

1. Configure your temporary security credentials for a federated user\. For information, see [Temporary Access to CodeCommit Repositories](https://docs.aws.amazon.com/codecommit/latest/userguide/temporary-access.html)\. Temporary credentials consist of:
   + AWS access key
   + AWS secret key
   + Session token

   For more information about temporary credentials, see [Permissions for GetFederationToken](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_getfederationtoken.html)\.

1. Connect to your repository using the AWS CLI credential helper\. For information, see [Setup Steps for HTTPS Connections to CodeCommit Repositories on Linux, macOS, or Unix with the AWS CLI Credential Helper](https://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-https-unixes.html) or [Setup Steps for HTTPS Connections to CodeCommit Repositories on Windows with the AWS CLI Credential Helper](https://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-https-windows.html) 

1. The following example shows how to connect to a CodeCommit repository and push a commit to it\.<a name="clone-repo"></a><a name="getting-started-clone-repo"></a>

**Example: To clone the project repository and make a change**
**Note**  
This procedure shows how to clone the project's code repository to your computer, make a change to the project's `index.html` file, and then push your change to the remote repository\. In this procedure, we assume that your project's code is stored in a CodeCommit repository and that you're using a Git client from the command line\. For other types of code repositories or tools, see the provider's documentation for how to clone the repository, change the file, and then push the code\.

1. If you used the AWS CodeStar console to create an AWS Cloud9 development environment for the project, open the development environment, and then skip to step 3 in this procedure\. To open the development environment, see [Open an AWS Cloud9 Environment for a Project](setting-up-ide-cloud9.md#setting-up-ide-cloud9-open)\.

   With your project open in the AWS CodeStar console, on the navigation bar, choose the **Project** gear icon, and then choose the **Connect tools** button\. In **Clone repository URL**, choose the protocol for the connection type you have set up for CodeCommit, and then copy the link\. For example, if you followed the steps in the previous procedure to set up Git credentials for CodeCommit, choose **HTTPS**\.

1. On your local computer, open a terminal or command line window and change directories to a temporary directory\. Run the git clone command to clone the repository to your computer\. Paste the link you copied\. For example, for CodeCommit using HTTPS:

   ```
   git clone https://git-codecommit.us-east-2.amazonaws.com/v1/repos/my-first-projec
   ```

   The first time you connect, you are prompted for the user name and password for the repository\. For CodeCommit, enter the Git credentials user name and password you downloaded in the previous procedure\.

1. Navigate to the cloned directory on your computer and browse the contents\. 

1. Open the `index.html` file \(in the public folder\)  and make a change to the file\.  For example, add a paragraph after the `<H2>` tag such as:

   ```
   <P>Hello, world!</P> 
   ```

   Save the file\.

1. At the terminal or command prompt, add your changed file, and then commit and push your change:

   ```
   git add index.html
   git commit -m "Making my first change to the web app"
   git push
   ```

1. On your project dashboard, view the changes in progress\. You should see that the commit history for the repository is updated with your commit, including the commit message\. You can also see the pipeline pick up your change to the repository and start building and deploying it\. After your web application is deployed, you can use the links you added to the project information tile to view your change\. 
**Note**  
If **Failed** is displayed for any of the pipeline stages, see the following for troubleshooting help:  
For the **Source** stage, see [Troubleshooting AWS CodeCommit](https://docs.aws.amazon.com/codecommit/latest/userguide/troubleshooting.html) in the *AWS CodeCommit User Guide*\.
For the **Build** stage, see [Troubleshooting AWS CodeBuild](https://docs.aws.amazon.com/codebuild/latest/userguide/troubleshooting.html) in the *AWS CodeBuild User Guide*\.
For the **Deploy** stage, see [Troubleshooting AWS CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/troubleshooting.html) in the *AWS CloudFormation User Guide*\.
For other issues, see [Troubleshooting AWS CodeStar](troubleshooting.md)\.

## Step 6: Add More Team Members<a name="getting-started-add-team-member"></a>

Every AWS CodeStar project is already configured with three AWS CodeStar roles\. Each role provides its own level of access to the project and its resources:
+ **Owner**: Can add and remove team members, change the project dashboard, and delete the project\.
+ **Contributor**: Can change the project dashboard and contribute code if the code is stored in CodeCommit, but cannot add or remove team members or delete the project\. This is the role you should choose for most team members in an AWS CodeStar project\.
+ **Viewer**: Can view the project dashboard, project code if the code is stored in CodeCommit, and the state of the project, but cannot move, add, or remove tiles from the project dashboard\.

**Important**  
If your project uses resources outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\), access to those resources is controlled by the resource provider, not AWS CodeStar\. For more information, see the resource provider's documentation\.  
Anyone who has access to an AWS CodeStar project might be able to use the AWS CodeStar console to access resources that are outside of AWS but are related to the project\.  
AWS CodeStar does not allow project team members to participate in any related AWS Cloud9 development environments for a project\. To allow a team member to participate in a shared environment, see [Share an AWS Cloud9 Environment with a Project Team Member](setting-up-ide-cloud9.md#setting-up-ide-cloud9-share)\.

For more information about teams and project roles, see [Working with AWS CodeStar Teams](working-with-teams.md)\.<a name="adh-add-tm"></a>

**To add a team member to an AWS CodeStar project \(console\)**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose the project\.

1. In the navigation bar for the project, choose **Team**\.

1. On the **Team members** page, choose **Add team member**\.

1. In **Choose user**, do one of the following: 
   + If an IAM user already exists for the person you want to add, choose the IAM user name from the list\. 
**Note**  
Users who have already been added to another AWS CodeStar project appear in the **AWS CodeStar users from other projects** list\.

     On the **Add team member** tab, in **Project role**, choose the AWS CodeStar role \(Owner, Contributor, or Viewer\) for this user\. This is an AWS CodeStar project\-level role that can only be changed by an owner of the project\. When applied to an IAM user, the role provides all permissions required to access AWS CodeStar project resources\. It applies policies required for creating and managing Git credentials for code stored in CodeCommit in IAM or uploading Amazon EC2 SSH keys for the user in IAM\. 
**Important**  
You cannot provide or change the display name or email information for an IAM user unless you are signed in to the console as that user\. For more information, see [Manage Display Information for Your AWS CodeStar User Profile ](how-to-manage-user-pref.md)\.

     Choose **Add**\.  
![\[Adding an existing IAM user to the team for a project\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/adh-team-add.png)
   + If an IAM user does not exist for the person you want to add to the project, choose **Create new IAM user**\. Enter the IAM user name, AWS CodeStar display name, email address, and project role you want to apply to this new user, and then choose **Create**\.   
![\[Creating a new IAM user to add to the team for a project\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/adh-team-add-new.png)

     You are redirected to the IAM console to confirm user creation\. Choose **Create user**, save the password information for that new user, and then choose **Close** to return to the AWS CodeStar console\. The user is added to the project with the role you chose\.
**Note**  
For ease of management, at least one user should be assigned the Owner role for the project\.

1. Send the new team member the following information:
   + Connection information for your AWS CodeStar project\.
   + If the source code is stored in CodeCommit, [instructions for setting up access with Git credentials](https://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-gc.html) to the CodeCommit repository from their local computers\.
   + Information about how the user can manage their display name, email address, and public Amazon EC2 SSH key, as described in [Working with Your AWS CodeStar User Profile ](working-with-user-info.md)\.
   + One\-time password and connection information, if the user is new to AWS and you created an IAM user for that person\. The password expires the first time the user signs in\. The user must choose a new password\.

## Step 7: Clean Up<a name="getting-started-clean"></a>

Congratulations\! You've finished the tutorial\. If you don't want to continue to use this project and its resources, you should delete it to avoid possible continued charges to your AWS account\. <a name="adh-delete-project"></a>

**To delete a project in AWS CodeStar**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Find the project in the list, and from the ellipsis \(**…**\), choose **Delete**\.

   Or, open the project, and in the navigation pane, choose **Project**\. On the project details page, choose **Delete project**\.

1. In **Type the following project ID to confirm**, enter the ID of the project, and then choose **Delete**\.

   Deleting a project can take several minutes\. After it's deleted, the project no longer appears in the list of projects in the AWS CodeStar console\. 
**Important**  
By default, when you delete a project, all resources listed under **Project resources** are deleted\. If you clear the check box, the project resources are retained\. For more information, go [here](how-to-delete-project.md#adh-keep-resources)\.   
If your project uses resources outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\), those resources are not deleted, even if you select the check box\.  
Your project cannot be deleted if any AWS CodeStar managed policies have been manually attached to roles that are not IAM users\. If you have attached your project's managed policies to a federated user's role, you must detach the policy before you can delete the project\. For more information, see [Detach an AWS CodeStar Managed Policy from the Federated User's Role](access-permissions-federated.md#access-permissions-federated-detach-CodeStar)\.

## Step 8: Get Your Project Ready for a Production Environment<a name="getting-started-production-ready"></a>

After you have created your project, you are ready to create, test, and deploy code\. Review the following considerations for maintaining your project in a production environment:
+ Regularly apply patches and review security best practices for the dependencies used by your application\. For more information, see [Security Best Practices for AWS CodeStar Resources](best-practices.md#best-practices-security)\.
+ Regularly monitor the environment settings suggested by the programming language for your project\.

## Next Steps<a name="getting-started-next-steps"></a>

Here are some other resources to help you learn about AWS CodeStar:
+ The [Tutorial: Creating and Managing a Serverless Project in AWS CodeStar](sam-tutorial.md) uses a project that creates and deploys a web service using logic in AWS Lambda and can be called by an API in Amazon API Gateway\.
+ [AWS CodeStar Project Templates](templates.md) describes other types of projects you can create\.
+ [Customize an AWS CodeStar Dashboard](how-to-customize.md) provides more information about customizing project dashboards, integrating with JIRA, and more\.
+ [Working with AWS CodeStar Teams](working-with-teams.md) provides information about enabling others to help you work on your projects\.