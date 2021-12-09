# How MediaTailor Works<a name="what-is-flow"></a>

MediaTailor serves personalized content to viewers while maintaining broadcast quality\-of\-service in over\-the\-top \(OTT\) applications\. 

Here is the general MediaTailor processing flow:

1. A player or content distribution network \(CDN\) such as Amazon CloudFront sends a request to MediaTailor for HLS or DASH content\. The request contains parameters from the player that includes information about the viewer that is used for ad customization\. The format of the request varies depending on whether you use server\-side or client\-side reporting to track how much of an ad the viewer watches\. 

   For information about how the requests differ between the two reporting methods, see [Ad Tracking Reporting in AWS Elemental MediaTailor](ad-reporting.md)\. For information about configuring the ad targeting parameters, see [Dynamic Ad Variables in AWS Elemental MediaTailor](variables.md)\.

1. Based on the request, MediaTailor retrieves the content manifest and ad specifications as follows:
   + MediaTailor sends a manifest request to your origin server, typically AWS Elemental MediaPackage\. The origin server returns a fully formed template manifest with ad markers, so that MediaTailor knows where to perform ad insertion or replacement\.
   + MediaTailor sends ad requests that include the viewer information to your ADS\. MediaTailor sends one request for pre\-roll ad avails, and one for other ad avails \(as applicable\)\. The ADS chooses ads based on the viewer information and current ad campaigns\. It returns the ad URLs in a VAST or VMAP response\.

1. MediaTailor manipulates the manifest to include the URLs for the appropriate ads from the VAST or VMAP response\. For the logic behind how ads are inserted, see [Ad Behavior in AWS Elemental MediaTailor](ad-behavior.md)\.

1. MediaTailor provides the fully customized manifest to the requesting CDN or player\. 

1. As playback progresses, either MediaTailor or the video player reports how much of an ad is played to the ADS ad tracking URL\. For more information about ad reporting, see [Ad Tracking Reporting in AWS Elemental MediaTailor](ad-reporting.md)\. The player requests ad segments throughout content playback\. When MediaTailor receives an ad segment request, if the ad is not already transcoded in a format that matches the video content, MediaTailor transcodes the ad\. If an ad is not already transcoded, MediaTailor doesn't present it for playback at the first request\. 

## Mixed Content Requests<a name="mixed-content-requests"></a>

Content requests are mixed when some requests are sent over HTTPS, while others are sent over HTTP\. Player requests for manifests and ad segments from MediaTailor are always sent over HTTPS\. If the origin server accepts only HTTP requests, playback might fail at the player\. To avoid playback issues, do one of the following:
+ Use an origin server that supports HTTPS requests\.
+ Use a content distribution network \(CDN\) to enforce HTTPS requests\. For more information, see [Using HTTPS in Amazon CloudFront](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/using-https.html)\. 

## Manifest Response Latency<a name="latency-note"></a>

A certain amount of latency is normal for MediaTailor responses to manifests\. Latency occurs mainly for these three reasons:
+ Manifest processing latency – time it takes for MediaTailor to look up entries in databases, and to compute and produce manifests\. Latency is usually less than 100 milliseconds\.
+ ADS latency – time it takes for the ADS to respond to the MediaTailor request\. Latency is variable, but MediaTailor times out if the ADS hasn't sent a response in 1\.5 seconds or less\.
+ Origin server latency – time it takes for the origin server to respond to the MediaTailor request\. Latency is variable, but MediaTailor times out if the origin server hasn't sent a response in 2 seconds or less\.