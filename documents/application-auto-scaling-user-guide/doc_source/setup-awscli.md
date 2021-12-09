# Set Up the AWS CLI<a name="setup-awscli"></a>

The AWS Command Line Interface \(AWS CLI\) is a unified developer tool for managing AWS services, including Application Auto Scaling\. Follow the steps to download and configure the AWS CLI\.

**To set up the AWS CLI**

1. Download and configure the AWS CLI\. For instructions, see the following topics in the *AWS Command Line Interface User Guide*: 
   + [Installing the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-set-up.html)
   + [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html)

1. Run the following command to verify that the Application Auto Scaling commands for the AWS CLI are installed\.

   ```
   aws application-autoscaling help
   ```

1. Add a named profile for the administrator user in the AWS CLI config file\. You can use this profile when executing AWS CLI commands\. For more information about named profiles, see [Named Profiles](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-profiles.html) in the *AWS Command Line Interface User Guide*\.

   ```
   aws configure --profile adminuser
   ```

   When prompted, specify the AWS access key and AWS secret access key of the IAM user to use with Application Auto Scaling\.

   ```
   aws_access_key_id = adminuser access key ID
   aws_secret_access_key = adminuser secret access key
   region = aws-region
   default output format = json
   ```

   For a list of available AWS Regions, see [Application Auto Scaling Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/as-app.html) in the *Amazon Web Services General Reference*\.

1. To confirm that the AWS CLI profile is configured correctly, run the following command in a command window\.

   ```
   aws configure --profile adminuser
   ```

   If your profile has been configured correctly, you should see output similar to the following\.

   ```
   AWS Access Key ID [****************52FQ]: 
   AWS Secret Access Key [****************xgyZ]: 
   Default region name [us-east-1]: 
   Default output format [json]:
   ```

After you set up an AWS account and the AWS CLI, you can try the next tutorial, in which you configure sample scheduled scaling actions\. 