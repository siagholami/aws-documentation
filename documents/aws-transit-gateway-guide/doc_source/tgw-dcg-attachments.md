# Transit gateway attachments to a Direct Connect gateway<a name="tgw-dcg-attachments"></a>

Attach a transit gateway to a Direct Connect gateway using a transit virtual interface\. This configuration offers the following benefits\. You can:
+ Manage a single connection for multiple VPCs or VPNs that are in the same Region\.
+ Advertise prefixes from on\-premises to AWS and from AWS to on\-premises\.

The following diagram illustrates how the Direct Connect gateway enables you to create a single connection to your Direct Connect connection that all of your VPCs can use\.

![\[Direct Connect Gateway Connected to Transit Gateway\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/direct-connect-tgw.png)

The solution involves the following components:
+ A transit gateway\.
+ A Direct Connect gateway\.
+ An association between the Direct Connect gateway and the transit gateway\.
+ A transit virtual interface that is attached to the Direct Connect gateway\.

For information about configuring Direct Connect gateways with transit gateways, see [Transit gateway associations](https://docs.aws.amazon.com/directconnect/latest/UserGuide/direct-connect-transit-gateways.html) in the *AWS Direct Connect User Guide*\.