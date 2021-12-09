--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Get Your Credentials and Tools<a name="get-credentials"></a>

Each job has a set of credentials that you must get from the AWS Snowball Management Console or the job management API to authenticate your access to the Snowball\. These credentials are an encrypted manifest file and an unlock code\. The manifest file contains important information about the job and permissions associated with it\.

**Note**  
You can only get your credentials after the device has been delivered to you\.

**To get your credentials by using the console**

1. Sign in to the AWS Management Console and open the AWS Snowball Management Console at [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. In the console, search the table for the specific job to download the job manifest for, and then choose that job\.

1. Expand that job's **Job status** pane, and choose **View job details**\.

1. In the details pane that appears, expand **Credentials** and then do the following:
   + Make a note of the unlock code \(including the hyphens\), because you need to provide all 29 characters to transfer data\. 
   + Choose **Download manifest** in the dialog box and follow the instructions to download the job manifest file to your computer\. The name of your manifest file includes your **Job ID**\.
**Note**  
We recommend that you don't save a copy of the unlock code in the same location in the workstation as the manifest for that job\. For more information, see [Best Practices for the AWS Snowball Edge Device](BestPractices.md)\.

Now that you have your credentials, the next step is to download the Snowball client, which is used to unlock the AWS Snowball Edge device\.

**Next:** [Download and Install the Snowball Client](download-the-client.md) 