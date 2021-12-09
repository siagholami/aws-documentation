# Adding a Data Set to an Analysis<a name="adding-a-data-set-to-an-analysis"></a>

**Topics**
+ [Add or Edit a Data Set](add-a-data-set-to-an-analysis.md)
+ [Replacing Data Sets](replacing-data-sets.md)
+ [Remove a Data Set From an Analysis](#delete-a-data-set-from-an-analysis)

After you have created an analysis, you can add more data sets to the analysis\. Then, you can use them to create more visuals\. 

From within the analysis, you can open any data set for editing, for example to add or remove fields, or perform other data preparation\. You can also remove, or replace data sets\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-data-sets.png)

The currently selected data set displays at the top of the **Fields list** pane\. This is the data set that is used by the currently selected visual\. Each visual can use only one data set\. Choosing a different visual changes the selected data set to the one used by that visual\.

To change the selected data set manually, choose the data set list at the top of the **Fields list** pane and then choose a different data set\. This deselects the currently selected visual if it doesn't use this data set; either choose a visual that uses the selected data set, or choose **Add** on the application bar and then **Add Visual** to create a new visual using the selected data set\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-select-a-dataset.png)

If you choose **Suggested** on the tool bar to see suggested visuals, you'll see visuals based on the currently selected data set\.

Only filters for the currently selected data set are shown in the **Filter** pane, and you can only create filters on the currently selected data set\. 

## Remove a Data Set From an Analysis<a name="delete-a-data-set-from-an-analysis"></a>

Use the following procedure to delete a data set from an analysis\.

1. On the analysis page, choose the data set list at the top of the **Fields list** pane and then choose **Edit analysis data sets**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-data-sets.png)

1. In the **Data sets in this analysis** dialog box, choose the data set you want to delete, and then choose the delete icon\. Note that you can't delete a data set if it's the only one in the analysis\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/delete-data-set-analysis.png)

1. Choose **Close** to close the dialog box\.