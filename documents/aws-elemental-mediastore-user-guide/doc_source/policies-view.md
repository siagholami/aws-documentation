# Viewing a container policy<a name="policies-view"></a>

You can use the console or the AWS CLI to view the resource\-based policy of a container\.

**To view a container policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the container name\.

   The container details page appears\. The policy is displayed in the **Container policy** section\. 

**To view a container policy \(AWS CLI\)**
+ In the AWS CLI, use the `get-container-policy` command:

  ```
  aws mediastore get-container-policy --container-name ExampleLiveDemo --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
    "Policy": {
      "Version": "2012-10-17",
      "Statement": [
        {
          "Sid": "PublicReadOverHttps",
          "Effect": "Allow",
          "Principal": {
            "AWS": "arn:aws:iam::111122223333:root",
          },
          "Action": [
            "mediastore:GetObject",
            "mediastore:DescribeObject",
          ],
          "Resource": "arn:aws:mediastore:us-west-2:111122223333:container/ExampleLiveDemo/*",
          "Condition": {
            "Bool": {
              "aws:SecureTransport": "true"
            }
          }
        }
      ]
    }
  }
  ```