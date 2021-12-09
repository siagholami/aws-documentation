# Security and User Provisioning for Embedded Dashboards in Amazon QuickSight<a name="embedded-dashboards-security"></a>

You can control access to dashboards through user groups, which can be programmatically managed using the group API operations\. Plus you can use features such as row\-level security to control granular access to data\. 

Embedded dashboards provide secure access and seamless integration with websites or apps by using transparent authentication via IAM roles, SAML, or OpenID Connect\. Each individual viewer of an embedded dashboard requires a valid Amazon QuickSight session token\. You can provision viewers of embedded dashboards as users of Amazon QuickSight by one of the following methods: 
+ On the fly, by using Amazon QuickSight's just\-in\-time user provisioning capabilities
+ In advance, by using available user management API operations

To enable a seamless authentication experience for users on the embedded page, you can validate the user by providing them an AWS role\. Alternatively, you can authenticate them using SAML/Open ID connect when displaying the iframe on the webpage or app\. The JS SDK validates the users with their AWS credentials and on successful completion, provides access to the embedded Amazon QuickSight dashboard\.

To ensure that the dashboards are embedded only in authorized apps, an Amazon QuickSight admin must add each domain you want to use in the Amazon QuickSight settings\. For more information, see [Adding Domains for Embedded Dashboard Users](approve-domain-for-dashboard-embedding.md)\.

CloudTrail auditing logs can provide you with information regarding the number of dashboards embedded, access rates, and domains where they are embedded\. 