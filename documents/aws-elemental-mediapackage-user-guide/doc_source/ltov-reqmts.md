# Live\-to\-VOD Requirements<a name="ltov-reqmts"></a>

Keep in mind these requirements when you're creating live\-to\-VOD assets in AWS Elemental MediaPackage\.

**Endpoint requirements**  
The endpoint that you're harvesting the live\-to\-VOD asset from must meet these requirements:
+ It must have a **Startover window** greater than 0 and up to nine hours\. To check or change the size of the window, see [Viewing a Single Endpoint](endpoints-view-one.md)\.
+ It must serve clear \(unencrypted\) HLS content\. If the live stream that you harvest from is served on an encrypted endpoint, create an identical, unencrypted endpoint on the same channel\. Disable **Allow origination** so that the new endpoint can't be used for playback\. MediaPackage creates the URL for endpoints that don't have origination enabled, but MediaPackage responds with an error to playback requests sent to this endpoint\. For information about creating endpoints, see [Creating an HLS Endpoint](endpoints-hls.md)\. 

**Live\-to\-VOD asset requirements**  
The live\-to\-VOD asset must meet these requirements:
+ It must start in the past, at the same time or after the live stream started\.
+ It must be no longer than the time specified in the **Startover window** on the endpoint\. If the endpoint has a window of 30 minutes, the live\-to\-VOD asset can't be longer than 30 minutes\. An endpoint can have a maximum 9 or 18 hour startover window, depending on the endpoint type\. A live\-to\-VOD asset also can't the window quota for the endpoint\. For startover window quotas by endpoint, see the *Time\-shifted manifest length quota* in [Live Hard Quotas](limits-live.md#hard-limits)\.
+ It must have a start and end time that's within the startover window on the endpoint\.