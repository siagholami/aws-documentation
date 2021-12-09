# AWS Lambda Developer Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What is AWS Lambda?](welcome.md)
+ [Getting started with AWS Lambda](getting-started.md)
   + [Create a Lambda function with the console](getting-started-create-function.md)
   + [Creating functions using the AWS Lambda console editor](code-editor.md)
   + [Using AWS Lambda with the AWS Command Line Interface](gettingstarted-awscli.md)
   + [AWS Lambda concepts](gettingstarted-concepts.md)
   + [AWS Lambda features](gettingstarted-features.md)
   + [Tools for working with AWS Lambda](gettingstarted-tools.md)
   + [AWS Lambda quotas](gettingstarted-limits.md)
+ [AWS Lambda permissions](lambda-permissions.md)
   + [AWS Lambda execution role](lambda-intro-execution-role.md)
   + [Using resource-based policies for AWS Lambda](access-control-resource-based.md)
   + [Identity-based IAM policies for AWS Lambda](access-control-identity-based.md)
   + [Resources and conditions for Lambda actions](lambda-api-permissions-ref.md)
   + [Using permissions boundaries for AWS Lambda applications](permissions-boundary.md)
+ [Managing AWS Lambda functions](lambda-functions.md)
   + [Configuring functions in the AWS Lambda console](configuration-console.md)
   + [Using AWS Lambda environment variables](configuration-envvars.md)
   + [Managing concurrency for a Lambda function](configuration-concurrency.md)
   + [Lambda function versions](configuration-versions.md)
   + [Lambda function aliases](configuration-aliases.md)
   + [AWS Lambda layers](configuration-layers.md)
   + [Configuring a Lambda function to access resources in a VPC](configuration-vpc.md)
   + [Configuring database access for a Lambda function](configuration-database.md)
   + [Configuring file system access for Lambda functions](configuration-filesystem.md)
   + [Tagging Lambda Functions](configuration-tags.md)
+ [Invoking AWS Lambda functions](lambda-invocation.md)
   + [Synchronous invocation](invocation-sync.md)
   + [Asynchronous invocation](invocation-async.md)
   + [AWS Lambda event source mappings](invocation-eventsourcemapping.md)
   + [Monitoring the state of a function with the Lambda API](functions-states.md)
   + [AWS Lambda function scaling](invocation-scaling.md)
   + [Error handling and automatic retries in AWS Lambda](invocation-retries.md)
   + [Invoking Lambda functions with the AWS Mobile SDK for Android](with-on-demand-custom-android.md)
      + [Tutorial: Using AWS Lambda with the Mobile SDK for Android](with-android-example.md)
      + [Sample function code](with-android-create-package.md)
+ [AWS Lambda runtimes](lambda-runtimes.md)
   + [AWS Lambda execution context](runtimes-context.md)
   + [Runtime support policy](runtime-support-policy.md)
   + [Custom AWS Lambda runtimes](runtimes-custom.md)
   + [AWS Lambda runtime interface](runtimes-api.md)
   + [Tutorial – Publishing a custom runtime](runtimes-walkthrough.md)
+ [AWS Lambda applications](deploying-lambda-apps.md)
   + [Managing applications in the AWS Lambda console](applications-console.md)
   + [Creating an application with continuous delivery in the Lambda console](applications-tutorial.md)
   + [Rolling deployments for Lambda functions](lambda-rolling-deployments.md)
   + [Common Lambda application types and use cases](applications-usecases.md)
   + [Best practices for working with AWS Lambda functions](best-practices.md)
