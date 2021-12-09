# IAM policies for AWS Chatbot<a name="chatbot-iam-policies"></a>

This section describes the IAM permissions and policies that AWS Chatbot uses to secure its operations with other AWS services\. AWS Chatbot uses these permissions to safely forward Amazon SNS notifications to chat rooms, support AWS CLI commands sessions in Slack, invoke Lambda functions, and create AWS support tickets directly in the Slack console\. You can also define your own custom policies for the same purposes, using these policies as templates\.

When you create a new role in the AWS Chatbot console, any of the IAM policies described in this topic might be assigned to that role\. You could apply all of them to a single role, or choose only a couple of them based on how the users of that role will use the AWS Chatbot\. Some policies contain a superset of permissions of other policies\. 

**Topics**
+ [AWS managed IAM policies in AWS Chatbot](#aws-managed-policies-for-chatbot)
+ [Customer managed IAM policies in AWS Chatbot](#user-managed-chatbot-iam-policies)

## AWS managed IAM policies in AWS Chatbot<a name="aws-managed-policies-for-chatbot"></a>

AWS Chatbot supports the following AWS managed IAM policies:
+ [**ReadOnlyAccess**](#read-only-access-managed-policy) 
+ [**CloudWatchReadOnlyAccess** ](#CloudwatchReadOnlyAccess-policy-for-chatbot)
+ [**AWS Support Command Permissions Policy** ](#chatbot_support_policy)

AWS managed policies are available to all AWS Chatbot users, but you can't change or edit them\. You can copy them and use them as templates for your own policies, knowing that you are using AWS\-approved policy language to build your own policies\.

AWS Chatbot adheres to standard IAM practices for using admin IAM accounts to activate and use the AWS Chatbot service\.

As a convenience, AWS Chatbot also supports the creation of new IAM roles directly in the AWS Chatbot console\. However, to configure existing IAM entities to use AWS Chatbot, you need to use the IAM console\.

### The IAM ReadOnlyAccess policy<a name="read-only-access-managed-policy"></a>

The **ReadOnlyAccess** policy is an AWS managed policy that is automatically assigned to roles in the AWS Chatbot service\. 

This policy does not appear in the AWS Chatbot console\. It defines Get, List, and Describe permissions for the entire suite of AWS services, enabling AWS Chatbot to use this role to access any of those services on your behalf\. 

You can attach this policy to new roles in IAM, or use it as a template to define your own, more restrictive policy\. 

**Note**  
AWS Chatbot must use a role that defines all the read\-only permissions necessary for its usage\. You can define a policy to be more restrictive or specify fewer services than the policy described here, and use that in place of the **ReadOnlyAccess** policy\. However, you must ensure that all CloudWatch and Amazon SNS read\-only permissions remain in your policy, or some CloudWatch features may not work with AWS Chatbot\. The policy also must provide Get, List, and Describe permissions for services supported by AWS Chatbot\. 

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "a4b:Get*",
                "a4b:List*",
                "a4b:Describe*",
                "a4b:Search*",
                "acm:Describe*",
                "acm:Get*",
                "acm:List*",
                "acm-pca:Describe*",
                "acm-pca:Get*",
                "acm-pca:List*",
                "amplify:GetApp",
                "amplify:GetBranch",
                "amplify:GetJob",
                "amplify:GetDomainAssociation",
                "amplify:ListApps",
                "amplify:ListBranches",
                "amplify:ListDomainAssociations",
                "amplify:ListJobs",
                (...)
                "xray:BatchGet*",
                "xray:Get*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

### The CloudWatchReadOnlyAccess policy<a name="CloudwatchReadOnlyAccess-policy-for-chatbot"></a>

You can attach the **CloudWatchReadOnlyAccess** policy to AWS Chatbot roles when you edit them in the IAM console\. This policy does not appear in the AWS Chatbot console\.

It is an AWS managed policy\. You can attach this policy to any role for AWS Chatbot usage\. You can define your own policy with greater restrictions, using this policy as a template\.

AWS Chatbot users can use this policy to support Amazon CloudWatch events reporting, alarms, CloudWatch logs, and CloudWatch trend charts for most of AWS Chatbot's supported AWS services\. It allows read\-only operations for CloudWatch Logs and the Amazon Simple Notification Service service, and can be used in place of the customer managed [**Notification permissions policy**](#read-only-notifications-policy)\. However, you must use the IAM console to attach this policy to any IAM role\.

The Logs permissions also support the useful **Show Logs** feature for CloudWatch alarms notifications in Slack\. AWS Chatbot also supports actions for displaying logs for Lambda and Amazon API Gateway\.

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "autoscaling:Describe*",
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
        }
    ]
}
```

### The AWS Support Command Permissions policy<a name="chatbot_support_policy"></a>

The **AWS Support Command Permissions** policy appears in the AWS Chatbot console when you configure resources\. It's provided in the AWS Chatbot console to conveniently set up a role, to allow Slack users to create AWS support tickets through their Slack channels\. 

In the IAM console, this policy appears as **AWSSupportAccess**\. 

It is an AWS managed policy\. You can also attach this policy in IAM to any role\. You can define your own policy with greater restrictions, using this policy as a template, for roles in AWS Chatbot\.

The **Support Command Permissions** policy applies only to the AWS Support service\.

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "support:*"
            ],
            "Resource": "*"
        }
    ]
}
```

## Customer managed IAM policies in AWS Chatbot<a name="user-managed-chatbot-iam-policies"></a>

 AWS Chatbot also supports three service\-provided customer managed IAM policies, that you can apply to any AWS Chatbot role\. They can also be used as templates for defining custom IAM permissions for your users:
+ [**ReadOnly Command Permissions policy**](#read-only-policy-for-cli) 
+ [**Lambda\-Invoke Command Permissions policy**](#lambda-invoke-policy-for-chatbot-cli)
+ [**Notification permissions policy**](#read-only-notifications-policy)

### The AWS Chatbot Read\-Only Command Permissions IAM policy<a name="read-only-policy-for-cli"></a>

The **Read\-Only Command Permissions** policy appears in the AWS Chatbot console when you configure resources\. You use this policy to support AWS commands and actions in Slack channels\.

It is a customer managed policy\. It pairs with the [**Lambda\-Invoke Command Permissions** policy](#lambda-invoke-policy-for-chatbot-cli) to provide a convenient AWS Chatbot configuration to enable Slack channel support for sending commands to the AWS CLI\.

The **Read\-Only Command Permissions** policy denies permission for AWS Chatbot users to get sensitive information from AWS services through the Slack channel, such as Amazon EC2 password information, key pairs and login credentials\.

This policy appears in the IAM console as the **AWS\-Chatbot\-ReadOnly\-Commands\-Policy**\.

You can edit and assign this policy to any role in AWS Chatbot or in IAM\. For editing of roles and policies for AWS Chatbot usage, we recommend using the IAM console\.

**Note**  
If you want to use this policy as a template, we recommend saving a new copy of the policy under a different name and making your changes there\.

For your team's command usage in Slack channels, you must use a role that defines the necessary read\-only permissions\. 

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "iam:*",
                "s3:GetBucketPolicy",
                "ssm:*",
                "sts:*",
                "kms:*",
                "cognito-idp:GetSigningCertificate",
                "ec2:GetPasswordData",
                "ecr:GetAuthorizationToken",
                "gamelift:RequestUploadCredentials",
                "gamelift:GetInstanceAccess",
                "lightsail:DownloadDefaultKeyPair",
                "lightsail:GetInstanceAccessDetails",
                "lightsail:GetKeyPair",
                "lightsail:GetKeyPairs",
                "redshift:GetClusterCredentials",
                "storagegateway:DescribeChapCredentials"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

### The AWS Chatbot Lambda\-Invoke Command Permissions policy<a name="lambda-invoke-policy-for-chatbot-cli"></a>

The **Lambda\-Invoke Command Permissions** policy appears in the AWS Chatbot console when you configure resources\. It pairs with the [**Read\-Only Command Permissions** policy](#read-only-policy-for-cli) to provide a convenient AWS Chatbot configuration to enable Slack channel access to the AWS CLI, and to features that make sense for CLI use\. The policy allows AWS Chatbot users to invoke Lambda functions in their Slack channels\. 

It is a customer managed policy\. In the IAM console, it appears as **AWS\-Chatbot\-LambdaInvoke\-Policy**\.

You can edit and assign this policy to any role in AWS Chatbot or in IAM\. 

By default, the **Lambda\-Invoke** policy is very permissive, because you can invoke any function for any action\.

We recommend using this policy as a template to define your own, more restrictive policies, such as permissions to invoke functions developed for your DevOps team that only they should be able to invoke, and deny permissions to invoke Lambda functions for any other purpose\. To edit roles and policies for AWS Chatbot, use the IAM console\.

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "lambda:invokeAsync",
                "lambda:invokeFunction"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

### The AWS Chatbot Notification Permissions IAM policy<a name="read-only-notifications-policy"></a>

The **Notification Permissions** policy appears in the AWS Chatbot console when you configure resources\. It provides the minimum usable IAM policy configuration for using the AWS Chatbot in Slack channels and Amazon Chime webhooks\. The **Notification Permissions** policy enables AWS Chatbot admins to forward CloudWatch Events, CloudWatch alarms, and format charting data for viewing in chat room messages\. Because many of AWS Chatbot's supported services use CloudWatch as their event and alarm processing layer, AWS Chatbot requires this policy for core functionality\. You can use other policies, such as [**CloudWatchReadOnlyAccess**](#CloudwatchReadOnlyAccess-policy-for-chatbot), in place of this policy, but you must attach that policy to the role in the IAM console\.

It is a customer managed policy\. You can edit and assign this policy to any role for AWS Chatbot usage\.

**Note**  
If you want to use this policy as a template, we recommend saving a new copy of the policy under a different name and making your changes there\.

In the IAM console, it appears as **AWS\-Chatbot\-NotificationsOnly\-Policy**\.

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "cloudwatch:Describe*",
                "cloudwatch:Get*",
                "cloudwatch:List*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```