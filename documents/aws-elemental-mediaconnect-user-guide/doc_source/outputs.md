# Outputs in AWS Elemental MediaConnect<a name="outputs"></a>

Each flow can have up to 50 outputs\. You can add and remove outputs at any time, even when the flow is active\. These outputs are sent to the IP address that you specify\. This option is useful if you intend to send your content to an on\-premises encoder\.

Another way that you can add outputs to a flow is from an entitlement\. You can [grant an entitlement](entitlements-grant.md) to share your content with another AWS account \(subscriber account\)\. When the subscriber creates a flow using your content as the source, AWS Elemental MediaConnect generates an output on your flow\.

**Note**  
If you [disable](entitlements-disable.md) an entitlement after the subscriber creates a flow based on that entitlement, the associated output remains on your flow\. This output continues to counts toward your maximum number of outputs\. To delete an output that's associated with an entitlement, [revoke](entitlements-revoke.md) the entitlement\.

**Topics**
+ [Adding outputs to a flow](outputs-add.md)
+ [Viewing a list of outputs of a flow](outputs-view-list.md)
+ [Updating outputs on a flow](outputs-update.md)
+ [Managing tags on an output](outputs-manage-tags.md)
+ [Removing outputs from a flow](outputs-remove.md)
+ [Output destinations](destinations.md)