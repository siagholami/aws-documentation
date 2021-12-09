# Migration Hub Import<a name="discovery-import"></a>

Migration Hub import allows you to import details of your on\-premises environment directly into Migration Hub without using the Discovery Connector or Discovery Agent, so you can perform migration assessment and planning directly from your imported data\. You also can group your devices as applications and track their migration status\.

**To initiate an import request**
+ Download the specially\-formatted, comma separated value \(CSV\) import template\.
+ Populate it with your existing on\-premises server data\.
+ Upload it to Migration Hub using the Migration Hub console, AWS CLI or one of the AWS SDKs\.

You can submit multiple import requests\. Each request is processed sequentially\. You can check the status of your import requests at any time, through the console or import APIs\.

After an import request is complete, you can view the details of individual imported records\. View utilization data, tags, and application mappings directly from within the Migration Hub console\. If errors were encountered during the import, you can review the count of successful and failed records, and you can see the error details for each failed record\.

**Handling errors:** A link is provided to download the error log and failed records files as CSV files in a compressed archive\. Use these files to resubmit your import request after correcting the errors\.

Limits apply to the number of imported records, imported servers, and deleted records you can keep\. For more information, see [AWS Application Discovery Service Limits](ads_service_limits.md)\.

## Supported Import File Fields<a name="import-supported-fields"></a>

Migration Hub import allows you to import data from any source\. The data provided must be in the supported format for a CSV file, and the data must contain only the supported fields with the supported ranges for those fields\.

An asterisk next to an import field name in the following table denotes that it is a required field\. Each record of your import file must have at least one or more of those required fields populated to uniquely identify a server or application\. Otherwise, a record without any of the required fields will fail to be imported\.

**Note**  
If you're using either VMware\.MoRefId or VMWare\.VCenterId, to identify a record, you must have both fields in the same record\.


| Import Field Name | Description | Examples | 
| --- | --- | --- | 
| ExternalId\* | A custom identifier that allows you to mark each record as unique\. For example, ExternalId can be the inventory ID for the server in your data center\. | Inventory Id 1 Server 2 CMBD Id 3  | 
| SMBiosId | System management BIOS \(SMBIOS\) ID\. |  | 
| IPAddress\* | A comma\-delimited list of IP addresses of the server, in quotes\. | 192\.0\.0\.2 "10\.12\.31\.233, 10\.12\.32\.11" | 
| MACAddress\* | A comma\-delimited list of MAC address of the server, in quotes\. | 00:1B:44:11:3A:B7 "00\-15\-E9\-2B\-99\-3C, 00\-14\-22\-01\-23\-45" | 
| HostName\* | The host name of the server\. We recommend using the fully qualified domain name \(FQDN\) for this value\. | ip\-1\-2\-3\-4localhost\.domain | 
| VMware\.MoRefId\* | The managed object reference ID\. Must be provided with a VMware\.VCenterId\. |  | 
| VMware\.VCenterId\* | Virtual machine unique identifier\. Must be provided with a VMware\.MoRefId\. |  | 
| CPU\.NumberOfProcessors | The number of CPUs\. | 4 | 
| CPU\.NumberOfCores | The total number of physical cores\. | 8 | 
| CPU\.NumberOfLogicalCores | The total number of threads that can run concurrently on all CPUs in a server\. Some CPUs support multiple threads to run concurrently on a single CPU core\. In those cases, this number will be larger than the number of physical \(or virtual\) cores\. | 16 | 
| OS\.Name | The name of the operating system\. | LinuxWindows\.Hat | 
| OS\.Version | The version of the operating system\. | 16\.04\.3NT 6\.2\.8 | 
| VMware\.VMName | The name of the virtual machine\. | Corp1 | 
| RAM\.TotalSizeInMB | The total RAM available on the server, in MB\. | 64128 | 
| RAM\.UsedSizeInMB\.Avg | The average amount of used RAM on the server, in MB\. | 64128 | 
| RAM\.UsedSizeInMB\.Max | The maximum amount of used RAM available on the server, in MB\. | 64128 | 
| CPU\.UsagePct\.Avg | The average CPU utilization when the discovery tool was collecting data\. | 4523\.9 | 
| CPU\.UsagePct\.Max | The maximum CPU utilization when the discovery tool was collecting data\. | 55\.3424 | 
| DiskReadsPerSecondInKB\.Avg | The average number of disk reads per second, in KB\. | 115984506 | 
| DiskWritesPerSecondInKB\.Avg | The average number of disk writes per second, in KB\. | 1996197 | 
| DiskReadsPerSecondInKB\.Max | The maximum number of disk reads per second, in KB\. | 37892869962 | 
| DiskWritesPerSecondInKB\.Max | The maximum number of disk writes per second, in KB\. | 184361808 | 
| DiskReadsOpsPerSecond\.Avg | The average number of disk read operations per second\. | 4528 | 
| DiskWritesOpsPerSecond\.Avg | The average number of disk write operations per second\. | 83 | 
| DiskReadsOpsPerSecond\.Max | The maximum number of disk read operations per second\. | 1083176 | 
| DiskWritesOpsPerSecond\.Max | The maximum number of disk write operations per second\. | 53571 | 
| NetworkReadsPerSecondInKB\.Avg | The average number of network read operations per second, in KB\. | 4528 | 
| NetworkWritesPerSecondInKB\.Avg | The average number of network write operations per second, in KB\. | 83 | 
| NetworkReadsPerSecondInKB\.Max | The maximum number of network read operations per second, in KB\. | 1083176 | 
| NetworkWritesPerSecondInKB\.Max | The maximum number of network write operations per second, in KB\. | 53571 | 
| Applications | A comma\-delimited list of applications that include this server, in quotes\. This value can include existing applications and/or new applications that are created upon import\. | Application1"Application2, Application3" | 
| Tags | A comma\-delimited list of tags formatted as name:value\.  Do not store sensitive information \(like personal data\) in tags\.  | "zone:1, critical:yes""zone:3, critical:no, zone:1" | 

