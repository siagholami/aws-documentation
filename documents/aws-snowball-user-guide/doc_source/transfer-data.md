--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Transfer Data<a name="transfer-data"></a>

The following section discuss the steps involved in transferring data\. These steps involve getting your credentials, downloading and installing the Snowball client tool, and then transferring data from your data source into the Snowball using the Snowball client\.

**Note**  
You can also transfer data programmatically with the Amazon S3 Adapter for Snowball\. For more information, see [Transferring Data with the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md)\.

**Topics**
+ [Get Your Credentials](#unlockdevice)
+ [Install the AWS Snowball Client](#download-the-client)
+ [Use the AWS Snowball Client](#transferthroughclient)
+ [Stop the AWS Snowball Client, and Power Off the Snowball](#turnitoff)
+ [Disconnect the device](#disconnectdevice)

## Get Your Credentials<a name="unlockdevice"></a>

Each AWS Snowball job has a set of credentials that you must get from the AWS Snowball Management Console or the job management API to authenticate your access to the Snowball\. These credentials are an encrypted manifest file and an unlock code\. The manifest file contains important information about the job and permissions associated with it\. Without it, you won't be able to transfer data\. The unlock code is used to decrypt the manifest\. Without it, you won't be able to communicate with the Snowball\.

**Note**  
You can only get your credentials after the Snowball device has been delivered to you\. After the device has been returned to AWS, the credentials for your job are no longer available\.

**To get your credentials by using the console**

1. Sign in to the AWS Management Console and open the AWS Snowball Management Console at [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. In the AWS Snowball Management Console, search the table for the specific job to download the job manifest for, and then choose that job\.

1. Expand that job's **Job status** pane, and select **View job details**

1. In the details pane that appears, expand **Credentials**\. Make a note of the unlock code \(including the hyphens\), because you'll need to provide all 29 characters to transfer data\. Choose **Download manifest** in the dialog box and follow the instructions to download the job manifest file to your computer\. The name of your manifest file includes your **Job ID**\.
**Note**  
As a best practice, we recommend that you don't save a copy of the unlock code in the same location in the workstation as the manifest for that job\. For more information, see [Best Practices for AWS Snowball](BestPractices.md)\.

Now that you have your credentials, you're ready to transfer data\.

## Install the AWS Snowball Client<a name="download-the-client"></a>

The Snowball client is one of the tools that you can use transfer from your on\-premises data source to the Snowball\.

The Snowball client must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.

## Use the AWS Snowball Client<a name="transferthroughclient"></a>

In this step, you'll run the Snowball client from the workstation first to authenticate your access to the Snowball for this job, and then to transfer data\. 

To authenticate your access to the Snowball, open a terminal or command prompt window on your workstation and type the following command:

 `snowball start -i [Snowball IP Address] -m [Path/to/manifest/file] -u [29 character unlock code]`

Following is an example of the command to configure the Snowball client\.

```
snowball start -i 192.0.2.0 -m /Downloads/JID2EXAMPLE-0c40-49a7-9f53-916aEXAMPLE81-manifest.bin  -u 12345-abcde-12345-ABCDE-12345
```

In this example, the IP address for the Snowball is 192\.0\.2\.0, the job manifest file that you downloaded is `JID2EXAMPLE-0c40-49a7-9f53-916aEXAMPLE81-manifest.bin`, and the 29 character unlock code is `12345-abcde-12345-ABCDE-12345`\.

When you've entered the preceding command with the right variables for your job, you get a confirmation message\. This message means that you're authorized to access the Snowball for this job\.

Now you can begin transferring data onto the Snowball\. Similarly to how Linux allows you to copy files and folders with the copy \(or `cp`\) command, the Snowball client also uses a `cp` command\. As in Linux, when you use the copy command you'll provide the values of two paths in your command\. One path represents the source location of the data to be copied, and the second path represents the destination where the data will be pasted\. When you're transferring data, destination paths to the Snowball must start with the `s3://` root directory identifier\.

During data transfer, you'll notice that there is at least one folder at the root level of the Snowball\. This folder and any others at this level have the same names as the destination buckets that were chosen when this job was created\. Data cannot be transferred directly into the root directory; it must instead go into one of the bucket folders or into their subfolders\.

To transfer data using the Snowball client, open a terminal or command prompt window on your workstation and type the following command:

`snowball cp [options] [path/to/data/source] s3://[path/to/data/destination]`

Following is an example of the command to copy data using the client to the Snowball\.

```
snowball cp --recursive /Logs/April s3://MyBucket/Logs
```

For more information on using the Snowball client tool, see [Using the Snowball Client](using-client.md)\. Use the Snowball client commands to finish transferring your data into the Snowball\. When you finish, it's time to prepare the Snowball for its return trip\.

## Stop the AWS Snowball Client, and Power Off the Snowball<a name="turnitoff"></a>

When you've finished transferring data on to the Snowball, prepare it for its return trip to AWS\. To prepare it, run the `snowball stop` command in the terminal of your workstation\. Running this command stops all communication to the Snowball from your workstation and performs local cleanup operations in the background\. When that command has finished, power off the Snowball by pressing the power button above the E Ink display\.

## Disconnect the device<a name="disconnectdevice"></a>

Disconnect the Snowball cables\. Secure the Snowball's cables into the cable caddie on the inside of the Snowball back panel and seal the Snowball\. When the return shipping label appears on the Snowball's E Ink display, you're ready to drop it off with your region's carrier to be shipped back to AWS\. To see who your region's carrier is, see [Shipping Carriers](mailing-storage.md#carriers)\.

**Important**  
Don't delete your local copies of the transferred data until the import into Amazon S3 is successful at the end of the process and you can verify the results of the data transfer\.

**Next:**

[Return the device](return-device.md) 