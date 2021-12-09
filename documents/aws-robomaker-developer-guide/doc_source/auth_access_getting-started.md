# Getting Started with IAM<a name="auth_access_getting-started"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that allows you manage access to services and resources securely\. IAM is a feature of your AWS account offered at no additional charge\.

**Note**  
Before you start with IAM, review the introductory information on [Authentication and Access Control for AWS RoboMaker](auth-and-access-control.md)\.

  When you first create an AWS account, you begin with a single sign\-in identity that has complete access to all AWS services and resources in the account\. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account\. We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, adhere to the [best practice of using the root user only to create your first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\. 

## Create your IAM Admin User<a name="auth_access_setup-iam-admin"></a>

**To create an administrator user for yourself and add the user to an administrators group \(console\)**

1. Use your AWS account email address and password to sign in as the *[AWS account root user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_root-user.html)* to the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.
**Note**  
We strongly recommend that you adhere to the best practice of using the **Administrator** IAM user below and securely lock away the root user credentials\. Sign in as the root user only to perform a few [account and service management tasks](https://docs.aws.amazon.com/general/latest/gr/aws_tasks-that-require-root.html)\.

1. In the navigation pane, choose **Users** and then choose **Add user**\.

1. For **User name**, enter **Administrator**\.

1. Select the check box next to **AWS Management Console access**\. Then select **Custom password**, and then enter your new password in the text box\.

1. \(Optional\) By default, AWS requires the new user to create a new password when first signing in\. You can clear the check box next to **User must create a new password at next sign\-in** to allow the new user to reset their password after they sign in\.

1. Choose **Next: Permissions**\.

1. Under **Set permissions**, choose **Add user to group**\.

1. Choose **Create group**\.

1. In the **Create group** dialog box, for **Group name** enter **Administrators**\.

1. Choose **Filter policies**, and then select **AWS managed \-job function** to filter the table contents\.

1. In the policy list, select the check box for **AdministratorAccess**\. Then choose **Create group**\.
**Note**  
You must activate IAM user and role access to Billing before you can use the `AdministratorAccess` permissions to access the AWS Billing and Cost Management console\. To do this, follow the instructions in [step 1 of the tutorial about delegating access to the billing console](https://docs.aws.amazon.com/IAM/latest/UserGuide/tutorial_billing.html)\.

1. Back in the list of groups, select the check box for your new group\. Choose **Refresh** if necessary to see the group in the list\.

1. Choose **Next: Tags**\.

1. \(Optional\) Add metadata to the user by attaching tags as key\-value pairs\. For more information about using tags in IAM, see [Tagging IAM Entities](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_tags.html) in the *IAM User Guide*\.

1. Choose **Next: Review** to see the list of group memberships to be added to the new user\. When you are ready to proceed, choose **Create user**\.

You can use this same process to create more groups and users and to give your users access to your AWS account resources\. To learn about using policies that restrict user permissions to specific AWS resources, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) and [Example Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_examples.html)\.

## Create Delegated Users for AWS RoboMaker<a name="auth_access_setup-iam-delegated"></a>

To support multiple users in your AWS account, you must delegate permission to allow other people to perform only the actions you want to allow\. To do this, create an IAM group with the permissions those people need and then add IAM users to the necessary groups as you create them\. You can use this process to set up the groups, users, and permissions for your entire AWS account\. This solution is best used by small and medium organizations where an AWS administrator can manually manage the users and groups\. For large organizations, you can use [custom IAM roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-custom-url.html), [federation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html), or [single sign\-on](https://docs.aws.amazon.com/singlesignon/latest/userguide/what-is.html)\.

In the following task, you will create three users named **arnav**, **carlos**, and **martha** and attach a policy that grants permission to create a robot application named **my\-example\-robot\-application**, but only within the next 30 days\. You can use the steps provided here to add users with different permissions\.

**To create a delegated user for someone else \(console\)**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Users** and then choose **Add user**\.

1. For **User name**, enter **arnav**\.

1. Choose **Add another user** and enter **carlos** for the second user\. Then choose **Add another user** and enter **martha** for the third user\.

1. Select the check box next to **AWS Management Console access** and select **Autogenerated password**\.

1. Clear the check box next to **User must create a new password at next sign\-in** to allow the new user to reset their password after they sign in\.

1. Choose **Next: Permissions**\.

1. Choose **Attach existing policies directly**\. You will create a new managed policy for the users\.

1. Choose **Create policy**\.

   The **Create policy** wizard opens in a new tab or browser window\.

1. On the **Visual editor** tab, choose **Choose a service**\. Then choose AWS RoboMaker\. You can use the search box at the top to limit the results in the list of services\.

   The **Service** section closes and the **Actions** section opens automatically\.

1. Choose the AWS RoboMaker actions that you want to allow\. For example, to grants permission to create a robot application, enter **CreateRobotApplication** in the Filter actions text box\. When the list of AWS RoboMaker actions is filtered, choose the check box next to **CreateRobotApplication**\.

   The AWS RoboMaker actions are grouped by access level classification to make it easy for you to quickly determine the level of access that each action provides\. For more information, see [Policy Access Level Classifications](auth_access_what-are-policies.md#auth_access_policies-access-level)\.

1. If the actions that you selected in the previous steps do not support choosing specific resources, then **All resources** is selected for you\. In that case, you cannot edit this section\.

   If you chose one or more actions that support resource\-level permissions, then the visual editor lists those resource types in the **Resources** section\. Choose **You chose actions that require the **robot application** resource type** to choose whether you want to enter a specific robot application for your policy\. 

1. If you want to allow the `CreateRobotApplication` action for all resources, choose **All resources**\.

   If you want to specify a resource, choose **Add ARN**\. Specify the region and account ID \(or account ID\) \(or choose **Any**\), and then enter **my\-example\-robot\-application** for the resource\. Then choose **Add**\.

1. Choose **Specify request conditions \(optional\)**\.

1. Choose **Add condition** to grants permission to create a robot application within the next 7 days\. Assume that today's date is January 1, 2019\. 

1. For **Condition Key**, choose **aws:CurrentTime**\. This condition key checks the date and time that the user makes the request\. It returns true \(and therefore allows the **CreateRobotApplication** action only if the date and time are within the specified range\.

1. For **Qualifier**, leave the default value\.

1. To specify the start of the allowed date and time range, for **Operator**, choose **DateGreaterThan**\. Then for **Value**, enter **2019\-01\-01T00:00:00Z**\.

1. Choose **Add** to save your condition\.

1. Choose **Add another condition** to specify the end date\.

1. Follow similar steps to specify the end of the allowed date and time range\. For **Condition Key**, choose **aws:CurrentTime**\. For **Operator**, choose **DateLessThan**\. For **Value**, enter **2019\-01\-06T23:59:59Z**, seven days after the first date\. Then choose **Add** to save your condition\.

1. \(Optional\) To see the JSON policy document for the policy you are creating, choose the **JSON** tab\. You can switch between the **Visual editor** and **JSON** tabs any time\. However, if you make changes or choose **Review policy** in the **Visual editor** tab, IAM might restructure your policy to optimize it for the visual editor\. For more information, see [Policy Restructuring](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_policies.html#troubleshoot_viseditor-restructure) in the *IAM User Guide*\.

1. When you are finished, choose **Review policy**\.

1. On the **Review policy** page, for **Name**, enter **CreateRobotApplicationPolicy** and for the **Description**, enter **Policy to grants permission to create a robot application**\. Review the policy summary to make sure that you have granted the intended permissions, and then choose **Create policy** to save your new policy\.

1. Return to the original tab or window, and refresh your list of policies\. 

1. In the search box, enter **CreateRobotApplicationPolicy**\. Select the check box next to your new policy\. Then choose **Next Step**\.

1. Choose **Next: Review** to preview your new users\. When you are ready to proceed, choose **Create users**\.

1. Download or copy the passwords for your new users and deliver them to the users securely\. Separately, provide your users with a [link to your IAM user console page](https://docs.aws.amazon.com/IAM/latest/UserGuide/console.html#user-sign-in-page) and the user names you just created\.

## Allow Users to Self\-Manage Their Credentials<a name="auth_access_manage-password-mfa"></a>

You must have physical access to the hardware that will host the user's virtual MFA device in order to configure MFA\. For example, you might configure MFA for a user who will use a virtual MFA device running on a smartphone\. In that case, you must have the smartphone available in order to finish the wizard\. Because of this, you might want to let users configure and manage their own virtual MFA devices\. In that case, you must grant users the permissions to perform the necessary IAM actions\.

**To create a policy to allow credential self\-management \(console\)**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**, and then choose **Create policy**\.

1. Choose the **JSON** tab and copy the text from the following JSON policy document\. Paste this text into the **JSON** text box\.
**Important**  
This example policy does not allow users to reset their password while signing in\. New users and users with an expired password might try to do so\. You can allow this by adding `iam:ChangePassword` and `iam:CreateLoginProfile` to the statement `BlockMostAccessUnlessSignedInWithMFA`\. However, IAM does not recommend this\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Sid": "AllowAllUsersToListAccounts",
               "Effect": "Allow",
               "Action": [
                   "iam:ListAccountAliases",
                   "iam:ListUsers",
                   "iam:ListVirtualMFADevices",
                   "iam:GetAccountPasswordPolicy",
                   "iam:GetAccountSummary"
               ],
               "Resource": "*"
           },
           {
               "Sid": "AllowIndividualUserToSeeAndManageOnlyTheirOwnAccountInformation",
               "Effect": "Allow",
               "Action": [
                   "iam:ChangePassword",
                   "iam:CreateAccessKey",
                   "iam:CreateLoginProfile",
                   "iam:DeleteAccessKey",
                   "iam:DeleteLoginProfile",
                   "iam:GetLoginProfile",
                   "iam:ListAccessKeys",
                   "iam:UpdateAccessKey",
                   "iam:UpdateLoginProfile",
                   "iam:ListSigningCertificates",
                   "iam:DeleteSigningCertificate",
                   "iam:UpdateSigningCertificate",
                   "iam:UploadSigningCertificate",
                   "iam:ListSSHPublicKeys",
                   "iam:GetSSHPublicKey",
                   "iam:DeleteSSHPublicKey",
                   "iam:UpdateSSHPublicKey",
                   "iam:UploadSSHPublicKey"
               ],
               "Resource": "arn:aws:iam::*:user/${aws:username}"
           },
           {
               "Sid": "AllowIndividualUserToViewAndManageTheirOwnMFA",
               "Effect": "Allow",
               "Action": [
                   "iam:CreateVirtualMFADevice",
                   "iam:DeleteVirtualMFADevice",
                   "iam:EnableMFADevice",
                   "iam:ListMFADevices",
                   "iam:ResyncMFADevice"
               ],
               "Resource": [
                   "arn:aws:iam::*:mfa/${aws:username}",
                   "arn:aws:iam::*:user/${aws:username}"
               ]
           },
           {
               "Sid": "AllowIndividualUserToDeactivateOnlyTheirOwnMFAOnlyWhenUsingMFA",
               "Effect": "Allow",
               "Action": [
                   "iam:DeactivateMFADevice"
               ],
               "Resource": [
                   "arn:aws:iam::*:mfa/${aws:username}",
                   "arn:aws:iam::*:user/${aws:username}"
               ],
               "Condition": {
                   "Bool": {
                       "aws:MultiFactorAuthPresent": "true"
                   }
               }
           },
           {
               "Sid": "BlockMostAccessUnlessSignedInWithMFA",
               "Effect": "Deny",
               "NotAction": [
                   "iam:CreateVirtualMFADevice",
                   "iam:DeleteVirtualMFADevice",
                   "iam:ListVirtualMFADevices",
                   "iam:EnableMFADevice",
                   "iam:ResyncMFADevice",
                   "iam:ListAccountAliases",
                   "iam:ListUsers",
                   "iam:ListSSHPublicKeys",
                   "iam:ListAccessKeys",
                   "iam:ListServiceSpecificCredentials",
                   "iam:ListMFADevices",
                   "iam:GetAccountSummary",
                   "sts:GetSessionToken"
               ],
               "Resource": "*",
               "Condition": {
                   "BoolIfExists": {
                       "aws:MultiFactorAuthPresent": "false"
                   }
               }
           }
       ]
   }
   ```

   What does this policy do? 
   + The `AllowAllUsersToListAccounts` statement enables the user to see basic information about the account and its users in the IAM console\. These permissions must be in their own statement because they do not support or do not need to specify a specific resource ARN, and instead specify `"Resource" : "*"`\.
   + The `AllowIndividualUserToSeeAndManageOnlyTheirOwnAccountInformation` statement enables the user to manage his or her own user, password, access keys, signing certificates, SSH public keys, and MFA information in the IAM console\. It also allows users to sign in for the first time in an administrator requires them to set a first\-time password\. The resource ARN limits the use of these permissions to only the user's own IAM user entity\.
   + The `AllowIndividualUserToViewAndManageTheirOwnMFA` statement enables the user to view or manage his or her own MFA device\. Notice that the resource ARNs in this statement allow access to only an MFA device or user that has the same name as the currently signed\-in user\. Users can't create or alter any MFA device other than their own\.
   + The `AllowIndividualUserToDeactivateOnlyTheirOwnMFAOnlyWhenUsingMFA` statement allows the user to deactivate only his or her own MFA device, and only if the user signed in using MFA\. This prevents others with only the access keys \(and not the MFA device\) from deactivating the MFA device and accessing the account\.
   + The `BlockMostAccessUnlessSignedInWithMFA` statement uses a combination of `"Deny"` and `"NotAction"` to deny access to all but a few actions in IAM and other AWS services ***if*** the user is not signed\-in with MFA\. For more information about the logic for this statement, see [NotAction with Deny](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_notaction.html) in the *IAM User Guide*\. If the user is signed\-in with MFA, then the `"Condition"` test fails and the final "deny" statement has no effect and other policies or statements for the user determine the user's permissions\. This statement ensures that when the user is not signed\-in with MFA, they can perform only the listed actions and only if another statement or policy allows access to those actions\.

     The `...IfExists` version of the `Bool` operator ensures that if the `aws:MultiFactorAuthPresent` key is missing, the condition returns true\. This means that a user accessing an API with long\-term credentials, such as an access key, is denied access to the non\-IAM API operations\.

1. When you are finished, choose **Review policy**\.

1. On the **Review** page, type **Force\_MFA** for the policy name\. For the policy description, type **This policy allows users to manage their own passwords and MFA devices but nothing else unless they authenticate with MFA\.** Review the policy **Summary** to see the permissions granted by your policy, and then choose **Create policy** to save your work\.

   The new policy appears in the list of managed policies and is ready to attach\.

**To attach the policy to a user \(console\)**

1. In the navigation pane, choose **Users**\.

1. Choose the name \(not the check box\) of the user you want to edit\. 

1. On the **Permissions** tab, and choose **Add permissions**\.

1. Choose **Attach existing policies directly**\.

1. In the search box, enter **Force**, and then select the check box next to **Force\_MFA** in the list\. Then choose **Next: Review**\.

1. Review your changes and choose **Add permissions**\.

## Enable MFA for Your IAM User<a name="auth_access_enable-mfa"></a>

For increased security, we recommend that all IAM users configure multi\-factor authentication \(MFA\) to help protect your AWS RoboMaker resources\. MFA adds extra security because it requires users to provide unique authentication from an AWS\-supported MFA device in addition to their regular sign\-in credentials\. The most secure AWS MFA device is the U2F security key\. If your company already has U2F devices, then we recommend that you enable those devices for AWS\. Otherwise, you must purchase a device for each of your users and wait for the hardware to arrive\. For more information, see [Enabling a U2F Security Key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa_enable_u2f.html) in the *IAM User Guide*\. 

If you don't already have a U2F device, you can get started quickly and at a low cost by enabling a virtual MFA device\. This requires that you install a software app on an existing phone or other mobile device\. The device generates a six\-digit numeric code based upon a time\-synchronized one\-time password algorithm\. When the user signs in to AWS, they are prompted to enter a code from the device\. Each virtual MFA device assigned to a user must be unique\. A user cannot enter a code from another user's virtual MFA device to authenticate\. For a list of a few supported apps that you can use as virtual MFA devices, see [Multi\-Factor Authentication](http://aws.amazon.com/iam/details/mfa/)\.

**Note**  
You must have physical access to the mobile device that will host the user's virtual MFA device in order to configure MFA for an IAM user\.

**To enable a virtual MFA device for an IAM user \(console\)**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Users**\.

1. In the **User Name** list, choose the name of the intended MFA user\.

1. Choose the **Security credentials** tab\. Next to **Assigned MFA device**, choose **Manage**\.

1. In the **Manage MFA Device** wizard, choose **Virtual MFA device**, and then choose **Continue**\.

   IAM generates and displays configuration information for the virtual MFA device, including a QR code graphic\. The graphic is a representation of the "secret configuration key" that is available for manual entry on devices that do not support QR codes\.

1. Open your virtual MFA app\.

   For a list of apps that you can use for hosting virtual MFA devices, see [Multi\-Factor Authentication](http://aws.amazon.com/iam/details/mfa/)\. If the virtual MFA app supports multiple accounts \(multiple virtual MFA devices\), choose the option to create a new account \(a new virtual MFA device\)\.

1. Determine whether the MFA app supports QR codes, and then do one of the following:
   + From the wizard, choose **Show QR code**, and then use the app to scan the QR code\. For example, you might choose the camera icon or choose an option similar to **Scan code**, and then use the device's camera to scan the code\.
   + In the **Manage MFA Device** wizard, choose **Show secret key**, and then enter the secret key into your MFA app\.

   When you are finished, the virtual MFA device starts generating one\-time passwords\. 

1. In the **Manage MFA Device** wizard, in the **MFA code 1** box, enter the one\-time password that currently appears in the virtual MFA device\. Wait up to 30 seconds for the device to generate a new one\-time password\. Then enter the second one\-time password into the **MFA code 2** box\. Choose **Assign MFA**\. 
**Important**  
Submit your request immediately after generating the codes\. If you generate the codes and then wait too long to submit the request, the MFA device successfully associates with the user but the MFA device is out of sync\. This happens because time\-based one\-time passwords \(TOTP\) expire after a short period of time\. If this happens, you can resync the device\. For more information, see [Resynchronizing Virtual and Hardware MFA Devices](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa_sync.html) in the *IAM User Guide*\.

   The virtual MFA device is now ready for use with AWS\.