# AWS SDK for Python (Boto3) examples

Code examples that show how to use Boto3 to access Amazon Web Services (AWS).

## Prerequisites

- You must have an AWS account, and have your default credentials and AWS Region configured as described in the [AWS Tools and SDKs Shared Configuration and Credentials Reference Guide](https://docs.aws.amazon.com/credref/latest/refdocs/creds-config-files.html).
- Python 3.6 or later
- Boto3 1.11.10 or later
- PyTest 5.3.5 or later (to run unit tests)

## Documentation

For Boto3 and AWS documentation, see the following:

- [AWS SDK for Python (Boto3) Documentation](https://boto3.amazonaws.com/v1/documentation/api/latest/index.html)
- [AWS Documentation](https://docs.aws.amazon.com/)

## Examples

### [Amazon DynamoDB batch examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/dynamodb/batching/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to write and retrieve Amazon DynamoDB
data using batch functions.

Boto3 features a 
[batch_writer](https://boto3.amazonaws.com/v1/documentation/api/latest/guide/dynamodb.html#batch-writing) 
function that handles all of the necessary intricacies
of the Amazon DynamoDB batch API on your behalf. This includes buffering, removing
duplicates, and retrying unprocessed items.

### [Amazon DynamoDB getting started examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/dynamodb/GettingStarted/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to create an Amazon DynamoDB 
table for storing movies, load movies into the table from a JSON-formatted file, 
and update and query movies in various ways.

### [Amazon DynamoDB Accelerator (DAX) examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/dynamodb/TryDax/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) and the Amazon DAX Client for  
Python to read items from an Amazon DynamoDB table. Retrieval, query, and scan speeds
are measured for both Boto3 and DAX clients to show some of the performance 
advantages of using DAX.

DAX is a DynamoDB-compatible caching service that provides fast in-memory performance 
and high availability for applications that demand microsecond latency. For more
information, see [In-Memory Acceleration with DynamoDB Accelerator (DAX)](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DAX.html). 

### [Amazon EC2 getting started examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/ec2/ec2_basics/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to manage Amazon Compute Cloud 
(Amazon EC2) resources. Learn to accomplish the following tasks:

* Create security keys, groups, and instances.
* Start and stop instances, use Elastic IP addresses, and update security 
groups.
* Clean up security keys and security groups.
* Permanently terminate instances. 

### [Amazon EMR cluster and command examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/emr/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) with the Amazon EMR API to create
and manage clusters and job steps. Learn to accomplish the following tasks:

* Create a short-lived cluster that estimates the value of pi using Apache Spark to 
  parallelize a large number of calculations, writes output to Amazon S3, and
  terminates itself after completing the job.
* Create a long-lived cluster that uses Apache Spark to query historical Amazon 
  review data to discover the top products in various categories with certain 
  keywords in their product titles.
* Create security roles and groups to let Amazon EMR manage cluster instances and
  to let the instances access additional AWS resources.
* Run commands on cluster instances, such as EMRFS configuration and shell scripts
  to install additional libraries. 
* Query clusters for status and terminate them using the API.

### [AWS IAM getting started examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/iam/iam_basics/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to manage AWS Identity and Access 
Management (IAM) resources. Learn to accomplish the following tasks:

* Create and manage IAM user access keys.
* Manage the alias of an account.
* Acquire reports about account usage.
* Create and manage IAM policies, including versioned policies.
* Create and manage IAM roles, including how to attach and detach policies.
* Create and manage IAM users, including how to attach a policy to a user.

### [AWS Lambda examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/lambda/boto_client_examples/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to create, deploy, and invoke 
AWS Lambda functions. Learn to accomplish the following tasks:

* Create and deploy Lambda functions that can be invoked in different ways:
    * By an invoke call through Boto3
    * By Amazon API Gateway as the target of a REST request
    * By Amazon EventBridge on a schedule
* Create and deploy a REST API on Amazon API Gateway. The REST API targets an 
AWS Lambda function to handle REST requests.
* Create a schedule rule on Amazon EventBridge that targets an AWS Lambda function.

These examples show how to use the low-level Boto3 client APIs to accomplish tasks
like creating a REST API and setting an event schedule. You can also use
[AWS Chalice](https://github.com/aws/chalice)
to achieve similar results more easily and with additional features. 

### [AWS Chalice and AWS Lambda REST API example](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/lambda/chalice_examples/lambda_rest/README.md)

#### Purpose

Shows how to use AWS Chalice with the AWS SDK for Python (Boto3) to 
create a serverless REST API that uses Amazon API Gateway, AWS Lambda, and 
Amazon DynamoDB. The REST API simulates a system that tracks daily cases
of COVID-19 in the United States, using fictional data. Learn how to:

* Use AWS Chalice to define routes in AWS Lambda functions that
 are called to handle REST requests that come through Amazon API Gateway.
* Use AWS Lambda functions to retrieve and store data in an Amazon DynamoDB 
table to serve REST requests.
* Define table structure and security role resources in an AWS CloudFormation template.
* Use AWS Chalice and AWS CloudFormation to package and deploy all necessary resources.
* Use AWS CloudFormation to clean up all created resources.

This example brings together some of the same information you can find in the
tutorials in the 
[AWS Chalice GitHub repository](https://aws.github.io/chalice/quickstart.html).

### [AWS Organizations policy examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/organizations/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to create and manage AWS Organizations
policies.

### [Amazon S3 managed file transfer example](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/s3/file_transfer/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) transfer manager to manage multipart
uploads to and downloads from an Amazon Simple Storage Service (Amazon S3) bucket.

When the file to transfer is larger than the specified threshold, the transfer
manager automatically uses multipart uploads or downloads. This example
shows how to use several of the available transfer manager settings, and reports
thread usage and time to transfer.

### [Amazon S3 getting started examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/s3/s3_basics/ReadMe.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to  get started using bucket and 
object operations in Amazon Simple Storage Service (Amazon S3). 
Learn to create, get, remove, and configure buckets and objects.

### [Amazon S3 batch and versioning examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/s3/s3_versioning/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to set up an Amazon S3 bucket for 
versioning, and how to perform taks on a version-enabled bucket. Learn to 
accomplish the following tasks:

* Create a version-enabled bucket and apply revisions to its objects.
* Get a full series of object versions.
* Roll back to a previous version.
* Revive a deleted object.
* Permanently delete all versions of an object.

Shows how to manipulate Amazon S3 versioned objects in batches by creating jobs
that call AWS Lambda functions to perform processing. Learn to accomplish the
following tasks:

* Create Lambda functions that operate on versioned objects.
* Create a manifest of objects to update.
* Create batch jobs that invoke Lambda functions to update objects.
* Delete Lambda functions.
* Empty and delete a versioned bucket.

### [Amazon SQS getting started examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/sqs/ReadMe.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) to get started using queue and 
message operations in Amazon Simple Queue Service (Amazon SQS). Learn how to 
create, get, and remove standard, FIFO, and dead-letter queues. Learn how to 
send, receive, and delete messages from a queue.

### [AWS STS temporary credential examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/sts/sts_temporary_credentials/README.md)

#### Purpose

Shows how to use the AWS Python SDK (Boto3) to access the AWS Security Token 
Service (AWS STS) to acquire temporary credentials that grant specific permissions. Also
demonstrates how to set up and use a multi-factor authentication (MFA) device. Learn
to accomplish the following tasks:

* Assume a role that grants specific permissions, and use those credentials to 
perform permitted actions.
* Add a new MFA device to a user. 
* Assume a role that requires MFA to be present.
* Construct a URL that gives federated users direct access to an account through the
AWS Management Console.
* Get a session token that can be used to call an API function that requires MFA.

### [Amazon Transcribe custom vocabulary example](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/example_code/transcribe/README.md)

#### Purpose

Shows how to use the AWS SDK for Python (Boto3) with the Amazon Transcribe API to
transcribe an audio file to a text file. Learn how to:

* Run a transcription job against an audio file in an Amazon S3 bucket.
* Create and refine a custom vocabulary to improve the accuracy of the transcription.
* List and manage transcription jobs and custom vocabularies.

### [Test tools for Python code examples](https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/python/test_tools/README.md)

#### Purpose

Centralizes PyTest fixtures and specialized stubbers based on the botocore Stubber 
that Python code examples can use for unit tests.

## Additional information

- As an AWS best practice, grant this code least privilege, or only the permissions required to perform a task. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *AWS Identity and Access Management User Guide*.
- This code has not been tested in all AWS Regions. Some AWS services are available only in specific Regions. For more information, see the [AWS Regional Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/)
- Running this code might result in charges to your AWS account.

---

Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

SPDX-License-Identifier: Apache-2.0
