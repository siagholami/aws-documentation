# Deleting a flow<a name="flows-delete"></a>

When you delete an active flow, it immediately becomes unavailable to customers who are accessing the output directly from your AWS Elemental MediaConnect flow or through an entitlement\. After you delete a flow, you can't recover it\.

If the flow is active, you must stop the flow before you can delete it\. 

**To delete a flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that you want to delete\.

   The details page for that flow appears\.

1. Review the **Status** field to verify that the flow is in **Standby** mode\. 

1. If the flow status is **Active**, choose **Stop**\. 

1. Choose **Delete**\. 

   A confirmation message appears\.

1. Choose **Delete flow**\. 

   The flow is no longer viewable to customers who are accessing the output directly from your MediaConnect flow or through an entitlement\. It might take up to five minutes for the flow to be deleted entirely\.

**To delete a flow \(AWS CLI\)**
+ In the AWS CLI, use the `delete-flow` command:

  ```
  aws mediaconnect delete-flow --flow-arn arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame --profile PMprofile
  ```

  The following example shows the return value:

  ```
  {
    "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame",
    "Status": "DELETING"
  }
  ```