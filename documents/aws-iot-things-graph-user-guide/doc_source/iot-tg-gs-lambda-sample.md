--------

--------

# Creating a Flow with Lambda Functions<a name="iot-tg-gs-lambda-sample"></a>

This topic describes how to create a simple workflow \(flow\) that uses three AWS Lambda functions as service models in that flow\. 

The flow runs every 60 seconds and calls three service models: one that reads data from an Amazon Simple Storage Service \(Amazon S3\) bucket, one that analyzes the data, and one that saves the results of the analysis to the Amazon S3 bucket\.

## Prerequisites<a name="iot-tg-gs-lambda-sample-reqs"></a>

To create this example, you need the following resources\. 

**Note**  
You must create the AWS IoT Greengrass group and Amazon S3 bucket in the same AWS Region\. The AWS IoT Things Graph entities that you create must also be in the same Region as these resources\.
+ An [AWS account](http://aws.amazon.com)\.
+ An [AWS IoT Greengrass core](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html), version 1\.7 or later\.
+ An [AWS IoT Greengrass group](https://docs.aws.amazon.com/greengrass/latest/developerguide/device-group.html)\.
+ [Node\.js](https://nodejs.org/en/download/) installed on your AWS IoT Greengrass core device\.
+ An [Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html) bucket that contains a file named `HelloWorld.txt`\.
+ An AWS IoT Greengrass [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) that has access to your S3 bucket\.

  Add this role to your AWS IoT Greengrass group\. For information about how to configure IAM roles for AWS IoT Greengrass, see [Configure IAM Roles](https://docs.aws.amazon.com/greengrass/latest/developerguide/config-iam-roles.html)\.
+ A Lambda [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) that has access to your S3 bucket\.

## Create an AWS IoT Greengrass Group<a name="iot-tg-gs-lambda-sample-gg"></a>

**Note**  
For information about using AWS CloudFormation to create and manage AWS IoT Greengrass groups and resources, see [AWS IoT Greengrass Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/AWS_Greengrass.html)\.

Perform the steps in [Setting Up Your Environment](iot-tg-gs-environment.html)\. Make sure that you've created an IAM role for AWS IoT Greengrass \(step 4 in the **Create an AWS IoT Greengrass Group** procedure in that topic\)\. Attach the `AmazonS3FullAccess` policy to give it access to your S3 bucket\.

On the **Settings** page of your group, make sure that **Greengrass container** is selected under **Lambda runtime environment**\. 

## Create and Deploy the Lambda Functions<a name="iot-tg-gs-lambda-sample-functions"></a>

1. Create the Lambda functions\.

   1. Follow the instructions in [Create a Simple Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/get-started-create-function.html) to create three Lambda functions named `GetS3Object`, `WordCount`, and `SaveToS3`\. 
**Note**  
The sample won't work if you use any other function names\.

   1. The code for these functions is in the [Lambdas\.zip](samples/Lambdas.zip) file\. Don't add any triggers\. Choose **Node\.js 6\.10** as your runtime\. Use an [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) that has read/write access to your Amazon S3 bucket\. 

      In the `SaveToS3` function, replace the value of `bucket` with the name of your S3 bucket\.

      Each Lambda function is a service model in the flow\. Copy the Lambda Amazon Resource Names \(ARNs\) so that you can use them in your service model definitions\.

   1. After you copy and save the functions in the Lambda console, on the **Actions** menu, choose **Publish new version**\. You must use version 1 for each Lambda function\.

1. Deploy the Lambda functions to AWS IoT Greengrass\.

   To do this, follow the instructions in [Configure the Lambda Function for AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/config-lambda.html)\.

## Create and Publish the Flow<a name="iot-tg-gs-lambda-sample-publish"></a>

To create this flow with the AWS CLI instead of the AWS IoT Things Graph console, follow the instructions in [Creating a Flow with Lambda Functions by Using the AWS CLI](iot-tg-gs-lambda-sample-deploy-cli.html)\.

1. Open the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home)\.

   Choose **Create flow**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleCreateFlow.png)

1. Create a flow\.

   In the **Flow configuration** pane that appears, enter a name for your flow\. Choose **Create flow**\.

1. Add the service models to the flow\.

   On the **Logic** tab, choose **Clock**, and then drag it into the flow designer\.

   On the **Service** tab, search for the **`getS3Lambda`** service model\. Choose the service model and drag it into the flow designer\. Do the same for the **`wordCountLambda`** and **`saveResponseLambda`** service models\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleLambdas.png)

1. Connect the service models\.

   In the flow designer, select the edge of the **ClockTrigger** service model and connect it to the **getS3Lambda** service model\. Then connect the **getS3Lambda**, **`wordCountLambda`**, and **`saveResponseLambda`** service models in the same way\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGLambdasDrop.png)

