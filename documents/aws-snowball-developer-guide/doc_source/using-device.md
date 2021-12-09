--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using an AWS Snowball Edge Device<a name="using-device"></a>

Following, you can find an overview of the AWS Snowball Edge device, the physically rugged device protected by AWS Key Management Service \(AWS KMS\) that you'll use for local storage and compute, or to transfer data between your on\-premises servers and Amazon Simple Storage Service \(Amazon S3\)\.

For information on unlocking an AWS Snowball Edge device, see [Using the Snowball Client](using-client.md)\.

When the device first arrives, inspect it for damage or obvious tampering\.

**Warning**  
If you notice anything that looks suspicious about the device, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/), and a new one will be shipped to you\.

The following image shows what the AWS Snowball Edge device looks like\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/snowball/latest/developer-guide/images/Snowball-Edge-Image.png)

It has three doors, a front, a back, and a top that all can be opened by latches\. The top door contains the power cable for the device\. The other two doors can be opened and slid inside the device so they're out of the way while you're using it\. By opening the doors, you get access to the LCD E Ink display embedded in the front side of the device, and the power and network ports in the back\.

Once your device arrives and is powered on, you're ready to use it\.

**Topics**
+ [Using the Snowball Client](using-client.md)
+ [Transferring Files Using the Amazon S3 Adapter](using-adapter.md)
+ [Transferring Files to AWS Snowball Edge Using the File Interface](using-fileinterface.md)
+ [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)
+ [Using Amazon EC2 Compute Instances](using-ec2.md)
+ [Using IAM Locally](using-local-iam.md)
+ [Using AWS Security Token Service](using-sts.md)
+ [Ports Required to Use AWS Services on an AWS Snowball Edge Device](port-requirements.md)