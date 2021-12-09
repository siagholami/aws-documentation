# Working with Channels in AWS Elemental MediaPackage<a name="channels"></a>

A channel holds all the information that AWS Elemental MediaPackage requires to receive a live content stream from a source such as AWS Elemental MediaLive or another encoder\. The channel receives content, and after packaging it, outputs it through an endpoint to downstream devices \(such as video players or CDNs\) that request the content\. 

After you create a channel, AWS Elemental MediaPackage provides a pair of input URLs that are fixed for the lifetime of the channel, regardless of any failures or upgrades that might happen over time\. The output of the upstream encoder points to the URLs for stream delivery to MediaPackage\.

For supported live inputs and codecs, see [Live Supported Codecs and Input Types](supported-inputs-live.md)\.

**Topics**
+ [Creating a Channel](channels-create.md)
+ [Viewing Channel Details](channels-view.md)
+ [Editing a Channel](channels-edit.md)
+ [Rotating Credentials on an Input URL](channels-rotate-creds.md)
+ [Deleting a Channel](channels-delete.md)
+ [Adding an Endpoint to a Channel](channels-add-endpoint.md)