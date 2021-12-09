# AWS Elemental MediaConnect concepts and terminology<a name="what-is-concepts"></a>

ARN  
An [Amazon Resource Name](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html), which is a unique identifier for any AWS resource\.

Availability Zone  
A specific location where AWS Cloud computing resources are hosted\. Availability Zones within an AWS Region are connected to each other with low latency, high throughput, and highly redundant networking\. In addition, they are physically separated and isolated from each other\. You can choose to create AWS Elemental MediaConnect flows in different Availability Zones for redundancy\.

AWS Region  
A geographic area where one or more Availability Zones are located\. Each AWS Region is independent from the other Regions\. You can create AWS Elemental MediaConnect flows in different Regions to distribute content to receivers in different locations around the world\. For more information about AWS Regions and their Availability Zones, see [AWS Global Infrastructure](https://aws.amazon.com/about-aws/global-infrastructure/)\.

Contribution encoder  
An encoder that receives a live video feed and encodes the stream into a single, high\-quality mezzanine stream for transportation or further processing into an adaptive bitrate \(ABR\) stream\.

Distribution  
The result of creating outputs that point to AWS Elemental MediaConnect flows in other AWS Regions, for the purpose of delivering content to different geographical locations\.

Entitlement  
A permission that is granted to allow an AWS account to access the content in a specific AWS Elemental MediaConnect flow\. The content originator grants an entitlement to a specific AWS account \(the subscriber\)\. Once an entitlement is granted, the subscriber can create a flow using the originator's flow as the source\. Each flow can have up to 50 entitlements\. 

Flow  
A connection between one or more video sources and one or more outputs\. For each flow, you specify the transport protocol to use, encryption information, and details for any outputs or entitlements that you want\. AWS Elemental MediaConnect returns an ingest endpoint where you can send your live video as a single unicast stream\. The service replicates and distributes the video to every output that you specify, whether inside or outside the AWS Cloud\. You can also set up entitlements on a flow to allow other AWS accounts to access your content\.

Mezzanine stream  
A lightly compressed video stream that takes up less space than a full resolution uncompressed stream\. The quality of a mezzanine stream is high enough to use as a source for creating final encodes that are delivered to consumer devices\. 

Originator account  
An AWS account that was used to create a flow with at least one entitlement\.

Output  
The destination address, protocol, and port that AWS Elemental MediaConnect sends the ingested video to\. Each flow can have up to 50 outputs\. An output can have the same protocol or a different protocol from the source\.

Policy  
An [IAM policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html), which is used to manage access in AWS\. 

Protocol  
A set of rules used for file transmission\. AWS Elemental MediaConnect provides protocol options \(such as Zixi, RTP, and RTP\-FEC\) that implement a quality of service \(QoS\) layer to enable the service to work with mezzanine\-quality live video\.

Receiver  
The recipient of a stream from AWS Elemental MediaConnect\. A receiver is any entity, inside or outside of the AWS Cloud, that can receive RTP or Zixi streams\. This might be an affiliate, a cloud encoder, or another MediaConnect flow\.

Replication  
The result of creating a flow with more than one output\. The source is replicated to produce multiple outputs\. Replication is useful when you want to distribute your video streams to multiple workflows within your own account or share your content with other AWS accounts\. 

Resource  
An entity in AWS that you can work with\. Each AWS resource is assigned an Amazon Resource Name \(ARN\) that acts as a unique identifier\. In AWS Elemental MediaConnect, these are the resources and their ARN formats:   
+ Entitlement: `aws:mediaconnect:region:account-id:entitlement:resourceID:resourceName`
+ Flow: `aws:mediaconnect:region:account-id:flow:resourceID:resourceName`
+ Output: `aws:mediaconnect:region:account-id:output:resourceID:resourceName`
+ Source: `aws:mediaconnect:region:account-id:source:resourceID:resourceName`

Sharing  
Allowing another AWS account to access the content of your flow\. To share your content, you \(the originator\) grant an entitlement to another AWS account \(the subscriber\)\.

Source  
External video content that includes configuration information \(encryption and source type\) and a network address\. Each flow has at least one source\. A standard source comes from a source other than another AWS Elemental MediaConnect flow, such as an on\-premises encoder\. An entitled source comes from an AWS Elemental MediaConnect flow that is owned by another AWS account and has granted an entitlement to your account\.

Subscriber account  
An AWS account that been granted access to content from an AWS Elemental MediaConnect flow that is owned by another AWS account \(the originator account\)\. This permission is granted when the originator sets up an entitlement for the subscriber\. The entitlement permits the subscriber to create a flow that uses the originator's content as the source\.

Whitelisting  
Allowing a block of Classless Inter\-Domain Routing \(CIDR\) IP addresses to serve as a source to your AWS Elemental MediaConnect flow\.