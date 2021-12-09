# Run AWS Lambda Function Dialog<a name="lambda-ref-invoke-function"></a>

The **Run Lambda Function** dialog provides a way for you to invoke a Lambda function directly from the Eclipse user interface\.

## Launching the dialog<a name="launching-the-dialog"></a>

The **Run Lambda Function** dialog can be launched in the following ways:
+ by opening the context menu for your AWS Lambda Java Project in Eclipse’s **Project Explorer** view, and selecting **Amazon Web Services** > **Run function on AWS Lambda…**\.
+ by opening the context menu in the code window for your Java class and selecting **AWS Lambda** > **Run function on AWS Lambda…**\.

The Invoke Function dialog appears like this:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/lambda_invoke_function_dialog.png)

## Options<a name="options"></a>

There are two ways to provide data to your function\. Either one or the other is required\.
+  **Select one of the JSON files as input**– If you have any `.json` files attached to your project, you can select one of them from the list provided\. Otherwise, this option will be greyed out\.
+  **Or enter the JSON input for your function**– You can directly enter valid JSON input for your function here\. The type of data that you enter must match the input parameter of the Java method in your handler class\.

Once you’ve made a selection and have provided your input data, you can click **Finish** to invoke your Lambda function, or click **Cancel** to exit the dialog without running anything\.