+ [Using AWS Lambda with other services](lambda-services.md)
   + [Using AWS Lambda with Alexa](services-alexa.md)
   + [Using AWS Lambda with Amazon API Gateway](services-apigateway.md)
      + [Tutorial: Using AWS Lambda with Amazon API Gateway](services-apigateway-tutorial.md)
      + [Sample function code](services-apigateway-code.md)
      + [Create a simple microservice using Lambda and API Gateway](services-apigateway-blueprint.md)
      + [AWS SAM template for an API Gateway application](services-apigateway-template.md)
   + [Using AWS Lambda with AWS CloudTrail](with-cloudtrail.md)
      + [Logging AWS Lambda API calls with AWS CloudTrail](logging-using-cloudtrail.md)
      + [Tutorial: Triggering a Lambda function with AWS CloudTrail events](with-cloudtrail-example.md)
      + [Sample function code](with-cloudtrail-create-package.md)
   + [Using AWS Lambda with Amazon CloudWatch Events](services-cloudwatchevents.md)
      + [Tutorial: Using AWS Lambda with scheduled events](services-cloudwatchevents-tutorial.md)
      + [AWS SAM template for a CloudWatch Events application](with-scheduledevents-example-use-app-spec.md)
      + [Schedule expressions using rate or cron](services-cloudwatchevents-expressions.md)
   + [Using AWS Lambda with Amazon CloudWatch Logs](services-cloudwatchlogs.md)
   + [Using AWS Lambda with AWS CloudFormation](services-cloudformation.md)
   + [Using AWS Lambda with CloudFront Lambda@Edge](lambda-edge.md)
   + [Using AWS Lambda with AWS CodeCommit](services-codecommit.md)
   + [Using AWS Lambda with AWS CodePipeline](services-codepipeline.md)
   + [Using AWS Lambda with Amazon Cognito](services-cognito.md)
   + [Using AWS Lambda with AWS Config](services-config.md)
   + [Using AWS Lambda with Amazon DynamoDB](with-ddb.md)
      + [Tutorial: Using AWS Lambda with Amazon DynamoDB streams](with-ddb-example.md)
      + [Sample function code](with-ddb-create-package.md)
      + [AWS SAM template for a DynamoDB application](kinesis-tutorial-spec.md)
   + [Using AWS Lambda with Amazon EC2](services-ec2.md)
      + [Tutorial: Using AWS SDK for .NET to manage Amazon EC2 Spot Instances](services-ec2-tutorial.md)
   + [Tutorial: Configuring a Lambda function to access Amazon ElastiCache in an Amazon VPC](services-elasticache-tutorial.md)
   + [Using AWS Lambda with an Application Load Balancer](services-alb.md)
   + [Using Amazon EFS with Lambda](services-efs.md)
   + [Using AWS Lambda with AWS IoT](services-iot.md)
   + [Using AWS Lambda with AWS IoT Events](services-iotevents.md)
   + [Using AWS Lambda with Amazon Kinesis Data Firehose](services-kinesisfirehose.md)
   + [Using AWS Lambda with Amazon Kinesis](with-kinesis.md)
      + [Tutorial: Using AWS Lambda with Amazon Kinesis](with-kinesis-example.md)
      + [Sample function code](with-kinesis-create-package.md)
      + [AWS SAM template for a Kinesis application](with-kinesis-example-use-app-spec.md)
   + [Using AWS Lambda with Amazon Lex](services-lex.md)
   + [Using Lambda with Amazon MSK](with-msk.md)
   + [Using AWS Lambda with Amazon RDS](services-rds.md)
   + [Using AWS Lambda with Amazon S3](with-s3.md)
      + [Tutorial: Using AWS Lambda with Amazon S3](with-s3-example.md)
      + [Sample Amazon S3 function code](with-s3-example-deployment-pkg.md)
      + [AWS SAM template for an Amazon S3 application](with-s3-example-use-app-spec.md)
   + [Using AWS Lambda with Amazon S3 batch operations](services-s3-batch.md)
   + [Using AWS Lambda with Amazon SES](services-ses.md)
   + [Using AWS Lambda with Amazon SNS](with-sns.md)
      + [Tutorial: Using AWS Lambda with Amazon Simple Notification Service](with-sns-example.md)
      + [Sample function code](with-sns-create-package.md)
   + [Using AWS Lambda with Amazon SQS](with-sqs.md)
      + [Tutorial: Using AWS Lambda with Amazon Simple Queue Service](with-sqs-example.md)
      + [Sample Amazon SQS function code](with-sqs-create-package.md)
      + [AWS SAM template for an Amazon SQS application](with-sqs-example-use-app-spec.md)
   + [Using AWS Lambda with AWS X-Ray](services-xray.md)
