# Shift Traffic for an AWS Lambda Project<a name="how-to-modify-serverless-project"></a>

AWS CodeDeploy supports function version deployments for AWS Lambda functions in your AWS CodeStar serverless projects\. An AWS Lambda deployment shifts incoming traffic from an existing Lambda function to an updated Lambda function version\. You might want to test an updated Lambda function by deploying a separate version and then rolling back the deployment to the first version if needed\.

Use the steps in this section to modify your AWS CodeStar project template and update your CodeStarWorker roles IAM permissions\. This task starts an automated response in AWS CloudFormation that creates aliased AWS Lambda functions and then instructs AWS CodeDeploy to shift traffic to an updated environment\.

**Note**  
Complete these steps only if you created your AWS CodeStar project before December 12, 2018\.

AWS CodeDeploy has three deployment options that allow you to shift traffic to versions of your AWS Lambda function in your application:
+ **Canary: **Traffic is shifted in two increments\. You can choose from predefined canary options that specify the percentage of traffic shifted to your updated Lambda function version in the first increment and the interval, in minutes, before the remaining traffic is shifted in the second increment\.
+ **Linear: **Traffic is shifted in equal increments with an equal number of minutes between each increment\. You can choose from predefined linear options that specify the percentage of traffic shifted in each increment and the number of minutes between each increment\. Traffic is shifted in equal increments with an equal number of minutes between each increment\. You can choose from predefined linear options that specify the percentage of traffic shifted in each increment and the number of minutes between each increment\.
+ **All\-at\-once: **All traffic is shifted from the original Lambda function to the updated Lambda function version at once\.


****  

| Deployment Preference Type | 
| --- | 
| Canary10Percent30Minutes | 
| Canary10Percent5Minutes | 
| Canary10Percent10Minutes | 
| Canary10Percent15Minutes | 
| Linear10PercentEvery10Minutes | 
| Linear10PercentEvery1Minute | 
| Linear10PercentEvery2Minutes | 
| Linear10PercentEvery3Minutes | 
| AllAtOnce | 

