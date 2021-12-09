--------

--------

# AWS IoT Things Graph Identity\-Based Policy Examples<a name="security_iam_id-based-policy-examples"></a>

By default, IAM users and roles don't have permission to create or modify AWS IoT Things Graph resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\. An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator must then attach those policies to the IAM users or groups that require those permissions\.

To learn how to create an IAM identity\-based policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

**Topics**
+ [Policy Best Practices](#security_iam_service-with-iam-policy-best-practices)
+ [Using the AWS IoT Things Graph Console](#security_iam_id-based-policy-examples-console)
+ [Allow Users to View Their Own Permissions](#security_iam_id-based-policy-examples-view-own-permissions)
+ [Getting an AWS IoT Things Graph Flow](#security_iam_id-based-policy-examples-access-flow)
+ [Viewing AWS IoT Things Graph Flow Configurations Based on Tags](#security_iam_id-based-policy-examples-view-flow-configurations)

## Policy Best Practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete AWS IoT Things Graph resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using AWS IoT Things Graph quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Using the AWS IoT Things Graph Console<a name="security_iam_id-based-policy-examples-console"></a>

To access the AWS IoT Things Graph console, you must have a minimum set of permissions\. These permissions must allow you to list and view details about the AWS IoT Things Graph resources in your AWS account\. If you create an identity\-based policy that is more restrictive than the minimum required permissions, the console won't function as intended for entities \(IAM users or roles\) with that policy\.

To ensure that those entities can still use the AWS IoT Things Graph console, make sure that they have permissions to perform the following actions:
+ `s3:REST.GET.OBJECT`
+ `s3:REST.PUT.OBJECT`
+ `iot:CreateTopicRule`
+ `iot:ListTopicRules`
+ `iot:GetTopicRule`
+ `iot:DescribeThing`
+ `iot:ListThingPrincipals`
+ `iot:UpdateThing`
+ `iot:AddThingToThingGroup`
+ `iot:DescribeThingGroup`
+ `iot:CreateThingGroup`
+ `iot:ListThingsInThingGroup`
+ `iot:DeleteThingGroup`
+ `iot:RemoveThingFromThingGroup`

For a list of required permissions for users who create and deploy flows to AWS IoT Greengrass, see [Security in AWS IoT Greengrass Deployments](iot-tg-security-gg.md)\.

You don't need to allow minimum console permissions for users that are making calls only to the AWS CLI or the AWS API\. Instead, allow access to only the actions that match the API operation that you're trying to perform\.

For more information, see [Adding Permissions to a User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html#users_change_permissions-add-console) in the *IAM User Guide*\.

## Allow Users to View Their Own Permissions<a name="security_iam_id-based-policy-examples-view-own-permissions"></a>

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
               "Resource": [
                   "arn:aws:iam::*:user/${aws:username}"
               ]
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

## Getting an AWS IoT Things Graph Flow<a name="security_iam_id-based-policy-examples-access-flow"></a>

In this example, you want to grant an IAM user in your AWS account access to your AWS IoT Things Graph flows\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"ViewFlows",
         "Effect":"Allow",
         "Action": "iotthingsgraph:GetFlowTemplate",
         "Resource": "*"
      }
   ]
}
```

## Viewing AWS IoT Things Graph Flow Configurations Based on Tags<a name="security_iam_id-based-policy-examples-view-flow-configurations"></a>

You can use conditions in your identity\-based policy to control access to AWS IoT Things Graph resources based on tags\. This example shows how you might create a policy that allows viewing a *Deployment* \(flow configuration\)\. However, permission is granted only if the *Deployment* tag `Owner` has the value of that user's user name\. This policy also grants the permissions necessary to complete this action on the console\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ViewSystemInstance",
            "Effect": "Allow",
            "Action": "iotthingsgraph:GetSystemInstance",
            "Resource": "*"
        },
        {
            "Sid": "ViewSystemInstanceIfOwner",
            "Effect": "Allow",
            "Action": "iotthingsgraph:GetSystemInstance",
            "Resource": "arn:aws:iotthingsgraph:*:*:Deployment/*",
            "Condition": {
                "StringEquals": {"aws:ResourceTag/Owner": "${aws:username}"}
            }
        }
    ]
}
```

You can attach this policy to the IAM users in your account\. If a user named `richard-roe` attempts to view an AWS IoT Things Graph flow configuration, the flow configuration must be tagged `Owner=richard-roe` or `owner=richard-roe`\. Otherwise, he is denied access\. The condition tag key `Owner` matches both `Owner` and `owner` because condition key names are not case\-sensitive\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.