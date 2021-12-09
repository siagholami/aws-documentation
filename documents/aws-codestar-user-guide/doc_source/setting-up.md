# Setting Up AWS CodeStar<a name="setting-up"></a>

Before you can start using AWS CodeStar, you must complete the following steps\. 

**Topics**
+ [Step 1: Create an AWS Account](#setting-up-create-account)
+ [Step 2: Create the AWS CodeStar Service Role](#setting-up-create-service-role)
+ [Step 3: Configure the User's IAM Permissions](#setting-up-user)
+ [Step 4: Create an Amazon EC2 Key Pair for AWS CodeStar Projects](#setting-up-create-ec2-key)
+ [Step 5: Open the AWS CodeStar Console](#setting-up-open-console)
+ [Next Steps](#setting-up-next-steps)

## Step 1: Create an AWS Account<a name="setting-up-create-account"></a>

Create an AWS account by going to [https://aws\.amazon\.com/](https://aws.amazon.com/) and choosing **Sign Up**\.

## Step 2: Create the AWS CodeStar Service Role<a name="setting-up-create-service-role"></a>

Create a [service role](access-permissions-service-role.md) that is used to create and manage AWS resources and IAM permissions\. You only need to create the service role once\. 

**Important**  
You must be signed in as an IAM administrative user \(or root account\) to create a service role\. For more information, see [Creating Your First IAM User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html)\.

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Choose **Start project**\.

    If you do not see **Start project** and are directed to the projects list page instead, the service role has been created\. Skip to [Configure Permissions for IAM Users](#setting-up-create-iam-user)\.

1. In **Create service role**, choose **Yes, create role**\.

1. Exit the wizard\. You come back to this later\.

## Step 3: Configure the User's IAM Permissions<a name="setting-up-user"></a>

You can use AWS CodeStar as an IAM user, a federated user, the root user, or an assumed role\. If you choose an IAM user, AWS CodeStar helps you configure user access by managing IAM permissions for you\. For information about what AWS CodeStar can do for IAM users versus federated users, see [AWS CodeStar Access Permissions Reference](access-permissions.md)\. 

If you have not set up any IAM users, see [IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html)\.

### Configure Permissions for IAM Users<a name="setting-up-create-iam-user"></a>

Complete these steps to set up IAM user permissions\.

1. To perform this step, sign in to theIAM console as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated AdministratorAccess managed policy or equivalent\. Attach the **`AWSCodeStarFullAccess`** managed policy to the IAM user that is used to create the project\. 

1. Sign in to the AWS CodeStar console as the IAM user with `AWSCodeStarFullAccess` attached who will create the project, and then create your project as described in [Step 1: Create an AWS CodeStar Project](getting-started.md#getting-started-create)\. AWS CodeStar creates Owner, Contributor, and Viewer managed policies for the project\. As the project creator, your Owner permissions are applied automatically\.

1. After you have created your project, use your permissions to add other IAM users as team members to your project\. For information, see [Manage Permissions for AWS CodeStar Team Members ](how-to-manage-team-permissions.md)\.

1. If your IAM user has already been added to one or more AWS CodeStar projects, it already has the policies and permissions required to access the service and resources for the projects you belong to\. To set up your local computer for working with AWS CodeStar projects, follow the steps in [Getting Started](getting-started.md#git-credentials)\. You can also [sign in to the AWS CodeStar console](https://console.aws.amazon.com/codestar/) and configure your user profile\. For more information, see [Manage Display Information for Your AWS CodeStar User Profile ](how-to-manage-user-pref.md) and [Add a Public Key to Your AWS CodeStar User Profile ](how-to-add-ec2-key.md)\.

### Configure Permissions for Federated Users<a name="setting-up-create-federated-user"></a>

To use AWS CodeStar as a federated user, the federated user must have IAM permissions that allow the user to use AWS CodeStar APIs and access any resources used in the projects \(such as Amazon EC2 or AWS Lambda\)\. 

If you have not set up any federated users, see [Federated User Access to AWS CodeStar](access-permissions-federated.md)\.

Complete these steps to set up federated user permissions:

1. Sign in to the IAMconsole as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated **AdministratorAccess** managed policy or equivalent\. Attach the **`AWSCodeStarFullAccess`** managed policy to the federated user role that is used to create the project\. See [Attach the `AWSCodeStarFullAccess` Managed Policy to the Federated User's Role](access-permissions-federated.md#access-permissions-federated-attach-FullAccess)\. 

1. Sign in to the AWS CodeStar console as the IAM user with `AWSCodeStarFullAccess` attached who will create the project, and then create your project as described in [Step 1: Create an AWS CodeStar Project](getting-started.md#getting-started-create)\. AWS CodeStar creates Owner, Contributor, and Viewer managed policies for the project\. As the federated user project creator, your project Owner permissions are not applied automatically\. You might not be able to access all project resources\. 

1. To give yourself access to all project resources, sign in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated **AdministratorAccess** managed policy or equivalent\. Attach your project's AWS CodeStar owner managed policy to the role you assume as a federated user\. This allows you to manage and view all of the resources created for your project\. For information, see [Attach Your Project's AWS CodeStar Viewer/Contributor/Owner Managed Policy to the Federated User's Role](access-permissions-federated.md#access-permissions-federated-attach-CodeStar)\.

1. Sign in to the console as a root user, an IAM administrator user in the account, or an IAM user or federated user with the associated **AdministratorAccess** managed policy or equivalent\. Grant federated users access to your project by attaching the appropriate AWS CodeStar owner, contributor, or viewer managed policy to the user's role\. For information, see [Attach Your Project's AWS CodeStar Viewer/Contributor/Owner Managed Policy to the Federated User's Role](access-permissions-federated.md#access-permissions-federated-attach-CodeStar)\.

## Step 4: Create an Amazon EC2 Key Pair for AWS CodeStar Projects<a name="setting-up-create-ec2-key"></a>

Many AWS CodeStar projects use AWS CodeDeploy or AWS Elastic Beanstalk to deploy code to Amazon EC2 instances\. To access Amazon EC2 instances associated with your project, create an Amazon EC2 key pair for your IAM user\. Your IAM user must have permissions to create and manage Amazon EC2 keys \(for example, permission to take the `ec2:CreateKeyPair` and `ec2:ImportKeyPair` actions\)\. For more information, see [Amazon EC2 Key Pairs](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html)\.

## Step 5: Open the AWS CodeStar Console<a name="setting-up-open-console"></a>

Sign in to the AWS Management Console, and then open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

## Next Steps<a name="setting-up-next-steps"></a>

Congratulations, you have completed the setup\! To start working with AWS CodeStar, see [Getting Started with AWS CodeStar](getting-started.md)\. 