+ [Orchestrating functions with Step Functions](lambda-stepfunctions.md)
   + [State machine application patterns](stepfunctions-patterns.md)
   + [Managing state machines in the Lambda console](stepfunctions-lc.md)
   + [Orchestration examples with Step Functions](services-stepfunctions.md)
+ [Lambda sample applications](lambda-samples.md)
   + [Blank function sample application for AWS Lambda](samples-blank.md)
   + [Error processor sample application for AWS Lambda](samples-errorprocessor.md)
   + [List manager sample application for AWS Lambda](samples-listmanager.md)
+ [Building Lambda functions with Node.js](lambda-nodejs.md)
   + [AWS Lambda function handler in Node.js](nodejs-handler.md)
   + [AWS Lambda deployment package in Node.js](nodejs-package.md)
   + [AWS Lambda context object in Node.js](nodejs-context.md)
   + [AWS Lambda function logging in Node.js](nodejs-logging.md)
   + [AWS Lambda function errors in Node.js](nodejs-exceptions.md)
   + [Instrumenting Node.js code in AWS Lambda](nodejs-tracing.md)
+ [Building Lambda functions with Python](lambda-python.md)
   + [AWS Lambda function handler in Python](python-handler.md)
   + [AWS Lambda deployment package in Python](python-package.md)
   + [AWS Lambda context object in Python](python-context.md)
   + [AWS Lambda function logging in Python](python-logging.md)
   + [AWS Lambda function errors in Python](python-exceptions.md)
   + [Instrumenting Python code in AWS Lambda](python-tracing.md)
+ [Building Lambda functions with Ruby](lambda-ruby.md)
   + [AWS Lambda function handler in Ruby](ruby-handler.md)
   + [AWS Lambda deployment package in Ruby](ruby-package.md)
   + [AWS Lambda context object in Ruby](ruby-context.md)
   + [AWS Lambda function logging in Ruby](ruby-logging.md)
   + [AWS Lambda function errors in Ruby](ruby-exceptions.md)
   + [Instrumenting Ruby code in AWS Lambda](ruby-tracing.md)
+ [Building Lambda functions with Java](lambda-java.md)
   + [Java sample applications for AWS Lambda](java-samples.md)
   + [AWS Lambda deployment package in Java](java-package.md)
   + [AWS Lambda function handler in Java](java-handler.md)
   + [AWS Lambda context object in Java](java-context.md)
   + [AWS Lambda function logging in Java](java-logging.md)
   + [AWS Lambda function errors in Java](java-exceptions.md)
   + [Instrumenting Java code in AWS Lambda](java-tracing.md)
   + [Creating a deployment package using Eclipse](java-package-eclipse.md)
+ [Building Lambda functions with Go](lambda-golang.md)
   + [AWS Lambda deployment package in Go](golang-package.md)
   + [AWS Lambda function handler in Go](golang-handler.md)
   + [AWS Lambda context object in Go](golang-context.md)
   + [AWS Lambda function logging in Go](golang-logging.md)
   + [AWS Lambda function errors in Go](golang-exceptions.md)
   + [Instrumenting Go code in AWS Lambda](golang-tracing.md)
   + [Using environment variables](golang-envvars.md)
