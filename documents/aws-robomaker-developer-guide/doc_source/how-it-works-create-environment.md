# Create a ROS Development Environment<a name="how-it-works-create-environment"></a>

Before you create a robot application, you need a properly configured development environment\. Robot development with AWS RoboMaker depends on a number of open source packages\. 


****  

| Package | Version | Description | 
| --- | --- | --- | 
|  Robot Operating System \(ROS\)  |  [Kinetic](http://wiki.ros.org/kinetic) [Melodic](http://wiki.ros.org/melodic)  |  Libraries and tools to help developers create robot applications\.  | 
|  Robot Operating System 2 \(ROS2\)  |  [Dashing](http://docs.ros2.org/dashing)  |  A newer version of ROS still under development\. For more information about using ROS 2 with AWS RoboMaker, see [ROS 2 Dashing \(Beta\)](robomaker-ros2-beta.md)\.  | 
|  Colcon  |  [Latest](https://github.com/colcon/colcon-core)  |  A command line tool for bundling ROS robot and simulation applications\.  | 
|  Gazebo  |  [7](http://gazebosim.org/blog/gazebo7) [9](http://gazebosim.org/blog/gazebo9)  |  Tool for simulating robots in complex environments\.  | 
|  rviz  |  [Melodic](http://wiki.ros.org/rviz) [Dashing](https://index.ros.org/p/rviz2/github-ros2-rviz/#dashing)  |  Tool for visualizing sensor data and state information from ROS in 3D\.  | 
|  rqt  |  [Melodic](http://wiki.ros.org/rqt) [Dashing](https://index.ros.org/p/rqt/github-ros-visualization-rqt/\#dashing)  |  Framework and plugins based on Qt for ROS GUI development\.  | 

You can create your own development environment or update an existing development environment to support AWS RoboMaker\. Most developers use Ubuntu or other supported Linux variants\. Other operating systems might be compatible\. 

AWS RoboMaker provides a quick and easy way to create a development environment that is already configured for robot development\.