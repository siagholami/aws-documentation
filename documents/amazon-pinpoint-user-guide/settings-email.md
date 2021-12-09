# Email Settings<a name="settings-email"></a>

Use the **Email** settings page to view information about email usage for your Amazon Pinpoint account, such as the number of emails that you've sent during the past 24 hours and whether there are sending restrictions on your account\.

You can also use the **Email** settings page to enable or disable the email channel for the current project\. If you disable the email channel for the project, you can't send email from campaigns or journeys in the project\. However, you can send transactional email from your Amazon Pinpoint account\.

In addition, you can use the **Email** settings page to verify email identities for the current project\. In Amazon Pinpoint, an *identity* is an email address or domain that you use to send email\. Every email address that you want to use as a "From," "Source," "Sender," or "Return\-Path" address in email has to be verified before you can send email with it by using Amazon Pinpoint\.

**Topics**
+ [Viewing Details About Email Usage](#settings-email-usage-details)
+ [Enabling and Disabling the Email Channel](#settings-email-enable)
+ [Verifying Identities](#settings-email-verify-identity)

## Viewing Details About Email Usage<a name="settings-email-usage-details"></a>

The **Email usage and restrictions** section of the **Email** settings page provides information about email usage for your Amazon Pinpoint account\. You can see how many emails have been sent from your account during the past 24 hours\. You can compare that number to the maximum number of emails that your account is allowed to send during a 24\-hour period, referred to as your *sending quota*\. You can also see the maximum number of emails that you can send per second, referred to as your *sending rate*\. For additional detailed reports, see the analytics pages for [Campaigns](analytics-campaigns.md) and [Transactional Messaging](analytics-transactional-messages.md)\.

**Note**  
The email sending quota, rate, and usage values that are shown in this section apply to your entire AWS account in the current AWS Region\. If you've used Amazon SES to send email in the same Region, then this section shows how many email messages you've sent from both Amazon SES and Amazon Pinpoint\.

The **Email usage and restrictions** section also indicates whether your account is in the sandbox\. If your account is in the sandbox, your sending quota and sending rate are set to relatively low values, and you can send email only to verified email addresses or domains\. For information about requesting an increase to your sending quota or sending rate, see [Managing Email Sending Quotas](channels-email-manage-limits.md)\. For information about removing your account from the sandbox, see [Requesting Production Access for Email](channels-email-setup-production-access.md)\.

## Enabling and Disabling the Email Channel<a name="settings-email-enable"></a>

To send email for campaigns and journeys in the current project, you first have to enable the email channel for the project\. If you don't plan to send email for any campaigns or journeys in a project, you can disable the email channel for the project\. 

Note that you don't need to enable the email channel to send transactional email, which is email that is typically sent only once in response to a specific action\. For information about sending transactional email, see [Sending Email in Amazon Pinpoint](channels-mobile-send.md)\.

**To enable the email channel for a project**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to enable the email channel for\.

1. In the navigation pane, under **Settings**, choose **Email**\.

1. On the **Identities** tab, choose **Edit**\.

1. Select **Enable the email channel for this project**\.

1. If you haven't verified an email identity yet, complete the appropriate procedure in the [Verifying Identities](#settings-email-verify-identity) section\. Otherwise, choose the identity that you want to use\.

1. Choose **Save**\.

The process for disabling the email channel is similar\. If you disable the email channel, you can't send email for any campaigns or journeys in the project\. However, you can send transactional email from your Amazon Pinpoint account\.

**To disable the email channel**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to disable the email channel for\.

1. In the navigation pane, under **Settings**, choose **Email**\.

1. On the **Identities** tab, choose **Edit**\.

1. Clear **Enable the email channel for this project**, and then choose **Save**\.

## Verifying Identities<a name="settings-email-verify-identity"></a>

An *identity* is an email address or domain that you use to send email\. Every identity that you use as a “From,” “Source,” “Sender,” or “Return\-Path” address in email has to be verified before you can send email with it by using Amazon Pinpoint\. You can verify as many as 10,000 email addresses or domains, in any combination, in each AWS Region\. If your account is still in the Amazon Pinpoint sandbox, you also need to verify the identities that you plan to send email to\.

### Verifying an Email Address<a name="settings-email-verify-email-address"></a>

If you aren't able to change DNS settings for your domain or you want to send email from an address on a commercial domain, such as *gmail\.com* or *hotmail\.com*, you can verify individual email addresses that you want to use when you send email from a project\.

**To verify an email address**

1. Complete the procedure in the [previous section](#settings-email-enable) to enable the email channel\.

1. Under **Identity type**, choose **Email address**, and then choose **Verify a new email address**\.

1. For **Default sender address**, enter the email address that you want to verify\. The email address must be an address that you can access and is able to receive mail\. 

1. Choose **Verify email address**\.

1. Choose **Save**\.

1. Check the inbox of the address that you entered and look for an email from *no\-reply\-aws@amazon\.com*\. Open the email and click the link in the email to complete the verification process for the email address\.
**Note**  
You should receive the verification email within five minutes\. If you don't receive the email, do the following:  
Make sure you typed the address correctly\.
Make sure the email address that you're attempting to verify can receive email\. You can test this by using another email address to send a test email to the address that you want to verify\.
Check your junk mail folder\.
The link in the verification email expires after 24 hours\. To resend the verification email, choose **Send verification email again** on the **Identities** tab of the **Email** settings page\.

When you verify an email address, consider the following:
+ Amazon Pinpoint has endpoints in multiple AWS Regions and the verification status of an email address is separate for each Region\. If you want to send email from the same identity in more than one Region, you must verify that identity in each Region\. You can verify as many as 10,000 identities \(email addresses and domains, in any combination\) in each AWS Region\.
+ The *local part* of the email address, which is the part that precedes the at sign \(@\), is case sensitive\. For example, if you verify *user@example\.com*, you can't send email from *USER@example\.com* unless you verify that address too\.
+ Domain names are case insensitive\. For example, if you verify *user@example\.com*, you can also send email from *user@EXAMPLE\.com*\.
+ You can apply labels to verified email addresses by adding a plus sign \(\+\) followed by a string of text after the local part of the address and before the at sign \(@\)\. For example, to apply *label1* to the address *user@example\.com*, use *user\+label1@example\.com*\. You can use as many labels as you want for each verified address\. You can also use labels in the "From" and "Return\-Path" fields to implement Variable Envelope Return Path \(VERP\)\. 
**Note**  
When you verify an unlabeled address, you are verifying all addresses that could be formed by adding a label to the address\. However, if you verify a labeled address, you can't use other labels with that address\.

### Verifying a Domain<a name="settings-email-verify-domain"></a>

If you plan to send email from a domain that you own, you should verify that domain, rather than individual email addresses from that domain\. After you verify a domain, you can send email from any address in that domain\. For example, if you verify the *example\.com* domain, you can send email from *carlos@example\.com*, *jane@example\.com*, and any other address in the *example\.com* domain\. You can also send email from any address on any subdomain of the domain\. For example, if you verify the domain *example\.com*, you can send email from *jane@example\.com* and *john@subdomain\.example\.com*\.

**Important**  
To verify a domain, you have to be able to modify the DNS settings for the domain\. The procedures for modifying the DNS settings for a domain vary depending on the DNS or web hosting provider\. For information about changing the DNS settings for your domain, see the documentation for your provider\.

**To verify a domain**

1. Complete the procedure in the [previous section](#settings-email-enable) to enable the email channel\.

1. Under **Identity type**, choose **Domain**, and then choose **Verify a new domain**\.

1. For **Domain**, enter the name of the domain that you want to verify\.

1. For **Default sender address**, enter the email address that you want to use by default when you send email from this domain\. When you send email, you can specify a different address\. However, if you don't specify a different address for specific email, Amazon Pinpoint sends the email from this default address\.

1. Choose **Verify domain**\.

1. Under **DNS records for domain verification**, copy the three CNAME records and save them to a location on your computer\. Or, to download and save the records in a \.csv file, choose **Download record set**\.

1. Log in to the management console for your DNS provider, and then create three new CNAME records that contain the values that you saved in the previous step\. See the next section for links to the documentation for several major providers\.

   It usually takes 24–48 hours for changes to DNS settings to propagate\. As soon as Amazon Pinpoint detects all three of these CNAME records in the DNS configuration of your domain, the verification process is complete\. You can’t send email from a domain until the verification process is complete\.

When you verify a domain, consider the following:
+ You can send email from any subdomain of the verified domain without verifying the subdomain specifically\. For example, if you verify *example\.com*, you don't need to verify *a\.example\.com* or *a\.b\.example\.com*\. 
+ As specified in [RFC 1034](https://tools.ietf.org/html/rfc1034), each DNS label can have up to 63 characters\. In addition, the whole domain name must not exceed a total length of 255 characters\.
+ Amazon Pinpoint has endpoints in multiple AWS Regions and the verification status of a domain is separate for each Region\. If you want to send email from the same identity in more than one Region, you must verify that identity in each Region\. You can verify as many as 10,000 identities \(domains and email addresses, in any combination\) in each AWS Region\.

#### Instructions for Configuring DNS Records for Various Providers<a name="settings-email-verify-domain-providers"></a>

The procedures for updating the DNS records for a domain vary depending on which DNS or web hosting provider you use\. The following table lists links to the documentation for several common providers\. This list isn't exhaustive and inclusion in this list isn’t an endorsement or recommendation of any company’s products or services\. If your provider isn't listed in the table, you can probably use the domain with Amazon Pinpoint\.


| DNS/Hosting Provider | Documentation Link | 
| --- | --- | 
|  Amazon Route 53  |  [Creating Records by Using the Amazon Route 53 Console](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/resource-record-sets-creating.html)  | 
|  GoDaddy  |  [Add a CNAME record](https://www.godaddy.com/help/add-a-cname-record-19236)  | 
|  Dreamhost  |  [How do I add custom DNS records?](https://help.dreamhost.com/hc/en-us/articles/215414867-How-do-I-add-custom-DNS-records-)  | 
|  Cloudflare  |  [Managing DNS records in Cloudflare](https://support.cloudflare.com/hc/en-us/articles/360019093151)  | 
|  HostGator  |  [Manage DNS Records with HostGator/eNom](https://support.hostgator.com/articles/hosting-guide/lets-get-started/dns-name-servers/manage-dns-records-with-hostgatorenom)  | 
|  Namecheap  |  [How do I add TXT/SPF/DKIM/DMARC records for my domain? ](https://www.namecheap.com/support/knowledgebase/article.aspx/317/2237/how-do-i-add-txtspfdkimdmarc-records-for-my-domain)  | 
|  Names\.co\.uk  |  [Changing your domains DNS Settings](https://www.names.co.uk/support/1156-changing_your_domains_dns_settings.html)  | 
|  Wix  |  [Adding or Updating CNAME Records in Your Wix Account](https://support.wix.com/en/article/adding-or-updating-cname-records-in-your-wix-account)  | 

#### Domain Verification Tips and Troubleshooting<a name="settings-email-verify-domain-troubleshooting"></a>

If you completed the preceding steps but your domain still isn’t verified after 72 hours, check the following:
+ Make sure that you entered the values for the DNS records in the correct fields\. Some providers refer to the **Name/host** field as *Host* or *Hostname*\. In addition, some providers refer to the **Record value** field as *Points to* or *Result*\.
+ Make sure that your provider didn’t automatically append your domain name to the **Name/host** value that you entered in the DNS record\. Some providers append the domain name without indicating that they’ve done so\. If your provider appended your domain name to the **Name/host** value, remove the domain name from the end of the value\. You can also try adding a period to the end of the value in the DNS record\. This period indicates to the provider that the domain name is fully qualified\.
+ The underscore character \(\_\) is required in the **Name/host** value of each DNS record\. If your provider doesn't allow underscores in DNS record names, contact the provider's customer support department for additional assistance\.
+ The validation records that you have to add to the DNS configuration for your domain are different for each AWS Region\. If you want to use a domain to send email from multiple AWS Regions, you have to verify the domain in each of those Regions\.