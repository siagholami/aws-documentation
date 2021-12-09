--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Transfer Data<a name="transfer-export"></a>

Following, you can find information about getting your credentials, downloading and installing the Snowball client tool, and then transferring data from the Snowball to your on\-premises data destination using the Snowball client\.

**Topics**
+ [Get Your Credentials](#unlockexport)
+ [Install the AWS Snowball Client](#download-export)
+ [Use the AWS Snowball Client](#exporttransfer)
+ [Disconnect the AWS Snowball device](#disconnectexport)

## Get Your Credentials<a name="unlockexport"></a>

Each AWS Snowball job has a set of credentials that you must get to authenticate your access to the Snowball\. These credentials are an encrypted manifest file and an unlock code\. The manifest file contains important information about the job and permissions associated with it\. Without it, you won't be able to transfer data\. The unlock code is used to decrypt the manifest\. Without it, the you won't be able to communicate with the Snowball\.

**Note**  
You can only get your credentials after the Snowball device has been delivered to you\.

**To get your credentials from the console**

1. Sign in to the AWS Management Console and open the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. In the AWS Snowball Management Console, search the table for the specific job part to download the job manifest for, and then choose that job\.

1. Expand that job part's **Job status** pane, and select **View job details**\.  
![\[View the job's details.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/getcredentials-600w.png)
**Note**  
Each job part has its own unique set of credentials\. You won't be able to unlock a Snowball for one job part with the credentials of a different job part, even if both job parts belong to the same export job\. 

1. In the details pane that appears, expand **Credentials**\. Make a note of the unlock code \(including the hyphens\), because you'll need to provide all 29 characters to run the Snowball client\.

1. Choose **Download manifest** in the dialog box, and then follow the instructions to download the job manifest file to your computer\. The name of your manifest file includes your job part ID\.
**Note**  
As a best practice, we recommend that you don't save a copy of the unlock code in the same location in the workstation as the manifest for that job\. For more information, see [Best Practices for AWS Snowball](BestPractices.md)\.

Now that you have your credentials, you're ready to use the Snowball client to transfer data\.

## Install the AWS Snowball Client<a name="download-export"></a>

The Snowball client is one of the tools that you can use to manage the flow of data from your on\-premises data source to the Snowball\.

The Snowball client must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.

## Use the AWS Snowball Client<a name="exporttransfer"></a>

In this step, you'll run the Snowball client from the workstation first to authenticate your access to the Snowball for this job, and then to transfer data\. 

To authenticate your access to the Snowball, open a terminal or command prompt window on your workstation and type the following command:

 `snowball start -i [Snowball IP Address] -m [Path/to/manifest/file] -u [29 character unlock code]`

Following is an example of the command to configure the Snowball client\.

```
snowball start -i 192.0.2.0 -m /Downloads/JID2EXAMPLE-0c40-49a7-9f53-916aEXAMPLE81-manifest.bin  -u 12345-abcde-12345-ABCDE-12345
```

In this example, the IP address for the Snowball is 192\.0\.2\.0, the job manifest file that you downloaded is `JID2EXAMPLE-0c40-49a7-9f53-916aEXAMPLE81-manifest.bin`, and the 29\-character unlock code is `12345-abcde-12345-ABCDE-12345`\.

When you've entered the preceding command with the right variables for your job part, you get a confirmation message\. This message means that you're authorized to access the Snowball for this job\. If you perform the `snowball ls` command, you'll notice that there is at least one folder at the root level of the Snowball\. This folder and any others at this level have the same names as the source S3 buckets that were chosen when this job was created\.

Now you can begin transferring data from the Snowball\. Similarly to how Linux allows you to copy files and folders with the copy \(or `cp`\) command, the Snowball client also uses a `cp` command\. As in Linux, when you use the copy command you'll provide the values of two paths in your command\. One path represents the source location of the data to be copied, and the second path represents the destination where the data will be pasted\. When you're transferring data, source paths from the Snowball must start with the `s3://` root directory identifier\.

Following is an example of the command to copy data using the client from the Snowball

```
snowball cp --recursive s3://MyBucket/Logs /Logs/April
```

Use the Snowball client commands to finish transferring your data from the Snowball\. For more information on using the Snowball client, see [Using the Snowball Client](using-client.md)\. 

## Disconnect the AWS Snowball device<a name="disconnectexport"></a>

When you've finished transferring data from the Snowball, prepare it for its return trip to AWS\. First, disconnect the Snowball cables\. Secure the Snowball's cables into the cable caddie on the inside of the Snowball back panel, and then seal the Snowball\.

When the return shipping label appears on the Snowball's E Ink display, it's ready to be returned\.

**Next:**

 [Return the device](return-export.md) 