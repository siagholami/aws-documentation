# Step 3a: Create a policy<a name="setting-up-create-nonadmin-IAM-users-policies"></a>

Create two policies for AWS Elemental MediaConnect: one to provide read/write access and one to provide read\-only access\. Perform these steps one time only for each policy\.

**To create policies**

1. Use your AWS account ID or account alias, and the credentials for your admin IAM user, to sign in to the [IAM console](https://console.aws.amazon.com/iam)\.

1. In the navigation pane of the console, choose **Policies**\.

1. On the **Policies** page, create a policy named `MediaConnectAllAccess` that allows all actions on all resources in AWS Elemental MediaConnect:

   1. Choose **Create policy**\.

   1. Choose the **JSON** tab and paste the following policy:

      ```
      {
          "Version": "2012-10-17",
          "Statement": [
              {
                  "Action": [
                      "mediaconnect:*"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              },
              {
                  "Action": [
                      "ec2:DescribeAvailabilityZones"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              },
               {
                  "Action": [
                      "cloudwatch:GetMetricData"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              },
              {
                  "Action": [
                      "iam:PassRole"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              }
          ]
      }
      ```

      This policy allows all actions on all resources in AWS Elemental MediaConnect\.

   1. Choose **Review policy**\.

   1. On the **Review policy** page, for **Name**, enter **MediaConnectAllAccess**, and then choose **Create policy**\.

1. On the **Policies** page, create a read\-only policy named `MediaConnectReadOnlyAccess` for AWS Elemental MediaConnect:

   1. Choose **Create policy**\.

   1. Choose the **JSON** tab and paste the following policy:

      ```
      {
          "Version": "2012-10-17",
          "Statement": [
              {
                  "Action": [
                      "mediaconnect:List*",
                      "mediaconnect:Describe*"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              },
              {
                  "Action": [
                      "ec2:DescribeAvailabilityZones"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              },
               {
                  "Action": [
                      "cloudwatch:GetMetricData"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              },
              {
                  "Action": [
                      "iam:PassRole"
                  ],
                  "Effect": "Allow",
                  "Resource": "*"
              }
          ]
      }
      ```

   1. Choose **Review policy**\.

   1. On the **Review policy** page, for **Name**, enter **MediaConnectReadOnlyAccess**, and then choose **Create policy**\.