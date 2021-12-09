# DASH Manifest Time Signal Example<a name="dash-manifest-time-signal-example"></a>

**DASH origin manifest example for time signal**  
The following example shows an ad avail in a manifest received by DASH from the content origin\. The following example shows the `scte35:TimeSignal` markers\.

```
  <Period start="PT346530.250S" id="178443" duration="PT61.561S">
    <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
      <Event  duration="5310000">
        <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="183003" tier="4095">
          <scte35:TimeSignal>
            <scte35:SpliceTime ptsTime="3442857000"/>
          </scte35:TimeSignal>
          <scte35:SegmentationDescriptor segmentationEventId="1414668" segmentationEventCancelIndicator="false" segmentationDuration="8100000">
            <scte35:DeliveryRestrictions webDeliveryAllowedFlag="false" noRegionalBlackoutFlag="false" archiveAllowedFlag="false" deviceRestrictions="3"/>
            <scte35:SegmentationUpid segmentationUpidType="12" segmentationUpidLength="2" segmentationTypeId="52" segmentNum="0" segmentsExpected="0">0100</scte35:SegmentationUpid>
          </scte35:SegmentationDescriptor>
        </scte35:SpliceInfoSection>
      </Event>
    </EventStream>
    <AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
      <Representation id="1" width="960" height="540" frameRate="30000/1001" bandwidth="1000000" codecs="avc1.4D401F">
        <SegmentTemplate timescale="30000" media="index_video_1_0_$Number$.mp4?m=1528475245" initialization="index_video_1_0_init.mp4?m=1528475245" startNumber="178444" presentationTimeOffset="10395907501">
          <SegmentTimeline>
            <S t="10395907501" d="60060" r="29"/>
            <S t="10397709301" d="45045"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet mimeType="audio/mp4" segmentAlignment="0" lang="eng">
      <Representation id="2" bandwidth="96964" audioSamplingRate="48000" codecs="mp4a.40.2">
        <SegmentTemplate timescale="48000" media="index_audio_2_0_$Number$.mp4?m=1528475245" initialization="index_audio_2_0_init.mp4?m=1528475245" startNumber="178444" presentationTimeOffset="16633452001">
          <SegmentTimeline>
            <S t="16633452289" d="96256" r="3"/>
            <S t="16633837313" d="95232"/>
            <S t="16633932545" d="96256" r="4"/>
            <S t="16634413825" d="95232"/>
            <S t="16634509057" d="96256" r="5"/>
            <S t="16635086593" d="95232"/>
            <S t="16635181825" d="96256" r="4"/>
            <S t="16635663105" d="95232"/>
            <S t="16635758337" d="96256" r="5"/>
            <S t="16636335873" d="71680"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
  </Period>
```

**DASH personalized response example for time signal**  
AWS Elemental MediaTailor personalizes the ad avails with advertising specifications\. The personalizations reflect the viewer data that is received from the player and the advertising campaigns that are currently underway\. 

The following example shows an ad avail after AWS Elemental MediaTailor personalizes it\. 

```
  <Period id="178443_1" start="PT96H15M30.25S">
    <BaseURL>http://d2gh0tfpz97e4o.cloudfront.net/nbc_fallback_2/</BaseURL>
    <AdaptationSet bitstreamSwitching="false" frameRate="30/1" mimeType="video/mp4" segmentAlignment="true" startWithSAP="1" subsegmentAlignment="true" subsegmentStartsWithSAP="1">
      <SegmentTemplate startNumber="1" timescale="90000"/>
      <Representation bandwidth="10000000" codecs="avc1.640028" height="1080" id="1" width="1920">
        <SegmentTemplate initialization="nbc_fallback_ad_2_1080p_10init.mp4" media="nbc_fallback_ad_2_1080p_10_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="180000" r="13" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="4000000" codecs="avc1.64001f" height="720" id="2" width="1280">
        <SegmentTemplate initialization="nbc_fallback_ad_2_720p_9init.mp4" media="nbc_fallback_ad_2_720p_9_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="180000" r="13" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="2500000" codecs="avc1.64001f" height="720" id="3" width="1280">
        <SegmentTemplate initialization="nbc_fallback_ad_2_720p_8init.mp4" media="nbc_fallback_ad_2_720p_8_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="270000" r="8" t="0"/>
            <S d="266940" t="2430000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="2000000" codecs="avc1.64001f" height="540" id="4" width="960">
        <SegmentTemplate initialization="nbc_fallback_ad_2_540p_7init.mp4" media="nbc_fallback_ad_2_540p_7_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="360000" r="6" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="1350000" codecs="avc1.64001e" height="396" id="5" width="704">
        <SegmentTemplate initialization="nbc_fallback_ad_2_396p_6init.mp4" media="nbc_fallback_ad_2_396p_6_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="360000" r="6" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="900000" codecs="avc1.64001e" height="396" id="6" width="704">
        <SegmentTemplate initialization="nbc_fallback_ad_2_396p_5init.mp4" media="nbc_fallback_ad_2_396p_5_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="360000" r="6" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="600000" codecs="avc1.64001e" height="396" id="7" width="704">
        <SegmentTemplate initialization="nbc_fallback_ad_2_396p_4init.mp4" media="nbc_fallback_ad_2_396p_4_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="360000" r="6" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="450000" codecs="avc1.640016" height="288" id="8" width="512">
        <SegmentTemplate initialization="nbc_fallback_ad_2_288p_3init.mp4" media="nbc_fallback_ad_2_288p_3_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="360000" r="6" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="300000" codecs="avc1.640016" height="288" id="9" width="512">
        <SegmentTemplate initialization="nbc_fallback_ad_2_288p_2init.mp4" media="nbc_fallback_ad_2_288p_2_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="360000" r="6" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation bandwidth="200000" codecs="avc1.640016" height="288" id="10" width="512">
        <SegmentTemplate initialization="nbc_fallback_ad_2_288p_1init.mp4" media="nbc_fallback_ad_2_288p_1_$Number%09d$.mp4" startNumber="1" timescale="90000">
          <SegmentTimeline>
            <S d="180000" r="13" t="0"/>
            <S d="176940" t="2520000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet lang="eng" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a1_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a1_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="11">
        <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a1_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a1_128k_$Number%09d$.mp4" startNumber="1" timescale="48000">
          <SegmentTimeline>
            <S d="96000" r="13" t="0"/>
            <S d="94368" t="1344000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet lang="enm" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a2_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a2_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="12">
        <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a2_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a2_128k_$Number%09d$.mp4" startNumber="1" timescale="48000">
          <SegmentTimeline>
            <S d="96000" r="13" t="0"/>
            <S d="94368" t="1344000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet lang="por" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a3_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a3_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="13">
        <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a3_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a3_128k_$Number%09d$.mp4" startNumber="1" timescale="48000">
          <SegmentTimeline>
            <S d="96000" r="13" t="0"/>
            <S d="94368" t="1344000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet lang="spa" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a4_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a4_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="14">
        <SegmentTemplate initialization="nbc_fallback_ad_2_audio_aac_a4_128kinit.mp4" media="nbc_fallback_ad_2_audio_aac_a4_128k_$Number%09d$.mp4" startNumber="1" timescale="48000">
          <SegmentTimeline>
            <S d="96000" r="13" t="0"/>
            <S d="94368" t="1344000"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
  </Period>
```