# Use an event to start a CodePipeline execution<a name="configure-service-events-codepipeline"></a>

 This example demonstrates how to configure an Amazon EventBridge rule so that an AWS CodePipeline execution starts when a package version in an CodeArtifact repository is published, modified, or deleted\. 

**Topics**
+ [Configure EventBridge permissions](#configure-service-events-codepipeline-permissions)
+ [Create the EventBridge rule](#configure-service-events-codepipeline-create-rule)
+ [Create the EventBridge rule target](#configure-service-events-codepipeline-create-rule-target)

## Configure EventBridge permissions<a name="configure-service-events-codepipeline-permissions"></a>

 You must add permissions for EventBridge to use CodePipeline to invoke the rule that you create\. To add these permissions using the AWS Command Line Interface \(AWS CLI\), follow step 1 in [Create a CloudWatch Events Rule for a CodeCommit Source \(CLI\)](https://docs.aws.amazon.com/codepipeline/latest/userguide/pipelines-trigger-source-repo-changes-cli.html) in the *AWS CodePipeline User Guide*\. 

## Create the EventBridge rule<a name="configure-service-events-codepipeline-create-rule"></a>

 To create the rule, use the `put-rule` command with the `--name` and `--event-pattern` parameters\. The event pattern specifies values that are matched against the contents of each event\. The target is triggered if the pattern matches the event\. For example, the following pattern matches CodeArtifact events from the `myrepo` repository in the `mydomain` domain\. 

```
aws events put-rule --name MyCodeArtifactRepoRule --event-pattern \
    '{"source":["aws.codeartifact"],"detail-type":["CodeArtifact Package Version State Change"],
    "detail":{"domainName":["mydomain"],"domainOwner":["123456789012"]"repositoryName":["myrepo"]}}'
```

## Create the EventBridge rule target<a name="configure-service-events-codepipeline-create-rule-target"></a>

 The following command adds a target to the rule so that when an event matches the rule, a CodePipeline execution is triggered\. For the `RoleArn` parameter, specify the Amazon Resource Name \(ARN\) of the role created earlier in this topic\. 

```
aws events put-targets --rule MyCodeArtifactRepoRule --targets \
  'Id=1,Arn=arn:aws:codepipeline:us-west-2:123456789012:pipeline-name,
  RoleArn=arn:aws:iam::123456789012:role/MyRole'
```