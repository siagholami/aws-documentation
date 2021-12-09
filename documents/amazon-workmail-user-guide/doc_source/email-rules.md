# Working with email rules<a name="email-rules"></a>

Use email rules to route emails from your mailbox in Amazon WorkMail\. You can forward or redirect emails to external email addresses and to Amazon WorkMail users, resources, or groups, but not to personal distribution lists in your **Contacts** folder\. 

**To create an email rule**

1. In the Amazon WorkMail web application, choose the gear icon\.

1. Choose **Email rules**, **New**\.

1. For **Rule name**, enter a name, and select **Active rule**\.

1. For **Conditions**, choose the conditions for the rule, such as **is sent only to me**\.
**Note**  
To match a string with special HTML characters for the condition **Includes these rules in the body**, remove any left angle brackets from the string\. This allows matching against email body text that contains HTML markup\.

1. For **Actions**, choose the actions for the rule, such as **Move message to folder**\.

1. Choose **OK**, **Save changes**\.

**Note**  
The **is sent to** email rule is only activated when the indicated recipients are in the **To:** or **CC:** fields of the email message\.

**To create an email forwarding rule**

1. In the Amazon WorkMail web application, choose the gear icon\.

1. Choose **Email rules**, **New**\.

1. For **Rule name**, enter a name, and select **Active rule**\.

1. For **Conditions**, choose the conditions for the rule, such as **is sent only to me**\.

1. For **Actions**, choose **Forward the message to**, **Select recipient\(s\)**\. Enter the email addresses to forward email to, and choose **To**, **OK**\.

   1. Optionally, choose additional actions, such as **Delete the message** or **Move message to folder**\.

1. Choose **OK**, **Save changes**\.

1. The recipient of the forwarded email sees that it was forwarded from you, and a copy of the email remains in your mailbox\.

Bounced emails are not forwarded\.

**To create an email redirect rule**

1. In the Amazon WorkMail web application, choose the gear icon\.

1. Choose **Email rules**, **New**\.

1. For **Rule name**, enter a name, and select **Active rule**\.

1. For **Conditions**, choose **is sent to**, **Select recipient\(s\)**\. Enter the user account from which to redirect email, and choose **To**, **OK**\. 

   1. Optionally, choose additional conditions such as **received from** or **includes these words in the subject**\.

1. For **Actions**, choose **Redirect the message to**, **Select recipient\(s\)**\. Enter the email addresses to redirect email to, and choose **To**, **OK**\.

1. Choose **OK**, **Save changes**\.

1. The recipient of the redirected email sees it as coming from the original sender\.

Emails that bounce and do not pass Sender Policy Framework \(SPF\) and DomainKeys Identified Mail \(DKIM\) key checks are not redirected\.