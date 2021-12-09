# Set Up the Project Data Store in Amazon S3<a name="deeplens-headpose-project-set-up-data-store"></a>

For this project, we will use Amazon SageMaker to train the model\. To do so, we need to prepare an S3 bucket and four subfolders to store the input needed for the training job and the output produced by the training job\. 

We will create an Amazon S3 bucket and name it `deeplens-sagemaker-models-<my-name>`\. Fill in your name or some ID in the `<my-name>` placeholder to make the bucket name unique\. In this bucket, we create a `headpose` folder to hold data for training the model specific for head pose detection\. 

We then create the following four subfolders under the `headpose` folder:
+ `deeplens-sagemaker-models-<my-name>/headpose/TFartifacts`: to store training output, i\.e\., the trained model artifacts\.
+  `deeplens-sagemaker-models-<my-name>/headpose/customTFcodes`
+ `deeplens-sagemaker-models-<my-name>/headpose/datasets`: to store training input, the preprocessed images with known head poses\. 
+ `deeplens-sagemaker-models-<my-name>/headpose/testIMs`

Follow the steps below to create the bucket and folders using the Amazon S3 console:

1. Open the Amazon S3 console at [https://console.aws.amazon.com/s3/home?region=us-east-1](https://console.aws.amazon.com/s3/home?region=us-east-1)\.

1.  If the Amazon S3 bucket does not exist yet, choose **\+ Create bucket** and then type `deeplens-sagemaker-models-<my-name>` in **Bucket name**, use the default values for other options, and choose **Create**\. Otherwise, double click the existing bucket name to choose the bucket\.

1. Choose **\+ Create folder**, type the `headpose` as the folder name, and then choose **Save**\.

1. Choose the `headpose` folder just created, and then choose **\+ Create folder** to create the four subfolders \(named `TFartifacts`, `customTFcodes`, `datasets`, `testIMs`\) under `headpose`, one at time\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-tutorial-headpose-detection-s3-bucket-folders.png)

Next, we need to [prepared the input data for training in Amazon SageMaker](deeplens-headpose-project-prepare-training-data.md)\. 