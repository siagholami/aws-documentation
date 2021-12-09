# Sending a Test Push Notification<a name="messages-mobile"></a>

To send a test push notification, you have to use a project that has one or more push notification channels enabled\. To learn how to create a new project and enable a push notification channel for it, see [Setting Up Amazon Pinpoint Mobile Push Channels](channels-mobile-setup.md)\. To learn how to enable a push notification channel for an existing project, see [Managing Mobile Push Channels with Amazon Pinpoint](channels-mobile-manage.md)\.

After you enable one or more push notification channels for a project, you can send a test push notification through any of those channels\.

**To send a test push notification**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to send a test message for\.

1. In the navigation pane, choose **Test messaging**\.

1. On the **Test messaging** page, under **Channel**, choose **Push notifications**\.

1. For **Destination type**, choose one of the following destinations for your message:
   + **Endpoint IDs** – Each destination is a unique ID that's assigned to an endpoint for the project\.
   + **Device tokens** – Each destination is a token that's assigned to the instance of the app that you're messaging\. For example, this value can be a device token that's assigned by the Apple Push Notification service \(APNs\) or a registration token that's assigned by Firebase Cloud Messaging \(FCM\)\.

1. Depending on your selection for **Destination type**, enter one or more **Endpoint IDs** or **Device tokens**\. You can enter up to 15 values\. Use commas to separate multiple values\.

   If you use device tokens as the destination type, you should only specify tokens that are associated with a single push notification service\. Amazon Pinpoint can send the message through only one push notification service at a time\.

   If you use endpoint IDs as the destination type, this restriction doesn't apply\. You can specify endpoints that use any push notification service\.

1. For **Push notification service**, specify the push notification service that you want to send the message through\. If you use endpoint IDs as the destination type, Amazon Pinpoint detects the service automatically\.

1. For **Notification type**, specify the type of test message that you want to send:
   + **Standard message** – A push notification that has a title, a message body, and other content and settings\. Recipients are alerted by their mobile devices when they receive the message\.
   + **Raw message** – A push notification that specifies all of a notification's content and settings as a JSON object\. This type of notification can be useful for cases such as sending custom data to an app for processing by that app, instead of the push notification service\. If you choose this option, the message editor displays an outline of the code to use for the message\. In the message editor, enter the settings that you want to use for each push notification service\. Include any optional settings \(such as images, sounds, and actions\) that you want to specify\. For more information, see the documentation for the push notification services that you use\. When you finish entering all the raw message content, skip to step 12\.

1. Under **Message**, for **Message content**, choose whether you want to **Create a new message** or **Use an existing template**\. 

   If you choose to use an existing template, choose the template from the **Template** list\. After you choose a template from the list, Amazon Pinpoint displays a preview of the active version of the template\. \(The active version is typically the version of a template that's been reviewed and approved for use, depending on your workflow\.\) When you finish choosing a template, skip to step 12\.

   If you choose to create a new message, specify a **Title** and **Body** for the message\.

1. For **Action**, select the action that you want to occur if the recipient taps the notification:
   + **Open app** – Your app launches, or it becomes the foreground app if it was sent to the background\.
   + **Go to URL** – The default mobile browser on the recipient's device launches and opens a web page at the URL that you specify\. For example, this action is useful for sending users to a blog post\.
   + **Open a deep link** – Your app opens and displays a designated user interface in the app\. Deep linking is an iOS and Android feature\. For example, this action is useful for directing users to special promotions for in\-app purchases\.

1. \(Optional\) In the **Media URLs** section, provide URLs that point to media files that you want to display in the message\. The URLs must be publicly accessible so that push notification services can retrieve the files\.

1. When you finish, choose **Send message**\.