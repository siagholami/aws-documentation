# Sending email with Amazon SES<a name="send-email"></a>


|  | 
| --- |
| Are you trying to send an email to Amazon\.com to inquire about your account or an order that you placed? If so, see [Contact Us](http://www.amazon.com/gp/help/customer/contact-us/) on the Amazon website\. | 

When you send an email, you are sending it through some type of outbound email server\. That email server might be provided by your Internet service provider \(ISP\), your company's IT department, or you might have set it up yourself\. The email server accepts your email content, formats it to comply with email standards, and then sends the email out over the Internet\. The email may pass through other servers until it eventually reaches a receiver \(an entity, such as an ISP, that receives the email on behalf of the recipient\)\. The receiver then delivers the email to the recipient\. The following diagram illustrates the basic email\-sending process\.

![\[Email-sending process\]](http://docs.aws.amazon.com/ses/latest/DeveloperGuide/images/email_sending_process-diagram.png)

When you use Amazon SES, Amazon SES becomes your outbound email server\. You can also keep your existing email server and configure it to send your outgoing emails through Amazon SES so that you don't have to change any settings in your email clients\. The following diagram shows where Amazon SES fits in to the email sending process\.

![\[Where Amazon SES fits in\]](http://docs.aws.amazon.com/ses/latest/DeveloperGuide/images/where_ses_fits_in-diagram.png)

A sender can generate the email content in different ways\. A sender can create the email by using an email client application, or use a program that automatically generates emails, like an application that sends order confirmations in response to purchase transactions\.

## How do I send emails using Amazon SES?<a name="how-to-use-ses"></a>

There are several ways that you can send an email by using Amazon SES\. You can use the Amazon SES console, the Simple Mail Transfer Protocol \(SMTP\) interface, or you can call the Amazon SES API\.
+ **Amazon SES console—**This method is the quickest way to set up your system and send a couple of test emails, but once you are ready to start your email campaign, you will use the console primarily to monitor your sending activity\. For example, you can quickly view the number of emails that you have sent and the number of bounces and complaints that you have received\.
+ **SMTP Interface—**There are two ways to access Amazon SES through the SMTP interface\. The first way, which requires no coding, is to configure any SMTP\-enabled software to send email through Amazon SES\. For example, you can configure your existing email client or software program to connect to the Amazon SES SMTP endpoint instead of your current outbound email server\.

  The second way is to use an SMTP\-compatible programming language such as Java and access the Amazon SES SMTP interface by using the language's built\-in SMTP functions and data types\. 
+ **Amazon SES API—**You can call the Amazon SES Query API directly through HTTPS, or you can use the [AWS Command Line Interface](https://aws.amazon.com/cli/), the [AWS Tools for Windows PowerShell](https://aws.amazon.com/powershell/), or an [AWS SDK](https://aws.amazon.com/tools/)\. The AWS SDKs wrap the low\-level functionality of the Amazon SES API with higher\-level data types and function calls that take care of the details for you\. The AWS SDKs provide not only Amazon SES operations, but also basic AWS functionality such as request authentication, request retries, and error handling\.

## How do I start?<a name="how-to-start-using-ses"></a>

If you're new to Amazon SES, start by reading the following sections:
+ [Amazon SES Quick start](quick-start.md)—Shows you how to get set up and send a test email as quickly as possible\.
+ [Getting started sending email with Amazon SES](send-email-getting-started.md)—Shows you how to send an email by using the Amazon SES console, the SMTP interface, and an AWS SDK\. Examples are provided in C\#, Java, and PHP\.
+ [Amazon SES and deliverability](send-email-concepts-deliverability.md)—Explains email deliverability concepts that you should be familiar with when you use Amazon SES\.
+ [Amazon SES email\-sending process](send-email-concepts-process.md)—Shows you what happens when you send an email through Amazon SES\.
+ [Email format and Amazon SES](send-email-concepts-email-format.md)—Reviews the format of emails and identifies the information that you need to provide to Amazon SES\.

Then you can learn about sending email with Amazon SES in more detail by reading the sections listed in the following table:


| Section | Description | 
| --- | --- | 
| [Setting up email](send-email-set-up.md) | Shows you how to sign up for AWS, get your AWS access keys, download an AWS SDK, verify email addresses or domains, and move out of the Amazon SES sandbox\. | 
| [Using the SMTP interface](send-email-smtp.md) | Shows you how to get your Amazon SES SMTP credentials, connect to the Amazon SES SMTP endpoint, and provides examples of how to configure email clients and software packages to send email through Amazon SES\. Also explains how to configure your existing email server to send all outgoing emails through Amazon SES\. | 
| [Using the API](send-email-api.md) | Shows you how to send formatted and raw emails by using the Amazon SES API\. Explains how to use non\-standard characters and send attachments by using the Multipurpose Internet Mail Extensions \(MIME\) standard when you send raw emails\. | 
| [Email authentication methods](send-email-authentication.md) | Shows you how to use DKIM with Amazon SES to show ISPs that you own the domain you are sending from\. | 
| [Managing sending quotas](manage-sending-quotas.md) | Describes the Amazon SES sending quotas, provides procedures for increasing them, and documents the errors you receive when you exceed them\. | 
| [Using sending authorization](sending-authorization.md) | Shows you how to authorize other users to send emails from your identities on your behalf\. | 
| [Using dedicated IP addresses](dedicated-ip.md) | * you decide whether to use shared IP addresses or lease dedicated IP addresses for your Amazon SES sending\. Provides procedures for requesting and relinquishing dedicated IPs, and for creating pools of dedicated IPs\.* | 
| [Testing email sending](send-email-simulator.md) | Explains how to use the Amazon SES mailbox simulator to simulate common email scenarios without affecting your sending statistics such as your bounce and complaint metrics\. The scenarios you can test are successful delivery, bounce, complaint, out\-of\-the\-office \(OOTO\), and address on the suppression list\. | 


****  

|  | 
| --- |
| For information and discussions about a variety of topics related to Amazon SES, see the [AWS Messaging and Targeting Blog](https://aws.amazon.com//blogs/messaging-and-targeting/)\. To browse and post questions, go to the [Amazon SES Forum](https://forums.aws.amazon.com/forum.jspa?forumID=90)\. | 