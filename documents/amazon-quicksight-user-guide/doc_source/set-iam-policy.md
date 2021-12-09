# Setting Your IAM Policy<a name="set-iam-policy"></a>

You can use AWS root credentials or IAM user credentials to create an Amazon QuickSight account\. AWS root and administrator credentials already have all of the required permissions for managing Amazon QuickSight access to AWS resources\. 

However, we recommend that you protect your root credentials, and instead use IAM user credentials\. To do this, you can create a policy and attach it to the IAM user and roles that you plan to use for Amazon QuickSight\. The policy must include the appropriate statements for the Amazon QuickSight administrative tasks you need to perform, as described in the following sections\.

**Important**  
Be aware of the following when working with Amazon QuickSight and IAM policies:  
Avoid directly modifying a policy that was created by Amazon QuickSight\. When you modify it yourself, Amazon QuickSight can't edit it\. This inability can cause an issue with the policy\. To fix this issue, delete the previously modified policy\. 
If you get an error on permissions when you try to create an Amazon QuickSight account, see [IAM Policy Actions for Creating Users in Amazon QuickSight](#iam-policy-actions-for-creating-users-inside-quicksight)\. 
In some cases, you might have an Amazon QuickSight account that you can't access even from the root account \(for example, if you accidentally deleted its directory service\)\. In this case, you can delete your old Amazon QuickSight account, then recreate it\. For more information, see [Canceling Your Amazon QuickSight Subscription and Closing the Account](closing-account.md)\.

## IAM Policy Actions for Signing Up for Amazon QuickSight<a name="iam-policy-actions-for-signing-up-for-quicksight"></a>

To allow a user to sign up and set permissions to AWS resources for Amazon QuickSight, allow the following actions in an IAM policy\. For more information, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\. 

The permissions for signing up don't allow you to fully use Amazon QuickSight\. However, a user with the AWS root and administrator credentials can subscribe to Amazon QuickSight with no additional actions needed\.


****  

| Standard Edition | Enterprise Edition | 
| --- | --- | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  |  Allow all of the actions required for Standard edition, plus the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  | 

## IAM Policy Actions for Creating Users in Amazon QuickSight<a name="iam-policy-actions-for-creating-users-inside-quicksight"></a>

To allow a user to create users and administrators in Amazon QuickSight, allow the following actions in an IAM policy\. For more information, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 


****  

| Standard Edition | Enterprise Edition | 
| --- | --- | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  | 

## IAM Policy Actions for Setting AWS Resource Permissions in Amazon QuickSight<a name="iam-policy-actions-for-setting-aws-resource-permissions-in-quicksight"></a>

To allow a user to set permissions to use AWS resources inside Amazon QuickSight, allow the following actions in an IAM policy\. For more information, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\.


****  

| Standard Edition | Enterprise Edition | 
| --- | --- | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  |  Allow the same actions as required for Standard edition\.  | 

## IAM Policy Actions for Managing Directory Group Associations to Microsoft Active Directory or AD Connector from Amazon QuickSight<a name="iam-policy-actions-for-AD-for-quicksight"></a>

For Enterprise edition only, to allow a user to manage directory group associations to Microsoft Active Directory or AD Connector from Amazon QuickSight, allow the following actions in an IAM policy\. For more information, see [Managing User Accounts in Amazon QuickSight Enterprise Edition](managing-users-enterprise.md)\.


****  

| Standard Edition | Enterprise Edition | 
| --- | --- | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  | 

## IAM Policy Actions for Unsubscribing from Amazon QuickSight<a name="iam-policy-actions-for-unsubscribing-from-quicksight"></a>

To allow a user to unsubscribe from Amazon QuickSight, allow the following actions in an IAM policy\. Unsubscribing removes all users and data, and you can't undo this operation\. For more information, see [Canceling Your Amazon QuickSight Subscription and Closing the Account](closing-account.md)\. 

To prevent Amazon QuickSight administrators from unsubscribing from Amazon QuickSight and deleting all users and data, you can deny all users the `quicksight:Unsubscribe` action\. Then, if users try to unsubscribe, they get a message to contact their AWS administrator\.


****  

| Standard Edition | Enterprise Edition | 
| --- | --- | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  | 

## IAM Policy Actions for Embedding Dashboards with Amazon QuickSight<a name="iam-policy-actions-for-embedded-dashboards"></a>

To allow a user to invoke an embedded dashboard from Amazon QuickSight, allow the following actions in an IAM policy\. In the policy, you need to supply the dashboard IDs for the dashboards that can be embedded\. For an example, see [IAM Policy Examples for Amazon QuickSight Dashboard Embedding ](#iam-policy-examples-for-dashboard-embedding)\. 


****  

| Standard Edition | Enterprise Edition | 
| --- | --- | 
|     |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/set-iam-policy.html)  | 

### IAM Policy Examples for Amazon QuickSight Dashboard Embedding<a name="iam-policy-examples-for-dashboard-embedding"></a>

The following example shows an IAM policy that enables dashboard sharing for specific dashboards\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": "quicksight:RegisterUser",
            "Resource": "*",
            "Effect": "Allow"
        },
        {
            "Action": "quicksight:GetDashboardEmbedUrl",
            "Resource": "arn:aws:quicksight:us-west-2:111122223333:dashboard/1a1ac2b2-3fc3-4b44-5e5d-c6db6778df89",
            "Effect": "Allow"
        }
    ]
}
```

## IAM Policy Examples for Amazon QuickSight<a name="iam-policy-examples-for-quicksight"></a>

Following, you can find several IAM policy examples for Amazon QuickSight\.

The following example shows an IAM policy that enables Active Directory group management for an Amazon QuickSight Enterprise edition account\.

```
{
    "Statement": [
        {
            "Action": [
                "ds:DescribeTrusts",
                "quicksight:GetGroupMapping",
                "quicksight:SearchDirectoryGroups",
                "quicksight:SetGroupMapping"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ],
    "Version": "2012-10-17"
}
```

The following example shows a policy that enables creating Amazon QuickSight users only\. For `quicksight:CreateReader`, `quicksight:CreateUser`, and `quicksight:CreateAdmin`, you can limit the permissions to **"Resource": "arn:aws:quicksight::<**YOUR\_AWS\_ACCOUNTID**>:user/$\{aws:userid\}"**\. For all other permissions described in this guide, use **"Resource": "\*"**\. The resource represents the scope of the permissions\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "quicksight:CreateUser"
            ],
            "Effect": "Allow",
            "Resource": "arn:aws:quicksight::<YOUR_AWS_ACCOUNTID>:user/${aws:userid}"
        }
    ]
}
```

The following example for Amazon QuickSight Enterprise edition shows a policy that enables subscribing, creating users, managing Active Directory, and setting permissions to AWS resources\. This example explicitly denies permission to unsubscribe from Amazon QuickSight\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "ds:AuthorizeApplication",
                "ds:UnauthorizeApplication",
                "ds:CheckAlias",
                "ds:CreateAlias",
                "ds:DescribeDirectories",
                "ds:DescribeTrusts",
                "ds:DeleteDirectory",
                "ds:CreateIdentityPoolDirectory",
                "iam:CreatePolicy",
                "iam:CreateRole",
                "iam:ListAccountAliases",
                "quicksight:CreateAdmin",
                "quicksight:Subscribe",
                "quicksight:GetGroupMapping",
                "quicksight:SearchDirectoryGroups",
                "quicksight:SetGroupMapping"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "iam:AttachRolePolicy",
                "iam:DetachRolePolicy",
                "iam:ListAttachedRolePolicies",
                "iam:CreatePolicy",
                "iam:GetPolicy",
                "iam:CreatePolicyVersion",
                "iam:DeletePolicyVersion",
                "iam:GetPolicyVersion",
                "iam:ListPolicyVersions",
                "iam:CreateRole",
                "iam:DeleteRole",
                "iam:GetRole",
                "iam:ListRoles",
                "iam:ListEntitiesForPolicy",
                "s3:ListAllMyBuckets"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": "quicksight:Unsubscribe",
            "Resource": "*"
        }
    ]
}
```

The following example for Amazon QuickSight Standard Edition shows a policy that enables subscribing, creating authors and readers, and setting permissions to AWS resources\. This example explicitly denies permission to unsubscribe from Amazon QuickSight\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "ds:AuthorizeApplication",
                "ds:UnauthorizeApplication",
                "ds:CheckAlias",
                "ds:CreateAlias",
                "ds:DescribeDirectories",
                "ds:DescribeTrusts",
                "ds:DeleteDirectory",
                "ds:CreateIdentityPoolDirectory",
                "iam:CreatePolicy",
                "iam:CreateRole",
                "iam:ListAccountAliases",
                "quicksight:CreateUser",
                "quicksight:Subscribe"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "iam:AttachRolePolicy",
                "iam:DetachRolePolicy",
                "iam:ListAttachedRolePolicies",
                "iam:CreatePolicy",
                "iam:GetPolicy",
                "iam:CreatePolicyVersion",
                "iam:DeletePolicyVersion",
                "iam:GetPolicyVersion",
                "iam:ListPolicyVersions",
                "iam:CreateRole",
                "iam:DeleteRole",
                "iam:GetRole",
                "iam:ListRoles",
                "iam:ListEntitiesForPolicy",
                "s3:ListAllMyBuckets"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": 
                "quicksight:Unsubscribe",
            "Resource": "*"
        }
    ]
}
```

For information about Amazon QuickSight actions like `quicksight:GetGroupMapping`, see [Working with IAM Actions and Permissions for Amazon QuickSight Users](iam-actions.md)\.