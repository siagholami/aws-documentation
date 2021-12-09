--------

--------

# Creating and Deploying Flows \(AWS IoT Greengrass\)<a name="iot-tg-workflows-gs"></a>

After you model a flow and upload all of the entities that it contains, you create and deploy the flow\. 

**Prerequisites**

**Note**  
The AWS IoT Greengrass group and Amazon S3 bucket must be created in the same AWS Region\. The AWS IoT Things Graph entities that you create must also be in the same Region as these resources\.
+ An [AWS account](http://aws.amazon.com)
+ An [AWS IoT Greengrass core,](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html) version 1\.7 or later

  Create a directory named **thingsgraph** at the root of your core\. For information on how to configure Greengrass logs, see [Monitoring with AWS IoT Greengrass Logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html)
+ An [Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html) bucket
+ An AWS IoT Greengrass [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) that has access to your S3 bucket

  Add this role to your Greengrass group\. For information on how to configure IAM roles for Greengrass, see [Configure IAM Roles](https://docs.aws.amazon.com/greengrass/latest/developerguide/config-iam-roles.html)\.
+ Completion of the steps in [Creating and Uploading Models](iot-tg-models-gs.html)

We provide procedures for creating and deploying flows using either the AWS CLI or the AWS IoT Things Graph console\. Both the AWS CLI and the console use the two devices that you created in [Creating and Uploading Models](iot-tg-models-gs.html)\.

**Note**  
You must create a **thingsgraph** directory at the root of your AWS IoT Greengrass core device\. If this directory doesn't exist, deployments to your core device won't work\.

**Topics**
+ [Create and Deploy a Flow \(CLI\)](iot-tg-workflows-cli.md)
+ [Create and Deploy a Flow \(AWS IoT Things Graph console\)](iot-tg-workflows-console.md)