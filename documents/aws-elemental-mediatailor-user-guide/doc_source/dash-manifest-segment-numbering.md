# DASH Manifest Segment Numbering<a name="dash-manifest-segment-numbering"></a>

MediaTailor supports media segments in `<SegmentTemplate>` that are defined using `<SegmentTimeline>` and the `media` attribute\. You can specify the media segment list in the `media` attribute using either the `$Number$` identifier or the `$Time$` identifier\.

 The following example shows a `SegmentTemplate` with a `media` attribute setting that uses the `$Number$` identifier\.

```
        <SegmentTemplate initialization="index_subtitles_4_0_init.mp4?m=1532451703" media="index_subtitles_4_0_$Number$.mp4?m=1532451703" presentationTimeOffset="1062336677920" startNumber="2349899" timescale="90000">
          <SegmentTimeline>
            <S d="540540" r="2" t="1062338840080"/>
            <S d="69069" t="1062340461700"/>
          </SegmentTimeline>
        </SegmentTemplate>
```

 The following example shows a `SegmentTemplate` with a `media` attribute setting that uses the `$Time$` identifier\.

```
        <SegmentTemplate initialization="asset_720p_8000K_9_init.mp4" media="asset_720p_8000K_9_$Time$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="180000" r="2" t="0"/>
            <S d="147000" t="540000"/>
          </SegmentTimeline>
        </SegmentTemplate>
```