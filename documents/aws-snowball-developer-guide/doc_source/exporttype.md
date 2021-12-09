--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Export Jobs from Amazon S3<a name="exporttype"></a>

Your data source for an export job is one or more Amazon S3 buckets\. Once the data for a job part is moved from Amazon S3 to an AWS Snowball Edge device, you can download a job report\. This report alerts you to any objects that failed the transfer to the device\. You can find more information in your job's success and failure logs\.

You can export any number of objects for each export job, using as many devices as it takes to complete the transfer\. AWS Snowball Edge devices for an export job's job parts are delivered one after another, with subsequent devices shipping to you after the previous job part enters the **In transit to AWS** status\.

When you copy objects into your on\-premises data destination from a device using the Amazon S3 Adapter for Snowball or the NFS mount point, those objects are saved as files\. If you copy objects into a location that already holds files, any existing files with the same names are overwritten\. The export job type is also capable of local storage and compute functionality\. This functionality uses the file interface or Amazon S3 Adapter for Snowball to read and write data, and triggers Lambda functions based off of Amazon S3 PUT object API actions running locally on the AWS Snowball Edge device\.

When AWS receives a returned device, we completely erase it, following the NIST 800\-88 standards\.

**Important**  
Don't change, update, or delete the exported Amazon S3 objects until you can verify that all of your contents for the entire job have been copied to your on\-premises data destination\.

When you create an export job, you can export an entire Amazon S3 bucket or a specific range of objects keys\.

## Using Export Ranges<a name="ranges"></a>

When you create an export job in the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2) or with the job management API, you can export an entire Amazon S3 bucket or a specific range of objects keys\. Object key names uniquely identify objects in a bucket\. If you export a range, you define the length of the range by providing either an inclusive range beginning, an inclusive range ending, or both\. 

Ranges are UTF\-8 binary sorted\. UTF\-8 binary data is sorted in the following way:
+ The numbers 0–9 come before both uppercase and lowercase English characters\.
+ Uppercase English characters come before all lowercase English characters\.
+ Lowercase English characters come last when sorted against uppercase English characters and numbers\.
+ Special characters are sorted among the other character sets\.

For more information on the specifics of UTF\-8, see [https://en\.wikipedia\.org/wiki/UTF\-8](https://en.wikipedia.org/wiki/UTF-8)\.

### Export Range Examples<a name="range-examples"></a>

Assume you have a bucket containing the following objects, sorted in UTF\-8 binary order:
+ 01
+ Aardvark
+ Aardwolf
+ Aasvogel/apple
+ Aasvogel/banana
+ Aasvogel/cherry
+ Banana
+ Car


| Specified Range Beginning | Specified Range Ending | Objects in the Range That Will Be Exported | 
| --- | --- | --- | 
| \(none\) | \(none\) | All of the objects in your bucket | 
| \(none\) | Aasvogel |  01 Aardvark Aardwolf Aasvogel/apple Aasvogel/banana Aasvogel/cherry  | 
| \(none\) | Aasvogel/banana |  01 Aardvark Aardwolf Aasvogel/apple Aasvogel/banana | 
| Aasvogel | \(none\) |  Aasvogel/apple Aasvogel/banana Aasvogel/cherry Banana Car | 
| Aardwolf | \(none\) | Aardwolf Aasvogel/apple Aasvogel/banana Aasvogel/cherry Banana Car | 
| Aar | \(none\) | Aardvark Aardwolf Aasvogel/apple Aasvogel/banana Aasvogel/cherry Banana Car | 
| car | \(none\) | No objects are exported, and you get an error message when you try to create the job\. Note that car is sorted below Car according to UTF\-8 binary values\. | 
| Aar | Aarrr | Aardvark Aardwolf | 