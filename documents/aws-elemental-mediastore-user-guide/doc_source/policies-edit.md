# Editing a container policy<a name="policies-edit"></a>

You can edit the permissions in the default container policy, or you can create a new policy that replaces the default policy\. It takes up to five minutes for the new policy to take effect\. 

**To edit a container policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the container name\.

1. Choose **Edit policy**\. For examples that show how to set different permissions, see [Example container policies](policies-examples.md)\.

1. Make the appropriate changes, and then choose **Save**\.

**To edit a container policy \(AWS CLI\)**

1. Create a file that defines the container policy:

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Sid": "PublicReadOverHttps",
         "Effect": "Allow",
         "Action": ["mediastore:GetObject", "mediastore:DescribeObject"],
         "Principal": "*",
         "Resource": "arn:aws:mediastore:us-west-2:111122223333:container/ExampleLiveDemo/*",
         "Condition": {
           "Bool": {
               "aws:SecureTransport": "true"
           }
         }
       }
     ]
   }
   ```

1. In the AWS CLI, use the `put-container-policy` command:

   ```
   aws mediastore put-container-policy --container-name ExampleLiveDemo --policy file://ExampleContainerPolicy.json --region us-west-2
   ```

   This command has no return value\.