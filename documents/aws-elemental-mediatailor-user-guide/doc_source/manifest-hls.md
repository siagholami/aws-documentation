# HLS \.m3u8 Manifests<a name="manifest-hls"></a>

AWS Elemental MediaTailor supports `.m3u8` HLS manifests with an `EXT-X-VERSION` of `3` or higher for live streaming and video on demand \(VOD\)\. When MediaTailor encounters an ad avail, it attempts ad insertion or replacement, based on the type of content\. If there aren't enough ads to fill the duration, for the remainder of the ad avail, MediaTailor displays the underlying content stream or the configured slate\. For more information about HLS ad behavior based on content type \(live or VOD\), see [Ad Behavior in AWS Elemental MediaTailor](ad-behavior.md)\.

The following sections provide more information about how MediaTailor handles HLS manifests\.

**Topics**
+ [HLS Supported Ad Markers](hls-ad-markers.md)
+ [HLS Manifest Tag Handling](manifest-hls-tags.md)
+ [HLS Manifest Examples](manifest-hls-example.md)