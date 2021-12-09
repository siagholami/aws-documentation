# Campaign Delivery Metrics<a name="channels-email-deliverability-dashboard-campaign-delivery"></a>

The **Campaign delivery metrics** section contains information about inbox placement rates for the email that you sent from your domains\. However, unlike the [Domain reputation](channels-email-deliverability-dashboard-domain.md) page, the **Campaign delivery metrics** page contains information about specific email campaigns, as opposed to information for entire domains\.

When you choose a domain and a date range, you see a table that contains the following information:
+ **Preview** – A small image that shows the content of the email\. Pause on the image to see a larger preview\.
+ **Last send date** – The date and time when the message was last sent\.
+ **Subject** – The subject line of the email\.
+ **Sender address** – The sender \("From"\) address for the message\.
+ **ESP** – The email provider \(such as Gmail or Yahoo\) that the metrics apply to\.
+ **Inbox rate** – The percentage of emails sent from the campaign that arrived in recipients' inboxes \(as opposed to their junk mail folders\)\.
+ **Open rate** – The percentage of emails sent from the campaign that were opened by their recipients\.

When you choose a campaign in this table, you see a details page for the campaign\. Campaign details pages contain two sections: **Details** and **Sending IP addresses**\.

## Details<a name="channels-email-deliverability-dashboard-campaign-delivery-details"></a>

This section contains the following information about the campaign:
+ **Latest sent date** – The date and time when the message was last sent\.
+ **First sent date** – The date and time when the message was first sent\.
+ **Subject** – The subject line of the email\.
+ **Sender address** – The sender \("From"\) address for the message\.
+ **Sender domain** – The domain that the message was sent from\.
+ **ESP** – The email provider \(such as Gmail or Yahoo\) that the metrics apply to\.
+ **Estimated volume** – The approximate number of recipients that were sent this campaign\.
+ **Inbox placement** – The percentage of emails sent from the campaign that arrived in recipients' inboxes \(as opposed to their junk mail folders\)\.
+ **Spam placement** – The percentage of emails sent from the campaign that arrived in recipients' junk mail folders\.
+ **Read** – The percentage of emails that were opened by their recipients\.
+ **Read and deleted** – The percentage of emails that were opened by their recipients and then deleted\.
+ **Deleted** – The percentage of emails that were deleted by their recipients without being read\.

The campaign details page also includes a larger preview of body of the email\. Amazon Pinpoint automatically removes identifying information from this preview image\.

## Sending IP Addresses<a name="channels-email-deliverability-dashboard-campaign-delivery-sending-ip"></a>

This section lists all the IP addresses that Amazon Pinpoint and Amazon SES used when sending the selected message to your recipients\.