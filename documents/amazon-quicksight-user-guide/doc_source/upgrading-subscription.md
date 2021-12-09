# Upgrading Your Amazon QuickSight Subscription from Standard Edition to Enterprise Edition<a name="upgrading-subscription"></a>

You can upgrade from Amazon QuickSight Standard edition to Amazon QuickSight Enterprise edition\. In Enterprise edition, Amazon QuickSight supports the following additional features:
+ Active directory integration 
+ Encryption for data at REST 
+ Pay\-per\-session pricing for users in the reader role 
+ Row\-level security 
+ Hourly refresh of datasets 
+ Private connections to data in a VPC with a private subnet 

To see a full comparison of Standard edition with Enterprise edition, see [Amazon QuickSight Editions](https://aws.amazon.com/quicksight/resource-library/editions/)\.

When you upgrade your account, your admins and authors are billed at the Amazon QuickSight Enterprise edition rates\. For up\-to\-date information on rates, see [Pricing](https://aws.amazon.com/quicksight/#Pricing)\. To enjoy pay\-per\-session pricing, you can add additional users as readers\. Before you reprovision existing users as readers, transfer or delete their resources, and then delete the users from your subscription\. 

Users who are in the reader role can view and manipulate shared dashboards, and receive emailed updates\. However, readers can't add or change data sources, data sets, analyses, visuals, or administrative settings\. Billing for readers is significantly lower in cost than regular user pricing\. It's based on 30\-minute sessions, and it's capped at a maximum amount per month for each reader\. Billing for upgrades is pro\-rated for the month of the upgrade\. Upgrades to users are also pro\-rated\. If you have an annual subscription to Standard edition, it's converted to Enterprise edition and stays in place for the remaining term\.

**Warning**  
Downgrading from Enterprise edition to Standard edition isn't currently possible due to the enhanced feature set available in Enterprise edition\. To perform this downgrade, unsubscribe from Amazon QuickSight, and then start a new subscription\. It isn't possible to transfer users or assets between subscriptions\.   
Upgrading to Enterprise edition to use Active Directory connectivity isn't supported due to differences in the user identity mechanisms between Amazon QuickSight password\-based users and existing Active Directory users\.  However, you can upgrade to Enterprise, and still use password\-based users\. If you want to upgrade, and change how users sign in, you can unsubscribe and start a new subscription\.

Use the following procedure to upgrade to Enterprise edition\. To perform the upgrade, you need administrative access to Amazon QuickSight, with security permissions to subscribe\. The person performing the upgrade is usually an AWS administrator who is also an Amazon QuickSight administrator\. 

1. Open the administrative settings page by clicking on your profile icon at top right\.

1. At top left, choose **Upgrade now**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-page-upgrade-now.png)

   The following screen appears\. For the latest prices, see [https://aws\.amazon\.com/quicksight/](https://aws.amazon.com/quicksight/)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/upgrade-to-enterprise-edition.png)

1. Be sure that you want to upgrade\.
**Important**  
You can't undo this action\.

   Choose **Upgrade** to upgrade\. The upgrade is instantaneous\.

   Billing for the upgrade to your subscription is pro\-rated for the month of upgrade\. Upgrades to Amazon QuickSight users are also pro\-rated\.

1. When you upgrade to Enterprise edition, your admin and author users retain their roles\. You can downgrade users to readers\. First make sure to transfer any assets they own that you want to keep\. Then, delete them and add them back to your subscription as readers\. If you are using Active Directory, delete the authors, move them to the new reader group, then recreate them as readers in Amazon QuickSight\. 
