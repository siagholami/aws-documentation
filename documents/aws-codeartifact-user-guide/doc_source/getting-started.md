# Getting started with CodeArtifact<a name="getting-started"></a>

 In this getting started tutorial, you use CodeArtifact to create the following: 
+  A domain called `my-domain`\. 
+  A repository called `my-repo` that is contained in `my-domain`\. 
+  A repository called `npm-store` that is contained in `my-domain`\. The `npm-store` has an external connection to the npm public repository\. This connection is used to ingest an npm package into the `my-repo` repository\. 

 Before starting this tutorial, we recommend that you review CodeArtifact [AWS CodeArtifact Concepts](codeartifact-concepts.md)\. 

**Note**  
 This tutorial requires you to create resources that might result in charges to your AWS account\. For more information, see [CodeArtifact pricing](https://aws.amazon.com/codeartifact/pricing/)\. 

**Topics**
+ [Prerequisites](#getting-started-prerequisites)
+ [Getting started using the console](getting-started-console.md)
+ [Getting started using the AWS CLI](getting-started-cli.md)

## Prerequisites<a name="getting-started-prerequisites"></a>

You can complete this tutorial using the AWS Management Console or the AWS Command Line Interface \(AWS CLI\)\. To follow the tutorial, you must first complete the following prerequisites: 
+  Complete the steps in [Setting up with AWS CodeArtifact](get-set-up-for-codeartifact.md)\. 
+  Install the npm CLI\. For more information, see [Installing the npm CLI](https://npme.npmjs.com/docs/cli/installation.html) on the npm website\. 