# Creating a Simulation Job<a name="create-simulation-job"></a>

Create a simulation job when you want to run your robot application in a virtual world using Gazebo or using previously recorded ROS messages stored in ROS bags\. You select the software suite name when you specify the simulation application\. If you choose **Gazebo**, your robot application will interact with the objects, terrain, and other physical aspects modelled in the simulation application\. If you choose **RosbagPlay**, your robot application will consume ROS messages published from the ROS bags you provide as data sources\. 

For more information about configuring your ROS launch file to play back ROS bag messages, see [Using ROS Bags for Play Back](simulation-job-playback-rosbags.md)\.

**Note**  
After 90 days, simulation jobs expire and will be deleted\. They will no longer be accessible\.

**Topics**
+ [Create a Simulation Job using Gazebo](#create-simulation-job-gazebo)
+ [Create a Simulation Job using ROS bags](#create-simulation-job-rosbag)

## Create a Simulation Job using Gazebo<a name="create-simulation-job-gazebo"></a>

You will create a simulation job using Gazebo when you want to run your robot application in the simulation you created\. Once running, you can interact with the simulation\. For example, you can use rviz to see images from visual sensors on your robot\. 

**To create a simulation job using Gazebo**  
Follow the steps under one of the following tabs:

**Note**  
If you are using an existing Amazon S3 bucket or creating a new bucket, it must be located in the same region as AWS RoboMaker\.

------
#### [ Using the console ]<a name="proc-create-simulation-job-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, and then choose **Simulation jobs**\.

1. Choose **Create simulation job**\.

1. On the **Simulation configuration** page, select a **simulation job duration**\. Select any value between 5 minutes and 14 days\.
**Important**  
To learn more about how you are charged for AWS RoboMaker see [AWS RoboMaker Pricing](https://aws.amazon.com/robomaker/pricing/)\. 

1. Select a **Failure behavior**\. Choose **fail** to terminate the host instance if the simulation job fails\. Choose **continue** to keep the host instance so you can connect and investigate\.

   If you specify an optional S3 folder below, it will contain simulation data\. It is available independent of the selected failure behavior\. 

1. For **IAM Role**, select a role or select **Create new role** to create one\. AWS RoboMaker will use this role to access resources on your behalf\. It is also used by your application to access AWS resources like Amazon Rekognition or Amazon Lex\.

1. *Optional:* In **Output destination**, type in a Amazon S3 folder name where simulation job output will be stored\. Optionally, select **Create new S3 folder** to create a new Amazon S3 folder\.

1. *Optional:* In **Networking**, if your robot application or simulation application accesses resources on an Amazon VPC, select the **VPC**, subnets and security groups\. If you want to access the simulation job from outside of the VPC, select **Assign public IP**\. 

1. *Optional:* To connect to your simulation application or robot application remotely, select **Enable connectivity to simulation**, then specify port mappings for the robot application and simulation application\. 
**Warning**  
You are responsible for configuring a secure remote connection to the simulation job\. We recommend you implement a strong authentication method and encryption in transit for the ports you are opening\. For more information about remote connectivity, see [Connecting to a Simulation Job](simulation-job-remote-connectivity.md)\.

1. Optionally, under **Tags**, specify one or more tags for the simulation job\. Tags are words or phrases that act as metadata for identifying and organizing your AWS resources\. Each tag consists of a key and a value\. You can manage tags for your simulation job on the **Simulation Job details** page\.

   For more about tagging, see [Using Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html#allocation-what) in the *AWS Billing and Cost Management User Guide*\. 

1. Choose **Next**\.

1. On the **Specify robot application** page, under **Robot application**, select **Create new application**\. Optionally, you can select **Choose existing application** to use a robot application that you have already created\.

1. Type a **name** for the robot application\.

1. Under **Sources**, specify the Amazon S3 location for the **X86\_64** robot application source\. AWS RoboMaker simulation jobs require an **X86\_64** source to run the simulation\. 

   Optionally, if you plan on deploying the robot application to robots in a fleet, you can provide **ARMHF** and **ARM64** robot application source files\. You can also update the robot application to include additional source files\. For more information, see [Updating a Robot Application](update-robot-application.md)\.

1. In **Robot application configuration**, provide the roslaunch **Launch package name** for your robot application\. 

1. Specify the roslaunch **Launch file**\. A launch file contains configuration information about which nodes to start up as well as other initialization parameters for roslaunch\.

   To learn more about roslaunch, see [roslaunch](http://wiki.ros.org/roslaunch)\.

1. *Optional:* If your robot application uses environment variables, specify the **Name** and **Value** pairs\. Environment variable names must start with A\-Z or underscore and consist of A\-Z, 0\-9 and underscore\. Names beginning with “AWS” are reserved\.

   Select **Add environment variable** to add additional variables\. 

   You can read environment variables in a launch file using roslaunch [substituion args](http://wiki.ros.org/roslaunch/XML#substitution_args)\.

1. Choose **Next**\. 

1. On the **Specify simulation application** page, select **Create new application**\. Optionally, you can select **Choose existing application** use a simulation application that you have already created\. 

1. Type a **name** for the simulation application\.

1. Select the **Simulation software suite** and **Simulation rendering version** used by your simulation application\. 

1. Under **Sources**, specify the Amazon S3 location for the **X86\_64** simulation application source\. AWS RoboMaker simulation jobs require an **X86\_64** source to run the simulation\. 

1. In **Simulation application configuration**, provide the roslaunch **Launch package name** and the roslaunch **Launch file** for your simulation application\. 

1. *Optional:* If your simulation application uses environment variables, specify the **Name** and **Value** pairs\. Select **Add environment variable** to add additional variables\.

1. Choose **Next**\. 

1. Select **Create** to create the simulation job\. 

------
#### [ Using the AWS CLI ]<a name="proc-create-simulation-job-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based simulation job creation on the other tab\.  

```
$ aws robomaker create-simulation-job --max-job-duration-in-seconds 3600 --iam-role arn:aws:iam::111111111111:role/MyRole --robot-applications application=arn:aws:robomaker:us-west-2:111111111111:robot-application/MyRobotApplication/1551203485821,launchConfig="{packageName=hello_world_robot,launchFile=rotate.launch}" --simulation-applications application=arn:aws:robomaker:us-west-2:111111111111:simulation-application/MySimulationApplication/1551203427605,launchConfig="{packageName=hello_world_simulation,launchFile=empty_world.launch}" --tags Region=North
```

------

## Create a Simulation Job using ROS bags<a name="create-simulation-job-rosbag"></a>

You must configure your ROS launch file to play back the ROS bag files you use as data sources\. For more information about configuring your ROS launch file to play back ROS bag messages, see [Using ROS Bags for Play Back](simulation-job-playback-rosbags.md)\.

**To create a simulation job using RosbagPlay**  
Follow the steps below:

**Note**  
If you are using an existing Amazon S3 bucket or creating a new bucket, it must be located in the same region as AWS RoboMaker\.<a name="proc-create-simulation-job-rosbag-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, and then choose **Simulation jobs**\.

1. Choose **Create simulation job**\.

1. On the **Simulation configuration** page, select a **simulation job duration**\. Select any value between 5 minutes and 14 days\.
**Important**  
To learn more about how you are charged for AWS RoboMaker see [AWS RoboMaker Pricing](https://aws.amazon.com/robomaker/pricing/)\. 

1. Select a **Failure behavior**\. Choose **fail** to terminate the host instance if the simulation job fails\. Choose **continue** to keep the host instance so you can connect and investigate\.

   If you specify an optional S3 folder below, it will contain simulation data\. It is available independent of the selected failure behavior\. 

1. For **IAM Role**, select a role or select **Create new role** to create one\. AWS RoboMaker will use this role to access resources on your behalf\. It is also used by your application to access AWS resources like Amazon Rekognition or Amazon Lex\.

1. *Optional:* In **Output destination**, type in a Amazon S3 folder name where simulation job output will be stored\. Optionally, select **Create new S3 folder** to create a new Amazon S3 folder\.

1. *Optional:* In **Networking**, if your robot application or simulation application access resources on an Amazon VPC, select the **VPC**, subnets and security groups\. If you want to access the simulation job from outside of the VPC, select **Assign public IP**\. 

1. Optionally, under **Tags**, specify one or more tags for the simulation job\. Tags are words or phrases that act as metadata for identifying and organizing your AWS resources\. Each tag consists of a key and a value\. You can manage tags for your simulation job on the **Simulation Job details** page\.

   For more about tagging, see [Tagging Your AWS RoboMaker Resources](tagging-robomaker.md)\. 

1. Choose **Next**\.

1. On the **Specify robot application** page, under **Robot application**, select **Create new application**\. Optionally, you can select **Choose existing application** to use a robot application that you have already created\.

1. Type a **name** for the robot application\.

1. Under **Sources**, specify the Amazon S3 location for the **X86\_64** robot application source\. AWS RoboMaker simulation jobs require an **X86\_64** source to run the simulation\. 

   Optionally, if you plan on deploying the robot application to robots in a fleet, you can provide **ARMHF** and **ARM64** robot application source files\. You can also update the robot application to include additional source files\. For more information, see [Updating a Robot Application](update-robot-application.md)\.

1. In **Robot application configuration**, provide the roslaunch **Launch package name** for your robot application\. 

1. Specify the roslaunch **Launch file**\. A launch file contains configuration information about which nodes to start up as well as other initialization parameters for roslaunch\.

   To learn more about roslaunch, see [roslaunch](http://wiki.ros.org/roslaunch)\.

1. *Optional:* If your robot application uses environment variables, specify the **Name** and **Value** pairs\. Environment variable names must start with A\-Z or underscore and consist of A\-Z, 0\-9 and underscore\. Names beginning with “AWS” are reserved\.

   Select **Add environment variable** to add additional variables\. 

   You can read environment variables in a launch file using roslaunch [substituion args](http://wiki.ros.org/roslaunch/XML#substitution_args)\.

1. Choose **Next**\. 

1. On the **Specify simulation application** page, select **Create new application**\. Optionally, you can select **Choose existing application** use a simulation application that you have already created\. 

1. Type a **name** for the simulation application\.

1. For **Software suite name**, select **RosbagPlay**\. `Kinetic` will automatically be selected as the **Software suite version**\.

1. Select the **Browse S3**, and then specify the path to your simulation application\. 

1. In **Simulation application configuration**, provide the roslaunch **Launch package name** and the roslaunch **Launch file** for your simulation application\. 

1. *Optional:* If your simulation application uses environment variables, specify the **Name** and **Value** pairs\. Select **Add environment variable** to add additional variables\.

1. In **Data source configuration**, provide a **ROS bag group name**, then choose **Browse S3** to select **ROS bag files**\. The files should contain ROS messages in the same format used by `rosbag record`\. Choose **Add group** to add additional groups of data files\. 
**Note**  
You can select up 100 files with a combined size less than 25 GB across all groups\. Performance may be impacted as the combined size of the data files increase\.

1. Choose **Next**\. 

1. Select **Create** to create the simulation job\. 