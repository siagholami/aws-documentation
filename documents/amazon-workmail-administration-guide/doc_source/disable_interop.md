# Disabling interoperability and decommissioning your mail server<a name="disable_interop"></a>

After all your Microsoft Exchange mailboxes are configured for Amazon WorkMail, you can disable interoperability\. If you have not migrated any users or records, disabling interoperability does not affect any of your configurations\.

**Warning**  
Before disabling interoperability, ensure that you have completed all the required steps\. Failure to do so could result in bounced emails or unintended behavior\. If you have not completed migration, disabling interoperability may cause disruptions to your organization\. You cannot undo this operation\.

**To disable interoperability support**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the AWS Region\. From the navigation bar, choose the Region that meets your needs\. For more information, see [Regions and endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

1. On the **Organizations** page, choose the organization that has interoperability mode enabled and choose **Disable Interoperability**\. 

1. In the **Disable interoperability with Microsoft Exchange** dialog box, enter the name of the organization and choose **Disable**\.

After disabling interoperability support, users and groups that are not enabled for Amazon WorkMail are removed from the address book\. You can still enable any missing user or group using the Amazon WorkMail console and they are added to the address book\. Resources from Microsoft Exchange cannot be enabled and do not appear in the address book until you complete the step below\.
+ **Create resources in Amazon WorkMail** – You can create resources in Amazon WorkMail and configure delegates and booking options for these resources\. For more information, see [Working with resources](https://docs.aws.amazon.com/workmail/latest/adminguide/resources_overview.html)\.
+ **Create an AutoDiscover DNS record** – Configure an AutoDiscover DNS record for all mail domains in the organization to enable users to easily connect to their Amazon WorkMail mailboxes from their Microsoft Outlook and mobile clients\. For more information, see [Use AutoDiscover to configure endpoints](https://docs.aws.amazon.com/workmail/latest/adminguide/autodiscover.html)\.
+ **Switch your MX DNS record to Amazon WorkMail** – To deliver all incoming emails to Amazon WorkMail, you have to switch your MX DNS record to Amazon WorkMail\. It can take up to 72 hours before the DNS change is propagated to all DNS servers\.
+ **Decommission your mail server** – After you’ve verified that all email is being routed directly to Amazon WorkMail, you can decommission your mail server if you do not intend to use it going forward\.