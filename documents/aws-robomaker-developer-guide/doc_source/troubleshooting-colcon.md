# Troubleshooting Colcon Build and Bundle<a name="troubleshooting-colcon"></a>

Help with building and bundling applications with colcon\. For more information about the bundle format and other technical details, see [Building and Bundling a ROS Application for AWS RoboMaker](https://aws.amazon.com/blogs/opensource/building-bundling-ros-app-aws-robomaker/) on the [AWS Open Source Blog](https://aws.amazon.com/blogs/opensource/)\.

## Colcon Build Failed<a name="troubleshooting-colcon-build"></a>

See the following topics for common solutions\.

### Are There CMakeLists\.txt Files in Nested Folders?<a name="troubleshooting-colcon-build-nested"></a>

If you are building a ROS1 application that is built with catkin\_make, colcon may not properly enumerate all of the packages in the workspace\. This is usually caused by nested folder structures with `CMakeLists.txt` in one or more intermediate directories\. colcon supports nested folder structures and finds your packages automatically\. 

For example, the `CMakeLists.txt` in the `intermediate_directory` is not required\. 

```
src/
├── package_1/
│ ├── package.xml
| └── CMakeLists.txt # okay
└── intermediate_directory/
    ├── package_2
    | ├── package.xml
    | └── CMakeLists.txt # okay
    ├── package_3
    | ├── package.xml
    | └── CMakeLists.txt  # okay
    └── CMakeLists.txt  # !!! remove !!!
```

### Are There Missing Install Directives in CMakeLists\.txt?<a name="troubleshooting-colcon-build-install-directives"></a>

If you are building a ROS1 application built with catkin\_make, the `devel` directory and its `setup.sh` adds all local packages into the search paths for ROS tools\. colcon behaves differently\. It installs the targets you specify into the `install` directory, so all of your cmake `install()` directives are executed\. 

If you are experiencing errors like `[my_launchfile] is neither a launch file in package [my_package] nor is [my_package] a launch file name` or `[rosrun] Couldn't find executable named my_node below /opt/ros/$ROS_DISTRO/share/my_package`, then adding calls to `install()` in your `CMakeLists.txt` might fix the issue\. 

For more examples on how to fix this issue, see [the ROS Wiki](http://wiki.ros.org/catkin/CMakeLists.txt#Optional_Step:_Specifying_Installable_Targets)\. 

## Colcon Bundle Failed<a name="troubleshooting-colcon-bundle"></a>

See the following topics for common solutions\.

### Cannot Locate rosdep Definition for \[package\_name\]<a name="troubleshooting-colcon-bundle-rosdep-def"></a>

Ensure that you are using the correct ROS package name for the package you want to depend on\. For example, the package might be named `ros-kinetic-packagename` in `apt`, but in your `package.xml` it should be `packagename`\. Search the [ROS distribution GitHub repo](https://github.com/ros/rosdistro) to see if the package is in the existing rosdep database\. If it is missing, add the dependency to rosdep\. For more information about adding dependencies to rosdep, see the [tutorials](http://wiki.ros.org/rosdep/Tutorials)\. 

## There are Missing Dependencies<a name="troubleshooting-colcon-bundle-missing-deps"></a>

Common error messages for missing dependencies include:
+ `Could not load libxyz.so`
+ `No such file or directory some_script.py`
+ `Could not load module 'python_dependency'`

To solve this problem, add the dependency to `package.xml` of the packages that require it\. Retry the bundle command\.

If your application uses dependencies from your own `apt` or `pip` repository, you need to include those repositories when you invoke colcon bundle\. To resolve this issue, try the following\. 
+ Override the `sources.lst` used by the `apt` installer for colcon bundle with the \-\-apt\-sources\-list argument\. To avoid resolution errors for base operating system and ROS packages, we recommend that you include all the sources we currently use\. For more information, see [examplesources\.list on GitHub](https://github.com/colcon/colcon-bundle/blob/master/colcon_bundle/installer/assets/xenial.sources.list)\. 
+ To override pip or pip3 sources, use \-\-pip\-args and \-\-pip3\-args arguments\. The string after these arguments is passed directly to pip\. For example, \-\-extra\-index\-url https://my\-custom\-pip\-repo/index\. 