+ [Building Lambda functions with C#](lambda-csharp.md)
   + [AWS Lambda Deployment Package in C#](csharp-package.md)
      + [.NET Core CLI](csharp-package-cli.md)
      + [AWS Toolkit for Visual Studio](csharp-package-toolkit.md)
   + [AWS Lambda function handler in C#](csharp-handler.md)
   + [AWS Lambda context object in C#](csharp-context.md)
   + [AWS Lambda function logging in C#](csharp-logging.md)
   + [AWS Lambda function errors in C#](csharp-exceptions.md)
   + [Instrumenting C# code in AWS Lambda](csharp-tracing.md)
+ [Building Lambda functions with PowerShell](lambda-powershell.md)
   + [Setting Up a PowerShell Development Environment](powershell-devenv.md)
   + [AWS Lambda deployment package in PowerShell](powershell-package.md)
   + [AWS Lambda function handler in PowerShell](powershell-handler.md)
   + [AWS Lambda context object in PowerShell](powershell-context.md)
   + [AWS Lambda function logging in PowerShell](powershell-logging.md)
   + [AWS Lambda function errors in PowerShell](powershell-exceptions.md)
+ [Monitoring and troubleshooting Lambda applications](lambda-monitoring.md)
   + [Monitoring functions in the AWS Lambda console](monitoring-functions-access-metrics.md)
   + [Working with AWS Lambda function metrics](monitoring-metrics.md)
   + [Accessing Amazon CloudWatch logs for AWS Lambda](monitoring-cloudwatchlogs.md)
+ [Security in AWS Lambda](lambda-security.md)
   + [Data protection in AWS Lambda](security-dataprotection.md)
   + [Identity and access management for AWS Lambda](security-iam.md)
      + [How AWS Lambda works with IAM](security_iam_service-with-iam.md)
      + [AWS Lambda identity-based policy examples](security_iam_id-based-policy-examples.md)
      + [Troubleshooting AWS Lambda identity and access](security_iam_troubleshoot.md)
   + [Compliance validation for AWS Lambda](security-compliance.md)
   + [Resilience in AWS Lambda](security-resilience.md)
   + [Infrastructure security in AWS Lambda](security-infrastructure.md)
   + [Configuration and vulnerability analysis in AWS Lambda](security-configuration.md)
+ [Troubleshooting issues in AWS Lambda](lambda-troubleshooting.md)
   + [Troubleshoot deployment issues in AWS Lambda](troubleshooting-deployment.md)
   + [Troubleshoot invocation issues in AWS Lambda](troubleshooting-invocation.md)
   + [Troubleshoot execution issues in AWS Lambda](troubleshooting-execution.md)
   + [Troubleshoot networking issues in AWS Lambda](troubleshooting-networking.md)
+ [AWS Lambda releases](lambda-releases.md)
+ [API reference](API_Reference.md)
   + [Actions](API_Operations.md)
      + [AddLayerVersionPermission](API_AddLayerVersionPermission.md)
      + [AddPermission](API_AddPermission.md)
      + [CreateAlias](API_CreateAlias.md)
      + [CreateEventSourceMapping](API_CreateEventSourceMapping.md)
      + [CreateFunction](API_CreateFunction.md)
      + [DeleteAlias](API_DeleteAlias.md)
      + [DeleteEventSourceMapping](API_DeleteEventSourceMapping.md)
      + [DeleteFunction](API_DeleteFunction.md)
      + [DeleteFunctionConcurrency](API_DeleteFunctionConcurrency.md)
      + [DeleteFunctionEventInvokeConfig](API_DeleteFunctionEventInvokeConfig.md)
      + [DeleteLayerVersion](API_DeleteLayerVersion.md)
      + [DeleteProvisionedConcurrencyConfig](API_DeleteProvisionedConcurrencyConfig.md)
      + [GetAccountSettings](API_GetAccountSettings.md)
      + [GetAlias](API_GetAlias.md)
      + [GetEventSourceMapping](API_GetEventSourceMapping.md)
      + [GetFunction](API_GetFunction.md)
      + [GetFunctionConcurrency](API_GetFunctionConcurrency.md)
      + [GetFunctionConfiguration](API_GetFunctionConfiguration.md)
      + [GetFunctionEventInvokeConfig](API_GetFunctionEventInvokeConfig.md)
      + [GetLayerVersion](API_GetLayerVersion.md)
      + [GetLayerVersionByArn](API_GetLayerVersionByArn.md)
      + [GetLayerVersionPolicy](API_GetLayerVersionPolicy.md)
      + [GetPolicy](API_GetPolicy.md)
      + [GetProvisionedConcurrencyConfig](API_GetProvisionedConcurrencyConfig.md)
      + [Invoke](API_Invoke.md)
      + [InvokeAsync](API_InvokeAsync.md)
      + [ListAliases](API_ListAliases.md)
      + [ListEventSourceMappings](API_ListEventSourceMappings.md)
      + [ListFunctionEventInvokeConfigs](API_ListFunctionEventInvokeConfigs.md)
      + [ListFunctions](API_ListFunctions.md)
      + [ListLayers](API_ListLayers.md)
      + [ListLayerVersions](API_ListLayerVersions.md)
      + [ListProvisionedConcurrencyConfigs](API_ListProvisionedConcurrencyConfigs.md)
      + [ListTags](API_ListTags.md)
      + [ListVersionsByFunction](API_ListVersionsByFunction.md)
      + [PublishLayerVersion](API_PublishLayerVersion.md)
      + [PublishVersion](API_PublishVersion.md)
      + [PutFunctionConcurrency](API_PutFunctionConcurrency.md)
      + [PutFunctionEventInvokeConfig](API_PutFunctionEventInvokeConfig.md)
      + [PutProvisionedConcurrencyConfig](API_PutProvisionedConcurrencyConfig.md)
      + [RemoveLayerVersionPermission](API_RemoveLayerVersionPermission.md)
      + [RemovePermission](API_RemovePermission.md)
      + [TagResource](API_TagResource.md)
      + [UntagResource](API_UntagResource.md)
      + [UpdateAlias](API_UpdateAlias.md)
      + [UpdateEventSourceMapping](API_UpdateEventSourceMapping.md)
      + [UpdateFunctionCode](API_UpdateFunctionCode.md)
      + [UpdateFunctionConfiguration](API_UpdateFunctionConfiguration.md)
      + [UpdateFunctionEventInvokeConfig](API_UpdateFunctionEventInvokeConfig.md)
   + [Data Types](API_Types.md)
      + [AccountLimit](API_AccountLimit.md)
      + [AccountUsage](API_AccountUsage.md)
      + [AliasConfiguration](API_AliasConfiguration.md)
      + [AliasRoutingConfiguration](API_AliasRoutingConfiguration.md)
      + [Concurrency](API_Concurrency.md)
      + [DeadLetterConfig](API_DeadLetterConfig.md)
      + [DestinationConfig](API_DestinationConfig.md)
      + [Environment](API_Environment.md)
      + [EnvironmentError](API_EnvironmentError.md)
      + [EnvironmentResponse](API_EnvironmentResponse.md)
      + [EventSourceMappingConfiguration](API_EventSourceMappingConfiguration.md)
      + [FileSystemConfig](API_FileSystemConfig.md)
      + [FunctionCode](API_FunctionCode.md)
      + [FunctionCodeLocation](API_FunctionCodeLocation.md)
      + [FunctionConfiguration](API_FunctionConfiguration.md)
      + [FunctionEventInvokeConfig](API_FunctionEventInvokeConfig.md)
      + [Layer](API_Layer.md)
      + [LayersListItem](API_LayersListItem.md)
      + [LayerVersionContentInput](API_LayerVersionContentInput.md)
      + [LayerVersionContentOutput](API_LayerVersionContentOutput.md)
      + [LayerVersionsListItem](API_LayerVersionsListItem.md)
      + [OnFailure](API_OnFailure.md)
      + [OnSuccess](API_OnSuccess.md)
      + [ProvisionedConcurrencyConfigListItem](API_ProvisionedConcurrencyConfigListItem.md)
      + [TracingConfig](API_TracingConfig.md)
      + [TracingConfigResponse](API_TracingConfigResponse.md)
      + [VpcConfig](API_VpcConfig.md)
      + [VpcConfigResponse](API_VpcConfigResponse.md)
+ [AWS glossary](glossary.md)