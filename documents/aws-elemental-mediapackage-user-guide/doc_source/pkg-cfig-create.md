# Creating a Packaging Configuration<a name="pkg-cfig-create"></a>

Create a packaging configuration to define how AWS Elemental MediaPackage prepares content for delivery from an asset\. 

To create a packaging configuration, you can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API\. For information about creating a packaging configuration with the AWS CLI or MediaPackage API, see [Packaging\_configurations](https://docs.aws.amazon.com/mediapackage-vod/latest/apireference/packaging_configurations.html) in the *AWS Elemental MediaPackage VOD API Reference*\.

When you're creating a packaging configuration, don't put sensitive identifying information like customer account numbers into free\-form fields, such as the **ID** field\. This applies when you're using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**Topics**
+ [Creating an HLS Packaging Configuration](pkg-cfig-create-hls.md)
+ [Creating a DASH Packaging Configuration](pkg-cfig-create-dash.md)
+ [Creating a Microsoft Smooth Packaging Configuration](pkg-cfig-create-mss.md)
+ [Creating a Common Media Application Format \(CMAF\) Packaging Configuration](pkg-cfig-create-cmaf.md)