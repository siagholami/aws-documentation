# Step 2: Run the Hello World Sample Application<a name="gs-build-rundemo"></a>

Before you begin working with a robot application and simulation application code, run the Hello World demo application in the AWS RoboMaker console\. This sets up the AWS resources the application needs, including the appropriate IAM roles and Amazon S3 bucket for loading applications and writing simulation output\.

**To run the Hello World demo application**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the AWS RoboMaker console, expand **Resources** on the left and then select **Sample applications**\.

1. In the **Try AWS RoboMaker sample applications** page, select **Hello World\!** and then select **Launch**\. This opens the **simulation job detail** page while AWS RoboMaker launches the sample simulation\.

   The sample application will use ROS Melodic and Gazebo 9 by default\. 

1. On the **simulation job detail** page, when status becomes **running**, select **Gazebo**\.

1. In the **AWS RoboMaker gzclient** window, use the mouse or keyboard to zoom in on the TurtleBot\. For more information, see [Gazebo Keyboard Shortcuts](http://gazebosim.org/hotkeys)\.

   It is spinning clockwise\. Gazebo is fully functional, so you can try out other features\. For example, if you want more light on the robot, choose the **sun** \(point light\) icon\. Then move the pointer around the robot to illuminate it\.

1. When you are done, close Gazebo by closing the browser window\.

The Hello World simulation runs for 1 hour\. In later steps, you have an opportunity to restart the simulation\. If you do, the simulation job timer is reset to zero and the simulation job will run another 1 hour\. 