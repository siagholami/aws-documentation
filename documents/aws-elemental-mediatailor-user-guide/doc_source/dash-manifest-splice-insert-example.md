# DASH Manifest Splice Insert Example<a name="dash-manifest-splice-insert-example"></a>

**DASH origin manifest example for splice insert**  
The following example from an MPD manifest shows an ad avail in a manifest received by DASH from the content origin\. This example uses the `scte35:SpliceInsert` markers with `outOfNetworkIndicator` set to `true`\.

```
   <Period start="PT173402.036S" id="46041">
    <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
      <Event duration="9450000">
        <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="183265" tier="4095">
          <scte35:SpliceInsert spliceEventId="99" spliceEventCancelIndicator="false" outOfNetworkIndicator="true" spliceImmediateFlag="false" uniqueProgramId="1" availNum="1" availsExpected="1">
            <scte35:Program><scte35:SpliceTime ptsTime="7835775000"/></scte35:Program>
            <scte35:BreakDuration autoReturn="true" duration="9450000"/>
          </scte35:SpliceInsert>
        </scte35:SpliceInfoSection>
      </Event>
    </EventStream>
    <AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
      <Representation id="1" width="640" height="360" frameRate="30/1" bandwidth="749952" codecs="avc1.4D4029">
        <SegmentTemplate timescale="30" media="index_video_1_0_$Number$.mp4?m=1531257079" initialization="index_video_1_0_init.mp4?m=1531257079" startNumber="46042" presentationTimeOffset="5202061">
          <SegmentTimeline>
            <S t="5202061" d="115"/>
            <S t="5202176" d="120" r="4"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation id="2" width="1280" height="720" frameRate="30/1" bandwidth="2499968" codecs="avc1.4D4029">
        <SegmentTemplate timescale="30" media="index_video_3_0_$Number$.mp4?m=1531257079" initialization="index_video_3_0_init.mp4?m=1531257079" startNumber="46042" presentationTimeOffset="5202061">
          <SegmentTimeline>
            <S t="5202061" d="115"/>
            <S t="5202176" d="120" r="4"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation id="3" width="1920" height="1080" frameRate="30/1" bandwidth="4499968" codecs="avc1.4D4029">
        <SegmentTemplate timescale="30" media="index_video_5_0_$Number$.mp4?m=1531257079" initialization="index_video_5_0_init.mp4?m=1531257079" startNumber="46042" presentationTimeOffset="5202061">
          <SegmentTimeline>
            <S t="5202061" d="115"/>
            <S t="5202176" d="120" r="4"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet mimeType="audio/mp4" segmentAlignment="0" lang="eng">
      <Representation id="4" bandwidth="128858" audioSamplingRate="44100" codecs="mp4a.40.2">
        <SegmentTemplate timescale="44100" media="index_audio_2_0_$Number$.mp4?m=1531257079" initialization="index_audio_2_0_init.mp4?m=1531257079" startNumber="46042" presentationTimeOffset="7647030507">
          <SegmentTimeline>
            <S t="7647030507" d="168959"/>
            <S t="7647199468" d="176127" r="1"/>
            <S t="7647551723" d="177151"/>
            <S t="7647728875" d="176127" r="1"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation id="5" bandwidth="128858" audioSamplingRate="44100" codecs="mp4a.40.2">
        <SegmentTemplate timescale="44100" media="index_audio_4_0_$Number$.mp4?m=1531257079" initialization="index_audio_4_0_init.mp4?m=1531257079" startNumber="46042" presentationTimeOffset="7647030507">
          <SegmentTimeline>
            <S t="7647030507" d="168959"/>
            <S t="7647199468" d="176127" r="1"/>
            <S t="7647551723" d="177151"/>
            <S t="7647728875" d="176127" r="1"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
      <Representation id="6" bandwidth="128858" audioSamplingRate="44100" codecs="mp4a.40.2">
        <SegmentTemplate timescale="44100" media="index_audio_6_0_$Number$.mp4?m=1531257079" initialization="index_audio_6_0_init.mp4?m=1531257079" startNumber="46042" presentationTimeOffset="7647030507">
          <SegmentTimeline>
            <S t="7647030507" d="168959"/>
            <S t="7647199468" d="176127" r="1"/>
            <S t="7647551723" d="177151"/>
            <S t="7647728875" d="176127" r="1"/>
          </SegmentTimeline>
        </SegmentTemplate>
      </Representation>
    </AdaptationSet>
  </Period>
```

