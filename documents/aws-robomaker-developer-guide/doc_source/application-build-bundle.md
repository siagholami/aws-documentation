# Building and Bundling Robotic Applications with Colcon<a name="application-build-bundle"></a>

AWS RoboMaker works with robotics applications built and bundled with colcon\. `colcon` is a command line tool built by the [Open Source Robotics Foundation](https://www.openrobotics.org/) \(OSRF\)\. It automates the building and bundling of ROS and ROS2 applications\. It should be a drop\-in replacement for `catkin_make`\. 

 For more information about `colcon`, see [Colcon](https://colcon.readthedocs.io/en/master/index.html)\. If you experience issues while building with `colcon`, see [colcon\-ros](https://github.com/colcon/colcon-ros)\. For problems bundling with `colcon`, see [colcon\-bundle](https://github.com/colcon/colcon-bundle)\. 

**Topics**
+ [Installing Colcon](#install-colcon)
+ [Using Colcon to Build and Bundle](#use-colcon)

## Installing Colcon<a name="install-colcon"></a>

Use the following commands to install `colcon`:

```
apt-get update
apt-get install python3-pip python3-apt
pip3 install -U setuptools
pip3 install -U colcon-common-extensions colcon-ros-bundle
```

If you already have `colcon` installed, you can install bundling support with the following command:

```
pip3 install -U colcon-ros-bundle
```

## Using Colcon to Build and Bundle<a name="use-colcon"></a>

Use the following commands to build and then bundle your robotics application:

```
cd robotic-application-workspace
colcon build
colcon bundle
```