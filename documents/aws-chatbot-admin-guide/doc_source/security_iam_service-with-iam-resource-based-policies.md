# IAM resource\-level permissions for AWS Chatbot<a name="security_iam_service-with-iam-resource-based-policies"></a>

*Resource\-level permissions* define the AWS resources on which you allow assigned entities \(users, groups, and roles\) to perform actions\. You specify the Amazon Resource Name \(ARN\) of one or more resources as part of an IAM policy, which you can then attach to IAM entities\. 

**Note**  
AWS Chatbot doesn't support* resource\-based policies*, which are directly attached to AWS resources\. For more information about the differences between policies and permissions, see [Identity\-Based Policies and Resource\-Based Policies ](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html)in the *IAM User Guide*\.

For more information about the differences between IAM policies and permissions, see [Identity\-Based Policies and Resource\-Based Policies ](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html)in the *IAM User Guide*\. The following sections describe how resource\-level permissions work with AWS Chatbot\.

**Topics**
+ [Using the AWS Chatbot resource in a policy](#security_iam_resource-description)
+ [Example: AWS Chatbot resource\-level permission](#security_iam_resource-based-policy-examples)

## Using the AWS Chatbot resource in a policy<a name="security_iam_resource-description"></a>

You can set up an IAM policy that defines *who* \(users, groups and roles\) can perform actions on AWS Chatbot resources\. The policy uses *resource\-level permissions* to determine *which* AWS Chatbot resources that users of the IAM policy can work with\. The policy also defines *how* they can work with them \(through Actions and Conditions\)\.

When creating an IAM policy, you refer to the **chat\-configuration** resource by its Amazon Resource Name \(ARN\)\. An AWS Chatbot resource ARN consists of three objects:
+ A list of one or more Amazon Simple Notification Service \(Amazon SNS\) topic ARNs for the topics to be associated with the configuration\.
+ The ARN of the customer's IAM role\. 

   AWS Chatbot assumes the IAM role in the customer's account and makes API calls to other AWS services to get necessary information\. For example, for an Amazon CloudWatch alarm notification, AWS Chatbot requires the metric graphic image displayed with the CloudWatch alarm notification\. For that, AWS Chatbot calls a CloudWatch API with the customer's credentials\.
+ An Amazon Chime webhook URL or Slack channel ID/Slack workspace ID\.

  When creating a resource\-level permission for a chatbot configuration, in the JSON both Slack channels and Amazon Chime webhooks are considered a *chat\-configuration*\. The chat\-configuration uses a following ARN field to distinguish between a Slack channel and a Amazon Chime webhook\.

  The `configuration-name` field is the name for the Slack channel or Amazon Chime webhook that is defined in the AWS Chatbot console\.

The AWS Chatbot resource ARN has the following format:

`arn:${partition}:chatbot::${account-id}:chat-configuration/slack-channel/${configuration-name}`

Or:

`arn:${partition}:chatbot::${account-id}:chat-configuration/chime-webhook/${configuration-name}`

For example:

`arn:aws:chatbot::123456789021:chat-configuration/slack-channel/devops_channel_01`

Or:

`arn:aws:chatbot::123456789021:chat-configuration/chime-webhook/devops_webhook_IT_team_space`

**Note**  
When you create the permissions, ensure that any Actions apply to the correct configuration type\. 

## Example: AWS Chatbot resource\-level permission<a name="security_iam_resource-based-policy-examples"></a>

You can use resource\-based permissions to allow or deny access to one or more AWS Chatbot resources in an IAM policy, or to all AWS Chatbot resources\. 

To add a resource\-level permission to a policy, include the channel's ARN in a new `Resource` statement\. The following example is based on the identity\-based policy in [AWS Chatbot Identity\-Based Policies](security_iam_service-with-iam-id-based-policies.md)\. It shows examples for both `slack-channel` and `chime-webhook` resources\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
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
                "chatbot:CreateChimeWebhookConfiguration"
                "chatbot:UpdateChimeWebhookConfiguration"
                ],
            "Resource":"arn:aws:chatbot::123456789021:chat-configuration/slack-channel/devops_private_channel"
            "Resource":"arn:aws:chatbot::123456789021:chat-configuration/chime-webhook/devops_aws_chime_webhook1"
            }
        }
    ]
}
```

You attach the policy to the IAM entity that needs it\. The associated users can create, edit, view and delete the resource's Slack chat channels, workspaces and associated SNS topics, and create and edit Amazon Chime webhooks\.