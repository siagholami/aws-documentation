# Resources you can use with AWS Resource Groups<a name="supported-resources"></a>

You can use the AWS Management Console or the AWS CLI to add tags to many AWS resources\. This topic describes resources that you can query and group into resource groups by using AWS Resource Groups, and resources that you can tag by using Tag Editor\.

**Important**  
A resource group based on a query for **All supported resource types** can add members automatically over time, as new resources are supported by Resource Groups\. When you run automations or other bulk tasks on an existing resource group based on **All supported resource types**, be aware that the actions might be run on many more resources than were in the group when you first created it\. This might also mean that automations or tasks that you created for other resources are applied to unintended resources, or resources on which the tasks cannot be completed\.  

![\[Query based on All supported resource types.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-allsupported-resources.png)

The following tables list which resources are supported for tag\-based groups, tagging in Tag Editor, and for AWS CloudFormation stack\-based groups\. 

## Amazon API Gateway<a name="services-apigateway"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ApiGateway::Account | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ApiGateway::ApiKey | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ApiGateway::DomainName | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ApiGateway::RestApi | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ApiGateway::Stage | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ApiGateway::UsagePlan | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon AppStream<a name="services-appstream"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::AppStream::Fleet | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::AppStream::ImageBuilder | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::AppStream::Stack | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS AppSync<a name="services-appsync"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::AppSync::DataSource | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::AppSync::GraphQLApi | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Certificate Manager<a name="services-certificatemanager"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CertificateManager::Certificate | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Certificate Manager Private Certificate Authority<a name="services-acmpca"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ACMPCA::CertificateAuthority | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Cloud9<a name="services-cloud9"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Cloud9::Environment | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS CloudFormation<a name="services-cloudformation"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CloudFormation::Stack | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon CloudFront<a name="services-cloudfront"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CloudFront::Distribution | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | 
| AWS::CloudFront::StreamingDistribution | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | 

¹ This is a resource for a global service that is hosted in the **US East \(N\. Virginia\)** Region\. To use Tag Editor to create or modify tags for this resource type, you must include `us-east-1` from the **Select regions** list under **Find resources to tag** in the Tag Editor console\.

² This is a resource for a global service that is hosted in the **US East \(N\. Virginia\)** Region\. Because Resource Groups are maintained separately for each region, you must switch your AWS console to the Region that contains the resources you want to include in the group\. To create a resource group that contains a global resource, you must configure your AWS Console to **US East \(N\. Virginia\) us\-east\-1** using the Region selector in the upper\-right corner of the AWS console\.

## AWS CloudTrail<a name="services-cloudtrail"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CloudTrail::Trail | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon CloudWatch<a name="services-cloudwatch"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CloudWatch::Alarm | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::CloudWatch::Dashboard | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon CloudWatch Logs<a name="services-logs"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Logs::LogGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS CodeBuild<a name="services-codebuild"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CodeBuild::Project | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS CodeCommit<a name="services-codecommit"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CodeCommit::Repository | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS CodeDeploy<a name="services-codedeploy"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CodeDeploy::Application | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::CodeDeploy::DeploymentConfig | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS CodePipeline<a name="services-codepipeline"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::CodePipeline::CustomActionType | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::CodePipeline::Pipeline | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::CodePipeline::Webhook | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Cognito<a name="services-cognito"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Cognito::IdentityPool | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Cognito::UserPool | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Comprehend<a name="services-comprehend"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Comprehend::DocumentClassifier | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Comprehend::EntityRecognizer | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Config<a name="services-config"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Config::ConfigRule | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Data Exchange<a name="services-dataexchange"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::DataExchange::DataSet | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::DataExchange::Revision | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Data Pipeline<a name="services-datapipeline"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::DataPipeline::Pipeline | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Database Migration Service<a name="services-dms"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::DMS::Certificate | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::DMS::Endpoint | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::DMS::EventSubscription | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::DMS::ReplicationInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::DMS::ReplicationSubnetGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::DMS::ReplicationTask | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon DynamoDB<a name="services-dynamodb"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::DynamoDB::Table | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon EMR<a name="services-emr"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::EMR::Cluster | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon ElastiCache<a name="services-elasticache"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ElastiCache::CacheCluster | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ElastiCache::Snapshot | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Elastic Beanstalk<a name="services-elasticbeanstalk"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ElasticBeanstalk::Application | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ElasticBeanstalk::ApplicationVersion | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ElasticBeanstalk::ConfigurationTemplate | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ElasticBeanstalk::Environment | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Elastic Compute Cloud \(Amazon EC2\)<a name="services-ec2"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::EC2::CapacityReservation | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::CustomerGateway | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::DHCPOptions | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::EIP | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::Host | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::Image | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::Instance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::InternetGateway | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::LaunchTemplate | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::NatGateway | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::NetworkAcl | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::NetworkInterface | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::ReservedInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::RouteTable | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::SecurityGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::Snapshot | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::SpotInstanceRequest | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::Subnet | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::TransitGateway | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::TransitGatewayRouteTable | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::EC2::Volume | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::VPC | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::VPCPeeringConnection | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::VPNConnection | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::EC2::VPNGateway | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Elastic Container Registry<a name="services-ecr"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ECR::Repository | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Elastic Container Service<a name="services-ecs"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ECS::Cluster | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ECS::ContainerInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ECS::Service | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ECS::Task | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::ECS::TaskDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Elastic File System<a name="services-efs"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::EFS::FileSystem | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Elastic Load Balancing<a name="services-elasticloadbalancing"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ElasticLoadBalancing::LoadBalancer | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ElasticLoadBalancingV2::LoadBalancer | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ElasticLoadBalancingV2::TargetGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Elasticsearch Service<a name="services-elasticsearch"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Elasticsearch::Domain | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon CloudWatch Events<a name="services-events"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Events::Rule | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon FSx<a name="services-fsx"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::FSx::FileSystem | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Glue<a name="services-glue"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Glue::Crawler | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Glue::Database | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Glue::Job | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Glue::Trigger | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Identity and Access Management<a name="services-iam"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::IAM::Role | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Inspector<a name="services-inspector"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Inspector::AssessmentTemplate | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS IoT<a name="services-iot"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::IoT::TopicRule | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS IoT Analytics<a name="services-iotanalytics"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::IoTAnalytics::Channel | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::IoTAnalytics::Dataset | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::IoTAnalytics::Datastore | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::IoTAnalytics::Pipeline | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS IoT Events<a name="services-iotevents"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::IoTEvents::DetectorModel | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::IoTEvents::Input | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS IoT Greengrass<a name="services-greengrass"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Greengrass::ConnectorDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::CoreDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::DeviceDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::FunctionDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::Group | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::LoggerDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::ResourceDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Greengrass::SubscriptionDefinition | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Key Management Service<a name="services-kms"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::KMS::Alias | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::KMS::Key | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Kinesis<a name="services-kinesis"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Kinesis::Stream | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Kinesis Data Analytics<a name="services-kinesisanalytics"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::KinesisAnalytics::Application | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::KinesisAnalyticsV2::Application | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Kinesis Data Firehose<a name="services-kinesisfirehose"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::KinesisFirehose::DeliveryStream | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Lambda<a name="services-lambda"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Lambda::Alias | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Lambda::EventSourceMapping | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Lambda::Function | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Lambda::LayerVersion | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Lambda::Version | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon MQ<a name="services-amazonmq"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::AmazonMQ::Broker | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::AmazonMQ::Configuration | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Managed Streaming for Apache Kafka<a name="services-kafka"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Kafka::Cluster | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS OpsWorks<a name="services-opsworks"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::OpsWorks::Instance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::OpsWorks::Layer | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::OpsWorks::Stack | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Organizations<a name="services-organizations"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Organizations::Account | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Quantum Ledger Database \(Amazon QLDB\)<a name="services-qldb"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::QLDB::Ledger | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Redshift<a name="services-redshift"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Redshift::Cluster | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Redshift::ClusterParameterGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Redshift::ClusterSecurityGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Redshift::ClusterSubnetGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::Redshift::HSMClientCertificate | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Relational Database Service \(Amazon RDS\)<a name="services-rds"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::RDS::DBCluster | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::RDS::DBClusterParameterGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::RDS::DBClusterSnapshot | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RDS::DBInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::RDS::DBParameterGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::RDS::DBSecurityGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::RDS::DBSnapshot | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RDS::DBSubnetGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::RDS::EventSubscription | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RDS::OptionGroup | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RDS::ReservedDBInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Resource Access Manager<a name="services-ram"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::RAM::ResourceShare | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Resource Groups<a name="services-resourcegroups"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ResourceGroups::Group | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Robomaker<a name="services-robomaker"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::RoboMaker::DeploymentJob | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RoboMaker::Fleet | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RoboMaker::Robot | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RoboMaker::RobotApplication | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RoboMaker::SimulationApplication | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::RoboMaker::SimulationJob | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon Route 53<a name="services-route53"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Route53::Domain | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Route53::HealthCheck | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | 
| AWS::Route53::HostedZone | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | 

¹ This is a resource for a global service that is hosted in the **US East \(N\. Virginia\)** Region\. To use Tag Editor to create or modify tags for this resource type, you must include `us-east-1` from the **Select regions** list under **Find resources to tag** in the Tag Editor console\.

² This is a resource for a global service that is hosted in the **US East \(N\. Virginia\)** Region\. Because Resource Groups are maintained separately for each region, you must switch your AWS console to the Region that contains the resources you want to include in the group\. To create a resource group that contains a global resource, you must configure your AWS Console to **US East \(N\. Virginia\) us\-east\-1** using the Region selector in the upper\-right corner of the AWS console\.

## Amazon Route 53 Resolver<a name="services-route53resolver"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Route53Resolver::ResolverEndpoint | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::Route53Resolver::ResolverRule | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes¹ | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes² | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

¹ This is a resource for a global service that is hosted in the **US East \(N\. Virginia\)** Region\. To use Tag Editor to create or modify tags for this resource type, you must include `us-east-1` from the **Select regions** list under **Find resources to tag** in the Tag Editor console\.

² This is a resource for a global service that is hosted in the **US East \(N\. Virginia\)** Region\. Because Resource Groups are maintained separately for each region, you must switch your AWS console to the Region that contains the resources you want to include in the group\. To create a resource group that contains a global resource, you must configure your AWS Console to **US East \(N\. Virginia\) us\-east\-1** using the Region selector in the upper\-right corner of the AWS console\.

## Amazon S3 Glacier<a name="services-glacier"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::Glacier::Vault | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## Amazon SageMaker<a name="services-sagemaker"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::SageMaker::Endpoint | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::SageMaker::EndpointConfig | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::SageMaker::HyperParameterTuningJob | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::SageMaker::LabelingJob | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::SageMaker::Model | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::SageMaker::NotebookInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::SageMaker::TrainingJob | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::SageMaker::TransformJob | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::SageMaker::Workteam | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Secrets Manager<a name="services-secretsmanager"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::SecretsManager::Secret | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Service Catalog<a name="services-servicecatalog"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::ServiceCatalog::CloudFormationProduct | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::ServiceCatalog::Portfolio | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Simple Notification Service<a name="services-sns"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::SNS::Topic | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Simple Queue Service<a name="services-sqs"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::SQS::Queue | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon Simple Storage Service \(Amazon S3\)<a name="services-s3"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::S3::Bucket | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Step Functions<a name="services-stepfunctions"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::StepFunctions::Activity | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::StepFunctions::StateMachine | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## AWS Storage Gateway<a name="services-storagegateway"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::StorageGateway::Gateway | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::StorageGateway::Volume | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 

## AWS Systems Manager<a name="services-ssm"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::SSM::Document | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::SSM::MaintenanceWindow | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::SSM::ManagedInstance | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | 
| AWS::SSM::Parameter | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 
| AWS::SSM::PatchBaseline | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-no.png) No | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 

## Amazon WorkSpaces<a name="services-workspaces"></a>


| **Resources** | **Tag Editor Tagging** | **Tag\-based Groups** | **AWS CloudFormation Stack\-based Groups** | 
| --- | --- | --- | --- | 
| AWS::WorkSpaces::Workspace | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/icon-yes.png) Yes | 