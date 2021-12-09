# Enable Tracing for a Project<a name="customize-project-xray"></a>

AWS X\-Ray offers tracing, which you can use to analyze performance behavior of distributed applications \(for example, latencies in response times\)\. After you add traces to your AWS CodeStar project, you can use the AWS X\-Ray console to view application views and response times\.

**Note**  
You can use these steps for the following projects, created with the following project support changes:   
Any Lambda project\.
For Amazon EC2 or Elastic Beanstalk projects created after August 3, 2018, AWS CodeStar provisioned a `/template.yml`file in the project repository\.

Each AWS CodeStar template includes an AWS CloudFormation file that models your application's AWS runtime dependencies, such as database tables and Lambda functions\. This file is stored in your source repository in the file `/template.yml`\.

You can modify this file to add tracing by adding the AWS X\-Ray resource to the `Resources` section\. You then modify the IAM permissions for your project to allow AWS CloudFormation to create the resource\. For information about template elements and formatting, see [AWS Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html)\.

These are the high\-level steps to follow to customize your template\. 

1.  [Step 1: Edit the Worker Role in IAM for Tracing](#customize-project-xray-edit-worker)

1. [Step 2: Modify the template\.yml File for Tracing](#customize-project-xray-edit-template)

1. [Step 3: Commit and Push Your Template Change for Tracing](#customize-project-xray-commit-template)

1. [Step 4: Monitor the AWS CloudFormation Stack Update for Tracing ](#customize-project-xray-stack-update) 

## Step 1: Edit the Worker Role in IAM for Tracing<a name="customize-project-xray-edit-worker"></a>

You must be signed in as an administrator to perform steps 1 and 4\. This step shows an example of editing permissions for a Lambda project\.

**Note**  
You can skip this step if your project was provisioned with a permissions boundary policy\.  
For projects created after December 6, 2018 PDT, AWS CodeStar provisioned your project with a permissions boundary policy\.

1. Sign in to the AWS Management Console and open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Create a project or choose an existing project with a `template.yml file`, and then open the **Project resources** page\.

1. Under **Project Resources**, locate the IAM role created for the CodeStarWorker/Lambda role in the resource list\. The role name follows this format: `role/CodeStarWorker-Project_name-lambda-Function_name`\. Choose the ARN for the role\.

1. The role opens in the IAM console\. Choose **Attach policies**\. Search for the `AWSXrayWriteOnlyAccess` policy, select the box next to it, and then choose **Attach Policy**\.

## Step 2: Modify the template\.yml File for Tracing<a name="customize-project-xray-edit-template"></a>

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Choose your serverless project and then open the **Code** page\. In the top level of your repository, locate and edit the `template.yml` file\. Under `Resources`, paste the resource into the `Properties` section \.

   ```
         Tracing: Active
   ```

   This example shows a modified template:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-xray-template-lambda.png)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)

## Step 3: Commit and Push Your Template Change for Tracing<a name="customize-project-xray-commit-template"></a>
+ Commit and push the changes in the `template.yml` file\.
**Note**  
This starts your pipeline\. If you commit the changes before you update IAM permissions, your pipeline starts, the AWS CloudFormation stack update encounters errors, and the stack update is rolled back\. If this happens, correct the permissions and then restart your pipeline\.

## Step 4: Monitor the AWS CloudFormation Stack Update for Tracing<a name="customize-project-xray-stack-update"></a>

1. The AWS CloudFormation stack update starts when the pipeline for your project starts the Deploy stage\. To see the status of the stack update, on your AWS CodeStar dashboard, choose the AWS CloudFormation stage in your pipeline\.

   If the stack update in AWS CloudFormation returns errors, see troubleshooting guidelines in [AWS CloudFormation: Stack Creation Rolled Back for Missing Permissions](troubleshooting.md#troubleshooting-cloudformation-stack-creation-permissions)\. If permissions are missing from the worker role, edit the policy attached to your project's Lambda worker role\. See [Step 1: Edit the Worker Role in IAM for Tracing](#customize-project-xray-edit-worker)\.

1. Use the dashboard to view the successful completion of your pipeline\. Tracing is now enabled on your application\.

1.  Verify that tracing is enabled by viewing the details for your function in the Lambda console\.

1. Choose the application endpoint for your project\. This interaction with your application is traced\. You can view tracing information in the AWS X\-Ray console\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-xray-console-tracelist.png)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)