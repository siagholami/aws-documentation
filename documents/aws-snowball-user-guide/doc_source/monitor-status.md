--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Monitor the Import Status<a name="monitor-status"></a>

You can track the status of your job at any time through the AWS Snowball Management Console or by making calls to the job management API\. For more information this API, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\. Whenever the Snowball is in transit, you can get detailed shipping status information from the tracking website using the tracking number you obtained when your region's carrier received the Snowball\. 

To monitor the status of your import job in the console, sign in to the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\. Choose the job you want to track from the table, or search for it by your chosen parameters in the search bar above the table\. Once you select the job, detailed information appears for that job within the table, including a bar that shows real\-time status of your job\.

Once your package arrives at AWS and the Snowball is delivered to processing, your job status changes from **In transit to AWS** to **At AWS**\. On average, it takes a day for your data import into Amazon S3 to begin\. When it does, the status of your job changes to **Importing**\. From this point on, it takes an average of two business days for your import to reach **Completed** status\.

Now your first data import job into Amazon S3 using Snowball is complete\. You can get a report about the data transfer from the console\. To access this report from the console, select the job from the table, and expand it to reveal the job's detailed information\. Choose **Get report** to download your job completion report as a PDF file\. For more information, see [Getting Your Job Completion Report and Logs in the Console](report.md)\.

**Next:** [Where Do I Go from Here?](where-to.md) 