# Step 8: Stop Your Model<a name="gs-step-stop-model-cli"></a>

If you don't need to use your model, you can stop it by calling [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion)\. 

**Note**  
You are charged for the amount of time your model is running\.

**To stop a model**
+ At the command prompt, enter the following command\. Replace `model_arn` with the ARN of the model that you started in [Step 6: Start Your Model](gs-step-start-model-cli.md)\.

  ```
  aws rekognition stop-project-version  --project-version-arn model_arn
  ```