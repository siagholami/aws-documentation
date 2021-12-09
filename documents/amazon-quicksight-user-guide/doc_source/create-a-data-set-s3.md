# Creating a Data Set Using Amazon S3 Files<a name="create-a-data-set-s3"></a>

To create a data set using one or more text files \(\.csv, \.tsv, \.clf, or \.elf\) from Amazon S3, create a manifest that Amazon QuickSight can use to identify the files that you want to use, and also the upload settings needed to import them\. When you create a data set using Amazon S3, the file data is automatically imported into [SPICE](welcome.md#spice)\.

You must grant Amazon QuickSight access to any Amazon S3 buckets that you want to read files from\. For information about granting Amazon QuickSight access to AWS resources, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\.

Use the following procedure to create an Amazon S3 data set\.

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target file set doesn't exceed data source limits\.

1. Create a manifest file to identify the text files you want to import, using one of the formats specified in [Supported Formats for Amazon S3 Manifest Files](supported-manifest-file-format.md)\.

1. You can save the manifest file to a local directory, or upload it into Amazon S3\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose the Amazon S3 icon\.

1. For **Data source name**, type a description of the data source\. This name should be something that helps you distinguish this data source from others\.

1. For **Upload a manifest file**, do one of the following:
   + To use a local manifest file, choose **Upload**, and then choose **Upload a JSON manifest file**\. For **Open**, choose a file, and then choose **Open**\.
   + To use a manifest file from Amazon S3, choose **URL**, and type the URL for the manifest file\. To find the URL of a pre\-existing manifest file in the Amazon S3 console, navigate to the appropriate file and choose it\. A properties panel displays, including the link URL\. You can copy the URL and paste it into Amazon QuickSight\.

1. Choose **Connect**\.

1. To make sure that the connection is complete, choose **Edit/Preview data**\. Otherwise, choose **Visualize** to create an analysis using the data as\-is\. If you choose **Edit/Preview data**, you can specify a data set name as part of preparing the data\. Otherwise, the data set name matches the name of the manifest file\. 

   To learn more about data preparation, see [Preparing Data](preparing-data.md)\.