# Starting an Amazon Rekognition Custom Labels Model \(SDK\)<a name="rm-start-model-sdk"></a>

You start a model by calling the [StartProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StartProjectVersion) API and passing the Amazon Resource Name \(ARN\) of the model in the `ProjectVersionArn` input parameter\. You also specify the number of inference units that you want to use\. For more information, see [Running a Trained Amazon Rekognition Custom Labels Model](rm-run-model.md)\.

A model might take a while to start\. The Python and Java examples in this topic use waiters to wait for the model to start\. A waiter is a utility method that polls for a particular state to occur\. Alternatively, you can check the current status by calling [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions)\. 

**To start a model \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` and permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following example code to start a model\.

------
#### [ CLI ]

   Change the value of `project-version-arn` to the ARN of the model that you want to start\. Change the value of `--min-inference-units` to the number of inference units that you want to use\.

   ```
   aws rekognition start-project-version  --project-version-arn model_arn\
     --min-inference-units "1"
   ```

------
#### [ Python ]

   Change the following values:
   + `project_arn` to the ARN of the project that contains the model that you want to use\.
   + `model_arn` to the ARN of the model that you want to start\.
   + `version_name` to the name of the model that you want to start\.
   + `min_inference_units` to the number of inference units that you want to use\.

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   
   def start_model(project_arn, model_arn, version_name, min_inference_units):
   
       client=boto3.client('rekognition')
   
       try:
           # Start the model
           print('Starting model: ' + model_arn)
           response=client.start_project_version(ProjectVersionArn=model_arn, MinInferenceUnits=min_inference_units)
           # Wait for the model to be in the running state
           project_version_running_waiter = client.get_waiter('project_version_running')
           project_version_running_waiter.wait(ProjectArn=project_arn, VersionNames=[version_name])
   
           #Get the running status
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
       model_arn='model_arn'
       min_inference_units=1 
       version_name='version_name'
       start_model(project_arn, model_arn, version_name, min_inference_units)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   Change the following values:
   + `projectArn` to the ARN of the project that contains the model that you want to use\.
   + `projectVersionArn` to the ARN of the model that you want to start\.
   + `versionName` to the name of the model that you want to start\.
   + `minInferenceUnits` to the number of inference units that you want to use\.

   ```
   //Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   package com.amazonaws.samples;
   
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.DescribeProjectVersionsRequest;
   import com.amazonaws.services.rekognition.model.DescribeProjectVersionsResult;
   import com.amazonaws.services.rekognition.model.ProjectVersionDescription;
   import com.amazonaws.services.rekognition.model.StartProjectVersionRequest;
   import com.amazonaws.services.rekognition.model.StartProjectVersionResult;
   import com.amazonaws.waiters.Waiter;
   import com.amazonaws.waiters.WaiterParameters;
   
   
   
   public class StartModel {
   
      public static void main(String[] args) throws Exception {
   
         String projectVersionArn ="model_arn";
         String projectArn = "project_arn";
         int minInferenceUnits=1;
         String versionName="version_name";
   
         AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
        
         StartProjectVersionRequest request = new StartProjectVersionRequest()
              .withMinInferenceUnits(minInferenceUnits)
              .withProjectVersionArn(projectVersionArn);
     
         try{
       	  
       	  StartProjectVersionResult result = rekognitionClient.startProjectVersion(request);
       	  
       	  System.out.println("Status: " + result.getStatus());
    
       	  DescribeProjectVersionsRequest describeProjectVersionsRequest = new DescribeProjectVersionsRequest()
       			 .withVersionNames(versionName)
       			 .withProjectArn(projectArn);
       	  
      	  
       	  Waiter<DescribeProjectVersionsRequest> waiter = rekognitionClient.waiters().projectVersionRunning();
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
   
      }
   }
   ```

------