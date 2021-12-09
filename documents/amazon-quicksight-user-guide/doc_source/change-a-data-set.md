# Changing a Data Set<a name="change-a-data-set"></a>

In two situations, changes to a data set might cause concern\. One is if you deliberately edit the data set\. The other is if your data source has changed so much that it affects the analyses based on it\. 

**Important**  
Analyses that are in production usage should be protected so they continue to function correctly\. 

We recommend the following when you're dealing with data changes:
+ Document your data sources and data sets, and the visuals that rely upon them\. Documentation should include screenshots, fields used, placement in field wells, filters, sorts, calculations, colors, formatting, and so on\. Record everything that you need to recreate the visual\.
+ When you edit a data set, try not to make changes that might break existing visuals\. For example, don't remove columns that are being used in a visual\. If you must remove a column, create a calculated column in its place\. The replacement column should have the same name and data type as the original\. 
+ If your data source or data set changes in your source database, adapt your visual to accommodate the change, as described previously\. Or you can try to adapt the source database\. For example, you might create a view of the source table \(document\)\. Then if the table changes, you can adjust the view to include or exclude columns \(attributes\), change data types, fill null values, and so on\. Or, in another circumstance, if your data set is based on a slow SQL query, you might create a table to hold the results of the query\. 

  If you can't sufficiently adapt the source of the data, recreate the visuals based on your documentation of the analysis\.
+ If you no longer have access to a data source, your analyses based on that source are empty\. The visuals you created still exist, but they can't display until they have some data to show\. This result can happen if permissions are changed by your administrator\.
+ If you remove the data set a visual is based on, you might need to recreate it from your documentation\. You can edit the visual and select a new data set to use with it\. If you need to consistently use a new file to replace an older one, store your data in a location that is consistently available\. For example, you might store your \.csv file in S3 and create an S3 data set to use for your visuals\. For more information on access files stored in S3, see [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)\. 

  Alternatively, you can import the data into a table, and base your visual on a query\. This way, the data structures don't change, even if the data contained in them changes\.