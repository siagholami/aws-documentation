# Delivering VOD Content from AWS Elemental MediaPackage<a name="vod-content"></a>

AWS Elemental MediaPackage uses the following resources for video on demand \(VOD\) content:
+ *Packaging groups* hold one or more packaging configurations\. The group enables you to apply multiple output configurations to an asset at the same time\. You can associate a group to multiple assets so that they all have the same configurations for their outputs\.
+ *Packaging configurations* tell MediaPackage how to package the output from an asset\. In the configuration, you define encryption, bitrate, and packaging settings\.
+ *Assets* ingest your source content and dynamically apply packaging configurations in response to playback requests\.

  For supported VOD inputs and codecs, see [VOD Supported Codecs and Input Types](supported-inputs-vod.md)\.

The following sections describe how to use these resources to manage VOD content in AWS Elemental MediaPackage\.

**Topics**
+ [Working with Packaging Groups in AWS Elemental MediaPackage](pkg-group.md)
+ [Working with Packaging Configurations in AWS Elemental MediaPackage](pkg-cfig.md)
+ [Working with Assets in AWS Elemental MediaPackage](asset.md)