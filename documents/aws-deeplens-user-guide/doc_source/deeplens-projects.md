# Building AWS DeepLens Projects<a name="deeplens-projects"></a>

When your AWS DeepLens device is registered with and connected to the AWS Cloud, you can begin to create an AWS DeepLens project on the AWS Cloud and deploy it to run on the device\. An AWS DeepLens project is a deep learning\-based computer vision application\. It consists of a deep learning model and a Lambda function to perform inference based on the model\. 

Before creating an AWS DeepLens project, you must have trained or have someone else trained a deep learning model using one of [the supported machine learning frameworks](deeplens-supported-frameworks.md)\. The model can be trained using Amazon SageMaker or another machine learning environment\. In addition, you must also have created and published an inference function in AWS Lambda\. In this chapter, you'll learn how to train a computer vision deep learning model in Amazon SageMaker and how to create an inference Lambda function to make inferences and to implement other application logic\.

To help you learn building your AWS DeepLens project, you have access to a set of AWS DeepLens sample projects\. You can use the sample projects as\-is to learn programming patterns for building a AWS DeepLens project\. You can also use them as templates to extend their functionality\. In this chapter, you'll learn more about these sample projects and how to employ one to run on your device, as well\.

**Topics**
+ [Machine Learning Frameworks Supported by AWS DeepLens](deeplens-supported-frameworks.md)
+ [Viewing AWS DeepLens Output Streams](deeplens-viewing-output.md)
+ [Working with AWS DeepLens Sample Projects](deeplens-sample-projects.md)
+ [Working with AWS DeepLens Custom Projects](deeplens-custom-projects.md)
+ [Building AWS DeepLens Project Tutorials](deeplens-project-tutorials.md)