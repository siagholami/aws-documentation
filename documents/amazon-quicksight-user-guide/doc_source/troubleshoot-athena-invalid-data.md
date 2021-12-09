# Invalid Data When Using Athena with Amazon QuickSight<a name="troubleshoot-athena-invalid-data"></a>

An "Invalid Data" error can occur when you use any operator or function in a calculated field\. Verify that the data in the table is consistent with the format you supplied to the function\.

For example, if you are using the function `parseDate(expression, [‘format’], [‘time_zone’])` as **parseDate\(date\_column, ‘MM/dd/yyyy’\)**, all values in `date_column` must conform to `'MM/dd/yyyy'` format \(`’05/12/2016’`\)\. Any value that isn't in this format \(**‘2016/12/05’**\) can cause an error\.