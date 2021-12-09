# Step 6: Start Your Model<a name="gs-step-start-model-cli"></a>

When your model is ready to use, you start it by calling [StartProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StartProjectVersion)\. For more information, see [Starting an Amazon Rekognition Custom Labels Model \(SDK\)](rm-start-model-sdk.md)\. To stop a running model, call [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion)\. 

In this step, you start the model\.

**To start a model**
+ At the command prompt, enter the following command\. Replace `model_arn` with the ARN of the model that you trained in [Step 4: Train Your Model](gs-step-train-model-cli.md)\.

  ```
  aws rekognition start-project-version  --project-version-arn model_arn\
    --min-inference-units "1"
  ```