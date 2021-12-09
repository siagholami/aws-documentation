# Stopping an Amazon Rekognition Custom Labels Model \(SDK\)<a name="rm-stop-model-sdk"></a>

You stop a model by calling the [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion) API and passing the Amazon Resource Name \(ARN\) of the model in the `ProjectVersionArn` input parameter\. 

A model might take a while to stop\. To check the current status, use `DescribeProjectVersions`\. 

**To stop a model \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following example code to stop a running model\.

------
#### [ CLI ]

   Change the value of `project-version-arn` to the ARN of the model that you want to stop\.

   ```
   aws rekognition stop-project-version --project-version-arn "my project"
   ```

------
#### [ Python ]

   The following example stops a model that is already running\.

   Change the value of `model_arn` to the name of the model that you want to stop\.

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   import time
   
   
   def stop_model(model_arn):
   
       client=boto3.client('rekognition')
   
       print('Stopping model:' + model_arn)
   
       #Stop the model
       try:
           response=client.stop_project_version(ProjectVersionArn=model_arn)
           status=response['Status']
           print ('Status: ' + status)
       except Exception as e:  
           print(e)  
   
       print('Done...')
       
   def main():
       
       model_arn='model_arn'
       stop_model(model_arn)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   The following example stops a model that is already running\.

   Change the value of `projectVersionArn` to the name of the model that you want to stop\.

   ```
   //Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   package com.amazonaws.samples;
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.StopProjectVersionRequest;
   import com.amazonaws.services.rekognition.model.StopProjectVersionResult;
   
   
   public class StopModel {
   
      public static void main(String[] args) throws Exception {
   
   
         String projectVersionArn ="model_arn";
   
         AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
          
         try {
             
            StopProjectVersionRequest request = new StopProjectVersionRequest()
                     .withProjectVersionArn(projectVersionArn); 
            StopProjectVersionResult result = rekognitionClient.stopProjectVersion(request);
     
            System.out.println(result.getStatus());
   
         } catch(Exception e) {
            System.out.println(e.toString());
         }
         System.out.println("Done...");
      }
   }
   ```

------