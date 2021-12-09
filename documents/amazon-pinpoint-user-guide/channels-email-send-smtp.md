# Sending Email by Using the Amazon Pinpoint SMTP Interface<a name="channels-email-send-smtp"></a>

The Amazon Pinpoint SMTP interface allows you to send email by using any application or library that can use the SMTP protocol to send email\.

For example, you can use common programming libraries, such as the `System.Net.Mail` library in \.NET or the `smtplib` library in Python, to send email using the SMTP interface\. This solution is useful in situations where you want to be able to send email from an application, but you don't want to integrate an AWS SDK into your app\.

You can also configure email server applications, such as Postfix or Sendmail, to send email through the Amazon Pinpoint SMTP interface\. This solution can be useful if you want to use your existing email server, but you also want to use the features of Amazon Pinpoint, such as bounce and complaint event publishing or the analytics charts in the Amazon Pinpoint console\.

You might also be able to configure desktop email applications, such as Mozilla Thunderbird, to send email using the Amazon Pinpoint SMTP interface\. However, this solution is only useful in certain situations, because most email clients require you to set up an incoming mail server, which Amazon Pinpoint doesn't offer\. See the documentation for your email client to determine if it requires you to enter the address of an incoming mail server, also referred to as an *IMAP server*\.

## Obtaining SMTP Credentials<a name="channels-email-send-smtp-credentials"></a>

To send email using the SMTP interface, you need to create a set of SMTP credentials\. These credentials are the user name and password that you use to connect to an Amazon Pinpoint SMTP endpoint\. You can quickly create these credentials by using the Amazon SES console\.

**To create SMTP credentials**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose any project\.

1. In the navigation pane, under **Settings**, choose **Email**\.

1. On the **Sending methods** tab, choose **Send email by using the SMTP interface**\.

1. Under **SMTP credentials**, choose **Generate SMTP credentials**\.

1. For **IAM User Name**, enter the user name for the SMTP user, or use the default name\. Choose **Create**\.

1. Choose **Show User SMTP Security Credentials**\. Copy the SMTP Username and SMTP Password and save it on your computer\. Alternatively, choose **Download Credentials** to download the user name and password to your computer\.
**Note**  
This is the only opportunity that you'll have to view these credentials\. If you close this page without saving these credentials, you have to use the IAM console to delete the SMTP user, and then repeat steps 1–7 above\.

1. When you finish, choose **Close**\.

## Connecting to the SMTP Interface<a name="channels-email-send-smtp-endpoints"></a>

To send email using the SMTP interface, you have to connect your application to an SMTP endpoint\. You can use the endpoints shown in the following table to send email\.


| Region Name | SMTP Endpoint | 
| --- | --- | 
| US East \(N\. Virginia\) | email\-smtp\.us\-east\-1\.amazonaws\.com | 
| US West \(Oregon\) | email\-smtp\.us\-west\-2\.amazonaws\.com | 
| Asia Pacific \(Mumbai\) | email\-smtp\.ap\-south\-1\.amazonaws\.com | 
| Asia Pacific \(Sydney\) | email\-smtp\.ap\-southeast\-2\.amazonaws\.com  | 
| Europe \(Frankfurt\) | email\-smtp\.eu\-central\-1\.amazonaws\.com | 
| Europe \(Ireland\) | email\-smtp\.eu\-west\-1\.amazonaws\.com | 

The Amazon Pinpoint SMTP endpoint requires all connections to be encrypted using Transport Layer Security \(TLS\)\. Amazon Pinpoint supports two mechanisms for establishing a TLS\-encrypted connection: STARTTLS and TLS Wrapper\. Check the documentation for your software to determine whether it supports STARTTLS, TLS Wrapper, or both\.

If you use STARTTLS authentication, you can connect to the Amazon Pinpoint SMTP interface on port 25, 587, or 2587\. If you use TLS Wrapper authentication, you can connect to the Amazon Pinpoint SMTP interface on port 465 or 2465\.

When you connect your application or library to the SMTP interface, use the SMTP user name and password that you created in [Obtaining SMTP Credentials](#channels-email-send-smtp-credentials)\.