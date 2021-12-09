# Running \(invoking\) the remote version of an AWS Lambda function by using the AWS Toolkit for JetBrains<a name="lambda-remote"></a>

A *remote* version of an AWS Lambda function is a function whose source code already exists inside of the Lambda service for an AWS account\.

To complete this procedure, you must first [install the ](key-tasks.md#key-tasks-install)AWS Toolkit for JetBrains and, if you haven't yet, [connect to an AWS account for the first time](key-tasks.md#key-tasks-first-connect)\. Then with IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider running, do the following\.

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) that contains the function, do that now\.

1. Expand **Lambda**, and confirm that the name of the function is listed\. If it is, skip ahead to step 3 in this procedure\.

   If the name of the function isn't listed, [create the Lambda function](key-tasks.md#key-tasks-lambda-create) that you want to run \(invoke\)\. 

   If you created the function as [part of an AWS serverless application](key-tasks.md#key-tasks-lambda-create-app), you must also [deploy that application](key-tasks.md#key-tasks-sam-deploy)\.

   If you created the function by creating a code file that implements a function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html), then in the code file, choose the Lambda icon next to the function handler\. Then choose **Create new AWS Lambda**\. Complete the [Create Function](create-function-dialog.md) dialog box, and then choose **Create Function**\.

1. With **Lambda** open in **AWS Explorer**, right\-click the name of the function, and then choose **Run '\[Remote\]'**\.  
![\[Running the remote version of a Lambda function by starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [Edit configuration](edit-configuration-dialog.md) dialog box if it's displayed, and then choose **Run** or **Debug**\. Results are displayed in the **Run** or **Debug** tool window\.
   + If the **Edit configuration** dialog box doesn't appear and you want to change the existing configuration, first [change its configuration](key-tasks.md#key-tasks-lambda-update), and then repeat this procedure from the beginning\. 
   + If the configuration details are missing, expand **Templates**, **AWS Lambda**, and then choose **Local**\. Choose **OK**, and then repeat this procedure from the beginning\. 