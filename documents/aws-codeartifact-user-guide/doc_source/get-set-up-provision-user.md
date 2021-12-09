# Provision an IAM User<a name="get-set-up-provision-user"></a>

Follow these instructions to prepare an IAM user to use CodeArtifact\.

**To provision an IAM user**

1. Create an IAM user, or use one that is associated with your AWS account\. For more information, see [Creating an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_SettingUpUser.html#Using_CreateUser_console) and [Overview of AWS IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html) in the *IAM User Guide*\.

1. Grant the IAM user access to CodeArtifact using the following policy\.

   ```
   {
   "Version": "2012-10-17",
   "Statement": [
      {
        "Effect": "Allow",
        "Action": [
             "codeartifact:*"
        ],
        "Resource": "*"
      },
      {       
        "Effect": "Allow",
        "Action": "sts:GetServiceBearerToken",
        "Resource": "*",
        "Condition": {
            "StringEquals": {
                "sts:AWSServiceName": "codeartifact.amazonaws.com"
            }
         }
       }
   ]
   }
   ```
**Important**  
This policy grants access to all CodeArtifact APIs\. We recommend that you always use the minimum permissions required to accomplish your task\. For more information, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\. 

If you haven't installed the package manager or build tool that you plan to use with CodeArtifact, see [Install your package manager or build tool](getting-started-install-package-manager.md)\.