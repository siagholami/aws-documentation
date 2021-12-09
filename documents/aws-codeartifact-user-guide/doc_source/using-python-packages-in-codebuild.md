# Using Python Packages in CodeBuild<a name="using-python-packages-in-codebuild"></a>

The steps below have been tested with the operating systems listed in the [Docker images provided by CodeBuild](https://docs.aws.amazon.com/codebuild/latest/userguide/build-env-ref-available.html)\.

## Set up permissions with IAM roles<a name="python-packages-in-codebuild-iam"></a>

These steps are required when using Python packages from CodeArtifact in CodeBuild\.

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

## Log in and use pip or twine<a name="python-packages-in-codebuild-login"></a>

To use Python packages from CodeBuild, run the `login` command from the `pre-build` section of your project's `buildspec.yaml` file to configure `pip` to fetch packages from CodeArtifact\. For more information, see [Using CodeArtifact with Python](using-python.md)\.

After `login` has run successfully, you can run `pip` commands from the `build` section to install or publish Python packages\.

### Linux<a name="python-packages-in-codebuild-login-linux"></a>

**Note**  
It is only necessary to upgrade the AWS CLI with `pip3 install awscli --upgrade --user` if you are using an older CodeBuild image\. If you are using the latest image versions, you can remove that line\.

 To install Python packages using `pip`: 

```
pre_build:
  commands:
    - pip3 install awscli --upgrade --user
    - aws codeartifact login --tool pip --domain my-domain --domain-owner domain-owner-id --repository my-repo
build:
  commands:
    - pip install requests
```

 To publish Python packages using `twine`: 

```
pre_build:
  commands:
    - pip3 install awscli --upgrade --user
    - aws codeartifact login --tool twine --domain my-domain --domain-owner domain-owner-id --repository my-repo
build:
  commands:
    - twine upload --repository codeartifact mypackage
```

### Windows<a name="python-packages-in-codebuild-login-windows"></a>

 To install Python packages using `pip`: 

```
version: 0.2
phases:
  install:
    commands:
      - '[Net.ServicePointManager]::SecurityProtocol = "Tls12"; Invoke-WebRequest https://awscli.amazonaws.com/AWSCLIV2.msi -OutFile $env:TEMP/AWSCLIV2.msi'
      - Start-Process -Wait msiexec "/i $env:TEMP\AWSCLIV2.msi /quiet /norestart"
  pre_build:
    commands:
      - '&"C:\Program Files\Amazon\AWSCLIV2\aws" codeartifact login --tool pip --domain my-domain --domain-owner domain-owner-id --repository my-repo'
  build:
    commands:
      - pip install requests
```

 To publish Python packages using `twine`: 

```
version: 0.2
phases:
  install:
    commands:
      - '[Net.ServicePointManager]::SecurityProtocol = "Tls12"; Invoke-WebRequest https://awscli.amazonaws.com/AWSCLIV2.msi -OutFile $env:TEMP/AWSCLIV2.msi'
      - Start-Process -Wait msiexec "/i $env:TEMP\AWSCLIV2.msi /quiet /norestart"
  pre_build:
    commands:
      - '&"C:\Program Files\Amazon\AWSCLIV2\aws" codeartifact login --tool twine --domain my-domain --domain-owner domain-owner-id --repository my-repo'
  build:
    commands:
      - twine upload --repository codeartifact mypackage
```