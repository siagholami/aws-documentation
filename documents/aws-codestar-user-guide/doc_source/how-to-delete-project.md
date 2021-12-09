# Delete an AWS CodeStar Project<a name="how-to-delete-project"></a>

If you no longer need a project, you can delete it and its resources so that you do not incur any further charges in AWS\. When you delete a project, all team members are removed from that project\. Their project roles are removed from their IAM users, but their user profiles in AWS CodeStar are not changed\. You can use the AWS CodeStar console or AWS CLI to delete a project\.<a name="adh-keep-resources"></a>

**Important**  
Deleting a project in AWS CodeStar cannot be undone\. By default all AWS resources for the project are deleted in your AWS account, including:  
The CodeCommit repository for the project along with anything stored in that repository\.
The AWS CodeStar project roles and the associated IAM policies configured for the project and its resources\.
Any Amazon EC2 instances created for the project\.
The deployment application and associated resources, such as:  
A CodeDeploy application and associated deployment groups\.
An AWS Lambda function and associated API Gateway APIs\.
An AWS Elastic Beanstalk application and associated environment\.
The continuous deployment pipeline for the project in CodePipeline\.
The AWS CloudFormation stacks associated with the project\.
Any AWS Cloud9 development environments created with the AWS CodeStar console\. All uncommitted code changes in the environments are lost\. 
To delete all project resources along with the project, select the **Delete associated resources along with AWS CodeStar project** check box\. If you clear this option, the project is deleted in AWS CodeStar, and the project roles that enabled access to those resources are deleted in IAM, but all other resources are retained\. You might continue to incur charges for these resources in AWS\. If you decide you no longer want one or more of these resources, you must manually delete them\. For more information, see [Project deletion: An AWS CodeStar project was deleted, but resources still exist](troubleshooting.md#troubleshooting-pd1)\.  
If you decide to keep resources when you delete a project, as a best practice, copy the list of resources from the project details page\. This way, you have a record of all resources that you have kept, even though the project no longer exists\.

**Topics**
+ [Delete a Project in AWS CodeStar \(Console\)](#how-to-delete-project-console)
+ [Delete a Project in AWS CodeStar \(AWS CLI\)](#how-to-delete-project-cli)

## Delete a Project in AWS CodeStar \(Console\)<a name="how-to-delete-project-console"></a>

You can use the AWS CodeStar console to delete a project\.<a name="adh-delete-project"></a>

**To delete a project in AWS CodeStar**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Find the project in the list, and from the ellipsis \(**…**\), choose **Delete**\.

   Or, open the project, and in the navigation pane, choose **Project**\. On the project details page, choose **Delete project**\.

1. In **Type the following project ID to confirm**, enter the ID of the project, and then choose **Delete**\.

   Deleting a project can take several minutes\. After it's deleted, the project no longer appears in the list of projects in the AWS CodeStar console\. 
**Important**  
By default, when you delete a project, all resources listed under **Project resources** are deleted\. If you clear the check box, the project resources are retained\. For more information, go [here](#adh-keep-resources)\.   
If your project uses resources outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\), those resources are not deleted, even if you select the check box\.  
Your project cannot be deleted if any AWS CodeStar managed policies have been manually attached to roles that are not IAM users\. If you have attached your project's managed policies to a federated user's role, you must detach the policy before you can delete the project\. For more information, see [Detach an AWS CodeStar Managed Policy from the Federated User's Role](access-permissions-federated.md#access-permissions-federated-detach-CodeStar)\.

## Delete a Project in AWS CodeStar \(AWS CLI\)<a name="how-to-delete-project-cli"></a>

You can use the AWS CLI to delete a project\. 

**To delete a project in AWS CodeStar**

1. At a terminal \(Linux, macOS, or Unix\) or command prompt \(Windows\), run the delete\-project command, including the name of the project\. For example, to delete a project with the ID *my\-2nd\-project*: 

   ```
   aws codestar delete-project --id my-2nd-project
   ```

   This command returns output similar to the following:

   ```
   {
       "projectArn":"arn:aws:codestar:us-east-2:111111111111:project/my-2nd-project"
   }
   ```

1. Run the list\-projects command and verify that the deleted project no longer appears in the list of projects associated with your AWS account\.

   ```
   aws codestar list-projects
   ```