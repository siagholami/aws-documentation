# Subscribing to content provided by another AWS account<a name="entitlements-subscriber"></a>

When another AWS account \(originator account\) grants an entitlement to your AWS account \(subscriber account\), you can create a flow that uses the originator's content as your source\. To subscribe to content provided by another AWS account, you create a flow based on the entitlement granted to you\. You must set up your flow in the same AWS Region as the originator's flow\.

You can use an entitlement only once\.

**Prerequisites**  
Before you can create your flow, you must do the following:
+ Obtain the following information from the content originator:
  + The entitlement ARN
  + The AWS Region that the originator created the flow in
  + The encryption key and algorithm if the originator set up encryption on the entitlement
+ If the entitlement is encrypted using [static key encryption](encryption-static-key.md), [store the encryption key](encryption-static-key-set-up.md#encryption-static-key-set-up-store-key) in AWS Secrets Manager before you begin this procedure\. \(If the content is encrypted using SPEKE, you don't need to do anything to configure encryption\.\)

**To create a flow based on an entitlement \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. Verify that you are logged in to the same AWS Region that the originator's flow is in\.

1. On the **Flows** page, choose **Create flow**\.

1. In the **Details** section, for **Name**, specify a name for your flow\. 

1. For **Availability Zone**, choose an Availability Zone for your flow\. This does not need to match the Availability Zone of the originator's flow\.

1. In the **Source** section, for **Source type**, choose **Entitled source**\.

1. For **Entitlement ARN**, choose the appropriate entitlement\. This list includes all entitlements that have been granted to you\.
**Tip**  
You can click in this field and start typing the entitlement name\. AWS Elemental MediaConnect will filter the list to include only entitlements with a name that matches what you type\.
**Note**  
The percentage of the entitlement data transfer fee that you are responsible for is listed next to each entitlement\. This value is set by the content originator\.

1. If the originator set up encryption on the entitlement, choose **Enable** in the **Decryption** section and do the following:

   1. For **Decryption type**, choose **Static key**\.

   1. For **Role ARN**, specify the ARN of the role that you created when you [set up encryption](encryption-static-key-set-up.md#encryption-static-key-set-up-create-iam-role)\.

   1. For **Secret ARN**, specify the ARN that AWS Secrets Manager assigned when you [created the secret to store the encryption key](encryption-static-key-set-up.md#encryption-static-key-set-up-store-key)\.

   1. For **Decryption algorithm**, choose the type of encryption that the originator provided\.

1. At the bottom of the page, choose **Create flow**\.
**Note**  
The flow does not start automatically\. You must [start the flow](flows-start.md) manually\.

1. [Add outputs](outputs-add.md) to specify where you want AWS Elemental MediaConnect to send the content, or [grant entitlements](entitlements-grant.md) to allow users of other AWS accounts to subscribe to your content\.