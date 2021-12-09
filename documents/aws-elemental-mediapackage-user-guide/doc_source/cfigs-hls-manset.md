# Manifest Settings Fields<a name="cfigs-hls-manset"></a>

Specify the format of the manifest that AWS Elemental MediaPackage delivers from an asset that uses this packaging configuration\.

1. \(Optional\) For **Manifest name**, enter a short string that will be appended to the endpoint URL\. The manifest name creates a unique path to this endpoint\. If you don't enter a value, MediaPackage uses the default manifest name, *index*\.

1. \(Optional\) In stream sets with a single video track, to include an additional I\-frame only stream along with the other tracks in the manifest, choose **Include IFrame only stream**\. MediaPackage inserts EXT\-I\-FRAMES\-ONLY tags in the manifest, and then compiles and includes an I\-frames only playlist in the stream\. This playlist enables player functionality like fast forward and rewind\.

1. \(Optional\) To group all audio tracks into a single HLS rendition group, choose **Use audio rendition group**\. For more information about rendition groups, see [Rendition Groups Reference in AWS Elemental MediaPackage](rendition-groups.md)\.

1. \(Optional\) Select **Repeat EXT\-X\-KEY** if you want the service to repeat the key before every segment of the manifest\. By default, the key is written just once, after the header and before the segments\. If you select **Repeat EXT\-X\-KEY**, the manifest is written as header, key, segment, key, segment, key, and so on, with every segment preceded by the key\. Set this according to the needs of the player\. Selecting this option might result in an increase in client requests to the DRM server\.

1. \(Optional\) To include EXT\-X\-PROGRAM\-DATE\-TIME tags in the output manifest, choose **Program date/time interval**, and then enter the interval at which MediaPackage should insert the tags in the manifest\.

   The EXT\-X\-PROGRAM\-DATE\-TIME tag synchronizes the stream to the wall clock, enabling functionality like viewer seek in the playback timeline and time display on the player\.

1. \(Optional\) In **Ad markers**, choose how ad markers are included in the packaged content\. 

   Choose from the following:
   + **None** – Omit all SCTE\-35 ad markers from the output\.
   + **SCTE\-35 enhanced** – Generate ad markers and blackout tags based on the SCTE\-35 input messages from the input source\.
   + **Passthrough** – Copy the SCTE\-35 ad markers directly from the input HLS input manifest to the output manifest\.