# AWS CodePipeline User Guide

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
+ [What is AWS CodePipeline?](welcome.md)
   + [Continuous delivery and continuous integration](concepts-continuous-delivery-integration.md)
   + [What can I do with CodePipeline?](welcome-what-can-I-do.md)
   + [A quick look at CodePipeline](welcome-introducing.md)
   + [How do I get started with CodePipeline?](welcome-get-started.md)
   + [We want to hear from you](welcome-contact-us.md)
   + [CodePipeline concepts](concepts.md)
   + [DevOps pipeline example](concepts-devops-example.md)
   + [How pipeline executions work](concepts-how-it-works.md)
   + [Input and output artifacts](welcome-introducing-artifacts.md)
+ [Getting started with CodePipeline](getting-started-codepipeline.md)
+ [Product and service integrations with CodePipeline](integrations.md)
   + [Integrations with CodePipeline action types](integrations-action-type.md)
   + [General integrations with CodePipeline](integrations-general.md)
   + [Examples from the community](integrations-community.md)
      + [Integration examples: Blog posts](integrations-community-blogposts.md)
      + [Integration examples: Videos](integrations-community-videos.md)
+ [CodePipeline tutorials](tutorials.md)
   + [Tutorial: Create a simple pipeline (S3 bucket)](tutorials-simple-s3.md)
   + [Tutorial: Create a simple pipeline (CodeCommit repository)](tutorials-simple-codecommit.md)
   + [Tutorial: Create a four-stage pipeline](tutorials-four-stage-pipeline.md)
   + [Tutorial: Set up a CloudWatch Events rule to receive email notifications for pipeline state changes](tutorials-cloudwatch-sns-notifications.md)
   + [Tutorial: Create a pipeline that builds and tests your Android app when a commit is pushed to your GitHub repository](tutorials-codebuild-devicefarm.md)
   + [Tutorial: Create a pipeline that tests your iOS app after a change in your S3 bucket](tutorials-codebuild-devicefarm-S3.md)
   + [Tutorial: Create a pipeline that deploys to AWS Service Catalog](tutorials-S3-servicecatalog.md)
   + [Tutorial: Create a pipeline with AWS CloudFormation](tutorials-cloudformation.md)
      + [Example 1: Create an AWS CodeCommit pipeline with AWS CloudFormation](tutorials-cloudformation-codecommit.md)
      + [Example 2: Create an Amazon S3 pipeline with AWS CloudFormation](tutorials-cloudformation-s3.md)
      + [Example 3: Create a GitHub pipeline with AWS CloudFormation](tutorials-cloudformation-github.md)
   + [Tutorial: Create a pipeline that uses variables from AWS CloudFormation deployment actions](tutorials-cloudformation-action.md)
   + [Tutorial: Amazon ECS Standard Deployment with CodePipeline](ecs-cd-pipeline.md)
   + [Tutorial: Create a pipeline with an Amazon ECR source and ECS-to-CodeDeploy deployment](tutorials-ecs-ecr-codedeploy.md)
   + [Tutorial: Create a pipeline that deploys an Amazon Alexa skill](tutorials-alexa-skills-kit.md)
   + [Tutorial: Create a pipeline that uses Amazon S3 as a deployment provider](tutorials-s3deploy.md)
   + [Tutorial: Create a pipeline that publishes your serverless application to the AWS Serverless Application Repository](tutorials-serverlessrepo-auto-publish.md)
   + [Tutorial: Using variables with Lambda invoke actions](tutorials-lambda-variables.md)
   + [Tutorial: Use an AWS Step Functions invoke action in a pipeline](tutorials-step-functions.md)
   + [Tutorial: Create a pipeline that uses AWS AppConfig as a deployment provider](tutorials-AppConfig.md)
