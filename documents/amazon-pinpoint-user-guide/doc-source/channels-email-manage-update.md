# Updating Email Settings<a name="channels-email-manage-update"></a>

You can use the Amazon Pinpoint console to update the email settings for a project\. For example, you can change the verified identity that's associated with the project or verify a new identity for the project\.

**To update your email settings**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to update email settings for\.

1. In the navigation pane, under **Settings**, choose **Email**\.

1. On the **Identities** tab, choose **Edit**\.

1. Under **Identity type**, choose the type of identity that you want to add or update: **Email address** or **Domain**\.

1. Choose whether you want to update an existing identity or verify a new identity\.

1. Enter the email address or domain, and then choose **Verify**\.

   If you enter an email address, Amazon Pinpoint sends a verification email to the address that you entered\. Follow the instructions in the email to complete the verification process\.

   If you enter an email domain, the console displays a TXT record that you have to add to the DNS settings for your domain\.

1. Follow the instructions shown on the console\. For more information about verifying an email address or domain, see [Verifying Email Identities](channels-email-manage-verify.md)\.

1. When you finish, choose **Save**\.