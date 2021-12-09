# ROS 2 Dashing \(Beta\)<a name="robomaker-ros2-beta"></a>

AWS RoboMaker now supports Robot Operating System 2 \(ROS2\) in beta release\. ROS2 is built on top of Data Distribution Standard \(DDS\), an industry data connectivity standard that provides discovery, serialization, and transportation\. ROS2 expands ROS’s use cases with increased security, quality of service, support for embedded systems and real\-time scenarios\. Customers can develop and test their robot applications in AWS RoboMaker with ROS2\-Dashing, through the AWS Management console, AWS SDK, AWS CLI, and the AWS API\. AWS RoboMaker recommends that customers do not use this beta release of the ROS2\-Dashing feature for their production workloads\. 

 We are releasing the AWS RoboMaker ROS2 beta feature to give customers a preview of how they can build their robot applications using ROS2, specifically ROS2 Dashing, the first Long Term Support release of ROS2\. There are certain [known issues](https://github.com/ros2/ros2/issues) in ROS\-2 Dashing, which the community is working to address so we do not recommend you build production applications using ROS2 Dashing\. This is, however, an opportunity to develop, test and evaluate your robot applications with the AWS RoboMaker ROS2 feature and provide feedback before we announce general availability of ROS2 in AWS RoboMaker once these issues have been fully addressed\. At the end of this beta program, we will deprecate support for ROS2 Dashing\. Customers will be asked to shut down their development environments built on ROS2 Dashing and will not be able to start new simulation jobs; existing simulation jobs will be allowed to run to completion\. Customers will also be asked to migrate to the new release of the AWS RoboMaker ROS2 feature for managing their robot fleets\. 

For more information about beta terms and conditions, see [AWS Service Terms](https://aws.amazon.com/service-terms/)\. 

**Topics**
+ [Known Differences in ROS2](#robomaker-ros2-beta-known-differences)
+ [Known Issues](#robomaker-ros2-beta-known-issues)

## Known Differences in ROS2<a name="robomaker-ros2-beta-known-differences"></a>

This section describes the known differences between ROS and ROS2 when using AWS RoboMaker\. 

### Cross\-Compiling Applications with Colcon<a name="robomaker-ros2-beta-cross-compile"></a>

You can now cross\-compile your robot applications using the `cc-build` plug\-in for `colcon`\. For more informaton about installing it in your development environment, see [ros\-tooling/cross\-compile](https://github.com/ros-tooling/cross_compile)\. 

### Capturing log data with rosout<a name="robomaker-ros2-beta-logging"></a>

Log output sent to the `rosout` topic is saved to a log file\. The log file name format is `rosout.log` and will be copied to the Amazon S3 bucket specified when the simulation job was created\. Specifically, it will be copied to `bucket_name/simulation_id/run_id/ros-logs/rosout`\. 

When a log file needs to be rotated because of size, the file is given a numerical suffix \(for example, `rosout.log.1`\) and older log files are incremented\. 

### Using the ROS2 command line interface<a name="robomaker-ros2-beta-roscli"></a>

To inspect ROS2 topics, messages, nodes, services and other information, use the `ros2` command\. For more information about how to use `ros2`, see [Introspection with Command Line Tools](https://index.ros.org/doc/ros2/Tutorials/Introspection-with-command-line-tools/)\. 

### Using the AWS RoboMaker Simulation ROS Service<a name="robomaker-ros2-beta-svc"></a>

For more information about using tags and cancelling a simulation with ROS2 Dashing, see [github\.com/aws\-robotics/aws\-robomaker\-simulation\-ros\-pkgs/tree/dashing](https://github.com/aws-robotics/aws-robomaker-simulation-ros-pkgs/tree/dashing)\. 

## Known Issues<a name="robomaker-ros2-beta-known-issues"></a>

This section describes the known issues for using ROS2 with AWS RoboMaker\. 
+ ROS bag play back is not supported\. For more information about ROS bag play back, see [Using ROS Bags for Play Back](simulation-job-playback-rosbags.md)\. We do not automatically record rosbags for ROS2 applications when you provide an Amazon S3 output location\. To learn more about recording rosbags from your ROS2 application, see the [rosbag2 repository on GitHub](https://github.com/ros2/rosbag2)\. 
+ The **Hello world** and **Robot monitoring** sample applications have been updated to work with ROS2\. For a description of the sample applications, see [Sample Applications](sample-applications.md)\.