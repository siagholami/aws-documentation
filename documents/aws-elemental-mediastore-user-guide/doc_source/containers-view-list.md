# Viewing a list of containers<a name="containers-view-list"></a>

You can view a list of all the containers that are associated with your account\.

**To view a list of containers \(console\)**
+ Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

  The **Containers** page appears, listing all the containers that are associated with your account\.

**To view a list of containers \(AWS CLI\)**
+ In the AWS CLI, use the `list-containers` command\.

  ```
  aws mediastore list-containers --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "Containers": [
          {
              "CreationTime": 1505317931.0,
              "Endpoint": "https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com",
              "Status": "ACTIVE",
              "ARN": "arn:aws:mediastore:us-west-2:111122223333:container/ExampleLiveDemo",
              "AccessLoggingEnabled": false,
              "Name": "ExampleLiveDemo"
          },
          {
              "CreationTime": 1506528818.0,
              "Endpoint": "https://fffggghhhiiijj.data.mediastore.us-west-2.amazonaws.com",
              "Status": "ACTIVE",
              "ARN": "arn:aws:mediastore:us-west-2:111122223333:container/ExampleContainer",
              "AccessLoggingEnabled": false,
              "Name": "ExampleContainer"
          }
      ]
  }
  ```