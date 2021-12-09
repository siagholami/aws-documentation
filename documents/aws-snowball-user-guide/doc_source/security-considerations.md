--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Other Security Considerations for Snowball<a name="security-considerations"></a>

Following are some security points that we recommend you consider when using Snowball, and also some high\-level information on other security precautions that we take when a Snowball arrives at AWS for processing\.

We recommend the following security approaches:
+ When the Snowball first arrives, inspect it for damage or obvious tampering\. If you notice anything that looks suspicious about the Snowball, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/), and a new Snowball will be shipped to you\.
+ You should make an effort to protect your job credentials from disclosure\. Any individual who has access to a job's manifest and unlock code can access the contents of the Snowball device sent for that job\.
+ Don't leave the Snowball sitting on a loading dock\. Left on a loading dock, it can be exposed to the elements\. Although the Snowball is rugged, weather can damage the sturdiest of hardware\. Report stolen, missing, or broken Snowballs as soon as possible\. The sooner such a Snowball issue is reported, the sooner another one can be sent to complete your job\.

**Note**  
The Snowball is the property of AWS\. Tampering with a Snowball is a violation of the AWS Acceptable Use Policy\. For more information, see [http://aws\.amazon\.com/aup/](http://aws.amazon.com/aup/)\.

We perform the following security steps:
+ All objects transferred to the Snowball have their metadata changed\. The only metadata that remains the same is `filename` and `filesize`\. All other metadata is set as in the following example: `-rw-rw-r-- 1 root root [filesize] Dec 31 1969 [path/filename]`
+ When a Snowball arrives at AWS, we inspect every device for any signs of tampering and to verify that no changes were detected by the Trusted Platform Module \(TPM\)\. AWS Snowball uses multiple layers of security designed to protect your data, including tamper\-resistant enclosures, 256\-bit encryption, and an industry\-standard TPM designed to provide both security and full chain of custody for your data\. 
+ After the data transfer job has been processed and verified, AWS performs a software erasure of the Snowball device that follows the National Institute of Standards and Technology \(NIST\) guidelines for media sanitization\.