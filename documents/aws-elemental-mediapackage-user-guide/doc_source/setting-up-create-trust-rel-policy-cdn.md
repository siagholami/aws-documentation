# Secrets Manager Access for CDN Authorization<a name="setting-up-create-trust-rel-policy-cdn"></a>

If you use content delivery network \(CDN\) authorization headers to restrict access to your endpoints in MediaPackage, you need a policy that allows you to do these things in Secrets Manager:
+ `GetSecretValue`: MediaPackage can retrieve the encrypted authorization code from a version of the secret\.
+ `DescribeSecret`: MediaPackage can retrieve the details of the secret, excluding encrypted fields\.
+ `ListSecrets`: MediaPackage can retrieve a list of secrets in the AWS account\.
+ `ListSecretVersionIds`: MediaPackage can retrieve all of the versions that are attached to the specified secret\.

**Note**  
You don't need a separate policy for each secret that you store in Secrets Manager\. If you create a policy like the one described in the following procedure, MediaPackage can access all secrets in your account in this Region\.

**To use the JSON policy editor to create a policy**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation column on the left, choose **Policies**\. 

   If this is your first time choosing **Policies**, the **Welcome to Managed Policies** page appears\. Choose **Get Started**\.

1. At the top of the page, choose **Create policy**\.

1. Choose the **JSON** tab\.

1. Enter the following JSON policy document:

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": [
           "secretsmanager:GetSecretValue",
           "secretsmanager:DescribeSecret",
           "secretsmanager:ListSecrets",
           "secretsmanager:ListSecretVersionIds"
         ],
         "Resource": [
           "*"
         ]
       },
       {
         "Effect": "Allow",
         "Action": [
            "iam:GetRole",
            "iam:PassRole"
          ],
          "Resource": "*"
        }
     ]
   }
   ```

1. Choose **Review policy**\.
**Note**  
You can switch between the **Visual editor** and **JSON** tabs any time\. However, if you make changes or choose **Review policy** in the **Visual editor** tab, IAM might restructure your policy to optimize it for the visual editor\. For more information, see [Policy Restructuring](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_policies.html#troubleshoot_viseditor-restructure) in the *IAM User Guide*\.

1. On the **Review policy** page, enter a **Name** and an optional **Description** for the policy that you are creating\. Review the policy **Summary** to see the permissions that are granted by your policy\. Then choose **Create policy** to save your work\.