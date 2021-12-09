# Update Code dialog box<a name="update-code-dialog"></a>

The **Update Code** dialog box in the AWS Toolkit for JetBrains is displayed whenever you [update an AWS Lambda function](key-tasks.md#key-tasks-sam-deploy)\.

![\[The Update Code dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Update Code** dialog box contains the following items\.

**Handler**  
*Required*\. The identifier of the corresponding function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html)\.

**Source Bucket**  
*Required*\. Choose an existing Amazon S3 bucket in the connected AWS account for the AWS Serverless Application Model Command Line Interface \(AWS SAM CLI\) to use to deploy the function to Lambda\. To create an Amazon S3 bucket in the account and have the AWS SAM CLI use that one instead, choose **Create**, and then follow the on\-screen instructions\.