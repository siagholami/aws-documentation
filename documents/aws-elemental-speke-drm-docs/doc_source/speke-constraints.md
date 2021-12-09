# Customizations and Constraints to the DASH\-IF Specification<a name="speke-constraints"></a>

The DASH\-IF CPIX specification, [https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf](https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf), supports a number of use cases and topologies\. The SPEKE API specification adheres to the CPIX specification with the following customizations and constraints:
+ SPEKE follows the Encryptor Consumer workflow\.
+ For encrypted content keys, SPEKE applies the following restrictions: 
  + SPEKE doesn't support digital signature verification \(XMLDSIG\) for request or response payloads\. 
  + SPEKE requires 2048 RSA\-based certificates\.
+ For rotating key workflows, SPEKE requires the `ContentKeyUsageRule` filter, `KeyPeriodFilter`\. SPEKE ignores all other `ContentKeyUsageRule` settings\.
+ SPEKE omits the `UpdateHistoryItemList` functionality\. If the list is present in the response, SPEKE ignores it\. 
+ SPEKE supports key rotation\. SPEKE uses only the `ContentKeyPeriod` `@index` to track the key period\.
+ To support MSS PlayReady, SPEKE uses a custom parameter under the `DRMSystem` tag, `SPEKE:ProtectionHeader`\.
+ For HLS packaging, if the `URIExtXKey` is present in the response, then it must contain the full data to add in the URI parameter of the `EXT-X-KEY` tag of an HLS playlist, with no further signaling requirement\.
+ For HLS playlist, under the `DRMSystem` tag, SPEKE provides the optional custom parameters `speke:KeyFormat` and `speke:KeyFormatVersions`, for the values of the `KEYFORMAT` and `KEYFORMATVERSIONS` parameters of the `EXT-X-KEY` tag\.

  The HLS initialization vector \(IV\) always follows segment number unless explicitly specified by the operator\.
+ When requesting keys, the encryptor might use the optional `@explicitIV` attribute on the `ContentKey` element\. The key provider can respond with an IV using `@explicitIV`, even if the attribute is not included in the request\.
+ The encryptor creates the key identifier \(`KID`\), which stays the same for any given content ID and key period\. The key provider includes the `KID` in its response to the request document\.
+ The key provider might include a value for the `Speke-User-Agent` response header, to identify itself for debugging purposes\.
+ SPEKE does not currently support multiple tracks or keys per content\.

The SPEKE\-compliant encryptor acts as a client and sends `POST` operations to the key provider endpoint\. The encryptor might send a periodic `heartbeat` request to ensure that the connection between the encryptor and the key provider endpoint is healthy\.