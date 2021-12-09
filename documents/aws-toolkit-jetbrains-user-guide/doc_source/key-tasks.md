# Key tasks for the AWS Toolkit for JetBrains<a name="key-tasks"></a>

Use the following brief instructions to complete key tasks with the AWS Toolkit for JetBrains\.
+ [Install the AWS Toolkit for JetBrains](#key-tasks-install)
+ [Update the AWS Toolkit for JetBrains](#key-tasks-update)
+ [Configure the AWS Toolkit for JetBrains to use an HTTP proxy](#key-tasks-proxy)
+ [Work with connections from the AWS Toolkit for JetBrains to AWS accounts](#key-tasks-connections)
+ [Get the current AWS Region that the AWS Toolkit for JetBrains is using](#key-tasks-current-region)
+ [Switch between AWS Regions](#key-tasks-switch-region)
+ [Open AWS Explorer within the AWS Toolkit for JetBrains](#key-tasks-open-explorer)
+ Work with AWS services
  + [Work with AWS serverless applications](#key-tasks-sam)
  + [Work with AWS Lambda functions](#key-tasks-lambda)
  + [Work with AWS CloudFormation stacks](#key-tasks-cloudformation)
  + [Work with Amazon CloudWatch Logs](#key-tasks-cloudwatch)
  + [Work with Amazon ECS clusters in an account](#key-tasks-ecs)
  + [Work with Amazon EventBridge schemas](#key-tasks-eventbridge)
  + [Work with Amazon S3 buckets and objects](#key-tasks-s3)

## Install the AWS Toolkit for JetBrains<a name="key-tasks-install"></a>

### <a name="account-and-ide-setup"></a>

#### Setting up your AWS account to use AWS Toolkit for JetBrains<a name="aws-account-and-access"></a>

1. [Create an AWS account](https://aws.amazon.com/premiumsupport/knowledge-center/create-and-activate-aws-account/), if you don't have an account already\.

1.  [Create an administrator user and group in AWS Identity and Access Management \(IAM\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html#getting-started_create-admin-group-console) in the account, if you haven't done that already\. 
**Note**  
We recommend that you create or use a special type of user and group in the account for the AWS Toolkit for JetBrains to use, which we call an *administrator* IAM user and group\. Although you can [create a regular IAM user and group](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html#id_users_create_console) in the account for the toolkit to use, this approach might not allow the toolkit to have full access to all of the AWS resources and AWS serverless applications in that account\. We support, but [strongly discourage](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users), using an [AWS account root user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#lock-away-credentials) with the AWS Toolkit for JetBrains\.

1. [Create an access key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey) for the user, if you don't have an [access key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html) for that user already\. 
**Note**  
An access key contains both an *access key ID* value and a *secret access key* value\. The AWS Toolkit for JetBrains needs to use both of these values later\. Be sure to store them in a secure location\. If you lose them, they're gone forever and can't be retrieved\. However, you can always [delete a lost access key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey), and then [create a replacement access key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey)\. If you ever do this, you also need to [change your toolkit connection settings](#key-tasks-change-connect)\. We support, but [strongly discourage](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users), [creating an access key for an AWS account root user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_root-user.html#id_root-user_manage_add-key) for the AWS Toolkit for JetBrains to use\.

#### Installing and configuring AWS Toolkit for JetBrains<a name="install-jetbrains-toolkit"></a>

1. Ensure that a [JetBrains IDE supported by AWS Toolkits](welcome.md#supported-ides) is installed and running\.

1. Open **Settings** / **Preferences**\.

1. Choose **Plugins**\.

1. On the **Marketplace** tab, in **Search plugins in marketplace**, begin entering *AWS Toolkit*\. When **AWS Toolkit by Amazon Web Services** is displayed, choose it\.  
![\[Finding the AWS Toolkit\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Choose **Install**\.  
![\[Installing the AWS Toolkit for JetBrains\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
**Note**  
To use the AWS Toolkit for JetBrains to work with its available features for AWS CloudFormation, AWS Lambda, AWS Serverless, and Amazon ECS, you must install version 1\.8 or later of the AWS Toolkit\.

1. When the **Third\-party Plugins Privacy Note** is displayed, choose **Accept**\.

1. Choose **Restart IDE**, and when prompted, choose **Restart**\.

1. Before you can use the AWS Toolkit for JetBrains to develop, test, analyze, and deploy AWS serverless applications or Lambda functions, be sure you have the following tools installed\. Install the tools in this order:

   1. [AWS Command Line Interface \(AWS CLI\)](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)

   1. [Docker](https://docs.docker.com/install/) \(Docker must always be running whenever you develop, test, analyze, or deploy serverless applications or functions\)

   1. [AWS Serverless Application Model Command Line Interface \(AWS SAM CLI\)](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)

1. Before you can use the AWS Toolkit for JetBrains to debug code in Amazon ECS clusters, you must complete additional steps\. For instructions, see the [prerequisites](ecs-debug.md#ecs-prereqs)\.

1. After you install the AWS Toolkit for JetBrains \(and, if you're working with AWS serverless applications, Lambda functions, or Amazon ECS clusters, you've installed the preceding additional required tools, in order\), [connect to an AWS account for the first time](#key-tasks-first-connect)\.

[Top](#key-tasks)

## Update the AWS Toolkit for JetBrains<a name="key-tasks-update"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install), you can check for updates to the toolkit at any time and install them\. 

To do this, with IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider already running, do the following:

1. Open **Settings** / **Preferences**\.

1. Choose **Updates**\. \(If no updates are displayed, you might need to choose **Check new updates**\.\)  
![\[Checking for updates to the AWS Toolkit for JetBrains\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Follow any on\-screen instructions to finish updating the AWS Toolkit for JetBrains\.

1. Restart the JetBrains IDE\.

## Configure the AWS Toolkit for JetBrains to Use an HTTP Proxy<a name="key-tasks-proxy"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install), you can configure it to use an HTTP proxy\. 

With IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider already running, do one of the following:
+ **CLion** – See [Configure HTTP proxy](https://www.jetbrains.com/help/clion/configuring-http-proxy.html) on the CLion help website\.
+ **GoLand** – See [HTTP Proxy](https://www.jetbrains.com/help/go/settings-http-proxy.html) on the GoLand help website\.
+ **IntelliJ IDEA** – See [HTTP Proxy](https://www.jetbrains.com/help/idea/settings-http-proxy.html) on the IntelliJ IDEA Help website\.
+ **WebStorm** – See [HTTP Proxy](https://www.jetbrains.com/help/webstorm/settings-http-proxy.html) on the WebStorm Help website\.
+ **JetBrains Rider** – See [Configure HTTP Proxy](https://www.jetbrains.com/help/rider/Configuring_HTTP_Proxy.html) on the JetBrains Rider help website\.
+ **PhpStorm** – See [HTTP Proxy](https://www.jetbrains.com/help/phpstorm/settings-http-proxy.html) on the PhpStorm help website\.
+ **PyCharm** – See [HTTP Proxy](https://www.jetbrains.com/help/pycharm/settings-http-proxy.html) on the PyCharm Help website\.
+ **RubyMine** – See [HTTP Proxy](https://www.jetbrains.com/help/ruby/settings-http-proxy.html) on the RubyMine help website\.

After you complete the preceding instructions, the toolkit begins using those HTTP proxy settings\.

[Top](#key-tasks)

## Work with connections from the AWS Toolkit for JetBrains to AWS accounts<a name="key-tasks-connections"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install), use the toolkit to do the following with AWS accounts:
+ [Connect to an AWS account for the first time](#key-tasks-first-connect)
+ [Get the current connection](#key-tasks-current-connect)
+ [Add multiple connections](#key-tasks-multiple-connect)
+ [Switch between connections](#key-tasks-switch-connect)
+ [Change connection settings](#key-tasks-change-connect)
+ [Delete a connection](#key-tasks-delete-connect)

[Top](#key-tasks)

### Connect to an AWS Account for the first time<a name="key-tasks-first-connect"></a>

We assume that you already [installed the AWS Toolkit for JetBrains](#key-tasks-install)\. To complete this procedure, you need an [access key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html) \(which contains both an *access key ID* value and a *secret access key* value\) for a user in IAM \(which we recommend\), or for an AWS account root user \(which we strongly discourage\)\. If you don't have an access key for a user in IAM already, [create one](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey)\.

1. With your access key ID value and secret access key value ready, do one of the following:
   + On the status bar, choose **AWS: No credentials selected**, and then choose **Edit AWS Credential file\(s\)**\.  
![\[AWS no credentials selected on the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)  
![\[Edit AWS credentials from the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
   + [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. Choose **Configure AWS Connection**, and then choose **Edit AWS Credential file\(s\)**\.  
![\[Configure AWS connection from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)  
![\[Edit AWS credentials from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. In the file, under `[default]`, for `aws_access_key_id`, replace `[accessKey1]` with your access key ID value \(for example, `AKIAIOSFODNN7EXAMPLE`\)\.

   If prompted, choose **I want to edit this file anyway**, and then choose **OK**\.

1. For `aws_secret_access_key`, replace `[secretKey1]` with your secret access key value \(for example, `wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY`\)\.

   The final results should look as shown here, following the [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-profiles.html) format\.

   ```
   ... Other file contents omitted for brevity ...
   
   [default]
   # ... Some comments ...
   aws_access_key_id = AKIAIOSFODNN7EXAMPLE
   # ... Some more comments ...
   # ... Some more comments ...
   # ... Some more comments ...
   # ... Some more comments ...
   aws_secret_access_key = wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
   
   ... Other file contents omitted for brevity ...
   ```
**Note**  
The AWS Toolkit for JetBrains currently supports the following configuration variables:  
`aws_access_key_id`
`aws_secret_access_key`
`aws_session_token`
`credential_process`
`mfa_serial`
`role_arn`
`source_profile`
For more information, see [AWS CLI Configuration Variables](https://docs.aws.amazon.com/cli/latest/topic/config-vars.html) in the *AWS CLI Command Reference*\.

1. Save and then close the file\. The AWS Toolkit for JetBrains tries to connect to the account by using the preceding access key\. 

   After connecting, you can use the toolkit to work with AWS resources in that account, such as [AWS serverless](#key-tasks-sam) applications, [AWS Lambda](#key-tasks-lambda) functions, and [AWS CloudFormation](#key-tasks-cloudformation) stacks\.

You can also have [more than one connection](#key-tasks-multiple-connect) available, so that you can [switch between them](#key-tasks-switch-connect)\.

After you connect, the AWS Toolkit for JetBrains selects the default AWS Region automatically\. You might need to [switch connections to work with different AWS resources](#key-tasks-switch-region)\.

[Top](#key-tasks)

### Add multiple connections<a name="key-tasks-multiple-connect"></a>

To complete this procedure, you must first have the additional [access key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html) \(which contains both an *access key ID* value and a *secret access key* value\) for a user in IAM \(recommended\) or AWS account root user \(strongly discouraged\)\. If you don't have an access key for a user IAM already, [create one](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey)\.

1. [Connect for the first time](#key-tasks-first-connect), if you have not done so already\.

1. With the additional access key ID value and secret access key value ready, do one of the following:
   + On the status bar, choose **AWS Connection Settings**, and then choose **All Credentials**, **Edit AWS Credential file\(s\)**\.  
![\[Choosing to edit AWS credentials from the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
   + [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open, and then choose **Show Options Menu** \(the settings icon\)\. Choose **AWS Connection Settings**, **All Credentials**, **Edit AWS Credential file\(s\)**\.  
![\[Choosing to edit AWS credentials from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. In the file, add a [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-profiles.html) for each additional connection\. Profile names can contain only the uppercase letters  **A** through **Z**, the lowercase letters **a** through **z**, the numbers **0** through **9**, the hyphen character \( **\-**\), and the underscore character \( **\_**\)\. Profile names must be less than 64 characters in length\. 

   For example, for a named profile named `myuser`, use the following format\.

   ```
   [profile myuser]
   aws_access_key_id = AKIAIOSFODNN7EXAMPLE
   aws_secret_access_key = wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
   ```
**Note**  
The AWS Toolkit for JetBrains currently supports named profiles with only the following characters: **A**\-**Z**, **a**\-**z**, **0**\-**9**, underscore \(**\_**\), and hyphen \(**\-**\)\.  
Currently, the toolkit supports only the following configuration variables:  
`aws_access_key_id`
`aws_secret_access_key`
`aws_session_token`
`credential_process`
`mfa_serial`
`role_arn`
`source_profile`
For more information, see [AWS CLI Configuration Variables](https://docs.aws.amazon.com/cli/latest/topic/config-vars.html) in the *AWS CLI Command Reference*\.

1. Save and then close the file\. The AWS Toolkit for JetBrains displays the new connection in the **AWS Connection Settings** menu in both the status bar and in **AWS Explorer**\.

Now that you have multiple connections, you can [switch between them](#key-tasks-switch-connect)\.

After you connect, you might need to [switch connections to work with](#key-tasks-switch-region)\.

[Top](#key-tasks)

### Switch between connections<a name="key-tasks-switch-connect"></a>

1. [Add multiple connections](#key-tasks-multiple-connect), if you haven't done so already\.

1. Do one of the following:
   + On the status bar, choose **AWS Connection Settings**\.
   + [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open, and then choose **AWS Connection Settings**\.

1. Choose the [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-profiles.html) to use for the new connection\. If it isn't listed, choose **All Credentials**, and then choose the [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-profiles.html) to use\.   
![\[Switching the current connection\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

   The AWS Toolkit for JetBrains switches to the new connection\. This connection is now selected in the **AWS Connection Settings** menu in both the status bar and **AWS Explorer**\.

After you connect, you might need to [switch to working with AWS resources in that account that are in a different AWS Region](#key-tasks-switch-region)\.

[Top](#key-tasks)

### Change connection settings<a name="key-tasks-change-connect"></a>

1. Do one of the following:
   + On the status bar, choose **AWS Connection Settings**, **All Credentials**, **Edit AWS Credential file\(s\)**\.  
![\[Choosing the Edit AWS Credential files command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
   + [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open, and then choose **Show Options Menu** \(the settings icon\)\. Then choose **AWS Connection Settings**, **All Credentials**, **Edit AWS Credential file\(s\)**\.  
![\[Choosing the Edit AWS Credential files command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Make your changes to the file, and then save and close the file\. 

[Top](#key-tasks)

### Delete a connection<a name="key-tasks-delete-connect"></a>

1. Do one of the following:
   + On the status bar, choose **AWS Connection Settings**, **All Credentials**, **Edit AWS Credential file\(s\)**\.  
![\[Choosing the Edit AWS Credential files command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
   + [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open, and then choose **Show Options Menu** \(the settings icon\)\. Then choose **AWS Connection Settings**, **All Credentials**, **Edit AWS Credential file\(s\)**\.  
![\[Choosing the Edit AWS Credential files command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. In the file, completely delete the [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-profiles.html) \(including the named profile's name, access key ID, and secret access key\) for the connection that you want to delete\.

1. Save and then close the file\. The AWS Toolkit for JetBrains removes the deleted connection from the **AWS Connection Settings** menu in both the status bar and in **AWS Explorer**\.

After you delete a connection, you might need to [switch to a different connection](#key-tasks-switch-connect) or [connect for the first time](#key-tasks-first-connect) again\.

[Top](#key-tasks)

## Get the current connection<a name="key-tasks-current-connect"></a>

To check which connection the AWS Toolkit for JetBrains is currently using, do one of the following:
+ On the status bar, see the current connection displayed in the **AWS Connection Settings** area\.  
![\[The current connection in the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
+ [Open AWS Explorer](#key-tasks-open-explorer), if it's not already open, and then choose **Show Options Menu** \(the settings icon\)\. Choose **AWS Connection Settings**\. The current connection is selected\.  
![\[The current connection in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

You can also have [more than one connection](#key-tasks-multiple-connect) available, so that you can [switch between them](#key-tasks-switch-connect)\.

[Top](#key-tasks)

## Get the current AWS Region<a name="key-tasks-current-region"></a>

To check which AWS Region the AWS Toolkit for JetBrains is currently using, do one of the following:
+ On the status bar, see the current Region displayed in the **AWS Connection Settings** area\.  
![\[The current AWS Region in the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
+ [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open, and then choose **Show Options Menu** \(the settings icon\)\. Choose **AWS Connection Settings**\. The current Region is selected\.  
![\[The current AWS Region in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

You can also [switch to a different AWS Region](#key-tasks-switch-region)\.

[Top](#key-tasks)

## Switch between AWS Regions<a name="key-tasks-switch-region"></a>

To switch AWS Regions, do one of the following:
+ On the status bar, choose **AWS Connection Settings**, and then choose the AWS Region that you want to switch to\.  
![\[Choosing a different AWS Region in the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
+ [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. Choose **Show Options Menu** \(the settings icon\), and then choose **AWS Connection Settings**\. If the AWS Region that you want to switch to is listed, choose it\. Otherwise, choose **All Regions**, and then choose the Region to switch to\.  
![\[Choosing a different AWS Region in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The AWS Toolkit for JetBrains switches to using the new Region\. The Region is now selected in the **AWS Connection Settings** menu in both the status bar and **AWS Explorer**\.

[Top](#key-tasks)

## Open AWS Explorer within the AWS Toolkit for JetBrains<a name="key-tasks-open-explorer"></a>

To complete this procedure, you must first [install the AWS Toolkit](#key-tasks-install)\. Then, with IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider already running, do one of the following:
+ On the tool window bar, choose **AWS Explorer**\.  
![\[AWS Explorer tool window button\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
+ On the **View** menu, choose **Tool Windows**, **AWS Explorer**\.  
![\[Opening AWS Explorer from the main menu\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

After you open **AWS Explorer** for the first time, use it to [connect to an AWS account for the first time](#key-tasks-first-connect)\. After that, you can use **AWS Explorer** to work with [AWS Lambda](#key-tasks-lambda) functions and [AWS CloudFormation](#key-tasks-cloudformation) stacks in the account\.

[Top](#key-tasks)

## Work with AWS Serverless Applications<a name="key-tasks-sam"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install) and then use it to [connect to an AWS account for the first time](#key-tasks-first-connect), you can use the toolkit to work with AWS serverless applications in an account, as follows:
+ [Create a serverless application](#key-tasks-sam-create)
+ [Deploy a serverless application](#key-tasks-sam-deploy)
+ [Change \(update\) the settings for a serverless application](#key-tasks-sam-update)
+ [Delete a serverless application](#key-tasks-sam-delete)

[Top](#key-tasks)

### Create a serverless application<a name="key-tasks-sam-create"></a>

To complete this procedure, you must first [install the AWS Toolkit for JetBrains](#key-tasks-install), and if you haven't yet, [connect to an AWS account for the first time](#key-tasks-first-connect)\. 

1. With IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider already running, do one of the following:
   + For IntelliJ IDEA or WebStorm, choose **File**, **New**, **Project**\.
   + For PyCharm, choose **File**, **New Project**\.
   + For JetBrains Rider, choose **File**, **New** for a new solution\. Or right\-click an existing solution in the **Explorer** tool window, and then choose **Add**, **New Project**\.

1. For IntelliJ IDEA, choose **AWS**, **AWS Serverless Application**, and then choose **Next**\.  
![\[Choosing to create an AWS serverless application in IntelliJ IDEA\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

   For PyCharm, choose **AWS Serverless Application**\.  
![\[Choosing to create an AWS serverless application in PyCharm\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

   For WebStorm, choose **AWS Serverless Application**\.  
![\[Choosing to create an AWS serverless application in WebStorm\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

   For JetBrains Rider, choose **AWS Serverless Application**\.  
![\[Choosing to create an AWS serverless application in JetBrains Rider\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [New Project dialog box \(or the New Solution dialog box for JetBrains Rider\)](new-project-dialog.md), and then choose **Finish** \(for IntelliJ IDEA\) or **Create** \(for PyCharm, WebStorm, or JetBrains Rider\)\. The AWS Toolkit for JetBrains creates the project and adds the serverless application's code files to the new project\.

1. If you're using IntelliJ IDEA, with the **Project** tool window already open and displaying the project that contains the serverless application's files, do one of the following:
   + For Maven\-based projects, right\-click the project's `pom.xml` file, and then choose **Add as Maven Project**\.  
![\[Choosing to add the POM file as a Maven project\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
   + For Gradle\-based projects, right\-click the project's `build.gradle` file, and then choose **Import Gradle project**\.  
![\[Choosing to import the Gradle project\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

     Complete the **Import Module from Gradle** dialog box, and then choose **OK**\.

After you create the serverless application, you can [run \(invoke\) or debug the local version of an AWS Lambda function](#key-tasks-lambda-local) that is contained in that application\.

You can also [deploy the serverless application](#key-tasks-sam-deploy)\. After you deploy it, you can [run \(invoke\) the remote version of a Lambda function](#key-tasks-lambda-remote) that is part of that deployed application\.

[Top](#key-tasks)

### Deploy a serverless application<a name="key-tasks-sam-deploy"></a>

Before you can use this procedure to deploy an AWS serverless application, you must first [create the AWS serverless application](#key-tasks-sam-create)\. Then follow these steps\.
**Note**  
To deploy a serverless application that contains an AWS Lambda function, and deploy that function with any nondefault or optional properties, you must first set those properties in the function's corresponding AWS Serverless Application Model \(AWS SAM\) template file \(for example, in a file named `template.yaml` within the project\)\. For a list of available properties, see [AWS::Serverless::Function](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#awsserverlessfunction) in the [awslabs/serverless\-application\-model](https://github.com/awslabs/serverless-application-model/) repository on GitHub\.

1. If you need to [switch to a different AWS Region](#key-tasks-switch-region) to deploy the serverless application, do that now\. 

1. With the **Project** tool window already open and displaying the project that contains the serverless application's files, right\-click the project's `template.yaml` file\. Then choose **Deploy Serverless Application**\.  
![\[Choosing the Deploy Serverless Application command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [Deploy Serverless Application](deploy-serverless-application-dialog.md) dialog box, and then choose **Deploy**\. 

   The AWS Toolkit for JetBrains creates a corresponding AWS CloudFormation stack for the deployment\. It also adds the name of the stack to the **CloudFormation** list in **AWS Explorer**\. If the deployment fails, you can try to figure out why by [viewing event logs for the stack](#key-tasks-cloudformation-logs)\.

After you deploy it, you can [run \(invoke\) the remote version of an AWS Lambda function](#key-tasks-lambda-remote) that is part of that deployed application\.

[Top](#key-tasks)

### Change \(update\) the settings for a serverless application<a name="key-tasks-sam-update"></a>

Before you can use this procedure to change settings for a serverless application, you must first [deploy the AWS serverless application](#key-tasks-sam-deploy) that you want to change\. Then follow these steps\.
**Note**  
To deploy a serverless application that contains an AWS Lambda function, and deploy that function with any nondefault or optional properties, you must first set those properties in the function's corresponding AWS SAM template file \(for example, in a file named `template.yaml` within the project\)\. For a list of available properties, see [AWS::Serverless::Function](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#awsserverlessfunction) in the [awslabs/serverless\-application\-model](https://github.com/awslabs/serverless-application-model/) repository on GitHub\.

1. With the **Project** tool window already open and displaying the project that contains the serverless application's files, open the project's `template.yaml` file\. Change the file's contents to reflect the new settings, and then save and close the file\.

1. If you need to [switch to a different AWS Region](#key-tasks-switch-region) to deploy the serverless application to, do that now\.

1. Right\-click the project's `template.yaml` file, and then choose **Deploy Serverless Application**\.  
![\[Choosing the Deploy Serverless Application command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [Deploy Serverless Application](deploy-serverless-application-dialog.md) dialog box, and then choose **Deploy**\. The AWS Toolkit for JetBrains updates the corresponding AWS CloudFormation stack for the deployment\. 

   If the deployment fails, you can try to figure out why by [viewing event logs for the stack](#key-tasks-cloudformation-logs)\.

[Top](#key-tasks)

### Delete a serverless application<a name="key-tasks-sam-delete"></a>

Before you can use this procedure to delete a serverless application, you must first [deploy the AWS serverless application](#key-tasks-sam-deploy) that you want to delete\. Then follow these steps\.

1. [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](#key-tasks-switch-region) that contains the serverless application, do that now\.

1. Expand **CloudFormation**\.

1. Right\-click the name of the AWS CloudFormation stack that contains the serverless application you want to delete, and then choose **Delete CloudFormation Stack**\.  
![\[Choosing to delete the AWS CloudFormation stack for an AWS serverless application starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the stack's name to confirm the deletion, and then choose **OK**\. If the stack deletion succeeds, the AWS Toolkit for JetBrains removes the stack name from the **CloudFormation** list in **AWS Explorer**\. If the stack deletion fails, you can try to figure out why by [viewing event logs for the stack](#key-tasks-cloudformation-logs)\.

[Top](#key-tasks)

## Work with AWS Lambda Functions<a name="key-tasks-lambda"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install) and then use the toolkit to [connect to an AWS account for the first time](#key-tasks-first-connect), you can use the toolkit to work with Lambda functions in the account, as follows\.
+ [Create a function](#key-tasks-lambda-create)
+ [Run \(invoke\) or debug the local version of a function](#key-tasks-lambda-local)
+ [Run \(invoke\) the remote version of a function](#key-tasks-lambda-remote)
+ [Change \(update\) the configuration for a function](#key-tasks-lambda-update)
+ [Delete a function](#key-tasks-lambda-delete)

[Top](#key-tasks)

### Create a function<a name="key-tasks-lambda-create"></a>

You can use the AWS Toolkit for JetBrains to create a Lambda function that is [part of an AWS serverless application](#key-tasks-lambda-create-app), or you can create a Lambda function [by itself](#key-tasks-lambda-create-standalone)\.

#### Create a serverless application that contains a Lambda Function<a name="key-tasks-lambda-create-app"></a>

See the instructions earlier in this topic about [creating an AWS serverless application](#key-tasks-sam-create)\.

[Top](#key-tasks)

#### Create a standalone function<a name="key-tasks-lambda-create-standalone"></a>

To complete this procedure, you must first [install the ](#key-tasks-install)AWS Toolkit for JetBrains and, if you haven't yet, [connect to an AWS account for the first time](#key-tasks-first-connect)\. 

Then with IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider already running, do one of the following:
+ [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](#key-tasks-switch-region) to create the function in, do that now\. Then right\-click **Lambda**, and choose **Create new AWS Lambda**\.  
![\[Creating an AWS Lambda function by starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

  Complete the [Create Function](create-function-dialog.md) dialog box, and then choose **Create Function**\. The AWS Toolkit for JetBrains creates a corresponding AWS CloudFormation stack for the deployment, and adds the function name to the **Lambda** list in **AWS Explorer**\. If the deployment fails, you can try to figure out why by [viewing event logs for the stack](#key-tasks-cloudformation-logs)\.
+ Create a code file that implements a function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html)\. 

  If you need to [switch to a different AWS Region](#key-tasks-switch-region) to create the remote function to be run \(invoked\), do that now\. Then in the code file, choose the **Lambda** icon in the gutter next to the function handler, and then choose **Create new AWS Lambda**\. Complete the [Create Function](create-function-dialog.md) dialog box, and then choose **Create Function**\.  
![\[Creating an AWS Lambda function by starting from an existing function handler in a code file\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
**Note**  
If the **Lambda** icon isn't displayed in the gutter next to the function handler, try displaying it for the current project by selecting the following box in **Settings**/**Preferences**: **Tools**, **AWS**, **Project settings**, **Show gutter icons for all potential AWS Lambda handlers**\. Also, if the function handler is already defined in the corresponding AWS SAM template, the **Create new AWS Lambda** command won't appear\.

  After you choose **Create Function**, the AWS Toolkit for JetBrains creates a corresponding function in the Lambda service for the connected AWS account\. If the operation succeeds, after you refresh **AWS Explorer**, the **Lambda** list displays the name of the new function\.
+ If you already have a project that contains an AWS Lambda function, and if you need to first [switch to a different AWS Region](#key-tasks-switch-region) to create the function in, do that now\. Then in the code file that contains the function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html), choose the **Lambda** icon in the gutter next to the function handler\. Choose **Create new AWS Lambda**, complete the [Create Function](create-function-dialog.md) dialog box, and then choose **Create Function**\.  
![\[Creating an AWS Lambda function by starting from an existing function handler in a code file\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
**Note**  
If the **Lambda** icon isn't displayed in the gutter next to the function handler, try displaying it for the current project by selecting the following box in **Settings**/**Preferences**: **Tools**, **AWS**, **Project settings**, **Show gutter icons for all potential AWS Lambda handlers**\. Also, the **Create new AWS Lambda** command won't be displayed if the function handler is already defined in the corresponding AWS SAM template\.

  After you choose **Create Function**, the AWS Toolkit for JetBrains creates a corresponding function in the Lambda service for the connected AWS account\. If the operation succeeds, after you refresh **AWS Explorer**, the new function's name appears in the **Lambda** list\.

After you create the function, you can [run \(invoke\) or debug the local version of the function](#key-tasks-lambda-local) or [run \(invoke\) the remote version](#key-tasks-lambda-remote)\.

[Top](#key-tasks)

### Run \(invoke\) or debug the local version of a function<a name="key-tasks-lambda-local"></a>

A *local* version of an AWS Lambda function is a function whose source code already exists on your local development computer\.

To complete this procedure, you must first [create the AWS Lambda function](#key-tasks-lambda-create) that you want to run \(invoke\) or debug, if you haven't created it already\.
**Note**  
To run \(invoke\) or debug the local version of a Lambda function, and run \(invoke\) or debug that function locally with any nondefault or optional properties, you must first set those properties in the function's corresponding AWS SAM template file \(for example, in a file named `template.yaml` within the project\)\. For a list of available properties, see [AWS::Serverless::Function](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#awsserverlessfunction) in the [awslabs/serverless\-application\-model](https://github.com/awslabs/serverless-application-model/) repository on GitHub\.

1. Do one of the following:
   + In the code file that contains the function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html), choose the Lambda icon in the gutter next to the function handler\. Choose **Run '\[Local\]'** or **Debug '\[Local\]'**\.   
![\[Running or debugging the local version of a Lambda function by starting from the function handler in the code file\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
   + With the **Project** tool window already open and displaying the project that contains the function, open the project's `template.yaml` file\. Choose the **Run** icon in the gutter next to the function's resource definition, and then choose **Run '\[Local\]'** or **Debug '\[Local\]'**\.  
![\[Running or debugging the local version of a Lambda function by starting from the function definition in the AWS SAM template file\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [Edit configuration](edit-configuration-dialog.md) dialog box if it's displayed, and then choose **Run** or **Debug**\. Results are displayed in the **Run** or **Debug** tool window\.
   + If the **Edit configuration** dialog box doesn't appear and you want to change the existing configuration, first [change its configuration](#key-tasks-lambda-update), and then repeat this procedure from the beginning\. 
   + If the configuration details are missing, expand **Templates**, **AWS Lambda**, and then choose **Local**\. Choose **OK**, and then repeat this procedure from the beginning\. 

[Top](#key-tasks)

### Run \(invoke\) the remote version of a function<a name="key-tasks-lambda-remote"></a>

A *remote* version of an AWS Lambda function is a function whose source code already exists inside of the Lambda service for an AWS account\.

To complete this procedure, you must first [install the AWS Toolkit for JetBrains](#key-tasks-install) and, if you haven't yet, [connect to an AWS account for the first time](#key-tasks-first-connect)\. Then with IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider running, do the following\.

1. [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](#key-tasks-switch-region) that contains the function, do that now\.

1. Expand **Lambda**, and confirm that the name of the function is listed\. If it is, skip ahead to step 3 in this procedure\.

   If the name of the function isn't listed, [create the Lambda function](#key-tasks-lambda-create) that you want to run \(invoke\)\. 

   If you created the function as [part of an AWS serverless application](#key-tasks-lambda-create-app), you must also [deploy that application](#key-tasks-sam-deploy)\.

   If you created the function by creating a code file that implements a function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html), then in the code file, choose the Lambda icon next to the function handler\. Then choose **Create new AWS Lambda**\. Complete the [Create Function](create-function-dialog.md) dialog box, and then choose **Create Function**\.

1. With **Lambda** open in **AWS Explorer**, right\-click the name of the function, and then choose **Run '\[Remote\]'**\.  
![\[Running the remote version of a Lambda function by starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [Edit configuration](edit-configuration-dialog.md) dialog box if it's displayed, and then choose **Run** or **Debug**\. Results are displayed in the **Run** or **Debug** tool window\.
   + If the **Edit configuration** dialog box doesn't appear and you want to change the existing configuration, first [change its configuration](#key-tasks-lambda-update), and then repeat this procedure from the beginning\. 
   + If the configuration details are missing, expand **Templates**, **AWS Lambda**, and then choose **Local**\. Choose **OK**, and then repeat this procedure from the beginning\. 

[Top](#key-tasks)

### Change \(update\) the configuration for a function<a name="key-tasks-lambda-update"></a>

Do one of the following:
+ With the code file open that contains the function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html), on the main menu, choose **Run**, **Edit Configurations**\. Complete the [Run/Debug Configurations](run-debug-configurations-dialog.md) dialog box, and then choose **OK**\.
+ [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](#key-tasks-switch-region) that contains the function, do that now\. Expand **Lambda**, choose the name of the function to change the configuration for, and then do one of the following:
  + **Change settings such as the timeout, memory, environment variables, and execution role –** Right\-click the name of the function, and then choose **Update Function Configuration**\.  
![\[Choosing the Update Function Configuration command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

    Complete the [Update Configuration](update-configuration-dialog.md) dialog box, and then choose **Update**\. 
  + **Change settings such as the input payload** – On the main menu, choose **Run**, **Edit Configurations**\. Complete the [Run/Debug Configurations](run-debug-configurations-dialog.md) dialog box, and then choose **OK**\.  
![\[Choosing the Edit Configurations command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

    If the configuration details are missing, first expand **Templates**, **AWS Lambda**, and then choose **Local** \(for the local version of the function\) or **Remote** \(for the remote version of that same function\)\. Choose **OK**, and then repeat this procedure from the beginning\.\)
  + **Change settings such as the function handler name or Amazon Simple Storage Service \(Amazon S3\) source bucket** – Right\-click the function name, and then choose **Update Function Code**\.  
![\[Choosing the Update Function Code command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

    Complete the [Update Code](update-code-dialog.md) dialog box, and then choose **Update**\.
  + **Change other available property settings that aren't listed in the preceding bullets** – Change those settings in the function's corresponding AWS SAM template file \(for example, in a file named `template.yaml` within the project\)\. 

    For a list of available property settings, see [AWS::Serverless::Function](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#awsserverlessfunction) in the [awslabs/serverless\-application\-model](https://github.com/awslabs/serverless-application-model/) repository on GitHub\. 

[Top](#key-tasks)

### Delete a function<a name="key-tasks-lambda-delete"></a>

You can use the AWS Toolkit for JetBrains to delete an AWS Lambda function that is [part of an AWS serverless application](#key-tasks-lambda-delete-sam)\. Or you can delete a [standalone Lambda function](#key-tasks-lambda-delete-standalone)\.

#### Delete a serverless application that contains a function<a name="key-tasks-lambda-delete-sam"></a>

See the instructions for [deleting a serverless application](#key-tasks-sam-delete), earlier in this topic\.

[Top](#key-tasks)

#### Delete a standalone function<a name="key-tasks-lambda-delete-standalone"></a>

1. [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](#key-tasks-switch-region) that contains the function, do that now\.

1. Expand **Lambda**\.

1. Right\-click the name of the function to delete, and then choose **Delete Function**\.  
![\[Choosing the Delete Function command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the function's name to confirm the deletion, and then choose **OK**\. If the function deletion succeeds, the AWS Toolkit for JetBrains removes the function name from the **Lambda** list\.

[Top](#key-tasks)

## Work with AWS CloudFormation stacks<a name="key-tasks-cloudformation"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install) and then use the toolkit to [connect to an AWS account for the first time](#key-tasks-first-connect), you can use the toolkit to work with AWS CloudFormation stacks in the account, as follows:
+ [View event logs for a stack](#key-tasks-cloudformation-logs)
+ [Delete a stack](#key-tasks-cloudformation-delete)

Currently, you can't use the AWS Toolkit for JetBrains to directly [create stacks](#key-tasks-cloudformation-create) or to [change stack settings](#key-tasks-cloudformation-change)\. However, you can do these tasks indirectly as part of working with AWS serverless applications and AWS Lambda functions, as follows\.

[Top](#key-tasks)

### Create a stack<a name="key-tasks-cloudformation-create"></a>

Currently, you can't use the AWS Toolkit for JetBrains to create an AWS CloudFormation stack directly\. However, whenever you use the toolkit to [deploy an AWS serverless application](#key-tasks-sam-deploy) or to [create and then deploy an AWS Lambda function](#key-tasks-lambda-create-standalone), the toolkit deploys these by first creating a corresponding stack in AWS CloudFormation, and then using that stack for the deployment\.

[Top](#key-tasks)

### Change stack settings<a name="key-tasks-cloudformation-change"></a>

Currently, you can't use the AWS Toolkit for JetBrains to change the settings for an AWS CloudFormation stack directly\. However, you can [change \(update\) the settings for an AWS serverless application](#key-tasks-sam-update) that belongs to a stack, or [change \(update\) the configuration for an AWS Lambda function](#key-tasks-lambda-update) that belongs to a stack\. Then you [deploy that serverless application](#key-tasks-sam-deploy) again or deploy that function, as part of the lifecycle of [running \(invoking\) the remote version of that function](#key-tasks-lambda-remote), again\. 

[Top](#key-tasks)

### View event logs for a stack<a name="key-tasks-cloudformation-logs"></a>

1. [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If the stack is in an AWS Region that's different from the current one, [switch to a different AWS Region](#key-tasks-switch-region) that contains it\.

1. Expand **CloudFormation**\.

1. To view event logs for the stack, right\-click the stack's name\. The AWS Toolkit for JetBrains displays the event logs in the **CloudFormation** tool window\.

   To hide or show the **CloudFormation** tool window, on the main menu, choose **View**, **Tool Windows**, **CloudFormation**\.  
![\[Choosing to view event logs for an AWS CloudFormation stack starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

[Top](#key-tasks)

### Deleting a stack<a name="key-tasks-cloudformation-delete"></a>

1. [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](#key-tasks-switch-region) that contains the stack, do that now\.

1. Expand **CloudFormation**\.

1. Right\-click the name of the stack to delete, and then choose **Delete CloudFormation Stack**\.  
![\[Choosing to delete a AWS CloudFormation stack starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the stack's name to confirm it's deleted, and then choose **OK**\. If the stack deletion succeeds, the AWS Toolkit for JetBrains removes the stack name from the **CloudFormation** list in **AWS Explorer**\. If the stack deletion fails, you can troubleshoot by [viewing the event logs for the stack](#key-tasks-cloudformation-logs)\.

[Top](#key-tasks)

## Work with Amazon CloudWatch Logs<a name="key-tasks-cloudwatch"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install) and then use the toolkit to [connect to an AWS account for the first time](#key-tasks-first-connect), you can use the toolkit to work with Amazon CloudWatch Logs in the account, as follows\.
+ [Viewing CloudWatch log groups and log streams](viewing-CloudWatch-logs.md)
+ [Working with CloudWatch log events](working-CloudWatch-log-events.md)

[Top](#key-tasks)

## Work with Amazon ECS clusters<a name="key-tasks-ecs"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install) and then use the toolkit to [connect to an AWS account for the first time](#key-tasks-first-connect), you can use the toolkit to work with Amazon ECS clusters in the account, as follows\. 

### Debug code in a cluster<a name="key-tasks-ecs-debug"></a>

After you complete the [prerequisites](ecs-debug.md#ecs-prereqs), do the following\.

1. [Open AWS Explorer](#key-tasks-open-explorer), if it isn't already open\. If the [Amazon ECS cluster](ecs-debug.md#ecs-cluster) is in an AWS Region that's different from the current one, [switch to a different AWS Region](#key-tasks-switch-region) that contains it\.

1. Expand **ECS**, and then expand **Clusters**\.

1. Expand your Amazon ECS cluster, right\-click your service, and then choose **Enable Cloud Debugging**\. For example, in the following screenshot, the cluster is named **java**, and the service is named **java\-service**\.  
![\[Enabling cloud debugging in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. When prompted, choose your [Amazon ECS task role](ecs-debug.md#ecs-task-role), and then choose **OK**\.

   The status bar displays the message **Configuring Cloud Debugging resource**\. Wait until the **Build Output** tab of the **Build** tool window displays a successful configuration message\. \(A related pop\-up also is displayed in the lower\-right corner\.\) This will take several minutes\.
**Note**  
As you enable code debugging in your AWS account for the first time, the AWS Toolkit for JetBrains creates an Amazon S3 bucket in your AWS account\. The bucket's name follows the format of `do-not-delete-cloud-debug-Region-ID-account-ID`\. The JetBrains Toolkit stores information in this bucket to enable code debugging\. **Do not delete this bucket or modify its contents\.** If you do, code debugging might stop working or produce unexpected results\. If you accidentally delete or modify this bucket, the JetBrains Toolkit will try to recreate the bucket\. You can also force the JetBrains Toolkit to recreate the bucket by choosing **Enable Cloud Debugging** again as described earlier, or by choosing **Disable Cloud Debugging** as described later in this procedure\.

1. With the code you want to debug displayed, in the **AWS Explorer**, expand **ECS**, expand **Clusters**, and then expand your cluster\. A service is displayed with a debug icon next to it\. This indicates the service is now enabled for cloud debugging\. Right\-click the service with the debug icon, and then choose **Debug**\.  
![\[Debugging an Amazon ECS service in the AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [**Edit configuration**](edit-configuration-dialog.md#edit-configuration-dialog-ecs) dialog box, and then choose **Debug**\.
**Note**  
To make changes to this configuration later, on the menu bar, choose **Run**, **Edit Configurations**\. Then expand **Amazon ECS Service Cloud Debug**, and choose the service's name\. 

1. Use the IDE's built\-in debugging tools to debug your code as usual\.

1. If you make changes to your code, you can start debugging again\. In the **AWS Explorer**, expand **ECS**, expand **Clusters**, and then expand your cluster\. Right\-click your service with the debug icon next to it, and then choose **Debug**\.

1. If you make changes to the associated `Dockerfile`, you must rebuild and republish the Docker image, and then repeat this procedure from the beginning\.

1. To disable debugging, in the **AWS Explorer**, expand **ECS**, expand **Clusters**, and then expand your cluster\. Right\-click your service with the debug icon next to it, and then choose **Disable Cloud Debugging**\. A pop\-up is displayed, confirming that debugging is disabled\.

[Top](#key-tasks)

## Working with Amazon EventBridge schemas<a name="key-tasks-eventbridge"></a>

See [Working with Amazon EventBridge schemas](eventbridge-schemas.md)\.

[Top](#key-tasks)

## Work with Amazon S3 buckets and objects<a name="key-tasks-s3"></a>

After you [install the AWS Toolkit for JetBrains](#key-tasks-install) and then use the toolkit to [connect to an AWS account for the first time](#key-tasks-first-connect), you can use the toolkit to work with Amazon S3 buckets and objects in the account, as follows\.
+ [Work with Amazon S3 buckets](work-with-S3-buckets.md)
+ [Work with Amazon S3 objects](work-with-S3-objects.md)

[Top](#key-tasks)