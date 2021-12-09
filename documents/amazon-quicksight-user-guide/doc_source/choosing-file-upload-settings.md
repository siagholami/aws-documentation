# Choosing File Upload Settings<a name="choosing-file-upload-settings"></a>

If you are using a file data source, you should confirm the upload settings that Amazon QuickSight uses to import the file into [SPICE](welcome.md#spice), and correct them if necessary\.

**Important**  
If it's necessary to change upload settings, make these changes before you make any other changes to the data set\. Changing upload settings causes Amazon QuickSight to reimport the file\. This process overwrites any changes you have made so far\.

## Changing Text File Upload Settings<a name="change-text-file-upload-settings"></a>

Text file upload settings include the file header indicator, file format, text delimiter, text qualifier, and start row\. If you are working with an Amazon S3 data source, the upload settings you select are applied to all files you choose to use in this data set\.

Use the following procedure to change text file upload settings\.

1. On the data preparation page, open the **Upload Settings** pane by choosing the expand icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/expand-upload-settings.png)

1. In **File format**, choose the file format type\.

1. If you chose the **custom separated \(CUSTOM\)** format, specify the separating character in **Delimiter**\. 

1. If the file doesn't contain a header row, deselect the **Files include headers** check box\.

1. If you want to start from a row other than the first row, specify the row number in **Start from row**\. If the **Files include headers** check box is selected, the new starting row is treated as the header row\. If the **Files include headers** check box is not selected, the new starting row is treated as the first data row\.

1. In **Text qualifier**, choose the text qualifier, either single quotes \('\) or double quotes \("\)\.

## Changing Microsoft Excel File Upload Settings<a name="change-excel-file-upload-settings"></a>

Microsoft Excel file upload settings include the range header indicator and whole sheet selector\.

Use the following procedure to change Microsoft Excel file upload settings\.

1. On the data preparation page, open the **Upload Settings** pane by choosing the expand icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/expand-upload-settings-excel.png)

1. Leave **Upload whole sheet** selected\.

1. If the file doesn't contain a header row, deselect the **Range contains headers** check box\.