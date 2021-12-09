# Working with Assets in AWS Elemental MediaPackage<a name="asset"></a>

An asset holds all of the information that AWS Elemental MediaPackage requires to ingest file\-based video content from a source such as Amazon S3\. Through the asset, MediaPackage ingests and dynamically packages content in response to playback requests\. The configurations associated with the asset determine how it can be packaged for output\. 

After you ingest an asset, AWS Elemental MediaPackage provides a URL for each playback configuration associated with the asset\. This URL is fixed for the lifetime of the asset, regardless of any failures that might happen over time\. Downstream devices use the URL to send playback requests\.

For supported VOD inputs and codecs, see [VOD Supported Codecs and Input Types](supported-inputs-vod.md)\.

**Topics**
+ [Ingesting an Asset](asset-create.md)
+ [Viewing Asset Details](asset-view.md)
+ [Editing an Asset](asset-edit.md)
+ [Deleting an Asset](asset-delete.md)