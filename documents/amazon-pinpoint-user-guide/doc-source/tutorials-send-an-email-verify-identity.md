# Step 2: Verify an Identity<a name="tutorials-send-an-email-verify-identity"></a>

In Amazon Pinpoint, an *identity* is an email address or domain that you use to send email\. Before you can send email using Amazon Pinpoint, you must verify each identity that you plan to send email from to prove that you own it\. When you verify an identity, you can choose to verify a [single email address](#tutorials-send-an-email-verify-identity-email) or an [entire domain](#tutorials-send-an-email-verify-identity-domain)\.

## Verifying a Single Email Address<a name="tutorials-send-an-email-verify-identity-email"></a>

When you verify an email address, you can use that specific address to send email from Amazon Pinpoint\. Verifying an email address is the fastest and easiest way to verify an identity for sending email in Amazon Pinpoint\. Additionally, if you want to send email from an address on a domain that you don't own, such as a domain that belongs to a commercial email provider, the only way to verify your identity is to verify an email address\. 

**To verify an email address**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the list of projects, choose the project that you created in the preceding section\.

1. In the navigation pane, choose **Settings**\.

1. On the **Channels** tab, under **Choose the channels to enable**, choose **Email**\.

1. Choose **Enable email channel**, and then choose **Email address**\.

1. For **Email address**, type the email address that you want to verify, and then choose **Verify**\.

1. Check the inbox for the email address that you submitted in the previous step\. Open the email from *no\-reply\-aws@amazon\.com* with the following subject: "Amazon Web Services – Email Address Verification Request in region *regionName*\."

   Choose the link in the email to verify your email address\.

## Verifying an Entire Domain<a name="tutorials-send-an-email-verify-identity-domain"></a>

When you verify an entire domain, you can send email from any address on that domain\. Verifying a domain is helpful when, for example, you want to use one email address as the sender and another address on the same domain as the Return\-Path address\.

Verifying a domain is more complicated than verifying an email address, because you need to be able to modify the DNS records for your domain\. If you aren't able to modify the DNS records for your domain, or you're not comfortable doing so, consider verifying an email address instead\.

The procedures for adding a TXT record to the DNS settings for your domain vary depending on who provides the DNS services for your domain\. If you use Amazon Route 53, see [Creating Records by Using the Amazon Route 53 Console](http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/resource-record-sets-creating.html) in the *Amazon Route 53 Developer Guide*\. If you use another DNS provider, see that provider's documentation for more information about adding TXT records to your DNS configuration\.

**To verify a domain**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the list of projects, choose the project that you created in the preceding section\.

1. In the navigation pane, choose **Settings**\.

1. On the **Channels** tab, under **Choose the channels to enable**, choose **Email**\.

1. Choose **Enable email channel**, and then choose **Email domain**\.

1. For **Email domain**, type the email domain that you want to verify, and then choose **Verify**\.

1. In the **Email domain verification** dialog box, copy the entire TXT record that's displayed, including the **Name**, **Type**, and **Value**\. When you finish, choose **Close**\.

1. Under **Default from address**, type the email address that you plan to send email from most often\. You can change this value later\. Choose **Save**\.

1. In the DNS settings for your domain, add the TXT record that you copied in step 7\. Amazon Pinpoint checks the DNS records for your domain periodically\. When your domain is successfully verified, Amazon Pinpoint sends you a notification by email\.
**Note**  
The procedures for updating your domain's DNS record vary depending on your domain provider\. See your domain provider's documentation for more information about updating the DNS records for your domain\.

**Next:** [Upload Contacts »](tutorials-send-an-email-upload-contacts.md)