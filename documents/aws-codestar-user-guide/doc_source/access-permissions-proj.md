# AWS CodeStar Project\-Level Policies and Permissions<a name="access-permissions-proj"></a>

When you create a project, AWS CodeStar creates the IAM roles and policies you need to manage your project resources\. The policies fall into three categories: 
+ IAM policies for project team members\.
+ IAM policies for worker roles\.
+ IAM policies for a runtime execution role\.

## IAM Policies for Team Members<a name="access-permissions-proj-team"></a>

When you create a project, AWS CodeStar creates three customer managed policies for owner, contributor, and viewer access to the project\. All AWS CodeStar projects contain IAM policies for these three access levels\. These access levels are project\-specific and defined by an IAM managed policy with a standard name, where *project\-id* is the ID of the AWS CodeStar project \(for example, *my\-first\-projec*\): 
+ `CodeStar_project-id_Owner`
+ `CodeStar_project-id_Contributor`
+ `CodeStar_project-id_Viewer`

**Important**  
These policies are subject to change by AWS CodeStar\. They should not be edited manually\. If you want to add or change permissions, attach additional policies to the IAM user\.

As you add team members \(IAM users\) to the project and choose their access levels, the corresponding policy is attached to the IAM user, granting the user the appropriate set of permissions to act on the project resources\. Under most circumstances, you don't need to directly attach or manage policies or permissions in IAM\. Manually attaching an AWS CodeStar access level policy to an IAM user is not recommended\. If absolutely necessary, as a supplement to an AWS CodeStar access level policy, you can create your own managed or inline policies to apply your own level of permissions to an IAM user\.

The policies are tightly scoped to project resources and specific actions\. As new resources are added to the infrastructure stack, AWS CodeStar attempts to update the team member policies to include permissions to access the new resource, if they are one of the supported resource types\.

**Note**  
The policies for access levels in an AWS CodeStar project apply to that project only\. This helps ensure that users can only see and interact with the AWS CodeStar projects they have permissions to, at the level determined by their role\. Only users who create AWS CodeStar projects should have a policy applied that allows access to all AWS CodeStar resources, regardless of project\.

All AWS CodeStar access level policies vary, depending on the AWS resources associated with the project with which the access levels are associated\. Unlike other AWS services, these policies are customized when the project is created and updated as project resources change\. Therefore, there is no one canonical owner, contributor, or viewer managed policy\. 

### AWS CodeStar Owner Role Policy<a name="access-permissions-proj-owner"></a>

