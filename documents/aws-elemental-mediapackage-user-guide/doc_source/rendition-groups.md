# Rendition Groups Reference in AWS Elemental MediaPackage<a name="rendition-groups"></a>

*Rendition groups* are used in HLS and CMAF outputs\. A rendition group collects all subtitle or audio tracks and makes them available for all video renditions in the stream\. When you enable rendition groups, MediaPackage pulls together all audio variants \(such as different languages or codecs\) and groups them for use with any video rendition\. MediaPackage automatically puts subtitles into a rendition group\. 

Audio and subtitles tracks are required to be in their own rendition groups for CMAF outputs\.

The following sections further describe when you can use rendition groups\.

**Note**  
DASH and Microsoft Smooth do not use rendition groups\. This is because all audio, video, and subtitle or caption tracks are presented to the player, and the player determines which are used during playback\.

## When to Use Rendition Groups<a name="when-use-rend-group"></a>

Rendition groups are used only in HLS and CMAF outputs\. Rendition groups are most beneficial when you have multiple languages or multiple audio codecs in your streams\. Rendition groups should be used in the following use cases:

**Note**  
If you harvest a live\-to\-VOD asset from a live HLS stream with rendition groups, the groups are passed through to the asset as well\.
+ With CMAF outputs, if there are any audio or subtitle tracks

  CMAF requires all audio tracks in one rendition group, and all subtitles in another\. Audio or subtitles can't be muxed with video tracks\.
+ One or more video tracks with multiple audio languages or codecs 

  When rendition groups are enabled, MediaPackage pulls all audio renditions together for shared use between the video tracks\. In this way, you don't have to duplicate all the audio options across all the video tracks\.
+ Multiple audio\-only tracks and multiple subtitle tracks

  When both the audio tracks and subtitle tracks are in rendition groups, all the audio options can be combined with any subtitle track\.
+ One audio\-only track and multiple subtitle tracks

  MediaPackage automatically pulls subtitle tracks into a rendition group so that the audio track can be used with any subtitle\. Because there is only one audio and the subtitles are already grouped, you don't need to tell MediaPackage to use rendition groups in this case\.

## When Not to Use Rendition Groups<a name="when-not-use-rend-group"></a>

Rendition groups can't or shouldn't be used in the following use cases:
+ Multiple video tracks in the stream, but only one language or codec is used for the audio\. If the same audio is used with multiple audio tracks, and rendition groups are also used, then your rendition group will have duplicates of the same audio track \(one for each video\)\. 

  Keep the audio and video muxed in the stream, and do not use a rendition group\.
+ DASH or Microsoft Smooth Streaming outputs\. These protocols do not support rendition groups\. Instead, the output stream includes all tracks, and the player determines which to play based on rules from the player side or from the manifest \(such as language or bitrate selection\)\. 

  To limit the tracks available to a player, use the stream selection options from the MediaPackage console or the REST API\.