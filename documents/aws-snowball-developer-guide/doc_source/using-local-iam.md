--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using IAM Locally<a name="using-local-iam"></a>

AWS Identity and Access Management \(IAM\) helps you securely control access to AWS resources running on your AWS Snowball Edge device\. You use IAM to control who is authenticated \(signed in\) and authorized \(has permissions\) to use resources\. 

IAM is supported locally on your device\. You can use the local IAM service to create new users and attach IAM policies to them\. You can use these policies to allow the access necessary to perform assigned tasks\. For example, you can give a user the ability to transfer data, but limit their ability to create new Amazon EC2 instances\.

Additionally, you can create local, session\-based credentials using AWS Security Token Service \(AWS STS\) on your device\. For information about the IAM service, see [Getting Started](https://docs.aws.amazon.com/IAM/latest/GettingStartedGuide/) in the *IAM User Guide*\.

Your device's root credentials can't be disabled, and you can't use policies within your account to explicitly deny access to the AWS account root user\. We recommend that you secure your root user access keys and create IAM user credentials for everyday interaction with your device\.

**Important**  
The documentation in this section applies to using IAM locally on an AWS Snowball Edge device\. For information about using IAM in the AWS Cloud, see [Identity and Access Management in Snowball](snowball-edge-iam.md)\.  
For AWS services to work properly on a Snowball Edge, you must allow the ports for the services\. For details, see [Ports Required to Use AWS Services on an AWS Snowball Edge Device](port-requirements.md)\.

**Topics**
+ [Using the AWS CLI and API Operations on Snowball Edge](#local-iam-specify-region)
+ [List of Supported IAM AWS CLI Commands on a Snowball Edge](#local-iam-cli-commands)
+ [IAM Policy Examples](#policy-examples)
+ [Example 9: Policy for API Calls](#local-sts-cli-example-policy)
+ [TrustPolicy Example](#role-policy-example-trust)

## Using the AWS CLI and API Operations on Snowball Edge<a name="local-iam-specify-region"></a>

When using the AWS CLI or API operations to issue IAM, AWS STS, Amazon S3, and Amazon EC2 commands on Snowball Edge, you must specify the region as "`snow`\." You can do this using `AWS configure` or within the command itself, as in the following examples\.

```
aws configure --profile abc
AWS Access Key ID [None]: defgh
AWS Secret Access Key [None]: 1234567
Default region name [None]: snow
Default output format [None]: json
```

Or

```
aws iam ls --profile snowballEdge --endpoint http://192.0.2.0:6078 --region snow 
```

**Note**  
The access key ID and access secret key that are used locally on AWS Snowball Edge can't be interchanged with the keys in the AWS Cloud\.

## List of Supported IAM AWS CLI Commands on a Snowball Edge<a name="local-iam-cli-commands"></a>

Following is a description of the subset of AWS CLI commands and options for IAM that are supported on Snowball Edge devices\. If a command or option isn't listed following, it's not supported\. Unsupported parameters for commands are noted in the description\.
+ [attach\-role\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/attach-role-policy.html) – Attaches the specified managed policy to the specified IAM role\.
+ [attach\-user\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/attach-user-policy.html) – Attaches the specified managed policy to the specified user\.
+ [create\-access\-key](https://docs.aws.amazon.com/cli/latest/reference/iam/create-access-key.html) – Creates a new local IAM secret access key and corresponding AWS access key ID for the specified user\.
+ [create\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/create-policy.html) – Creates a new IAM managed policy for your device\.
+ [create\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/create-role.html) – Creates a new local IAM role for your device\. The following parameters are **not** supported:
  + `Tags`
  + `PermissionsBoundary`
+ [create\-user](https://docs.aws.amazon.com/cli/latest/reference/iam/create-user.html) – Creates a new local IAM user for your device\. The following parameters are **not** supported:
  + `Tags`
  + `PermissionsBoundary`
+ [delete\-access\-key](https://docs.aws.amazon.com/cli/latest/reference/iam/delete-access-key.html) – Creates a new local IAM secret access key and corresponding AWS access key ID for the specified user\.
+ [delete\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/delete-policy.html) – Deletes the specified managed policy\.
+ [delete\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/delete-role.html) – Deletes the specified role\.
+ [delete\-user](https://docs.aws.amazon.com/cli/latest/reference/iam/delete-user.html) – Deletes the specified user\.
+ [detach\-role\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/detach-role-policy.html) – Removes the specified managed policy from the specified role\.
+ [detach\-user\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/detach-user-policy.html) – Removes the specified managed policy from the specified user\.
+ [get\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/get-policy.html) – Retrieves information about the specified managed policy, including the policy's default version and the total number of local IAM users, groups, and roles to which the policy is attached\.
+ [get\-policy\-version](https://docs.aws.amazon.com/cli/latest/reference/iam/get-policy-version.html) – Retrieves information about the specified version of the specified managed policy, including the policy document\.
+ [get\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/get-role.html) – Retrieves information about the specified role, including the role's path, GUID, ARN, and the role's trust policy that grants permission to assume the role\.
+ [get\-user](https://docs.aws.amazon.com/cli/latest/reference/iam/get-user.html) – Retrieves information about the specified IAM user, including the user's creation date, path, unique ID, and ARN\.
+ [list\-access\-keys](https://docs.aws.amazon.com/cli/latest/reference/iam/list-access-keys.html) – Returns information about the access key IDs associated with the specified IAM user\.
+ [list\-attached\-role\-policies](https://docs.aws.amazon.com/cli/latest/reference/iam/list-attached-role-policies.html) – Lists all managed policies that are attached to the specified IAM role\.
+ [list\-attached\-user\-policies](https://docs.aws.amazon.com/cli/latest/reference/iam/list-attached-user-policies.html) – Lists all managed policies that are attached to the specified IAM user\.
+ [list\-entities\-for\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/list-entities-for-policy.html) – Lists all local IAM users, groups, and roles that the specified managed policy is attached to\.
  + `--EntityFilter`: Only the `user` and `role` values are supported\.
+ [list\-policies](https://docs.aws.amazon.com/cli/latest/reference/iam/list-policies.html) – Lists all the managed policies that are available in your local AWS account\. The following parameter is **not** supported:
  + `--PolicyUsageFilter`
+ [list\-roles](https://docs.aws.amazon.com/cli/latest/reference/iam/list-roles.html) – Lists the local IAM roles that have the specified path prefix\.
+ [list\-users](https://docs.aws.amazon.com/cli/latest/reference/iam/list-users.html) – Lists the IAM users that have the specified path prefix\.
+ [update\-access\-key](https://docs.aws.amazon.com/cli/latest/reference/iam/update-access-key.html) – Changes the status of the specified access key from Active to Inactive, or vice versa\.
+ [update\-assume\-role\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/update-assume-role-policy.html) – Updates the policy that grants an IAM entity permission to assume a role\.
+ [update\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/update-role.html) – Updates the description or maximum session duration setting of a role\.
+ [update\-user](https://docs.aws.amazon.com/cli/latest/reference/iam/update-user.html) – Updates the name and/or the path of the specified IAM user\.

### Supported IAM API Operations<a name="iam-local-supported-apis"></a>

Following are the IAM API operations that you can use with a Snowball Edge, with links to their descriptions in the IAM API Reference\.
+ [AttachRolePolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_AttachRolePolicy.html) – Attaches the specified managed policy to the specified IAM role\.
+ [AttachUserPolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_AttachUserPolicy.html) – Attaches the specified managed policy to the specified user\.
+ [CreateAccessKey](https://docs.aws.amazon.com/IAM/latest/APIReference/API_CreateAccessKey.html) – Creates a new local IAM secret access key and corresponding AWS access key ID for the specified user\.
+ [CreatePolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_CreatePolicy.html) – Creates a new IAM managed policy for your device\.
+ [CreateRole](https://docs.aws.amazon.com/IAM/latest/APIReference/API_CreateRole.html) – Creates a new local IAM role for your device\.
+ [CreateUser](https://docs.aws.amazon.com/IAM/latest/APIReference/API_CreateUser.html) – Creates a new local IAM user for your device\.

  The following parameters are **not** supported:
  + `Tags`
  + `PermissionsBoundary`
+ [DeleteAccessKey](https://docs.aws.amazon.com/IAM/latest/APIReference/API_DeleteAccessKey.html)– Deletes the specified access key\.
+ [DeletePolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_DeletePolicy.html) – Deletes the specified managed policy\.
+ [DeleteRole](https://docs.aws.amazon.com/IAM/latest/APIReference/API_DeleteRole.html) – Deletes the specified role\.
+ [DeleteUser](https://docs.aws.amazon.com/IAM/latest/APIReference/API_DeleteUser.html) – Deletes the specified user\.
+ [DetachRolePolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_DetachRolePolicy.html) – Removes the specified managed policy from the specified role\.
+ [DetachUserPolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_DetachUserPolicy.html) – Removes the specified managed policy from the specified user\.
+ [GetPolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_GetPolicy.html) – Retrieves information about the specified managed policy, including the policy's default version and the total number of local IAM users, groups, and roles to which the policy is attached\.
+ [GetPolicyVersion](https://docs.aws.amazon.com/IAM/latest/APIReference/API_GetPolicyVersion.html) – Retrieves information about the specified version of the specified managed policy, including the policy document\.
+ [GetRole](https://docs.aws.amazon.com/IAM/latest/APIReference/API_GetRole.html) – Retrieves information about the specified role, including the role's path, GUID, ARN, and the role's trust policy that grants permission to assume the role\.
+ [GetUser](https://docs.aws.amazon.com/IAM/latest/APIReference/API_GetUser.html) – Retrieves information about the specified IAM user, including the user's creation date, path, unique ID, and ARN\.
+ [ListAccessKeys](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListAccessKeys.html) – Returns information about the access key IDs associated with the specified IAM user\.
+ [ListAttachedRolePolicies](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListAttachedRolePolicies.html) – Lists all managed policies that are attached to the specified IAM role\.
+ [ListAttachedUserPolicies](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListAttachedUserPolicies.html) – Lists all managed policies that are attached to the specified IAM user\.
+ [ListEntitiesForPolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListEntitiesForPolicy.html) – Retrieves information about the specified IAM user, including the user's creation date, path, unique ID, and ARN\.
  + `--EntityFilter`: Only the `user` and `role` values are supported\.
+ [ListPolicies](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListPolicies.html) – Lists all the managed policies that are available in your local AWS account\. The following parameter is **not** supported:
  + `--PolicyUsageFilter`
+ [ListRoles](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListRoles.html) – Lists the local IAM roles that have the specified path prefix\. 
+ [ListUsers](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListUsers.html) – Lists the IAM users that have the specified path prefix\.
+ [UpdateAccessKey](https://docs.aws.amazon.com/IAM/latest/APIReference/API_UpdateAccessKey.html) – Changes the status of the specified access key from Active to Inactive, or vice versa\.
+ [UpdateAssumeRolePolicy](https://docs.aws.amazon.com/IAM/latest/APIReference/API_UpdateAssumeRolePolicy.html) – Updates the policy that grants an IAM entity permission to assume a role\. 
+ [UpdateRole](https://docs.aws.amazon.com/IAM/latest/APIReference/API_UpdateRole.html) – Updates the description or maximum session duration setting of a role\.
+ [UpdateUser](https://docs.aws.amazon.com/IAM/latest/APIReference/API_UpdateUser.html) – Updates the name and/or the path of the specified IAM user\.

### Supported IAM Policy Version and Grammar<a name="iam-policy"></a>

Following is the local IAM support version 2012\-10\-17 of the IAM policy and a subset of the policy grammar\.


| Policy type | Supported grammar | 
| --- | --- | 
| Identity\-based policies \(user/role policy\) | "Effect", "Action" and "Resource"  Local IAM doesn't support "`Condition`", "`NotAction`", "`NotResource`" and "`Principal`"\.    | 
| Resource\-based policies \(role trust policy\) | "Effect", "Action" and "Principal" For Principal, only AWS account ID or principal ID is allowed\.  | 

## IAM Policy Examples<a name="policy-examples"></a>

**Note**  
AWS Identity and Access Management\(IAM\) users need `"snowballdevice:*"` permissions to use the [AWS OpsHub for Snow Family application](aws-opshub.md) to manage Snow family devices\.

The following are examples of policies that grant permissions to a Snowball Edge device\.

### Example 1: Allows Full Access to the IAM API<a name="role-policy-example-iam"></a>

Use the following policy to allow full access to IAM API\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "iam:*",
            "Resource": "*"
        }
    ]
}
```

### Example 2: Allows Full Access to the Amazon S3 API<a name="role-policy-example-s3-full"></a>

Use the following policy to allow full access to Amazon S3 API\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "s3:*",
            "Resource": "*"
            
        }
    ]
}
```

### Example 3: Allows Read and Write Access to a Specific Amazon S3 Bucket<a name="role-policy-example-s3-bucket"></a>

 Use the following policy to allow read and write access to a specific bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ListObjectsInBucket",
            "Effect": "Allow",
            "Action": "s3:ListBucket",
            "Resource": "arn:aws:s3:::bucket-name"
        },
        {
            "Sid": "AllObjectActions",
            "Effect": "Allow",
            "Action": "s3:*Object",
            "Resource": "arn:aws:s3:::bucket-name/*"
        }
    ]
}
```

### Example 4: Allows Only List Access to a Specific Amazon S3 Bucket<a name="role-policy-example-s3-list"></a>

Use the following policy to allow List access to a specific bucket but deny everything else\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "DenyObjectActions",
            "Effect": "Deny",
            "Action": "s3:*",
            "Resource": "*"
        },
        {
            "Sid": "ListObjectsInBucket",
            "Effect": "Allow",
            "Action": "s3:ListBucket",
            "Resource": "arn:aws:s3:::bucket-name"
        }
    ]
}
```

### Example 5: Allows List, Get, and Put Access to a Specific Amazon S3 Bucket<a name="role-policy-example-s3-lgp"></a>

Use the following policy to allow List, Get, and Put Access to a Specific Bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:PutObject",
                "s3:GetObject",
                "s3:List*"
            ],
            "Resource": "arn:aws:s3:::examplebucket/*"
        }
    ]
}
```

### Example 6: Allows Full Access to the Amazon EC2 API<a name="role-policy-example-ec2"></a>

 Use the following policy to allow full access to Amazon EC2\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "ec2:*",
            "Resource": "*"
        }
    ]
}
```

### Example 7: Allows Access to Start and Stop Amazon EC2 Instances<a name="role-policy-example-ec2-stop-start"></a>

 Use the following policy to allow access to start and stop Amazon EC2 instances\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "ec2:StartInstances",
                "ec2:StopInstances"
            ],
            "Resource": "*"
        }
    ]
}
```

### Example 8: Denies Calls to DescribeLaunchTemplates but Allows All Calls to DescribeImages<a name="role-policy-example-ec2-desc-image"></a>

 Use the following policy to deny calls to `DescribeLaunchTemplates` but allow all calls to `DescribeImages`\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "ec2:DescribeLaunchTemplates"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "ec2:DescribeImages"
            ],
            "Resource": "*"
        }
    ]
}
```

## Example 9: Policy for API Calls<a name="local-sts-cli-example-policy"></a>

When using the AWS CLI or API operations to issue IAM, AWS STS, Amazon S3, and Amazon EC2 commands on Snowball Edge, you must specify the region as "`snow`\." You can do this using `AWS configure` or within the command itself, as in the following examples\.

```
aws iam list-policies --endpoint http://ip-address:6078 --profile snowballEdge --region snow
{
    "Policies": [
        {
            "PolicyName": "Administrator",
            "Description": "Root user admin policy for Account 123456789012",
            "CreateDate": "2020-03-04T17:44:59.412Z",
            "AttachmentCount": 1,
            "IsAttachable": true,
            "PolicyId": "policy-id",
            "DefaultVersionId": "v1",
            "Path": "/",
            "Arn": "arn:aws:iam::123456789012:policy/Administrator",
            "UpdateDate": "2020-03-04T19:10:45.620Z"
        }
    ]
}
```

## TrustPolicy Example<a name="role-policy-example-trust"></a>

A trust policy returns a set of temporary security credentials that you can use to access AWS resources that you might normally not have access to\. These temporary credentials consist of an access key ID, a secret access key, and a security token\. Typically, you use `AssumeRole` in your account for cross\-account access\. 

The following is an example of a trust policy\. For more information about trust policy, see [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) in the *AWS Security Token Service API Reference*\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "AWS": [
                    "arn:aws:iam::AccountId:root" //You can use the Principal ID instead of the account ID. 
                ]
            },
            "Action": [
                "sts:AssumeRole"
            ]
        }
    ]
}
```