You can import data even if you don’t have data populated for all the fields defined in the import template, so long as each record has at least one of the required fields within it\. Duplicates are managed across multiple import requests by using either an external or internal matching key\. If you populate your own matching key, `External ID`, this field is used to uniquely identify and import the records\. If no matching key is specified, import uses an internally generated matching key that is derived from some of the columns in the import template\. For more information on this matching, see [Matching Logic for Discovered Servers and Applications](view-data.md#add-match-logic)\.

**Note**  
Migration Hub import does not support any fields outside of those defined in the import template\. Any custom fields supplied will be ignored and will not be imported\.

## Setting Up Your Import Permissions<a name="import-perms"></a>

Before you can import your data, ensure that your IAM user has the necessary Amazon S3 permissions to upload \(`s3:PutObject`\) your import file to Amazon S3, to read the object \(`s3:GetObject`\)\. You also must establish programmatic access \(for the AWS CLI\) or console access, by creating an IAM policy and attaching it to the IAM user that performs imports in your AWS account\.

------
#### [ Console Permissions ]

Use the following procedure to edit the permissions policy for the IAM user that will make import requests in your AWS account using the console\.

**To edit a user's attached managed policies**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam)\.

1. In the navigation pane, choose **Users**\.

1. Choose the name of the user whose permissions policy you want to change\.

1. Choose the **Permissions** tab and choose **Add permissions**\.

1. Choose **Attach existing policies directly**, and then choose **Create policy**\.

   1. In the **Create policy** page that opens, choose **JSON**, and paste in the following policy\. Remember to replace the name of your bucket with the actual name of the bucket that the IAM user will upload the import files into\.

      ```
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Effect": "Allow",
            "Action": [
              "s3:GetBucketLocation",
              "s3:ListAllMyBuckets"
            ],
            "Resource": "*"
          },
          {
            "Effect": "Allow",
            "Action": ["s3:ListBucket"],
            "Resource": ["arn:aws:s3:::importBucket"]
          },
          {
            "Effect": "Allow",
            "Action": [
              "s3:PutObject",
              "s3:GetObject",
              "s3:DeleteObject"
            ],
            "Resource": ["arn:aws:s3:::importBucket/*"]
          }
        ]
      }
      ```

   1. Choose **Review policy**\.

   1. Give your policy a new **Name** and optional description, before reviewing the summary of the policy\.

   1. Choose **Create policy**\.

1. Return to the **Grant permissions** IAM console page for the user that will make import requests in your AWS account\.

1. Refresh the table of policies, and search for the name of the policy you just created\.

1. Choose **Next: Review**\.

1. Choose **Add permissions**\.

------
#### [ AWS CLI Permissions ]

Use the following procedure to edit the permissions policy for the IAM user that will make import requests in your AWS account using the AWS CLI\.

**To edit a user's attached managed policies**

1. Use the `aws iam create-policy` AWS CLI command to create an IAM policy with the following permissions\. Remember to replace the name of your bucket with the actual name of the bucket that the IAM user will upload the import files into\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": ["s3:ListBucket"],
         "Resource": ["arn:aws:s3:::importBucket"]
       },
       {
         "Effect": "Allow",
         "Action": [
           "s3:PutObject",
           "s3:GetObject",
           "s3:DeleteObject"
         ],
         "Resource": ["arn:aws:s3:::importBucket/*"]
       }
     ]
   }
   ```

   For more information on using this command, see [create\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/create-policy.html) in the *AWS CLI Command Reference*\.

1. Use the `aws iam attach-user-policy` AWS CLI command to attach the policy you created in the last step to the IAM user that will be performing import requests in your AWS account using the AWS CLI\. For more information on using this command, see [attach\-user\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/attach-user-policy.html) in the *AWS CLI Command Reference*\.

------

Now that you've added the policy to your IAM user, you're ready to start the import process\. Remember that when your user uploads object to the Amazon S3 bucket that you specified, that they leave the default permissions for the objects set so that the user can read the object\.

## Uploading Your Import File to Amazon S3<a name="migration-hub-import-s3-upload"></a>

Next, you must upload your CSV formatted import file into Amazon S3 so it can be imported\. Before you begin, you should have an Amazon S3 bucket that will house your import file created and/or chosen ahead of time\.

------
#### [ Console S3 Upload ]

**To upload your import file to Amazon S3**

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. In the **Bucket name** list, choose the name of the bucket that you want to upload your object to\.

1. Choose **Upload**\.

1. In the **Upload** dialog box, choose **Add files** to choose the file to upload\.

1. Choose a file to upload, and then choose **Open\.** 

1. Choose **Upload**\.

1. Once your file has been uploaded, choose the name of your data file object from your bucket dashboard\.

1. From the **Overview** tab of the object details page, copy the **Object URL**\. You'll need this when you create your import request\.

1. Return to the and paste it in the **Data file link on S3** field on the **Start new import** page\.

------
#### [ AWS CLI S3 Upload ]

**To upload your import file to Amazon S3**

1. Open a terminal window, and navigate to the directory that you've saved your import file to\.

1. Type the following command: 

   ```
   aws s3 cp ImportFile.csv s3://BucketName/ImportFile.csv
   ```

1. This will return the following results:

   ```
   upload: .\ImportFile.csv to s3://BucketName/ImportFile.csv
   ```

1. Copy the full Amazon S3 object path that was returned\. You'll need this when you create your import request\.

------

## Importing Data<a name="start-data-import"></a>

After you have downloaded the import template from the Migration Hub console and have populated it with your existing on\-premises server data, you are ready to start importing the data into Migration Hub\. There are two ways to do this: Through the console or by making API calls through the AWS CLI\. Instructions are provided below for both ways\.

------
#### [ Console Import ]

Start data import on the **Tools** page of the Migration Hub console\.

**To start data import**

1. In the navigation pane, under **Discover**, choose **Tools**\.

1. If you don't already have an import template filled out, you can download the template by choosing **import template** in the **Import** box\. Open the downloaded template and populate it with your existing on\-premises server data\. You can also download the import template from our Amazon S3 bucket at [https://s3\.us\-west\-2\.amazonaws\.com/templates\-7cffcf56\-bd96\-4b1c\-b45b\-a5b42f282e46/import\_template\.csv](https://s3.us-west-2.amazonaws.com/templates-7cffcf56-bd96-4b1c-b45b-a5b42f282e46/import_template.csv)

1. Choose the **Import** button in the **Import** box, which will take you to the **Import** page under **Tools**\. 

1. Choose **Start new import**\.

1. In the next screen, specify a name for the import in the **Import name** field\.

1. Fill out the **Data file link on S3** field\. To do this step, you'll need to upload your import data file to Amazon S3\. For more information, see [Uploading Your Import File to Amazon S3](#migration-hub-import-s3-upload)\.

1. Choose **Import** in the lower\-right area\. This will open the **Imports** page where you can see your import and its status listed in the table\.

After following the preceding procedure to start your data import, the **Imports** page will show details of each import request including its progress status, completion time, and the number of successful or failed records with the ability to download those records\. From this screen, you can also navigate to the **Servers** page under **Discover** to see the actual imported data\.

On the **Servers** page, you can see a list of all the servers \(devices\) that are discovered along with the import name\. When you navigate from the **Imports** \(import history\) page by selecting the name of the import listed in the **Name** column , you are taken to the **Servers** page where a filter is applied based on the selected import's data set and only see data belonging to that particular import\.

The archive is in a \.zip format, and contains two files; `errors-file` and `failed-entries-file`\. The errors file contains a list of error messages associated with each failed line and associated column name from your data file that failed the import\. You can use this file to quickly identify where problems occurred\. The failed entries file includes each line and all the provided columns that failed\. You can make the changes called out in the errors file in this file and attempt to import the file again with the corrected information\.

------
#### [ AWS CLI Import ]

To start the data import process from the AWS CLI, the AWS CLI must first be installed in your environment\. For more information, see [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) in the *AWS Command Line Interface User Guide*\.

**Note**  
If you don't already have an import template filled out, you can download the import template from our Amazon S3 bucket here: [https://s3\.us\-west\-2\.amazonaws\.com/templates\-7cffcf56\-bd96\-4b1c\-b45b\-a5b42f282e46/import\_template\.csv](https://s3.us-west-2.amazonaws.com/templates-7cffcf56-bd96-4b1c-b45b-a5b42f282e46/import_template.csv)

**To start data import**

1. Open a terminal window, and type the following command:

   ```
   aws discovery start-import-task --import-url s3://BucketName/ImportFile.csv --name ImportName
   ```

1. This will create your import task, and return the following status information:

   ```
   {
       "task": {
           "status": "IMPORT_IN_PROGRESS",
           "applicationImportSuccess": 0,
           "serverImportFailure": 0,
           "serverImportSuccess": 0,
           "name": "ImportName",
           "importRequestTime": 1547682819.801,
           "applicationImportFailure": 0,
           "clientRequestToken": "EXAMPLE1-abcd-1234-abcd-EXAMPLE1234",
           "importUrl": "s3://BucketName/ImportFile.csv",
           "importTaskId": "import-task-EXAMPLE1229949eabfEXAMPLE03862c0"
       }
   }
   ```

------

## Tracking Your Migration Hub Import Requests<a name="tracking-import-request"></a>

You can track the status of your Migration Hub import requests using the console, AWS CLI, or one of the AWS SDKs\.

------
#### [ Console Tracking ]

From the **Imports** dashboard in the Migration Hub console, you'll find the following elements\.
+ **Name** – The name of the import request\.
+ **Import ID** – The unique ID of the import request\.
+ **Import time** – The date and time that the import request was created\.
+ **Import status** – The status for the import request\. This can be one of the following values:
  + **Importing** – This data file is currently being imported\.
  + **Imported** – The entire data file was successfully imported\.
  + **Imported with errors** – One or more of the records in the data file failed to import\. To resolve your failed records, choose **Download failed records** for your import task and resolve the errors in the failed entries csv file, and do the import again\.
  + **Import Failed** – None of the records in the data file where imported\. To resolve your failed records, choose **Download failed records** for your import task and resolve the errors in the failed entries csv file, and do the import again\.
+ **Imported records** – The number of records in a specific data file that were successfully imported\.
+ **Failed records** – The number records in a specific data file that weren't imported\.

------
#### [ CLI Tracking ]

You can track the status of your import tasks with the `aws discovery describe-import-tasks` AWS CLI command\.

1. Open a terminal window, and type the following command:

   ```
   aws discovery describe-import-tasks
   ```

1. This will return a list of all your import tasks in JSON format, complete with status and other relevant information\. Optionally, you can filter results to return a subset of your import tasks\.

When tracking your import tasks, you may find that the `serverImportFailure` value returned is greater than zero\. When this happens, your import file had one or more entries that couldn't be imported\. This can be resolved by downloading your failed records archive, reviewing the files within, and doing another import request with the modified failed\-entries\.csv file\.

------

After creating your import task, you can perform additional actions to help manage and track your data migration\. For example, you can download an archive of failed records for a specific request\. For information on using the failed records archive to resolve import issues, see [Troubleshooting Failed Import Records](troubleshooting.md#troubleshooting-import-failed-records)\. 