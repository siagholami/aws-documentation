# Live and VOD Manifest Reference<a name="what-is-manifest"></a>

AWS Elemental MediaPackage delivers live and video on demand \(VOD\) manifests to requesting devices\. A live manifest indicates that the content is not complete\. New content continually becomes available through the playback endpoint\. Alternatively, a VOD manifest indicates that the program is complete, or will be complete at a specified time in the future\. 

This section describes the differences in live and VOD manifests, and explains when MediaPackage delivers each manifest type\.

## Manifest Properties<a name="manifest-properties"></a>

These are the main properties in a manifest that determine if it's live or VOD:
+ For HLS and CMAF VOD manifests, `EXT-X-ENDLIST` is at the end of the bitrate manifests\. In live manifests, this tag isn't present\.
+ For MPEG\-DASH VOD manifests, `type="static"` is in the `MPD` properties\. In live manifests, the type is `dynamic`\.
+ For Microsoft Smooth VOD manifests, `IsLive=TRUE` is in the `SmoothStreamingMedia` properties\. In live manifests, the `IsLive` property isn't present\.

For VOD, the scrub bar on playback devices also often shows that the program has a limited duration\. This duration is equal to the length of the current manifest\. If a playback request defines a specific playback window, this duration is equal to the length of that playback window\. 

## When a Manifest Is VOD<a name="manifest-complete"></a>

MediaPackage delivers a VOD manifest when the content of the program is complete\. MediaPackage considers a program complete under the following conditions:

**There's an `end` parameter in the past\.**  
When a playback request includes an `end` parameter that's set in the past, the content is complete\. No new content is added to it\. MediaPackage delivers a static, VOD manifest to downstream devices\.  
For information about start and end parameters in playback requests, see [Time\-shifted Viewing Reference in AWS Elemental MediaPackage](time-shifted.md)\.

**The manifest that the upstream encoder delivers to MediaPackage includes an `EXT-X-ENDLIST` tag\.**  
When you stop the output from your encoder, the manifest that it sends to MediaPackage includes an `EXT-X-ENDLIST` tag\. This tag tells MediaPackage that the content is complete, and no new content will be added\. MediaPackage delivers a static, VOD manifest to downstream devices\.  
If you manually stop an AWS Elemental MediaLive channel when one or both pipelines to MediaPackage are stopped, MediaLive doesn't include `EXT-X-ENDLIST` in the HLS manifest to MediaPackage\. MediaPackage continues to produce a live manifest\.   
If both pipelines are active when you stop the channel, MediaLive includes `EXT-X-ENDLIST`\. MediaPackage delivers a VOD manifest to downstream devices\.
If you restart the output from the encoder, the manifest from MediaPackage becomes live again\. Playback devices might need to refresh to resume content playback\.  
If you're using input redundancy and the active stream ends, MediaPackage fails over to the other incoming stream for input\. The manifest isn't marked as complete unless both incoming streams end\.