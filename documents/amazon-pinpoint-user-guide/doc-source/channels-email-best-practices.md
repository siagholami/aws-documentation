# Tips and Best Practices<a name="channels-email-best-practices"></a>

Even when you have your customers' best interests in mind, you may still encounter situations that impact the deliverability of your messages\. The following sections contain recommendations to help ensure that your email communications reach your intended audience\.

## General Recommendations<a name="channels-email-best-practices-general"></a>
+ Put yourself in your customer's shoes\. Ask yourself if the message you're sending is something you would want to receive in your own inbox\. If the answer is anything less than an enthusiastic "yes\!" then you probably shouldn't send it\.
+ Some industries have a reputation for poor quality or even malicious email practices\. If you're involved in the following industries, you must monitor your reputation very closely and resolve issues immediately:
  + Home mortgage
  + Credit
  + Pharmaceuticals and supplements
  + Alcohol and tobacco
  + Adult entertainment
  + Casinos and gambling
  + Work\-from\-home programs

## Domain and "From" Address Considerations<a name="channels-email-best-practices-domain-from"></a>
+ Think carefully about the addresses you send email from\. The "From" address is one of the first pieces of information your recipients see, and therefore can leave a lasting first impression\. Additionally, some ISPs associate your reputation with your "From" address\.
+ Consider using subdomains for different types of communications\. For example, assume you're sending email from the domain *example\.com*, and you plan to send both marketing and transactional messages\. Rather than sending all of your messages from *example\.com*, send your marketing messages from a subdomain such as *marketing\.example\.com*, and your transactional messages from a subdomain such as *orders\.example\.com*\. Unique subdomains develop their own reputations\. Using subdomains reduces the risk of damage to your reputation if, for example, your marketing communications land in a spam trap or trigger a content filter\.
+ If you plan to send a large number of messages, don't send those messages from an ISP\-based address such as *sender@hotmail\.com*\. If an ISP notices a large volume of messages coming from *sender@hotmail\.com*, that email is treated differently than an email that comes from an outbound email sending domain that you own\.
+ Work with your domain registrar to ensure that the WHOIS information for your domain is accurate\. Maintaining an honest and up\-to\-date WHOIS record demonstrates that you value transparency, and allows users to quickly identify whether or not your domain is legitimate\.
+ Avoid using a no\-reply address, such as no\-reply@example\.com, as your "From" or "Reply\-to" address\. Using a *no\-reply@* email address sends your recipients a clear message: that you aren't offering them a way to contact you, and that you're not interested in their feedback\.

## Building and Maintaining Your Lists<a name="channels-email-best-practices-lists"></a>
+ Implement a double opt\-in strategy\. When users sign up to receive email from you, send them a message with a confirmation link, and don't start sending them email until they confirm their address by clicking that link\. A double opt\-in strategy helps reduce the number of hard bounces resulting from typographical errors\.
+ When collecting email addresses with a web\-based form, perform minimal validation on those addresses upon submission\. For example, ensure that the addresses you collect are well\-formed \(that is, they are in the format recipient@example\.com\), and that they refer to domains with valid MX records\.
+ Use caution when allowing user\-defined input to be passed to Amazon SES unchecked\. Forums registrations and form submissions present unique risks because the content is completely user\-generated, and spammers can fill out forms with their own content\. It's your responsibility to ensure that you only send email with high\-quality content\.
+ It's highly unlikely that a standard alias \(such as *postmaster@*, *abuse@*, or *noc@*\) will ever sign up for your email intentionally\. Ensure that you only send messages to real people who actually want to receive them\. This rule is especially true for standard aliases, which are customarily reserved for email watchdogs\.

## Compliance<a name="channels-email-best-practices-compliance"></a>
+ Be aware of the email marketing and anti\-spam laws and regulations in the countries and regions you send email to\. You're responsible for ensuring that the email you send complies with these laws\. This guide doesn't cover these laws, so it's important that you research them\. For a list of laws, see [Email Spam Legislation by Country](https://en.wikipedia.org/wiki/Email_spam_legislation_by_country) on Wikipedia\.
+ Always consult an attorney to obtain legal advice\.

## Bounces<a name="channels-email-best-practices-bounce-rate"></a>

A *bounce* occurs when an email can't be delivered to the intended recipient\. There are two types of bounces: *hard bounces* and *soft bounces*\. A hard bounce occurs when the email can't be delivered because of a persistent issue, such as when an email address doesn't exist\. A soft bounce occurs when a temporary issue prevents the delivery of an email\. Soft bounces can occur when a recipient's inbox is full, or when the receiving server is temporarily unavailable\. Amazon Pinpoint handles soft bounces by attempting to re\-deliver soft bounced emails for a certain period of time\.

It's essential that you monitor the number of hard bounces in your email program, and that you remove hard\-bouncing email addresses from your recipient lists\. When email receivers detect a high rate of hard bounces, they assume that you don't know your recipients well\. As a result, a high hard bounce rate can negatively impact the deliverability of your email messages\.

