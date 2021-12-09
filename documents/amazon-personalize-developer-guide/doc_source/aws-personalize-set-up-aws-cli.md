# Setting Up the AWS CLI<a name="aws-personalize-set-up-aws-cli"></a>

The AWS Command Line Interface \(AWS CLI\) is a unified developer tool for managing AWS services, including Amazon Personalize\. We recommend that you install it\.

1. To install the AWS CLI, follow the instructions in [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) in the *AWS Command Line Interface User Guide*\. 

1. To configure the AWS CLI and set up a profile to call the AWS CLI, follow the instructions in [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.

1. To confirm that the AWS CLI profile is configured properly, run the following command\.

   ```
   aws configure --profile default
   ```

   If your profile has been configured correctly, you will see output similar to the following\.

   ```
   AWS Access Key ID [****************52FQ]: 
   AWS Secret Access Key [****************xgyZ]: 
   Default region name [us-west-2]: 
   Default output format [json]:
   ```

1. To verify that the AWS CLI is configured for use with Amazon Personalize, run the following commands\.

   ```
   aws personalize help
   ```

   and

   ```
   aws personalize-runtime help
   ```

   and

   ```
   aws personalize-events help
   ```

   If the AWS CLI is configured correctly, you will see a list of the supported AWS CLI commands for Amazon Personalize, Amazon Personalize runtime, and Amazon Personalize events\.

   If you set up the AWS CLI and it doesn't recognize the commands for Amazon Personalize, update the AWS CLI\. To update the AWS CLI, run the following command\.

   ```
   pip3 install awscli --upgrade --user
   ```

   For more information, see [Installing the AWS CLI Using pip](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html#install-tool-pip)\.