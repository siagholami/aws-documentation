# Disconnect<a name="kvswebrtc-websocket-apis6"></a>

A client can close a connection at any time\. WebSocket\-compliant libraries support close functionality\. When the connection is closed, service marks the client as offline for the specific signaling channel and does not try to deliver any messages\. The same behavior also applies in the event of idle connection timeout\.

Service also sends disconnect indications to the client, for example, during deployments or server maintenance\. The following are the defined indication messages:
+ **GO\_AWAY**: This message is used to initiate the connection shutdown\. It enables a client to gracefully process previous messages, disconnect, and reconnect to the signaling channel if needed\. 
+ **RECONNECT\_ICE\_SERVER**: This message is used to initiate the relay connection shutdown and enables a client to gracefully disconnect, obtain a new ICE server configuration, and reconnect to the relay servers if needed\.