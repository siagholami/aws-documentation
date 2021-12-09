# Import Your Amazon SageMaker Trained Model<a name="deeplens-import-from-sagemaker"></a>

To use your Amazon SageMaker trained model for your computer vision application, you must import it into AWS DeepLens\.

**To import your Amazon SageMaker trained model into AWS DeepLens**

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. From the navigation pane, choose **Models** then choose **Import model**\.

1. For **Import source** choose **Amazon SageMaker trained model**\.

1. In the **Model settings** area:

   1. From the list of completed jobs, choose the **Amazon SageMaker training job ID** for the model you want to import\. 

       The ID of the job must begin with `deeplens-`, unless you've customized the **AWSDeepLensServiceRolePolicy** \(used for registering the device\) to extend the policy to allow AWS DeepLens to access Amazon SageMaker's training jobs not starting with `deeplens*`\. 

       If you do not find the job you're looking for in the list, go to the Amazon SageMaker console and check the status of the jobs to verify that it has successfully completed\. 

   1. For the **Model name**, type the name you want for the model\. Model names can contain alphanumeric characters and hypens, and be no longer than 100 characters\.

   1. For the **Description** you can optionally type in a description for your model\.

   1. Choose **Import model**\.