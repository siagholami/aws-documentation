# Using identity\-based policies for CodeGuru Reviewer<a name="auth-and-access-control-iam-identity-based-access-control"></a>

By default, IAM users and roles don't have permission to create or modify Amazon CodeGuru Reviewer resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\. An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator must then attach those policies to the IAM users or groups that require those permissions\. To learn how to attach policies to an IAM user or group, see [Adding and Removing IAM Identity Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_manage-attach-detach.html) in the *IAM User Guide*\.

To learn how to create an IAM identity\-based policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

**Topics**
+ [Policy best practices](#security_iam_service-with-iam-policy-best-practices)
+ [Permissions required to use the CodeGuru Reviewer console](#console-permissions)
+ [AWS managed \(predefined\) policies for CodeGuru Reviewer](#managed-policies)
+ [Customer managed policy examples](#security_iam_id-based-policy-examples)

## Policy best practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete CodeGuru Reviewer resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using CodeGuru Reviewer quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Permissions required to use the CodeGuru Reviewer console<a name="console-permissions"></a>

A user who uses the CodeGuru Reviewer console must have a minimum set of permissions that allows the user to describe other AWS resources for the AWS account\. You must have permissions from the following services:
+ CodeGuru Reviewer
+ AWS CodeCommit \(if your source code is in a CodeCommit repository\)
+ AWS CodeStar connections \(if your source code is in a repository managed by AWS CodeStar connections, such as Bitbucket\)
+ AWS Identity and Access Management \(IAM\)

 If your source code is in a GitHub respository, you must have an OAuth token to connect to it\. Associated GitHub repositories are not managed by AWS CodeStar connections\. For more information, see [Git automation with OAuth tokens](https://help.github.com/en/github/extending-github/git-automation-with-oauth-tokens#step-1-get-an-oauth-token) on the GitHub website\. 

If you create an IAM policy that is more restrictive than the minimum required permissions, the console won't function as intended\.

The following shows an example of a permissions policy that allows a user to get information about a repository association only in the `us-east-2` Region for account `123456789012` for any repository assocation with a universally unique identifier \(UUID\) that starts with `12345`\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "codeguru-reviewer:DescribeRepositoryAssociation",
      "Resource": "arn:aws:codeguru-reviewer:us-east-2:123456789012:association:12345*"      
    }
  ]
}
```

## AWS managed \(predefined\) policies for CodeGuru Reviewer<a name="managed-policies"></a>

AWS addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. These AWS managed policies grant necessary permissions for common use cases so you can avoid having to investigate what permissions are needed\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\.

To create and manage CodeGuru Reviewer service roles, you must also attach the AWS managed policy named `IAMFullAccess`\.

You can also create your own custom IAM policies to allow permissions for CodeGuru Reviewer actions and resources\. You can attach these custom policies to the IAM users or groups that require those permissions\.

The following AWS managed policies, which you can attach to users in your account, are specific to CodeGuru Reviewer\.

**Topics**
+ [AmazonCodeGuruReviewerFullAccess](#managed-full-access)
+ [AmazonCodeGuruReviewerReadOnlyAccess](#managed-read-only-access)
+ [AmazonCodeGuruReviewerServiceRolePolicy](#managed-policy-for-codecommit-and-codestar-connections)

### AmazonCodeGuruReviewerFullAccess<a name="managed-full-access"></a>

`AmazonCodeGuruReviewerFullAccess` – Provides full access to CodeGuru Reviewer, including permissions to create, update, and delete code reviews and repository associations\. It also grants permission to related resources in other services that integrate with CodeGuru Reviewer, such as Amazon CloudWatch, AWS CodeStar connections, and CodeCommit\. Apply this only to administrative\-level users to who you want to grant full control over CodeGuru Reviewer repository associations, code reviews, and related resources in your AWS account, including the ability to delete code reviews and repository associations\. 

The `AmazonCodeGuruReviewerFullAccess` policy contains the following statement\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AmazonCodeGuruReviewerFullAccess",
            "Effect": "Allow",
            "Action": [
                "codeguru-reviewer:*"
            ],
            "Resource": "*"
        },
        {
            "Sid": "AmazonCodeGuruReviewerSLRCreation",
            "Action": "iam:CreateServiceLinkedRole",
            "Effect": "Allow",
            "Resource": "arn:aws:iam::*:role/aws-service-role/codeguru-reviewer.amazonaws.com/AWSServiceRoleForAmazonCodeGuruReviewer",
            "Condition": {
                "StringLike": {
                    "iam:AWSServiceName": "codeguru-reviewer.amazonaws.com"
                }
            }
        },
        {
            "Sid": "AmazonCodeGuruReviewerSLRDeletion",
            "Effect": "Allow",
            "Action": [
                "iam:DeleteServiceLinkedRole",
                "iam:GetServiceLinkedRoleDeletionStatus"
            ],
            "Resource": "arn:aws:iam::*:role/aws-service-role/codeguru-reviewer.amazonaws.com/AWSServiceRoleForAmazonCodeGuruReviewer"
        },
        {
            "Sid": "CodeCommitAccess",
            "Effect": "Allow",
            "Action": [
                "codecommit:ListRepositories"
            ],
            "Resource": "*"
        },
        {
            "Sid": "CodeCommitTagManagement",
            "Effect": "Allow",
            "Action": [
                "codecommit:TagResource",
                "codecommit:UntagResource"
            ],
            "Resource": "*",
            "Condition": {
                "ForAllValues:StringEquals": {
                    "aws:TagKeys": "codeguru-reviewer"
                }
            }
        },
        {
            "Sid": "CodeConnectTagManagement",
            "Effect": "Allow",
            "Action": [
                "codestar-connections:TagResource",
                "codestar-connections:UntagResource",
                "codestar-connections:ListTagsForResource"
            ],
            "Resource": "*",
            "Condition": {
                "ForAllValues:StringEquals": {
                    "aws:TagKeys": "codeguru-reviewer"
                }
            }
        },
        {
            "Sid": "CodeConnectManagedRules",
            "Effect": "Allow",
            "Action": [
                "codestar-connections:UseConnection",
                "codestar-connections:ListConnections",
                "codestar-connections:PassConnection"
            ],
            "Resource": "*",
            "Condition": {
                "ForAllValues:StringEquals": {
                    "codestar-connections:ProviderAction": [
                        "ListRepositories",
                        "ListOwners"
                    ]
                }
            }
        },
        {
            "Sid": "CloudWatchEventsManagedRules",
            "Effect": "Allow",
            "Action": [
                "events:PutRule",
                "events:PutTargets",
                "events:DeleteRule",
                "events:RemoveTargets"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "events:ManagedBy": "codeguru-reviewer.amazonaws.com"
                }
            }
        }
    ]
}
```

### AmazonCodeGuruReviewerReadOnlyAccess<a name="managed-read-only-access"></a>

`AmazonCodeGuruReviewerReadOnlyAccess` – Grants read\-only access to CodeGuru Reviewer and related resources in other AWS services\. Apply this policy to users who you want to grant the ability to view code reviews, but not to create or make any changes to them\. 

The `AmazonCodeGuruReviewerReadOnlyAccess` policy contains the following statement\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AmazonCodeGuruReviewerReadOnlyAccess",
            "Effect": "Allow",
            "Action": [
                "codeguru-reviewer:List*",
                "codeguru-reviewer:Describe*",
                "codeguru-reviewer:Get*"
            ],
            "Resource": "*"
        }
    ]
}
```

### AmazonCodeGuruReviewerServiceRolePolicy<a name="managed-policy-for-codecommit-and-codestar-connections"></a>

`AmazonCodeGuruReviewerServiceRolePolicy` – Grants permission to related resources in CodeCommit, AWS CodeStar connections, and CloudWatch that are required to create repository associations\. 

For CodeCommit repository associations, the CodeCommit and CloudWatch permissions in this policy are required\. For associations with repositories that are managed by an AWS CodeStar connection, such as Bitbucket, the AWS CodeStar connections permissions are required\.

 When you create your first association with a CodeCommit or AWS CodeStar connections managed repository, CodeGuru Reviewer adds the `AmazonCodeGuruReviewerServiceRolePolicy` policy to your AWS account\. This policy grants CodeGuru Reviewer access to CodeCommit repositories and AWS CodeStar connections resources in your account that have a `"aws:ResourceTag/codeguru-reviewer"` tag\. When you associate a CodeCommit respository, CodeGuru Reviewer adds this tag to the repository\. When you associate an AWS CodeStar connections managed repository, CodeGuru Reviewer adds this tag to the AWS CodeStar connections resource, if it doesn't already exist\. 

The `AmazonCodeGuruReviewerServiceRolePolicy` policy contains the following statement\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AccessCodeGuruReviewerEnabledRepositories",
            "Effect": "Allow",
            "Action": [
                "codecommit:GetRepository",
                "codecommit:DescribePullRequestEvents",
                "codecommit:GetCommentsForPullRequest",
                "codecommit:GetDifferences",
                "codecommit:GetPullRequest",
                "codecommit:ListPullRequests",
                "codecommit:PostCommentForPullRequest",
                "codecommit:GitPull",
                "codecommit:UntagResource"
            ],
            "Resource": "*",
            "Condition": {
                "StringLike": {
                    "aws:ResourceTag/codeguru-reviewer": "enabled"
                }
            }
        },
        {
            "Sid": "AccessCodeGuruReviewerEnabledConnections",
            "Effect": "Allow",
            "Action": [
                "codestar-connections:UseConnection"
            ],
            "Resource": "*",
            "Condition": {
                "ForAllValues:StringEquals": {
                    "codestar-connections:ProviderAction": [
                        "ListBranches",
                        "GetBranch",
                        "ListRepositories",
                        "ListOwners",
                        "ListPullRequests",
                        "GetPullRequest",
                        "ListPullRequestComments",
                        "ListPullRequestCommits",
                        "ListCommitFiles",
                        "ListBranchCommits",
                        "CreatePullRequestDiffComment",
                        "GitPull"
                    ]
                },
                "Null": {
                    "aws:ResourceTag/codeguru-reviewer ;": "false"
                }
            }
        },
        {
            "Sid": "CloudWatchEventsResourceCleanup",
            "Effect": "Allow",
            "Action": [
                "events:DeleteRule",
                "events:RemoveTargets"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "events:ManagedBy": "codeguru-reviewer.amazonaws.com"
                }
            }
        }
    ]
}
```

