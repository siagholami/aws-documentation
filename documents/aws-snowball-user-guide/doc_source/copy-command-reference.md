--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Options for the snowball cp Command<a name="copy-command-reference"></a>

Following, you can find information about `snowball cp` command options and also syntax guidelines for using this command\. You use this command to transfer data from your workstation to a Snowball\.


| Command Option | Description | 
| --- | --- | 
| \-b, \-\-batch | String\. Significantly improves the transfer performance for small files by batching them into larger `.snowballarchives` files\. Batching is on by default\. You can change the following defaults to specify when a file is included in a batch: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/copy-command-reference.html) During import into Amazon S3, batches are extracted and the original files are imported into Amazon S3\. Only `.snowballarchives` files that were created during the copy command with this option are extracted automatically during import\.   | 
| \-\-checksum | On and set to false by default\. Calculates a checksum for any source and destination files with the same name, and then compares the checksums\. This command option is used when a copy operation is resumed\. Using this option adds computational overhead during your copy operation\.  When this option isn't used, a faster comparison of just file names and dates occurs when you resume as copy operation\.   | 
| \-f, \-\-force | On and set to false by default\. This command option has two uses: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/copy-command-reference.html)  The preceding use cases are not mutually exclusive\. We recommend that you use `-f` with care to prevent delays in data transfer\.   | 
| \-h, \-\-help | On and set to false by default\. Displays the usage information for the `snowball cp` command in the terminal\. | 
| \-\-noBatch | String\. Disables automatic batching of small files\. If you're copying a directory, and you use this option, you must also use the `--recursive` option\. This option is hidden\. For performance reasons, we don't recommend that you use it unless your use case requires it\.  | 
| \-r, \-\-recursive | On and set to false by default\. Recursively traverses directories during the `snowball cp` command's operation\. | 
| \-s, \-\-stopOnError | On and set to false by default\. Stops the `snowball cp` command's operation if it encounters an error\. | 

**Important**  
The `--batch` option for the Snowball client's copy command is not supported for HDFS data transfers\. If you must transfer a large number of small files from an HDFS cluster, we recommend that you find a method of collecting them into larger archive files, and then transferring those\. However, these archives are what is imported into Amazon S3\. If you want the files in their original state, take them out of the archives after importing the archives\.

## Snowball Logs<a name="snowballlogs"></a>

When you transfer data between your on\-premises data centers and a Snowball, the Snowball client automatically generates a plaintext log and saves it to your workstation\. If you encounter unexpected errors during data transfer to the Snowball, make a copy of the associated log files\. Include them along with a brief description of the issues that you encountered in a message to AWS Support\.

Logs are saved in the following locations, based on your workstation's operating system:
+ **Windows** – C:\\Users\\*<username>*\\\.aws\\snowball\\logs\\
+ **Mac** – /Users/*<username>*/\.aws/snowball/logs/
+ **Linux** – /home/*<username>*/\.aws/snowball/logs/

Logs are saved with the file name snowball\_*<year>*\_*<month>*\_*<date>*\_*<hour>*\. The hour is based on local system time for the workstation and uses a 24\-hour clock\.

**Example Log Name**

```
snowball_2016_03_28_10.log
```

Each log has a maximum file size of 5 MB\. When a log reaches that size, a new file is generated, and the log is continued in the new file\. If additional logs start within the same hour as the old log, then the name of the first log is appended with `.1` and the second log is appended with `.2`, and so on\.

**Important**  
Logs are saved in plaintext format and contain file name and path information for the files that you transfer\. To protect this potentially sensitive information, we strongly suggest that you delete these logs once the job that the logs are associated with enters the **completed** status\.