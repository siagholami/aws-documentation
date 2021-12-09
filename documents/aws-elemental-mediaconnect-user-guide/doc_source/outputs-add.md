# Adding outputs to a flow<a name="outputs-add"></a>

You can add up to 50 outputs for each flow\. Every output must have a name, a protocol, an IP address, and a port\.

**Note**  
If you intend to set up an entitlement for an output, don't create the output\. Instead, [grant an entitlement](entitlements-grant.md)\. When the subscriber creates a flow using your content as the source, the service creates an output on your flow\.

The method you use to add an output to a flow is dependent on the type of output that you want to add:
+ [Standard output](outputs-add-standard.md) – Sends content to any destination that is not a virtual private cloud \(VPC\) that you configured using Amazon Virtual Private Cloud\.
+ [VPC output](outputs-add-vpc.md) – Sends content to a VPC that you configured using Amazon Virtual Private Cloud\.