# DNS Blackhole List \(DNSBL\) FAQs<a name="faqs-dnsbls"></a>

*Domain Name System\-based Blackhole Lists* \(*DNSBLs*\)—sometimes referred to as *Realtime Blackhole Lists* \(*RBLs*\), *deny lists*, *blocklists*, or *blacklists*—are intended to inform email providers of IP addresses that are suspected of sending unwanted email\.

Different DNSBLs have different impacts on email deliverability\. This topic describes how DNSBLs impact the delivery of emails you send using Amazon SES, as well as our policies for removing Amazon SES IP addresses from DNSBLs\.

**Note**  
This topic is about the DNSBLs that email providers use to block incoming messages\. For information about how Amazon SES blocks outgoing email sent to recipients whose email addresses have previously generated bounces, see [Using the Amazon SES global suppression list](sending-email-global-suppression-list.md)\.

## Q1\. How do DNSBLs impact email delivery?<a name="bl-q1"></a>

Different DNSBLs have different impacts on the successful delivery of a message\. Major email providers—including Gmail, Hotmail, AOL, and Yahoo—seem to recognize a very small number of highly regarded DNSBLs, such as those offered by Spamhaus\. In our experience, other DNSBLs tend to have a low impact, although some mail systems emphasize certain DNSBLs over others\.

Finally, many email providers have their own internal deny lists\. Email providers guard these lists very closely, and rarely share them with the public\. If an IP address is on one of these lists, it can have a major impact on your ability to send email to recipients who use that provider\.

## Q2\. How do IP addresses end up on DNSBLs?<a name="bl-q2"></a>

There are several ways that an IP address can end up on a DNSBL\. IP addresses can be added to DNSBLs when they send email to a *spamtrap*\. A spamtrap is an email address that doesn't belong to a human user\. Spamtraps exist solely to collect spam and identify spammers\. Some DNSBLs also allow individual users to submit IP addresses\. A few DNSBLs even allow users to submit entire IP address ranges\. Other DNSBLs are maintained through contributions by email administrators, and can include IP addresses that administrators believe are abusing their own systems\.

## Q3\. How does Amazon SES prevent its IP addresses from appearing on DNSBLs?<a name="bl-q3"></a>

Our systems look for signs of abuse\. If we detect sending patterns or other characteristics that could lead to an IP address being added to a DNSBL, we send a notification to the sender\. If the situation is severe, or if the sender doesn't fix the issue after we send the notification, we'll pause the sender's ability to send email until they resolve the issue\. Enforcing our sending policies in this way helps reduce the chances that our IP addresses end up on DNSBLs\.

## Q4\. Can Amazon SES have its IP addresses removed from a DNSBL?<a name="bl-q4"></a>

We actively monitor DNSBLs that could impact delivery across the entire Amazon SES service, or that could impact the ability to send email to recipients who use major email providers, such as Gmail, Yahoo, AOL, and Hotmail\. The DNSBLs offered by Spamhaus fall into this category\. When one of our IP addresses appears on a list that meets either of these criteria, we take immediate action to have that address removed from the DNSBL as quickly as possible\.

We don't monitor DNSBLs that are unlikely to impact delivery across the entire Amazon SES service, or that don't have a measurable impact on delivery to major email providers\. The DNSBLs offered by SORBS and UCEPROTECT fall into this category\. Because of the specific listing and delisting practices of the vendors who operate these lists, we are unable to have our IP addresses removed from these lists\.

## Q5\. An email provider is rejecting my email because the sending IP address is listed by a DNSBL other than Spamhaus\. What can I do?<a name="bl-q5"></a>

First, confirm that the message was truly blocked because of a DNSBL\. If your email was rejected because the sending IP address was added to a DNSBL, you'll receive a bounce notification that mentions the DNSBL provider by name, as in the following example:

