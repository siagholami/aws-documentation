# Working with Packaging Configurations in AWS Elemental MediaPackage<a name="pkg-cfig"></a>

A packaging configuration defines a single delivery point for an asset\. The configuration holds all of the information that's needed for AWS Elemental MediaPackage to integrate with a player or content delivery network \(CDN\), such as Amazon CloudFront\. The configuration outputs content in one of the available stream formats:
+ Apple HLS – Packages content to Apple HTTP Live Streaming \(HLS\) 
+ Microsoft Smooth – Packages content for Microsoft Smooth Streaming players
+ Common Media Application Format \(CMAF\) – Packages content to devices that support Apple HLS fragmented MP4 \(fMP4\)
+ DASH\-ISO – Packages content for the DASH\-ISO ABR streaming protocol

The packaging configuration also holds information about digital rights management \(DRM\) and encryption integration, bitrate presentation order, and more\.

**Topics**
+ [Creating a Packaging Configuration](pkg-cfig-create.md)
+ [Viewing Packaging Configuration Details](pkg-cfig-view.md)
+ [Editing a Packaging Configuration](pkg-cfig-edit.md)
+ [Deleting a Packaging Configuration](pkg-cfig-delete.md)