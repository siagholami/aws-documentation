# Navigation and Person Recognition<a name="gs-navreco"></a>

In this section, explore a robot that moves between places and recognizes faces in photos\. 

Before you use AWS RoboMaker for the first time, complete the tasks in [Create an Account](gs-set-up.md)\. Then, in the AWS RoboMaker console, launch the Navigation and Person Recognition sample application\.

**Topics**
+ [View Simulated Camera Images](#gs-navreco-camera)
+ [View Recognized People](#gs-navreco-recognized)

## View Simulated Camera Images<a name="gs-navreco-camera"></a>

Use rqt to view images from the robot's camera\.

**To view simulated camera images**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the AWS RoboMaker console, choose **Simulation jobs** on the left and then select the **Navigation and Person Recognition** simulation job\.

1. In the **Simulation details** page, in the **Simulation tools** section, select **rqt**\.

1. In **rqt**, choose **Plugins**, **Visualization**, **Image View**\. 

1. Select **/camera/rgb/image\_raw**\. 

## View Recognized People<a name="gs-navreco-recognized"></a>

Use the terminal and rostopic to view people as the robot explores the virtual space\. 

**To view the logs**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the AWS RoboMaker console, choose **Simulation jobs** on the left and then select the **Navigation and Person Recognition** simulation job\.

1. In the **Simulation details** page, in the **Simulation tools** section, select **terminal**\.

1. In **terminal**, type in the following to set up the ROS environment and run the text command tool\.

   ```
   eval $AWS_ROBOMAKER_ROBOT_APPLICATION_SETUP
   ```

1. Type in the following command\.

   ```
   rostopic echo /rekognized_people
   ```

   When a person is recognized, you see output similar to this:

   ```
   Data: "I see brandon"
   ```