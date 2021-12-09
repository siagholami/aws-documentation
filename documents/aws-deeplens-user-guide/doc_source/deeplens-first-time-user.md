# Learning AWS DeepLens Application Development<a name="deeplens-first-time-user"></a>

If you are a first\-time AWS DeepLens user, we recommend that you do the following in order:

1. **Read [ AWS DeepLens Project Workflow](how-deeplens-works.md)**—Explains the basic workflow of a AWS DeepLens project running inference on the device against the deployed deep learning model\.

1. **Explore [Amazon SageMaker](https://docs.aws.amazon.com/sagemaker/latest/dg/whatis.html)**—You use Amazon SageMaker to create and train your own AWS DeepLens CNN model or import a pre\-trained one\. 

1. **Learn about the [AWS DeepLens Device Library](deeplens-device-library.md)**—The device library encapsulates the classes and methods that you can call in your Lambda functions to optimize the deployed model artifacts to grab a frame from the device video feeds, and to run inference on the video frame against the model\.

1. **Register your device as prescribed in [Getting Started with AWS DeepLens](deeplens-getting-started.md)**—Register your AWS device, create the AWS Identity and Access Management \(IAM\) roles and policies to grant necessary permissions to run AWS DeepLens and its dependent AWS services\. 

   After you've registered your AWS DeepLens device and configured the development environment, follow the exercises below:

   1. **[Create and Deploy an AWS DeepLens Sample Project in the AWS DeepLens Console](deeplens-create-deploy-sample-project.md)**—Walks you through creating sample AWS DeepLens project, which is included with your device\.

   1. **[Use Amazon SageMaker to Provision a Pre\-trained Model for a Sample Project](deeplens-train-model.md)**—Walks you through creating and training a model using Amazon SageMaker\.

   1. **[Relay an AWS DeepLens Project Output through AWS SMS](deeplens-extend.md)**—Walks you through taking output from your AWS DeepLens and using it to trigger an action\.

## More Info<a name="what-is-deeplens-related-topics"></a>
+ AWS DeepLens is available in the `us-east-1` region\.
+ [AWS DeepLens Forum](https://forums.aws.amazon.com/forum.jspa?forumID=275)