--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# What Is an AWS Snowball Device?<a name="whatissnowball"></a>

AWS Snowball is a service that accelerates transferring large amounts of data into and out of AWS using physical storage devices, bypassing the Internet\. Each AWS Snowball device type can transport data at faster\-than internet speeds\. This transport is done by shipping the data in the devices through a regional carrier\. The devices are rugged shipping containers, complete with E Ink shipping labels\.

With a Snowball, you can transfer hundreds of terabytes or petabytes of data between your on\-premises data centers and Amazon Simple Storage Service \(Amazon S3\)\. AWS Snowball uses Snowball appliances and provides powerful interfaces that you can use to create jobs, transfer data, and track the status of your jobs through to completion\. By shipping your data in Snowballs, you can transfer large amounts of data at a significantly faster rate than if you were transferring that data over the Internet, saving you time and money\.

**Note**  
There are many options for transferring your data into AWS\. Snowball is intended for transferring large amounts of data\. If you want to transfer less than 10 terabytes of data between your on\-premises data centers and Amazon S3, Snowball might not be your most economical choice\.

Snowball uses Snowball appliances shipped through your region's carrier\. Each Snowball is protected by AWS Key Management Service \(AWS KMS\) and made physically rugged to secure and protect your data while the Snowball is in transit\. In the US regions, Snowballs come in two sizes: 50 TB and 80 TB\. All other regions have 80 TB Snowballs only\.

## Snowball Features<a name="features"></a>

Snowball with the Snowball appliance has the following features:
+ You can import and export data between your on\-premises data storage locations and Amazon S3\.
+ Snowball has an 80 TB model available in all regions, and a 50 TB model only available in the US regions\.
+ Encryption is enforced, protecting your data at rest and in physical transit\.
+ You don't have to buy or maintain your own hardware devices\.
+ You can manage your jobs through the AWS Snowball Management Console, or programmatically with the job management API\.
+ You can perform local data transfers between your on\-premises data center and a Snowball\. These transfers can be done through the Snowball client, a standalone downloadable client, or programmatically using Amazon S3 REST API calls with the downloadable Amazon S3 Adapter for Snowball\. For more information, see [Transferring Data with a Snowball](using-device.md#snowball-data-transfer)\.
+ The Snowball is its own shipping container, and its E Ink display changes to show your shipping label when the Snowball is ready to ship\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\.
+ For a list of regions where the Snowball appliance is available, see [AWS Snowball](https://docs.aws.amazon.com/general/latest/gr/rande.html#snowball_region) in the * AWS General Reference*\.

**Note**  
Snowball doesn't support international shipping or shipping between regions outside of the US\. For more information on shipping restrictions, see [Region\-Based Shipping Restrictions](shipping.md#shipwithinregion)\.

## Prerequisites for Using AWS Snowball<a name="snowball-prereqs"></a>

Before transferring data into Amazon S3 using Snowball, you should do the following:
+ Create an AWS account and an administrator user in AWS Identity and Access Management \(IAM\)\. For more information, see [Creating an IAM User for Snowball](auth-access-control.md#create-iam-user)\.
+ If you are importing data, do the following:
  + Confirm that the files and folders to transfer are named according to the [Object Key Naming Guidelines](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-key-guidelines) for Amazon S3\. Any files or folders with names that don't meet these guidelines won't be imported into Amazon S3\.
  + Plan what data you want to import into Amazon S3\. For more information, see [How to Transfer Petabytes of Data Efficiently](transfer-petabytes.md)\.
+ If you are exporting data, do the following:
  + Understand what data will be exported when you create your job\. For more information, see [Using Export Ranges](ranges.md)\.
  + For any files with a colon \(`:`\) in the file name, change the file names in Amazon S3 before you create the export job to get these files\. Files with a colon in the file name fail export to Microsoft Windows Server\. 

## Tools and Interfaces<a name="tools"></a>

Snowball uses the AWS Snowball Management Console and the job management API for creating and managing jobs\. To perform data transfers on the Snowball appliance locally, use the Snowball client or the Amazon S3 Adapter for Snowball\. To learn more about using these in detail, see the following topics:
+ [Using the AWS Snowball Management Console](using-console.md)
+ [Using an AWS Snowball Device](using-device.md)
+ [Transferring Data with a Snowball](using-device.md#snowball-data-transfer)

We also recommend that you check out the job management API for AWS Snowball\. For more information, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\.

## Services Related to AWS Snowball<a name="snowball-related"></a>

This guide assumes that you are an Amazon S3 user\.

## Are You a First\-Time User of AWS Snowball?<a name="welcome-first-time-user"></a>

If you are a first\-time user of the Snowball service with the Snowball appliance, we recommend that you read the following sections in order:

1. To learn more about the different types of jobs, see [Jobs for Standard Snowball devices](jobs.md)\.

1. For an end\-to\-end overview of how Snowball works with the Snowball appliance, see [How AWS Snowball Works with the Standard Snowball device](how-it-works.md)\.

1. When you're ready to get started, see [Getting Started with AWS Snowball](getting-started.md)\.

## Pricing<a name="pricing"></a>

For information about the pricing and fees associated with the AWS Snowball, see [AWS Snowball Pricing](http://aws.amazon.com/snowball/pricing)\.