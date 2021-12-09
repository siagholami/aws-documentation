# Working with AWS DeepLens Custom Projects<a name="deeplens-custom-projects"></a>

After you've explored one or more sample projects, you may want to create and deploy your own AWS DeepLens projects\. It means that you'll need to do all or most of the following\.
+ Train a custom deep learning model either in Amazon SageMaker or elsewhere\.
+ Import the model into AWS DeepLens\.
+ Create and publish an inference function\.
+ Create a AWS DeepLens project and add the model and the inference function to it\.
+ Deploy the project to your AWS DeepLens device\.

We'll walk you through these tasks in this section\.

**Topics**
+ [Import Your Amazon SageMaker Trained Model](deeplens-import-from-sagemaker.md)
+ [Import an Externally Trained Model](deeplens-import-external-trained.md)
+ [Optimize a Custom Model](deeplens-optimize-model.md)
+ [Create and Publish an AWS DeepLens Inference Lambda Function](deeplens-inference-lambda-create.md)
+ [Create and Deploy a Custom AWS DeepLens Project](deeplens-create-custom-project.md)
+ [Use Amazon SageMaker Neo to Optimize Inference on AWS DeepLens](deeplens-compile-model-with-neo.md)