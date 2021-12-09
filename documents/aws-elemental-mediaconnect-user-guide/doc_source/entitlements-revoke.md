# Revoking an entitlement<a name="entitlements-revoke"></a>

After you revoke an entitlement, the content becomes unavailable to the subscriber account permanently\. The entitlement and the associated output are removed from your flow\. 

If you want to stop streaming content to the subscriber’s flow temporarily, [disable](entitlements-disable.md) the entitlement instead\. 

**To revoke an entitlement \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that is associated with the entitlement that you want to revoke\.

   The details page for that flow appears\.

1. Choose the **Entitlements** tab\.

1. Choose the entitlement that you want to revoke\.

1. Choose **Revoke**\.

**To revoke an entitlement on a flow \(AWS CLI\)**
+ In the AWS CLI, use the `revoke-flow-entitlement` command:

  ```
  aws mediaconnect revoke-flow-entitlement --flow-arn arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BaseballGame --entitlement-arn arn:aws:mediaconnect:us-west-2:111122223333:entitlement:1-11aa22bb11aa22bb-3333cccc4444:AnyCompany_Entitlement
  ```

  The following example shows the return value:

  ```
  {
      "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BaseballGame",
      "EntitlementArn": "arn:aws:mediaconnect:us-west-2:111122223333:entitlement:1-11aa22bb11aa22bb-3333cccc4444:AnyCompany_Entitlement"
  }
  ```