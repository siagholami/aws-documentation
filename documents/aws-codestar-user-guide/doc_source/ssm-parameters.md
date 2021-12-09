# Securely Use SSM Parameters in an AWS CodeStar Project<a name="ssm-parameters"></a>

Many customers store secrets, such as credentials, in [Systems Manager Parameter Store](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-paramstore-about.html) parameters\. Now you can securely use these parameters in an AWS CodeStar project\. For example, you might want to use SSM parameters in your build spec for CodeBuild or when defining application resources in your toolchain stack \(template\.yml\)\.

In order to use SSM parameters in a AWS CodeStar project, you must manually tag the parameters with the AWS CodeStar project ARN\. You must also provide appropriate permissions to the AWS CodeStar toolchain worker role to access the parameters that you've tagged\.

## Before You Begin<a name="w5aac15c22c21b7"></a>
+ [Create a new](https://docs.aws.amazon.com/systems-manager/latest/userguide/param-create-console.html) or identify an existing Systems Manager parameter that contains the information you want to access\.
+ Identify which AWS CodeStar project you want to use, or [create a new project](how-to-create-project.md)\.
+ Make a note of the CodeStar project ARN\. It looks like this: `arn:aws:codestar:region-id:account-id:project/project-id`\.

## Tag a Parameter with the AWS CodeStar Project ARN<a name="w5aac15c22c21b9"></a>

See [Tagging Systems Manager Parameters](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-paramstore-su-tag.html) for step by step instructions\.

1. In **Key**, enter `awscodestar:projectArn`\.

1. In **Value**, enter the project ARN from CodeStar: `arn:aws:codestar:region-id:account-id:project/project-id`\.

1. Choose **Save**\.

Now you can reference the SSM parameter in your template\.yml file\. If you want to use it with a toolchain worker role, you will need to grant additional permissions\.

## Grant Permissions to Use Tagged Parameters in your AWS CodeStar Project Toolchain<a name="w5aac15c22c21c11"></a>

**Note**  
These steps are applicable only to projects created after December 6, 2018 PDT\.

1. Open the AWS CodeStar project dashboard for the project you want to use\.

1. Click **Project** to view the list of created resources, and locate the toolchain worker role\. It is an IAM resource with a name of the format: `role/CodeStarWorker-project-id-ToolChain`\.

1. Click the ARN to open it in the IAM console\.

1. Locate the ToolChainWorkerPolicy and expand it, if necessary\.

1. Click **Edit Policy**\.

1. Under `Action:` add the following line:

   `ssm:GetParameter*`

1. Click Review policy, then click Save changes\.

For projects created before December 6, 2018 PDT, you will need to add the following permissions to the worker roles for each service\. 

```
        {
            "Action": [
                "ssm:GetParameter*"
            ],
            "Resource": "*",
            "Effect": "Allow",
            "Condition": {
                "StringEquals": {
                    "ssm:ResourceTag/awscodestar:projectArn": "arn:aws:codestar:region-id:account-id:project/project-id"
                }
            }
        }
```