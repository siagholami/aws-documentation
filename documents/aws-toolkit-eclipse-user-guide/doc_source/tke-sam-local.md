# Debug Serverless Applications Using AWS SAM Local<a name="tke-sam-local"></a>

This tutorial guides you through debugging a serverless application project with the AWS Toolkit for Eclipse using AWS SAM Local\. SAM Local is the AWS CLI tool for managing serverless applications written with the AWS Serverless Application Model \(AWS SAM\)\. See the SAM Local [README](https://github.com/awslabs/aws-sam-local) for more information\.

## Prerequisites<a name="prerequisites"></a>

To use this tutorial, you must have the AWS Toolkit for Eclipse, Docker, and AWS SAM Local installed\. See the AWS SAM Local [README](https://github.com/awslabs/aws-sam-local#installation) for Docker and SAM Local installation instructions\. See the [Getting Started](getting-started.md) topic for instructions on installing and setting up the AWS Toolkit for Eclipse\.

**Note**  
To use the AWS SAM Local feature of the AWS Toolkit for Eclipse, your project must be a valid Maven Project with a valid pom\.xml file\.

After you install the required tools, open the Eclipse **Preferences** dialog box from the **Eclipse** menu\. Configure the **SAM Local Executable** path, as shown\. This enables the AWS Toolkit for Eclipse to know where to find your SAM Local installation\.

![\[SAM local dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-executable-screenshot.png)

## Import the SAM Application from AWS CodeStar<a name="import-the-sam-application-from-acslong"></a>

For this tutorial, you need a sample project in AWS CodeStar\. See the [Creating a Serverless Project in AWS CodeStar](https://docs.aws.amazon.com/codestar/latest/userguide/sam-tutorial.html#sam-tutorial-create-project) tutorial in the AWS CodeStar User Guide to create a sample project\.

**To import SAM app from AWS CodeStar**

1. On the Eclipse toolbar, open the Amazon Web Services menu \(identified by the AWS homepage icon\), and then choose **Import AWS CodeStar Project**\. Or, on the Eclipse menu bar, choose **File**, **Import**, **AWS**, **AWS CodeStar Project**\.

1. Choose the region that the sample application was created in\.

1. Choose your sample project from the **Project Name** list\.

1. Add in your Git credentials\. See the [AWS CodeCommit User Guide](https://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-gc.html) to learn how to get Git credentials for CodeCommit\.  
![\[SAM Local import in AWS CodeStar Project Selection dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-codestar-import.png)

1. Choose **Next**\.

1. Choose **Next** on the **Branch Selection** page\.

1. Choose **Finish** on the **Local Destination** page\.

Next, you can debug this serverless application locally using SAM Local within Eclipse\.

## Debug Lambda Function Locally<a name="debug-lam-function-locally"></a>

Create a debug configuration for your serverless application and use SAM Local to run the application locally\.

**To debug the Lambda function locally**

1. In the Eclipse **Project Explorer**, open `HelloWorldHandler.java`\.

1. Right\-click in your Eclipse code window, choose **Debug As**, and then choose **AWS SAM Local**\.  
![\[SAM Local debug dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-debug-config.png)

1. For this example, leave the **Project** and **Template** as they are\.

1. Choose **Lambda Function** in the **Run as** field\.

1. Choose **GetHelloWorld** in the **Function identifier** field\.

1. For this example, we will provide an Amazon S3 event\. Choose **Generate** next to the **Event** input box\.  
![\[SAM Local debug dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-debug-config-event.png)

1. Choose a region that has your Amazon S3 bucket\.

1. Enter a valid Amazon S3 bucket name\.

1. Enter a valid Amazon S3 object key, and then choose **OK**\.

1. On the **Save As** page, select the current project and enter a name for the event file\. In this example, we used **s3\-event\.json**\.  
![\[SAM Local debug dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-debug-config-event-file.png)

1. Choose **OK** to save the event file and get back to the main dialog box\.

1. Leave the advanced settings as they are\. See [Advanced Settings](#sam-local-advanced-settings) to learn more about those fields\.

1. Choose **Apply**, and then choose **Debug**\.

This runs the Lambda function locally\. You can set breakpoints as you would for other applications to debug the code\.

## Test API Gateway Locally<a name="test-abp-locally"></a>

You can also test the HTTP request/response functionality with SAM Local\.

**To test API Gateway locally**

1. Right\-click in your Eclipse code window, choose **Debug As**, **Debug Configuration**\.  
![\[SAM Local debug dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-debug-config-api.png)

1. Create a new Debug Configuration for this run and name it something different\.

1. Choose **API Gateway** in the **Run as** field\.

1. Leaving all other fields as they are, your configuration should look similar to the following\.  
![\[SAM Local debug dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-debug-config-api-2.png)

1. Choose **Apply**, and then choose **Debug**\.

This spawns a local API gateway that you can use to test your application\. The debug output will contain HTTP links that can be used to verify the request/response functionality of your code\.

![\[Example SAM Local debug output for api gateway\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-api-debug-output.png)

## Advanced Settings<a name="sam-local-advanced-settings"></a>

This section describes the advanced options available on the SAM Local Debug configurations page\.

![\[SAM Local debug dialog box advanced options\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/sam-local-debug-config-advanced.png)

### AWS Configuration<a name="aws-configuration"></a>

**Select profile**  
\(Required\) The profile to use for AWS credentials\.  
\(Default\) The default profile

**Select region**  
\(Required\) The region that the application is deployed to\.  
\(Default\) US East \(Virginia\)

### SAM Local Configuration<a name="sam-local-configuration"></a>

**Maven goals**  
\(Required\) Maven goals to execute when building the application\. You must customize these goals if the default does not generate a Jar file with all the dependencies included \(fat Jar\)\. See [Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/) in Maven Project to learn how to use the plugin to create a fat Jar\.  
\(Default\) clean package

**SAM runtime**  
\(Required\) Path to the SAM executable\.  
\(Default\) /usr/local/bin/sam

**Debug port**  
\(Required\) Port that the Eclipse debugger uses to connect to SAM Local\.  
\(Default\) 5858

**Env vars**  
\(Optional\) Path to a JSON file that contains values for environment variables used by Lambda functions\. See [Environment variable files](https://github.com/awslabs/aws-sam-local#environment-variable-file) in the SAM Local user guide to learn the required syntax for this file\.  
\(Default\) Empty

### Lambda Function Configuration<a name="lambda-function-configuration"></a>

**Code URI**  
\(Optional\) Path to the code archive file\. For the example on this page, it would be the path to the \.jar file\.  
\(Default\) Path in the template\.yml file

**Timeout**  
\(Required\) Lambda function runtime timeout\.  
\(Default\) 300

## More Info<a name="more-info"></a>

For more information about AWS SAM Local, see the [AWS SAM Local](https://github.com/awslabs/aws-sam-local) user guide in GitHub\. For more information about the AWS Serverless Application Model \(SAM\), see the [AWS SAM](https://github.com/awslabs/serverless-application-model) project in GitHub\.