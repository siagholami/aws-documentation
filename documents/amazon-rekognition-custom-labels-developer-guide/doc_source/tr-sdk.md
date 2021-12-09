# Accessing the Summary File and Evaluation Manifest Snapshot \(SDK\)<a name="tr-sdk"></a>

To get training results, you call [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions)\. By default, `DescribeProjectVersions` returns information about all model versions in a project\. To specify a specific model version, add the model version ARN to the `ProjectVersionArns` input parameter\. 

The location of the metrics is returned in the `ProjectVersionDescription` response from `DescribeProjectVersions`\.
+ `EvaluationResult` – The location of the summary file\.
+ `TestingDataResult` – The location of the evaluation manifest snapshot used for testing\. 

**Note**  
The amount of time, in seconds, that you are billed for training is returned in `BillableTrainingTimeInSeconds`\. 

For information about the metrics that are returned by the Amazon Rekognition Custom Labels, see [Accessing Amazon Rekognition Custom Labels Training Results \(SDK\)](tr-metrics-api.md)\.

**To access training results \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following examples to get the locations of the summary file and the evaluation manifest snapshot\. Replace `project_arn` with the Amazon Resource Name \(ARN\) of the project that contains the model\. For more information, see [Creating an Amazon Rekognition Custom Labels Project](cp-create-project.md)\. Replace `version_name` with the name of the model version\. For more information, see [Training a Model \(SDK\)](tm-sdk.md)\.

------
#### [ CLI ]

   ```
   aws rekognition describe-project-versions --project-arn "project_arn"\
        --version-names "version_name"
   ```

------
#### [ Python ]

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   import io
   from io import BytesIO
   import sys
   import json
   
   
   def describe_model(project_arn, version_name):
   
       client=boto3.client('rekognition')
       
       response=client.describe_project_versions(ProjectArn=project_arn,
           VersionNames=[version_name])
   
       for model in response['ProjectVersionDescriptions']:
           print(json.dumps(model,indent=4,default=str))
          
   def main():
   
       project_arn='project_arn'
       version_name='version_name'
   
       describe_model(project_arn, version_name)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   ```
   //Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   package com.amazonaws.samples;
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.DescribeProjectVersionsRequest;
   import com.amazonaws.services.rekognition.model.DescribeProjectVersionsResult;
   import com.amazonaws.services.rekognition.model.ProjectVersionDescription;
   import com.fasterxml.jackson.databind.ObjectMapper;
   import com.fasterxml.jackson.databind.SerializationFeature;
   
   public class DescribeModel {
   
       public static void main(String[] args) throws Exception {
   
          
           String projectArn = "project_arn";
           String versionName="version_name";
   
     
           AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
           
           DescribeProjectVersionsRequest describeProjectVersionsRequest = new DescribeProjectVersionsRequest()
                   .withProjectArn(projectArn)
                   .withVersionNames(versionName);
   
   
           ObjectMapper mapper = new ObjectMapper();
           mapper.enable(SerializationFeature.INDENT_OUTPUT);
           
           DescribeProjectVersionsResult response=rekognitionClient.describeProjectVersions(describeProjectVersionsRequest);
   
           for(ProjectVersionDescription projectVersionDescription: response.getProjectVersionDescriptions() )
           {
               System.out.println(mapper.writeValueAsString(projectVersionDescription));
           }
       }
   
   }
   ```

------

The F1 score and summary file location are returned in `EvaluationResult`\. For example:

```
"EvaluationResult": {
                "F1Score": 1.0,
                "Summary": {
                    "S3Object": {
                        "Bucket": "echo-dot-scans",
                        "Name": "test-output/EvaluationResultSummary-my-echo-dots-project-v2.json"
                    }
                }
            }
        }
```

The evaluation manifest snapshot is stored in the location specified in the ` --output-config` input parameter that you specified in [Training a Model \(SDK\)](tm-sdk.md)\. 