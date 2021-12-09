# Step 2: Create an IAM Administrator User and Group<a name="su-account-user"></a>

When you create an AWS account, you get a single sign\-in identity that has complete access to all of the AWS services and resources in the account\. This identity is called the AWS account *root user*\. Signing in to the AWS Management Console by using the email address and password that you used to create the account gives you complete access to all of the AWS resources in your account\. 

We strongly recommend that you do *not* use the root user for everyday tasks, even the administrative ones\. Instead, adhere to the best practice in [Create Individual IAM Users](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users), which is to create an AWS Identity and Access Management \(IAM\) administrator user\. Then securely lock away the root user credentials, and use them to perform only a few account and service management tasks\. 

**To create an administrator user and sign in to the console**

1. Create an administrator user in your AWS account\. For instructions, see [Creating Your First IAM User and Administrators Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *IAM User Guide*\.
**Note**  
An IAM user with administrator permissions has unrestricted access to the AWS services in your account\. You can restrict permissions as necessary\. The code examples in this guide assume that you have a user with the `AmazonRekognitionFullAccess` permissions\. You also have to provide permissions to access the console\. For more information, see [Step 5: Set Up Amazon Rekognition Custom Labels Console Permissions](su-console-policy.md)\.

1. Sign in to the AWS Management Console\. 

   To sign in to the AWS Management Console as a IAM user, you must use a special URL\. For more information, see [How Users Sign In to Your Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_how-users-sign-in.html) in the *IAM User Guide*\.