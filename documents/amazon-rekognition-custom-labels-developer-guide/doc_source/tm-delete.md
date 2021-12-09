# Deleting an Amazon Rekognition Custom Labels Model<a name="tm-delete"></a>

You can delete a model by using the Amazon Rekognition Custom Labels console or by using the [DeleteProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_DeleteProjectVersion) API\. You can't delete a model if it is running or if it is training\. To stop a running model, use the [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion) API\. For more information, see [Stopping an Amazon Rekognition Custom Labels Model \(SDK\)](rm-stop-model-sdk.md)\. If a model is training, wait until it finishes before you delete the model\.

A deleted model can't be undeleted\.

**Topics**
+ [Deleting an Amazon Rekognition Custom Labels Model \(Console\)](#tm-delete-console)
+ [Deleting an Amazon Rekognition Custom Labels Model \(SDK\)](#tm-delete-sdk)

## Deleting an Amazon Rekognition Custom Labels Model \(Console\)<a name="tm-delete-console"></a>

The following procedure shows how to delete a model\(s\) from a project details page\. You can also delete a model from a model's detail page\.  

**To delete a model \(console\)**

1. Open the Amazon Rekognition console at [https://console\.aws\.amazon\.com/rekognition/](https://console.aws.amazon.com/rekognition/)\.

1. Choose **Use Custom Labels**\.

1. Choose **Get started**\. 

1. In the left navigation pane, choose **Projects**\.

1. Choose the project that contains the model that you want to delete\. The project details page opens\.

1. In the **Models** section, select the model\(s\) that you want to delete\.
**Note**  
If the model can't be selected, the model is either running or is training, and can't be deleted\. Check the **Status** field and try again after stopping the running model, or wait until training finishes\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/delete-model-project-page.png)

1. Choose **Delete model** and the **Delete model dialog box is shown\.**

1. Enter **delete** to confirm deletion\. 

1. Choose **Delete** to delete the model\. Deleting the model might take a while to complete\.
**Note**  
If you **Close** the dialog box during model deletion, the models are still deleted\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/delete-model.png)

## Deleting an Amazon Rekognition Custom Labels Model \(SDK\)<a name="tm-delete-sdk"></a>

You delete an Amazon Rekognition Custom Labels model by calling [DeleteProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_DeleteProjectVersion) and supplying the Amazon Resource Name \(ARN\) of the model that you want to delete\. You can get the model ARN from the **Use your model** section of the model details page in the Amazon Rekognition Custom Labels console\. Alternatively, call [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions) and supply the following\.
+ The ARN of the project \(`ProjectArn`\) that the model is associated with\.
+ The version name \(`VersionNames`\) of the model\. 

The model ARN is the `ProjectVersionArn` field in the [ProjectVersionDescription](https://docs.aws.amazon.com/rekognition/latest/dg/API_ProjectVersionDescription) object, from the `DescribeProjectVersions` response\.

You can't delete a model if it is running or is training\. To determine if the model is running or training, call [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions) and check the `Status` field of the model's [ProjectVersionDescription](https://docs.aws.amazon.com/rekognition/latest/dg/API_ProjectVersionDescription) object\. To stop a running model, use the [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion) API\. For more information, see [Stopping an Amazon Rekognition Custom Labels Model \(SDK\)](rm-stop-model-sdk.md)\. You have to wait for a model to finishing training before you can delete it\. 

**To delete a model \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following code to delete a model\. 

------
#### [ AWS CLI ]

   Change the value of `project-version-arn` to the name of the project you want to delete\.

   ```
   aws rekognition delete-project-version --project-version-arn model_arn 
   ```

------
#### [ Python ]

   Change the value of `model_arn` to the name of the model you want to delete\.

   ```
   #Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   
   def delete_model(model_arn):
   
       client=boto3.client('rekognition')
   
       #Delete a project
       print('Deleting model:' + model_arn)
       response=client.delete_project_version(ProjectVersionArn=model_arn)
       print('Status: ' + response['Status'])
       print('Done...')
       
   def main():
       model_arn='model_arn'
       delete_model(model_arn)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   Change the value of `modelArn` to the name of the model you want to delete\.

   ```
   //Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   
   
   package com.amazonaws.samples;
   import com.amazonaws.client.builder.AwsClientBuilder;
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.DeleteProjectVersionRequest;
   import com.amazonaws.services.rekognition.model.DeleteProjectVersionResult;
   
   
   public class DeleteModel {
   
      public static void main(String[] args) throws Exception {
   
   
         String modelArn ="model_arn";
   
         AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
         
         try {
             
            DeleteProjectVersionRequest request = new DeleteProjectVersionRequest()
                     .withProjectVersionArn(modelArn); 
            DeleteProjectVersionResult result = rekognitionClient.deleteProjectVersion(request);
     
            System.out.println(result.getStatus());
   
         } catch(Exception e) {
            System.out.println(e.toString());
         }
         System.out.println("Done...");
      }
   }
   ```

------