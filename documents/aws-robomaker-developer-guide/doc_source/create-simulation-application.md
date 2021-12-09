# Creating a Simulation Application<a name="create-simulation-application"></a>

Create a simulation application to use in simulation jobs\.

**To create a simulation application**  
Follow the steps under one of the following tabs\.

**Note**  
Amazon S3 objects must be located in the same Region as AWS RoboMaker\.

------
#### [ Using the console ]<a name="proc-create-simulation-application-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Development**, and then choose **simulation applications**\.

1. Type a **name** for the application\. Choose a name that helps you identify the simulation\. For example, `Outdoor v2`\.

1. Select the **ROS distribution** used by your robot application\. For more information about ROS, see [www\.ros\.org](http://www.ros.org/)\. 

1. Select the **Simulation software suite** used by your simulation application\. For more information about ROS, see [www\.ros\.org](http://www.ros.org/)\. 

1. Select the **Simulation rendering engine** used by your simulation application\. 

1. Provide the Amazon S3 path to your bundled simulation application file built for the **X86\_64** platform\. 

   \(Optional\) select **Create new S3 folder** to go to the Amazon Simple Storage Service console\. There, you can create and manage buckets\.

1. \(Optional\) Under **Tags**, specify one or more tags for the simulation application\. Tags are words or phrases that act as metadata to identify your AWS resources\. Each tag consists of a key and a value\. You can manage tags for your simulation on the **Simulation application details** page\.

   For more about tagging, see [Tagging Your AWS RoboMaker Resources](tagging-robomaker.md)\. 

1. Choose **Create**\.

------
#### [ Using the AWS CLI ]<a name="proc-create-simulation-application-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based create simulation application on the other tab\.  

```
$ aws robomaker create-simulation-application \
--name HelloWorldSimulationApplication \
--rendering-engine name=OGRE,version=1.x \
--simulation-software-suite name=Gazebo,version=7 \
--robot-software-suite name=ROS,version=Melodic \
--sources architecture=X86_64,s3Bucket=my-bucket-name,s3Key=my-key-name/hello-world-simulation.tar
```

------