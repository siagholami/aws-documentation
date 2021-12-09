# Launching a Sample Application<a name="sample-applications-launching"></a>

The AWS RoboMaker console makes it easy to launch a pre\-built AWS RoboMaker sample application\. You can launch an application using default settings and let AWS RoboMaker manage permissions\. You can also choose a different Gazebo version and use a custom IAM role\. 

**To launch a sample application**  
Follow the steps under one of the following tabs\.

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)`\.

1. In the left pane, choose **Resources**, and then choose **Sample applications**\.

1. Select one of the sample applications\.

1. *Optional: * Select **Additional settings** to view additional configuration options\.

1. Optional: Select a **ROS distribution**\. ROS Melodic is the latest version\. It works with Gazebo 9\. For more information about the Robot Operating System \(ROS\), see [www\.ros\.org](http://www.ros.org/)\.

1. Optional: Select a **Simulation software suite**\. Each sample application is built for Gazebo 7 and Gazebo 9\. Gazebo 9 has additional features for robotics developers\. 

1. Optional: Select an **IAM role**\. This role will be used by AWS RoboMaker to create the sample application environment and launch it\. It will also be used by the sample application to access resources like Amazon Rekognition\. 
**Note**  
If you are a student or educator accessing AWS RoboMaker through the AWS Educate portal, select the **robomaker\_students** IAM role\.

   For more information about the permissions required by the sample applications, see [Configuring Permissions](sample-applications-permissions.md)