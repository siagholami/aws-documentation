# SCTE\-35 Message Options in AWS Elemental MediaPackage<a name="scte"></a>

This section describes the options that AWS Elemental MediaPackage offers for configuring how SCTE\-35 messages are handled in live DASH, HLS, and CMAF outputs\. For live\-to\-VOD assets, MediaPackage passes the SCTE\-35 messages from the live stream through to the harvested asset\. These options don't apply to Microsoft Smooth Streaming or video on demand \(VOD\) outputs\. 

SCTE\-35 messages accompany video in your source content\. These messages signal where MediaPackage should insert ad markers when it packages the content for output\. By default, MediaPackage inserts markers for the following message types in the source content:
+ `splice_insert`
+ `time_signal` with the following segmentation types:
  + Provider advertisement
  + Distributor advertisement
  + Provider placement opportunity
  + Distributor placement opportunity

  The `time_signal` must also include delivery restriction flags in the `segmentation_descriptor`\.

When these commands are present, MediaPackage inserts corresponding ad markers in the output manifests:
+ For HLS and CMAF outputs, MediaPackage inserts `EXT-X-CUE-OUT` and `EXT-X-CUE-IN` tags\.
+ For DASH outputs, MediaPackage inserts `EventStream` tags to create multiple periods, when you have multi\-period manifests enabled\. 

The following sections describe how you can modify MediaPackage SCTE\-35 message handling behavior\.

## SCTE\-35 Settings in MediaPackage<a name="scte-settings"></a>

You can modify how MediaPackage interacts with SCTE\-35 messages from your source content\. Configure the following settings on your endpoints\. For more information, see the following:
+ For the MediaPackage console, see [Creating an Endpoint](endpoints-create.md)\.
+ For the MediaPackage REST API, see [Origin\_endpoints](https://docs.aws.amazon.com/mediapackage/latest/apireference/origin_endpoints.html) in the *AWS Elemental MediaPackage API Reference*\.

**Important**  
To modify how MediaPackage handles SCTE\-35 messages, you should be familiar with the SCTE\-35 standard\. You can download a PDF of the most recent standards here: [Download SCTE ISBE Standards](https://www.scte.org/SCTE/Standards/Download/SCTE/Standards/Download_SCTE_Standards.aspx?hkey=63914a25-0f85-4d74-8181-c1b642039ad7)\. You should also be familiar with how SCTE\-35 is implemented in your source content\. 

****Ad markers****  
This setting is available on HLS and CMAF endpoints\.   
**Ad markers** allows you to specify what MediaPackage does when it detects SCTE\-35 messages\. These are the options:  
+ **None** – MediaPackage ignores the SCTE\-35 messages and doesn't include ad markers in the output manifest\.
+ **SCTE\-35 enhanced** – MediaPackage includes ad markers and blackout tags in the output manifest for SCTE\-35 messages that meet the requirements in **Customize ad triggers** and **Ads on delivery restrictions**\.
+ **Passthrough** – MediaPackage copies all SCTE\-35 messages from the source content and inserts them in the output manifest\.

****Customize ad triggers****  
This setting is available on HLS, CMAF, and DASH endpoints\.  
**Customize ad triggers** identifies which SCTE\-35 message types MediaPackage treats as ads in the output manifest\.   
If you don't change this setting, MediaPackage treats these message types as ads:  
+ Splice insert
+ Provider advertisement
+ Distributor advertisement
+ Provider placement opportunity
+ Distributor placement opportunity

****Ads on delivery restrictions****  
This setting is available on HLS, CMAF, and DASH endpoints\.  
**Ads on delivery restrictions** sets conditions for what SCTE\-35 messages become ads, based on the delivery restriction flags in the `segmentation_descriptor` of the messages\. MediaPackage inserts an ad marker that corresponds to the positioning of the messages of the right type that meet the delivery restriction conditions\.   
If you don't change this setting, MediaPackage converts messages that are classified as *restricted* \(they have delivery restriction flags\) to ad markers in the output manifest\.  
Splice insert SCTE\-35 messages don't have `segmentation_descriptor`\. If you choose splice insert in **Customize ad triggers**, all splice inserts become ad markers in the output manifest\.

## How It Works<a name="scte-works"></a>

The **Ad markers**, **Customize ad triggers**, and **Ads on delivery restrictions** settings work together to determine what MediaPackage does with SCTE\-35 messages from the source content\.

When there are SCTE\-35 messages in the source content, MediaPackage takes the following action based on the value that you selected in **Ad markers**:
+ For **None**, MediaPackage does nothing with the SCTE\-35 messages\. No ad markers are inserted in the output manifest\.
+ For **Passthrough**, MediaPackage copies all SCTE\-35 messages from the source content and inserts them in the output manifest\.
+ For **SCTE\-35 enhanced**, MediaPackage checks for messages that meet the requirements that you set\. In the output manifest, MediaPackage inserts ad markers that correspond to the applicable messages\. To check for your requirements, MediaPackage does the following:

  1. Checks if any SCTE\-35 messages match the message types that you indicated in **Customize ad triggers**

  1. For messages of the right types, checks if the delivery restriction flags in `segmentation_descriptor` meet the conditions that you set in **Ads on delivery restrictions**

  1. For messages of the right type that meet the delivery restriction conditions, inserts ad markers in the output manifest, as described earlier in this chapter