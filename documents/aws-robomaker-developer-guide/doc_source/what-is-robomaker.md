# What Is AWS RoboMaker?<a name="what-is-robomaker"></a>

AWS RoboMaker is a service that makes it easy to create robotics applications at scale\. AWS RoboMaker extends the Robot Operating System \(ROS\) framework with cloud services\. This includes AWS machine learning services\. It includes monitoring services\. It even includes analytics services\. These combine to enable a robot to do several things on its own\. Stream data, navigate, communicate, comprehend, and learn\. AWS RoboMaker provides a robotics application development environment\. It provides a robotics simulation service, which speeds application testing\. It provides a fleet management service so you can deploy and manage applications remotely\.

## Are You a First\-time User of AWS RoboMaker?<a name="first-time-user"></a>

If you are a first\-time user of AWS RoboMaker, do the following\. 

1. **Read [How It Works](how-it-works.md) ** – An overview of AWS RoboMaker\. Learn the key concepts and components involved in building robot applications and simulations\. Read this topic in the order presented\. 

1. **Read [Getting Started with AWS RoboMaker](getting-started.md)** – A tutorial to help you build your first robot application and simulation\. Explains how to run a simulation job\. Use the sample code provided by AWS RoboMaker\.

1. Depending on your needs, explore the following topics\.
   + Learn about the Robot Operating System \(ROS\)\. In AWS RoboMaker, you build applications and simulations based on ROS\. For more information, see [http://wiki\.ros\.org/ROS/Tutorials](http://wiki.ros.org/ROS/Tutorials)\.
   + Learn about Gazebo, a simulator to test robots\. Gazebo helps you test algorithms\. It helps you design robots and train artificial intelligence\. For more information, see [http://gazebosim\.org/tutorials](http://gazebosim.org/tutorials)\. Select version 9\.

## Supported Software and Versions<a name="supported-versions"></a>

AWS RoboMaker supports the following programs, tools, and libraries\.


****  

| Name | Versions Supported | Description | 
| --- | --- | --- | 
| Robot Operating System \(ROS\) |  [Kinetic](http://wiki.ros.org/kinetic) \(end of life April 2021\) [Melodic](http://wiki.ros.org/melodic) \(end of life May 2023\)  | Libraries and tools to help you create robot applications\. | 
| Robot Operating System 2 \(ROS 2\) |  [Dashing](http://docs.ros2.org/dashing) \(in AWS RoboMaker beta\)  | A newer version of ROS still under development\. | 
| Colcon | [Latest](https://github.com/colcon/colcon-core) | Command line tool to bundle ROS robot and simulation applications\. | 
| Gazebo | [7](http://gazebosim.org/blog/gazebo7), [9](http://gazebosim.org/blog/gazebo9) | Tool to simulate robots in an environment\. | 
| rviz | [ROS rviz](http://wiki.ros.org/rviz) [ROS2 rviz2](https://github.com/ros2/rviz)  | Tool to visualize sensor data and state information from ROS in 3D\. | 
| rqt | [latest](http://wiki.ros.org/rqt) | Framework and plugins based on Qt for ROS GUI development\. | 

ROS supports the Python versions listed here\.


****  

| Name | Version\(s\) Supported | Ununtu Version\(s\) Supported | 
| --- | --- | --- | 
| ROS Kinetic | Python 2 | Ubuntu Xenial | 
| ROS Melodic | Python 2 | Ubuntu Bionic | 
| ROS2 Dashing | Python 3 | Ubuntu Bionic | 

The following table shows which ROS versions are supported for different AWS RoboMaker features\.


****  

| AWS RoboMaker Feature | ROS version\(s\) Supported | 
| --- | --- | 
| Cloud Extensions |  Melodic, Kinetic, Dashing  | 
| Development Environment \(Create\) |  Melodic, Kinetic, Dashing  | 
| Simulation Job |  Melodic, Kinetic, Dashing  | 
| Fleet Management |  Melodic, Kinetic, Dashing  | 

AWS RoboMaker simulation jobs support the combinations of ROS distribution and Gazebo listed here\.
+ Kinetic and Gazebo 7
+ Kinetic and Gazebo 9
+ Melodic and Gazebo 9
+ Dashing and Gazebo 9

Gazebo supports the components listed here\.


****  

| Component | Version\(s\) Supported | 
| --- | --- | 
| Physics engine |  [ODE](http://opende.sourceforge.net/)  | 
| Rendering engine |  [OGRE](https://www.ogre3d.org/)  | 