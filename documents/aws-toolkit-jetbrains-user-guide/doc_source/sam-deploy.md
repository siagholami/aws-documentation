# Deploying an AWS serverless application by using the AWS Toolkit for JetBrains<a name="sam-deploy"></a>

To complete this procedure, you must first [create the AWS serverless application](key-tasks.md#key-tasks-sam-create) that you want to deploy, if you haven't created it already\.
**Note**  
To deploy a serverless application that contains an AWS Lambda function, and deploy that function with any nondefault or optional properties, you must first set those properties in the function's corresponding AWS Serverless Application Model \(AWS SAM\) template file \(for example, in a file named `template.yaml` within the project\)\. For a list of available properties, see [AWS::Serverless::Function](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#awsserverlessfunction) in the [awslabs/serverless\-application\-model](https://github.com/awslabs/serverless-application-model/) repository on GitHub\.

1. If you need to [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) to deploy the serverless application, do that now\. 

1. With the **Project** tool window already open and displaying the project that contains the serverless application's files, right\-click the project's `template.yaml` file\. Then choose **Deploy Serverless Application**\.  
![\[Choosing the Deploy Serverless Application command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [Deploy Serverless Application](deploy-serverless-application-dialog.md) dialog box, and then choose **Deploy**\. 

   The AWS Toolkit for JetBrains creates a corresponding AWS CloudFormation stack for the deployment\. It also adds the name of the stack to the **CloudFormation** list in **AWS Explorer**\. If the deployment fails, you can try to figure out why by [viewing event logs for the stack](key-tasks.md#key-tasks-cloudformation-logs)\.

After you deploy it, you can [run \(invoke\) the remote version of an AWS Lambda function](key-tasks.md#key-tasks-lambda-remote) that is part of that deployed application\.