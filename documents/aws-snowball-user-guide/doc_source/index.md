# AWS Snowball User Guide

-----
*****Copyright &copy; 2018 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

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
+ [What Is an AWS Snowball Device?](whatissnowball.md)
   + [AWS Snowball Device Differences](device-differences.md)
   + [How AWS Snowball Works with the Standard Snowball device](how-it-works.md)
   + [Jobs for Standard Snowball devices](jobs.md)
   + [Setting Up Your AWS Access](setting-up.md)
+ [Getting Started with AWS Snowball](getting-started.md)
   + [Importing Data into Amazon S3 with AWS Snowball](create-import-job-steps.md)
      + [Create an Import Job](create-import-job.md)
      + [Receive the AWS Snowball device](receive-device.md)
      + [Connect the AWS Snowball device to Your Local Network](getting-started-connect.md)
      + [Transfer Data](transfer-data.md)
      + [Return the device](return-device.md)
      + [Monitor the Import Status](monitor-status.md)
   + [Exporting Data from Amazon S3 with Snowball](create-export-job-steps.md)
      + [Create an Export Job](create-export-job.md)
      + [Receive the AWS Snowball device](receive-export.md)
      + [Connect the AWS Snowball device to Your Local Network](export-connect.md)
      + [Transfer Data](transfer-export.md)
      + [Return the device](return-export.md)
      + [Repeat the Process](repeat.md)
   + [Where Do I Go from Here?](where-to.md)
+ [Best Practices for AWS Snowball](BestPractices.md)
   + [Performance for AWS Snowball](performance.md)
   + [How to Transfer Petabytes of Data Efficiently](transfer-petabytes.md)
+ [Using the AWS Snowball Management Console](using-console.md)
   + [Cloning an Import Job in the Console](clonejob.md)
   + [Using Export Ranges](ranges.md)
   + [Getting Your Job Completion Report and Logs in the Console](report.md)
   + [Canceling Jobs in the Console](canceljob.md)
+ [Using an AWS Snowball Device](using-device.md)
   + [Transferring Data with the Snowball Client](snowball-transfer-client.md)
      + [Using the Snowball Client](using-client.md)
      + [Commands for the Snowball Client](using-client-commands.md)
      + [Options for the snowball cp Command](copy-command-reference.md)
         + [Syntax for the snowball cp Command](copy-command-syntax.md)
   + [Transferring Data with the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md)
      + [Using the Amazon S3 Adapter for Snowball](using-adapter.md)
         + [Options for the Amazon S3 Adapter for Snowball](using-adapter-options.md)
         + [Using the Adapter with Amazon S3 Commands for the AWS CLI](using-adapter-cli.md)
         + [Supported REST API Actions](using-adapter-supported-api.md)
+ [Shipping Considerations for AWS Snowball](shipping.md)
   + [Shipping an AWS Snowball device](mailing-storage.md)
+ [Security in AWS Snowball](security.md)
   + [Authorization and Access Control in AWS Snowball](auth-access-control.md)
   + [AWS Key Management Service in Snowball](kms.md)
   + [Authorization with the Amazon S3 API Adapter for Snowball](auth-adapter.md)
   + [Other Security Considerations for Snowball](security-considerations.md)
+ [Data Validation in AWS Snowball](validation.md)
+ [Snowball Notifications](notifications.md)
+ [AWS Snowball Specifications](specifications.md)
+ [AWS Snowball Limits](limits.md)
+ [Troubleshooting for a Standard Snowball](troubleshooting.md)
+ [Job Management API Reference for AWS Snowball](api-reference.md)
+ [Document History](WhatsNew.md)
+ [](glos-chap.md)