# Getting started<a name="getting-started"></a>

This section provides information about how to install, set up, and use the AWS Toolkit for Microsoft Azure DevOps\.

**Topics**
+ [Set up an Azure DevOps account](#set-up-a-vsts-account)
+ [Install the AWS Toolkit for Azure DevOps extension](#install-the-aws-tools-for-vsts-extension)
+ [Establish AWS credentials for the AWS Toolkit for Azure DevOps](#set-up-aws-credentials-for-the-aws-tools-for-vsts)
+ [Supply task credentials](#supplying-task-creds-overview)

## Set up an Azure DevOps account<a name="set-up-a-vsts-account"></a>

To use [Azure DevOps](https://visualstudio.microsoft.com/team-services/), you will first need to [sign up for an Azure DevOps account](https://docs.microsoft.com/en-us/azure/devops/user-guide/sign-up-invite-teammates?view=azure-devops)\.

## Install the AWS Toolkit for Azure DevOps extension<a name="install-the-aws-tools-for-vsts-extension"></a>

This procedure outlines how to install the AWS Toolkit for Azure DevOps extension\.

1. Go to the [Extensions for Azure DevOps](https://marketplace.visualstudio.com/azuredevops) Visual Studio Marketplace and search for *AWS Toolkit for Azure DevOps*\. \(The following URL is a direct link to the AWS Toolkit for Azure DevOps: [https://marketplace.visualstudio.com/items?itemName=AmazonWebServices.aws-vsts-tools](https://marketplace.visualstudio.com/items?itemName=AmazonWebServices.aws-vsts-tools)\.\)

1. Choose **Get it free** and sign in to your Azure DevOps account, if prompted\.

1. Choose **Install** to install the toolkit into your Azure DevOps account, or choose **Download** to install it on an on\-premises server\.

## Establish AWS credentials for the AWS Toolkit for Azure DevOps<a name="set-up-aws-credentials-for-the-aws-tools-for-vsts"></a>

To allow the AWS Toolkit for Azure DevOps to access AWS services, you need an AWS account and AWS credentials\. When build agents run the tasks contained in the tools, the tasks must be configured with, or have access to, those AWS credentials to enable them to call AWS service APIs\. 

To increase the security of your AWS account, we recommend that you don't use your root account credentials\. You should create an *IAM user* to provide access credentials to the tasks running in the build agent processes\.

For more information about creating an IAM user in your account, and copying that user's credentials, see [Setting up the AWS Toolkit for Azure DevOps](setting-up.md)\.

## Supply task credentials<a name="supplying-task-creds-overview"></a>

After you create an AWS account and IAM user, and you've made a copy of the access key and secret access key for that user, you can supply credentials to the tasks in the following ways\.

**Topics**
+ [Supply task credentials using a service connection](#service-connection)
+ [Supply credentials through named variables in your build](#credentials-through-named-variables)
+ [Supply standard AWS environment variables in the build agent process](#credentials-standard-aws-env-variables)
+ [Supply credentials with Amazon EC2 build agents](#credentials-ec2-build-agents)

### Supply task credentials using a service connection<a name="service-connection"></a>

You can create a link to your AWS subscription by using the **Service connections** section of the **Project settings** for your project\. Note that a service connection expects long\-lived AWS credentials consisting of an access\-key and secret\-key pair\. You can also define **Assume Role** credentials to scope down the access\. Service connections also support the use of a session token variable\. You can rotate session tokens from the service connections\. For more information, see [Use personal access tokens](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate) in the Microsoft Azure DevOps online documentation\.

**To set up a service connection**

1. Open Azure DevOps and access the project that you want to add a service connection to\.

1. Choose the settings icon in the lower\-left side of the screen, and then choose **Service connections**\.

1. From **New AWS service connection**, choose **AWS**\. This opens the **Add AWS service connection** form\.

1. Provide a **Connection name**, **Access key ID**, and **Secret key ID**, and complete any other fields you want\.

1. When you've completed the required and any optional fields in the form, choose **OK**\.

You can test your credentials by creating a new AWS Toolkit for Azure DevOps task in an existing build pipeline and using the connection name you defined in the **Add AWS service connection** form\.

### Supply credentials through named variables in your build<a name="credentials-through-named-variables"></a>

You can specify credentials by using named variables\. You can set these variables using values from previous jobs in the pipeline, or set them globally\. Named variables can be used to get credentials from a custom credentials store\. 

The following are all the supported named variables:
+ `AWS.AccessKeyID` – IAM access key ID\.
+ `AWS.SecretAccessKey` – IAM secret access key\.
+ `AWS.SessionToken` – IAM session token\.
+ `AWS.Region` – AWS Region code, for example, us\-east\-2\.

**To set up global pipeline variables**

1. Open Azure DevOps, open the build definition, and then choose **variables**\.

1. Choose **Add new Variable**\.

1. Choose a variable name from one of the four supported names listed previously, and then choose the appropriate value based on your use case\.

1. Once you save your changes, this variable will be used by all of your AWS tasks\.

**To set up dynamic pipeline variables**

1. Create a job to get the variables\.

1. Create a second job that uses your AWS credentials\.

1. Give the first job an output variable that contains the credentials\.

1. Make the second job rely on the first job\.

For more information about Azure DevOps pipeline variables, see [Define variables](https://docs.microsoft.com/en-us/azure/devops/pipelines/process/variables) in the Microsoft Azure DevOps online documentation\.

### Supply standard AWS environment variables in the build agent process<a name="credentials-standard-aws-env-variables"></a>

You can specify credentials with standard named AWS environment variables\. These variables can be used to get credentials from a custom credentials store\. 

The following are all the supported standard named AWS environment variables:
+ `AWS_ACCESS_KEY_ID` – IAM access key ID\.
+ `AWS_SECRET_ACCESS_KEY` – IAM secret access key\.
+ `AWS_SESSION_TOKEN` – IAM session token\.
+ `AWS_ROLE_ARN` – Amazon Resource Name \(ARN\) of the role you want to assume\.
+ `AWS_REGION` – AWS Region code, for example, us\-east\-2\.

For more information about Azure DevOps pipeline variables, see [Define variables](https://docs.microsoft.com/en-us/azure/devops/pipelines/process/variables) in the Microsoft Azure DevOps online documentation\.

### Supply credentials with Amazon EC2 build agents<a name="credentials-ec2-build-agents"></a>

For build agents running on Amazon Elastic Compute Cloud \(Amazon EC2\) instances, the tasks can automatically obtain credential and Region information from instance metadata associated with the Amazon EC2 instance\. 

To use Amazon EC2 instance metadata credentials, the instance must have started with an instance profile that references a role that grants permissions to the task\. This allows the role to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.

Set up an Amazon EC2 instance as a self\-hosted Azure pipelines agent\. For more infornmation, see [Azure Pipelines agent](https://docs.microsoft.com/en-us/azure/devops/pipelines/agents/agents) in the Microsoft Azure DevOps online documentation\. After that's completed, AWS tasks can be added without setting any credentials explicitly\. When running on a build machine, your IAM credentials are picked up automatically\.