# Monitoring Amazon WorkMail with Amazon CloudWatch<a name="monitoring-workmail-cloudwatch"></a>

You can monitor Amazon WorkMail using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

## CloudWatch metrics for Amazon WorkMail<a name="cw-metrics"></a>

Amazon WorkMail sends the following metrics and dimension information to CloudWatch\.

The `AWS/WorkMail` namespace includes the following metrics\.


| Metric | Description | 
| --- | --- | 
|  `OrganizationEmailReceived`  |  The number of emails received by your Amazon WorkMail organization\. If 1 email is addressed to 10 recipients in your organization, the `OrganizationEmailReceived` count is 1\. Units: Count  | 
|  `MailboxEmailDelivered`  |  The number of emails delivered to individual mailboxes in your Amazon WorkMail organization\. If 1 email is successfully delivered to 10 recipients in your organization, the `MailboxEmailDelivered` count is 10\. Units: Count  | 
|  `IncomingEmailBounced`  |  The number of incoming emails that bounced due to full mailboxes or non\-existent mailboxes\. This metric is counted for each intended recipient\. For example, if 1 email is sent to 10 recipients in your organization, and 2 of the recipients have full mailboxes resulting in a bounce response, the `IncomingEmailBounced` count is 2\. Units: Count  | 
|  `OutgoingEmailBounced`  |  The number of outgoing emails that could not be delivered, counted for each intended recipient\. For example, if 1 email is sent to 10 recipients, and 2 emails could not be delivered, the `OutgoingEmailBounced` count is 2\. Units: Count  | 
|  `OutgoingEmailSent`  |  The number of emails successfully sent from your Amazon WorkMail organization\. This metric is counted for each recipient of a successfully sent email\. For example, if 1 email is sent to 10 recipients, and the email was successfully delivered to 8 of the recipients, the `OutgoingEmailSent` count is 8 \. Units: Count  | 

## CloudWatch event logs for Amazon WorkMail<a name="cw-events"></a>

When you turn on email event logging for your Amazon WorkMail organization, Amazon WorkMail logs email events with CloudWatch\. For more information about turning on email event logging, see [Tracking messages](tracking.md)\.

The following tables describe the events that Amazon WorkMail logs with CloudWatch, when the events are transmitted, and what the event fields contain\.

**`ORGANIZATION_EMAIL_RECEIVED`**  
This event is logged when your Amazon WorkMail organization receives an email message\.


| Field | Description | 
| --- | --- | 
|  recipients  |  The intended recipients of the message\.  | 
|  sender  |  The email address of the user who sent the email message on behalf of another user\. This field is set only when an email is sent on behalf of another user\.  | 
|  from  |  The **From** address, which is usually the email address of the user who sent the message\. If the user sent the message as another user or on behalf of another user, this field returns the email address of the user on whose behalf the email was sent, not the email address of the actual sender\.  | 
|  subject  |  The email message subject\.  | 
|  messageId  |  The SMTP message ID\.  | 
|  spamVerdict  |  Indicates whether the message is marked as spam by Amazon SES\. For more information, see [Contents of Notifications for Amazon SES Email Receiving](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/receiving-email-notifications-contents.html) in the *Amazon Simple Email Service Developer Guide*\.  | 
|  dkimVerdict  |  Indicates whether the DomainKeys Identified Mail \(DKIM\) check passed\. For more information, see [Contents of Notifications for Amazon SES Email Receiving](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/receiving-email-notifications-contents.html) in the *Amazon Simple Email Service Developer Guide*\.  | 
|  dmarcVerdict  |  Indicates whether the Domain\-based Message Authentication, Reporting & Conformance \(DMARC\) check passed\. For more information, see [Contents of Notifications for Amazon SES Email Receiving](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/receiving-email-notifications-contents.html) in the *Amazon Simple Email Service Developer Guide*\.  | 
|  dmarcPolicy  | Appears only when the dmarcVerdict field contains "FAIL"\. Indicates the action to take on the email when the DMARC check fails \(NONE, QUARANTINE, or REJECT\)\. This is set by the owner of the sending email domain\.  | 
|  spfVerdict  |  Indicates whether the Sender Policy Framework \(SPF\) check passed\. For more information, see [Contents of Notifications for Amazon SES Email Receiving](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/receiving-email-notifications-contents.html) in the *Amazon Simple Email Service Developer Guide*\.  | 
|  messageTimestamp  |  Indicates when the message is received\.  | 

**`MAILBOX_EMAIL_DELIVERED`**  
This event is logged when a message is delivered to a mailbox in your organization\. This is logged once for each mailbox to which a message is delivered, so a single `ORGANIZATION_EMAIL_RECEIVED` event can result in multiple `MAILBOX_EMAIL_DELIVERED` events\.


| Field | Description | 
| --- | --- | 
|  recipient  |  The mailbox to which the message is delivered\.  | 
|  folder  |  The mailbox folder where the message is placed\.  | 

**`RULE_APPLIED`**  
This event is logged when an incoming or outgoing message triggers an email flow rule\.


