# VOD Workflow Method Call Examples<a name="vod-workflow-methods"></a>

*Request Syntax Example*

The following URL is an example and does not indicate a fixed format\.

```
POST https://speke-compatible-server/speke/v1.0/copyProtection
```

*Request Body*

A CPIX element\.

*Response Headers*


| Name | Type | Occurs | Description | 
| --- | --- | --- | --- | 
| Speke\-User\-Agent | String | 1\.\.1 | String that identifies the key provider | 
| Content\-Type | String | 1\.\.1 | application/xml | 

*Request Response*


| HTTP CODE | Payload Name | Occurs | Description | 
| --- | --- | --- | --- | 
| 200 \(Success\) | CPIX | 1\.\.1 | DASH\-CPIX payload response | 
| 4XX \(Client error\) | Client error message | 1\.\.1 | Description of the client error | 
| 5XX \(Server error\) | Server error message | 1\.\.1 | Description of the server error | 

**Note**  
The examples in this section do not include content key encryption\. For information on how to add content key encryption, see [Content Key Encryption](content-key-encryption.md)\. 

*VOD Example Request Payload with Keys in the Clear*

The following example shows a basic VOD request payload from the encryptor to the DRM key provider: 

```
<cpix:CPIX id="abc123" xmlns:cpix="urn:dashif:org:cpix" xmlns:pskc="urn:ietf:params:xml:ns:keyprov:pskc" xmlns:speke="urn:aws:amazon:com:speke">
	<cpix:ContentKeyList>
		<cpix:ContentKey kid="98ee5596-cd3e-a20d-163a-e382420c6eff" explicitIV="OFj2IjCsPJFfMAxmQxLGPw=="></cpix:ContentKey>
	</cpix:ContentKeyList>
	<cpix:DRMSystemList>
		<!-- HLS AES-128 (systemId is implementation specific)-->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="81376844-f976-481e-a84e-cc25d39b0b33">
			<cpix:URIExtXKey></cpix:URIExtXKey>
			<speke:KeyFormat></speke:KeyFormat>
			<speke:KeyFormatVersions></speke:KeyFormatVersions>
		</cpix:DRMSystem>
		
		<!-- HLS SAMPLE-AES -->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="94ce86fb-07ff-4f43-adb8-93d2fa968ca2">
			<cpix:URIExtXKey></cpix:URIExtXKey>
			<speke:KeyFormat></speke:KeyFormat>
			<speke:KeyFormatVersions></speke:KeyFormatVersions>
		</cpix:DRMSystem>
		
		<!-- Common encryption (Widevine)-->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="edef8ba9-79d6-4ace-a3c8-27dcd51d21ed">
			<cpix:PSSH></cpix:PSSH>
		</cpix:DRMSystem>
		
		<!-- Common encryption / MSS (Playready) -->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="9a04f079-9840-4286-ab92-e65be0885f95">
			<speke:ProtectionHeader></speke:ProtectionHeader>
			<cpix:PSSH></cpix:PSSH>
		</cpix:DRMSystem>
	</cpix:DRMSystemList>
    </cpix:CPIX>
```

*VOD Example Response Payload with Keys in the Clear*

The following example shows a basic VOD response payload from the DRM key provider:

