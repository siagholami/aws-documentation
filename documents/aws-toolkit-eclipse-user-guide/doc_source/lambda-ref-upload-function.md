# Upload Function to AWS Lambda Dialog Box<a name="lambda-ref-upload-function"></a>

You use the **Upload Function to AWS Lambda** dialog box to create a Lambda function, and upload your code to run when the Lambda function is invoked\.

## Launching the Dialog Box<a name="launching-the-dialog-box"></a>

You can launch the **Upload Function to AWS Lambda** dialog box in two ways:
+ Open the context menu for your AWS Lambda Java Project in the Eclipse **Project Explorer** view, and then choose **Amazon Web Services**, **Upload function to AWS Lambda**\.
+ Open the context menu in the code window for your Java class, and then choose **AWS Lambda**, **Upload function to AWS Lambda**\.

The **Upload Function to AWS Lambda** dialog box has two pages:
+  [Select Target Lambda Function](#select-target-lambda-function-ui) 
+  [Function Configuration](#lambda-function-config-ui) 

## Select Target Lambda Function Options<a name="select-target-lambda-function-ui"></a>

![\[Select Target Lambda Function page and options\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_function_create_new.png)

**Select the Handler**  
\(Required\) The handler class that contains the Lambda function code you want to upload\.  
\(Default\) The most recently uploaded handler or the first one found if none were previously uploaded\.

**Select the AWS Region**  
\(Required\) The region in which you want to create your Lambda function\.  
\(Default\) The default AWS Management Console region for your AWS account\.

**Select or Create a Lambda Function**  
\(Required\) You must select whether to use an existing Lambda function from the drop\-down list, or to create a new one by entering its name\.  
\(Default\) **Create a new Lambda function** 

When you choose **Next**, the **Function Configuration** page opens\.

## Function Configuration Options<a name="lambda-function-config-ui"></a>

![\[Function Configuration page\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_tutorial_upload_function_configure.png)

The page is divided into five sections, each with its own settings\.

### Basic Settings<a name="basic-settings"></a>

This section shows the function name and enables you to add a text description\.

**Name**  
\(Immutable\) The name is determined by the name you chose on the **Select Target Lambda Function** page\. You can’t modify it here, however, you can choose **Back** to re\-enter it on the previous page\.

**Description**  
\(Optional\) A text description of the function\.  
\(Default\) The description is empty\.

### Function Role<a name="function-role"></a>

In this section, you can select the IAM role to apply to the function\. You can also create a new IAM role with the **Create** button\. The IAM role you create through the AWS Toolkit for Eclipse is a basic role that provides access to Amazon S3\. If you need more access to AWS resources, you must provide access to each of the services used in the AWS Management Console\.

**IAM Role**  
\(Required\) The role that Lambda uses to access your AWS resources during the execution of your function\.  
\(Default\) The first IAM role from your AWS account\.

### Function Versioning and Alias<a name="function-versioning-and-alias"></a>

In this section, you can publish a new version of your Lambda function and specify an alias for that version\. To learn more about Lambda versioning and aliasing, see [AWS Lambda Function Versioning and Aliases](https://docs.aws.amazon.com/lambda/latest/dg/versioning-aliases.html) in the AWS Lambda Developer Guide\.

**Publish new version**  
\(Default\) Not selected\. If you select this option, the upload creates a new version of the Lambda function instead of replacing it\.

**Provide an alias to this new version**  
\(Default\) Not selected\. If you select this option, you can type in a new alias or use an existing one\.

### S3 Bucket for Function Code<a name="s3-bucket-for-function-code"></a>

In this section, you can set an Amazon S3 bucket for your Lambda function to use\. You can also create a new bucket with the **Create** button and select settings to encrypt your Lambda function when it uploads to Amazon S3\.

**S3 Bucket**  
\(Required\) An Amazon S3 bucket that your function’s code can use\. Only buckets that are in the same region in which you will run the function are displayed here\.  
\(Default\) The first bucket in your list or the last bucket you uploaded your Lambda function to\.

**Encryption setting**  
\(Default\) None is selected\. To learn more about Amazon S3 encryption, see [Protecting Data Using Server\-Side Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the Amazon S3 Developer Guide\.

### Advanced Settings<a name="advanced-settings"></a>

This section contains settings that you might use less often\. They can provide you with more control over your function’s execution environment than the settings in the **Function Execution** section\.

**Memory \(MB\)**  
\(Required\) The number of megabytes of memory available to your Lambda function\.  
\(Default\) 512 MB\.

**Timeout \(s\)**  
\(Required\) The timeout, in seconds, after which the function is considered to have failed if it has finished execution\.  
\(Default\) 15 s\.