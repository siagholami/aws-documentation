--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Understanding AWS Snowball Edge Jobs<a name="jobs"></a>

A job in AWS Snowball is a discrete unit of work, defined when you create it in the console or the job management API\. With the AWS Snowball Edge device, there are three different job types, all of which are capable of local storage and compute functionality\. This functionality uses the file interface or Amazon S3 Adapter for Snowball to read and write data\. It triggers Lambda functions based on Amazon S3 PUT object API actions running locally on the AWS Snowball Edge device\.

**Important**  
With an AWS Snowball Edge device, all jobs can use the compute functionality in regions where AWS Lambda is supported\. How the compute functionality is implemented in AWS Snowball jobs is specific to Snowball—the functionality can differ significantly from how Lambda works in the cloud\. Before creating your first compute job, we recommend that you familiarize yourself with how AWS Lambda powered by AWS Greengrass works\. For more information, see [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)\.
+ [Import Jobs into Amazon S3](importtype.md) – The transfer of 80 TB or less of your local data copied onto a single device, and then moved into Amazon S3\. For import jobs, AWS Snowball Edge devices and jobs have a one\-to\-one relationship\. Each job has exactly one device associated with it\. If you need to import more data, you can create new import jobs or clone existing ones\. When you return a device of this job type, that data on it is imported into Amazon S3\.
+ [Export Jobs from Amazon S3](exporttype.md) – The transfer of any amount of data \(located in Amazon S3\), copied onto any number of AWS Snowball Edge devices, and then moved one AWS Snowball Edge device at a time into your on\-premises data destination\. When you create an export job, it's split into job parts\. Each job part is no more than 100 TB in size, and each job part has exactly one AWS Snowball Edge device associated with it\. When you return a device of this job type, it's erased\.
+ [Local Compute and Storage Only Jobs](computetype.md) – These jobs involve one AWS Snowball Edge device, or multiple devices used in a cluster\. These jobs don't start with data in their buckets like an export job, and can't have data imported into Amazon S3 at the end like an import job\. When you return a device of this job type, it's erased\. With this job type, you also have the option of creating a cluster of devices\. A cluster improves local storage durability and you can scale up or down with local storage capacity\.

  In regions where Lambda is not available, this job type will be called *Local storage only*\.

## Job Details<a name="jobdetails"></a>

Each job is defined by the details that you specify when it's created\. The following table describes all the details of a job\.


****  

| Console Identifier | API Identifier | Detail Description | 
| --- | --- | --- | 
| Job name | Description | A name for the job, containing alphanumeric characters, spaces, and any Unicode special characters\. | 
| Job type | JobType | The type of job, either import, export, or local compute and storage\. | 
| Job ID | JobId | A unique 39\-character label that identifies your job\. The job ID appears at the bottom of the shipping label that appears on the E Ink display, and in the name of a job's manifest file\. | 
| Address | AddressId | The address that the device will be shipped to\. In the case of the API, this is the ID for the address data type\. | 
| Created date | N/A | The date that you created this job\. | 
| Shipping speed | ShippingOption | Speed options are based on region\. For more information, see [Shipping Speeds](mailing-storage.md#shippingspeeds)\. | 
| IAM role ARN | RoleARN | This Amazon Resource Name \(ARN\) is the AWS Identity and Access Management \(IAM\) role that is created during job creation with write permissions for your Amazon S3 buckets\. The creation process is automatic, and the IAM role that you allow AWS Snowball to assume is only used to copy your data between your Amazon S3 buckets and the Snowball\. For more information, see [Permissions Required to Use the AWS Snowball Console](access-control-managing-permissions.md#additional-console-required-permissions)\. | 
| AWS KMS key | KmsKeyARN | In AWS Snowball, AWS Key Management Service \(AWS KMS\) encrypts the keys on each Snowball\. When you create your job, you also choose or create an ARN for an AWS KMS encryption key that you own\. For more information, see [AWS Key Management Service in AWS Snowball Edge](kms.md)\. | 
| Snowball capacity | SnowballCapacityPreference | AWS Snowball devices come in three sizes: the 50 TB and 80 TB Snowballs and the 100 TB storage optimized or 42 TB compute optimized AWS Snowball Edge device\. Which are available depends on your AWS Region\.  | 
| Storage service | N/A | The AWS storage service associated with this job, in this case Amazon S3\. | 
| Resources | Resources | The AWS storage service resources associated with your job\. In this case, these are the Amazon S3 buckets that your data is transferred to or from\. | 
| Job type | JobType | The type of job, either import, export, or local compute and storage\. | 
| Snowball type | SnowballType | The type of device used, either a Snowball or an AWS Snowball Edge device\. | 
| Cluster ID | ClusterId | A unique 39\-character label that identifies your cluster\. | 

## Canceling Jobs in the Console<a name="canceljob"></a>

If you need to cancel a job request or a cluster creation request for any reason, you have at least an hour after you created the request to do so\. You can only cancel jobs can when they have **Job created** status\. Once a job begins processing, you can no longer cancel it\. Likewise, to cancel a cluster creation request you have about an hour\.

**To cancel a job in the console**

1. Sign in to the AWS Management Console and open the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. Search for and choose your job from the table\.

1. From **Actions**, choose **Cancel job**\.

You have now canceled your job\.