# DASH Ad Avail Duration<a name="dash-ad-avail-duration"></a>

During playback, when AWS Elemental MediaTailor encounters an ad avail, it replaces some or all of the avail with ads\. MediaTailor starts ad replacement at the beginning of the ad avail and includes ads as follows: 
+ If the ad avail specifies a duration, MediaTailor includes as many ads as it can fit inside the duration boundary, without overwriting content that follows\. 
+ If no duration is provided, MediaTailor includes ads until it reaches the end of the ad avail\. For multi\-period manifests, this is the end of the period\. For single\-period manifests, this is the end of the event\. MediaTailor doesn't play ads past the end of the ad avail and, when it encounters the end, truncates the current ad instead of overwriting the content that follows\. 

**How AWS Elemental MediaTailor looks for the ad avail duration**  
AWS Elemental MediaTailor searches for a duration setting in the following order: 

1. `Event` `duration`

1. For splice insert, the `scte35:BreakDuration` `duration`

1. For time signal, the `scte35:SegmentationDescriptor` `segmentationDuration`

If AWS Elemental MediaTailor doesn't find any of these settings, it manages ad inclusion without a duration\. 

The following example shows an `Event` that has a `duration`\.

```
  <Period start="PT444806.040S" id="123586" duration="PT15.000S">
    <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
      <Event duration="1350000">
        <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="180832" tier="4095">
          <scte35:SpliceInsert spliceEventId="4026531855" spliceEventCancelIndicator="false" outOfNetworkIndicator="true" spliceImmediateFlag="false" uniqueProgramId="1" availNum="1" availsExpected="1">
            <scte35:Program><scte35:SpliceTime ptsTime="5672624400"/></scte35:Program>
            <scte35:BreakDuration autoReturn="true" duration="1350000"/>
          </scte35:SpliceInsert>
        </scte35:SpliceInfoSection>
      </Event>
        ...
```

The following example shows ad avail with no duration specified\. The `Event` has no `duration` and the `scte35:SpliceInsert` element doesn't contain a `scte35:BreakDuration` child element\.

```
  <Period start="PT444836.720S" id="123597" duration="PT12.280S">
    <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
      <Event>
        <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="180832" tier="4095">
          <scte35:SpliceInsert spliceEventId="4026531856" spliceEventCancelIndicator="false" outOfNetworkIndicator="true" spliceImmediateFlag="false" uniqueProgramId="1" availNum="1" availsExpected="1">
            <scte35:Program><scte35:SpliceTime ptsTime="5675385600"/></scte35:Program>
          </scte35:SpliceInsert>
        </scte35:SpliceInfoSection>
      </Event>
      ...
```