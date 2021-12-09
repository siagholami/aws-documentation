# Making SAP HANA software available for AWS Launch Wizard to deploy HANA database<a name="launch-wizard-sap-structure"></a>

**Topics**
+ [Download SAP HANA software](#launch-wizard-sap-install)
+ [Upload SAP HANA software to Amazon S3](#launch-wizard-sap-s3)

## Download SAP HANA software<a name="launch-wizard-sap-install"></a>

To download the SAP HANA software, go to the **SAP Software Downloads** page and download the installation files directly to your local drive\.

1. Navigate to the [http://support.sap.com/swdc](http://support.sap.com/swdc) page and log in to your account\.

1. Under **Installation and Upgrades**, choose **Access Downloads**>**A\-Z index**\.

1. Choose **H** in the **Installations and Upgrades** window, and select **SAP HANA Platform Edition** from the list\.

1. Choose **SAP HANA Platform Edition**>**Installation**\.

1. In the **Downloads** window, find the revision you want to download and download each file to your local drive\. 
**Note**  
If you do not have access to the software and believe you should, contact the [SAP Global Support Customer Interaction Center](http://support.sap.com/contactus)\. 
**Important**  
Do not extract the downloaded HANA software\. Instead, stage the files in your Amazon S3 bucket as is\. Launch Wizard will extract the media and install the software for you\.

## Upload SAP HANA software to Amazon S3<a name="launch-wizard-sap-s3"></a>

To upload the SAP HANA software to your Amazon S3 bucket, you must create and set up your destination bucket\.

**Set up destination bucket**

1. Navigate to the Amazon S3 console at [https://console\.aws\.amazon\.com/s3](https://console.aws.amazon.com/s3)\.

1. Choose **Create Bucket**\.

1. In the **Create Bucket** dialog box, provide a name for your new S3 bucket with the prefix `launchwizard`\. Choose the **AWS Region** where you want to create the S3 bucket, which should be a Region that is close to your location, and then choose **Create Bucket**\. For detailed information about bucket names and Region selection, see [Create a Bucket ](https://docs.aws.amazon.com/AmazonS3/latest/gsg/CreatingABucket.html)in the **Amazon S3 Getting Started Guide**\.

1. Choose the bucket that you created and, from the **Overview** tab, **Create folder**s to organize your SAP HANA downloads\. We recommend that you create a folder for each version of SAP HANA\.

1. To add the unextracted SAP HANA files to the appropriate folder, choose **Upload** from the **Overview** tab\. 

 If the path for the specific version of SAP HANA software is `s3://launchwizardhanamedia/SP23` or `s3://launchwizardhanamedia/SP24`, then use this path in the Amazon S3 URL for SAP HANA software \(HANAInstallMedia\) parameter\. 

**Note**  
We recommend that you place only the main SAP HANA installation files in the S3 bucket\. Do not place multiple SAP HANA versions in the same folder\. SAP provides the software as a single \.zip file or as multiple files depending on the SAP HANA version \(one \.exe file and multiple \.rar files\)\. Upload them to the version\-specific folder that you created\. 