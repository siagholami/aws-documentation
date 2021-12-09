# Grant permission to Amazon WorkDocs API for third\-party developer AWS account<a name="wd-iam-crossacct"></a>

You can grant access to third\-party developers, or to users who are using a different AWS account\. To do this, create an IAM role, and attach Amazon WorkDocs API allow policies\.

This form of access is required in the following scenarios:
+ Developer belongs to the same organization but the developer’s AWS account is different from the Amazon WorkDocs AWS account\. 
+ When an enterprise would like to grant Amazon WorkDocs API access to third\-party application developers\.

In both of these scenarios, there are two AWS accounts involved, a developer’s AWS account and a different account hosting a Amazon WorkDocs site\.

The developer will need to provide the following information so the account administrator can create the IAM role:
+ Your AWS account ID
+ A unique `External ID` that your customer will use to identify you\. For more information, see [How to Use an External ID When Granting Access to Your AWS Resources to a Third Party](url-iam-user;id_roles_create_for-user_externalid.html)\.
+ A list of Amazon WorkDocs APIs your application needs access to\. IAM based policy control provides granular control, the ability to define allow or deny policies at the individual API level\. For the list of Amazon WorkDocs APIs, see [Amazon WorkDocs API Reference](https://docs.aws.amazon.com/workdocs/latest/APIReference/)\.

The following procedure describes steps involved in configuring IAM for cross\-account access\.

**To configure IAM for cross\-account access**

1. Create a Amazon WorkDocs API permission policy, call it `WorkDocsAPIReadOnly` policy\.

1. Create a new role in the IAM console of the AWS account hosting the Amazon WorkDocs site:

   1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

   1. In the navigation pane of the console, click **Roles** and then click **Create New Role**\.

   1. For **Role name**, type a role name to help identify the purpose of this role, for example `workdocs_app_role`\. Role names must be unique within your AWS account\. After you enter the name, click **Next Step**\.

   1. On the **Select Role Type** page, select the **Role for Cross\-Account Access** section, and then select the type of role that you want to create:
      + Select **Provide access between AWS accounts you own** if you are the administrator of both the user account and the resource account, or both accounts belong to the same company\. This is also the option to select when the users, role, and resource to be accessed are all in the same account\.
      + Select **Provide access between your AWS account and a third\-party AWS account** if you are the administrator of the account that owns the Amazon WorkDocs site and you want to grant permissions to users from an Application developer account\. This option requires you to specify an external ID \(which the third party must provide to you\) to provide additional control over the circumstances in which the third party can use the role to access your resources\. For more information, see [How to Use an External ID When Granting Access to Your AWS Resources to a Third Party](url-iam-user;id_roles_create_for-user_externalid.html)\.

   1. On the next page, specify the AWS account ID to which you want to grant access to your resources and also enter **External ID** in case of third\-party access\.

   1. Click **Next Step** to attach a policy\.

1. On the **Attach Policy** page, search for the Amazon WorkDocs API permission policy that was created earlier and select the box next to the policy and click **Next Step**\.

1. Review the details, copy the role ARN for future reference and click **Create Role** to complete the creation of the role\.

1. Share the role ARN with the developer\. The following is an example of the role ARN:

   ```
   arn:aws:iam::AWS-ACCOUNT-ID:role/workdocs_app_role
   ```