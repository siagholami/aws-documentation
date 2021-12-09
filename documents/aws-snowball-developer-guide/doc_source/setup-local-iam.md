--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Set Up Local Users<a name="setup-local-iam"></a>

Following are steps to set up a local administrator on your AWS Snowball Edge device\.

1. **Retrieve your root user credentials**

   Use the `snowballEdge list-access-keys` and `snowballEdge get-secret-access-key` to get your local credentials\. For more information, see [Getting Credentials](using-client-commands.md#client-credentials)\.

1. **Configure the root user credential using `aws configure`**

   Supply the `AWS Access Key ID`, `AWS Secret Access Key`, and `Default region name`\. The region name must be `snowball`\. Optionally supply a `Default output format`\. For more information about configuring the AWS CLI, see [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html) in the *AWS Command Line Interface User Guide*\.

1. **Create one or more local users on your device**

   Use the `create-user` command to add users to your device\.

   ```
   aws iam create-user --endpoint endpointIPaddress --profile ProfileID --region snow --user-name UserName
   ```

   After you add users according to your business needs, you can store your AWS root credentials in a safe location and only use them for account and service management tasks\. For more information about creating IAM users, see [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *IAM User Guide*\.

1. **Create an access key for your user**

   Use the `create-access-key` command to create an access key for your user\.

   ```
   aws iam create-access-key --endpoint endpointIPaddress --profile ProfileID --region snow --user-name UserName
   ```

   Save the access key information to a file and distribute to your users\.

1. **Create an access policy**

   You might want different users to have different levels of access to functionality on your device\. The following example creates a policy document named `s3-only-policy` and attaches it to a user\.

   ```
   cat s3-only-policy
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": "s3:*",
         "Resource": "*"
       }
     ]
   }
   ```

   ```
   aws iam create-policy --endpoint endpointIPaddress --profile ProfileID --region snow --policy-name s3-only-policy --policy-document file://s3-only-policy
   ```

1. **Attach the policy to your user**

   Use the `attach-user-policy` to attach the s3\-only\-policy to a user\.

    `aws iam attach-user-policy --endpoint endpointIPaddress --profile ProfileID --region snow --user-name UserName --policy-arn arn:aws:iam::AccountID:UserName` 

For more information about using IAM locally, see [Using IAM Locally](using-local-iam.md)\.

**Next:** [Use the Snowball Edge](transfer-data.md) 