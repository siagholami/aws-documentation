# Import an Externally Trained Model<a name="deeplens-import-external-trained"></a>

To use an externally trained model, import it\.

**To import an externally trained model**

1. Sign in to the AWS Management Console for AWS DeepLens at [https://console\.aws\.amazon\.com/deeplens/](https://console.aws.amazon.com/deeplens/)\.

1. In the navigation pane, choose **Models**, then choose **Import model**\.

1.  into For **Import source**, choose **Externally trained model**\.

1. For **Model settings**, provide the following information\.

   1. For **Model artifact path**, type the full path to the Amazon Simple Storage Service \(Amazon S3\) location of the artifacts created when you trained your model\. The path begins with **s3://deeplens\-**\. For example, if you followed the naming conventions we use throughout this documentation, the path will be **s3://deeplens\-sagemaker\-*your\_name*/<dir>**\.

   1. For **Model name**, type a name\. A model name can have a maximum of 100 alphanumeric characters and hypens\.

   1. Optional\. For **Description**, type a description of the model\.

   1. Choose **Import model**\.