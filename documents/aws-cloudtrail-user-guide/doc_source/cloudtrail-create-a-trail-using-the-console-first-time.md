# Creating a Trail<a name="cloudtrail-create-a-trail-using-the-console-first-time"></a>

Follow the procedure to create a trail that applies to all Regions\. A trail that applies to all Regions delivers log files from all Regions to an S3 bucket\. After you create the trail, CloudTrail automatically starts logging the events that you specified\. 

**Note**  
After you create a trail, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see [CloudTrail Supported Services and Integrations](cloudtrail-aws-service-specific-topics.md)\.

**Contents**
+ [Creating a Trail in the Console](#creating-a-trail-in-the-console)
+ [Configuring Advanced Settings for Your Trail](#advanced-settings-for-your-trail)
+ [Next Steps](#cloudtrail-create-a-trail-using-the-console-first-time-next-steps)

## Creating a Trail in the Console<a name="creating-a-trail-in-the-console"></a>

 You can configure your trail for the following: 
+ Specify if you want the trail to apply to all Regions or a single Region\.
+ Specify an Amazon S3 bucket to receive log files\.
+ For management and data events, specify if you want to log read\-only, write\-only, or all events\.

**To create a CloudTrail trail with the AWS Management Console**

1. Sign in to the AWS Management Console and open the CloudTrail console at [https://console\.aws\.amazon\.com/cloudtrail/](https://console.aws.amazon.com/cloudtrail/)\.

1. Choose the AWS Region where you want the trail to be created\.

1. Choose **Get Started Now**\.
**Tip**  
If you do not see **Get Started Now**, choose **Trails**, and then choose **Create trail**\.

1. On the **Create Trail** page, for **Trail name**, type a name for your trail\. For more information, see [CloudTrail Trail Naming Requirements](cloudtrail-trail-naming-requirements.md)\.

1. For **Apply trail to all regions**, choose **Yes** to receive log files from all Regions\. This is the default and recommended setting\. If you choose **No**, the trail logs files only from the Region in which you create the trail\.

1. For **Management events**, do the following\.

   1. For **Read/Write events**, choose if you want your trail to log **All**, **Read\-only**, **Write\-only**, or **None**, and then choose **Save**\. By default, trails log all management events\. For more information, see [Management Events](logging-management-events-with-cloudtrail.md#logging-management-events)\.

   1. For **Log AWS KMS events**, choose **Yes** to log AWS Key Management Service \(AWS KMS\) events in your trail\. Choose **No** to filter AWS KMS events out of your trail\. The default setting is **Yes**\.

1. In **Insights events**, for **Log Insights events**, choose **Yes** if you want your trail to log Insights events\. By default, trails don't log Insights events\. For more information about Insights events, see [Logging Insights Events for Trails](logging-insights-events-with-cloudtrail.md)\. Additional charges apply for logging Insights events\. For CloudTrail pricing, see [AWS CloudTrail Pricing](https://aws.amazon.com/cloudtrail/pricing/)\.

   Insights events are delivered to a different folder named `/CloudTrail-Insight`of the same S3 bucket that is specified in the **Storage location** area of the trail details page\. CloudTrail creates the new prefix for you\. For example, if your current destination S3 bucket is named `S3bucketName/AWSLogs/CloudTrail/`, the S3 bucket name with a new prefix is named `S3bucketName/AWSLogs/CloudTrail-Insight/`\.

1. For **Data events**, you can specify logging data events for Amazon S3 buckets, for AWS Lambda functions, or both\. By default, trails don't log data events\. Additional charges apply for logging data events\. For CloudTrail pricing, see [AWS CloudTrail Pricing](https://aws.amazon.com/cloudtrail/pricing/)\.

   You can select the option to log all S3 buckets and Lambda functions, or you can specify individual buckets or functions\. 

   For Amazon S3 buckets:
   + Choose the **S3** tab\.
   + To specify a bucket, choose **Add S3 bucket**\. Type the S3 bucket name and prefix \(optional\) for which you want to log data events\. For each bucket, specify whether you want to log **Read** events, such as `GetObject`, **Write** events, such as `PutObject`, or both\. For more information, see [Data Events](logging-data-events-with-cloudtrail.md#logging-data-events)\.
   + To log data events for all S3 buckets in your AWS account, select **Select all S3 buckets in your account**\. Then choose whether you want to log **Read** events, such as `GetObject`, **Write** events, such as `PutObject`, or both\. This setting takes precedence over individual settings you configure for individual buckets\. For example, if you specify logging **Read** events for all S3 buckets, and then choose to add a specific bucket for data event logging, **Read** is already selected for the bucket you added\. You cannot clear the selection\. You can only configure the option for **Write**\. 
**Note**  
Selecting the **Select all S3 buckets in your account** option enables data event logging for all buckets currently in your AWS account and any buckets you create after you finish creating the trail\. It also enables logging of data event activity performed by any user or role in your AWS account, even if that activity is performed on a bucket that belongs to another AWS account\.  
If the trail applies only to one Region, selecting the **Select all S3 buckets in your account** option enables data event logging for all buckets in the same Region as your trail and any buckets you create later in that Region\. It will not log data events for Amazon S3 buckets in other Regions in your AWS account\.

   For Lambda functions:
   + Choose the **Lambda** tab\.
   + To specify logging individual functions, select them from the list\. 
**Note**  
If you have more than 15,000 Lambda functions in your account, you cannot view or select all functions in the CloudTrail console when creating a trail\. You can still select the option to log all functions, even if they are not displayed\. If you want to log data events for specific functions, you can manually add a function if you know its ARN\. You can also finish creating the trail in the console, and then use the AWS CLI and the put\-event\-selectors command to configure data event logging for specific Lambda functions\. For more information, see [Managing Trails With the AWS CLI](cloudtrail-additional-cli-commands.md)\.
   + To log data events for all Lambda functions in your AWS account, select **Log all current and future functions**\. This setting takes precedence over individual settings you configure for individual functions\. All functions are logged, even if all functions are not displayed\.
**Note**  
If you are creating a trail for all Regions, this selection enables data event logging for all functions currently in your AWS account, and any Lambda functions you might create in any Region after you finish creating the trail\. If you are creating a trail for a single Region, this selection enables data event logging for all functions currently in that Region in your AWS account, and any Lambda functions you might create in that Region after you finish creating the trail\. It does not enable data event logging for Lambda functions created in other Regions\.  
Logging data events for all functions also enables logging of data event activity performed by any user or role in your AWS account, even if that activity is performed on a function that belongs to another AWS account\.

1. For **Storage location**, for **Create a new S3 bucket**, choose **Yes** to create a bucket\. When you create a bucket, CloudTrail creates and applies the required bucket policies\.
**Note**  
If you chose **No**, choose an existing S3 bucket\. The bucket policy must grant CloudTrail permission to write to it\. For information about manually editing the bucket policy, see [Amazon S3 Bucket Policy for CloudTrail](create-s3-bucket-policy-for-cloudtrail.md)\.

1. For **S3 bucket**, type a name for the bucket you want to designate for log file storage\. The name must be globally unique\. For more information, see [Amazon S3 Bucket Naming Requirements](cloudtrail-s3-bucket-naming-requirements.md)\.

1. For **Tags**, add one or more custom tags \(key\-value pairs\) to your trail\. Tags can help you identify both your CloudTrail trails and the Amazon S3 buckets that contain CloudTrail log files\. You can then use resource groups for your CloudTrail resources\. For more information, see [AWS Resource Groups](https://docs.aws.amazon.com/ARG/latest/userguide/welcome.html) and [Why Use Tags For Trails?](cloudtrail-concepts.md#cloudtrail-concepts-tags)\.

1. To configure advanced settings, see [Configuring Advanced Settings for Your Trail](#advanced-settings-for-your-trail)\. Otherwise, choose **Create**\.

1. The new trail appears on the **Trails** page\. The **Trails** page shows the trails in your account from all Regions\. In about 15 minutes, CloudTrail publishes log files that show the AWS API calls made in your account\. You can see the log files in the S3 bucket that you specified\. It can take up to 36 hours for CloudTrail to deliver the first Insights event, if you have enabled Insights event logging, and unusual activity is detected\.

**Note**  
You can't rename a trail after it has been created\. Instead, you can delete the trail and create a new one\.

## Configuring Advanced Settings for Your Trail<a name="advanced-settings-for-your-trail"></a>

You can configure the following settings for your trail:
+ Specify a log file prefix for the S3 bucket receiving log files\.
+ Encrypt log files with AWS Key Management Service \(SSE\-KMS\) instead of the default encryption \([Amazon S3\-managed encryption keys \(SSE\-S3\)\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html)\.
+ Enable log file validation for logs\.
+ Configure Amazon SNS to notify you when log files are delivered\.

**To configure advanced settings for your trail**

1. For **Storage location**, choose **Advanced**\.

1. In the **Log file prefix** field, type a prefix for your Amazon S3 bucket\. The prefix is an addition to the URL for an Amazon S3 object that creates a folder\-like organization in your bucket\. The location where your log files will be stored appears under the text field\.

1. For **Encrypt log files with SSE\-KMS**, choose **Yes** if you want to encrypt your log files with SSE\-KMS instead of SSE\-S3\.

1. For **Create a new KMS key**, choose **Yes** to create an AWS KMS customer master key or **No** to use an existing one\.

1. If you chose **Yes**, in the **KMS key** field, type an alias\. CloudTrail encrypts your log files with the field, type an alias\. CloudTrail encrypts your log files with the customer master key and adds the policy for you\.
**Note**  
If you chose **No**, choose an existing AWS KMS customer master key\. You can also type the ARN of a key from another account\. For more information, see [Updating a Trail to Use Your CMK](create-kms-key-policy-for-cloudtrail-update-trail.md)\. The key policy must allow CloudTrail to use the key to encrypt your log files, and allow the users you specify to read log files in unencrypted form\. For information about manually editing the key policy, see [Configure AWS KMS Key Policies for CloudTrail](create-kms-key-policy-for-cloudtrail.md)\.

1. For **Enable log file validation**, choose **Yes** to have log digests delivered to your S3 bucket\. You can use the digest files to verify that your log files did not change after CloudTrail delivered them\. For more information, see [Validating CloudTrail Log File Integrity](cloudtrail-log-file-validation-intro.md)\. 

1. For **Send SNS notification for every log file delivery**, choose **Yes** if you want to be notified each time a log is delivered to your bucket\. CloudTrail stores multiple events in a log file\. SNS notifications are sent for every log file, not for every event\. 

1. For **Create a new SNS topic**, choose **Yes** to create a topic, or choose **No** to use an existing topic\. If you are creating a trail that applies to all Regions, SNS notifications for log file deliveries from all Regions are sent to the single SNS topic that you create\.
**Note**  
If you chose **No**, choose an existing topic\. You can also enter the ARN of a topic from another Region or from an account with appropriate permissions\. For more information, see [Amazon SNS Topic Policy for CloudTrail](cloudtrail-permissions-for-sns-notifications.md)\.

1. If you chose **Yes**, in the **SNS topic** field, type a name\.

   If you create a topic, you must subscribe to the topic to be notified of log file delivery\. You can subscribe from the Amazon SNS console\. Due to the frequency of notifications, we recommend that you configure the subscription to use an Amazon SQS queue to handle notifications programmatically\. For more information, see the [Amazon Simple Notification Service Getting Started Guide](https://docs.aws.amazon.com/sns/latest/gsg/)\.

1. Choose **Create**\.

## Next Steps<a name="cloudtrail-create-a-trail-using-the-console-first-time-next-steps"></a>

After you create your trail, you can return to the trail to make changes:
+ Configure CloudTrail to send log files to CloudWatch Logs\. For more information, see [Sending Events to CloudWatch Logs](send-cloudtrail-events-to-cloudwatch-logs.md)\.
+ Create a table and use it to run a query in Amazon Athena to analyze your AWS service activity\. For more information, see [Creating a Table for CloudTrail Logs in the CloudTrail Console](https://docs.aws.amazon.com/athena/latest/ug/cloudtrail-logs.html#create-cloudtrail-table-ct) in the [Amazon Athena User Guide](https://docs.aws.amazon.com/athena/latest/ug/)\.
+ Add custom tags \(key\-value pairs\) to the trail\.
+ To create another trail, return to the **Trails** page and choose **Add new trail**\.

**Note**  
When configuring a trail, you can choose an S3 bucket and SNS topic that belong to another account\. However, if you want CloudTrail to deliver events to a CloudWatch Logs log group, you must choose a log group that exists in your current account\.