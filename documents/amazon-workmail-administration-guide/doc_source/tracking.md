# Tracking messages<a name="tracking"></a>

Turn on email event logging in the Amazon WorkMail console to track email messages for your organization\. Email event logging uses an AWS Identity and Access Management service\-linked role to grant permissions to publish the email event logs to Amazon CloudWatch\. For more information about IAM service\-linked roles, see [Using service\-linked roles for Amazon WorkMail](using-service-linked-roles.md)\.

In the CloudWatch event logs, you can use CloudWatch search tools and metrics to track messages and troubleshoot email issues\. For more information about the event logs that Amazon WorkMail sends to CloudWatch, see [CloudWatch event logs for Amazon WorkMail](monitoring-workmail-cloudwatch.md#cw-events)\. For more information about CloudWatch Logs, see the [Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/)\.

## Turning on email event logging<a name="enable-tracking"></a>

When you turn on email event logging using the default settings, Amazon WorkMail:
+ Creates an AWS Identity and Access Management service\-linked role – `AmazonWorkMailEvents`\.
+ Creates a CloudWatch log group – `/aws/workmail/emailevents/organization-alias`\.
+ Sets CloudWatch log retention to 30 days\.

**To turn on email event logging**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Organization settings**, **Monitoring**\.

1. For **Log settings**, choose **Edit**\.

1. For **Log Events**, select **Enable mail events**\.

1. Do one of the following:

   1. \(Recommended\) Select **Use default settings**\.

   1. \(Optional\) Clear the check box for **Use default settings**, and select a **Destination Log Group** and **IAM Role**\.
**Note**  
Choose this option only if you have already created a log group and custom IAM role using the AWS CLI\. For more information, see [Creating a custom log group and IAM role for email event logging](#custom-tracking-role)\.

1. Select **I authorize Amazon WorkMail to publish logs in my account using this configuration**\.

1. Choose **Save**\.

## Creating a custom log group and IAM role for email event logging<a name="custom-tracking-role"></a>

We recommend using the default settings when enabling email event logging for Amazon WorkMail\. If you require a custom monitoring configuration, you can use the AWS CLI to create a dedicated log group and custom IAM role for email event logging\.

**To create a custom log group and IAM role for email event logging**

1. Using the AWS CLI, create a log group in the same AWS Region as your Amazon WorkMail organization\. For more information, see [create\-log\-group](https://docs.aws.amazon.com/cli/latest/reference/logs/create-log-group.html) in the *AWS CLI Command Reference*\.

   ```
   aws –-region us-east-1 logs create-log-group --log-group-name workmail-monitoring
   ```

1. Create a file containing the following policy:

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "events.workmail.amazonaws.com"
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

1. Using the AWS CLI, create an IAM role and attach this file as the role policy document\. For more information, see [create\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/create-role.html) in the *AWS CLI Command Reference*\.

   ```
   aws iam create-role --role-name workmail-monitoring-role --assume-role-policy-document file://trustpolicyforworkmail.json
   ```
**Note**  
If you are a `WorkMailFullAccess` managed policy user, you must include the term `workmail` in the role name\. This managed policy only allows you to configure email event logging using roles with `workmail` in the name\. For more information, see [Granting a user permissions to pass a role to an AWS service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_passrole.html) in the *IAM User Guide*\.

1. Create a file containing the policy for the IAM role you created in the previous step\. At minimum, the policy must grant permissions to the role to create log streams and put log events into the log group that you created in step 1\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "logs:CreateLogStream",
                   "logs:PutLogEvents"
               ],
               "Resource": "arn:aws:logs:us-east-1:111122223333:log-group:workmail-monitoring*"
           }
       ]
   }
   ```

1. Using the AWS CLI, attach the policy file to the IAM role\. For more information, see [put\-role\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/put-role-policy.html) in the *AWS CLI Command Reference*\.

   ```
   aws iam put-role-policy --role-name workmail-monitoring-role --policy-name workmail-permissions --policy-document file://rolepolicy.json
   ```

Follow the steps in the previous topic to turn on email event logging using the newly created log group and role\. For more information, see [Turning on email event logging](#enable-tracking)\.

## Turning off email event logging<a name="turn-off-tracking"></a>

Turn off email event logging from the Amazon WorkMail console\. If you no longer need to use email event logging, we recommend that you delete the related CloudWatch log group and service\-linked role as well\. For more information, see [Deleting a service\-linked role for Amazon WorkMail](using-service-linked-roles.md#delete-slr)\.

**To turn off email event logging**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Organization settings**, **Monitoring**\.

1. For **Log settings**, choose **Edit**\.

1. Clear the check box for **Enable mail events**\.

1. Choose **Save**\.