# Transition your AWS CodeStar Project to Production<a name="transition-project-prod"></a>

After you have created your application using an AWS CodeStar project and seen what AWS CodeStar provides, you might want to transition your project to production use\. One way to do this is to replicate your application’s AWS resources outside of AWS CodeStar\. You will still need a repository, a build project, a pipeline, and a deployment, but rather than having AWS CodeStar create them for you, you will recreate them using AWS CloudFormation\.

**Note**  
It can be helpful to create or view a similar project using one of the AWS CodeStar quick starts first and use that as a template for your own project to make sure you include the resources and policies you need\.

An AWS CodeStar project is a combination of source code and the resources created to deploy the code\. The collection of resources that help you build, release, and deploy your code are called toolchain resources\. At project creation, an AWS CloudFormation template provisions your toolchain resources in a continuous integration/continuous deployment \(CI/CD\) pipeline\.

When you use the console to create a project, the toolchain template is created for you\. When you use the AWS CLI to create a project, you create the toolchain template that creates your toolchain resources\.

A complete toolchain requires the following recommended resources:

1. A CodeCommit or GitHub repository that contains your source code\.

1. A CodePipeline pipeline that is configured to listen to changes to your repository\.

   1. When you use AWS CodeBuild to run unit or integration tests, we recommend that you add a build stage to your pipeline to create build artifacts\.

   1. We recommend that you add a deployment stage to your pipeline that uses CodeDeploy or AWS CloudFormation to deploy your build artifact and source code to your runtime infrastructure\.
**Note**  
Because CodePipeline requires at least two stages in a pipeline, and the first stage must be the source stage, add a build or deploy stage as the second stage\.

**Topics**
+ [Create a GitHub Repository](create-github.md)