+ [CodePipeline best practices and use cases](best-practices.md)
+ [Tagging resources](tag-resources.md)
+ [Use CodePipeline with Amazon Virtual Private Cloud](vpc-support.md)
+ [Working with pipelines in CodePipeline](pipelines.md)
   + [Start a pipeline execution in CodePipeline](pipelines-about-starting.md)
      + [Use CloudWatch Events to start a pipeline (CodeCommit source)](triggering.md)
         + [Create a CloudWatch Events rule for a CodeCommit source (console)](pipelines-trigger-source-repo-changes-console.md)
         + [Create a CloudWatch Events rule for a CodeCommit source (CLI)](pipelines-trigger-source-repo-changes-cli.md)
         + [Create a CloudWatch Events rule for a CodeCommit source (AWS CloudFormation template)](pipelines-trigger-source-repo-changes-cfn.md)
      + [Use CloudWatch Events to start a pipeline (Amazon S3 source)](create-cloudtrail-S3-source.md)
         + [Create a CloudWatch Events rule for an Amazon S3 source (console)](create-cloudtrail-S3-source-console.md)
         + [Create a CloudWatch Events rule for an Amazon S3 source (CLI)](create-cloudtrail-S3-source-cli.md)
         + [Create a CloudWatch Events rule for an Amazon S3 source (AWS CloudFormation template)](create-cloudtrail-S3-source-cfn.md)
      + [Use webhooks to start a pipeline (GitHub source)](pipelines-webhooks.md)
         + [Create a webhook for a GitHub source](pipelines-webhooks-create.md)
         + [List webhooks in your account](pipelines-webhooks-view.md)
         + [Edit the webhook for your GitHub source](pipelines-webhooks-update.title.md)
         + [Delete the webhook for your GitHub source](pipelines-webhooks-delete.md)
         + [Tag a webhook in CodePipeline](tag-webhooks.md)
         + [Create a webhook for a GitHub source (AWS CloudFormation template)](pipelines-webhooks-create-cfn.md)
      + [Use CloudWatch Events to start a pipeline (Amazon ECR source)](create-cwe-ecr-source.md)
         + [Create a CloudWatch Events rule for an Amazon ECR source (console)](create-cwe-ecr-source-console.md)
         + [Create a CloudWatch Events rule for an Amazon ECR source (CLI)](create-cwe-ecr-source-cli.md)
         + [Create a CloudWatch Events rule for an Amazon ECR source (AWS CloudFormation template)](create-cwe-ecr-source-cfn.md)
      + [Use periodic checks to start a pipeline](run-automatically-polling.md)
      + [Start a pipeline manually in AWS CodePipeline](pipelines-rerun-manually.md)
      + [Use Amazon CloudWatch Events to start a pipeline on a schedule](pipelines-trigger-source-schedule.md)
   + [Stop a pipeline execution in CodePipeline](pipelines-stop.md)
   + [Create a pipeline in CodePipeline](pipelines-create.md)
   + [Edit a pipeline in CodePipeline](pipelines-edit.md)
   + [View pipeline details and history in CodePipeline](pipelines-view.md)
      + [View pipeline details and history (console)](pipelines-view-console.md)
      + [View pipeline details and history (CLI)](pipelines-view-cli.md)
   + [Delete a pipeline in CodePipeline](pipelines-delete.md)
   + [Create a pipeline in CodePipeline that uses resources from another AWS account](pipelines-create-cross-account.md)
   + [Edit pipelines to use push events](update-change-detection.md)
   + [Create the CodePipeline service role](pipelines-create-service-role.md)
      + [Create the CodePipeline service role (console)](pipelines-create-service-role-console.md)
      + [Create the CodePipeline service role (CLI)](pipelines-create-service-role-cli.md)
   + [Tag a pipeline in CodePipeline](pipelines-tag.md)
   + [Create a connection to Bitbucket](connections-pipelines.md)
   + [Create a notification rule](notification-rule-create.md)
+ [Working with actions in CodePipeline](actions.md)
   + [Create and add a custom action in CodePipeline](actions-create-custom-action.md)
   + [Tag a custom action in CodePipeline](customactions-tag.md)
   + [Invoke an AWS Lambda function in a pipeline in CodePipeline](actions-invoke-lambda-function.md)
   + [Retry a failed action in CodePipeline](actions-retry.md)
   + [Manage approval actions in CodePipeline](approvals.md)
      + [Grant approval permissions to an IAM user in CodePipeline](approvals-iam-permissions.md)
      + [Grant Amazon SNS permissions to a CodePipeline service role](approvals-service-role-permissions.md)
      + [Add a manual approval action to a pipeline in CodePipeline](approvals-action-add.md)
      + [Approve or reject an approval action in CodePipeline](approvals-approve-or-reject.md)
      + [JSON data format for manual approval notifications in CodePipeline](approvals-json-format.md)
   + [Add a cross-Region action in CodePipeline](actions-create-cross-region.md)
   + [Working with variables](actions-variables.md)
