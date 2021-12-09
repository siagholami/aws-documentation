# Removing outputs from a flow<a name="outputs-remove"></a>

You can remove outputs that you added to the flow\. If AWS Elemental MediaConnect generated the output as the result of an entitlement, you must [revoke the entitlement](entitlements-revoke.md)\.

**To remove an output from a flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that is associated with the output that you want to remove\.

   The details page for that flow appears\. 

1. Choose the **Outputs** tab\.

1. Choose the output, and then choose **Remove**\.

**To remove an output from a flow \(AWS CLI\)**
+ In the AWS CLI, use the `remove-flow-output` command:

  ```
  aws mediaconnect remove-flow-output --flow-arn "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame" --output-arn "arn:aws:mediaconnect:us-east-1:111122223333:output:2-3aBC45dEF67hiJ89-c34de5fG678h:Output1" --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame",
      "OutputArn": "arn:aws:mediaconnect:us-east-1:111122223333:output:2-3aBC45dEF67hiJ89-c34de5fG678h:Output1"
  }
  ```