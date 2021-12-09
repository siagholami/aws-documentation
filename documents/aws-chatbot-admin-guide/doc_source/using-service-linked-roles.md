# Using service\-linked roles for AWS Chatbot<a name="using-service-linked-roles"></a>

A [service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) is a type of IAM role that links directly to an AWS service\. It gives AWS services the permissions to access resources in other services to complete actions on your behalf\.

**Topics**
+ [Service\-linked role permissions for AWS Chatbot](#slr-permissions)
+ [Enabling the service\-linked role for AWS Chatbot](#create-slr)
+ [Editing a service\-linked role for AWS Chatbot](#edit-slr)
+ [Manually deleting the AWSServiceRoleForAWSChatbot service\-linked role](#delete-slr)
+ [Supported regions for AWS Chatbot service\-linked roles](#slr-regions)

For information about other services that support service\-linked roles, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose any **Yes** entry with a link to view the service\-linked role documentation for that service\.

When you create an AWS Chatbot resource in the AWS Chatbot console, you can also choose to provide a list of one or more SNS topics to associate with the new resource\. AWS Chatbot automatically uses the **AWSServiceRoleForAWSChatbot** service\-linked role to add or remove subscriptions to the AWS Chatbot global Amazon SNS subscription endpoint\.

The service\-linked role makes setting up AWS Chatbot easier because you don’t have to manually add the necessary permissions\. AWS Chatbot defines the permissions for the service\-linked role and only AWS Chatbot can assume that role\. The permissions include a trust policy and a permissions policy, which apply only to the AWS Chatbot service\. 

## Service\-linked role permissions for AWS Chatbot<a name="slr-permissions"></a>

AWS Chatbot uses the service\-linked role named **AWSServiceRoleForAWSChatbot**\. This is a managed IAM policy with scoped permissions that AWS Chatbot needs to run in customers’ accounts\.

The AWS Chatbot service\-linked role gives permissions for the following services and resources:
+ Amazon SNS notifications
+ CloudWatch Logs

These permissions allow AWS Chatbot to perform operations on Amazon SNS topics and CloudWatch Logs\.

IAM administrators can view, but can't edit, the permissions for the AWS Chatbot service\-linked role\.

The **AWSServiceRoleForAWSChatbot** service\-linked role provides trust permissions to the following service to assume its role:
+ management\.chatbot\.amazonaws\.com

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

When you create an AWS Chatbot configuration, it creates the following policy for the service\-linked role:

```
{

    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
              "sns:ListSubscriptionsByTopic",
              "sns:ListTopics",
              "sns:Unsubscribe",
              "sns:Subscribe",
              "sns:ListSubscriptions"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
              "logs:PutLogEvents",
              "logs:CreateLogStream"
              "logs:DescribeLogStreams"
              "logs:CreateLogGroup"
              "logs:DescribeLogGroups"
            ],
            "Resource": "arn:aws:logs:*:*:log-group:/aws/chatbot/*"
        }
    ]
}
```

You don't need to take any action to support this role beyond using the AWS Chatbot service\. 

## Enabling the service\-linked role for AWS Chatbot<a name="create-slr"></a>

When you configure AWS Chatbot for the first time, you configure a Slack channel or Amazon Chime webhook to work with Amazon Simple Notification Service \(Amazon SNS\) topics for forwarding notifications to chat rooms\. When you create the first resource, AWS Chatbot automatically creates the IAM service\-linked role, which can be seen in the IAM console\. You don't need to manually create or configure this role\. 

## Editing a service\-linked role for AWS Chatbot<a name="edit-slr"></a>

You can't edit the **AWSServiceRoleForAWSChatbot** service\-linked role\. You also can't change its name, because other entities might reference it\. You can edit the role's description using the IAM console\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Manually deleting the AWSServiceRoleForAWSChatbot service\-linked role<a name="delete-slr"></a>

Under specific circumstances, you can manually delete the **AWSServiceRoleForAWSChatbot** service\-linked role\. If you no longer need to use any feature or service that requires a service\-linked role, we recommend that you delete that role\. Doing so prevents having an unused entity that is not actively maintained in your account\.

To delete the AWS Chatbot service\-linked role, you must delete all AWS Chatbot resources in your AWS account, including all Slack channels and Amazon Chime webhooks\. You can delete all AWS Chatbot resources using the AWS Chatbot console, and then use the IAM console or AWS Command Line Interface \(AWS CLI\) to delete the service\-linked role\. 

**Note**  
If AWS Chatbot is using the **AWSServiceRoleForAWSChatbot** service\-linked role when you try to delete its resources, the deletion might fail\. If that happens, wait a few minutes and try deleting it again\.

**To delete AWS Chatbot resources**

1. [Open the AWS Chatbot console](https://us-east-2.console.aws.amazon.com/chatbot/home?region=us-east-2#/chat-clients)\.

1. To remove Amazon Chime webhook configurations, do the following:

   1. Choose **Amazon Chime**\.

   1. Choose each webhook that you need to delete and choose **Delete webhook**\. You can delete one at a time\.

   1. Choose **Delete** to confirm the deletion\.

   1. Repeat these steps to delete all webhook configurations\.

1. To remove Slack channel configurations, do the following:

   1. Choose **Slack**\.

   1. Choose the channel that you need to delete and choose **Delete channel**\.

   1. Choose **Delete** to confirm the deletion\.

   1. Repeat these steps to delete all Slack channel configurations\.
**Note**  
If you delete the AWS Chatbot service\-linked role, and then need to use it again, simply open the AWS Chatbot console and create a new Slack channel or Amazon Chime webhook resource to recreate the role in your account\. When you create the first new resource in AWS Chatbot, it creates the service\-linked role for you again\. 

1. To delete the **AWSServiceRoleForAWSChatbot** service\-linked role, use the IAM console or the AWS Command Line Interface \(AWS CLI\) \. For information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported regions for AWS Chatbot service\-linked roles<a name="slr-regions"></a>

AWSServiceRoleForAWSChatbot doesn't support using service\-linked roles in every AWS Region where the service is available\. The following table shows the Regions where you can use the **AWSServiceRoleForAWSChatbot**\.


****  

| Region Name | Region Identity | Supported in AWS Chatbot | 
| --- | --- | --- | 
| US East \(N\. Virginia\) | us\-east\-1 | Yes | 
| US East \(Ohio\) | us\-east\-2 | Yes | 
| US West \(N\. California\) | us\-west\-1 | Yes | 
| US West \(Oregon\) | us\-west\-2 | Yes | 
| Asia Pacific \(Mumbai\) | ap\-south\-1 | Yes | 
| Asia Pacific \(Osaka\-Local\) | ap\-northeast\-3 | Yes | 
| Asia Pacific \(Seoul\) | ap\-northeast\-2 | Yes | 
| Asia Pacific \(Singapore\) | ap\-southeast\-1 | Yes | 
| Asia Pacific \(Sydney\) | ap\-southeast\-2 | Yes | 
| Asia Pacific \(Tokyo\) | ap\-northeast\-1 | Yes | 
| Canada \(Central\) | ca\-central\-1 | Yes | 
| Europe \(Frankfurt\) | eu\-central\-1 | Yes | 
| Europe \(Ireland\) | eu\-west\-1 | Yes | 
| Europe \(London\) | eu\-west\-2 | Yes | 
| Europe \(Paris\) | eu\-west\-3 | Yes | 
| South America \(São Paulo\) | sa\-east\-1 | Yes | 
| AWS GovCloud \(US\) | us\-gov\-west\-1 | No | 