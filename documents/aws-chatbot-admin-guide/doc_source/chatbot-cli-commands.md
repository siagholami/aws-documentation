# Running AWS CLI commands from Slack channels<a name="chatbot-cli-commands"></a>

You can run commands using AWS CLI syntax directly in Slack channels\. AWS Chatbot enables you to retrieve diagnostic information, invoke Lambda functions, and create support cases for your AWS resources\. 

When you interact with AWS Chatbot in Slack, it parses your input and prompts you for any missing parameters before it runs the command\. 

## Using commands in Slack<a name="intro-to-the-aws-cli-in-slack"></a>

After you set up the AWS Chatbot in your Slack workspace, you run commands in Slack with the following prefix:

`@aws`

The AWS Chatbot command syntax is the same as you would use in a terminal:

`@aws service command --options`

**Note**  
You can specify parameters with either a double hyphen \(*\-\-option*\) or a single hyphen \(*\-option*\)\. This allows you to use a mobile device to run commands without running into issues with the mobile device automatically converting a double hyphen to a long dash\.

For example, enter the following read\-only command to view a list of your Lambda functions:

`@aws lambda list-functions`

Enter the following commands to list and chart CloudWatch alarms:

`@aws cloudwatch describe-alarms --state ALARM`

You can enter a complete AWS CLI command with all the parameters, or you can enter the command without parameters and AWS Chatbot prompts you for missing parameters\.

The following limitations apply to running AWS CLI commands in your Slack chat rooms:
+ AWS Chatbot does not support commands to create, delete, or configure AWS resources \(for example, to delete an S3 bucket\)\. 
+ You may experience some latency when invoking commands through AWS Chatbot\.
+ Regardless of their AWS Chatbot role permissions, users cannot run IAM, AWS Security Token Service, or AWS Key Management Service commands within Slack channels\.
+ Amazon S3 service commands support Linux\-style command aliases such as **ls** and **cp**\. AWS Chatbot does not support Amazon S3 command aliases for commands in Slack\.
+ Users cannot display or decrypt secret keys or key pairs for any AWS service, or pass IAM credentials\.
+ You can't use AWS CLI command memory \(that is, recent commands appear when the user presses up arrow or down arrow keys\) in the Slack channel\. You must enter, or copy and paste each AWS CLI command in the Slack channel\.
+ You can create AWS support cases through your Slack channels\. You cannot add attachments to these cases from the Slack channel\.
+ Slack channels do not support standard AWS CLI pagination\. 

## Managing permissions for running commands using AWS Chatbot<a name="iam-policies-for-slack-channels-cli-support"></a>

With AWS Identity and Access Management \(IAM\), you can use *identity\-based policies*, which are JSON permissions policy documents, and attach them to an *identity*, such as an IAM user, role, or group\. These policies control what actions an identity can perform\. AWS Chatbot provides three IAM policies in the AWS Chatbot console, that you can use to quickly set up AWS CLI commands support for Slack channels\. Those policies include:
+ **ReadOnly Command Permissions**
+ **Lambda\-Invoke Command Permissions**
+ **AWS Support Command Permissions**

You can use any or all of these policies, based on your organization's requirements\. To use them, create a new role in the AWS Chatbot console and attach them there, or attach the policies to the AWS Chatbot IAM roles using the IAM console\. The policies simplify AWS Chatbot role configuration and enable you to set up quickly\. 

You can use these IAM policies as templates to define your own policies\. For example, all policies described here use a wildcard \("\*"\) to apply the policy's permissions to all resources:

```
               "Resource": [
                "*"
            ]
```

You can define custom permissions in a policy to limit actions to specific resources in your AWS account\. These are called *resource\-based permissions*\. For more information on defining resources in a policy, see the section [IAM JSON Policy Elements: Resource](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_resource.html) in the *IAM User Guide*\.

