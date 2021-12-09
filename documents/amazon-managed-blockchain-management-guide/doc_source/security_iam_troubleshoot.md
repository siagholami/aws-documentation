# Troubleshooting Amazon Managed Blockchain Identity and Access<a name="security_iam_troubleshoot"></a>

Use the following information to help you diagnose and fix common issues that you might encounter when working with Managed Blockchain and IAM\.

**Topics**
+ [I Am Not Authorized to Perform an Action in Managed Blockchain](#security_iam_troubleshoot-no-permissions)
+ [I Want to View My Access Keys](#security_iam_troubleshoot-access-keys)
+ [I'm an Administrator and Want to Allow Others to Access Managed Blockchain](#security_iam_troubleshoot-admin-delegate)

## I Am Not Authorized to Perform an Action in Managed Blockchain<a name="security_iam_troubleshoot-no-permissions"></a>

If the AWS Management Console tells you that you're not authorized to perform an action, then you must contact your administrator for assistance\. Your administrator is the person that provided you with your user name and password\.

The following example error occurs when the `mateojackson` IAM user tries to use the console to view details about a *widget* but does not have `managedblockchain:CreateMember` permissions\.

```
User: arn:aws:iam::123456789012:user/mateojackson is not authorized to perform: managedblockchain:CreateMember on resource: n-MWY63ZJZU5HGNCMBQER7IN6OIU
```

In this case, Mateo asks his administrator to update his policies to allow him to access the `n-MWY63ZJZU5HGNCMBQER7IN6OIU` resource using the `managedblockchain:CreateMember` action\.

## I Want to View My Access Keys<a name="security_iam_troubleshoot-access-keys"></a>

After you create your IAM user access keys, you can view your access key ID at any time\. However, you can't view your secret access key again\. If you lose your secret key, you must create a new access key pair\. 

Access keys consist of two parts: an access key ID \(for example, `AKIAIOSFODNN7EXAMPLE`\) and a secret access key \(for example, `wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY`\)\. Like a user name and password, you must use both the access key ID and secret access key together to authenticate your requests\. Manage your access keys as securely as you do your user name and password\.

**Important**  
 Do not provide your access keys to a third party, even to help [find your canonical user ID](https://docs.aws.amazon.com/general/latest/gr/acct-identifiers.html#FindingCanonicalId)\. By doing this, you might give someone permanent access to your account\. 

When you create an access key pair, you are prompted to save the access key ID and secret access key in a secure location\. The secret access key is available only at the time you create it\. If you lose your secret access key, you must add new access keys to your IAM user\. You can have a maximum of two access keys\. If you already have two, you must delete one key pair before creating a new one\. To view instructions, see [Managing Access Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey) in the *IAM User Guide*\.

## I'm an Administrator and Want to Allow Others to Access Managed Blockchain<a name="security_iam_troubleshoot-admin-delegate"></a>

To allow others to access Managed Blockchain, you must create an IAM entity \(user or role\) for the person or application that needs access\. They will use the credentials for that entity to access AWS\. You must then attach a policy to the entity that grants them the correct permissions in Managed Blockchain\.

To get started right away, see [Creating Your First IAM Delegated User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-delegated-user.html) in the *IAM User Guide*\.