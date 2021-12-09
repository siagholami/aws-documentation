--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Local Compute and Storage Only Jobs<a name="computetype"></a>

Local compute and storage jobs enable you to use Amazon S3 and AWS Lambda powered by AWS Greengrass locally, without an internet connection\. While local storage and compute functionality also exists for the import and export job types, this job type is only for local use\. You can't export data from Amazon S3 onto the device or import data into Amazon S3 when the device is returned\. 

## Local Compute Jobs<a name="aboutcompute"></a>

The local compute functionality is AWS Lambda powered by AWS Greengrass, and can automatically run Python\-language code in response to [Amazon S3 PUT object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectPUT.html) action API calls to the AWS Snowball Edge device\. You write the Python code as a Lambda function in the Lambda console\.

Buckets and Lambda functions have a one\-to\-one relationship, meaning that one Lambda function can be associated with one bucket when the job is created\. For more information, see [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)\.

## Local Storage Jobs<a name="aboutstorage"></a>

You can read and write objects to an AWS Snowball Edge device using the Amazon S3 Adapter for Snowball or the file interface\. The adapter comes built\-into the device, and it supports Amazon S3 REST API actions\. This Amazon S3 REST API support is limited to a subset of S3 REST API actions\. For more information, see [Transferring Files Using the Amazon S3 Adapter](using-adapter.md)\.

When you've finished using the device, return it to AWS and the device will be erased\. This erasure follows the National Institute of Standards and Technology \(NIST\) 800\-88 standards\.

## Local Cluster Option<a name="clusteroption"></a>

A cluster is a logical grouping of Snowball Edge devices, in groups of 5 to 10 devices\. A cluster is created as a single job, which offers increased durability and storage size when compared to other AWS Snowball job offerings\. For more information on cluster jobs, see [Using an AWS Snowball Edge Cluster](UsingCluster.md)\.