The `CodeStar_project-id_Owner` customer managed policy allows a user to perform all actions in the AWS CodeStar project with no restrictions\. This is the only policy that allows a user to add or remove team members\. The contents of the policy vary, depending on the resources associated with the project\. See [AWS CodeStar Owner Role Policy](adh-policy-examples.md#adh-policy-owner) for an example\.

An IAM user with this policy can perform all AWS CodeStar actions in the project, but unlike an IAM user with the `AWSCodeStarFullAccess` policy, the user cannot create projects\. The `codestar:*` permission is limited in scope to a specific resource \(the AWS CodeStar project associated with that project ID\)\.

### AWS CodeStar Contributor Role Policy<a name="access-permissions-proj-contributor"></a>

The `CodeStar_project-id_Contributor` customer managed policy allows a user to contribute to the project and change the project dashboard, but does not allow a user to add or remove team members\. The contents of the policy vary, depending on the resources associated with the project\. See [AWS CodeStar Contributor Role Policy](adh-policy-examples.md#adh-policy-contributor) for an example\.

### AWS CodeStar Viewer Role Policy<a name="access-permissions-proj-viewer"></a>

The `CodeStar_project-id_Viewer` customer managed policy allows a user to view a project in AWS CodeStar, but not change its resources or add or remove team members\. The contents of the policy vary, depending on the resources associated with the project\. See [AWS CodeStar Viewer Role Policy ](adh-policy-examples.md#adh-policy-viewer) for an example\.

## IAM Policies for Worker Roles<a name="access-permissions-proj-worker"></a>

If you create your AWS CodeStar project after December 6, 2018 PDT, AWS CodeStar creates two worker roles, `CodeStar-project-id-ToolChain` and `CodeStar-project-id-CloudFormation`\. A worker role is a project\-specific IAM role that AWS CodeStar creates to pass to a service\. It grants permissions so that the service can create resources and execute actions in the context of your AWS CodeStar project\. The toolchain worker role has a trust relationship established with toolchain services such as CodeBuild, CodeDeploy, and CodePipeline\. Project team members \(owners and contributors\) are granted access to pass the worker role to trusted downstream services\. For an example of the inline policy statement for this role, see [Toolchain Worker Role Policy \(After December 6, 2018 PDT\)](adh-policy-examples.md#adh-policy-toolchain-worker-new)\.

The CloudFormation worker role includes permissions for selected resources supported by AWS CloudFormation, as well as permissions to create IAM users, roles, and policies in your application stack\. It also has a trust relationship established with AWS CloudFormation\. To mitigate risks of privilege escalation and destructive actions, the AWS CloudFormation role policy includes a condition that requires the project\-specific permissions boundary for every IAM entity \(user or role\) created in the infrastructure stack\. For an example of the inline policy statement for this role, see [AWS CloudFormation Worker Role Policy](adh-policy-examples.md#adh-policy-cfn-worker-new)\.

For AWS CodeStar projects created before December 6, 2018 PDT AWS CodeStar creates individual worker roles for toolchain resources such as CodePipeline, CodeBuild, and CloudWatch Events, and also creates a worker role for AWS CloudFormation that supports a limited set of resources\. Each of these roles has a trust relationship established with the corresponding service\. Project team members \(owners and contributors\) and some of the other worker roles are given access to pass the role to the trusted downstream services\. Permissions for the worker roles are defined in an inline policy that is scoped down to a basic set of actions that the role can perform on a set of project resources\. These permissions are static\. They include permissions to resources that are included in the project at creation, but are not updated when new resources are added to the project\. For examples of these policy statements, see: 
+ [AWS CloudFormation Worker Role Policy \(Before December 6, 2018 PDT\)](adh-policy-examples.md#adh-policy-cfn-worker-existing)
+ [CodePipeline Worker Role Policy \(Before December 6, 2018 PDT\)](adh-policy-examples.md#adh-policy-acp-worker-existing)
+ [CodeBuild Worker Role Policy \(Before December 6, 2018 PDT\)](adh-policy-examples.md#adh-policy-acb-worker-existing)
+ [CloudWatch Events Worker Role Policy \(Before December 6, 2018 PDT\)](adh-policy-examples.md#adh-policy-cwe-worker-existing)

## IAM Policy for the Execution Role<a name="access-permissions-proj-policy-execution"></a>

For projects created after December 6, 2018 PDT, AWS CodeStar creates a generic execution role for the sample project in your application stack\. The role is scoped down to project resources using the permissions boundary policy\. As you expand on the sample project, you can create additional IAM roles, and the AWS CloudFormation role policy requires that these roles be scoped down using the permission boundary to avoid escalation of privileges\. For more information, see [Add an IAM Role to a Project](add-iam-role.md)\.

For Lambda projects created before December 6, 2018 PDT, AWS CodeStar creates a Lambda execution role that has an inline policy attached with permissions to act on the resources in the project AWS SAM stack\. As new resources are added to the SAM template, AWS CodeStar attempts to update the Lambda execution role policy to include permissions to the new resource if they are one of the supported resource types\.

## IAM Permissions Boundary<a name="access-permissions-proj-pb-worker"></a>

After December 6, 2018 PDT, when you create a project AWS CodeStar creates a customer managed policy and assigns that policy as the [IAM permissions boundary](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_boundaries.html) to IAM roles in the project\. AWS CodeStar requires all IAM entities created in the application stack to have a permissions boundary\. A permissions boundary controls the maximum permissions that the role can have, but does not provide the role with any permissions\. Permissions policies define the permissions for the role\. This means that no matter how many extra permissions are added to a role, anyone using the role cannot perform more than the actions included in the permissions boundary\. For information about how permissions policies and permissions boundaries are evaluated, see [Policy Evaluation Logic](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_evaluation-logic.html) in the *IAM User Guide*\. 

AWS CodeStar uses a project\-specific permissions boundary to prevent escalation of privileges to resources outside the project\. The AWS CodeStar permissions boundary includes ARNs for project resources\. For an example of this policy statement, see [AWS CodeStar Permissions Boundary Policy](adh-policy-examples.md#permissions-boundary-policy)\.

The AWS CodeStar transform updates this policy when you add or remove a supported resource from the project through the application stack \(template\.yml\)\. 

## Add an IAM Permissions Boundary to Existing Projects<a name="access-permissions-proj-pb-add"></a>

If you have an AWS CodeStar project that was created before December 6, 2018 PDT, you should manually add a permission boundary to the IAM roles in the project\. As a best practice, we recommend using a project\-specific boundary that includes only resources in the project to avoid escalation of privilege to resources outside the project\. Follow these steps to use the AWS CodeStar managed permission boundary that is updated as the project evolves\.

1. Sign into the AWS CloudFormation console and locate the template for the toolchain stack in your project\. This template is named `awscodestar-project-id`\.

1. Choose the template, choose **Actions**, and then choose **View/Edit template in Designer**\.

1. Locate the `Resources` section, and include the following snippet at the top of the section\.

   ```
     PermissionsBoundaryPolicy:
       Description: Creating an IAM managed policy for defining the permissions boundary for an AWS CodeStar project
       Type: AWS::IAM::ManagedPolicy
       Properties:
         ManagedPolicyName: !Sub 'CodeStar_${ProjectId }_PermissionsBoundary'
         Description: 'IAM policy to define the permissions boundary for IAM entities created in an AWS CodeStar project'
         PolicyDocument:
           Version: '2012-10-17'
           Statement:
           - Sid: '1'
             Effect: Allow
             Action: ['*']
             Resource:
               - !Sub 'arn:${AWS::Partition}:cloudformation:${AWS::Region}:${AWS::AccountId}:stack/awscodestar-${ProjectId}-*'
   ```

   You might need additional IAM permissions to update the stack from the AWS CloudFormation console\.

1. \(Optional\) If you want to create application\-specific IAM roles, complete this step\. From the IAM console, update the inline policy attached to the AWS CloudFormation role for your project to include the following snippet\. You might need additional IAM resources to update the policy\.

   ```
          {
               "Action": [
                   "iam:PassRole"
               ],
               "Resource": "arn:aws:iam::{AccountId}:role/CodeStar-{ProjectId}*",
               "Effect": "Allow"
           },
           {
               "Action": [
                   "iam:CreateServiceLinkedRole",
                   "iam:GetRole",
                   "iam:DeleteRole",
                   "iam:DeleteUser"
               ],
               "Resource": "*",
               "Effect": "Allow"
           },
           {
               "Action": [
                   "iam:AttachRolePolicy",
                   "iam:AttachUserPolicy",
                   "iam:CreateRole",
                   "iam:CreateUser",
                   "iam:DeleteRolePolicy",
                   "iam:DeleteUserPolicy",
                   "iam:DetachUserPolicy",
                   "iam:DetachRolePolicy",
                   "iam:PutUserPermissionsBoundary",
                   "iam:PutRolePermissionsBoundary"
               ],
               "Resource": "*",
               "Condition": {
                   "StringEquals": {
                       "iam:PermissionsBoundary": "arn:aws:iam::{AccountId}:policy/CodeStar_{ProjectId}_PermissionsBoundary"
                   }
               },
               "Effect": "Allow"
           }
   ```

1. Push a change through your project pipeline so that AWS CodeStar updates the permissions boundary with appropriate permissions\.

For more information, see [Add an IAM Role to a Project](add-iam-role.md)\.