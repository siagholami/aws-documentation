# Step 4: View Campaign Analytics<a name="gettingstarted-analytics"></a>

At this point, you've created a segment that you're a member of\. You've also created an email campaign and sent it to yourself\. In this section, you look at the delivery and response metrics for the campaign\.

## Step 4\.1: Interact with Your Campaign<a name="gettingstarted-analytics-interact"></a>

Before you can view the delivery and response metrics for your campaign, you have to interact with the message that you sent yourself in [Step 3](gettingstarted-create-campaign.md)\.

**To interact with the email**

1. In your email client, open the message that you sent yourself in [Step 3](gettingstarted-create-campaign.md)\.

1. If your email client automatically hides images by default, choose the **Download pictures** \(or equivalent\) button to load the images in the message\.

1. Choose one or more of the links that are contained in the message\.

1. Wait for a few minutes, and then proceed to the next section\.

## Step 4\.2: View Metrics for the Campaign<a name="gettingstarted-analytics-view"></a>

After you interact with the email that you sent from the campaign, you can view the metrics for the campaign\.

**To view the campaign metrics**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you used to send the campaign\.

1. In the navigation pane, under **Analytics**, choose **Campaigns**\.

1. In the **Campaigns** section, choose the campaign that you created in [Step 3](gettingstarted-create-campaign.md)\.

1. \(Optional\) Use the date control to choose a date range for the reports on this page\.

   On the metrics page for your campaign, you see the following information:
   + **Delivery count metrics** – This section provides information about the delivery of the messages that were sent from your campaign\. It includes the following information:
     + **Messages sent** – The number of messages that were sent\.
     + **Messages delivered** – The number of messages that were delivered to their recipients\.
     + **Links clicked** – The number of times that links in the messages were clicked by recipients\. If a single recipient clicks a link more than once, each click is represented in this section\.
     + **Endpoint deliveries** – The average number of endpoints that the campaign was sent to, for each day in the chosen date range\. The chart shows the number of endpoints that the campaign was delivered to, for each day in the chosen date range\.
   + **Delivery rate metrics** – This section shows the overall delivery and response rates for the messages that were sent from your campaign\. It includes the following information:
     + **Delivery rate** – The percentage of messages that were delivered to recipients, of the total number of endpoints that you targeted in the segment that you sent this campaign to\.
     + **Email open rate** – The percentage of messages that were opened by recipients, of the total number of messages that were delivered\.
     + **Bounce rate** – The percentage of messages that weren't delivered to recipients because they bounced\. This value includes only hard bounces—that is, messages that bounced because of a permanent issue\. For example, hard bounces could occur when the recipient's email address doesn't exist, or when the recipient permanently rejects email from your domain\.
   + **Campaign runs** – This section shows information that's specific to each time the campaign ran\. Because you can use Amazon Pinpoint to create recurring campaigns, this section can show information for several campaign runs\. However, if you completed the procedures in this tutorial, this section contains information for only one campaign run because you ran the campaign only once\. This section contains the following metrics, in addition to the metrics that are defined in the preceding sections:
     + **Endpoints targeted** – The number of endpoints that were targeted by the segment that was associated with the campaign run\. This number includes endpoints that were part of the segment, but didn't receive the message\.
     + **Total email opened** – The total number of times that messages sent from the campaign run were opened\. For example, if a message was opened two times by one recipient, both of those opens are counted\.

**Next:** [Next Steps](gettingstarted-next-steps.md)