# Jobs<a name="jobs"></a>

AWS Data Exchange jobs are asynchronous import or export operations used to create or copy assets\. A data set owner can import and export, but someone with an entitlement to a data set can only export\. You can use the console, AWS CLI, your own REST application, or one of the AWS SDKs to create or copy assets through jobs\.

Jobs are deleted 90 days after they are created\.

**Topics**
+ [Job Properties](#job-properties)
+ [AWS Regions and Jobs](#jobs-regions)
+ [Importing Assets](#importing-assets)
+ [Exporting Assets](#exporting-assets)

## Job Properties<a name="job-properties"></a>

Jobs have the following properties:
+ **Job ID** – An ID generated when the job is created that uniquely identifies the job\. 
+ **Job type** – The following job types are supported: import from Amazon S3, import from signed URL, export to Amazon S3, export to signed URL\. 
+ **Amazon Resource Name \(ARN\)**> – A unique identifier for AWS resources\.
+ **Job state** – The job state can be: `WAITING`, `IN_PROGRESS`, `COMPLETED`, `CANCELLED`, `ERROR`, or `TIMED_OUT`\. When a job is created, it's put in the `WAITING` state until the job is started\.
+ **Job details** – Details of the operation to be performed by the job, such as export destination details or import source details\.

**Example Job Resource**  

```
{
    "Arn": "arn:aws:dataexchange:us-east-1:123456789012:jobs/6cEXAMPLE818f7c7a23b3d0EXAMPLE1c",
    "Id": "6cEXAMPLE818f7c7a23b3d0EXAMPLE1c",
    "State": "COMPLETED",
    "Type": "IMPORT_ASSETS_FROM_S3",
    "CreatedAt": "2019-10-11T14:12:24.640Z",
    "UpdatedAt": "2019-10-11T14:13:00.804Z",
    "Details": {
        "ImportAssetsFromS3": {
            "AssetSources": [
                {
                    "Bucket": "awsexamplebucket",
                    "Key": "MyKey"
                }
            ],
            "DataSetId": "14EXAMPLE4460dc9b005a0dEXAMPLE2f",
            "RevisionId": "e5EXAMPLE224f879066f999EXAMPLE42"
        }
    }
}
```

## AWS Regions and Jobs<a name="jobs-regions"></a>

If you import or export an asset to or from an Amazon S3 bucket that is in an AWS Region different from the data set's, your AWS account is charged for the data transfer costs according to Amazon S3 data transfer pricing policies\.

## Importing Assets<a name="importing-assets"></a>

There are two ways you can import assets to a revision:
+ From an Amazon S3 bucket that you have permissions to access\. 
+ By using a signed URL\.

### Importing Assets from an Amazon S3 Bucket<a name="importing-from-s3"></a>

When you import from an Amazon S3 bucket, you must create and start a job of type `IMPORT_ASSETS_FROM_S3`\. Provide the details of the import destinations \(including the asset ID, revision ID, and data set ID\) and the asset sources \(Amazon S3\)\. The newly created assets have a name property equal to the original S3 object's key\. You can update the assets' name property after they are created\. You can import up to 100 assets in a single job\.

When importing assets from Amazon S3 to AWS Data Exchange, the IAM permissions you're using must include the ability to write to the AWS Data Exchange service Amazon S3 buckets and to read from the Amazon S3 bucket where your assets are stored\. You can import from any Amazon S3 bucket you have permission to access, regardless of ownership\. For more information, see [Additional Amazon S3 Permissions](access-control.md#additional-s3-permissions)\.

### Importing Assets from a Signed URL<a name="importing-from-url"></a>

You can use signed URLs to import assets that are not stored in Amazon S3\. Create a job of type `IMPORT_ASSET_FROM_SIGNED_URL`, provide the 24\-byte MD5 hash of the asset, and the asset name\. The job's details include a signed URL that you can use to import your file\. The signed URL expires one hour after it's created\.

## Exporting Assets<a name="exporting-assets"></a>

There are two ways you can export assets from a published revision of a product:
+ To an Amazon S3 bucket that you have permissions to access\. 
+ By using a signed URL\.

### Exporting Assets to an Amazon S3 Bucket<a name="exporting-from-s3"></a>

When you export to an Amazon S3 bucket, you must create and start a job of type `EXPORT_ASSETS_TO_S3`\. Provide details of the assets you would like to export and the target destination\. By default, the assets are exported to an S3 object using the original asset name as an object key\. You can export up to 100 assets in a single job\.

AWS Data Exchange supports configurable encryption parameters when exporting data sets to Amazon S3\. In your export job details, you can specify the Amazon S3 server\-side encryption configuration you want to apply to the exported objects\. You can choose to use server\-side encryption with Amazon S3\-Managed Keys \(SSE\-S3\) or server\-side encryption with Customer Master Keys \(CMKs\) stored in AWS Key Management Service \(SSE\-KMS\)\. For more information, see [Protecting data using server\-side encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the *Amazon Simple Storage Service Developer Guide*\. 

**Note**  
When exporting assets to Amazon S3, the IAM permissions you're using must include the ability to read from the AWS Data Exchange service Amazon S3 buckets and to write to the Amazon S3 bucket where your assets are stored\. You can export to any Amazon S3 bucket you have permission to access, regardless of ownership\. For more information, see [Additional Amazon S3 Permissions](access-control.md#additional-s3-permissions)\.

### Exporting Assets to a Signed URL<a name="Exporting-from-url"></a>

You can use signed URLs to export assets to destinations other than S3 buckets\. Create and start a job of type `EXPORT_ASSET_TO_SIGNED_URL` and provide the source details\. The job's details include a signed URL that you can use to export your file\. The signed URL has an expiry time of 1 minute\.