+ [Working with stage transitions in CodePipeline](transitions.md)
+ [Monitoring pipelines with CodePipeline](monitoring.md)
   + [Detect and react to changes in pipeline state with Amazon CloudWatch Events](detect-state-changes-cloudwatch-events.md)
   + [Events placeholder bucket reference](reference-ct-placeholder-buckets.md)
   + [Logging CodePipeline API calls with AWS CloudTrail](monitoring-cloudtrail-logs.md)
+ [Troubleshooting CodePipeline](troubleshooting.md)
+ [Security in AWS CodePipeline](security.md)
   + [Data protection in AWS CodePipeline](data-protection.md)
   + [Identity and access management for AWS CodePipeline](security-iam.md)
      + [How AWS CodePipeline works with IAM](security_iam_service-with-iam.md)
      + [AWS CodePipeline identity-based policy examples](security_iam_id-based-policy-examples.md)
         + [Policy best practices](security_iam_service-with-iam-policy-best-practices.md)
         + [Viewing resources in the console](security-iam-resources-console.md)
         + [Allow users to view their own permissions](security_iam_id-based-policy-examples-view-own-permissions.md)
         + [Identity-based policies (IAM) examples](security-iam-id-policies-examples.md)
         + [Using tags to control access to CodePipeline resources](tag-based-access-control.md)
         + [Permissions required to use the CodePipeline console](security-iam-permissions-console.md)
         + [AWS managed (predefined) policies for CodePipeline](managed-policies.md)
         + [Customer managed policy examples](customer-managed-policies.md)
      + [AWS CodePipeline resource-based policy examples](security_iam_resource-based-policy-examples.md)
      + [Troubleshooting AWS CodePipeline identity and access](security_iam_troubleshoot.md)
      + [CodePipeline permissions reference](permissions-reference.md)
   + [Logging and monitoring in CodePipeline](incident-response.md)
   + [Compliance validation for AWS CodePipeline](SERVICENAME-compliance.md)
   + [Resilience in AWS CodePipeline](disaster-recovery-resiliency.md)
   + [Infrastructure security in AWS CodePipeline](infrastructure-security.md)
   + [Security best practices](security-best-practices.md)
+ [AWS CodePipeline command line reference](reference-command-line.md)
+ [CodePipeline pipeline structure reference](reference-pipeline-structure.md)
+ [Action structure reference](action-reference.md)
   + [Amazon ECR](action-reference-ECR.md)
   + [Amazon Elastic Container Service and CodeDeploy Blue-Green](action-reference-ECSbluegreen.md)
   + [Amazon Elastic Container Service](action-reference-ECS.md)
   + [Amazon S3](action-reference-S3.md)
   + [AWS AppConfig](action-reference-AppConfig.md)
   + [AWS CloudFormation](action-reference-CloudFormation.md)
   + [AWS CodeBuild](action-reference-CodeBuild.md)
   + [CodeCommit](action-reference-CodeCommit.md)
   + [AWS CodeDeploy](action-reference-CodeDeploy.md)
   + [AWS Device Farm](action-reference-DeviceFarm.md)
   + [AWS Lambda](action-reference-Lambda.md)
   + [AWS Step Functions](action-reference-StepFunctions.md)
   + [CodeStarSourceConnection](action-reference-CodestarConnectionSource.md)
   + [GitHub](action-reference-GitHub.md)
+ [Image definitions file reference](file-reference.md)
+ [Variables](reference-variables.md)
+ [Update polling pipelines to the recommended change detection method](trigger-S3-migration-cwe.md)
+ [Quotas in AWS CodePipeline](limits.md)
+ [AWS CodePipeline User Guide document history](history.md)
+ [AWS glossary](glossary.md)