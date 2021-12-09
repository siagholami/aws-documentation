--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Troubleshooting for a Standard Snowball<a name="troubleshooting"></a>

The following can help you troubleshoot problems that you might have with an AWS Snowball \(Snowball\)\. If you're having trouble establishing a connection to a Snowball, see [Why can’t my AWS Snowball device establish a connection with the network?](https://aws.amazon.com/premiumsupport/knowledge-center/troubleshoot-connect-snowball/) in the *AWS Knowledge Center*\.

## How to Identify Your Device<a name="identifying-device"></a>

There are two Snowball device types, The Snowball and the Snowball Edge\. If you're not sure which type of device you have on hand, see [AWS Snowball Device Differences](device-differences.md)\.

## Troubleshooting Connection Problems<a name="connection-troubleshooting"></a>

The following can help you troubleshoot issues you might have with connecting to your Snowball\. 
+ Routers and switches that work at a rate of 100 megabytes per second won't work with a Snowball\. We recommend that you use a switch that works at a rate of 1 GB per second \(or faster\)\. 
+ If you experience odd connection errors with the device, power off the Snowball, unplug all the cables, and leave it for 10 minutes\. After 10 minutes have passed, restart the device, and try again\.
+ Ensure that no antivirus software or firewalls block the Snowball device's network connection\.
+ If the LCD display has an error that says **Appliance timed out**, power off the Snowball, unplug all the cables, leave the appliance for 10 minutes, and then reconnect it and start again

For more advanced connection troubleshooting, you can take the following steps:
+ If you can't communicate with the Snowball Edge, ping the IP address of the device\. If the ping returns `no connect`, confirm the IP address for the device and confirm your local network configuration\.
+ If the IP address is correct and the lights on the back of the device are flashing, then use telnet to test the device on ports 22 and 8080\. Testing port 22 determines if the Snowball Edge is working correctly\. Testing port 8080 ensures that the device can write to the Amazon S3 buckets on it\. If you can connect on port 22 but not on port 8080, first power off the Snowball Edge and then unplug all the cables\. Leave the device for 10 minutes, and then reconnect it and start again\.

## Troubleshooting Manifest File Problems<a name="manifest-file-troubleshooting"></a>

Each job has a specific manifest file associated with it\. If you create multiple jobs, track which manifest is for which job\.

If you lose a manifest file or if a manifest file is corrupted, you can redownload the manifest file for a specific job\. You do so using the console, AWS CLI or one of the AWS APIs\.

## Troubleshooting Data Transfer Problems<a name="transfer-troubleshooting"></a>

If you encounter performance issues while transferring data to or from a Snowball, see [Performance for AWS Snowball](performance.md) for recommendations and guidance on improving transfer performance\. The following can help you troubleshoot issues that you might have with your data transfer to or from a Snowball\.
+ You can't transfer data into the root directory of the Snowball Edge\. If you have trouble transferring data into the Snowball, make sure that you're transferring data into a subdirectory on the Snowball that is not the root folder\. The top\-level subdirectories have the names of the Amazon S3 buckets that you included in the job\. Put your data in those subdirectories\.
+ For security purposes, data transfers must be completed within 90 days of the Snowball being prepared\. After 90 days, the Snowball becomes locked to additional on\-premises data transfers\. If the Snowball becomes locked during a data transfer, return the Snowball and create a new job to transfer the rest of your data\. If the Snowball becomes locked during an import job, we can still transfer the existing data on the Snowball into Amazon S3\.
+ Objects transferred onto Snowballs have a maximum key length of 933 bytes\. Key names that include characters that take up more than one byte each still have a maximum key length of 933 bytes\. When determining key length, you include the file or object name and also its path or prefixes\. Thus, files with short file names within a heavily nested path can have keys longer than 933 bytes\. The bucket name is not factored into the path when determining the key length\. Some examples follow\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/troubleshooting.html)

  If a key's length is larger than 933 bytes, you see the following error message when you try to copy the object to a Snowball:

  ```
  Failed to copy the following file: <Name of object with a keylength over 933 bytes>
            PARENT_NOT_FOUND:
  ```

  If you receive this error message, you can resolve the issue by reducing the object's key length\.
