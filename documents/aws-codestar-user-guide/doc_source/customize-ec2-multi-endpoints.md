# Add a Prod Stage and Endpoint to a Project<a name="customize-ec2-multi-endpoints"></a>

Use the procedures in this section to add a new production \(Prod\) stage to your pipeline and a manual approval stage between your pipeline's Deploy and Prod stages\. This creates an additional resource stack when your project pipeline runs\. 

**Note**  
You can use these procedures if:   
For projects created after August 3, 2018, AWS CodeStar provisioned your Amazon EC2, Elastic Beanstalk, or Lambda project with a `/template.yml` file in the project repository\.
For projects created after December 6, 2018 PDT, AWS CodeStar provisioned your project with a permissions boundary policy\.

All AWS CodeStar projects use an AWS CloudFormation template file that models your application's AWS runtime dependencies, such as Linux instances and Lambda functions\. The `/template.yml` file is stored in your source repository\.

In the `/template.yml` file, use the `Stage` parameter to add a resource stack for a new stage in the project pipeline\.

```
  Stage:
    Type: String
    Description: The name for a project pipeline stage, such as Staging or Prod, for which resources are provisioned and deployed.
    Default: ''
```

The `Stage` parameter is applied to all named resources with the project ID referenced in the resource\. For example, the following role name is a named resource in the template:

```
RoleName: !Sub 'CodeStar-${ProjectId}-WebApp${Stage}'
```

## Prerequisites<a name="prereq"></a>

Use the template options in the AWS CodeStar console to create a project\. 

Make sure your IAM user has the following permissions:
+ `iam:PassRole` on the project AWS CloudFormation role\.
+ `iam:PassRole` on the project toolchain role\.
+ `cloudformation:DescribeStacks`
+ `cloudformation:ListChangeSets`

For Elastic Beanstalk or Amazon EC2 projects only:
+ `codedeploy:CreateApplication`
+ `codedeploy:CreateDeploymentGroup`
+ `codedeploy:GetApplication`
+ `codedeploy:GetDeploymentConfig`
+ `codedeploy:GetDeploymentGroup`
+ `elasticloadbalancing:DescribeTargetGroups`