```
<cpix:CPIX xmlns:cpix="urn:dashif:org:cpix" xmlns:pskc="urn:ietf:params:xml:ns:keyprov:pskc" xmlns:speke="urn:aws:amazon:com:speke" id="abc123">
	<cpix:ContentKeyList>
		<cpix:ContentKey explicitIV="OFj2IjCsPJFfMAxmQxLGPw==" kid="98ee5596-cd3e-a20d-163a-e382420c6eff">
			<cpix:Data>
				<pskc:Secret>
					<pskc:PlainValue>5dGAgwGuUYu4dHeHtNlxJw==</pskc:PlainValue>
				</pskc:Secret>
			</cpix:Data>
		</cpix:ContentKey>
	</cpix:ContentKeyList>
	<cpix:DRMSystemList>
		<!-- HLS AES-128 (systemId is implementation specific) -->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="81376844-f976-481e-a84e-cc25d39b0b33">
			<cpix:URIExtXKey>aHR0cHM6Ly83azR5dHV4cTVkLmV4ZWN1dGUtYXBpLnVzLXdlc3QtMi5hbWF6b25hd3MuY29tL0VrZVN0YWdlL2NsaWVudC9hYmMxMjMvOThlZTU1OTYtY2QzZS1hMjBkLTE2M2EtZTM4MjQyMGM2ZWZm</cpix:URIExtXKey>
			<speke:KeyFormat>aWRlbnRpdHk=</speke:KeyFormat>
			<speke:KeyFormatVersions>MQ==</speke:KeyFormatVersions>
		</cpix:DRMSystem>
		
		<!-- HLS SAMPLE-AES -->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="94ce86fb-07ff-4f43-adb8-93d2fa968ca2">
			<cpix:URIExtXKey>aHR0cHM6Ly83azR5dHV4cTVkLmV4ZWN1dGUtYXBpLnVzLXdlc3QtMi5hbWF6b25hd3MuY29tL0VrZVN0YWdlL2NsaWVudC9hYmMxMjMvOThlZTU1OTYtY2QzZS1hMjBkLTE2M2EtZTM4MjQyMGM2ZWZm</cpix:URIExtXKey>
			<speke:KeyFormat>Y29tLmFwcGxlLnN0cmVhbWluZ2tleWRlbGl2ZXJ5</speke:KeyFormat>
			<speke:KeyFormatVersions>MQ==</speke:KeyFormatVersions>
		</cpix:DRMSystem>
		
		<!-- Common encryption (Widevine) -->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="edef8ba9-79d6-4ace-a3c8-27dcd51d21ed">
			<cpix:PSSH>AAAAanBzc2gAAAAA7e+LqXnWSs6jyCfc1R0h7QAAAEoIARIQeSIcblaNbb7Dji6sAtKZzRoNd2lkZXZpbmVfdGVzdCIfa2V5LWlkOmVTSWNibGFOYmI3RGppNnNBdEtaelE9PSoCU0QyAA==</cpix:PSSH>
		</cpix:DRMSystem>
		
		<!-- Common encryption / MSS (Playready) -->
		<cpix:DRMSystem kid="98ee5596-cd3e-a20d-163a-e382420c6eff" systemId="9a04f079-9840-4286-ab92-e65be0885f95">
			<speke:ProtectionHeader>CgMAAAEAAQAAAzwAVwBSAE0ASABFAEEARABFAFIAIAB4AG0AbABuAHMAPQAiAGgAdAB0AHAAOgAvAC8AcwBjAGgAZQBtAGEAcwAuAG0AaQBjAHIAbwBzAG8AZgB0AC4AYwBvAG0ALwBEAFIATQAvADIAMAAwADcALwAwADMALwBQAGwAYQB5AFIAZQBhAGQAeQBIAGUAYQBkAGUAcgAiACAAdgBlAHIAcwBpAG8AbgA9ACIANAAuADAALgAwAC4AMAAiAD4APABEAEEAVABBAD4APABQAFIATwBUAEUAQwBUAEkATgBGAE8APgA8AEsARQBZAEwARQBOAD4AMQA2ADwALwBLAEUAWQBMAEUATgA+ADwAQQBMAEcASQBEAD4AQQBFAFMAQwBUAFIAPAAvAEEATABHAEkARAA+ADwALwBQAFIATwBUAEUAQwBUAEkATgBGAE8APgA8AEsASQBEAD4ATwBXAGoAaAB0AHIAMwB1ADkAawArAHIAZABvADEASQBMAFkAMAByAGEAdwA9AD0APAAvAEsASQBEAD4APABDAEgARQBDAEsAUwBVAE0APgBCADMAQQA2AEEAMwB4AG0AdABkAEkAPQA8AC8AQwBIAEUAQwBLAFMAVQBNAD4APABMAEEAXwBVAFIATAA+AGgAdAB0AHAAOgAvAC8AcABsAGEAeQByAGUAYQBkAHkALgBkAGkAcgBlAGMAdAB0AGEAcABzAC4AbgBlAHQALwBwAHIALwBzAHYAYwAvAHIAaQBnAGgAdABzAG0AYQBuAGEAZwBlAHIALgBhAHMAbQB4AD8AUABsAGEAeQBSAGkAZwBoAHQAPQAxACYAYQBtAHAAOwBhAG0AcAA7AGEAbQBwADsAVQBzAGUAUwBpAG0AcABsAGUATgBvAG4AUABlAHIAcwBpAHMAdABlAG4AdABMAGkAYwBlAG4AcwBlAD0AMQA8AC8ATABBAF8AVQBSAEwAPgA8AC8ARABBAFQAQQA+ADwALwBXAFIATQBIAEUAQQBEAEUAUgA+AA==</speke:ProtectionHeader>
			<cpix:PSSH>AAADMHBzc2gAAAAAmgTweZhAQoarkuZb4IhflQAAAxAQAwAAAQABAAYDPABXAFIATQBIAEUAQQBEAEUAUgAgAHgAbQBsAG4AcwA9ACIAaAB0AHQAcAA6AC8ALwBzAGMAaABlAG0AYQBzAC4AbQBpAGMAcgBvAHMAbwBmAHQALgBjAG8AbQAvAEQAUgBNAC8AMgAwADAANwAvADAAMwAvAFAAbABhAHkAUgBlAGEAZAB5AEgAZQBhAGQAZQByACIAIAB2AGUAcgBzAGkAbwBuAD0AIgA0AC4AMAAuADAALgAwACIAPgA8AEQAQQBUAEEAPgA8AFAAUgBPAFQARQBDAFQASQBOAEYATwA+ADwASwBFAFkATABFAE4APgAxADYAPAAvAEsARQBZAEwARQBOAD4APABBAEwARwBJAEQAPgBBAEUAUwBDAFQAUgA8AC8AQQBMAEcASQBEAD4APAAvAFAAUgBPAFQARQBDAFQASQBOAEYATwA+ADwASwBJAEQAPgBiAGgAdwBpAGUAWQAxAFcAdgBtADMARABqAGkANgBzAEEAdABLAFoAegBRAD0APQA8AC8ASwBJAEQAPgA8AEMASABFAEMASwBTAFUATQA+AGEAVABtAFAASgBWAEMAVgBaADYAcwA9ADwALwBDAEgARQBDAEsAUwBVAE0APgA8AEwAQQBfAFUAUgBMAD4AaAB0AHQAcABzADoALwAvAHAAcgBsAHMALgBhAHQAdgAtAHAAcwAuAGEAbQBhAHoAbwBuAC4AYwBvAG0ALwBjAGQAcAA8AC8ATABBAF8AVQBSAEwAPgA8AEMAVQBTAFQATwBNAEEAVABUAFIASQBCAFUAVABFAFMAPgA8AEkASQBTAF8ARABSAE0AXwBWAEUAUgBTAEkATwBOAD4ANwAuADEALgAxADQAMwA5AC4AMAA8AC8ASQBJAFMAXwBEAFIATQBfAFYARQBSAFMASQBPAE4APgA8AC8AQwBVAFMAVABPAE0AQQBUAFQAUgBJAEIAVQBUAEUAUwA+ADwALwBEAEEAVABBAD4APAAvAFcAUgBNAEgARQBBAEQARQBSAD4A</cpix:PSSH>
		</cpix:DRMSystem>
	</cpix:DRMSystemList>
</cpix:CPIX>
```