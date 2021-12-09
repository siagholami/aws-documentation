# Add Team Members to an AWS CodeStar Project<a name="how-to-add-team-member"></a>

If you have the owner role in an AWS CodeStar project or have the `AWSCodeStarFullAccess` policy applied to your IAM user, you can add other IAM users to the project team\. This is a simple process that applies an AWS CodeStar role \(owner, contributor, or viewer\) to the user\. These roles are per\-project and customized\. For example, a contributor team member in project A might have permissions to resources that are different from those of a contributor team member in project B\. A team member can have only one role in a project\. After you've added a team member, he or she can interact immediately with your project at the level defined by the role\. 

Benefits of AWS CodeStar roles and team membership include:
+ You do not have to manually configure permissions in IAM for your team members\. 
+ You can easily change a team member's level of access to a project\.
+ Users can access project dashboards in the AWS CodeStar console only if they are team members\. 
+ User access to a project is defined by role\. 

For more information about teams and AWS CodeStar roles, see [Working with AWS CodeStar Teams](working-with-teams.md) and [Working with Your AWS CodeStar User Profile ](working-with-user-info.md)\.

To add a team member to a project, you must either have the AWS CodeStar owner role for the project or the `AWSCodeStarFullAccess` policy\. 

**Important**  
Adding a team member does not affect that member's access to resources that are outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\)\. Those access permissions are controlled by the resource provider, not AWS CodeStar\. For more information, see the resource provider's documentation\.  
Anyone who has access to an AWS CodeStar project can  use the AWS CodeStar console to access resources that are outside of AWS but related to that project\.  
Adding a team member to a project does not automatically allow that member to participate in any related AWS Cloud9 development environments for the project\. To allow a team member to participate in a shared environment, see [Share an AWS Cloud9 Environment with a Project Team Member](setting-up-ide-cloud9.md#setting-up-ide-cloud9-share)\.  
Granting federated user access to a project involves manually attaching the AWS CodeStar owner, contributor, or viewer managed policy to the role assumed by the federated user\. For more information, see [Federated User Access to AWS CodeStar](access-permissions-federated.md)\.

**Topics**
+ [Add a Team Member \(Console\)](#how-to-add-team-member-console)
+ [Add and View Team Members \(AWS CLI\)](#how-to-add-team-member-cli)

## Add a Team Member \(Console\)<a name="how-to-add-team-member-console"></a>

You can use the AWS CodeStar console to add a team member to your project\. If an IAM user already exists for the person you want to add, you can add the IAM user\. Otherwise, you can create an IAM user for that person when you add them to your project\.<a name="adh-add-tm"></a>

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

## Add and View Team Members \(AWS CLI\)<a name="how-to-add-team-member-cli"></a>

You can use the AWS CLI to add team members to your project team\. You can also view information about all of the team members in your project\.

**To add a team member**

1. Open a terminal or command window\.

1. Run the associate\-team\-member command with the `--project-id`, `-user-arn`, and `--project-role` parameters\. You can also specify whether the user has remote access to project instances by including the `--remote-access-allowed` or `--no-remote-access-allowed` parameters\. For example:

   ```
   aws codestar associate-team-member --project-id my-first-projec --user-arn arn:aws:iam:111111111111:user/Jane_Doe --project-role Contributor --remote-access-allowed
   ```

   This command returns no output\.

**To view all team members \(AWS CLI\)**

1. Open a terminal or command window\.

1. Run the list\-team\-members command with the `--project-id` parameter\. For example:

   ```
   aws codestar list-team-members --project-id my-first-projec
   ```

   This command returns output similar to the following:

   ```
   {
       "teamMembers":[
   		  {"projectRole":"Owner","remoteAccessAllowed":true,"userArn":"arn:aws:iam::111111111111:user/Mary_Major"},
   		  {"projectRole":"Contributor","remoteAccessAllowed":true,"userArn":"arn:aws:iam::111111111111:user/Jane_Doe"},
   		  {"projectRole":"Contributor","remoteAccessAllowed":true,"userArn":"arn:aws:iam::111111111111:user/John_Doe"},
   		  {"projectRole":"Viewer","remoteAccessAllowed":false,"userArn":"arn:aws:iam::111111111111:user/John_Stiles"}
   	]
   }
   ```