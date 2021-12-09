# Using service\-linked roles for Trusted Advisor<a name="using-service-linked-roles-ta"></a>

AWS Trusted Advisor uses the AWS Identity and Access Management \(IAM\) [service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html)\. A service\-linked role is a unique IAM role that is linked directly to AWS Trusted Advisor\. Service\-linked roles are predefined by Trusted Advisor, and they include all the permissions that the service requires to call other AWS services on your behalf\. Trusted Advisor uses this role to check your usage across AWS and to provide recommendations to improve your AWS environment\. For example, Trusted Advisor analyzes your Amazon Elastic Compute Cloud \(Amazon EC2\) instance use to help you reduce costs, increase performance, tolerate failures, and improve security\.

**Note**  
AWS Support uses a separate IAM service\-linked role for accessing your account's resources to provide billing, administrative, and support services\. For more information, see [Using service\-linked roles for AWS Support](using-service-linked-roles-sup.md)\.

For information about other services that support service\-linked roles, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html)\. Look for the services that have **Yes** in the **Service\-linked role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

**Topics**
+ [Service\-linked role permissions for Trusted Advisor](#service-linked-role-permissions-ta)
+ [Manage permissions for service\-linked roles](#manage-permissions-for-slr)
+ [Creating a service\-linked role for Trusted Advisor](#create-service-linked-role-ta)
+ [Editing a service\-linked role for Trusted Advisor](#edit-service-linked-role-ta)
+ [Deleting a service\-linked role for Trusted Advisor](#delete-service-linked-role-ta)

## Service\-linked role permissions for Trusted Advisor<a name="service-linked-role-permissions-ta"></a>

Trusted Advisor uses two service\-linked roles:
+ [AWSServiceRoleForTrustedAdvisor](https://console.aws.amazon.com/iam/home?#/roles/AWSServiceRoleForTrustedAdvisor) – This role trusts the Trusted Advisor  service to assume the role to access AWS services on your behalf\. The role permissions policy allows Trusted Advisor read\-only access for all AWS resources\. This role simplifies getting started with your AWS account, because you don't have to add the necessary permissions for Trusted Advisor\. When you open an AWS account, Trusted Advisor creates this role for you\. The defined permissions include the trust policy and the permissions policy\. You can't attach the permissions policy to any other IAM entity\.
+ [AWSServiceRoleForTrustedAdvisorReporting](https://console.aws.amazon.com/iam/home?#/roles/AWSServiceRoleForTrustedAdvisorReporting) – This role trusts the Trusted Advisor  service to assume the role for the organizational view feature\. This role enables Trusted Advisor as a trusted service in your AWS Organizations organization\. Trusted Advisor creates this role for you when you enable organizational view\. Use this feature to create reports for Trusted Advisor check results for all accounts in your organization\. For more information, see [Organizational view for AWS Trusted Advisor](organizational-view.md)\.

## Manage permissions for service\-linked roles<a name="manage-permissions-for-slr"></a>

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. The following examples use the `AWSServiceRoleForTrustedAdvisor` service\-linked role\.

**Example : Allow an IAM entity to create the `AWSServiceRoleForTrustedAdvisor` service\-linked role**  

This step is necessary only if the Trusted Advisor account is disabled, the service\-linked role is deleted, and the user must recreate the role to reenable Trusted Advisor\.

You can add the following statement to the permissions policy for the IAM entity to create the service\-linked role\.

```
{
    "Effect": "Allow",
    "Action": [
        "iam:CreateServiceLinkedRole",
        "iam:PutRolePolicy"
    ],
    "Resource": "arn:aws:iam::*:role/aws-service-role/trustedadvisor.amazonaws.com/AWSServiceRoleForTrustedAdvisor*",
    "Condition": {"StringLike": {"iam:AWSServiceName": "trustedadvisor.amazonaws.com"}}
}
```

**Example : **Allow an IAM entity to edit the description of the `AWSServiceRoleForTrustedAdvisor` service\-linked role****  

You can only edit the description for the `AWSServiceRoleForTrustedAdvisor` role\. You can add the following statement to the permissions policy for the IAM entity to edit the description of a service\-linked role\.

```
{
    "Effect": "Allow",
    "Action": [
        "iam:UpdateRoleDescription"
    ],
    "Resource": "arn:aws:iam::*:role/aws-service-role/trustedadvisor.amazonaws.com/AWSServiceRoleForTrustedAdvisor*",
    "Condition": {"StringLike": {"iam:AWSServiceName": "trustedadvisor.amazonaws.com"}}
}
```

**Example : Allow an IAM entity to delete the `AWSServiceRoleForTrustedAdvisor` service\-linked role**  

You can add the following statement to the permissions policy for the IAM entity to delete a service\-linked role\.

```
{
    "Effect": "Allow",
    "Action": [
        "iam:DeleteServiceLinkedRole",
        "iam:GetServiceLinkedRoleDeletionStatus"
    ],
    "Resource": "arn:aws:iam::*:role/aws-service-role/trustedadvisor.amazonaws.com/AWSServiceRoleForTrustedAdvisor*",
    "Condition": {"StringLike": {"iam:AWSServiceName": "trustedadvisor.amazonaws.com"}}
}
```

You can also use an AWS managed policy, such as [AdministratorAccess](https://console.aws.amazon.com/iam/home#policies/arn:aws:iam::aws:policy/AdministratorAccess), to provide full access to Trusted Advisor\.

## Creating a service\-linked role for Trusted Advisor<a name="create-service-linked-role-ta"></a>

You don't need to manually create the `AWSServiceRoleForTrustedAdvisor` service\-linked role\. When you open an AWS account, Trusted Advisor creates the service\-linked role for you\.

**Important**  
If you were using the Trusted Advisor service before it began supporting service\-linked roles, then Trusted Advisor already created the `AWSServiceRoleForTrustedAdvisor` role in your account\. To learn more, see [A new role appeared in my IAM account](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_roles.html#troubleshoot_roles_new-role-appeared) in the *IAM User Guide*\.

If your account doesn't have the `AWSServiceRoleForTrustedAdvisor` service\-linked role, then Trusted Advisor won't work as expected\. This can happen if someone in your account disabled Trusted Advisor and then deleted the service\-linked role\. In this case, you can use IAM to create the `AWSServiceRoleForTrustedAdvisor` service\-linked role, and then reenable Trusted Advisor\.

**To enable Trusted Advisor \(console\)**

1.  Use the IAM console, AWS CLI, or the IAM API to create a service\-linked role for Trusted Advisor\. For more information, see [Creating a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role)\.

1. Sign in to the AWS Management Console, and then navigate to the Trusted Advisor console at [https://console.aws.amazon.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor)\.

   The **Disabled Trusted Advisor** status banner appears in the console\.

1. Choose **Enable Trusted Advisor Role** from the status banner\. If the required `AWSServiceRoleForTrustedAdvisor` isn't detected, the disabled status banner remains\.

## Editing a service\-linked role for Trusted Advisor<a name="edit-service-linked-role-ta"></a>

You can't change the name of a service\-linked role because various entities might reference the role\. However, you can use the IAM console, AWS CLI, or the IAM API to edit the description of the role\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for Trusted Advisor<a name="delete-service-linked-role-ta"></a>

If you don't need to use the features or services of Trusted Advisor, you can delete the `AWSServiceRoleForTrustedAdvisor` role\. You must disable Trusted Advisor before you can delete this service\-linked role\. This prevents you from removing permissions required by Trusted Advisor operations\. When you disable Trusted Advisor, you disable all service features, including offline processing and notifications\. Also, if you disable Trusted Advisor for a linked account, then the separate payer account is also affected, which means you won't receive Trusted Advisor checks that identify ways to save costs\. You can't access the Trusted Advisor console\. API calls to Trusted Advisor return an access denied error\.

You must recreate the `AWSServiceRoleForTrustedAdvisor` service\-linked role in the account before you can reenable Trusted Advisor\.

You must first disable Trusted Advisor in the console before you can delete the `AWSServiceRoleForTrustedAdvisor` service\-linked role\. 

**To disable Trusted Advisor**

1. Sign in to the AWS Management Console and navigate to the Trusted Advisor console at [https://console.aws.amazon.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor)\.

1. In the navigation pane, choose **Preferences**\.

1. In the **Service Linked Role Permissions** section, choose **Disable Trusted Advisor**\.

1. In the confirmation dialog box, choose **OK** to confirm that you want to disable Trusted Advisor\.

After you disable Trusted Advisor, all Trusted Advisor functionality is disabled, and the Trusted Advisor console displays only the disabled status banner\.

You can then use the IAM console, the AWS CLI, or the IAM API to delete the Trusted Advisor service\-linked role named `AWSServiceRoleForTrustedAdvisor`\. For more information, see [Deleting a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.