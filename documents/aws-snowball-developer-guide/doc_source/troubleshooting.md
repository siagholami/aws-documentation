--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Troubleshooting for an AWS Snowball Edge<a name="troubleshooting"></a>

Following, you can find information to help you troubleshoot problems with an AWS Snowball Edge device\. If you have trouble establishing a connection to a Snowball, see [Why can’t my AWS Snowball device establish a connection with the network?](https://aws.amazon.com/premiumsupport/knowledge-center/troubleshoot-connect-snowball/) in the *AWS Knowledge Center*\. In addition, be aware of the following:
+ Objects in Amazon S3 have a maximum file size of 5 TB\.
+ Objects transferred onto AWS Snowball Edge devices have a maximum key length of 933 bytes\. Key names that include characters that take up more than 1 byte each still have a maximum key length of 933 bytes\. When determining key length, you include the file or object name and also its path or prefixes\. Thus, files with short file names within a heavily nested path can have keys longer than 933 bytes\. The bucket name is not factored into the path when determining the key length\. Some examples follow\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/developer-guide/troubleshooting.html)
+ For security purposes, import and export jobs using an AWS Snowball Edge device must be completed within 360 days of the being prepared\. If you need to keep one or more devices for longer than 360 days, contact AWS Support\. Otherwise, after 360 days, the device becomes locked to additional on\-premises data transfers\. If the device becomes locked during a data transfer, return it and create a new job to transfer the rest of your data\. If the AWS Snowball Edge device becomes locked during an import job, we can still transfer the existing data on the device into Amazon S3\.
+ If you encounter unexpected errors using an AWS Snowball Edge device, we want to hear about it\. Make a copy of the relevant logs and include them along with a brief description of the issues that you encountered in a message to AWS Support\. For more information about logs, see [Commands for the Snowball Client](using-client-commands.md)\.

## How to Identify Your Device<a name="identifying-device"></a>

There are two Snowball device types, Snowball and Snowball Edge\. If you're not sure which type of device you have on hand, see [AWS Snowball Device Differences](device-differences.md)\.

## Troubleshooting Connection Problems<a name="connection-troubleshooting"></a>

The following information can help you troubleshoot certain issues that you might have with connecting to your Snowball Edge: 
+ Routers and switches that work at a rate of 100 megabytes per second don't work with a Snowball Edge\. We recommend that you use a switch that works at a rate of 1 GB per second \(or faster\)\. 
+ If you experience odd connection errors with the device, power off the Snowball Edge, unplug all the cables, and leave it for 10 minutes\. After 10 minutes have passed, restart the device, and try again\.
+ Ensure that no antivirus software or firewalls block the Snowball Edge device's network connection\.
+ Be aware that the file interface and Amazon S3 Adapter for Snowball have different IP addresses\.

For more advanced connection troubleshooting, you can take the following steps:
+ If you can't communicate with the Snowball Edge, ping the IP address of the device\. If the ping returns `no connect`, confirm the IP address for the device and confirm your local network configuration\.
+ If the IP address is correct and the lights on the back of the device are flashing, then use telnet to test the device on ports 22 and 8080\. Testing port 22 determines if the Snowball Edge is working correctly\. Testing port 8080 ensures that the device can write to the Amazon S3 buckets on it\. If you can connect on port 22 but not on port 8080, first power off the Snowball Edge and then unplug all the cables\. Leave the device for 10 minutes, and then reconnect it and start again\.

## Troubleshooting Manifest File Problems<a name="manifest-file-troubleshooting"></a>

Each job has a specific manifest file associated with it\. If you create multiple jobs, track which manifest is for which job\.

If you lose a manifest file or if a manifest file is corrupted, you can redownload the manifest file for a specific job\. You do so using the console, AWS CLI, or one of the AWS APIs\.

## Troubleshooting Credentials Problems<a name="credentials-troubleshooting"></a>

Use the following topics to help you resolve credentials issues with the Snowball Edge\.

### Unable to Locate AWS CLI Credentials<a name="cli-credentials-troubleshoot"></a>

