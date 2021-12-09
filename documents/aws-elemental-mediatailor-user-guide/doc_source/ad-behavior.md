# Ad Behavior in AWS Elemental MediaTailor<a name="ad-behavior"></a>

This section covers how AWS Elemental MediaTailor manipulates the manifest to include the URLs for ads\. 

AWS Elemental MediaTailor replaces or inserts ads, depending on how the origin server configures the ad avails and on whether the content is VOD or live\. 
+ With ad replacement, MediaTailor replaces content segments with ads\. 
+ With ad insertion, MediaTailor inserts ad content where segments don’t exist\.

 AWS Elemental MediaTailor also uses configured slates to fill gaps in ads and to manage VPAID ad handling\. 

**Topics**
+ [VOD Content Ad Behavior](ad-behavior-vod.md)
+ [Live Content Ad Behavior](ad-behavior-live.md)
+ [Slate Management](slate-management.md)