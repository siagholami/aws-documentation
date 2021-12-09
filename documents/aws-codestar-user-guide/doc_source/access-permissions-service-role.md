# AWS CodeStar Service Role Policy and Permissions<a name="access-permissions-service-role"></a>

AWS CodeStar uses a service role, aws\-codestar\-service\-role, when it creates and manages the resources for your project\. For more information, see [Roles Terms and Concepts](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html) in the *IAM User Guide*\.

**Important**  
You must be signed in as an IAM administrator user or root account to create this service role\. For more information, see [First\-Time Access Only: Your Root User Credentials](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_identity-management.html#intro-identity-first-time-access) and [Creating Your First IAM Admin User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *IAM User Guide*\.

This role is created for you the first time you create a project in AWS CodeStar\. The service role acts on your behalf to:
+ Create the resources you choose when you create a project\.
+ Display information about those resources in the AWS CodeStar project dashboard\.

It also acts on your behalf when you manage the resources for a project\. For an example of this policy statement, see [AWS CodeStar Service Role Policy](adh-policy-examples.md#adh-policy-service-role) \.