# Replacing Data Sets<a name="replacing-data-sets"></a>

In an analysis, you can add, edit, replace, or remove data sets\. Use this section to learn how to replace your data set\. 

When you replace a data set, the new data set should have similar columns, if you expect the visual to work the way you designed it\. Replacing the data set also clears the undo and redo history for the analysis\. This means you can't use the undo and redo buttons on the application bar to navigate your changes\. So, when you decide to change the data set, your analysis design should be somewhat stable—not in the middle of an editing phase\.

 Use the following procedure to replace a data set\.

1. Inside your analysis, choose the pencil icon near the data set from the top left of the screen\. 

1. Choose the **Replace this data set with another** icon in the screen that opens\. 

1. From the list of available data sets that appears, choose one, and then choose **Select**\. 

1. 
**Note**  
Replacing a data set clears the undo and redo history for this analysis\. 

   Review your choice, and confirm it by choosing **Replace**\. 

The data set is replaced with the new one\. The field list and visuals are updated with the new data set\. 

At this point, you can choose to add a new data set, edit the new data set, or replace it with a different one\. Choose **Close** to exit\. 

## If Your New Data Set Doesn't Match<a name="replacing-data-sets-2"></a>

If the selected replacement data set doesn't contain all of the fields and hierarchies used by the visuals, filters, parameters, and calculated fields in your analysis, you receive a warning from Amazon QuickSight\. It shows a list of mismatched columns\. 

If this happens, you can choose **Replace anyway**, which breaks some or all of your visuals, or choose **Back** to cancel\. By choosing **Back**, you get the opportunity to note the mismatches and investigate\. 

The following screenshot shows a mismatch\. The `Region` field in the data set is a geographic type, when the analysis expects it to be a text field\. Additionally, the new data set is missing the `Monthly Compensation` field, because the field containing this data has a different name in the data set\. 

In this case, you can choose **Back** and edit the data set to change `Region` to a string\. You can then rename the `Compensation` field to `Monthly Compensation`\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/replace-data-set-mismatch.png)

Alternatively, if we choose **Replace anyway**, a confirmation notice appears\. It warns you that some things in the analysis—visuals, filters, parameters, calculated fields, or some combination of these—don't work with the new data set\. Choose **Confirm** to proceed, or choose **Back** to cancel\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/replace-data-set-anyway-confirmation.png)

If you change your mind after replacing the data set, you can still recover\. Let's say you replace the data set despite the mismatches, and then find that it is too difficult to change your analysis to match the new data set\. You can undo any changes you made to your analysis, and replace the new data set with the original one, or with a data set that more closely matches the requirements of the analysis\. 