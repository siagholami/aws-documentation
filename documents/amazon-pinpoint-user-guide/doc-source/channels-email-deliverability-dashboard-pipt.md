# Inbox Placement Tests<a name="channels-email-deliverability-dashboard-pipt"></a>

On the **Inbox placement tests** page of the Deliverability dashboard, you can perform tests that can help you predict how specific messages are handled by over 95 major email providers around the world\. When you perform an inbox placement test, you provide a sample message that contains the content that you plan to send to your customers\. Amazon Pinpoint then sends that message to special email addresses on several major email domains\. After about 24 hours, the test is complete, and you can view the results\.

**Important**  
When you perform an inbox placement test, we send your message to a third party for delivery testing and analysis\. We impose our standard security requirements on this third party, and the contents of your emails are encrypted during transfer\. However, because it isn't necessary to use real data when you perform these tests, we recommend that you avoid sending sensitive, confidential, or personally identifiable information in the messages that you use in these tests\.

Inbox placement tests show you how different email providers handle specific messages\. The test results tell you how many of your messages arrived in test recipients' inboxes on the various email providers\. It also tells you how many messages were sent to recipients' junk mail folders, and how many weren't delivered at all\. Performing inbox placement tests help you identify deliverability problems that could arise as a result of the content of your email\.

Your monthly Deliverability dashboard subscription includes 25 inbox placement tests per month\. You can purchase more tests for an additional fee\. For more information, see [Amazon Pinpoint Pricing](https://aws.amazon.com/pinpoint/pricing/)\.

**To create a new email placement test**

1. In the navigation pane of the Deliverability dashboard, choose **Inbox placement tests**\.

1. Choose **Create a test**\.

1. For **Name**, enter a name that helps you easily identify this specific test\.

1. For **From address**, choose either an **Email address** or a **Domain**, and then specify the email address that you plan to use to send the email\.

1. For **Subject**, enter the subject line for the email\.

1. For **HTML content**, enter the HTML\-formatted content of the message\.

1. Choose **Create**\.

It takes approximately 24 hours for the test to complete\. When the test is finished, complete the following steps to view the results\.

**To view the results of an inbox placement test**

1. In the navigation pane of the Deliverability dashboard, choose **Inbox placement tests**\.

1. Confirm that the value in the **Test status** column is **Complete** for the test that you want to review\. If it is, choose the test, and then choose **View test results**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/channels-email-deliverability-dashboard-pipt-view-results.png)

Each inbox placement test contains two sections: **Deliverability overview** and **ISP overview**\.

The **Deliverability overview** section contains the following information about the message that you sent in the inbox placement test:
+ **Test name** – The name that you provided when you created the test\.
+ **Report ID** – A unique identifier for the test\.
+ **From identity** – The email address that the test email was sent from\.
+ **Subject** – The subject line of the test email\.
+ **Inbox** – The percentage of emails that arrived in test recipients' email inboxes\.
+ **Spam** – The percentage of emails that arrived in test recipients' spam folders\.
+ **Missing** – The percentage of emails that didn't reach the recipient\.
+ **DKIM rate** – The percentage of messages that were verified using DKIM\.
+ **SPF rate** – The percentage of messages that were verified using SPF\.

You can view the contents of the test email by expanding the **View HTML content** section\.

The **ISP overview** section contains a list of over 95 major email providers located in countries around the world\. For each provider, this table includes the following metrics:
+ **Inbox** – The percentage of emails that arrived in test recipients' email inboxes on the provider's domain\.
+ **Spam** – The percentage of emails that arrived in test recipients' spam folders on the provider's domain\.
+ **Missing** – The percentage of emails that didn't reach the recipient\.
+ **SPF** – The percentage of messages that were verified by the provider using SPF\.
+ **DKIM** – The percentage of messages that were verified by the provider using DKIM\.

## Test Results<a name="channels-email-deliverability-dashboard-pipt-results"></a>

Inbox placement tests contain two sections: a **Deliverability overview** and an **ISP Overview**\.

 **Deliverability Overview** 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/channels-email-deliverability-dashboard-pipt-results.png)

This section contains a summary of the inbox placement test\. It includes the following information:
+ **From identity** – The sender email address for the test email\.
+ **Subject** – The subject line of the email\.
+ **Inbox** – The percentage of test messages that arrived in recipients' inboxes\.
+ **Spam** – The percentage of test messages that were sent to recipients' junk mail folders\.
+ **Missing** – The percentage of test messages that weren't delivered to recipients at all\.
+ **DKIM rate** – The percentage of test messages that were authenticated by the recipient's mail providers by using DomainKeys Identified Mail\.
+ **SPF rate** – The percentage of test messages that were authenticated by the recipient's mail provider by using Sender Policy Framework\.

You can also view the body of the email by choosing **View HTML content**\.

 **ISP Overview** 

This section contains a list of all of the email providers that we sent your test message to during the test\. For each provider in this list, we provide the same five metrics shown in the **Deliverability overview** section \(**Inbox**, **Spam**, **Missing**, **SPF**, and **DKIM**\)\.