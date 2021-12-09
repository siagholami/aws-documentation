# Deleting an AWS CloudFormation stack by using the AWS Toolkit for JetBrains<a name="cloudformation-delete"></a>

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) that contains the stack, do that now\.

1. Expand **CloudFormation**\.

1. Right\-click the name of the stack to delete, and then choose **Delete CloudFormation Stack**\.  
![\[Choosing to delete a AWS CloudFormation stack starting from AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the stack's name to confirm it's deleted, and then choose **OK**\. If the stack deletion succeeds, the AWS Toolkit for JetBrains removes the stack name from the **CloudFormation** list in **AWS Explorer**\. If the stack deletion fails, you can troubleshoot by [viewing the event logs for the stack](key-tasks.md#key-tasks-cloudformation-logs)\.