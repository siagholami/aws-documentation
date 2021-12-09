# Captions<a name="captions"></a>

You can configure Elastic Transcoder to transcode captions, or subtitles, from one format to another\. Elastic Transcoder supports two types of captions:
+ **Embedded:** Embedded captions are included in the same file as the audio and video\. Elastic Transcoder supports only one embedded caption per language\.

  Valid input formats include CEA\-608 \(EIA\-608, first non\-empty channel only\), CEA\-708 \(EIA\-708, first non\-empty channel only\), and mov\-text\.

  Valid output formats include mov\-text \(MP4 only\) and CEA\-708 \(MPEG\-TS and MP4, `29.97` and `30` frames per second only\)\. CEA\-708 captions are embedded in the H\.264 SEI user data of the stream\.

  Elastic Transcoder supports a maximum of one embedded format per output\.
+ **Sidecar:** Sidecar captions are kept in a separate metadata file from the audio and video data\. Sidecar captions require a player that is capable of understanding the relationship between the video file and the sidecar file\. Elastic Transcoder supports only one sidecar caption per language, to a maximum of 20 sidecar captions tracks per file\.

  Valid input formats include DFXP \(first div element only\), EBU\-TT, SCC, SMPT, SRT, TTML, \(first div element only\), and WebVTT\.

  Valid output formats include DFXP \(first div element only\), SCC, SRT, and WebVTT\.

 If you want TTML or SMPTE\-TT compatible captions, specify DFXP as your output format\.

Elastic Transcoder does not support OCR \(Optical Character Recognition\), does not accept pictures as a valid input for captions, and is not available for audio\-only transcoding\. Elastic Transcoder does not preserve text formatting \(for example, italics\) during the transcoding process\.

For information about transcoding captions when you're using the Elastic Transcoder console, see [Output Details, Part 3, Caption Settings](job-settings.md#job-settings-output-details-part-2)\. For information about transcoding captions when you're using the Elastic Transcoder API, see the documentation about the [Create Job](create-job.md) API action beginning with the **Captions** element\.

For more information on embedded files, see the [Subtitle \(caption\)](http://en.wikipedia.org/wiki/Subtitle_%28captioning%29#Creation.2C_delivery_and_display_of_subtitles) Wikipedia page\.

For more information on sidecar files, see the [Metadata Platform](http://en.wikipedia.org/wiki/Extensible_Metadata_Platform) and [Sidecar file](http://en.wikipedia.org/wiki/Sidecar_file) Wikipedia pages\.