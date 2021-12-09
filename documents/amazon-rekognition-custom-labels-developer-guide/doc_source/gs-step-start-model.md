# Step 9: Start Your Model<a name="gs-step-start-model"></a>

If you're happy with the performance of your model, you make it available for use by starting it\. The console provides example code that you use to start the model\. To run the example code, you need to set up the AWS SDK\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\. 

**Note**  
You are charged for the amount of time, in minutes, that the model is running\. For more information, see [Inference hours](https://aws.amazon.com/rekognition/pricing/#Amazon_Rekognition_Custom_Labels_pricing)\. 

Starting a model takes a while to complete\. You can use the console to determine if the model is running\. Alternatively you can use the `DescribeProjectVersions` API to get the current status\. For more information, see [Running a Trained Amazon Rekognition Custom Labels Model](rm-run-model.md)\.

**To start a model \(console\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` and `AmazonS3ReadOnlyAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the latest version of the AWS CLI\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. On the **Projects** resources page, choose the project that contains the trained model that you want to start\.

1. In the **Models** section, choose the model that you want to start\. The summary results are shown\. 

1. In the **Use model** section, choose **API Code**\. 

1. At the command prompt, use the AWS CLI command that calls `start-project-version` to start your model\. The value of `--project-version-arn` should be the Amazon Resource Name \(ARN\) of your model\.

   ```
   aws rekognition start-project-version \
     --project-version-arn "model_arn" \
     --min-inference-units 1\
     --region us-east-1
   ```

1. Choose your project name at the top of the page to go back to the project overview page\.

1. In the **Model** section, check the status of the model\. When the status is **The model is running**, you can use the model to analyze images\.