# Step 4: Choose When to Send the Campaign<a name="campaigns-schedule"></a>

After you write your message, you can specify when the campaign should be sent\. You can choose to send the campaign immediately, at a scheduled date and time, on a recurring basis, or when certain events occur\.

Before you can complete the procedures in this section, you have to complete [Step 3](campaigns-message.md)\.

**Topics**
+ [Sending the Campaign Immediately](#campaigns-schedule-immediate)
+ [Sending the Campaign at a Specific Date and Time](#campaigns-schedule-once)
+ [Sending the Campaign on a Recurring Basis](#campaigns-schedule-recurring)
+ [Sending the Campaign When Events Occur](#campaigns-event-triggered)

## Sending the Campaign Immediately<a name="campaigns-schedule-immediate"></a>

If you want to send the campaign as soon as you finish creating it, you can choose to send the campaign immediately\.

**To send the campaign immediately**

1. Under **When should the campaign be sent**, choose **At a specific time**\.

1. Under **How often should the campaign be sent**, choose **Immediately**\.

1. Choose **Next** to continue to the final step\.

## Sending the Campaign at a Specific Date and Time<a name="campaigns-schedule-once"></a>

If you want to send a campaign only once, you can schedule it to be sent at a specific date and time\.

**To send the campaign at a specific date and time**

1. Under **When should the campaign be sent**, choose **At a specific time**\.

1. Under **How often should the campaign be sent**, choose **Once**\. 

1. For **Start date and time**, choose the date and time when Amazon Pinpoint should send the message\.

1. Under **Time zone**, choose the time zone that you want to use to schedule the campaign\. Optionally, choose **Use recipient's local time** to base the delivery time on each recipient's local time zone\.

1. Choose **Next** to continue to the final step\.

## Sending the Campaign on a Recurring Basis<a name="campaigns-schedule-recurring"></a>

You can also schedule the campaign to be sent on a recurring basis\. You can specify the frequency, as well as the start and end dates for the campaign\.

**To send the campaign on a recurring basis**

1. Under **When should the campaign be sent**, choose **At a specific time**\.

1. Under **How often should the campaign be sent**, choose how often Amazon Pinpoint should send the recurring campaign\. For example, to send the campaign once per week, choose **Weekly**\.

1. For **Start date and time**, choose the date and time when Amazon Pinpoint should send the first message in the recurring series\.

1. For **End date and time**, choose the date and time when Amazon Pinpoint should stop sending recurring messages\.

1. Under **Time zone**, choose a time zone to base the start and end times on\. Optionally, choose **Use recipient's local time** to base the delivery time on each recipient's local time zone\.

1. Choose **Next** to continue to the final step\.

## Sending the Campaign When Events Occur<a name="campaigns-event-triggered"></a>

If you want to send the campaign when customers take certain actions, you can configure the campaign to be sent when a specific event occurs\. For example, you can configure the campaign to be sent when a customer registers a new account, or when a customer adds an item to their shopping cart but doesn't purchase it\. To learn more about sending events from your apps to Amazon Pinpoint, see [Reporting Events in Your Application](https://docs.aws.amazon.com/pinpoint/latest/developerguide/integrate-events.html) in the *Amazon Pinpoint Developer Guide*\.

**Note**  
You can send event\-based messages only if your campaign uses dynamic segments \(as opposed to imported segments\)\. In addition, if you integrate your app with Amazon Pinpoint by using an AWS Mobile SDK, messages from event\-based campaigns are sent only to customers whose apps are running AWS Mobile SDK for Android version 2\.7\.2 or later, or AWS Mobile SDK for iOS version 2\.6\.30 or later\.

**To configure a campaign to be sent when an event occurs**

1. Under **When should the campaign be sent**, choose **When an event occurs**\.

1. For **Events**, choose the name of the event that triggers the execution of the campaign\.

1. \(Optional\) For **Attributes** and **Metrics**, choose the specific characteristics that trigger the execution of the campaign\.
**Tip**  
The more event data you capture from your users, the more options you have when you set up event triggers\. Event attributes and metrics are available only if you've provided those values to Amazon Pinpoint\. To learn more about capturing event data, see [Reporting Events in Your Application](https://docs.aws.amazon.com/pinpoint/latest/developerguide/integrate-events.html) in the *Amazon Pinpoint Developer Guide*\.

1. Under **Campaign Dates**, for **Start date and time**, choose a start date\. Amazon Pinpoint sends the campaign only if the event that you specified earlier occurs after the start date\.
**Note**  
The **Start date and time** that you choose has to be at least 15 minutes in the future\.

1. For **End date and time**, choose an end date\. Amazon Pinpoint sends the campaign only if the event that you specified earlier occurs before the end date\.

1. Under **Time zone**, choose a time zone to base the start and end dates on\.

1. Choose **Next** to continue to the final step\.

### Best Practices for Using Event\-Based Campaigns<a name="campaigns-event-triggered-best-practices"></a>

There are a few restrictions and best practices that you should consider when you create event\-based campaigns:
+ You can create an event\-based campaign only if you chose a dynamic segment \(as opposed to an imported segment\) in [Step 2](campaigns-segment.md)\.
+ If you integrate your app with Amazon Pinpoint by using an AWS Mobile SDK, your app should use the following versions of the SDK in order to work properly with event\-based campaigns: 
  + AWS Mobile SDK for Android version 2\.7\.2 or later
  + AWS Mobile SDK for iOS version 2\.6\.30 or later

  Because of this restriction, we recommend that you set up your segments to only include customers who use a version of your app that runs a compatible version of the SDK\.
+ Choose your events carefully\. For example, if you send an event\-based campaign every time a `session.start` event occurs, you might quickly overwhelm your users with messages\. You can limit the number of messages that Amazon Pinpoint sends to a single endpoint in a 24\-hour period\. For more information, see [General Settings](settings-general.md)\.

**Next**  
[Step 5: Review and Launch the Campaign](campaigns-review.md)