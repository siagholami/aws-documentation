# Simulation Tools<a name="simulation-tools"></a>

AWS RoboMaker provides Gazebo, rqt, rviz and terminal access to interact with running simulation jobs\. 

Common tasks include: 
+ [Pause a Running Simulation](simulation-tools-gazebo.md#simulation-tools-gazebo-pause)
+ [View Node Graph](simulation-tools-rqt.md#simulation-tools-rqt-node-graph)
+ [View Robot Sensor Data](simulation-tools-rviz.md#simulation-tools-rviz-view-data)
+ [Inspect ROS Topics and Messages](simulation-tools-terminal.md#simulation-tools-terminal-debug-topics)

The IAM user or role used to create simulation will automatically have permission to access the simulation tools\. If it is a different user or role, it should have the `robomaker:CreateSimulationJob` privilege\. 

**Topics**
+ [Gazebo](simulation-tools-gazebo.md)
+ [rqt](simulation-tools-rqt.md)
+ [rviz](simulation-tools-rviz.md)
+ [Terminal](simulation-tools-terminal.md)