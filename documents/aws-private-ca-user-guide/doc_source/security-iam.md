# Identity and Access Management for AWS Certificate Manager Private Certificate Authority<a name="security-iam"></a>

 Access to ACM Private CA requires credentials that AWS can use to authenticate your requests\. The following topics provide details on how you can use [AWS Identity and Access Management \(IAM\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) to help secure your private certificate authorities \(CAs\) by controlling who can access them\. 

## Authentication<a name="authentication"></a>

You can access AWS as any of the following types of identities:
+ **AWS account root user** –  When you first create an AWS account, you begin with a single sign\-in identity that has complete access to all AWS services and resources in the account\. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account\. We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, adhere to the [best practice of using the root user only to create your first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\. 
+ **IAM user** – An [IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html) is an identity within your AWS account that has specific custom permissions \(for example, permissions to create a directory in ACM Private CA\)\. You can use an IAM user name and password to sign in to secure AWS webpages like the [AWS Management Console](https://console.aws.amazon.com/), [AWS Discussion Forums](https://forums.aws.amazon.com/), or the [AWS Support Center](https://console.aws.amazon.com/support/home#/)\.

   

  In addition to a user name and password, you can also generate [access keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html) for each user\. You can use these keys when you access AWS services programmatically, either through [one of the several SDKs](https://aws.amazon.com/tools/#sdk) or by using the [AWS Command Line Interface \(CLI\)](https://aws.amazon.com/cli/)\. The SDK and CLI tools use the access keys to cryptographically sign your request\. If you don’t use AWS tools, you must sign the request yourself\. ACM Private CA supports *Signature Version 4*, a protocol for authenticating inbound API requests\. For more information about authenticating requests, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the *AWS General Reference*\.

   
+ **IAM role** –  An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an IAM identity that you can create in your account that has specific permissions\. An IAM role is similar to an IAM user in that it is an AWS identity with permissions policies that determine what the identity can and cannot do in AWS\. However, instead of being uniquely associated with one person, a role is intended to be assumable by anyone who needs it\. Also, a role does not have standard long\-term credentials such as a password or access keys associated with it\. Instead, when you assume a role, it provides you with temporary security credentials for your role session\. IAM roles with temporary credentials are useful in the following situations:

   
  + **Federated user access** –  Instead of creating an IAM user, you can use existing identities from AWS Directory Service, your enterprise user directory, or a web identity provider\. These are known as *federated users*\. AWS assigns a role to a federated user when access is requested through an [identity provider](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html)\. For more information about federated users, see [Federated Users and Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_access-management.html#intro-access-roles) in the *IAM User Guide*\. 

     
  + **AWS service access** –  A service role is an IAM role that a service assumes to perform actions in your account on your behalf\. When you set up some AWS service environments, you must define a role for the service to assume\. This service role must include all the permissions that are required for the service to access the AWS resources that it needs\. Service roles vary from service to service, but many allow you to choose your permissions as long as you meet the documented requirements for that service\. Service roles provide access only within your account and cannot be used to grant access to services in other accounts\. You can create, modify, and delete a service role from within IAM\. For example, you can create a role that allows Amazon Redshift to access an Amazon S3 bucket on your behalf and then load data from that bucket into an Amazon Redshift cluster\. For more information, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html) in the *IAM User Guide*\. 

      
  + **Applications running on Amazon EC2** –  You can use an IAM role to manage temporary credentials for applications that are running on an EC2 instance and making AWS CLI or AWS API requests\. This is preferable to storing access keys within the EC2 instance\. To assign an AWS role to an EC2 instance and make it available to all of its applications, you create an instance profile that is attached to the instance\. An instance profile contains the role and enables programs that are running on the EC2 instance to get temporary credentials\. For more information, see [Using an IAM Role to Grant Permissions to Applications Running on Amazon EC2 Instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html) in the *IAM User Guide*\. 

## Understanding Resources, Ownership, and Permissions Policies<a name="understand-resource-ownership"></a>

In ACM Private CA, the primary resource that you work with is a *certificate authority \(CA\)*\. Every private CA that you own or control is identified by an Amazon Resource Name \(ARN\), which has the following form\. 

```
arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/12345678-abcd-1234-abcd-1234567890ab
```

A *resource owner* is the *principal entity* of the AWS account in which an AWS resource is created\. The following examples illustrate how this works\. 
+ If you use the credentials of your AWS account root user to create a private CA, your AWS account owns the CA\. 
+ If you create an IAM user in your AWS account, you can grant that user permission to create a private CA\. However, the account to which that user belongs owns the CA\. 
+ If you create an IAM role in your AWS account and grant it permission to create a private CA, anyone who can assume the role can create the CA\. However, the account to which the role belongs will own the private CA\. 

## <a name="managing-access"></a>

A *permissions policy* describes who has access to what\. The following discussion explains the available options for creating permissions policies\. 

**Note**  
This documentation discusses using IAM in the context of ACM Private CA\. It doesn't provide detailed information about the IAM service\. For complete IAM documentation, see the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html)\. For information about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html)\. 

When you set up access control and permissions policies that you plan to attach to an IAM identity \(identity\-based policies\), use the following table as a reference\. The first column in the table lists each ACM Private CA API operation\. You specify actions in a policy's `Action` element\. The remaining columns provide the additional information\.


**ACM Private CA API Operations and Permissions**  

| ACM Private CA API Operations | Required Permissions | Resources | 
| --- | --- | --- | 
|  [CreateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthority.html)  |  `acm-pca:CreateCertificateAuthority`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [CreateCertificateAuthorityAuditReport](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthorityAuditReport.html)  |  `acm-pca:CreateCertificateAuthorityAuditReport`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
| [CreatePermission](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreatePermission.html) | acm\-pca:CreatePermission | arn:aws:acm\-pca:AWS\_Region:AWS\_Account:certificate\-authority/certificate\_ID | 
|  [DeleteCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeleteCertificateAuthority.html)  |  `acm-pca:DeleteCertificateAuthority`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
| [DeletePermission](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeletePermission.html) | acm\-pca:DeletePermission | arn:aws:acm\-pca:AWS\_Region:AWS\_Account:certificate\-authority/certificate\_ID | 
| [DeletePolicy](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeletePermission.html) | acm\-pca:DeletePolicy | arn:aws:acm\-pca:AWS\_Region:AWS\_Account:certificate\-authority/certificate\_ID | 
|  [DescribeCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DescribeCertificateAuthority.html)  |  `acm-pca:DescribeCertificateAuthority`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [DescribeCertificateAuthorityAuditReport](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DescribeCertificateAuthorityAuditReport.html)  |  `acm-pca:DescribeCertificateAuthorityAuditReport`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [GetCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificate.html)  |  `acm-pca:GetCertificate`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [GetCertificateAuthorityCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCertificate.html)  |  `acm-pca:GetCertificateAuthorityCertificate`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [GetCertificateAuthorityCsr](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCsr.html)  |  `acm-pca:GetCertificateAuthorityCsr`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
| [GetPolicy](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeletePermission.html) | acm\-pca:GetPolicy | arn:aws:acm\-pca:AWS\_Region:AWS\_Account:certificate\-authority/certificate\_ID | 
|  [ImportCertificateAuthorityCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ImportCertificateAuthorityCertificate.html)  |  `acm-pca:ImportCertificateAuthorityCertificate`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html)  |  `acm-pca:IssueCertificate`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [ListCertificateAuthorities](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListCertificateAuthorities.html)  |  `acm-pca:ListCertificateAuthorities`  |  N/A  | 
| [ListPermissions](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListPermissions.html) | acm\-pca:ListPermissions | arn:aws:acm\-pca:AWS\_Region:AWS\_Account:certificate\-authority/certificate\_ID | 
|  [ListTags](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListTags.html)  |  `acm-pca:ListTags`  |  N/A  | 
| [PutPolicy](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeletePermission.html) | acm\-pca:PutPolicy | arn:aws:acm\-pca:AWS\_Region:AWS\_Account:certificate\-authority/certificate\_ID | 
|  [RevokeCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RevokeCertificate.html)  |  `acm-pca:RevokeCertificate`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [TagCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_TagCertificateAuthority.html)  |  `acm-pca:TagCertificateAuthority`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [UntagCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_UntagCertificateAuthority.html)  |  `acm-pca:UntagCertificateAuthority`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 
|  [UpdateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_UpdateCertificateAuthority.html)  |  `acm-pca:UpdateCertificateAuthority`  |  `arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/certificate_ID`  | 

You can use IAM to create policies that apply permissions to IAM users, groups, and roles\. These are called *identity\-based policies*\. IAM offers the following types of identity\-based policies: 
+ [AWS Managed Policies](#auth-AwsManagedPolicies) are policies available by default with ACM Private CA\. These policies cover basic user roles\.
+ [Customer Managed Policies](#auth-CustManagedPolicies) are policies that you create and manage in your AWS account and which you can attach to multiple users, groups, and roles\. You have more precise control when using customer managed policies than you have when using AWS managed policies\.
+ [Inline Policies](#auth-InlinePolicies) are policies that you create and manage and which you embed directly into a single user, group, or role\.
+ [Resource\-Based Policies](pca-rbp.md) are used by ACM Private CA to enable cross\-account access to private CAs\.

### AWS Managed Policies<a name="auth-AwsManagedPolicies"></a>

ACM Private CA includes a set of predefined AWS managed policies for administrators, users, and auditors\. Understanding these policies can help you implement [Customer Managed Policies](#auth-CustManagedPolicies)\.
+ **FullAccess** – Unrestricted administrative control\.

  ```
  {
     "Version":"2012-10-17",
     "Statement":[
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:*"
           ],
           "Resource":"*"
        }
     ]
  }
  ```
+ **ReadOnly** – Access limited to read\-only API operations\.

  ```
  {
     "Version":"2012-10-17",
     "Statement":{
        "Effect":"Allow",
        "Action":[
           "acm-pca:DescribeCertificateAuthority",
           "acm-pca:DescribeCertificateAuthorityAuditReport",
           "acm-pca:ListCertificateAuthorities",
           "acm-pca:GetCertificateAuthorityCsr",
           "acm-pca:GetCertificateAuthorityCertificate",
           "acm-pca:GetCertificate",
           "acm-pca:ListPermissions",
           "acm-pca:ListTags"
        ],
        "Resource":"*"
     }
  }
  ```
+ **PrivilegedUser** – Ability to issue and revoke CA certificates\. This policy has no other administrative capabilities and no ability to issue end\-entity certificates\. Permissions are mutually exclusive with the **User** policy\. 

  ```
  {
     "Version":"2012-10-17",
     "Statement":[
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:IssueCertificate"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*",
           "Condition":{
              "StringLike":{
                 "acm-pca:TemplateArn":[
                    "arn:aws:acm-pca:::template/*CACertificate*/V*"
                 ]
              }
           }
        },
        {
           "Effect":"Deny",
           "Action":[
              "acm-pca:IssueCertificate"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*",
           "Condition":{
              "StringNotLike":{
                 "acm-pca:TemplateArn":[
                    "arn:aws:acm-pca:::template/*CACertificate*/V*"
                 ]
              }
           }
        },
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:RevokeCertificate",
              "acm-pca:GetCertificate",
              "acm-pca:ListPermissions"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*"
        },
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:ListCertificateAuthorities"
           ],
           "Resource":"*"
        }
     ]
  }
  ```
+ **User** – Ability to issue and revoke end\-entity certificates\. This policy has no administrative capabilities and no ability to issue CA certificates\. Permissions are mutually exclusive with the **PrivilegedUser** policy\.

  ```
  {
     "Version":"2012-10-17",
     "Statement":[
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:IssueCertificate"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*",
           "Condition":{
              "StringLike":{
                 "acm-pca:TemplateArn":[
                    "arn:aws:acm-pca:::template/EndEntityCertificate/V*"
                 ]
              }
           }
        },
        {
           "Effect":"Deny",
           "Action":[
              "acm-pca:IssueCertificate"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*",
           "Condition":{
              "StringNotLike":{
                 "acm-pca:TemplateArn":[
                    "arn:aws:acm-pca:::template/EndEntityCertificate/V*"
                 ]
              }
           }
        },
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:RevokeCertificate",
              "acm-pca:GetCertificate",
              "acm-pca:ListPermissions"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*"
        },
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:ListCertificateAuthorities"
           ],
           "Resource":"*"
        }
     ]
  }
  ```
+ **Auditor** – Access to read\-only API operations and permission to generate a CA audit report\. 

  ```
  {
     "Version":"2012-10-17",
     "Statement":[
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:CreateCertificateAuthorityAuditReport",
              "acm-pca:DescribeCertificateAuthority",
              "acm-pca:DescribeCertificateAuthorityAuditReport",
              "acm-pca:GetCertificateAuthorityCsr",
              "acm-pca:GetCertificateAuthorityCertificate",
              "acm-pca:GetCertificate",
              "acm-pca:ListPermissions",
              "acm-pca:ListTags"
           ],
           "Resource":"arn:aws:acm-pca:*:*:certificate-authority/*"
        },
        {
           "Effect":"Allow",
           "Action":[
              "acm-pca:ListCertificateAuthorities"
           ],
           "Resource":"*"
        }
     ]
  }
  ```

### Customer Managed Policies<a name="auth-CustManagedPolicies"></a>

As a best practice, don't use your AWS account root user to interact with AWS, including ACM Private CA\. Instead use AWS Identity and Access Management \(IAM\) to create an IAM user, IAM role, or federated user\. Create an administrator group and add yourself to it\. Then log in as an administrator\. Add additional users to the group as needed\. 

Another best practice is to create a customer managed IAM policy that you can assign to users\. Customer managed policies are standalone identity\-based policies that you create and which you can attach to multiple users, groups, or roles in your AWS account\. Such a policy restricts users to performing only the ACM Private CA actions that you specify\. 

The following example [customer\-managed policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-using.html#create-managed-policy-console) allows a user to create a CA audit report\. This is an example only\. You can choose any ACM Private CA operations that you want\. For more examples, see [Inline Policies](#auth-InlinePolicies)\. 

**To create a customer managed policy**

1. Sign in to the IAM console using the credentials of an AWS administrator\.

1. In the navigation pane of the console, choose **Policies**\.

1. Choose **Create policy**\.

1. Choose the **JSON** tab\.

1. Copy the following policy and paste it into the editor\.

   ```
   {
      "Version":"2012-10-17",
      "Statement":[
         {
            "Effect":"Allow",
            "Action":"acm-pca:CreateCertificateAuthorityAuditReport",
            "Resource":"*"
         }
      ]
   }
   ```

1. Choose **Review policy**\.

1. For **Name**, type `PcaListPolicy`\.

1. \(Optional\) Type a description\.

1. Choose **Create policy**\.

An administrator can attach the policy to any IAM user to limit what ACM Private CA actions the user can perform\. For ways to apply a permissions policy, see [Changing Permissions for an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/) in the *IAM User Guide*\.

## Inline Policies<a name="auth-InlinePolicies"></a>

Inline policies are policies that you create and manage and embed directly into a user, group, or role\. The following policy examples show how to assign permissions to perform ACM Private CA actions\. For general information about inline policies, see [Working with Inline Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_inline-using.html) in the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\. You can use the AWS Management Console, the AWS Command Line Interface \(AWS CLI\), or the IAM API to create and embed inline policies\. 

**Topics**
+ [Listing Private CAs](#policy-list-pcas)
+ [Retrieving a Private CA Certificate](#policy-retrieve-pca)
+ [Importing a Private CA Certificate](#policy-import-pca-cert)
+ [Deleting a Private CA](#policy-delete-pca)
+ [Read\-Only Access to ACM Private CA](#policy-pca-read-only)
+ [Full Access to ACM Private CA](#policy-pca-full-access)
+ [Administrator Access to All AWS Resources](#policy-aws-administrator)

### Listing Private CAs<a name="policy-list-pcas"></a>

 The following policy allows a user to list all of the private CAs in an account\. 

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action":"acm-pca:ListCertificateAuthorities",
         "Resource":"*"
      }
   ]
}
```

### Retrieving a Private CA Certificate<a name="policy-retrieve-pca"></a>

 The following policy allows a user to retrieve a specific private CA certificate\. 

```
{
   "Version":"2012-10-17",
   "Statement":{
      "Effect":"Allow",
      "Action":"acm-pca:GetCertificateAuthorityCertificate",
      "Resource":"arn:aws:acm-pca:AWS_Region:AWS_Account:certificate-authority/12345678-1234-1234-1234-123456789012"
   }
}
```

### Importing a Private CA Certificate<a name="policy-import-pca-cert"></a>

The following policy allows a user to import a private CA certificate\. 

```
{
   "Version":"2012-10-17",
   "Statement":{
      "Effect":"Allow",
      "Action":"acm-pca:ImportCertificateAuthorityCertificate",
      "Resource":"arn:aws:acm-pca:AWS_Region:AWS_Account:certificate/12345678-1234-1234-1234-123456789012"
   }
}
```

### Deleting a Private CA<a name="policy-delete-pca"></a>

The following policy allows a user to delete a specific private CA\.

```
{
   "Version":"2012-10-17",
   "Statement":{
      "Effect":"Allow",
      "Action":"acm-pca:DeleteCertificateAuthority",
      "Resource":"arn:aws:acm-pca:AWS_Region:AWS_Account:certificate/12345678-1234-1234-1234-123456789012"
   }
}
```

### Read\-Only Access to ACM Private CA<a name="policy-pca-read-only"></a>

 The following policy allows a user to describe and list private certificate authorities and to retrieve the private CA certificate and certificate chain\. 

```
{
   "Version":"2012-10-17",
   "Statement":{
      "Effect":"Allow",
      "Action":[
         "acm-pca:DescribeCertificateAuthority",
         "acm-pca:DescribeCertificateAuthorityAuditReport",
         "acm-pca:ListCertificateAuthorities",
         "acm-pca:ListTags",
         "acm-pca:GetCertificateAuthorityCertificate",
         "acm-pca:GetCertificateAuthorityCsr",
         "acm-pca:GetCertificate"
      ],
      "Resource":"*"
   }
}
```

### Full Access to ACM Private CA<a name="policy-pca-full-access"></a>

 The following policy allows a user to perform any ACM Private CA action\. 

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action":[
            "acm-pca:*"
         ],
         "Resource":"*"
      }
   ]
}
```

### Administrator Access to All AWS Resources<a name="policy-aws-administrator"></a>

 The following policy allows a user to perform any action on any AWS resource\. 

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action":"*",
         "Resource":"*"
      }
   ]
}
```