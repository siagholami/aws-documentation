# Updating an entitlement<a name="entitlements-update"></a>

After an entitlement has been created, you can still update the description, status, and subscribers\. If you change the subscriber account ID, the content becomes unavailable to the original subscriber account\. If the original subscriber already created a flow that used the entitlement as a source, the associated output is removed from your flow\.

**To update an entitlement \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that is associated with the entitlement that you want to update\.

   The details page for that flow appears\.

1. Choose the **Entitlements** tab\.

1. Choose the entitlement that you want to update\.

1. Choose **Update**\.

1. Make the appropriate changes, and then choose **Save**\.

**To update an entitlement on a flow \(AWS CLI\)**
+ In the AWS CLI, use the `update-flow-entitlement` command:

  ```
  aws mediaconnect update-flow-entitlement --flow-arn arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BaseballGame --entitlement-arn arn:aws:mediaconnect:us-west-2:111122223333:entitlement:1-11aa22bb11aa22bb-3333cccc4444:AnyCompany_Entitlement --description 'For AnyCompany Affiliate' --subscribers 444455556666", "123456789012
  ```

  The following example shows the return value:

  ```
  {
      "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BaseballGame",
      "Entitlement": {
          "Name": "AnyCompany_Entitlement",
          "Description": "For AnyCompany Affiliate",
          "EntitlementArn": "arn:aws:mediaconnect:us-west-2:111122223333:entitlement:1-11aa22bb11aa22bb-3333cccc4444:AnyCompany_Entitlement",
          "Encryption": {
              "KeyType": "static-key",
              "Algorithm": "aes128",
              "RoleArn": "arn:aws:iam::111122223333:role/MediaConnect-ASM",
              "SecretArn": "arn:aws:secretsmanager:us-west-2:111122223333:secret:mySecret1"
          },
          "Subscribers": [
              "444455556666", "123456789012"
          ]
      }
  }
  ```