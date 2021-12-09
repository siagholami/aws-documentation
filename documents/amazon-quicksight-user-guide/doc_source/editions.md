# Different Editions of Amazon QuickSight<a name="editions"></a>

Amazon QuickSight offers Standard and Enterprise editions\. To learn more about the differences in availability, user management, permissions, and security between the two versions, see the following topic\. 

Both editions offer a full set of features for creating and sharing data visualizations\. Enterprise edition additionally offers encryption at rest and Microsoft Active Directory \(Microsoft Active Directory\) integration\. In Enterprise edition, you select a Microsoft Active Directory directory in AWS Directory Service\. You use that active directory to identify and manage your Amazon QuickSight users and administrators\. 

For more information about the features offered by the Amazon QuickSight editions and about pricing, see the [Amazon QuickSight website](https://aws.amazon.com/quicksight/)\. 

## Comparing Editions<a name="compare-editions"></a>

To help you decide which edition is for you, take a look at the following table to compare features between editions\.


| Features | Standard Edition | Enterprise Edition | 
| --- | --- | --- | 
| Free Authors | 1 | 1 | 
| Free Trial Authors \(60 Days\) | 4 | 4 | 
| Included SPICE Capacity | 10 GB/User | 10 GB/User | 
| Readers | N/A | $0\.30/session | 
| Additional SPICE Capacity | $0\.25/GB/mo\. | $0\.38/GB/mo\. | 
| Connect to spreadsheets, databases, data lakes, and business apps | ✓ | ✓ | 
| Easily analyze data with AutoGraph | ✓ | ✓ | 
| Fast, scalable visualizations | ✓ | ✓ | 
| Publish dashboards for interactive data access | ✓ | ✓ | 
| Single\-Sign\-On with SAML or OpenID Connect | ✓ | ✓ | 
| Web and mobile access | ✓ | ✓ | 
| Drill\-down to detail and customize filters | ✓ | ✓ | 
| Enable audit logs with AWS CloudTrail | ✓ | ✓ | 
| Reader Role |  | ✓ | 
| Securely Access data in Private VPCs and On\-Prem |  | ✓ | 
| Row Level Security |  | ✓ | 
| Hourly refresh of SPICE data |  | ✓ | 
| Secure data encryption at rest |  | ✓ | 
| Connect to Active Directory |  | ✓ | 
| Use Active Directory groups |  | ✓ | 

## Availability of Editions<a name="edition-availability"></a>

All editions are available in any AWS Region that is currently supported by Amazon QuickSight\. 

The capacity region in which you start your Amazon QuickSight subscription is where your account's default [SPICE](welcome.md#spice) capacity is allocated\. However, you can purchase additional SPICE capacity and access your AWS resources in any other supported AWS Region\.

You can start a new Amazon QuickSight subscription using Standard edition, choosing any default capacity region\. You can then upgrade it to Enterprise edition at any time, and connect to it using Role Based Federation \(SSO\) or email invitations\.

If you require Active Directory integration, begin by creating a new Enterprise edition subscription\. Choose the US East \(N\. Virginia\) Region as your default capacity region\. 

**Note**  
If you are using Microsoft Active Directory onsite at your data center or outside your default AWS Region, you can use AD Connector to integrate with Amazon QuickSight Enterprise edition\. Currently, Amazon QuickSight only supports AD Connectors located in the US East \(N\. Virginia\) Region\. 

To manage Enterprise account settings, you must temporarily change your region for your session to US East \(N\. Virginia\) Region\. You can change it back when you have finished editing your account settings\. These settings include changing your subscription's notification email, enabling IAM access requests, editing access to AWS resources, and unsubscribing from Amazon QuickSight\.

## User Management Between Edititons<a name="edition-user-management"></a>

User management is different between the Amazon QuickSight Standard and Enterprise editions\. However, both editions support identity federation, or Federated Single Sign\-On \(SSO\), through Security Assertion Markup Language 2\.0 \(SAML 2\.0\)\.

### User Management for Standard Edition<a name="edition-user-management-standard"></a>

In Standard edition, you can invite an AWS Identity and Access Management \(IAM\) user and allow that user to use their credentials to access Amazon QuickSight\. Alternatively, you can invite any person with an email address to create an Amazon QuickSight–only user account\. When you create a user account, Amazon QuickSight sends email to that user inviting them to activate their account\. 

When you create a user account, you also choose to assign it either an administrative or a user role\. This role assignment determines the user's permissions in Amazon QuickSight\. You perform all management of users by adding, changing, and deleting user accounts in Amazon QuickSight\. 

For more information about managing Standard edition user accounts, see [Managing User Access Inside Amazon QuickSight](managing-quicksight-users.md)\.

### User Management for Enterprise Edition<a name="edition-user-management-enterprise"></a>

In Enterprise edition, you can select one or more Microsoft Active Directory active directory groups in AWS Directory Service for administrative access\. All users in these groups are authorized to sign in to Amazon QuickSight as administrators\. You can also select one or more Microsoft Active Directory active directory groups in AWS Directory Service for user access\. All users in these groups are authorized to sign in to Amazon QuickSight as users\. 

**Important**  
Amazon QuickSight administrators and users added in this way aren't automatically notified of their access to Amazon QuickSight\. You must email users with the sign\-in URL, the account name, and their credentials\.

You can only add or remove Enterprise edition user accounts by adding or removing a person from a Microsoft Active Directory group that you associated with Amazon QuickSight\. When you add a user account, the permissions it gets rely on whether the Microsoft Active Directory group is an administrative group or a user group in Amazon QuickSight\. 

You can also bulk add or remove user accounts by integrating Microsoft Active Directory groups with, or removing Microsoft Active Directory groups from, Amazon QuickSight\. 

Deactivating a user by removing the user from a Microsoft Active Directory group, or by removing their Microsoft Active Directory group from integration with Amazon QuickSight, doesn't delete the associated Amazon QuickSight user account for that person\. 

For more information about managing Enterprise edition user accounts, see [Access and Authentication in Amazon QuickSight](access-and-authentication.md)\.

## Permissions for the Different Editions<a name="edition-permissions"></a>

In Standard edition, all Amazon QuickSight administrators can manage subscriptions and SPICE capacity\. They can also add, modify, and delete user accounts\. 

Additional AWS permissions are required to manage Amazon QuickSight permissions to AWS resources and to unsubscribe from Amazon QuickSight\. These tasks can only be performed by an IAM user who also has administrative permissions in Amazon QuickSight, or by the IAM user or AWS account that created the Amazon QuickSight account\.

To manage access to AWS resources from Amazon QuickSight, you must be logged in as one of the following:
+ Any IAM user who is an Amazon QuickSight adminstrator
+ The IAM user or AWS root account that created the Amazon QuickSight account

In Enterprise edition, you must add AD users or groups to an IAM role that has QuickSight permissions, rather than adding IAM users individually\. All Microsoft Active Directory users that are Amazon QuickSight administrators can to manage subscriptions and SPICE capacity\. 

Additional AWS permissions are required to manage Microsoft Active Directory groups, manage access to AWS resources, or unsubscribe from Amazon QuickSight\. Administrators are prompted for AWS or IAM credentials to perform these tasks\.

For more information about the permissions needed for specific tasks, see [Setting Your IAM Policy](set-iam-policy.md)\.

## Secure Transmission and Storage Between Editions<a name="security"></a>

In both editions of Amazon QuickSight, all transfers of data \(for example, from the data source to SPICE, or from SPICE to the user interface\) are encrypted\. Database connections are secured using Secure Sockets Layer \(SSL\), and all other transfers are secured using Transport Layer Security \(TLS\)\.

In Enterprise edition, data at rest in SPICE is also encrypted using block\-level encryption with AWS\-managed keys\.