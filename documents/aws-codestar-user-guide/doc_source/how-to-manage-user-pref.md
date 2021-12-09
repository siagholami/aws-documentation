# Manage Display Information for Your AWS CodeStar User Profile<a name="how-to-manage-user-pref"></a>

You can use the AWS CodeStar console or AWS CLI to change the display name and email address in your user profile\. A user profile is not project\-specific\. It is associated with your IAM user, and is applied across the AWS CodeStar projects you belong to in an AWS Region\. If you belong to projects in more than one AWS Region, you have separate user profiles\. 

You can only manage your own user profile in the AWS CodeStar console\. If you have the `AWSCodeStarFullAccess` policy, you can use the AWS CLI to view and manage other profiles\.

**Note**  
The information in this topic covers only your AWS CodeStar user profile\. If your project uses resources outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\), those resource providers might use their own user profiles, which might have different settings\. For more information, see the resource provider's documentation\.

**Topics**
+ [Manage Your User Profile \(Console\)](#how-to-manage-user-pref-console)
+ [Manage User Profiles \(AWS CLI\)](#how-to-manage-user-pref-cli)

## Manage Your User Profile \(Console\)<a name="how-to-manage-user-pref-console"></a>

You can manage your user profile in the AWS CodeStar console by navigating to any project where you are a team member and changing your profile information\. Because user profiles are user\-specific, not project\-specific, your user profile changes appear in every project in an AWS Region where you are a team member\.

**Important**  
To use the console to change the display information for a user, you must be signed in as that IAM user\. No other user, even those with the AWS CodeStar owner role for a project or with the `AWSCodeStarFullAccess` policy applied, can change your display information\.

**To change your display information in all projects in an AWS region**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose a project where you are a team member\.

1. In the navigation bar for the project, choose **Team**\.

1. On the **Team members** page, find the name of your IAM user \(the team member that has your IAM name in parentheses and **\[You\]** in brackets next to the display name\), and then choose **Edit**\.

1. Edit the display name, the email address, or both, and then choose **Save**\.
**Note**  
A display name and email address are required\. For more information, see [Limits in AWS CodeStar](limits.md)\. 

## Manage User Profiles \(AWS CLI\)<a name="how-to-manage-user-pref-cli"></a>

You can use the AWS CLI to create and manage your user profile in AWS CodeStar\. You can also use the AWS CLI to view your user profile information, and to view all user profiles configured for your AWS account in an AWS Region\. 

Make sure that your AWS profile is configured for the region where you want to create, manage, or view user profiles\. 

**To create a user profile**

1. Open a terminal or command window\.

1. Run the create\-user\-profile command with the `user-arn`, `display-name`, and `email-address` parameters\. For example:

   ```
   aws codestar create-user-profile --user-arn arn:aws:iam:111111111111:user/John_Stiles --display-name "John Stiles" --email-address "john_stiles@example.com"
   ```

   This command returns output similar to the following:

   ```
   {
   	"createdTimestamp":1.491439687681E9,"
   	displayName":"John Stiles",
   	"emailAddress":"john.stiles@example.com",
   	"lastModifiedTimestamp":1.491439687681E9,
   	"userArn":"arn:aws:iam::111111111111:user/Jane_Doe"
   }
   ```

**To view your display information**

1. Open a terminal or command window\.

1. Run the describe\-user\-profile command with the `user-arn` parameter\. For example:

   ```
   aws codestar describe-user-profile --user-arn arn:aws:iam:111111111111:user/Mary_Major
   ```

   This command returns output similar to the following:

   ```
   {
   	"createdTimestamp":1.490634364532E9,
   	"displayName":"Mary Major",
   	"emailAddress":"mary.major@example.com",
   	"lastModifiedTimestamp":1.491001935261E9,
   	"sshPublicKey":"EXAMPLE=",
   	"userArn":"arn:aws:iam::111111111111:user/Mary_Major"
   }
   ```

**To change your display information**

1. Open a terminal or command window\.

1. Run the update\-user\-profile command with the `user-arn` parameter and the profile parameters you want to change, such as `display-name` or `email-address`\. For example, if a user with the display name Jane Doe wants to change her display name to Jane Mary Doe:

   ```
   aws codestar update-user-profile --user-arn arn:aws:iam:111111111111:user/Jane_Doe --display-name "Jane Mary Doe"
   ```

   This command returns output similar to the following:

   ```
   {
   	"createdTimestamp":1.491439687681E9,
   	"displayName":"Jane Mary Doe",
   	"emailAddress":"jane.doe@example.com",
   	"lastModifiedTimestamp":1.491442730598E9,
   	"sshPublicKey":"EXAMPLE1",
   	"userArn":"arn:aws:iam::111111111111:user/Jane_Doe"
   }
   ```

**To list all user profiles in an AWS region in your AWS account**

1. Open a terminal or command window\.

1. Run the aws codestar list\-user\-profiles command\. For example:

   ```
   aws codestar list-user-profiles 
   ```

   This command returns output similar to the following:

   ```
   {
     "userProfiles":[
   	{
   		"displayName":"Jane Doe",
   		"emailAddress":"jane.doe@example.com",
   		"sshPublicKey":"EXAMPLE1",
   		"userArn":"arn:aws:iam::111111111111:user/Jane_Doe"
   	},
   	{
   		"displayName":"John Doe",
   		"emailAddress":"john.doe@example.com",
   		"sshPublicKey":"EXAMPLE2",
   		"userArn":"arn:aws:iam::111111111111:user/John_Doe"
   	},
   	{
   		"displayName":"Mary Major",
   		"emailAddress":"mary.major@example.com",
   		"sshPublicKey":"EXAMPLE=",
   		"userArn":"arn:aws:iam::111111111111:user/Mary_Major"
   	},
   	{
   		"displayName":"John Stiles",
   		"emailAddress":"john.stiles@example.com",
   		"sshPublicKey":"",
   		"userArn":"arn:aws:iam::111111111111:user/John_Stiles"
   	}
     ]
   }
   ```