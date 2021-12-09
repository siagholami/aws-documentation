# Sources in AWS Elemental MediaConnect<a name="sources"></a>

Each AWS Elemental MediaConnect flow has at least one source and as many as two sources\. When you create a flow, you specify the source name, protocol, whitelist, and ingest port\. A source can be anything that provides a live video feed, such as the following:
+ An on\-premises encoder
+ Another AWS Elemental MediaConnect flow
+ An AWS Elemental MediaLive output
+ A playout system \(cloud\-based or on\-premises\)

From the MediaConnect console, you can view Amazon CloudWatch metrics to [monitor the source health](monitor-source-health.md) of an active flow\.

**Topics**
+ [Source failover](source-failover.md)
+ [Adding a source to an existing flow](source-adding.md)
+ [Updating the source of a flow](source-update.md)
+ [Removing a source from a flow](source-remove.md)
+ [Source ports](source-ports.md)