The following guidelines can help you avoid bounces and improve your sender reputation:
+ Try to keep your hard bounce rate below 5%\. The fewer hard bounces in your email program, the more likely ISPs will see your messages as legitimate and valuable\. This rate should be considered a reasonable and attainable goal, but isn't a universal rule across all ISPs\.
+ Never rent or buy email lists\. These lists may contain large numbers of invalid addresses, which could cause your hard bounce rates to increase dramatically\. Furthermore, these lists could contain spam traps—email addresses specifically used to catch illegitimate senders\. If your messages land in a spam trap, your delivery rates and sender reputation could be irrevocably damaged\.
+ Keep your list up to date\. If you haven't emailed your recipients in a long time, try to validate your customers' statuses through some other means \(such as website login activity or purchase history\)\.
+ If you don't have a method of verifying your customers' statuses, consider sending a *win\-back* email\. A typical win\-back email mentions that you haven't heard from the customer in a while, and encourages the customer to confirm that they still want to receive your email\. After sending a win\-back email, purge all of the recipients who did not respond from your lists\.

When you receive bounces, it's vital that you respond to them appropriately by observing the following rules:
+ If an email address hard bounces, immediately remove that address from your lists\. Don't attempt to re\-send messages to hard\-bouncing addresses\. Repeated hard bounces add up, and ultimately harm your reputation with the recipient's ISP\.
+ Make sure that the address you use to receive bounce notifications is able to receive email\. 
+ If your inbound email comes to you from an ISP, instead of through your own internal servers, an influx of bounce notifications can land in your spam folder or be dropped completely\. Ideally, you shouldn't use a hosted email address to receive bounces\. If you must, however, then check the spam folder often, and don't mark the bounce messages as spam\. In Amazon Pinpoint, you can specify the address that bounce notifications are sent to\.
+ Usually, a bounce provides the address of the mailbox refusing delivery\. However, if you need more granular data to map a recipient address to a particular email campaign, include an X\-header with a value you can trace back to your internal tracking system\. 

## Complaints<a name="channels-email-best-practices-complaints"></a>

A complaint occurs when an email recipient clicks the "Mark as Spam" \(or equivalent\) button in their web\-based email client\. If you accumulate a large number of these complaints, the ISP assumes that you are sending spam\. This has a negative impact on your deliverability rate and sender reputation\. Some, but not all, ISPs will notify you when a complaint is reported; this is known as a *feedback loop*\. Amazon Pinpoint automatically forwards complaints from ISPs that offer feedback loops to you\.

The following guidelines can help you avoid complaints and improve your sender reputation:
+ Try to keep your complaint rate below 0\.1%\. The fewer complaints in your email program, the more likely ISPs will see your messages as legitimate and valuable\. This rate should be considered a reasonable and attainable goal, but isn't a universal rule across all ISPs\.
+ If a customer complains about a marketing email, you should immediately stop sending that customer marketing emails\. However, if your email program also includes other types of emails \(such as notification or transactional emails\), it may be acceptable to continue to send those types of messages to the recipient who issued the complaint\.
+ As with hard bounces, if you have a list that you haven't sent email to in a while, ensure that your recipients understand why they're receiving your messages\. We recommend that you send a welcome message reminding them of who you are and why you're contacting them\.

When you receive complaints, it's vital that you respond to them appropriately by observing the following rules:
+ Make sure that the address you use to receive complaint notifications is able to receive email\. 
+ Make sure that your complaint notifications aren't being marked as spam by your ISP or mail system\.
+ Complaint notifications usually contain the body of the email; this is different from bounce notifications, which only include the email headers\. However, in complaint notifications, the email address of the individual who issued the complaint is removed\. Use custom X\-headers or special identifiers embedded in the email body so that you can identify the email address that issued the complaint\. This technique makes it easier to identify addresses that complained so that you can remove them from your recipient lists\.

## Message Quality<a name="channels-email-best-practices-quality"></a>

Email receivers use *content filters* to detect certain characteristics of messages and determine whether a message is legitimate\. These content filters automatically review the content of messages to identify common traits of unwanted to malicious messages\. Amazon Pinpoint uses content filtering technologies to help detect and block messages that contain malware before they are sent\.

If an email receiver's content filters determine that your message has characteristics of spam or malicious email, your message will most likely be flagged and diverted from recipients' inboxes\.

Remember the following when designing your email:
+ Modern content filters are intelligent, continuously adapting and changing\. They don't rely on a predefined set of rules\. Third\-party services such as [ReturnPath](https://returnpath.com/) or [Litmus](https://litmus.com/) can help identify content in your email that may trigger content filters\.
+ If your email contains links, check the URLs for those links against blacklists, such as those found at [URIBL\.com](http://uribl.com/) and [SURBL\.org](http://www.surbl.org/)\.
+ Avoid using link shorteners\. Malicious senders may use link shorteners to hide the actual destination of a link\. When ISPs notice that link shortening services—even the most reputable ones—are being used for nefarious purposes, they may blacklist those services altogether\. If your email contains a link to a blacklisted link shortening service, it won't reach your customers' inboxes, and the success of your email campaign suffers\.
+ Test every link in your email to ensure that it points to the intended page\.
+ Make sure your website includes Privacy Policy and Terms of Use documents, and that these documents are up to date\. It's a good practice to link to these documents from each email you send\. Providing links to these documents demonstrates that you have nothing to hide from your customers, which can help build a relationship of trust\.
+ If you plan to send high\-frequency content \(such as "daily deals" messages\), ensure that the content of your email is different with each deployment\. When you send messages with high frequency, you must ensure that those messages are timely and relevant, rather than repetitive and annoying\.