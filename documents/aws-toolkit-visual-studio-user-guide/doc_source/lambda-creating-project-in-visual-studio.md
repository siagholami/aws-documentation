# Tutorial: Using the AWS Lambda Project in the AWS Toolkit for Visual Studio<a name="lambda-creating-project-in-visual-studio"></a>

Using the AWS Lambda \.NET Core project templates for Visual Studio you can easily create a AWS Lambda Function using Microsoft \.NET Core\.

For prerequisites and information about setting up the AWS Toolkit for Visual Studio, see [Using the AWS Lambda Templates in the AWS Toolkit for Visual Studio](lambda-index.md)\.

## Create a Visual Studio \.NET Core Lambda Project<a name="create-a-visual-studio-net-core-lam-project"></a>

1. Open Visual Studio, and on the **File** menu, choose **New**, **Project**\.

1. **For Visual Studio 2017**:

   In the **New Project** dialog box, expand **Installed**, expand **Visual C\#**, and select **AWS Lambda**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-05-Core-Lambda-VS2017.png)

   **For Visual Studio 2019**:

   In the **New Project** dialog box, ensure that the **Language**, **Platform**, and **Project type** drop\-down boxes are set to "All \.\.\." and type *aws lambda* in the **Search** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-05-Core-Lambda-VS2019.png)

   There are two types of project to choose from:
   + AWS Lambda projects for creating a project to develop and deploy an individual Lambda function\.
   + AWS Serverless Applications projects for creating Lambda functions with a serverless AWS CloudFormation template\. AWS serverless applications enable you to define more than just the function\. For example, you can simultaneously create a database, add IAM roles, etc\., with serverless deployment\. AWS serverless applications also enable you to deploy multiple functions at one time\.

1. Select the **AWS Lambda Project \(\.NET Core \- C\#\)** template\.

1. **For Visual Studio 2017**:

   Enter the desired **Name**, **Location**, etc\., for your template project, then click **OK**\.

   **For Visual Studio 2019**:

   Click **Next**\. In the next dialog, enter the desired **Name**, **Location**, etc\., for your template project, then click **Create**\.

1. After you select the project type, choose a blueprint\. For **AWS Lambda Project \(\.NET Core\)**, the **Select Blueprint** page shows several Lambda function templates\.  
![\[Blueprints for an AWS Lambda project\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/blueprints.png)

1. Choose the type of Lambda function you want to develop, and then choose **Finish** to create the Visual Studio project\. You can now review the project's structure and code\.

## Review the Project Files<a name="review-the-project-files"></a>

Examine the `aws-lambda-tools-defaults.json` file, which is created as part of your project\. You can set the options in this file, which is read by the Lambda tooling by default\. The project templates created in Visual Studio set many of these fields with default values\. This is where the function handler is specified which is why you don't have to set it in the wizard\. But if you rename the Function, Class or Assembly then you will need to update the field in the `aws-lambda-tools-defaults.json` file\.

```
{
  "profile":"default",
  "region" : "us-east-2",
  "configuration" : "Release",
  "framework" : "netcoreapp1.0",
  "function-runtime":"dotnetcore1.0",
  "function-memory-size" : 256,
  "function-timeout" : 30,
  "function-handler" : "BlogExample::BlogExample.Function::FunctionHandler"
}
```

When you use this aws\-lambda\-tools\-default\.json file, the only things left that the Lambda tooling needs to deploy the function are the name of the Lambda function and the IAM role\.

Your project is now ready to publish to Lambda\.

## Publish to Lambda<a name="publish-to-lam"></a>

To publish your function to Lambda:

1. In **Solution Explorer**, right\-click the project, and then choose **Publish to AWS Lambda**\.  
![\[Publishing a Visual Studio project to AWS Lambda\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/Publish.png)

1. On the **Upload Lambda Function** page, in **Function Name**, type a name for the function or select a previously published function to republish\. Then choose **Next**\.  
![\[Upload screen for Lambda function\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/Upload.png)

1. In the **Advanced Function Details** page, set the fields as follows:
   +  **Required:** Provide a **Role Name** for a role associated with your account\. Choose an existing role or a new role based on an AWS managed policy or your own managed policy\. The role is used to provide credentials for any AWS service calls made by the code in the function\. Your account must have permission to run the IAM ListPolicies action, or the **Role Name** list will be empty and you will be unable to continue\.
   +  *Optional:* If your Lambda function accesses resources on an Amazon VPC, select the subnets and security groups\.
   +  *Optional:* Set any environment variables that your Lambda function needs\. The keys are automatically encrypted by the default service key \(which is free\) or you can specify an AWS KMS key \(for which there is a charge\)\. [KMS](https://aws.amazon.com/kms/) is a managed service you can use to create and control the encryption keys used to encrypt your data\. If you have an AWS KMS key, you can select it from the list\.

1. Choose **Upload**\.  
![\[Set Lambda function details in the Advanced Function Details page\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/AdvancedFunction.png)

1. The **Uploading Function** page is shown while the function is uploading, and automatically closes when the upload completes\. To keep the wizard open so you can view the report, clear **Automatically close wizard on successful completion** at the bottom of the form before the upload completes\. Close the page when you finish viewing the report\.  
![\[Uploading Function page\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/uploading.png)

1. After the function is uploaded, the **Function** page opens\. Use the tabs on the left side of the page to test the function, add event sources, and view the log\. Use the **Configuration** tab to add VPC subnets and security groups, memory, timeout, and environment variables\.  
![\[Function page showing an example request for testing a function\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/FunctionPage.png)

1. To add event sources to establish a connection between an AWS resource \(such as an Amazon S3 bucket, Amazon SNS topic, or Amazon Kinesis Data Streams streams\) and a Lambda function, choose **Event Sources**\. This will display the **Add Event Source** page\.

   On the **Add Event Source** page, from **Source Type**, choose the appropriate event source and choose **OK** to add the event source\.  
![\[Add Event Source page\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/EventSources.png)

1. To test the function, in **Example Requests**, choose an example request\.  
![\[Function page showing an example request for testing a function\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/testfunction.png)

1. To run the test, choose **Invoke**\.  
![\[Invoking the test function page\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/invoke.png)

1. View the output from the test in **Log output**\.  
![\[Function test output log\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/logoutput.png)

After your Lambda function is published, it's ready to use\. For use cases, see [Examples of How to Use AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/use-cases.html)\.

Lambda automatically monitors Lambda functions for you, reporting metrics through Amazon CloudWatch\. To monitor and troubleshoot your function, see [Troubleshooting and Monitoring AWS Lambda Functions with Amazon CloudWatch](https://docs.aws.amazon.com/lambda/latest/dg/monitoring-functions.html)\.