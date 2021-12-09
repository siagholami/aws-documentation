# Create and Deploy the Head Pose Detection Project<a name="deeplens-headpose-project-create-and-deploy-project"></a>

Before creating the AWS DeepLens project, your must import the model into AWS DeepLens\. Because the original Amazon SageMaker\-trained model artifact is converted to a protobuff file, you must treat the transformed model artifact as externally trained\.<a name="deeplens-tutorial-headpose-detection-import-model"></a>

**To import the customized Amazon SageMaker\-trained model for head pose detection**

1. Go to the AWS DeepLens console\.

1. Choose **Models** from the main navigation pane\.

1. Choose **Import model**\.

1. On the **Import model to AWS DeepLens** page, do the following:

   1. Under **Import source**, choose **Externally trained model**\.

   1. Under **Model settings**, do the following:

      1. For **Model artifact path**, type the model's S3 URL, e\.g\., `s3://deeplens-sagemaker-models-<my-name>/headpose/TFartifacts/<sagemaker-job-name>/output/frozen_model.pb`\.

      1. For **Model name**, type a name for your model, e\.g\., **my\-headpose\-detection\-model**\.

      1. For **Model framework**, choose `TensorFlow`\.

      1. For **Description \- Optional**, type a description about the model, if choose to do so\.

After importing the model, you can now create an AWS DeepLens project to add the imported model and the published inference Lambda function\.<a name="deeplens-tutorial-headpose-detection-create-project"></a>

**To create a custom AWS DeepLens project for head pose detection**

1. In the AWS DeepLens console, choose **Projects** from the main navigation pane\. 

1. In the **Projects** page, choose **Create new project**\.

1. On the **Choose project type** page, choose **Create a new blank project**\. Then, choose **Next**\.

1. On the **Specify project details** page, do the following:

   1. Under **Project information**, type a name for your project in the **Project name** input field and, optionally, give a project description in the **Description \- Optional** input field\.

1. Under **Project content**, do the following:

   1. Choose **Add model**\. Then, select the radio button next to your head pose detection model imported earlier and choose **Add model**\.

   1. Choose **Add function**\. Then, select the radio button next to the published Lambda function for head pose detection and choose **Add function**\.

      The function must be published in AWS Lambda and named with the **deeplens\-** prefix to make it visible here\. If you've published multiple versions of the function, make sure to choose the function of the correction version\.

1. Choose **Create**\.

With the project created, you're ready to deploy it to your registered AWS DeepLens device\. Make sure to remove any active project from the device before proceeding further\.

1. In the **Projects** page of the DAWS DeepLensL console, choose the newly created project for head pose detection\.

1. In the selected project details page, choose **Deploy to device**\.

1. On the **Target device** page, select the radio button next to your registered device and then choose **Review**\.

1. On the **Review and deploy** page, choose **Deploy** after verifying the project details\. 

1. On the device details page, examine the deployment status by inspecting **Device status** and **Registration status**\. If they're **Online** and **Registered**, respectively, the deployment succeeded\. Otherwise, verify that the imported model and the published Lambda function are valid\. 

1. After the project is successfully deployed, you can view the project output in one of the following ways: 

   1. View the JSON\-formatted output published by the inference Lambda function in the AWS IoT Core console\. For instructions, see [View Your AWS DeepLens Project Output in the AWS IoT Console](deeplens-viewing-project-output-json.md)\.

   1. View streaming video in a supported web browser\. For instructions, [View Video Streams from AWS DeepLens Device in Browser](deeplens-viewing-device-output-in-browser.md)\.

This completes this tutorial to build and deploy your head pose detection project\. 