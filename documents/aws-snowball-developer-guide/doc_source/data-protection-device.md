--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Protecting Data On Your Device<a name="data-protection-device"></a>

## Securing your AWS Snowball Edge<a name="security-considerations"></a>

Following are some security points that we recommend you consider when using AWS Snowball Edge, and also some high\-level information on other security precautions that we take when a device arrives at AWS for processing\.

We recommend the following security approaches:
+ When the device first arrives, inspect it for damage or obvious tampering\. If you notice anything that looks suspicious about the device, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/), and a new device will be shipped to you\.
+ You should make an effort to protect your job credentials from disclosure\. Any individual who has access to a job's manifest and unlock code can access the contents of the device sent for that job\.
+ Don't leave the device sitting on a loading dock\. Left on a loading dock, it can be exposed to the elements\. Although each AWS Snowball Edge device is rugged, weather can damage the sturdiest of hardware\. Report stolen, missing, or broken devices as soon as possible\. The sooner such an issue is reported, the sooner another one can be sent to complete your job\.

**Note**  
The AWS Snowball Edge devices are the property of AWS\. Tampering with a device is a violation of the AWS Acceptable Use Policy\. For more information, see [http://aws\.amazon\.com/aup/](http://aws.amazon.com/aup/)\.

We perform the following security steps:
+ When transferring data with the Amazon S3 Adapter for Snowball, object metadata is not persisted\. The only metadata that remains the same is `filename` and `filesize`\. All other metadata is set as in the following example: `-rw-rw-r-- 1 root root [filesize] Dec 31 1969 [path/filename]`
+ When transferring data with the file interface, object metadata is persisted\.
+ When a device arrives at AWS, we inspect it for any signs of tampering and to verify that no changes were detected by the Trusted Platform Module \(TPM\)\. AWS Snowball Edge uses multiple layers of security designed to protect your data, including tamper\-resistant enclosures, 256\-bit encryption, and an industry\-standard TPM designed to provide both security and full chain of custody for your data\. 
+ Once the data transfer job has been processed and verified, AWS performs a software erasure of the Snowball device that follows the National Institute of Standards and Technology \(NIST\) guidelines for media sanitization\.

## Validating NFC Tags<a name="nfc-validation"></a>

Snowball Edge devices have three options for device configurations\. Snowball Edge Compute Optimized devices \(with or without the GPU\) have NFC tags built into them\. You can scan these tags with the AWS Snowball Edge Verification App, available on iOS and Android\. Scanning and validating these NFC tags can help you verify that your device has not been tampered with before you use it\.

Validating NFC tags includes using the Snowball client to generate a device\-specific QR code to verify that the tags you're scanning are for the right device\.

The following procedure describes how to validate the NFC tags on a Snowball Edge device\. Before you get started, make sure you've performed the following first five steps of the getting started exercise:

1. Create your first job\. For more information, see [Create Your First Job](create-job.md)\.

1. Receive the device\. For more information, see [Receive the Snowball Edge](receive-device.md)\.

1. Connect to your local network\. For more information, see [Connect to Your Local Network](getting-started-connect.md)\.

1. Get your credentials and tools\. For more information, see [Get Your Credentials and Tools](get-credentials.md)\.

1. Download and install the Snowball client\. For more information, see [Download and Install the Snowball Client](download-the-client.md)\.

**To validate the NFC tags in a Snowball Edge Compute Optimized device**

1. Run the `snowballEdge get-app-qr-code` Snowball client command\. If you run this command for a node in a cluster, provide the serial number \(`--device-sn`\) to get a QR code for a single node\. Repeat this step for each node in the cluster\. For more information on using this command, see [Getting Your QR Code for NFC Validation](using-client-commands.md#client-qr-code)\.

   The QR code is saved to a location of your choice as a \.png file\.

1.  Navigate to the \.png file that you saved, and open it so that you can scan the QR code with the app\.

1. To scan the NFC tags with your phone, download and install the AWS Snowball Edge Verification App from the Apple App store if you are using an iPhone\. Download the app from the Google Play store if you are using an Android phone\.

1. Start the app, and follow the on\-screen instructions\.

You've now successfully scanned and validated the NFC tags for your device\. 

If you encounter issues while scanning, try the following:
+ Confirm that your device has the Snowball Edge Compute Optimized options \(with or without GPU\)\.
+ Download the app on another phone, and try again\.
+ Move the device to an isolated area of the room, away from interference from other NFC tags, and try again\.
+ If issues persist, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.