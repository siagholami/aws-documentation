# What is Authentication?<a name="auth_access_what-is-authentication"></a>

Authentication is how you sign in to AWS using your credentials\.

**Note**  
To get started quickly, you can ignore this section\. First, review the introductory information on [Authentication and Access Control for AWS Global Accelerator](auth-and-access-control.md), and then see [Getting Started with IAM](auth_access_getting-started.md)\.

As a principal, you must be *authenticated* \(signed in to AWS\) using an entity \(root user, IAM user, or IAM role\) to send a request to AWS\. An IAM user can have long\-term credentials such as a user name and password or a set of access keys\. When you assume an IAM role, you are given temporary security credentials\. 

To get authenticated from the AWS Management Console as a user, you must sign in with your user name and password\. To get authenticated from the AWS CLI or AWS API, you must provide your access key and secret key or temporary credentials\. AWS provides SDK and CLI tools to cryptographically sign your request using your credentials\. If you don’t use AWS tools, you must sign the request yourself\. Regardless of the authentication method that you use, you might also be required to provide additional security information\. For example, AWS recommends that you use multi\-factor authentication \(MFA\) to increase the security of your account\.

As a principal, you can sign in to AWS using the following entities \(users or roles\):

**AWS account root user**  
 When you first create an AWS account, you begin with a single sign\-in identity that has complete access to all AWS services and resources in the account\. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account\. We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, adhere to the [best practice of using the root user only to create your first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\.

**IAM user**  
An [IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html) is an entity within your AWS account that has specific permissions\. Global Accelerator supports *Signature Version 4*, a protocol for authenticating inbound API requests\. For more information about authenticating requests, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the *AWS General Reference*\.

**IAM role**  
 An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an IAM identity that you can create in your account that has specific permissions\. It is similar to an *IAM user*, but it is not associated with a specific person\. An IAM role enables you to obtain temporary access keys that can be used to access AWS services and resources\. IAM roles with temporary credentials are useful in the following situations:    
**Federated user access**  
 Instead of creating an IAM user, you can use existing user identities from AWS Directory Service, your enterprise user directory, or a web identity provider\. These are known as *federated users*\. AWS assigns a role to a federated user when access is requested through an [identity provider](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html)\. For more information about federated users, see [Federated Users and Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_access-management.html#intro-access-roles) in the *IAM User Guide*\.   
**Temporary user permissions**  
An IAM user can assume a role temporarily to take on different permissions for a specific task\.   
**Cross\-account access**  
You can use an IAM role to allow a trusted principal in a different account to access resources in your account\. Roles are the primary way to grant cross\-account access\. However, with some AWS services, you can attach a policy directly to a resource \(instead of using a role as a proxy\)\. Global Accelerator does not support these resource\-based policies\. For more information about choosing whether to use a role or a resource\-based policy to allow cross\-account access, see [Controlling Access to Principals in a Different Account](auth_access_what-is-access-control.md#auth_access_controlling-principal-accounts)\.  
**AWS service access**  
 You can use an IAM role in your account to grant an AWS service permissions to access your account’s resources\. For example, you can create a role that allows Amazon Redshift to access an Amazon S3 bucket on your behalf and then load data from that bucket into an Amazon Redshift cluster\. For more information, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html) in the *IAM User Guide*\.   
**Applications running on Amazon EC2**  
 You can use an IAM role to manage temporary credentials for applications that are running on an EC2 instance and making AWS API requests\. This is preferable to storing access keys within the EC2 instance\. To assign an AWS role to an EC2 instance and make it available to all of its applications, you create an instance profile that is attached to the instance\. An instance profile contains the role and enables programs that are running on the EC2 instance to get temporary credentials\. For more information, see [Using an IAM Role to Grant Permissions to Applications Running on Amazon EC2 Instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html) in the *IAM User Guide*\. 