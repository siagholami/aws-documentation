# Deleting an Amazon Rekognition Custom Labels Project<a name="cp-delete"></a>

You can delete a project by using the Amazon Rekognition console or by calling the [DeleteProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_DeleteProject) API\. To delete a project, you must first delete each associated model\. A deleted project or model can't be undeleted\. 

**Topics**
+ [Deleting an Amazon Rekognition Custom Labels Project \(Console\)](#cp-delete-console)
+ [Deleting an Amazon Rekognition Custom Labels Project \(SDK\)](#cp-delete-sdk)

## Deleting an Amazon Rekognition Custom Labels Project \(Console\)<a name="cp-delete-console"></a>

You can delete a project from the projects page, or you can delete a project from a project's detail page\. The following procedure shows you how to delete a project using the projects page\.

The Amazon Rekognition Custom Labels console deletes associated models for you during project deletion, except when a model is running or training\. If a model is running, use the [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion) API to stop the model\. For more information, see [Stopping an Amazon Rekognition Custom Labels Model \(SDK\)](rm-stop-model-sdk.md)\. If a model is training, wait until it finishes before you delete the project\.

**To delete a project \(console\)**

1. Open the Amazon Rekognition console at [https://console\.aws\.amazon\.com/rekognition/](https://console.aws.amazon.com/rekognition/)\.

1. Choose **Use Custom Labels**\.

1. Choose **Get started**\. 

1. In the left navigation pane, choose **Projects**\.

1. On the **Projects** page, select the radio button for the project that you want to delete\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/delete-projects-page.png)

1. Choose **Delete** at the top of the page\. The **Delete project** dialog box is shown\.

1. If the project has no associated models:

   1. Enter **delete** to delete the model\.

   1. Choose **Delete** to delete the project\.

1. If the project has associated models:

   1. Enter **delete** to confirm that you want to delete the model\(s\)\.

   1. Choose **Delete associated models**\. Model deletion might take a while to complete\.
**Note**  
The console can't delete models that are in\-training or running\. Try again after stopping any running models that are listed, and wait until models listed as training finish\.  
If you **Close** the dialog box during model deletion, the models are still deleted\. Later, you can delete the project by repeating this procedure\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/delete-project-with-models.png)

   1. Enter **delete** to confirm that you want to delete the project\.

   1. Choose **Delete** to delete the project\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/delete-project.png)

## Deleting an Amazon Rekognition Custom Labels Project \(SDK\)<a name="cp-delete-sdk"></a>

You delete an Amazon Rekognition Custom Labels project by calling [DeleteProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_DeleteProject) and supplying the Amazon Resource Name \(ARN\) of the project that you want to delete\. To get the ARNs of the projects in your account, call [DescribeProjects](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjects)\. The response includes an array of [ProjectDescription](https://docs.aws.amazon.com/rekognition/latest/dg/API_ProjectDescription) objects\. The project ARN is the `ProjectArn` field\. You can use the project name to identify the ARN of the project\. For example, `arn:aws:rekognition:us-east-1:123456789010:project/project name/1234567890123`\. 

Before you can delete a project, you must first delete all models in the project\. For more information, see [Deleting an Amazon Rekognition Custom Labels Model \(SDK\)](tm-delete.md#tm-delete-sdk)\. The project might take a few moments to delete\. During that time, the status of the project is `DELETING`\. The project is deleted if a subsequent call to [DescribeProjects](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjects) doesn't include the project that you deleted\.

**To delete a project \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following code to delete a project\. 

------
#### [ AWS CLI ]

   Change the value of `project-arn` to the name of the project that you want to create\.

   ```
   aws rekognition delete-project --project-arn project_arn 
   ```

------
#### [ Python ]

   Change the value of `project_arn` to the name of the project you want to delete\.

   ```
   #Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   
   def delete_project(project_arn):
   
       client=boto3.client('rekognition')
   
       #Delete a project
       print('Deleting project:' + project_arn)
       response=client.delete_project(ProjectArn=project_arn)
       print('Status: ' + response['Status'])
       print('Done...')
       
   def main():
       project_arn='project_arn'
       delete_project(project_arn)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   Change the value of `projectArn` to the ARN of the project you want to delete\.

   ```
   //Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   
   
   package com.amazonaws.samples;
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.DeleteProjectRequest;
   import com.amazonaws.services.rekognition.model.DeleteProjectResult;
   
   
   public class DeleteProject {
   
      public static void main(String[] args) throws Exception {
   
   
         String projectArn ="project_arn";
   
         AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
   
         try {
             
            DeleteProjectRequest request = new DeleteProjectRequest()
                     .withProjectArn(projectArn); 
            DeleteProjectResult result = rekognitionClient.deleteProject(request);
     
            System.out.println(result.getStatus());
   
         } catch(Exception e) {
            System.out.println(e.toString());
         }
         System.out.println("Done...");
      }
   }
   ```

------