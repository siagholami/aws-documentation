--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Return the device<a name="return-device"></a>

The prepaid shipping label on the E Ink display contains the correct address to return the Snowball\. For information on how to return your Snowball, see [Shipping Carriers](mailing-storage.md#carriers)\. The Snowball will be delivered to an AWS sorting facility and forwarded to the AWS data center\. The carrier will automatically report back a tracking number for your job to the AWS Snowball Management Console\. You can access that tracking number, and also a link to the tracking website, by viewing the job's status details in the console, or by making calls to the job management API\.

**Important**  
Unless personally instructed otherwise by AWS, never affix a separate shipping label to the Snowball\. Always use the shipping label that is displayed on the Snowball's E Ink display\.

Additionally, you can track the status changes of your job through the AWS Snowball Management Console, by Amazon SNS notifications if you selected that option during job creation, or by making calls to the job management API\. For more information on this API, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\. The final status values include when the Snowball has been received by AWS, when data import begins, and when the import job is completed\.

**Next:** [Monitor the Import Status](monitor-status.md) 