For more information on these policies, see [Configuring an IAM Role for AWS Chatbot](getting-started.md#AWS::Chatbot::Role)\.

### Using the AWS Chatbot read\-only command permissions policy<a name="about-readonlycommand-chatbot-policy"></a>

The AWS Chatbot **ReadOnly Command Permissions** policy controls access to several important AWS services, including IAM, AWS Security Token Service \(AWS STS\), AWS Key Management Service \(AWS KMS\), and Amazon S3\. It disallows all IAM operations when using AWS commands in Slack\. When you use the **ReadOnly Command Permissions** policy, you allow or deny the following permissions to users who run commands in Slack: 
+ IAM \(Deny All\)
+ AWS KMS \(Deny All\)
+ AWS STS \(Deny All\)
+ Amazon Cognito \(allows Read\-Only, denies `GetSigningCertificate` commands\)
+ Amazon EC2 \(allows Read\-Only, denies `GetPasswordData` commands \)
+ Amazon Elastic Container Registry \(Amazon ECR\) \(allows Read\-Only, denies `GetAuthorizationToken` commands\)
+ GameLift \(allows Read\-Only, denies requests for credentials and `GetInstanceAccess` commands\)
+ Amazon Lightsail \(allows List, Read, denies several key pair operations and `GetInstanceAccess`\)
+ Amazon Redshift \(denies `GetClusterCredentials` commands\)
+ Amazon S3 \(allows Read\-Only commands, denies `GetBucketPolicy` commands\)
+ AWS Storage Gateway \(allows Read\-Only, denies `DescribeChapCredentials` commands\)

The **ReadOnly Command Permissions** policy JSON code is shown following:

```
{
   "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "iam:*",
                "kms:*",
                "sts:*",
                "cognito-idp:GetSigningCertificate",
                "ec2:GetPasswordData",
                "ecr:GetAuthorizationToken",
                "gamelift:RequestUploadCredentials",
                "gamelift:GetInstanceAccess",
                "lightsail:DownloadDefaultKeyPair",
                "lightsail:GetInstanceAccessDetail",
                "lightsail:GetKeyPair",
                "lightsail:GetKeyPairs",
                "redshift:GetClusterCredentials",
                "s3:GetBucketPolicy",
                "storagegateway:DescribeChapCredentials"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

### Using the AWS Chatbot Lambda\-Invoke policy<a name="about-lambda-invoke-chatbot-policy"></a>

The AWS Chatbot **Lambda\-Invoke Command Permissions** policy allows users to invoke AWS Lambda functions in Slack channels\. This policy is an AWS managed policy that is not specific to AWS Chatbot, though it appears in the AWS Chatbot console\.

By default, invoked Lambda functions can perform *any operation*\. You might need to define a more restrictive inline IAM policy that allows permissions to invoke specific Lambda functions, such as functions specifically developed for your DevOps team that only they should be able to invoke, and deny permissions to invoke Lambda functions for any other purpose\.

The **Lambda\-Invoke Command Permissions** policy is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "lambda:invokeAsync",
                "lambda:invokeFunction"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

You can also define resource\-based permissions to allow invoking of Lambda functions only against specific resources, instead of the "\*" wildcard that applies the policy to all resources\. Always follow the IAM practice of granting only the permissions required for your users to do their jobs\.

## Running commands in Slack<a name="Things-to-know-about-cli-in-Slack"></a>

AWS Chatbot tracks your use of command options and prompts you for any missing parameters before it runs the command you want\. 

For example, if you enter `@aws lambda get-function` with no further arguments, the Chatbot requests the function name\. Then, run the `@aws lambda list-functions` command, find the function name you need, and re\-run the first command with the corrected option\. Add more parameters for the initial command with `@aws function-name name`\. AWS Chatbot parses your commands and helps you complete the correct syntax so it can run the complete AWS CLI command\.

### Getting help for AWS services<a name="getting-help-in-the-chat-window"></a>

To get help about commands for any AWS service, enter **@aws** followed by the service name, as shown following: 

`@aws lambda --help`

`@aws cloudwatch describe-alarms --help`

### Formatting data and viewing logs<a name="formatting-in-the-chat-window.title"></a>

To ensure data from Amazon CloudWatch alarms is correctly formatted, attach the **Lambda\-Invoke Command Permissions** and **ReadOnly Commands Permissions** IAM policies to the role in the AWS Chatbot console for users in the Slack channel\. 

Run the `cloudwatch describe-alarms` command to show CloudWatch alarms in chart form as follows: 

`@aws cloudwatch describe-alarms `

You can change the command to only include notifications in the alarm state, filtering out other notifications, by adding the following option:

`@aws cloudwatch describe-alarms --state ALARM`

To see alarms from a different AWS Region, include that Region in the command:

`@aws cloudwatch describe-alarms --state ALARM --region us-east-1`

### Displaying Amazon CloudWatch Logs information<a name="logs-in-the-chat-window.title"></a>

CloudWatch alarm notifications show buttons in Slack notifications to view logs related to the alarm\. These notifications use the [CloudWatch Log Insights feature](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/AnalyzingLogData.html)\. There may be service charges for using this feature to query and show logs\.

You can view CloudWatch logs, including error logs, that are associated with the CloudWatch alarm by choosing **Show logs** at the bottom of the alarm notification in Slack\. AWS Chatbot displays the first 30 log entries from the start of the alarm evaluation period\. AWS Chatbot uses CloudWatch Log Insights to query for logs\. The query results contain a link to the CloudWatch Log Insights console, where a user can dive deeper into logs details\.

Choose **Show error logs** to filter search results to log entries containing Error, Exception, or Fail terms\.

The log shows a command that a user can copy, paste, and edit to re\-run the query for viewing logs in Slack\.

### Creating an AWS Support case<a name="create-a-support-case"></a>

The **AWS Support Command Permissions** policy appears in the AWS Chatbot console when you configure resources\. It's provided in the AWS Chatbot console so that you can set up new roles for users in Slack to create AWS support tickets through their Slack channels\. 

You can quickly create a new AWS support case from Slack by entering the following:

`@aws support create-case`

Follow the prompts from AWS Chatbot to fill out the support case with its needed parameters\. When you complete the case information entry, AWS Chatbot asks for confirmation\. You will not be able to use file attachments\.

For any AWS Chatbot role that creates AWS Support cases, you need to attach the **AWS Support command permissions** policy to the role\. For existing roles, you will need to attach the policy in the IAM console\.

In the IAM console, this policy appears as **AWSSupportAccess**\. 

It is an AWS managed policy\. Attach this policy in IAM to any role for AWS Chatbot usage\. You can define your own policy with greater restrictions, using this policy as a template\.

The **Support Command Permissions** policy applies only to the AWS Support service\.

The policy's JSON code is shown following:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "support:*"
            ],
            "Resource": "*"
        }
    ]
}
```

## Configuring commands support on an existing Slack channel<a name="setting-up-aws-cli-on-slack"></a>

If you have existing Slack channels using the AWS Chatbot, you can reconfigure them in a few steps to support the AWS CLI\.

1. [Open the AWS Chatbot console](https://us-east-2.console.aws.amazon.com/chatbot/home?region=us-east-2#/chat-clients)\.

1. In the **Configured Clients** page, select the **Slack** workspace\. If you have only one workspace, its contents \(the list of Slack channels\) appear on the page\.
**Note**  
In this procedure, we assume use of an existing AWS Chatbot Slack channel configuration\. The process is very similar if you need to create a new Slack configuration by choosing **Configure new client**\.

1. Choose a Slack channel from the **Configured channels** list, and choose **Edit**\. The selected channel can be public or private\.

1. In the **Edit Slack channel** page, define the **IAM permissions** that the chatbot uses for messaging your Slack chat room\.

1. For **IAM role**, choose **Create an IAM role using a template**\.
**Note**  
The first time you reconfigure a Slack channel to work with commands, you must create a new role using the AWS Chatbot policies as templates, or choose an existing role that provides the permissions you need\. 

1. For the **Role name**, enter a new role name using alphanumeric characters\. Valid characters: a\-z, A\-Z, 0\-9, \.\\w\+=,\.@\-\_\.

1. For **Policy templates**, choose the **Read Only command permissions** and **Lambda\-Invoke command permissions** policies for the role\.

   If you plan to have users of the role submit AWS Support cases, also attach the **AWS Support command permissions** policy\.

1. If you want the role to allow users to view CloudWatch alarms in graphical format, add the **Notification Permissions** policy\. It provides the necessary Read and List permissions for CloudWatch alarms, events and logs, and for Amazon SNS topics\.
**Note**  
You do not need to edit or change the Amazon SNS topics configuration for the Slack channel\.

1. Choose **Save**\.

   You can use the IAM console to modify an existing IAM role\. By simply attaching the three additional AWS Chatbot policies to the IAM role, users of that role can immediately begin using commands in the Slack channel\. To do so, see [Configuring an IAM Role for AWS Chatbot](getting-started.md#AWS::Chatbot::Role)\.

**Important**  
If you have a large number of Slack channels and you want to have the same command permissions across multiple channels, you can apply the configured AWS Chatbot role to any of your other Slack channels without further modification\. The IAM policies will be consistent across Slack channels that support commands in your AWS Chatbot service\.

## Enabling multiple accounts to use commands in a Slack channel<a name="multiple-accounts-in-a-channel"></a>

You can configure AWS Chatbot for multiple AWS accounts in the same Slack channel\. When you work with AWS Chatbot for the first time in that channel, it will ask you which account you want to use\. AWS Chatbot will remember the account selection for 7 days\.

To change the default account in the channel, enter `@aws set default-account` and select the account from the list\.