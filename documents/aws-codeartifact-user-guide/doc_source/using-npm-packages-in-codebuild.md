# Using npm packages in CodeBuild<a name="using-npm-packages-in-codebuild"></a>

The steps below have been tested with the operating systems listed in [Docker images provided by CodeBuild](https://docs.aws.amazon.com/codebuild/latest/userguide/build-env-ref-available.html)\.

## Set up permissions with IAM roles<a name="npm-packages-in-codebuild-iam"></a>

These steps are required when using npm packages from CodeArtifact in CodeBuild\.

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**\. On the **Roles** page, edit the role used by your CodeBuild build project\. This role must have the following permissions\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
         {
             "Effect": "Allow",
             "Action": [ "codeartifact:GetAuthorizationToken",
                         "codeartifact:GetRepositoryEndpoint",
                         "codeartifact:ReadFromRepository"
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
 If you also want to use CodeBuild to publish packages, add the **codeartifact:PublishPackageVersion** permission\. 

   For information, see [Modifying a Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_manage_modify.html) in the *IAM User Guide*\.

## Log in and use npm<a name="npm-packages-in-codebuild-login"></a>

To use npm packages from CodeBuild, run the `login` command from the `pre-build` section of your project's `buildspec.yaml` to configure `npm` to fetch packages from CodeArtifact\. For more information, see [Authentication with npm](npm-auth.md)\.

After `login` has run successfully, you can run `npm` commands from the `build` section to install npm packages\.

### Linux<a name="npm-packages-in-codebuild-login-linux"></a>

**Note**  
It is only necessary to upgrade the AWS CLI with `pip3 install awscli --upgrade --user` if you are using an older CodeBuild image\. If you are using the latest image versions, you can remove that line\.

```
pre_build:
  commands:
    - pip3 install awscli --upgrade --user
    - aws codeartifact login --tool npm --domain my-domain --domain-owner domain-owner-id --repository my-repo
build:
  commands:
    - npm install
```

### Windows<a name="npm-packages-in-codebuild-login-windows"></a>

```
version: 0.2
phases:
  install:
    commands:
      - '[Net.ServicePointManager]::SecurityProtocol = "Tls12"; Invoke-WebRequest https://awscli.amazonaws.com/AWSCLIV2.msi -OutFile $env:TEMP/AWSCLIV2.msi'
      - Start-Process -Wait msiexec "/i $env:TEMP\AWSCLIV2.msi /quiet /norestart"
  pre_build:
    commands:
      - '&"C:\Program Files\Amazon\AWSCLIV2\aws" codeartifact login --tool npm --domain my-domain --domain-owner domain-owner-id --repository my-repo'
  build:
    commands:
      - npm install
```