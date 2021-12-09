# Managing user permissions and access<a name="manage-access"></a>

Manage which features your Amazon Chime users can access by assigning them Pro or Basic permissions\. Users with Basic permissions cannot host meetings, but they can attend meetings and use chat\. For more information about the features that users with Pro and Basic permissions can access, see [Plans and pricing](https://aws.amazon.com/chime/pricing)\.

Manage who can sign into your Amazon Chime administrative account by inviting or suspending users\. Only Enterprise account administrators can suspend users\. Team account administrators can remove users from their accounts so that they are no longer paying for the user’s permissions\. However, they can't suspend the user to prevent them from signing in\. For more information about the differences between Enterprise and Team accounts, see [Managing your Amazon Chime accounts](manage-chime-account.md)\.

## Managing user permissions<a name="manage-licenses"></a>

As an Amazon Chime administrator, you can manage Pro and Basic permissions for the users in your Amazon Chime account\.

If Active Directory or Okta is configured for your Amazon Chime account, manage user permissions through their directory group membership\. If you do not have Active Directory or Okta configured, manage user permissions from the Amazon Chime console\.

### Team accounts and Enterprise Login with Amazon<a name="manage-team-lwa-permissions"></a>

If you administer an Amazon Chime Team account or Enterprise LWA account, where users sign in with their Login with Amazon \(LWA\) accounts, you can manage Pro and Basic permissions in the Amazon Chime console\.

**To manage user permissions for Team and Enterprise LWA accounts**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Accounts**, choose the name of the Amazon Chime account\.

1. Choose **Users**\.

1. Select the users and choose **Actions**, **Assign permissions**\.

1. Choose one of the following permissions:
   + **Pro**
   + **Basic**

1. Choose **Assign**\.

### Enterprise Active Directory or Enterprise OpenID Connect \(Okta\) accounts<a name="manage-AD-enterprise-permissions"></a>

If your users sign in with Active Directory or Okta credentials, manage their permissions by making them members of a directory group that has Pro or Basic permissions assigned to it\.

To assign Pro permissions to a user, make them a member of an Active Directory or Okta group that you have assigned Pro permissions to\. To assign Basic permissions to a user, make them a member of a group that you have assigned Basic permissions to\. Users who don't have either Pro or Basic permissions aren't able to sign into Amazon Chime\.

## Managing user access<a name="manage-user-access"></a>

If you administer an Amazon Chime account, you can invite users to allow to them to sign in to your account\. Enterprise account administrators can suspend user access to prevent them from signing in to the account\.

### Inviting and removing Team account users<a name="invite-remove-team-user"></a>

If you administer a Team account, use the Amazon Chime console to invite users from any email domain\.

**Note**  
A user's free 30\-day Pro trial ends when they accept your invitation\.

**To invite users to a Team account**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Accounts**, choose the name of the Team account\.

1. Choose **Users**, **Invite users**\.

1. Enter the email addresses of the users to invite, separating multiple email addresses with a semicolon \(**;**\)\.

1. Choose **Invite users**\.

The following procedure disassociates users from your Team account by removing any Pro or Basic permissions assigned to them\. Removed users can still sign in to Amazon Chime, but they are no longer paid members of your Amazon Chime account\.

**To remove users from a Team account**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Accounts**, choose the name of the Team account\.

1. Choose **Users**\. 

1. Select the users to remove and choose **Actions**, **Remove user**\.

Any Pro or Basic permissions assigned to the users are removed\. The users can no longer use autocomplete to find new Team users in their **Contacts**\.

### Inviting and suspending Enterprise account users<a name="invite-suspend-enterprise-user"></a>

If you administer an Enterprise account, any users that register for Amazon Chime with an email address from your claimed domains are automatically added to your account\. If you configured Active Directory or Okta, the users must also be members of the directory group you configured for Amazon Chime\.

**To invite users to an Enterprise account**
+ Send an invitation email to the users in your organization and instruct them to follow the steps in [Creating an Amazon Chime account](https://docs.aws.amazon.com/chime/latest/ug/chime-create-account.html) in the *Amazon Chime User Guide*\.

Users sign in with an email address from one of the domains that you claimed for your account\. After they complete the steps to create their Amazon Chime user accounts, they automatically appear under your Enterprise account **Users** in the Amazon Chime console\.

The following procedure suspends users from an Enterprise account that does not have Active Directory or Okta configured\. This prevents the users from signing in to Amazon Chime\.

**To suspend users from an Enterprise account**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Accounts**, choose the name of the Enterprise account\.

1. Choose **Users**\.

1. Select the users to suspend and choose **Actions**, **Suspend user**\.

1. Select the check box and choose **Suspend**\.

If you have Active Directory or Okta configured for your Enterprise account, use the following procedure to suspend users\.

**To suspend users from an Enterprise Active Directory or OpenID Connect \(Okta\) account**
+ Do one of the following:
  + From your Active Directory or Okta Administrator Dashboard, suspend the user or mark them inactive\.
  + Remove the user from any Active Directory group that has Basic or Pro permissions assigned to it\.