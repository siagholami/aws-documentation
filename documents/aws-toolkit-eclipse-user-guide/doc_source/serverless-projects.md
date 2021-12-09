# Serverless Projects<a name="serverless-projects"></a>

The AWS Toolkit for Eclipse includes a project creation wizard that you can use to quickly configure and create serverless projects that deploy on AWS CloudFormation and run Lambda functions in response to RESTful web requests\.

## Creating a Serverless Project<a name="creating-a-serverless-project"></a>

**To create a serverless project**

1. Select the AWS icon in the toolbar, and choose **New AWS serverless project…** from the menu that appears\.

1. Enter a **Project name**\.

1. Enter a **Package namespace** for your project\. This will be used as the prefix for the source namespaces created for your project\.

1. Choose either to **Select a blueprint** or to **Select a serverless template file**:  
**Select a Blueprint**  
Choose a [pre\-defined project blueprint](#serverless-blueprints) to use for your serverless project\.  
**Select a Serverless Template File**  
Choose a JSON\-formatted Serverless Application Model \(SAM\) `.template` file on your filesystem to fully customize your serverless project\.
**Note**  
For information about the structure and contents of a `.template` file, view the [current version of the specification](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md) on GitHub\.

1. Press the **Finish** button to create your new serverless project\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/serverless-project-create.png)

## Serverless Project Blueprints<a name="serverless-blueprints"></a>

The following serverless project blueprints are available to use:

**article**  
This blueprint creates a S3 Bucket for storing article content, and a DynamoDB Table for article metadata\. It contains Lambda functions for retrieving \(`GetArticle`\) and storing \(`PutArticle`\) articles, which are triggered by API Gateway events\.

**hello\-world**  
A simple blueprint that creates a Lambda function which takes a single string\. Its output is `Hello, value `, where *value* is the string that was passed in, or `World` if no string is passed to the function\.

## Serverless Project Structure<a name="serverless-structure"></a>

The serverless project wizard will create a new Eclipse project for you, consisting of the following parts:
+ The `src` directory contains two sub\-directories, each prefaced with your chosen **Package namespace**:  
**mynamespace\.function**  
Contains class files for the Lambda functions that are defined by your serverless template\.  
**mynamespace\.model**  
Contains generic `ServerlessInput` and `ServerlessOutput` classes that define the input and output model for your Lambda functions\.  
For more information about the input and output formats used in the model classes, see the [Configure Proxy Integration for a Proxy Resource](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-set-up-simple-proxy.html) page in the API Gateway Developer Guide\.
+ The `serverless.template` file defines the AWS resources and Lambda functions \(a resource of type “AWS::Serverless:Function”\) used by your project\.

## Deploying a Serverless Project<a name="serverless-deploy"></a>

**To deploy your serverless project**

1. In Eclipse’s **Project Explorer** window, select your project and open the context menu \(right\-click or long press\)\.

1. Choose **Amazon Web Services ‣ Deploy Serverless Project…** on the context menu\. This will bring up the **Deploy Serverless to AWS CloudFormation** dialog\.

1. Select the **AWS Regions** to use\. This determines where the AWS CloudFormation stack that you deploy is located\.

1. Choose an **S3 Bucket** to use to store your Lambda function code, or select the **Create** button to create a new S3 bucket to store your code\.

1. Choose a name for your AWS CloudFormation stack\.

1. Press the **Finish** button to upload your Lambda functions to Amazon S3 and deploy your project template to AWS CloudFormation\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/serverless-project-deploy.png)

When your project is deployed, a AWS CloudFormation stack detail window will appear that provides information about your deployment and its current status\. It will initially show its status as `CREATE_IN_PROGRESS`\. When the status is `CREATE_COMPLETE`, your deployment is active\.

To return to this window at any time, open the **AWS Explorer**, select the **AWS CloudFormation** node, and then select the name of the AWS CloudFormation stack you specified\.

**Note**  
If there was an error during deployment, your stack may be rolled back\. See [Troubleshooting](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/troubleshooting.html) in the AWS CloudFormation User Guide for information about how to diagnose stack deployment errors\.

## See Also<a name="see-also"></a>
+  [AWS Serverless Application Model \(GitHub\)](https://github.com/awslabs/serverless-application-model) 
+  [The AWS CloudFormation Template Editor](tke-cfn-editor.md) 
+  [Using Lambda with the AWS Toolkit for Eclipse](lambda.md) 