# Getting Started with the Amazon Rekognition Custom Labels SDK<a name="gs-cli"></a>

Amazon Rekognition Custom Labels provides an API that you can use to create Amazon Rekognition Custom Labels projects, train and evaluate models, run models, and analyze images using your model\. 

For information about the general flow of creating and using a model, see [Getting Started with Amazon Rekognition Custom Labels](gs-introduction.md)\.

**Note**  
The Amazon Rekognition Custom Labels API is documented as part of the Amazon Rekognition API reference content\. For more information, see [Amazon Rekognition Custom Labels API Reference](custom-labels-api-reference.md)\.

## Creating a Project<a name="ud-create-project-sdk"></a>

To create a model with the API, use [CreateProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProject)\. For more information, see [Creating an Amazon Rekognition Custom Labels Project \(SDK\)](cp-create-project.md#cp-sdk)\. After you create a project, you need to create or add a dataset by using the Amazon Rekognition Custom Labels console\. For more information, see [Creating an Amazon Rekognition Custom Labels Dataset](cd-create-dataset.md)\.

## Creating a Dataset<a name="ud-create-dataset-sdk"></a>

A dataset contains the images, labels, and bounding box information that you use to train a model\. Alternatively, you can use an Amazon SageMaker Ground Truth manifest file to train a model\. The Amazon Rekognition Custom Labels API doesn't create datasets, import images, or label images\. To do these tasks, you need to use the Amazon Rekognition Custom Labels console or provide your own Amazon SageMaker Ground Truth format manifest file\. An option for creating a manifest file is to create an Amazon SageMaker Ground Truth labeling job\. For more information, see [Amazon SageMaker Ground Truth](https://docs.aws.amazon.com/sagemaker/latest/dg/sms.html)\.

Dataset files are stored in an Amazon S3 bucket\. If you aren't using a dataset that was created in the Amazon Rekognition Custom Labels console, you need to add permissions to your bucket or buckets so that Amazon Rekognition Custom Labels can access the bucket contents\. For more information, see [Step 4: Set Up Amazon S3 Bucket Permissions for SDK Use](su-sdk-bucket-permssions.md)\.

For more information about the workflow for creating and managing a dataset, see [Managing a Dataset](cd-managing-datasets.md)\.

## Training and Evaluating a Model<a name="ud-train-evaluate-sdk"></a>

You can use the Amazon Rekognition Custom Labels APIs to train and evaluate a model\.

**Training a model**  
You train an Amazon Rekognition Custom Labels model by calling [CreateProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProjectVersion)\. A new version of a model is created each time it is trained\. `CreateProjectVersion` requires a training dataset and a testing dataset\. 

If you choose, you can create a testing dataset by splitting your training dataset in an 80 \(training\)/20 \(testing\) split\. When a model is trained, its performance is evaluated and the results placed in an S3 bucket\. You can choose to place the training results in the same bucket as the console S3 bucket, or a different S3 bucket that you choose\. For more information, see [Training a Model \(SDK\)](tm-sdk.md)\. 

You are charged for the amount of time that it takes to train a model\. For more information, see [Training hours](https://aws.amazon.com/rekognition/pricing/#Amazon_Rekognition_Custom_Labels_pricing)\. 

**Evaluating a model**  
To evaluate a model, you call [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions) to get the training results\. The training results include metrics that aren't available in the console, such as a confusion matrix for classification results\. The training results are returned in the following formats: 
+ F1 score – A single value representing the overall performance of precision and recall for the model\. For more information, see [Overall Model Performance](tr-metrics-use.md#tr-f1-metric)\.
+ Summary file location – The training summary includes aggregated evaluation metrics for the entire testing dataset and metrics for each individual label\. `DescribeProjectVersions` returns the S3 bucket and folder location of the summary file\. For more information, see [Summary File](tr-summary-file-api.md)\.
+ Evaluation manifest snapshot location – The snapshot contains detailed information about the test results including the confidence ratings and the results of binary classification tests, such as false positives\. `DescribeProjectVersions` returns the S3 bucket and folder location of the snapshot files\. For more information, see [Evaluation Manifest Snapshot](tr-evaluation-manifest-snapshot-api.md)\. 

For more information about evaluating a model, see [Evaluating a Trained Amazon Rekognition Custom Labels Model](tr-train-results.md)\.

## Running and Using a Model<a name="ud-running-using"></a>

Amazon Rekognition Custom Labels provides an API that you use, with your model, to detect custom labels in images\. The model must be running before you can detect custom labels\. 

**Running a model**  
When your model is ready to use, you start it by calling [StartProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StartProjectVersion)\. For more information, see [Starting an Amazon Rekognition Custom Labels Model \(SDK\)](rm-start-model-sdk.md)\. You are charged for the amount of time, in minutes, that the model is running\. For more information, see [Inference hours](https://aws.amazon.com/rekognition/pricing/#Amazon_Rekognition_Custom_Labels_pricing)\. To stop a running model, call [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion)\. For more information, see [Stopping an Amazon Rekognition Custom Labels Model \(SDK\)](rm-stop-model-sdk.md)\. 

**Analyzing images**  
To analyze new images with your running model, you call [DetectCustomLabels](https://docs.aws.amazon.com/rekognition/latest/dg/API_DetectCustomLabels)\. This operation takes an input image from either an Amazon S3 bucket or from a local file system\. It also requires the Amazon Resource Name \(ARN\) of the model that you want to use\. The response includes predictions for the presence of custom labels in the input image\. A custom label has an associated confidence score that tells you the model's confidence in the accuracy of the prediction\. Object location information for objects detected in the image is also returned\. For more information, see [Analyzing an Image with a Trained Model](detecting-custom-labels.md)\. 