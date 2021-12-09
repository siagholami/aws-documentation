--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# AWS Snowball Limits<a name="limits"></a>

Following, you can find information about limitations on using AWS Snowball \(Snowball\)\.

**Important**  
When you transfer data into Amazon Simple Storage Service using a Snowball, keep in mind that individual Amazon S3 objects can range in size from a minimum of 0 bytes to a maximum of 5 terabytes \(TB\)\.

## Regional Limitations for AWS Snowball<a name="region-limits"></a>

The AWS Snowball service has two device types, the standard Snowball and the Snowball Edge\. The following table highlights which of these devices are available in which regions\. 

**Note**  
The guide you're reading now is for the Snowball, which has 50 TB or 80 TB of storage space\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.


****  

| Region | Snowball Availability | Snowball Edge Availability | 
| --- | --- | --- | 
| US East \(Ohio\) | 50 TB and 80 TB | 100 TB | 
| US East \(N\. Virginia\) | 50 TB and 80 TB | 100 TB | 
| US West \(N\. California\) | 50 TB and 80 TB | 100 TB | 
| US West \(Oregon\) | 50 TB and 80 TB | 100 TB | 
| Canada \(Central\) | 80 TB only | 100 TB | 
| Asia Pacific \(Mumbai\) | 80 TB only | Not available | 
| Asia Pacific \(Sydney\) | 80 TB only | 100 TB | 
| Asia Pacific \(Tokyo\) | 80 TB only | 100 TB | 
| EU \(Frankfurt\) | 80 TB only | 100 TB | 
| EU \(Ireland\) | 80 TB only | 100 TB | 
| EU \(London\) | 80 TB only | 100 TB | 
| South America \(São Paulo\) | 80 TB only | 100 TB | 

## Limitations on Jobs in AWS Snowball<a name="job-limits"></a>

The following limitations exist for creating jobs in AWS Snowball:
+ For security purposes, data transfers must be completed within 90 days of the Snowball being prepared\.
+ Currently, Snowball doesn't support server\-side encryption with AWS KMS–managed keys \(SSE\-KMS\) or server\-side encryption with customer\-provided keys \(SSE\-C\)\. Snowball does support server\-side encryption with Amazon S3–managed encryption keys \(SSE\-S3\)\. For more information on SSE\-S3, see [Protecting Data Using Server\-Side Encryption with Amazon S3\-Managed Encryption Keys \(SSE\-S3\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html) in the *Amazon Simple Storage Service Developer Guide\.*
+ In the US regions, Snowballs come in two sizes: 50 TB and 80 TB\. All other regions have the 80 TB Snowballs only\. If you're using Snowball to import data, and you need to transfer more data than will fit on a single Snowball, create additional jobs\. Each export job can use multiple Snowballs\.
+ The default service limit for the number of Snowballs you can have at one time is 1\. If you want to increase your service limit, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.
+ All objects transferred to the Snowball have their metadata changed\. The only metadata that remains the same is `filename` and `filesize`\. All other metadata is set as in the following example: `-rw-rw-r-- 1 root root [filesize] Dec 31 1969 [path/filename]`

## Limitations on Transferring On\-Premises Data with a Snowball<a name="transfer-limits"></a>

The following limitations exist for transferring data to or from a Snowball device on\-premises:
+ Files must be in a static state while being copied\. Files that are modified while they are being transferred will not be imported into Amazon S3\.
+ Jumbo frames are not supported—that is, Ethernet frames with more than 1500 bytes of payload\.
+ When selecting what data to export, keep in mind that objects with trailing slashes in their names \(`/` or `\`\) will not be transferred\. Before exporting any objects with trailing slashes, update their names to remove the slash\.
+ When using the Amazon S3 Adapter for Snowball with the AWS CLI to transfer data, note that the `--recursive` option for the `cp` command is only supported for uploading data to a Snowball, not for transferring data from a Snowball\.

## Limitations on Shipping a Snowball<a name="shipping-limits"></a>

The following limitations exist for shipping a Snowball:
+ AWS will not ship a Snowball to a post office box\.
+ AWS will not ship a Snowball between non\-US regions—for example, from EU \(Ireland\) to EU \(Frankfurt\), or from Asia Pacific \(Mumbai\) to Asia Pacific \(Sydney\)\.
+ Moving a AWS Snowball Edge device to an address outside of the country specified when the job was created is not allowed and is a violation of the AWS Service Terms\.

For more information on shipping, see [Shipping Considerations for AWS Snowball](shipping.md)\.

## Limitations on Processing Your Returned Snowball for Import<a name="return-limits"></a>

To connect your returned Snowball to one of our Snowball stations for import, the device must meet the following requirements:
+ The Snowball device must not be compromised\. Except for the two access panels in the front and the back, don't open the Snowball for any reason\.
+ The device must not be physically damaged\. You can prevent damage by closing the two panels on the Snowball until the latches make an audible clicking sound\.
+ The Snowball's E Ink display must be visible, and must show the return label that was automatically generated when you finished transferring your data onto the Snowball\.

**Note**  
All Snowballs returned that do not meet these requirements are erased without work performed on them\.