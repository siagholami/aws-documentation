# Tutorial: How to Create, Upload, and Invoke an AWS Lambda Function<a name="lambda-tutorial"></a>

This tutorial guides you through the process of a typical AWS Lambda workflow, and provides you with first\-hand experience using Lambda with the AWS Toolkit for Eclipse\.

**Important**  
The tutorial assumes that you have an AWS account, have already [installed the AWS Toolkit for Eclipse](getting-started.md), and that you understand the basic concepts and features of Lambda\. If you’re unfamiliar with Lambda, learn more at the [Lambda](https://aws.amazon.com/lambda/) home page and in the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)\.

## Create an AWS Lambda Project<a name="lambda-tutorial-create-handler-class"></a>

To begin a Lambda project, you first implement the code as a method in a handler class\. The AWS Toolkit for Eclipse provides a new project wizard to help you create a new handler class\. The Lambda project is a Maven project that uses a POM\.xml file to manage package dependencies\. You can use the Maven command line tool for building, testing, and deploying your application\. For more information about Maven, see the [Maven project documentation](https://maven.apache.org)\.

**To create an AWS Lambda project**

1. On the Eclipse toolbar, open the Amazon Web Services menu \(identified by the AWS homepage icon\), and then choose **New AWS Lambda Java project**\. Or on the Eclipse menu bar, choose **File**, **New**, **AWS Lambda Java Project**\.

1. Add a *Project name*, *Group ID*, *Artifact ID*, and *class name* in the associated input boxes\. The Group ID and Artifact ID are the IDs that identify a Maven build artifact\. This tutorial uses the following example values:
   +  **Project name**: *HelloLambda* 
   +  **Group ID**: *com\.example\.lambda* 
   +  **Artifact ID**: *demo* 
   +  **Class name**: *Hello* 

   The **Package Name** field is the package namespace for the AWS Lambda handler class\. The default value for this field is a concatination of the Group ID and Artifact ID, following Maven project conventions\. This field is automatically updated when the **Group ID** and **Artifact ID** fields are updated\.

1. For **Input Type**, choose **Custom**\. For information about each of the available input types, see [New AWS Lambda Java Project Dialog](lambda-ref-create-project.md)\.

1. Verify that your entries look like the following screenshot \(modify them if they are not\), and then choose **Finish**\.  
![\[Project name, Group ID, Artifact ID and class name values in the New AWS Lambda Maven Project dialog box\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_create_project_filled.png)

   As you type, the code in the **Source preview** changes to reflect the changes you make in the dialog box\.

1. After you choose **Finish**, your project’s directory and source files are generated in your Eclipse workspace\. A new web browser window opens, displaying `README.html` \(which was created for you in your project’s root directory\)\. `README.html` provides instructions to guide you through the next steps of implementing, testing, uploading, and invoking your new Lambda function\. Read through it to gain some familiarity with the steps that are described here\.

Next, you implement the function in the `HelloLambda` Java project that was just created for you in Eclipse\.

## Implement the Handler Method<a name="lambda-tutorial-implement-handler-method"></a>

You use the **Create New Project** dialog box to create a skeleton project\. Now fill in the code that will be run when your Lambda function is invoked\. \(In this case, by a custom event that sends a String to your function, as you specified when setting your method’s input parameter\.\)

**To implement your Lambda handler method**

1. In the Eclipse **Project Explorer**, open `Hello.java` in the **HelloLambda** project\. It will contain code similar to the following\.

   ```
   package com.example.lambda.demo;
   
   import com.amazonaws.services.lambda.runtime.Context;
   import com.amazonaws.services.lambda.runtime.RequestHandler;
   
   public class Hello implements RequestHandler<Object, String> {
   
       @Override
       public String handleRequest(Object input, Context context) {
           context.getLogger().log("Input: " + input);
   
           // TODO: implement your handler
           return "Hello from Lambda";
       }
   
   }
   ```

1. Replace the contents of the `handleRequest` function with the following code\.

   ```
   @Override
   public String handleRequest(String input, Context context) {
     context.getLogger().log("Input: " + input);
     String output = "Hello, " + input + "!";
     return output;
   }
   ```

## Allow Lambda to Assume an IAM Role<a name="lambda-tutorial-assume-role"></a>

For Lambda to be able to access your Lambda function, you have to create an IAM role that gives it access to your AWS resources\. You can create the role in two ways, either through the AWS Management Console or by using the AWS Toolkit for Eclipse\. This section describes how to create the IAM role in the console\. See [Upload the Code](#lambda-tutorial-upload-code) to create one using the AWS Toolkit for Eclipse\.

**To create an IAM role for Lambda**

1. Sign in to the [AWS Management Console](https://console.aws.amazon.com/console/home)\.

1. From the **Services** menu, open the [IAM console](https://console.aws.amazon.com/iam/home)\.

1. In the Navigation pane, choose **Roles**, and then choose **Create role**\.

1. For **Select type of trusted entity**, choose **AWS service**, and then choose **Lambda** for the service that will use this role\. Then choose **Next: Permissions**\.

1. For **Attach permissions policy**, choose **AWSLambdaBasicExecutionRole**\. This allows Lambda to write to your CloudWatch Logs resources\. Then choose **Next: Review**\.

1. Add a name for your role, such as `hello-lambda-role`, and a description for the role\. Then choose **Create role** to finish creating the IAM role\.

## Create an Amazon S3 Bucket for Your Lambda Code<a name="lambda-tutorial-create-bucket"></a>

AWS Lambda requires an Amazon S3 bucket to store your Java project when you upload it\. You can either use a bucket that already exists in the AWS Region in which you’ll run your code, or you can create a new one specifically for Lambda to use \(recommended\)\.

You can create an Amazon S3 bucket in two ways, either through the AWS Management Console or by using the AWS Toolkit for Eclipse\. This section describes how to create an Amazon S3 bucket in the console\. See [Upload the Code](#lambda-tutorial-upload-code) to create one using the AWS Toolkit for Eclipse\.

**To create an Amazon S3 bucket for use with Lambda**

1. Sign in to the [AWS Management Console](https://console.aws.amazon.com/console/home)\.

1. From the **Services** menu, open the [S3 console](https://console.aws.amazon.com/s3/home)\.

1. Choose **Create bucket**\.

1. Enter a bucket name, and then choose a region for your bucket\. This region should be the same one in which you intend to run your Lambda function\. For a list of regions supported by Lambda see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#lambda_region) in the Amazon Web Services General Reference\.

1. Choose **Create** to finish creating your bucket\.

## Upload the Code<a name="lambda-tutorial-upload-code"></a>

Next, you upload your code to AWS Lambda in preparation for invoking it using the AWS Management Console\.

**To upload your function to Lambda**

1. Right\-click in your Eclipse code window, choose **AWS Lambda**, and then choose **Upload function to AWS Lambda**\.

1. On the **Select Target Lambda Function** page, choose the AWS Region to use\. This should be the same region that you chose for your [Amazon S3 bucket](#lambda-tutorial-create-bucket)\.  
![\[Select Target Lambda function page\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_function_create_new.png)

1. Choose **Create a new Lambda function**, and then type a name for your function \(for example, `HelloFunction`\)\.

1. Choose **Next**\.

1. On the **Function Configuration** page, enter a description for your target Lambda function, and then choose the IAM role and Amazon S3 bucket that your function will use\.  
![\[Function Configuration page\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_function_configure.png)

   For more information about the available options, see [Upload Function to AWS Lambda Dialog Box](lambda-ref-upload-function.md)\.

1. On the **Function Configuration** page, choose **Create** in **Function Role** if you want to create a new IAM role for your Lambda function\. Enter a role name in the dialogue box the **Create Role** dialogue box\.  
![\[Creating a new IAM role in the Function Configuration page\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_create_iam_role.png)

1. On the **Function Configuration** page, choose **Publish new version** if you want the upload to create a new version of the Lambda function\. To learn more about versioning and aliases in Lambda, see [AWS Lambda Function Versioning and Aliases](https://docs.aws.amazon.com/lambda/latest/dg/versioning-aliases.html) in the AWS Lambda Developer Guide\.

1. If you chose to publish a new version, the **Provide an alias to this new version** option is enabled\. Choose this option if you want to associate an alias with this version of the Lambda function\.

1. On the **Function Configuration** page, choose **Create** in the **S3 Bucket for Function Code** section if you want to create a new Amazon S3 bucket for your Lambda function\. Enter a bucket name in the **Create Bucket** dialogue box\.  
![\[Create Bucket page\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_create_s3_bucket.png)

1. In the **S3 Bucket for Function Code** section, you can also choose to encrypt the uploaded code\. For this example, leave **None** selected\. To learn more about Amazon S3 encryption, see [Protecting Data Using Server\-Side Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the Amazon S3 Developer Guide\.

1. Leave the **Advanced Settings** options as they are\. The AWS Toolkit for Eclipse selects default values for you\. Choose **Finish** to upload your Lambda function to AWS\.

If the upload succeeds, you will see the Lambda function name that you chose appear next to your Java handler class in the **Project Explorer** view\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_function_success.png)

If you don’t see this happen, open the Eclipse **Error Log** view\. Lambda writes information about failures to upload or run your function to this error log so you can debug them\.

## Invoke the Lambda Function<a name="lambda-tutorial-invoke-function"></a>

You can now invoke the function on AWS Lambda\.

**To invoke your Lambda function**

1. Right\-click in the Eclipse code window, choose **AWS Lambda**, and then choose **Run Function on AWS Lambda**\.

1. Choose the handler class you want to invoke\.

1. In the input box, type a valid JSON string, such as “AWS Lambda”\.  
![\[Choosing a Lambda handler to invoke\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_invoke_function.png)
**Note**  
You can add new JSON input files to your project, and they will show up in this dialog box if the file name ends with \.json\. You can use this feature to provide standard input files for your Lambda functions\.

1. The **Show Live Log** box is checked by default\. This displays the logs from the Lambda function output in the Eclipse **Console**\.

1. Choose **Invoke** to send your input data to your Lambda function\. If you have set up everything correctly, you should see the return value of your function printed out in the Eclipse **Console** view \(which automatically appears if it isn’t already shown\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_success.png)

Congratulations, you’ve just run your first Lambda function directly from the Eclipse IDE\!

## Next Steps<a name="next-steps"></a>

Now that you’ve uploaded and deployed your function, try changing the code and rerunning the function\. Lambda automatically reuploads and invokes the function for you, and prints output to the Eclipse **Console**\.

## More Info<a name="more-info"></a>

For more information about each of the pages that were covered in this tutorial, as well as a full description of each option, see the [AWS Lambda Interface Reference](lambda-ref.md)\.

For more information about Lambda and about writing Java code for Lambda, see [Authoring Lambda Functions in Java](https://docs.aws.amazon.com/lambda/latest/dg/lambda-java-how-to-create-deployment-package.html) in the AWS Lambda Developer Guide\.