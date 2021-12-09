# Working with Amazon EventBridge schemas<a name="eventbridge-schemas"></a>

You can use the AWS Toolkit for JetBrains to work with Amazon EventBridge Schemas as follows\.

**Note**  
Working with EventBridge Schemas is currently supported only by the AWS Toolkit for IntelliJ and the AWS Toolkit for PyCharm\.

The following information assumes you have already [set up the AWS Toolkit for JetBrains](getting-started.md)\.

**Contents**
+ [View a schema](#eventbridge-schemas-view)
+ [Find a schema](#eventbridge-schemas-find)
+ [Generate code for a schema](#eventbridge-schemas-generate-code)
+ [Create an AWS SAM application that uses a schema](#eventbridge-schemas-serverless-app)

## View an available schema<a name="eventbridge-schemas-view"></a>

1. With the [**AWS Explorer**](aws-explorer.md) tool window displayed, expand **Schemas**\.

1. Expand the name of the registry that contains the schema you want to view\. For example, many of the schemas that AWS supplies are in the **aws\.events** registry\.

1. To view the schema in the editor, right\-click the title of the schema, and on the context menu, choose **View Schema**\. 

## Find an available schema<a name="eventbridge-schemas-find"></a>

With the [**AWS Explorer**](aws-explorer.md) tool window displayed, do one of the following:
+ Begin typing the title of the schema you want to find\. The **AWS Explorer** highlights the titles of schemas that contain a match\.
+ Right\-click **Schemas**, and on the context menu, choose **Search Schemas**\. In the **Search EventBridge Schemas** dialog box, begin typing the title of the schema you want to find\. The dialog box displays the titles of schemas that contain a match\.
+ Expand **Schemas**\. Right\-click the name of the registry that contains the schema you want to find, and then choose **Search Schemas in Registry**\. In the **Search EventBridge Schemas** dialog box, begin typing the title of the schema you want to find\. The dialog box displays the titles of schemas that contain a match\.

To view a schema in the list of matches, do one of the following:
+ To display the schema in the editor, in **AWS Explorer**, right\-click the title of the schema, and then choose **View Schema**\. 
+ In the **Search EventBridge Schemas** dialog box, choose the title of the schema to display the schema\. 

## Generate code for an available schema<a name="eventbridge-schemas-generate-code"></a>

1. With the [**AWS Explorer**](aws-explorer.md) tool window displayed, expand **Schemas**\.

1. Expand the name of the registry that contains the schema you want to generate code for\.

1. Right\-click the title of the schema, and then choose **Download code bindings**\.

1. In the **Download code bindings** dialog box, choose the following:
   + The **Version** of the schema to generate code for\.
   + The supported programming **Language** and language version to generate code for\.
   + The **File location** where you want to store the generated code on the local development machine\.

1. Choose **Download**\.

## Create an AWS Serverless Application Model application that uses an available schema<a name="eventbridge-schemas-serverless-app"></a>

1. On the **File** menu, choose **New**, **Project**\. 

1. In the **New Project** dialog box, choose **AWS**\.

1. Choose **AWS Serverless Application**, and then choose **Next**\.

1. Specify the following:
   + A **Project name** for the project\.
   + A **Project location** on your local development machine for the project\.
   + A supported AWS Lambda **Runtime** for the project\.
   + An AWS Serverless Application Model \(AWS SAM\) **SAM Template** for the project\. The choices currently include the following:
     + **AWS SAM EventBridge Hello World \(EC2 Instance State Change\) ** – When deployed, creates an AWS Lambda function and an associated Amazon API Gateway endpoint in your AWS account\. By default, this function and endpoint respond only to an Amazon EC2 instance status change\.
     + **AWS SAM EventBridge App from Scratch \(for any Event trigger from a Schema Registry\)** – When deployed, creates an AWS Lambda function and an associated Amazon API Gateway endpoint in your AWS account\. This function and endpoint can respond to events that are available in the schema you specify\.

       If you choose this template, you must also specify the following:
       + The named profile, **Credentials**, to use\.
       + The AWS **Region** to use\.
       + The EventBridge **Event Schema** to use\.
   + The version of the SDK to use for the project \(**Project SDK**\)\.

After you create an AWS serverless application project, you can do the following:
+ [Deploy the application](sam-deploy.md)
+ [Change \(update\) the application's settings](sam-update.md)
+ [Delete the deployed application](sam-delete.md)

You can also do the following with Lambda functions that are part of the application:
+ [Run \(invoke\) or debug the local version of a function](invoke-lambda.md)
+ [Run \(invoke\) the remote version of a function](lambda-remote.md)
+ [Change a function's settings](lambda-update.md)
+ [Delete a function](lambda-delete.md)