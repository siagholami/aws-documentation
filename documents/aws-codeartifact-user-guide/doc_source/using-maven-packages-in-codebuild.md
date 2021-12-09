# Using Maven packages in CodeBuild<a name="using-maven-packages-in-codebuild"></a>

## Set up permissions with IAM roles<a name="maven-packages-in-codebuild-iam"></a>

These steps are required when using Maven packages from CodeArtifact in CodeBuild\.

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
 If you also want to use CodeBuild to publish packages, add the **codeartifact:PublishPackageVersion** and **codeartifact:PutPackageMetadata** permissions\. 

   For information, see [Modifying a Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_manage_modify.html) in the *IAM User Guide*\.

## Use gradle or mvn<a name="maven-packages-in-codebuild-login"></a>

To use Maven packages with `gradle` or `mvn`, store the CodeArtifact auth token in an environment variable, as described in [Pass an auth token in an environment variable](tokens-authentication.md#env-var)\. The following is an example\. 

**Note**  
It is only necessary to upgrade the AWS CLI with `pip3 install awscli --upgrade --user` if you are using an older CodeBuild image\. If you are using the latest image versions, you can remove that line\.

```
pre_build:
  commands:
    - pip3 install awscli --upgrade --user
    - export CODEARTIFACT_TOKEN=`aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text`
```

 **To use Gradle:** 

If you referenced the `CODEARTIFACT_TOKEN` variable in your Gradle `build.gradle` file as described in [Using CodeArtifact with Gradle](maven-gradle.md), you can invoke your Gradle build from the `buildspec.yaml` `build` section\.

```
build:
  commands:
    - gradle build
```

 **To use mvn:** 

You must configure your Maven configuration files \(`settings.xml` and `pom.xml`\) following the instructions in [Using CodeArtifact with mvn](maven-mvn.md)\.