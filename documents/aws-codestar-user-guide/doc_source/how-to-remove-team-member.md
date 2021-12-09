# Remove Team Members from an AWS CodeStar Project<a name="how-to-remove-team-member"></a>

After you remove a user from an AWS CodeStar project, the user still appears in the commit history for the project repository, but no longer has access to the CodeCommit repository or any other project resources, such as the project pipeline\. \(The exception to this rule is an IAM user who has other policies that grant access to those resources\.\) The user cannot access the project dashboard, and the project no longer appears in the list of projects that user sees on the AWS CodeStar dashboard\. You can use the AWS CodeStar console or AWS CLI to remove team members from your project team\.

**Important**  
Although removing a team member from a project denies remote access to project Amazon EC2 instances, it does not close any of the user's active SSH sessions\.  
Removing a team member does not affect that team member's access to any resources that are outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\)\. Those access permissions are controlled by the resource provider, not AWS CodeStar\. For more information, see the resource provider's documentation\.  
Removing a team member from a project does not automatically delete that team member's related AWS Cloud9 development environments or prevent that member from participating in any related AWS Cloud9 development environments they have been invited to\. To delete a development environment, see [Delete an AWS Cloud9 Environment from a Project](setting-up-ide-cloud9.md#setting-up-ide-cloud9-delete)\. To prevent a team member from participating in a shared environment, see [Share an AWS Cloud9 Environment with a Project Team Member](setting-up-ide-cloud9.md#setting-up-ide-cloud9-share)\.

To remove a team member from a project, you must have the AWS CodeStar owner role for that project or have the `AWSCodeStarFullAccess` policy applied to your account\.

**Topics**
+ [Remove Team Members \(Console\)](#how-to-remove-team-member-console)
+ [Remove Team Members \(AWS CLI\)](#how-to-remove-team-member-cli)

## Remove Team Members \(Console\)<a name="how-to-remove-team-member-console"></a>

You can use the AWS CodeStar console to remove team members from your project team\. 

**To remove a team member from a project**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose the project\.

1. In the navigation bar for the project, choose **Team**\.

1. On the **Team members** page, find the name of the team member you want to remove, and then choose **Remove**\.

## Remove Team Members \(AWS CLI\)<a name="how-to-remove-team-member-cli"></a>

You can use the AWS CLI to remove team members from your project team\. 

**To remove a team member**

1. Open a terminal or command window\.

1. Run the disassociate\-team\-member command with the `--project-id` and `-user-arn`\. For example:

   ```
   aws codestar disassociate-team-member --project-id my-first-projec --user-arn arn:aws:iam:111111111111:user/John_Doe 
   ```

   This command returns output similar to the following:

   ```
   {
       "projectId": "my-first-projec", 
       "userArn": "arn:aws:iam::111111111111:user/John_Doe"
   }
   ```