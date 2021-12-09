--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Import Jobs into Amazon S3<a name="importtype"></a>

With an import job, your data is copied to the AWS Snowball Edge device with the built\-in Amazon S3 Adapter for Snowball or NFS mount point\. Your data source for an import job should be on\-premises\. In other words, the storage devices that hold the data to be transferred should be physically located at the address that you provided when you created the job\.

When you import files, each file becomes an object in Amazon S3 and each directory becomes a prefix\. If you import data into an existing bucket, any existing objects with the same names as newly imported objects are overwritten\. The import job type is also capable of local storage and compute functionality\. This functionality uses the file interface or Amazon S3 Adapter for Snowball to read and write data, and triggers Lambda functions based off of Amazon S3 PUT object API actions running locally on the AWS Snowball Edge device\.

When all of your data has been imported into the specified Amazon S3 buckets in the AWS Cloud, AWS performs a complete erasure of the device\. This erasure follows the NIST 800\-88 standards\.

After your import is complete, you can download a job report\. This report alerts you to any objects that failed the import process\. You can find additional information in the success and failure logs\.

**Important**  
Don't delete your local copies of the transferred data until you can verify the results of the job completion report and review your import logs\.