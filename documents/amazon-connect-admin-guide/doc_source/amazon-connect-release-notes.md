# Release notes<a name="amazon-connect-release-notes"></a>

To help you keep track of the ongoing updates and improvements to Amazon Connect, we publish release notices that describe recent changes\.

**Topics**
+ [Upcoming changes](#amazon-connect-upcoming-changes)
+ [September 2020 Updates](#september20-release-notes)
+ [August 2020 Updates](#august20-release-notes)
+ [July 2020 Updates](#july20-release-notes)
+ [June 2020 Updates](#june20-release-notes)
+ [May 2020 Update](#may20-release-notes)
+ [April 2020 Update](#april20-release-notes)
+ [March 2020 Update](#mar20-release-notes)
+ [February 2020 Update](#feb20-release-notes)
+ [January 2020 Update](#jan20-release-notes)
+ [December 2019 Update](#dec19-release-notes)
+ [November 2019 Update](#nov19-release-notes)
+ [October 2019 Update](#oct19-release-notes)
+ [June 2019 Update](#w117aac63c33)
+ [May 2019 Updates](#w117aac63c35)
+ [April 2019 Updates](#w117aac63c37)
+ [March 2019 Update](#w117aac63c39)
+ [February 2019 Updates](#feb19-release-notes)
+ [January 2019 Updates](#jan19-release-notes)
+ [December 2018 Updates](#dec18-release-notes)
+ [November 2018 Updates](#nov18-release-notes)
+ [October 2018 Updates](#oct18-release-notes)
+ [September 2018 Updates](#sep18-release-notes)
+ [August 2018 Updates](#aug18-release-notes)
+ [July 2018 Updates](#july18-release-notes)
+ [June 2018 Updates](#jun18-release-notes)
+ [April and May 2018 Updates](#may18-release-notes)

## Upcoming changes<a name="amazon-connect-upcoming-changes"></a>

We continuously make improvements to Amazon Connect based on your feedback, and also as we find ways to improve your experience\. Take a look at this section to learn about planned changes to help improve how your agents work\. 

### New "Next status" for agents<a name="upcoming-changes-next-status"></a>


|  | 
| --- |
| This feature is available only to customers who are using the latest Contact Control Panel \(CCP\)\. The URL for the latest CCP looks like this: https://*name of your instance\.awsapps\.com*/connect/ccp\-v2/  | 

In busy contact centers, it can be difficult for agents to take a break or go offline when contacts are being quickly routed to them\. To help agents manage their time, we will release a feature that lets agents pause new contacts being routed to them while they finish their current contacts\. When all their slots are cleared, Amazon Connect automatically sets agents to the next status, such as **Lunch**\.

The following images of the Contact Control Panel \(CCP\) show how agents use this feature\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/connect/latest/adminguide/images/next-status-example-new.png)

1. The agent is on a contact\.

1. The agent chooses their next status, such as **Lunch**\. They can choose only a custom \([NPT](real-time-metrics-definitions.md#non-productive-time-real-time)\) status, or **Offline**\. 

1. The agent is in **Next status: Lunch**\. They are still on contact\. No new contacts can be routed to them\. 

1. The contact ends\. The agent finishes ACW, and chooses **Clear contact**\. Instead of going back to **Available**, their CCP is automatically set to **Lunch**\. 

#### How to cancel "Next status"<a name="next-status-example"></a>

Agents can easily switch from **Next status** back to **Available**\. The ability to switch their status is useful, for example, if they accidentally choose **Next status: Lunch**, or if they decide not to go to **Lunch** before Amazon Connect automatically sets to that status\. 

The following images show this workflow\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/connect/latest/adminguide/images/next-status-example-cancel.png)

1. While working on the same contact, the agent cancels **Next status: Lunch** and goes back to **Available**\.

1. The contact ends and the agent is still **Available** for new contacts to be routed to them\. 

#### Example 1: Set "Next status" while handling only ACW contacts<a name="next-status-examples-acw"></a>

Let's say an agent is finishing after contact work \(ACW\) for one or more contacts, such as a voice contact or multiple chats\. They are not on contact with anyone\.

Instead of choosing **Clear contact** when the agent finishes ACW, they choose **Lunch**\. This puts them in **Next status: Lunch** only briefly\. 

Here's what happens in this scenario:

1. Agent finishes ACW and chooses **Lunch** instead of **Clear contact**\.

1. Amazon Connect stops routing new contacts to them\.

1. All their slots are cleared\. This is so the agent doesn't have to choose **Clear contact** to end the ACW\. 

1. Because all the ACWs have been cleared, Amazon Connect immediately starts the automatic transition that sets the agent's status to **Lunch**\.

   Agents were put into **Next status \- Lunch** only briefly \(milliseconds\!\)\. They might even see it in the CCP if they look fast enough\. 

This order of events mirrors how the CCP currently works when agents change their status while working on ACW\. For example, an agent is finishing ACW and they set their status to **Lunch**\. Here's what happens next:

1. Amazon Connect stops routing new contacts to them\.

1. The ACW slot is cleared for the agent so they don't have to choose **Clear contact**\. 

1. The agent is set to **Lunch**\.

#### Example 2: Set "Next status" while managing some chats on contact and other chats in ACW<a name="next-status-examples-oncontact"></a>

Let's say an agent is managing two chats: 
+ Customer 1 is in ACW\.
+ Customer 2 is on contact\.

While still on a contact, the agent sets their status to **Offline**\. This puts them in the **Next status: Offline** state\. 

Here's what happens in this scenario:

1. The agent sets their status to **Offline**\.

1. Amazon Connect stops routing new contacts to them\.

1. The contact that is in ACW is cleared so the agent doesn't have to choose **Clear contact**\. Only the connected chat remains\.

1. The agent's status is **Next status: Offline**, and they continue working on their connected chat\.

1. After they finish work on that contact, the agent chooses **Clear contact** to end the ACW\. 

1. Amazon Connect automatically sets the agents status to **Offline**\.

### Metrics: No changes due to "Next status"<a name="next-status-metrics"></a>

When an agent is in **Next status**, their metrics are the same as when their status is **Available**\.

For example, an agent is handling one contact and chooses **Next status**\. Here's what you'll see in the real\-time metrics report:
+ Agent Activity state = On Contact
+ Agent \- Staffed = 1

**Non\-productive time** \(NPT\) is not incremented when an agent is in **Next status** because the agent is still **Available**\. NPT increments only when the agent actually enters the non\-productive status, such as **Lunch**\.

### Agent event stream has new NextAgentStatus field<a name="agent-event-stream-next-status"></a>

When an agent sets their status to **Next status**, Amazon Connect populates a new `NextAgentStatus ` field with the next status selected by the agent\. 

At the same time, the `AgentStatus` field continues to display `Available`\. 

The following code snippet shows what the agent event stream looks like when an agent has set their CCP to **Next status: Lunch**\. 

```
               
"CurrentAgentSnapshot": 
{
    "AgentStatus": {
            "ARN": "example-ARN",
            "Name": "Available",
            "StartTimestamp": "2019-08-13T20:52:30.704Z"
        },
     "NextAgentStatus": {
            "Name": "Lunch",
            "ARN": "example-ARN2",
            "EnqueueTimestamp": "2019-08-13T20:58:00.004Z",
        }
}
```

When an agent has not selected a **Next status**, the field is `null`, as shown in the following snippet:

```
               
"CurrentAgentSnapshot": {
    "AgentStatus": {
            "ARN": "example-ARN",
            "Name": "Available",
            "StartTimestamp": "2019-08-13T20:52:30.704Z"
        },
     "NextAgentStatus": null
}
```

### Amazon Connect Streams API and "Next status"<a name="streams-next-status"></a>

When we release this feature, it will have the following effect:
+ If you integrate with Amazon Connect Streams API and your agents interact directly with the native CCP user interface, then at release your agents will start using this new feature immediately\.
+ If you integrate with Amazon Connect Streams API but your agents don't interact directly with the native CCP user interface, then at release your contact center will continue to have the previous behavior when agent\.setState\(\) is called: an agent will not be able to select an NPT or Offline status while connected to at least one contact\. 

  To use **Next status** with a custom CCP integration that does not directly embed the CCP, you will need to make additional changes that will be detailed further in the [Amazon Connect Streams README](https://github.com/amazon-connect/amazon-connect-streams/blob/master/README.md)\. 

## September 2020 Updates<a name="september20-release-notes"></a>

The following updates were released in September 2020:

### Contact flows<a name="september20-contact-flows"></a>
+ Added the Amazon Connect Flow language, a JSON\-based representation of a series of flow actions, and the criteria for moving between them\. For more information, see [Amazon Connect Flow language](flow-language.md)\. 

### APIs<a name="september20-apis"></a>

Added the following APIs for contact flows:
+ [CreateContactFlow](https://docs.aws.amazon.com/connect/latest/APIReference/API_CreateContactFlow.html)
+ [DescribeContactFlow](https://docs.aws.amazon.com/connect/latest/APIReference/API_DescribeContactFlow.html) 
+ [UpdateContactFlowContent](https://docs.aws.amazon.com/connect/latest/APIReference/API_UpdateContactFlowContent.html) 
+ [UpdateContactFlowName](https://docs.aws.amazon.com/connect/latest/APIReference/API_UpdateContactFlowName.html) 

Added the following API to list prompts:
+ [ListPrompts](https://docs.aws.amazon.com/connect/latest/APIReference/API_ListPrompts.html)

Added the following APIs for routing profiles:
+ [AssociateRoutingProfileQueues](https://docs.aws.amazon.com/connect/latest/APIReference/API_AssociateRoutingProfileQueues.html)
+ [CreateRoutingProfile](https://docs.aws.amazon.com/connect/latest/APIReference/API_CreateRoutingProfile.html) 
+ [DeleteRoutingProfile](https://docs.aws.amazon.com/connect/latest/APIReference/API_DeleteRoutingProfile.html)
+ [DescribeRoutingProfile](https://docs.aws.amazon.com/connect/latest/APIReference/API_DescribeRoutingProfile.html)
+ [DisassociateRoutingProfileQueues](https://docs.aws.amazon.com/connect/latest/APIReference/API_DisassociateRoutingProfileQueues.html)
+ [ListRoutingProfileQueues](https://docs.aws.amazon.com/connect/latest/APIReference/API_ListRoutingProfileQueues.html)
+ [UpdateRoutingProfileConcurrency](https://docs.aws.amazon.com/connect/latest/APIReference/API_UpdateRoutingProfileConcurrency.html)
+ [UpdateRoutingProfileName](https://docs.aws.amazon.com/connect/latest/APIReference/API_UpdateRoutingProfileName.html)
+ [UpdateRoutingProfileQueues](https://docs.aws.amazon.com/connect/latest/APIReference/API_UpdateRoutingProfileQueues.html)

## August 2020 Updates<a name="august20-release-notes"></a>

The following updates were released in August 2020:

### Contact flows<a name="august20-contact-flows"></a>
+ Added the ability to automatically use the best sounding voice available from Amazon Polly for text\-to\-speech\. For more information, see [Amazon Polly best sounding voice](text-to-speech.md#amazon-polly-best-sounding-voice)\. 
+ Added the ability to select, cut, copy, and paste contact flows\. For more information, see [Copy and paste contact flows](copy-paste-contact-flows.md)\. 

### Telephony<a name="august20-early-media"></a>
+ Added the ability for all customers to enable/disable media support for outbound phone calls\. For more information, see [Step 3: Telephony options](amazon-connect-instances.md#get-started-telephony) in the [Create an Amazon Connect instance](amazon-connect-instances.md) topic\. 

### Monitoring<a name="august20-monitoring"></a>
+ Added logging of Amazon Connect Participant Service calls with AWS CloudTrail\. For more information, see [Logging Amazon Connect API calls with AWS CloudTrail](logging-using-cloudtrail.md)\.

### Contact Lens for Amazon Connect<a name="august20-contact-flows"></a>
+ Updated the security profile permissions for the redaction feature\. For more information, see [Security profile permissions for Contact Lens](permissions-for-contact-lens.md)\.

## July 2020 Updates<a name="july20-release-notes"></a>

The following updates were released in July 2020:

### Contact flows<a name="july20-contact-flows"></a>
+ The **Set voice** block supports speaking styles with neural text\-to\-speech \(TTS\) voices\. For more information, see [Contact block: Set voice](set-voice.md)\.

### APIs<a name="july20-apis"></a>
+ Added [StartContactRecording](https://docs.aws.amazon.com/connect/latest/APIReference/API_StartContactRecording.html), [StopContactRecording](https://docs.aws.amazon.com/connect/latest/APIReference/API_StopContactRecording.html), [SuspendContactRecording](https://docs.aws.amazon.com/connect/latest/APIReference/API_SuspendContactRecording.html), [ResumeContactRecording](https://docs.aws.amazon.com/connect/latest/APIReference/API_ResumeContactRecording.html) to the Amazon Connect Service API\.

### Contact Lens for Amazon Connect<a name="july20-contact-lens"></a>
+ Updated Contact Lens for Amazon Connect for general availability\. This feature lets you analyze customer\-agent conversations, by using speech transcription, natural language processing, and intelligent search capabilities\. For more information, see [Analyze conversations using Contact Lens for Amazon Connect](analyze-conversations.md)\.

### Metrics<a name="july20-metrics"></a>
+ Fixed content that was added in June 2020 that said **Agent idle time**,** Agent on contact time**, and **Occupancy** had been deprecated\. That was incorrect\. Rather, they are no longer available for queue groupings only\. For more information, see [What's new in metrics](upcoming-changes.md)\.
+ Corrected how **Occupancy** is calculated\. The correct calculation is: 

  \(Agent on contact \(wall clock time\) / \(Agent on contact \(wall clock time\) \+ Agent idle time\)\)

## June 2020 Updates<a name="june20-release-notes"></a>

The following updates were released in June 2020:

### Metrics<a name="june20-metrics"></a>
+ The following historical metrics no longer appear in queue groupings:
  + Agent idle time
  + Agent on contact time
  + Occupancy
+ Added upcoming metric changes: new real\-time and historical metrics for inbound and outbound contact time\. For more information, see [What's new in metrics](upcoming-changes.md)\.

### Contact Control Panel \(CCP\)<a name="june20-ccp"></a>
+ Released the following improvements:
  + DTMF input is passed to all lines in a three\-way call\. Any party can enter DTMF input\. 
  + Resolved an issue where the DTMF tone degraded when agents interacted with Quick connect and/or Number pad during a session\. 
  + Resolved an issue where quick connects sometimes did not appear on a page, even after an agent refreshed it\.
  + Improved the experience when a manager "listens in" to multiple chat conversations\. Updated the unread message count on the CCP to include messages sent by the customer and those sent by the agent\. Previously, the unread message count only included messages sent by the customer\.
+ Published instructions for upgrading to the latest CCP\. For more information, see [Upgrade to the latest CCP](upgrade-to-latest-ccp.md)\.
+ Published a training video that explains how to use the CCP\. For more information, see [Training video: How to use the CCPTraining video](ccp-video-training.md)\.

### Contact flows<a name="june20-contact-flows"></a>
+ The **Set disconnect flow** block supports voice conversations\. For more information, see [Contact block: Set disconnect flow](set-disconnect-flow.md)\.
+ The **Set Voice** block supports Amazon Polly Neural Text\-to\-Speech \(NTTS\) voices\. For more information, see [Contact block: Set voice](set-voice.md)\.
+ The **Get queue metrics** block can return metrics by channel, for example, by voice or chat\. For more information, see [Contact block: Get queue metrics](get-queue-metrics.md)\.

## May 2020 Update<a name="may20-release-notes"></a>

The following updates were released in May 2020:

### Contact flows<a name="may20-contact-flows"></a>
+ Added the ability to select multiple blocks at the same time and rearrange them as a group within a contact flow\. For more information, see [Create an inbound contact flow](create-contact-flow.md#create-inbound-contact-flow)\.

## April 2020 Update<a name="april20-release-notes"></a>

The following updates were released in April 2020:

### Telephony<a name="april20-telephony"></a>
+ Added early media support for outbound phone calls\. Enabled by default, an agent hears tones and audio messages played by phone companies—such as busy signals, failure to connect errors, or other informational messages—through their headset or audio device\. For more information, see [Step 3: Telephony options](amazon-connect-instances.md#get-started-telephony) in the [Create an Amazon Connect instance](amazon-connect-instances.md) topic\. 
+ Added the `barge-in-enabled` session attribute to the [Get customer input](get-customer-input.md) block so customers can interrupt Amazon Lex bots with their voice\. 

## March 2020 Update<a name="mar20-release-notes"></a>

The following updates were released in March 2020:

### Contact flows<a name="mar20-contact-flows"></a>
+ Updated the [Store customer input](store-customer-input.md) block to allow you to specify a custom terminating keypress\.

### Metrics<a name="mar20-metrics"></a>
+ Announced [June 2020: Changes for omnichannel spport](upcoming-changes.md#metrics-changes-june-2020)\.

### Networking<a name="mar20-networking"></a>
+ Updated softphone requirements in [Set up your network](ccp-networking.md)\.

## February 2020 Update<a name="feb20-release-notes"></a>

The following updates were released in February 2020:

### Service Quotas<a name="feb20-networking"></a>
+ Adjusted [Amazon Connect service quotas](amazon-connect-service-limits.md) for new accounts\.

### Contact Flows<a name="feb20-contact-flows"></a>

Updated the following blocks so you can set contact attributes:
+ [Set customer queue flow](set-customer-queue-flow.md)
+ [Set hold flow](set-hold-flow.md) 
+ [Set whisper flow](set-whisper-flow.md) 

## January 2020 Update<a name="jan20-release-notes"></a>

The following updates were released in January 2020:

### Contact Control Panel \(CCP\)<a name="jan20-ccp"></a>

The following updates were made to the updated Contact Control Panel \(ccp\-v2\):
+ Agents can now transfer a contact by double\-clicking a quick connect\. For more information, see [Transfer calls to a quick connect or external number](transfers.md)\.
+ The number pad now retains the previously selected country flag so agents don't need to select it every time\.
+ All strings in the CCP user interface are now localized in available languages\.
+ Resolved an issue where the color of the call status bar incorrectly displayed as green during a conference call when the call was in the Joined state\. It is now blue\.
+ Resolved an issue where the agent’s name was displayed in error messages for missed chats, rather than the customer’s name\.

### Networking<a name="jan20-networking"></a>
+ Updated [Set up your network](ccp-networking.md) to include requirements for the updated Contact Control Panel \(ccp\-v2\)\.

## December 2019 Update<a name="dec19-release-notes"></a>

The following update was released in December 2019:

### Monitoring<a name="dec19-monitoring"></a>
+ Added Contact Lens for Amazon Connect for preview\. This feature enables you search conversations for keywords, sentiment scores, and non\-talk time\. For more information, see [Analyze conversations using Contact Lens for Amazon Connect](analyze-conversations.md)\.
+ Added logging of Amazon Connect API calls with AWS CloudTrail\. For more information, see [Logging Amazon Connect API calls with AWS CloudTrail](logging-using-cloudtrail.md)\.

## November 2019 Update<a name="nov19-release-notes"></a>

The following updates were released in November 2019:

### Omnichannel Support<a name="nov19-channel"></a>
+ Added support for chat communications\. For more information, see [Concepts](connect-concepts.md)\. 

### Metrics<a name="nov19-metrics"></a>
+ For a description of changes, see [What's new in metrics](upcoming-changes.md)\.

### Contact Flows<a name="nov19-contact-flows"></a>

Added the following contact flow blocks:
+ [Contact block: Wait](wait.md)
+ [Contact block: Set disconnect flow](set-disconnect-flow.md) 

Updated the following contact flow blocks for chat:
+ [Contact block: Play prompt](play.md)
+ [Contact block: Get customer input](get-customer-input.md)
+ [Contact block: Store customer input](store-customer-input.md)
+ [Contact block: Set recording and analytics behavior](set-recording-behavior.md)

### User Management<a name="nov19-users"></a>
+ Added that you can use AWS Identity and Access Management \(IAM\) with Amazon Connect\. For more information, see [Identity and access management for Amazon Connect](security-iam.md)\.

### Live Media Streaming<a name="nov19-lms"></a>
+ Added that you can capture customer audio for the entire interaction with your contact center\. For more information, see [Capture customer audio: live media streaming](customer-voice-streams.md)\.

### API<a name="nov19-api"></a>
+ Added [StartChatContact](https://docs.aws.amazon.com/connect/latest/APIReference/API_StartChatContact.html), [ListTagsForResource](https://docs.aws.amazon.com/connect/latest/APIReference/API_ListTagsForResource.html), [TagResource](https://docs.aws.amazon.com/connect/latest/APIReference/API_TagResource.html), [UntagResource](https://docs.aws.amazon.com/connect/latest/APIReference/API_UntagResource.html) to the Amazon Connect Service API\.
+ Added the [Amazon Connect Participant Service](https://docs.aws.amazon.com/connect-participant/latest/APIReference/Welcome.html) API\. These APIs are used chat participants, such as agents and customers\.

### Contact Control Panel \(CCP\)<a name="nov19-CCP"></a>
+ Updated the CCP so it supports chat\. For more information, see [Agent training guide for the Amazon Connect CCP](agent-user-guide.md)\. 

## October 2019 Update<a name="oct19-release-notes"></a>

The following update was released in October 2019:

### Metrics<a name="oct19-metrics"></a>
+ The real time metric **On call** is now incremented whenever an agent is handling a contact who is connected, on hold, in After Contact Work, or the agent is dialog out to a customer\. 

  This metric is available in the Queues tables and Routing Profile tables on the **Real time metrics** page\. It's also returned by the `GetCurrentMetricData` API as `AGENTS_ON_CALL`\. 

## June 2019 Update<a name="w117aac63c33"></a>

The following update was released in June 2019:

### Contact Flows<a name="june19-flows"></a>
+ Added contact flow versioning so you can choose between a saved or published version when you roll back\.

## May 2019 Updates<a name="w117aac63c35"></a>

The following updates were released in May 2019:

### Metrics and Reporting<a name="may19-flows"></a>
+ Improved the error messages you might encounter when creating, editing, or deleting a scheduled report\. 
+ In the Historical metrics report UI, changed **Contacts missed** to **Agent non\-response**\. This metric appears as **Contacts missed** in scheduled reports and exported CSV files\.
+ In the agent event stream, fixed the formatting of the timestamp millisecond so you can better order and analyze the data\. To learn more, see [Amazon Connect agent event streams](agent-event-streams.md)\. 

### Contact Control Panel<a name="may19-ccp"></a>
+ Resolved an issue where calling a destroy action \(such as `connection.destroy`\) using the [Amazon Connect Streams API](https://github.com/aws/amazon-connect-streams/blob/master/Documentation.md) resulted in different behavior depending on which leg of the conversation it was called from: the agent or the customer\. Now calling a destroy action results in the same behavior for both: a busy conversation is moved to After Call Work \(ACW\) and a conversation in any other state is cleared\. If you used the native Contact Control Panel instead of the Amazon Connect Streams API, you weren't impacted by this issue\.

## April 2019 Updates<a name="w117aac63c37"></a>

The following updates were released in April 2019:

### Contact Control Panel<a name="april19-ccp"></a>
+ Resolved an issue where the hold flow didn't run in this case: 
  + The agent missed a call and then set themselves back to Available\.
  + Then they were re\-routed the same call\.
  + The agent put that customer on hold while handling the call\.

  However, taking the customer off hold worked as expected and no other impact occurred\.
+ Resolved an issue where the [Amazon Connect Streams API](https://github.com/aws/amazon-connect-streams/blob/master/Documentation.md) returned `softphoneAutoAccept = FALSE` even though **Auto\-Accept Call** was enabled for the agent\. 

## March 2019 Update<a name="w117aac63c39"></a>

The following updates were released in March 2019:

### Metrics and Reporting<a name="march19-flows"></a>
+ Improved the error messages you might encounter when running real\-time metrics reports\. For example, if you manually configure a real\-time metrics report to contain more than 100 queues, we'll display this message: "You've hit the maximum limit of 100 queues\. Please reconfigure your report to contain no more than 100 queues\." To learn more, see [No metrics or too few rows in a queues report?](troubleshoot-rtm.md)

### Contact Control Panel<a name="march19-ccp"></a>
+ Resolved an issue where, in rare cases, an agent already handling an outbound call could have been incorrectly presented with an additional queued callback, even though they are only allowed to handle one contact at a time\. Since that agent would have been on contact and not idle, the agent wouldn't have been able to accept the queued callback\.

  In these cases, the outbound call was not impacted; the agent wouldn't have noticed any differences in the CCP\. The callback was presented to another agent instead of being dropped\.

## February 2019 Updates<a name="feb19-release-notes"></a>

The following updates were released in February 2019:

**Topics**
+ [Contact Routing](#feb19-contact-routing)
+ [Contact Flows](#feb19-flows)
+ [Metrics and Reporting](#feb19-metrics)
+ [Contact Control Panel \(CCP\)](#feb19-ccp)

### Contact Routing<a name="feb19-contact-routing"></a>
+ Resolved an issue where in rare cases some contacts were not routed to the agent that was available for the longest time\.
+ Resolved an issue in the user interface where the value displayed for **No\. of agents staffed** for the **Basic Routing Profile** on the **Routing Profiles** page was incorrect\. The correct number of agents for the routing profile was displayed on the **User Management** page\.

### Contact Flows<a name="feb19-flows"></a>
+ Resolved an issue with the contact flow editor when adding intents in Chrome\.
+ Resolved an issue where routing priority and age for queued callbacks were not saved\.
+ Resolved an issue where contact attributes for an outbound whisper flow were not saved\.

### Metrics and Reporting<a name="feb19-metrics"></a>
+ Added **EnqueueTimestamp**, **Duration**, and **DequeueTimestamp** to the contact trace record \(CTR\) for callback contacts\.
+ Resolved an issue where **InitiationTimestamp** for callback contacts did not match the time that the callback was created\.
+ Resolved an issue where users were given an incorrect message when they did not have permissions to edit a report\.

### Contact Control Panel \(CCP\)<a name="feb19-ccp"></a>
+ Resolved an issue where callbacks were not ringing in the CCP\.

## January 2019 Updates<a name="jan19-release-notes"></a>

The following updates were released in January 2019:

**Topics**
+ [Contact Routing](#jan19-contact-routing)
+ [Contact Flows](#jan19-flows)
+ [Metrics and Reporting](#jan19-metrics)

### Contact Routing<a name="jan19-contact-routing"></a>
+ Resolved an issue where in rare cases agent transfers were failing\.

### Contact Flows<a name="jan19-flows"></a>
+ Resolved an issue where agent transfers were failing\.
+ Resolved an issue that resulted in periodic delays in publishing contact flow logs\.

### Metrics and Reporting<a name="jan19-metrics"></a>
+ Resolved an issue in real\-time metrics reports where the page showed the wrong calculation for **Avg queue answer time**\.
+ Resolved an issue where some events were missing from an agent event stream\.

## December 2018 Updates<a name="dec18-release-notes"></a>

The following updates were released in December 2018:

**Topics**
+ [Metrics and Reporting](#dec18-metrics)
+ [Contact Control Panel \(CCP\)](#dec18-ccp)

### Metrics and Reporting<a name="dec18-metrics"></a>
+ Resolved an issue where agent event streams were missing agent snapshots during login and logout events\.
+ Resolved an issue where the contact trace record detail page displayed timestamps using the timezone selected on the search page\.
+ Resolved an issue where the AfterContactWork status was overridden\.
+ Resolved an issue where the timestamps are incorrect if an agent accidentally disconnects while placing a customer on hold\.

### Contact Control Panel \(CCP\)<a name="dec18-ccp"></a>
+ Resolved an intermittent issue with initialization when an agent configuration is corrupted or null\.
+ Resolved an issue where pressing Enter to transfer a call did not work\.

## November 2018 Updates<a name="nov18-release-notes"></a>

The following updates were released in November 2018:

**Topics**
+ [General](#nov18-general)
+ [Contact Flows](#nov18-flows)
+ [Metrics and Reporting](#nov18-metrics)

### General<a name="nov18-general"></a>
+ Resolved an issue with auditing\.
+ Resolved an issue that sometimes resulted in agents being placed in a default state when a contact disconnected when attempting to connect to an agent\.
+ Resolved an issue that sometimes resulted in newly created agents not being able to log in correctly if the log in attempt occurred immediately after user account was created\.

### Contact Flows<a name="nov18-flows"></a>
+ Added the new Loop block, which lets you loop through segments of a contact flow, such as requesting customer information additional times if valid data is not entered\.

### Metrics and Reporting<a name="nov18-metrics"></a>
+ Resolved an issue where callbacks handled were included in the count for incoming contacts in historical reports, but not counted in scheduled reports\. Callbacks handled are no longer included in the count for Incoming contacts handled in historical reports\.
+ Improved performance of report generation for reports with a large number of queues and agents in an instance\.
+ Resolved an issue with how ACW was reported, and backfilled data in customer instances to correct the ACW data for September, October, and November\.

## October 2018 Updates<a name="oct18-release-notes"></a>

The following updates were released in October 2018:

**Topics**
+ [General](#oct18-general)
+ [Metrics and Reporting](#oct18-metrics)
+ [API](#oct18-api)

### General<a name="oct18-general"></a>
+ Resolved an issue that sometimes resulted in stuck media sessions\.

### Metrics and Reporting<a name="oct18-metrics"></a>
+ Resolved an issue that sometimes resulted in agent names not being displayed correctly in historical reports\.
+ Resolved an issue that sometimes resulted in the data related to agent Auxiliary states were incorrectly overwritten\.

### API<a name="oct18-api"></a>
+ Resolved an issue where the `GetCurrentMetrics` operation returned the metric `OLDEST_CONTACT_AGE` in milliseconds instead of seconds\.

## September 2018 Updates<a name="sep18-release-notes"></a>

The following updates were released in September 2018:

**Topics**
+ [General](#sep18-general)
+ [API](#sep18-api)

### General<a name="sep18-general"></a>
+ Improved page loading times for the **User management** page\.
+ Resolved an issue that sometimes caused issues loading the **Queues** page when there were a large number of quick connects associated with a queue\.

### API<a name="sep18-api"></a>
+ Released the [UpdateContactAttributes](https://docs.aws.amazon.com/connect/latest/APIReference/API_UpdateContactAttributes.html) operation for the Amazon Connect API\.

## August 2018 Updates<a name="aug18-release-notes"></a>

The following updates were released in August 2018:

**Topics**
+ [General](#aug18-general)
+ [Contact Routing](#aug18-contact-routing)
+ [Metrics and Reporting](#aug18-metrics)

### General<a name="aug18-general"></a>
+ Added a restriction of 64 characters for the password length for the administrator account created during instance creation\.
+ Resolved an issue where the **Hours of operation** page would not load when no days were selected for a saved Hours of operation configuration\.

### Contact Routing<a name="aug18-contact-routing"></a>
+ Increased the timeout for whispers to 2 minutes for outbound and queued callbacks so that agents have longer to prepare for the incoming call\.

### Metrics and Reporting<a name="aug18-metrics"></a>
+ Modified how the value for the Contacts abandoned metric so that calls that transfer to callbacks are not counted as abandoned contacts\.

## July 2018 Updates<a name="july18-release-notes"></a>

The following updates were released in July 2018:

**Topics**
+ [New Features](#july18-features)
+ [General](#july18-general)
+ [Metrics and Reporting](#july18-metrics)
+ [Contact Flows](#july18-contact-flows)

### New Features<a name="july18-features"></a>
+ [Use the Call phone number block to set caller ID](queues-callerid.md#using-call-number-block)
+ [Add an Amazon Lex bot](amazon-lex.md)
+ [User Management APIs](https://docs.aws.amazon.com/connect/latest/APIReference/)
+ [Manage contacts in a queue](queue-to-queue-transfer.md)

### General<a name="july18-general"></a>
+ Added an error message when attempting to create an admin user during instance creation using “Administrator” as the user name\. The user name Administrator is reserved for internal use, and cannot be used to create a user account in Amazon Connect\.
+ Added support for directory user names that include consecutive dashes\.
+ Added pagination when displaying security profiles in your instance so that more than 25 security profiles can be displayed\.
+ Performance optimizations to reduce latency when using the `StartOutboundVoiceContact` API\.

### Metrics and Reporting<a name="july18-metrics"></a>
+ Resolved an issue in real\-time metrics reports where applied filters were not displayed in the settings page when an additional filter was applied\. The settings page now displays the applied filters correctly\.

### Contact Flows<a name="july18-contact-flows"></a>
+ Added drop\-down menus for contact attributes to make it easier to reference attributes in a contact flows\.

## June 2018 Updates<a name="jun18-release-notes"></a>

The following updates were released in June 2018:

**Topics**
+ [General](#june18-general)
+ [Telephony and Voice](#june18-telephony)
+ [Contact Flows](#june18-contact-flows)
+ [Metrics and Reporting](#june18-metrics)
+ [Contact Control Panel \(CCP\)](#june18-ccp)

### General<a name="june18-general"></a>
+ Changed the font in the UI to Amazon Ember for better readability\.

### Telephony and Voice<a name="june18-telephony"></a>
+ Introduced support for using Amazon Lex bots with Amazon Connect in the US West \(Oregon\) Region\.
+ Fixed a bug that in some cases caused a call to drop when a Loop prompt occurred at the same as a call connecting to an agent\.

### Contact Flows<a name="june18-contact-flows"></a>
+ Renamed the **Set queue** block to **Set working queue**\.
+ Added a **Copy to clipboard** button next to the ARN of a contact flow so you can easily copy the ARN\. Choose **Show additional flow information** under the name of the contact flow in the designer to display the ARN\.
+ Added a new **Call phone number** block, which lets you choose the phone number from your instance to display as the caller ID in an outbound whisper flow\. For more information, see [Use the Call phone number block to set caller ID](queues-callerid.md#using-call-number-block)\.
+ Released contact attributes for system metrics, including a new **Get metrics** block in contact flows\. For more information, see [How to use system metric attributes](attrib-system-metrics.md)\.

### Metrics and Reporting<a name="june18-metrics"></a>
+ Fixed an issue that caused incorrect rendering of the search field in the filters settings for some historical metrics reports\.
+ Fixed an issue in downloaded reports where the phone number would be blank instead of listing the phone number for calls that were callbacks\.
+ Login/Logout reports now support 20,000 rows per report generation, up from 10,000\.

### Contact Control Panel \(CCP\)<a name="june18-ccp"></a>
+ Added a mute button to the CCP and a mute function to the Streams API so agents can mute and unmute active calls\.

## April and May 2018 Updates<a name="may18-release-notes"></a>

The following updates were released in April and May 2018:

**Topics**
+ [General](#may18-general)
+ [Telephony and Voice](#may18-telephony)
+ [Contact Flows](#may18-contact-flows)
+ [Metrics and Reporting](#may18-metrics)
+ [Contact Control Panel \(CCP\)](#may18-ccp)

### General<a name="may18-general"></a>
+ New [Amazon Polly voices](https://docs.aws.amazon.com/polly/latest/dg/voicelist.html) are now automatically made available in Amazon Connect as soon as they are launched\. You can use new voices, such as Matthew and Léa, in your contact flows\.
+ Updated password enforcement for Amazon Connect user accounts to match requirements for the Amazon Connect admin account created during instance creation\.
+ Resolved an issue that sometimes resulted in the email addresses not being saved when updating an existing user account\.

### Telephony and Voice<a name="may18-telephony"></a>
+ Service optimizations to reduce latency and improve caller ID for Japanese telephony\.
+ Customers can now place calls to Jersey and Guernsey in the Channel Islands\.
+ Added support for keypad numeric input to an Amazon Lex bots when used in an Amazon Connect contact flow\. For more information, see [Amazon Connect Now Supports Keypad Input with an Amazon Lex Chatbot](http://aws.amazon.com/about-aws/whats-new/2018/05/amazon-connect-now-supports-keypad-input-with-an-amazon-lex-chat/)\.
+ Reduced latency for the contact control panel, improving the agent user experience\.

### Contact Flows<a name="may18-contact-flows"></a>
+ Resolved an issue with publishing a contact flow in the case where an **AWS Lambda function block** is used in a contact flow, and the input type for a parameter was changed from **Send attribute** with a **System** attribute is changed to **Send text**\. These contact flows now publish successfully\.
+ Agent and customer whispers are now maintained with queued callbacks\.
+ Attributes now correctly persist with queue callbacks\.
+ Contact attributes are now maintained when using a **Loop prompt** block in a queue flow\.

### Metrics and Reporting<a name="may18-metrics"></a>
+ Data for scheduled reports is now delayed by 15 minutes to allow for most recent data to be incorporated in to reports\. Previously, in some cases, report data for the final 15 minute period during the scheduled report interval did not get included in scheduled reports\. This applies to all report types\.
+ In metric calculations, the time that an incoming call rings is attributed to idle time if the agent is in idle state before an incoming call\.
+ The metric **Agent on contact time** now includes time that an agent spent in an auxiliary busy state\.
+ Published new documentation about metrics\.

### Contact Control Panel \(CCP\)<a name="may18-ccp"></a>
+ Added a **Save** button to the settings menu for the CCP when an agent is using a desk phone\. The **Save** button saves the deskphone configuration between sessions\.
+ Agent username is now available as part of agent configuration data in the [Amazon Connect Streams API](https://github.com/aws/amazon-connect-streams/blob/master/Documentation.md)\.
+ Contact attributes are now available when using the streams\.js \(Streams API\) for screenpops after queued callbacks\.
+ Fixed issue where for some auto\-accept calls, the agent continued to hear ringing after accepting and joining the call\.