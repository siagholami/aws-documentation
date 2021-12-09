--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Document History<a name="doc-history"></a>
+ **API version: 1\.0** 
+ **Latest documentation update: **April 16, 2020

The following table describes important changes to the *AWS Snowball Edge Developer Guide* after July 2018\. For notifications about documentation updates, you can subscribe to the RSS feed\.

| Change | Description | Date | 
| --- |--- |--- |
| [Introducing AWS OpsHub for Snow Family](#doc-history) | The Snow Family Devices now offer a user\-friendly tool, AWS OpsHub for Snow Family, that you can use to manage your devices and local AWS services\. For more information, see [Using AWS OpsHub for Snow Family to Manage Snowball Devices](https://docs.aws.amazon.com/snowball/latest/developer-guide/aws-opshub.html)\. | April 16, 2020 | 
| [AWS Identity and Access Management \(IAM\) is now available locally on the AWS Snowball Edge device](#doc-history) | You can now use AWS Identity and Access Management \(IAM\) to securely control access to AWS resources running on your AWS Snowball Edge device\. For more information, see [Using IAM Locally](https://docs.aws.amazon.com/snowball/latest/developer-guide/using-local-iam.html)\. | April 16, 2020 | 
| [Introducing a new Snowball Edge Storage Optimized \(for data transfer\) device option](#doc-history) | Snowball now adds a new storage optimized device based on the current compute\-optimized and GPU devices\. For more information, see [Snowball Edge Device Options](https://docs.aws.amazon.com/snowball/latest/developer-guide/device-differences.html#device-options)\. | March 23, 2020 | 
| [NFC tag validation support](#doc-history) | Snowball Edge Compute Optimized devices \(with or without the GPU\) have NFC tags built into them\. You can scan these tags with the AWS Snowball Edge Verification App, available on iOS and Android\. For more information, see [Validating NFC Tags](https://docs.aws.amazon.com/snowball/latest/developer-guide/nfc-validation.html)\. | December 13, 2018 | 
| [Security groups are now available for compute instances](#doc-history) | Security groups in Snowball Edge devices are similar to security groups in the AWS Cloud, with some subtle differences\. For more information, see [Security Groups in Snowball Edge Devices](https://docs.aws.amazon.com/snowball/latest/developer-guide/edge-security-groups.html)\. | November 26, 2018 | 
| [Introducing on\-premises update](#doc-history) | You can now update the software that makes a Snowball Edge device run in your local environment\. Note that on\-premises updates require an internet connection\. For more information, see [Updating an Snowball Edge](https://docs.aws.amazon.com/snowball/latest/developer-guide/updating-device.html)\. | November 26, 2018 | 
| [Introducing new device options for Snowball Edge](#doc-history) | Snowball Edge devices come in three options – storage optimized, compute optimized, and with GPU\. For more information, see [Snowball Edge Device Options](https://docs.aws.amazon.com/snowball/latest/developer-guide/device-differences.html#device-options)\. | November 15, 2018 | 
| [New AWS Region supported](#doc-history) | Snowball Edge devices are now available in the Asia Pacific \(Mumbai\)\. Note that compute instances and AWS Lambda powered by AWS Greengrass are not supported in this region\. | September 24, 2018 | 
| [Introducing support for Amazon EC2 compute instances on Snowball Edge devices](#doc-history) | AWS Snowball now supports local Amazon EC2 compute instances running on Snowball Edge devices\. For more information about jobs using Amazon EC2 compute instances, see [https://docs.aws.amazon.com/snowball/latest/developer-guide/using-ec2.html](https://docs.aws.amazon.com/snowball/latest/developer-guide/using-ec2.html)\. | July 17, 2018 | 
| [Improved troubleshooting content](#doc-history) | The troubleshooting chapter has been updated and reorganized\. | July 11, 2018 | 

The following table describes documentation releases for the AWS Snowball Edge device before July 2018\.


****  

| Change | Description | Date | 
| --- | --- | --- | 
| New AWS Region supported | AWS Snowball is now supported in the Asia Pacific \(Singapore\) region\. For more information on shipping in this AWS Region, see [Shipping Considerations for AWS Snowball](shipping.md)\. | April 3, 2018 | 
| Automatically extracted batches of small files are now supported | You can now batch many small files together into a larger archive, and specify that those batches are automatically extracted when the data is imported into Amazon S3\. Batching small files together can significantly improve your transfer performance when moving data from your on\-premises server to a Snowball Edge device\. For more information, see [Batching Small Files](batching-small-files.md)\. | March 20, 2018 | 
| Major feature revision to the Snowball client, and cluster update | The new major feature revision for the Snowball client includes performance improvements, profiles, and support for the cluster update\. For more information, see [Using the Snowball Client](using-client.md)\. Clusters are now leaderless\. All nodes can read and write data to the cluster\. For more information, see [Using an AWS Snowball Edge Cluster](UsingCluster.md)\. | February 5, 2018 | 
| New AWS Region supported | AWS Snowball is now supported in the Europe \(Paris\) region\. For more information on shipping in this AWS Region, see [Shipping Considerations for AWS Snowball](shipping.md)\. | December 18, 2017 | 
| Improved AWS CLI support for the Amazon S3 Adapter for Snowball | You can now use the `s3 sync` command with the Amazon S3 Adapter for Snowball to sync data between a Snowball Edge and your local computer\. For more information, see [Supported AWS CLI Commands for Amazon S3](using-adapter-cli.md#using-adapter-cli-commands)\. | November 10, 2017 | 
| Updated file interface file size support | The file interface can now support files up to 150 GB in size\. For more information, see [Transferring Files to AWS Snowball Edge Using the File Interface](using-fileinterface.md)\. | October 4, 2017 | 
| New AWS Region supported | AWS Snowball Edge is now supported in the Asia Pacific \(Tokyo\) region, with region\-specific shipping options\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | September 19, 2017 | 
| New AWS Region supported | AWS Snowball Edge is now supported in the South America \(São Paulo\) region, with region\-specific shipping options\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | August 8, 2017 | 
| Updated AWS IoT Greengrass and Lambda functionality | Lambda functions running on AWS Snowball Edge devices can now be added, updated, removed, or replaced, once the devices are on\-premises\. In addition, AWS Snowball Edge devices can now be used as AWS IoT Greengrass core devices\. For more information, see [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)\. | July 25, 2017 | 
| New AWS Region supported | AWS Snowball Edge is now supported in the Canada \(Central\) region, with region\-specific shipping options\. For more information, see [Shipping Considerations for AWS Snowball](shipping.md)\. | June 29, 2017 | 
| Updated file interface functionality | With the file interface, you can now choose the Network File System \(NFS\) clients that are allowed to access the file share on the Snowball Edge, in addition to accessing other support and troubleshooting features\. For more information, see [Transferring Files to AWS Snowball Edge Using the File Interface](using-fileinterface.md)\. | June 21, 2017 | 
| Updated cluster functionality | Clusters can now be created in groups of 5–10 AWS Snowball Edge devices\. For more information, see [Using an AWS Snowball Edge Cluster](UsingCluster.md)\. | June 5, 2017 | 
| Documentation update | Documentation navigation has been updated for clarity and consistency, and a regional limitations section has been added\. For more information, see [Region Availability for AWS Snowball](limits.md#region-limits)\. | May 8, 2017 | 
| Updated compute information | The following updates have been made for AWS Lambda powered by AWS Greengrass functions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/developer-guide/doc-history.html) | December 6, 2016 | 
| Introducing AWS Snowball Edge | The AWS Snowball service now has two devices, the standard Snowball and the AWS Snowball Edge device\. With the new Snowball Edge, you can now create local storage and compute jobs, harnessing the power of the AWS Cloud locally, without an internet connection\. | November 30, 2016 | 