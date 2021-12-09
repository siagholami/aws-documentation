# Pricing and Licensing for Embedded Dashboards with Amazon QuickSight<a name="embedded-dashboards-pricing-and-licensing"></a>

This section covers pricing and licensing information for using embedded dashboards with Amazon QuickSight Enterprise edition\.

## Pricing for Embedded Dashboards with Amazon QuickSight<a name="embedded-dashboards-pricing"></a>

Embedded dashboards are billed in a way that is similar to billing for readers\. Each viewer gets a 30\-minute session charged at $0\.30, with a max charge of $5 per user per month\. Session authentication in Amazon QuickSight expires after 10 hours\. Currently, if the hosting app needs sessions longer than 10 hours, users see a time\-out page\. 

## Licensing for Embedded Dashboards with Amazon QuickSight<a name="embedded-dashboards-licensing"></a>

All embedded iframes feature a “Powered by Amazon QuickSight” label, along with required legal notices\. Loading animations feature an Amazon QuickSight logo\.

Each individual user who accesses an embedded dashboard is licensed separately, and must be a user of Amazon QuickSight\. Similar to dashboards within Amazon QuickSight, embedded dashboards need to be shared with a group that the user is a member of\. Alternatively, embedded dashboards can be shared explicitly with each user\. 

Routing more than one user through a single Amazon QuickSight user is not yet supported\. Doing this triggers throttling at the user level, so that the same user identity can't access Amazon QuickSight from multiple browsers\. If you need to use multiple iframes on the same page, contact the Amazon QuickSight team\. 