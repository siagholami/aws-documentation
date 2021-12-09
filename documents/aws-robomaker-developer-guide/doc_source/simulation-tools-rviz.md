# rviz<a name="simulation-tools-rviz"></a>

rviz is a 3d visualization tool for ROS applications\. It provides a view of your robot model, capture sensor information from robot sensors, and replay captured data\. It can display data from camera, lasers, from 3D and 2D devices including pictures and point clouds\. 

To perform the tasks below, rviz must be open and connected to a running simulation job\. You can open rviz from the **Simulation jobs detail** page of a running simulation job\. 

**Topics**
+ [View Robot Sensor Data](#simulation-tools-rviz-view-data)

## View Robot Sensor Data<a name="simulation-tools-rviz-view-data"></a>

Robots typically have sensors to gather data from the world\. For example, a robot might use a sensor to detect a collision with an object or a laser scanner to learn about objects in the surrounding environment\. 

1. In **rviz**, select **File** and then choose **Open Config**\. In the dialog box, navigate to `robomaker/workspace/bundle-store/GUID/opt/ros/$ROS_DISTRO/share/turtlebot3_description/rviz`\. Select `model.rviz` and then choose **Open**\. It does not matter which `GUID` directory you choose\. 

   If prompted about unsaved changed, select **Discard**\. 

1. In the display, laser scan data appears as red dots\. Walls and other objects can be identified by lines of red dots centered on the robot\. The laser scan will only be visible if there are objects in the virtual world\. 

1. Open Gazebo\. Compare the location and orientation of the robot in Gazebo to what the laser scan detects\. 

1. In **Gazebo**, drop a sphere next to the robot\. In **rviz**, the laser scan detects part of the object\.