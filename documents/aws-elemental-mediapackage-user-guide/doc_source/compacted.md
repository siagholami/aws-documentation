# Compacted DASH Manifests<a name="compacted"></a>

The ability to compact DASH manifests is available with only live workflows in AWS Elemental MediaPackage\.

The default DASH manifest from AWS Elemental MediaPackage includes duplicate data about each representation \(track\)\. For some players, processing a manifest with all this data is difficult and slow\. To reduce some of the burden, MediaPackage can compact the manifest by moving some attributes from the `Representation` object to the `AdaptationSet` object\. This way, rather than having the attributes defined for each representation in the manifest, they're defined once at a higher level\. The representations then inherit these attributes from the adaptation set\.

**Example Default DASH manifest**  
In the following example, the `SegmentTemplate` object and all of its elements are listed in every `Representation.` Each adaptation set in the manifest has this same layout:  

```
<AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
   <Representation id="1" width="640" height="360" frameRate="30/1" bandwidth="749952" codecs="avc1.640029">
      <SegmentTemplate timescale="30000" media="index_video_1_0_$Number$.mp4?m=1543947824" initialization="index_video_1_0_init.mp4?m=1543947824" startNumber="1">
         <SegmentTimeline>
           <S t="62000" d="60000" r="9"/>
         </SegmentTimeline>
      </SegmentTemplate>
   </Representation>
   <Representation id="2" width="854" height="480" frameRate="30/1" bandwidth="1000000" codecs="avc1.640029">
      <SegmentTemplate timescale="30000" media="index_video_3_0_$Number$.mp4?m=1543947824" initialization="index_video_3_0_init.mp4?m=1543947824" startNumber="1">
         <SegmentTimeline>
           <S t="62000" d="60000" r="9"/>
         </SegmentTimeline>
      </SegmentTemplate>
   </Representation>
   <Representation id="3" width="1280" height="720" frameRate="30/1" bandwidth="2499968" codecs="avc1.640029">
      <SegmentTemplate timescale="30000" media="index_video_5_0_$Number$.mp4?m=1543947824" initialization="index_video_5_0_init.mp4?m=1543947824" startNumber="1">
         <SegmentTimeline>
           <S t="62000" d="60000" r="9"/>
         </SegmentTimeline>
      </SegmentTemplate>
   </Representation>
</AdaptationSet>
```

**Example Compacted DASH manifest**  
In this example, the `SegmentTemplate` objects and all of their elements are collapsed into one and moved to the `AdaptationSet`\. The playback device understands that each representation in this adaptation set uses this same template:  

```
<AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
   <SegmentTemplate timescale="30000" media="index_video_$RepresentationID$_0_$Number$.mp4?m=1543947824" initialization="index_video_$RepresentationID$_0_init.mp4?m=1543947824" startNumber="1">
     <SegmentTimeline>
       <S t="62000" d="60000" r="9"/>
     </SegmentTimeline>
   </SegmentTemplate>
   <Representation id="1" width="640" height="360" frameRate="30/1" bandwidth="749952" codecs="avc1.640029"/>
   <Representation id="2" width="854" height="480" frameRate="30/1" bandwidth="1000000" codecs="avc1.640029"/>
   <Representation id="3" width="1280" height="720" frameRate="30/1" bandwidth="2499968" codecs="avc1.640029"/>
</AdaptationSet>
```

 For information about compacting a DASH manifest, see [How AWS Elemental MediaPackage Compacts Manifests](#how-cpact-works)\.

## How AWS Elemental MediaPackage Compacts Manifests<a name="how-cpact-works"></a>

To compact the DASH manifest from the AWS Elemental MediaPackage console, choose **Compact** for **Manifest layout** on the DASH endpoint\. To ensure that tracks are available at the right time, AWS Elemental MediaPackage checks the frame rate and audio sampling rate in the source content to determine if the manifest can be compacted\.

**Note**  
Captions tracks always use the same rate, so AWS Elemental MediaPackage always compacts adaptation sets with captions\.

AWS Elemental MediaPackage takes the following actions:
+ If the rates are the same across all representations in an adaptation set, AWS Elemental MediaPackage collapses all of the `SegmentTemplate` objects into one and moves it to the `AdaptationSet` level\. This way, the information in the template isn't repeated throughout the manifest\. To allow the playback device to use the same template information across representations, MediaPackage adds a `$RepresentationID$` variable to the `media` and `initialization` request URLs\. The playback device replaces this variable with the ID of the representation that it's currently requesting\. MediaPackage also moves the `ContentProtection` element, when it's present, to the adaptation set as well\.
+ If the rates are different across representations, AWS Elemental MediaPackage compacts and moves the `SegmentTemplate` with the most frequent rate to the `AdaptationSet`\. Representations with a different rate keep their segment template\. The rate for the representation overrides the one at the adaptation set\.
+ If there are exactly two frame rates in use in a video adaptation set, AWS Elemental MediaPackage compacts as follows:
  + When 24 and 48 are used, the compacted template uses 48 for the frame rate and 48000 for the timebase\.
  + When 25 and 50 are used, the compacted template uses 50 for the frame rate and 50000 for the timebase\.
  + When 29\.97 and 59\.94 are used, the compacted template uses 59\.95 for the frame rate and 60000 for the timebase\.
  + When 30 and 60 are used, the compacted template uses 60 for the frame rate and 60000 for the timebase\.

  If there are two video frame rates in use but they aren't in one of the doubled patterns above, then that set can't be compacted\.
+ If there are no duplicate rates across representations in an adaptation set, then that set can't be compacted\.