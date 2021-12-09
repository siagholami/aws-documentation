# Set up AWS Credentials<a name="setup-credentials"></a>

To access Amazon Web Services with the AWS Toolkit for Eclipse, you must configure the AWS Toolkit for Eclipse with AWS account credentials\.

## Get your AWS access keys<a name="get-your-aws-access-keys"></a>

Access keys consist of an *access key ID* and *secret access key*, which are used to sign programmatic requests that you make to AWS\. If you don’t have access keys, you can create them by using the [AWS Management Console](https://console.aws.amazon.com/console/home)\. We recommend that you use IAM access keys instead of AWS root account access keys\. IAM lets you securely control access to AWS services and resources in your AWS account\.

**Note**  
To create access keys, you must have permissions to perform the required IAM actions\. For more information, see [Granting IAM User Permission to Manage Password Policy and Credentials](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_delegate-permissions.html) in the IAM User Guide\.

### To get your access key ID and secret access key<a name="w3aab7c11b5b3b5"></a>

1. Open the [IAM console](https://console.aws.amazon.com/iam/home)\.

1. On the navigation menu, choose **Users**\.

1. Choose your IAM user name \(not the check box\)\.

1. Open the **Security credentials** tab, and then choose **Create access key**\.

1. To see the new access key, choose **Show**\. Your credentials resemble the following:
   + Access key ID: `AKIAIOSFODNN7EXAMPLE` 
   + Secret access key: `wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY` 

1. To download the key pair, choose **Download \.csv file**\. Store the keys

in a secure location\.

**Important**  
Keep the keys confidential to protect your AWS account, and never email them\. Do not share them outside your organization, even if an inquiry appears to come from AWS or Amazon\.com\. *No one who legitimately represents Amazon will ever ask you for your secret key\.* 

### Related topics<a name="w3aab7c11b5b3b7"></a>
+  [What Is IAM?](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) in IAM User Guide\.
+  [AWS Security Credentials](https://docs.aws.amazon.com/general/latest/gr/aws-security-credentials.html) in Amazon Web Services General Reference\.

## Add your AWS access keys to the AWS Toolkit for Eclipse<a name="add-access-keys"></a>

The AWS Toolkit for Eclipse uses the same system for locating and using AWS access keys as that used by the AWS CLI and AWS Java SDK\. Access keys entered in the Eclipse IDE are saved to a *shared AWS credentials file* \(called `credentials`\) in the `.aws` sub\-directory within your home directory\.

**Note**  
The location of the credential file can be modified\. For information about setting the location of this file, see [Changing the AWS credentials file location](#set-credfile-location)\.

If you have already set your AWS credentials using the AWS CLI, then the AWS Toolkit for Eclipse will automatically detect and use those credentials\. For more information about using the AWS CLI, see the [AWS CLI User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\.

**To add your access keys to the AWS Toolkit for Eclipse**

1. Open Eclipse’s **Preferences** dialog box and click **AWS Toolkit** in the sidebar\.

1. Type or paste your AWS access key ID in the **Access Key ID** box\.

1. Type or paste your AWS secret access key in the **Secret Access Key** box\.

1. Click **Apply** or **OK** to store your access key information\.

Here’s an example of a configured set of default credentials:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-preferences.png)

## Using multiple AWS accounts with the AWS Toolkit for Eclipse<a name="using-profiles"></a>

The **Preferences** dialog box allows you to add information for more than one AWS account\. Multiple accounts can be useful, for example, to provide developers and administrators with separate resources for development and for release/publication\.

Separate sets of AWS credentials are stored as *profiles* within the shared AWS credentials file described in [Add your AWS access keys to the AWS Toolkit for Eclipse](#add-access-keys)\. All of the configured profiles can be seen in the drop\-down box at the top of the AWS Toolkit Preferences Global Configuration screen, labeled **Default Profile**\.

**To add a new set of access keys**

1. On the **AWS Toolkit Preferences** screen in Eclipse’s **Preferences** dialog box, click **Add profile**\.

1. Add your new account information to the **Profile Details** section\.

   Choose a descriptive name for the **Profile Name**, and enter your access key information in the **Access Key ID** and **Secret Access Key** boxes\.

1. Click **Apply** or **OK** to store your access key information\.

You can repeat this procedure for as many sets of AWS account information that you need\.

When you have entered all of your AWS account information, select the default account by choosing one of the accounts from the **Default Profile** drop\-down\. AWS Explorer displays resources associated with the default account, and when you create a new application through the AWS Toolkit for Eclipse, the application uses the credentials for the configured default account\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-pref-select-profile.png)

**Note**  
For an alternative approach to separate your AWS resources, see [Differentiating AWS Resources with Naming](differentiate-resources-with-naming.md)\.

## Changing the AWS credentials file location<a name="set-credfile-location"></a>

Using the AWS Toolkit for Eclipse Preferences screen, you can change the location used by the Toolkit to store and load credentials\.

### To set the AWS credentials file location<a name="w3aab7c11c11b5"></a>
+ In the AWS Toolkit Preferences dialog, locate the **Credentials file location** section, and enter the pathname of the file where you would like your AWS credentials stored\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-pref-set-credfile-loc.png)

**Important**  
It is *strongly recommended* that you don’t store your AWS credential information within any network\-shared directory or within any source\-control\-managed projects\. Always retain strict control of your AWS access keys\!