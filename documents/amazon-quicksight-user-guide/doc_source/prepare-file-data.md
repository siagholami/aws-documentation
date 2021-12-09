# Preparing a Data Set Based on File Data<a name="prepare-file-data"></a>

Use the following procedure to prepare a data set based on text or Microsoft Excel files from either your local network or Amazon S3\.

1. Open a file data set for data preparation by choosing one of the following options:
   + Create a new local file data set, and then choose **Edit/Preview data**\. For more information about creating a new data set from a local text file, see [Creating a Data Set Using a Local Text File](create-a-data-set-file.md)\. For more information about creating a new data set from a Microsoft Excel file, see [Creating a Data Set Using a Microsoft Excel File](create-a-data-set-excel.md)\.
   + Create a new Amazon S3 data set, and then choose **Edit/Preview data**\. For more information about creating a new Amazon S3 data set using a new Amazon S3 data source, see [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)\. For more information about creating a new Amazon S3 data set using an existing Amazon S3 data source, see [Creating a Data Set Using an Existing Amazon S3 Data Source](create-a-data-set-existing.md#create-a-data-set-existing-s3)\.
   + Open an existing Amazon S3, text file, or Microsoft Excel data set for editing, from either the analysis page or the **Your Data Sets** page\. For more information about opening an existing data set for data preparation, see [Editing a Data Set](edit-a-data-set.md)\.

1. \(Optional\) On the data preparation page, type a new name into the data set name box on the application bar\. 

   This name defaults to the file name for local files\. For example, it defaults to **Group 1** for Amazon S3 files\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-set-name.png)

1. Review the file upload settings and correct them if necessary\. For more information about file upload settings, see [Choosing File Upload Settings](choosing-file-upload-settings.md)\.
**Important**  
If you want to change upload settings, make this change before you make any other changes to the data set\. New upload settings cause Amazon QuickSight to reimport the file\. This process overwrites all of your other changes\.

1. Prepare the data by doing one or more of the following:
   + [Selecting Fields](selecting-fields.md)
   + [Changing a Field Name](changing-a-field-name.md)
   + [Changing a Field Data Type](changing-a-field-data-type.md)
   + [Adding a Calculated Field During Data Preparation](working-with-calculated-fields.md#adding-a-calculated-field)
   + [Adding a Filter](adding-a-filter.md)

1. Check the [SPICE](welcome.md#spice) indicator to see if you have enough capacity to import the data set\. File data sets automatically load into SPICE\. The import happens when you choose either **Save & visualize** or **Save**\. 

   If you don't have access to enough SPICE capacity, you can make the data set smaller by using one of the following options: 
   + Apply a filter to limit the number of rows\.
   + Select fields to remove from the data set\.
**Note**  
The SPICE indicator doesn't update to how much space you save by removing fields or filtering the data\. It continues to reflect the SPICE usage from the last import\.

1. Choose **Save** to save your work, or **Cancel** to cancel it\. 

   You might also see **Save & visualize**\. This option appears based on the screen that you started from\. If this option isn't there, you can create a new visualization by starting from the data set screen\. 

## Preparing a Data Set Based on a Microsoft Excel File<a name="prepare-excel-file-data"></a>

Use the following procedure to prepare a Microsoft Excel data set\.

1. Open a text file data set for preparation by choosing one of the following options:
   + Create a new Microsoft Excel data set, and then choose **Edit/Preview data**\. For more information about creating a new Excel data set, see [Creating a Data Set Using a Microsoft Excel File](create-a-data-set-excel.md)\.
   + Open an existing Excel data set for editing\. You can do this from the analysis page or the **Your Data Sets** page\. For more information about opening an existing data set for data preparation, see [Editing a Data Set](edit-a-data-set.md)\.

1. \(Optional\) On the data preparation page, type a name into the data set name box in the application bar\. If you don't rename the data set, its name defaults to the Excel file name\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/excel-name.png)

1. Review the file upload settings and correct them if necessary\. For more information about file upload settings, see [Choosing File Upload Settings](choosing-file-upload-settings.md)\. 
**Important**  
If it's necessary to change upload settings, make this change before you make any other changes to the data set\. Changing upload settings causes Amazon QuickSight to reimport the file\. This process overwrites any changes you have made so far\.

1. \(Optional\) Change the sheet selection\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/excel-sheet.png)

1. \(Optional\) Change the range selection\. To do this, open **Upload Settings** from the on–data set menu beneath the login name at the top right\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/prepare-data-excel-range.png)

1. Prepare the data by doing one or more of the following:
   + [Selecting Fields](selecting-fields.md)
   + [Changing a Field Name](changing-a-field-name.md)
   + [Changing a Field Data Type](changing-a-field-data-type.md)
   + [Adding a Calculated Field During Data Preparation](working-with-calculated-fields.md#adding-a-calculated-field)
   + [Adding a Filter](adding-a-filter.md)

1. Check the [SPICE](welcome.md#spice) indicator to see if you have enough space to import the data set\. Amazon QuickSight must import Excel data sets into SPICE\. This import happens when you choose either **Save & visualize** or **Save**\.

   If you don't have enough SPICE capacity, you can choose to make the data set smaller using one of the following methods:
   + Apply a filter to limit the number of rows\.
   + Select fields to remove from the data set\.
   + Define a smaller range of data to import\.
**Note**  
The SPICE indicator doesn't update to reflect your changes until after your load them\. It shows the SPICE usage from the last import\.

1. Choose **Save** to save your work, or **Cancel** to cancel it\. 

   You might also see **Save & visualize**\. This option appears based on the screen that you started from\. If this option isn't there, you can create a new visualization by starting from the data set screen\. 