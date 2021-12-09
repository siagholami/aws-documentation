# Step 4: Train Your Model<a name="gs-step-train-model-cli"></a>

You train an Amazon Rekognition Custom Labels model by calling [CreateProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProjectVersion)\. A new version of a model is created each time it is trained\. `CreateProjectVersion` requires a training dataset and a testing dataset\. In this step, you create a testing dataset by splitting your training dataset in an 80 \(training\)/20 \(testing\) split\. When a model is trained, its performance is evaluated and the results placed in an S3 bucket\. You can choose to place the training results in the same bucket as the console S3 bucket, or an S3 bucket that you choose\. For more information, see [Training a Model \(SDK\)](tm-sdk.md)\. 

In this step, you train a model using the dataset you prepared in [Step 3: Prepare Your Dataset](gs-step-prepare-dataset-cli.md)\.

**To train a model \(SDK\)**

1. At the command prompt, enter the following command\. Replace the following:
   + `my_project_arn` with the Amazon Resource Name \(ARN\) of the project you created in [Step 2: Create a Project](gs-step-create-project-cli.md#gs-step-create-project-cli.title)\.
   + `version_name` with a unique version name of your choosing\.
   + `output_bucket` with the name of the Amazon S3 bucket where Amazon Rekognition Custom Labels saves the training results\.
   + `output_folder` with the name of the folder where the training results are saved\.
   + `training_bucket` with the name of the Amazon S3 bucket that contains the manifest file and images\.
   + `training_manifest` with the name and path to the manifest file\.

   ```
   aws rekognition create-project-version\
      --project-arn "my_project_arn"\
     --version-name "version_name"\
     --output-config '{"S3Bucket":"output bucket", "S3KeyPrefix":"output_folder"}'\
     --training-data '{"Assets": [{ "GroundTruthManifest": { "S3Object": { "Bucket": "training_bucket", "Name": "training_manifest" } } } ] }'\
     --testing-data '{"AutoCreate":true }'
   ```

1. Note the value of `version_name` because you need it in the next step\.

1. Use the following command to get the current status of the model training\. Training is complete when the value of `Status` is `TRAINING_COMPLETED`\. 

   Replace `project_arn` with the ARN of the project you created in [Step 2: Create a Project](gs-step-create-project-cli.md)\. Replace `version_name` with the name of the version that you used in [Step 4: Train Your Model](#gs-step-train-model-cli)\.

   ```
   aws rekognition describe-project-versions --project-arn "project_arn"\
        --version-names "version_name"
   ```