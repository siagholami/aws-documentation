# Step 7: Monitor Your Migration Task<a name="CHAP_On-PremOracle2Aurora.Steps.Monitor"></a>

Three sections in the console provide visibility into what your migration task is doing:
+ Task monitoring – The **Task Monitoring** tab provides insight into your full load throughput and also your change capture and apply latencies\.
+ Table statistics – The **Table Statistics** tab provides detailed information on the number of rows processed, type and number of transactions processed, and also information on DDL operations\.
+ Logs – From the **Logs** tab you can view your task’s log file, \(assuming you turned logging on\.\) If for some reason your task fails, search this file for errors\. Additionally, you can look in the file for any warnings\. Any data truncation in your task appears as a warning in the log file\. If you need to, you can increase the logging level by using the AWS Command Line Interface \(CLI\)\.