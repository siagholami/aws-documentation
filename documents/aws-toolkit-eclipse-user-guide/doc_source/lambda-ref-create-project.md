# New AWS Lambda Java Project Dialog<a name="lambda-ref-create-project"></a>

The **New Lambda Java Project** dialog helps you to create and configure a new Java project that you can use to author a Lambda function\.

## Launching the dialog<a name="launching-the-dialog"></a>

The **New Lambda Java Project** dialog can be launched in the following ways:
+ by opening the AWS menu in the Eclipse toolbar and selecting **New AWS Lambda Java project…**\.
+ by selecting **File ‣ New ‣ Other…** in the Eclipse menu, and then choosing **AWS ‣ AWS Lambda Java Project** in the resulting dialog\.

## Create Project Dialog user interface<a name="create-project-dialog-user-interface"></a>

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_create_project_default.png)

**Project name**  
 *Required*\. You must provide a name for your project\.

**Package name**  
An optional name for your Java package\. It must be a valid Java package name, such as “com\.mycompany\.myproject”\. When you enter the package name in the text entry field, it will be added to the contents of the **Source Preview** window\.  
 *Default*: None, this parameter is optional\.

**Class name**  
 *Required*\. The name that identifies the Java class that contains your Lambda code\. It must be a valid Java class name\. The default value is generic; you can specify your own name here or change the **Package name** to avoid conflicts with similarly\-named classes\.  
 *Default*: *LambdaFunctionHandler* 

**Input type**  
 *Required*\. The type of input that will be used to call your Lambda function\. You can select a category from the drop\-down list:  
+  *S3 Event*– receives an event from [Amazon S3](https://docs.aws.amazon.com/lambda/latest/dg/with-s3.html) event\.
+  *SNS Event*– receives an event from [Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/sns-lambda.html)\.
+  *Kinesis Event*– receives an event from an [Amazon Kinesis stream](https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html)\.
+  *Cognito Event*– receives an event from [Amazon Cognito](https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-events.html)\.
+  *Custom*– receives an event from custom code\. If you set the input type to *Custom*, then you can also set the name of the custom input type in the box next to the type selection\. By default, the generic *Object* type is used\.
**Important**  
The custom input type *must* be a valid Java class name, and not a primitive type such as `int`, `float`, and so on\. You can use Java’s standard boxed types \(`Integer`, `Float`, …\) for these cases\.

  Use the *Custom* input type for setting up event sources such as the following:
  +  [user applications](https://docs.aws.amazon.com/lambda/latest/dg/getting-started.html) 
  +  [mobile applications](https://docs.aws.amazon.com/lambda/latest/dg/with-on-demand-custom-android.html) 
  + The [AWS Management Console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started.html)\.
  + The [AWS CLI invoke command](https://docs.aws.amazon.com/lambda/latest/dg/API_Invoke.html)\.
 *Default*: *S3 Event* 

**Output type**  
The output type\. This must be a valid Java object\.  
 *Default*: *Object* 