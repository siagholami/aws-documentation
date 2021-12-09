# `duration` Attribute in the `SegmentTemplate`<a name="segtemp-format-duration"></a>

In a default DASH manifest, `SegmentTemplate` holds a `SegmentTimeline`\. The timeline describes all the segments in `Representation`, including their duration and their start time\. With live events, AWS Elemental MediaPackage adds segments to the timeline as it receives them from your encoder\. To be aware of newly available segments, the playback device must regularly request an updated manifest from MediaPackage\.

If all the segments in a representation have the same duration, you can help to reduce latency and shorten the manifest by enabling AWS Elemental MediaPackage to remove the `SegmentTimeline` objects\. In their place, MediaPackage adds a `duration` attribute to the `SegmentTemplate` properties\. The playback device calculates when segments are available by using `duration` and `startNumber`\. Because the playback device doesn't have to rely on an updated manifest to know about segments, it doesn't have to constantly request updates to maintain playback\. For information about how the `duration` attribute works, see the following sections\.

**Topics**
+ [How the `duration` Attribute Works](#how-stemp-dur-works)
+ [`duration` Attribute with Compacted DASH Manifests](#stemp-dur-combos)

## How the `duration` Attribute Works<a name="how-stemp-dur-works"></a>

Enable the `$duration$` attribute through the **Segment template format** setting on the DASH endpoint, as described in [Creating a DASH Endpoint](endpoints-dash.md)\. This is what happens with the manifest: 

1. When AWS Elemental MediaPackage generates the DASH manifest, it adds the `duration` attribute to the `SegmentTemplate` object, as shown in the following example:  
**Example**  

   ```
   <SegmentTemplate timescale="30000" media="index_video_1_0_$Number$.mp4?m=1535562908" initialization="index_video_1_0_init.mp4?m=1535562908" startNumber="175032" duration="90000" presentationTimeOffset="62061"/>
   ```

   A segment timeline and individual segment descriptions are not included in the segment template\.
**Important**  
Except for the final segment, segments must be no more than 50% deviation from the value of the duration\. With a 90000 duration, segments must be between 45000 and 135000 \(1\.5 to 4\.5 seconds with a 30000 timescale\)\.   
**Example**  

   The following is an example of an adaptation set that uses the `duration` in the segment template:

   ```
   <AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
     <Representation id="1" width="852" height="480" frameRate="30/1" bandwidth="1200000" codecs="avc1.4D401F">
       <SegmentTemplate timescale="30000" media="index_video_1_0_$Number$.mp4?m=1535562908" initialization="index_video_1_0_init.mp4?m=1535562908" startNumber="175032" duration="90000" presentationTimeOffset="62061"/>
     </Representation>
     <Representation id="2" width="640" height="360" frameRate="30/1" bandwidth="800000" codecs="avc1.4D401E">
       <SegmentTemplate timescale="30000" media="index_video_3_0_$Number$.mp4?m=1535562908" initialization="index_video_3_0_init.mp4?m=1535562908" startNumber="175032" duration="90000" presentationTimeOffset="62061"/>
     </Representation>
     <Representation id="3" width="320" height="240" frameRate="30/1" bandwidth="499968" codecs="avc1.4D400D">
       <SegmentTemplate timescale="30000" media="index_video_5_0_$Number$.mp4?m=1535562908" initialization="index_video_5_0_init.mp4?m=1535562908" startNumber="175032" duration="90000" presentationTimeOffset="62061"/>
     </Representation>
   </AdaptationSet>
   ```

1. The playback device requests segments using the URL that is defined in the `media` attribute\. In the URL, it replaces the `$Number$` variable with the number of the segment, starting with the value of the `startNumber` in the `SegmentTemplate` for the first segment\.

1. If your playback device needs to determine the most recent segment, it uses this formula:

   \(\(wall clock time \- `availabilityStartTime` \) / \(`duration` / `timescale` \)\) \+ `startNumber`  
**Example**  

   A playback device is calculating the most recent segment with the following values:
   + Wall clock from the playback device: 2018\-11\-16T19:18:30Z
   + `availabilityStartTime` attribute from the `MPD` object of the manifest: 2018\-11\-16T19:08:30Z
   + `duration` attribute from the `SegmentTemplate` object of the manifest: 90000
   + `timescale` attribute from the `SegmentTemplate`: 30000
   + `startNumber` attribute from the `SegmentTemplate`: 175032

   The calculation it uses is \(\(2018\-11\-16T19:18:30Z \- 2018\-11\-16T19:08:30Z\) / \(90000/30000\)\) \+ 175032

   This calculation then becomes \(600 seconds elapsed time\) / \(3 second segment durations\) = 200 elapsed segments\. Adding those segments to the 175032 start segment makes the most recent segment 175232\.

## `duration` Attribute Limitations<a name="stemp-limitations"></a>

To ensure proper playback and help prevent issues with conflicting segment durations, AWS Elemental MediaPackage enforces the following limitations for the `duration` attribute:
+ You can enable the feature only when you create the endpoint\. 

  You can't modify the endpoint to later add the `duration` attribute to your DASH manifests\. This includes changing from one segment template format to one that uses `duration`\. For example, you can't create an endpoint that uses the `$Time$` variable with `SegmentTimeline`, and then edit the endpoint to use the `$Number$` variable with `duration`\.
+ You must keep the **segment duration** value that you set when you create the endpoint\.

  You can't edit the endpoint to modify the segment duration\.
+ You must produce single period DASH manifests from endpoints that use `duration`\.

  You can't use multi\-period DASH with the `duration` attribute\.

## `duration` Attribute with Compacted DASH Manifests<a name="stemp-dur-combos"></a>

Combining compacted manifests with the `duration` attribute will further reduce the size of the manifest, but not by much\. Compacted manifests have one `SegmentTemplate` and `SegmentTimeline` per adaptation set\. When you use the `duration` attribute, AWS Elemental MediaPackage removes the segment timeline\. With both treatments, the manifest has one `SegmentTemplate` per adaptation set, and no `SegmentTimeline`\. See the following examples\.

For more information about compacted manifests, see [Compacted DASH Manifests](compacted.md)\.

**Important**  
If the segments in a representation intentionally have varying sizes of segments, don't use the `duration` attribute\. This treatment works only when the segments are a consistent size\.

**Example**    
Compacted manifest  

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
Compacted manifest with `duration` attribute  

```
<AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
   <SegmentTemplate timescale="30000" media="index_video_$RepresentationID$_0_$Number$.mp4?m=1543947824" initialization="index_video_$RepresentationID$_0_init.mp4?m=1543947824" startNumber="1" duration="60000"/>
   <Representation id="1" width="640" height="360" frameRate="30/1" bandwidth="749952" codecs="avc1.640029"/>
   <Representation id="2" width="854" height="480" frameRate="30/1" bandwidth="1000000" codecs="avc1.640029"/>
   <Representation id="3" width="1280" height="720" frameRate="30/1" bandwidth="2499968" codecs="avc1.640029"/>
</AdaptationSet>
```