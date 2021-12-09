# Claiming a domain<a name="claim-domain"></a>

To create an Enterprise account and benefit from the greater control that it provides over your account and users, you must claim at least one email domain\. 

**To claim a domain**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. On the **Accounts** page, select the name of the Team account\.

1. In the navigation pane, choose **Identity**, **Domains**\.

1. On the **Domains** page, choose **Claim a new domain**\.

1. For **Domain**, type the domain that your organization uses for email addresses\. Choose **Verify this domain**\.  
![\[The Verify a new domain dialog box in the Amazon Chime console\]](http://docs.aws.amazon.com/chime/latest/ag/images/verify_new_domain_dialog.png)

1. Follow the directions on the screen to add a TXT record to the DNS server for your domain\. In general, the process involves signing in to your domain's account, finding the DNS records for your domain, and adding a TXT record with the name and value provided by Amazon Chime\. For more information about updating the DNS records for your domain, see the documentation for your DNS provider or domain name registrar\.

   Amazon Chime checks for the existence of this record to verify that you own the domain\. After the domain is verified, its status changes from **Pending verification** to **Verified**\.
**Note**  
Propagation of the DNS change and verification by Amazon Chime can take up to 24 hours\.

1. If your organization uses additional domains or subdomains for email addresses, repeat this procedure for each domain\.

For more information about troubleshooting domain claims, see [Why isn't my domain claim request getting verified?](https://answers.chime.aws/questions/618/why-isnt-my-domain-claim-request-getting-verified.html)\.