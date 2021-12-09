# Packager Settings Fields<a name="endpoints-hls-packager"></a>

1. For **Type**, choose **Apple HLS**\.

1. \(Optional\) For **Segment duration**, type the duration \(in seconds\) of each segment\. If the value that you type here is different from the input segment size, AWS Elemental MediaPackage rounds segments to the nearest multiple of the input segment duration\.

1. \(Optional\) For **Playlist window duration**, type the total duration \(in seconds\) of the manifest\.

1. \(Optional\) To group all audio tracks into a single HLS rendition group, select **Use audio rendition group**\. For more information about rendition groups, see [Rendition Groups Reference in AWS Elemental MediaPackage](rendition-groups.md)\.

1. \(Optional\) In stream sets with a single video track, to include an additional I\-frame only stream along with the other tracks in the manifest, select **Include IFrame only stream**\. MediaPackage inserts `EXT-I-FRAMES-ONLY` tags in the manifest, and then compiles and includes an I\-frames only playlist in the stream\. This playlist enables player functionality like fast forward and rewind\.

1. \(Optional\) To include `EXT-X-PROGRAM-DATE-TIME` tags in the output manifest, select **Program date/time interval**, and then type the interval for MediaPackage to insert the tags in the manifest\.

   The `EXT-X-PROGRAM-DATE-TIME` tag holds the time of the segment\. When program date time \(PDT\) information is available in the source content, MediaPackage uses this same information on the output content\. Otherwise, MediaPackage uses Coordinated Universal Time \(UTC\) for the PDT\.

   The PDT information helps downstream players to synchronize the stream to the wall clock, enabling functionality like viewer seek in the playback timeline and time display on the player\.

**SCTE\-35 Options**  
The following fields dictate how MediaPackage processes SCTE\-35 messages from the input stream\. For more information, see [SCTE\-35 Message Options in AWS Elemental MediaPackage](scte.md)\.

1. \(Optional\) In **Ad markers**, choose how ad markers are included in the packaged content\. 

   Choose from the following:
   + **None** – Omit all SCTE\-35 ad markers from the output\.
   + **SCTE\-35 enhanced** – Generate ad markers and blackout tags based on the SCTE\-35 input messages from the input source\.
   + **Passthrough** – Copy the SCTE\-35 ad markers directly from the input HLS input manifest to the output manifest\.

1. \(Optional\) To add or remove SCTE\-35 message types that MediaPackage treats as ads, choose **Customize ad triggers**\. If you don't make a selection here, MediaPackage inserts ad markers in the output manifest based on these message types:
   + Splice insert
   + Provider advertisement
   + Distributor advertisement
   + Provider placement opportunity
   + Distributor placement opportunity

1. \(Optional\) To change what ad insertion action MediaPackage takes based on delivery restriction flags in the segmentation descriptors of SCTE\-35 messages, choose **Ads on delivery restrictions**\. These are the available options:
   + **None** – MediaPackage doesn't insert any ad markers in the output manifest\.
   + **Restricted** – MediaPackage inserts ad markers when there *are* delivery restrictions in the SCTE\-35 message types that you indicated in **Customize ad triggers**\.
   + **Unrestricted** – MediaPackage inserts ad markers when there *aren't* delivery restrictions in the SCTE\-35 message types that you indicated in **Customize ad triggers**\.
   + **Both** – MediaPackage inserts ad markers whether or not there are delivery restrictions in the SCTE\-35 message types that you indicated in **Customize ad triggers**\.