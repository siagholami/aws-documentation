# Deleting an AWS serverless application by using the AWS Toolkit for JetBrains<a name="sam-delete"></a>

Before deleting an AWS serverless application, you must first [deploy it](key-tasks.md#key-tasks-sam-deploy)\.

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) that contains the serverless application, do that now\.

1. Expand **CloudFormation**\.

1. Right\-click the name of the AWS CloudFormation stack that contains the serverless application you want to delete, and then choose **Delete CloudFormation Stack**\.  
![\[Choosing to delete the AWS CloudFormation stack for an AWS serverless application starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the stack's name to confirm the deletion, and then choose **OK**\. If the stack deletion succeeds, the AWS Toolkit for JetBrains removes the stack name from the **CloudFormation** list in **AWS Explorer**\. If the stack deletion fails, you can try to figure out why by [viewing event logs for the stack](key-tasks.md#key-tasks-cloudformation-logs)\.