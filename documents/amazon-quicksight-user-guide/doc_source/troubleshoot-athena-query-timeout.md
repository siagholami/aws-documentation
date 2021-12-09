# Query Timeout When Using Athena with Amazon QuickSight<a name="troubleshoot-athena-query-timeout"></a>

If your query times out, you can try these options to resolve your problem\.

If the failure was generated while working on an analysis, remember that Amazon QuickSight’s timeout for generating any visual is 2 minutes\. If you're using a custom SQL query, you can simplify your query to optimize execution time\. 

If you are in direct query mode \(not using SPICE\), you can try importing your data to SPICE\. However, if your query exceeds the Athena 30\-minute timeout, you might get another timeout while importing data into SPICE\. For the most current information on Athena limits, see [Amazon Athena Limits](https://docs.aws.amazon.com//general/latest/gr/aws_service_limits.html#amazon-athena-limits)\.