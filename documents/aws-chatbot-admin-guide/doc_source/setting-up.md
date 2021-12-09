# Setting up AWS Chatbot<a name="setting-up"></a>

To use AWS Chatbot, you authorize an Amazon Chime configuration or a Slack workspace with AWS Chatbot, and optionally configure AWS Chatbot to use an Amazon Simple Notification Service \(Amazon SNS\) topic to deliver notifications to the chat rooms\. Before you can get started, you must complete the following setup tasks\.

**Topics**
+ [Prerequisites](#chatbot-prereqs)
+ [Setting up IAM permissions for AWS Chatbot](#chatbot-iam)
+ [Setting up Amazon SNS topics](#chatbot-sns)

## Prerequisites<a name="chatbot-prereqs"></a>

With AWS Chatbot, you can use Amazon Chime and Slack chat rooms to monitor and respond to events in your AWS Cloud\.

Below are some prerequisites you should have before you begin using AWS Chatbot:
+ You have signed up for AWS and created an AWS Identity and Access Management \(IAM\) administrator user\. If this is your first time using AWS, see [Creating Your First IAM Admin User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *IAM User Guide*\.
+ You have started using some AWS services\. For more information about AWS services you can use with AWS Chatbot, see [Using AWS Chatbot with other AWS services](related-services.md)\.
+ You have administrator privileges with a Slack workspace or an Amazon Chime chat room\.

## Setting up IAM permissions for AWS Chatbot<a name="chatbot-iam"></a>

If you have an existing administrator user, you can access the AWS Chatbot console with no additional permissions\.

If you would like to add AWS Chatbot access to an existing user or group, you can choose from allowed Chatbot actions in IAM\.

**Note**  
All users in the Slack channel or Amazon Chime chat room will have the permissions defined by the role\.

**To create a policy to configure AWS Chatbot**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Policies** from the navigation pane\.

1. Choose **Create policy**\.

1. Expand **Service** and find **Chatbot**\.

1. Under **Actions**, expand the **Read** and **Write** sections to see the available actions\.

   **Read** actions include **DescribeChimeWebhookConfigurations**, **DescribeSlackChannelConfigurations**, and more\.

   **Write** actions include **CreateChimeWebhookConfiguration**, **DeleteChimeWebhookConfiguration**, and more\.

1. After selecting the actions you want to include, choose **Review policy**\.

1. Give your policy a name and description, then choose **Create policy**\. You can now add your new policy to any of your users or groups\.

For more information on updating the permissions of existing users, see [Adding Permissions to a User \(Console\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html#users_change_permissions-add-console) in the *IAM User Guide*\.

**Note**  
 AWS Chatbot is a global service that requires access to all AWS Regions\. If there is a policy in place that prevents access to services in certain Regions, you must change the policy to allow global AWS Chatbot access\. For more information about policy types that might limit how IAM roles can be assumed and how to override them, see [Other policy types](security-iam.md#security-iam-other-policies)\. 

## Setting up Amazon SNS topics<a name="chatbot-sns"></a>

To use AWS Chatbot, you must have Amazon SNS topics set up\. If you don't have any Amazon SNS topics yet, follow the steps to get started in [Getting Started with Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/sns-getting-started.html) in the *Amazon Simple Notification Service Developer Guide*\.