# Creating a Robot Application<a name="create-robot-application"></a>

Create a robot application to use in a simulation job\. When it is ready to deploy to robot hardware, you can add it to a fleet and then deploy to the fleet\.

**To create a robot application**  
Follow the steps under one of the following tabs\.

**Note**  
Amazon S3 objects must be located in the same region as AWS RoboMaker\.

------
#### [ Using the console ]<a name="proc-create-robot-application-con"></a>

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)`\.

1. In the left pane, choose **Development**, and then choose **Robot applications**\.

1. Select **Create robot application**\.

1. In the **Create robot application** page, type a **Name** for the robot application\. Choose a name that helps you identify the robot\.

1. Select the **ROS distribution** used by your robot application\. For more information about the Robot Operating System \(ROS\), see [www\.ros\.org](http://www.ros.org/)\. 

1. Provide the Amazon S3 path to your bundled robot application file\. If this robot application is used only in simulations, specify a bundle built for the **X86\_64** platform\. If you use this robot application in a fleet deployment, specify one or more bundles that represent the architectures of the robots in your fleet\. 

   Optionally, choose **Create new S3 folder** to go to the Amazon Simple Storage Service AWS Management Console to create and manage buckets\.

1. Optionally, under **Tags**, specify one or more tags for the simulation application\. Tags are words or phrases that act as metadata for identifying and organizing your AWS resources\. Each tag consists of a key and a value\. You can manage tags for your simulation application on the **Simulation application details** page\.

   For more about tagging, see [Tagging Your AWS RoboMaker Resources](tagging-robomaker.md)\. 

1. Choose **Create**\.

------
#### [ Using the AWS CLI ]<a name="proc-create-robot-application-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based create robot application on the other tab\.  

```
$ aws robomaker create-robot-application --application my-robot-application --robot-software-suite name=ROS,version=Melodic --sources architecture=X86_64,s3Bucket=my-bucket,s3Key=my-folder/cloud-watch-robot.tar
```

------