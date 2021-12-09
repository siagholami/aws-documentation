# Updating outputs on a flow<a name="outputs-update"></a>

You can update outputs on a flow, even when the flow is active\.

**To update an output on a flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that is associated with the output that you want to update\.

1. Choose the **Outputs** tab\.

   A list of outputs for that flow appears\.

1. Choose the output that you want to update\.

1. Choose **Update**\.

1. Make the appropriate changes, and then choose **Save**\.

**To update a flow output \(AWS CLI\)**
+ In the AWS CLI, use the `update-flow-output` command:

  ```
  aws mediaconnect update-flow-output --output-arn "arn:aws:mediaconnect:us-east-1:111122223333:output:2-3aBC45dEF67hiJ89-c34de5fG678h:NYCfeed" --port 5040 --region us-east-1 --profile PMprofile
  ```

  The following example shows the return value:

  ```
  {
    "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame",
    "Output": {
      "Address": "192.0.2.12",
      "Encryption": {
        "Algorithm": "aes256",
        "KeyType": "static-key",
        "RoleArn": "arn:aws:iam::111122223333:role/AllowMediaConnect",
        "SecretArn": "arn:aws:secretsmanager:us-west-2:111122223333:secret:SECRETID"
      },
      "Name": "Output1",
      "OutputArn": "arn:aws:mediaconnect:us-east-1:111122223333:output:2-3aBC45dEF67hiJ89-c34de5fG678h:Output1",
      "Port": 5040,
      "Protocol": "rtp-fec"
    }
  }
  ```