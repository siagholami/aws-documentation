# Tips and Best Practices for Journeys<a name="journeys-best-practices"></a>

Although journeys are designed to be flexible and fully customizable, there are some fundamental strategies and practices that can help you plan, design, and manage any journey\. Consider the following tips and best practices for designing and managing a successful journey\.

**Topics**
+ [Scope and Settings](#journeys-best-practices-settings)
+ [Segments](#journeys-best-practices-segments)
+ [Activities](#journeys-best-practices-activities)
+ [Email Messages](#journeys-best-practices-email)
+ [Reviewing and Testing](#journeys-best-practices-review-test)
+ [Analytics](#journeys-best-practices-analytics)
+ [Lifecycle Management](#journeys-best-practices-lifecycle)

## Scope and Settings<a name="journeys-best-practices-settings"></a>

Because a journey can perform a variety of different and interrelated tasks, it’s a good idea to create a well\-defined scenario for a journey\. Also, you should choose journey settings that support your scenario and goals\. By using journey settings, you can establish constraints that determine the timing, volume, and frequency with which a journey can engage participants\. 

When you define a scenario, consider limiting its scope to a small aspect of a larger customer experience\. Although Amazon Pinpoint supports large\-scale journeys that have extensive workflows, you have more opportunities to monitor, refine, and manage a customer’s experience if you design a journey to be part of a sequence of related journeys\. 

For example, you can design a journey that focuses on welcoming new customers and providing them with recommended first steps during their first seven days as a customer\. Based on each customer’s actions during the first journey, you can then add them to a subsequent journey that’s tailored to their initial level of engagement\. One subsequent journey might provide next steps for customers who were highly engaged in the first journey\. Another subsequent journey might promote different products or services to customers who were less engaged in the first journey\. By creating a sequence of smaller\-scope journeys, you can continually refine and manage the customer experience throughout the customer lifecycle\.

After you define a scenario, choose journey settings that support your goals for the scenario\. These settings define the timing, volume, and frequency with which any part of a journey can engage participants\. To choose these settings, create or open the journey\. Then choose **Settings** from the **Actions** menu, and expand the **Advanced settings** section\.

Some key goals and related settings are:

**Store and use participants' local time zones**  
To optimize participant engagement in a journey that has a scheduled start and end time, configure the journey to use each participant's local time zone\. This helps to ensure that journey activities occur when a participant is most likely to participate in those activities\.   
Note, however, that the usefulness of this setting depends on whether you store local time zone values in the endpoint definitions for participants\. If you use this setting and the endpoint definition for a participant doesn't specify a time zone, Amazon Pinpoint doesn't include the participant in the journey\. To avoid this issue, use the `Timezone` attribute to store time zone information for participants\. This is a standard attribute that Amazon Pinpoint provides\.

**Address quiet\-time conflicts**  
If you configure an activity to send messages at a time that conflicts with the quiet\-time settings for the journey or project, Amazon Pinpoint doesn't send the messages\. In addition, it doesn't try to send the messages after quiet time ends\. To avoid this conflict, define custom quiet\-time settings for the journey\. In addition, schedule email activities to occur during hours that don’t conflict with quiet time\. 

**Limit the number of messages that participants can receive**  
To help ensure that participants don’t receive too many messages from the journey or project, limit the number of messages that can be sent to a participant during a 24\-hour period\. This can be especially helpful if a journey uses a segment that’s also used by campaigns or other journeys\. You might also create and use a segment that’s designed explicitly for use by only a specific journey\.

**Optimize the number of messages that can be sent**  
If a journey has a large number of participants and it sends a large number of messages, factor the amount of time that Amazon Pinpoint needs to process and send all of those messages\.  
For example, consider a situation where you have a journey activity that sends messages to 1,000,000 participants, and the maximum sending rate for your Amazon Pinpoint account is 200 messages per second\. Some participants won’t receive the message until approximately 80 minutes after the activity starts\. This is especially relevant if a journey includes wait activities that follow email activities\. If Amazon Pinpoint hasn’t finished sending all the messages by the time the wait activity ends, participants might be moved to the activity that follows the wait activity, before they’ve received the message\.  
To mitigate this risk, consider increasing the maximum number of messages that a journey can send per second, and possibly increase it to the maximum sending rate for your account\. Also consider [increasing the sending quotas for your account](channels-email-manage-limits.md)\.

**Limit the number of times that participants can enter a journey**  
Depending on the nature and design of a journey, limit the number of times that a single participant can enter the same journey\. If you don’t set this limit, a participant could enter a journey, complete several activities in the journey, arrive at an end activity, and then start the journey again\. You might prefer to have each participant start and complete a journey only once\.   
Note that Amazon Pinpoint doesn't allow a participant to enter a journey if they're already an active participant in the journey\. For example, Amazon Pinpoint doesn't add a participant as a new participant if the participant starts a journey and you subsequently update the participant's endpoint definition in a way that affects their inclusion in a segment \(based on segment criteria\) or the journey \(based on activity conditions\)\.

**Maximize opportunities for participants to start a journey**  
The journey entry activity, which is the first activity in a journey, determines how often new participants are added to the journey\. Because new or existing customers could become participants at any time, it’s a good idea to configure the entry activity to add new members to the segment frequently\. You can also configure the segment to add new participants automatically based on specific user attributes or events\. For an example of how to configure a segment in these ways, see the [Building Your First Journey in Amazon Pinpoint](https://aws.amazon.com/blogs/messaging-and-targeting/building-your-first-journey-in-amazon-pinpoint/) blog post\.

## Segments<a name="journeys-best-practices-segments"></a>

Segments are key\. They determine who can participate in an overall journey and specific journey activities\. When you create segments for a journey, consider the following best practices:

**Create a dedicated test segment**  
If you have a regular group of people who test your journeys and messages, create a segment that contains only their endpoints\. You can then use that segment as a consistent testing framework, especially if you use the journey testing feature that Amazon Pinpoint provides\. For tips about how to build this segment, see [Review and Test a Journey](journeys-review-test.md)\.

**Use multiple segments**  
Although you can choose only one segment for the journey entry activity, that segment can include multiple smaller segments\. Later in the journey, you can then use a multivariate split activity to divide participants into separate groups based on their segment membership\. This approach can help you provide a more tailored experience for each participant\. It can also help reduce processing times for email activities, because those activities will send messages to a smaller, more targeted audience\.   
It’s also a good idea to segment participants based on actions that they explicitly do or don’t do\. You can do this by using split activities\. For example, you can use a yes/no split activity to send participants down a *Yes* path if they click a link in a message, and a *No* path if they don’t\. The absence of an action can be an opportunity to reengage a participant through a follow\-up activity\.

**Don’t delete segments and endpoints**  
We encourage you to maintain segments that are part of an active journey\. If you delete a segment that’s being used by an active journey, the journey could fail and stop running\. If the journey does continue to run, any participants who were part of the segment might be removed from the journey prematurely\. In addition, those participants will be reported as “dropped” in the analytics data for the last activity that they were part of\. This compromises the usefulness of your analytics data—you won’t be able to distinguish between participants who left a journey independently and participants whom you removed\.

**Leverage custom attributes**  
To identify and add journey participants to segments more easily, consider adding a custom, journey\-specific attribute to endpoints when your application creates or updates endpoints\. You can then use this attribute to identify a user or endpoint as someone who should participate in a journey\.

## Activities<a name="journeys-best-practices-activities"></a>

Activities are the building blocks of any journey\. Therefore, when you choose the type and settings for each activity, and the relationships between activities, consider the following guidelines:

**Optimize the entry activity**  
The entry activity, which is the first activity in a journey, determines how often new participants are added to the journey\. Because new or existing customers could become participants at any time, it’s a good idea to configure the entry activity to update \(add participants to\) the associated segment frequently\. By doing this, you maximize opportunities for participants to start a journey\.

**Prepare for changes to segment and participant data**  
An activity’s evaluation of segment conditions is based on the latest data for each participant \(endpoint\) in the segment, and this data might change over time\. For example, a participant’s favorite food could be pizza when they start an activity\. That participant could subsequently change their preference to hot dogs\. If this happens, subsequent activities will evaluate the participant based on the participant’s preference for hot dogs, not pizza\. One way to prepare for these kinds of changes is to use split activities that predict the changes and send participants down an appropriate path\.

**Take advantage of the *Else* path**  
A multivariate split activity can contain as many as four paths \(each with its own criteria\), in addition to an *Else* path\. The *Else* path is for participants who don’t meet any of the criteria for the other paths\. Therefore, it provides an excellent opportunity to handle unexpected or unusual cases that you might not have considered when you designed the journey\.

**Consider delays in receiving event data**  
Some event data, such as *email opens*, is based on information that we receive from participants’ email providers\. Some providers send us this information immediately, while others send it less frequently\. Those delays can impact participants’ experiences\. When Amazon Pinpoint evaluates events as a condition of an activity, it moves a participant to a *No* path if it doesn’t have any event data for a participant\. To mitigate this risk, add buffer time to the evaluation schedule for activities that immediately follow email activities\.

**Avoid consecutive email activities**  
We recommend that you insert a wait or other type of activity between two or more email activities\. This can help account for the amount of time that Amazon Pinpoint needs to process and send messages, and any delays in participants receiving messages\.

## Email Messages<a name="journeys-best-practices-email"></a>

In addition to [general tips and best practices for sending email](channels-email-best-practices.md), consider doing the following before you create a journey:

**Create a dedicated “From” address**  
Consider using a dedicated email address or domain for all the messages that you send from a journey\. This provides a consistent experience across all the messages that participants receive from a journey\. It also gives each participant an opportunity to adjust their email application settings to ensure that all of a journey’s messages arrive in their inbox\. In addition, if you subscribe to the [Deliverability Dashboard](channels-email-deliverability-dashboard.md), using a dedicated address or domain can make it easier for you to access advanced analytics data for specific journeys\. To learn how to set up a dedicated address or domain for sending messages, see [Verifying Email Identities](channels-email-manage-verify.md)\.

**Verify that you set up the email channel correctly**  
Before you publish a journey, make sure that your Amazon Pinpoint account has [production access for email](channels-email-setup-production-access.md)\. If it doesn’t, your account is in the sandbox environment, which means that participants might not receive messages from the journey\. \(In the sandbox environment, you can send only a limited number of messages and you can send messages to only certain email addresses\.\) Also, make sure the sending quota and sending rate for your account can support the number of messages that you plan to send from the journey\. To check the sending quota and rate for your account, you can use the **Email Settings** page on the Amazon Pinpoint console\.

**Design a collection of related message templates**  
During the early stages of the planning process, it’s a good idea to design and create a message template for each email activity that you expect to include in the journey\. If you do this, you can ensure that all the messages have a consistent design\. This also ensures that each message is specific to and optimized for the corresponding phase of the journey\. For example, in a journey that welcomes new customers, you might have three email templates\. There is one template with introductory information, another with intermediate information for users who clicked a link in the first message, and another with revised introductory information for users who didn’t click a link in the first message\.

## Reviewing and Testing<a name="journeys-best-practices-review-test"></a>

Amazon Pinpoint includes a review feature that checks for and warns you about configuration errors in a journey\. It also simplifies the process of finding and fixing any errors\. To find the activity or setting that has an error, click the error description\. 

To fix an error, follow the recommendation provided in the **Review your journey** pane\. We encourage you to use this feature to review and fix errors before you publish a journey\. As a best practice, we also encourage you to complete this review process multiple times before you publish a journey\.

Amazon Pinpoint also includes a testing feature that streamlines the testing process\. After you complete the review process for a journey, you can use this feature to send a group of test participants through the journey\. 

To ensure that only test participants can enter the journey, you can create and use a dedicated test segment with this feature\. To expedite testing, you can configure this feature to reduce or eliminate wait times for and between activities\. We strongly recommend that you use this feature to test all aspects of a journey, including each message that a journey sends, before you publish a journey\.

To learn more about reviewing and testing a journey, see [Review and Test a Journey](journeys-review-test.md)\.

## Analytics<a name="journeys-best-practices-analytics"></a>

After you publish a journey, Amazon Pinpoint automatically starts collecting and aggregating analytics data for several types of standard metrics that apply to the overall journey and individual journey activities\. We strongly recommend that you review these metrics regularly and frequently\. 

Among other things, these metrics provide key insight into issues to address, such as failures and errors that might have occurred when Amazon Pinpoint attempted to evaluate or perform an activity\. Overall, these metrics can help you determine what is or isn’t working well in a journey, which can help you design more effective journeys in the future\. For detailed information about the available metrics and how to view them, see [View Journey Metrics](journeys-metrics.md)\.

Amazon Pinpoint automatically stores your analytics data for 90 days\. Depending on a journey’s projected duration or your organization’s long\-term storage and reporting needs, you might want to store the underlying event data for more than 90 days\. To do this, we recommend that you configure Amazon Pinpoint to export data to Amazon Kinesis Data Streams or Amazon Kinesis Data Firehose\. If you export data to Amazon Kinesis, you can also use other services and applications to perform deeper analysis or reporting\. For more information, see [Streaming Events with Amazon Pinpoint](analytics-streaming.md)\.

## Lifecycle Management<a name="journeys-best-practices-lifecycle"></a>

As you move a journey through various phases of development and execution, keep the following in mind for each phase of the journey’s lifecycle\. Also note that you can stop \(cancel\) a journey at any time if any issues arise\.


| Phase | Description | 
| --- | --- | 
| Draft |  The journey is being developed and hasn’t been published yet\.  In this phase, you can change any aspect of the journey, including segments, activities, and settings for the journey\. You can also leverage Amazon Pinpoint features for reviewing and testing the journey\. You can repeat the review and test processes as many times as you want\.  | 
| Active |  The journey has been developed, reviewed, tested, and published\. Depending on the journey's schedule, it might currently be running or scheduled to start running at a later time\. In this phase, you can't add, change, or remove activities from the journey\.  | 
| Closed |  The journey has been developed, reviewed, tested, and published\. It has started running and is closed to new participants\.  Depending on the journey’s schedule and settings, it might have also passed its scheduled end time\. Or the journey might have passed its scheduled start time, and it has an entry activity that’s set to never add new segment members\. In this phase, you can't add new participants to the journey, and no existing participants can enter the journey for the first time\. However, any existing participants who are currently waiting to start an activity can resume the journey\.  | 
| Stopped |  The journey was developed, reviewed, tested, and published, and then subsequently stopped\. You can't restart a journey after you stop it\. If you stop a journey, Amazon Pinpoint continues to perform activities that are currently in progress until those activities are complete\. Amazon Pinpoint also continues to collect and aggregate analytics data for those activities until the activities are complete\. It also does this for any activities that were complete when you stopped the journey\.  In this phase, you can't add, change, or remove any activities from the journey\. In addition, Amazon Pinpoint stops evaluating the journey and doesn't perform any activities that haven't started\.  | 