+ If you're using Linux and you can't upload files with UTF\-8 characters to a Snowball, it might be because your Linux workstation doesn't recognize UTF\-8 character encoding\. You can correct this issue by installing the `locales` package on your Linux workstation and configuring it to use one of the UTF\-8 locales like `en_US.UTF-8`\. You can configure the `locales` package by exporting the environment variable `LC_ALL`, for example: `export LC_ALL=en_US.UTF-8`
+ If you encounter unexpected errors during data transfer to the Snowball, we want to hear about it\. Make a copy of your logs and include them along with a brief description of the issues that you encountered in a message to AWS Support\. For more information about logs, see [Snowball Logs](copy-command-reference.md#snowballlogs)\.

## Troubleshooting AWS CLI Problems<a name="cli-troubleshooting"></a>

Use the following topics to help you resolve problems when working with a Snowball and the AWS CLI\. 

### AWS CLI Error Message: "Profile Cannot Be Null"<a name="null-profile-troubleshooting"></a>

When working with the AWS CLI, you might encounter an error message that says `"Profile cannot be null"`\. You can encounter this error if the AWS CLI hasn't been installed or an AWS CLI profile hasn't been configured\.

**Action to take**  
Ensure that you have downloaded and configured the AWS CLI on your workstation\. For more information, see [Install the AWS CLI Using the Bundled Installer \(Linux, macOS, or Unix\)](https://docs.aws.amazon.com/cli/latest/userguide/awscli-install-bundle.html) in the *AWS Command Line Interface User Guide\.*

### Null Pointer Error When Transferring Data with the AWS CLI<a name="null-pointer-troubleshooting"></a>

When using the AWS CLI to transfer data, you might encounter a null pointer error\. This error can occur in the following conditions:
+ If the specified file name is misspelled, for example `flowwer.png` or `flower.npg` instead of `flower.png`
+ If the specified path is incorrect, for example `C:\Doccuments\flower.png` instead of `C:\Documents\flower.png`
+ If the file has been corrupted

**Action to take**  
Confirm that your file name and path are correct, and try again\. If you continue to experience this issue, confirm that the file has not been corrupted, abandon the transfer, or attempt repairs to the file\.

## Troubleshooting Client Problems<a name="client-troubleshooting"></a>

The following can help you troubleshoot issues with the Snowball client\.
+ If you're having trouble using the Snowball client, type the command `snowball help` for a list of all available actions for that tool\.
+ Although you can run multiple instances of the Snowball client at the same time, each instance of the client requires up to 7 GB of dedicated RAM for memory\-intensive tasks, such as performing the `snowball cp` command\. If your workstation runs out of memory as it runs the Snowball client, you see a Java `OutOfMemoryError` exception returned in the terminal window\. You can resolve this issue by freeing up resources on the workstation or increasing the amount of memory for your workstation, and then performing your Snowball client task again\.
+ If you encounter issues while transferring data to a Snowball using the client on a PC running Microsoft Windows Server, it might be due to the Data Deduplication feature in Windows\. If you have the Data Deduplication feature turned on, we recommend that you use the Amazon S3 Adapter for Snowball with the AWS CLI to transfer data instead\. For more information, see [Transferring Data with the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md)\.

### Troubleshooting Snowball Client Validation Problems<a name="client-validation"></a>

When you transfer data, the copy operation first performs a precheck on the metadata for each file to copy\. If any of the following attributes are true about a file's metadata, then the copy operation stops before it transfers any files:
+ **The size of the file is greater than 5 TB** – Objects in Amazon S3 must be 5 TB or less in size, so files that are larger 5 TB in size can't be transferred to the Snowball\. If you encounter this problem, separate the file into parts smaller than 5 TB, compress the file so that it's within the 5 TB limit, or otherwise reduce the size of the file, and try again\.
+ **The file is a symbolic link, and only contains a reference to another file or directory** – Symbolic links \(or junctions\) can't be transferred into Amazon S3\.
+ **There are permissions issues for access to the file** – For example, a user might be trying to read a file on the Snowball client when that user doesn't have read permissions for that file\. Permissions issues result in precheck failures\.
+ **Object key length too large** –If an object's key length is larger than 933 bytes, it fails the precheck\.

For a list of files that can't be transferred, check the terminal before data copying starts\. You can also find this list in the `<temp directory>/snowball-<random-character-string>/failed-files` file, which is saved to your Snowball client folder on the workstation\. For Windows, this temp directory would be located in `C:/Users/<username>/AppData/Local/Temp`\. For Linux and Mac, the temp directory would be located in `/tmp`\.

If you discover errors when you run the `snowball validate` command, identify the files that failed the transfer, resolve the issues that the error messages report, and then transfer those files again\. If your validation command fails with the same error message, then you can use the `–f` option with the `snowball cp` command to force the copy operation and overwrite the invalid files\.

### Java Heap Error with the Snowball Client<a name="snowball-java-heap-size-error"></a>

A Java heap error can occur with the Snowball client in a couple of situations: 
+ If the physical workstation you're using to transfer data doesn't meet the minimum hardware specifications
+ If there are issues with Java\-based resources\.

**Actions to take**  
Ensure that your workstation meets the recommended hardware specifications\. For more information, see [Workstation Specifications](specifications.md#workstationspecs)\. VMs are not supported for use as workstations\.

Because the Snowball client is a Java application, you have other options if your workstation meets the minimum hardware requirements and you encounter this issue\. These are described following\.

**Important**  
These are advanced troubleshooting steps\. If you're unsure how to proceed, contact AWS Support\.
+ You can increase the number of worker threads associated with the command with the `-w` option, based on the amount of dedicated physical memory you have available for the application, as in the following example\.

  ```
  snowball -w 20 cp [source] [destination] —-recursive 
  ```
+ You can update the Java heap size by editing the Snowball client batch file itself\. We recommend that you only take this action if you know the amount of dedicated physical memory that you have available for this application, and the exact amount of memory that you can increase this by\.

**To edit the Snowball client batch file**

  1. Open a terminal window and stop the Snowball client

  1. Navigate to the `snowball.bat` file\. On Windows, by default, this file is saved to the following path: `C:\Program Files (x86)\SnowballClient\bin`\.

  1. Open the `snowball.bat` file, and increase the `-Xmx7G` value from 7 to a higher number, based on the amount of dedicated physical memory you have available for the application\.

  1. Save the file and restart the Snowball client

## Troubleshooting Adapter Problems<a name="adapter-troubleshooting"></a>

Use the following topics to resolve issues that you encounter with the Amazon S3 Adapter for Snowball\.

### Unable to Connect the Adapter to Your Snowball<a name="troubleshoot-adapter-unlock"></a>

In some cases, you might be unable to connect the adapter to your Snowball\. In this case, keep in mind these points:
+ The terminal session that you ran the unlock command on must remain open for the connection to be established\. To initiate connection commands, open a secondary terminal window\. 
+ The adapter endpoint uses the IP address of the workstation where the adapter is installed, and not the IP address of the Snowball\.

### Unable to Locate Credentials for the Adapter<a name="troubleshoot-adapter-credentials"></a>

If you're communicating with the Snowball through the Amazon S3 Adapter for Snowball using the AWS CLI, you might encounter an error message that says `Unable to locate credentials. You can configure credentials by running "aws configure".`

**Action to take**  
Configure the AWS credentials that the AWS CLI uses to run commands for you\. For more information, see [Configuring the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.

## Troubleshooting Import Job Problems<a name="import-troubleshooting"></a>

Sometimes files fail to import into Amazon S3\. If the following issue occurs, try the actions specified to resolve your issue\. If a file fails import, you might need to try importing it again\. Importing it again might require a new job for Snowball\.

**Files failed import into Amazon S3 due to invalid characters in object names**  
This problem occurs if a file or folder name has characters that aren't supported by Amazon S3\. Amazon S3 has rules about what characters can be in object names\. For more information, see [Object Key Naming Guidelines](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-key-guidelines)\.

**Action to take**  
If you encounter this issue, you see the list of files and folders that failed import in your job completion report\.

In some cases, the list is prohibitively large, or the files in the list are too large to transfer over the internet\. In these cases, you should create a new Snowball import job, change the file and folder names to comply with Amazon S3 rules, and transfer the files again\.

If the files are small and there isn't a large number of them, you can copy them to Amazon S3 through the AWS CLI or the AWS Management Console\. For more information, see [How Do I Upload Files and Folders to an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html) in the *Amazon Simple Storage Service Console User Guide\.*

## Troubleshooting Export Job Problems<a name="export-troubleshooting"></a>

Sometimes files fail to export into your workstation\. If the following issue occurs, try the actions specified to resolve your issue\. If a file fails export, you might need to try exporting it again\. Exporting it again might require a new job for Snowball\.

**Files failed export to a Microsoft Windows Server**  
A file can fail export to a Microsoft Windows Server if it or a related folder is named in a format not supported by Windows\. For example, if your file or folder name has a colon \(`:`\) in it, the export fails because Windows doesn't allow that character in file or folder names\.

**Action to take**

1. Make a list of the names that are causing the error\. You can find the names of the files and folders that failed export in your logs\. For more information, see [Getting Your Job Completion Report and Logs in the Console](report.md)\.

1. Change the names of the objects in Amazon S3 that are causing the issue to remove or replace the unsupported characters\.

1. If the list of names is prohibitively large, or if the files in the list are too large to transfer over the internet, create a new export job specifically for those objects\.

   If the files are small and there isn't a large number of them, copy the renamed objects from Amazon S3 through the AWS CLI or the AWS Management Console\. For more information, see [How Do I Download an Object from an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/download-objects.html) in the* Amazon Simple Storage Service Console User Guide\.*