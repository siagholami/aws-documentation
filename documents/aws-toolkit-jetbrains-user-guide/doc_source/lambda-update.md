# Changing \(updating\) AWS Lambda function settings by using the AWS Toolkit for JetBrains<a name="lambda-update"></a>

To use the AWS Toolkit for JetBrains to change \(update\) the settings for an AWS Lambda function, do one of the following\.
+ With the code file open that contains the function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html), on the main menu, choose **Run**, **Edit Configurations**\. Complete the [Run/Debug Configurations](run-debug-configurations-dialog.md) dialog box, and then choose **OK**\.
+ [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) that contains the function, do that now\. Expand **Lambda**, choose the name of the function to change the configuration for, and then do one of the following:
  + **Change settings such as the timeout, memory, environment variables, and execution role –** Right\-click the name of the function, and then choose **Update Function Configuration**\.  
![\[Choosing the Update Function Configuration command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

    Complete the [Update Configuration](update-configuration-dialog.md) dialog box, and then choose **Update**\. 
  + **Change settings such as the input payload** – On the main menu, choose **Run**, **Edit Configurations**\. Complete the [Run/Debug Configurations](run-debug-configurations-dialog.md) dialog box, and then choose **OK**\.  
![\[Choosing the Edit Configurations command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

    If the configuration details are missing, first expand **Templates**, **AWS Lambda**, and then choose **Local** \(for the local version of the function\) or **Remote** \(for the remote version of that same function\)\. Choose **OK**, and then repeat this procedure from the beginning\.\)
  + **Change settings such as the function handler name or Amazon Simple Storage Service \(Amazon S3\) source bucket** – Right\-click the function name, and then choose **Update Function Code**\.  
![\[Choosing the Update Function Code command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

    Complete the [Update Code](update-code-dialog.md) dialog box, and then choose **Update**\.
  + **Change other available property settings that aren't listed in the preceding bullets** – Change those settings in the function's corresponding AWS SAM template file \(for example, in a file named `template.yaml` within the project\)\. 

    For a list of available property settings, see [AWS::Serverless::Function](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#awsserverlessfunction) in the [awslabs/serverless\-application\-model](https://github.com/awslabs/serverless-application-model/) repository on GitHub\. 