| Field | Description | 
| --- | --- | 
|  ruleName  |  The name of the rule\.  | 
|  ruleType  |  The type of rule applied \(INBOUND\_RULE, OUTBOUND\_RULE, MAILBOX\_RULE\)\. Inbound and outbound rules apply to your Amazon WorkMail organization\. Mailbox rules apply only to specified mailboxes\. For more information, see [Managing email flows](email-flows.md)\.  | 
|  ruleActions  |  Actions taken based on the rule\. Different recipients of the message might have different actions, such as a bounced email or a successfully delivered email\.  | 
|  targetFolder  |  Intended destination folder for a `Move` or `Copy` MAILBOX\_RULE\.  | 
|  targetRecipient  |  Intended recipient of a `Forward` or `Redirect` MAILBOX\_RULE\.  | 

**`JOURNALING_INITIATED`**  
This event is logged when Amazon WorkMail sends an email to the journaling address specified by your organization administrator\. This is only transmitted if journaling is configured for your organization\. For more information, see [Using email journaling with Amazon WorkMail](journaling_overview.md)\.


| Field | Description | 
| --- | --- | 
|  journalingAddress  |  The email address to which the journaling message is sent\.  | 

**`INCOMING_EMAIL_BOUNCED`**  
This event is logged when an incoming message cannot be delivered to a target recipient\. Bounced emails can be caused by reasons such as the target mailbox not existing, or the mailbox being full\. This is logged once for each recipient that resulted in a bounced email\. For example, if an incoming message is addressed to three recipients and two of them have full mailboxes, two INCOMING\_EMAIL\_BOUNCED events are logged\.


| Field | Description | 
| --- | --- | 
|  bouncedRecipient  |  The intended recipient for which Amazon WorkMail bounced the message\.  | 

**`OUTGOING_EMAIL_SUBMITTED`**  
This event is logged when a user in your organization submits an email message for sending\. This is logged before the message leaves Amazon WorkMail, so this event does not indicate whether the email is successfully delivered\.


| Field | Description | 
| --- | --- | 
|  recipients  |  The recipients of the message as specified by the sender\. Includes all recipients on the To, CC, and BCC lines\.  | 
|  sender  |  The email address of the user who sent the email message on behalf of another user\. This field is set only when an email is sent on behalf of another user\.  | 
|  from  |  The **From** address, which is usually the email address of the user who sent the message\. If the user sent the message as another user or on behalf of another user, this field returns the email address of the user on whose behalf the email was sent, not the email address of the actual sender\.  | 
|  subject  |  The email message subject\.  | 

**`OUTGOING_EMAIL_SENT`**  
This event is logged when an outgoing email is successfully delivered to a target recipient\. This is logged once for each successful recipient, so a single `OUTGOING_EMAIL_SUBMITTED` can result in multiple `OUTGOING_EMAIL_SENT` entries\.


| Field | Description | 
| --- | --- | 
|  recipient  |  The recipient of the successfully delivered email\.  | 
|  sender  |  The email address of the user who sent the email message on behalf of another user\. This field is set only when an email is sent on behalf of another user\.  | 
|  from  |  The **From** address, which is usually the email address of the user who sent the message\. If the user sent the message as another user or on behalf of another user, this field returns the email address of the user on whose behalf the email was sent, not the email address of the actual sender\.  | 
|  messageId  |  The SMTP message ID\.  | 

**`OUTGOING_EMAIL_BOUNCED`**  
This event is logged when an outgoing message cannot be delivered to a target recipient\. Bounced emails can be caused by reasons such as the target mailbox not existing, or the mailbox being full\. This is logged once for each recipient that resulted in a bounced email\. For example, if an outgoing message is addressed to three recipients and two of them have full mailboxes, two `OUTGOING_EMAIL_BOUNCED` events are logged\.


| Field | Description | 
| --- | --- | 
|  bouncedRecipient  |  The intended recipient for which the destination mail server bounced the message\.  | 

**`DMARC_POLICY_APPLIED`**  
This event is logged when a DMARC policy is applied to an email sent to your organization\.


| Field | Description | 
| --- | --- | 
| from |  The From address, which is usually the email address of the user who sent the message\. If the user sent the message as another user or on behalf of another user, this field returns the email address of the user on whose behalf the email was sent, not the email address of the actual sender\. | 
| recipients |  The intended recipients of the message\. | 
| policy | The applied DMARC policy, indicating the action to take on the email when the DMARC check fails \(NONE, QUARANTINE, or REJECT\)\. This is the same as the dmarcPolicy field in the ORGANIZATION\_EMAIL\_RECEIVED event\. | 

## Using CloudWatch Insights with Amazon WorkMail<a name="cw-insights"></a>

If you have turned on email event logging in the Amazon WorkMail console, you can use Amazon CloudWatch Logs Insights to query your event logs\. For more information about turning on email event logging, see [Tracking messages](tracking.md)\. For more information about CloudWatch Logs Insights, see [Analyze log data with CloudWatch Logs Insights](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/AnalyzingLogData.html) in the *Amazon CloudWatch Logs User Guide*\.

