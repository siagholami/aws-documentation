# Create and Deploy a Custom AWS DeepLens Project<a name="deeplens-create-custom-project"></a>

**Topics**
+ [Create Your Custom Project Using the AWS DeepLens Console](#deeplens-create-custom-project)

## Create Your Custom Project Using the AWS DeepLens Console<a name="deeplens-create-custom-project"></a>

The following procedure creates a custom AWS DeepLens project containing a custom\-trained model and inference function based on the model\. You should have imported your model, created and published a custom inference &LAM; function before proceeding further\.

**To create a custom AWS DeepLens project using the AWS DeepLens console**

The steps for creating a project encompass two screens\. On the first screen you select your project\. On the second screen, you specify the project's details\.

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. Choose **Projects**, then choose **Create new project**\.

1. On the **Choose project type** page, choose **Create a new blank project**\.

1. On the **Specify project details** page, under **Project information**, do the following: 

   1.  In **Project name** type a name, for example, `my-cat-and-dog-detection`, to identify your custom project\.

   1. Optionally, in **Description \- *Optional*** provide a description for your custom project\.

1. Still on the **Specify project details** page, under **Project content**, do the following: 

   1. Choose **Add model**, choose the radio button next to the name of your custom model you've imported into AWS DeepLens, and, then, choose **Add model**\.

   1. Choose **Add function**, choose the radio button next to the name of your custom inference function you've created and published, and, then, choose **Add function**\. 

      If you don't see your function displayed, verify that it's published\. 

   1. Choose **Create** to start creating your custom project\.

1. On the **Projects** page, choose the project your just created\. 

1. Choose **Deploy to device** and follow the on\-screen instructions to deploy the project to your device\.