If you're communicating with the AWS Snowball Edge device through the Amazon S3 Adapter for Snowball by using the AWS CLI, you might encounter an error message that says `Unable to locate credentials. You can configure credentials by running "aws configure".`

**Action to take**  
Configure the AWS credentials that the AWS CLI uses to run commands for you\. For more information, see [Configuring the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.

### Error Message: Check Your Secret Access Key and Signing<a name="adapter-credentials-troubleshoot"></a>

When using the Amazon S3 Adapter for Snowball to transfer data to a Snowball Edge, you might encounter the following error message\.

```
An error occurred (SignatureDoesNotMatch) when calling the CreateMultipartUpload operation: The request signature we calculated does not match the signature you provided. 
Check your AWS secret access key and signing method. For more details go to:
http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html#ConstructingTheAuthenticationHeader
```

**Action to take**  
Get your credentials from the Snowball client\. For more information, see [Getting Credentials](using-client-commands.md#client-credentials)\.

## Troubleshooting Data Transfer Problems<a name="transfer-troubleshooting"></a>

If you encounter performance issues while transferring data to or from a Snowball Edge, see [Performance](BestPractices.md#performance) for recommendations and guidance on improving transfer performance\. The following can help you troubleshoot issues that you might have with your data transfer to or from a Snowball Edge:
+ You can't transfer data into the root directory of the Snowball Edge\. If you have trouble transferring data into the device, make sure that you're transferring data into a subdirectory\. The top\-level subdirectories have the names of the Amazon S3 buckets that you included in the job\. Put your data in those subdirectories\.
+ If you're using Linux and you can't upload files with UTF\-8 characters to an AWS Snowball Edge device, it might be because your Linux server doesn't recognize UTF\-8 character encoding\. You can correct this issue by installing the `locales` package on your Linux server and configuring it to use one of the UTF\-8 locales like `en_US.UTF-8`\. You can configure the `locales` package by exporting the environment variable `LC_ALL`, for example: `export LC_ALL=en_US.UTF-8`
+ When you use the Amazon S3 Adapter for Snowball with the AWS CLI, you can work with files or folders with spaces in their names, such as `my photo.jpg` or `My Documents`\. However, make sure that you handle the spaces properly\. For more information, see [Specifying Parameter Values for the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html) in the *AWS Command Line Interface User Guide*\.

### Troubleshooting Problems with Transferring Data with the File Interface<a name="file-interface-transfer-troubleshoot"></a>

If you encounter issues while transferring data with the file interface, keep the following considerations in mind:
+ The maximum size of a file that you can transfer to the file interface on a Snowball Edge is 150 GB\. If you try to transfer a file larger than 150 GB, the file interface writes the first 150 GB of that file, and then returns an error message indicating that the file is too large\.
+ We recommend that you use only one method of reading and writing data to each bucket on a Snowball Edge device\. Using both the file interface and the Amazon S3 Adapter for Snowball on the same bucket might result in undefined behavior\.
+ The file interface supports all NFS file operations, except truncation, renaming, and changing ownership\. Requests that use these unsupported file operations are rejected with error messages sent to your NFS client\. Attempts to change a file's permissions after the file has been created on the Snowball Edge are ignored without an error message\.
+ If the Snowball Edge has a power failure or is rebooted, data in the file interface buffer persists\. On reboot, this buffered data is uploaded to buckets on the device\. When **Write status** on the **File interface** tab shows 100 percent with a green progress bar, all data in the file interface buffer is uploaded to the buckets on the device\.
+ Don't write data to a Snowball Edge that is full\. Also, don't write more data to a Snowball Edge than can fit in the remaining available storage\. Either action causes errors that might corrupt your data\. We recommend that you use the Snowball client's `snowballEdge status` command to determine the remaining amount of space on the Snowball Edge\. Then compare the remaining space to the amount of data that you want to copy using the file interface before copying the data\.
+ When you've finished copying data to the Snowball Edge using the file interface, you must disable the file interface\. You do so to avoid losing any data that might be in the buffer but not yet written to the Amazon S3 bucket\. For more information, see [Disabling the File Interface](using-fileinterface.md#fileinterface-cleanup)\.
+ We recommend that you keep a local copy of all data that is written to the file interface until the Snowball Edge has been shipped back to AWS and the data has been ingested to Amazon S3\.

## Troubleshooting AWS CLI Problems<a name="cli-troubleshooting"></a>

Use the following topics to help you resolve problems when working with an AWS Snowball Edge device and the AWS CLI\. 

### AWS CLI Error Message: "Profile Cannot Be Null"<a name="null-profile-troubleshooting"></a>

When working with the AWS CLI, you might encounter an error message that says `"Profile cannot be null"`\. You can encounter this error if the AWS CLI hasn't been installed or an AWS CLI profile hasn't been configured\.

**Action to take**  
Ensure that you have downloaded and configured the AWS CLI on your workstation\. For more information, see [Install the AWS CLI Using the Bundled Installer \(Linux, macOS, or Unix\)](https://docs.aws.amazon.com/cli/latest/userguide/awscli-install-bundle.html) in the *AWS Command Line Interface User Guide\.*

### Null Pointer Error When Transferring Data with the AWS CLI<a name="null-pointer-troubleshooting"></a>

When using the AWS CLI to transfer data, you might encounter a null pointer error\. This error can occur in the following conditions:
+ If the specified file name is misspelled, for example `flowwer.png` or `flower.npg` instead of `flower.png`
+ If the specified path is incorrect, for example `C:\Doccuments\flower.png` instead of `C:\Documents\flower.png`
+ If the file is corrupted

**Action to take**  
Confirm that your file name and path are correct, and try again\. If you continue to experience this issue, confirm that the file has not corrupted, abandon the transfer, or attempt repairs to the file\.

## Troubleshooting Import Job Problems<a name="import-troubleshooting"></a>

Sometimes files fail to import into Amazon S3\. If the following issue occurs, try the actions specified to resolve your issue\. If a file fails import, you might need to try importing it again\. Importing it again might require a new job for Snowball Edge\.

**Files failed import into Amazon S3 due to invalid characters in object names**  
This problem occurs if a file or folder name has characters that aren't supported by Amazon S3\. Amazon S3 has rules about what characters can be in object names\. For more information, see [Object Key Naming Guidelines](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-key-guidelines)\.

**Action to take**  
If you encounter this issue, you see the list of files and folders that failed import in your job completion report\.

In some cases, the list is prohibitively large, or the files in the list are too large to transfer over the internet\. In these cases, you should create a new Snowball import job, change the file and folder names to comply with Amazon S3 rules, and transfer the files again\.

If the files are small and there isn't a large number of them, you can copy them to Amazon S3 through the AWS CLI or the AWS Management Console\. For more information, see [How Do I Upload Files and Folders to an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html) in the *Amazon Simple Storage Service Console User Guide\.*

## Troubleshooting Export Job Problems<a name="export-troubleshooting"></a>

Sometimes files fail to export into your workstation\. If the following issue occurs, try the actions specified to resolve your issue\. If a file fails export, you might need to try exporting it again\. Exporting it again might require a new job for Snowball Edge\.

**Files failed export to a Microsoft Windows Server**  
A file can fail export to a Microsoft Windows Server if it or a related folder is named in a format not supported by Windows\. For example, if your file or folder name has a colon \(`:`\) in it, the export fails because Windows doesn't allow that character in file or folder names\.

**Action to take**

1. Make a list of the names that are causing the error\. You can find the names of the files and folders that failed export in your logs\. For more information, see [AWS Snowball Edge Logs](using-client-commands.md#logs)\.

1. Change the names of the objects in Amazon S3 that are causing the issue to remove or replace the unsupported characters\.

1. If the list of names is prohibitively large, or if the files in the list are too large to transfer over the internet, create a new export job specifically for those objects\.

   If the files are small and there isn't a large number of them, copy the renamed objects from Amazon S3 through the AWS CLI or the AWS Management Console\. For more information, see [How Do I Download an Object from an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/download-objects.html) in the* Amazon Simple Storage Service Console User Guide\.*