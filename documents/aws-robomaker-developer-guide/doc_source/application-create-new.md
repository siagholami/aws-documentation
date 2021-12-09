# Creating a New Robotic Application<a name="application-create-new"></a>

This section describes how to create a robotic application\. It uses a directory structure that separates the robot application and the simulation application\. This makes it easier to use in AWS RoboMaker simulations and other stages of robotics development\. 

Robotics applications usually include both a robot application and a simulation application\. A robot application is deployed to the physical robot\. Simulation applications are used to model aspects of the physical world\. Using an AWS RoboMaker simulation job, robot applications can run inside of simulation applications and data can be collected and visualized\.

AWS RoboMaker robotics applications usually have the following directory structure and files:

```
MyApplication
├── robot_ws                               # workspace for the robot system
│   └── src
│       └── robot_app                      # ROS package for the robot application
│           ├── CMakeLists.txt             # build config 
│           ├── launch
│           │   └── rotate.launch          # robot entrypoint, specifies running system 
│           ├── package.xml                # ROS package config
│           ├── scripts
│           │   └── rotate.py              # custom ROS node, loaded at launch
│           ├── setup.py                   # allow ROS to find your python code
│           └── src
│               └── robot_app
│                   └── __init__.py        # python module for any .py code
└── simulation_ws                          # workspace for the simulation
    └── src
        └── simulation_app                 # ROS package for the simulation application
            ├── CMakeLists.txt             # build config
            ├── launch
            │   ├── example.launch         # simulation entrypoint, specifies world, etc
            │   └── spawn_turtlebot.launch # launch file for spawning the simulated robot
            ├── package.xml                # ROS package config
            └── worlds
                └── example.world          # world description
```

