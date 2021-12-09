# Packager Settings Fields<a name="endpoints-dash-packager"></a>

1. For **Type**, choose **DASH\-ISO**\.

1. \(Optional\) For **Segment duration**, type the duration \(in seconds\) of each segment\. If the value that you type here is different from the input segment size, AWS Elemental MediaPackage rounds segments to the nearest multiple of the input segment duration\.
**Important**  
If you enable **Number with duration** in **Segment template format**, you can't change the segment duration after you've created the endpoint\.

1. \(Optional\) For **Manifest window duration**, type the total duration \(in seconds\) of the manifest\.

1. \(Optional\) In **Profile**, specify a DASH profile, like HbbTV\.

   Choose from the following:
   + **None** – the output doesn't use a DASH profile
   + **Hbbtv 1\.5** – the output is HbbTV\-compliant

1. \(Optional\) In **Manifest layout**, choose if you want AWS Elemental MediaPackage to serve a full or compact manifest in response to playback requests\.
   + If you choose **Full**, MediaPackage presents the `SegmentTemplate` and `SegmentTimeline` tags for every `Representation` in the manifest\.
   + If you choose **Compact**, MediaPackage combines duplicate `SegmentTemplate` tags and presents them at the start of the manifest\. This shortens the manifest and makes it easier for some devices to process it\.

   For more information about the manifest layout options, see [Compacted DASH Manifests](compacted.md)\.

1. \(Optional\) For **Min update period**, type the minimum amount of time \(in seconds\) that the player should wait before requesting manifest updates\. A lower value means that manifests are updated more frequently, but a lower value also contributes to request and response network traffic\.

1. \(Optional\) For **Min buffer time**, type the minimum amount of time \(in seconds\) that a player must keep in the buffer\. If network conditions interrupt playback, the player will have additional buffered content before playback fails, allowing for recovery time before the viewer's experience is affected\.

1. \(Optional\) For **Suggested presentation delay**, enter the amount of time \(in seconds\) that the player should be from the end of the manifest\. This sets the content start point back x seconds from the end of the manifest \(the point where content is live\)\. For example, with a 35\-second presentation delay, requests at 5:30 receive content from 5:29:25\. When used with time delay, AWS Elemental MediaPackage adds the suggested presentation delay to the time delay duration\.

1. \(Optional\) In **Segment template format**, choose how AWS Elemental MediaPackage and playback requests refer to each segment\.
   + If you choose **Number with timeline**, MediaPackage uses the `$Number$` variable to refer to the segment in the `media` attribute of the `SegmentTemplate` tag\. The value of the variable is the sequential number of the segment\. `SegmentTimeline` is included in each segment template\.
   + If you choose **Number with duration**, MediaPackage uses the `$Number$` variable and replaces the `SegmentTimeline` objects with a `duration` attribute in the segment template\.
   + If you choose **Time with timeline**, MediaPackage uses the `$Time$` variable to refer to the segment\. The value of the variable is the timestamp of when on the manifest timeline the segment starts\. `SegmentTimeline` is included in each segment template\.

   For more information about the formatting options of the `SegmentTemplate` tag, see [DASH Manifest Segment Template Format](segtemp-format.md)\.

1. For **Period triggers**, choose how AWS Elemental MediaPackage creates media presentation description \(MPD\) periods in the DASH output manifest\. Choose from the following:
   + **None** – MediaPackage doesn't create additional periods\. It formats the manifest as a single period and doesn't include SCTE\-35 markers in the segments\.
   + **Trigger new periods on ads** – MediaPackage creates and inserts in the manifest multiple periods based on SCTE\-35 ad markers from the input content\. These periods separate portions of the content, such as setting boundaries between the main content and ad content\. For more information about how AWS Elemental MediaPackage configures periods in the manifest, see [DASH Manifest Options in AWS Elemental MediaPackageMulti\-period DASH in AWS Elemental MediaPackage](multi-period.md)\.
**Important**  
Multiple periods are required if you use AWS Elemental MediaTailor for personalized ad insertion in DASH content\. For more information about this service, see the [AWS Elemental MediaTailor User Guide](https://docs.aws.amazon.com/mediatailor/latest/ug/)\.

**SCTE\-35 Options**  
The following fields dictate how MediaPackage processes SCTE\-35 messages from the input stream\. For more information, see [SCTE\-35 Message Options in AWS Elemental MediaPackage](scte.md)\.

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

   If you choose not to insert ad markers, MediaPackage also won't create periods\. The output manifest is contained in a single period\.