## Customer managed policy examples<a name="security_iam_id-based-policy-examples"></a>

You can create your own custom IAM policies to allow permissions for CodeGuru Reviewer actions and resources\. You can attach these custom policies to the IAM users, roles, or groups that require those permissions\. You can also create your own custom IAM policies for integration between CodeGuru Reviewer and other AWS services\. 

 The following example IAM policies grant permissions for various CodeGuru Reviewer actions\. Use them to limit CodeGuru Reviewer access for your IAM users and roles\. These policies control the ability to perform actions with the CodeGuru Reviewer console, API, AWS SDKs, or the AWS CLI\. 

**Note**  
All examples use the US East \(Ohio\) Region \(us\-east\-2\) and contain fictitious account IDs\.

 **Examples**
+ [Example 1: Allow a user to perform CodeGuru Reviewer operations in a single Region](#identity-based-policies-example-1)
+ [Example 2: Allow read\-only access to CodeGuru Reviewer operations for a user connecting from a specified IP address range ](#identity-based-policies-example-2)

### Example 1: Allow a user to perform CodeGuru Reviewer operations in a single Region<a name="identity-based-policies-example-1"></a>

The following permissions policy uses a wildcard character \(`"codeguru-reviewer:*"`\) to allow users to perform all CodeGuru Reviewer actions in the us\-east\-2 Region and not from other AWS Regions\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "codeguru-reviewer:*",
            "Resource": "arn:aws:codeguru-reviewer:us-east-2:123456789012:*",
            "Condition": {
                "StringEquals": {
                    "aws:RequestedRegion": "us-east-2"
                }
            }
        }
    ]
}
```

### Example 2: Allow read\-only access to CodeGuru Reviewer operations for a user connecting from a specified IP address range<a name="identity-based-policies-example-2"></a>

You can create a policy that only allows users CodeGuru Reviewer read\-only access if their IP address is within a certain IP address range\. The following example grants read\-only CodeGuru Reviewer permissions to users whose IP addresses are within the specified IP address block of 203\.0\.113\.0/24\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
          "codeguru-reviewer:List*",
          "codeguru-reviewer:Describe*"
      ],
      "Resource": "*",
      "Condition": {
        "IpAddress": {
          "aws:SourceIp": "203.0.113.0/24"
        }
      }
    }
  ]
}
```