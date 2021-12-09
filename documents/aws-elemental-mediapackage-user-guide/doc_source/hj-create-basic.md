# Basic Details<a name="hj-create-basic"></a>

The basic details of a harvest job define its identifier and the source for the live\-to\-VOD asset\.

1. For **ID**, enter a name that describes the harvest job\. The ID is the primary identifier for the harvest job\. You can reuse the ID when the harvest job expires from your account\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\.

1. For **Origin endpoint**, select the endpoint that serves the live stream that you're harvesting the live\-to\-VOD asset from\. The endpoint must be serving clear \(unencrypted\) HLS content, and it must have a **startover window** that's greater than 0, up to nine hours\. The startover window on the endpoint determines how long the live\-to\-VOD asset can be\. If the endpoint has a window of five hours, the live\-to\-VOD asset can be a maximum of five hours long\.
   + To harvest a live\-to\-VOD asset when you have an encrypted live stream, create a second, unencrypted endpoint on the same channel\. For more information, see [Creating Live\-to\-VOD Assets with AWS Elemental MediaPackage](ltov.md)\.
   + To view or change the startover window on an endpoint, see [Viewing a Single Endpoint](endpoints-view-one.md)\.
   + To set the live\-to\-VOD asset length, see [Start and End Date and Time](hj-create-time.md) in this chapter\.