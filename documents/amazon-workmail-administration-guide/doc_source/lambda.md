# Configuring AWS Lambda for Amazon WorkMail<a name="lambda"></a>

Use the **Run Lambda** action in inbound and outbound email flow rules to pass email messages that match the rules to an AWS Lambda function for processing\.

Choose from the following configurations for a **Run Lambda** action in Amazon WorkMail\.

**Synchronous **Run Lambda** configuration**  
Email messages that match the flow rule are passed to a Lambda function for processing before they are sent or delivered\. Use this configuration to control inbound or outbound email flow for use cases such as blocking delivery of sensitive email messages\.

**Asynchronous **Run Lambda** configuration**  
Email messages that match the flow rule are passed to a Lambda function for processing while they are sent or delivered\. This configuration does not affect email delivery and is used for tasks such as collecting metrics for inbound or outbound email messages\.

Whether you choose synchronous or asynchronous configuration, the event object passed to your Lambda function contains metadata for the inbound or outbound email event\. You can also use the message ID in the metadata to access the full content of the email message\. For more information, see [Retrieving message content with AWS Lambda](lambda-content.md)\. For more information about email events, see [Lambda event data](#lambda-data)\.

For more information about inbound and outbound email flow rules, see [Managing email flows](email-flows.md)\. For more information about Lambda, see the [https://docs.aws.amazon.com/lambda/latest/dg/welcome.html](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html)\.

**Note**  
Currently, Lambda email flow rules reference only Lambda functions in the same AWS Region and AWS account as the Amazon WorkMail organization being configured\.

## Getting started with Lambda for Amazon WorkMail<a name="start-lambda"></a>

To start using Lambda with Amazon WorkMail, deploy [the example Lambda function](https://console.aws.amazon.com/lambda/home#/create/app?applicationId=arn:aws:serverlessrepo:us-east-1:489970191081:applications/workmail-hello-world-python) from the AWS Serverless Application Repository to your account\. Permissions for the example Lambda function are already configured for you\.

If you choose to create your own Lambda function to use with Amazon WorkMail, you must configure permissions using the AWS Command Line Interface \(AWS CLI\)\. In the following example command, replace `MY_FUNCTION_NAME` with the name of your Lambda function, and replace `REGION` with your Amazon WorkMail AWS Region\. Available Amazon WorkMail Regions include `us-east-1`, `us-west-2`, and `eu-west-1`\.

```
aws --region REGION lambda add-permission --function-name MY_FUNCTION_NAME --statement-id AllowWorkMail --action "lambda:InvokeFunction" --principal workmail.REGION.amazonaws.com
```

For more information about using the AWS CLI, see the [https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html)\.

## Configuring synchronous **Run Lambda** rules<a name="synchronous-rules"></a>

To configure a synchronous **Run Lambda** rule, create an email flow rule with the **Run Lambda** action and select the **Run synchronously** check box\. For more information about creating mail flow rules, see [Creating an email flow rule](create-email-rules.md)\.

To finish creating the synchronous rule, add the Lambda Amazon Resource Name \(ARN\) and configure the following options\.

****Fallback action****  
The action Amazon WorkMail applies if the Lambda function fails to run\. This action also applies to any recipients that are omitted from the Lambda response if the **allRecipients** flag is not set\. The **Fallback action** cannot be another Lambda action\.

****Rule timeout** \(in minutes\)**  
The time period during which the Lambda function is retried if Amazon WorkMail fails to invoke it\. The **Fallback action** is applied at the end of this time period\.

**Note**  
Synchronous **Run Lambda** rules support the **\*** destination condition only\.

## Lambda event data<a name="lambda-data"></a>

The Lambda function is triggered using the following event data\. The presentation of the data varies depending on which programming language is used for the Lambda function\.

```
{
    "summaryVersion": "2018-10-10",
    "envelope": {
        "mailFrom" : {
            "address" : "from@example.com"
        },
        "recipients" : [
           { "address" : "recipient1@example.com" },
           { "address" : "recipient2@example.com" }
        ]
    },
    "sender" : {
        "address" :  "sender@example.com"
    },
    "subject" : "Hello From Amazon WorkMail!",
    "messageId": "00000000-0000-0000-0000-000000000000",
    "invocationId": "00000000000000000000000000000000",
    "flowDirection": "INBOUND",
    "truncated": false
}
```

The event JSON includes the following data\.

**summaryVersion**  
The version number for **LambdaEventData**\. Only updates when a backwards incompatible change is made in **LambdaEventData**\.

**envelope**  
The envelope of the email message, which includes the following fields\.    
**mailFrom**  
The **From** address, which is usually the email address of the user who sent the email message\. If the user sent the email message as another user or on behalf of another user, the **mailFrom** field returns the email address of the user on whose behalf the email message was sent, not the email address of the actual sender\.  
**recipients**  
A list of recipient email addresses\. There is no distinction between **To**, **CC**, or **BCC**\.  
For inbound email flow rules, this list includes recipients for each domain that is part of the Amazon WorkMail organization in which the rule is created\. The Lambda function is invoked separately for each SMTP conversation from the sender, and the recipients field lists the recipients from that SMTP conversation\. Recipients with external domains are not included\.

**sender**  
The email address of the user who sent the email message on behalf of another user\. This field is set only when an email message is sent on behalf of another user\.

**subject**  
The email subject line\. Truncated when it exceeds the 256 character limit\.

**messageId**  
A unique ID used to access the full content of the email message when using the Amazon WorkMail Message Flow SDK\.

**invocationID**  
The ID for a unique Lambda invocation\. This ID remains the same when a Lambda function is called more than once for the same **LambdaEventData**\. Use to detect retries and avoid duplication\.

**flowDirection**  
Indicates the direction of the email flow, either **INBOUND** or **OUTBOUND**\.

**truncated**  
Applies to the payload size, not the subject line length\. When `true`, the payload size exceeds the 128 KB limit, so the list of recipients is truncated in order to meet the limit\.

## Synchronous **Run Lambda** response schema<a name="synchronous-schema"></a>

When an email flow rule with a synchronous **Run Lambda** action matches an inbound or outbound email message, Amazon WorkMail calls the configured Lambda function and waits for the response before taking action on the email message\. The Lambda function returns a response according to a pre\-defined schema that lists the actions, action types, applicable parameters, and recipients that the action applies to\.

The following schema is an example of a synchronous **Run Lambda** response\. Responses vary based on the programming language used for the Lambda function\.

```
{
      'actions': [                          
      {
        'action' : {                       
          'type': 'string',                 
          'parameters': { various }       
        },
        'recipients': list of strings,      
        'allRecipients': boolean            
      }
    ]
}
```

The response JSON includes the following data\.

**action**  
The action to take for the recipients\.

**type**  
The action type\. Action types are not returned for asynchronous **Run Lambda** actions\.  
Inbound rule action types include **BOUNCE**, **DROP**, **DEFAULT**, **BYPASS\_SPAM\_CHECK**, and **MOVE\_TO\_JUNK**\. For more information, see [Inbound email rule actions](email-flows.md#email-flows-rule-actions)\.  
Outbound rule action types include **BOUNCE**, **DROP**, and **DEFAULT**\. For more information, see [Outbound email rule actions](email-flows.md#email-flows-rule-outbound)\. 

**parameters**  
Additional action parameters\. Supported for the **BOUNCE** action type as a JSON object with the key **bounceMessage** and value **string**\. This bounce message is used to create the bounce email message\.

**recipients**  
List of email addresses on which the action should be taken\. You can add new recipients to the response even if they were not included in the original recipients list\. This field is not required if **allRecipients** is true for an action\.  
When a Lambda action is called for inbound email, you can only add new recipients that are from your organization\. The new recipients are added to the response as **BCC**\.

**allRecipients**  
When true, applies the action to all the recipients that are not subject to another specific action in the Lambda response\.

### Synchronous **Run Lambda** action limits<a name="synchronous-limits"></a>

The following limits apply when Amazon WorkMail invokes Lambda functions for synchronous **Run Lambda** actions: 
+ Lambda functions must respond within 15 seconds, or be treated as failed invocations\.
+ Lambda function responses up to 256 KB are allowed\.
+ Up to 10 unique actions are allowed in the response\. Actions greater than 10 are subject to the configured **Fallback action**\. 
+ Up to 500 recipients are allowed for outbound Lambda functions\.
+ The maximum value for **Rule timeout** is 240 minutes\. If the minimum value of 0 is configured, there are no retries before Amazon WorkMail applies the fallback action\.

### Synchronous **Run Lambda** action failures<a name="synchronous-failures"></a>

If Amazon WorkMail is unable to invoke your Lambda function due to an error, invalid response, or Lambda timeout, Amazon WorkMail retries the invocation with exponential backoff until the **Rule timeout** period completes\. Then, the **Fallback action** is applied to all recipients of the email message\. For more information, see [Configuring synchronous **Run Lambda** rules](#synchronous-rules)\.

## Example synchronous **Run Lambda** responses<a name="synchronous-responses"></a>

The following examples demonstrate the structure of common synchronous **Run Lambda** responses\.

**Example : Remove specified recipients from an email message**  
The following example demonstrates the structure of a synchronous **Run Lambda** response for removing recipients from an email message\.  

```
{
    'actions': [{
      'action' : {'type': 'DEFAULT'},
      'allRecipients': True
    },
    {
      'action' : {'type': 'DROP'},
      'recipients' : ['drop-recipient@example.com']
    }]
}
```

**Example : Bounce with a custom email message**  
The following example demonstrates the structure of a synchronous **Run Lambda** response for bouncing with a custom email message\.  

```
{
      'actions' : [{
        'action' : {
          'type' : 'BOUNCE',
          'parameters' : {
            'bounceMessage' : 'Email in breach of company policy.'
          }
        },
        'allRecipients': True
      }]
}
```

**Example : Add recipients to an email message**  
The following example demonstrates the structure of a synchronous **Run Lambda** response for adding recipients to the email message\. This does not update the **To** or **CC** fields of the email message\.  

```
{
      'actions': [{
        'action' : { 'type' : 'DEFAULT' },
        'recipients' : [
          'new-recipient@example.com'
         ]
      },
      {
        'action' : { 'type' : 'DEFAULT' },
        'allRecipients' : True
      }]
}
```

For more code examples to use when creating Lambda functions for **Run Lambda** actions, see [Amazon WorkMail Lambda templates](https://github.com/aws-samples/amazon-workmail-lambda-templates)\.

## More information about using Lambda with Amazon WorkMail<a name="lambda-more"></a>

You can also access the full content of the email message that triggers the Lambda function\. For more information, see [Retrieving message content with AWS Lambda](lambda-content.md)\. 