# Deploy Serverless Application dialog box<a name="deploy-serverless-application-dialog"></a>

The **Deploy Serverless Application** dialog in the AWS Toolkit for JetBrains is displayed when you [deploy an AWS serverless application](key-tasks.md#key-tasks-sam-deploy)\.

![\[The Deploy Serverless Application dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Deploy Serverless Application** dialog box contains the following items\.

**Create Stack**  
Either **Create Stack** or **Update Stack** is *required* \(but not both\)\. Provide the name of the stack for the AWS Serverless Application Model Command Line Interface \(AWS SAM CLI\) to create in AWS CloudFormation for the connected AWS account\. The AWS SAM CLI then uses this stack to deploy the AWS serverless application\.

**Update Stack**  
Either **Create Stack** or **Update Stack** is *required* \(but not both\)\. Choose the name of an existing AWS CloudFormation stack for the AWS SAM CLI to use in the connected AWS account to deploy the AWS serverless application\. 

**Template Parameters**  
*Optional*\. Any parameters that the AWS Toolkit for JetBrains detects in the corresponding project's `template.yaml` file\. To specify a value for a parameter, choose the box in the **Value** column next to the parameter, enter the value, and then press **Enter**\. For more information, see [Parameters](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/parameters-section-structure.html) in the *AWS CloudFormation User Guide*\.

**S3 Bucket**  
*Required*\. Choose an existing Amazon Simple Storage Service \(Amazon S3\) bucket in the connected AWS account for the AWS SAM CLI to use to deploy the AWS serverless application\. To create an Amazon S3 bucket in the account and have the AWS SAM CLI use that one instead, choose **Create**, and then follow the on\-screen instructions\.

**Require confirmation before deploying**  
*Optional*\. If selected, instructs AWS CloudFormation to wait for you to finish creating or updating the corresponding stack by [executing the stack's current change set in AWS CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-cfn-updating-stacks-changesets-execute.html)\. If you don't execute this change set, the AWS serverless application won't move on to the deployment phase\.

**Build function inside a container**  
*Optional*\. If selected, the AWS SAM CLI builds any of the serverless application's functions inside of an AWS Lambda\-like Docker container locally before deployment\. This is useful if the function depends on packages that have natively compiled dependencies or programs\. For more information, see [Building Applications with Dependencies](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-build.html) in the *AWS Serverless Application Model Developer Guide*\.