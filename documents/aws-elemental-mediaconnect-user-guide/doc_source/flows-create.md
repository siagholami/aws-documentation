# Creating a flow<a name="flows-create"></a>

A flow consists of one source, a name, and an Availability Zone\. The ability to choose an Availability Zone allows you to create multiple flows within an AWS Region for redundancy\. After you create a flow, you can add up to 50 outputs and up to 50 entitlements\.

The method that you use to create a flow is dependent on the type of source that you want to use for your flow:
+ [Standard source](flows-create-standard-source.md) – Uses content from any source that is not a VPC source or an entitled source\.
+ [VPC source](flows-create-vpc-source.md) – Uses content that comes from a VPC that you configure\.
+ [Entitled source](flows-create-entitled-source.md) – Uses content that is owned by another AWS account that has granted an entitlement to your account\. 

**Note**  
If you want to create a flow that uses redundant sources for failover, create the flow with one of the sources\. After the flow is created, [add the other source](source-adding.md)\. Because MediaConnect treats both sources as the primary source, it doesn't matter which one you specify when you first create the flow\. If your flow uses an entitled source, you can't add a second source\.