**DASH personalized response example for splice insert**  
AWS Elemental MediaTailor personalizes the ad avails with advertising specifications\. The personalizations reflect the viewer data that is received from the player and the advertising campaigns that are currently underway\. 

The following example shows an ad avail after MediaTailor personalizes it\. 

```
  <Period id="46041_1" start="PT48H10M2.036S">
    <BaseURL>http://cdnlocation.net/EXAMPLE_PRODUCT/</BaseURL>
    <AdaptationSet bitstreamSwitching="false" frameRate="30/1" mimeType="video/mp4" segmentAlignment="true" startWithSAP="1" subsegmentAlignment="true" subsegmentStartsWithSAP="1">
      <SegmentTemplate startNumber="1" timescale="90000"/>
      <Representation bandwidth="10000000" codecs="avc1.640028" height="1080" id="1" width="1920">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_1080p_10init.mp4" media="EXAMPLE_PRODUCT_1080p_10_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="4000000" codecs="avc1.64001f" height="720" id="2" width="1280">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_720p_9init.mp4" media="EXAMPLE_PRODUCT_720p_9_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="2500000" codecs="avc1.64001f" height="720" id="3" width="1280">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_720p_8init.mp4" media="EXAMPLE_PRODUCT_720p_8_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="2000000" codecs="avc1.64001f" height="540" id="4" width="960">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_540p_7init.mp4" media="EXAMPLE_PRODUCT_540p_7_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="1350000" codecs="avc1.64001e" height="396" id="5" width="704">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_396p_6init.mp4" media="EXAMPLE_PRODUCT_396p_6_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="900000" codecs="avc1.64001e" height="396" id="6" width="704">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_396p_5init.mp4" media="EXAMPLE_PRODUCT_396p_5_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="600000" codecs="avc1.64001e" height="396" id="7" width="704">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_396p_4init.mp4" media="EXAMPLE_PRODUCT_396p_4_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="450000" codecs="avc1.640016" height="288" id="8" width="512">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_288p_3init.mp4" media="EXAMPLE_PRODUCT_288p_3_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="300000" codecs="avc1.640016" height="288" id="9" width="512">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_288p_2init.mp4" media="EXAMPLE_PRODUCT_288p_2_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
      <Representation bandwidth="200000" codecs="avc1.640016" height="288" id="10" width="512">
        <SegmentTemplate initialization="EXAMPLE_PRODUCT_288p_1init.mp4" media="EXAMPLE_PRODUCT_288p_1_$Number%09d$.mp4" startNumber="1" timescale="90000"><SegmentTimeline><S d="180000" r="11" t="0"/></SegmentTimeline></SegmentTemplate>
      </Representation>
    </AdaptationSet>
    <AdaptationSet lang="eng" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a1_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a1_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="11"><SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a1_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a1_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"><SegmentTimeline><S d="96000" r="11" t="0"/></SegmentTimeline></SegmentTemplate></Representation>
    </AdaptationSet>
    <AdaptationSet lang="enm" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a2_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a2_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="12"><SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a2_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a2_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"><SegmentTimeline><S d="96000" r="11" t="0"/></SegmentTimeline></SegmentTemplate></Representation>
    </AdaptationSet>
    <AdaptationSet lang="por" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a3_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a3_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="13"><SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a3_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a3_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"><SegmentTimeline><S d="96000" r="11" t="0"/></SegmentTimeline></SegmentTemplate></Representation>
    </AdaptationSet>
    <AdaptationSet lang="spa" mimeType="audio/mp4" segmentAlignment="0">
      <SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a4_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a4_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"/>
      <Representation audioSamplingRate="48000" bandwidth="128000" codecs="mp4a.40.2" id="14"><SegmentTemplate initialization="EXAMPLE_PRODUCT_audio_aac_a4_128kinit.mp4" media="EXAMPLE_PRODUCT_audio_aac_a4_128k_$Number%09d$.mp4" startNumber="1" timescale="48000"><SegmentTimeline><S d="96000" r="11" t="0"/></SegmentTimeline></SegmentTemplate></Representation>
    </AdaptationSet>
  </Period>
```