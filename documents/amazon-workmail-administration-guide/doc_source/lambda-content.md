# Retrieving message content with AWS Lambda<a name="lambda-content"></a>

After you configure an AWS Lambda function to manage email flows for Amazon WorkMail, you can access the full content of the email messages that are processed using Lambda\. For more information about getting started with Lambda for Amazon WorkMail, see [Configuring AWS Lambda for Amazon WorkMail](lambda.md)\.

To access the full content of email messages, use the `GetRawMessageContent` action in the Amazon WorkMail Message Flow API\. The email message ID that is passed to your Lambda function upon invocation sends a request to the API\. Then, the API responds with the full MIME content of the email message\. For more information, see [Amazon WorkMail Message Flow](https://docs.aws.amazon.com/workmail/latest/APIReference/API_Operations_Amazon_WorkMail_Message_Flow.html) in the *Amazon WorkMail API Reference*\.

The following example shows how a Lambda function using the Python runtime environment can retrieve the full message content\.

```
import boto3
import email

def email_handler(event, context):
    workmail = boto3.client('workmailmessageflow', region_name=os.environ["AWS_REGION"])
    msg_id = event['messageId']
    raw_msg = workmail.get_raw_message_content(messageId=msg_id)

    parsed_msg = email.message_from_bytes(raw_msg['messageContent'].read())
    print(parsed_msg)
```

For more detailed examples of ways to analyze the content of messages that are in transit, see the [amazon\-workmail\-lambda\-templates](https://github.com/aws-samples/amazon-workmail-lambda-templates) repository on GitHub\.

**Note**  
The Amazon WorkMail Message Flow API can be used to access email messages that are in transit only\. The messages can only be accessed within 24 hours of being sent or received\. To programmatically access messages that are already delivered to a user’s mailbox, use one of the other protocols supported by Amazon WorkMail, such as IMAP or Exchange Web Services \(EWS\)\.

## Managing access to the Amazon WorkMail Message Flow API<a name="lambda-content-access"></a>

Use AWS Identity and Access Management \(IAM\) policies to manage access to the Amazon WorkMail Message Flow API\.

The Amazon WorkMail Message Flow API works with a single resource type, an email message in transit\. Each email message in transit has a unique Amazon Resource Name \(ARN\) associated with it\.

The following example shows the syntax of an ARN associated with an email message in transit\.

```
arn:aws:workmailmessageflow:region:account:message/organization/context/messageID
```

Changeable fields in the preceding example include the following:
+ **Region** – The AWS Region for your Amazon WorkMail organization\.
+ **Account** – The AWS account ID for your Amazon WorkMail organization\.
+ **Organization** – Your Amazon WorkMail organization ID\.
+ **Context** – Indicates whether the message is `incoming` to your organization, or `outgoing` from it\.
+ **Message ID** – The unique email message ID that is passed as input to your Lambda function\.

The following example includes example IDs for an ARN associated with an incoming email message in transit\.

```
arn:aws:workmailmessageflow:us-east-1:111122223333:message/m-n1pq2345678r901st2u3vx45x6789yza/incoming/d1234567-8e90-1f23-456g-hjk7lmnop8q9
```

You can use these ARNs as resources in the `Resource` section of your IAM user policies in order to manage access to Amazon WorkMail messages in transit\. For more information about granting IAM users permissions for Amazon WorkMail, see [Create AWS Identity and Access Management users and groups](prereqs.md#iam_users_groups)\.

## Example IAM policies for Amazon WorkMail message flow access<a name="lambda-content-policies"></a>

The following example policy grants an IAM entity full read access to all inbound and outbound messages for every Amazon WorkMail organization in your AWS account\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "workmailmessageflow:GetRawMessageContent"
            ],
            "Resource": "arn:aws:workmailmessageflow:region:account:message/*",
            "Effect": "Allow"
        }
    ]
}
```

If you have multiple organizations in your AWS account, you can also limit access to one or more organizations\. This is useful if certain Lambda functions should only be used for certain organizations\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "workmailmessageflow:GetRawMessageContent"
            ],
            "Resource": "arn:aws:workmailmessageflow:region:account:message/organization/*",
            "Effect": "Allow"
        }
    ]
}
```

You can also choose to grant access to messages depending on whether they are `incoming` to your organization, or `outgoing` from it\. To do this, use the qualifier `incoming` or `outgoing` in the ARN\. 

The following example policy grants access only to messages that are incoming to your organization\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "workmailmessageflow:GetRawMessageContent"
            ],
            "Resource": "arn:aws:workmailmessageflow:region:account:message/organization/incoming/*",
            "Effect": "Allow"
        }
    ]
}
```