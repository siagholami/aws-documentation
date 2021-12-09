# Step 1: Create a New Amazon Pinpoint Project<a name="tutorials-send-an-email-new-project"></a>

Before you can send email using Amazon Pinpoint, you first have to create a project\. A *project* is a collection of settings, segments, campaigns, and analytics for a specific set of customer engagements\.

Part of creating an email campaign involves verifying an identity\. In Amazon Pinpoint, an *identity* is an email address or domain that you use to send email\. Before you can send email using Amazon Pinpoint, you must verify each identity that you plan to use as a "From", "Source", "Sender", or "Return\-Path" address to prove that you own it\. If your account is still in the Amazon Pinpoint sandbox, you also need to verify the identities that you plan to send emails to\.

The procedure in this section shows you how to create a new email project by using the Amazon Pinpoint console\.

**To create a new Amazon Pinpoint project and verify an email address**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose **Create a project**\.

1. For **Project name**, enter a name, and then choose **Create**\.
**Note**  
The project name can contain up to 64 alphanumeric characters\. It can also include the following characters: comma \(,\), period \(\.\), at sign \(@\), underscore \(\_\), equals sign \(=\), and plus sign \(\+\)\.

1. Under **Messaging channels**, next to **Email**, choose **Configure**\.

1. For **Email address**, enter the email address that you want to verify, and then choose **Verify**\. Amazon Pinpoint sends an email to the address you specified\. Open the email, and then click the link in the message to verify your email address\.

**Next:** [Upload a List of Segment Members to Amazon S3 »](tutorials-send-an-email-upload-contacts.md)