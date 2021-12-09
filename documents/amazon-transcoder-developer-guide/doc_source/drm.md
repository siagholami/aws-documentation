# Digital Rights Management<a name="drm"></a>

You can use Digital Rights Management \(DRM\) to restrict access to your playlist so that only authenticated users can view your content\.

DRM works by restricting playback of a file to users who have authenticated with a third\-party DRM license server\. DRM accomplishes this by including, or packaging, a DRM header in the segments of the file\. The DRM packaging includes the information required to contact the license server and any encryption information needed to play a file\. Once the file has been packaged, it is sent to the content distribution network, which can be a service such as Amazon S3 and CloudFront, or a non\-AWS service such as Akamai\. After the file has been distributed, the license server needs to be contacted for a license before the file plays\. DRM goes beyond standard encryption by specifying an entire set of protocols for content protection\.The following figure shows the basic flow of how DRM works\.

![\[Figure of DRM flow.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

Elastic Transcoder handles the DRM packaging \(the last three steps of this process\) for you:

1. The content provider \(you\) calls the DRM license provider with a content key ID to generate a content key\.

1. The license provider uses the key ID to generate a content key and returns it and a license acquisition URL to the content provider\.

1. The content provider calls AWS KMS to encrypt the content key, and AWS KMS returns the encrypted content key\.

1. The content provider calls the package server \(Elastic Transcoder\) with the encrypted content key, key ID, and license acquisition URL\.

1. The package server fetches the file to be protected, and bundles it with the DRM information\.

1. The package server sends the DRM\-protected file to the distribution server, which distributes the file\.

**Topics**
+ [PlayReady DRM](#play-ready)

## PlayReady DRM<a name="play-ready"></a>

Elastic Transcoder supports DRM using PlayReady DRM\.  This protects your media content and ensures that only authorized users can view your media files\. The authentication and playback flow of a PlayReady protected file is dependant on your specific player and license server setup\.

### Keys for Digital Rights Management<a name="drm-key-overview"></a>

To use DRM with Elastic Transcoder, you need two types of keys and one key ID:
+ **Content key** — The key from your DRM license server, which is associated with your Elastic Transcoder job
+ **Key ID** — The ID of the key from the DRM license server, which the license server uses to identify the content key needed to decrypt a file
+ **AWS KMS key** — The AWS KMS key associated with your Elastic Transcoder pipeline

You must have a content key to use DRM\. The content key is used to encrypt your media file\. All variations and segments of the same content are encrypted using the same content key\. Elastic Transcoder does not generate this key for you; you must obtain it from your DRM license server\. You must also have the ID of the key, so that Elastic Transcoder can package it in protected playlists, allowing the player to retrieve the content key from the license server\.

You must have an AWS KMS key to use DRM\. The AWS KMS key is used to encrypt your content key before it is sent it over the Internet\. We recommend that you create one AWS KMS key to use with all your transcoding jobs\. For more information about creating and setting up an AWS KMS key, see [Using AWS KMS with Elastic Transcoder](encryption.md#using-kms)\.

### Streaming DRM\-Protected Content<a name="drm-setup"></a>

To deliver DRM content, you must have the following:
+ A DRM license provider for generating and storing your DRM content keys\.
+ A location for storing your encrypted media files\. We recommend that you store your files in Amazon S3\.
+ \(Optional\) A content distribution network \(CDN\) to stream your files\. For more information about CDNs, see [Getting Started with CloudFront](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/programming-encryption.html) in the *Amazon CloudFront Developer Guide*\.
+ An application capable of authenticating and authorizing your users\. You can use Amazon EC2 to run this application\. For more information, see [Setting Up with Amazon EC2](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/concepts.html) in the *Amazon EC2 User Guide for Windows Instances* \(for Windows users\) or [Setting Up with Amazon EC2](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts.html) in the *Amazon EC2 User Guide for Linux Instances* \(for Linux users\)\. 
+ A player capable of playing DRM\-protected and encrypted files\.
**Note**  
To use HLS with PlayReady DRM, you must have a custom player\.

### Creating DRM\-Protected Streamed Content<a name="drm-ets-setup"></a>

To prepare your files for DRM, you must associate an AWS KMS with a new or existing pipeline\.

To set up a pipeline with an AWS KMS that you specify, see [Using AWS KMS with Elastic Transcoder](encryption.md#using-kms)\.

The following steps show how to encrypt your files for DRM by using the Elastic Transcoder console:

**To use DRM for your files**

1. Open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation pane, click **Jobs** and create a new job\. For more information, see [Creating a Job in Elastic Transcoder](creating-jobs.md)\.

1. Leave **Encryption Parameters** set to `None`\.

1. For **Playlists**, click **Add Playlist** and select either `Smooth` or `HLSv3` as your playlist type\.

1. For **PlayReady DRM**, select `Enter Information`\.

   a\. For **License Acquisition Url**, type the absolute path to the DRM server\.

   b\. For **Key ID**, type your content key ID\.

   c\. For **Encryption Key**, type your base64\-encoded content key\.

   d\. For **Encryption Key MD5**, type the base64\-encoded MD5 hash of your content key\.

   e\. For **Encryption Initialization Vector**, type your base64\-encoded initialization vector\.

**Note**  
Elastic Transcoder returns your content key as part of the job object, but does not store it\. You are responsible for storing the content key in the DRM server\.