1. Update the **ClockTrigger**\.

   In the trigger editor that appears in the right pane, for **Frequency**, enter **60**, and then select **seconds** from the menu on the right\. For **Action**, choose **ThingsGraph\.startFlow**\.

1. Add the `getS3Lambda` service model action\.

   1. In the flow designer, choose the **`getS3Lambda`** service model\. In the action editor that appears in the right pane, select **No action configured**\. In the list that appears, select **`getS3ObjectAsString`**\. 

   1. Expand **Inputs**\. Choose **Define Input**, and then enter the names of your Amazon S3 bucket and file as the values for **bucket** and **key**\. 

   1. Expand **Output**, and then enter **getS3LambdaResult**\.

1. Add the `wordCountLambda` service model action\.

   1. In the flow designer, select the **`wordCountLambda`** service model\. In the action editor that appears in the right pane, choose **No action configured**\. For **Action** box, choose **`wordCount`**\. Expand **Inputs**, choose **Define Input**, and then for **message**, enter **$\{getS3LambdaResult\.message\}**\.

   1. Expand **Output**, and then enter **wordCountLambdaResult**\. 

1. Add the `saveResponseLambda` service model action\.

   1. In the flow designer, select the **`saveResponseLambda`** service model\.

   1. In the action editor that appears in the right pane, choose **No action configured**\.

   1. For **Action**, choose **save**\.

   1. Expand **Inputs**, choose **Define Input**, and then for **response**, enter **$\{wordCountLambdaResult\}**\.

1. Publish the flow\.

   Choose **Publish** at the upper right of the page\. This creates the flow and adds it to the list of flows that can be deployed\.

## Create and Deploy the Flow Configuration<a name="iot-tg-gs-lambda-sample-deploy"></a>

1. On the **Flows** list page, select the box next to the flow that you just created, and then choose **Create flow configuration**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGLambdaCreateDeploy.png)

1. Name the flow configuration\.

   On the **Describe flow configuration** page, select your flow and enter a flow configuration name\. The flow configuration name can't contain spaces\. Choose **Greengrass**, and then choose **Next**\.

1. Configure the target\.

   On the **Configure target** page, enter the name of your Amazon S3 bucket and the AWS IoT Greengrass group to which your AWS IoT Greengrass core device belongs\. Amazon S3 buckets are globally unique, so your bucket name will be different from the one in the following screen shot\. Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGLamDeploymentDetails2.png)

1. Select things\.

   This example contains only service models, so you don't have to select any things to use in the flow\. Choose **Next**\.

1. View the trigger\.

   On the **Define trigger** page, the following GraphQL appears in the editor\. This GraphQL specifies the time intervals at which the flow runs\. This flow runs every 60 seconds\. You don't need to edit this code\.

   Choose **Review**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGLamTrigger.png)

1. Review and create\.

   On the **Review and create** page, review the information you entered for your flow configuration\. Choose **Create**\.

1. Deploy\.

   When the **Flow configuration created** message appears, choose **Deploy now**\.

   Refresh the **Deployments** page to verify that the flow has deployed\. After a successful deployment, the **Deployments** page displays **Deployed in target** in the **Status** column\.

## Run the Flow<a name="iot-tg-gs-lambda-sample-run"></a>

After a flow is deployed, it runs automatically every 60 seconds\. You can verify that it's running by going to your Amazon S3 bucket\. You should see a new file named `word-count-response` in the bucket\.

## Delete the Flow and Flow Configuration \(Optional\)<a name="iot-tg-gs-lambda-sample-cleanup"></a>

For instructions on how to undeploy a flow configuration, and delete the flow configuration and flow that you've created, see [Deleting Flow Configurations](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingflowconfig) and [Deleting Systems, Flows, and Namespaces](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingsysflow) in [Lifecycle Management for AWS IoT Things Graph Entities, Flows, Systems, and Deployments](iot-tg-lifecycle.html)\.