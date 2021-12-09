# Setting up AWS IoT Events<a name="iotevents-start"></a>

If you do not have an AWS account, complete the following steps to create one\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

## Setting up permissions for AWS IoT Events<a name="iotevents-permissions"></a>

This section describes the roles and permissions that are required to use some features of AWS IoT Events\. You can use AWS CLI commands or the AWS Identity and Access Management \(IAM\) console to create roles and associated permission policies to access resources or perform certain functions in AWS IoT Events\. 

The [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/) has more detailed information about securely controlling permissions to access AWS resources\. For information specific to AWS IoT Events, see [Actions, resources, and condition keys for AWS IoT Events](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotevents.html)\.

### Action permissions<a name="iotevents-permissions-event-actions"></a>

AWS IoT Events enables you to trigger actions which use other AWS services\. To do so, you must grant AWS IoT Events permission to perform these actions on your behalf\. This section contains a list of the actions and an example policy which grants permission to perform all these actions on your resources\. Change the *region* and *account\-id* references as required\. When possible, you should also change the wildcards \(\*\) to refer to specific resources that will be accessed\. You can use the IAM console to grant permission to AWS IoT Events to send an Amazon SNS alert that you have defined\. For more information, see [ Using the IAM console to manage roles and permissions](#iotevents-permissions-console)\.

<a name="build-in-actions-intro"></a>AWS IoT Events supports the following actions that let you use a timer or set a variable:<a name="build-in-actions"></a>
+ [`setTimer`](built-in-actions.md#iotevents-set-timer) to create a timer\.
+ [`resetTimer`](built-in-actions.md#iotevents-reset-timer) to reset the timer\.
+ [`clearTimer`](built-in-actions.md#iotevents-clear-timer) to delete the timer\.
+ [`setVariable`](built-in-actions.md#iotevents-set-variable) to create a variable\.

<a name="work-with-aws-services-intro"></a>AWS IoT Events supports the following actions that let you work with AWS services: <a name="work-with-aws-services"></a>
+ [`iotTopicPublish`](iotevents-other-aws-services.md#iotevents-iotcore) to publish a message on an MQTT topic\.
+ [`iotEvents`](iotevents-other-aws-services.md#iotevents-iteinput) to send data to AWS IoT Events as an input value\.
+ [`iotSiteWise`](iotevents-other-aws-services.md#iotevents-iotsitewise) to send data to an asset property in AWS IoT SiteWise\.
+ [`dynamoDB`](iotevents-other-aws-services.md#iotevents-dynamodb) to send data to an Amazon DynamoDB table\.
+ [`dynamoDBv2`](iotevents-other-aws-services.md#iotevents-dynamodbv2) to send data to an Amazon DynamoDB table\.
+ [`firehose`](iotevents-other-aws-services.md#iotevents-firehose) to send data to an Amazon Kinesis Data Firehose stream\.
+ [`lambda`](iotevents-other-aws-services.md#iotevents-lambda) to invoke an AWS Lambda function\.
+ [`sns`](iotevents-other-aws-services.md#iotevents-sns) to send data as a push notification\.
+ [`sqs`](iotevents-other-aws-services.md#iotevents-sqs) to send data to an Amazon SQS queue\.

**Example Policy**  

```
{
   "Version": "2012-10-17",
   "Statement": [
     {
       "Effect": "Allow",
       "Action": "iot:Publish",
       "Resource": "arn:aws:iot:<region>:<account_id>:topic/*"
     },
     {
       "Effect": "Allow",
       "Action": "iotevents:BatchPutMessage",
       "Resource": "arn:aws:iotevents:<region>:<account_id>:input/*"
     },
     {
       "Effect": "Allow",
       "Action": "iotsitewise:BatchPutAssetPropertyValue",
       "Resource": "*"
     },
     {
       "Effect": "Allow",
       "Action": "dynamodb:PutItem",
       "Resource": "arn:aws:dynamodb:<region>:<account_id>:table/*"
     },
     {
       "Effect": "Allow",
       "Action": [
         "firehose:PutRecord",
         "firehose:PutRecordBatch"
       ],
       "Resource": "arn:aws:firehose:<region>:<account_id>:deliverystream/*"
     },
     {
       "Effect": "Allow",
       "Action": "lambda:InvokeFunction",
       "Resource": "arn:aws:lambda:<region>:<account_id>:function:*"
     },
     {
       "Effect": "Allow",
       "Action": "sns:Publish",
       "Resource": "arn:aws:sns:<region>:<account_id>:*"
     },
     {
       "Effect": "Allow",
       "Action": "sqs:SendMessage",
       "Resource": "arn:aws:sqs:<region>:<account_id>:*"
     }
   ]
}
```

### Securing input data<a name="iotevents-permissions-input-data"></a>

It's important to consider who can grant access to input data for use in a detector model\. If you have a user or entity whose overall permissions you want to restrict, but that is permitted to create or update a detector model, you must also grant permission for that user or entity to update input routing\. This means that in addition to granting permission for `iotevents:CreateDetectorModel` and `iotevents:UpdateDetectorModel`, you must also grant permission for `iotevents:UpdateInputRouting`\.

**Example**  
The following policy adds permission for `iotevents:UpdateInputRouting`\.  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "updateRoutingPolicy",
            "Effect": "Allow",
            "Action": [
                "iotevents:UpdateInputRouting"
            ],
            "Resource": "*"
        }
    ]
}
```

You can specify a list of input Amazon Resource Names \(ARNs\) instead of the wildcard "`*`" for the "`Resource`" to limit this permission to specific inputs\. This enables you to restrict access to the input data that is consumed by detector models created or updated by the user or entity\.

### Using the IAM console to manage roles and permissions<a name="iotevents-permissions-console"></a>

The following example shows how to use the IAM console to grant permission to AWS IoT Events to generate Amazon SNS alerts on your behalf\. You can also attach the role to any entity \(user or account owner\) that you will use to define and publish an AWS IoT Events detector model that contains event actions that send Amazon SNS alerts\.

To complete this example, you need the ARN of an existing [Amazon SNS topic](https://docs.aws.amazon.com/sns/latest/dg/welcome.html) to use in AWS IoT Events\.

**To use the IAM console to manage roles and permissions**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Dashboard**, **Roles**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/welcome-iam.png)

1. Choose **Create role**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-role.png)

1. On the **Create role** page, do the following\.

   1. For **Select type of trusted entity**, choose **AWS service**\.

   1. For **Choose the service that will use this role**, choose **IoT**\.

   1. For **Select your use case**, choose **IoT** and choose **Next: Permissions**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/choose-service-1.png)  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/choose-service-2.png)

1. On the **Create role** page, for **Attached permissions**, leave these permissions as they are for now and choose **Next: Tags**\.

   You add a new policy granting the required permissions in a later step\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/next-tags.png)

1. On the **Create role** page, for **Add tags \(optional\)**, don't add tags now and choose **Next:Review**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/next-review.png)

1. On the **Review** page, enter a **Role name**, an optional **Role description**, and choose **Create role**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-role-final.png)

1. On the **Roles** page, find and select the name of the role that you created\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/select-role.png)

1. On the **Summary** page for your role, on the **Permissions** tab, choose **Attach policies**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/attach-policies.png)

1. On the **Attach Permissions** page, choose **Create policy**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-policy.png)

1. On the **Create Policy** page, select the **JSON** tab\. If a policy validation failure warning appears, choose the **X** icon to dismiss it\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-policy-json.png)

1. On the **JSON** tab, do the following\.

   1. Replace the JSON in the editor with the following example\.

   1. Change the `Resource` value to the ARN of the [Amazon SNS topic](https://docs.aws.amazon.com/sns/latest/dg/welcome.html) that to use in AWS IoT Events\.

   1. Choose **Review policy**\. You can also use wildcard characters in the Amazon SNS topic ARN to grant broader permissions, but be aware of the security issues this raises\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Action": [
                   "sns:*"
               ],
               "Effect": "Allow",
               "Resource": "arn:aws:sns:us-east-1:123456789012:testAction"
           }
       ]
   }
   ```

   Your policy should look like the following\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/review-policy.png)

1. On the **Review policy** page, enter a **Name** for the policy, an optional **Description**, and choose **Create policy**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/review-policy-name.png)

1. On the **Policies** page, in the navigation pane, choose **Roles**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/from-policy-to-role.png)

1. On the **Roles** page, find and select the name of the role that you created\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/select-role-again.png)

1. On the **Summary** page for your role, on the **Permissions** tab, choose **Attach policies**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/attach-policies.png)

1. On the **Attach permissions** page for your role, select the check box next to the policy that you created, and choose **Attach policy**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/add-permissions.png)

1. On the **Roles** page, find and select the name of the role that you created\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/select-role-again.png)

1. On the **Summary** page for that role, on the **Trust relationships** tab, choose **Edit trust relationship**\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/edit-trust.png)

1. On the **Edit Trust Relationship** page, for **Policy Document**, replace the existing JSON with the following and choose **Update Trust Policy**\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Sid": "",
         "Effect": "Allow",
         "Principal": {
           "Service": "iotevents.amazonaws.com" 
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

   Your policy should look like the following\.  
![\[Set up an AWS IoT Events service role in the IAM console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/update-trust.png)

You have now granted AWS IoT Events permission to send alerts to your Amazon SNS topic on your behalf\. For enhanced security, remove the unused policies that were attached by default to the role that you created\.

### Amazon CloudWatch logging role policy<a name="iotevents-permissions-cloudwatch"></a>

The following policy documents provide the role policy and trust policy that allow AWS IoT Events to submit logs to CloudWatch on your behalf\.

Role policy:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "logs:CreateLogGroup",
                "logs:CreateLogStream",
                "logs:PutLogEvents",
                "logs:PutMetricFilter",
                "logs:PutRetentionPolicy",
                "logs:GetLogEvents",
                "logs:DeleteLogStream"
            ],
            "Resource": [
                "arn:aws:logs:*:*:*"
            ]
        }
    ]
}
```

Trust policy:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": [
          
          "iotevents.amazonaws.com"
        ]
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
```

You also need an IAM permissions policy attached to the IAM user that allows the user to pass roles, as follows\. For more information, see [ Granting a user permissions to pass a role to an AWS service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_passrole.html) in the *IAM User Guide*\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Action": [
          "iam:GetRole",
          "iam:PassRole"
      ],
      "Resource": "arn:aws:iam::<account-id>:role/Role_To_Pass"
    }
  ]
}
```

You can use the following command to put the resource policy for CloudWatch logs\. This allows AWS IoT Events to put log events into CloudWatch streams\.

```
aws logs put-resource-policy --policy-name ioteventsLoggingPolicy --policy-document "{ \"Version\": \"2012-10-17\", \"Statement\": [ { \"Sid\": \"IoTEventsToCloudWatchLogs\", \"Effect\": \"Allow\", \"Principal\": { \"Service\": [ \"iotevents.amazonaws.com\" ] }, \"Action\":\"logs:PutLogEvents\", \"Resource\": \"*\" } ] }" 
```

Use the following command to put logging options\. Replace the `roleArn` with the logging role that you created\.

```
aws iotevents put-logging-options --cli-input-json "{ \"loggingOptions\": {\"roleArn\": \"arn:aws:iam::123456789012:role/testLoggingRole\", \"level\": \"INFO\", \"enabled\": true } }" 
```

### Amazon SNS messaging role policy<a name="iotevents-permissions-sns"></a>

The following policy documents provide the role policy and trust policy that allow AWS IoT Events to send SNS messages\.

Role policy:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "sns:*"
            ],
            "Effect": "Allow",
            "Resource": "arn:aws:sns:us-east-1:123456789012:testAction"
        }
    ]
}
```

Trust policy:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": [
          "iotevents.amazonaws.com"
        ]
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
```