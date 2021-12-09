# Use AWS Cloud9 with AWS CodeStar<a name="setting-up-ide-cloud9"></a>

You can use AWS Cloud9 to make code changes and develop software in an AWS CodeStar project\. AWS Cloud9 is an online IDE, which you access through your web browser\. The IDE offers a rich code editing experience with support for several programming languages and runtime debuggers, as well as a built\-in terminal\. In the background, an Amazon EC2 instance hosts an AWS Cloud9 development environment\. This environment provides the AWS Cloud9 IDE and access to the AWS CodeStar project's code files\. For more information, see the *[AWS Cloud9 User Guide](http://docs.aws.amazon.com/cloud9/latest/user-guide/)*\.

You can use the AWS CodeStar console or AWS Cloud9 console to create AWS Cloud9 development environments for projects that store their code in CodeCommit\. For AWS CodeStar projects that store their code in GitHub, you can only use the AWS Cloud9 console\. This topic describes how to use both consoles\.

To use AWS Cloud9, you need:
+ An IAM user that has been added as a team member to an AWS CodeStar project\.
+ If the AWS CodeStar project stores its source code in CodeCommit, AWS credentials for the IAM user\.

**Topics**
+ [Create an AWS Cloud9 Environment for a Project](#setting-up-ide-cloud9-create)
+ [Open an AWS Cloud9 Environment for a Project](#setting-up-ide-cloud9-open)
+ [Share an AWS Cloud9 Environment with a Project Team Member](#setting-up-ide-cloud9-share)
+ [Delete an AWS Cloud9 Environment from a Project](#setting-up-ide-cloud9-delete)
+ [Use GitHub with AWS Cloud9](#setting-up-ide-cloud9-github)
+ [Additional Resources](#setting-up-ide-cloud9-more)

## Create an AWS Cloud9 Environment for a Project<a name="setting-up-ide-cloud9-create"></a>

Follow these steps to create an AWS Cloud9 development environment for a AWS CodeStar project\. 

### Existing AWS CodeStar Project<a name="existing-project"></a>

Open the project in the AWS CodeStar console\. On the side navigation bar, choose **IDE**\. Choose **Create new environment**, and then use the following steps\.

**Important**  
If the project's source code is stored in GitHub, you won't see **IDE** on the side navigation bar\. However, you can use the AWS Cloud9 console to create a development environment, open the new environment, and then connect it to the project's GitHub repository\. Skip the following steps and see [Use GitHub with AWS Cloud9](#setting-up-ide-cloud9-github)\.  
If the project is in an AWS Region where AWS Cloud9 isn't supported, you won't see **IDE** on the side navigation bar\. However, you can use the AWS Cloud9 console to create a development environment, open the new environment, and then connect it to the project's AWS CodeCommit repository\. Skip the following steps and see [Creating an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/create-environment.html), [Opening an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/open-environment.html), and the [AWS CodeCommit Sample](http://docs.aws.amazon.com/cloud9/latest/user-guide/sample-codecommit.html) in the *AWS Cloud9 User Guide*\. For the list of supported AWS Regions, see [AWS Cloud9](https://docs.aws.amazon.com/general/latest/gr/rande.html#cloud9_region) in the *Amazon Web Services General Reference*\.

### New AWS CodeStar Project<a name="new-project"></a>

Follow the steps in [Create a Project](how-to-create-project.md)\. On **Set up tools**, for **Pick how you want to edit your code**, choose **Cloud9**\. Choose **Next**, and then use the following steps\.

**Important**  
If you choose to store the project's source code in GitHub, on **Set up tools**, you see **Connect to your source repository** instead of **Pick how you want to edit your code**\. There is no AWS Cloud9 option\. However, after AWS CodeStar creates the project, you can use the AWS Cloud9 console to create and open a development environment and then connect it to the project's GitHub repository\. Skip the following steps and see [Use GitHub with AWS Cloud9](#setting-up-ide-cloud9-github)\.  
If the project is in an AWS Region where AWS Cloud9 is not supported, on **Set up tools**, you won't see an option to choose AWS Cloud9\. However, you can use the AWS Cloud9 console to create and open a development environment and then connect it to the project's AWS CodeCommit repository\. Skip the following steps and see [Creating an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/create-environment.html), [Opening an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/open-environment.html), and the [AWS CodeCommit Sample](http://docs.aws.amazon.com/cloud9/latest/user-guide/sample-codecommit.html) in the *AWS Cloud9 User Guide*\. For the list of supported AWS Regions, see [AWS Cloud9](https://docs.aws.amazon.com/general/latest/gr/rande.html#cloud9_region) in the *Amazon Web Services General Reference*\.

On **Set up your AWS Cloud9 environment**, customize the project defaults\.

1. To change the default type of Amazon EC2 instance to host the environment, for **Pick an instance type for the IDE \(not your overall project\)**, choose the instance type\.

1. To change the default environment name and add a description, expand **Environment name and description**, and then make your changes\.
**Note**  
Environment names must be unique per user\.

1.  AWS Cloud9 uses Amazon Virtual Private Cloud \(Amazon VPC\) in your AWS account to communicate with the instance\. Depending on how Amazon VPC is set up in your AWS account, do one of the following\.  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/codestar/latest/userguide/setting-up-ide-cloud9.html)

   For more information, see [Amazon VPC Settings for AWS Cloud9 Development Environments](http://docs.aws.amazon.com/cloud9/latest/user-guide/vpc-settings.html) in the *AWS Cloud9 User Guide*\.

1. To change the default time period after which AWS Cloud9 shuts down the environment when it has not been used, expand **Cost\-saving options**, and then change the setting\.

1. Choose **Next**\.

To open the environment, see [Open an AWS Cloud9 Environment for a Project](#setting-up-ide-cloud9-open)\.

You can use these steps to create more than one environment for a project\. For example, you might want to use one environment to work on one portion of the code and another environment to work on the same portion of the code with different settings\.

## Open an AWS Cloud9 Environment for a Project<a name="setting-up-ide-cloud9-open"></a>

Follow these steps to open an AWS Cloud9 development environment that you created for an AWS CodeStar project\.

1. With the project open in the AWS CodeStar console, on the side navigation bar, choose **IDE**\.
**Important**  
If the project's source code is stored in GitHub, you won't see **IDE** on the side navigation bar\. However, you can use the AWS Cloud9 console to open an existing environment\. Skip the rest of this procedure and see [Opening an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/open-environment.html) in the *AWS Cloud9 User Guide* and [Use GitHub with AWS Cloud9](#setting-up-ide-cloud9-github)\.

1. For **Your AWS Cloud9 environments** or **Shared AWS Cloud9 environments**, choose **Open IDE** for the environment you want to open\.

You can use the AWS Cloud9 IDE to start working with code in the project's AWS CodeCommit repository right away\. For more information, see [The Environment Window](http://docs.aws.amazon.com/cloud9/latest/user-guide/tutorial.html#tutorial-environment), [The Editor, Tabs, and Panes](http://docs.aws.amazon.com/cloud9/latest/user-guide/tutorial.html#tutorial-editor), and [The Terminal](http://docs.aws.amazon.com/cloud9/latest/user-guide/tutorial.html#tutorial-terminal) in the *AWS Cloud9 User Guide* and [Basic Git Commands](https://docs.aws.amazon.com/codecommit/latest/userguide/how-to-basic-git.html) in the *AWS CodeCommit User Guide*\.

## Share an AWS Cloud9 Environment with a Project Team Member<a name="setting-up-ide-cloud9-share"></a>

After you create an AWS Cloud9 development environment for an AWS CodeStar project, you can invite other users across your AWS account, including project team members, to access that same environment\. This is especially useful for pair programming, where two programmers take turns coding and giving advice about the same code through screen sharing or while sitting at the same workstation\. Environment members can use the shared AWS Cloud9 IDE to see each member's code changes highlighted in the code editor and to text chat with other members while coding\. 

Adding a team member to a project doesn't automatically allow that member to participate in any related AWS Cloud9 development environments for the project\. To invite a project team member to access an environment for a project, you need to determine the correct environment member access role, apply AWS managed policies to the user, and invite the user to your environment\. For more information, see [About Environment Member Access Roles](http://docs.aws.amazon.com/cloud9/latest/user-guide/share-environment.html#share-environment-member-roles) and [Invite an IAM User to Your Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/share-environment.html#share-environment-invite-user) in the *AWS Cloud9 User Guide*\. 

When you invite a project team member to access an environment for a project, the AWS CodeStar console displays the environment to that team member\. The environment is displayed in the **Shared Cloud9 environments** list on the **IDE** tab in the AWS CodeStar console for the project\. To display this list, have the team member open the project in the console, and then choose **IDE** in the side navigation bar\.

**Important**  
If the project's source code is stored in GitHub, you won't see **IDE** on the side navigation bar\. However, you can use the AWS Cloud9 console to invite other users across your AWS account, including project team members, to access an environment\. To do this, see [Use GitHub with AWS Cloud9](#setting-up-ide-cloud9-github) in this guide, and see [About Environment Member Access Roles](http://docs.aws.amazon.com/cloud9/latest/user-guide/share-environment.html#share-environment-member-roles) and [Invite an IAM User to Your Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/share-environment.html#share-environment-invite-user) in the *AWS Cloud9 User Guide*\.

You can also invite a user who is not a project team member to access an environment\. For example, you might want a user to work on a project's code but have no other access to that project\. To invite this type of user, see [About Environment Member Access Roles](http://docs.aws.amazon.com/cloud9/latest/user-guide/share-environment.html#share-environment-member-roles) and [Invite an IAM User to Your Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/share-environment.html#share-environment-invite-user)in the *AWS Cloud9 User Guide*\. When you invite a user who is not a project team member to access an environment for a project, that user can use the AWS Cloud9 console to access the environment\. For more information, see [Open an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/open-environment.html) in the *AWS Cloud9 User Guide*\.

## Delete an AWS Cloud9 Environment from a Project<a name="setting-up-ide-cloud9-delete"></a>

When you delete a project and all its AWS resources from AWS CodeStar, all related AWS Cloud9 development environments that were created with the AWS CodeStar console are also deleted and cannot be recovered\. You can delete a development environment from a project without deleting the project\.

1. With the project open in the AWS CodeStar console, in the side navigation bar, choose **IDE**\.
**Important**  
If the project's source code is stored in GitHub, you won't see **IDE** on the side navigation bar\. However, you can use the AWS Cloud9 console to delete a development environment\. Skip the rest of this procedure and see [Deleting an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/delete-environment.html) in the *AWS Cloud9 User Guide*\.

1. On the tile for the environment you want to delete, choose the ellipses \(**…**\)\.

1. Enter the name for the development environment, and then choose **Delete**\.
**Warning**  
You cannot recover a development environment after it has been deleted\. All uncommitted code changes in the environment are lost\. 

## Use GitHub with AWS Cloud9<a name="setting-up-ide-cloud9-github"></a>

For AWS CodeStar projects that have their source code stored in GitHub, the AWS CodeStar console doesn't support working with AWS Cloud9 development environments directly\. However, you can use the AWS Cloud9 console to work with source code in GitHub repositories\.

1. Use the AWS Cloud9 console to create an AWS Cloud9 development environment\. For information, see [Creating an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/create-environment.html) in the *AWS Cloud9 User Guide*\.

1. Use the AWS Cloud9 console to open the development environment\. For information, see [Opening an Environment](http://docs.aws.amazon.com/cloud9/latest/user-guide/open-environment.html) in the *AWS Cloud9 User Guide*\.

1. In the IDE, use a terminal session to connect to the GitHub repository \(a process known as *cloning*\)\. If a terminal session isn't running, on the menu bar in the IDE, choose **Window, New Terminal**\. For the commands to use to clone the GitHub repository, see [Cloning a Repository](https://help.github.com/articles/cloning-a-repository/#platform-linux) on the GitHub Help website\.

   To navigate to the main page of the GitHub repository, with the project open in the AWS CodeStar console, on the side navigation bar, choose **Code**\.

1. Use the **Environment** window and editor tabs in the IDE to view, change, and save code\. For more information, see [The Environment Window](http://docs.aws.amazon.com/cloud9/latest/user-guide/tutorial.html#tutorial-environment) and [The Editor, Tabs, and Panes](http://docs.aws.amazon.com/cloud9/latest/user-guide/tutorial.html#tutorial-editor) in the *AWS Cloud9 User Guide*\.

1. Use Git in the IDE's terminal session to push your code changes to the repository and periodically pull code changes from others from the repository\. For more information, see [Pushing to a Remote Respository](https://help.github.com/articles/pushing-to-a-remote/) and [Fetching a Remote Repository](https://help.github.com/articles/fetching-a-remote/) on the GitHub Help website\. For Git commands, see [Git Cheatsheet](https://help.github.com/articles/git-cheatsheet/) on the GitHub Help website\.
**Note**  
To keep Git from prompting you for your GitHub user name and password every time you push or pull code from the repository, you can use a *credential helper*\. For more information, see [Caching Your GitHub Password in Git](https://help.github.com/articles/caching-your-github-password-in-git/) on the GitHub Help website\.

## Additional Resources<a name="setting-up-ide-cloud9-more"></a>

For more information about using AWS Cloud9, see the following in the *AWS Cloud9 User Guide*:
+ [Tutorial](http://docs.aws.amazon.com/cloud9/latest/user-guide/tutorial.html)
+ [Working with Environments](http://docs.aws.amazon.com/cloud9/latest/user-guide/environments.html)
+ [Working with the IDE](http://docs.aws.amazon.com/cloud9/latest/user-guide/ide.html)
+ [Samples](http://docs.aws.amazon.com/cloud9/latest/user-guide/samples.html)