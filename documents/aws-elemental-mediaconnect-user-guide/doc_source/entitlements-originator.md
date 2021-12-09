# Sharing content with other AWS accounts<a name="entitlements-originator"></a>

You can grant an entitlement to share the content in your AWS Elemental MediaConnect flow with another AWS account \(subscriber account\)\. When the subscriber sets up a flow based on the entitlement, the service generates an output on your flow to represent the stream from your flow to the subscriber's flow\. This output is counted as part of the 50 maximum outputs that you can have on your flow\. 

You can grant, update, and revoke entitlements at any time, even on an active flow\. If you want to stop streaming content to the subscriber’s flow on a temporary basis, you can disable the entitlement\. Later, you can enable the entitlement when you're ready to allow content to stream to the subscriber's flow again\. You can also specify the percentage of the entitlement data transfer fee that you want the subscriber to be responsible for\.

**Note**  
If you grant an entitlement and later [disable](entitlements-disable.md) it \(to temporarily stop streaming content to the subscriber’s flow\), the entitlement remains associated with your flow and counts toward your maximum number of entitlements\. However, if you [revoke](entitlements-revoke.md) the entitlement \(to permanently stop streaming content to the subscriber’s flow\), the entitlement is removed from your flow and no longer counts toward the maximum number of entitlements\.

After you grant an entitlement, you provide information about the entitlement \(name, AWS Region, and encryption details\) to the subscriber\. The subscriber uses this information to create a MediaConnect flow that uses your flow as the source\. The subscriber's flow must be in the same AWS Region as your flow\. If the subscriber wants a flow in a different Region, they must create a second flow in the new Region\. The following illustration shows this process\.

![\[This illustration shows the setup for sharing content across AWS Regions.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)

**Topics**
+ [Granting an entitlement on a flow](entitlements-grant.md)
+ [Updating an entitlement](entitlements-update.md)
+ [Managing tags on an entitlement](entitlements-manage-tags.md)
+ [Revoking an entitlement](entitlements-revoke.md)
+ [Disabling an entitlement temporarily](entitlements-disable.md)
+ [Enabling an entitlement that has been temporarily disabled](entitlements-enable.md)