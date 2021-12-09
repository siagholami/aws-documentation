# Creating Event Notifications<a name="cloudwatch-events-notification"></a>

You can use Amazon CloudWatch Events and Amazon Simple Notification Service \(Amazon SNS\) to notify you of new events\. In CloudWatch Events, the rule describes which events you're notified about\. In Amazon SNS, the topic describes what kind of notification you receive\. This section provides high\-level steps for creating a topic and rule for events from AWS Elemental MediaPackage\. For detailed information about topics and rules, see the following:
+ [Create a Topic](https://docs.aws.amazon.com/sns/latest/dg/sns-getting-started.html#CreateTopic) and [Subscribe to a Topic](https://docs.aws.amazon.com/sns/latest/dg/sns-getting-started.html#SubscribeTopic) in the *Amazon Simple Notification Service Developer Guide*
+ [Getting Started with Amazon CloudWatch Events](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/CWE_GettingStarted.html) in the *Amazon CloudWatch Events User Guide*

**To create notifications of CloudWatch events**

1. Access [Amazon SNS](https://console.aws.amazon.com/sns/v2/home) and create a topic\. Give the topic a descriptive name that you will later recognize\.

1. Subscribe to the topic that you just created\. Choose what kind of notification you want to receive, and where that notification is sent\. For example, for email notifications, choose the **Email** protocol and enter the email address to receive notifications for the endpoint\.

1. Access [CloudWatch Events](https://console.aws.amazon.com/cloudwatch) and create a rule that uses a **Custom event pattern**\. In the pattern preview space, enter the following: 

   ```
   {
     "source": [
       "aws.mediapackage"
     ],
     "detail-type": [
       "detail-type from event"
     ]
   }
   ```

   For `detail-type`, enter the value for the `detail-type` field from the event\. You can use the following values for detail\-type:
   + **MediaPackage Input Notification**
   + **MediaPackage Key Provider Notification**

   For information about the event types, see [AWS Elemental MediaPackage Events](cloudwatch-events-example.md)\.  
**Example**  

   The following example rule creates notifications for all events on all detail\-types\.

   ```
   {
     "source": [
       "aws.mediapackage"
     ],
     "detail-type": [
       "MediaPackage Input Notification",
       "MediaPackage Key Provider Notification",
       "MediaPackage HarvestJob Notification"
     ]
   }
   ```

1. Add a target to the rule that you just created\. Choose **SNS topic**, and then choose the topic that you created in step 1\. 

1. Configure the details of the rule, and give it a descriptive name\. To start using the rule, make sure it's enabled, and then save it\.