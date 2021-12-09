# Install or upgrade and then configure the AWS CLI<a name="get-set-up-install-cli"></a>

 To call Amazon CodeGuru Reviewer commands from the AWS Command Line Interface \(AWS CLI\) on a local development machine, you must install the AWS CLI\. 

**Note**  
You cannot create a repository association for a GitHub repository using the AWS CLI\. You can use the AWS CLI to create a repository association for all other support supported repository types\. For more information, see [Working with repository associations in Amazon CodeGuru Reviewer](working-with-repositories.md)\.

 If you have an older version of the AWS CLI installed, we recommend you upgrade it so the CodeGuru Reviewer commands are available\. To check the version, use the `aws --version` command\.

**To install and configure the AWS CLI**

1. Follow the instructions in [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) to install or upgrade the AWS CLI\.

1. To configure the AWS CLI, see [Configuring the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) and [Managing Access Keys for IAM Users](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingCredentials.html)\. 
**Important**  
When you configure the AWS CLI, you are prompted to specify an AWS Region\. Choose one of the supported Regions listed in [Region and Endpoints](https://docs.aws.amazon.com/general/latest/gr/codeguru-reviewer.html) in the *AWS General Reference*\.

1. To verify the installation or upgrade, call the following command from the AWS CLI\.

   ```
   aws codeguru-reviewer help
   ```

   If successful, this command displays a list of available CodeGuru Reviewer commands\.