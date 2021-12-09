# Update Configuration dialog box<a name="update-configuration-dialog"></a>

The **Update Configuration** dialog box in the AWS Toolkit for JetBrains is displayed whenever you [change \(update\) the configuration for an AWS Lambda function](key-tasks.md#key-tasks-lambda-update)\.

![\[The Update Configuration dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Update Configuration** dialog box contains the following items\.

**Name**  
*Required*\. The function's name\. Can contain only the uppercase letters `A` through `Z`, the lowercase letters `a` through `z`, the numbers `0` through `9`, the hyphen character \(`-`\), and the underscore character \(`_`\)\. This name must be less than 64 characters in length\.

**Description**  
*Optional*\. Any meaningful description about the function\. 

**Handler**  
*Required*\. The identifier of the corresponding [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [C\#](https://docs.aws.amazon.com/lambda/latest/dg/dotnet-programming-model-handler-types.html)\. 

**Runtime**  
*Required*\. The identifier of the [runtime](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for Lambda to use\.

**Timeout \(seconds\)**  
*Required*\. The amount of time that Lambda allows a function to run before stopping it\. Specify an amount of up to 900 seconds \(15 minutes\)\.

**Memory \(MB\)**  
*Required*\. The amount of memory available to the function during its execution\. Specify an amount [between 128 MB and 3,008 MB](https://docs.aws.amazon.com/lambda/latest/dg/limits.html) in 64\-MB increments\.

**Environment Variables**  
*Optional*\. Any [environment variables](https://docs.aws.amazon.com/lambda/latest/dg/env_variables.html) for the function to use, specified as key\-value pairs\. To add, change, or delete environment variables, choose the folder icon, and then follow the on\-screen instructions\.

**IAM Role**  
*Required*\. Choose an available [Lambda execution role](https://docs.aws.amazon.com/lambda/latest/dg/lambda-intro-execution-role.html) in the connected AWS account for Lambda to use for the function\. To create an execution role in the account and have Lambda use that one instead, choose **Create**, and then follow the on\-screen instructions\. For more information, see [AWS Lambda Execution Role](https://docs.aws.amazon.com/lambda/latest/dg/lambda-intro-execution-role.html) in the *AWS Lambda Developer Guide*\.

**Enable AWS X\-Ray**  
*Optional*\. If selected, Lambda enables AWS X\-Ray to detect, analyze, and optimize performance issues with the function\. X\-Ray collects metadata from the Lambda service and any upstream or downstream services that make up your function\. X\-Ray uses this metadata to generate a detailed service graph that shows performance bottlenecks, latency spikes, and other issues that impact the performance of your function\. For more information, see [Using AWS X\-Ray](https://docs.aws.amazon.com/lambda/latest/dg/lambda-x-ray.html) in the *AWS Lambda Developer Guide*\.