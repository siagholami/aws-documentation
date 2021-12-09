# Working with AWS CodeStar Teams<a name="working-with-teams"></a>

After you create a development project, grant access to others so you can work together\. In AWS CodeStar, each project has a *project team*\. A user can belong to multiple AWS CodeStar projects and have different AWS CodeStar roles \(and thus, different permissions\) in each\. In the AWS CodeStar console, users see all projects associated with your AWS account, but they can view and work only on those projects in which they are team members\.

Team members can choose a friendly name for themselves\. They can also add an email address so other team members can contact them\. Team members who are not owners cannot change their AWS CodeStar role for the project\. 

Each project in AWS CodeStar has three roles:


**Roles and Permissions in an AWS CodeStar Project**  

| Role Name | View Project Dashboard and Status | Add/Remove/Access Project Resources | Add/Remove Team Members | Delete Project | 
| --- | --- | --- | --- | --- | 
| Owner | x | x | x | x | 
| Contributor | x | x |  |  | 
| Viewer | x |  |  |  | 
+ **Owner**: Can add and remove other team members, contribute code to a project repository if the code is stored in CodeCommit, grant or deny other team members remote access to any Amazon EC2 instances running Linux associated with the project, configure the project dashboard, and delete the project\.
+ **Contributor**: Can add and remove dashboard resources such as a JIRA tile, contribute code to the project repository if the code is stored in CodeCommit, and interact fully with the dashboard\. Cannot add or remove team members, grant or deny remote access to resources, or delete the project\. This is the role you should choose for most team members\.
+ **Viewer**: Can view the project dashboard, the code if is stored in CodeCommit, and, on the dashboard tiles, the state of the project and its resources\.

**Important**  
If your project uses resources outside of AWS \(for example, a GitHub repository or issues in Atlassian JIRA\), access to those resources is controlled by the resource provider, not AWS CodeStar\. For more information, see the resource provider's documentation\.  
Anyone who has access to an AWS CodeStar project can use the AWS CodeStar console to access resources that are outside of AWS but related to the project\.  
AWS CodeStar does not automatically allow project team members to participate in any related AWS Cloud9 development environments for a project\. To allow a team member to participate in a shared environment, see [Share an AWS Cloud9 Environment with a Project Team Member](setting-up-ide-cloud9.md#setting-up-ide-cloud9-share)\.

An IAM policy is associated with each project role\. This policy is customized for your project to reflect its resources\. For more information about these policies, see [AWS CodeStar Access Permissions Reference](access-permissions.md)\.

The following diagram shows the relationship between each role and an AWS CodeStar project\.

![\[AWS CodeStar roles and their access to the project and its resources\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/adh-team-whowhat.png)![\[AWS CodeStar roles and their access to the project and its resources\]](http://docs.aws.amazon.com/codestar/latest/userguide/)

**Topics**
+ [Add Team Members to an AWS CodeStar Project](how-to-add-team-member.md)
+ [Manage Permissions for AWS CodeStar Team Members](how-to-manage-team-permissions.md)
+ [Remove Team Members from an AWS CodeStar Project](how-to-remove-team-member.md)