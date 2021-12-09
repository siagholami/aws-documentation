# Viewing the details of a flow<a name="flows-view-details"></a>

You can view a flow's details, such as ARN, Availability Zone, status, source, entitlements, and outputs\.

**To view the details of a flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that you want to view\.

   The details page for that flow appears\. This page is divided into the following tabs:
   + The **Source** tab shows details about the source for this flow, including an indication of whether the flow is connected to the source\. 
   + The **Outputs** tab shows details for each output that you created for this flow\.
   + The **Entitlements** tab shows any entitlements that you have granted on this flow\.
   + The **Alerts** tab shows a log of active alerts on this flow\. 

**To view the details of a flow \(AWS CLI\)**
+ In the AWS CLI, use the `describe-flow` command:

  ```
  aws mediaconnect describe-flow --flow-arn arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:AwardsShow
  ```

  The following example shows the return value:

  ```
  {
      "Flow": {
          "EgressIp": "54.201.4.39",
          "AvailabilityZone": "us-east-1b",
          "Status": "ACTIVE",
          "FlowArn": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:AwardsShow",
          "Entitlements": [
              {
                  "EntitlementArn": "arn:aws:mediaconnect:us-east-1:111122223333:entitlement:1-AaBb11CcDd22EeFf-34DE5fG12AbC:MyEntitlement",
                  "Description": "Assign to this account",
                  "Name": "MyEntitlement",
                  "Subscribers": [
                      "444455556666"
                  ]
              }
          ],
          "Description": "NYC awards show",
          "Name": "AwardsShow",
          "Outputs": [
              {
                  "Port": 2355,
                  "Name": "NYC",
                  "Transport": {
                      "SmoothingLatency": 0,
                      "Protocol": "rtp-fec"
                  },
                  "OutputArn": "arn:aws:mediaconnect:us-east-1:111122223333:output:2-3aBC45dEF67hiJ89-c34de5fG678h:NYC",
                  "Destination": "192.0.2.0"
              },
              {
                  "Port": 3025,
                  "Name": "LA",
                  "Transport": {
                      "SmoothingLatency": 0,
                      "Protocol": "rtp-fec"
                  },
                  "OutputArn": "arn:aws:mediaconnect:us-east-1:111122223333:output:2-987655dEF67hiJ89-c34de5fG678h:LA",
                  "Destination": "192.0.2.0"
              }
          ],
          "Source": {
              "IngestIp": "54.201.4.39",
              "SourceArn": "arn:aws:mediaconnect:us-east-1:111122223333:source:3-4aBC56dEF78hiJ90-4de5fG6Hi78Jk:ShowSource",
              "Transport": {
                  "MaxBitrate": 80000000,
                  "Protocol": "rtp"
              },
              "IngestPort": 1069,
              "Description": "Saturday night show",
              "Name": "ShowSource",
              "WhitelistCidr": "10.24.34.0/23"
          }
      }
  }
  ```