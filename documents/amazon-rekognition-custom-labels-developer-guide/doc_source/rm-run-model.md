# Running a Trained Amazon Rekognition Custom Labels Model<a name="rm-run-model"></a>

When you're satisfied with the performance of the model, you can start to use it\. To use a model, you must first start it by using the [StartProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StartProjectVersion) API operation\. The console provides example code for you to use\. 

You are charged for the amount of time, in minutes, that the model is running\. For more information, see [Inference hours](https://aws.amazon.com/rekognition/pricing/#Amazon_Rekognition_Custom_Labels_pricing)\. 

A single inference unit represents 1 hour of model use\. A single inference unit can support up to 5 transactions per second \(TPS\)\. Use a higher number to increase the TPS throughput of your model\. You are charged for the number of inference units that you use\. You specify the number of inference units to use in the `MinInferenceUnits` input parameter\. 

Starting a model might take a few minutes to complete\. To check the current status of the model readiness, use [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions)\.

After the model is started you use [DetectCustomLabels](https://docs.aws.amazon.com/rekognition/latest/dg/API_DetectCustomLabels), to analyze images using the model\. For more information, see [Analyzing an Image with a Trained Model](detecting-custom-labels.md)\. The console also provides example code to call `DetectCustomLabels`\. 

**Topics**
+ [Starting or Stopping an Amazon Rekognition Custom Labels Model \(Console\)](rm-start-model-console.md)
+ [Starting an Amazon Rekognition Custom Labels Model \(SDK\)](rm-start-model-sdk.md)
+ [Stopping an Amazon Rekognition Custom Labels Model \(SDK\)](rm-stop-model-sdk.md)