# Use Amazon SageMaker to Provision a Pre\-trained Model for a Sample Project<a name="deeplens-train-model"></a>

In this example, you start with a SqueezeNet object detection model and use Amazon SageMaker to train it to perform binary classification to determine whether an object is a hot dog\. The example shows you how to edit a model to perform binary classification, and explains learning rate and epochs\. We have provided a Jupyter notebook instance, which is open source software for interactive computing\. It includes the editing code to execute and explanations for the entire process\.

After training the model, you import its artifacts into AWS DeepLens, and create a project\. You then watch as your AWS DeepLens detects and identifies hot dogs\.

**Topics**
+ [Step 1: Create an Amazon S3 Bucket](#create-s3-bucket)
+ [Step 2: Create an Amazon SageMaker Notebook Instance](#create-sagemaker-notebook)
+ [Step 3: Edit the Model in Amazon SageMaker](#edit-model-sagemaker)
+ [Step 4: Optimize the Model](#optimize-model)
+ [Step 5: Import the Model](#import-model)
+ [Step 6: Create an Inference Lambda Function](#create-lambda)
+ [Step 7: Create a New AWS DeepLens Project](#create-new-project)
+ [Step 8: Review and Deploy the Project](#deploy-project)
+ [Step 9: View Your Model's Output](#view-model-output)

## Step 1: Create an Amazon S3 Bucket<a name="create-s3-bucket"></a>

Before you begin, be sure that you have created an AWS account, and the required IAM users and roles\.

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose **Create bucket**\.

1. On the **Name and region** tab:

   1. Name the bucket **deeplens\-sagemaker\-*<some\_string>***, where *<some\_string>* can be any string to make the bucket name unique across AWS\. An example would be your account name or ID\.
**Note**  
The bucket name must begin with **deeplens\-sagemaker\-** to work with the default access policies\. Otherwise, the services will not be able to access it\.

   1. Verify that you are in the US East \(N\. Virginia\) region\.

   1. Choose **Next**\.

1. On the **Configure options** tab, choose **Next**\.

1. On the **Set permissions** tab, choose **Grant Amazon S3 Log Delivery group write access to this bucket** from the **Manage system permissions** drop\-down menu, then choose **Next**\.

1. On the **Review** tab, review your settings then choose **Create bucket**\.

1. On the created bucket's page, choose the **Overview** tab and then choose **Create folder**\. 

1. Name the folder *test* then choose **Save**\. 

   To use the folder with the example notebook instance to be created next, you must name the folder as `test`, unless you change the default folder name in the notebook\.

## Step 2: Create an Amazon SageMaker Notebook Instance<a name="create-sagemaker-notebook"></a>

Create an Amazon SageMaker notebook instance\.

1. Open the Amazon SageMaker console at [https://console\.aws\.amazon\.com/sagemaker/](https://console.aws.amazon.com/sagemaker/)\.

   Make sure that you have chosen the `us-east-1` — US East \(N\. Virginia\) Region\.

1. Choose **Notebook instances** from the navigation pane and then choose **Create notebook instance**\.

1. On the **Create notebook instance** page, then do the following:

   1. Under **Notebook instance settings**, type a name for the notebook in the **Notebook instance name** input field; for example, ***<your\-name>*\-hotdog**\.

   1. For **Notebook instance type**, choose `ml.t2.medium`\.

   1. For **Permissions and encryption**, under **IAM role**, choose **Create a new role**, if this is the first time you run a notebook, type `deeplens-sagemaker` in the **Specific S3 buckets** input field, and then choose **Create role**\. 

      After you've created the first notebook instance for AWS DeepLens, you can choose an available IAM role from the **Use existing role** list\. 

      If you've already [created the AWSDeepLensSageMaker role](deeplens-required-iam-roles.md#deeplens-required-iam-roles-create-sagemaker-service) as part of the setup, choose **Enter a custom IAM role ARN**, paste the Amazon Resource Name \(ARN\) of your Amazon SageMaker role in the **Custom IAM role ARN** box\. You can find the ARN of your Amazon SageMaker role as follows:

      1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

      1. In the navigation pane, choose **Roles**\.

      1. Find the **AWSDeepLensSagemakerRole** and choose its name\. This takes you to the role's **Summary** page\.

      1. On the **Summary** page, locate and copy the **Role ARN**\. The ARN will look something like this:

         ```
         arn:aws:iam::account id:role/AWSDeepLensSagemakerRole
         ```

   1. All other settings are optional\. Skip them for this exercise\.
**Tip**  
If you want to access resources in your VPC from the notebook instance, choose a **VPC** and a **SubnetId**\. For **Security Group**, choose the default security group of the VPC\. The inbound and outbound rules of the default security group are sufficient for the exercises in this guide\.

   1. Choose **Create notebookinstance**\.

      Your new notebook instance is now available on the **Notebooks** page\.

## Step 3: Edit the Model in Amazon SageMaker<a name="edit-model-sagemaker"></a>

In this step, you open the ***<your\-name>*\-hotdog** notebook and edit the object detection model so it recognizes a hot dog\. The notebook contains explanations to help you through each step\. 

1. Open the Amazon SageMaker console at [https://console\.aws\.amazon\.com/sagemaker/](https://console.aws.amazon.com/sagemaker/)\.

1. Make sure the US East \(N\. Virginia\) Region is chosen\.

1. In the navigation pane, choose **Notebook instances**\.

1. On the **Notebooks** page, choose the radio button to the left of the notebook instance that you just created \(***<your\-name>*\-hotdog**\)\. When the notebook's status is *InService*, choose **Open Jupiter**\.

1. Open a new tab in your browser and navigate to [https://github\.com/aws\-samples/reinvent\-2017\-deeplens\-workshop](https://github.com/aws-samples/reinvent-2017-deeplens-workshop)\.

1. Download the \.zip file or clone the Git repository with the following command\. If you downloaded the \.zip file, locate it and extract all\.

   ```
   git clone git@github.com:aws-samples/reinvent-2017-deeplens-workshop.git
   ```

   If you downloaded the \.zip file, locate it and extract all\.

You now upload the training file and use it to edit the model\.

1. On the Jupyter tab, choose **Upload**\.

1. Navigate to the extracted file `deeplens-hotdog-or-not-hotdog.ipynb` then choose **Open**, then choose **Upload**\.

1. Locate and choose the *deeplens\-hotdog\-or\-not\-hotdog* notebook\. 

1. In the upper right corner of the Jupyter screen, verify that the kernal is `conda_mxnet_p36`\. If it isn't, change the kernal\.

1. In the `deeplens-hotdog-or-not-hotdog.ipynb` file, search for **bucket= *'your S3 bucket name here'***\. Replace *'your s3 bucket name here'* with the name of your S3 bucket, for example **deeplens\-sagemaker\-*<your\-name>***\.

   Return to the top of the file\.

   For each step \(`In [#]:`\) in the file:

   1. Read the step's description\.

   1. If the block has code in it, place your cursor in the code block and run the code block\. To run a code block in Jupyter, use **Ctrl\+<Enter>** or choose the run icon \(![\[Image NOT FOUND\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-run-button.png)\)\.
**Important**  
Each step is numbered in a fashion such as `In [1]:`\. While the block is executing, that changes to `In [*]:`\. When the block finishes executing it returns to `In [1]:`\. Do not move on to the next code block while the current block is still running\.

1. After you finish editing the model, return to the Amazon S3 console, choose your bucket name, choose the `test` folder, and then verify that the following artifacts of the edited model are stored in your S3 bucket's test folder\.
   + Hotdog\_or\_not\_model\-0000\.params
   + Hotdog\_or\_not\_model\-symbol\.json

## Step 4: Optimize the Model<a name="optimize-model"></a>

Now that you have a trained mxNet model there is one final step that is required before you run the model on the AWS DeepLens’s GPU\. The trained mxNet model does not come in a computationally optimized format\. If we deploy the model in the original format it will run on the CPU via mxNet at sub optimal speed\. In order to run the model at optimal speed on the GPU we need to perform model optimization\.  For instructions on how to optimize your MXNet model, see [Optimize a Custom Model](deeplens-optimize-model.md)\.

## Step 5: Import the Model<a name="import-model"></a>

Import the edited model into AWS DeepLens\.

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. Choose **Models**, then choose **Import model**\.

1. For **Import model to AWS DeepLens**, choose **Externally trained model**\.

1. For **Model settings**, do the following:

   1. For **Model artifact**, type the path to the artifacts that you uploaded to the Amazon S3 bucket in the previous step\. The path begins with **s3://deeplens\-**\. For example, if you followed the naming in Step 1, the path will be **s3://deeplens\-sagemaker\-*<your\-name>*/*<dir>***\.

   1. For **Model name**, type a name for the model\.

   1. For **Model description**, type a description\.

1. Choose **Import model**\.

## Step 6: Create an Inference Lambda Function<a name="create-lambda"></a>

Use the AWS Lambda console to create a Lambda function that uses your model\. For specific instructions with sample code, see [Create and Publish an AWS DeepLens Inference Lambda Function](deeplens-inference-lambda-create.md)\.

## Step 7: Create a New AWS DeepLens Project<a name="create-new-project"></a>

Now create a new AWS DeepLens project and add the edited model to it\.

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. Choose **Projects**\.

1. Choose **Create new project**\.

1. For **Choose project type**, choose **Create a new blank project**, then choose **Next**\.

1. For **Project information**, type a name and description for this project\.

1. For **Project content**, choose **Add model**\.

1. Search for and choose the model that you just created, then choose **Add model**\.

1. Choose **Add function**, then choose, for example, **deeplens\-hotdog\-no\-hotdog**, then choose **Add function**\.

1. Choose **Create**\.

## Step 8: Review and Deploy the Project<a name="deploy-project"></a>

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. From the list of projects, choose the project that you just created, then choose **Deploy to device**\.

1. Choose your AWS DeepLens as your target device, then choose **Review**\.

1. Review the settings, then choose **Deploy**\.
**Important**  
Deploying a project incurs costs for the various AWS services that are used\. 

## Step 9: View Your Model's Output<a name="view-model-output"></a>

To view your model's output, follow the instructions at [Viewing AWS DeepLens Output Streams](deeplens-viewing-output.md)\.