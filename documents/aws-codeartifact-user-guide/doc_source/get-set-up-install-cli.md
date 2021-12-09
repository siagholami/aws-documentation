# Install or upgrade and then configure the AWS CLI<a name="get-set-up-install-cli"></a>

 To call CodeArtifact commands from the AWS Command Line Interface \(AWS CLI\) on a local development machine, you must install the AWS CLI\. 

 If you have an older version of the AWS CLI installed, you must upgrade it so the CodeArtifact commands are available\. CodeArtifact commands are available in AWS CLI version 2\.0\.21 and newer\. To check the version, use the `aws --version` command\.

**To install and configure the AWS CLI**

1. Follow the instructions in [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) to install or upgrade the AWS CLI\.

1. To configure the AWS CLI, see [Configuring the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) and [Managing Access Keys for IAM Users](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingCredentials.html)\. 
**Important**  
When you configure the AWS CLI, you are prompted to specify an AWS Region\. Choose one of the supported regions listed in [Region and Endpoints](https://docs.aws.amazon.com/general/latest/gr/codeartifact.html) in the *AWS General Reference*\.

1. To verify the installation or upgrade, call the following command from the AWS CLI\.

   ```
   aws codeartifact help
   ```

   If successful, this command displays a list of available CodeArtifact commands\.

Next, you can create an IAM user and grant that user access to CodeArtifact\. For more information, see [Provision an IAM User](get-set-up-provision-user.md)\.