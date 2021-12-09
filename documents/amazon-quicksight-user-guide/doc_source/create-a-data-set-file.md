# Creating a Data Set Using a Local Text File<a name="create-a-data-set-file"></a>

To create a data set using a local text file data source, identify the location of the file, and then upload it\. The file data will be automatically imported into [SPICE](welcome.md#spice) as part of creating a data set\. 

Use the following procedure to create a data set based on a local text file\.

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target file doesn't exceed data source limits\.

   Supported file types include \.csv, \.tsv, \.json, \.clf, or \.elf files\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose **Upload a file**\.

1. In the **Open** dialog box, browse to a file, select it, and then choose **Open**\.

   A file must be 1 GB or less to be uploaded to Amazon QuickSight\.

1. To prepare the data before creating the data set, choose **Edit/Preview data**, otherwise choose **Visualize** to create an analysis using the data as\-is\. If you choose the former, you can specify a data set name as part of preparing the data\. If you choose the latter, a data set with the same name as the source file is created\. To learn more about data preparation, see [Preparing Data](preparing-data.md)\.