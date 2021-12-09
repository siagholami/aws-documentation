# What Is AWS DeepLens?<a name="what-is-deeplens"></a>

AWS DeepLens is a deep learning\-enabled video camera\. It is integrated with the Amazon Machine Learning ecosystem and can perform local inference against deployed models provisioned from the AWS Cloud\. It lets you learn and explore the latest Artificial Intelligence \(AI\) tools and technology for developing computer vision applications based on a deep learning model\. 

As a beginner to machine learning, you can use AWS DeepLens to explore deep learning through hands\-on tutorials based on ready\-deployed deep learning sample projects\. Each sample project contains a pre\-trained model and a pedagogically straightforward inference function\. 

As a seasoned practitioner, you can leverage the AWS DeepLens development platform to train a convolutional neural network \(CNN\) model and deploy to the AWS DeepLens device your computer vision application project containing the model\. You can train the model in any of the [supported deep learning frameworks](deeplens-supported-frameworks.md), including Caffe, MXNet and TensorFlow\. 

To create and run an AWS DeepLens\-based computer vision application project, you typically use the following AWS services:
+ Use the Amazon SageMaker service to train and validate a CNN model or import a pre\-trained model\.
+ Use the AWS Lambda service to create a project function to make inferences of video frames off the camera feeds against the model\.
+ Use the AWS DeepLens service to create a computer vision application project that consists of the model and inference function\.
+ Use the AWS IoT Greengrass service to deploy the application project and a Lambda runtime to your AWS DeepLens device, as well as the software or configuration updates\. 

This means that you must grant appropriate permissions to access these AWS services\. 

**Topics**
+ [AWS DeepLens Device Versions](deeplens-versions.md)
+ [AWS DeepLens Hardware](deeplens-hardware.md)
+ [AWS DeepLens Project Workflow](how-deeplens-works.md)
+ [Supported Modeling Frameworks](supported-frameworks.md)
+ [Learning AWS DeepLens Application Development](deeplens-first-time-user.md)