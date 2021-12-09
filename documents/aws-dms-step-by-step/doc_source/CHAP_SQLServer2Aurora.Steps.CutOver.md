# Step 8: Cut Over to Aurora MySQL<a name="CHAP_SQLServer2Aurora.Steps.CutOver"></a>

Perform the following steps to move connections from your Microsoft SQL Server database to your Amazon Aurora MySQL database\.

**To cut over to Aurora MySQL**

1. End all SQL Server database dependencies and activities, such as running scripts and client connections\. Ensure that the SQL Server Agent service is stopped\.

   The following query should return no results other than your connection:

   ```
   SELECT session_id, login_name from sys.dm_exec_sessions where session_id > 50;
   ```

1. Kill any remaining sessions \(other than your own\)\.

   ```
                      
   KILL session_id;
   ```

1. Shut down the SQL Server service\.

1. Let the AWS DMS task apply the final changes from the SQL Server database on the Amazon Aurora MySQL database\.

1. In the AWS DMS console, stop the AWS DMS task by choosing **Stop** for the task, and then confirming that you want to stop the task\.