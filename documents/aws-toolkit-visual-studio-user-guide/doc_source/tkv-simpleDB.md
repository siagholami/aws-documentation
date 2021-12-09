# Using Amazon SimpleDB from AWS Explorer<a name="tkv-simpleDB"></a>

AWS Explorer displays all of the Amazon SimpleDB domains associated with the active AWS account\. From AWS Explorer, you can create or delete Amazon SimpleDB domains\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-simpleDB-explorer.png)

 *Executing Queries and Editing the Results* 

AWS Explorer can also display a grid view of a Amazon SimpleDB domain from which you can view the items, attributes, and values in that domain\. You can execute queries so that only a subset of the domain's items is displayed\. By double\-clicking a cell, you can edit the values for that item's corresponding attribute\. You can also add new attributes to the domain\.

The domain displayed here is from the Amazon SimpleDB sample included with the AWS SDK for \.NET\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-simpleDB-grid-view.png)

To execute a query, edit the query in the text box at the top of the grid view, and then choose **Execute**\. The view is filtered to show only the items that match the query\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-simpleDB-query.png)

To edit the values associated with an attribute, double\-click the corresponding cell, edit the values, and then choose **Commit Changes**\.

 *Adding an Attribute* 

To add an attribute, at the top of the view, choose **Add Attribute**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-simpleDB-new-attr-dlg.png)

To make the attribute part of the domain, you must add a value for it to at least one item and then choose **Commit Changes**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-simpleDB-new-attr-commit.png)

 *Paginating Query Results* 

There are three buttons at the bottom of the view\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-simpleDB-paginate-export.png)

The first two buttons provide pagination for query results\. To display an additional page of results, choose the first button\. To display an additional ten pages of results, choose the second button\. In this context, a page is equal to 100 rows or the number of results specified by the LIMIT value, if it is included in the query\.

 *Export to CSV* 

The last button exports the current results to a CSV file\.