The following examples demonstrate how to query CloudWatch Logs for common email events\. You run these queries in the CloudWatch console\. For instructions about how to run these queries, see [Tutorial: Run and modify a sample query](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/CWL_AnalyzeLogData_RunSampleQuery.html) in the *Amazon CloudWatch Logs User Guide*\.

**Example: See why User B did not receive an email sent by User A\.**  
The following code example demonstrates how to query for an outgoing email sent by User A to User B, sorted by timestamp\.  

```
fields @timestamp, traceId
| sort @timestamp asc
| filter (event.from like /(?i)userA@example.com/
and event.eventName = "OUTGOING_EMAIL_SUBMITTED"
and event.recipients.0 like /(?i)userB@example.com/)
```
This returns the sent message and trace ID\. Use the trace ID in the following code example to query the event logs for the sent message\.  

```
fields @timestamp, event.eventName
| sort @timestamp asc
| filter traceId = "$TRACEID"
```
This returns the email message ID and the email events\. `OUTGOING_EMAIL_SENT` indicates that the email was sent\. `OUTGOING_EMAIL_BOUNCED` indicates that the email bounced\. To see whether the email was received, query using the message ID in the following code example\.  

```
fields @timestamp, event.eventName
| sort @timestamp asc
| filter event.messageId like "$MESSAGEID"
```
This should also return the received message, because it has the same message ID\. Use the trace ID in the following code example to query for delivery\.  

```
fields @timestamp, event.eventName
| sort @timestamp asc
| filter traceId = "$TRACEID"
```
This returns the delivery action and any applicable rule actions\.

**Example: See all mail received from a user or domain**  
The following code example demonstrates how to query for all mail received from a specified user\.  

```
fields @timestamp, event.eventName
| sort @timestamp asc
| filter (event.from like /(?i)user@example.com/ and event.eventName = "ORGANIZATION_EMAIL_RECEIVED")
```
The following code example demonstrates how to query for all mail received from a specified domain\.  

```
fields @timestamp, event.eventName
| sort @timestamp asc
| filter (event.from like "example.com" and event.eventName = "ORGANIZATION_EMAIL_RECEIVED")
```

**Example: See who sent bounced emails**  
The following code example demonstrates how to query for outgoing emails that bounced, and also returns the reasons for bouncing\.  

```
fields @timestamp, event.destination, event.reason
| sort @timestamp desc
| filter event.eventName = "OUTGOING_EMAIL_BOUNCED"
```
The following code example demonstrates how to query for incoming emails that bounced, and also returns the bounced recipients' email addresses and the reasons for bouncing\.  

```
fields @timestamp, event.bouncedRecipient.emailAddress, event.bouncedRecipient.reason, event.bouncedRecipient.status
| sort @timestamp desc
| filter event.eventName = "INCOMING_EMAIL_BOUNCED"
```

**Example: See which domains are sending spam**  
The following code example demonstrates how to query for recipients in your organization that are receiving spam\.  

```
stats count(*) as c by event.recipients.0
| filter (event.eventName = "ORGANIZATION_EMAIL_RECEIVED" and event.spamVerdict = "FAIL")
| sort c desc
```
The following code example demonstrates how to query for the sender of the spam emails\.  

```
fields @timestamp, event.recipients.0, event.sender, event.from
| sort @timestamp asc
| filter (event.spamVerdict = "FAIL")
```

**Example: See why an email was sent to a recipient's spam folder**  
The following code example demonstrates how to query for emails identified as spam, filtered by subject\.  

```
fields @timestamp, event.recipients.0, event.spamVerdict, event.spfVerdict, event.dkimVerdict, event.dmarcVerdict
| sort @timestamp asc
| filter event.subject like /(?i)$SUBJECT/ and event.eventName = "ORGANIZATION_EMAIL_RECEIVED"
```
You can also query by the email trace ID to see all events for the email\.

**Example: See emails that match email flow rules**  
The following code example demonstrates how to query for emails that matched outbound email flow rules\.  

```
fields @timestamp, event.ruleName, event.ruleActions.0.action
| sort @timestamp desc
| filter event.ruleType = "OUTBOUND_RULE"
```
The following code example demonstrates how to query for emails that matched inbound email flow rules\.  

```
fields @timestamp, event.ruleName, event.ruleActions.0.action, event.ruleActions.0.recipients.0
| sort @timestamp desc
| filter event.ruleType = "INBOUND_RULE"
```

**Example: See how many emails are received or sent by your organization**  
The following code example demonstrates how to query for the number of emails received by each recipient in your organization\.  

```
stats count(*) as c by event.recipient
| filter event.eventName = "MAILBOX_EMAIL_DELIVERED"
| sort c desc
```
The following code example demonstrates how to query for the number of emails sent by each sender in your organization\.  

```
stats count(*) as c by event.from
| filter event.eventName = "OUTGOING_EMAIL_SUBMITTED"
| sort c desc
```