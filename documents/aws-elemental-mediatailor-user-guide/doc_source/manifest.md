# AWS Elemental MediaTailor Manifest Handling<a name="manifest"></a>

A manifest is the input to AWS Elemental MediaTailor from an upstream encoder\. When MediaTailor receives a request for content playback, it manipulates the manifest and adds personalized content, tailored for the viewing session\. This section describes how MediaTailor handles manifests\. For information about ad handling and insertion, see [Ad Behavior in AWS Elemental MediaTailor](ad-behavior.md)\.

**Topics**
+ [Ad Transcoding](manifest-transcoding.md)
+ [Alternate Audio and Subtitles](manifest-audio-captions.md)
+ [HLS \.m3u8 Manifests](manifest-hls.md)
+ [DASH \.mpd Manifests](manifest-dash.md)