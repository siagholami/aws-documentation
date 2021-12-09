# Firewall and Network Requirements<a name="firewall-network"></a>

To join meetings and make calls from your Echo devices, you must have the following ports and protocols:


| Service | Protocol | Destination Port | Transport | 
| --- | --- | --- | --- | 
| Signaling | HTTPS | 443 | TCP | 
| Media port/connectivity negotiation | ICE/STUN/TURN | 3478 | TCP/UDP UDP is preferred\. Only open TCP 3478 if UDP 3478 isn't allowed\.  | 
| Conference or PSTN calling audio G\.711 audio codec  | SRTP | 49152 \- 65535 | UDP | 