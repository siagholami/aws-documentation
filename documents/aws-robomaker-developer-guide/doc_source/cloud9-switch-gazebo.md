# Manually Switching Gazebo Versions<a name="cloud9-switch-gazebo"></a>

This section describes how to change the version of Gazebo that is supported in the AWS Cloud9 development environment\. This applies only to the ROS Kinetic development environment\.

When you switch Gazebo versions, it affects the *entire* development environment\. All of the robot applications and simulation applications in the development environment will be built and bundled in the switched environment\. 

**Note**  
Simulation applications are dependent on a version\. To change the version, you need to update the dependencies in your application\.

**Topics**
+ [Switch from Gazebo 7 to Gazebo 9](#cloud9-switch-gazebo-to-v9)
+ [Switch from Gazebo 9 to Gazebo 7](#cloud9-switch-gazebo-to-v7)

## Switch from Gazebo 7 to Gazebo 9<a name="cloud9-switch-gazebo-to-v9"></a>

**To switch from Gazebo 7 environment to Gazebo 9 environment**

1. Open the command prompt\.

1. Run the following code to create a shell script named `gazebo7to9.sh` in the current directory:

   ```
   $ echo '
   #!/bin/bash
   set -e
   
   echo "Switching to Gazebo9…"
   
   sudo touch /etc/apt/sources.list.d/gazebo-stable.list
   sudo chmod 666 /etc/apt/sources.list.d/gazebo-stable.list
   sudo echo "deb http://packages.osrfoundation.org/gazebo/ubuntu-stable `lsb_release -cs` main" > /etc/apt/sources.list.d/gazebo-stable.list
   sudo wget http://packages.osrfoundation.org/gazebo.key -O - | sudo apt-key add -
   sudo apt-get update
   
   sudo touch /etc/ros/rosdep/sources.list.d/00-gazebo9.list
   sudo chmod 666 /etc/ros/rosdep/sources.list.d/00-gazebo9.list
   sudo echo "yaml https://github.com/osrf/osrf-rosdep/raw/master/gazebo9/gazebo.yaml
   yaml https://github.com/osrf/osrf-rosdep/raw/master/gazebo9/releases/indigo.yaml indigo
   yaml https://github.com/osrf/osrf-rosdep/raw/master/gazebo9/releases/jade.yaml jade 
   yaml https://github.com/osrf/osrf-rosdep/raw/master/gazebo9/releases/kinetic.yaml kinetic 
   yaml https://github.com/osrf/osrf-rosdep/raw/master/gazebo9/releases/lunar.yaml lunar" >> /etc/ros/rosdep/sources.list.d/00-gazebo9.list
   
   sudo apt-get remove ros-kinetic-gazebo*
   sudo apt-get remove libgazebo*
   sudo apt-get remove gazebo*
   
   echo "Done switching…"' > gazebo7to9.sh && chmod +x gazebo7to9.sh
   ```

   You only need to create this script once in your environment\.

1. On the command line, run the script you created: 

   ```
   $ gazebo7to9.sh
   ```

   The environment will configured to build and bundle applications using Gazebo 9\.

## Switch from Gazebo 9 to Gazebo 7<a name="cloud9-switch-gazebo-to-v7"></a>

**To switch from Gazebo 9 environment to Gazebo 7 environment**

1. Open the command prompt\.

1. Run the following code to create a shell script named `gazebo9to7.sh` in the current directory:

   ```
   $ echo '
       !/bin/bash
       set -e
       echo "Switching to Gazebo7…"
       sudo apt-get remove ros-kinetic-gazebo*
       sudo apt-get remove libgazebo*
       sudo apt-get remove gazebo*
       sudo rm /etc/ros/rosdep/sources.list.d/00-gazebo9.list
       echo "Done switching…"' > gazebo9to7.sh && chmod +x gazebo9to7.sh
   ```

1. On the command line, run the script you created: 

   ```
   $ gazebo9to7.sh
   ```

   The environment will configured to build and bundle applications using Gazebo 7\.