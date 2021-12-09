# Use an event to run a Lambda function<a name="configure-service-events-lambda-function"></a>

 This example shows you how to configure an EventBridge rule that starts an AWS Lambda function when a package version in an CodeArtifact repository is published, modified, or deleted\. 

For more information, see [Tutorial: Schedule AWS Lambda Functions Using EventBridge](https://docs.aws.amazon.com/eventbridge/latest/userguide/run-lambda-schedule.html) in the *Amazon CloudWatch Events User Guide*\. 

**Topics**
+ [Create the EventBridge rule](#configure-service-events-lambda-create-rule)
+ [Create the EventBridge rule target](#configure-service-events-lambda-create-rule-target)
+ [Configure EventBridge permissions](#configure-service-events-lambda-permissions)

## Create the EventBridge rule<a name="configure-service-events-lambda-create-rule"></a>

 To create a rule that starts a Lambda function, use the `put-rule` command with the `--name` and `--event-pattern` options\. The following pattern specifies npm packages in the `@types` scope in any repository in the `mydomain` domain\.

```
aws events put-rule --name "MyCodeArtifactRepoRule" --event-pattern \
  '{"source":["aws.codeartifact"],"detail-type":["CodeArtifact Package Version State Change"],
  "detail":{"domainName":["mydomain"],"domainOwner":["domainownerID"],"packageNamespace":["types"],"packageFormat":["npm"]}}'
```

## Create the EventBridge rule target<a name="configure-service-events-lambda-create-rule-target"></a>

 The following command adds a target to the rule that runs the Lambda function when an event matches the rule\. For the `arn` parameter, specify the Amazon Resource Name \(ARN\) of the Lambda function\. 

```
aws events put-targets --rule MyCodeArtifactRepoRule --targets \
  Id=1,Arn=arn:aws:lambda:us-west-2:123456789012:function:MyLambdaFunction
```

## Configure EventBridge permissions<a name="configure-service-events-lambda-permissions"></a>

 Use the `add-permission` command to grant permissions for the rule to invoke a Lambda function\. For the `--source-arn` parameter, specify the ARN of the rule that you created earlier in this example\. 

```
aws lambda add-permission --function-name MyLambdaFunction \\
  --statement-id my-statement-id --action 'lambda:InvokeFunction' \\
  --principal events.amazonaws.com \\
  --source-arn arn:aws:events:us-west-2:123456789012:rule/MyCodeArtifactRepoRule
```