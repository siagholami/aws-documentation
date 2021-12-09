# Step 2: Create a Project<a name="gs-step-create-project-cli"></a>

You use a project to manage your models\. A project contains the datasets and models that you create\. In this step, you create a project using [CreateProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProject) API\.

**To create a project \(CLI\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` and `AmazonS3FullAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

   1. Set permissions to access the Amazon Rekognition Custom Labels console\. For more information, see [Step 5: Set Up Amazon Rekognition Custom Labels Console Permissions](su-console-policy.md)\.

1. At the command prompt, enter the following command\. Replace `my_project` with a project name of your choice\.

   ```
   aws rekognition create-project --project-name my_project
   ```

1. Note the name of the project Amazon Resource Name \(ARN\) that's displayed in the response\. You'll need it to create a model\. 