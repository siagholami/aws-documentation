# AWS CodeStar Access Permissions Reference<a name="access-permissions"></a>

 You can use AWS CodeStar as an [IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html), a federated user, the root user, or an assumed role\. All user types with the appropriate permissions can manage project permissions to their AWS resources, but AWS CodeStar manages project permissions automatically for IAM users\. [IAM policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) and [roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) grant permissions and access to that user based on the project role\. You can use the IAM console to create other policies that assign AWS CodeStar and other permissions to an IAM user\. 

For example, you might want to allow a user to view, but not change, an AWS CodeStar project\. In this case, you add the IAM user to an AWS CodeStar project with the viewer role\. Every AWS CodeStar project has a set of policies that help you control access to the project\. In addition, you can control which users have access to AWS CodeStar\.

In the [Setting Up AWS CodeStar](setting-up.md) instructions, you attached a policy named `AWSCodeStarFullAccess` to your IAM user\. For an example of that policy statement, see [AWSCodeStarFullAccess](adh-policy-examples.md#adh-policy-fullaccess)\.

This policy statement allows the user to perform all available actions in AWS CodeStar with all available AWS CodeStar resources associated with the AWS account\. This includes creating and deleting projects\. You might not want to give all users this much access\. Instead, you can add project\-level permissions using project roles managed by AWS CodeStar\. The roles grant specific levels of access to AWS CodeStar projects and are named as follows: 
+ Owner
+ Contributor
+ Viewer

AWS CodeStar access is handled differently for IAM users and federated users\. Only IAM users can be added to teams\. To grant IAM users permissions to projects, you add the user to the project team and assign the user a role\. To grant federated users permissions to projects, you manually attach the AWS CodeStar project role's managed policy to the federated user's role\. This table summarizes the tools available for each type of access\.


****  

| Permissions feature | IAM user | Federated user | Root user | 
| --- | --- | --- | --- | 
| SSH key management for remote access for Amazon EC2 and Elastic Beanstalk projects | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-checkmark.png) |  |  | 
| AWS CodeCommit SSH access | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-checkmark.png) |  |  | 
|  IAM user permissions managed by AWS CodeStar  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-checkmark.png) |  |  | 
|  Project permissions managed manually  |  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-checkmark.png) | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-checkmark.png) | 
| Users can be added to project as team members | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-checkmark.png) |  |  | 

**Topics**
+ [AWS CodeStar Project\-Level Policies and Permissions](access-permissions-proj.md)
+ [AWS CodeStar Service Role Policy and Permissions](access-permissions-service-role.md)
+ [Action and Resource Syntax](access-permissions-syntax.md)
+ [AWS CodeStar Policy Examples](adh-policy-examples.md)
+ [IAM User Access to AWS CodeStar](access-permissions-user.md)
+ [Federated User Access to AWS CodeStar](access-permissions-federated.md)