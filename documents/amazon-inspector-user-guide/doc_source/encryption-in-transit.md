# Encryption of data in transit<a name="encryption-in-transit"></a>

During an assessment, the agent gathers telemetry data from the system to send back to Amazon Inspector over a TLS\-protected channel\.

Clients must support Transport Layer Security \(TLS\) 1\.0 or later\. We recommend TLS 1\.2 or later\. Clients must also support cipher suites with perfect forward secrecy \(PFS\) such as Ephemeral Diffie\-Hellman \(DHE\) or Elliptic Curve Ephemeral Diffie\-Hellman \(ECDHE\)\. Most modern systems such as Java 7 and later support these modes\.