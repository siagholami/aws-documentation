# Stopping a flow<a name="flows-stop"></a>

When you stop an active flow, it immediately becomes unavailable to customers who are accessing the output directly from your AWS Elemental MediaConnect flow or through an entitlement\. If you want to delete an active flow, you must stop the flow first before you can delete it\.

**To stop a flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that you want to stop\.

   The details page for that flow appears\.

1. Choose **Stop**\.

   The status of the flow changes to **Standby**\. The flow stops immediately and is no longer viewable to customers who are accessing the output directly from your MediaConnect flow or through an entitlement\.

**To stop a flow \(AWS CLI\)**
+ In the AWS CLI, use the `stop-flow` command:

  ```
  aws mediaconnect stop-flow --flow-arn arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame --profile PMprofile
  ```

  The following example shows the return value:

  ```
  {
    "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame",
    "Status": "STOPPING"
  }
  ```