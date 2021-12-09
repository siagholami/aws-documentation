# Action and Resource Syntax<a name="access-permissions-syntax"></a>

The following sections describe the format for specifying actions and resources\.

Actions follow this general format:

```
codestar:action
```

Where *action* is an available AWS CodeStar operation, such as `ListProjects` or `AssociateResource`\. To allow an action, use the `"Effect" : "Allow"` clause\. To explicitly deny an action, use the `"Effect" : "Deny"` clause\. By default, all actions are denied, unless specified otherwise in any other attached policy\. 

Resources follow this general format:

```
arn:aws:codestar:region:account:resource-specifier
```

Where *region* is a target AWS Region \(such as **us\-east\-2**\), *account* is the AWS account ID, and *resource\-specifier* is the project ID\. Wildcard \(`*`\) characters can be used to specify a partial name\.

For example, the following specifies the AWS CodeStar project named `my-first-projec` registered to the AWS account `111111111111` in the AWS Region `us-east-2`:

```
arn:aws:codestar:us-east-2:111111111111:project/my-first-projec
```

The following specifies any AWS CodeStar project that begins with the name `my-proj` registered to the AWS account `111111111111` in the AWS Region `us-east-2`:

```
arn:aws:codestar:us-east-2:111111111111:project/my-proj*
```

**Topics**
+ [Resource Scoping in AWS CodeStar](#access-permissions-resource-scoping)
+ [Projects](#access-permissions-syntax-projects)
+ [Resources](#access-permissions-syntax-resources)
+ [Teams](#access-permissions-syntax-teams)
+ [Users](#access-permissions-syntax-users)

## Resource Scoping in AWS CodeStar<a name="access-permissions-resource-scoping"></a>

Some of the permissions in AWS CodeStar cannot be scoped to a resource, but instead must be scoped to all, or the action fails\. 

The following action cannot be scoped\. It must be set to \*:
+ ListProjects

## Projects<a name="access-permissions-syntax-projects"></a>

Allowed actions include: 
+ `CreateProject` to create an AWS CodeStar project\. 
+ `DeleteProject` to delete an AWS CodeStar project\.
+ `DescribeProject` to describe the attributes of an AWS CodeStar project\.
+ `ListProjects` to list all the AWS CodeStar projects\. 
+ `UpdateProject` to update the attributes of an AWS CodeStar project\.

The following example allows a specified IAM user to edit the attributes of an AWS CodeStar project, such as its project description:

```
{
  "Version": "2012-10-17",
  "Statement" : [
    {
      "Effect" : "Allow",
      "Action" : [
        "codestar:UpdateProject"
      ],
      "Resource" : "arn:aws:codestar:us-east-2:project/my-first-projec"
    }
  ]
}
```

## Resources<a name="access-permissions-syntax-resources"></a>

Allowed actions include:
+ `ListResources` to list all the resources for an AWS CodeStar project\.

The following example allows an IAM user who has this policy attached to list resources for a project with the ID *my\-first\-projec*:

```
{
  "Version": "2012-10-17",
  "Statement" : [
    {
      "Effect" : "Allow",
      "Action" : [
        "codestar:ListResources",
      ],
      "Resource" : "arn:aws:codestar:us-east-2:project/my-first-projec"
    }
  ]
}
```

## Teams<a name="access-permissions-syntax-teams"></a>

Allowed actions include:
+ `AssociateTeamMember` to add a user to an AWS CodeStar project\.
+ `DisassociateTeamMember` to remove a user from an AWS CodeStar project\.
+ `ListTeamMembers` to list all the users in an AWS CodeStar project\.
+ `UpdateTeamMember` to change the team member's attributes in an AWS CodeStar project \(for example, the user's project role\)\. 

The following example allows an IAM user who has this policy attached to add team members to an AWS CodeStar project with the project ID *my\-first\-projec*, but explicitly denies that user the ability to remove team members:

```
{
  "Version": "2012-10-17",
  "Statement" : [
    {
      "Effect" : "Allow",
      "Action" : [
        "codestar:AssociateTeamMember",
      ],
      "Resource" : "arn:aws:codestar:us-east-2:project/my-first-projec"
    },
    {
      "Effect" : "Deny",
      "Action" : [
        "codestar:DisassociateTeamMember",
      ],
      "Resource" : "arn:aws:codestar:us-east-2:project/my-first-projec"
    }
      ]
    
  ]
}
```

## Users<a name="access-permissions-syntax-users"></a>

Allowed actions include:
+ `CreateUserProfile` to create a user profile in AWS CodeStar\. This profile contains data associated with the user, such as a display name, that appears across all AWS CodeStar projects\.
+ `DeleteUserProfile` to delete an AWS CodeStar user profile\.
+ `DescribeUserProfile` to retrieve information about an AWS CodeStar user profile\.
+ `ListUserProfiles` to list all AWS CodeStar user profiles for an AWS account\.
+ `UpdateUserProfile` to update an AWS CodeStar profile for a user\.

The following example allows an IAM user who has this policy attached to list all AWS CodeStar user profiles associated with an AWS account:

```
{
  "Version": "2012-10-17",
  "Statement" : [
    {
      "Effect" : "Allow",
      "Action" : [
        "codestar:ListUserProfiles",
              ],
      "Resource" : "*"
    }
  ]
}
```