# Lambda action<a name="receiving-email-action-lambda"></a>

The Lambda action calls your code through a Lambda function and, optionally, notifies you through Amazon SNS\. This action has the following options\.
+ **Lambda function—**The ARN of the Lambda function\. An example of a Lambda function ARN is *arn:aws:lambda:us\-west\-2:account\-id:function:MyFunction*\. For information about AWS Lambda, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html)\.
+ **Invocation type—**The invocation type of the Lambda function\. An invocation type of **RequestResponse** means that the execution of the function will immediately result in a response, and a value of **Event** means that the function will be invoked asynchronously\. We recommend that you use **Event** invocation type unless synchronous execution is absolutely necessary for your use case\.
**Note**  
There is a 30\-second timeout on **RequestResponse** invocations\.

  For information about AWS Lambda invocation types, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/API_Invoke.html)\.
+ **SNS Topic—**The name or ARN of the Amazon SNS topic to notify when the specified Lambda function is triggered\. An example of an Amazon SNS topic ARN is *arn:aws:sns:us\-west\-2:123456789012:MyTopic*\. You can also create an Amazon SNS topic when you set up your action by choosing **Create SNS Topic**\. For more information about Amazon SNS topics, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/CreateTopic.html)\.
**Note**  
The Amazon SNS topic you choose must be in the same AWS region as the Amazon SES endpoint you use to receive email\. 

## Writing your Lambda function<a name="receiving-email-action-lambda-function"></a>

To process your email, your Lambda function can be invoked asynchronously \(that is, using the `Event` invocation type\)\. The event object passed to your Lambda function will contain metadata pertaining to the inbound email event\. You can also use the metadata to access the message content from your Amazon S3 bucket\.

If you want to actually control the mail flow, your Lambda function must be invoked synchronously \(that is, using the `RequestResponse` invocation type\) and your Lambda function must call the `callback` method with two arguments: the first argument is `null`, and the second argument is a `disposition` property that is set to either `STOP_RULE`, `STOP_RULE_SET`, or `CONTINUE`\. If the second argument is `null` or does not have a valid `disposition` property, the mail flow continues and further actions and rules are processed, which is the same as with `CONTINUE`\.

For example, you can stop the receipt rule set by writing the following line at the end of your Lambda function code:

```
callback( null, { "disposition" : "STOP_RULE_SET" });
```

For AWS Lambda code samples, see [Lambda function examples](receiving-email-action-lambda-example-functions.md)\. For examples of high\-level use cases, see [Use case examples](receiving-email-action-lambda-example-use-cases.md)\.

### Input format<a name="receiving-email-action-lambda-input"></a>

Amazon SES passes information to the Lambda function in JSON format\. The top\-level object contains a `Records` array, which is populated with properties `eventSource`, `eventVersion`, and `ses`\. The `ses` object contains `receipt` and `mail` objects, which are in exactly the same format as in the Amazon SNS notifications described in [Notification contents](receiving-email-notifications-contents.md)\.

**Note**  
The data that Amazon SES passes to Lambda includes metadata about the message, as well as several email headers\. However, it doesn't contain the body of the message\.

The following is a high\-level view of the structure of the input that Amazon SES provides to the Lambda function\.

```
{
   "Records": [
      {
        "eventSource": "aws:ses",
        "eventVersion": "1.0",
        "ses": {
           "receipt": {
               <same contents as SNS notification>
            },
           "mail": {
               <same contents as SNS notification>
           }
         }
     }
   ]
}
```

### Return values<a name="receiving-email-action-lambda-function-return-values"></a>

Your Lambda function can control mail flow by returning one of the following values:
+ `STOP_RULE`—No further actions in the current receipt rule will be processed, but further receipt rules can be processed\.
+ `STOP_RULE_SET`—No further actions or receipt rules will be processed\.
+ `CONTINUE` or any other invalid value—This means that further actions and receipt rules can be processed\.