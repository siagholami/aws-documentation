# Starting or Stopping an Amazon Rekognition Custom Labels Model \(Console\)<a name="rm-start-model-console"></a>

The Amazon Rekognition Custom Labels console provides example code that you can use to start and stop a model\. 

**To start or stop a model \(console\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Open the Amazon Rekognition console at [https://console\.aws\.amazon\.com/rekognition/](https://console.aws.amazon.com/rekognition/)\.

1. Choose **Use Custom Labels**\.

1. Choose **Get started**\. 

1. In the left navigation pane, choose **Projects**\.

1. On the **Projects** resources page, choose the project that contains the trained model that you want to start or stop\.

1. In the **Models** section, choose the model that you want to start or stop\. The summary results are shown\. 

1. In the **Use model** section, choose **API Code**\. 

1. At the command prompt, use the AWS CLI command that calls `start-project-version` to start your model\. Use the code snippet that calls `stop-project-version` to stop your model\. The value of `--project-version-arn` should be the Amazon Resource Name \(ARN\) of your model\. 

1. Choose your project name at the top of the page to go back to the project overview page\.

1. In the **Model** section, check the status of the model\. When the status is **The model is running**, you can use the model to analyze images\.