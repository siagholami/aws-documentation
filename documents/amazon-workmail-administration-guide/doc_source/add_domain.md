# Adding a domain<a name="add_domain"></a>

You can add up to 100 domains to your Amazon WorkMail organization for sending email\. When you add a new domain, an Amazon Simple Email Service \(Amazon SES\) sending authorization policy is automatically added to the domain identity policy\. This provides Amazon WorkMail with access to all Amazon SES sending actions for your domain and allows you to redirect email to your domain as well as external domains\.

**Note**  
As a best practice, you should add aliases for postmaster@ and abuse@\. You can create distribution groups for these aliases if you want certain users in your organization to receive mail sent to these aliases\.

**To add a domain**

1. Sign in to the AWS Management Console and open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the AWS Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of the organization to which to add a domain\.

1. In the navigation pane, choose **Domains**, **Add domain**\.

1. On the **Add domain** screen, enter the domain name to add\. Domain names can contain Basic Latin \(ASCII\) characters\.
   + \(Optional\) If you have a domain that is managed in an Amazon Route 53 public hosted zone, you can choose it from the dropdown menu that appears\.

1. Choose **Add domain**\.
   + \(Optional\) If you add a domain for which you are using Route 53 as the DNS service, and the hosted zone does not contain any records for Amazon WorkMail \(such as MX records\), you are redirected to the **Automatic Configuration** page\. Choose **Configure automatically** and follow the prompts to have Amazon WorkMail automatically insert the DNS records for you, and skip the rest of this procedure\.

1. In the console section **Step 1: Verify domain ownership**, the TXT record verifies your ownership of the domain\.

   After all your users and distribution groups are created, and mailboxes are successfully migrated, you can update the MX record to start forwarding email to Amazon WorkMail\. Updates to DNS records can take up to 48 hours to process\. For information about creating DNS records, see step 8\.

1. In the console sections **Step 2: Finalize domain setup** and **Step 3: Increase security \(recommended\)**, the following records are listed:
   + The MX record to deliver incoming email to Amazon WorkMail\.
   + The CNAME autodiscover record that allows users to easily configure their Microsoft Outlook or mobile device knowing only their email address and password\.
   + The CNAME records for DKIM signing\. For more information about DKIM signing, see [Authenticating email with DKIM](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/dkim.html) in the *Amazon Simple Email Service Developer Guide*\.
   + The TXT record for SPF verification\. For more information about SPF verification, see [Authenticating email with SPF](authenticate_domain.md)\.
   + The TXT record for DMARC\. For more information about DMARC records in Amazon WorkMail, see [Complying with DMARC using Amazon SES](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/dmarc.html) in the *Amazon Simple Email Service Developer Guide*\.
**Important**  
Some DNS providers automatically append the domain name to the end of DNS records\. Adding a record that already contains the domain name \(such as \_amazonses\.example\.com\) might result in the duplication of the domain name \(such as \_amazonses\.example\.com\.example\.com\)\. To avoid duplicating the domain name in the record name, add a period to the end of the domain name in the DNS record\. This indicates to your DNS provider that the record name is fully qualified, meaning that it is no longer relative to the domain name\. It also prevents the DNS provider from appending an additional domain name\.

   You can copy these records for use with your DNS service\. The record names that are copied include the domain name\. Depending on which DNS service you use, the domain name might already be added to the domain's DNS record\.

   The records on the domain page also include the verification status\. After you create a record, choose the refresh icon to see the verification status and record value\. For more information about verifying domains, see [Verifying domains](domain_verification.md)\.

   The following table shows the available verification statuses for each record type\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workmail/latest/adminguide/add_domain.html)
**Note**  
The AutoDiscover domain verification also checks for correct AutoDiscover setup\. After phase 2 and phase 3 verification are complete, a check mark appears next to the **Verified** status\.

   We recommend that you set the Time to Live \(TTL\) to 3600 of the MX and autodiscover CNAME record\. Reducing the TTL ensures that your mail servers don't use outdated or invalid MX records after updating your MX records or migrating your mailboxes\.

1. We recommend configuring your domain as the `MAIL FROM` domain\. You can see the status of your `MAIL FROM` domain in the console section **Step 4: Enhance deliverability \(recommended\)**\. For more information, see [Configuring a custom MAIL FROM domain in Amazon WorkMail](custom-mail-from-domain.md)\.