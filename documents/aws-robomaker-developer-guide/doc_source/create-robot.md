# Creating a Robot<a name="create-robot"></a>

Before you can deploy a robot application, you must configure your robot hardware\. When you create a robot, you select the hardware architecture and an IAM role for AWS IoT Greengrass\. After the robot is created, download the AWS IoT Greengrass core and security resources, then configure your robot hardware\.

**Topics**
+ [Create deployment role](#create-robot-role)
+ [Create a robot](#create-robot-steps)

## Create deployment role<a name="create-robot-role"></a>

Before you create a robot, create an IAM role for robot application deployment\. The role will also be used by AWS RoboMaker to access resources like Amazon S3 \(where your robot application is placed prior to deployment\) and by your robot application to access resources it consumes like Amazon Lex or Amazon Rekognition\.

If you have already created these roles, you can skip to [Create a robot](#create-robot-steps)\. 

**To create the AWS IoT Greengrass role**

1. Sign in to the AWS Management Console and open the AWS Identity and Access Management console at [console\.aws\.amazon\.com/iam](https://console.aws.amazon.com/iam)\.

1. Create the access policy\. On the left, choose **Policies**, then choose **Create policy**\. Choose **JSON** and paste the code below:

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "robomaker:UpdateRobotDeployment"
               ],
               "Resource": "*"
           },
           {
               "Effect": "Allow",
               "Action": [
                   "s3:List*",
                   "s3:Get*"
               ],
               "Resource": ["arn:aws:s3:::my-robot-application-source-bucket/*"]
           }
       ]
   }
   ```

   Choose **Review policy**, type in a **Name**, and then choose **Create policy**\.

1. Choose **Roles** and then choose **Create role**\.

1. In the **Create role: Step 1** page, choose **Greengrass** and then choose **Next: Permissions**\.

1. In the **Permissions** page, select the policy you created above, then choose **Next: Tags**\.

1. In the **Add tags** page, add optional tags to the role, then choose **Next: Review**\.

1. In the **Review** page, type in a **Role name** and then choose **Create role**\.

1. Next, update the trust policy to include AWS Lambda\. Select the new role, then select the **Trust relationships** tab\.

1. In the **Trust relationship** tab, select **Edit trust relationship**\.

1. Update the trust relationship with the following policy document: 

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": [
             "lambda.amazonaws.com",
             "greengrass.amazonaws.com"
           ]
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

1. Select **Update Trust Policy**\.

## Create a robot<a name="create-robot-steps"></a><a name="proc-create-robot-con"></a>

**To create a robot:**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet Management**, and then choose **Robots**\.

1. Choose **Create robot**\.

1. In the **Create robot** page, type a **name** for the robot\.

1. Select the **Architecture** of the robot\.

1. Under **AWS IoT Greengrass group defaults**, select a **Create new** to create a new AWS IoT Greengrass group for the robot\. Optionally, you can select an existing AWS IoT Greengrass group\. Each robot must have its own AWS IoT Greengrass group\.

   If you use an existing AWS IoT Greengrass group, it must have an IAM role associated with it\. To create the role, see [Create deployment role](#create-robot-role)\.

1. Optionally, modify the **Greengrass prefix**\. This string is prepended to AWS IoT Greengrass objects created on your behalf\. 

1. Select a **IAM role** to assign to the AWS IoT Greengrass group created for the robot\. It grants permissions for AWS IoT Greengrass to access your robot application in Amazon S3 and read update status from AWS RoboMaker\.

1. Optionally, under **Tags**, specify one or more tags for the robot\. Tags are words or phrases that act as metadata for identifying and organizing your AWS resources\. Each tag consists of a key and a value\. You can manage tags for your robot on the **Robot details** page\.

   For more about tagging, see [Tagging Your AWS RoboMaker Resources](tagging-robomaker.md)\.

1. Choose **Create**\. 

1. In the **Download your Core device** page, choose **Download** to download and store your robot's security resources\.

1.  Download AWS IoT Greengrass core software matching the architecture of your physical robot\. To configure and run the AWS IoT Greengrass core software, follow the steps in [Module 1: Environment Setup for Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html)\. Then follow the steps in [Start AWS Greengrass on the Core Device](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-device-start.html)\. 

    Use the following command to unzip your security resources: 

   ```
   $ sudo unzip RobotName-setup.zip -d /greengrass
   ```