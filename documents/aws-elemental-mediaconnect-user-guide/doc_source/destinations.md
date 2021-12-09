# Output destinations<a name="destinations"></a>

Each output on a flow must be sent to a different destination\. The parameters that define the destination depend on the protocol, but every protocol uses a compound identifier for the destination\. For example, multiple outputs can point to the same destination IP address, as long as none of their ports overlap\. Likewise, multiple outputs can point to the same stream ID as long as their remote IDs are different\. The following table lists how each protocol defines the destination\.

**Note**  
Some protocols require additional ports for error correction\. For outputs that use these protocols, AWS Elemental MediaConnect automatically reserves the additional ports\. The protocol defines specifically which ports must be reserved\. For example, some protocols require port\+2 and port\+4 for error correction\. If you specify port 5000 for the output, the service assigns ports 5000, 5002, and 5004\.


****  

| Protocol | Destination Definition | Ports Required | 
| --- | --- | --- | 
| RIST | IP address, port, and port\+1 |  The port that you specify, plus one additional port\. The service automatically reserves a port that is \+1 from the port that you specified\. For example, if you specify port 3000 for this output, the service also reserves port 3001\.  | 
| RTP | IP address and port | The port that you specify\. This is the only port needed for the output\. | 
| RTP\-FEC | IP address, port, port\+2, and port\+4 |  The port that you specify, plus two additional ports\. The service automatically reserves ports that are \+2 and \+4 from the port that you specified\. For example, if you specify port 2000 for this output, the service also reserves ports 2002 and 2004 for error correction\.  | 
| Zixi pull | Stream ID and remote ID | The service automatically uses port 2077 for these outputs\. | 
| Zixi push | IP address, stream ID, and port | The port that you specify is the only port needed for the output\. | 