**Topics**
+ [Prerequisites](#application-create-prereq)
+ [Create the Robot Application Workspace](#application-create-robot-ws)
+ [Create the Simulation Application Workspace](#application-create-simulation-ws)
+ [Build the Robot and Simulation Application Bundles](#application-create-build-robot-and-simulation)

## Prerequisites<a name="application-create-prereq"></a>

You need to have a development environment configured for robotics development using AWS RoboMaker\. Your development environment must have the following:
+ Robot Operating System \(ROS\) [Kinetic](http://wiki.ros.org/kinetic) or [Melodic](http://wiki.ros.org/melodic)
+ [Colcon](https://github.com/colcon/colcon-core)

To create a preconfigured robotics development environment in AWS Cloud9, see [Creating a Development Environment](cloud9-create-ide.md)\.

## Create the Robot Application Workspace<a name="application-create-robot-ws"></a>

The robot application workspace contains custom ROS nodes and other assets needed by your robot application\.

**To create the robot application workspace**

1. Open the command prompt\.

1. Create the project directory, then move to the new directory\.

   ```
   $ mkdir MyApplication
   $ cd MyApplication
   ```

1. Create directories for ROS launch files, ROS nodes, deployment scripts, and source folders\.

   ```
   $ mkdir -p robot_ws/src/robot_app
   $ cd robot_ws/src/robot_app 
   $ mkdir -p launch scripts src/robot_app
   ```

1. Create an empty `__init__.py` file for using Python with ROS\.

   ```
   $ touch src/robot_app/__init__.py
   ```

1. Copy the following Python script into a file named `rotate.py` and then save it to the `scripts` directory\. This sample node periodically rotates the robot\. Your application will likely have more than one node and more sophisticated code\.

   ```
   #!/usr/bin/env python
   
   import rospy
   from geometry_msgs.msg import Twist
   
   class Rotator():
       def __init__(self):
           self._cmd_pub = rospy.Publisher('/cmd_vel', Twist, queue_size=1)
   
       def rotate_forever(self):
           self.twist = Twist()
   
           r = rospy.Rate(10)
           while not rospy.is_shutdown():
               self.twist.angular.z = 0.1
               self._cmd_pub.publish(self.twist)
               rospy.loginfo("Rotating robot: %s", self.twist)
               r.sleep()
   
   
   def main():
       rospy.init_node('rotate')
       try:
           rotator = Rotator()
           rotator.rotate_forever()
       except rospy.ROSInterruptException:
           pass
   
   if __name__ == '__main__':
       main()
   ```

1. Make the Python script executable so it can be found by roslaunch\. roslaunch is used to start the nodes in your application\.

   ```
   $ chmod +x scripts/rotate.py
   ```

1. Copy the following XML into a file named `rotate.launch` and then save it to the `launch` directory\. The launch file is configured to start the rotate node\.

   ```
   <launch>
     <!-- 
          Using simulation time means nodes initialized after this
          will not use the system clock for its ROS clock and 
          instead wait for simulation ticks. 
   
          See http://wiki.ros.org/Clock
   
          Note: set to false for deploying to a real robot.
     -->
     <arg name="use_sim_time" default="true"/>
     <param name="use_sim_time" value="$(arg use_sim_time)"/>
   
     <!-- Rotate the robot on launch -->
     <node pkg="robot_app" type="rotate.py" name="rotate" output="screen"/>
   </launch>
   ```

1. Copy the following into a file named `CMakeLists.txt` and save it to the `robot_app` directory\. For more information on creating make files for ROS, see [CMakeLists\.txt](http://wiki.ros.org/catkin/CMakeLists.txt)\.

   ```
   ################################################################################
   # Set minimum required version of cmake, project name and compile options
   ################################################################################
   cmake_minimum_required(VERSION 2.8.3)
   
   # Mention your package name 
   project(robot_app)
   
   ################################################################################
   # Find catkin packages and libraries for catkin and system dependencies
   ################################################################################
   find_package(catkin REQUIRED COMPONENTS
     rospy
     std_msgs
   )
   
   ################################################################################
   # Setup for python modules and scripts
   ################################################################################
   catkin_python_setup()
   
   ################################################################################
   # Declare ROS messages, services and actions
   ################################################################################
   
   ################################################################################
   # Declare ROS dynamic reconfigure parameters
   ################################################################################
   
   ################################################################################
   # Declare catkin specific configuration to be passed to dependent projects
   ################################################################################
   catkin_package(
     CATKIN_DEPENDS
       rospy
       std_msgs
   )
   
   ################################################################################
   # Build
   ################################################################################
   include_directories(
     include
     ${catkin_INCLUDE_DIRS}
   )
   
   ################################################################################
   # Install
   ################################################################################
   # Add your custom nodes here. 
   catkin_install_python(PROGRAMS 
     scripts/rotate.py
     DESTINATION ${CATKIN_PACKAGE_BIN_DESTINATION}
   )
   
   install(DIRECTORY launch
       DESTINATION ${CATKIN_PACKAGE_SHARE_DESTINATION}
   )
   
   ################################################################################
   # Test
   ################################################################################
   ```

1. Copy the following XML into a file named `package.xml` and then save it to the `robot_app` directory\. It includes all robot application dependencies\.

   ```
   <?xml version="1.0"?>
   <package format="2">
     <name>robot_app</name>
     <version>1.0.0</version>
     <description>
       A custom AWS RoboMaker robot package with a rotating Turtlebot3
     </description>
     <license>MIT</license>
     <author email="aws-robomaker@amazon.com">AWS RoboMaker</author>
     <maintainer email="aws-robomaker@amazon.com">AWS RoboMaker</maintainer>
     <buildtool_depend>catkin</buildtool_depend>
     <depend>rospy</depend>
     <depend>std_msgs</depend>
     <depend>turtlebot3_msgs</depend>
     <exec_depend>message_runtime</exec_depend>
     <exec_depend>turtlebot3_bringup</exec_depend>
   </package>
   ```

1. Create a `setup.py` file and then save it to the `robot_app` directory\. It helps ROS find your Python nodes\. To learn more abot ROS Python makefiles, see [Writing a ROS Python Makefile](http://wiki.ros.org/rospy_tutorials/Tutorials/Makefile)\.

   ```
   ## ! DO NOT MANUALLY INVOKE THIS setup.py, USE CATKIN INSTEAD
   ## See http://ros.org/doc/api/catkin/html/user_guide/setup_dot_py.html
   
   from distutils.core import setup
   from catkin_pkg.python_setup import generate_distutils_setup
   
   # fetch values from package.xml
   setup_args = generate_distutils_setup(
       packages=['robot_app'],
       package_dir={'': 'src'}
   )
   
   setup(**setup_args)
   ```

## Create the Simulation Application Workspace<a name="application-create-simulation-ws"></a>

The simulation application workspace contains models for the robot and terrain\. It also includes custom ROS nodes and other assets needed by your simulation application\.

1. Open the command prompt and move to the project directory, then run the following commands to create simulation application directories\.

   ```
   $ mkdir -p simulation_ws/src/simulation_app
   $ cd simulation_ws/src/simulation_app
   $ mkdir launch worlds
   ```

1. Copy the following XML into a file named `example.launch` and then save it to the `launch` directory\. It loads the simulated world with a Turtlebot\.

   ```
   <launch>
     <!-- Always set GUI to false for RoboMaker Simulation
          Use gui:=true on roslaunch command-line to run with a gui.
     -->
     <arg name="gui" default="false"/>
   
     <include file="$(find gazebo_ros)/launch/empty_world.launch">
       <arg name="world_name" value="$(find simulation_app)/worlds/example.world"/>
       <arg name="paused" value="false"/>
       <arg name="use_sim_time" value="true"/>
       <arg name="gui" value="$(arg gui)"/>
       <arg name="headless" value="false"/>
       <arg name="debug" value="false"/>
       <arg name="verbose" value="true"/>
     </include>
   
     <!-- Spawn Robot 
          This must be the same robot type as the robot application
     -->
     <include file="$(find simulation_app)/launch/spawn_turtlebot.launch">
         <!-- Override arg parameters here e.g,
             <arg name="x_pos" default="10.0"/>
             <arg name="y_pos" default="5.0"/>
        -->
     </include>
   </launch>
   ```

1. Copy the following XML into a file named `spawn_turtlebot.launch` and then save it to the `launch` directory\. It spawns a Turtlebot robot into the simulation\.

   ```
   <launch>
     <!-- Optional environment variable, default is "waffle_pi". Note that "burger" does not have a camera -->
     <arg name="model" default="$(optenv TURTLEBOT3_MODEL waffle_pi)" doc="model type [burger, waffle, waffle_pi]"/>
   
     <!-- You may override arg parmaters when including this launch file -->
     <arg name="x_pos" default="0.0"/>
     <arg name="y_pos" default="0.0"/>
     <arg name="z_pos" default="0.0"/>
     <arg name="roll" default="0.0"/>
     <arg name="pitch" default="0.0"/>
     <arg name="yaw" default="0.0"/>
     
     <!-- Spawn the robot into Gazebo with the turtlebot description -->
     <param name="robot_description" command="$(find xacro)/xacro --inorder $(find turtlebot3_description)/urdf/turtlebot3_$(arg model).urdf.xacro" />
     <node pkg="gazebo_ros" type="spawn_model" name="spawn_urdf" 
       args="-urdf -param robot_description -model turtlebot3_$(arg model) 
             -x $(arg x_pos) -y $(arg y_pos) -z $(arg z_pos) 
             -R $(arg roll) -P $(arg pitch) -Y $(arg yaw)"/>
   
     <!-- 
          Publish robot and joint states. This allows rviz to display robot data, and in 
          the robot's coordinate frame. These nodes could go into the robot application 
          .launch files instead.
       -->
     <node pkg="robot_state_publisher" type="robot_state_publisher" name="robot_state_publisher" output="screen"/>
     <node name="joint_state_publisher" pkg="joint_state_publisher" type="joint_state_publisher" />
   </launch>
   ```

1. Copy the following XML into a file named `example.world` and then save it to the `worlds` directory\. The world file defines the static and dynamic objects in a simulated environment\. For more information about building worlds for Gazebo, see [Building a World](http://gazebosim.org/tutorials?tut=build_world)\.

   ```
   <?xml version="1.0" encoding="utf-8"?>
   <sdf version="1.4">
     <world name="default">
       <gui>
         <camera name="default_camera">
           <pose>0.8 -0.75 0.35 0 0.25 2.35</pose>
         </camera>
       </gui>
   
       <!-- A global light source -->
       <include>
         <uri>model://sun</uri>
       </include>
   
       <!-- A ground plane -->
       <include>
         <uri>model://ground_plane</uri>
       </include>
   
       <physics type="ode">
         <real_time_update_rate>1000.0</real_time_update_rate>
         <max_step_size>0.001</max_step_size>
         <real_time_factor>1</real_time_factor>
         <ode>
           <solver>
             <type>quick</type>
             <iters>150</iters>
             <precon_iters>0</precon_iters>
             <sor>1.400000</sor>
             <use_dynamic_moi_rescaling>1</use_dynamic_moi_rescaling>
           </solver>
           <constraints>
             <cfm>0.00001</cfm>
             <erp>0.2</erp>
             <contact_max_correcting_vel>2000.000000</contact_max_correcting_vel>
             <contact_surface_layer>0.01000</contact_surface_layer>
           </constraints>
         </ode>
       </physics>
       
       <scene>
           <ambient>0.4 0.4 0.4 1</ambient>
           <background>0.7 0.7 0.7 1</background>
           <shadows>true</shadows>
       </scene>
       
     </world>
   </sdf>
   ```

1. Copy the following text into a file named `CMakeLists.txt` and then save it to the `simulation_app` directory\. 

   ```
   cmake_minimum_required(VERSION 2.8.3)
   
   project(simulation_app)
   
   find_package(catkin REQUIRED COMPONENTS
     gazebo_ros
   )
   
   catkin_package(DEPENDS gazebo_ros)
   
   install(DIRECTORY launch worlds
     DESTINATION ${CATKIN_PACKAGE_SHARE_DESTINATION}
   )
   ```

1. Copy the following XML into a file named `package.xml` and then save it to the `simulation_app` directory\. It includes all simulation application dependencies\.

   ```
   <?xml version="1.0"?>
   <package format="2">
     <name>simulation_app</name>
     <version>1.0.0</version>
     <description>
       A custom AWS RoboMaker simulation package with a TurtleBot3 in an empty Gazebo world.
     </description>
     <license>MIT</license>
     <author email="aws-robomaker@amazon.com">AWS RoboMaker</author>
     <maintainer email="aws-robomaker@amazon.com">AWS RoboMaker</maintainer>
     <buildtool_depend>catkin</buildtool_depend>
     <depend>gazebo_ros</depend>
     <depend>gazebo_plugins</depend>
     <depend>turtlebot3_description</depend>
     <depend>turtlebot3_gazebo</depend>
     <depend>turtlebot3_simulations</depend>
     <exec_depend>gazebo</exec_depend>
   </package>
   ```

## Build the Robot and Simulation Application Bundles<a name="application-create-build-robot-and-simulation"></a>

AWS RoboMaker works with robotics applications built and bundled with colcon\. For more information, see [Building and Bundling Robotic Applications with Colcon](application-build-bundle.md)\.

1. Open the command line and move to the `robot_ws` directory, then run the following commands\.

   ```
   $ rosdep update
   $ rosdep install --from-paths src --ignore-src -r -y
   $ colcon build
   $ colcon bundle
   ```

   If you are launching from the command\-line, run the following commands:

   ```
   $ source install/setup.sh
   $ roslaunch robot_app rotate.launch
   ```

   Use the following to launch the robot application in AWS RoboMaker:

   ```
   roslaunch robot_app rotate.launch
   ```

1. Move to the `simulation_ws` directory, then run the following commands\.

   ```
   $ rosdep update
   $ rosdep install --from-paths src --ignore-src -r -y
   $ colcon build
   $ colcon bundle
   ```

   If you are launching from the command\-line, run the following commands:

   ```
   $ source install/setup.sh
   $ roslaunch simulation_app example.launch
   ```

   Use the following to launch the simulation application in AWS RoboMaker:

   ```
   roslaunch simulation_app example.launch
   ```