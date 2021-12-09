# Creating a Data Set from Salesforce<a name="create-a-data-set-salesforce"></a>

Use the following procedure to create a data set by connecting to Salesforce and selecting a report or object to provide data\.

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target report or object doesn't exceed data source limits\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose the **Salesforce** icon\.

1. Type a name for the data source and then choose **Create data source**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce1.png)

1. On the Salesforce login page, enter your Salesforce credentials\.

1. For **Data elements: contain your data**, choose **Select** and then choose either **REPORT** or **OBJECT**\.
**Note**  
Joined reports aren't supported as Amazon QuickSight data sources\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce2.png)

1. Choose one of the following options:
   + To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.
   + Otherwise, choose a report or object and then choose **Select**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce3.png)

1. Choose one of the following options:
   + To create a data set and an analysis using the data as\-is, choose **Visualize**\.
**Note**  
If you don't have enough [SPICE](welcome.md#spice) capacity, choose **Edit/Preview data**\. In data preparation, you can remove fields from the data set to decrease its size or apply a filter that reduces the number of rows returned\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce4.png)
   + To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation for the selected report or object\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.