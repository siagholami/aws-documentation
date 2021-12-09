# `media` Attribute in `SegmentTemplate`<a name="segtemp-format-media"></a>

The `media` attribute in the `SegmentTemplate` properties defines the URL where playback devices send segment requests\. By default, this URL uses a `$Number$` variable to identify the specific segment that is requested\. When a playback device requests the segment, it replaces the variable with the number identifier of the segment\. For the first segment in the representation, replace this identifier with the value of the `startNumber` from the `SegmentTemplate` properties\. Each additional segment increments by one\.

Some players navigate the segments better when the segments are identified instead by the timestamp for when playback is available\. To support this use case, MediaPackage uses the `$Time$` variable instead of `$Number$` in the URL of the `media` attribute\. When a playback device requests the segment, it replaces the variable with the availability start time of the segment\. This start time is identified in the `t` value of the segment \(`S`\) properties in the `SegmentTimeline` object\. For an example, see [How It Works](#how-stemp-works)\.

## How the `$Time$` Variable Works<a name="how-stemp-works"></a>

Enable the `$Time$` variable through the **Segment template format** setting on the DASH endpoint, as described in [Creating a DASH Endpoint](endpoints-dash.md)\. AWS Elemental MediaPackage takes the following actions:

1.  When AWS Elemental MediaPackage generates the DASH manifest, it uses the `$Time$` variable in the `media` value of the `SegmentTemplate` object, as shown in the following example:  
**Example**  

   ```
   <SegmentTemplate timescale="30" media="index_video_1_0_$Time$.mp4?m=1122792372" initialization="index_video_1_0_init.mp4?m=1122792372" startNumber="2937928">
   ```

1. When a playback device requests segments, it uses the URL defined in the `media` attribute and replaces the variable with the availability start time of the segment that is requested\.
**Important**  
The value that replaces the variable must be an exact `t` value of a segment\. If the request uses an arbitrary timestamp, AWS Elemental MediaPackage doesn't seek the closest segment\.  
**Example**  

   The following is an example of a segment template from a representation\. It uses the `$Time$` variable:

   ```
   <SegmentTemplate timescale="30000" media="155_video_1_2_$Time$.mp4?m=1545421124" initialization="155_video_1_2_init.mp4?m=1545421124" startNumber="710">
     <SegmentTimeline>
          <S t="255197799" d="360360" r="8"/>
          <S t="258441039" d="334334"/>
     </SegmentTimeline>
   </SegmentTemplate>
   ```

   The request URL for the first segment is **155\_video\_1\_2\_*255197799*\.mp4**\. With a 360360 duration, the next segment request is **155\_video\_1\_2\_*255558159*\.mp4**, and so on through the ninth segment\. 

   The final segment request is **155\_video\_1\_2\_*258441039*\.mp4**\.