# Managing email flows<a name="email-flows"></a>

Set up *email flow rules* to handle email flows based on email addresses or domains\. Email flow rules are based on both the sender's and recipient's email addresses or domains\.

To create an email flow rule, specify a [*rule action*](#email-flows-rule-actions) to apply to an email when a specified [*pattern*](#email-flows-patterns) is matched\.

**Topics**
+ [Inbound email rule actions](#email-flows-rule-actions)
+ [Outbound email rule actions](#email-flows-rule-outbound)
+ [Sender and recipient patterns](#email-flows-patterns)
+ [Creating an email flow rule](create-email-rules.md)
+ [Configuring SMTP gateways](smtp-gateway.md)
+ [Configuring AWS Lambda for Amazon WorkMail](lambda.md)
+ [Retrieving message content with AWS Lambda](lambda-content.md)
+ [Testing an email flow rule](test-email-flow-rule.md)
+ [Modifying an email flow rule](modify-email-flow-rule.md)
+ [Removing an email flow rule](remove-email-flow-rule.md)

## Inbound email rule actions<a name="email-flows-rule-actions"></a>

Inbound email flow rules help prevent undesirable email from reaching your users' mailboxes\. You can use these rules with an AWS Lambda function to process incoming email before it is delivered to your users' mailboxes\. For more information about using Lambda with Amazon WorkMail, see [Configuring Lambda for Amazon WorkMail](lambda.md)\. For more information about Lambda, see the [https://docs.aws.amazon.com/lambda/latest/dg/welcome.html](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html)\.

Inbound email flow rules, also called rule actions, automatically apply to all email messages sent to anyone inside of the Amazon WorkMail organization\. This differs from email rules for individual mailboxes\.

The following rule actions define how inbound email is handled\. For each rule, you specify [sender and recipient patterns](#email-flows-patterns) together with one of the following actions\. 


****  

| Action | Description | 
| --- | --- | 
|  Drop email  |  The email message is ignored\. It is not delivered, and the sender is not notified of the non\-delivery\.  | 
|  Send bounce response  |  The email message is not delivered, and the sender is notified of the non\-delivery in a bounce message\.  | 
| Deliver to junk folder |  The email message is delivered to users' spam or junk folders, even if it is not originally identified as spam by the Amazon WorkMail spam detection system\.   | 
|  Default  |  The email message is delivered after being checked by the Amazon WorkMail spam detection system\. Spam email is delivered to the junk folder\. All other email messges are delivered to the inbox\. Other email flow rules with a less specific sender pattern are ignored\. To add exceptions to domain\-based email flow rules, configure the Default action with a more specific sender pattern\. For more information, see [Sender and recipient patterns](#email-flows-patterns)\.  | 
|  Never deliver to junk folder  |  The email message is always delivered to users' inboxes, even if it is identified as spam by the Amazon WorkMail spam detection system\. By not using the default spam detection system, you could expose your users to high\-risk content from the addresses that you specify\.  | 
|  Run Lambda  |  Passes the email message to a Lambda function for processing before or while it is delivered to users' inboxes\.  | 

**Note**  
Inbound email is first delivered to Amazon Simple Email Service \(Amazon SES\) and then to Amazon WorkMail\. If Amazon SES blocks an incoming email message, then rule actions won't apply\. For example, Amazon SES blocks an email message when a known virus is detected or because of explicit IP filtering rules\. Specifying a rule action, such as **Default**, **Deliver to junk folder**, or **Never deliver to junk folder** has no effect\.

## Outbound email rule actions<a name="email-flows-rule-outbound"></a>

Outbound email flow rules can be used to direct email messages via SMTP gateways, or to block senders from sending email messages to specified recipients\. For more information about SMTP gateways, see [Configuring SMTP gateways](smtp-gateway.md)\.

Outbound email flow rules can also be used to pass the email message to an AWS Lambda function for processing after the email is sent\. For more information about using Lambda with Amazon WorkMail, see [Configuring Lambda for Amazon WorkMail](lambda.md)\. For more information about Lambda, see the [https://docs.aws.amazon.com/lambda/latest/dg/welcome.html](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html)\.

The following rule actions define how outbound email is handled\. For each rule, you specify [sender and recipient patterns](#email-flows-patterns) together with one of the following actions\. 


****  

| Action | Description | 
| --- | --- | 
|  Default  |  The email message is sent via the normal flow\.  | 
|  Drop email  |  The email message is dropped\. It is not sent, and the sender is not notified\.  | 
| Send bounce response |  The email message is not sent, and the sender is notified with a message that the administrator blocked the email message\.   | 
|  Route to SMTP gateway  |  The email message is sent via a configured SMTP gateway\.  | 
|  Run Lambda  |  Passes the email message to a Lambda function for processing before or while the email message is sent\.  | 

## Sender and recipient patterns<a name="email-flows-patterns"></a>

An email flow rule can apply to a specific email address, or all email addresses under a specific domain or set of domains\. You define a pattern to determine the email addresses that a rule applies to\.

Both sender and recipient patterns take one of the following forms:
+ **An email address** matches a single email address; for example:

  ```
  mailbox@example.com
  ```
+ **A domain name** matches all email addresses under that domain; for example:

  ```
  example.com
  ```
+ **A wildcard domain** matches all email addresses under that domain and all of its subdomains\. A wildcard appears only at the front of a domain; for example:

  ```
  *.example.com
  ```
+ **Star** matches any email addresses under any domain\.

  ```
  *
  ```

**Note**  
The **\+** symbol is not valid inside of sender or recipient patterns\.

Multiple patterns can be specified for one rule\. For more information, see [Inbound email rule actions](#email-flows-rule-actions) and [Outbound email rule actions](#email-flows-rule-outbound)\.

Inbound email flow rules are applied if either the `Sender` or `From` header in an inbound email message matches any patterns\. If present, the `Sender` address is matched first\. The `From` address is matched if there is no `Sender` header or if the `Sender` header doesn't match any rule\. If there are multiple recipients for the email message that match different rules, each rule applies for the matched recipients\.

Outbound email flow rules are applied if the recipient and either the `Sender` or `From` header in an outbound email message matches any patterns\. If there are multiple recipients for the email message that match different rules, each rule applies for the matched recipients\.

If multiple rules match, the action of the most specific rule is applied\. An example is when a rule for a specific email address takes precedence over a rule for an entire domain\. If multiple rules have the same specificity, the most restrictive action is applied\. An example is when a **Drop** action takes precedence over a **Bounce** action\. The order of precedence for actions is the same as the order in which they are listed in [Inbound email rule actions](#email-flows-rule-actions) and [Outbound email rule actions](#email-flows-rule-outbound)\.

**Note**  
Take care when creating rules with overlapping sender patterns with **Drop** or **Bounce** actions\. Unexpected precedence ordering could result in many inbound email messages not being delivered\.