# Identity\-based IAM policies for AWS Chatbot<a name="security_iam_service-with-iam-id-based-policies"></a>

A policy is an object in AWS that, when you attach it to an identity, defines their permissions\. When you create a policy to restrict or allow access to a resource, you can use an identity\-based policy\.

You can attach IAM identity\-based policies to IAM entities such as a user in your AWS account, an IAM group, or an IAM role\. You can define allowed or denied actions and resources, and the conditions under which actions are allowed or denied\. AWS Chatbot supports specific actions, resources, and condition keys\.

**Note**  
To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.  
For information about the specific IAM JSON policy elements that AWS Chatbot supports, see [Actions, Resources, and Condition Keys for AWS Chatbot](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awschatbot.html#awschatbot-policy-keys) in the *IAM User Guide*\. 

**Topics**
+ [Identity\-based policies for AWS Chatbot](#security_iam_id-based-policy-examples)
+ [Identity\-based policy best practices](#security_iam_service-with-iam-policy-best-practices)
+ [Applying AWS Chatbot permissions to an IAM identity](#ChatbotCompleteRoleExample)
+ [Allowing users to view their permissions](#security_iam_id-based-policy-examples-view-own-permissions)

## Identity\-based policies for AWS Chatbot<a name="security_iam_id-based-policy-examples"></a>

By default, IAM users, groups, and roles don't have permission to create or modify AWS Chatbot resources\. They also can't perform tasks using the AWS Management Console or AWS Command Line Interface \(AWS CLI\)\. An IAM administrator can create IAM identity\-based policies that grant entities permission to perform specific console and CLI operations on the resources that they need\. The administrator attaches those policies to the IAM entities that require those permissions\.

**Note**  
In an identity\-based policy, you don't specify the principal who gets the permission \(the `Principal` element\) because the policy gets attached to the entity that needs to use it\.

To learn about all of the elements that you use in a policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\. For information about the specific IAM JSON policy elements that AWS Chatbot supports, see [Actions, Resources, and Condition Keys for AWS Chatbot](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awschatbot.html#awschatbot-policy-keys) in the *IAM User Guide*\. 

### AWS Chatbot actions for identity\-based policies<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Actions in an AWS Chatbot policy use the following prefix before the action\. 

`"Action": [`

` "chatbot:"`

` ]`

For example, to grant a user permission to view the list of all Slack channels using the `DescribeSlackChannels` operation, you include the `chatbot:DescribeSlackChannels` action in the user's policy\. Policy statements must include either an `Action` or `NotAction` element\. AWS Chatbot defines its own set of actions that describe tasks that you can perform with this service\. To see the list of AWS Chatbot actions, see [Actions, Resources, and Condition Keys for AWS Chatbot](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awschatbot.html) in the *IAM User Guide\.*

To specify multiple actions in a single statement, separate them with commas\.

`"Action": [`

` "chatbot:DescribeSlackChannels",`

` "chatbot:DescribeSlackWorkspaces"`

` ]`

**Important**  
Although you can specify multiple actions of like type in a policy using wildcards \(\*\), we strongly discourage doing so\. Follow the practice of granting least privileges and narrowing the permissions necessary for a user to perform their work\.

## Identity\-based policy best practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete AWS Chatbot resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using AWS Chatbot quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Applying AWS Chatbot permissions to an IAM identity<a name="ChatbotCompleteRoleExample"></a>

The following example of an AWS Chatbot identity\-based policy controls all aspects of Slack chat room configuration\. It grants full read\-only permissions to Amazon CloudWatch and Amazon CloudWatch Logs, and Amazon Simple Notification Service \(Amazon SNS\) topics\. It enables Slack chat room configuration through both the AWS Chatbot console and CLI actions\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AllChatbotPermissions"
            "Action": [
                "cloudwatch:Describe*",
                "cloudwatch:Get*",
                "cloudwatch:List*",
                "logs:Get*",
                "logs:List*",
                "logs:Describe*",
                "logs:TestMetricFilter",
                "logs:FilterLogEvents",
                "sns:Get*",
                "sns:List*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
            {
            "Sid": "AllSlackPermissions",
            "Effect": "Allow",
            "Action": [
                "chatbot:Describe*",
                "chatbot:UpdateSlackChannelConfiguration",
                "chatbot:CreateSlackChannelConfiguration",
                "chatbot:DeleteSlackChannelConfiguration"
            ],
            "Resource": "*"
        }
    ]
}
```

In this example, `"Resource": "*"` refers to all applicable Slack resources\. You attach the policy to an IAM user, group, or role who needs access to all Slack resources\. 

## Allowing users to view their permissions<a name="security_iam_id-based-policy-examples-view-own-permissions"></a>

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