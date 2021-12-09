# Step 3: Modify the Trust Relationship<a name="setting-up-create-trust-rel-trust"></a>

The trust relationship defines what entities can assume the role that you created in [Step 2: Create a Role](setting-up-create-trust-rel-role.md)\. When you created the role and established the trusted relationship, you chose EC2 as the trusted entity\. Modify the role so that the trusted relationship is between your AWS account and AWS Elemental MediaPackage\.

**To change the trust relationship to MediaPackage**

1. Access the role that you created in [Step 2: Create a Role](setting-up-create-trust-rel-role.md)\. 

   If you're not already displaying the role, in the navigation pane of the IAM console, choose **Roles**\. Search for and choose the role that you created\.

1. On the **Summary** page for the role, choose **Trust relationships**\.

1. Choose **Edit trust relationship**\.

1. On the **Edit Trust Relationship** page, in the **Policy Document**, change `ec2.amazonaws.com` to `mediapackage.amazonaws.com`\. 

   The policy document should now look like this: 

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Sid": "",
         "Effect": "Allow",
         "Principal": {
           "Service": "mediapackage.amazonaws.com"
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

1. Choose **Update Trust Policy**\.

1. On the **Summary** page, make a note of the value in **Role ARN**\. You use this ARN when you ingest source content for video on demand \(VOD\) workflows\. The ARN looks like this:

   `arn:aws:iam::111122223333:role/RoleName`

   In the example, `111122223333` is your AWS account number\. 