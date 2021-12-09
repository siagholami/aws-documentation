# <a name="glos-chap"></a>

# AWS Glossary<a name="glos-chap"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

### Numbers and Symbols<a name="numbers"></a>

**100\-continue**<a name="hundredcontinue"></a>  
A method that enables a client to see if a server can accept a request before actually sending it\. For large PUT requests, this method can save both time and bandwidth charges\.

### A<a name="A"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**AAD**   
See [additional authenticated data](#additional_authenticated_data).

**access control list \(ACL\)**<a name="ACL"></a>  
A document that defines who can access a particular [bucket](#bucket) or object\. Each [bucket](#bucket) and object in [Amazon S3](#AmazonSimpleStorageService) has an ACL\. The document defines what each type of user can do, such as write and read permissions\.

**access identifiers**   
See [credentials](#accesscredentials).

**access key**<a name="access_key"></a>  
The combination of an [access key ID](#accesskeyID) \(like `AKIAIOSFODNN7EXAMPLE`\) and a [secret access key](#SecretAccessKey) \(like `wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY`\)\. You use access keys to sign API requests that you make to AWS\.

**access key ID**<a name="accesskeyID"></a>  
A unique identifier that's associated with a [secret access key](#SecretAccessKey); the access key ID and secret access key are used together to sign programmatic AWS requests cryptographically\.

**access key rotation**<a name="keyrotate"></a>  
A method to increase security by changing the AWS access key ID\. This method enables you to retire an old key at your discretion\.

**access policy language**<a name="accesslang"></a>  
A language for writing documents \(that is, [*policies*](#policy)\) that specify who can access a particular AWS [resource](#resource) and under what conditions\.

**account**<a name="account"></a>  
A formal relationship with AWS that is associated with all of the following:  
+ The owner email address and password
+ The control of [resource](#resource)s created under its umbrella
+ Payment for the AWS activity related to those resources
The AWS account has permission to do anything and everything with all the AWS account resources\. This is in contrast to a [user](#AWSUser), which is an entity contained within the account\.

**account activity**<a name="accountactivity"></a>  
A webpage showing your month\-to\-date AWS usage and costs\. The account activity page is located at [https://aws\.amazon\.com/account\-activity/](https://aws.amazon.com/account-activity/)\.

**ACL**   
See [access control list \(ACL\)](#ACL).

**ACM**   
See [AWS Certificate Manager \(ACM\)](#acm).

**ACM PCA**   
See [AWS Certificate Manager Private Certificate Authority \(ACM PCA\)](#acm-pca).

**ACM Private CA**   
See [AWS Certificate Manager Private Certificate Authority \(ACM PCA\)](#acm-pca).

**action**<a name="action"></a>  
An API function\. Also called *operation* or *call*\. The activity the [principal](#principal) has permission to perform\. The action is B in the statement "A has permission to do B to C where D applies\." For example, Jane sends a request to [Amazon SQS](#AmazonSimpleQueueService) with Action=ReceiveMessage\.   
[Amazon CloudWatch](#AmazonCW): The response initiated by the change in an alarm's state: for example, from OK to ALARM\. The state change may be triggered by a metric reaching the alarm threshold, or by a SetAlarmState request\. Each alarm can have one or more actions assigned to each state\. Actions are performed once each time the alarm changes to a state that has an action assigned, such as an [Amazon Simple Notification Service](#SNS) notification, an [Amazon EC2 Auto Scaling](#AutoScaling) [policy](#policy) execution or an [Amazon EC2](#ec2) [instance](#instance) stop/terminate action\.

**active trusted signers**<a name="trustedsigner"></a>  
A list showing each of the trusted signers you've specified and the IDs of the corresponding active key pairs that [Amazon CloudFront](#AmazonCF) is aware of\. To be able to create working signed URLs, a trusted signer must appear in this list with at least one key pair ID\.

**additional authenticated data**<a name="additional_authenticated_data"></a>  
Information that is checked for integrity but not encrypted, such as headers or other contextual metadata\.

**administrative suspension**<a name="admin_suspension"></a>  
[Amazon EC2 Auto Scaling](#AutoScaling) might suspend processes for [Auto Scaling group](#AutoScalingGroup) that repeatedly fail to launch instances\. Auto Scaling groups that most commonly experience administrative suspension have zero running instances, have been trying to launch instances for more than 24 hours, and have not succeeded in that time\. 

**alarm**<a name="alarm"></a>  
An item that watches a single metric over a specified time period and triggers an [Amazon SNS](#SNS) [topic](#topic) or an [Amazon EC2 Auto Scaling](#AutoScaling) [policy](#policy) if the value of the metric crosses a threshold value over a predetermined number of time periods\.

**allow**<a name="allow"></a>  
One of two possible outcomes \(the other is [deny](#deny)\) when an [IAM](#IAM) access [policy](#policy) is evaluated\. When a user makes a request to AWS, AWS evaluates the request based on all permissions that apply to the user and then returns either allow or deny\.

**Amazon API Gateway**<a name="APIGateway"></a>  
A fully managed service that makes it easy for developers to create, publish, maintain, monitor, and secure APIs at any scale\.   
See also [https://aws\.amazon\.com/api\-gateway](https://aws.amazon.com/apigateway/).

**Amazon AppStream 2\.0**<a name="appstream"></a>  
A fully managed, secure service for streaming desktop applications to users without rewriting those applications\.   
See also [https://aws\.amazon\.com/appstream/](https://aws.amazon.com/appstream/).

**Amazon Athena**<a name="athena"></a>  
An interactive query service that makes it easy to analyze data in Amazon S3 using ANSI SQL\. Athena is serverless, so there is no infrastructure to manage\. Athena scales automatically and is simple to use, so you can start analyzing your datasets within seconds\.   
See also [https://aws\.amazon\.com/athena/](https://aws.amazon.com/athena/).

**Amazon Aurora**<a name="aurora"></a>  
A fully managed MySQL\-compatible relational database engine that combines the speed and availability of commercial databases with the simplicity and cost\-effectiveness of open\-source databases\.   
See also [https://aws\.amazon\.com/rds/aurora/](https://aws.amazon.com/rds/aurora/).

**Amazon Chime**<a name="chime"></a>  
A secure, real\-time, unified communications service that transforms meetings by making them more efficient and easier to conduct\.   
See also [https://aws\.amazon\.com/chime/](https://aws.amazon.com/chime/).

**Amazon Cloud Directory \(Cloud Directory\)**<a name="clouddirectory"></a>  
A service that provides a highly scalable directory store for your application’s multihierarchical data\.   
See also [https://aws\.amazon\.com/cloud\-directory/](https://aws.amazon.com/cloud-directory/).

**Amazon CloudFront**<a name="AmazonCF"></a>  
An AWS content delivery service that helps you improve the performance, reliability, and availability of your websites and applications\.   
See also [https://aws\.amazon\.com/cloudfront](https://aws.amazon.com/cloudfront/).

**Amazon CloudSearch**<a name="cloudSearch"></a>  
 A fully managed service in the AWS Cloud that makes it easy to set up, manage, and scale a search solution for your website or application\. 

**Amazon CloudWatch**<a name="AmazonCW"></a>  
A web service that enables you to monitor and manage various metrics, and configure alarm actions based on data from those metrics\.   
See also [https://aws\.amazon\.com/cloudwatch](https://aws.amazon.com/cloudwatch/).

**Amazon CloudWatch Events**<a name="AmazonCWE"></a>  
A web service that enables you to deliver a timely stream of system events that describe changes in AWS [resource](#resource)s to [AWS Lambda](#lambda) functions, streams in [Amazon Kinesis Data Streams](#AmazonKinesisStreams), [Amazon Simple Notification Service](#SNS) topics, or built\-in targets\.    
See also [https://aws\.amazon\.com/cloudwatch](https://aws.amazon.com/cloudwatch/).

**Amazon CloudWatch Logs**<a name="AmazonCWL"></a>  
A web service for monitoring and troubleshooting your systems and applications from your existing system, application, and custom log files\. You can send your existing log files to CloudWatch Logs and monitor these logs in near\-real time\.   
See also [https://aws\.amazon\.com/cloudwatch](https://aws.amazon.com/cloudwatch/).

**Amazon Cognito**<a name="cognito"></a>  
A web service that makes it easy to save mobile user data, such as app preferences or game state, in the AWS Cloud without writing any backend code or managing any infrastructure\. Amazon Cognito offers mobile identity management and data synchronization across devices\.    
See also [https://aws\.amazon\.com/cognito/](https://aws.amazon.com/cognito/).

**Amazon Connect**<a name="connect"></a>  
A service solution that offers easy, self\-service configuration and enables dynamic, personal, and natural customer engagement at any scale\.   
See also [https://aws\.amazon\.com/connect/](https://aws.amazon.com/connect/).

**Amazon Corretto**<a name="AmazonCorretto"></a>  
A no\-cost, multiplatform, production\-ready distribution of the Open Java Development Kit \(OpenJDK\)\.   
See also [https://aws\.amazon\.com/corretto/](https://aws.amazon.com/corretto/).

**Amazon DocumentDB \(with MongoDB compatibility\)**<a name="documentdb"></a>  
A managed database service that you can use to set up, operate, and scale MongoDB\-compatible databases in the cloud\.   
See also [https://aws\.amazon\.com/documentdb/](https://aws.amazon.com/documentdb/).

**Amazon DynamoDB**<a name="dynamodb"></a>  
A fully managed NoSQL database service that provides fast and predictable performance with seamless scalability\.    
See also [https://aws\.amazon\.com/dynamodb/](https://aws.amazon.com/dynamodb/).

**Amazon DynamoDB Storage Backend for Titan**<a name="dynamodb-titan-backend"></a>  
A storage backend for the Titan graph database implemented on top of Amazon DynamoDB\. Titan is a scalable graph database optimized for storing and querying graphs\.   
See also [https://aws\.amazon\.com/dynamodb/](https://aws.amazon.com/dynamodb/).

**Amazon DynamoDB Streams**<a name="dynamodb-streams"></a>  
An AWS service that captures a time\-ordered sequence of item\-level modifications in any Amazon DynamoDB table, and stores this information in a log for up to 24 hours\. Applications can access this log and view the data items as they appeared before and after they were modified, in near real time\.    
See also [https://aws\.amazon\.com/dynamodb/](https://aws.amazon.com/dynamodb/).

**Amazon Elastic Block Store \(Amazon EBS\)**<a name="EBS"></a>  
A service that provides block level storage [volume](#volume)s for use with [EC2 instance](#ec2instance)s\.   
See also [https://aws\.amazon\.com/ebs](https://aws.amazon.com/ebs/).

**Amazon EBS\-backed AMI**<a name="EBSbacked"></a>  
A type of [Amazon Machine Image \(AMI\)](#AmazonMachineImage) whose [instance](#instance)s use an [Amazon EBS](#EBS) [volume](#volume) as their root device\. Compare this with instances launched from [instance store\-backed AMI](#instancebacked)s, which use the [instance store](#instancestore) as the root device\.

**Amazon Elastic Container Registry \(Amazon ECR\)**<a name="ecr"></a>  
A fully managed Docker container registry that makes it easy for developers to store, manage, and deploy Docker container images\. Amazon ECR is integrated with [Amazon Elastic Container Service \(Amazon ECS\)](#ecs) and [AWS Identity and Access Management \(IAM\)](#IAM)\.   
See also [https://aws\.amazon\.com/ecr](https://aws.amazon.com/ecr).

**Amazon Elastic Container Service \(Amazon ECS\)**<a name="ecs"></a>  
 A highly scalable, fast, [container](#container) management service that makes it easy to run, stop, and manage Docker containers on a [cluster](#cluster) of [EC2 instance](#ec2instance)s\.   
See also [https://aws\.amazon\.com/ecs](https://aws.amazon.com/ecs).

**Amazon ECS service**<a name="ecs_service"></a>  
A service for running and maintaining a specified number of [task](#task)s \(instantiations of a [task definition](#task_definition)\) simultaneously\. 

**Amazon EC2 VM Import Connector**<a name="VMimport"></a>  
See [https://aws\.amazon\.com/ec2/vm\-import](https://aws.amazon.com/ec2/vm-import/).

**Amazon Elastic Compute Cloud \(Amazon EC2\)**<a name="ec2"></a>  
A web service that enables you to launch and manage Linux/UNIX and Windows Server [instance](#instance)s in Amazon's data centers\.    
See also [https://aws\.amazon\.com/ec2](https://aws.amazon.com/ec2/).

**Amazon EC2 Auto Scaling**<a name="AutoScaling"></a>  
A web service designed to launch or terminate [instance](#instance)s automatically based on user\-defined [policies](#policy), schedules, and [health check](#healthcheck)s\.   
See also [https://aws\.amazon\.com/ec2/autoscaling](https://aws.amazon.com/ec2/autoscaling/).

**Amazon Elastic File System \(Amazon EFS\)**<a name="efs"></a>  
A file storage service for [EC2](#ec2) [instance](#instance)s\. Amazon EFS is easy to use and provides a simple interface with which you can create and configure file systems\. Amazon EFS storage capacity grows and shrinks automatically as you add and remove files\.   
See also [https://aws\.amazon\.com/efs/](https://aws.amazon.com/efs/).

**Amazon EMR \(Amazon EMR\)**<a name="AmazonElasticMapReduce"></a>  
A web service that makes it easy to process large amounts of data efficiently\. Amazon EMR uses [Hadoop](#Hadoop) processing combined with several AWS products to do such tasks as web indexing, data mining, log file analysis, machine learning, scientific simulation, and data warehousing\.    
See also [https://aws\.amazon\.com/elasticmapreduce](https://aws.amazon.com/elasticmapreduce/).

**Amazon Elastic Transcoder**<a name="elastictranscoder"></a>  
A cloud\-based media transcoding service\. Elastic Transcoder is a highly scalable tool for converting \(or *transcoding*\) media files from their source format into versions that play on devices like smartphones, tablets, and PCs\.   
See also [https://aws\.amazon\.com/elastictranscoder/](https://aws.amazon.com/elastictranscoder/).

**Amazon ElastiCache**<a name="elasticache"></a>  
A web service that simplifies deploying, operating, and scaling an in\-memory cache in the cloud\. The service improves the performance of web applications by providing information retrieval from fast, managed, in\-memory caches, instead of relying entirely on slower disk\-based databases\.   
See also [https://aws\.amazon\.com/elasticache/](https://aws.amazon.com/elasticache/).

**Amazon Elasticsearch Service \(Amazon ES\)**<a name="AmazonElasticsearchService"></a>  
An AWS managed service for deploying, operating, and scaling Elasticsearch, an open\-source search and analytics engine, in the AWS Cloud\. Amazon Elasticsearch Service \(Amazon ES\) also offers security options, high availability, data durability, and direct access to the Elasticsearch API\.   
See also [https://aws\.amazon\.com/elasticsearch\-service](https://aws.amazon.com/elasticsearch-service/).

**Amazon EventBridge**<a name="eventbridge"></a>  
A serverless event bus service that enables you to connect your applications with data from a variety of sources and routes that data to targets such as AWS Lambda\. You can set up routing rules to determine where to send your data to build application architectures that react in real time to all of your data sources\.   
See also [https://aws\.amazon\.com/eventbridge/](https://aws.amazon.com/eventbridge/).

**Amazon GameLift**<a name="gamelift"></a>  
A managed service for deploying, operating, and scaling session\-based multiplayer games\.   
See also [https://aws\.amazon\.com/gamelift/](https://aws.amazon.com/gamelift/).

**Amazon GuardDuty**<a name="guardduty"></a>  
A continuous security monitoring service\. Amazon GuardDuty can help to identify unexpected and potentially unauthorized or malicious activity in your AWS environment\.   
See also [https://aws\.amazon\.com/guardduty/](https://aws.amazon.com/guardduty/).

**Amazon Inspector**<a name="Amazon_Inspector"></a>  
An automated security assessment service that helps improve the security and compliance of applications deployed on AWS\. Amazon Inspector automatically assesses applications for vulnerabilities or deviations from best practices\. After performing an assessment, Amazon Inspector produces a detailed report with prioritized steps for remediation\.   
See also [https://aws\.amazon\.com/inspector](https://aws.amazon.com/inspector/).

**Amazon Kinesis**<a name="AmazonKinesis"></a>  
A platform for streaming data on AWS\. Kinesis offers services that simplify the loading and analysis of streaming data\.    
See also [https://aws\.amazon\.com/kinesis/](https://aws.amazon.com/kinesis/).

**Amazon Kinesis Data Firehose**<a name="AmazonKinesisFirehose"></a>  
A fully managed service for loading streaming data into AWS\. Kinesis Data Firehose can capture and automatically load streaming data into [Amazon S3](#AmazonSimpleStorageService) and [Amazon Redshift ](#redshift), enabling near real\-time analytics with existing business intelligence tools and dashboards\. Kinesis Data Firehose automatically scales to match the throughput of your data and requires no ongoing administration\. It can also batch, compress, and encrypt the data before loading it\.    
See also [https://aws\.amazon\.com/kinesis/firehose/](https://aws.amazon.com/kinesis/firehose/).

**Amazon Kinesis Data Streams**<a name="AmazonKinesisStreams"></a>  
A web service for building custom applications that process or analyze streaming data for specialized needs\. Amazon Kinesis Data Streams can continuously capture and store terabytes of data per hour from hundreds of thousands of sources\.    
See also [https://aws\.amazon\.com/kinesis/streams/](https://aws.amazon.com/kinesis/streams/).

**Amazon Lightsail**<a name="lightsail"></a>  
Lightsail is designed to be the easiest way to launch and manage a virtual private server with AWS\. Lightsail offers bundled plans that include everything you need to deploy a virtual private server, for a low monthly rate\.   
See also [https://aws\.amazon\.com/lightsail/](https://aws.amazon.com/lightsail/).

**Amazon Lumberyard**<a name="lumberyard"></a>  
A cross\-platform, 3D game engine for creating high\-quality games\. You can connect games to the compute and storage of the AWS Cloud and engage fans on Twitch\.   
See also [https://aws\.amazon\.com/lumberyard/](https://aws.amazon.com/lumberyard/).

**Amazon Machine Image \(AMI\)**<a name="AmazonMachineImage"></a>  
An encrypted machine image stored in [Amazon Elastic Block Store \(Amazon EBS\)](#EBS) or [Amazon Simple Storage Service](#AmazonSimpleStorageService)\. AMIs are like a template of a computer's root drive\. They contain the operating system and can also include software and layers of your application, such as database servers, middleware, web servers, and so on\. 

**Amazon Machine Learning**<a name="machine-learning"></a>  
A cloud\-based service that creates machine learning \(ML\) models by finding patterns in your data, and uses these models to process new data and generate predictions\.   
See also [http://aws\.amazon\.com/machine\-learning/](http://aws.amazon.com/machine-learning/).

**Amazon Macie**<a name="macie"></a>  
A security service that uses machine learning to automatically discover, classify, and protect sensitive data in AWS\.   
See also [http://aws\.amazon\.com/macie/](http://aws.amazon.com/macie/).

**Amazon Managed Blockchain**<a name="managed-blockchain"></a>  
A fully managed service for creating and managing scalable blockchain networks using popular open source frameworks\.   
See also [http://aws\.amazon\.com/managed\-blockchain/](http://aws.amazon.com/managed-blockchain/).

**Amazon ML**   
See [Amazon Machine Learning](#machine-learning).

**Amazon Mobile Analytics**<a name="AmazonMobileAnalytics"></a>  
A service for collecting, visualizing, understanding, and extracting mobile app usage data at scale\.   
See also [https://aws\.amazon\.com/mobileanalytics](https://aws.amazon.com/mobileanalytics/).

**Amazon MQ**<a name="AmazonMQ"></a>  
A managed message broker service for Apache ActiveMQ that makes it easy to set up and operate message brokers in the cloud\.   
See also [https://aws\.amazon\.com/amazon\-mq/](https://aws.amazon.com/amazon-mq/).

**Amazon Neptune**<a name="neptune"></a>  
A managed graph database service that you can use to build and run applications that work with highly connected datasets\. Neptune supports the popular graph query languages Apache TinkerPop Gremlin and W3C’s SPARQL, enabling you to build queries that efficiently navigate highly connected datasets\.   
See also [https://aws\.amazon\.com/neptune/](https://aws.amazon.com/neptune/).

**Amazon QuickSight**<a name="quicksight"></a>  
A fast, cloud\-powered business analytics service that makes it easy to build visualizations, perform analysis, and quickly get business insights from your data\.    
See also [https://aws\.amazon\.com/quicksight/](https://aws.amazon.com/quicksight/).

**Amazon Redshift**<a name="redshift"></a>  
A fully managed, petabyte\-scale data warehouse service in the cloud\. With Amazon Redshift, you can analyze your data using your existing business intelligence tools\.   
See also [https://aws\.amazon\.com/redshift/](https://aws.amazon.com/redshift/).

**Amazon Relational Database Service \(Amazon RDS\)**<a name="AmazonRelationalDatabaseService"></a>  
A web service that makes it easier to set up, operate, and scale a relational database in the cloud\. It provides cost\-efficient, resizable capacity for an industry\-standard relational database and manages common database administration tasks\.   
See also [https://aws\.amazon\.com/rds](https://aws.amazon.com/rds/).

**Amazon Resource Name \(ARN\)**<a name="ARN"></a>  
A standardized way to refer to an AWS [resource](#resource)\. For example: arn:aws:iam::123456789012:user/division\_abc/subdivision\_xyz/Bob\.

**Amazon Route 53**<a name="Route53"></a>  
A web service you can use to create a new DNS service or to migrate your existing DNS service to the cloud\.   
See also [https://aws\.amazon\.com/route53](https://aws.amazon.com/route53/).

**Amazon S3**   
See [Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService).

**Amazon S3\-Backed AMI**<a name="s3backed"></a>   
See [instance store\-backed AMI](#instancebacked).

**Amazon S3 Glacier**<a name="glacier"></a>  
A secure, durable, and low\-cost storage service for data archiving and long\-term backup\. You can reliably store large or small amounts of data for significantly less than on\-premises solutions\. Glacier is optimized for infrequently accessed data, where a retrieval time of several hours is suitable\.   
See also [https://aws\.amazon\.com/glacier/](https://aws.amazon.com/glacier/).

**AWS Security Hub**<a name="securityhub"></a>  
A service that provides a comprehensive view of the security state of your AWS resources\. Security Hub collects security data from AWS accounts and services and helps you analyze your security trends to identify and prioritize the security issues across your AWS environment\.   
See also [https://aws\.amazon\.com/security\-hub/](https://aws.amazon.com/security-hub/).

**Amazon Silk**<a name="silk"></a>  
A next\-generation web browser available only on Fire OS tablets and phones\. Built on a split architecture that divides processing between the client and the AWS Cloud, Amazon Silk is designed to create a faster, more responsive mobile browsing experience\.

**Amazon Simple Email Service \(Amazon SES\)**<a name="SES"></a>  
An easy\-to\-use, cost\-effective email solution for applications\.    
See also [https://aws\.amazon\.com/ses](https://aws.amazon.com/ses/).

**Amazon Simple Notification Service \(Amazon SNS\)**<a name="SNS"></a>  
A web service that enables applications, users, and devices to instantly send and receive notifications from the cloud\.   
See also [https://aws\.amazon\.com/sns](https://aws.amazon.com/sns/).

**Amazon Simple Queue Service \(Amazon SQS\)**<a name="AmazonSimpleQueueService"></a>  
Reliable and scalable hosted queues for storing messages as they travel between computers\.    
See also [https://aws\.amazon\.com/sqs](https://aws.amazon.com/sqs/).

**Amazon Simple Storage Service \(Amazon S3\)**<a name="AmazonSimpleStorageService"></a>  
Storage for the internet\. You can use it to store and retrieve any amount of data at any time, from anywhere on the web\.   
See also [https://aws\.amazon\.com/s3](https://aws.amazon.com/s3/).

**Amazon Simple Workflow Service \(Amazon SWF\)**<a name="swf"></a>  
A fully managed service that helps developers build, run, and scale background jobs that have parallel or sequential steps\. Amazon SWF is like a state tracker and task coordinator in the cloud\.   
See also [https://aws\.amazon\.com/swf/](https://aws.amazon.com/swf/).

**Amazon Sumerian**<a name="AmazonSumerian"></a>  
A set of tools for creating and running high\-quality 3D, augmented reality \(AR\), and virtual reality \(VR\) applications on the web\.   
See also [https://aws\.amazon\.com/sumerian/](https://aws.amazon.com/sumerian/).

**Amazon Textract**<a name="AmazonTextract"></a>  
A service that automatically extracts text and data from scanned documents\. Amazon Textract goes beyond simple optical character recognition \(OCR\) to also identify the contents of fields in forms and information stored in tables\.   
See also [https://aws\.amazon\.com/textract/](https://aws.amazon.com/textract/).

**Amazon Virtual Private Cloud \(Amazon VPC\)**<a name="AmazonVirtualPrivateCloud"></a>  
A web service for provisioning a logically isolated section of the AWS Cloud where you can launch AWS [resource](#resource)s in a virtual network that you define\. You control your virtual networking environment, including selection of your own IP address range, creation of [subnet](#subnet)s, and configuration of [route table](#routetable)s and network gateways\.   
See also [https://aws\.amazon\.com/vpc](https://aws.amazon.com/vpc/).

**Amazon VPC**   
See [Amazon Virtual Private Cloud \(Amazon VPC\)](#AmazonVirtualPrivateCloud).

**Amazon Web Services \(AWS\)**<a name="amazonwebservices"></a>  
An infrastructure web services platform in the cloud for companies of all sizes\.   
See also [https://aws\.amazon\.com/what\-is\-cloud\-computing/](https://aws.amazon.com/what-is-cloud-computing/).

**Amazon WorkDocs**<a name="workdocs"></a>  
A managed, secure enterprise document storage and sharing service with administrative controls and feedback capabilities\.   
See also [https://aws\.amazon\.com/workdocs/](https://aws.amazon.com/workdocs/).

**Amazon WorkLink**<a name="worklink"></a>  
A cloud\-based service that provides secure access to internal websites and web apps from mobile devices\.   
See also [https://aws\.amazon\.com/worklink/](https://aws.amazon.com/worklink/).

**Amazon WorkMail**<a name="workmail"></a>  
A managed, secure business email and calendar service with support for existing desktop and mobile email clients\.    
See also [https://aws\.amazon\.com/workmail/](https://aws.amazon.com/workmail/).

**Amazon WorkSpaces**<a name="workspaces"></a>  
A managed, secure desktop computing service for provisioning cloud\-based desktops and providing users access to documents, applications, and [resource](#resource)s from supported devices\.   
See also [https://aws\.amazon\.com/workspaces/](https://aws.amazon.com/workspaces/).

**Amazon WorkSpaces Application Manager \(Amazon WAM\)**<a name="wam"></a>  
A web service for deploying and managing applications for Amazon WorkSpaces\. Amazon WAM accelerates software deployment, upgrades, patching, and retirement by packaging Windows desktop applications into virtualized application containers\.    
See also [https://aws\.amazon\.com/workspaces/applicationmanager](https://aws.amazon.com/workspaces/applicationmanager).

**AMI**   
See [Amazon Machine Image \(AMI\)](#AmazonMachineImage).

**analysis scheme**<a name="analysisscheme"></a>  
[Amazon CloudSearch](#cloudSearch): Language\-specific text analysis options that are applied to a text field to control stemming and configure stopwords and synonyms\. 

**application**<a name="application"></a>  
[AWS Elastic Beanstalk](#Beanstalk): A logical collection of components, including environments, versions, and environment configurations\. An application is conceptually similar to a folder\.  
[AWS CodeDeploy](#AWSCodeDeploy): A name that uniquely identifies the application to be deployed\. AWS CodeDeploy uses this name to ensure the correct combination of revision, deployment configuration, and deployment group are referenced during a deployment\.

**Application Auto Scaling**<a name="ApplicationAutoScaling"></a>  
A web service that enables you to configure automatic scaling for AWS resources beyond Amazon EC2, such as Amazon ECS services, Amazon EMR clusters, and DynamoDB tables\.   
See also [https://aws\.amazon\.com/autoscaling/](https://aws.amazon.com/autoscaling/).

**Application Billing**<a name="AppBilling"></a>  
The location where your customers manage the Amazon DevPay products they've purchased\. The web address is [http://www\.amazon\.com/dp\-applications](http://www.amazon.com/dp-applications)\.

**application revision**<a name="applicationrevision"></a>  
[AWS CodeDeploy](#AWSCodeDeploy): An archive file containing source content—such as source code, webpages, executable files, and deployment scripts—along with an [application specification file](#applicationspecificationfile)\. Revisions are stored in [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket)s or [GitHub](#github) repositories\. For Amazon S3, a revision is uniquely identified by its Amazon S3 object key and its ETag, version, or both\. For GitHub, a revision is uniquely identified by its commit ID\.

**application specification file**<a name="applicationspecificationfile"></a>  
[AWS CodeDeploy](#AWSCodeDeploy): A YAML\-formatted file used to map the source files in an application revision to destinations on the instance\. The file is also used to specify custom permissions for deployed files and specify scripts to be run on each instance at various stages of the deployment process\.

**application version**<a name="appversion"></a>  
[AWS Elastic Beanstalk](#Beanstalk): A specific, labeled iteration of an application that represents a functionally consistent set of deployable application code\. A version points to an [Amazon S3](#AmazonSimpleStorageService) object \(a JAVA WAR file\) that contains the application code\. 

**AppSpec file**   
See [application specification file](#applicationspecificationfile).

**AUC**<a name="AUC"></a>  
Area Under a Curve\. An industry\-standard metric to evaluate the quality of a binary classification machine learning model\. AUC measures the ability of the model to predict a higher score for positive examples, those that are “correct,” than for negative examples, those that are “incorrect\.” The AUC metric returns a decimal value from 0 to 1\. AUC values near 1 indicate an ML model that is highly accurate\.

**ARN**   
See [Amazon Resource Name \(ARN\)](#ARN).

**artifact**<a name="artifact"></a>  
[AWS CodePipeline](#AWSCodePipeline): A copy of the files or changes that will be worked upon by the pipeline\. 

**asymmetric encryption**<a name="asymmetric_encryption"></a>  
 [Encryption](#encrypt) that uses both a public key and a private key\.

**asynchronous bounce**<a name="asynchronousbounce"></a>  
A type of [bounce](#bounce) that occurs when a [receiver](#receiver) initially accepts an email message for delivery and then subsequently fails to deliver it\.

**atomic counter**<a name="atomic-counter"></a>  
DynamoDB: A method of incrementing or decrementing the value of an existing attribute without interfering with other write requests\.

**attribute**<a name="attribute"></a>  
A fundamental data element, something that does not need to be broken down any further\. In DynamoDB, attributes are similar in many ways to fields or columns in other database systems\.  
 Amazon Machine Learning: A unique, named property within an observation in a dataset\. In tabular data, such as spreadsheets or comma\-separated values \(\.csv\) files, the column headings represent the attributes, and the rows contain values for each attribute\.

**Aurora**   
See [Amazon Aurora](#aurora).

**authenticated encryption**<a name="authenticated_encryption"></a>  
[Encryption](#encrypt) that provides confidentiality, data integrity, and authenticity assurances of the encrypted data\.

**authentication**<a name="authentication"></a>  
The process of proving your identity to a system\.

**Auto Scaling group**<a name="AutoScalingGroup"></a>  
A representation of multiple [EC2 instance](#ec2instance)s that share similar characteristics, and that are treated as a logical grouping for the purposes of instance scaling and management\.

**Availability Zone**<a name="AZ"></a>  
A distinct location within a [Region](#region) that is insulated from failures in other Availability Zones, and provides inexpensive, low\-latency network connectivity to other Availability Zones in the same Region\.

**AWS**   
See [Amazon Web Services \(AWS\)](#amazonwebservices).

**AWS Application Discovery Service**<a name="ApplicationDiscoveryService"></a>  
A web service that helps you plan to migrate to AWS by identifying IT assets in a data center—including servers, virtual machines, applications, application dependencies, and network infrastructure\.    
See also [https://aws\.amazon\.com/about\-aws/whats\-new/2016/04/aws\-application\-discovery\-service/](https://aws.amazon.com/about-aws/whats-new/2016/04/aws-application-discovery-service/).

**AWS AppSync**<a name="AWSAppSync"></a>  
An enterprise level, fully managed GraphQL service with real\-time data synchronization and offline programming features\.   
See also [https://aws\.amazon\.com/appsync/](https://aws.amazon.com/appsync/).

**AWS Auto Scaling**<a name="AWSAutoScaling"></a>  
A fully managed service that enables you to quickly discover the scalable AWS resources that are part of your application and configure dynamic scaling\.   
See also [https://aws\.amazon\.com/autoscaling/](https://aws.amazon.com/autoscaling/).

**AWS Backup**<a name="awsbackup"></a>  
A managed backup service that you can use to centralize and automate the backup of data across AWS services in the cloud and on premises\.   
See also [https://aws\.amazon\.com/backup/](https://aws.amazon.com/backup/).

**AWS Billing and Cost Management**<a name="billing"></a>  
The AWS Cloud computing model in which you pay for services on demand and use as much or as little as you need\. While [resource](#resource)s are active under your account, you pay for the cost of allocating those resources\. You also pay for any incidental usage associated with those resources, such as data transfer or allocated storage\.   
See also [https://aws\.amazon\.com/billing/new\-user\-faqs/](https://aws.amazon.com/billing/new-user-faqs/).

**AWS Blockchain Templates**<a name="blockchain-templates"></a>  
A service for creating and deploying open\-source blockchain frameworks on AWS, such as Ethereum and Hyperledger Fabric\.   
See also [https://aws\.amazon\.com/blockchain/templates/](https://aws.amazon.com/blockchain/templates/).

**AWS Certificate Manager \(ACM\)**<a name="acm"></a>  
A web service for provisioning, managing, and deploying Secure Sockets Layer/[Transport Layer Security](#transportlayersecurity) \(SSL/TLS\) certificates for use with AWS services\.   
See also [https://aws\.amazon\.com/certificate\-manager/](https://aws.amazon.com/certificate-manager/).

**AWS Certificate Manager Private Certificate Authority \(ACM PCA\)**<a name="acm-pca"></a>  
A hosted private certificate authority service for issuing and revoking private digital [certificate](#certificate)s\.   
See also [https://aws\.amazon\.com/certificate\-manager/private\-certificate\-authority/](https://aws.amazon.com/certificate-manager/private-certificate-authority/).

**AWS Cloud Development Kit \(AWS CDK\)**<a name="AWSCDK"></a>  
An open\-source software development framework for defining your cloud infrastructure in code and provisioning it through AWS CloudFormation\.   
See also [https://aws\.amazon\.com/cdk/](https://aws.amazon.com/cdk/).

**AWS Cloud Map**<a name="cloudmap"></a>  
A service that you use to create and maintain a map of the backend services and resources that your applications depend on\. AWS Cloud Map lets you name and discover your cloud resources\.   
See also [https://aws\.amazon\.com/cloud\-map](https://aws.amazon.com/cloud-map).

**AWS Cloud9**<a name="AWSCloud9"></a>  
A cloud\-based integrated development environment \(IDE\) that you use to write, run, and debug code\.   
See also [https://aws\.amazon\.com/cloud9/](https://aws.amazon.com/cloud9/).

**AWS CloudFormation**<a name="CloudFormation"></a>  
A service for writing or changing templates that create and delete related AWS [resource](#resource)s together as a unit\.   
See also [https://aws\.amazon\.com/cloudformation](https://aws.amazon.com/cloudformation/).

**AWS CloudHSM**<a name="cloudhsm"></a>  
A web service that helps you meet corporate, contractual, and regulatory compliance requirements for data security by using dedicated hardware security module \(HSM\) appliances within the AWS Cloud\.   
See also [https://aws\.amazon\.com/cloudhsm/](https://aws.amazon.com/cloudhsm/).

**AWS CloudTrail**<a name="cloudtrail"></a>  
A web service that records AWS API calls for your account and delivers log files to you\. The recorded information includes the identity of the API caller, the time of the API call, the source IP address of the API caller, the request parameters, and the response elements returned by the AWS service\.   
See also [https://aws\.amazon\.com/cloudtrail/](https://aws.amazon.com/cloudtrail/).

**AWS CodeBuild**<a name="AWSCodeBuild"></a>  
A fully managed continuous integration service that compiles source code, runs tests, and produces software packages that are ready to deploy\.   
See also [https://aws\.amazon\.com/codebuild](https://aws.amazon.com/codebuild/).

**AWS CodeCommit**<a name="AWSCodeCommit"></a>  
A fully managed source control service that makes it easy for companies to host secure and highly scalable private Git repositories\.   
See also [https://aws\.amazon\.com/codecommit](https://aws.amazon.com/codecommit/).

**AWS CodeDeploy**<a name="AWSCodeDeploy"></a>  
A service that automates code deployments to any instance, including [EC2 instance](#ec2instance)s and [instance](#instance)s running on\-premises\.   
See also [https://aws\.amazon\.com/codedeploy](https://aws.amazon.com/codedeploy/).

**AWS CodeDeploy agent**<a name="AWSCodeDeployagent"></a>  
A software package that, when installed and configured on an instance, enables that instance to be used in CodeDeploy deployments\.

**AWS CodePipeline**<a name="AWSCodePipeline"></a>  
A continuous delivery service for fast and reliable application updates\.   
See also [https://aws\.amazon\.com/codepipeline](https://aws.amazon.com/codepipeline/).

**AWS Command Line Interface \(AWS CLI\)**<a name="awscli"></a>  
A unified downloadable and configurable tool for managing AWS services\. Control multiple AWS services from the command line and automate them through scripts\.   
See also [https://aws\.amazon\.com/cli/](https://aws.amazon.com/cli/).

**AWS Config**<a name="config"></a>  
A fully managed service that provides an AWS [resource](#resource) inventory, configuration history, and configuration change notifications for better security and governance\. You can create rules that automatically check the configuration of AWS resources that AWS Config records\.   
See also [https://aws\.amazon\.com/config/](https://aws.amazon.com/config/).

**AWS Database Migration Service**<a name="AWSDatabaseMigrationService"></a>  
A web service that can help you migrate data to and from many widely used commercial and open\-source databases\.   
See also [https://aws\.amazon\.com/dms](https://aws.amazon.com/dms).

**AWS Data Pipeline**<a name="AmazonDataPipeline"></a>  
A web service for processing and moving data between different AWS compute and storage services, as well as on\-premises data sources, at specified intervals\.   
See also [https://aws\.amazon\.com/datapipeline](https://aws.amazon.com/datapipeline).

**AWS Device Farm**<a name="AWSDeviceFarm"></a>  
An app testing service that allows developers to test Android, iOS, and Fire OS devices on real, physical phones and tablets that are hosted by AWS\.   
See also [https://aws\.amazon\.com/device\-farm](https://aws.amazon.com/device-farm/).

**AWS Direct Connect**<a name="AWSDirectConnect"></a>  
A web service that simplifies establishing a dedicated network connection from your premises to AWS\. Using AWS Direct Connect, you can establish private connectivity between AWS and your data center, office, or colocation environment\.   
See also [ https://aws\.amazon\.com/directconnect](https://aws.amazon.com/directconnect/).

**AWS Directory Service**<a name="AWSDirectoryService"></a>  
A managed service for connecting your AWS [resource](#resource)s to an existing on\-premises Microsoft Active Directory or to set up and operate a new, standalone directory in the AWS Cloud\.   
See also [ https://aws\.amazon\.com/directoryservice](https://aws.amazon.com/directoryservice/).

**AWS Elastic Beanstalk**<a name="Beanstalk"></a>  
A web service for deploying and managing applications in the AWS Cloud without worrying about the infrastructure that runs those applications\.   
See also [https://aws\.amazon\.com/elasticbeanstalk](https://aws.amazon.com/elasticbeanstalk/).

**AWS Elemental MediaConnect**<a name="mediaconnect"></a>  
A service that lets broadcasters and other premium video providers reliably ingest live video into the AWS Cloud and distribute it to multiple destinations inside or outside the AWS Cloud\.   
See also [https://aws\.amazon\.com/mediaconnect](https://aws.amazon.com/mediaconnect/).

**AWS Elemental MediaConvert**<a name="AWSElementalMediaConvert"></a>  
A file\-based video conversion service that transforms media into formats required for traditional broadcast and for internet streaming to multi\-screen devices\.   
See also [https://aws\.amazon\.com/mediaconvert](https://aws.amazon.com/mediaconvert).

**AWS Elemental MediaLive**<a name="AWSElementalMediaLive"></a>  
A video service that lets you create live outputs for broadcast and streaming delivery\.   
See also [https://aws\.amazon\.com/medialive](https://aws.amazon.com/medialive).

**AWS Elemental MediaPackage**<a name="AWSElementalMediaPackage"></a>  
A just\-in\-time packaging and origination service that lets you format highly secure and reliable live outputs for a variety of devices\.   
See also [https://aws\.amazon\.com/mediapackage](https://aws.amazon.com/mediapackage).

**AWS Elemental MediaStore**<a name="AWSElementalMediaStore"></a>  
A storage service optimized for media that provides the performance, consistency, and low latency required to deliver live and on\-demand video content at scale\.   
See also [https://aws\.amazon\.com/mediastore](https://aws.amazon.com/mediastore).

**AWS Elemental MediaTailor**<a name="AWSElementalMediaTailor"></a>  
A video service that lets you serve targeted ads to viewers while maintaining broadcast quality in over\-the\-top \(OTT\) video applications\.   
See also [https://aws\.amazon\.com/mediatailor](https://aws.amazon.com/mediatailor).

**AWS Firewall Manager**<a name="firewallmanager"></a>  
A service that you use with AWS WAF to simplify your AWS WAF administration and maintenance tasks across multiple accounts and resources\. With AWS Firewall Manager, you set up your firewall rules just once\. The service automatically applies your rules across your accounts and resources, even as you add new resources\.   
See also [https://aws\.amazon\.com/firewall\-manager](https://aws.amazon.com/firewall-manager/).

**AWS Global Accelerator**<a name="globalaccelerator"></a>  
A network layer service that you use to create accelerators that direct traffic to optimal endpoints over the AWS global network\. This improves the availability and performance of your internet applications that are used by a global audience\.   
See also [https://aws\.amazon\.com/global\-accelerator](https://aws.amazon.com/global-accelerator/).

**AWS Glue**<a name="Glue"></a>  
A fully managed [extract, transform, and load \(ETL\)](#extracttransformload) service that you can use to catalog data and load it for analytics\. With AWS Glue, you can discover your data, develop scripts to transform sources into targets, and schedule and run ETL jobs in a serverless environment\.   
See also [https://aws\.amazon\.com/glue](https://aws.amazon.com/glue/).

**AWS GovCloud \(US\)**<a name="govcloud-us"></a>  
An isolated AWS Region designed to host sensitive workloads in the cloud, ensuring that this work meets the US government's regulatory and compliance requirements\. The AWS GovCloud \(US\) Region adheres to United States International Traffic in Arms Regulations \(ITAR\), Federal Risk and Authorization Management Program \(FedRAMP\) requirements, Department of Defense \(DOD\) Cloud Security Requirements Guide \(SRG\) Levels 2 and 4, and Criminal Justice Information Services \(CJIS\) Security Policy requirements\.   
See also [https://aws\.amazon\.com/govcloud\-us/](https://aws.amazon.com/govcloud-us/).

**AWS Identity and Access Management \(IAM\)**<a name="IAM"></a>  
A web service that enables [Amazon Web Services \(AWS\)](#amazonwebservices) customers to manage users and user permissions within AWS\.   
See also [https://aws\.amazon\.com/iam](https://aws.amazon.com/iam/).

**AWS Import/Export**<a name="AWSImportExport"></a>  
A service for transferring large amounts of data between AWS and portable storage devices\.    
See also [https://aws\.amazon\.com/importexport](https://aws.amazon.com/importexport/).

**AWS IoT Core**<a name="AWSIoT"></a>  
A managed cloud platform that lets connected devices easily and securely interact with cloud applications and other devices\.   
See also [https://aws\.amazon\.com/iot](https://aws.amazon.com/iot/).

**AWS IoT 1\-Click**<a name="AWSIoTOneClick"></a>  
A service that enables simple devices to trigger AWS Lambda functions that can execute an action\.   
See also [https://aws\.amazon\.com/iot\-1\-click](https://aws.amazon.com/iot-1-click/).

**AWS IoT Analytics**<a name="AWSIoTAnalytics"></a>  
A fully managed service used to run sophisticated analytics on massive volumes of IoT data\.   
See also [https://aws\.amazon\.com/iot\-analytics](https://aws.amazon.com/iot-analytics/).

**AWS IoT Device Defender**<a name="AWSIoTDeviceDefender"></a>  
An AWS IoT security service that allows you to audit the configuration of your devices, monitor your connected devices to detect abnormal behavior, and to mitigate security risks\.   
See also [https://aws\.amazon\.com/iot\-device\-defender](https://aws.amazon.com/iot-device-defender/).

**AWS IoT Device Management**<a name="AWSIoTDeviceManagement"></a>  
A service used to securely onboard, organize, monitor, and remotely manage IoT devices at scale\.   
See also [https://aws\.amazon\.com/iot\-device\-management](https://aws.amazon.com/iot-device-management/).

**AWS IoT Events**<a name="AWSIoTEvents"></a>  
A fully managed AWS IoT service that makes it easy to detect and respond to events from IoT sensors and applications\.   
See also [https://aws\.amazon\.com/iot\-events](https://aws.amazon.com/iot-events/).

**AWS IoT Greengrass**<a name="Greengrass"></a>  
Software that lets you run local compute, messaging, data caching, sync, and ML inference capabilities for connected devices in a secure way\.   
See also [https://aws\.amazon\.com/greengrass](https://aws.amazon.com/greengrass/).

**AWS IoT Things Graph**<a name="AWSIoTThingsGraph"></a>  
A service that makes it easy to visually connect different devices and web services to build IoT applications\.   
See also [https://aws\.amazon\.com/iot\-things\-graph](https://aws.amazon.com/iot-things-graph/).

**AWS Key Management Service \(AWS KMS\)**<a name="AWS_KMS"></a>  
A managed service that simplifies the creation and control of [encryption](#encrypt) keys that are used to encrypt data\.   
See also [ https://aws\.amazon\.com/kms](https://aws.amazon.com/kms/).

**AWS Lambda**<a name="lambda"></a>  
A web service that lets you run code without provisioning or managing servers\. You can run code for virtually any type of application or backend service with zero administration\. You can set up your code to automatically trigger from other AWS services or call it directly from any web or mobile app\.   
See also [https://aws\.amazon\.com/lambda/](https://aws.amazon.com/lambda/).

**AWS managed key**<a name="AWS_managed_key"></a>  
One type of [customer master key \(CMK\)](#customer_master_key) in [AWS Key Management Service \(AWS KMS\)](#AWS_KMS)\. 

**AWS managed policy**<a name="AWS_managed_policy"></a>  
An [IAM](#IAM) [managed policy](#managed_policy) that is created and managed by AWS\.

**AWS Management Console**<a name="AWSManagementConsole"></a>  
A graphical interface to manage compute, storage, and other cloud [resource](#resource)s\.   
See also [https://aws\.amazon\.com/console](https://aws.amazon.com/console/).

**AWS Management Portal for vCenter**<a name="mgtportal"></a>  
A web service for managing your AWS [resource](#resource)s using VMware vCenter\. You install the portal as a vCenter plugin within your existing vCenter environment\. Once installed, you can migrate VMware VMs to [Amazon EC2](#ec2) and manage AWS resources from within vCenter\.   
See also [https://aws\.amazon\.com/ec2/vcenter\-portal/](https://aws.amazon.com/ec2/vcenter-portal/).

**AWS Marketplace**<a name="marketplace"></a>  
A web portal where qualified partners market and sell their software to AWS customers\. AWS Marketplace is an online software store that helps customers find, buy, and immediately start using the software and services that run on AWS\.   
See also [https://aws\.amazon\.com/partners/aws\-marketplace/](https://aws.amazon.com/partners/aws-marketplace/).

**AWS Mobile Hub**<a name="AWSMobileHub"></a>  
An integrated console that for building, testing, and monitoring mobile apps\.   
See also [https://aws\.amazon\.com/mobile](https://aws.amazon.com/console/).

**AWS Mobile SDK**<a name="mobilesdk"></a>  
A software development kit whose libraries, code examples, and documentation help you build high quality mobile apps for the iOS, Android, Fire OS, Unity, and Xamarin platforms\.   
See also [https://aws\.amazon\.com/mobile/sdk](https://aws.amazon.com/mobile/sdk).

**AWS OpsWorks**<a name="opsworks"></a>  
A configuration management service that helps you use Chef to configure and operate groups of instances and applications\. You can define the application’s architecture and the specification of each component including package installation, software configuration, and [resource](#resource)s such as storage\. You can automate tasks based on time, load, lifecycle events, and more\.   
See also [https://aws\.amazon\.com/opsworks/](https://aws.amazon.com/opsworks/).

**AWS Organizations**<a name="awsorganizations"></a>  
An account management service that enables you to consolidate multiple AWS accounts into an organization that you create and centrally manage\.    
See also [https://aws\.amazon\.com/organizations/](https://aws.amazon.com/organizations/).

**AWS Resource Access Manager**<a name="awsram"></a>  
A service that lets you share your resources with any AWS account or organization in AWS Organizations\.   
See also [https://aws\.amazon\.com/ram/](https://aws.amazon.com/ram/).

**AWS ParallelCluster**<a name="parallelcluster"></a>  
An AWS supported open source cluster management tool that helps you to deploy and manage high performance computing \(HPC\) clusters in the AWS Cloud\.

**AWS SDK for C\+\+**<a name="sdkcpp"></a>  
A software development kit for that provides C\+\+ APIs for many AWS services including [Amazon S3](#AmazonSimpleStorageService), [Amazon EC2](#ec2), [Amazon DynamoDB](#dynamodb), and more\. The single, downloadable package includes the AWS C\+\+ library, code examples, and documentation\.   
See also [https://aws\.amazon\.com/sdk\-for\-cpp/](https://aws.amazon.com/sdk-for-cpp/).

**AWS SDK for Go**<a name="sdkgo"></a>  
A software development kit for integrating your Go application with the full suite of AWS services\.   
See also [https://aws\.amazon\.com/sdk\-for\-go/](https://aws.amazon.com/sdk-for-go/).

**AWS SDK for Java**<a name="sdkjava"></a>  
A software development kit that provides Java APIs for many AWS services including [Amazon S3](#AmazonSimpleStorageService), [Amazon EC2](#ec2), [Amazon DynamoDB](#dynamodb), and more\. The single, downloadable package includes the AWS Java library, code examples, and documentation\.    
See also [https://aws\.amazon\.com/sdk\-for\-java/](https://aws.amazon.com/sdk-for-java/).

**AWS SDK for JavaScript in the Browser**<a name="sdkjavabrowser"></a>  
A software development kit for accessing AWS services from JavaScript code running in the browser\. Authenticate users through Facebook, Google, or Login with Amazon using web identity federation\. Store application data in [Amazon DynamoDB](#dynamodb), and save user files to [Amazon S3](#AmazonSimpleStorageService)\.   
See also [https://docs\.aws\.amazon\.com/sdk\-for\-javascript/v2/developer\-guide/](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/).

**AWS SDK for JavaScript in Node\.js**<a name="sdkjavanodejs"></a>  
A software development kit for accessing AWS services from JavaScript in Node\.js\. The SDK provides JavaScript objects for AWS services, including [Amazon S3](#AmazonSimpleStorageService), [Amazon EC2](#ec2), [Amazon DynamoDB](#dynamodb), and [Amazon Simple Workflow Service \(Amazon SWF\)](#swf) \. The single, downloadable package includes the AWS JavaScript library and documentation\.   
See also [https://docs\.aws\.amazon\.com/sdk\-for\-javascript/v2/developer\-guide/](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/).

**AWS SDK for \.NET**<a name="sdkdotnet"></a>  
A software development kit that provides \.NET API actions for AWS services including [Amazon S3](#AmazonSimpleStorageService), [Amazon EC2](#ec2), [IAM](#IAM), and more\. You can download the SDK as multiple service\-specific packages on NuGet\.   
See also [https://aws\.amazon\.com/sdk\-for\-net/](https://aws.amazon.com/sdk-for-net/).

**AWS SDK for PHP**<a name="sdkphp"></a>  
A software development kit and open\-source PHP library for integrating your PHP application with AWS services like [Amazon S3](#AmazonSimpleStorageService), [Amazon S3 Glacier](#glacier), and [Amazon DynamoDB](#dynamodb)\.   
See also [https://aws\.amazon\.com/sdk\-for\-php/](https://aws.amazon.com/sdk-for-php/).

**AWS SDK for Python \(Boto\)**<a name="sdkpython"></a>  
A software development kit for using Python to access AWS services like [Amazon EC2](#ec2), [Amazon EMR](#AmazonElasticMapReduce), [Amazon EC2 Auto Scaling](#AutoScaling), [Amazon Kinesis](#AmazonKinesis), [AWS Lambda](#lambda), and more\.   
See also [http://boto\.readthedocs\.org/en/latest/](http://boto.readthedocs.org/en/latest/).

**AWS SDK for Ruby**<a name="sdkruby"></a>  
A software development kit for accessing AWS services from Ruby\. The SDK provides Ruby classes for many AWS services including [Amazon S3](#AmazonSimpleStorageService), [Amazon EC2](#ec2), [Amazon DynamoDB](#dynamodb)\. and more\. The single, downloadable package includes the AWS Ruby Library and documentation\.   
See also [https://aws\.amazon\.com/sdk\-for\-ruby/](https://aws.amazon.com/sdk-for-ruby/).

**AWS Security Token Service \(AWS STS\)**<a name="STS"></a>  
A web service for requesting temporary, limited\-privilege credentials for [AWS Identity and Access Management \(IAM\)](#IAM) users or for users that you authenticate \([federated users](#fed_identity)\)\.   
See also [https://aws\.amazon\.com/iam/](https://aws.amazon.com/iam/).

**AWS Service Catalog**<a name="servicecatalog"></a>  
A web service that helps organizations create and manage catalogs of IT services that are approved for use on AWS\. These IT services can include everything from virtual machine images, servers, software, and databases to complete multitier application architectures\.   
See also [https://aws\.amazon\.com/servicecatalog/](https://aws.amazon.com/servicecatalog/).

**AWS Shield**<a name="shield"></a>  
A service that helps to protect your resources—such as Amazon EC2 instances, Elastic Load Balancing load balancers, Amazon CloudFront distributions, and Route 53 hosted zones—against DDoS attacks\. AWS Shield is automatically included at no extra cost beyond what you already pay for AWS WAF and your other AWS services\. For added protection against DDoS attacks, AWS offers AWS Shield Advanced\.    
See also [https://aws\.amazon\.com/shield](https://aws.amazon.com/shield/).

**AWS Single Sign\-On**<a name="aws-sso"></a>  
A cloud\-based service that simplifies managing SSO access to AWS accounts and business applications\. You can control SSO access and user permissions across all your AWS accounts in AWS Organizations\.   
See also [https://aws\.amazon\.com/single\-sign\-on/](https://aws.amazon.com/single-sign-on/).

**AWS Step Functions**<a name="AWSStepFunctions"></a>  
A web service that coordinates the components of distributed applications as a series of steps in a visual workflow\.   
See also [https://aws\.amazon\.com/step\-functions/](https://aws.amazon.com/step-functions/).

**AWS Snowball**<a name="snowball"></a>  
A petabyte\-scale data transport solution that uses devices designed to be secure to transfer large amounts of data into and out of the AWS Cloud\.   
See also [https://aws\.amazon\.com/snowball](https://aws.amazon.com/importexport/).

**AWS Storage Gateway**<a name="storagegateway"></a>  
A web service that connects an on\-premises software appliance with cloud\-based storage\. AWS Storage Gateway provides seamless and secure integration between an organization’s on\-premises IT environment and AWS storage infrastructure\.   
See also [https://aws\.amazon\.com/storagegateway/](https://aws.amazon.com/storagegateway/).

**AWS Toolkit for Eclipse**<a name="toolkiteclipse"></a>  
An open\-source plugin for the Eclipse Java integrated development environment \(IDE\) that makes it easier to develop, debug, and deploy Java applications using Amazon Web Services\.   
See also [https://aws\.amazon\.com/eclipse/](https://aws.amazon.com/eclipse/).

**AWS Toolkit for JetBrains**<a name="toolkitjetbrains"></a>  
An open\-source plugin for the integrated development environments \(IDEs\) from JetBrains that makes it easier to develop, debug, and deploy serverless applications using Amazon Web Services\.   
See also [https://aws\.amazon\.com/intellij/](https://aws.amazon.com/intellij/)[https://aws\.amazon\.com/pycharm/](https://aws.amazon.com/pycharm/).

**AWS Toolkit for Visual Studio**<a name="toolkitvisualstudio"></a>  
An extension for Visual Studio that helps in developing, debugging, and deploying \.NET applications using Amazon Web Services\.    
See also [https://aws\.amazon\.com/visualstudio/](https://aws.amazon.com/visualstudio/).

**AWS Toolkit for Visual Studio Code**<a name="toolkitvscode"></a>  
An open\-source plugin for the Visual Studio Code \(VS Code\) editor that makes it easier to develop, debug, and deploy applications using Amazon Web Services\.   
See also [https://aws\.amazon\.com/visualstudiocode/](https://aws.amazon.com/visualstudiocode/).

**AWS Tools for Windows PowerShell**<a name="toolspowershell"></a>  
A set of PowerShell cmdlets to help developers and administrators manage their AWS services from the Windows PowerShell scripting environment\.   
See also [https://aws\.amazon\.com/powershell/](https://aws.amazon.com/powershell/).

**AWS Tools for Microsoft Visual Studio Team Services**<a name="awsvsts"></a>  
Provides tasks you can use in build and release definitions in VSTS to interact with AWS services\.   
See also [https://aws\.amazon\.com/vsts/](https://aws.amazon.com/vsts/).

**AWS Trusted Advisor**<a name="trustedadvisor"></a>  
A web service that inspects your AWS environment and makes recommendations for saving money, improving system availability and performance, and helping to close security gaps\.   
See also [https://aws\.amazon\.com/premiumsupport/trustedadvisor/](https://aws.amazon.com/premiumsupport/trustedadvisor/).

**AWS VPN CloudHub**<a name="awsvpncloudhub"></a>  
Enables secure communication between branch offices using a simple hub\-and\-spoke model, with or without a [VPC](#VPC)\.

**AWS WAF**<a name="awswaf"></a>  
A web application firewall service that controls access to content by allowing or blocking web requests based on criteria that you specify\. For example, you can filter access based on the header values or the IP addresses that the requests originate from\. AWS WAF helps protect web applications from common web exploits that could affect application availability, compromise security, or consume excessive resources\.   
See also [https://aws\.amazon\.com/waf/](https://aws.amazon.com/waf/).

**AWS X\-Ray**<a name="awsxray"></a>  
A web service that collects data about requests that your application serves\. X\-Ray provides tools that you can use to view, filter, and gain insights into that data to identify issues and opportunities for optimization\.   
See also [https://aws\.amazon\.com/xray/](https://aws.amazon.com/xray/).

### B<a name="B"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**basic monitoring**<a name="basicmonitor"></a>  
Monitoring of AWS provided metrics derived at a 5\-minute frequency\.

**batch**<a name="batch"></a>   
See [document batch](#documentbatch).

**BGP ASN**<a name="BGPASN"></a>  
Border Gateway Protocol Autonomous System Number\. A unique identifier for a network, for use in BGP routing\. [Amazon EC2](#ec2) supports all 2\-byte ASN numbers in the range of 1 – 65335, with the exception of 7224, which is reserved\.

**batch prediction**<a name="batch-prediction"></a>  
Amazon Machine Learning: An operation that processes multiple input data observations at one time \(asynchronously\)\. Unlike real\-time predictions, batch predictions are not available until all predictions have been processed\.   
See also .

**billing**   
See [AWS Billing and Cost Management](#billing).

**binary attribute**<a name="binary-attribute"></a>  
Amazon Machine Learning: An attribute for which one of two possible values is possible\. Valid positive values are 1, y, yes, t, and true answers\. Valid negative values are 0, n, no, f, and false\. Amazon Machine Learning outputs 1 for positive values and 0 for negative values\.   
See also .

**binary classification model**<a name="binary-classification-model"></a>  
Amazon Machine Learning: A machine learning model that predicts the answer to questions where the answer can be expressed as a binary variable\. For example, questions with answers of “1” or “0”, “yes” or “no”, “will click” or “will not click” are questions that have binary answers\. The result for a binary classification model is always either a “1” \(for a “true” or affirmative answers\) or a “0” \(for a “false” or negative answers\)\.

**blacklist**<a name="blacklist"></a>  
A list of IP addresses, email addresses, or domains that an [internet service provider](#internetserviceprovider) suspects to be the source of [spam](#spam)\. The ISP blocks incoming email from these addresses or domains\.

**block**<a name="block"></a>  
A dataset\. [Amazon EMR](#AmazonElasticMapReduce) breaks large amounts of data into subsets\. Each subset is called a data block\. Amazon EMR assigns an ID to each block and uses a hash table to keep track of block processing\.

**block device**<a name="blockdevice"></a>  
A storage device that supports reading and \(optionally\) writing data in fixed\-size blocks, sectors, or clusters\.

**block device mapping**<a name="blockdevmap"></a>  
A mapping structure for every [AMI](#AmazonMachineImage) and [instance](#instance) that specifies the block devices attached to the instance\.

**blue/green deployment**<a name="bluegreendeployment"></a>  
CodeDeploy: A deployment method in which the instances in a deployment group \(the original environment\) are replaced by a different set of instances \(the replacement environment\)\.

**bootstrap action**<a name="bootstrapact"></a>  
A user\-specified default or custom action that runs a script or an application on all nodes of a job flow before [Hadoop](#Hadoop) starts\.

**Border Gateway Protocol Autonomous System Number**   
See [BGP ASN](#BGPASN).

**bounce**<a name="bounce"></a>  
A failed email delivery attempt\.

**breach**<a name="breach"></a>  
[Amazon EC2 Auto Scaling](#AutoScaling): The condition in which a user\-set threshold \(upper or lower boundary\) is passed\. If the duration of the breach is significant, as set by a breach duration parameter, it can possibly start a [scaling activity](#ScalingActivity)\. 

**bucket**<a name="bucket"></a>  
[Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService): A container for stored objects\. Every object is contained in a bucket\. For example, if the object named `photos/puppy.jpg` is stored in the `johnsmith` bucket, then authorized users can access the object with the URL `http://johnsmith.s3.amazonaws.com/photos/puppy.jpg`\.

**bucket owner**<a name="bucketowner"></a>  
The person or organization that owns a [bucket](#bucket) in [Amazon S3](#AmazonSimpleStorageService)\. Just as Amazon is the only owner of the domain name Amazon\.com, only one person or organization can own a bucket\. 

**bundling**<a name="bundling"></a>  
A commonly used term for creating an [Amazon Machine Image \(AMI\)](#AmazonMachineImage)\. It specifically refers to creating [instance store\-backed AMI](#instancebacked)s\.

### C<a name="C"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**cache cluster**<a name="CacheCluster"></a>  
A logical cache distributed over multiple [cache node](#CacheNode)s\. A cache cluster can be set up with a specific number of cache nodes\.

**cache cluster identifier**<a name="CacheClusterIdentifier"></a>  
Customer\-supplied identifier for the cache cluster that must be unique for that customer in an AWS [Region](#region)\.

**cache engine version**<a name="CacheEngineVersion"></a>  
The version of the Memcached service that is running on the cache node\.

**cache node**<a name="CacheNode"></a>  
A fixed\-size chunk of secure, network\-attached RAM\. Each cache node runs an instance of the Memcached service, and has its own DNS name and port\. Multiple types of cache nodes are supported, each with varying amounts of associated memory\.

**cache node type**<a name="CacheNodeType"></a>  
An [EC2 instance](#ec2instance) type used to run the cache node\.

**cache parameter group**<a name="CacheParameterGroup"></a>  
A container for cache engine parameter values that can be applied to one or more cache clusters\.

**cache security group**<a name="CacheSecurityGroup"></a>  
A group maintained by ElastiCache that combines inbound authorizations to cache nodes for hosts belonging to [Amazon EC2](#ec2) [security group](#SecurityGroup)s specified through the console or the API or command line tools\.

**canned access policy**<a name="cannedaccesspol"></a>  
A standard access control policy that you can apply to a [bucket](#bucket) or object\. Options include: private, public\-read, public\-read\-write, and authenticated\-read\.

**canonicalization**<a name="canonicalize"></a>  
The process of converting data into a standard format that a service such as [Amazon S3](#AmazonSimpleStorageService) can recognize\.

**capacity**<a name="capacity"></a>  
The amount of available compute size at a given time\. Each [Auto Scaling group](#AutoScalingGroup) is defined with a minimum and maximum compute size\. A [scaling activity](#ScalingActivity) increases or decreases the capacity within the defined minimum and maximum values\.

**Cartesian product processor**<a name="cartesian-product-processor"></a>  
A processor that calculates a Cartesian product\. Also known as a *Cartesian data processor*\.

**Cartesian product**<a name="cartesian-product"></a>  
A mathematical operation that returns a product from multiple sets\.

**CDN**   
See [content delivery network \(CDN\)](#content-delivery-network).

**certificate**<a name="certificate"></a>  
A credential that some AWS products use to authenticate AWS [account](#account)s and users\. Also known as an [X\.509 certificate](#X509) \. The certificate is paired with a private key\.

**chargeable resources**<a name="chargeable-resources"></a>  
Features or services whose use incurs fees\. Although some AWS products are free, others include charges\. For example, in an [AWS CloudFormation](#CloudFormation) [stack](#stack), AWS [resource](#resource)s that have been created incur charges\. The amount charged depends on the usage load\. Use the Amazon Web Services Simple Monthly Calculator at [http://calculator\.s3\.amazonaws\.com/calc5\.html](http://calculator.s3.amazonaws.com/calc5.html) to estimate your cost prior to creating instances, stacks, or other resources\.

**CIDR block**<a name="CIDRblock"></a>  
Classless Inter\-Domain Routing\. An internet protocol address allocation and route aggregation methodology\.   
See also [Classless Inter\-Domain Routing](http://en.wikipedia.org/wiki/CIDR_notation).

**ciphertext**<a name="cipher_text"></a>  
Information that has been [encrypted](#encrypt), as opposed to [plaintext](#plain_text), which is information that has not\.

**ClassicLink**<a name="ClassicLink"></a>  
A feature for linking an EC2\-Classic [instance](#instance) to a [VPC](#VPC), allowing your EC2\-Classic instance to communicate with VPC instances using private IP addresses\.   
See also . 
See also .

**classification**<a name="classification"></a>  
In machine learning, a type of problem that seeks to place \(classify\) a data sample into a single category or “class\.” Often, classification problems are modeled to choose one category \(class\) out of two\. These are binary classification problems\. Problems with more than two available categories \(classes\) are called "multiclass classification" problems\.   
See also . 
See also .

**CLI**   
See [AWS Command Line Interface \(AWS CLI\)](#awscli).

**Cloud Directory**   
See [Amazon Cloud Directory \(Cloud Directory\)](#clouddirectory).

**cloud service provider \(CSP\)**<a name="cloudserviceprovider"></a>  
A company that provides subscribers with access to internet\-hosted computing, storage, and software services\.

**CloudHub**   
See [AWS VPN CloudHub](#awsvpncloudhub).

**cluster**<a name="cluster"></a>  
A logical grouping of [container instance](#container_instance)s that you can place [task](#task)s on\.   
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): A logical grouping of one or more data nodes, optional dedicated master nodes, and storage required to run Amazon Elasticsearch Service \(Amazon ES\) and operate your Amazon ES domain\.   
See also . 
See also . 
See also .

**cluster compute instance**<a name="ClusterCompute"></a>  
A type of [instance](#instance) that provides a great amount of CPU power coupled with increased networking performance, making it well suited for High Performance Compute \(HPC\) applications and other demanding network\-bound applications\. 

**cluster placement group**<a name="ClusterPlacementGroup"></a>  
A logical [cluster compute instance](#ClusterCompute) grouping to provide lower latency and high\-bandwidth connectivity between the [instance](#instance)s\. 

**cluster status**<a name="clusterstatus"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): An indicator of the health of a cluster\. A status can be green, yellow, or red\. At the shard level, green means that all shards are allocated to nodes in a cluster, yellow means that the primary shard is allocated but the replica shards are not, and red means that the primary and replica shards of at least one index are not allocated\. The shard status determines the index status, and the index status determines the cluster status\. 

**CMK**   
See [customer master key \(CMK\)](#customer_master_key).

**CNAME**<a name="cname"></a>  
Canonical Name Record\. A type of [resource record](#resourcerecord) in the Domain Name System \(DNS\) that specifies that the domain name is an alias of another, canonical domain name\. More simply, it is an entry in a DNS table that lets you alias one fully qualified domain name to another\. 

**complaint**<a name="complaint"></a>  
The event in which a [recipient](#recipient) who does not want to receive an email message clicks "Mark as Spam" within the email client, and the [internet service provider](#internetserviceprovider) sends a notification to [Amazon SES](#SES)\.

**compound query**<a name="compoundquery"></a>  
[Amazon CloudSearch](#cloudSearch): A search request that specifies multiple search criteria using the Amazon CloudSearch structured search syntax\.

**condition**<a name="condition"></a>  
[IAM](#IAM): Any restriction or detail about a permission\. The condition is *D* in the statement "A has permission to do B to C where D applies\."  
[AWS WAF](#awswaf): A set of attributes that AWS WAF searches for in web requests to AWS [resource](#resource)s such as [Amazon CloudFront](#AmazonCF) distributions\. Conditions can include values such as the IP addresses that web requests originate from or values in request headers\. Based on the specified conditions, you can configure AWS WAF to allow or block web requests to AWS resources\.

**conditional parameter**   
See [mapping](#mapping).

**configuration API**<a name="configurationapi"></a>  
[Amazon CloudSearch](#cloudSearch): The API call that you use to create, configure, and manage search domains\.

**configuration template**<a name="configtemplate"></a>  
A series of key–value pairs that define parameters for various AWS products so that [AWS Elastic Beanstalk](#Beanstalk) can provision them for an environment\.

**consistency model**<a name="consistencymodel"></a>  
The method a service uses to achieve high availability\. For example, it could involve replicating data across multiple servers in a data center\.   
See also .

**console**   
See [AWS Management Console](#AWSManagementConsole).

**consolidated billing**<a name="consolidatedbilling"></a>  
A feature of the AWS Organizations service for consolidating payment for multiple AWS accounts\. You create an organization that contains your AWS accounts, and you use the master account of your organization to pay for all member accounts\. You can see a combined view of AWS costs that are incurred by all accounts in your organization, and you can get detailed cost reports for individual accounts\. 

**container**<a name="container"></a>  
A Linux container that was created from a Docker image as part of a [task](#task)\. 

**container definition**<a name="container_definition"></a>  
Specifies which [Docker image](#docker_image) to use for a [container](#container), how much CPU and memory the container is allocated, and more options\. The container definition is included as part of a [task definition](#task_definition)\.

**container instance**<a name="container_instance"></a>  
 An [EC2 instance](#ec2instance) that is running the [Amazon Elastic Container Service \(Amazon ECS\)](#ecs) agent and has been registered into a [cluster](#cluster)\. Amazon ECS [task](#task)s are placed on active container instances\. 

**container registry**<a name="container_registry"></a>  
 Stores, manages, and deploys [Docker image](#docker_image)s\. 

**content delivery network \(CDN\)**<a name="content-delivery-network"></a>  
A web service that speeds up distribution of your static and dynamic web content—such as \.html, \.css, \.js, media files, and image files—to your users by using a worldwide network of data centers\. When a user requests your content, the request is routed to the data center that provides the lowest latency \(time delay\)\. If the content is already in the location with the lowest latency, the CDN delivers it immediately\. If not, the CDN retrieves it from an origin that you specify \(for example, a web server or an Amazon S3 bucket\)\. With some CDNs, you can help secure your content by configuring an HTTPS connection between users and data centers, and between data centers and your origin\. Amazon CloudFront is an example of a CDN\.

**continuous delivery**<a name="continuous_delivery"></a>  
A software development practice in which code changes are automatically built, tested, and prepared for a release to production\.   
See also [https://aws\.amazon\.com/devops/continuous\-delivery/](https://aws.amazon.com/devops/continuous-delivery/).

**continuous integration**<a name="continuous_integration"></a>  
A software development practice in which developers regularly merge code changes into a central repository, after which automated builds and tests are run\.   
See also [https://aws\.amazon\.com/devops/continuous\-integration/](https://aws.amazon.com/devops/continuous-integration/).

**cooldown period**<a name="cooldown"></a>  
Amount of time during which [Amazon EC2 Auto Scaling](#AutoScaling) does not allow the desired size of the [Auto Scaling group](#AutoScalingGroup) to be changed by any other notification from an [Amazon CloudWatch](#AmazonCW) [alarm](#alarm)\.

**core node**<a name="corenode"></a>  
An [EC2 instance](#ec2instance) that runs [Hadoop](#Hadoop) map and reduce tasks and stores data using the Hadoop Distributed File System \(HDFS\)\. Core nodes are managed by the [master node](#masternode), which assigns Hadoop tasks to nodes and monitors their status\. The EC2 instances you assign as core nodes are capacity that must be allotted for the entire job flow run\. Because core nodes store data, you can't remove them from a job flow\. However, you can add more core nodes to a running job flow\.   
Core nodes run both the DataNodes and TaskTracker Hadoop daemons\.

**corpus**<a name="corpus"></a>  
[Amazon CloudSearch](#cloudSearch): A collection of data that you want to search\.

**credential helper**<a name="credentialhelper"></a>  
[AWS CodeCommit](#AWSCodeCommit): A program that stores credentials for repositories and supplies them to Git when making connections to those repositories\. The [AWS CLI](#awscli) includes a credential helper that you can use with Git when connecting to CodeCommit repositories\.

**credentials**<a name="accesscredentials"></a>  
Also called *access credentials* or *security credentials*\. In authentication and authorization, a system uses credentials to identify who is making a call and whether to allow the requested access\. In AWS, these credentials are typically the [access key ID](#accesskeyID) and the [secret access key](#SecretAccessKey)\.

**cross\-account access**<a name="crossaccountaccess"></a>  
The process of permitting limited, controlled use of [resource](#resource)s in one AWS [account](#account) by a user in another AWS account\. For example, in [AWS CodeCommit](#AWSCodeCommit) and [AWS CodeDeploy](#AWSCodeDeploy) you can configure cross\-account access so that a user in AWS account A can access an CodeCommit repository created by account B\. Or a pipeline in [AWS CodePipeline](#AWSCodePipeline) created by account A can use CodeDeploy resources created by account B\. In [IAM](#IAM) you use a [role](#role) to [delegate](#delegation) temporary access to a [user](#AWSUser) in one account to resources in another\.

**cross\-Region replication**<a name="cross-region-replication"></a>  
A client\-side solution for maintaining identical copies of [Amazon DynamoDB](#dynamodb) tables across different AWS [Region](#region)s, in near real time\.

**customer gateway**<a name="customergateway"></a>  
A router or software application on your side of a VPN tunnel that is managed by [Amazon VPC](#AmazonVirtualPrivateCloud)\. The internal interfaces of the customer gateway are attached to one or more devices in your home network\. The external interface is attached to the [virtual private gateway](#VPNgateway) across the VPN tunnel\. 

**customer managed policy**<a name="customer_managed_policy"></a>  
An [IAM](#IAM) [managed policy](#managed_policy) that you create and manage in your AWS [account](#account)\.

**customer master key \(CMK\)**<a name="customer_master_key"></a>  
The fundamental [resource](#resource) that [AWS Key Management Service \(AWS KMS\)](#AWS_KMS) manages\. CMKs can be either customer managed keys or AWS managed keys\. Use CMKs inside AWS KMS to [encrypt](#encrypt) or decrypt up to 4 kilobytes of data directly or to encrypt generated data keys, which are then used to encrypt or decrypt larger amounts of data outside of the service\. 

### D<a name="D"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**dashboard**   
See [service health dashboard](#servicehealthdashboard).

**data consistency**<a name="data-consistency"></a>  
A concept that describes when data is written or updated successfully and all copies of the data are updated in all AWS [Region](#region)s\. However, it takes time for the data to propagate to all storage locations\. To support varied application requirements, [Amazon DynamoDB](#dynamodb) supports both eventually consistent and strongly consistent reads\.   
See also . 
See also . 
See also .

**data node**<a name="data-node"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): An Elasticsearch instance that holds data and responds to data upload requests\.   
See also . 
See also .

**data schema**<a name="data-schema"></a>   
See [schema](#schema).

**data source**<a name="data_source"></a>  
The database, file, or repository that provides information required by an application or database\. For example, in [AWS OpsWorks](#opsworks), valid data sources include an [instance](#instance) for a stack’s MySQL layer or a stack’s [Amazon RDS](#AmazonRelationalDatabaseService) service layer\. In [Amazon Redshift ](#redshift), valid data sources include text files in an [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket), in an [Amazon EMR](#AmazonElasticMapReduce) cluster, or on a remote host that a cluster can access through an SSH connection\.   
See also .

**database engine**<a name="databaseengine"></a>  
The database software and version running on the [DB instance](#dbinstance)\.

**database name**<a name="databasename"></a>  
The name of a database hosted in a [DB instance](#dbinstance)\. A DB instance can host multiple databases, but databases hosted by the same DB instance must each have a unique name within that instance\. 

**datasource**<a name="datasource"></a>  
[Amazon Machine Learning](#machine-learning): An object that contains metadata about the input data\. Amazon ML reads the input data, computes descriptive statistics on its attributes, and stores the statistics—along with a schema and other information—as part of the datasource object\. Amazon ML uses datasources to train and evaluate a machine learning model and generate batch predictions\.   
See also .

**DB compute class**<a name="DBComputeclass"></a>  
The size of the database compute platform used to run the instance\.

**DB instance**<a name="dbinstance"></a>  
An isolated database environment running in the cloud\. A DB instance can contain multiple user\-created databases\.

**DB instance identifier**<a name="DBInstanceidentifier"></a>  
User\-supplied identifier for the DB instance\. The identifier must be unique for that user in an AWS [Region](#region)\.

**DB parameter group**<a name="DBParameterGroup"></a>  
A container for database engine parameter values that apply to one or more [DB instance](#dbinstance)s\.

**DB security group**<a name="DBSecurityGroup"></a>  
A method that controls access to the [DB instance](#dbinstance)\. By default, network access is turned off to DB instances\. After inbound traffic is configured for a [security group](#SecurityGroup), the same rules apply to all DB instances associated with that group\.

**DB snapshot**<a name="DBSnapshot"></a>  
A user\-initiated point backup of a [DB instance](#dbinstance)\.

**Dedicated Host**<a name="DedicatedHost"></a>  
A physical server with [EC2 instance](#ec2instance) capacity fully dedicated to a user\.

**Dedicated Instance**<a name="DedicatedInstance"></a>  
An [instance](#instance) that is physically isolated at the host hardware level and launched within a [VPC](#VPC)\.

**dedicated master node**<a name="dedicatedmasternode"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): An Elasticsearch instance that performs cluster management tasks, but does not hold data or respond to data upload requests\. Amazon Elasticsearch Service \(Amazon ES\) uses dedicated master nodes to increase cluster stability\.    
See also . 
See also .

**Dedicated Reserved Instance**<a name="DedicatedReservedInstance"></a>  
An option that you purchase to guarantee that sufficient capacity will be available to launch [Dedicated Instance](#DedicatedInstance)s into a [VPC](#VPC)\. 

**delegation**<a name="delegation"></a>  
Within a single AWS [account](#account): Giving AWS [user](#AWSUser)s access to [resource](#resource)s in your AWS account\.   
Between two AWS accounts: Setting up a trust between the account that owns the resource \(the trusting account\), and the account that contains the users that need to access the resource \(the trusted account\)\.   
See also .

**delete marker**<a name="deletemarker"></a>  
An object with a key and version ID, but without content\. [Amazon S3](#AmazonSimpleStorageService) inserts delete markers automatically into versioned [bucket](#bucket)s when an object is deleted\.

**deliverability**<a name="deliverability"></a>  
The likelihood that an email message will arrive at its intended destination\.

**deliveries**<a name="deliveries"></a>  
The number of email messages, sent through [Amazon SES](#SES), that were accepted by an [internet service provider](#internetserviceprovider) for delivery to [recipient](#recipient)s over a period of time\.

**deny**<a name="deny"></a>  
The result of a [policy](#policy) statement that includes deny as the effect, so that a specific action or actions are expressly forbidden for a user, group, or role\. Explicit deny take precedence over explicit [allow](#allow)\. 

**deployment configuration**<a name="deploymentconfiguration"></a>  
[AWS CodeDeploy](#AWSCodeDeploy): A set of deployment rules and success and failure conditions used by the service during a deployment\.

**deployment group**<a name="deploymentgroup"></a>  
[AWS CodeDeploy](#AWSCodeDeploy): A set of individually tagged [instance](#instance)s, [EC2 instance](#ec2instance)s in [Auto Scaling group](#AutoScalingGroup)s, or both\.

**detailed monitoring**<a name="detailedmonitoring"></a>  
Monitoring of AWS provided metrics derived at a 1\-minute frequency\.

**Description property**<a name="description"></a>  
A property added to parameters, [resource](#resource)s, resource properties, mappings, and outputs to help you to document [AWS CloudFormation](#CloudFormation) template elements\.

**dimension**<a name="dimension"></a>  
A name–value pair \(for example, InstanceType=m1\.small, or EngineName=mysql\), that contains additional information to identify a metric\.

**discussion forums**<a name="discussionforums"></a>  
A place where AWS users can post technical questions and feedback to help accelerate their development efforts and to engage with the AWS community\. The discussion forums are located at [https://forums\.aws\.amazon\.com/](https://forums.aws.amazon.com/)\.

**distribution**<a name="distribution"></a>  
A link between an origin server \(such as an [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket)\) and a domain name, which [CloudFront](#AmazonCF) automatically assigns\. Through this link, CloudFront identifies the object you have stored in your [origin server](#originserver)\. 

**DKIM**<a name="DKIM"></a>  
DomainKeys Identified Mail\. A standard that email senders use to sign their messages\. ISPs use those signatures to verify that messages are legitimate\. For more information, see [http://www\.dkim\.org](http://www.dkim.org)\.

**DNS**   
See [Domain Name System](#domainnamesystem).

**Docker image**<a name="docker_image"></a>  
 A layered file system template that is the basis of a Docker [container](#container)\. Docker images can comprise specific operating systems or applications\. 

**document**<a name="document"></a>  
[Amazon CloudSearch](#cloudSearch): An item that can be returned as a search result\. Each document has a collection of fields that contain the data that can be searched or returned\. The value of a field can be either a string or a number\. Each document must have a unique ID and at least one field\. 

**document batch**<a name="documentbatch"></a>  
[Amazon CloudSearch](#cloudSearch): A collection of add and delete document operations\. You use the document service API to submit batches to update the data in your search domain\. 

**document service API**<a name="documentsvcapi"></a>  
[Amazon CloudSearch](#cloudSearch): The API call that you use to submit document batches to update the data in a search domain\.

**document service endpoint**<a name="documentsvcendpoint"></a>  
[Amazon CloudSearch](#cloudSearch): The URL that you connect to when sending document updates to an Amazon CloudSearch domain\. Each search domain has a unique document service endpoint that remains the same for the life of the domain\.

**domain**<a name="domain"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): The hardware, software, and data exposed by Amazon Elasticsearch Service \(Amazon ES\) endpoints\. An Amazon ES domain is a service wrapper around an Elasticsearch cluster\. An Amazon ES domain encapsulates the engine instances that process Amazon ES requests, the indexed data that you want to search, snapshots of the domain, access policies, and metadata\.   
See also . 
See also .

**Domain Name System**<a name="domainnamesystem"></a>  
A service that routes internet traffic to websites by translating friendly domain names like www\.example\.com into the numeric IP addresses like 192\.0\.2\.1 that computers use to connect to each other\.

**Donation button**<a name="Donationbutton"></a>  
An HTML\-coded button to provide an easy and secure way for US\-based, IRS\-certified 501\(c\)3 nonprofit organizations to solicit donations\.

**DynamoDB stream**<a name="dynamodb-stream"></a>  
An ordered flow of information about changes to items in an[Amazon DynamoDB](#dynamodb) table\. When you enable a stream on a table, DynamoDB captures information about every modification to data items in the table\.   
See also .

### E<a name="E"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**EBS**   
See [Amazon Elastic Block Store \(Amazon EBS\)](#EBS).

**EC2**   
See [Amazon Elastic Compute Cloud \(Amazon EC2\)](#ec2).

**EC2 compute unit**<a name="ECU"></a>  
An AWS standard for compute CPU and memory\. You can use this measure to evaluate the CPU capacity of different [EC2 instance](#ec2instance) types\.

**EC2 instance**<a name="ec2instance"></a>  
A compute [instance](#instance) in the [Amazon EC2](#ec2) service\. Other AWS services use the term *EC2 instance* to distinguish these instances from other types of instances they support\.

**ECR**   
See [Amazon Elastic Container Registry \(Amazon ECR\)](#ecr).

**ECS**   
See [Amazon Elastic Container Service \(Amazon ECS\)](#ecs).

**edge location**<a name="edgeloc"></a>  
A site that [CloudFront](#AmazonCF) uses to cache copies of your content for faster delivery to users at any location\. 

**EFS**   
See [Amazon Elastic File System \(Amazon EFS\)](#efs).

**Elastic**<a name="Elastic"></a>  
A company that provides open\-source solutions—including Elasticsearch, Logstash, Kibana, and Beats—that are designed to take data from any source and search, analyze, and visualize it in real time\.  
Amazon Elasticsearch Service \(Amazon ES\) is an AWS managed service for deploying, operating, and scaling Elasticsearch in the AWS Cloud\.   
See also . 
See also .

**Elastic Block Store**   
See [Amazon Elastic Block Store \(Amazon EBS\)](#EBS).

**Elastic IP address**<a name="ElasticIP"></a>  
A fixed \(static\) IP address that you have allocated in [Amazon EC2](#ec2) or [Amazon VPC](#AmazonVirtualPrivateCloud) and then attached to an [instance](#instance)\. Elastic IP addresses are associated with your account, not a specific instance\. They are *elastic* because you can easily allocate, attach, detach, and free them as your needs change\. Unlike traditional static IP addresses, Elastic IP addresses allow you to mask instance or [Availability Zone](#AZ) failures by rapidly remapping your public IP addresses to another instance\.

**Elastic Load Balancing**<a name="ELB"></a>  
A web service that improves an application's availability by distributing incoming traffic between two or more [EC2 instance](#ec2instance)s\.   
See also [https://aws\.amazon\.com/elasticloadbalancing](https://aws.amazon.com/elasticloadbalancing/).

**elastic network interface**<a name="elasticnetworkinterface"></a>  
An additional network interface that can be attached to an [instance](#instance)\. Elastic network interfaces include a primary private IP address, one or more secondary private IP addresses, an Elastic IP Address \(optional\), a MAC address, membership in specified [security group](#SecurityGroup)s, a description, and a source/destination check flag\. You can create an elastic network interface, attach it to an instance, detach it from an instance, and attach it to another instance\. 

**Elasticsearch**<a name="Elasticsearch"></a>  
An open\-source, real\-time distributed search and analytics engine used for full\-text search, structured search, and analytics\. Elasticsearch was developed by the Elastic company\.  
Amazon Elasticsearch Service \(Amazon ES\) is an AWS managed service for deploying, operating, and scaling Elasticsearch in the AWS Cloud\.   
See also . 
See also .

**EMR**   
See [Amazon EMR \(Amazon EMR\)](#AmazonElasticMapReduce).

**encrypt**<a name="encrypt"></a>  
To use a mathematical algorithm to make data unintelligible to unauthorized [user](#AWSUser)s while allowing authorized users a method \(such as a key or password\) to convert the altered data back to its original state\.

**encryption context**<a name="encryption_context"></a>  
A set of key–value pairs that contains additional information associated with [AWS Key Management Service \(AWS KMS\)](#AWS_KMS)–encrypted information\.

**endpoint**<a name="endpoint"></a>  
A URL that identifies a host and port as the entry point for a web service\. Every web service request contains an endpoint\. Most AWS products provide endpoints for a Region to enable faster connectivity\.  
[Amazon ElastiCache](#elasticache): The DNS name of a [cache node](#CacheNode)\.  
[Amazon RDS](#AmazonRelationalDatabaseService): The DNS name of a [DB instance](#dbinstance)\.  
[AWS CloudFormation](#CloudFormation): The DNS name or IP address of the server that receives an HTTP request\.

**endpoint port**<a name="endpointport"></a>  
[Amazon ElastiCache](#elasticache): The port number used by a [cache node](#CacheNode)\.  
[Amazon RDS](#AmazonRelationalDatabaseService): The port number used by a [DB instance](#dbinstance)\.

**envelope encryption**<a name="envelope_encryption"></a>  
The use of a master key and a data key to algorithmically protect data\. The master key is used to encrypt and decrypt the data key and the data key is used to encrypt and decrypt the data itself\. 

**environment**<a name="environment"></a>  
[AWS Elastic Beanstalk](#Beanstalk): A specific running instance of an [application](#application)\. The application has a CNAME and includes an application version and a customizable configuration \(which is inherited from the default container type\)\.  
[AWS CodeDeploy](#AWSCodeDeploy): Instances in a deployment group in a blue/green deployment\. At the start of a blue/green deployment, the deployment group is made up of instances in the original environment\. At the end of the deployment, the deployment group is made up of instances in the replacement environment\.

**environment configuration**<a name="environmentconfiguration"></a>  
A collection of parameters and settings that define how an environment and its associated resources behave\.

**ephemeral store**   
See [instance store](#instancestore).

**epoch**<a name="epoch"></a>  
The date from which time is measured\. For most Unix environments, the epoch is January 1, 1970\.

**ETL**   
See [extract, transform, and load \(ETL\)](#extracttransformload).

**evaluation**<a name="evaluation"></a>  
Amazon Machine Learning: The process of measuring the predictive performance of a machine learning \(ML\) model\.  
Also a machine learning object that stores the details and result of an ML model evaluation\.

**evaluation datasource**<a name="evaluation-datasource"></a>  
The data that Amazon Machine Learning uses to evaluate the predictive accuracy of a machine learning model\.

**eventual consistency**<a name="eventualconsistency"></a>  
The method through which AWS products achieve high availability, which involves replicating data across multiple servers in Amazon's data centers\. When data is written or updated and `Success` is returned, all copies of the data are updated\. However, it takes time for the data to propagate to all storage locations\. The data will eventually be consistent, but an immediate read might not show the change\. Consistency is usually reached within seconds\.   
See also . 
See also . 
See also .

**eventually consistent read**<a name="eventually-consistent-read"></a>  
A read process that returns data from only one Region and might not show the most recent write information\. However, if you repeat your read request after a short time, the response should eventually return the latest data\.   
See also . 
See also . 
See also .

**eviction**<a name="eviction"></a>  
The deletion by [CloudFront](#AmazonCF) of an object from an [edge location](#edgeloc) before its expiration time\. If an object in an edge location isn't frequently requested, CloudFront might evict the object \(remove the object before its expiration date\) to make room for objects that are more popular\. 

**exbibyte**<a name="exbibyte"></a>  
A contraction of exa binary byte, an exbibyte is 2^60 or 1,152,921,504,606,846,976 bytes\. An exabyte \(EB\) is 10^18 or 1,000,000,000,000,000,000 bytes\. 1,024 EiB is a [zebibyte](#zebibyte)\.

**expiration**<a name="expiration"></a>  
For [CloudFront](#AmazonCF) caching, the time when CloudFront stops responding to user requests with an object\. If you don't use headers or CloudFront [distribution](#distribution) settings to specify how long you want objects to stay in an [edge location](#edgeloc), the objects expire after 24 hours\. The next time a user requests an object that has expired, CloudFront forwards the request to the [origin](#originserver)\.

**explicit launch permission**<a name="explicitlaunchpermission"></a>  
An [Amazon Machine Image \(AMI\)](#AmazonMachineImage) launch permission granted to a specific AWS [account](#account)\.

**exponential backoff**<a name="exponentialbackoff"></a>  
A strategy that incrementally increases the wait between retry attempts in order to reduce the load on the system and increase the likelihood that repeated requests will succeed\. For example, client applications might wait up to 400 milliseconds before attempting the first retry, up to 1600 milliseconds before the second, up to 6400 milliseconds \(6\.4 seconds\) before the third, and so on\.

**expression**<a name="expression"></a>  
[Amazon CloudSearch](#cloudSearch): A numeric expression that you can use to control how search hits are sorted\. You can construct Amazon CloudSearch expressions using numeric fields, other rank expressions, a document's default relevance score, and standard numeric operators and functions\. When you use the `sort` option to specify an expression in a search request, the expression is evaluated for each search hit and the hits are listed according to their expression values\.

**extract, transform, and load \(ETL\)**<a name="extracttransformload"></a>  
A process that is used to integrate data from multiple sources\. Data is collected from sources \(extract\), converted to an appropriate format \(transform\), and written to a target data store \(load\) for purposes of analysis and querying\.  
ETL tools combine these three functions to consolidate and move data from one environment to another\. [AWS Glue](#Glue) is a fully managed ETL service for discovering and organizing data, transforming it, and making it available for search and analytics\.

### F<a name="F"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**facet**<a name="facet"></a>  
[Amazon CloudSearch](#cloudSearch): An index field that represents a category that you want to use to refine and filter search results\.

**facet enabled**<a name="facetenabled"></a>  
[Amazon CloudSearch](#cloudSearch): An index field option that enables facet information to be calculated for the field\.

**FBL**   
See [feedback loop](#feedbackloop).

**feature transformation**<a name="feature-transformation"></a>  
Amazon Machine Learning: The machine learning process of constructing more predictive input representations or “features” from the raw input variables to optimize a machine learning model’s ability to learn and generalize\. Also known as *data transformation* or *feature engineering*\.

**federated identity management**<a name="fed_identity"></a>  
Allows individuals to sign in to different networks or services, using the same group or personal credentials to access data across all networks\. With identity federation in AWS, external identities \(federated users\) are granted secure access to [resource](#resource)s in an AWS [account](#account) without having to create IAM [user](#AWSUser)s\. These external identities can come from a corporate identity store \(such as LDAP or Windows Active Directory\) or from a third party \(such as Login with Amazon, Facebook, or Google\)\. AWS federation also supports SAML 2\.0\.

**federated user**   
See [federated identity management](#fed_identity).

**federation**   
See [federated identity management](#fed_identity).

**feedback loop**<a name="feedbackloop"></a>  
The mechanism by which a mailbox provider \(for example, an [internet service provider](#internetserviceprovider)\) forwards a [recipient](#recipient)'s [complaint](#complaint) back to the [sender](#sender)\.

**field weight**<a name="fieldweight"></a>  
The relative importance of a text field in a search index\. Field weights control how much matches in particular text fields affect a document's relevance score\.

**filter**<a name="filter"></a>  
A criterion that you specify to limit the results when you list or describe your [Amazon EC2](#ec2) [resource](#resource)s\.

**filter query**<a name="filterquery"></a>  
A way to filter search results without affecting how the results are scored and sorted\. Specified with the [Amazon CloudSearch](#cloudSearch) `fq` parameter\. 

**FIM**   
See [federated identity management](#fed_identity).

**Firehose**   
See [Amazon Kinesis Data Firehose](#AmazonKinesisFirehose).

**format version**   
See [template format version](#template-format-version).

**forums**   
See [discussion forums](#discussionforums).

**function**   
See [intrinsic function](#intrinsicfunction).

**fuzzy search**<a name="fuzzysearch"></a>  
A simple search query that uses approximate string matching \(fuzzy matching\) to correct for typographical errors and misspellings\.

### G<a name="G"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**geospatial search**<a name="geospatialsearch"></a>  
A search query that uses locations specified as a latitude and longitude to determine matches and sort the results\. 

**gibibyte**<a name="gibibyte"></a>  
A contraction of giga binary byte, a gibibyte is 2^30 or 1,073,741,824 bytes\. A gigabyte \(GB\) is 10^9 or 1,000,000,000 bytes\. 1,024 GiB is a [tebibyte](#tebibyte)\.

**GitHub**<a name="github"></a>  
A web\-based repository that uses Git for version control\.

**global secondary index**<a name="global-secondary-index"></a>  
An index with a partition key and a sort key that can be different from those on the table\. A global secondary index is considered global because queries on the index can span all of the data in a table, across all partitions\.   
See also .

**grant**<a name="grant_perms"></a>  
[AWS Key Management Service \(AWS KMS\)](#AWS_KMS): A mechanism for giving AWS [principal](#principal)s long\-term permissions to use [customer master key \(CMK\)](#customer_master_key)s\.

**grant token**<a name="grant_token"></a>  
A type of identifier that allows the permissions in a [grant](#grant_perms) to take effect immediately\.

**ground truth**<a name="ground-truth"></a>  
The observations used in the machine learning \(ML\) model training process that include the correct value for the target attribute\. To train an ML model to predict house sales prices, the input observations would typically include prices of previous house sales in the area\. The sale prices of these houses constitute the ground truth\.

**group**<a name="group"></a>  
A collection of [IAM](#IAM) [user](#AWSUser)s\. You can use IAM groups to simplify specifying and managing permissions for multiple users\.

### H<a name="H"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**Hadoop**<a name="Hadoop"></a>  
Software that enables distributed processing for big data by using clusters and simple programming models\. For more information, see [http://hadoop\.apache\.org](http://hadoop.apache.org/)\.

**hard bounce**<a name="hardbounce"></a>  
A persistent email delivery failure such as "mailbox does not exist\."

**hardware VPN**<a name="hardwarevpn"></a>  
A hardware\-based IPsec VPN connection over the internet\.

**health check**<a name="healthcheck"></a>  
A system call to check on the health status of each instance in an [Amazon EC2 Auto Scaling](#AutoScaling) group\.

**high\-quality email**<a name="highqualityemail"></a>  
Email that recipients find valuable and want to receive\. Value means different things to different recipients and can come in the form of offers, order confirmations, receipts, newsletters, etc\.

**highlights**<a name="highlights"></a>  
[Amazon CloudSearch](#cloudSearch): Excerpts returned with search results that show where the search terms appear within the text of the matching documents\.

**highlight enabled**<a name="highlightenabled"></a>  
[Amazon CloudSearch](#cloudSearch): An index field option that enables matches within the field to be highlighted\.

**hit**<a name="hitcloudsearch"></a>  
A document that matches the criteria specified in a search request\. Also referred to as a *search result*\.

**HMAC**<a name="HMAC"></a>  
Hash\-based Message Authentication Code\. A specific construction for calculating a message authentication code \(MAC\) involving a cryptographic hash function in combination with a secret key\. You can use it to verify both the data integrity and the authenticity of a message at the same time\. AWS calculates the HMAC using a standard, cryptographic hash algorithm, such as SHA\-256\. 

**hosted zone**<a name="hostedzone"></a>  
A collection of [resource record](#resourcerecord) sets that [Amazon Route 53](#Route53) hosts\. Like a traditional DNS zone file, a hosted zone represents a collection of records that are managed together under a single domain name\.

**HTTP\-Query**<a name="HTTPquery"></a>   
See [Query](#Query).

**HVM virtualization**<a name="HVM"></a>  
Hardware Virtual Machine virtualization\. Allows the guest VM to run as though it is on a native hardware platform, except that it still uses paravirtual \(PV\) network and storage drivers for improved performance\.   
See also .

### I<a name="I"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**IAM**   
See [AWS Identity and Access Management \(IAM\)](#IAM).

**IAM group**   
See [group](#group).

**IAM policy simulator**   
See [policy simulator](#policy_simulator).

**IAM role**   
See [role](#role).

**IAM user**   
See [user](#AWSUser).

**Identity and Access Management**   
See [AWS Identity and Access Management \(IAM\)](#IAM).

**identity provider \(IdP\)**<a name="identity_provider"></a>  
An [IAM](#IAM) entity that holds metadata about external identity providers\.

**IdP**   
See [identity provider \(IdP\) ](#identity_provider).

**image**   
See [Amazon Machine Image \(AMI\)](#AmazonMachineImage).

**import/export station**<a name="importexportstation"></a>  
A machine that uploads or downloads your data to or from [Amazon S3](#AmazonSimpleStorageService)\.

**import log**<a name="importlog"></a>  
A report that contains details about how [AWS Import/Export](#AWSImportExport) processed your data\.

**in\-place deployment**<a name="inplacedeployment"></a>  
CodeDeploy: A deployment method in which the application on each instance in the deployment group is stopped, the latest application revision is installed, and the new version of the application is started and validated\. You can choose to use a load balancer so each instance is deregistered during its deployment and then restored to service after the deployment is complete\.

**index**<a name="index"></a>   
See [search index](#searchindex).

**index field**<a name="indexfield"></a>  
A name–value pair that is included in an [Amazon CloudSearch](#cloudSearch) domain's index\. An index field can contain text or numeric data, dates, or a location\. 

**indexing options**<a name="indexoptions"></a>  
Configuration settings that define an [Amazon CloudSearch](#cloudSearch) domain's index fields, how document data is mapped to those index fields, and how the index fields can be used\. 

**inline policy**<a name="inline_policy"></a>  
An [IAM](#IAM) [policy](#policy) that is embedded in a single IAM [user](#AWSUser), [group](#group), or [role](#role)\.

**input data**<a name="input-data"></a>  
Amazon Machine Learning: The observations that you provide to Amazon Machine Learning to train and evaluate a machine learning model and generate predictions\.

**instance**<a name="instance"></a>  
A copy of an [Amazon Machine Image \(AMI\)](#AmazonMachineImage) running as a virtual server in the AWS Cloud\.

**instance family**<a name="instancefamily"></a>  
A general [instance type](#instancetype) grouping using either storage or CPU capacity\. 

**instance group**<a name="instancegroup"></a>  
A [Hadoop](#Hadoop) cluster contains one master instance group that contains one [master node](#masternode), a core instance group containing one or more [core node](#corenode) and an optional [task node](#tasknode) instance group, which can contain any number of task nodes\. 

**instance profile**<a name="instanceprofile"></a>  
A container that passes [IAM](#IAM) [role](#role) information to an [EC2 instance](#ec2instance) at launch\.

**instance store**<a name="instancestore"></a>  
Disk storage that is physically attached to the host computer for an [EC2 instance](#ec2instance), and therefore has the same lifespan as the instance\. When the instance is terminated, you lose any data in the instance store\. 

**instance store\-backed AMI**<a name="instancebacked"></a>  
A type of [Amazon Machine Image \(AMI\)](#AmazonMachineImage) whose [instance](#instance)s use an [instance store](#instancestore) [volume](#volume) as the root device\. Compare this with instances launched from [Amazon EBS](#EBS)\-backed AMIs, which use an Amazon EBS volume as the root device\.

**instance type**<a name="instancetype"></a>  
A specification that defines the memory, CPU, storage capacity, and usage cost for an [instance](#instance)\. Some instance types are designed for standard applications, whereas others are designed for CPU\-intensive, memory\-intensive applications, and so on\. 

**internet gateway**<a name="internetgateway"></a>  
Connects a network to the internet\. You can route traffic for IP addresses outside your [VPC](#VPC) to the internet gateway\. 

**internet service provider**<a name="internetserviceprovider"></a>  
A company that provides subscribers with access to the internet\. Many ISPs are also [mailbox provider](#mailboxprovider)s\. Mailbox providers are sometimes referred to as ISPs, even if they only provide mailbox services\.

**intrinsic function**<a name="intrinsicfunction"></a>  
A special action in a [AWS CloudFormation](#CloudFormation) template that assigns values to properties not available until runtime\. These functions follow the format *Fn::Attribute*, such as `Fn::GetAtt`\. Arguments for intrinsic functions can be parameters, pseudo parameters, or the output of other intrinsic functions\.

**IP address**<a name="IPaddress"></a>  
A numerical address \(for example, 192\.0\.2\.44\) that networked devices use to communicate with one another using the Internet Protocol \(IP\)\. All [EC2 instance](#ec2instance)s are assigned two IP addresses at launch, which are directly mapped to each other through network address translation \([NAT](#nat)\): a private IP address \(following RFC 1918\) and a public IP address\. Instances launched in a [VPC](#AmazonVirtualPrivateCloud) are assigned only a private IP address\. Instances launched in your default VPC are assigned both a private IP address and a public IP address\.

**IP match condition**<a name="IPmatchcondition"></a>  
[AWS WAF](#awswaf): An attribute that specifies the IP addresses or IP address ranges that web requests originate from\. Based on the specified IP addresses, you can configure AWS WAF to allow or block web requests to AWS [resource](#resource)s such as [Amazon CloudFront](#AmazonCF) distributions\.

**ISP**   
See [internet service provider](#internetserviceprovider).

**issuer**<a name="issuer"></a>  
The person who writes a [policy](#policy) to grant permissions to a [resource](#resource)\. The issuer \(by definition\) is always the resource owner\. AWS does not permit [Amazon SQS](#AmazonSimpleQueueService) users to create policies for resources they don't own\. If John is the resource owner, AWS authenticates John's identity when he submits the policy he's written to grant permissions for that resource\.

**item**<a name="item"></a>  
A group of attributes that is uniquely identifiable among all of the other items\. Items in [Amazon DynamoDB](#dynamodb) are similar in many ways to rows, records, or tuples in other database systems\.

### J<a name="J"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**job flow**<a name="jobflow"></a>  
[Amazon EMR](#AmazonElasticMapReduce): One or more [step](#step)s that specify all of the functions to be performed on the data\.

**job ID**<a name="jobID"></a>  
A five\-character, alphanumeric string that uniquely identifies an [AWS Import/Export](#AWSImportExport) storage device in your shipment\. AWS issues the job ID in response to a `CREATE JOB` email command\. 

**job prefix**<a name="jobprefix"></a>  
An optional string that you can add to the beginning of an [AWS Import/Export](#AWSImportExport) log file name to prevent collisions with objects of the same name\.   
See also .

**JSON**<a name="json"></a>  
JavaScript Object Notation\. A lightweight data interchange format\. For information about JSON, see [http://www\.json\.org/](http://www.json.org/)\.

**junk folder**<a name="junkfolder"></a>  
The location where email messages that various filters determine to be of lesser value are collected so that they do not arrive in the [recipient](#recipient)'s inbox but are still accessible to the recipient\. This is also referred to as a [spam](#spam) or bulk folder\.

### K<a name="K"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**key**<a name="key"></a>  
A credential that identifies an AWS [account](#account) or [user](#AWSUser) to AWS \(such as the AWS [secret access key](#SecretAccessKey)\)\.
[Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService), [Amazon EMR \(Amazon EMR\)](#AmazonElasticMapReduce): The unique identifier for an object in a [bucket](#bucket)\. Every object in a bucket has exactly one key\. Because a bucket and key together uniquely identify each object, you can think of Amazon S3 as a basic data map between the *bucket \+ key*, and the object itself\. You can uniquely address every object in Amazon S3 through the combination of the web service endpoint, bucket name, and key, as in this example: `http://doc.s3.amazonaws.com/2006-03-01/AmazonS3.wsdl`, where `doc` is the name of the bucket, and `2006-03-01/AmazonS3.wsdl` is the key\.
[AWS Import/Export](#AWSImportExport): The name of an object in Amazon S3\. It is a sequence of Unicode characters whose UTF\-8 encoding cannot exceed 1024 bytes\. If a key, for example, logPrefix \+ import\-log\-JOBID, is longer than 1024 bytes, [AWS Elastic Beanstalk](#Beanstalk) returns an `InvalidManifestField` error\. 
[IAM](#IAM): In a [policy](#policy), a specific characteristic that is the basis for restricting access \(such as the current time, or the IP address of the requester\)\.
Tagging resources: A general [tag](#tag) label that acts like a category for more specific tag values\. For example, you might have [EC2 instance](#ec2instance) with the tag key of *Owner* and the tag value of *Jan*\. You can tag an AWS [resource](#resource) with up to 10 key–value pairs\. Not all AWS resources can be tagged\.

**key pair**<a name="keypair"></a>  
A set of security credentials that you use to prove your identity electronically\. A key pair consists of a private key and a public key\.

**key prefix**<a name="keyprefix"></a>  
A logical grouping of the objects in a [bucket](#bucket)\. The prefix value is similar to a directory name that enables you to store similar data under the same directory in a bucket\.

**kibibyte**<a name="kibibyte"></a>  
A contraction of kilo binary byte, a kibibyte is 2^10 or 1,024 bytes\. A kilobyte \(KB\) is 10^3 or 1,000 bytes\. 1,024 KiB is a [mebibyte](#mebibyte)\.

**KMS**   
See [AWS Key Management Service \(AWS KMS\)](#AWS_KMS).

### L<a name="L"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**labeled data**<a name="labeled-data"></a>  
In machine learning, data for which you already know the target or “correct” answer\.

**launch configuration**<a name="launchconfiguration"></a>  
A set of descriptive parameters used to create new [EC2 instance](#ec2instance)s in an [Amazon EC2 Auto Scaling](#AutoScaling) activity\.   
A template that an [Auto Scaling group](#AutoScalingGroup) uses to launch new EC2 instances\. The launch configuration contains information such as the [Amazon Machine Image \(AMI\)](#AmazonMachineImage) ID, the instance type, key pairs, [security group](#SecurityGroup)s, and block device mappings, among other configuration settings\.

**launch permission**<a name="launchpermission"></a>  
An [Amazon Machine Image \(AMI\)](#AmazonMachineImage) attribute that allows users to launch an AMI\. 

**lifecycle**<a name="lifecycle"></a>  
The lifecycle state of the [EC2 instance](#ec2instance) contained in an [Auto Scaling group](#AutoScalingGroup)\. EC2 instances progress through several states over their lifespan; these include *Pending*, *InService*, *Terminating* and *Terminated*\. 

**lifecycle action**<a name="lifecycleaction"></a>  
An action that can be paused by Auto Scaling, such as launching or terminating an EC2 instance\.

**lifecycle hook**<a name="lifecyclehook"></a>  
Enables you to pause Auto Scaling after it launches or terminates an EC2 instance so that you can perform a custom action while the instance is not in service\.

**link to VPC**<a name="LinkToVpc"></a>  
The process of linking \(or attaching\) an EC2\-Classic [instance](#instance) to a ClassicLink\-enabled [VPC](#VPC)\.    
See also . 
See also .

**load balancer**<a name="loadbalancer"></a>  
A DNS name combined with a set of ports, which together provide a destination for all requests intended for your application\. A load balancer can distribute traffic to multiple application instances across every [Availability Zone](#AZ) within a [Region](#region)\. Load balancers can span multiple Availability Zones within an AWS Region into which an [Amazon EC2](#ec2) instance was launched\. But load balancers cannot span multiple Regions\. 

**local secondary index**<a name="local-secondary-index"></a>  
An index that has the same partition key as the table, but a different sort key\. A local secondary index is local in the sense that every partition of a local secondary index is scoped to a table partition that has the same partition key value\.   
See also .

**logical name**<a name="logical-name"></a>  
A case\-sensitive unique string within an [AWS CloudFormation](#CloudFormation) template that identifies a [resource](#resource), [mapping](#mapping), parameter, or output\. In an AWS CloudFormation template, each parameter, [resource](#resource), property, mapping, and output must be declared with a unique logical name\. You use the logical name when dereferencing these items using the `Ref` function\.

### M<a name="M"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**Mail Transfer Agent \(MTA\)**<a name="mailtransferagent"></a>  
Software that transports email messages from one computer to another by using a client\-server architecture\.

**mailbox provider**<a name="mailboxprovider"></a>  
An organization that provides email mailbox hosting services\. Mailbox providers are sometimes referred to as [internet service provider](#internetserviceprovider)s, even if they only provide mailbox services\.

**mailbox simulator**<a name="mailboxsimulator"></a>  
A set of email addresses that you can use to test an [Amazon SES](#SES)\-based email sending application without sending messages to actual recipients\. Each email address represents a specific scenario \(such as a bounce or complaint\) and generates a typical response that is specific to the scenario\.

**main route table**<a name="MainRouteTable"></a>  
The default [route table](#routetable) that any new [VPC](#VPC) [subnet](#subnet) uses for routing\. You can associate a subnet with a different route table of your choice\. You can also change which route table is the main route table\.

**managed policy**<a name="managed_policy"></a>  
A standalone [IAM](#IAM) [policy](#policy) that you can attach to multiple [user](#AWSUser)s, [group](#group)s, and [role](#role)s in your IAM [account](#account)\. Managed policies can either be AWS managed policies \(which are created and managed by AWS\) or customer managed policies \(which you create and manage in your AWS account\)\.

**manifest**<a name="manifest"></a>  
When sending a *create job* request for an import or export operation, you describe your job in a text file called a manifest\. The manifest file is a YAML\-formatted file that specifies how to transfer data between your storage device and the AWS Cloud\.

**manifest file**<a name="manifest-file"></a>  
Amazon Machine Learning: The file used for describing batch predictions\. The manifest file relates each input data file with its associated batch prediction results\. It is stored in the Amazon S3 output location\.

**mapping**<a name="mapping"></a>  
A way to add conditional parameter values to an [AWS CloudFormation](#CloudFormation) template\. You specify mappings in the template's optional Mappings section and retrieve the desired value using the `FN::FindInMap` function\.

**marker**   
See [pagination token](#PaginationToken).

**master node**<a name="masternode"></a>  
A process running on an [Amazon Machine Image \(AMI\)](#AmazonMachineImage) that keeps track of the work its core and task nodes complete\. 

**maximum price**<a name="maxprice"></a>  
 The maximum price you will pay to launch one or more [Spot Instance](#SpotInstance)s\. If your maximum price exceeds the current [Spot price](#SpotPrice) and your restrictions are met, [Amazon EC2](#ec2) launches instances on your behalf\. 

**maximum send rate**<a name="maximumsendrate"></a>  
The maximum number of email messages that you can send per second using [Amazon SES](#SES)\.

**mebibyte**<a name="mebibyte"></a>  
A contraction of mega binary byte, a mebibyte is 2^20 or 1,048,576 bytes\. A megabyte \(MB\) is 10^6 or 1,000,000 bytes\. 1,024 MiB is a [gibibyte](#gibibyte)\.

**member resources**   
See [resource](#resource).

**message ID**<a name="messageID"></a>  
[Amazon Simple Email Service \(Amazon SES\)](#SES): A unique identifier that is assigned to every email message that is sent\.  
[Amazon Simple Queue Service \(Amazon SQS\)](#AmazonSimpleQueueService): The identifier returned when you send a message to a queue\.

**metadata**<a name="metadata"></a>  
Information about other data or objects\. In [Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService) and [Amazon EMR \(Amazon EMR\)](#AmazonElasticMapReduce) metadata takes the form of name–value pairs that describe the object\. These include default metadata such as the date last modified and standard HTTP metadata such as Content\-Type\. Users can also specify custom metadata at the time they store an object\. In [Amazon Elastic Compute Cloud \(Amazon EC2\)](#ec2) metadata includes data about an [EC2 instance](#ec2instance) that the instance can retrieve to determine things about itself, such as the instance type, the IP address, and so on\.

**metric**<a name="metric"></a>  
An element of time\-series data defined by a unique combination of exactly one [namespace](#namespace), exactly one metric name, and between zero and ten dimensions\. Metrics and the statistics derived from them are the basis of [Amazon CloudWatch](#AmazonCW)\.

**metric name**<a name="metricname"></a>  
The primary identifier of a metric, used in combination with a [namespace](#namespace) and optional dimensions\.

**MFA**   
See [multi\-factor authentication \(MFA\)](#AWSMultiFactorAuthentication).

**micro instance**<a name="MicroInstance"></a>  
 A type of [EC2 instance](#ec2instance) that is more economical to use if you have occasional bursts of high CPU activity\.

**MIME**   
See [Multipurpose Internet Mail Extensions \(MIME\)](#multipurposeinternetmailextensions).

**ML model**<a name="ml-model"></a>  
In machine learning \(ML\), a mathematical model that generates predictions by finding patterns in data\. Amazon Machine Learning supports three types of ML models: binary classification, multiclass classification, and regression\. Also known as a *predictive model*\.   
See also . 
See also . 
See also .

**MTA**   
See [Mail Transfer Agent \(MTA\)](#mailtransferagent).

**Multi\-AZ deployment**<a name="multiAZ"></a>  
A primary [DB instance](#dbinstance) that has a synchronous standby replica in a different [Availability Zone](#AZ)\. The primary DB instance is synchronously replicated across Availability Zones to the standby replica\.

**multiclass classification model**<a name="multiclass-classification-model"></a>  
A machine learning model that predicts values that belong to a limited, pre\-defined set of permissible values\. For example, "Is this product a book, movie, or clothing?"

**multi\-factor authentication \(MFA\)**<a name="AWSMultiFactorAuthentication"></a>  
An optional AWS [account](#account) security feature\. Once you enable AWS MFA, you must provide a six\-digit, single\-use code in addition to your sign\-in credentials whenever you access secure AWS webpages or the [AWS Management Console](#AWSManagementConsole)\. You get this single\-use code from an authentication device that you keep in your physical possession\.   
See also [https://aws\.amazon\.com/mfa/](https://aws.amazon.com/mfa/).

**multi\-valued attribute**<a name="multivalattrib"></a>  
An attribute with more than one value\.

**multipart upload**<a name="multipartupload"></a>  
A feature that allows you to upload a single object as a set of parts\.

**Multipurpose Internet Mail Extensions \(MIME\)**<a name="multipurposeinternetmailextensions"></a>  
An internet standard that extends the email protocol to include non\-ASCII text and nontext elements like attachments\.

**Multitool**<a name="Multitool"></a>  
A cascading application that provides a simple command\-line interface for managing large datasets\. 

### N<a name="N"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**namespace**<a name="namespace"></a>  
An abstract container that provides context for the items \(names, or technical terms, or words\) it holds, and allows disambiguation of homonym items residing in different namespaces\.

**NAT**<a name="nat"></a>  
Network address translation\. A strategy of mapping one or more IP addresses to another while data packets are in transit across a traffic routing device\. This is commonly used to restrict internet communication to private instances while allowing outgoing traffic\.    
See also . 
See also . 
See also .

**NAT gateway**<a name="natGateway"></a>  
A [NAT](#nat) device, managed by AWS, that performs network address translation in a private [subnet](#subnet), to secure inbound internet traffic\. A NAT gateway uses both NAT and port address translation\.   
See also .

**NAT instance**<a name="natInstance"></a>  
A [NAT](#nat) device, configured by a user, that performs network address translation in a [VPC](#VPC) public [subnet](#subnet) to secure inbound internet traffic\.    
See also .

**network ACL**<a name="NetworkACL"></a>  
An optional layer of security that acts as a firewall for controlling traffic in and out of a [subnet](#subnet)\. You can associate multiple subnets with a single network [ACL](#ACL), but a subnet can be associated with only one network ACL at a time\.

**Network Address Translation and Protocol Translation**<a name="networkAddressTranslation"></a>  
\([NAT](#nat)\-PT\) An internet protocol standard defined in RFC 2766\.   
See also . 
See also .

**n\-gram processor**<a name="n-gram-processor"></a>  
A processor that performs n\-gram transformations\.   
See also .

**n\-gram transformation**<a name="n-gram-transformation"></a>  
Amazon Machine Learning: A transformation that aids in text string analysis\. An n\-gram transformation takes a text variable as input and outputs strings by sliding a window of size *n* words, where *n* is specified by the user, over the text, and outputting every string of words of size *n* and all smaller sizes\. For example, specifying the n\-gram transformation with window size =2 returns all the two\-word combinations and all of the single words\.

**NICE Desktop Cloud Visualization**<a name="dcv"></a>  
A remote visualization technology for securely connecting users to graphic\-intensive 3D applications hosted on a remote, high\-performance server\. 

**node**<a name="node"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): An Elasticsearch instance\. A node can be either a data instance or a dedicated master instance\.   
See also .

**NoEcho**<a name="noecho"></a>  
A property of [AWS CloudFormation](#CloudFormation) parameters that prevent the otherwise default reporting of names and values of a template parameter\. Declaring the `NoEcho` property causes the parameter value to be masked with asterisks in the report by the `cfn-describe-stacks` command\.

**NoSQL**<a name="nosql"></a>  
Nonrelational database systems that are highly available, scalable, and optimized for high performance\. Instead of the relational model, NoSQL databases \(like [Amazon DynamoDB](#dynamodb)\) use alternate models for data management, such as key–value pairs or document storage\. 

**null object**<a name="nullobject"></a>  
A null object is one whose version ID is null\. [Amazon S3](#AmazonSimpleStorageService) adds a null object to a [bucket](#bucket) when [versioning](#versioning) for that bucket is suspended\. It is possible to have only one null object for each key in a bucket\.

**number of passes**<a name="number-of-passes"></a>  
The number of times that you allow Amazon Machine Learning to use the same data records to train a machine learning model\.

### O<a name="O"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**object**<a name="object"></a>  
[Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService): The fundamental entity type stored in Amazon S3\. Objects consist of object data and metadata\. The data portion is opaque to Amazon S3\.  
[Amazon CloudFront](#AmazonCF): Any entity that can be served either over HTTP or a version of RTMP\.

**observation**<a name="observation"></a>  
Amazon Machine Learning: A single instance of data that Amazon Machine Learning \(Amazon ML\) uses to either train a machine learning model how to predict or to generate a prediction\. Each row in an Amazon ML input data file is an observation\.

**On\-Demand Instance**<a name="ondemandinstance"></a>  
An [Amazon EC2](#ec2) pricing option that charges you for compute capacity by the hour with no long\-term commitment\.

**operation**<a name="operation"></a>  
An API function\. Also called an *action*\.

**optimistic locking**<a name="optimistic-locking"></a>  
A strategy to ensure that an item that you want to update has not been modified by others before you perform the update\. For [Amazon DynamoDB](#dynamodb), optimistic locking support is provided by the AWS SDKs\.

**organization**<a name="organization"></a>  
[AWS Organizations](#awsorganizations): An entity that you create to consolidate and manage your AWS accounts\. An organization has one master account along with zero or more member accounts\.

**organizational unit**<a name="organizational-unit"></a>  
[AWS Organizations](#awsorganizations): A container for accounts within a [root](#root) of an organization\. An organizational unit \(OU\) can contain other OUs\.

**origin access identity**<a name="originaccessidentity"></a>  
Also called OAI\. When using [Amazon CloudFront](#AmazonCF) to serve content with an [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket) as the origin, a virtual identity that you use to require users to access your content through CloudFront URLs instead of Amazon S3 URLs\. Usually used with CloudFront [private content](#privatecontent)\. 

**origin server**<a name="originserver"></a>  
The [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket) or custom origin containing the definitive original version of the content you deliver through [CloudFront](#AmazonCF)\.

**original environment**<a name="originalenvironment"></a>  
The instances in a deployment group at the start of an CodeDeploy blue/green deployment\.

**OSB transformation**<a name="osb-transformation"></a>  
Orthogonal sparse bigram transformation\. In machine learning, a transformation that aids in text string analysis and that is an alternative to the n\-gram transformation\. OSB transformations are generated by sliding the window of size *n* words over the text, and outputting every pair of words that includes the first word in the window\.   
See also .

**OU**   
See [organizational unit](#organizational-unit).

**output location**<a name="output-location"></a>  
Amazon Machine Learning: An Amazon S3 location where the results of a batch prediction are stored\.

### P<a name="P"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**pagination**<a name="Pagination"></a>  
The process of responding to an API request by returning a large list of records in small separate parts\. Pagination can occur in the following situations:  
+ The client sets the maximum number of returned records to a value below the total number of records\.
+ The service has a default maximum number of returned records that is lower than the total number of records\.
When an API response is paginated, the service sends a subset of the large list of records and a pagination token that indicates that more records are available\. The client includes this pagination token in a subsequent API request, and the service responds with the next subset of records\. This continues until the service responds with a subset of records and no pagination token, indicating that all records have been sent\. 

**pagination token**<a name="PaginationToken"></a>  
A marker that indicates that an API response contains a subset of a larger list of records\. The client can return this marker in a subsequent API request to retrieve the next subset of records until the service responds with a subset of records and no pagination token, indicating that all records have been sent\.    
See also .

**paid AMI**<a name="paidAMI"></a>  
An [Amazon Machine Image \(AMI\)](#AmazonMachineImage) that you sell to other [Amazon EC2](#ec2) users on [AWS Marketplace](#marketplace)\.

**paravirtual virtualization**<a name="paravirtual"></a>   
See [PV virtualization](#PV).

**part**<a name="part"></a>  
A contiguous portion of the object's data in a multipart upload request\.

**partition key**<a name="partition-key"></a>  
A simple primary key, composed of one attribute \(also known as a *hash attribute*\)\.   
See also . 
See also .

**PAT**<a name="pat"></a>  
Port address translation\. 

**pebibyte**<a name="pebibyte"></a>  
A contraction of peta binary byte, a pebibyte is 2^50 or 1,125,899,906,842,624 bytes\. A petabyte \(PB\) is 10^15 or 1,000,000,000,000,000 bytes\. 1,024 PiB is an [exbibyte](#exbibyte)\.

**period**   
See [sampling period](#SamplingPeriod).

**permission**<a name="permission"></a>  
A statement within a [policy](#policy) that allows or denies access to a particular [resource](#resource)\. You can state any permission like this: "A has permission to do B to C\." For example, Jane \(A\) has permission to read messages \(B\) from John's [Amazon SQS](#AmazonSimpleQueueService) queue \(C\)\. Whenever Jane sends a request to Amazon SQS to use John's queue, the service checks to see if she has permission\. It further checks to see if the request satisfies the conditions John set forth in the permission\.

**persistent storage**<a name="persistentstorage"></a>  
A data storage solution where the data remains intact until it is deleted\. Options within [AWS](#amazonwebservices) include: [Amazon S3](#AmazonSimpleStorageService), [Amazon RDS](#AmazonRelationalDatabaseService), [Amazon DynamoDB](#dynamodb), and other services\.

**physical name**<a name="physical-name"></a>  
A unique label that [AWS CloudFormation](#CloudFormation) assigns to each [resource](#resource) when creating a [stack](#stack)\. Some AWS CloudFormation commands accept the physical name as a value with the `--physical-name` parameter\.

**pipeline**<a name="pipeline"></a>  
[AWS CodePipeline](#AWSCodePipeline): A workflow construct that defines the way software changes go through a release process\.

**plaintext**<a name="plain_text"></a>  
Information that has not been [encrypted](#encrypt), as opposed to [ciphertext](#cipher_text)\.

**policy**<a name="policy"></a>  
[IAM](#IAM): A document defining permissions that apply to a user, group, or role; the permissions in turn determine what users can do in AWS\. A policy typically [allow](#allow)s access to specific actions, and can optionally grant that the actions are allowed for specific [resource](#resource)s, like [EC2 instance](#ec2instance)s, [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket)s, and so on\. Policies can also explicitly [deny](#deny) access\.  
[Amazon EC2 Auto Scaling](#AutoScaling): An object that stores the information needed to launch or terminate instances for an Auto Scaling group\. Executing the policy causes instances to be launched or terminated\. You can configure an [alarm](#alarm) to invoke an Auto Scaling policy\.

**policy generator**<a name="policy_generator"></a>  
A tool in the [IAM](#IAM) [AWS Management Console](#AWSManagementConsole) that helps you build a [policy](#policy) by selecting elements from lists of available options\. 

**policy simulator**<a name="policy_simulator"></a>  
A tool in the [IAM](#IAM) [AWS Management Console](#AWSManagementConsole) that helps you test and troubleshoot [policies](#policy) so you can see their effects in real\-world scenarios\. 

**policy validator**<a name="policy_validator"></a>  
A tool in the [IAM](#IAM) [AWS Management Console](#AWSManagementConsole) that examines your existing IAM access control [policies](#policy) to ensure that they comply with the IAM policy grammar\.

**presigned URL**<a name="presignedURL"></a>  
A web address that uses [query string authentication](#querystringauthentication)\. 

**prefix**   
See [job prefix](#jobprefix).

**Premium Support**<a name="PremiumSupport"></a>  
A one\-on\-one, fast\-response support channel that AWS customers can subscribe to for support for AWS infrastructure services\.    
See also [https://aws\.amazon\.com/premiumsupport/](https://aws.amazon.com/premiumsupport/).

**primary key**<a name="primary-key"></a>  
One or two attributes that uniquely identify each item in a [Amazon DynamoDB](#dynamodb) table, so that no two items can have the same key\.   
See also . 
See also .

**primary shard**<a name="primary-shard"></a>   
See [shard](#shard).

**principal**<a name="principal"></a>  
The [user](#AWSUser), service, or [account](#account) that receives permissions that are defined in a [policy](#policy)\. The principal is A in the statement "A has permission to do B to C\."

**private content**<a name="privatecontent"></a>  
When using [Amazon CloudFront](#AmazonCF) to serve content with an [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket) as the origin, a method of controlling access to your content by requiring users to use signed URLs\. Signed URLs can restrict user access based on the current date and time and/or the IP addresses that the requests originate from\.

**private IP address**<a name="privateIP"></a>  
A private numerical address \(for example, 192\.0\.2\.44\) that networked devices use to communicate with one another using the Internet Protocol \(IP\)\. All [EC2 instance](#ec2instance)ss are assigned two IP addresses at launch, which are directly mapped to each other through network address translation \([NAT](#nat)\): a private address \(following RFC 1918\) and a public address\. *Exception:* Instances launched in [Amazon VPC](#AmazonVirtualPrivateCloud) are assigned only a private IP address\.

**private subnet**<a name="privateSubnet"></a>  
A [VPC](#VPC) [subnet](#subnet) whose instances cannot be reached from the internet\.

**product code**<a name="productcode"></a>  
An identifier provided by AWS when you submit a product to [AWS Marketplace](#marketplace)\.

**properties**   
See [resource property](#resourceproperty).

**property rule**<a name="property-rule"></a>  
A [JSON](#json)\-compliant markup standard for declaring properties, mappings, and output values in an [AWS CloudFormation](#CloudFormation) template\. 

**Provisioned IOPS**<a name="provisionedIOPS"></a>  
A storage option designed to deliver fast, predictable, and consistent I/O performance\. When you specify an IOPS rate while creating a DB instance, [Amazon RDS](#AmazonRelationalDatabaseService) provisions that IOPS rate for the lifetime of the DB instance\.

**pseudo parameter**<a name="pseudoparameter"></a>  
A predefined setting, such as `AWS:StackName` that can be used in [AWS CloudFormation](#CloudFormation) templates without having to declare them\. You can use pseudo parameters anywhere you can use a regular parameter\.

**public AMI**<a name="publicAMI"></a>  
An [Amazon Machine Image \(AMI\)](#AmazonMachineImage) that all AWS [account](#account)s have permission to launch\.

**public dataset**<a name="publicdataset"></a>  
A large collection of public information that can be seamlessly integrated into applications that are based in the AWS Cloud\. Amazon stores public datasets at no charge to the community and, like all AWS services, users pay only for the compute and storage they use for their own applications\. These datasets currently include data from the Human Genome Project, the U\.S\. Census, Wikipedia, and other sources\.    
See also [https://aws\.amazon\.com/publicdatasets](https://aws.amazon.com/publicdatasets/).

**public IP address**<a name="publicIP"></a>  
A public numerical address \(for example, 192\.0\.2\.44\) that networked devices use to communicate with one another using the Internet Protocol \(IP\)\. [EC2 instance](#ec2instance)s are assigned two IP addresses at launch, which are directly mapped to each other through Network Address Translation \([NAT](#nat)\): a private address \(following RFC 1918\) and a public address\. *Exception:* Instances launched in [Amazon VPC](#AmazonVirtualPrivateCloud) are assigned only a private IP address\.

**public subnet**<a name="publicSubnet"></a>  
A [subnet](#subnet) whose instances can be reached from the internet\.

**PV virtualization**<a name="PV"></a>  
Paravirtual virtualization\. Allows guest VMs to run on host systems that do not have special support extensions for full hardware and CPU virtualization\. Because PV guests run a modified operating system that does not use hardware emulation, they cannot provide hardware\-related features such as enhanced networking or GPU support\.   
See also .

### Q<a name="Q"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**quartile binning transformation**<a name="quartile-binning-transformation"></a>  
Amazon Machine Learning: A process that takes two inputs, a numerical variable and a parameter called a bin number, and outputs a categorical variable\. Quartile binning transformations discover non\-linearity in a variable's distribution by enabling the machine learning model to learn separate importance values for parts of the numeric variable’s distribution\.

**Query**<a name="Query"></a>  
A type of web service that generally uses only the GET or POST HTTP method and a query string with parameters in the URL\.   
See also .

**query string authentication**<a name="querystringauthentication"></a>  
An AWS feature that lets you place the authentication information in the HTTP request query string instead of in the `Authorization` header, which enables URL\-based access to objects in a [bucket](#bucket)\.

**queue**<a name="queue"></a>  
A sequence of messages or jobs that are held in temporary storage awaiting transmission or processing\. 

**queue URL**<a name="queueURL"></a>  
A web address that uniquely identifies a queue\.

**quota**<a name="quota"></a>  
[Amazon RDS](#AmazonRelationalDatabaseService): The maximum number of [DB instance](#dbinstance)s and available storage you can use\.  
[Amazon ElastiCache](#elasticache): The maximum number of the following items:  
+ The number of cache clusters for each AWS [account](#account)
+ The number of cache nodes per cache cluster
+ The total number of cache nodes per AWS account across all cache clusters created by that AWS account

### R<a name="R"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**range GET**<a name="rangeGET"></a>  
A request that specifies a byte range of data to get for a download\. If an object is large, you can break up a download into smaller units by sending multiple range GET requests that each specify a different byte range to GET\. 

**raw email**<a name="rawemail"></a>  
A type of *sendmail* request with which you can specify the email headers and MIME types\. 

**RDS**   
See [Amazon Relational Database Service \(Amazon RDS\)](#AmazonRelationalDatabaseService).

**read replica**<a name="readreplica"></a>  
[Amazon RDS](#AmazonRelationalDatabaseService): An active copy of another DB instance\. Any updates to the data on the source DB instance are replicated to the read replica DB instance using the built\-in replication feature of MySQL 5\.1\.

**real\-time predictions**<a name="real-time-predictions"></a>  
Amazon Machine Learning: Synchronously generated predictions for individual data observations\.   
See also .

**receipt handle**<a name="receipthandle"></a>  
[Amazon SQS](#AmazonSimpleQueueService): An identifier that you get when you receive a message from the queue\. This identifier is required to delete a message from the queue or when changing a message's visibility timeout\.

**receiver**<a name="receiver"></a>  
The entity that consists of the network systems, software, and policies that manage email delivery for a [recipient](#recipient)\. 

**recipient**<a name="recipient"></a>  
[Amazon Simple Email Service \(Amazon SES\)](#SES): The person or entity receiving an email message\. For example, a person named in the "To" field of a message\.

**Redis**<a name="redis"></a>  
A fast, open\-source, in\-memory key\-value data structure store\. Redis comes with a set of versatile in\-memory data structures with which you can easily create a variety of custom applications\.

**reference**<a name="prop_reference"></a>  
A means of inserting a property from one AWS [resource](#resource) into another\. For example, you could insert an [Amazon EC2](#ec2) [security group](#SecurityGroup) property into an [Amazon RDS](#AmazonRelationalDatabaseService) resource\.

**Region**<a name="region"></a>  
A named set of AWS [resource](#resource)s in the same geographical area\. A Region comprises at least two [Availability Zone](#AZ)s\.

**regression model**<a name="recipe"></a>  
Amazon Machine Learning: Preformatted instructions for common data transformations that fine\-tune machine learning model performance\.

**regression model**<a name="regression-model"></a>  
A type of machine learning model that predicts a numeric value, such as the exact purchase price of a house\.

**regularization**<a name="regularization"></a>  
A machine learning \(ML\) parameter that you can tune to obtain higher\-quality ML models\. Regularization helps prevent ML models from memorizing training data examples instead of learning how to generalize the patterns it sees \(called overfitting\)\. When training data is overfitted, the ML model performs well on the training data but does not perform well on the evaluation data or on new data\.

**replacement environment**<a name="replacementenvironment"></a>  
The instances in a deployment group after the CodeDeploy blue/green deployment\.

**replica shard**<a name="replica-shard"></a>   
See [shard](#shard).

**reply path**<a name="replypath"></a>  
The email address to which an email reply is sent\. This is different from the [return path](#returnpath)\.

**representational state transfer**   
See [REST](#REST).

**reputation**<a name="reputation"></a>  
1\. An [Amazon SES](#SES) metric, based on factors that might include [bounce](#bounce)s, [complaint](#complaint)s, and other metrics, regarding whether or not a customer is sending high\-quality email\.  
2\. A measure of confidence, as judged by an [internet service provider](#internetserviceprovider) or other entity that an IP address that they are receiving email from is not the source of [spam](#spam)\.

**requester**<a name="requester"></a>  
The person \(or application\) that sends a request to AWS to perform a specific action\. When AWS receives a request, it first evaluates the requester's permissions to determine whether the requester is allowed to perform the request action \(if applicable, for the requested [resource](#resource)\)\.

**Requester Pays**<a name="RequesterPays"></a>  
An [Amazon S3](#AmazonSimpleStorageService) feature that allows a [bucket owner](#bucketowner) to specify that anyone who requests access to objects in a particular [bucket](#bucket) must pay the data transfer and request costs\.

**reservation**<a name="reservation"></a>  
A collection of [EC2 instance](#ec2instance)s started as part of the same launch request\. Not to be confused with a [Reserved Instance](#reservedinstance)\.

**Reserved Instance**<a name="reservedinstance"></a>  
A pricing option for [EC2 instance](#ec2instance)s that discounts the [on\-demand](#ondemandinstance) usage charge for instances that meet the specified parameters\. Customers pay for the entire term of the instance, regardless of how they use it\.

**Reserved Instance Marketplace**<a name="reservedinstancemarketplace"></a>  
An online exchange that matches sellers who have reserved capacity that they no longer need with buyers who are looking to purchase additional capacity\. [Reserved Instance](#reservedinstance)s that you purchase from third\-party sellers have less than a full standard term remaining and can be sold at different upfront prices\. The usage or reoccurring fees remain the same as the fees set when the Reserved Instances were originally purchased\. Full standard terms for Reserved Instances available from AWS run for one year or three years\.

**resource**<a name="resource"></a>  
An entity that users can work with in AWS, such as an [EC2 instance](#ec2instance), an [Amazon DynamoDB](#dynamodb) table, an [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket), an [IAM](#IAM) user, an [AWS OpsWorks](#opsworks) [stack](#stack), and so on\.

**resource property**<a name="resourceproperty"></a>  
A value required when including an AWS [resource](#resource) in an [AWS CloudFormation](#CloudFormation) [stack](#stack)\. Each resource may have one or more properties associated with it\. For example, an `AWS::EC2::Instance` resource may have a `UserData` property\. In an AWS CloudFormation template, resources must declare a properties section, even if the resource has no properties\.

**resource record**<a name="resourcerecord"></a>  
Also called *resource record set*\. The fundamental information elements in the Domain Name System \(DNS\)\.   
See also [Domain Name System](http://en.wikipedia.org/wiki/Domain_Name_System).

**REST**<a name="REST"></a>  
Representational state transfer\. A simple stateless architecture that generally runs over HTTPS/TLS\. REST emphasizes that resources have unique and hierarchical identifiers \(URIs\), are represented by common media types \(HTML, XML, [JSON](#json), and so on\), and that operations on the resources are either predefined or discoverable within the media type\. In practice, this generally results in a limited number of operations\.   
See also . 
See also . 
See also .

**RESTful web service**<a name="RESTful"></a>  
Also known as RESTful API\. A web service that follows [REST](#REST) architectural constraints\. The API operations must use HTTP methods explicitly; expose hierarchical URIs; and transfer either XML, [JSON](#json), or both\. 

**return enabled**<a name="returnenabled"></a>  
[Amazon CloudSearch](#cloudSearch): An index field option that enables the field's values to be returned in the search results\.

**return path**<a name="returnpath"></a>  
The email address to which bounced email is returned\. The return path is specified in the header of the original email\. This is different from the [reply path](#replypath)\.

**revision**<a name="revision"></a>  
[AWS CodePipeline](#AWSCodePipeline): A change made to a source that is configured in a source action, such as a pushed commit to a [GitHub](#github) repository or an update to a file in a versioned [Amazon S3](#AmazonSimpleStorageService) [bucket](#bucket)\. 

**role**<a name="role"></a>  
A tool for giving temporary access to AWS [resource](#resource)s in your AWS [account](#account)\.

**rollback**<a name="rollback"></a>  
A return to a previous state that follows the failure to create an object, such as [AWS CloudFormation](#CloudFormation) [stack](#stack)\. All [resource](#resource)s associated with the failure are deleted during the rollback\. For AWS CloudFormation, you can override this behavior using the `--disable-rollback` option on the command line\.

**root**<a name="root"></a>  
[AWS Organizations](#awsorganizations): A parent container for the accounts in your organization\. If you apply a [service control policy](#service-control-policy) to the root, it applies to every [organizational unit](#organizational-unit) and account in the organization\.

**root credentials**<a name="root_credentials"></a>  
Authentication information associated with the AWS [account](#account) owner\. 

**root device volume**<a name="rootdevicevolume"></a>  
A [volume](#volume) that contains the image used to boot the [instance](#instance) \(also known as a *root device*\)\. If you launched the instance from an [AMI](#AmazonMachineImage) backed by [instance store](#instancestore), this is an instance store [volume](#volume) created from a template stored in [Amazon S3](#AmazonSimpleStorageService)\. If you launched the instance from an AMI backed by [Amazon EBS](#EBS), this is an Amazon EBS volume created from an Amazon EBS snapshot\.

**route table**<a name="routetable"></a>  
A set of routing rules that controls the traffic leaving any [subnet](#subnet) that is associated with the route table\. You can associate multiple subnets with a single route table, but a subnet can be associated with only one route table at a time\.

**row identifier**<a name="row-identifier"></a>  
Amazon Machine Learning: An attribute in the input data that you can include in the evaluation or prediction output to make it easier to associate a prediction with an observation\.

**rule**<a name="rule"></a>  
[AWS WAF](#awswaf): A set of conditions that AWS WAF searches for in web requests to AWS [resource](#resource)s such as [Amazon CloudFront](#AmazonCF) distributions\. You add rules to a [web ACL](#webacl), and then specify whether you want to allow or block web requests based on each rule\.

### S<a name="S"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**S3**   
See [Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService).

**sampling period**<a name="SamplingPeriod"></a>  
A defined duration of time, such as one minute, over which [Amazon CloudWatch](#AmazonCW) computes a [statistic](#statistic)\. 

**sandbox**<a name="sandbox"></a>  
A testing location where you can test the functionality of your application without affecting production, incurring charges, or purchasing products\.  
[Amazon SES](#SES): An environment that is designed for developers to test and evaluate the service\. In the sandbox, you have full access to the Amazon SES API, but you can only send messages to verified email addresses and the mailbox simulator\. To get out of the sandbox, you need to apply for production access\. Accounts in the sandbox also have lower [sending limits](#sendinglimits) than production accounts\.

**scale in**<a name="scale-in"></a>  
To remove EC2 instances from an [Auto Scaling group](#AutoScalingGroup)\.

**scale out**<a name="scale-out"></a>  
To add EC2 instances to an [Auto Scaling group](#AutoScalingGroup)\.

**scaling policy**<a name="scalingpolicy"></a>  
A description of how Auto Scaling should automatically scale an [Auto Scaling group](#AutoScalingGroup) in response to changing demand\.   
See also . 
See also .

**scaling activity**<a name="ScalingActivity"></a>  
A process that changes the size, configuration, or makeup of an [Auto Scaling group](#AutoScalingGroup) by launching or terminating instances\.

**scheduler**<a name="scheduler"></a>  
 The method used for placing [task](#task)s on [container instance](#container_instance)s\. 

**schema**<a name="schema"></a>  
Amazon Machine Learning: The information needed to interpret the input data for a machine learning model, including attribute names and their assigned data types, and the names of special attributes\.

**score cut\-off value**<a name="score-cut-off-value"></a>  
Amazon Machine Learning: A binary classification model outputs a score that ranges from 0 to 1\. To decide whether an observation should be classified as 1 or 0, you pick a classification threshold, or cut\-off, and Amazon ML compares the score against it\. Observations with scores higher than the cut\-off are predicted as target equals 1, and scores lower than the cut\-off are predicted as target equals 0\.

**SCP**   
See [service control policy](#service-control-policy).

**search API**<a name="searchapi"></a>  
[Amazon CloudSearch](#cloudSearch): The API that you use to submit search requests to a [search domain](#searchdomain)\. 

**search domain**<a name="searchdomain"></a>  
[Amazon CloudSearch](#cloudSearch): Encapsulates your searchable data and the search instances that handle your search requests\. You typically set up a separate Amazon CloudSearch domain for each different collection of data that you want to search\.

**search domain configuration**<a name="domainconfig"></a>  
[Amazon CloudSearch](#cloudSearch): An domain's indexing options, [analysis scheme](#analysisscheme)s, [expression](#expression)s, [suggester](#suggester)s, access policies, and scaling and availability options\. 

**search enabled**<a name="searchenabled"></a>  
[Amazon CloudSearch](#cloudSearch): An index field option that enables the field data to be searched\. 

**search endpoint**<a name="searchendpoint"></a>  
[Amazon CloudSearch](#cloudSearch): The URL that you connect to when sending search requests to a search domain\. Each Amazon CloudSearch domain has a unique search endpoint that remains the same for the life of the domain\.

**search index**<a name="searchindex"></a>  
[Amazon CloudSearch](#cloudSearch): A representation of your searchable data that facilitates fast and accurate data retrieval\.

**search instance**<a name="searchinstance"></a>  
[Amazon CloudSearch](#cloudSearch): A compute [resource](#resource) that indexes your data and processes search requests\. An Amazon CloudSearch domain has one or more search instances, each with a finite amount of RAM and CPU resources\. As your data volume grows, more search instances or larger search instances are deployed to contain your indexed data\. When necessary, your index is automatically partitioned across multiple search instances\. As your request volume or complexity increases, each search partition is automatically replicated to provide additional processing capacity\. 

**search request**<a name="searchrequest"></a>  
[Amazon CloudSearch](#cloudSearch): A request that is sent to an Amazon CloudSearch domain's search endpoint to retrieve documents from the index that match particular search criteria\. 

**search result**<a name="searchresult"></a>  
[Amazon CloudSearch](#cloudSearch): A document that matches a search request\. Also referred to as a *search hit*\. 

**secret access key**<a name="SecretAccessKey"></a>  
A key that is used in conjunction with the [access key ID](#accesskeyID) to cryptographically sign programmatic AWS requests\. Signing a request identifies the sender and prevents the request from being altered\. You can generate secret access keys for your AWS [account](#account), individual IAM [user](#AWSUser)s, and temporary sessions\.

**security group**<a name="SecurityGroup"></a>  
A named set of allowed inbound network connections for an instance\. \(Security groups in [Amazon VPC](#AmazonVirtualPrivateCloud) also include support for outbound connections\.\) Each security group consists of a list of protocols, ports, and IP address ranges\. A security group can apply to multiple instances, and multiple groups can regulate a single instance\. 

**sender**<a name="sender"></a>  
The person or entity sending an email message\.

**Sender ID**<a name="SenderID"></a>  
A Microsoft\-controlled version of [SPF](#SPF)\. An email authentication and anti\-spoofing system\. For more information about Sender ID, see [Sender ID](http://wikipedia.org/wiki/Sender_ID) in Wikipedia\.

**sending limits**<a name="sendinglimits"></a>  
The [sending quota](#sendingquota) and [maximum send rate](#maximumsendrate) that are associated with every [Amazon SES](#SES) account\.

**sending quota**<a name="sendingquota"></a>  
The maximum number of email messages that you can send using [Amazon SES](#SES) in a 24\-hour period\.

**server\-side encryption \(SSE\)**<a name="server_side_encryption"></a>  
The [encrypting](#encrypt) of data at the server level\. [Amazon S3](#AmazonSimpleStorageService) supports three modes of server\-side encryption: SSE\-S3, in which Amazon S3 manages the keys; SSE\-C, in which the customer manages the keys; and SSE\-KMS, in which [AWS Key Management Service \(AWS KMS\)](#AWS_KMS) manages keys\.

**service**   
See [Amazon ECS service](#ecs_service).

**service control policy**<a name="service-control-policy"></a>  
[AWS Organizations](#awsorganizations): A policy\-based control that specifies the services and actions that users and roles can use in the accounts that the service control policy \(SCP\) affects\.

**service endpoint**   
See [endpoint](#endpoint).

**service health dashboard**<a name="servicehealthdashboard"></a>  
A web page showing up\-to\-the\-minute information about AWS service availability\. The dashboard is located at [http://status\.aws\.amazon\.com/](http://status.aws.amazon.com/)\.

**Service Quotas**<a name="servicequotas"></a>  
A service for viewing and managing your quotas easily and at scale as your AWS workloads grow\. Quotas, also referred to as limits, are the maximum number of resources that you can create in an AWS account\.

**service role**<a name="servicerole"></a>  
An [IAM](#IAM) [role](#role) that grants permissions to an AWS service so it can access AWS [resource](#resource)s\. The policies that you attach to the service role determine which AWS resources the service can access and what it can do with those resources\.

**SES**   
See [Amazon Simple Email Service \(Amazon SES\)](#SES).

**session**<a name="session"></a>  
The period during which the temporary security credentials provided by [AWS Security Token Service \(AWS STS\)](#STS) allow access to your AWS account\.

**SHA**<a name="SHA"></a>  
Secure Hash Algorithm\. SHA1 is an earlier version of the algorithm, which AWS has deprecated in favor of SHA256\. 

**shard**<a name="shard"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): A partition of data in an index\. You can split an index into multiple shards, which can include primary shards \(original shards\) and replica shards \(copies of the primary shards\)\. Replica shards provide failover, which means that a replica shard is promoted to a primary shard if a cluster node that contains a primary shard fails\. Replica shards also can handle requests\.

**shared AMI**<a name="sharedAMI"></a>  
An [Amazon Machine Image \(AMI\)](#AmazonMachineImage) that a developer builds and makes available for others to use\. 

**shutdown action**<a name="shutdownaction"></a>  
[Amazon EMR](#AmazonElasticMapReduce): A predefined bootstrap action that launches a script that executes a series of commands in parallel before terminating the job flow\. 

**signature**<a name="signature"></a>  
Refers to a *digital signature*, which is a mathematical way to confirm the authenticity of a digital message\. AWS uses signatures to authenticate the requests you send to our web services\. For more information, to [https://aws\.amazon\.com/security](https://aws.amazon.com/security/)\. 

**SIGNATURE file**<a name="SIGNATUREfile"></a>  
[AWS Import/Export](#AWSImportExport): A file you copy to the root directory of your storage device\. The file contains a job ID, manifest file, and a signature\.

**Signature Version 4**<a name="sig_v_4"></a>  
Protocol for authenticating inbound API requests to AWS services in all AWS Regions\.

**Simple Mail Transfer Protocol**   
See [SMTP](#smtp).

**Simple Object Access Protocol**   
See [SOAP](#SOAP).

**Simple Storage Service**   
See [Amazon Simple Storage Service \(Amazon S3\)](#AmazonSimpleStorageService).

**Single Sign\-On**   
See [AWS Single Sign\-On](#aws-sso).

**Single\-AZ DB instance**<a name="singleAZ"></a>  
A standard \(non\-Multi\-AZ\) [DB instance](#dbinstance) that is deployed in one [Availability Zone](#AZ), without a standby replica in another Availability Zone\.    
See also .

**sloppy phrase search**<a name="sloppyphrasesearch"></a>  
A search for a phrase that specifies how close the terms must be to one another to be considered a match\. 

**SMTP**<a name="smtp"></a>  
Simple Mail Transfer Protocol\. The standard that is used to exchange email messages between internet hosts for the purpose of routing and delivery\.

**snapshot**<a name="snapshot"></a>  
[Amazon Elastic Block Store \(Amazon EBS\)](#EBS): A backup of your [volume](#volume)s that is stored in [Amazon S3](#AmazonSimpleStorageService)\. You can use these snapshots as the starting point for new Amazon EBS volumes or to protect your data for long\-term durability\.   
See also .

**SNS**   
See [Amazon Simple Notification Service \(Amazon SNS\)](#SNS).

**SOAP**<a name="SOAP"></a>  
Simple Object Access Protocol\. An XML\-based protocol that lets you exchange information over a particular protocol \(HTTP or SMTP, for example\) between applications\.   
See also . 
See also .

**soft bounce**<a name="softbounce"></a>  
A temporary email delivery failure such as one resulting from a full mailbox\.

**software VPN**<a name="softwarevpn"></a>  
A software appliance\-based VPN connection over the internet\. 

**sort enabled**<a name="sortenabled"></a>  
[Amazon CloudSearch](#cloudSearch): An index field option that enables a field to be used to sort the search results\.

**sort key**<a name="sort-key"></a>  
An attribute used to sort the order of partition keys in a composite primary key \(also known as a *range attribute*\)\.    
See also . 
See also .

**source/destination checking**<a name="sourcedestinationchecking"></a>  
A security measure to verify that an [EC2 instance](#ec2instance) is the origin of all traffic that it sends and the ultimate destination of all traffic that it receives; that is, that the instance is not relaying traffic\. Source/destination checking is enabled by default\. For instances that function as gateways, such as [VPC](#VPC) [NAT](#nat) instances, source/destination checking must be disabled\.

**spam**<a name="spam"></a>  
Unsolicited bulk email\.

**spamtrap**<a name="spamtrap"></a>  
An email address that is set up by an anti\-[spam](#spam) entity, not for correspondence, but to monitor unsolicited email\. This is also called a *honeypot*\.

**SPF**<a name="SPF"></a>  
Sender Policy Framework\. A standard for authenticating email\. 

**Spot Instance**<a name="SpotInstance"></a>  
 A type of [EC2 instance](#ec2instance) that you can bid on to take advantage of unused [Amazon EC2](#ec2) capacity\.

**Spot price**<a name="SpotPrice"></a>  
The price for a [Spot Instance](#SpotInstance) at any given time\. If your maximum price exceeds the current price and your restrictions are met, [Amazon EC2](#ec2) launches instances on your behalf\. 

**SQL injection match condition**<a name="SQLinjectionmatchcondition"></a>  
[AWS WAF](#awswaf): An attribute that specifies the part of web requests, such as a header or a query string, that AWS WAF inspects for malicious SQL code\. Based on the specified conditions, you can configure AWS WAF to allow or block web requests to AWS [resource](#resource)s such as [Amazon CloudFront](#AmazonCF) distributions\. 

**SQS**   
See [Amazon Simple Queue Service \(Amazon SQS\)](#AmazonSimpleQueueService).

**SSE**   
See [server\-side encryption \(SSE\)](#server_side_encryption).

**SSL**<a name="ssl"></a>  
Secure Sockets Layer   
See also .

**SSO**   
See [AWS Single Sign\-On](#aws-sso).

**stack**<a name="stack"></a>  
[AWS CloudFormation](#CloudFormation): A collection of AWS [resource](#resource)s that you create and delete as a single unit\.  
[AWS OpsWorks](#opsworks): A set of instances that you manage collectively, typically because they have a common purpose such as serving PHP applications\. A stack serves as a container and handles tasks that apply to the group of instances as a whole, such as managing applications and cookbooks\.

**station**<a name="stage"></a>  
[AWS CodePipeline](#AWSCodePipeline): A portion of a pipeline workflow where one or more actions are performed\.

**station**<a name="station"></a>  
A place at an AWS facility where your AWS Import/Export data is transferred on to, or off of, your storage device\.

**statistic**<a name="statistic"></a>  
One of five functions of the values submitted for a given [sampling period](#SamplingPeriod)\. These functions are `Maximum`, `Minimum`, `Sum`, `Average`, and `SampleCount`\.

**stem**<a name="stems"></a>  
The common root or substring shared by a set of related words\. 

**stemming**<a name="stemming"></a>  
The process of mapping related words to a common stem\. This enables matching on variants of a word\. For example, a search for "horse" could return matches for horses, horseback, and horsing, as well as horse\. [Amazon CloudSearch](#cloudSearch) supports both dictionary based and algorithmic stemming\.

**step**<a name="step"></a>  
[Amazon EMR](#AmazonElasticMapReduce): A single function applied to the data in a [job flow](#jobflow)\. The sum of all steps comprises a job flow\.

**step type**<a name="steptype"></a>  
[Amazon EMR](#AmazonElasticMapReduce): The type of work done in a step\. There are a limited number of step types, such as moving data from [Amazon S3](#AmazonSimpleStorageService) to [Amazon EC2](#ec2) or from Amazon EC2 to Amazon S3\. 

**sticky session**<a name="stickysession"></a>  
A feature of the [Elastic Load Balancing](#ELB) load balancer that binds a user's session to a specific application instance so that all requests coming from the user during the session are sent to the same application instance\. By contrast, a load balancer defaults to route each request independently to the application instance with the smallest load\. 

**stopping**<a name="stopping"></a>  
The process of filtering stop words from an index or search request\.

**stopword**<a name="stopword"></a>  
A word that is not indexed and is automatically filtered out of search requests because it is either insignificant or so common that including it would result in too many matches to be useful\. Stopwords are language specific\. 

**streaming**<a name="streaming"></a>  
[Amazon EMR \(Amazon EMR\)](#AmazonElasticMapReduce): A utility that comes with [Hadoop](#Hadoop) that enables you to develop MapReduce executables in languages other than Java\.   
[Amazon CloudFront](#AmazonCF): The ability to use a media file in real time—as it is transmitted in a steady stream from a server\.

**streaming distribution**<a name="streamingdistribution"></a>  
A special kind of [distribution](#distribution) that serves streamed media files using a Real Time Messaging Protocol \(RTMP\) connection\.

**Streams**   
See [Amazon Kinesis Data Streams](#AmazonKinesisStreams).

**string\-to\-sign**<a name="string-to-sign"></a>  
Before you calculate an [HMAC](#HMAC) signature, you first assemble the required components in a canonical order\. The preencrypted string is the string\-to\-sign\.

**string match condition**<a name="stringmatchcondition"></a>  
[AWS WAF](#awswaf): An attribute that specifies the strings that AWS WAF searches for in a web request, such as a value in a header or a query string\. Based on the specified strings, you can configure AWS WAF to allow or block web requests to AWS [resource](#resource)s such as [CloudFront](#AmazonCF) distributions\.

**strongly consistent read**<a name="strongly-consistent-read"></a>  
A read process that returns a response with the most up\-to\-date data, reflecting the updates from all prior write operations that were successful—regardless of the Region\.   
See also . 
See also . 
See also .

**structured query**<a name="structuredquery"></a>  
Search criteria specified using the [Amazon CloudSearch](#cloudSearch) structured query language\. You use the structured query language to construct compound queries that use advanced search options and combine multiple search criteria using Boolean operators\. 

**STS**   
See [AWS Security Token Service \(AWS STS\)](#STS).

**subnet**<a name="subnet"></a>  
A segment of the IP address range of a [VPC](#VPC) that [EC2 instance](#ec2instance)s can be attached to\. You can create subnets to group instances according to security and operational needs\. 

**Subscription button**<a name="Subscriptionbutton"></a>  
An HTML\-coded button that enables an easy way to charge customers a recurring fee\.

**suggester**<a name="suggester"></a>  
[Amazon CloudSearch](#cloudSearch): Specifies an index field you want to use to get autocomplete suggestions and options that can enable fuzzy matches and control how suggestions are sorted\.

**suggestions**<a name="suggestions"></a>  
Documents that contain a match for the partial search string in the field designated by the [suggester](#suggester)\. [Amazon CloudSearch](#cloudSearch) suggestions include the document IDs and field values for each matching document\. To be a match, the string must match the contents of the field starting from the beginning of the field\. 

**supported AMI**<a name="supportedAMI"></a>  
An [Amazon Machine Image \(AMI\)](#AmazonMachineImage) similar to a [paid AMI](#paidAMI), except that the owner charges for additional software or a service that customers use with their own AMIs\.

**SWF**   
See [Amazon Simple Workflow Service \(Amazon SWF\)](#swf).

**symmetric encryption**<a name="symmetric_encryption"></a>  
[Encryption](#encrypt) that uses a private key only\.   
See also .

**synchronous bounce**<a name="synchronousbounce"></a>  
A type of [bounce](#bounce) that occurs while the email servers of the [sender](#sender) and [receiver](#receiver) are actively communicating\.

**synonym**<a name="synonym"></a>  
A word that is the same or nearly the same as an indexed word and that should produce the same results when specified in a search request\. For example, a search for "Rocky Four" or "Rocky 4" should return the fourth *Rocky* movie\. This can be done by designating that `four` and `4` are synonyms for `IV`\. Synonyms are language specific\. 

### T<a name="T"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**table**<a name="table"></a>  
A collection of data\. Similar to other database systems, DynamoDB stores data in tables\. 

**tag**<a name="tag"></a>  
Metadata that you can define and assign to AWS [resource](#resource)s, such as an [EC2 instance](#ec2instance)\. Not all AWS resources can be tagged\.

**tagging**<a name="tagging"></a>  
Tagging resources: Applying a [tag](#tag) to an AWS [resource](#resource)\.  
[Amazon SES](#SES): Also called *labeling*\. A way to format [return path](#returnpath) email addresses so that you can specify a different return path for each recipient of a message\. Tagging enables you to support [VERP](#VERP)\. For example, if Andrew manages a mailing list, he can use the return paths andrew\+recipient1@example\.net and andrew\+recipient2@example\.net so that he can determine which email bounced\.

**target attribute**<a name="target-attribute"></a>  
Amazon Machine Learning \(Amazon ML \): The attribute in the input data that contains the “correct” answers\. Amazon ML uses the target attribute to learn how to make predictions on new data\. For example, if you were building a model for predicting the sale price of a house, the target attribute would be “target sale price in USD\.”

**target revision**<a name="targetrevision"></a>  
[AWS CodeDeploy](#AWSCodeDeploy): The most recent version of the application revision that has been uploaded to the repository and will be deployed to the instances in a deployment group\. In other words, the application revision currently targeted for deployment\. This is also the revision that will be pulled for automatic deployments\.

**task**<a name="task"></a>  
 An instantiation of a [task definition](#task_definition) that is running on a [container instance](#container_instance)\. 

**task definition**<a name="task_definition"></a>  
The blueprint for your task\. Specifies the name of the [task](#task), revisions, [container definition](#container_definition)s, and [volume](#volume) information\. 

**task node**<a name="tasknode"></a>  
An [EC2 instance](#ec2instance) that runs [Hadoop](#Hadoop) map and reduce tasks, but does not store data\. Task nodes are managed by the [master node](#masternode), which assigns Hadoop tasks to nodes and monitors their status\. While a job flow is running you can increase and decrease the number of task nodes\. Because they don't store data and can be added and removed from a job flow, you can use task nodes to manage the EC2 instance capacity your job flow uses, increasing capacity to handle peak loads and decreasing it later\.  
Task nodes only run a TaskTracker Hadoop daemon\.

**tebibyte**<a name="tebibyte"></a>  
A contraction of tera binary byte, a tebibyte is 2^40 or 1,099,511,627,776 bytes\. A terabyte \(TB\) is 10^12 or 1,000,000,000,000 bytes\. 1,024 TiB is a [pebibyte](#pebibyte)\.

**template format version**<a name="template-format-version"></a>  
The version of an [AWS CloudFormation](#CloudFormation) template design that determines the available features\. If you omit the `AWSTemplateFormatVersion` section from your template, AWS CloudFormation assumes the most recent format version\.

**template validation**<a name="template-validation"></a>  
The process of confirming the use of [JSON](#json) code in an [AWS CloudFormation](#CloudFormation) template\. You can validate any AWS CloudFormation template using the `cfn-validate-template` command\.

**temporary security credentials**<a name="temp_security_creds"></a>  
Authentication information that is provided by [AWS STS](#STS) when you call an STS API action\. Includes an [access key ID](#accesskeyID), a [secret access key](#SecretAccessKey), a [session](#session) token, and an expiration time\.

**throttling**<a name="throttling"></a>  
The automatic restricting or slowing down of a process based on one or more limits\. Examples: [Amazon Kinesis Data Streams](#AmazonKinesisStreams) throttles operations if an application \(or group of applications operating on the same stream\) attempts to get data from a shard at a rate faster than the shard limit\. [Amazon API Gateway](#APIGateway) uses throttling to limit the steady\-state request rates for a single account\. [Amazon SES](#SES) uses throttling to reject attempts to send email that exceeds the [sending limits](#sendinglimits)\.

**time series data**<a name="timeseriesdata"></a>  
Data provided as part of a metric\. The time value is assumed to be when the value occurred\. A metric is the fundamental concept for [Amazon CloudWatch](#AmazonCW) and represents a time\-ordered set of data points\. You publish metric data points into CloudWatch and later retrieve statistics about those data points as a time\-series ordered dataset\.

**timestamp**<a name="timestamp"></a>  
A date/time string in ISO 8601 format\.

**TLS**   
See [Transport Layer Security](#transportlayersecurity).

**tokenization**<a name="tokenization"></a>  
The process of splitting a stream of text into separate tokens on detectable boundaries such as white space and hyphens\.

**topic**<a name="topic"></a>  
A communication channel to send messages and subscribe to notifications\. It provides an access point for publishers and subscribers to communicate with each other\.

**Traffic Mirroring**<a name="trafficmirroring"></a>  
An Amazon VPC feature that you can use to copy network traffic from an elastic network interface of Amazon EC2 instances, and then send it to out\-of\-band security and monitoring appliances for content inspection, threat monitoring, and troubleshooting\.   
See also [https://aws\.amazon\.com/vpc/](https://aws.amazon.com/vpc/).

**training datasource**<a name="training-datasource"></a>  
A datasource that contains the data that Amazon Machine Learning uses to train the machine learning model to make predictions\.

**transition**<a name="transition"></a>  
[AWS CodePipeline](#AWSCodePipeline): The act of a revision in a pipeline continuing from one stage to the next in a workflow\.

**Transport Layer Security**<a name="transportlayersecurity"></a>  
A cryptographic protocol that provides security for communication over the internet\. Its predecessor is Secure Sockets Layer \(SSL\)\.

**trust policy**<a name="trust_policy"></a>  
An [IAM](#IAM) [policy](#policy) that is an inherent part of an IAM [role](#role)\. The trust policy specifies which [principal](#principal)s are allowed to use the role\.

**trusted signers**<a name="trustedsigners"></a>  
AWS [account](#account)s that the [CloudFront](#AmazonCF) distribution owner has given permission to create signed URLs for a distribution's content\.

**tuning**<a name="tuning"></a>  
Selecting the number and type of [AMIs](#AmazonMachineImage) to run a [Hadoop](#Hadoop) job flow most efficiently\.

**tunnel**<a name="tunnel"></a>  
A route for transmission of private network traffic that uses the internet to connect nodes in the private network\. The tunnel uses encryption and secure protocols such as PPTP to prevent the traffic from being intercepted as it passes through public routing nodes\. 

### U<a name="U"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**unbounded**<a name="unbounded"></a>  
The number of potential occurrences is not limited by a set number\. This value is often used when defining a data type that is a list \(for example, `maxOccurs="unbounded"`\), in [WSDL](#WSDL)\.

**unit**<a name="unit"></a>  
Standard measurement for the values submitted to [Amazon CloudWatch](#AmazonCW) as metric data\. Units include seconds, percent, bytes, bits, count, bytes/second, bits/second, count/second, and none\.

**unlink from VPC**<a name="UnlinkFromVpc"></a>  
The process of unlinking \(or detaching\) an EC2\-Classic [instance](#instance) from a ClassicLink\-enabled [VPC](#VPC)\.   
See also . 
See also .

**usage report**<a name="usagereport"></a>  
An AWS record that details your usage of a particular AWS service\. You can generate and download usage reports from [https://aws\.amazon\.com/usage\-reports/](https://aws.amazon.com/usage-reports/)\.

**user**<a name="AWSUser"></a>  
A person or application under an [account](#account) that needs to make API calls to AWS products\. Each user has a unique name within the AWS account, and a set of security credentials not shared with other users\. These credentials are separate from the AWS account's security credentials\. Each user is associated with one and only one AWS account\.

### V<a name="V"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**validation**   
See [template validation](#template-validation).

**value**<a name="value"></a>  
Instances of [attributes](#attribute) for an item, such as cells in a spreadsheet\. An attribute might have multiple values\.
Tagging resources: A specific [tag](#tag) label that acts as a descriptor within a tag category \(key\)\. For example, you might have [EC2 instance](#ec2instance) with the tag key of *Owner* and the tag value of *Jan*\. You can tag an AWS [resource](#resource) with up to 10 key–value pairs\. Not all AWS resources can be tagged\.

**Variable Envelope Return Path**   
See [VERP](#VERP).

**verification**<a name="verification"></a>  
The process of confirming that you own an email address or a domain so that you can send email from or to it\.

**VERP**<a name="VERP"></a>  
Variable Envelope Return Path\. A way in which email sending applications can match [bounce](#bounce)d email with the undeliverable address that caused the bounce by using a different [return path](#returnpath) for each recipient\. VERP is typically used for mailing lists\. With VERP, the recipient's email address is embedded in the address of the return path, which is where bounced email is returned\. This makes it possible to automate the processing of bounced email without having to open the bounce messages, which may vary in content\.

**versioning**<a name="versioning"></a>  
Every object in [Amazon S3](#AmazonSimpleStorageService) has a key and a version ID\. Objects with the same key, but different version IDs can be stored in the same [bucket](#bucket)\. Versioning is enabled at the bucket layer using PUT Bucket versioning\. 

**VGW**<a name="VGW"></a>   
See [virtual private gateway](#VPNgateway).

**virtualization**  
Allows multiple guest virtual machines \(VM\) to run on a host operating system\. Guest VMs can run on one or more levels above the host hardware, depending on the type of virtualization\.    
See also . 
See also .

**virtual private cloud**   
See [VPC](#VPC).

**virtual private gateway**<a name="VPNgateway"></a>  
\(VGW\) The Amazon side of a [VPN connection](#VPNconnection) that maintains connectivity\. The internal interfaces of the virtual private gateway connect to your [VPC](#VPC) via the VPN attachment and the external interfaces connect to the VPN connection, which leads to the [customer gateway](#customergateway)\.

**visibility timeout**<a name="visibilitytimeout"></a>  
The period of time that a message is invisible to the rest of your application after an application component gets it from the queue\. During the visibility timeout, the component that received the message usually processes it, and then deletes it from the queue\. This prevents multiple components from processing the same message\.

**volume**<a name="volume"></a>  
A fixed amount of storage on an [instance](#instance)\. You can share volume data between [container](#container)s and persist the data on the [container instance](#container_instance) when the containers are no longer running\. 

**VPC**<a name="VPC"></a>  
Virtual private cloud\. An elastic network populated by infrastructure, platform, and application services that share common security and interconnection\.

**VPC endpoint**<a name="VPCendpoint"></a>  
A feature that enables you to create a private connection between your [VPC](#VPC) and another AWS service without requiring access over the internet, through a [NAT](#nat) instance, a [VPN connection](#VPNconnection), or [AWS Direct Connect](#AWSDirectConnect)\. 

**VPG**<a name="VPG"></a>   
See [virtual private gateway](#VPNgateway).

**VPN CloudHub**   
See [AWS VPN CloudHub](#awsvpncloudhub).

**VPN connection**<a name="VPNconnection"></a>  
[Amazon Web Services \(AWS\)](#amazonwebservices): The IPsec connection between a [VPC](#VPC) and some other network, such as a corporate data center, home network, or colocation facility\.

### W<a name="W"></a>

 [Numbers and Symbols](#numbers) \| [A](#A) \| [B](#B) \| [C](#C) \| [D](#D) \| [E](#E) \| [F](#F) \| [G](#G) \| [H](#H) \| [I](#I) \| [J](#J) \| [K](#K) \| [L](#L) \| [M](#M) \| [N](#N) \| [O](#O) \| [P](#P) \| [Q](#Q) \| [R](#R) \| [S](#S) \| [T](#T) \| [U](#U) \| [V](#V) \| [W](#W) \| [X, Y, Z](#XYZ) 

**WAM**   
See [Amazon WorkSpaces Application Manager \(Amazon WAM\)](#wam).

**web access control list**<a name="webacl"></a>  
[AWS WAF](#awswaf): A set of rules that defines the conditions that AWS WAF searches for in web requests to AWS [resource](#resource)s such as [Amazon CloudFront](#AmazonCF) distributions\. A web access control list \(web ACL\) specifies whether to allow, block, or count the requests\.

**Web Services Description Language**   
See [WSDL](#WSDL).

**WSDL**<a name="WSDL"></a>  
Web Services Description Language\. A language used to describe the actions that a web service can perform, along with the syntax of action requests and responses\.    
See also . 
See also .

### X, Y, Z<a name="XYZ"></a>

**X\.509 certificate**<a name="X509"></a>  
A digital document that uses the X\.509 public key infrastructure \(PKI\) standard to verify that a public key belongs to the entity described in the [certificate](#certificate)\.

**yobibyte**<a name="yobibyte"></a>  
A contraction of yotta binary byte, a yobibyte is 2^80 or 1,208,925,819,614,629,174,706,176 bytes\. A yottabyte \(YB\) is 10^24 or 1,000,000,000,000,000,000,000,000 bytes\.

**zebibyte**<a name="zebibyte"></a>  
A contraction of zetta binary byte, a zebibyte is 2^70 or 1,180,591,620,717,411,303,424 bytes\. A zettabyte \(ZB\) is 10^21 or 1,000,000,000,000,000,000,000 bytes\. 1,024 ZiB is a [yobibyte](#yobibyte)\.

**zone awareness**<a name="zoneawareness"></a>  
[Amazon Elasticsearch Service \(Amazon ES\)](#AmazonElasticsearchService): A configuration that distributes nodes in a cluster across two [Availability Zone](#AZ)s in the same Region\. Zone awareness helps to prevent data loss and minimizes downtime in the event of node and data center failure\. If you enable zone awareness, you must have an even number of data instances in the instance count, and you also must use the Amazon Elasticsearch Service Configuration API to replicate your data for your Elasticsearch cluster\.