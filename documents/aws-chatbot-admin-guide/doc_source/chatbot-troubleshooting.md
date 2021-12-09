# Troubleshooting AWS Chatbot<a name="chatbot-troubleshooting"></a>

AWS Chatbot operates with several AWS services, including Amazon CloudWatch, Amazon GuardDuty, and AWS CloudFormation\. If you encounter issues when trying to receive notifications, see the following topic for troubleshooting help\.

## Notifications aren't sent to chat rooms\.<a name="chatbot-subcription-troubleshooting-chat-rooms-not-receiving-notifications"></a>

If you configured your AWS service to send notifications to the Amazon Simple Notification Service \(Amazon SNS\) topics mapped to AWS Chatbot, but the notifications aren't appearing in the chat rooms use these steps to troubleshoot\.

**Possible causes** 
+ **The notification's originating service is not supported by AWS Chatbot\.**

  For a list of supported services, see [Using AWS Chatbot with Other AWS Services](related-services.md)\.
+ **AWS Chatbot supports CloudWatch Events only for specific AWS services\.**

  Services that support CloudWatch Events forwarding by Amazon SNS topics to Slack or Amazon Chime chat rooms include the following:
  + [AWS Billing and Cost Management](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/sns-alert-chime.html)
  + [AWS Config Events](https://docs.aws.amazon.com/config/latest/developerguide/monitor-config-with-cloudwatchevents.html)
  + [Amazon GuardDuty Events](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_findings_cloudwatch.html)
  + [AWS Health Events](https://docs.aws.amazon.com/health/latest/ug/cloudwatch-events-health.html)
  + [ AWS Security Hub Events](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-cloudwatch-events.html#securityhub-cwe-send)
  + [AWS Systems Manager Events](https://docs.aws.amazon.com/systems-manager/latest/userguide/monitoring-cloudwatch-events.html) including the following:
    + AWS Systems Manager [Configuration Compliance Events](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-compliance-fixing.html)
    + AWS Systems Manager [Maintenance Windows Events](https://docs.aws.amazon.com/systems-manager/latest/userguide/monitoring-sns-mw-register.html)
    + AWS Systems Manager [Parameter Store Events](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-paramstore-cwe.html)

  If you map Amazon SNS topics that are associated with any other AWS service, their CloudWatch Events notifications are sent to email or other standard SNS targets\. They won't work with AWS Chatbot\.
**Note**  
Some AWS services support Amazon CloudWatch alarms for reporting and monitoring\. You configure CloudWatch alarms using performance metrics from the services that are active in your account\. Amazon Elastic Compute Cloud \(EC2\), with its collection of metrics, is a good example\. When you associate CloudWatch alarms with an Amazon SNS topic that is mapped to AWS Chatbot, the Amazon SNS topic sends the CloudWatch alarm notifications to the chat rooms\.
+ **The SNS topic doesn't have a subscription to AWS Chatbot\.**

  In the Amazon SNS console, go to the **Topics** page, choose the **Subscriptions** tab, and then verify that the topic has a subscription\. If the topic doesn't, open the AWS Chatbot console, open your authorized client, and then look at the **Configured channels** or **Configured webhooks** list\. Add a new channel or webhook configuration, and then add the SNS topic\. Without this configuration, event notifications can't reach the chat rooms\. 
+ **Your SNS topic subscription to the AWS Chatbot has the Enable raw message delivery setting enabled\.**

  Don't enable the **Enable raw message delivery** feature for any SNS topic subscriptions to AWS Chatbot\.
+ **The event was throttled\.**

  AWS Chatbot allows for 10 events per second\. If more than 10 events per second are received, any event above 10 is throttled\.

## CloudWatch alarm notifications don't show the graphs from the reporting metrics\.<a name="chatbot-notification-troubleshooting-cloudwatch-alarm-notifications-missing-metrics"></a>

**Possible causes**
+ **The IAM role doesn’t have CloudWatchRead permissions\. **

  In the AWS Chatbot console, create a new role\. This role requires the Notifications permissions policy from the AWS Chatbot console when you configure a new webhook or Slack channel\. You can also edit your IAM role to [add the CloudWatchRead permissions](getting-started.md#AWS::Chatbot::Role) for AWS Chatbot\.
+ **AWS Chatbot doesn't have access to all AWS Regions\.**

  AWS Chatbot may execute API calls from any nearby AWS Region\. If any Region is disabled, you may experience problems with CloudWatch metrics graphs, among other issues\. For more information, see [I get AccessDenied or permissions errors\.](#chatbot-troubleshooting-regions)

## When I set up an SNS topic in the AWS Billing and Cost Management console to forward notifications to the AWS Chatbot, I get a "Please comply with SNS Topic ARN format" error message\.<a name="chatbot-notification-troubleshooting-sns-topic-arn-format-error"></a>

If the AWS Billing and Cost Management console displays an error message for the SNS topic you want to use for notifications, [you can edit the SNS topic's permissions policy so it can forward Budget notifications\.](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/budgets-sns-policy.html) 

Do this if you have already configured an SNS topic that has a subscription to AWS Chatbot or you've configured a new SNS topic\. It is not needed if you want to use an Amazon SNS topic that is already configured and working with AWS Billing and Cost Management\. [You can then set up that topic with a subscription to AWS Chatbot](getting-started.md#subscribe-sns-topic)\.

## How do I edit my configuration name?<a name="chatbot-notification-troubleshooting-edit-config-name"></a>

Configuration names can't be edited\. Names must be unique across your account\.

## I get AccessDenied or permissions errors\.<a name="chatbot-troubleshooting-regions"></a>

**Possible causes**
+ **You are missing some IAM permissions or trust relationships\.**

  Make sure you have the correct policies set up by following the instructions found in [Setting up AWS Chatbot](setting-up.md) and [Identity and Access Management for AWS Chatbot](security-iam.md)\.
+ **AWS Chatbot doesn't have access to all AWS Regions\.**

  AWS Chatbot is a global service and may execute API calls from any nearby AWS Region\. If any Region is disabled, you may experience errors\. Make sure the IAM role you set up for AWS Chatbot to assume has access to all Regions\. 

  [Other policy types](security-iam.md#security-iam-other-policies) can limit how IAM roles can be assumed\. If you have set up your AWS Chatbot IAM role to have global access but you're still getting errors, one of these policy types may be the culprit:
  + **AWS Organizations service control policies \(SCPs\)** \- SCPs are JSON policies that specify the maximum permissions for an organization or organizational unit \(OU\) in AWS Organizations\. A service control policy could be overriding the policies you put in place for AWS Chatbot\. See [How SCPs Work](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_about-scps.html) in the *AWS Organizations User Guide*\.
  + **IAM account settings**

    With IAM, you can use AWS Security Token Service \(AWS STS\) to create and provide trusted users with temporary security credentials that can control access to your AWS resources\. When you activate STS endpoints for a Region, AWS STS can issue temporary credentials to users and roles in your account that make an AWS STS request\. Those credentials can then be used in any Region that is enabled by default or is manually enabled\. You must activate the Region in the account where the temporary credentials are generated\. It does not matter whether a user is signed into the same account or a different account when they make the request\. For more information, see [Activating and deactivating AWS STS in an AWS Region](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_enable-regions.html#sts-regions-activate-deactivate) in the *IAM User Guide*\. 

 If there is a policy in place that prevents access to services in certain Regions, you must change the policy to allow global AWS Chatbot access\.

For example, the policy below allows AWS Chatbot in **us\-east\-2** but denies other services by using a [NotAction](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_notaction.html) element\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "NotAction": [
                "chatbot:*"
            ],
            "Resource": [
                "*"
            ],
            "Condition": {
                "StringEquals": {
                    "aws:RequestedRegion": [
                        "us-east-2"
                    ]
                }
            }
        }
    ]
}
```