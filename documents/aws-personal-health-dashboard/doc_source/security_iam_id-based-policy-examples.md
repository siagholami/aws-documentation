# AWS Health identity\-based policy examples<a name="security_iam_id-based-policy-examples"></a>

By default, IAM users and roles don't have permission to create or modify AWS Health resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\. An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator must then attach those policies to the IAM users or groups that require those permissions\.

To learn how to create an IAM identity\-based policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

**Topics**
+ [Policy best practices](#security_iam_service-with-iam-policy-best-practices)
+ [Using the AWS Health console](#security_iam_id-based-policy-examples-console)
+ [Allow users to view their own permissions](#security_iam_id-based-policy-examples-view-own-permissions)
+ [Accessing the Personal Health Dashboard and the AWS Health API](#security_iam_id-based-policy-examples-access-dashboard)
+ [Resource\- and action\-based conditions](#resource-action-based-conditions)

## Policy best practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete AWS Health resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using AWS Health quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Using the AWS Health console<a name="security_iam_id-based-policy-examples-console"></a>

To access the AWS Health console, you must have a minimum set of permissions\. These permissions must allow you to list and view details about the AWS Health resources in your AWS account\. If you create an identity\-based policy that is more restrictive than the minimum required permissions, the console won't function as intended for entities \(IAM users or roles\) with that policy\.

To ensure that those entities can still use the AWS Health console, you can attach the following AWS managed policy, [AWSHealthFullAccess](https://console.aws.amazon.com/iam/home?#/policies/arn:aws:iam::aws:policy/AWSHealthFullAcces)\.

This policy grants an entity full access to the following: 
+ Personal Health Dashboard in the AWS Management Console
+ AWS Health API operations and notifications
+ Access to enable or disable AWS Health for all accounts in an organization for AWS Organizations

**Example : AWSHealthFullAccess**  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "organizations:EnableAWSServiceAccess",
                "organizations:DisableAWSServiceAccess"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "organizations:ServicePrincipal": "health.amazonaws.com"
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": [
                "health:*",
                "organizations:ListAccounts"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "iam:AWSServiceName": "health.amazonaws.com"
                }
            }
        }
    ]
}
```

**Note**  
You can also use the AWS managed role, `Health_OrganizationsServiceRolePolicy` so that AWS Health can view events for other accounts in your organization\. For more information, see [Using service\-linked roles for AWS Health](using-service-linked-roles.md)\.

You don't need to allow minimum console permissions for users that are making calls only to the AWS CLI or the AWS API\. Instead, allow access to only the actions that match the API operation that you're trying to perform\.

For more information, see [Adding Permissions to a User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html#users_change_permissions-add-console) in the *IAM User Guide*\.

## Allow users to view their own permissions<a name="security_iam_id-based-policy-examples-view-own-permissions"></a>

This example shows how you might create a policy that allows IAM users to view the inline and managed policies that are attached to their user identity\. This policy includes permissions to complete this action on the console or programmatically using the AWS CLI or AWS API\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ViewOwnUserInfo",
            "Effect": "Allow",
            "Action": [
                "iam:GetUserPolicy",
                "iam:ListGroupsForUser",
                "iam:ListAttachedUserPolicies",
                "iam:ListUserPolicies",
                "iam:GetUser"
            ],
            "Resource": ["arn:aws:iam::*:user/${aws:username}"]
        },
        {
            "Sid": "NavigateInConsole",
            "Effect": "Allow",
            "Action": [
                "iam:GetGroupPolicy",
                "iam:GetPolicyVersion",
                "iam:GetPolicy",
                "iam:ListAttachedGroupPolicies",
                "iam:ListGroupPolicies",
                "iam:ListPolicyVersions",
                "iam:ListPolicies",
                "iam:ListUsers"
            ],
            "Resource": "*"
        }
    ]
}
```

## Accessing the Personal Health Dashboard and the AWS Health API<a name="security_iam_id-based-policy-examples-access-dashboard"></a>

The Personal Health Dashboard is available for all AWS accounts\. The AWS Health API is available only to accounts with a Business or Enterprise support plan\. For more information, see [AWS Support](https://aws.amazon.com/premiumsupport/)\.

You can use IAM to create entities \(users, groups, or roles\), and then give those entities permissions to access the Personal Health Dashboard and the AWS Health API\.

By default, IAM users don't have access to the Personal Health Dashboard or the AWS Health API\. You give users access to your account's AWS Health information by attaching IAM policies to a single user, a group of users, or a role\. For more information, see [Identities \(Users, Groups, and Roles\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) and [Overview of IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html)\.

After you create IAM users, you can give those users individual passwords\. Then, they can sign in to your account and view AWS Health information by using an account\-specific sign\-in page\. For more information, see [How Users Sign In to Your Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_how-users-sign-in.html)\.

**Note**  
An IAM user with permissions to view Personal Health Dashboard has read\-only access to health information across all AWS services on the account, which can include, but is not limited to, AWS resource IDs such as Amazon EC2 instance IDs, EC2 instance IP addresses, and general security notifications\.   
For example, if an IAM policy grants access only to Personal Health Dashboard and the AWS Health API, then the user or role that the policy applies to can access all information posted about AWS services and related resources, even if other IAM policies don't allow that access\.

You can use two groups of APIs for AWS Health\.
+ Individual accounts – You can use the operations such as [DescribeEvents](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEvents.html) and [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) to get information about AWS Health events for your account\. 
+ Organizational account – You can use operations such as [DescribeEventsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventsForOrganization.html) and [DescribeEventDetailsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetailsForOrganization.html) to get information about AWS Health events for accounts that are part of your organization\.

For more information about the available API operations, see the [AWS Health API Reference](https://docs.aws.amazon.com/health/latest/APIReference/)\.

### Individual actions<a name="individual-account-health-api-actions"></a>

You can set the `Action` element of an IAM policy to `health:Describe*`\. This allows access to the Personal Health Dashboard and AWS Health\. AWS Health supports access control to events based on the `eventTypeCode` and service\.

#### Describe access<a name="allow-describe-access-example"></a>

This policy statement grants access to Personal Health Dashboard and any of the `Describe*` AWS Health API operations\. For example, an IAM user with this policy can access the Personal Health Dashboard in the AWS Management Console and call the AWS Health `DescribeEvents` API operation\.

**Example : Describe access**  

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Allow",
    "Action": [
      "health:Describe*"
    ],
    "Resource": "*"
  }]
}
```

#### Deny access<a name="deny-access-example"></a>

This policy statement denies access to Personal Health Dashboard and the AWS Health API\. An IAM user with this policy can't view the Personal Health Dashboard in the AWS Management Console and can't call any of the AWS Health API operations\.

**Example : Deny access**  

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Deny",
    "Action": [
      "health:*"
    ],
    "Resource": "*"
  }]
}
```

### Organizational view<a name="organizational-view"></a>

 If you enable organizational view for AWS Health, you must allow access to the AWS Health API operations for AWS Organizations\. The `Action` element of an IAM policy must include the following permissions:
+ `iam:CreateServiceLinkedRole`
+ `organizations:EnableAWSServiceAccess`
+ `organizations:DisableAWSServiceAccess`
+ `organizations:ListAccounts`

To understand the exact permissions needed for each APIs, see [Actions Defined by AWS Health APIs and Notifications](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awshealthapisandnotifications.html#awshealthapisandnotifications-actions-as-permissions) in the *IAM User Guide*\.

**Note**  
You must use credentials from the master account for an organization to access the AWS Health APIs for AWS Organizations\. For more information, see [Aggregating AWS Health events across accounts with organizational view](aggregate-events.md)\.

#### Allow AWS Health organizational API access<a name="allow-organizational-api-access"></a>

This policy statement grants access to all AWS Health organizational API operations\.

**Example : Allow AWS Health organizational view access**  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "organizations:EnableAWSServiceAccess",
                "organizations:DisableAWSServiceAccess"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "organizations:ServicePrincipal": "health.amazonaws.com"
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": [
                "health:*",
                "organizations:ListAccounts"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "arn:aws:iam::*:role/aws-service-role/health.amazonaws.com/AWSServiceRoleForHealth*"
        }
    ]
}
```

#### Deny AWS Health organizational API access<a name="deny-organizational-api-access"></a>

This policy statement denies access to the AWS Organizations API operations, but allows access to the AWS Health API operations for an individual account\. 

**Example : Deny AWS Health organizational view access**  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "health:*"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": [
                "organizations:EnableAWSServiceAccess",
                "organizations:DisableAWSServiceAccess"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "organizations:ServicePrincipal": "health.amazonaws.com"
                }
            }
        },
        {
            "Effect": "Deny",
            "Action": [
                "organizations:ListAccounts"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "arn:aws:iam::*:role/aws-service-role/health.amazonaws.com/AWSServiceRoleForHealth*"
        }
    ]
}
```

