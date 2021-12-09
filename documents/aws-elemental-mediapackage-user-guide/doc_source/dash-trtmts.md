# DASH Manifest Options in AWS Elemental MediaPackage<a name="dash-trtmts"></a>

This section describes the options that AWS Elemental MediaPackage offers for modifying live output DASH manifests\. These options don't apply to video on demand \(VOD\) outputs or harvested live\-to\-VOD assets\.

**Default DASH manifest**  
The following is a truncated example of a DASH manifest with no treatments:

```
<MPD>
  <Period>  
    <AdaptationSet>  
      <Representation> 
        <SegmentTemplate> 
          <SegmentTimeline> 
            <S /> 
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    .
    .
  </Period>
</MPD>
```

The elements of the DASH manifest are nested within the `MPD` \(media presentation description\) object\. These are the elements of the manifest:
+ `Period`: The entire manifest is nested in one period\.
+ `AdaptationSet`: An `AdaptationSet` groups together representations of the same type \(video, audio, or captions\)\. There are one or more `AdaptationSets` in the `Period`\.
+ `Representation`: A `Representation` describes an audio, video, or captions track\. There are one or more `Representations` in each `AdaptationSet`\. Each representation is a track\.
+ `SegmentTemplate`: A `SegmentTemplate` defines properties of the representation, such as the timescale and access URLs for media and initialization segments\. There is one `SegmentTemplate` for each `Representation`\.
+ `SegmentTimeline`: A `SegmentTimeline` describes when each segment is available for playback\. There is one `SegmentTimeline` for each `SegmentTemplate`\.
+ `S`: An `S` describes when the segment is available \(`t` value\), the duration of the segment \(`d` value\), and a count of how many additional consecutive segments have this same duration \(`r` value\)\. There are one or more segments in the `SegmentTimeline`\. 

AWS Elemental MediaPackage can modify how some of these elements are presented in the output manifest\. You can use the following treatment options on the output live manifest:
+ Separate the manifest into multiple periods, to allow ad breaks\. See [DASH Manifest Options in AWS Elemental MediaPackageMulti\-period DASH in AWS Elemental MediaPackage](multi-period.md)\.
+ Reduce the length of the manifest to make processing and playback more efficient\. See [Compacted DASH Manifests](compacted.md)\.
+ Control what segment information is used in the media URL in the `SegmentTemplate` properties\. See [DASH Manifest Segment Template Format](segtemp-format.md)\.