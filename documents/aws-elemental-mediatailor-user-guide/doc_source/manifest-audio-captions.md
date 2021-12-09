# Alternate Audio and Subtitles<a name="manifest-audio-captions"></a>

AWS Elemental MediaTailor supports input and output of multiple audio and WebVTT subtitle tracks\. 

## Audio<a name="manifest-audio-captions-alternate"></a>

If your content contains alternate audio, AWS Elemental MediaTailor transcodes audio\-only renditions of the ads to the alternate audio tracks for your content\. This way, audio switching continues to work during ads\. The service inserts the default audio from the ad and replicates it across your audio tracks during ad avails\.

For ad transcoding to succeed, the audio sample rate must be from 16 to 320 kHz\.

## Subtitles<a name="manifest-audio-captions-subtitles"></a>

Ad playback doesn't include subtitles\. Instead, AWS Elemental MediaTailor inserts blank offsets for the webVTT sidecar files during ad avails\. 

For DASH, AWS Elemental MediaTailor supports in\-band subtitles\. MediaTailor currently does not support sideband subtitles\. 