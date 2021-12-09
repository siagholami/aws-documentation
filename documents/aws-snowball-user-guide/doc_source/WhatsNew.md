--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Document History<a name="WhatsNew"></a>
+ ****API version: ****latest
+ ****Latest document update:**** July 11, 2018

The following table describes the important changes to the documentation since the last release of AWS Snowball after July 2018\. For notifications about documentation updates, you can subscribe to the RSS feed\.

| Change | Description | Date | 
| --- |--- |--- |
| [Improved Troubleshooting Content](#WhatsNew) | The troubleshooting chapter has been updated and reorganized\. | July 11, 2018 | 

The following table describes the important changes to the documentation since the last release of AWS Snowball before July 2018\.


| Change | Description | Date Changed | 
| --- | --- | --- | 
| India carrier change | The carrier in India is now Blue Dart\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | April 4, 2018 | 
| New AWS Region supported | AWS Snowball is now supported in the Asia Pacific \(Singapore\) region\. For more information on shipping in this AWS Region, see [Shipping Considerations for AWS Snowball](shipping.md)\. | March 1, 2018 | 
| New AWS Region supported | AWS Snowball is now supported in the EU \(Paris\) region\. For more information on shipping in this AWS Region, see [Shipping Considerations for AWS Snowball](shipping.md)\. | December 18, 2017 | 
| Improved transfer speed for small files | You can now automatically batch small files to improve transfer speed by using the \-\-batch option of the Snowball client copy command\. During the import process into Amazon S3, all files in batches are automatically extracted\. For more information, see [Options for the snowball cp Command](copy-command-reference.md)\. | November 14, 2017 | 
| New AWS Region supported | AWS Snowball is now supported in the Asia Pacific \(Tokyo\) region, with region\-specific shipping options\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | September 19, 2017 | 
| New AWS Region supported | AWS Snowball is now supported in the South America \(São Paulo\) region, with region\-specific shipping options\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | August 8, 2017 | 
| New AWS Region supported | AWS Snowball is now supported in the Canada \(Central\) region, with region\-specific shipping options\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | June 29, 2017 | 
| Documentation update | The right navigation has been updated for clarity and consistency, and a regional limitations section has been added\. For more information, see [Regional Limitations for AWS Snowball](limits.md#region-limits)\. | May 8, 2017 | 
| Reading Hadoop Distributed File System \(HDFS\) custom configuration files is now supported\. | You can now specify the location of your HDFS custom configuration XML files using the new \-\-hdfsconfig option for the Snowball client cp command\. | February 8, 2017 | 
| Importing data from a Hadoop Distributed File System \(HDFS\) cluster \(version 2\.x\) is now supported\. | You can now import data from a HDFS cluster \(version 2\.x\) to Amazon S3 through a Snowball\. | September 30, 2016 | 
| Programmatic job management and data transfers are now supported\. | You can now programmatically manage jobs and transfer data with Snowball\. For more information on using the job management API for Snowball, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\. For more information on using the Amazon S3 Adapter for Snowball to call Amazon S3 REST API actions to transfer data with a Snowball, see [Transferring Data with the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md)\. | August 11, 2016 | 
| Snowball is now available from EU \(Frankfurt\) in the European Union\. | You can now create and manage jobs from the [EU \(Frankfurt\) AWS Management Console](https://eu-central-1.console.aws.amazon.com/importexport/home)\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\.  | July 25, 2016 | 
| Snowball is now available in India\. | Snowball is now available in the Asia Pacific \(Mumbai\) region\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\.  | June 27, 2016 | 
| Snowball is now available in new AWS Regions and has a new storage capacity option\. | Snowball is now available in the following regions; US East \(N\. Virginia\), US West \(Oregon\), US West \(N\. California\), EU \(Ireland\), Asia Pacific \(Sydney\), and AWS GovCloud \(US\)\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. Snowball also has a new 80 TB model available in all regions, in addition to the 50 TB model only available in the US regions\.  | April 19, 2016 | 
| Introducing export for AWS Snowball | You can now use Snowball to export data from Amazon Simple Storage Service \(Amazon S3\)\. | February 29, 2016 | 
| Hardware update: SFP\+ optical interface | The Snowball device has been updated to include a new SFP\+ optical interface that offers slightly better signal integrity over its copper counterpart but otherwise shares the same high performance\. If you received a Snowball before this date, it does not have this network interface option\. | November 18, 2015 | 
| Introducing AWS Snowball |  AWS Snowball is a data transfer service for importing huge amounts of data into Amazon Simple Storage Service \(Amazon S3\)\. With Snowball, you can import hundreds of terabytes or petabytes of data from your on\-premises data centers into Amazon S3\.  | October 7, 2015 | 