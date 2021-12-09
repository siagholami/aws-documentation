# Device communication protocols<a name="protocols"></a><a name="iot-message-broker"></a>

AWS IoT Core supports devices and clients that use the MQTT and the MQTT over WebSocket Secure \(WSS\) protocols to publish and subscribe to messages, and devices and clients that use the HTTPS protocol to publish messages\. All protocols support IPv4 and IPv6\. This section describes the different connection options for devices and clients\.

AWS IoT Core uses [TLS](https://en.wikipedia.org/wiki/Transport_Layer_Security) [version 1\.2](https://en.wikipedia.org/wiki/Transport_Layer_Security#TLS_1.2) to encrypt all communication\. For more information, see [Transport security in AWS IoT](transport-security.md)\.<a name="protocol-port-mapping"></a>

**Protocols, port mappings, and authentication**  
How a device or client connects to the message broker by using a device endpoint depends on the protocol it uses\. The following table lists the protocols that the AWS IoT device endpoints support and the authentication methods and ports they use\.


**Protocols, authentication, and port mappings**  

| Protocol | Operations supported | Authentication | Port | ALPN protocol name | 
| --- | --- | --- | --- | --- | 
|  MQTT over WebSocket  | Publish, Subscribe | Signature Version 4 | 443 |  N/A  | 
|  MQTT over WebSocket  | Publish, Subscribe | Custom authentication | 443 |  N/A  | 
|  MQTT  | Publish, Subscribe |  X\.509 client certificate  |  443†  |  `x-amzn-mqtt-ca`  | 
| MQTT | Publish, Subscribe | X\.509 client certificate | 8883 | N/A | 
|  MQTT  | Publish, Subscribe |  Custom authentication  |  443†  |  `mqtt`  | 
|  HTTPS  | Publish only |  Signature Version 4  |  443  |  N/A  | 
|  HTTPS  | Publish only |  X\.509 client certificate  |  443†  |  `x-amzn-http-ca`  | 
| HTTPS | Publish only | X\.509 client certificate | 8443 | N/A | 
| HTTPS | Publish only | Custom authentication | 443 | N/A | 

†Clients that connect on port 443 with X\.509 client certificate authentication must implement the [Application Layer Protocol Negotiation \(ALPN\)](https://tools.ietf.org/html/rfc7301) TLS extension and use the [ALPN protocol name](https://tools.ietf.org/html/rfc7301#section-3.1) listed in the ALPN ProtocolNameList sent by the client as part of the `ClientHello` message\. Clients must also send the [Server Name Indication \(SNI\) TLS extension](https://tools.ietf.org/html/rfc3546#section-3.1)\. Connection attempts that don't include the SNI are refused\. For more information, see [Transport Security in AWS IoT](transport-security.html)\. 

**Note**  
The [AWS IoT Device SDKs](iot-connect-devices.md#iot-connect-device-sdks) support MQTT and MQTT over WSS and they support the security requirements of client connections\. We recommend using the [AWS IoT Device SDKs](iot-connect-devices.md#iot-connect-device-sdks) to connect clients to AWS IoT\.

Clients connect to their AWS account's device endpoints\. See [AWS IoT device data and service endpoints](iot-connect-devices.md#iot-connect-device-endpoints) for information about how to find your account's device endpoints\.


**Connecting to AWS IoT Core**  

|  Protocol  |  Endpoint or URL  | 
| --- | --- | 
|  MQTT  |  `iot-endpoint`  | 
|  MQTT over WSS  |  `wss://iot-endpoint/mqtt`  | 
|  HTTPS  |  `https://iot-endpoint/topics`  | 

## Choosing a protocol for your device communication<a name="protocol-selection"></a>

For most IoT device communication through the device endpoints, you'll want to use the MQTT or MQTT over WSS protocols; however, the device endpoints also support HTTPS\. The following table compares how AWS IoT Core uses the two protocols for device communication\.


**AWS IoT device protocols side\-by\-side**  

|  Feature  |  [MQTT](mqtt.md)  |  [HTTPS](http.md)  | 
| --- | --- | --- | 
|  Publish/Subscribe support  |  Publish and subscribe  |  Publish only  | 
|  SDK support  |  [AWS Device SDKs](iot-connect-devices.md#iot-connect-device-sdks) support MQTT and WSS protocols  |  No SDK support, but you can use language\-specific methods to make HTTPS requests  | 
|  Quality of Service support  |  [MQTT QoS levels 0 and 1](mqtt.md#mqtt-qos)  |  No QoS support  | 
| Can receive messages missed while device was offline | Yes | No | 
|  `clientId` field support  |  Yes  |  No  | 
|  Device disconnection detection  |  Yes  |  No  | 
|  Secure communications  |  Yes\. See [Protocols, port mappings, and authentication](#protocol-port-mapping)  |  Yes\. See [Protocols, port mappings, and authentication](#protocol-port-mapping)  | 
| Duration of connection | Up to several weeks | Up to 24 hours | 
|  Topic definitions  |  Application defined  |  Application defined  | 
|  Message data format  |  Application defined  |  Application defined  | 
| Protocol overhead | Lower | Higher | 
| Power consumption | Lower | Higher | 