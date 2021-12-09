# Training a Model \(SDK\)<a name="tm-sdk"></a>

You train a model by calling [CreateProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProjectVersion)\. To train a model, the following information is needed:
+ Name – A unique name for the model version\.
+ Project ARN – The Amazon Resource Name \(ARN\) of the project that manages the model\.
+ Training dataset – An Amazon SageMaker Ground Truth–formatted manifest file and images that are used to train the model\. You can create the dataset in the Amazon Rekognition Custom Labels console\. Another option is to provide an external manifest file such as an Amazon SageMaker Ground Truth labeling job\. The dataset is stored in an Amazon S3 bucket\. 
+ Testing dataset – Test images and labels used to evaluate the model after training\. You can use a dataset created in the Amazon Rekognition Custom Labels console \(stored in the console's Amazon S3 bucket\)\. Alternatively, you can use an Amazon SageMaker Ground Truth format manifest file stored in an external Amazon S3 bucket\. You can also split the training dataset to use it as a test dataset\. 
+ Training results location – The Amazon S3 location where the results are placed\. You can use the same location as the console Amazon S3 bucket, or you can choose a different location\. We recommend choosing a different location because this allows you to set permissions and avoid potential naming conflicts with training output from using the Amazon Rekognition Custom Labels console\.

The response from `CreateProjectVersion` is an ARN that you use to identify the model version in subsequent requests\. You can also use the ARN to secure the model version\. Training a model version takes a while to complete\. The Python and Java examples in this topic use waiters to wait for training to complete\. A waiter is a utility method that polls for a particular state to occur\. Alternatively, you can get the current status of training by calling `DescribeProjectVersions`\. Training is completed when the `Status` field value is `TRAINING_COMPLETED`\. After training is completed, you can evaluate model’s quality by reviewing the evaluation results\. 

**To train a model \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` and permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

   1. If you are using an external Amazon S3 bucket, set the permissions\. For more information, see [Step 4: Set Up Amazon S3 Bucket Permissions for SDK Use](su-sdk-bucket-permssions.md)\.

1. Use the following example code to train a project\.

------
#### [ AWS CLI ]

   The following example creates a model\. The training dataset is split to create the test dataset\. Replace the following:
   + `my_project_arn` with the Amazon Resource Name \(ARN\) of the project\.
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

------
#### [ Python ]

   The following example creates a model\. Replace the following:
   + `my_project_arn` with the Amazon Resource Name \(ARN\) of the project\.
   + `version_name` with a unique version name of your choosing\.
   + `output_bucket` with the name of the Amazon S3 bucket where Amazon Rekognition Custom Labels saves the training results\.
   + `output_folder` with the name of the folder where the training results are saved\.
   + `training_bucket` with the name of the Amazon S3 bucket that contains the training manifest file and images\.
   + `training_manifest` with the name and path to the training manifest file\.
   + The example splits the training dataset to create a test dataset\. If you want to use your own test dataset, do the following\.
     + Uncomment the following line of code:

       ```
       #testing_dataset= json.loads('{"Assets": [{ "GroundTruthManifest": { "S3Object": { "Bucket": "testing_bucket", "Name": "testing_output" } } } ]}')
       ```
     + Replace `testing_bucket` with the name of the Amazon S3 bucket that contains the testing manifest file and images\. 
     + Replace `testing_manifest` with the name and path to the testing manifest file\.

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   import json
   import time
   
   def train_model(project_arn, version_name, output_config, training_dataset,testing_dataset):
   
       client=boto3.client('rekognition')
       
       print('Starting training of: ' + version_name)
         
       try:
           response=client.create_project_version(ProjectArn=project_arn, 
               VersionName=version_name,
               OutputConfig=output_config,
               TrainingData=training_dataset,
               TestingData=testing_dataset)
   
           # Wait for the project version training to complete
           project_version_training_completed_waiter = client.get_waiter('project_version_training_completed')
           project_version_training_completed_waiter.wait(ProjectArn=project_arn,
           VersionNames=[version_name])
       
           #Get the completion status
           describe_response=client.describe_project_versions(ProjectArn=project_arn,
               VersionNames=[version_name])
           for model in describe_response['ProjectVersionDescriptions']:
               print("Status: " + model['Status'])
               print("Message: " + model['StatusMessage']) 
       except Exception as e:
           print(e)
   
       print('Done...')
       
   def main():
       
       project_arn='project_arn'
       version_name='version_name'
       
       output_config = json.loads('{"S3Bucket":"output_bucket", "S3KeyPrefix":"output_folder"}')
       training_dataset= json.loads('{"Assets": [{ "GroundTruthManifest": { "S3Object": { "Bucket": "training_bucket", "Name": "training-_manifest" } } } ] }')
       testing_dataset= json.loads('{"AutoCreate":true}')
       #testing_dataset= json.loads('{"Assets": [{ "GroundTruthManifest": { "S3Object": { "Bucket": "testing_bucket", "Name": "testing_output" } } } ]}')
     
       train_model(project_arn, version_name, output_config, training_dataset, testing_dataset)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   The following example creates a model\. Replace the following:
   + `projectArn` with the Amazon Resource Name \(ARN\) of the project\.
   + `versionName` with a unique version name of your choosing\.
   + `outputBucket` with the name of the Amazon S3 bucket where Amazon Rekognition Custom Labels saves the training results\.
   + `outputFolder` with the name of the folder where the training results are saved\.
   + `trainingBucket` with the name of the Amazon S3 bucket that contains the training manifest file and images\.
   + `trainingManifest` with the name and path to the training manifest file\.
   + The example splits the training dataset to create a test dataset\. If you want to use your own test dataset, do the following\.
     + Uncomment the following lines of code:

       ```
              /* TestingData testingData = new TestingData()
                     .withAssets(new Asset[] {new Asset()
                     .withGroundTruthManifest(testingGroundTruthManifest)});
                */
       ```
     + Replace `testingBucket` with the name of the Amazon S3 bucket that contains the testing manifest file and images\. 
     + Replace `testingManifest` with the name and path to the testing manifest file\.

   ```
   //Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   package com.amazonaws.samples;
   
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.Asset;
   import com.amazonaws.services.rekognition.model.CreateProjectVersionRequest;
   import com.amazonaws.services.rekognition.model.CreateProjectVersionResult;
   import com.amazonaws.services.rekognition.model.DescribeProjectVersionsRequest;
   import com.amazonaws.services.rekognition.model.DescribeProjectVersionsResult;
   import com.amazonaws.services.rekognition.model.GroundTruthManifest;
   import com.amazonaws.services.rekognition.model.OutputConfig;
   import com.amazonaws.services.rekognition.model.ProjectVersionDescription;
   import com.amazonaws.services.rekognition.model.S3Object;
   import com.amazonaws.services.rekognition.model.TestingData;
   import com.amazonaws.services.rekognition.model.TrainingData;
   import com.amazonaws.waiters.Waiter;
   import com.amazonaws.waiters.WaiterParameters;
   
   
   
   public class TrainModel {
   
       public static void main(String[] args) throws Exception {
   
   
           String projectArn = "project_arn";
   
           String versionName="version_name";
           String outputBucket="output_bucket";
           String outputFolder="output_folder";
           String trainingBucket="training_bucket";
           String trainingManifest="training_manifest";
           String testingBucket="testing_bucket";
           String testingManifest="testing_manifest";
   
   
           OutputConfig outputConfig = new OutputConfig()
                   .withS3Bucket(outputBucket)
                   .withS3KeyPrefix(outputFolder);
   
           GroundTruthManifest trainingGroundTruthManifest = new GroundTruthManifest()
                   .withS3Object(new S3Object()
                           .withBucket(trainingBucket)
                           .withName(trainingManifest));
   
   
           GroundTruthManifest testingGroundTruthManifest = new GroundTruthManifest()
                   .withS3Object(new S3Object()
                           .withBucket(testingBucket)
                           .withName(testingManifest));
   
   
           TrainingData trainingData = new TrainingData()
                   .withAssets(new Asset[] {new Asset()
                           .withGroundTruthManifest(trainingGroundTruthManifest)});
   
           TestingData testingData=new TestingData()
                   .withAutoCreate(true);
   
   
          /* TestingData testingData = new TestingData()
                 .withAssets(new Asset[] {new Asset()
                 .withGroundTruthManifest(testingGroundTruthManifest)});
            */	 
   
   
           AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
   
           CreateProjectVersionRequest request = new CreateProjectVersionRequest()
                   .withOutputConfig(outputConfig)
                   .withProjectArn(projectArn)
                   .withTrainingData(trainingData)
                   .withTestingData(testingData)
                   .withVersionName(versionName);
   
           try{
   
               CreateProjectVersionResult result = rekognitionClient.createProjectVersion(request);
   
               System.out.println("Model ARN: " + result.getProjectVersionArn());
   
               System.out.println("Training model...");
   
               DescribeProjectVersionsRequest describeProjectVersionsRequest = new DescribeProjectVersionsRequest()
                       .withVersionNames(versionName)
                       .withProjectArn(projectArn);
   
   
               Waiter<DescribeProjectVersionsRequest> waiter = rekognitionClient.waiters().projectVersionTrainingCompleted();
               waiter.run(new WaiterParameters<>(describeProjectVersionsRequest));
   
               DescribeProjectVersionsResult response=rekognitionClient.describeProjectVersions(describeProjectVersionsRequest);
   
               for(ProjectVersionDescription projectVersionDescription: response.getProjectVersionDescriptions() )
               {
                   System.out.println("Status: " + projectVersionDescription.getStatus());
               }
               System.out.println("Done...");
   
   
           } catch(Exception e) {
               System.out.println(e.toString());
           }
           System.out.println("Done...");
       }
   }
   ```

------