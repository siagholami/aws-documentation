# Tutorial: Create an Alexa Skill Project in AWS CodeStar<a name="alexa-tutorial"></a>

AWS CodeStar is a cloud‑based development service on Amazon Web Services \(AWS\) that provides the tools you need to quickly develop, build, and deploy applications on AWS\. With AWS CodeStar, you can set up your entire continuous delivery toolchain in minutes, allowing you to start releasing code faster\. The Alexa skill project templates on AWS CodeStar enable you to create a simple Hello World Alexa skill from your AWS account with just a few clicks\. The templates also create a basic deployment pipeline that gets you started with a continuous integration \(CI\) workflow for skill development\.

The main benefits of creating Alexa skills from AWS CodeStar are that you can get started with skill development in AWS and connect your Amazon developer account to the project to deploy skills to the development stage directly from AWS\. You also get a ready to use deployment \(CI\) pipeline with a repository with all the source code for the project\. You can configure this repository with your preferred IDE to create skills with tools you are familiar with\.

## Prerequisites<a name="alexa-prereq"></a>
+  Create an Amazon developer account by going to [https://developer\.amazon\.com](https://developer.amazon.com/)\. Signup is free\. This account owns your Alexa skills\. 
+ If you do not have an AWS account, use the following procedure to create one\.

**To sign up for AWS**

  1. Open [https://aws\.amazon\.com/](https://aws.amazon.com/), and then choose **Create an AWS Account**\.
**Note**  
If you previously signed in to the AWS Management Console using AWS account root user credentials, choose **Sign in to a different account**\. If you previously signed in to the console using IAM credentials, choose **Sign\-in using root account credentials**\. Then choose **Create a new AWS account**\.

  1. Follow the online instructions\.

**Important**  
After you create the Alexa skill project, make all edits in the project repository only\. We recommend that you do not edit this skill directly using any other Alexa Skills Kit tools, such as the ASK CLI or ASK developer console\. These tools are not integrated with the project repository\. Using them causes the skill and repository code to become out of sync\.

## Step 1: Create the project and connect your Amazon developer account<a name="alexa-tutorial-step1"></a>

In this tutorial, you create a skill using Node\.js running on AWS Lambda\. Most of the steps are the same for other languages, although the skill name differs\. Refer to the README\.md file in the project repository for details of the specific project template you choose\.

1. Sign in to the AWS Management Console, and then open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Choose the AWS Region where you want to create the project and its resources\. The Alexa skill runtime is available in the following AWS Regions:
   + Asia Pacific \(Tokyo\)
   + EU \(Ireland\)
   + US East \(N\. Virginia\)
   + US West \(Oregon\)

1. Choose **Create a new project**\. If **Create a new project** is not displayed, choose **Start a project**\.

1. On the **Choose a project template** page:

   1. For **Application category**, choose **Alexa Skill**\.

   1. For **Programming languages**, choose **Node\.js**\.

   1. Choose the box that contains your selections\.

1. For **Project name**, enter a name for the project \(for example, *My Alexa Skill*\)\. If you use a different name, be sure to use it throughout this tutorial\. AWS CodeStar chooses a related identifier for this project for the **Project ID** \(for example, **my\-alexa\-skill**\)\. If you see a different project ID, be sure to use it throughout this tutorial\. 

1. Choose **AWS CodeCommit** for the repository in this tutorial and do not change the **Repository name** value\.

1. Choose **Connect Amazon developer account** to link to your Amazon developer account for hosting the skill\. 

1. Sign in with your Amazon developer credentials\. Choose **Allow**\.

1. If you have multiple vendor IDs associated with your Amazon developer account, choose the one that you want to use for this project\. Make sure you use an account with the Administrator or Developer role assigned\.

1. Choose **Next**\.

1. Leave **AWS CodeStar would like permission to administer AWS resources on your behalf** selected, and then choose **Create Project**\.

1. \(Optional\) If this is your first time using AWS CodeStar in this AWS Region, enter the display name and email address you want AWS CodeStar to use for your IAM user\. Choose **Next**\.

1. On **Pick how you want to edit your code**, choose **Skip**\. You can set up your local workstation to edit the project's code later\. 

1. Wait while AWS CodeStar creates the project\. This might take several minutes\. Do not continue until you see the welcome banner\.

## Step 2: Test your skill in the Alexa Simulator<a name="alexa-tutorial-step2"></a>

In the first step, AWS CodeStar created a skill for you and deployed it to the Alexa skill development stage\. Next, you test the skill in the Alexa Simulator\. 

1. In the **Application endpoints** tile on the right side of the AWS CodeStar console, choose **Alexa simulator**\. A new tab opens in the Alexa Simulator\.

1. Sign in with your Amazon developer credentials for the account you connected to your project in Step 1\.

1. Under **Test,** choose **Development** to enable testing\.

1. Enter `ask hello node hello`\. The default invocation name for your skill is `hello node`\.

1. Your skill should respond `Hello World!`\.

When the skill is enabled in the Alexa Simulator, you can also invoke it on an Alexa\-enabled device that is registered to your Amazon developer account\. To test your skill on a device, say *Alexa, ask hello node to say hello*\.

For more information about the Alexa Simulator, see [Test Your Skill in the Developer Console](https://developer.amazon.com/docs/devconsole/test-your-skill.html#test-simulator)\.

## Step 3: Explore your project resources<a name="alexa-tutorial-step3"></a>

As part of creating the project, AWS CodeStar also created AWS resources on your behalf\. These resources include a project repository using CodeCommit, a deployment pipeline using CodePipeline and an AWS Lambda function\. You can access these resources from the left navigation bar\. For example, choosing **Code** opens the project CodeCommit repository\. You can view the pipeline deployment status in the **Continuous deployment** tile on the project dashboard \(choose **Dashboard** from the left navigation bar, if necessary\)\. You can view a complete list of AWS resources created as part of your project by choosing **Project** in the left navigation bar\. This list includes links to each resource\.

## Step 4: Make a change in your skill's response<a name="alexa-tutorial-step4"></a>

In this step, you make a minor change to your skill's response to understand the iteration cycle\.

1. Choose **Code** from the left navigation bar\. The code section of your repository opens in a new tab\. This repository contains the build specification \(buildspec\.yml\), AWS CloudFormation application stack \(template\.yml\), readme file, and your skill's source code in the [skill package format \(project structure\)](https://developer.amazon.com/docs/smapi/skill-package-api-reference.html#skill-package-format)\.

1. Navigate to the file lambda > custom > index\.js \(in case of Node\.js\.\)\. This file contains your request handling code, which uses the [ASK SDK](https://developer.amazon.com/docs/quick-reference/use-sdks-quick-reference.html)\.

1. Choose **Edit**\.

1. Replace the string `Hello World!` in line 24 with the string `Hello. How are you?`\.

1. Scroll down to the end of the file\. Enter author name and email address and an optional commit message\.

1. Choose **Commit changes** to commit the changes to the repository\.

1. Return to the project dashboard in AWS CodeStar and check the **Continuous deployment** tile\. You should now see the pipeline deploying\.

1. When the pipeline finishes deployment, test your skill again in the Alexa Simulator\. Your skill should now respond with `Hello. How are you?`

## Step 5: Set up your local workstation to connect to your project repository<a name="alexa-tutorial-step5"></a>

Earlier you made a small change to the source code directly from the CodeCommit console\. In this step, you configure the project repository with your local workstation so that you can edit and manage code from the command line or your favorite IDE\. The following steps explain how to set up command line tools\.

1. Navigate to the project dashboard in AWS CodeStar, if necessary\.

1. In the left navigation bar, choose **Project**, then choose **Connect tools**\.

1. Choose **Command line tools**\.

1. In **Clone repository URL**, choose **HTTPS**\.

1. Choose **See instructions**\.

1. Follow the instructions to complete the following tasks:

   1. Install Git on your local workstation from a website such as [Git Downloads](https://git-scm.com/downloads)\.

   1. Install the AWS CLI\. For information, see [Installing the AWS Command Line Interface](http://docs.aws.amazon.com/cli/latest/userguide/installing.html)\.

   1. Configure the AWS CLI with your IAM user access key and secret key\. For information, see [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html)\.

   1. Clone the project's CodeCommit repository onto your local workstation\. For more information, see [Connect to an AWS CodeCommit Repository](https://docs.aws.amazon.com/codecommit/latest/userguide/how-to-connect.html)\.

## Next Steps<a name="alexa-tutorial-next"></a>

This tutorial showed you how to get started with a basic skill\. To continue your skill development journey, see the following resources\.
+ Understand the fundamentals of a skill by watching [How Alexa Skills Work](https://www.youtube.com/watch?v=hbH6gZoKcbM) and other videos on the Alexa Developers YouTube channel\.
+ Understand the various components of your skill by reviewing the documentation for the [skill package format](https://developer.amazon.com/docs/smapi/skill-package-api-reference.html#skill-package-format), the [skill manifest schemas](https://developer.amazon.com/docs/smapi/skill-manifest.html), and the [interaction model schemas](https://developer.amazon.com/docs/smapi/interaction-model-schema.html)\.
+ Turn your idea into a skill by reviewing the documentation for [Alexa Skills Kit](https://developer.amazon.com/docs/ask-overviews/build-skills-with-the-alexa-skills-kit.html) and the [ASK SDKs](https://developer.amazon.com/docs/quick-reference/use-sdks-quick-reference.html)\.