--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Return the Snowball Edge<a name="return-device"></a>

The prepaid shipping label on the E Ink display contains the correct address to return the AWS Snowball Edge device\. For information on how to return the device, see [Shipping Carriers](mailing-storage.md#carriers)\. The device is delivered to an AWS sorting facility and forwarded to the AWS data center\. The carrier automatically reports back a tracking number for your job to the AWS Snowball Management Console\. You can access that tracking number, and also a link to the tracking website, by viewing the job's status details in the console, or by making calls to the job management API\.

**Important**  
Unless personally instructed otherwise by AWS, never affix a separate shipping label to the device\. Always use the shipping label that is displayed on the E Ink display\.

Additionally, you can track the status changes of your job through the AWS Snowball Management Console, by Amazon SNS notifications if you selected that option during job creation, or by making calls to the job management API\. For more information on this API, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\. The final status values include when the AWS Snowball Edge device has been received by AWS, when data import begins, and when the job is completed\.

**Job\-Type Specific Consideration**

If you are exporting data or if you are using a device for a local storage and compute only job, then your job is now complete\. For information on what to do next, see [Where Do I Go from Here?](where-to.md)\.

**Next:** [Monitor the Import Status](monitor-status.md) 