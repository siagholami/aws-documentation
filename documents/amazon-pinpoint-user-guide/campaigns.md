# Amazon Pinpoint Campaigns<a name="campaigns"></a>

A *campaign* is a messaging initiative that engages a specific audience [segment](segments.md)\. A campaign sends tailored messages according to a schedule that you define\. You can use the console to create a campaign that sends messages through any single channel that is supported by Amazon Pinpoint: mobile push, email, or SMS\.

For example, to help increase engagement between your mobile app and its users, you could use Amazon Pinpoint to create and manage push notification campaigns that reach out to users of that app\. Your campaign might invite users back to your app who haven’t run it recently or offer special promotions to users who haven’t purchased recently\.

Your campaign can send a message to all users in a segment, or you can allocate a holdout, which is a percentage of users who receive no messages\. The segment can be one that you created on the **Segments** page or one that you define while you create the campaign\. 

You can set the campaign's schedule to send the message once or at a recurring frequency, such as once per week\. You can also set up your campaign to send messages when specific events occur\. For example, you can send a campaign when a user creates a new account, or when a customer adds an item to their shopping cart, but doesn't complete their purchase\. To prevent users from receiving your messages at inconvenient times, you can also configure your campaigns so that they don't send messages during specific quiet hours\.

To experiment with alternative campaign strategies, set up your campaign as an A/B test\. An A/B test includes two or more treatments of the message or schedule\. Treatments are variations of your message or schedule\. As your users respond to the campaign, you can view campaign analytics to compare the effectiveness of each treatment\.

If you want to send a one\-time message without engaging a user segment or defining a schedule, you can simply [send a direct message](messages.md) instead of creating a campaign\.

**Topics**
+ [Step 1: Create a Campaign](campaigns-begin.md)
+ [Step 2: Specify the Audience for the Campaign](campaigns-segment.md)
+ [Step 3: Write the Message](campaigns-message.md)
+ [Step 4: Choose When to Send the Campaign](campaigns-schedule.md)
+ [Step 5: Review and Launch the Campaign](campaigns-review.md)
+ [Managing Campaigns](campaigns-managing.md)