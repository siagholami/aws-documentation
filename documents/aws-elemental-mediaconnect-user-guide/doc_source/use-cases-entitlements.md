# Use case: entitlements<a name="use-cases-entitlements"></a>

Entitlements allow one AWS account holder to share content with other AWS account holders\. For example, a sports company wants to share a flow \(Baseball\-Game\) with a local TV station\. A sports broadcaster \(the originator\) creates an entitlement on the Baseball\-Game flow to allow access for the local TV station \(the subscriber\)\. The local TV station creates an AWS Elemental MediaConnect flow using an output from the Baseball\-Game flow as the source\.

The subscriber must set up their flow in AWS Elemental MediaConnect in the same Region as the originator's flow\. 

This following illustration shows how to share content with another AWS subscriber\. The output of the originator's flow can be used as the source of the subscriber's flow\.

![\[This illustration shows how to share content with another AWS subscriber. The output of the originator's flow can be used as the source of the subscriber's flow.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)