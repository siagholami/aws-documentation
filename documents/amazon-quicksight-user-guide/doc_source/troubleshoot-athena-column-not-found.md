# Column Not Found When Using Athena with Amazon QuickSight<a name="troubleshoot-athena-column-not-found"></a>

If you receive a "`column not found`" error, this can happen if the columns in an analysis are missing from the Athena data source\. 

In Amazon QuickSight, open your analysis\. in the **Visualize** tab, Choose **Choose data set\.\.\.**, then **Edit analysis data sets**\. 

In the **Data sets in this analysis** screen, choose **Edit** near your data set to refresh the data set\. Amazon QuickSight caches the schema for 2 minutes\. So it can take 2 minutes before the latest changes display\. 

To investigate how the column was lost in the first place, you can go to Athena console and check the query history to find queries that edited the table\.

If this error happened when you were editing a custom SQL query in preview, verify the name of the column in the query, and check for any other syntax errors\. For example, check that the column name isn't enclosed in single quotes, which are reserved for strings\.