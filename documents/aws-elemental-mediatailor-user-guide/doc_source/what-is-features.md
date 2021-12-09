# Features of MediaTailor<a name="what-is-features"></a>

MediaTailor supports the following features: 

Ad Tracking Reporting  
MediaTailor offers server\-side ad view reporting for HLS and client\-side ad view reporting for HLS and DASH:  
+ For server\-side reporting, the service sends reporting information to ad tracking URLs directly\.
+ For client\-side reporting, the service provides the beacons for the downstream player or content distribution network \(CDN\) to use\. The player or CDN directly calls the ADS to report how much of an ad that a viewer watches, in quartile percentages \(25%, 50%, 75%, or 100%\)\.
For more information about setting up reporting, see [Ad Tracking Reporting in AWS Elemental MediaTailor](ad-reporting.md)\.

Audio   
MediaTailor supports multiple audio tracks\. For more information, see [Alternate Audio and Subtitles](manifest-audio-captions.md)\.

Content and Ad Continuity  
MediaTailor uses a transcoding service to ensure that ads and content have the same bitrate and resolution so that transitions are smooth throughout playback\.  
MediaTailor also performs audio normalization between ads and main content\. This normalization ensures that the playback volume stays consistent between ads and the content\.

Personalized Content  
MediaTailor uses VAST or VMAP to pass viewer information to the ad decision server \(ADS\), and in return receives targeted ads that are relevant for the viewer\.