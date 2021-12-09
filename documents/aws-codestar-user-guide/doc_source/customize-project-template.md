# Add a Resource to a Project<a name="customize-project-template"></a>

Each AWS CodeStar template for all projects comes with an AWS CloudFormation file that models your application's AWS runtime dependencies, such as database tables and Lambda functions\. This is stored in your source repository in the file `/template.yml`\.

**Note**  
You can use these steps for the following projects, created with the following project support changes:   
Any Lambda project\.
For Amazon EC2 or Elastic Beanstalk projects created after August 3, 2018, AWS CodeStar provisioned a `/template.yml` file in the project repository\.

You can modify this file by adding AWS CloudFormation resources to the `Resources` section\. Modifying the `template.yml` file allows AWS CodeStar and AWS CloudFormation to add the new resource to your project\. Some resources require you to add other permissions to the policy for your project's CloudFormation worker role\. For information about template elements and formatting, see [AWS Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html)\.

After you determine which resources you must add to your project, these are the high\-level steps to follow to customize a template\. For a list of AWS CloudFormation resources and their required properties, see [AWS Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-guide.html)\.

1.  [Step 1: Edit the CloudFormation Worker Role in IAM](#customize-project-template-sqs-2) \(if necessary\)

1. [Step 2: Modify the template\.yml File](#customize-project-template-sqs-1)

1. [Step 3: Commit and Push Your Template Change](#customize-project-template-sqs-3)

1. [Step 4: Monitor the AWS CloudFormation Stack Update ](#customize-project-template-sqs-4) 

1. [Step 5: Add Resource Permissions with an Inline Policy](#customize-project-template-sqs-5)

Use the steps in this section to modify your AWS CodeStar project template to add a resource and then expand the project's CloudFormation worker role's permissions in IAM\. In this example, the [AWS::SQS::Queue](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-sqs-queues.html) resource is added to the `template.yml` file\. The change starts an automated response in AWS CloudFormation that adds an Amazon Simple Queue Service queue to your project\.

## Step 1: Edit the CloudFormation Worker Role in IAM<a name="customize-project-template-sqs-2"></a>

You must be signed in as an administrator to perform steps 1 and 5\.

**Note**  
You can skip this step if your project was provisioned with a permissions boundary policy\.  
For projects created after December 6, 2018 PDT, AWS CodeStar provisioned your project with a permissions boundary policy\.

1. Sign in to the AWS Management Console and open the AWS CodeStar console, at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Create a project or choose an existing project with a `template.yml file`, and then open the **Project resources** page\.

1. Under **Project Resources**, locate the IAM role created for the CodeStarWorker/AWS CloudFormation role in the resource list\. The role name follows this format: `role/CodeStarWorker-Project_name-CloudFormation`\.

1. The role opens in the IAM console\. On the **Permissions** tab, in **Inline Policies**, expand the row for your service role policy, and choose **Edit Policy**\.

1. Choose the **JSON** tab to edit the policy\.
**Note**  
The policy attached to the worker role is `CodeStarWorkerCloudFormationRolePolicy`\.

1. In the **JSON** field, add the following policy statement in the `Statement` element\.

   ```
   {
     "Action": [
       "sqs:CreateQueue",
       "sqs:DeleteQueue",
       "sqs:GetQueueAttributes",
       "sqs:SetQueueAttributes",
       "sqs:ListQueues",
       "sqs:GetQueueUrl"
     ],
     "Resource": [
       "*"
     ],
     "Effect": "Allow"
   }
   ```

1. Choose **Review policy** to ensure the policy contains no errors, and then choose **Save changes**\.

## Step 2: Modify the template\.yml File<a name="customize-project-template-sqs-1"></a>

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

1. Choose your serverless project and then open the **Code** page\. In the top level of your repository, make a note of the location of `template.yml`\.

1. Use an IDE, the console, or the command line in your local repository to edit the `template.yml` file in your repository\. Paste the resource into the `Resources` section\. In this example, when the following text is copied, it adds the `Resources` section\.

   ```
   Resources:
     TestQueue:
       Type: AWS::SQS::Queue
   ```

   This example shows a modified template:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-sqs-template-lambda.png)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)

## Step 3: Commit and Push Your Template Change<a name="customize-project-template-sqs-3"></a>
+ Commit and push the changes in the `template.yml` file that you saved in step 2\.
**Note**  
This starts your pipeline\. If you commit the changes before you update IAM permissions, your pipeline starts and the AWS CloudFormation stack update encounters errors, which causes the stack update to be rolled back\. If this happens, correct the permissions and then restart your pipeline\.

## Step 4: Monitor the AWS CloudFormation Stack Update<a name="customize-project-template-sqs-4"></a>

1. When the pipeline for your project starts the Deploy stage, the AWS CloudFormation stack update starts\. You can choose the AWS CloudFormation stage in your pipeline on your AWS CodeStar dashboard to see the stack update\.

   **Troubleshooting:**

   The stack update fails if required resource permissions are missing\. View the failure status in the AWS CodeStar dashboard view for your project's pipeline\.

   Choose the **CloudFormation** link in your pipeline's Deploy stage to troubleshoot the failure in the AWS CloudFormation console\. In the console, in the **Events** list, choose your project to view stack creation details\. There is a message with the failure details\. In this example, the `sqs:CreateQueue` permission is missing\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/acs-sqs-pipeline-deployfailed-stack.png)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/codestar/latest/userguide/)

   Add any missing permissions by editing the policy attached to your project's AWS CloudFormation worker role\. See [Step 1: Edit the CloudFormation Worker Role in IAM](#customize-project-template-sqs-2)\.

1. After a successful run of your pipeline, the resources are created in your AWS CloudFormation stack\. In the **Resources** list in AWS CloudFormation, view the resource created for your project\. In this example, the TestQueue queue is listed in the **Resources ** section\.

   The queue URL is available in AWS CloudFormation\. The queue URL follows this format:

   ```
   https://{REGION_ENDPOINT}/queue.|api-domain|/{YOUR_ACCOUNT_NUMBER}/{YOUR_QUEUE_NAME}
   ```

   For more information, see [Send an Amazon SQS Message](https://docs.aws.amazon.com/sdk-for-net/v2/developer-guide/SendMessage.html#send-sqs-message), [Receive a Message from an Amazon SQS Queue](https://docs.aws.amazon.com/sdk-for-net/v2/developer-guide/ReceiveMessage.html#receive-sqs-message), and [Delete a Message from an Amazon SQS Queue](https://docs.aws.amazon.com/sdk-for-net/v2/developer-guide/DeleteMessage.html#delete-sqs-message)\. 

## Step 5: Add Resource Permissions with an Inline Policy<a name="customize-project-template-sqs-5"></a>

Grant team members access to your new resource by adding the appropriate inline policy to the user's role\. Not all resources require that you add permissions\. To perform the following steps, you must have signed in to the console either as a root user, an IAM administrator user in the account, or an IAM user or federated user with the `AdministratorAccess` managed policy or equivalent\.

1. In the IAM console, choose **Users**, and then choose the user account\.

1. On the **Permissions** tab, choose **Add inline policy**\. On the **Create policy** page, choose the **JSON** tab\.

1. On the **JSON** tab, paste the policy for your new resource\. Use the permissions that are appropriate for the level of access you want to provide\. This example provides the view\-only policy for the Amazon SQS resource\. Copy and paste the JSON policy provided here\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": [
           "sqs:Get*",
           "sqs:List*",
           "sqs:Receive*"
         ],
         "Resource": "*"
       }
     ]
   }
   ```

1. Choose **Review policy**, and then choose **Create policy**\.

1. In **Name**, enter a name for your inline policy\. To make your policy easier to find and modify, include your AWS CodeStar project name in the policy title\.

1. The updated statement is displayed as attached directly to the user\.

1. If necessary, you can copy the policy to other team members\.
**Important**  
AWS CodeStar does not manage the inline policy created for an added resource\. To remove the user's permissions or clean up deleted resources, you must manually delete the inline policy\.