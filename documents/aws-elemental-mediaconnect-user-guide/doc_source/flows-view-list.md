# Viewing a list of flows<a name="flows-view-list"></a>

You can view a list of your AWS Elemental MediaConnect flows in a specific AWS Region\.

**To view a list of flows \(console\)**
+ Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

  The **Flows** page appears, listing all the flows that are associated with your account\.

**To view a list of flows \(AWS CLI\)**
+ In the AWS CLI, use the `list-flows` command:

  ```
  aws mediaconnect list-flows --profile PMprofile
  ```

  The following example shows the return value:

  ```
  {
    "Flows": [
      {
        "AvailabilityZone": "us-west-2a",
        "Description": "Temporary listed flow description",
        "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame",
        "Name": "BasketballGame",
        "SourceType": "OWNED",
        "Status": "STOPPING"
      },
      {
        "AvailabilityZone": "us-west-2d",
        "Description": "Temporary listed flow description",
        "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:2-3aBC45dEF67hiJ8k-2AbC34DE5fGa6:AwardsShow",
        "Name": "AwardsShow",
        "SourceType": "OWNED",
        "Status": "STANDBY"
      }
    ]
  }
  ```