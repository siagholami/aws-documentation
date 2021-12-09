# Creating a flow that uses an entitled source<a name="flows-create-entitled-source"></a>

A flow consists of one source, a name, and an Availability Zone\. The ability to choose an Availability Zone allows you to create multiple flows within an AWS Region for redundancy\. After you create a flow, you can add up to 50 outputs and up to 50 entitlements\.

**To create a flow that uses an entitled source \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose **Create flow**\.

1. In the **Details** section, for **Name**, specify a name for your flow\. This name will become part of the ARN for this flow\.
**Note**  
MediaConnect allows you to create multiple flows with the same name\. However, we encourage you to use unique flow names within an AWS Region to help with organization\. After you create a flow, you can't change the name\.

1. For **Availability Zone**, choose an Availability Zone for your flow\. Use this option when you are setting up redundant flows\. Otherwise, you can leave this as **Any**\. If you leave the default, the service will randomly assign an Availability Zone within the current AWS Region , or if your source comes from a VPC, the service will assign the Availability Zone of the VPC subnet to the flow\.
**Note**  
If your source comes from your VPC, the Availability Zone of your flow must match that of your VPC subnet\. We recommend that you leave this as **Any** and let the service ensure that the Availability Zone is set correctly\.

1. In the **Source** section, for **Source type** choose **Entitled source**\.

1. For **Entitlement ARN**, choose the appropriate entitlement\. This list includes all entitlements that have been granted to you\.
**Tip**  
You can click in this field and start entering the entitlement name\. MediaConnect will filter the list to include only entitlements with a name that matches what you enter\.

1. Choose **Create flow**\.
**Note**  
The flow doesn't start automatically\. You must [start the flow](flows-start.md) manually\.

1. [Add outputs](outputs-add.md) to specify where you want MediaConnect to send the content, or [grant entitlements](entitlements-grant.md) to allow users of other AWS accounts to subscribe to your content\.