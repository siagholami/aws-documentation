# Source ports<a name="source-ports"></a>

Each source on a flow must use a different port\. \(The exception is sources that use the Zixi protocol\. Those sources all use port 2088\.\) Some protocols require additional ports for error correction\. For sources that use these protocols, AWS Elemental MediaConnect automatically reserves the additional ports that are needed\. The following table lists which additional ports, if any, the service reserves\.


****  

| Protocol | Ports Needed | Ports Required | 
| --- | --- | --- | 
| RIST | Port and port\+1 |  The port that you specify, plus one additional port\. MediaConnect automatically reserves a port that is \+1 from the port that you specified\. For example, if you specify port 3000 for this output, the service also reserves port 3001\.  | 
| RTP | Port | The port that you specify\. This is the only port needed for the output\. | 
| RTP\-FEC | Port, port\+2, and port\+4 |  The port that you specify, plus two additional ports\. MediaConnect automatically reserves ports that are \+2 and \+4 from the port that you specified\. For example, if you specify port 2000 for this output, the service also reserves ports 2002 and 2004 for error correction\.  | 
| Zixi push | Port \(2088\) | MediaConnect automatically uses port 2088 for these outputs\. | 