For more information about AWS CodeDeploy deployments on an AWS Lambda compute platform, see [Deployments on an AWS Lambda Compute Platform](https://docs.aws.amazon.com/codedeploy/latest/userguide/deployment-steps.html#deployment-steps-lambda)\.

For more information about AWS SAM, see [AWS Serverless Application Model \(AWS SAM\)](https://github.com/awslabs/serverless-application-model) on GitHub\.

**Prerequisites: **

When you create a serverless project, select any template with the Lambda compute platform\. You must be signed in as an administrator to perform steps 4\-6\.

**Topics**

**Step 1: Modify the SAM template to add AWS Lambda version deployment parameters**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Create a project or choose an existing project with a `template.yml` file, and then open the **Code** page\. In the top level of your repository, note the location of the SAM template named `template.yml` to be modified\.

1. Open the `template.yml` file in your IDE or local repository\. Copy the following text to add a `Globals` section to the file\. The sample text in this tutorial chooses the `Canary10Percent5Minutes` option\.

   ```
   Globals:
     Function:
       AutoPublishAlias: live
       DeploymentPreference: 
         Enabled: true
         Type: Canary10Percent5Minutes
   ```

   This example shows a modified template after the `Globals` section has been added:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-codedeploy-tutorial-template.png)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)

   For more information, see the [Globals Section](https://github.com/awslabs/serverless-application-model/blob/master/docs/globals.rst) reference guide for SAM templates\. 

**Step 2: Edit the AWS CloudFormation role to add permissions**

1. Sign in to the AWS Management Console and open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.
**Note**  
You must sign in to the AWS Management Console using credentials associated with the IAM user you created or identified in [Setting Up AWS CodeStar](setting-up.md)\. This user must have the AWS managed policy named **`AWSCodeStarFullAccess`** attached\.

1. Choose your existing serverless project and then open the **Project resources** page\.

1. Under **Resources**, choose the IAM role created for the CodeStarWorker/AWS CloudFormation role\. The role opens in the IAM console\. 

1. On the **Permissions** tab, in **Inline Policies**, in the row for your service role policy, choose **Edit Policy**\. Choose the **JSON** tab to edit the policy in JSON format\.
**Note**  
Your service role is named `CodeStarWorkerCloudFormationRolePolicy`\.

1. In the **JSON** field, add the following policy statements within the `Statement` element\. Replace the *region* and *id* placeholders with your region and account ID\.

   ```
   {
     "Action": [
       "s3:GetObject",
       "s3:GetObjectVersion",
       "s3:GetBucketVersioning"
     ],
     "Resource": "*",
     "Effect": "Allow"
   },
   {
     "Action": [
       "s3:PutObject"
     ],
     "Resource": [
       "arn:aws:s3:::codepipeline*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "lambda:*"
     ],
     "Resource": [
       "arn:aws:lambda:region:id:function:*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "apigateway:*"
     ],
     "Resource": [
       "arn:aws:apigateway:region::*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "iam:GetRole",
       "iam:CreateRole",
       "iam:DeleteRole",
       "iam:PutRolePolicy"
     ],
     "Resource": [
       "arn:aws:iam::id:role/*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "iam:AttachRolePolicy",
       "iam:DeleteRolePolicy",
       "iam:DetachRolePolicy"
     ],
     "Resource": [
       "arn:aws:iam::id:role/*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "iam:PassRole"
     ],
     "Resource": [
       "*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "codedeploy:CreateApplication",
       "codedeploy:DeleteApplication",
       "codedeploy:RegisterApplicationRevision"
     ],
     "Resource": [
       "arn:aws:codedeploy:region:id:application:*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "codedeploy:CreateDeploymentGroup",
       "codedeploy:CreateDeployment",
       "codedeploy:DeleteDeploymentGroup",
       "codedeploy:GetDeployment"
     ],
     "Resource": [
       "arn:aws:codedeploy:region:id:deploymentgroup:*"
     ],
     "Effect": "Allow"
   },
   {
     "Action": [
       "codedeploy:GetDeploymentConfig"
     ],
     "Resource": [
       "arn:aws:codedeploy:region:id:deploymentconfig:*"
     ],
     "Effect": "Allow"
   }
   ```

1. Choose **Review policy** to ensure the policy contains no errors\. When the policy is error\-free, choose **Save changes**\.

**Step 3: Commit and push your template change to start the AWS Lambda version shift**

1. Commit and push the changes in the `template.yml` file that you saved in step 1\.
**Note**  
This starts your pipeline\. If you commit the changes before you update IAM permissions, your pipeline starts and the AWS CloudFormation stack update encounters errors that roll back the stack update\. If this happens, restart your pipeline after permissions have been corrected\.

1. The AWS CloudFormation stack update starts when the pipeline for your project starts the **Deploy** stage\. To see the stack update notification when the deployment starts, on your AWS CodeStar dashboard, select the AWS CloudFormation stage in your pipeline\.

   During stack update, AWS CloudFormation automatically updates the project resources as follows:
   + AWS CloudFormation processes the `template.yml` file by creating aliased Lambda functions, event hooks, and resources\.
   + AWS CloudFormation calls Lambda to create the new version of the function\.
   + AWS CloudFormation creates an AppSpec file and calls AWS CodeDeploy to shift the traffic\.

   For more information about publishing aliased Lambda functions in SAM, see the [AWS Serverless Application Model \(SAM\)](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md) template reference\. For more information about event hooks and resources in the AWS CodeDeploy AppSpec file, see [AppSpec 'resources' Section \(AWS Lambda Deployments Only\)](https://docs.aws.amazon.com/codedeploy/latest/userguide/reference-appspec-file-structure-resources.html) and [AppSpec 'hooks' Section for an AWS Lambda Deployment](https://docs.aws.amazon.com/codedeploy/latest/userguide/reference-appspec-file-structure-hooks.html#appspec-hooks-lambda)\.

1. After successful completion of your pipeline, the resources are created in your AWS CloudFormation stack\. On the **Project** page, in the **Project Resources** list, view the AWS CodeDeploy application, the AWS CodeDeploy deployment group, and the AWS CodeDeploy service role resources created for your project\.

1. To create a new version, make a change to the Lambda function in your repository\. The new deployment starts and shifts traffic according to the deployment type indicated in the SAM template\. To view the status of the traffic that is being shifted to the new version, on the **Project** page, in the **Project Resources** list, choose the link to the AWS CodeDeploy deployment\.

1. To view details about each revision, under **Revisions**, choose the link to the AWS CodeDeploy deployment group\.

1. In your local working directory, you can make changes to your AWS Lambda function and commit the change to your project repository\. AWS CloudFormation supports AWS CodeDeploy in managing the next revision in the same way\. For more information about redeploying, stopping, or rolling back a Lambda deployment, see [Deployments on an AWS Lambda Compute Platform](https://docs.aws.amazon.com/codedeploy/latest/userguide/deployment-steps.html#deployment-steps-lambda)\.