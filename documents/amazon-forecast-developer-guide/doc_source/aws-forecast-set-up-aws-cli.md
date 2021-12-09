# Set Up the AWS CLI<a name="aws-forecast-set-up-aws-cli"></a>

The AWS Command Line Interface \(AWS CLI\) is a unified developer tool for managing AWS services, including Amazon Forecast\. We recommend that you install and use it\. 

1. To install the AWS CLI, follow the instructions in [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) in the *AWS Command Line Interface User Guide*\. 

1. To configure the AWS CLI and set up a profile to call it, follow the instructions in [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.

1. To confirm that the AWS CLI profile is configured correctly, run the following command in a command window:

   ```
   aws configure --profile default
   ```

   If your profile has been configured correctly, you should see output similar to the following:

   ```
   AWS Access Key ID [****************52FQ]: 
   AWS Secret Access Key [****************xgyZ]: 
   Default region name [us-west-2]: 
   Default output format [json]:
   ```

1. To verify that the AWS CLI is configured for use with Amazon Forecast, run the following commands\.

   ```
   aws forecast help
   ```

   ```
   aws forecastquery help
   ```

   If the AWS CLI is configured correctly, you will see a list of the supported CLI commands for Amazon Forecast or Amazon Forecast Query\.