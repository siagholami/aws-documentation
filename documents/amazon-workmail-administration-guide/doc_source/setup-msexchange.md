# Enable email routing between Microsoft Exchange and Amazon WorkMail users<a name="setup-msexchange"></a>

When you enable email routing between Microsoft Exchange Server and Amazon WorkMail, users that are configured for Amazon WorkMail can continue using their existing email addresses to send and receive email on Amazon WorkMail\. When email routing is enabled, your Microsoft Exchange Server remains the primary SMTP server for incoming email\.

Prerequisites for email routing: 
+ Interoperability mode is enabled for your organization\. For more information, see [Enable interoperability](interoperability.md#enable_interoperability)\.
+ Your domain is added and verified in the Amazon WorkMail console\.
+ Your Microsoft Exchange Server can send email to the internet\. You might need to configure a Send connector\.

## Enable email routing for a user<a name="enable_routing_user"></a>

We recommend that you carry out the following steps first for test users, before applying the change to your organization\.

1. Enable the user you are migrating to Amazon WorkMail\. For more information, see [Enable existing users](https://docs.aws.amazon.com/workmail/latest/adminguide/enable_existing_user.html)\.

1. In the Amazon WorkMail console, ensure that there are at least two email addresses associated with the enabled user\. 
   + *workmailuser*@*orgname*\.awsapps\.com \(this is added automatically, and can be used for tests without your Microsoft Exchange\.\)
   + *workmailuser*@*yourdomain*\.com \(this is added automatically, and is the primary Microsoft Exchange address\.\)

     For more information, see [Edit user email addresses](https://docs.aws.amazon.com/workmail/latest/adminguide/edit_user_email_addresses.html)\.

1. Ensure that you migrate all data from the mailbox in Microsoft Exchange to the mailbox in Amazon WorkMail\. For more information, see [Migrating to Amazon WorkMail](https://docs.aws.amazon.com/workmail/latest/adminguide/migration_overview.html)\.

1. When all the data is migrated, disable the mailbox for the user on Microsoft Exchange and create a mail user \(or mail\-enabled user\) that has the external SMTP address pointed to Amazon WorkMail\. This can be achieved using the following commands in Exchange Management Shell\.
**Important**  
The steps below erase the contents of the mailbox\. Ensure that your data has been migrated to Amazon WorkMail before you attempt to enable email routing\. Some mail clients do not seamlessly switch to Amazon WorkMail when this command is executed\. For more information, see [Mail client configuration](#mail_client_config)\.

   ```
   $old_mailbox = Get-Mailbox exchangeuser
   ```

   ```
   Disable-Mailbox $old_mailbox
   ```

   ```
   $new_mailuser = Enable-MailUser $old_mailbox.Identity -ExternalEmailAddress workmailuser@orgname.awsapps.com -PrimarySmtpAddress $old_mailbox.PrimarySmtpAddress
   ```

   ```
   Set-MailUser $new_mailuser -EmailAddresses $old_mailbox.EmailAddresses -HiddenFromAddressListsEnabled $old_mailbox.HiddenFromAddressListsEnabled
   ```

   In the above commands, **orgname** represents the name of the Amazon WorkMail organization\. For more information, see [Disabling mailbox](https://technet.microsoft.com/en-us/library/jj863434(v=exchg.150).aspx) and [Enabling mail users](https://technet.microsoft.com/en-us/library/aa996549(v=exchg.150).aspx) on Microsoft TechNet\.

1. Send a test email to the user \(as per the example above, **workmailuser@yourdomain\.com**\)\. If email routing has been enabled correctly, the user should be able to log in to the Amazon WorkMail mailbox and receive the email\.

**Note**  
Microsoft Exchange remains the primary server for incoming email as long as you would like to have interoperability between the two environments\. To ensure interoperability with Microsoft Exchange, the DNS records should not be updated to point to Amazon WorkMail until later\.

## Post setup configuration<a name="post_setup"></a>

The above steps move a user mailbox from Microsoft Exchange Server to Amazon WorkMail, while keeping the user in Microsoft Exchange as a contact\. Because the migrated user is now an external mail user, Microsoft Exchange Server imposes additional constraints and there may be additional configuration requirements to complete the migration\.
+ The user might not be able to send emails to groups by default\. To enable this functionality, the user must be added to a safe sender list for all groups\. For more information, see [Delivery management](https://technet.microsoft.com/en-us/library/bb123722.aspx#deliverymanagement) on Microsoft TechNet\.
+ The user also might not be able to book resources\. To enable this functionality, you must set the `ProcessExternalMeetingMessages` of all resources that the user needs to access\. For more information, see [Set\-CalendarProcessing](https://technet.microsoft.com/en-us/library/dd335046.aspx) on Microsoft TechNet\.

## Mail client configuration<a name="mail_client_config"></a>

Some mail clients do not switch seamlessly to Amazon WorkMail and require the user to perform additional setup\. Different mail clients require different actions to be taken\.
+ Microsoft Outlook on Windows—Requires MS Outlook to be restarted\. At startup, you are required to choose whether to keep using the old mailbox or use a temporary mailbox\. Choose the temporary mailbox option, and reconfigure the Microsoft Exchange mailbox from scratch\.
+ Microsoft Outlook on MacOS—When Outlook is restarted, you see the following message **Outlook was redirected to server orgname\.awsapps\.com\. Do you want this server to configure your settings?**\. Accept the suggestion\.
+ Mail on iOS—The mail app stops receiving emails and generates a **Cannot get mail** error\. Reconfigure the Microsoft Exchange mailbox from scratch\.