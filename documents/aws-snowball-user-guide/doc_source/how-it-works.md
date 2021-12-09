--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# How AWS Snowball Works with the Standard Snowball device<a name="how-it-works"></a>

Following, you can find information on how AWS Snowball works, including concepts and its end\-to\-end implementation\.

**Topics**
+ [How It Works: Concepts](#how-it-works-conceptual)
+ [How It Works: Implementation](#how-it-works-implementation)

## How It Works: Concepts<a name="how-it-works-conceptual"></a>

### How Import Works<a name="how-import"></a>

![\[A diagram showing how import works.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/import-job-diagram.png)

Each import job uses a single Snowball appliance\. After you create a job in the AWS Snowball Management Console or the job management API, we ship you a Snowball\. When it arrives in a few days, you’ll connect the Snowball to your network and transfer the data that you want imported into Amazon S3 onto that Snowball using the Snowball client or the Amazon S3 Adapter for Snowball\. 

When you’re done transferring data, ship the Snowball back to AWS, and we’ll import your data into Amazon S3\.

### How Export Works<a name="how-export"></a>

![\[A diagram showing how export works.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/export-job-diagram.png)

Each export job can use any number of Snowball appliances\. After you create a job in the AWS Snowball Management Console or the job management API, a listing operation starts in Amazon S3\. This listing operation splits your job into parts\. Each job part can be up to about 80 TB in size, and each job part has exactly one Snowball associated with it\. After your job parts are created, your first job part enters the **Preparing Snowball** status\.

Soon after that, we start exporting your data onto a Snowball\. Typically, exporting data takes one business day\. However, this process can take longer\. Once the export is done, AWS gets the Snowball ready for pickup by your region's carrier\. When the Snowball arrives at your data center or office in a few days, you’ll connect the Snowball to your network and transfer the data that you want exported to your servers by using the Snowball client or the Amazon S3 Adapter for Snowball\.

When you’re done transferring data, ship the Snowball back to AWS\. Once we receive a returned Snowball for your export job part, we perform a complete erasure of the Snowball\. This erasure follows the National Institute of Standards and Technology \(NIST\) 800\-88 standards\. This step marks the completion of that particular job part\. If there are more job parts, the next job part now is prepared for shipping\.

**Note**  
The listing operation is a function of Amazon S3\. You are billed for it as you are for any Amazon S3 operation, even if you cancel your export job\.

## How It Works: Implementation<a name="how-it-works-implementation"></a>

The following are overviews of how the Snowball is implemented for importing and exporting data\. Both overviews assume that you'll use the AWS Snowball Management Console to create your job and the Snowball client to locally transfer your data\. If you'd rather work programmatically, to create jobs you can use the job management API for Snowball\. For more information, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\. To transfer your data programmatically, you can use the Amazon S3 Adapter for Snowball\. For more information, see [Transferring Data with the Amazon S3 API Adapter for Snowball](snowball-transfer-adapter.md)\.

### End\-to\-End Import Implementation<a name="import-implementation"></a>

1. **Create an import job** – Sign in to the AWS Snowball Management Console and create a job\. The status of your job is now **Job created**, and we have queued your job request for processing\. If there’s a problem with your request, you can cancel your job at this point\.

1. **A Snowball is prepared for your job** – We prepare a Snowball for your job, and the status of your job is now **Preparing Snowball**\. For security purposes, data transfers must be completed within 90 days of the Snowball being prepared\.

1. **A Snowball is shipped to you by your region's carrier** – The carrier takes over from here, and the status of your job is now **In transit to you**\. You can find your tracking number and a link to the tracking website on the AWS Snowball Management Console\. For information on who your region's carrier is, see [Shipping Carriers](mailing-storage.md#carriers)\.

1. **Receive the Snowball** – A few days later, your region's carrier delivers the Snowball to the address that you provided when you created the job, and the status of your job changes to **Delivered to you**\. When the Snowball arrives, you’ll notice that it didn’t arrive in a box, because the Snowball is its own shipping container\.

1. **Get your credentials and download the Snowball client** – Get ready to start transferring data by getting your credentials, your job manifest, and the manifest's unlock code, and then downloading the Snowball client\.
   + The Snowball client is the tool that you’ll use to manage the flow of data from your on\-premises data source to the Snowball\.

     The Snowball client must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.
   + The manifest is used to authenticate your access to the Snowball, and it is encrypted so that only the unlock code can decrypt it\. You can get the manifest from the AWS Snowball Management Console when the Snowball is on\-premises at your location\.
   + The unlock code is a 29\-character code that also appears when you get your manifest\. We recommend that you write it down and keep it separate from the manifest to prevent unauthorized access to the Snowball while it’s at your facility\. The unlock code is visible when you get your manifest\.

1. **Install and set up the Snowball client** – Install the Snowball client on the computer workstation that has your data source mounted on it\. 

1. **Position the hardware** – Move the Snowball into your data center and open it following the instructions on the case\. Connect the Snowball to power and your local network\.

1. **Power on the Snowball** – Next, power on the Snowball by pressing the power button above the E Ink display\. Wait a few minutes, and the **Ready** screen appears\.

1. **Start the Snowball client** – When you start the Snowball client on your workstation, type the IP address of the Snowball, the path to your manifest, and the unlock code\. The Snowball client decrypts the manifest and uses it to authenticate your access to the Snowball\.

1. **Transfer data** – Use the Snowball client to transfer the data that you want to import into Amazon S3 from your data source into the Snowball\.

1. **Prepare the Snowball for its return trip** – After your data transfer is complete, power off the Snowball and unplug its cables\. Secure the Snowball’s cables into the cable caddie on the inside of the Snowball’s back panel and seal the Snowball\. Now the Snowball is ready to be returned\.

1. **Your region's carrier returns the Snowball to AWS** – While the carrier has the Snowball for shipping, the status for the job becomes **In transit to AWS**\.

1. **AWS gets the Snowball** – The Snowball arrives at AWS, and the status for your job becomes **At AWS**\. On average, it takes about a day for AWS to begin importing your data into Amazon S3\.

1. **AWS imports your data into Amazon S3** – When import starts, your job’s status changes to **Importing**\. The import can take a few days\. At this point, if there are any complications or issues, we contact you through email\.

   Once the import is complete, your job status becomes **Completed**, and a PDF file of your job completion report becomes available for download from the AWS Snowball Management Console\.

1. **Your imported data now resides in Amazon S3** – With the import complete, the data that you transferred is now in Amazon S3\.

Now that you know how an import job works, you're ready to create your first job\. For more information, see [Importing Data into Amazon S3 with AWS Snowball](create-import-job-steps.md)\.

For more information about the job management API for Snowball, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\.

### End\-to\-End Export Implementation<a name="export-implementation"></a>

1. **Create an export job** – Sign in to the AWS Snowball Management Console and create a job\. This process begins a listing operation in Amazon S3 to determine the amount of data to be transferred, and also any optional ranges for objects within your buckets that your job will transfer\. Once the listing is complete, the AWS Snowball Management Console creates all the job parts that you'll need for your export job\. At this point, you can cancel your job if you need to\.
**Note**  
The listing operation is a function of Amazon S3\. You are billed for it as you are for any Amazon S3 operation, even if you cancel your export job\.

1. **A Snowball is prepared for your job part** – Soon after your job parts are created, your first job part enters the **Preparing Snowball** status\. For security purposes, data transfers must be completed within 90 days of the Snowball being prepared\. When the Snowball is prepared, the status changes to **Exporting**\. Typically, exporting takes one business day; however, this process can take longer\. Once the export is done, the job status becomes **Preparing shipment**, and AWS gets the Snowball ready for pickup\.

1. **A Snowball is shipped to you by your region's carrier** – The carrier takes over from here, and the status of your job is now **In transit to you**\. You can find your tracking number and a link to the tracking website on the AWS Snowball Management Console\. For information on who your region's carrier is, see [Shipping Carriers](mailing-storage.md#carriers)\.

1. **Receive the Snowball** – A few days later, the carrier delivers the Snowball to the address you provided when you created the job, and the status of your first job part changes to **Delivered to you**\. When the Snowball arrives, you’ll notice that it didn’t arrive in a box, because the Snowball is its own shipping container\.

1. **Get your credentials and download the Snowball client** – Get ready to start transferring data by getting your credentials, your job manifest, and the manifest's unlock code, and then downloading the Snowball client\.
   + The Snowball client is the tool that you’ll use to manage the flow of data from the Snowball to your on\-premises data destination\.

     The Snowball client must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.
   + The manifest is used to authenticate your access to the Snowball, and it is encrypted so that only the unlock code can decrypt it\. You can get the manifest from the AWS Snowball Management Console when the Snowball is on\-premises at your location\.
   + The unlock code is a 29\-character code that also appears when you get your manifest\. We recommend that you write it down and keep it separate from the manifest to prevent unauthorized access to the Snowball while it’s at your facility\. The unlock code is visible when you get your manifest\.

1. **Install and set up the Snowball client** – Install the Snowball client on the computer workstation that has your data source mounted on it\. 

1. **Position the hardware** – Move the Snowball into your data center and open it following the instructions on the case\. Connect the Snowball to power and your local network\.

1. **Power on the Snowball** – Next, power on the Snowball by pressing the power button above the E Ink display\. Wait a few minutes, and the **Ready** screen appears\.

1. **Start the Snowball client** – When you start the Snowball client on your workstation, type the IP address of the Snowball, the path to your manifest, and the unlock code\. The Snowball client decrypts the manifest and uses it to authenticate your access to the Snowball\.

1. **Transfer data** – Use the Snowball client to transfer the data that you want to export from the Snowball appliance into your on\-premises data destination\.

1. **Prepare the Snowball for its return trip** – After your data transfer is complete, power off the Snowball and unplug its cables\. Secure the Snowball’s cables into the cable caddie on the inside of the Snowball’s back panel and seal the Snowball\. The Snowball is now ready to be returned\.

1. **Your region's carrier returns the Snowball to AWS** – When the carrier has the Snowball, the status for the job becomes **In transit to AWS**\. At this point, if your export job has more job parts, the next job part enters the **Preparing Snowball** status\.

1. **We erase the Snowball** – Once we receive a returned Snowball we perform a complete erasure of the Snowball\. This erasure follows the NIST 800\-88 standards\.

Now that you know how an export job works, you're ready to create your first job\. For more information, see [Exporting Data from Amazon S3 with Snowball](create-export-job-steps.md)\.