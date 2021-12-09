# Providing AWS Credentials<a name="credentials"></a>

Before you can use the Toolkit for Visual Studio, you must provide one or more sets of valid AWS credentials\. These credentials allow you to access your AWS resources through the Toolkit for Visual Studio\. They're also used to sign programmatic web services requests so that AWS can verify that the request comes from an authorized source\.

**Important**  
AWS credentials consist of an access key ID and secret access key\. We recommend that you do NOT use your account's root credentials\. Instead, [create one or more IAM users](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html), and then use those credentials\. For additional information, see [Using IAM Users](http://aws.amazon.com/blogs/developer/using-iam-users-access-key-management-for-net-applications-part-2/) and [Best Practices for Managing AWS Access Keys](https://docs.aws.amazon.com/general/latest/gr/aws-access-keys-best-practices.html)\.

The Toolkit for Visual Studio supports multiple sets of credentials from any number of accounts\. Each set is referred to as a *profile*\. When you add a profile to the Toolkit for Visual Studio, the credentials can be stored using two mechanisms:
+ Encrypted and stored in the SDK Credential Store\.

  This store is also used by the [AWS SDK for \.NET](https://aws.amazon.com/sdk-for-net/) and the [AWS Tools for Windows PowerShell](https://docs.aws.amazon.com/powershell/latest/userguide/)\. The SDK Credential Store is specific to your Windows user account on your machine and can't be decrypted or used elsewhere\.
+ The plain\-text shared AWS credentials file used by other AWS SDKs and the AWS CLI\.

To use the Toolkit for Visual Studio, at least one credential profile must be available from either the SDK Credential Store or the shared AWS credentials file\.

**Note**  
Credential profiles created using the Toolkit for Visual Studio are saved only to the encrypted SDK Credential Store or the shared AWS credentials file\. Multi\-Factor Authentication \(MFA\) profiles are not supported by the Toolkit for Visual Studio\.

## Adding a profile to the SDK Credential Store or the Shared AWS Credentials File<a name="adding-a-profile-to-the-sdk-credential-store"></a>

To add a profile to the SDK Credential Store or the shared AWS credentials file:

1. Open AWS Explorer in Visual Studio \(**View** ≫ **AWS Explorer**\)\.

1. Choose the **New Account Profile** icon to the right of the **Profile:** list\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/add_profile.png)

   The New Account Profile dialog box opens\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-account-add.png)

1. To create a credential profile, enter the following data into the dialog box and then choose **OK**\.
**Note**  
When you create an account in the AWS Management Console, or when you [create an IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) and set up credentials for the user, you are given the opportunity to download and save the generated credentials as a `.csv` file\. \(This is NOT the shared AWS credentials file\.\)  
If you have downloaded this file, you can choose **Import from csv file\.\.\.** to browse for the file and automatically import the access key ID and secret access key into the dialog box\.  
** **Profile Name** **  
\(Required\) The profile's display name\.  
**Storage Location**  
\(Required\) Choose whether to use the SDK Credential Store or the shared AWS credentials file\.  
** **Access Key ID** **  
\(Required\) The access key ID\.  
** **Secret Access Key** **  
\(Required\) The secret access key\.  
** **Account Number** **  
\(Optional\) The credential's account number\. The Toolkit for Visual Studio uses the account number to construct Amazon Resource Names \(ARNs\)\.  
**Account Type**  
\(Required\) The account type\. This entry determines which regions are displayed in AWS Explorer if you select this profile\. The default is **Standard AWS Account**\.  
   + If you choose **AWS GovCloud \(US\) Account**, AWS Explorer displays only the AWS GovCloud \(US\) region\.
   + If you choose **Amazon AWS Account \- China \(Beijing\) Region**, AWS Explorer displays only the China \(Beijing\) region\.

After you add the first profile, you can also do the following:
+ To add another profile, repeat the procedure\.
+ To delete a profile, choose it in the **Profile:** dropdown, and then choose the **Delete Profile** icon\.
+ To edit a profile, choose it in the **Profile:** dropdown, and then choose the **Edit Profile** icon to open the **Edit Profile** dialog box\.

  For example, if you have [rotated an IAM user's credentials](https://docs.aws.amazon.com/general/latest/gr/aws-access-keys-best-practices.html)—a recommended practice—you can edit the profile to update the user's credentials in the SDK Credential Store or shared AWS credentials file\. For more information, see [IAM Credential Rotation](http://aws.amazon.com/blogs/developer/iam-credential-rotation-access-key-management-for-net-applications-part-3/)\.

You can also add profiles to the SDK Credential Store or shared AWS credentials file when you create certain AWS projects\. In the dialog box where you enter project information, fields for credential information might be available\.

The following example is for a new AWS Lambda Node\.js project\. You can choose an existing credential profile or create one\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/specify_creds.png)

## Manually Adding a Profile to the Shared AWS Credentials File<a name="adding-a-profile-to-the-aws-credentials-profile-file"></a>

You can set your credentials in the shared AWS credentials file on your local system\. On Windows, this file is called `C:\Users\USERNAME\.aws\credentials`\.

This file should contain lines in the following format:

```
[default]
aws_access_key_id = YOUR_ACCESS_KEY_ID
aws_secret_access_key = YOUR_SECRET_ACCESS_KEY
```

You can use a role by creating a profile for the role\. The following example shows a role profile named `assumed-role` that is assumed by the default profile\.

```
[assume-role-test]
role_arn = arn:aws:iam::123456789012:role/assumed-role
source_profile = default
```

In this case, the default profile is an IAM user with credentials and permission to assume a role named `assumed-role`\. To access the role, you create a named profile, in this case `assume-role-test`\. Instead of configuring this profile with credentials, you specify the ARN of the role and the name of the profile that has access to it\.

For an EC2 instance, specify an IAM role and then give your EC2 instance access to that role\. See [IAM Roles for Amazon EC2](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-roles-for-amazon-ec2.html) in the *Amazon EC2 User Guide for Linux Instances* for a detailed discussion about how this works\.