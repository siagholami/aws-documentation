# VOD Supported Codecs and Input Types<a name="supported-inputs-vod"></a>

The following sections describe supported input types and codecs for file\-based video on demand \(VOD\) content\.

## Supported Input Types<a name="supported-types-vod"></a>

These are the input types that AWS Elemental MediaPackage supports for VOD content\.


| MediaPackage Input Type | Use Case | 
| --- | --- | 
| HLS | Pull an HLS stream set from an Amazon Simple Storage Service bucket, with or without a secure connection\.Additional requirements:[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html) | 
| SMIL | Pull an MP4 stream set referenced by a \.smil manifest from an Amazon Simple Storage Service bucket, with or without a secure connection\. For information about the \.smil manifest, see [Creating a SMIL File](supported-inputs-vod-smil.md)\.Additional requirements:[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html) | 

## Supported Input Codecs<a name="suported-inputs-codecs-vod"></a>

These are the video, audio, and subtitles codecs that MediaPackage supports for file\-based source content\.


| Input Type | Media Container | Video Codecs | Audio Codecs | Subtitles Format | 
| --- | --- | --- | --- | --- | 
| HLS |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  | WebVTT | 
| SMIL | MP4 \(non\-fragmented\) |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  | SRT | 

## Supported Output Codecs<a name="suported-outputs-codecs-vod"></a>

These are the video, audio, and subtitles codecs that MediaPackage supports for delivering VOD content\.


| Endpoint Type | Manifest Format | Media Container | Video Codecs | Audio Codecs | Subtitles Format | 
| --- | --- | --- | --- | --- | --- | 
| Apple HLS | HLS |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  | WebVTT | 
| Microsoft Smooth | MSS | MP4 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  | DFXP | 
| DASH\-ISO | MPEG\-DASH | MP4 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  | EBU\-TT | 
| CMAF | HLS | CMAF |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/supported-inputs-vod.html)  | WebVTT | 