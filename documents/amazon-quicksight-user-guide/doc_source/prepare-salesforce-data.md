# Preparing a Data Set Based on Salesforce Data<a name="prepare-salesforce-data"></a>

Use the following procedure to prepare a Salesforce data set\.

1. Open a Salesforce data set for preparation by choosing one of the following options:
   + Create a new Salesforce data set and choose **Edit/Preview data**\. For more information about creating a new Salesforce data set using a new Salesforce data source, see [Creating a Data Set from Salesforce](create-a-data-set-salesforce.md)\. For more information about creating a new Salesforce data set using an existing Salesforce data source, see [Create a Data Set Using an Existing Salesforce Data Source](create-a-data-set-existing.md#create-a-data-set-existing-salesforce)\.
   + Open an existing Salesforce data set for editing from either the analysis page or the **Your Data Sets** page\. For more information about opening an existing data set for data preparation, see [Editing a Data Set](edit-a-data-set.md)\.

1. \(Optional\) On the data preparation page, type a name into the data set name box in the application bar if you want to change the data set name \(this defaults to the report or object name\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce-name.png)

1. \(Optional\) Change the data element selection to see either reports or objects\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce-data-element.png)

1. \(Optional\) Change the data selection to choose a different report or object\.

   If you have a long list in the **Data** pane, you can search to locate a specific item by typing a search term into the **Search tables** box\. Any item whose name contains the search term is shown\. Search is case\-insensitive and wildcards are not supported\. Choose the cancel icon \(**X**\) to the right of the search box to return to viewing all items\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/salesforce-data.png)

1. Prepare the data by doing one or more of the following:
   + [Selecting Fields](selecting-fields.md)
   + [Changing a Field Name](changing-a-field-name.md)
   + [Changing a Field Data Type](changing-a-field-data-type.md)
   + [Adding a Calculated Field During Data Preparation](working-with-calculated-fields.md#adding-a-calculated-field)
   + [Adding a Filter](adding-a-filter.md)

1. Check the [SPICE](welcome.md#spice) indicator to see if you have enough space to import the data set\. Importing data into SPICE is required for Salesforce data sets\. Importing occurs when you choose either **Save & visualize** or **Save**\.

   If you don't have enough SPICE capacity, you can remove fields from the data set or apply a filter to decrease its size\. For more information about adding and removing fields from a data set, see [Selecting Fields](selecting-fields.md)\.
**Note**  
The SPICE indicator doesn't update to reflect the potential savings of removing fields or filtering the data\. It continues to reflect the size of the data set as retrieved from the data source\.

1. Choose **Save** to save your work, or **Cancel** to cancel it\. 

   You might also see **Save & visualize**\. This option appears based on the screen you started from\. If this option isn't there, you can create a new visualization by starting from the data set screen\. 