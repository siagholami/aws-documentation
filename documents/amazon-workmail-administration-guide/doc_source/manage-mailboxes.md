# Managing user mailboxes<a name="manage-mailboxes"></a>

You can disable and restore user mailboxes and enable push notifications\. For information about managing mailbox permissions, see [Working with mailbox permissions](mail_perms_overview.md)\.

**Topics**
+ [Disabling user mailboxes](#delete_user_mailbox)
+ [Restoring disabled mailboxes](#restore_deleted_mailbox)
+ [Viewing email headers](#email-headers)
+ [Working with notifications](#notifications)

## Disabling user mailboxes<a name="delete_user_mailbox"></a>

You can disable user mailboxes when they are no longer needed\. Amazon WorkMail keeps mailboxes for 30 days before they're permanently removed\.

**To disable a user's mailbox**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the AWS Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, select **Users**, select the name of the user to disable, and choose **Disable User**\.

1. In the **Disable user\(s\)** dialog box, choose **Disable**\.

**Note**  
To permanently delete a user and their data, use the `DeleteUser` API action for Amazon WorkMail\. For more information, see [DeleteUser](https://docs.aws.amazon.com/workmail/latest/APIReference/API_DeleteUser.html) in the *Amazon WorkMail API Reference*\.

## Restoring disabled mailboxes<a name="restore_deleted_mailbox"></a>

Amazon WorkMail retains disabled mailboxes for 30 days before permanently removing them\. To restore a mailbox, use the same steps as enabling an existing user\.

**Important**  
Mailboxes cannot be restored if the organization containing them has been deleted\. To restore a user's disabled mailbox, the user must be still in the directory\. If the user isn't in the directory or if you've re\-created them, the mailbox cannot be restored because each mailbox is linked to a unique user ID\.

**To restore a disabled mailbox**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users** to see a list of enabled, disabled, and system users\.

1. From the list of disabled users, select the users to enable and choose **Enable user**\.

1. In the **Enable user\(s\)** dialog box, review the primary email address of the user and choose **Enable**\.

## Viewing email headers<a name="email-headers"></a>

The information in email headers can help you troubleshoot user email issues\.

**To view email headers in Amazon WorkMail**

1. In the Amazon WorkMail web application, open the email message\.

1. Choose **Message options** \(the gear and envelope icon\)\.

The email headers appear under **Internet Headers**\.

## Working with notifications<a name="notifications"></a>

With the Amazon WorkMail Push Notifications API, you can receive push notifications about changes in your mailbox, including new email and calendar updates\. You can register the URLs \(or push notification responders\) to receive notifications\. With this feature, developers can create responsive applications for Amazon WorkMail users, as applications are quickly notified about changes from a user's mailbox\.

For more information, see [Notification subscriptions, mailbox events, and EWS in Exchange](https://msdn.microsoft.com/en-us/library/office/dn458791(v=exchg.150).aspx)\.

You can subscribe specific folders, such as Inbox or Calendar, or all folders for mailbox change events \(including NewMail, Created, and Modified\)\.

You can use client libraries such as the [EWS Java API](https://github.com/OfficeDev/ews-java-api) or the [Managed EWS C\# API](https://msdn.microsoft.com/en-us/library/office/dn567668(v=exchg.150).aspx) to access this feature\. A complete sample application of a push responder, developed using AWS Lambda and API Gateway \(using the AWS Serverless framework\), is available [here](https://github.com/aws-samples/amazon-workmail-demo-ews-push-notifications)\. It uses the EWS Java API\.

The following is a sample push subscription request\.

```
<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:t="http://schemas.microsoft.com/exchange/services/2006/types">
   <soap:Body>
      <m:Subscribe xmlns:m="http://schemas.microsoft.com/exchange/services/2006/messages">
         <m:PushSubscriptionRequest>
            <t:FolderIds>
               <t:DistinguishedFolderId Id="inbox" />
            </t:FolderIds>
            <t:EventTypes>
               <t:EventType>NewMailEvent</t:EventType>
               <t:EventType>CopiedEvent</t:EventType>
               <t:EventType>CreatedEvent</t:EventType>
               <t:EventType>DeletedEvent</t:EventType>
               <t:EventType>ModifiedEvent</t:EventType>
               <t:EventType>MovedEvent</t:EventType>
            </t:EventTypes>
            <t:StatusFrequency>1</t:StatusFrequency>
            <t:URL>https://YOUR_PUSH_RESPONDER_URL</t:URL>
         </m:PushSubscriptionRequest>
      </m:Subscribe>
   </soap:Body>
</soap:Envelope>
```

The following is a successful subscription request result\.

```
<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <Header xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <ServerVersionInfo xmlns="http://schemas.microsoft.com/exchange/services/2006/types" MajorVersion="14" MinorVersion="2" MajorBuildNumber="390" Version="Exchange2010_SP2" MinorBuildNumber="3" />
   </Header>
   <soap:Body>
      <m:SubscribeResponse xmlns:m="http://schemas.microsoft.com/exchange/services/2006/messages" xmlns:t="http://schemas.microsoft.com/exchange/services/2006/types">
         <m:ResponseMessages>
            <m:SubscribeResponseMessage ResponseClass="Success">
               <m:ResponseCode>NoError</m:ResponseCode>
               <m:SubscriptionId>hKJETtoAdi9PPW0tZDQ4MThmMDoVYB</m:SubscriptionId>
               <m:Watermark>AAAAAAA=</m:Watermark>
            </m:SubscribeResponseMessage>
         </m:ResponseMessages>
      </m:SubscribeResponse>
   </soap:Body>
</soap:Envelope>
```

Afterwards, notifications are sent to the URL specified in the subscription request\. The following is a sample notification\.

```
<soap:Envelope
    xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Header>
        <t:RequestServerVersion
            xmlns:t="http://schemas.microsoft.com/exchange/services/2006/types"
            xmlns:m="http://schemas.microsoft.com/exchange/services/2006/messages" Version="Exchange2010_SP2">
        </t:RequestServerVersion>
    </soap:Header>
    <soap:Body>
        <m:SendNotification
            xmlns:t="http://schemas.microsoft.com/exchange/services/2006/types"
            xmlns:m="http://schemas.microsoft.com/exchange/services/2006/messages">
            <m:ResponseMessages>
                <m:SendNotificationResponseMessage ResponseClass="Success">
                    <m:ResponseCode>NoError</m:ResponseCode>
                    <m:Notification>
                        <t:SubscriptionId>hKJETtoAdi9PPW0tZDQ4MThmMDoVYB</t:SubscriptionId>
                        <t:PreviousWatermark>ygwAAAAAAAA=</t:PreviousWatermark>
                        <t:MoreEvents>false</t:MoreEvents>
                        <t:ModifiedEvent>
                            <t:Watermark>ywwAAAAAAAA=</t:Watermark>
                            <t:TimeStamp>2018-02-02T15:15:14Z</t:TimeStamp>
                            <t:FolderId Id="AAB2L089bS1kNDgxOGYwOGE5OTQ0="></t:FolderId>
                            <t:ParentFolderId Id="AAB2L089bS1kNDgxOGYwOGE="></t:ParentFolderId>
                        </t:ModifiedEvent>
                    </m:Notification>
                </m:SendNotificationResponseMessage>
            </m:ResponseMessages>
        </m:SendNotification>
    </soap:Body>
</soap:Envelope>
```

To acknowledge that the push notification responder has received the notification, it must reply with the following\.

```
 <?xml version="1.0"?>
  <s:Envelope xmlns:s= "http://schemas.xmlsoap.org/soap/envelope/">
    <s:Body>
      <SendNotificationResult xmlns="http://schemas.microsoft.com/exchange/services/2006/messages">
        <SubscriptionStatus>OK</SubscriptionStatus>
      </SendNotificationResult>
    </s:Body>
  </s:Envelope>
```

To unsubscribe from receiving push notifications, clients must send an unsubscribe response in the `SubscriptionStatus` field, similar to the following\.

```
 <?xml version="1.0"?>
  <s:Envelope xmlns:s= "http://schemas.xmlsoap.org/soap/envelope/">
    <s:Body>
      <SendNotificationResult xmlns="http://schemas.microsoft.com/exchange/services/2006/messages">
        <SubscriptionStatus>Unsubscribe</SubscriptionStatus>
      </SendNotificationResult>
    </s:Body>
  </s:Envelope>
```

To verify the health of your push notification responder, Amazon WorkMail sends a “heartbeat” \(also called a `StatusEvent`\)\. The frequency with which they are sent is determined by the `StatusFrequency` parameter provided in the initial subscription request\. For example, if `StatusFrequency` equals 1, a `StatusEvent` is sent every 1 minute\. This value can range between 1 and 1440 minutes\. This `StatusEvent` looks like the following\.

```
<?xml version="1.0 (http://www.w3.org/TR/REC-xml/)" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
<soap:Header>
    <t:RequestServerVersion xmlns:t="http://schemas.microsoft.com/exchange/services/2006/types" xmlns:m="http://schemas.microsoft.com/exchange/services/2006/messages" Version="Exchange2010_SP2"/>
</soap:Header>
<soap:Body>
    <m:SendNotification xmlns:t="http://schemas.microsoft.com/exchange/services/2006/types" xmlns:m="http://schemas.microsoft.com/exchange/services/2006/messages">
    <m:ResponseMessages>
        <m:SendNotificationResponseMessage ResponseClass="Success">
            <m:ResponseCode>NoError</m:ResponseCode>
            <m:Notification>
                <t:SubscriptionId>hKJETtoAdi9PPW0tZDQ4MThmMDoVYB</t:SubscriptionId>
                <t:PreviousWatermark>AAAAAAAAAAA=</t:PreviousWatermark>
                <t:MoreEvents>false</t:MoreEvents>
                <t:StatusEvent>
                    <t:Watermark>AAAAAAAAAAA=</t:Watermark>
                </t:StatusEvent>
            </m:Notification>
        </m:SendNotificationResponseMessage>
    </m:ResponseMessages>
</m:SendNotification>
</soap:Body>
</soap:Envelope>
```

If a client push notification responder fails to respond \(with the same OK status as before\), the notification is retried for a maximum of `StatusFrequency` minutes\. For example, if `StatusFrequency` equals 5, and the first notification fails, it is retried for a maximum of 5 minutes with an exponential backoff between each retry\. If the notification is not delivered after the retry time has expired, the subscription becomes invalidated and no new notifications are delivered\. You must create a new subscription to continue to receive notifications about mailbox events\. Currently, you can subscribe for a maximum of three subscriptions per mailbox\.