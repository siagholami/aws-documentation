# Gazebo<a name="simulation-tools-gazebo"></a>

Gazebo lets you build 3D worlds with robots, terrain, and other objects\. It also has has a physics engine for modeling illumination, gravity, and other forces\. Robotics developers use Gazebo to evaluate and test robots in different scenarios, often times more quickly than using physical robots and scenarios\. Gazebo also makes it easier to test other aspects of your robot like error handling, battery life, navigation, and machine learning algorithms\.

To perform the tasks below, Gazebo must be open and connected to a running simulation job\. You can open Gazebo from the **Simulation jobs detail** page of a running simulation job\. 

**Topics**
+ [Pause a Running Simulation](#simulation-tools-gazebo-pause)
+ [View Robot and Objects in the Simulation](#simulation-tools-gazebo-view-objects)
+ [Add and Move Objects in the Simulation](#simulation-tools-gazebo-drop-move)
+ [Apply Forces to Robots and Objects](#simulation-tools-gazebo-use-the-force)

## Pause a Running Simulation<a name="simulation-tools-gazebo-pause"></a>

You can pause a running simulation in Gazebo by selecting the pause icon\. It is located under the rendering of the world on the left\.

When a running simulation is paused, it is paused in other simulation tools like rqt and rviz\. This is useful for investigating simulation data at a moment in time\. For example, using rqt to examine image data from a video camera mounted on a robot\. 

## View Robot and Objects in the Simulation<a name="simulation-tools-gazebo-view-objects"></a>

When you open Gazebo, it presents a view of the simulated world\. The initial perspective is configured by the simulation application developer\. 

1. In **Gazebo**, use the mouse or keyboard to explore the world\. Zoom in, pan out, and move the world around\. 

1. Switch to an orthographic \(or perspective\) camera angle\. In the menu, select **Camera** and then choose **Orthographic** \(or **Perspective**\)\. Reset the camera by choosing **Reset View Angle**\.

1. Select an alternate view to see objects differently\. For example, select **View** and then choose **Wireframe** to see the world rendered as a wireframe\. 

1. It is easy to reset the world to its original configuration\. Select **Edit** and then choose **Reset World**\. Select **Reset Model Poses** to revert changes to model poses\.

## Add and Move Objects in the Simulation<a name="simulation-tools-gazebo-drop-move"></a>

Gazebo includes a collection of models that can be used to create an environment\. Objects can be placed in the environment, moved, and posed to meet the needs of the scenario\. 

1. In **Gazebo**, on the left, select the **Insert** tab\. 

1. In the **Insert** tab, choose **Bookshelf**, then move the cursor to the room\. As you move into the room, you will see the bookshelf model\. Click the left mouse button to place it in the room\. 

1. Move the bookshelf by selecting Translation mode\. Choose the multi\-arrow plus icon in the menu or use the keyboard shortcut **Control\-T**\. Select the bookshelf, then move it to a new location and click the mouse button\.

1. Press **Escape** to exit Translation mode\. Select the bookshelf and then in the **World** tab, expand **Pose** to see different pose settings\. Select a value and then change one increment at a time using the up and down selectors\. Gazebo updates the world after each click\.

## Apply Forces to Robots and Objects<a name="simulation-tools-gazebo-use-the-force"></a>

Things do not always go as planned in the physical world\. A robot might be subjected to unexpected forces and distrurbances during operation\. Objects might tumble, spin, and interact with neighborhing objects or the robot itself\. Using Gazebo, you can create disturbances by applying force and/or torque to models during simulation\. 

This example uses the [Navigation and Person Recognition](gs-navreco.md) sample\. For more information, see [AWS RoboMaker sample applications](https://us-west-2.console.aws.amazon.com/robomaker/home?#sampleSimulationJobs)\. The principles apply to robots and objects that are not static\. Entities marked as static only have collision geometry\.

1. In **Gazebo**, verify the simulation is running\. The simulation must be running to see how an object responds to force and torque\. 

1. In the **World** tab on the left, expand **turtlebot3\_waffle\_pi**\. Right click **wheel\_left\_link** and then choose **Apply Force/Torque**\. 

1. Under **Force**, specify an **X** value of **1000**\. Use the mouse or keyboard to move the underlying view so the robot is in view, then choose **Apply Force**\. The robot will will mostly rotate counter\-clockwise\.

   Select **Clear** and then choose **Apply Force** to remove the force\. 

1. Now apply enough torque on the Y\-axis to tumble the robot upsidedown\. Under **Torque**, specify a **Y** value of **400**\. Make sure the robot is in view, then choose **Apply Torque**\. The robot will flip updsidedown\. Choose **Apply Torque** and it will tumble upright\. 

   Select **Clear** and then choose **Apply Torque** to remove the torque\. Select **Cancel** to close the dialog box\. 

1. No try applying force to an object\. In the **World** tab on the left, right click **ChairA\_01\_001** and then choose **Apply Force**\. Use the mouse or keyboard to make sure the chair is in view\. 

1. Under **Force**, specify an **Z** value of **50000**, then choose **Apply Force**\. The chair will launch off the ground and then return to rest\.

   Select **Clear** and then choose **Apply Force** to remove the force\. Select **Cancel** to close the dialog box\. 