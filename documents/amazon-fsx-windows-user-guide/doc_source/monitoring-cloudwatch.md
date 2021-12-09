# Monitoring with Amazon CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor file systems using Amazon CloudWatch, which collects and processes raw data from Amazon FSx for Windows File Server into readable, near real\-time metrics\. These statistics are retained for a period of 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. By default, Amazon FSx for Windows File Server metric data is automatically sent to CloudWatch at 1\-minute periods\. For more information about CloudWatch, see [What Is Amazon CloudWatch?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html) in the *Amazon CloudWatch User Guide*\.

As with Amazon EFS, Amazon S3, and Amazon EBS, Amazon FSx CloudWatch metrics are reported as raw *Bytes*\. Bytes are not rounded to either a decimal or binary multiple of the unit\.

Amazon FSx for Windows File Server publishes the following metrics into the `AWS/FSx` namespace in CloudWatch\. For each metric, Amazon FSx for Windows File Server emits a data point per file system per minute\.


| Metric | Description | 
| --- | --- | 
| DataReadBytes |  The number of bytes for file system read operations\. The `Sum` statistic is the total number of bytes associated with read operations during the period\. To calculate the average throughput \(Bytes per second\) for a period, divide the `Sum` statistic by the number of seconds in the period\. Units: Bytes Valid statistics: `Sum`  | 
| DataWriteBytes |  The number of bytes for file system write operations\. The `Sum` statistic is the total number of bytes associated with write operations during the period\. To calculate the average throughput \(Bytes per second\) for a period, divide the `Sum` statistic by the number of seconds in the period\. Units: Bytes Valid statistics: `Sum`  | 
| DataReadOperations |  The number of read operations\. The `Sum` statistic is the count of read operations during the time period\. To calculate the average number of read operations \(operations per second\) for a period, divide the `Sum` statistic by the number of seconds in the period\. Units: Count Valid statistics: `Sum`  | 
| DataWriteOperations |  The number of write operations\. The `Sum` statistic is the count of write operations during the time period\. To calculate the average number of write operations \(operations per second\) for a period, divide the `Sum` statistic by the number of seconds in the period\. Units: Count Valid statistics: `Sum`  | 
| MetadataOperations |  The number of metadata operations\. The `Sum` statistic is the count of metadata operations during the time period\. To calculate the average number of metadata operations \(operations per second\) for a period, divide the `Sum` statistic by the number of seconds in the period\. Units: Count Valid statistics: `Sum`  | 
| FreeStorageCapacity |  The amount of available storage capacity\. Units: Bytes Valid statistics: `Average`, `Minimum`  | 

## Amazon FSx for Windows File Server Dimensions<a name="fsx-dimensions"></a>

Amazon FSx for Windows File Server metrics use the `FSx` namespace and provide metrics for a single dimension, `FileSystemId`\. You can find a file system's ID using the [aws fsx describe\-file\-systems](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html) AWS CLI command or the [DescribeFileSystems](https://docs.aws.amazon.com/v2/documentation/api/latest/reference/fsx/describe-file-systems.html) API command\. A file system ID takes the form of *fs\-0123456789abcdef0*\.