# Granting Access to Users<a name="catalogs_portfolios_users"></a>

Give users access to portfolios by using IAM users, groups, and roles\. The best way to provide portfolio access for many users is to put the users in an IAM group and grant access to that group\. That way you can simply add and remove users from the group to manage portfolio access\. For more information, see [IAM Users and Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_WorkingWithGroupsAndUsers.html) in the *IAM User GuideUsing IAM*\.

In addition to access to a portfolio, IAM users must also have access to the AWS Service Catalog end user console\. You grant access to the console by applying permissions in IAM\. For more information, see [Identity and Access Management in AWS Service Catalog](controlling_access.md)\.

**To grant portfolio access to users or groups**

1. In the portfolio details page, expand **Users, groups and roles**, and then choose **Add user, group or role**\.

1. Choose the **Groups**, **Users**, or **Roles** tab to add groups, users, or roles, respectively\.

1. Choose one or more users, groups, or roles, and then choose **Add Access** to grant them access to the current portfolio\.
**Tip**  
To grant access to a combination of groups, users, and roles, you can switch between the tabs without losing your selection\.

**To remove access to a portfolio**

1. On the portfolio details page, choose the checkbox for the user or group\.

1. Choose **Remove user, group or role**\.