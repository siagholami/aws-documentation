# Amazon Detective identity\-based policy examples<a name="security_iam_id-based-policy-examples"></a>

By default, IAM users and roles don't have permission to create or modify Detective resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\.

An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator then attaches those policies to the IAM users or groups that require those permissions\.

To learn how to create an IAM identity\-based policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

**Topics**
+ [Policy best practices](#security_iam_service-with-iam-policy-best-practices)
+ [Using the Detective console](#security_iam_id-based-policy-examples-console)
+ [Allowing users to view their own permissions](#security_iam_id-based-policy-examples-view-own-permissions)
+ [Master account: Managing the member accounts in a behavior graph](#security_iam_id-based-policy-examples-master-account-mgmt)
+ [Master account: Using a behavior graph for investigation](#security_iam_id-based-policy-examples-master-investigate)
+ [Member account: Managing behavior graph invitations and memberships](#security_iam_id-based-policy-examples-member-account)

## Policy best practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete Detective resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using Detective quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Using the Detective console<a name="security_iam_id-based-policy-examples-console"></a>

To use the Amazon Detective console, the user or role must have access to the relevant actions, which match corresponding actions in the API\.

To enable Detective and become a master account for a behavior graph, the user or role must be granted permission for the `CreateGraph` action\.

To use the Detective console to perform any master account actions, the user or role must be granted permission for the `ListGraphs` action\. This grants permission to retrieve the behavior graphs their account is a master for\. They also must be granted permission to perform specific master account actions\.

The most basic master account actions are to view a list of member accounts in a behavior graph, and to use the behavior graph for investigation\.
+ To view the list of member accounts in a behavior graph, the principal must be granted permission for the `ListMembers` action\.
+ To conduct investigation in a behavior graph, the principal must be granted permission for the `SearchGraph` action\.

To use the Detective console to perform any member account actions, the user or role must be granted permission for the `ListInvitations` action\. This grants permission to view behavior graph invitations\. They can then be granted permission for specific member account actions\.

## Allowing users to view their own permissions<a name="security_iam_id-based-policy-examples-view-own-permissions"></a>

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

## Master account: Managing the member accounts in a behavior graph<a name="security_iam_id-based-policy-examples-master-account-mgmt"></a>

This example policy is intended for master account users who are only responsible for managing the member accounts used in the behavior graph\. The policy also allows the user to view the usage information and deactivate Detective\. The policy does not grant permission to use the behavior graph for investigation\.

```
{"Version":"2012-10-17",
  "Statement":[
   {
    "Effect":"Allow",
    "Action":["detective:ListMembers","detective:CreateMembers","detective:DeleteMembers","detective:DeleteGraph","detective:Get*","detective:StartMonitoringMember"],
    "Resource":"arn:aws:detective:us-east-1:111122223333:graph:027c7c4610ea4aacaf0b883093cab899"
  },
  {
    "Effect":"Allow",
    "Action":["detective:CreateGraph","detective:ListGraphs"],
    "Resource":"*"
  }
 ]
}
```

## Master account: Using a behavior graph for investigation<a name="security_iam_id-based-policy-examples-master-investigate"></a>

This example policy is intended for master account users who use the behavior graph for investigation only\. They cannot view or edit the list of member accounts in the behavior graph\.

```
{"Version":"2012-10-17",
  "Statement":[
   {
    "Effect":"Allow",
    "Action":["detective:SearchGraph"],
    "Resource":"arn:aws:detective:us-east-1:111122223333:graph:027c7c4610ea4aacaf0b883093cab899"
   },
   {
    "Effect":"Allow",
    "Action":["detective:ListGraphs"],
    "Resource":"*"
  }
 ]
}
```

## Member account: Managing behavior graph invitations and memberships<a name="security_iam_id-based-policy-examples-member-account"></a>

This example policy is intended for users belonging to a member account\. In the example, the member account belongs to two behavior graphs\. The policy grants permission to respond to invitations and remove the member account from the behavior graph\.

```
{"Version":"2012-10-17",
  "Statement":[
   {
    "Effect":"Allow",
   "Action":["detective:AcceptInvitation","detective:RejectInvitation","detective:DisassociateMembership"],
   "Resource":[
       "arn:aws:detective:us-east-1:111122223333:graph:027c7c4610ea4aacaf0b883093cab899",
       "arn:aws:detective:us-east-1:444455556666:graph:056d2a9521xi2bbluw1d164680eby416"
    ]
  },
  {
    "Effect":"Allow",
    "Action":["detective:ListInvitations"],
    "Resource":"*"
  }
 ]
}
```