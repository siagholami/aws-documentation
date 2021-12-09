# Tutorial: Create a Project in AWS CodeStar with the AWS CLI<a name="cli-tutorial"></a>

This tutorial shows you how to use the AWS CLI to create an AWS CodeStar project with sample source code and a sample toolchain template\. AWS CodeStar provisions the AWS infrastructure and IAM resources specified in an AWS CloudFormation toolchain template\. The project manages your toolchain resources to build and deploy your source code\.

AWS CodeStar uses AWS CloudFormation to build and deploy your sample code\. This sample code creates a web service that is hosted in AWS Lambda and can be accessed through Amazon API Gateway\.

**Prerequisites:** 
+ Complete the steps in [Setting Up AWS CodeStar](setting-up.md)\.
+ You must have created an Amazon S3 storage bucket\. In this tutorial, you upload the sample source code and toolchain template to this location\.

**Note**  
Your AWS account might be charged for costs related to this tutorial, including AWS services used by AWS CodeStar\. For more information, see [AWS CodeStar Pricing](https://aws.amazon.com/codestar/pricing)\.

**Topics**
+ [Step 1: Download and Review the Sample Source Code](#cli-tutorial-download-source)
+ [Step 2: Download the Sample Toolchain Template](#cli-tutorial-toolchain-template)
+ [Step 3: Test Your Toolchain Template in AWS CloudFormation](#cli-tutorial-toolchain-template-test)
+ [Step 4: Upload Your Source Code and Toolchain Template](#cli-tutorial-template-upload)
+ [Step 5: Create a Project in AWS CodeStar](#cli-tutorial-create-project)

## Step 1: Download and Review the Sample Source Code<a name="cli-tutorial-download-source"></a>

For this tutorial, there is a zip file available for download\. It contains sample source code for a Node\.js [sample application](samples/nodews.zip) on the Lambda compute platform\. When the source code is placed in your repository, its folder and files appear as shown:

```
tests/
app.js
buildspec.yml
index.js
package.json
README.md
template.yml
```

The following project elements are represented in your sample source code:
+ `tests/`: Unit tests set up for this project's CodeBuild project\. This folder is included in the sample code, but it is not required to create a project\.
+ `app.js`: Application source code for your project\.
+ `buildspec.yml`: The build instructions for your CodeBuild resource's build stage\. This file is required for a toolchain template with an CodeBuild resource\.
+ `package.json`: The dependencies information for your application source code\.
+ `README.md`: The project readme file included in all AWS CodeStar projects\. This file is included in the sample code, but it is not required to create a project\.
+  `template.yml`: The infrastructure template file or SAM template file included in all AWS CodeStar projects\. This is different from the toolchain template\.yml you upload later in this tutorial\. This file is included in the sample code, but it is not required to create a project\.

## Step 2: Download the Sample Toolchain Template<a name="cli-tutorial-toolchain-template"></a>

The sample toolchain template provided for this tutorial creates a repository \(CodeCommit\), pipeline \(CodePipeline\), and build container \(CodeBuild\) and uses AWS CloudFormation to deploy your source code to a Lambda platform\. In addition to these resources, there are also IAM roles that you can use to scope the permissions of your runtime environment, an Amazon S3 bucket that CodePipeline uses to store your deployment artifacts, and an CloudWatch Events rule that is used to trigger pipeline deployments when you push code to your repository\. To align with [AWS IAM best practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege), scope down the policies of your toolchain roles defined in this example\.

Download and unzip the sample AWS CloudFormation template in [YAML](samples/toolchain.zip) format\.

When you run the create\-project command later in the tutorial\. this template creates the following customized toolchain resources in AWS CloudFormation\. For more information about the resources created in this tutorial, see the following topics in the *AWS CloudFormation User Guide*:
+ The [AWS::CodeCommit::Repository](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-codecommit-repository.html) AWS CloudFormation resource creates a CodeCommit repository\.
+ The [AWS::CodeBuild::Project](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-codebuild-project.html) AWS CloudFormation resource creates an CodeBuild build project\.
+ The [AWS::CodeDeploy::Application](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-codedeploy-application.html) AWS CloudFormation resource creates a CodeDeploy application\.
+ The [AWS::CodePipeline::Pipeline](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-codepipeline-pipeline.html) AWS CloudFormation resource creates a CodePipeline pipeline\.
+ The [AWS::S3::Bucket](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-s3-bucket.html) AWS CloudFormation resource creates your pipeline's artifact bucket\.
+ The [AWS::S3::BucketPolicy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-s3-policy.html) AWS CloudFormation resource creates the artifact bucket policy for your pipeline's artifact bucket\.
+ The [AWS::IAM::Role](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html) AWS CloudFormation resource creates the CodeBuild IAM worker role that gives AWS CodeStar permissions to manage your CodeBuild build project\.
+ The [AWS::IAM::Role](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html) AWS CloudFormation resource creates the CodePipeline IAM worker role that gives AWS CodeStar permissions to create your pipeline\.
+ The [AWS::IAM::Role](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html) AWS CloudFormation resource creates the AWS CloudFormation IAM worker role that gives AWS CodeStar permissions to create your resource stack\.
+ The [AWS::IAM::Role](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html) AWS CloudFormation resource creates the AWS CloudFormation IAM worker role that gives AWS CodeStar permissions to create your resource stack\.
+ The [AWS::IAM::Role](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html) AWS CloudFormation resource creates the AWS CloudFormation IAM worker role that gives AWS CodeStar permissions to create your resource stack\.
+ The [AWS::Events::Rule](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-events-rule.html) AWS CloudFormation resource creates the CloudWatch Events rule that monitors your repository for push events\.
+ The [AWS::IAM::Role](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html) AWS CloudFormation resource creates the CloudWatch Events IAM role\.

## Step 3: Test Your Toolchain Template in AWS CloudFormation<a name="cli-tutorial-toolchain-template-test"></a>

Before you upload your toolchain template, you can test your toolchain template in AWS CloudFormation and troubleshoot any errors\.

1. Save your updated template to your local computer, and open the AWS CloudFormation console\. Choose **Create Stack**\. You should see your new resources in the list\.

1. View your stack for any stack creation errors\.

1. After your testing is complete, delete the stack\.
**Note**  
Make sure you delete your stack and all resources created in AWS CloudFormation\. Otherwise, when you create your project, you might encounter errors for resource names already in use\.

## Step 4: Upload Your Source Code and Toolchain Template<a name="cli-tutorial-template-upload"></a>

To create an AWS CodeStar project, you must first package your source code into a \.zip file and place it in Amazon S3\. AWS CodeStar initializes your repository with these contents\. You specify this location in your input file when you run the command to create your project in the AWS CLI\.

You must also upload your `toolchain.yml` file and place it in Amazon S3\. You specify this location in your input file when you run the command to create your project in the AWS CLI

**To upload your source code and toolchain template**

1. The following sample file structure shows the source files and the toolchain template ready to be zipped and uploaded\. The sample code includes the `template.yml` file\. Remember, this file is different from the `toolchain.yml` file\.

   ```
   ls
   src toolchain.yml
   
   ls src/
   README.md    app.js        buildspec.yml    index.js    package.json    template.yml    tests
   ```

1. Create the \.zip for the source code files\.

   ```
   cd src; zip -r "../src.zip" *; cd ../
     adding: README.md (deflated 58%)
     adding: app.js (deflated 43%)
     adding: buildspec.yml (deflated 48%)
     adding: index.js (deflated 45%)
     adding: package.json (deflated 50%)
     adding: template.yml (deflated 53%)
     adding: tests/ (stored 0%)
     adding: tests/test.js (deflated 64%)
   ```

1. Call the cp command and include the files as parameters\.

   The following commands upload the \.zip file and `toolchain.yml` to Amazon S3\.

   ```
   aws s3 cp src.zip s3://MyBucket/src.zip 
   aws s3 cp toolchain.yml s3://MyBucket/toolchain.yml
   ```

**To configure your Amazon S3 bucket to share your source code**
+ Because you're storing your source code and toolchain in Amazon S3, you can use the Amazon S3 bucket policies and object ACLs to ensure that other IAM users or AWS accounts can create projects from your samples\. AWS CodeStar ensures that any user who creates a custom project has access to the toolchain and source they want to use\.

  To let anyone use your sample, run the following commands:

  ```
  aws s3api put-object-acl --bucket MyBucket --key toolchain.yml --acl public-read
  aws s3api put-object-acl --bucket MyBucket --key src.zip --acl public-read
  ```

## Step 5: Create a Project in AWS CodeStar<a name="cli-tutorial-create-project"></a>

Use these steps to create your project\.

**Important**  
Make sure you configure the preferred AWS Region in AWS CLI\. Your project is created in the AWS Region configured in the AWS CLI\.

1. Run the create\-project command and include the `--generate-cli-skeleton` parameter:

   ```
   aws codestar create-project --generate-cli-skeleton
   ```

   JSON\-formatted data appears in the output\. Copy the data to a file \(for example, `input.json`\) in a location on your local computer or instance where the AWS CLI is installed\. Modify the copied data as follows, and save your results\. This input file is configured for a project named `MyProject` with a bucket name of `myBucket`\.
   + Make sure you provide the `roleArn` parameter\. For custom templates, like the sample template in this tutorial, you must provide a role\. This role must have permissions to create all of the resources specified in [Step 2: Download the Sample Toolchain Template](#cli-tutorial-toolchain-template)\.
   + Make sure you provide the `ProjectId` parameter under `stackParameters`\. The sample template provided for this tutorial requires this parameter\. 

   ```
   {
       "name": "MyProject", 
       "id": "myproject", 
       "description": "Sample project created with the CLI", 
       "sourceCode": [
           {
               "source": {
                   "s3": {
                       "bucketName": "MyBucket", 
                       "bucketKey": "src.zip"
                   }
               }, 
               "destination": {
                   "codeCommit": {
                       "name": "myproject"
                   
                   }
               }
           }
       ], 
       "toolchain": {
           "source": {
               "s3": {
                   "bucketName": "MyBucket", 
                   "bucketKey": "toolchain.yml"
               }
           },
           "roleArn": "role_ARN", 
           "stackParameters": {
               "ProjectId": "myproject"
           }
       }
   }
   ```

1. Switch to the directory that contains the file you just saved, and run the create\-project command again\. Include the `--cli-input-json` parameter\.

   ```
   aws codestar create-project --cli-input-json file://input.json
   ```

1. If successful, data similar to the following appears in the output:

   ```
   {
       "id": "project-ID",
       "arn": "arn"
   }
   ```
   + The output contains information about the new project:
     + The `id` value represents the project ID\. 
     + The `arn` value represents the ARN of the project\. 

1. Use the describe\-project command to check the status of your project creation\. Include the `--id` parameter\.

   ```
   aws codestar describe-project --id <project_ID> 
   ```

   Data similar to the following appears in the output:

   ```
   {
       "name": "MyProject",
       "id": "myproject",
       "arn": "arn:aws:codestar:us-east-1:account_ID:project/myproject",
       "description": "",
       "createdTimeStamp": 1539700079.472,
       "stackId": "arn:aws:cloudformation:us-east-1:account_ID:stack/awscodestar-myproject/stack-ID",
       "status": {
           "state": "CreateInProgress"
       }
   }
   ```
   + The output contains information about the new project:
     + The `id` value represents the unique project ID\.
     + The `state` value represents the status of the project creation, such as `CreateInProgress` or `CreateComplete`\.

While your project is being created, you can [add team members](how-to-add-team-member.md) or [configure access](setting-up-ide.md) to your project repository from the command line or your favorite IDE\.