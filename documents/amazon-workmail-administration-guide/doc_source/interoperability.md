# Interoperability between Amazon WorkMail and Microsoft Exchange<a name="interoperability"></a>

Interoperability between Amazon WorkMail and Microsoft Exchange Server allows you to minimize disruption to your users as you migrate mailboxes to Amazon WorkMail, or use Amazon WorkMail for a subset of your corporate mailboxes\.

This interoperability allows you to use the same corporate domain for mailboxes across both environments\. This way, your users can schedule meetings with bidirectional sharing of calendar free/busy information\.

## Prerequisites<a name="prerequisites"></a>

Before you enable interoperability with Microsoft Exchange, do the following: 
+ Make sure you have at least one user enabled for Amazon WorkMail, so you can configure the availability settings for Microsoft Exchange\. To enable a user, follow the steps in [Enable email routing for a user](setup-msexchange.md#enable_routing_user)\.
+ Set up an Active Directory \(AD\) Connector – Setting up an AD Connector with your on\-premises directory allows users to continue using their existing corporate credentials\. For more information, see [Set up AD Connector](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/create_directory.html#create_ad_connector) and [Integrate Amazon WorkMail with your on\-premises directory](https://docs.aws.amazon.com/workmail/latest/adminguide/premises_directory.html)\.
+ Set up your Amazon WorkMail organization – Create an Amazon WorkMail organization that uses the AD Connector that you set up\.
+ Add your corporate domains to your Amazon WorkMail organization and verify them in the Amazon WorkMail console\. Otherwise, emails sent to this alias will bounce\. For more information, see [Working with domains](https://docs.aws.amazon.com/workmail/latest/adminguide/domains_overview.html)\.
+ Migrate mailboxes – Enable users to provision and migrate mailboxes from your on\-premises environment to Amazon WorkMail\. For more information, see [Enable existing users](https://docs.aws.amazon.com/workmail/latest/adminguide/enable_existing_user.html) and see [Migrating to Amazon WorkMail](https://docs.aws.amazon.com/workmail/latest/adminguide/migration_overview.html)\. 
**Note**  
Do not update DNS records to point to Amazon WorkMail\. This ensures that Microsoft Exchange remains the primary server for incoming email for as long as you want interoperability between the two environments\.
+ Make sure that the User Principal Names \(UPNs\) in Active Directory match the users' primary SMTP addresses\.

Amazon WorkMail makes HTTPS requests to the EWS URL on Microsoft Exchange to obtain calendar free/busy information\. 
+ Ensure that the relevant firewall settings are set up to allow access from the internet\. The default port for HTTPS requests is port 443\.
+ Amazon WorkMail can only make successful HTTPS requests to the EWS URL on Microsoft Exchange when a certificate signed by a valid certificate authority \(CA\) is available in your Microsoft Exchange environment\. For more information, see [Create an Exchange Server certificate request for a certification authority](https://technet.microsoft.com/en-us/library/bb125165.aspx) on the Microsoft Exchange Documentation website\.
+ You must enable **Basic Authentication** for EWS in Microsoft Exchange\. For more information, see [Virtual directories: Exchange 2013](https://docs.microsoft.com/en-us/archive/blogs/mvpawardprogram/virtual-directories-exchange-2013) on the Microsoft MVP Award Program Blog\.

## Add domains and enable mailboxes<a name="add_domains_interop"></a>

Add your corporate domains to Amazon WorkMail so that they can be used in email addresses\. Ensure that the domains added to Amazon WorkMail are verified, then enable users and groups to provision mailboxes on Amazon WorkMail\. Resources cannot be enabled in Amazon WorkMail while in interoperability mode, and should be re\-created in Amazon WorkMail after you disable interoperability mode\. However, you can still use them to schedule meetings while in interoperability mode\. Resources from Microsoft Exchange are always shown in the **Users** tab in Amazon WorkMail\. 
+ For more information, see [Add domains](https://docs.aws.amazon.com/workmail/latest/adminguide/add_domain.html), [Enable existing users](https://docs.aws.amazon.com/workmail/latest/adminguide/enable_existing_user.html), and [Enable an existing group](https://docs.aws.amazon.com/workmail/latest/adminguide/enable_existing_group.html)\.

**Note**  
To ensure interoperability with Microsoft Exchange, do not update the DNS records to point to Amazon WorkMail records\. Microsoft Exchange remains the primary server for incoming email as long as you want interoperability between the two environments\.

## Enable interoperability<a name="enable_interoperability"></a>

If you have not created an Amazon WorkMail organization, follow the steps in [ Integrate Amazon WorkMail with your on\-premises directory \(Custom Setup\)](https://docs.aws.amazon.com/workmail/latest/adminguide/remises_directory.html) and choose **Enable interoperability** when creating your Amazon WorkMail organization\.

If you already have an Amazon WorkMail organization with an AD Connector linked to Active Directory and you also have Microsoft Exchange, contact [AWS Support](https://aws.amazon.com/premiumsupport/) for assistance with enabling Microsoft Exchange interoperability for an existing Amazon WorkMail organization\.

## Create service accounts in Microsoft Exchange and Amazon WorkMail<a name="create-serviceacct"></a>

To access calendar free/busy information, create a service account on both Microsoft Exchange and Amazon WorkMail\. The Microsoft Exchange service account is any user on Microsoft Exchange that has access to the calendar free/busy information of other Exchange users\. Access is granted by default; so no special permissions are required\.

Similarly, the Amazon WorkMail service account is any user on Amazon WorkMail that has access to calendar free/busy information of other users on Amazon WorkMail\. This is also granted by default\.

Using an Amazon WorkMail organization that takes advantage of an AD Connector integrated with your on\-premises directory means that the Amazon WorkMail service account user must be created in your on\-premises directory and then enabled for Amazon WorkMail\.

## Limitations in interoperability mode<a name="interop_limitations"></a>

When your organization is in interoperability mode, all user, group, and resource management must be done using the Exchange admin center\. Users and groups can be enabled for Amazon WorkMail through the AWS Management Console\. For more information, see [Enable existing users](https://docs.aws.amazon.com/workmail/latest/adminguide/enable_existing_user.html) and [Enable an existing group](https://docs.aws.amazon.com/workmail/latest/adminguide/enable_existing_group.html)\.

When enabling a user or group for Amazon WorkMail, you cannot edit the email addresses or aliases of those users and groups\. Those must also be configured via the Exchange admincenter\. Amazon WorkMail synchronizes changes in your directory every four hours\.

Resources cannot be created or enabled in Amazon WorkMail while in interoperability mode\. However, all your Exchange resources are available in the Amazon WorkMail address book and can be used for scheduling meetings as usual\.