**Topics**
+ [Prerequisites](#prereq)
+ [Step 1: Create an Application and Deployment Group in CodeDeploy \(Amazon EC2 Projects Only\)](#customize-ec2-multi-endpoints-newdeployment)
+ [Step 2: Add a New Pipeline Stage for the Prod Stage](#customize-ec2-multi-endpoints-newstage)
+ [Step 3: Add a Manual Approval Stage](#customize-ec2-multi-endpoints-approval)
+ [Step 4: Push a Change and Monitor the AWS CloudFormation Stack Update](#customize-ec2-multi-endpoints-stack)

## Step 1: Create an Application and Deployment Group in CodeDeploy \(Amazon EC2 Projects Only\)<a name="customize-ec2-multi-endpoints-newdeployment"></a>

You choose your CodeDeploy application and then add a new deployment group associated with the new instance\.

**Note**  
If your project is a Lambda or Elastic Beanstalk project, you can skip this step\.

1. Open the CodeDeploy console at [https://console\.aws\.amazon\.com/codedeploy](https://console.aws.amazon.com/codedeploy)\.

1. Choose **Create application**\.

1. In **Application name**, enter a name for your application that includes the project name and the Prod stage \(for example, <*project\-id*>\-*prod*\)\.

1. In **Compute platform**, choose **EC2/On\-premises**\.

1. Choose **Create application**\.

1. Under **Deployment groups**, choose **Create deployment group**\.

1. In **Deployment group name**, enter ***<project\-id>\-prod\-Env***\.

1. In **Service role**, choose the toolchain worker role for your AWS CodeStar project\.

1. Under **Deployment type**, choose **In\-place**\.

1. Under **Environment configuration**, choose the **Amazon EC2 Instances** tab\.

1. Under the tag group, under **Key**, choose `aws:cloudformation:stack-name`\. Under **Value**, choose `awscodestar-<projectid>-infrastructure-prod` \(the stack to be created for the **GenerateChangeSet** action\)\.

1. In **Deployment settings**, choose `CodeDeployDefault.AllAtOnce`\.

1. Clear **Choose a load balancer**\.

1. Choose **Create deployment group**\.

   Now your second deployment group has been created\.

## Step 2: Add a New Pipeline Stage for the Prod Stage<a name="customize-ec2-multi-endpoints-newstage"></a>

Add a stage with the same set of deployment actions as your project's Deploy stage\. For example, the new Prod stage for an Amazon EC2 project should have the same actions as the Deploy stage created for the project\.

**To copy parameters and fields from the Deploy stage**

1. From your AWS CodeStar project dashboard, choose **Pipeline Details** to open your pipeline in the CodePipeline console\.

1. Choose **Edit**\.

1. In the Deploy stage, choose **Edit stage**\.

1. Choose the edit icon on the **GenerateChangeSet** action\. Make a note of the values in the following fields\. You use these values when you create your new action\.
   + **Stack name**
   + **Change set name**
   + **Template**
   + **Template configuration**
   + **Input artifacts**

1. Expand **Advanced**, and in **Parameters**, copy the parameters for your project\. You paste these parameters into your new action\. For example, copy the parameters that are shown here in JSON format:
   + Lambda projects:

     ```
     {
       "ProjectId":"MyProject"
     }
     ```
   + Amazon EC2 projects:

     ```
     {
     
       "ProjectId":"MyProject",
       "InstanceType":"t2.micro",
       "WebAppInstanceProfile":"awscodestar-MyProject-WebAppInstanceProfile-EXAMPLEY5VSFS",
       "ImageId":"ami-EXAMPLE1",
       "KeyPairName":"my-keypair",
       "SubnetId":"subnet-EXAMPLE",
       "VpcId":"vpc-EXAMPLE1"
     }
     ```
   + Elastic Beanstalk projects:

     ```
     {
       "ProjectId":"MyProject",
       "InstanceType":"t2.micro",
       "KeyPairName":"my-keypair",
       "SubnetId":"subnet-EXAMPLE",
       "VpcId":"vpc-EXAMPLE",
       "SolutionStackName":"64bit Amazon Linux 2018.03 v3.0.5 running Tomcat 8 Java 8",
       "EBTrustRole":"CodeStarWorker-myproject-EBService",
       "EBInstanceProfile":"awscodestar-myproject-EBInstanceProfile-11111EXAMPLE"
     }
     ```

1. In the stage edit pane, choose **Cancel**\.

**To create a GenerateChangeSet action in your new Prod stage**
**Note**  
After you add the new action but while you are still in edit mode, if you reopen the new action for editing, some of the fields might not be displayed\. You might also see following: Stack *stack\-name* does not exist  
This error does not prevent you from saving the pipeline\. However, to restore the missing fields, you must delete the new action and add it again\. After you save and run the pipeline, the stack is recognized and the error does not reappear\.

1. If your pipeline is not already displayed, from your AWS CodeStar project dashboard, choose **Pipeline Details** to open your pipeline in the console\.

1. Choose **Edit**\.

1. At the bottom of the diagram, choose **\+ Add stage**\.

1. Enter a stage name \(for example, **Prod**\), and then choose **\+ Add action group**\.

1. In **Action name**, enter a name \(for example, **GenerateChangeSet**\)\.

1. In **Action provider**, choose **AWS CloudFormation**\.

1. In **Action mode**, choose **Create or replace a change set**\.

1. In **Stack name**, enter a new name for the AWS CloudFormation stack that is to be created by this action\. Start with a name that is identical to the Deploy stack name, and then add **\-prod**:
   + Lambda projects: `awscodestar-<project_name>-lambda-prod`
   + Amazon EC2 and Elastic Beanstalk projects: `awscodestar-<project_name>-infrastructure-prod`
**Note**  
The stack name must start with **awscodestar\-<project\_name>\-** exactly, or the stack creation fails\.

1. In **Change set name**, enter the same change set name as provided in the existing Deploy stage \(for example, **pipeline\-changeset**\)\.

1. In **Template**, enter the same change template name as provided in the existing Deploy stage \(for example, **<project\-ID>\-BuildArtifact::template\.yml**\)\.

1. In **Template configuration**, enter the same change template configuration file name as provided in the Deploy stage \(for example, **<project\-ID>\-BuildArtifact::template\-configuration\.json**\)\.

1. In **Capabilities**, choose **CAPABILITY\_NAMED\_IAM**\.

1. In **Role name**, choose the name of your project's AWS CloudFormation worker role\.

1. Expand **Advanced**, and in **Parameters**, paste the parameters for your project\. Include the `Stage` parameter, shown here in JSON format, for an Amazon EC2 project:

   ```
   {
   
     "ProjectId":"MyProject",
     "InstanceType":"t2.micro",
     "WebAppInstanceProfile":"awscodestar-MyProject-WebAppInstanceProfile-EXAMPLEY5VSFS",
     "ImageId":"ami-EXAMPLE1",
     "KeyPairName":"my-keypair",
     "SubnetId":"subnet-EXAMPLE",
     "VpcId":"vpc-EXAMPLE1",
     "Stage":"Prod"
   }
   ```
**Note**  
Make sure to paste all of the parameters for the project, not just new parameters or parameters you want to change\.

1. In **Input artifacts**, choose the build artifact\.

1. Choose **Save**\.

1. In the AWS CodePipeline pane, choose **Save pipeline change**, and then choose **Save change**\. View your updated pipeline\.

**To create an ExecuteChangeSet action in your new Prod stage**

1. If you are not already viewing your pipeline, from your AWS CodeStar project dashboard, choose **Pipeline Details** to open your pipeline in the console\.

1. Choose **Edit**\.

1. In your new Prod stage, after the new **GenerateChangeSet** action, choose **\+ Add action group**\.

1. In **Action name**, enter a name \(for example, **ExecuteChangeSet**\)\.

1. In **Action provider**, choose **AWS CloudFormation**\.

1. In **Action mode**, choose **Execute a change set**\.

1. In **Stack name**, enter the new name for the AWS CloudFormation stack that you entered in the GenerateChangeSet action \(for example, **awscodestar\-<project\-ID>\-infrastructure\-prod**\)\.

1. In **Change set name**, enter the same change set name used in the Deploy stage \(for example,**pipeline\-changeset**\)\.

1. Choose **Save**\.

1. In the AWS CodePipeline pane, choose **Save pipeline change**, and then choose **Save change**\. View your updated pipeline\.

**To create a CodeDeploy Deploy action in your new Prod stage \(Amazon EC2 projects only\)**

1. After the new actions in your Prod stage, choose **\+ Action**\.

1. In **Action name**, enter a name \(for example, **Deploy**\)\.

1. In **Action provider**, choose **AWS CodeDeploy**\.

1. In **Application name**, choose the name of the new CodeDeploy application you created in step 2\.

1. In **Deployment group**, choose the name of the new CodeDeploy deployment group you created in step 2\.

1. In **Input artifacts**, choose the same build artifact used in the existing stage\.

1. Choose **Save**\.

1. In the AWS CodePipeline pane, choose **Save pipeline change**, and then choose **Save change**\. View your updated pipeline\.

## Step 3: Add a Manual Approval Stage<a name="customize-ec2-multi-endpoints-approval"></a>

As a best practice, add a manual approval stage in front of your new production stage\.

1. In the upper left, choose **Edit**\.

1. In your pipeline diagram, between the Deploy and Prod deployment stages, choose **\+ Add stage**\.

1. On **Edit stage**, enter a stage name \(for example, **Approval**\), and then choose **\+ Add action group**\.

1. In **Action name**, enter a name \(for example, **Approval**\)\.

1. In **Approval type**, choose **Manual approval**\.

1. \(Optional\) Under **Configuration**, in **SNS Topic ARN**, choose the SNS topic that you have created and subscribed to\.

1. Choose **Add Action**\.

1. In the AWS CodePipeline pane, choose **Save pipeline change**, and then choose **Save change**\. View your updated pipeline\.

1. To submit your changes and start a pipeline build, choose **Release change**, and then choose **Release**\.

## Step 4: Push a Change and Monitor the AWS CloudFormation Stack Update<a name="customize-ec2-multi-endpoints-stack"></a>

1. Make a change in your repository to start your pipeline\.

1. When the pipeline starts the Deploy stage, the AWS CloudFormation stack update starts\. You can choose the AWS CloudFormation stage in your pipeline on your AWS CodeStar dashboard to see the stack update notification\. To view stack creation details, in the console, choose your project from the **Events** list\. 

1. After successful completion of your pipeline, the resources are created in your AWS CloudFormation stack\. In the AWS CloudFormation console, choose the infrastructure stack for your project\. Stack names follow this format:
   + Lambda projects: `awscodestar-<project_name>-lambda-prod`
   + Amazon EC2 and Elastic Beanstalk projects: `awscodestar-<project_name>-infrastructure-prod`

   In the **Resources ** list in the AWS CloudFormation console, view the resource created for your project\. In this example, the new Amazon EC2 instance appears in the **Resources** section\.

1. Access the endpoint for your production stage:
   + For an Elastic Beanstalk project, open the new stack in the AWS CloudFormation console and expand **Resources**\. Choose the Elastic Beanstalk application\. The link opens in the Elastic Beanstalk console\. Choose **Environments**\. Choose the URL in **URL** to open the endpoint in a browser\.
   + For a Lambda project, open the new stack in the AWS CloudFormation console and expand **Resources**\. Choose the API Gateway resource\. The link opens in the API Gateway console\. Choose **Stages**\. Choose the URL in **Invoke URL** to open the endpoint in a browser\.
   + For an Amazon EC2 project, choose the new Amazon EC2 instance in your project resources list in the AWS CodeStar console\. The link opens on the **Instance** page of the Amazon EC2 console\. Choose the **Description** tab, copy the URL in **Public DNS \(IPv4\)**, and open the URL in a browser\.

1. Verify that your change is deployed\.