# Monitor for AWS Health events with Amazon CloudWatch Events<a name="cloudwatch-events-health"></a>

You can use Amazon CloudWatch Events to detect and react to changes for AWS Health events\. Then, based on the rules that you create, CloudWatch Events invokes one or more target actions when an event matches the values that you specify in a rule\. Depending on the type of event, you can send notifications, capture event information, take corrective action, initiate events, or take other actions\. 

You can choose the following types of targets when using CloudWatch Events as a part of your AWS Health workflow:
+ AWS Lambda functions
+ Amazon Kinesis Data Streams
+ Amazon Simple Queue Service \(Amazon SQS\) queues
+ Built\-in targets \(CloudWatch alarm actions\)
+ Amazon Simple Notification Service \(Amazon SNS\) topics

For example, you can use a Lambda function to pass a notification to a Slack channel when an AWS Health event occurs\. Or, you can use Lambda and CloudWatch Events to send custom text or SMS notifications with Amazon SNS when an AWS Health event occurs\.

For samples of automation and customized alerts that you can create in response to AWS Health events, see the [AWS Health Tools](https://github.com/aws/aws-health-tools) in GitHub\.

Only AWS Health events that are specific to your AWS account and resources are published to CloudWatch Events\. This includes events such as Amazon Elastic Block Store \(Amazon EBS\) volume lost, Amazon Elastic Compute Cloud \(Amazon EC2\) instance store drive performance degraded, and all the scheduled change events\. 

In contrast, [Service Health Dashboard](https://status.aws.amazon.com) events provide public information about the regional availability of a service\. These events aren't specific to AWS accounts, so they aren't published to CloudWatch Events\.

Use the following options to identify if an event is public or account\-specific:
+ In the Personal Health Dashboard, choose the **Affected resources** tab on the **Event log** page\. Events with resources are specific to your account\. Events without resources are public and are not specific to your account\. 
+ Use the AWS Health API to return the `eventScopeCode` parameter\. Events can have the `PUBLIC`, `ACCOUNT_SPECIFIC`, or `NONE` value\. For more information, see the [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) operation in the *AWS Health API Reference*\. 

**Important**  
Events that appear in the Personal Health Dashboard are Region\-specific\. For example, if AWS Health sends an event that affects a resource \(such as an Amazon EC2 instance\) in the US East \(Ohio\) Region, you must configure CloudWatch Events in the same Region to get notified of that event\.

**Topics**
+ [Creating a CloudWatch Events rule for AWS Health](#creating-cloudwatch-events-rule-for-aws-health)
+ [Automating actions for EC2 instances](#automating-instance-actions)

## Creating a CloudWatch Events rule for AWS Health<a name="creating-cloudwatch-events-rule-for-aws-health"></a>

You can create a CloudWatch Events rule to get notified for AWS Health events in your account\. Before you create event rules for AWS Health, you should do the following:
+ Familiarize yourself with events, rules, and targets in CloudWatch Events\. For more information, see [What Is Amazon CloudWatch Events?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/WhatIsCloudWatchEvents.html) in the *Amazon CloudWatch Events User Guide* and [New CloudWatch Events – Track and Respond to Changes to Your AWS Resources](https://aws.amazon.com/blogs/aws/new-cloudwatch-events-track-and-respond-to-changes-to-your-aws-resources/)\.
+ Create the target or targets to use in your event rules\.

**To create a CloudWatch Events rule for AWS Health**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. To change the AWS Region, use the **Region selector** in the upper\-right corner of the page\. Choose a Region in which you want to track AWS Health events\.

1. In the navigation pane, under **Events**, choose **Rules**\.

1. Choose **Create rule**, and then under **Event Source**, for **Service Name**, choose **Health**\.

1. For **Event Type**, choose one of the following options\.
   + Choose **All Events** to create a rule that applies to all AWS services\. This rule monitors all events from AWS Health\. If you choose this option, you can't specify event type categories or event type codes\.
   + Choose **Specific Health events**, **Specific service\(s\)**, and then choose a service name from the list\. This creates a rule that monitors events for only one service\. For example, you can choose **EC2** so that CloudWatch Events monitors only Amazon EC2 events\. You can't choose more than one service\.
**Tip**  
To monitor all AWS Health events for a specific service, we recommend that you choose **Any event type category** and **Any resource**\. This ensures that your rule monitors for any AWS Health events, including any new event type codes, for your specified service\. For an example rule, see [all Amazon EC2 events](#all-ec2-events-rule)\.

1. If you chose a specific service, choose one of the following options\.
   + Choose **Any event type category** to create a rule that applies to all event type categories\.
   + Choose **Specific event type category\(s\)** and then choose a value from the list\. This creates a rule that applies only to one event type category, such as **scheduledChange**\. You can't choose more than one category\.

1. If you chose a specific service and event type category, choose one of the following options for event type codes\.
   + Choose **Any event type code** to create a rule that applies to all event type codes\.
   + Choose **Specific event type code\(s\)** and then choose one or more values from the list\. This creates a rule that applies only to specific event type codes\. For example, if you choose **AWS\_EC2\_INSTANCE\_STOP\_SCHEDULED** and **AWS\_EC2\_PERSISTENT\_INSTANCE\_RETIREMENT\_SCHEDULED**, your rule applies only to these events when they occur in your account\.

1. Choose one of the following options for affected resources\.
   + Choose **Any resource** to create a rule that applies to all resources\.
   + Choose **Specific resource\(s\)** and enter the IDs of one or more resources\. For example, you might specify an Amazon EC2 instance ID such as `i-EXAMPLEa1b2c3de4` to monitor for events that affect only this resource\.

1. Review your rule setup so that it meets your event\-monitoring requirements\.

1. In the **Targets** area, choose **Add target\***\.

1. In the **Select target type** list, choose the type of target that you prepared to use with this rule, and then configure any additional options required by that type\.

1. Choose **Configure details**\.

1. On the **Configure rule details** page, enter a name and description for the rule, and then select the **State** check box to enable the rule as soon as it's created\.

1. Choose **Create rule**\.<a name="all-ec2-events-rule"></a>

**Example : Rule for all Amazon EC2 events**  
The following example creates a rule so that CloudWatch Events monitors for all Amazon EC2 events, including the event type categories, event codes, and resources\.  

![\[Screenshot of how to a CloudWatch Events rule for all Amazon EC2 events only.\]](http://docs.aws.amazon.com/health/latest/ug/images/cloudwatch-events-rule-all-ec2-health-events.png)

**Example : Rule for specific Amazon EC2 events**  
The following example creates a rule so that CloudWatch Events monitors the following:  
+ The Amazon EC2 service
+ The **scheduledChange** event type category
+ The event type codes for **AWS\_EC2\_INSTANCE\_TERMINATION\_SCHEDULED** and **AWS\_EC2\_INSTANCE\_RETIREMENT\_SCHEDULED**
+ The instance with the `i-EXAMPLEa1b2c3de4` ID

![\[Screenshot of how to a CloudWatch Events rule for specific Amazon EC2 events only.\]](http://docs.aws.amazon.com/health/latest/ug/images/cloudwatch-events-rule-all-ec2-specific-events-resource.png)

## Automating actions for EC2 instances<a name="automating-instance-actions"></a>

You can automate actions in response to new scheduled events for your EC2 instances\. For example, you can create CloudWatch Events rules for EC2 scheduled events generated by the AWS Health service\. These rules can then trigger targets, such as AWS Systems Manager Automation documents, to automate actions\. You can find more options at [Automating Amazon EC2 with CloudWatch Events](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/automating_with_cloudwatch_events.html)\.

 For example, when an Amazon EC2 instance retirement event is scheduled for an Amazon Elastic Block Store \(Amazon EBS\)\-backed EC2 instance, you can automate the stop and start of the instance so that you don't have to perform these actions manually\.

**To automate the stop and start of EBS\-backed EC2 instances that are scheduled for retirement**

1. Open the CloudWatch console to create a CloudWatch Events rule:

   1. Navigate to [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

   1. Under **Events**, choose **Rules**\.

1. Edit the Event Pattern Preview, and then provide the following inputs\.  
**Example**  

   ```
   {
     "source": [
       "aws.health"
     ],
     "detail-type": [
       "AWS Health Event"
     ],
     "detail": {
       "service": [
         "EC2"
       ],
       "eventTypeCategory": [
         "scheduledChange"
       ],
       "eventTypeCode": [
         "AWS_EC2_INSTANCE_RETIREMENT_SCHEDULED"
       ]
     }
   }
   ```

   You should see the following fields appear in the console\.
   + For **Service Name**, AWS Health
   + For **Event Type**, **Specific Health events**
   + The Amazon EC2 service
   + The **scheduledChange** event type category
   + The **AWS\_EC2\_INSTANCE\_RETIREMENT\_SCHEDULED** event type code
   + Any resource  
![\[Create an "Event Pattern" for AWS Health screenshot.\]](http://docs.aws.amazon.com/health/latest/ug/images/automating-actions-1.jpg)

1. Select **Save**\.

1. Add the Systems Manager Automation document target\. Select **Add target\***, and then select **SSM Automation**, as shown in the following figure\.  
**Example**    
![\[Screenshot of the "SSM Automation" example in the CloudWatch Events console.\]](http://docs.aws.amazon.com/health/latest/ug/images/automating-actions-2.jpg)

1. Choose the **AWS\-RestartEC2Instance** Systems Manager document from the list\.

1. Configure the Input Transformer as shown here, with `{"Instances":"$.resources"}` as the InputPathsMap and `{"InstanceId": <Instances>}` as the **Input Template**\.

1. Choose an existing AWS Identity and Access Management \(IAM\) role, and then create a new one with permissions to run the SSM automation document\.

If you don't have an existing IAM role with the required EC2 and Systems Manager permissions, then create the role\.

**To create an IAM role with EC2 and Systems Manager permissions**

1. Set up the required IAM permissions for CloudWatch Events by creating an IAM policy\. Then, associate the policy with an IAM role for CloudWatch\. For this example, name the IAM role `AutomationCWRole`\. Here is an example of such an IAM policy\.  
**Example**  

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": [
           "ec2:StartInstances",
           "ec2:StopInstances",
           "ec2:DescribeInstanceStatus"
         ],
         "Resource": [
           "*"
         ]
       },
       {
         "Effect": "Allow",
         "Action": [
           "ssm:*"
         ],
         "Resource": [
           "*"
         ]
       },
       {
         "Effect": "Allow",
         "Action": [
           "sns:Publish"
         ],
         "Resource": [
           "arn:aws:sns:*:*:Automation*"
         ]
       },
       {
         "Effect": "Allow",
         "Action": [
           "iam:PassRole"
         ],
         "Resource": "arn:aws:iam::<AccountId>:role/AutomationCWRole"
       }
     ]
   }
   ```

1. Be sure to update the role Amazon Resource Name \(ARN\) with the account ID and role name\. Also, be sure that the role has `events.amazonaws.com` and `ssm.amazonaws.com` configured as trusted entities for the IAM role as shown here\.  
**Example**  

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": [
             "ssm.amazonaws.com",
             "events.amazonaws.com"
           ]
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```