# Using AWS Chatbot with other AWS services<a name="related-services"></a>

AWS Chatbot works with a number of AWS services, including [Amazon CloudWatch](https://console.aws.amazon.com/cloudwatch/), [AWS Security Hub](https://console.aws.amazon.com/securityhub/), and [Amazon GuardDuty](https://console.aws.amazon.com/guardduty/)\. All services that work with AWS Chatbot use [Amazon SNS topics](https://docs.aws.amazon.com/sns/latest/dg/) as targets to send event and alarm notifications\. You may already have established Amazon SNS topics that send notifications to DevOps and development personnel as emails\. Because AWS Chatbot redirects those Amazon SNS topics' notifications to chat rooms, you can map those Amazon SNS topics to a Slack channel or Amazon Chime webhook in the AWS Chatbot console\. 

When you create a new Amazon SNS topic, your services will require additional configuration\. 

**Topics**
+ [AWS Billing and Cost Management](#aws-billing)
+ [AWS CloudFormation](#cloud-formation)
+ [Notifications for AWS developer tools](#codeserviceevents)
+ [Amazon CloudWatch Alarms](#cloudwatch)
+ [Amazon CloudWatch Events](#cloudwatchevents)

You can set up the following AWS services to forward notifications to Amazon Chime or Slack chat rooms\.

## AWS Billing and Cost Management<a name="aws-billing"></a>

AWS Billing and Cost Management helps AWS account holders plan service usage, service costs, and instance reservations\. You do this using several specific types of budgets, which track your unblended costs, subscriptions, refunds, and Reserved Instances\. The service sends AWS Budget Alerts to an Amazon SNS topic\. You then map the Amazon SNS topic in AWS Chatbot to send those notifications to your chat rooms\.

For information about setting up Amazon SNS topics for AWS budgets, see [Creating an Amazon SNS Topic for Budget Notifications](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/budgets-sns-policy.html) in the* AWS Billing and Cost Management User Guide*\.

## AWS CloudFormation<a name="cloud-formation"></a>

AWS CloudFormation is an infrastructure management service that helps you model and set up Amazon Web Services resources so you can spend less time managing those resources and more time focusing on the applications that you run in AWS\. You create a template that describes all of the AWS resources \(for example, Amazon EC2 instances or Amazon RDS DB instances\) that you want, and AWS CloudFormation provisions and configures those resources for you\. 

AWS Chatbot supports AWS CloudFormation notifications through Amazon SNS topics\. You enable support for SNS topics that are enabled for use with AWS Chatbot by selecting them in each AWS CloudFormation stack configuration\. For more information, see [Setting AWS CloudFormation Stack Options](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-console-add-tags.html) in the *AWS CloudFormation User Guide*\. 

## Notifications for AWS developer tools<a name="codeserviceevents"></a>

AWS provides a suite of cloud\-based developer tools for creating, managing, and working with software development projects\. The AWS development tools suite includes AWS services such as AWS CloudFormation stacks, AWS CodeBuild, AWS CodeCommit, AWS CodeDeploy, AWS CodePipeline, and more\. You can redirect Amazon SNS topic subscriptions for these services to AWS Chatbot\. For example, if you want notifications about events in an AWS CodeCommit repository or in a pipeline in AWS CodePipeline to appear in a Slack channel for your development teams, you can set up notifications for those resources in the Developer Tools console, and then integrate the SNS topic used for those notifications with AWS Chatbot\. For more information, see [Configure Integration Between Notifications and AWS Chatbot](https://docs.aws.amazon.com/codestar-notifications/latest/userguide/notifications-chatbot.html) in the *Developer Tools Console User Guide*\.

## Amazon CloudWatch Alarms<a name="cloudwatch"></a>

To monitor performance and operating metrics for AWS services, and send notifications when thresholds are breached, you can create alarms in Amazon CloudWatch\. CloudWatch sends an Amazon SNS notification or performs an action when the alarm changes state\. The `Alarms` action sends notifications to an Amazon SNS topic that forwards the notification to AWS Chatbot for viewing in chat rooms\.

Any metric, for any AWS service, that CloudWatch alarm actions can report can also be shared by an SNS topic to chat rooms through AWS Chatbot\. This includes alarms for services such as Amazon Elastic Compute Cloud \(Amazon EC2\)\. 

For information about setting up SNS topics to forward CloudWatch alarms, see [Set Up Amazon SNS Notifications](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/US_SetupSNS.html) in the *Amazon CloudWatch User Guide*\.

Because CloudWatch alarms use SNS topics to forward alarm notifications, you need to map only the associated Amazon SNS topic to your Slack channel or Amazon Chime webhook configuration in AWS Chatbot\.

AWS Chatbot also supports several AWS services through CloudWatch Events\. For more information, see the following section\.

## Amazon CloudWatch Events<a name="cloudwatchevents"></a>

AWS Chatbot supports several AWS services through [Amazon CloudWatch Events rules](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html)\. CloudWatch uses CloudWatch Events rules to help manage AWS service events and how you respond to them\. You can use these rules to associate an Amazon SNS topic \(or other actions\) with an event type from any AWS service\.

You map the Amazon SNS topic to the CloudWatch Events rule, and then map it to an Slack channel or Amazon Chime webhook in the AWS Chatbot console\. When a service event matches the rule, the rule's Amazon SNS topic sends a notification to the chat room\. 

AWS Chatbot supports CloudWatch Events for the following AWS services: AWS Config, Amazon GuardDuty, AWS Health, AWS Security Hub, and AWS Systems Manager\.

### [AWS Config](https://console.aws.amazon.com/config/)<a name="aws-config"></a>

AWS Config performs resource oversight and tracking for auditing and compliance, config change management, troubleshooting, and security analysis\. It provides a detailed view of AWS resources configuration in your AWS account\. The service also shows how resources relate to one another and how they were configured in the past, so you can see how configurations and relationships change over time\. 

For AWS Config monitoring, [you configure Amazon CloudWatch Events rules](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html) to forward AWS Config events notifications to an Amazon SNS topic\. You can then map that topic to AWS Chatbot to track those event notifications in chat rooms\.

 For more information, see [ Notifications for AWS Config](https://docs.aws.amazon.com/config/latest/developerguide/notifications-for-AWS-Config.html) in the *AWS Config Developer Guide*\.

### [Amazon GuardDuty](https://console.aws.amazon.com/guardduty/)<a name="aws-guardduty"></a>

Amazon GuardDuty is a security threat monitoring service that detects and reports on potential security threats in your AWS account\. It uses threat intelligence feeds, such as lists of malicious IPs and domains, and machine learning to identify possible unauthorized and malicious activity in your AWS environment\.

GuardDuty reports its security incidents and threats through *findings*\. Findings appear in the GuardDuty console and automatically appear as CloudWatch Events\. You then [create Amazon CloudWatch Events rules](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html),  so these events appear as notifications to a selected SNS topic\. You then map that SNS topic to a Slack channel or Amazon Chime webhook in AWS Chatbot\.

 For more information, see [Monitoring Amazon GuardDuty Findings with Amazon CloudWatch Events](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_findings_cloudwatch.html) in the *Amazon GuardDuty User Guide*\.

### [AWS Health](https://phd.aws.amazon.com/phd/home#/)<a name="aws-health"></a>

AWS Health provides visibility into the state of your AWS resources, services, and accounts\. It provides information about the performance and availability of resources that affect your applications running on AWS and guidance for remediation\. AWS Health provides this information in a console called the Personal Health Dashboard \(PHD\)\. 

AWS Health directly supports CloudWatch Events notifications\. You configure [CloudWatch Events rules](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html) for AWS Health, and specify an SNS topic mapped in AWS Chatbot\. 

For more information, see [Monitoring AWS Health Events with Amazon CloudWatch Events](https://docs.aws.amazon.com/health/latest/ug/cloudwatch-events-health.html) in the *AWS Health User Guide*\.

### [AWS Security Hub](https://console.aws.amazon.com/securityhub/)<a name="security-hub"></a>

AWS Security Hub provides a comprehensive view of high\-priority security alerts and compliance status across your AWS accounts\. Security Hub aggregates, organizes, and prioritizes security findings from multiple AWS services, including Amazon GuardDuty, Amazon Inspector, and Amazon Macie\. Security Hub reduces the effort of collecting and prioritizing security findings across accounts, from AWS services, and from AWS partner tools\. 

Security Hub supports two types of integration with [CloudWatch Events rules](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html), both of which AWS Chatbot supports:
+ **Standard CloudWatch Events**\. [Security Hub automatically sends all findings to CloudWatch Events](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-cloudwatch-events.html)\. You can define CloudWatch Events rules that automatically route generated findings to an Amazon Simple Storage Service \(Amazon S3\) bucket, a remediation workflow, or an SNS topic\. Use this method to automatically send all Security Hub findings, or all findings with specific characteristics, to an SNS topic to which AWS Chatbot subscribes\.
+ **Security Hub Custom Actions**\.[ Define custom actions in Security Hub](https://aws.amazon.com/blogs/apn/how-to-enable-custom-actions-in-aws-security-hub/) and configure [CloudWatch Events rules](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html) to respond to those actions\. The event rule uses its SNS topic setting to forward its notifications to the SNS topic to which AWS Chatbot subscribes\. 

### [AWS Systems Manager](https://console.aws.amazon.com/systems-manager/)<a name="system-manager"></a>

AWS Systems Manager lets you view and control your infrastructure on AWS\. Using the Systems Manager console, you can view operational data from multiple AWS services and automate operational tasks across your AWS resources\. Systems Manager helps you maintain security and compliance by scanning your managed instances, and reporting or taking corrective action on detected policy violations\.

AWS Chatbot supports the following Systems Manager events\.

**Configuration compliance**
+ Status change for association compliance\.
+ Status change for instance patch compliance\.

**Automation**
+ Status change for an automation execution\.
+ Status change for a single step in an automation execution\.

**Run command**
+ Status change for a command \(applies to one or more instances\)\.
+ Status change for a command invocation \(applies to one instance only\)\. 

**State manager**
+ Status change for an association\.
+ Status change for an instance association\.

**Parameter store**
+ A parameter is created\.
+ A parameter is updated\.
+ A parameter is deleted\.

For information about monitoring Systems Manager events with CloudWatch, see [Monitoring Systems Manager Events with Amazon CloudWatch Events](https://docs.aws.amazon.com/systems-manager/latest/userguide/monitoring-cloudwatch-events.html) in the *AWS Systems Manager User Guide*\. 