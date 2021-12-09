# Distributing content from an AWS Elemental MediaLive Multiplex<a name="distribution-from-medialive"></a>

An AWS Elemental MediaLive [multiplex](https://docs.aws.amazon.com/medialive/latest/ug/eml-multiplex.html) creates a UDP transport stream \(TS\) that carries multiple programs, also known as a multi\-program transport stream \(MPTS\)\. When you create a multiplex, MediaLive automatically grants an entitlement in MediaConnect for your account\. Create a flow based on that entitlement and distribute the content from that flow\.

**To distribute content from a MediaLive multiplex \(console\)**

1. In MediaLive, [create a multiplex](https://docs.aws.amazon.com/medialive/latest/ug/multiplex-create.html)\.

   MediaLive creates a MediaConnect entitlement that uses the multiplex as the source\. The name of the entitlement includes `multiplex` and the name you chose for the multiplex\.

1. In MediaConnect, [create a flow based on the new entitlement](entitlements-subscriber.md)\.

1. [Add outputs](outputs-add.md) to distribute the content\.