# Distributing content using AWS Elemental MediaConnect<a name="distribute-content"></a>

You can use AWS Elemental MediaConnect to distribute content to different geographical locations\. For example, suppose that your source is an on\-premises contribution encoder that is located in Portland, Oregon and you want to distribute your content to locations around the world\. You set up your initial AWS Elemental MediaConnect flow in the `us-west-1` Region, which is the closest physical AWS Region to your encoder\. After your content is in the AWS Cloud, you send it to other MediaConnect flows located in Regions that are closer to your receivers\.

The following illustration shows an on\-premises contribution encoder located in Portland, Oregon that uploads content to AWS Elemental MediaConnect in the AWS Cloud\. The flow has three outputs that send content to others flows in different AWS Regions\. These secondary flows are closer to the receivers, which are located in various cities around the world\.

![\[This illustration shows an on-premises contribution encoder located in Portland, Oregon that uploads content to AWS Elemental MediaConnect in the AWS Cloud. The flow has three outputs that send content to others flows in different AWS Regions. These secondary flows are closer to the receivers, which are located in various cities around the world.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)

**Topics**
+ [Distributing content across Regions](distribution-across-regions.md)
+ [Distributing content to AWS Elemental MediaLive](distribution-to-medialive.md)
+ [Distributing content from an AWS Elemental MediaLive Multiplex](distribution-from-medialive.md)