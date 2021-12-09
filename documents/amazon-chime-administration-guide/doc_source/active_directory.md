# Connecting to your Active Directory<a name="active_directory"></a>

When you connect your Amazon Chime administrative account to an Active Directory, you can benefit from the following capabilities:
+ Your Amazon Chime users can sign in with their Active Directory credentials\.
+ As an Amazon Chime administrator, you choose which credential security features to add, including password rotation, password complexity rules, and multi\-factor authentication\.
+ When you remove user accounts from your Active Directory, their Amazon Chime accounts are also removed\.
+ You can specify which Active Directory groups receive Amazon Chime Pro permissions\.
  + Multiple groups can be configured to receive Basic or Pro permissions\.
  + Users must be a member of either group to sign in to Amazon Chime\.
  + Users in both groups receive a Pro license\.

For more information about managing user permissions, see [Managing user permissions and access](manage-access.md)\.

## Prerequisites<a name="active-directory-prereqs"></a>

Before you can connect to your Active Directory in Amazon Chime, you must complete the following prerequisites:
+ Make sure that you have the correct AWS Identity and Access Management \(IAM\) permissions to configure domains, active directories, and directory groups\. For more information, see [Identity and access management for Amazon Chime](security-iam.md)\.
+ Create a directory with AWS Directory Service that is configured in the US East \(N\. Virginia\) Region\. For more information, see the [AWS Directory Service Administration Guide](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/)\. Amazon Chime can connect using AD Connector, Microsoft AD, or Simple AD\.
+ Claim a domain in order to create an Amazon Chime Enterprise account, or convert your existing Team account to an Enterprise account\. If your users have work email addresses from more than one domain, make sure to claim all of those domains\. For more information, see [Claiming a domain](claim-domain.md) and [Converting a Team account to an Enterprise account](convert-team-to-enterprise.md)\.

## Connecting to your Active Directory in Amazon Chime<a name="connect-active-directory-chime"></a>

After you connect your Active Directory to Amazon Chime, your users are prompted to sign in with their directory credentials when they use an email address from one of the domains you claimed in your Amazon Chime Enterprise account\.

**To connect to your Active Directory in Amazon Chime**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. In the navigation pane, for **Identity**, choose **Active directory**\.

1. For **Cloud directory ID**, select the AWS Directory Service directory to use for Amazon Chime, and then choose **Connect**\.
**Note**  
You can find your directory ID using the [AWS Directory Service console](https://console.aws.amazon.com/directoryservice/)\.

1. After your directory connects, choose **Add a new group**\. 

1. For **Group**, enter the group name\. The name must exactly match an Active Directory group in the target directory\. Active Directory Organization Units \(OUs\) are not supported\.

1. For **Permissions**, choose **Basic** or **Pro**\. 

1. Choose **Add group**\.

1. \(Optional\) Repeat this procedure to create additional directory groups\.

## Configuring multiple email addresses<a name="multi-email"></a>

After you connect to your Active Directory in Amazon Chime, users can sign in to Amazon Chime using their Active Directory credentials\. Your users can have multiple email addresses assigned to them in your Active Directory\. To allow your users to sign in to Amazon Chime using their Active Directory credentials, you must claim each applicable email domain in your Amazon Chime administrative account\. For more information, see [Claiming a domain](claim-domain.md)\.

**Note**  
If your users attempt to sign in using an email address from an unclaimed domain, they are prompted to sign in using **Log in with Amazon**\. They are not able to sign in to your administrative account when using an email address from an unclaimed domain\.

When viewing user details in the Amazon Chime console, Amazon Chime uses the single email address in the `EmailAddress` attribute from your Active Directory as each user’s primary email address\. This is the only email address that you can see for the user in the Amazon Chime console\. However, users can sign in with any additional addresses listed in the `ProxyAddress` attribute, as long as you claim those domains in your Amazon Chime account\.

### Incorrect configuration example<a name="incorrect-config"></a>

A user with the **username** shirley\.rodriguez is a member of an Amazon Chime account that has claimed two domains: example\.com and example\.org\. In Active Directory, this user has the following three email addresses:
+ Primary email address: shirley\.rodriguez@example\.com
+ Proxy email address 1: shirley\.rodriguez@example2\.com
+ Proxy email address 2: srodriguez@example\.org

This user can sign into Amazon Chime using shirley\.rodriguez@example\.com or srodriguez@example\.org and her user name shirley\.rodriguez\. If they attempt to sign in using shirley\.rodriguez@example2\.com, they are asked to **Log in with Amazon** and they are not part of your managed account\. This is why it's important to claim all of the domains your users use for email\.

Other Amazon Chime users can add this user as a contact, invite them to meetings, or add them as a delegate using either the shirley\.rodriguez@example\.com or srodriguez@example\.org email address\. 

### Correct configuration example<a name="correct-config"></a>

A user with the **username** shirley\.rodriguez is a member of an Amazon Chime account that has claimed three domains: example\.com, example2\.com, and example\.org\. In Active Directory, this user has the following three email addresses:
+ Primary email address: shirley\.rodriguez@example\.com
+ Proxy email address 1: shirley\.rodriguez@example2\.com
+ Proxy email address 2: srodriguez@example\.org

This user can sign into Amazon Chime using any of their work email addresses\. Other users can also add them as a contact, invite them to meetings, or add them as a delegate using any of their work email addresses\. 