# Exporting data to Amazon Simple Storage Service<a name="export-to-s3"></a>

You can export incoming data from AWS IoT SiteWise to an Amazon S3 bucket in your account\. You can back up your data in a format that lets you create historical reports or analyze your data with complex methods\.

AWS IoT SiteWise provides this feature as an AWS CloudFormation template\. When you create a stack from the template, AWS CloudFormation creates the required AWS resources to stream incoming data from AWS IoT SiteWise to an S3 bucket\. 

Then, the S3 bucket receives all of your asset property data sent from AWS IoT SiteWise property value update messages\. The S3 bucket also receives your asset metadata, which includes asset and property names and other information\.

For more information about how to enable property value update messages for the asset properties to export to Amazon S3, see [Interacting with other AWS services](interact-with-other-services.md)\.

This feature stores your asset property data and asset metadata in Amazon S3 in [Apache Parquet](https://parquet.apache.org/documentation/latest/) format\. Parquet is a columnar data format that saves space and enables faster queries compared to row\-oriented formats like JSON\.

**Note**  
When this feature retrieves asset metadata, it supports up to approximately 5,000 asset properties\. This limitation applies only to asset metadata\. This limitation doesn't apply to the number of properties supported when the feature exports asset property data\.

Each resource's name includes a prefix that you can customize when you create the stack\. Resources include the following:
+ An Amazon S3 bucket
+ AWS Lambda functions
+ An AWS IoT Core rule
+ AWS Identity and Access Management roles
+ An Amazon Kinesis Data Firehose stream
+ An AWS Glue database

For a complete list, see [Resources created from the template](export-to-s3-resources.md)\.

**Important**  
You will be charged for the resources that this AWS CloudFormation template creates and consumes\. These charges include data storage and data transfer for multiple AWS services\.

**Topics**
+ [Creating the AWS CloudFormation stack](#create-export-to-s3-stack)
+ [Viewing your data in Amazon S3](#view-exported-data-in-s3)
+ [Analyzing exported data with Amazon Athena](analyze-exported-asset-data.md)
+ [Resources created from the template](export-to-s3-resources.md)

## Creating the AWS CloudFormation stack<a name="create-export-to-s3-stack"></a>

You can create a stack in AWS CloudFormation to export your asset data to Amazon S3\.

**To export data to Amazon S3**

1. Open the [AWS CloudFormation template](https://console.aws.amazon.com/cloudformation/home?#/stacks/new?stackName=IoTSiteWiseExportToS3&templateURL=https%3A%2F%2Fs3.amazonaws.com%2Faws-iot-sitewise%2FexportToS3%2FSiteWiseExportToS3CloudFormation.yml) and sign in to the AWS Management Console\.

1. On the **Create stack** page, choose **Next** at the bottom of the page\.

1. On the **Specify stack details** page, enter a **BucketName** for the S3 bucket that this template creates to receive asset data\. This bucket name must be globally unique\. For more information, see [Rules for bucket naming](https://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html#bucketnamingrules) in the *Amazon Simple Storage Service Developer Guide*\.

1. \(Optional\) Change any of the template's other parameters:
   + **GlobalResourcePrefix** – A prefix for names of global resources, such as IAM roles, created from this template\.
   + **LocalResourcePrefix** – A prefix for names of resources created from this template in the current Region\.
**Note**  
If you create this template multiple times, you might need to change the bucket name and resource prefix parameters to avoid resource name conflicts\.

1. Choose **Next**\.

1. On the **Configure stack options** page, choose **Next**\.

1. At the bottom of the page, select the check box that says **I acknowledge that AWS CloudFormation might create IAM resources**\.

1. Choose **Create stack**\.

   The stack takes a few minutes to create\. If the stack fails to create, your account might have insufficient permissions, or you might have entered a bucket name that already exists\. Use the following steps to delete the stack and try again:

   1. Choose **Delete** in the upper\-right corner\.

      The stack takes a few minutes to delete\.
**Note**  
AWS CloudFormation doesn't delete S3 buckets or CloudWatch log groups\. You can delete these resources in the consoles for those services\.

   1. If the stack fails to delete, choose **Delete** again\.

   1. If the stack fails to delete again, follow the steps in the AWS CloudFormation console to skip the resources that failed to delete, and try again\.

1. After the AWS CloudFormation stack creates successfully, follow the next procedure to explore your asset property data in Amazon S3\.

**Important**  
After you create the stack, you can see the new resources in your AWS account\. The feature might stop working correctly if you delete or modify these resources\. We recommend that you don't modify these resources unless you want to stop sending data to the bucket or want to customize this feature\.

## Viewing your data in Amazon S3<a name="view-exported-data-in-s3"></a>

After you create the feature, you can view your asset property data and asset metadata in Amazon S3\.

**Note**  
Asset metadata updates every 6 hours\. You might need to wait up to 6 hours to see asset metadata appear in the S3 bucket\.

This feature stores asset property data in the following columns, where each row contains a data point:
+ **type** – The type of property notification \(`PropertyValueUpdate`\)\.
+ **asset\_id** – The ID of the asset that received a data point\.
+ **asset\_property\_id** – The ID of the property that received a data point for the asset\.
+ **time\_in\_seconds** – The time at which the data was received, expressed in seconds in Unix epoch time\.
+ **offset\_in\_nanos** – The nanosecond offset from `timeInSeconds`\.
+ **asset\_property\_quality** – The quality of the data point: `GOOD`, `UNCERTAIN`, or `BAD`\.
+ **asset\_property\_value** – The value of the data point\.
+ **asset\_property\_data\_type** – The data type of the asset property: `boolean`, `double`, `integer`, or `string`\.

This feature stores asset metadata in the following columns, where each row contains an asset property:
+ **asset\_id** – The ID of the asset\.
+ **asset\_name** – The name of the asset\.
+ **asset\_model\_id** – The ID of the asset's model\.
+ **asset\_property\_id** – The ID of the asset property\.
+ **asset\_property\_name** – The name of the asset property\.
+ **asset\_property\_data\_type** – The data type of the asset property: `BOOLEAN`, `DOUBLE`, `INTEGER`, or `STRING`\.
+ **asset\_property\_unit** – The unit of the asset property\.
+ **asset\_property\_alias** – The alias of the asset property\.

**To view your AWS IoT SiteWise data in Amazon S3**

1. Navigate to the [Amazon S3 console](https://console.aws.amazon.com/s3/)\.

1. From the list of buckets, choose the bucket with the name you chose when you created the template\.

1. In the bucket, choose one of the following folders:
   + `asset-property-updates` – This folder contains asset property data exported from AWS IoT SiteWise\.
   + `asset-metadata` – This folder contains asset details exported from AWS IoT SiteWise\.

1. Choose the object that you want to view\.

1. On the object's page, do the following:

   1. Choose the **Select from** tab\.

      In this panel, you can preview records from Parquet files\.

   1. For **File format**, choose **Parquet**\.

   1. Choose **Show file preview** to show the contents of the file in JSON format\.

**Note**  
If new data doesn't appear in the bucket, check that you enabled property value update notifications for your asset properties\. For more information, see [Interacting with other AWS services](interact-with-other-services.md)\.

For more information about how to analyze your asset data stored in the S3 bucket, see [Analyzing exported data with Amazon Athena](analyze-exported-asset-data.md)\.