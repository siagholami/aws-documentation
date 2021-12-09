# HLS Manifest Tag Handling<a name="manifest-hls-tags"></a>

This section describes how AWS Elemental MediaTailor manages tags in the personalized output manifest\.

## EXT\-X\-CUE Tags<a name="manifest-hls-tags-cue"></a>

MediaTailor replaces `EXT-X-CUE-OUT`, `EXT-X-CUE-OUT-CONT`, and `EXT-X-CUE-IN` tags in the input manifest with `EXT-X-DISCONTINUITY` tags in the output manifest\. The `DISCONTINUITY` tags mark the following boundaries:
+ Where the main content transitions to an ad
+ Where one ad transitions to another ad
+ Where an ad transitions back to the main content

## EXT\-X\-DATERANGE Tags<a name="manifest-hls-tags-daterange"></a>

MediaTailor passes through `EXT-X-DATERANGE` tags from the input manifest to the output manifest\. MediaTailor also inserts `EXT-X-DISCONTINUITY` tags that correspond to the `DATERANGE` tags\. The `DISCONTINUITY` tags mark the following boundaries:
+ Where the main content transitions to an ad
+ Where one ad transitions to another ad
+ Where an ad transitions back to the main content

## EXT\-X\-KEY Tags<a name="manifest-hls-tags-key"></a>

MediaTailor passes through `EXT-X-KEY` tags from the input manifest\. These tags indicate that the main content is encrypted\. Since ads aren't encrypted, MediaTailor inserts `EXT-X-KEY:METHOD=NONE` at the start of an ad avail\. When playback returns to the main content, MediaTailor re\-enables encryption by inserting the `EXT-X-KEY` tag with the `METHOD` value defined as the encryption type\.

## Unrecognized Tags<a name="manifest-hls-tags-unknown"></a>

MediaTailor passes through all unknown and custom tags from the input manifest to the output manifest\.