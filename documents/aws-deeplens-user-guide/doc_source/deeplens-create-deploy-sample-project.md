# Create and Deploy an AWS DeepLens Sample Project in the AWS DeepLens Console<a name="deeplens-create-deploy-sample-project"></a>

In this walkthrough, you'll use the AWS DeepLens console to create an AWS DeepLens project from the [Object Detection sample project template](deeplens-templated-projects-overview.md#object-recognition) to create an AWS DeepLens project\. The pre\-trained object detection model can analyze images from a video stream captured on your AWS DeepLens device and identify an objects as one of as many as 20 labeled image types\. The instructions presented here apply to creating and deploying other AWS DeepLens sample project\.

When creating a sample project, the fields in the console are pre\-populated for you so you can accept the defaults\. In the **Project content** portion of the screen, you need to know the project's model and inference function\. You can find the information for the individual projects in [AWS DeepLens Sample Projects Overview](deeplens-templated-projects-overview.md)\.

The following diagram presents a high\-level overview of the processes to use the AWS DeepLens console to create and deploy a sample project\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-flow-chart-deploy-sample-project.png)

## Create and Deploy Your Project<a name="deeplens-getting-started-create-project"></a>

Follow the steps below to create and deploy the Object Detection sample project\.

**To create and deploy an AWS DeepLens sample project using the AWS DeepLens console**

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. Choose **Projects**, then choose **Create new project**\.

1. On the **Choose project type** screen

   1. Choose **Use a project template**, then choose the sample project you want to create\. For this exercise, choose **Object detection**\.

   1. Scroll to the bottom of the screen, then choose **Next**\.

1. On the **Specify project details** screen

   1. In the **Project information** section:

      1. Either accept the default name for the project, or type a name you prefer\.

      1. Either accept the default description for the project, or type a description you prefer\.

   1. Choose **Create**\.

      This returns you to the **Projects** screen where the project you just created is listed with your other projects\.

1. On the **Projects** screen, choose the radio button to the left of your project name or choose the project to open the project details page, then choose **Deploy to device**\.

1. On the **Target device** screen, from the list of AWS DeepLens devices, choose the radio button to the left of the device that you want to deploy this project to\. An AWS DeepLens device can have only one project deployed to it at a time\.

1. Choose **Review**\.

   If a project is already deployed to the device, you will see an error message that deploying this project will overwrite the project that is already running on the device\. Choose **Continue project**\. 

   This will take you to the **Review and deploy** screen\.

1. On the **Review and deploy** screen, review your project and choose either **Previous** to go back and make changes, or **Deploy** to deploy the project\.
**Important**  
Deploying a project incurs costs for the AWS services that are used to run the project\. 

For instructions on viewing your project's output, see [Viewing AWS DeepLens Output Streams](deeplens-viewing-output.md)\.