# Creating a Data Set Using a Microsoft Excel File<a name="create-a-data-set-excel"></a>

To create a data set using a Microsoft Excel file data source, upload an \.xlsx file from a local or networked drive\. The data will be imported into [SPICE](welcome.md#spice)\.

 For more information about creating new Amazon S3 data sets using Amazon S3 data sources, see [Creating a Data Set Using an Existing Amazon S3 Data Source](create-a-data-set-existing.md#create-a-data-set-existing-s3) or [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)\. 

Use the following procedure to create a data set based on an Excel file\. 

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target file doesn't exceed data source limits\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose **Upload a file**\.

1. In the **Open** dialog box, choose a file, and then choose **Open**\.

   A file must be 1 GB or less to be uploaded to Amazon QuickSight\.

1. If the Excel file contains multiple sheets, choose the sheet to import\. You can change this later by preparing the data\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/choose-sheet.png)

1. 
**Note**  
On the following screens, you have multiple chances to prepare the data\. Each of these takes you to the **Prepare Data** screen\. This screen is the same one where you can access after the data import is complete\. It allows you to change the upload settings even after the upload is complete\.

    Choose **Select** to confirm your settings\. Or, you can choose **Edit/Preview data** to prepare the data immediately\.

1. A preview of the data appears on the next screen\. You can't make changes directly to the data preview\. If the data headings and content don't look correct, you can choose **Edit settings and prepare data** to correct the file upload settings\. 

   Otherwise, choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/correct-settings.png)

1. On the **Data Source Details** screen, you can choose **Edit/Preview data**\. You can specify a data set name in the **Prepare Data** screen\. 

    If you don't need to prepare the data, you can choose to create an analysis using the data as\-is\. Choose **Visualize**\. Doing this names the data set the same as the source file, and takes you to the **Analysis** screen\. To learn more about data preparation and excel upload settings, see [Preparing Data](preparing-data.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/finish-excel.png)