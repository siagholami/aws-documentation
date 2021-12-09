# Using identity\-based policies for CodeGuru Profiler<a name="auth-and-access-control-iam-identity-based-access-control"></a>

By default, IAM users and roles don't have permission to create or modify CodeGuru Profiler resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\. An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator must then attach those policies to the IAM users or groups that require those permissions\. To learn how to attach policies to an IAM user or group, see [Adding and removing IAM identity permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_manage-attach-detach.html) in the *IAM User Guide*\.

To learn how to create an IAM identity\-based policy using example JSON policy documents, see [Creating policies on the JSON tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

**Topics**
+ [Policy best practices](#security_iam_service-with-iam-policy-best-practices)
+ [Permissions required to use the CodeGuru Profiler console](#console-permissions)
+ [Permissions required by the CodeGuru Profiler profiling agent](#agent-policies)
+ [Permissions required to access CodeGuru Profiler data](#view-policies)
+ [AWS managed \(predefined\) policies for CodeGuru Profiler](#managed-policies)
+ [Customer managed policy examples](#security_iam_id-based-policy-examples)

## Policy best practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete CodeGuru Profiler resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using CodeGuru Profiler quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Permissions required to use the CodeGuru Profiler console<a name="console-permissions"></a>

A user who uses the CodeGuru Profiler console must have a minimum set of permissions that allows them to describe other AWS resources for the AWS account\. You must have permissions from the following services:
+ CodeGuru Profiler
+  [https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListUsers.html](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListUsers.html) and [https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListRoles.html](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ListRoles.html) from the IAM service

If you create an IAM policy that is more restrictive than the minimum required permissions, the console won't function as intended\.

## Permissions required by the CodeGuru Profiler profiling agent<a name="agent-policies"></a>

The CodeGuru Profiler profiling agent is imported into your profiled application\. When your application runs, the agent starts in a different thread to profile your application\. The following permissions are required to submit data to CodeGuru Profiler:
+ `codeguru-profiler:ConfigureAgent`
+ `codeguru-profiler:PostAgentProfile`

For more information, see [Enabling the agent with code](enabling-the-agent-with-code.md)\.

 The following example policy grants the current AWS user permission to write to a single profiling group in the current AWS Region\. 

```
{
   "Statement": [{
      "Effect": "Allow",
      "Action": [
         "codeguru-profiler:ConfigureAgent",
         "codeguru-profiler:PostAgentProfile"
      ],
      "Resource": "arn:aws:codeguru-profiler:region-id:aws-account-id:profilingGroup/profilingGroupName"
   }]
}
```

## Permissions required to access CodeGuru Profiler data<a name="view-policies"></a>

 Data collected and submitted to CodeGuru Profiler by an agent is used to create application profiles for visualizations: 
+ `codeguru-profiler:GetProfile`
+ `codeguru-profiler:DescribeProfilingGroup`

For more information, see [Working with visualizations](working-with-visualizations.md)\. 

The following is an example\.

```
{
   "Statement": [{
      "Effect": "Allow",
      "Action": [
         "codeguru-profiler:GetProfile",
         "codeguru-profiler:DescribeProfilingGroup"           
      ],
      "Resource": "arn:aws:codeguru-profiler:region-id:aws-account-id:profilingGroup/profilingGroupName"        
   }]
}
```

For the CodeGuru Profiler console, it can be useful to have an additional policy statement providing `ListProfilingGroups` permissions to allow users to see the list of `ProfilingGroups`\. For example, the following allows users to see a list of all profiling groups in their AWS account and Region\. 

```
{
   "Statement": [{
      "Effect": "Allow",
      "Action": [
         "codeguru-profiler:ListProfilingGroups"
      ],
      "Resource": "*"
   }]
}
```

 For more information, see [https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_ConfigureAgent.html](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_ConfigureAgent.html), [https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_PostAgentProfile.html](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_PostAgentProfile.html), [https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_GetProfile.html](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_GetProfile.html), [https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_DescribeProfilingGroup.html](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_DescribeProfilingGroup.html), and [https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_ListProfilingGroups.html](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_ListProfilingGroups.html) in the *Amazon CodeGuru Profiler API Reference*\. 

## AWS managed \(predefined\) policies for CodeGuru Profiler<a name="managed-policies"></a>

AWS addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. These AWS managed policies grant necessary permissions for common use cases so you can avoid having to investigate what permissions are needed\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\.

To create and manage CodeGuru Profiler service roles, you must also attach the AWS managed policy named `IAMFullAccess`\.

You can also create your own custom IAM policies to allow permissions for CodeGuru Profiler actions and resources\. You can attach these custom policies to the IAM users or groups that require those permissions\.

The following AWS managed policies, which you can attach to users in your account, are specific to CodeGuru Profiler\.

**Topics**
+ [AmazonCodeGuruProfilerFullAccess](#managed-full-access)
+ [AmazonCodeGuruProfilerReadOnlyAccess](#managed-read-only-access)

### AmazonCodeGuruProfilerFullAccess<a name="managed-full-access"></a>

`AmazonCodeGuruProfilerFullAccess` – Provides full access to CodeGuru Profiler, including permissions to create, update, and delete profiling groups\. Apply this only to administrative\-level users who you want to grant full control over CodeGuru Profiler profiling groups and related resources in your AWS account, including the ability to delete profiling groups\. 

The `AmazonCodeGuruProfilerFullAccess` policy contains the following statement\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeguru-profiler:*",
                "iam:ListRoles",
                "iam:ListUsers",
                "codeguru:*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

### AmazonCodeGuruProfilerReadOnlyAccess<a name="managed-read-only-access"></a>

`AmazonCodeGuruProfilerReadOnlyAccess` – Grants read\-only access to CodeGuru Profiler and related resources in other AWS services\. Apply this policy to users who you want to grant the ability to view profiling group visualizations, but not make any changes to them\. 

The `AmazonCodeGuruProfilerReadOnlyAccess` policy contains the following statement\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeguru-profiler:Get*",
                "codeguru-profiler:Describe*",
                "codeguru-profiler:List*",
                "iam:ListRoles",
                "iam:ListUsers",
                "codeguru:Get*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

## Customer managed policy examples<a name="security_iam_id-based-policy-examples"></a>

You can create your own custom IAM policies to allow permissions for CodeGuru Profiler actions and resources\. You can attach these custom policies to the IAM users, roles, or groups that require those permissions\. You can also create your own custom IAM policies for integration between CodeGuru Profiler and other AWS services\. 

 The following example IAM policies grant permissions for various CodeGuru Profiler actions\. Use them to limit CodeGuru Profiler access for your IAM users and roles\. These policies control the ability to perform actions by using the CodeGuru Profiler console, API, AWS SDKs, or the AWS CLI\. 

**Note**  
All examples use the US East \(Ohio\) Region \(us\-east\-2\) and contain fictitious account IDs\.

 **Examples**
+ [Example 1: Allow a user to see all profiling groups and the visualizations of only one profiling group](#identity-based-policies-example-1)
+ [Example 2: Allow a user to perform CodeGuru Profiler operations in a single Region](#identity-based-policies-example-2)
+ [Example 3: Allow a user connecting from a specified IP address range access to a profiling group ](#identity-based-policies-example-3)

### Example 1: Allow a user to see all profiling groups and the visualizations of only one profiling group<a name="identity-based-policies-example-1"></a>

 The following example policy grants permissions for the AWS user with account ID `123456789012` to see a list of all profiling groups in their AWS account and Region\. That user can see visualizations for only one profiling group named `my-profiling-group`\. 

```
{
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "codeguru-profiler:GetProfile",
            "codeguru-profiler:DescribeProfilingGroup"
         ],
         "Resource": "arn:aws:codeguru-profiler:us-east-2:123456789012:profilingGroup/my-profiling-group"
      },
      {
         "Effect": "Allow",
         "Action": [
            "codeguru-profiler:ListProfilingGroups"
         ],
         "Resource": "*"
      }
   ]
}
```

### Example 2: Allow a user to perform CodeGuru Profiler operations in a single Region<a name="identity-based-policies-example-2"></a>

The following permissions policy uses a wildcard character \(`"codeguru-profiler:*"`\) to allow users to perform all CodeGuru Profiler actions in the us\-east\-2 Region and not from other AWS Regions\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "codeguru-profiler:*",
      "Resource": "*",
      "Condition": {
        "StringEquals": {
          "aws:RequestedRegion": "us-east-2"
        }
      }
    }
  ]
}
```

### Example 3: Allow a user connecting from a specified IP address range access to a profiling group<a name="identity-based-policies-example-3"></a>

You can create a policy that allows users to view a CodeGuru Profiler profiling group only if their IP address is within a certain IP address range\. Because the `GetFindingsReportAccountSummary` and `ListProfilingGroups` actions don't support resource\-level permissions, their resource is specified as wildcard character \(`*`\) in a separate statement\. For more information, see the [Amazon CodeGuru Profiler permissions reference](auth-and-access-control-permissions-reference.md)\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "codeguru-profiler:*",
        "iam:ListRoles",
        "iam:ListUsers",
        "codeguru:*"
      ],
      "Resource": "arn:aws:codeguru-profiler:us-east-2:544120495673:profilingGroup/DemoProfilingGroup",
      "Condition": {
        "IpAddress": {
          "aws:SourceIp": "203.0.113.0/24"
        }
      }
    },
    {
      "Effect": "Allow",
      "Action": [
        "codeguru-profiler:GetFindingsReportAccountSummary",
        "codeguru-profiler:ListProfilingGroups"
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