```
554 5.7.1 Service unavailable; Client host [192.0.2.0] blocked using DNSBLName; See: http://www.example.com/query/ip/192.0.2.0
```

If you received a bounce notification, but it didn't contain information similar to the message shown in the preceding example, then the email provider most likely rejected your message for a reason unrelated to being added to a DNSBL\.

If you can confirm that an email provider is blocking your email because the sending IP address is on a DNSBL, there are a few things you can do:
+ Contact the postmaster of the domain that rejected your message to request an exception from their spam filtering policy\. Some postmasters have support processes, and may publish a postmaster page that describes this process\. If the domain you're trying to contact doesn't publish its postmaster support policies, you might be able to contact the postmaster by sending email to *postmaster@**example\.com*, where *example\.com* is the domain in question\. Domains are required by [RFC 5321](https://tools.ietf.org/html/rfc5321) to have a postmaster mailbox\. 

  When you contact the postmaster, provide the bounce codes you received, the headers of the email you're trying to send, a measurement of the impact the DNSBL is having on the delivery of your email, and information about why you believe that your email is being improperly blocked\. The more information you can provide to the postmaster to demonstrate that you're sending legitimate email, the more likely the postmaster is to make an exception for you\.
+ If the email provider doesn't respond, or is unwilling to change their policies, consider using a [dedicated IP address](dedicated-ip.md)\. Dedicated IP addresses are addresses that only you can use\. By implementing good sending practices, you can keep your engagement rates high, and your rates of bounces, complaints, and spamtrap hits low\. Good sending practices can help ensure that your addresses don't end up on DNSBLs\.

## Q6\. Email that I send to Gmail, Yahoo, Hotmail, or another major provider is being sent to the spam folder\. Is this happening because my sending IP address is on a DNSBL?<a name="bl-q6"></a>

Probably not\. If an IP address is listed by a DNSBL with significant impact, such as one of the DNSBLs from Spamhaus, major email providers will reject email from that IP address completely, rather than sending it to the spam folder\.

When major email providers accept an email \(rather than rejecting it\), they usually consider *user engagement* when considering whether to place the message in the inbox or in the spam folder\. *User engagement* refers to the ways in which users interacted with the messages you sent them previously\.

To increase the chances that your messages reach your customers' inboxes, you should implement all of the following best practices:
+ **Never** rent or purchase lists of email addresses\. Renting or purchasing lists is a violation of the [AWS Acceptable Use Policy](https://aws.amazon.com/aup) \(AUP\) and isn't allowed on Amazon SES under any circumstances\.
+ Only send email to customers who explicitly asked to receive email from you\. In many countries and jurisdictions around the world, it's illegal to send email to recipients who didn't explicitly agree to receive email from you\. 
+ Stop sending email to customers who haven't opened or clicked links in messages that you've sent in the past 30–90 days\. This step can help to keep your engagement rates high, which increases the chances that the messages you send in the future arrive in recipients' inboxes\.
+ Use consistent design elements and writing styles in each message that you send to ensure that customers can easily identify messages from you\.
+ Use email authentication mechanisms, such as [SPF](send-email-authentication-spf.md) and [DKIM](send-email-authentication-dkim.md)\.
+ When customers use a web form to subscribe to your content, send them an email to confirm that they want to receive email from you\. Don't send them any additional email until they confirm that they want to receive email from you\. This process is known as *confirmed opt\-in* or *double opt\-in*\.
+ Make it easy for your customers to unsubscribe, and honor unsubscribe requests immediately\.
+ If you send email that contains links, check those links against the Spamhaus Domain Block List \(DBL\)\. To test your links, use the [Domain Lookup Tool](https://www.spamhaus.org/lookup/) on the Spamhaus website\.

By implementing these practices, you can improve your sender reputation, which increases the likelihood that the email you send reaches recipients' inboxes\. Implementing these practices also helps keep the bounce and complaint rates low for your account, and reduces the risk of sending email to spamtraps\.