**Note**  
If the user or group that you want to give permissions to already has an IAM policy, you can add the AWS Health\-specific policy statement to that policy\.

## Resource\- and action\-based conditions<a name="resource-action-based-conditions"></a>

AWS Health supports [IAM conditions](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html) for the [ DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html) and [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) API operations\. This lets you restrict events that the AWS Health API sends to a user, group, or role\. 

To do so, update the `Condition` block of the IAM policy or set the `Resource` element\. You can use [String Conditions](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html#Conditions_String) to restrict access based on certain AWS Health event fields\. 

AWS Health supports the following fields:
+ `eventTypeCode`
+ `service`

**Example : Action\-based condition**  
This policy statement grants access to Personal Health Dashboard and the AWS Health `Describe*` API operations, but denies access to any AWS Health events that relate to Amazon EC2\.  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "health:Describe*",
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": [
                "health:DescribeAffectedEntities",
                "health:DescribeEventDetails"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "health:service": "EC2"
                }
            }
        }
    ]
}
```

**Example : Resource\-based condition**  
The following policy has the same effect, but uses the `Resource` element instead\.  

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Allow",
    "Action": [
      "health:Describe*"
    ],
    "Resource": "*",
  },
  {
    "Effect": "Deny",
    "Action": [
      "health:DescribeEventDetails",
      "health:DescribeAffectedEntities"
    ],
    "Resource": "arn:aws:health:*::event/EC2/*/*",
  }]
}
```

**Example : eventTypeCode condition**  
This policy statement grants access to Personal Health Dashboard and the AWS Health `Describe*` API operations, but denies access to any AWS Health events with the `eventTypeCode` that matches `AWS_EC2_*`\.  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "health:Describe*",
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": [
                "health:DescribeAffectedEntities",
                "health:DescribeEventDetails"
            ],
            "Resource": "*",
            "Condition": {
                "StringLike": {
                    "health:eventTypeCode": "AWS_EC2_*"
                }
            }
        }
    ]
}
```

**Important**  
If you call the [DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html) and [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) operations and don't have permission to access the AWS Health event, the `AccessDeniedException` error appears\. For more information, see [Troubleshooting AWS Health identity and access](security_iam_troubleshoot.md)\.