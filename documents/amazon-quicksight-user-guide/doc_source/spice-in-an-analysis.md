# SPICE Data in an Analysis<a name="spice-in-an-analysis"></a>

When you use [SPICE](welcome.md#spice) data to create an analysis, a data import indicator appears next to the data set list at the top of the **Fields list** pane\. When you first open the analysis and the data set is importing, this icon appears as a spinner\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/importing-data-icon.png)

Once the SPICE import completes, the indicator displays the percentage of rows that were successfully imported\. A message also appears at the top of the visualization pane to provide counts of the rows imported and skipped\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-spice-check.png)

If any rows were skipped, you can choose **View summary** in this message bar to see details about why those rows failed to import\. To edit the data set and resolve the issues that led to skipped rows, choose **Edit data set**\. For more information about common causes for skipped rows, see [My Rows Were Skipped During Data Preparation](troubleshooting-skipped-rows.md)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/skipped-rows.png)

If an import fails altogether, the data import indicator appears as an exclamation point icon, and an **Import failed** message displays\.