# Federated User Access to AWS CodeStar<a name="access-permissions-federated"></a>

Instead of creating an IAM user or using the root user, you can use user identities from AWS Directory Service, your enterprise user directory, a web identity provider, or IAM users assuming roles\. These are known as *federated users*\.

Grant federated users access to your AWS CodeStar project by manually attaching the managed policies described in [AWS CodeStar Project\-Level Policies and Permissions](access-permissions-proj.md) to the user's IAM role\. You attach the owner, contributor, or viewer policy after AWS CodeStar creates your project resources and IAM roles\. 

**Prerequisites: **
+ You must have set up an identity provider\. For more information, see [Creating IAM Identity Providers](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_create.html)\. For example, you could have a SAML identity provider set up and AWS authentication set up through the provider\. For more information about SAML federation, see [About SAML 2\.0\-based Federation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_saml.html)\.
+ You must have created a role for a federated user to assume when access is requested through an [identity provider](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html)\. An STS trust policy must be attached to the role that allows federated users to assume the role\. For more information, see [Federated Users and Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_access-management.html#intro-access-roles) in the *IAM User Guide*\.
+ You must have created your AWS CodeStar project and know the project ID\.

For more information about creating a role for identity providers, see [Creating a Role for a Third\-Party Identity Provider \(Federation\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-idp.html)\.

## Attach the `AWSCodeStarFullAccess` Managed Policy to the Federated User's Role<a name="access-permissions-federated-attach-FullAccess"></a>

Grant a federated user permissions to create a project by attaching the `AWSCodeStarFullAccess` managed policy\. To perform these steps, you must have signed in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated `AdministratorAccess` managed policy or equivalent\.

**Note**  
After you create the project, your project owner permissions are not applied automatically\. Using a role with administrative permissions for your account, attach the owner managed policy, as described in [Attach Your Project's AWS CodeStar Viewer/Contributor/Owner Managed Policy to the Federated User's Role](#access-permissions-federated-attach-CodeStar)\.

1. Open the IAM console\. In the navigation pane, choose **Policies**\.

1. Enter `AWSCodeStarFullAccess` in the search field\. The policy name is displayed, with a policy type of **AWS managed**\. You can expand the policy to see the permissions in the policy statement\.

1. Select the circle next to the policy, and then under **Policy actions**, choose **Attach**\.

1. On the **Summary** page, choose the **Attached entities** tab\. Choose **Attach**\.

1. On the **Attach Policy** page, filter for the federated user's role in the search field\. Select the box next to the name of the role, and then choose **Attach policy**\. The **Attached entities** tab shows the new attachment\.

## Attach Your Project's AWS CodeStar Viewer/Contributor/Owner Managed Policy to the Federated User's Role<a name="access-permissions-federated-attach-CodeStar"></a>

Grant federated users access to your project by attaching the appropriate owner, contributor, or viewer managed policy to the user's role\. The managed policy gives the appropriate level of permissions\. Unlike IAM users, you need to manually attach and detach managed policies for federated users\. This is equivalent to assigning project permissions to team members in AWS CodeStar\. To perform these steps, you must have signed in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated `AdministratorAccess` managed policy or equivalent\.

**Prerequisites:**
+ You must have created a role or have an existing role that your federated user assumes\.
+ You must know which level of permissions you want to grant\. The managed policies attached to the owner, contributor, and viewer roles provide role\-based permissions for your project\.
+ Your AWS CodeStar project must have been created\. The managed policy is not available in IAM until the project is created\.

1. Open the IAM console\. In the navigation pane, choose **Policies**\.

1. Enter your project ID in the search field\. The policy name matching your project is displayed, with a policy type of **Customer managed**\. You can expand the policy to see the permissions in the policy statement\.

1. Choose one of these managed policies\. This example attaches a viewer managed policy\. Select the circle next to the policy, and then under **Policy actions**, choose **Attach**\.

1. On the **Summary** page, choose the **Attached entities** tab\. Choose **Attach**\.

1. On the **Attach Policy** page, filter for the federated user's role in the search field\. Select the box next to the name of the role and then choose **Attach policy**\. The **Attached entities** tab shows the new attachment\.

## Detach an AWS CodeStar Managed Policy from the Federated User's Role<a name="access-permissions-federated-detach-CodeStar"></a>

Before you delete your AWS CodeStar project, you must manually detach any managed policies you attached to a federated user's role\. To perform these steps, you must have signed in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated `AdministratorAccess` managed policy or equivalent\.

1. Open the IAM console\. In the navigation pane, choose **Policies**\.

1. Enter your project ID in the search field\.

1. Select the circle next to the policy, and then under **Policy actions**, choose **Attach**\.

1. On the **Summary** page, choose the **Attached entities** tab\.

1. Filter for the federated user's role in the search field\. Choose **Detach**\.

## Attach an AWS Cloud9 Managed Policy to the Federated User's Role<a name="access-permissions-federated-attach-Cloud9"></a>

Grant federated users access to your AWS Cloud9 environment by attaching the `AWSCloud9User` managed policy to the user's role\. Unlike IAM users, you must manually attach and detach managed policies for federated users\. To perform these steps, you must have signed in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated `AdministratorAccess` managed policy or equivalent\.

**Prerequisites:**
+ You must have created a role or have an existing role that your federated user assumes\.
+ You must know which level of permissions you want to grant:
  + The `AWSCloud9User` managed policy allows the user to do the following:
    + Create their own AWS Cloud9 development environments\.
    + Get information about their environments\.
    + Change the settings for their environments\.
  + The `AWSCloud9Administrator` managed policy allows the user to do the following for themselves or others:
    + Create environments\.
    + Get information about environments\.
    + Delete environments\.
    + Change the settings of environments\.

1. Open the IAM console\. In the navigation pane, choose **Policies**\.

1. Enter the policy name in the search field\. This example searches for the `AWSCloud9User` managed policy\. The managed policy is displayed, with a policy type of **AWS managed**\. You can expand the policy to see the permissions in the policy statement\.

1. Choose one of these managed policies\. This example attaches the `AWSCloud9User` managed policy\. Select the circle next to the policy, and then under **Policy actions**, choose **Attach**\.

1. On the **Summary** page, choose the **Attached entities** tab\. Choose **Attach**\.

1. On the **Attach Policy** page, filter for the federated user's role in the search field\. Choose the box next to the name of the role and then choose **Attach policy**\. The **Attached entities** tab shows the new attachment\.

## Detach an AWS Cloud9 Managed Policy from the Federated User's Role<a name="access-permissions-federated-detach-Cloud9"></a>

To remove a federated user's AWS Cloud9 permissions, detach the policy\. To perform these steps, you must have signed in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated `AdministratorAccess` managed policy or equivalent\.

1. Open the IAM console\. In the navigation pane, choose **Policies**\.

1. Enter your project name in the search field\.

1. Select the circle next to the policy, and then under **Policy actions**, choose **Attach**\.

1. On the **Summary** page, choose the **Attached entities** tab\.

1. Filter for the federated user's role in the search field\. Choose **Detach**\.