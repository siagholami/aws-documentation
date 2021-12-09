# Build and Run the Head Pose Detection Project with TensorFlow\-Trained Model<a name="deeplens-project-headpose-with-tensorflow-model"></a>

In this tutorial, we will walk you though an end\-to\-end process to build and run an AWS DeepLens project to detect head poses\. The project is based on the Head pose detection sample project\. Specifically, you'll learn: 

1. How to train a computer vision model using the TensorFlow framework in Amazon SageMaker, including converting the model artifact to the protobuff format for use by AWS DeepLens\. 

1. How to create an inference Lambda function to infer head poses based on frames captured off the video feed from the AWS DeepLens video camera\.

1. How to create an AWS DeepLens project to include the Amazon SageMaker\-trained deep learning model and the inference Lambda function\.

1. How to deploy the project to your AWS DeepLens device to run the project and verify the results\. 

**Topics**
+ [Get the AWS Sample Project on GitHub](deeplens-headpose-project-source-on-github.md)
+ [Set Up the Project Data Store in Amazon S3](deeplens-headpose-project-set-up-data-store.md)
+ [Prepare Input Data for Training In Amazon SageMaker](deeplens-headpose-project-prepare-training-data.md)
+ [Train a Head Pose Detection Model in Amazon SageMaker](deeplens-headpose-project-train-model-using-sagemaker.md)
+ [Create an Inference Lambda Function to Detect Head Poses](deeplens-headpose-project-create-inference-lambda-function.md)
+ [Create and Deploy the Head Pose Detection Project](deeplens-headpose-project-create-and-deploy-project.md)