# Multi\-period DASH in AWS Elemental MediaPackage<a name="multi-period"></a>

Multi\-period DASH manifests are available with only live workflows in AWS Elemental MediaPackage\.

A period is a chunk of content in the DASH manifest, defined by a start time and duration\. By default, the entire manifest is contained in one period but AWS Elemental MediaPackage can partition the DASH manifest into multiple periods to indicate boundaries between ads and the main content\. For example, if you're using MediaPackage with a downstream ad service such as AWS Elemental MediaTailor, choose **Trigger new period on ads** on the MPEG\-DASH endpoint in MediaPackage\. This option tells MediaPackage that the DASH manifest is to be formatted with multiple periods\.
+ For information about AWS Elemental MediaTailor, see the [https://docs.aws.amazon.com/mediatailor/latest/ug/](https://docs.aws.amazon.com/mediatailor/latest/ug/)\.
+ For information about DASH\-ISO endpoints in AWS Elemental MediaPackage, see [Creating a DASH Endpoint](endpoints-dash.md)\.
+ For more information about how multi\-period DASH works in AWS Elemental MediaPackage, see the following *How it Works* section\.

## How Multi\-period DASH Works<a name="how-mp-works"></a>

To use the multi\-period DASH feature, the input to AWS Elemental MediaPackage must have SCTE\-35 ad marker messages\. These messages inform MediaPackage of where to create period boundaries\. This is how MediaPackage processes those messages:

1. AWS Elemental MediaPackage detects the SCTE\-35 messages from the input source\. 

1. Using the attributes of the SCTE\-35 messages, AWS Elemental MediaPackage calculates where the boundaries are between the end of the main content and the ads\. This calculation is \(scte35 `ptsAdjustment` \+ scte35 `ptsTime`\) / \(EventStream `timescale`\)\.  
**Example**  

   In the following example, the period starts at 44\.075 seconds because \(183003 \+ 3783780\) / 90000 = 44\.075:

   ```
   <Period start="PT44.075S" id="21">
       <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
         <Event>
           <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="183003" tier="4095">
             <scte35:SpliceInsert spliceEventId="1000" spliceEventCancelIndicator="false" outOfNetworkIndicator="true" spliceImmediateFlag="false" uniqueProgramId="7" availNum="1" availsExpected="4">
               <scte35:Program><scte35:SpliceTime ptsTime="3783780"/></scte35:Program>
             </scte35:SpliceInsert>
           </scte35:SpliceInfoSection>
         </Event>
       </EventStream>
        .
        .
   </Period>
   ```

1. AWS Elemental MediaPackage inserts the `EventStream`, `Event`, and `scte35` tags with additional information into the manifest and surrounds the ad period with a `Period` tag, as shown in the preceding example\. MediaPackage groups all adaptation sets before the first ad period into a period, and any subsequent adaptation sets after the ad are grouped into a period, until the next SCTE\-35 marker\. Here is a complete manifest example with multiple periods\. It uses `SpliceInsert` SCTE\-35 ad markers:  
**Example**  

   ```
   <?xml version="1.0" encoding="utf-8"?>
   <MPD>
     <Period start="PT0.000S" id="0" duration="PT44.075S">
       <AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
         <Representation id="1" width="960" height="540" frameRate="30000/1001" bandwidth="1000000" codecs="avc1.4D401F">
           <SegmentTemplate timescale="30000" media="index_video_1_0_$Number$.mp4?m=1528413503" initialization="index_video_1_0_init.mp4?m=1528413503" startNumber="6" presentationTimeOffset="0">
             <SegmentTimeline>
               <S t="361301" d="60060" r="15"/>
             </SegmentTimeline>
           </SegmentTemplate>
         </Representation>
       </AdaptationSet>
       <AdaptationSet mimeType="audio/mp4" segmentAlignment="0" lang="eng">
         <Representation id="2" bandwidth="96964" audioSamplingRate="48000" codecs="mp4a.40.2">
           <SegmentTemplate timescale="48000" media="index_audio_2_0_$Number$.mp4?m=1528413503" initialization="index_audio_2_0_init.mp4?m=1528413503" startNumber="6" presentationTimeOffset="0">
             <SegmentTimeline>
               <S t="578305" d="96256" r="3"/>
               <S t="963329" d="95232"/>
               <S t="1058561" d="96256" r="5"/>
               <S t="1636097" d="95232"/>
               <S t="1731329" d="96256" r="3"/>
             </SegmentTimeline>
           </SegmentTemplate>
         </Representation>
       </AdaptationSet>
     </Period>
     <Period start="PT44.075S" id="21">
       <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
         <Event>
           <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="183003" tier="4095">
             <scte35:SpliceInsert spliceEventId="1000" spliceEventCancelIndicator="false" outOfNetworkIndicator="true" spliceImmediateFlag="false" uniqueProgramId="7" availNum="1" availsExpected="4">
               <scte35:Program><scte35:SpliceTime ptsTime="3783780"/></scte35:Program>
             </scte35:SpliceInsert>
           </scte35:SpliceInfoSection>
         </Event>
       </EventStream>
       <AdaptationSet mimeType="video/mp4" segmentAlignment="true" subsegmentAlignment="true" startWithSAP="1" subsegmentStartsWithSAP="1" bitstreamSwitching="true">
         <Representation id="1" width="960" height="540" frameRate="30000/1001" bandwidth="1000000" codecs="avc1.4D401F">
           <SegmentTemplate timescale="30000" media="index_video_1_0_$Number$.mp4?m=1528413503" initialization="index_video_1_0_init.mp4?m=1528413503" startNumber="22" presentationTimeOffset="1322261">
             <SegmentTimeline>
               <S t="1322261" d="60060" r="13"/>
             </SegmentTimeline>
           </SegmentTemplate>
         </Representation>
       </AdaptationSet>
       <AdaptationSet mimeType="audio/mp4" segmentAlignment="0" lang="eng">
         <Representation id="2" bandwidth="96964" audioSamplingRate="48000" codecs="mp4a.40.2">
           <SegmentTemplate timescale="48000" media="index_audio_2_0_$Number$.mp4?m=1528413503" initialization="index_audio_2_0_init.mp4?m=1528413503" startNumber="22" presentationTimeOffset="2115617">
             <SegmentTimeline>
               <S t="2116353" d="96256"/>
               <S t="2212609" d="95232"/>
               <S t="2307841" d="96256" r="5"/>
               <S t="2885377" d="95232"/>
               <S t="2980609" d="96256" r="4"/>
             </SegmentTimeline>
           </SegmentTemplate>
         </Representation>
       </AdaptationSet>
     </Period>
   </MPD>
   ```

   If your input has `TimeSignal` SCTE\-35 ad markers instead of `SpliceInsert`, the EventStream within the ad period looks like this:

   ```
   <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
     <Event>
       <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="183265" tier="4095">
         <scte35:TimeSignal>
           <scte35:SpliceTime ptsTime="1350000"/>
         </scte35:TimeSignal>
         <scte35:SegmentationDescriptor segmentationEventId="1073741825" segmentationEventCancelIndicator="false" segmentationDuration="450000">
           <scte35:DeliveryRestrictions webDeliveryAllowedFlag="false" noRegionalBlackoutFlag="true" archiveAllowedFlag="true" deviceRestrictions="3"/>
           <scte35:SegmentationUpid segmentationUpidType="1" segmentationUpidLength="3" segmentationTypeId="48" segmentNum="0" segmentsExpected="0">012345</scte35:SegmentationUpid>
         </scte35:SegmentationDescriptor>
       </scte35:SpliceInfoSection>
     </Event>
   </EventStream>
   ```

   AWS Elemental MediaPackage also embeds `scte35:SpliceInsert` messages as metadata in the individual video segments\. 

If you're using a downstream ad service, that service looks for the SCTE\-35 markers in the manifest that AWS Elemental MediaPackage provides and inserts ads based on those markers\.