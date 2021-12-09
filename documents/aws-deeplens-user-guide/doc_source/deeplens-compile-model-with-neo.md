# Use Amazon SageMaker Neo to Optimize Inference on AWS DeepLens<a name="deeplens-compile-model-with-neo"></a>

A trained model might not be optimized to run inference on your device\. Before you deploy a trained model to your AWS DeepLens, you can use [Amazon SageMaker Neo](https://docs.aws.amazon.com/sagemaker/latest/dg/neo) to optimize it to run inference on the AWS DeepLens hardware\. The process involves these steps: 

1. Compile the model\.

1. Import the compiled model into the AWS DeepLens console\.

1. Deploy the compiled model to your AWS DeepLens device\.

1. Load the compiled model into the Neo runtime of the inference engine\.

We recommend that you use Neo\-compiled models for improved inference performance with minimal effort on your part\.

**Topics**
+ [Compile an AWS DeepLens Model](#deeplens-use-neo-create-compilation-job)
+ [Import a Compiled Model into the AWS DeepLens Console](#deeplens-import-compiled-model-into-console)
+ [Load the Compiled Model into the AWS DeepLens Inference Engine](#deeplens-load-compiled-model-into-inference-engine)

## Compile an AWS DeepLens Model<a name="deeplens-use-neo-create-compilation-job"></a>

 To use Neo to compile a model, you can use AWS CLI to create and run a compilation job\. First create a job configuration file in JSON to specify the following: The Amazon S3 bucket to load the raw model artifacts from, the training data format, and the machine learning framework, which indicates how the job is to run\. 

The following example JSON file shows how to specify the job configuration\. As an example, the file is named *neo\_deeplens\.json*\. 

```
{
    "CompilationJobName": "deeplens_inference",
    "RoleArn": "arn:aws:iam::your-account-id:role/service-role/AmazonSageMaker-ExecutionRole-20190429T140091",
    "InputConfig": {
        "S3Uri": "s3://your-bucket-name/headpose/model/deeplens-tf/train/model.tar.gz",
        "DataInputConfig":  "{\"data\": [1,84,84,3]}",
        "Framework": "TENSORFLOW"
    },
    "OutputConfig": {
        "S3OutputLocation": "s3://your-bucket-name/headpose/model/deeplens-tf/compile",
        "TargetDevice": "deeplens"
    },
    "StoppingCondition": {
        "MaxRuntimeInSeconds": 300
    }
}
```

The `InputConfig.S3Uri` property value specifies the S3 path to the trained model artifacts\. The `S3OutputLocation` property value specifies the S3 folder to contain the Neo\-compiled model artifacts\. The input data format specified in the `DataInputConfig` property value must be consistent with the original training data format\. For more information about the compilation job configuration property values, see [CreateCompilationJob](https://docs.aws.amazon.com/sagemaker/latest/dg/API_CreateCompilationJob.html)\.

 To create and run the Neo job, type the following AWS CLI command in a terminal window\. 

```
aws sagemaker create-compilation-job \
--cli-input-json file://neo_deeplens.json \
--region us-west-2
```

 In addition to AWS CLI, you can also use the Amazon SageMaker console or the Amazon SageMaker SDK to create and run the compilation job\. To learn more, see use [the Amazon SageMaker console](https://docs.aws.amazon.com/sagemaker/latest/dg/neo-job-compilation-console.html) and [Amazon SageMaker SDK](https://docs.aws.amazon.com/sagemaker/latest/dg/neo-job-compilation-sagemaker-sdk.html) to compile a trained model\. 

## Import a Compiled Model into the AWS DeepLens Console<a name="deeplens-import-compiled-model-into-console"></a>

 This section explains how to import a compiled model\. When these steps are complete, you can deploy the model to your AWS DeepLens device and then run inference\. 

**To import a Neo\-compiled model into the AWS DeepLens console**

1.  Download the compiled model from the S3 folder as specified by the `S3OutputLocation` path\. 

1.  On your computer, create a folder \(*compiled\-model\-folder*\) to unpack the compiled model into\. Note the folder name because you need it later to identify the compiled model\. 

   ```
   mkdir compiled-model-folder
   ```

1. If you use a macOS computer, set the following flag\.

   ```
   COPYFILE_DISABLE=1 
   ```

1. Unpack the downloaded model into the folder \(*compiled\-model\-folder*\)\.

   ```
   tar xzvf model-deeplens.tar.gz -C compiled-model-folder
   ```

1.  Compress the compiled model folder\. 

   ```
   tar czvf compiled-model-foler.tar.gz compiled-model-folder
   ```

1.  Upload the compressed compiled model folder to S3\. Note the target S3 path\. You use it import the model in the next step\. 

1. Go to the AWS DeepLens console and import the model specifying the S3 path chosen in the previous step\. In the model's settings, set the model's framework to `Other`\. 

The compiled model is now ready for deployment to your AWS DeepLens device\. The steps to deploy a compiled model are the same as an uncompiled model\.

## Load the Compiled Model into the AWS DeepLens Inference Engine<a name="deeplens-load-compiled-model-into-inference-engine"></a>

To load a compiled model into your AWS DeepLens inference engine, specify the folder name that contains the compiled model artifacts and the Neo runtime\. Do this when you instantiate the `awscam.Model` class in the Lambda function\. The following code example demonstrates this\.

```
import awscam
model = awscam.Model('compiled-model-folder', {'GPU': 1}, runtime=1)
ret, image = awscam.getlastFrame()
infer_results = model.doInference(image)
```

 The function now runs inference with a compiled model in the Neo runtime\. To use the compiled model for inference, you must set `runtime=1` and select GPU \(`{'GPU' : 1}`\) when creating the `model` object\. 

The output `infer_results` returns the raw inference results as a dictionary object, where `infer_results[i]` holds the result of the `ith` output layer\. For example, if an image classification network \(e\.g\., resnet\-50\) has only one Softmax output layer, `infer_results[0]` is a Numpy array with size `N x 1` that gives the probability for each of the `N` labeled images\.