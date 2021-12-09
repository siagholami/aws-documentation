# Step 11: Stop Your Model<a name="gs-step-stop-model"></a>

You are charged for the amount of time your model is running\. If you have finished using the model, you should stop it\. The console provides example code that you use to stop the model\. For more information, see [Running a Trained Amazon Rekognition Custom Labels Model](rm-run-model.md)\. 

To run the example code, you need to set up the AWS SDK\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

Stopping a model takes a while to complete\. Check the console to determine if the model is running\. Alternatively you can use the `DescribeProjectVersions` API to get the current status\.

**To stop a model \(console\)**

1. On the **Projects** resources page, choose the project that contains the trained model that you want to stop\.

1. In the **Models** section, choose the model that you want to stop\. The summary results are shown\. 

1. In the **Use model** section, choose **API Code**\. 

1. At the command prompt, use the AWS CLI command that calls `stop-project-version`\. It should look similar to the following example\. The value of `--project-version-arn` should be Amazon Resource Name \(ARN\) of your model\. For more information, see [Step 8: Stop Your Model](gs-step-stop-model-cli.md)\.

   ```
   aws rekognition stop-project-version \
     --project-version-arn "model_arn" \
     --region us-east-1
   ```

1. Choose your project name at the top of the page to go back to the project overview page\.

1. In the **Model** section, check the status of the model\. The model has successfully stopped when the status is **The model is ready to run**\.