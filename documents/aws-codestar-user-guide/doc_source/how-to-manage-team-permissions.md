# Manage Permissions for AWS CodeStar Team Members<a name="how-to-manage-team-permissions"></a>

You change permissions for team members by changing their AWS CodeStar role\. Each team member can be assigned to only one role in an AWS CodeStar project, but many users can be assigned to the same role\. You can use the AWS CodeStar console or AWS CLI to manage permissions\.

**Important**  
To change a role for a team member, you must either have the AWS CodeStar owner role for that project or have the `AWSCodeStarFullAccess` policy applied\.  
Changing a team member's permissions does not affect that team member's access to any resources that are outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\)\. Those access permissions are controlled by the resource provider, not AWS CodeStar\. For more information, see the resource provider's documentation\.  
Anyone who has access to an AWS CodeStar project may be able to use the AWS CodeStar console to access resources that are outside of AWS but are related to that project\.  
Changing a team member's role for a project does not automatically allow or prevent that member from participating in any AWS Cloud9 development environments for the project\. To allow or prevent a team member from participating in a shared environment, see [Share an AWS Cloud9 Environment with a Project Team Member](setting-up-ide-cloud9.md#setting-up-ide-cloud9-share)\.

You can also grant permissions for users to remotely access any Amazon EC2 Linux instances associated with the project\. After you grant this permission, the user must upload an SSH public key that is associated with their AWS CodeStar user profile across all team projects\. To successfully connect to the Linux instances, the user must have SSH configured and the private key on the local computer\.

**Topics**
+ [Manage Team Permissions \(Console\)](#how-to-manage-team-permissions-console)
+ [Manage Team Permissions \(AWS CLI\)](#how-to-manage-team-permissions-cli)

## Manage Team Permissions \(Console\)<a name="how-to-manage-team-permissions-console"></a>

You can use the AWS CodeStar console to manage the roles of team members\. You can also manage whether team members have remote access to the Amazon EC2 instances associated with your project\.

**To change the role of a team member**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose the project\.

1. In the navigation bar for the project, choose **Team**\.

1. On the **Team members** page, find the name of the team member, and then choose **Edit**\.

1. In **Role**, choose the AWS CodeStar role \(owner, contributor, or viewer\) you want to grant this user\.

   For more information about AWS CodeStar roles and their permissions, see [Working with AWS CodeStar Teams](working-with-teams.md)\.

   Choose **Save**\.

**To grant a team member remote access permissions to Amazon EC2 instances**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose the project\.

1. In the navigation bar for the project, choose **Team**\.

1. On the **Project team** page, find the name of the team member, and then choose **Edit**\.

1. Select **Allow SSH access to project instances**, and then choose **Save**\.

1. \(Optional\) Notify the team members that they should upload an SSH public key for their AWS CodeStar users, if they have not already done so\. For more information, see [Add a Public Key to Your AWS CodeStar User Profile ](how-to-add-ec2-key.md)\.

## Manage Team Permissions \(AWS CLI\)<a name="how-to-manage-team-permissions-cli"></a>

You can use the AWS CLI to manage the project role assigned to a team member\. You can use the same AWS CLI commands to manage whether that team member has remote access to Amazon EC2 instances associated with your project\.

**To manage the permissions for a team member**

1. Open a terminal or command window\.

1. Run the update\-team\-member command with the `--project-id`, `-user-arn`, and `--project-role` parameters\. You can also specify whether the user has remote access to project instances by including the `--remote-access-allowed` or `--no-remote-access-allowed` parameters\. For example, to update the project role of an IAM user named John\_Doe and change his permissions to viewer with no remote access to project Amazon EC2 instances:

   ```
   aws codestar update-team-member --project-id my-first-projec --user-arn arn:aws:iam:111111111111:user/John_Doe --project-role Viewer --no-remote-access-allowed
   ```

   This command returns output similar to the following:

   ```
   {
   	"projectRole":"Viewer",
   	"remoteAccessAllowed":false,
   	"userArn":"arn:aws:iam::111111111111:user/John_Doe"
   }
   ```