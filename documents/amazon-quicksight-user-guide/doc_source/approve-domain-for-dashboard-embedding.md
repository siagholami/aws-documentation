# Adding Domains for Embedded Dashboard Users<a name="approve-domain-for-dashboard-embedding"></a>

In Amazon QuickSight Enterprise edition, you can embed dashboards in an app or webpage\. The domain that is going to host embedded dashboards must be on the *allowlist*, the list of approved domains for your Amazon QuickSight subscription\. This requirement protects your data by keeping unapproved domains from hosting embedded dashboards\. 

You can only embed dashboards after you perform the following steps:
+ Approve the hosting domains and subdomains for embedding\.
+ Publish the dashboard\.
+ Share the dashboard with users or groups so they can see the embedded version of it\.

Use the following procedure to view or edit the list of approved domains\. 

1. Choose the profile icon at top right\.

1. Choose **Manage QuickSight**\. You must be an Amazon QuickSight admin to access this screen\.

1. Choose **Domains and Embedding** on the left\. The domains that you can embed a dashboard in are listed at the bottom of the page\. 

1. \(Optional\) You can add a new domain here by entering it in the **Domain** box\. You can also choose **Include subdomains** to allow embedded dashboards on all subdomains\. Choose **Add** to add the domain\.

   You can edit or delete existing domain by choosing the icons next to each domain in the list at the bottom of the page\.

Make sure that you use a valid https URL\. The following list shows examples of URLs that are valid for embedded dashboards:
+ https://example\-1\.com
+ https://www\.アマゾンドメイン\.jp
+ https://www\.亚马逊域名\.cn:1234
+ https://111\.222\.33\.44:1234
+ https://111\.222\.33\.44

The following list shows examples of URLs that are *not* valid for embedded dashboards:
+ http://example
+ https://example\.com\.\*\.example\-1\.co\.uk
+ https://co\.uk
+ https://111\.222\.33\.44\.55:1234
+ https://111\.222\.33\.44\.55

For more information about embedded dashboards, see [Embedding Amazon QuickSight Dashboards](embedding-dashboards.md)\. 