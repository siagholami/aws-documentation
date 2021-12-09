# Creating an Amazon Rekognition Custom Labels Project<a name="cp-create-project"></a>

You can create a project with the Amazon Rekognition Custom Labels console or with the API\. When you first use the console, you specify the Amazon S3 bucket where Amazon Rekognition Custom Labels stores your project files\. If you're using the API, you can also use Amazon S3 buckets that are external to the Amazon Rekognition Custom Labels console\.

**Topics**
+ [Creating an Amazon Rekognition Custom Labels Project \(Console\)](#cp-console)
+ [Creating an Amazon Rekognition Custom Labels Project \(SDK\)](#cp-sdk)

## Creating an Amazon Rekognition Custom Labels Project \(Console\)<a name="cp-console"></a>

You can use the Amazon Rekognition Custom Labels console to create a project\. 

**To create a project \(console\)**

1. Sign in to the AWS Management Console and open the Amazon Rekognition console at [https://console\.aws\.amazon\.com/rekognition/](https://console.aws.amazon.com/rekognition/)\.

1. In the left pane, choose **Use Custom Labels**\. The Amazon Rekognition Custom Labels landing page is shown\.

1. Choose **Get started**\. 

1. Choose **Create Project**\. 

1. If this is the first time that you've opened the console in the current AWS Region, the **First Time Set Up** dialog box is shown\. Do the following:

   1. Note the name of the Amazon S3 bucket that's shown\.

   1. Choose **Create S3 bucket** to let Amazon Rekognition Custom Labels create an Amazon S3 bucket on your behalf\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/first-time.png)

1. In the **Create project** section, enter a name for your project\. 

1. Choose **Create project** to create your project\. The project page is shown\. A success message should be shown at the top of the page\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/create-project.png)

## Creating an Amazon Rekognition Custom Labels Project \(SDK\)<a name="cp-sdk"></a>

You create an Amazon Rekognition Custom Labels project by calling [CreateProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProject)\. The response is an Amazon Resource Name \(ARN\) as an identifier for the project\. After you create a project, you create datasets for training and testing a model\. For more information, see [Creating an Amazon Rekognition Custom Labels Dataset](cd-create-dataset.md)\. 

**To create a project \(SDK\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following code to create a project\. 

------
#### [ AWS CLI ]

   The following example creates a project and displays its ARN\.

   Change the value of `project-name` to the name of the project that you want to create\.

   ```
   aws rekognition create-project --project-name my_project
   ```

------
#### [ Python ]

   The following example creates a project and displays its ARN\.

   Change the value of `project_name` to the name of the project you want to create\.

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   
   def create_project(project_name):
   
       client=boto3.client('rekognition')
   
       #Create a project
       print('Creating project:' + project_name)
       response=client.create_project(ProjectName=project_name)
       print('project ARN: ' + response['ProjectArn'])
       print('Done...')
       
   def main():
       project_name='project'
       create_project(project_name)
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   The following example creates a project and displays its ARN\.

   Change the value of `projectName` to the name of the project you want to create\.

   ```
   //Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   package com.amazonaws.samples;
   
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   import com.amazonaws.services.rekognition.model.CreateProjectRequest;
   import com.amazonaws.services.rekognition.model.CreateProjectResult;
   
   
   public class CreateProject {
   
       public static void main(String[] args) throws Exception {
   
           String projectName="project_name";
   
           try{
               AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
   
               CreateProjectRequest createProjectRequest = new CreateProjectRequest()
                       .withProjectName(projectName);
   
               CreateProjectResult response=rekognitionClient.createProject(createProjectRequest);
               
               System.out.println("Project ARN: " + response.getProjectArn());
   
   
           } catch(Exception e) {
               System.out.println(e.toString());
           }
           System.out.println("Done...");
       }
   }
   ```

------

1. Note the name of the project ARN that's displayed in the response\. You'll need it to create a model\. 