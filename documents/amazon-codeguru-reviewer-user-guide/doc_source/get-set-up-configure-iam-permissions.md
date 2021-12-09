# Configure IAM permissions for Amazon CodeGuru Reviewer<a name="get-set-up-configure-iam-permissions"></a>

When you create an AWS account, you get a single sign\-in identity that has complete access to all of the AWS services and resources in the account\. This identity is called the AWS account *root user*\. Signing in to the AWS console using the email address and password that you used to create the account gives you complete access to all of the AWS resources in your account\. 

We strongly recommend that you *not* use the root user for everyday tasks, even the administrative ones\. Instead, create an IAM user with the least privileges needed\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\. For more information, see [Create individual IAM users](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users) in the *AWS Identity and Access Management User Guide*\.

 See the following topics for information about permissions required for CodeGuru Reviewer and how to add them\. 
+  [Authenticating with identities in CodeGuru Reviewer](security_iam_authentication.md) 
+  [Using identity\-based policies for CodeGuru Reviewer](auth-and-access-control-iam-identity-based-access-control.md) 
+  [Amazon CodeGuru Reviewer permissions reference](auth-and-access-control-permissions-reference.md) 