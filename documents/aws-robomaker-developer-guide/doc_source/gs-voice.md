# Voice Commands<a name="gs-voice"></a>

In this section, explore a robot that accepts commands through natural language text and voice in a simulated bookstore using Amazon Lex\. The robot supports the commands **move \[direction\] \[rate\]** or **turn \[direction\] \[rate\]**, and **stop**\. Each command is acknowledged and then executed\. 

Before you use AWS RoboMaker for the first time, complete the tasks in [Create an Account](gs-set-up.md)\. Then, in the AWS RoboMaker console, launch the Voice Commands sample application\.

**Topics**
+ [Use Natural Language Text to Move the Robot](#gs-navreco-camera)

## Use Natural Language Text to Move the Robot<a name="gs-navreco-camera"></a>

Use rqt to view images from the robot's camera\.

**To view simulated camera images**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the AWS RoboMaker console, choose **Simulation jobs** on the left and then select the **Voice Commands** simulation job\.

1. In the **Simulation details screen**, in the **Simulation tools** section, select **Gazebo**\. Zoom in on the robot\. There are a series of obstacles positioned in front of it\.

1. In the **Simulation details screen**, in the **Simulation tools** section, select **terminal**\.

1. In **terminal**, type in the following commands to set up the robot operating system \(ROS\) environment and run the text command tool\.

   ```
   eval $AWS_ROBOMAKER_ROBOT_APPLICATION_SETUP
   rosrun voice_interaction_robot text_input.py
   ```

1. Type in the following command to see the robot hit obstacles\. The robot is moving forward at 0\.4 meters per second\.

   ```
   move forward 0.4
   ```

   The robot tries to move forward until it is told to stop\. The faster the robot moves, the more the obstacles are displaced\. Reasonable speeds are 0\.3–0\.5 meters per second\.

   You can also move the robot backward\.

   ```
   move backward 0.4
   ```

1. The robot can be commanded to turn clockwise or counterclockwise\. For example:

   ```
   turn clockwise .5
   turn counterclockwise .65
   ```

   The turn rate is radians per second\. Values between 0\.4 and 0\.78 are reasonable for the robot\.

1. Type **stop** to stop the robot\.