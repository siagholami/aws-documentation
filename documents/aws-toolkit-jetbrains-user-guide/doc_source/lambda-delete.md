# Deleting an AWS Lambda function by using the AWS Toolkit for JetBrains<a name="lambda-delete"></a>

You can use the AWS Toolkit to delete an AWS Lambda function that is part of an AWS serverless application, or you can delete a standalone Lambda function\.

To delete a Lambda function that is part of an AWS serverless application, skip the rest of this topic and see [Deleting an application](sam-delete.md) instead\.

To delete a standalone Lambda function, do the following\.

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. If you need to [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) that contains the function, do that now\.

1. Expand **Lambda**\.

1. Right\-click the name of the function to delete, and then choose **Delete Function**\.  
![\[Choosing the Delete Function command\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the function's name to confirm the deletion, and then choose **OK**\. If the function deletion succeeds, the AWS Toolkit for JetBrains removes the function name from the **Lambda** list\.