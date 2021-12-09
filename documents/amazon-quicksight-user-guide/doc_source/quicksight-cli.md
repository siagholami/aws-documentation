# Amazon QuickSight and the AWS CLI<a name="quicksight-cli"></a>

The following procedure explains how to interact with Amazon QuickSight API operations through the AWS CLI\. The following instructions have been tested in Bash but should be identical or similar in other command\-line environments\.

1. Install AWS SDK in your environment\. Instructions on how to do that are located here: [AWS Command line Interface](https://aws.amazon.com/cli/)\.

1. Set up your AWS CLI identity and region using the following command and follow\-up instructions\. Use the credentials for an IAM identity or role that has the proper permissions\. 

   ```
   aws configure
   ```

1. Look at the Amazon QuickSight SDK help by issuing the following command: 

   ```
   aws quicksight help
   ```

1. To get detailed instructions on how to use an API, enter its name followed by help, like so: 

   ```
   aws quicksight list-users help
   ```

1. Now you can call an Amazon QuickSight API operation\. This example returns a list of Amazon QuickSight users in your account\. 

   ```
   aws quicksight list-users --aws-account-id aws-account-id --namespace default --region us-east-1
   ```