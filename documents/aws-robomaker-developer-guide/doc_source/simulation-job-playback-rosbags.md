# Using ROS Bags for Play Back<a name="simulation-job-playback-rosbags"></a>

[ROS bags](http://wiki.ros.org/rosbag) are files that contain timestamped, serialized message data from ROS topics\. AWS RoboMaker can play back messages in ROS bags to ROS applications running in a simulation job\. AWS RoboMaker uses `rosbag` to [play back](http://wiki.ros.org/rosbag/Commandline#rosbag_play) messages\. Messages are played back based on their original timestamp and include the original payload\. The messages from the ROS bags replace inputs and other observations from the real world and virtual simulation\. 

ROS bags are recorded using `rosbag record`\. ROS bags can be created from ROS applications designed for simulation\. They can also be created by robots operating in the real world\. ROS bags are used to test new robotic applications, troubleshoot existing applications, and develop new functionality\. 

ROS bags specified in data sources are copied to the `/opt/robomaker/datasources/` directory in the simulation environment\.

**Topics**
+ [Example Launch File Configurations](#simulation-job-playback-rosbags-example)
+ [Avoiding a Failed Simulation Job when Play Back Ends](#simulation-job-playback-rosbags-failed)
+ [Using Tags for Custom Status and Property Values](#simulation-job-playback-rosbags-tags)
+ [Canceling a Simulation Job Early](#simulation-job-playback-rosbags-cancel)

## Example Launch File Configurations<a name="simulation-job-playback-rosbags-example"></a>

A simulation job using ROS bag playback requires at least one ROS bag data source\. The simulation application must also have a launch file node configured to play back the ROS bag data source\. This section contains example launch configurations\. 

The examples below use a node that plays ROS bag files\. The BAG files are specified in arguments\. The path to the ROS bag file is prefixed with the mount path for data sources\. For example, in the following: 

```
args="/opt/robomaker/datasources/mybaggroup/myS3prefix/log_0.bag"/>
```

Where:
+ `myS3prefix/log_0.bag` is the full Amazon S3 key path to the bag file
+ `mybaggroup` is the name of the bag group
+ `/opt/robomaker/datasources/` is the path where the log file is mounted

### Play a Single ROS bag File<a name="simulation-job-playback-rosbags-example-single"></a>

In the following example, the messages in ROS bag file `log_0.bag` are played back ordered by synchronized time\. The bag file is part of the ROS bag group `mybaggroup`\. The ROS bag file itself is located in `myS3prefix`, not in `mybaggroup`\. 

```
<launch>
   <!-- ROS bag files are copied to /opt/robomaker/datasources/
        ROS bag files are copied from myS3prefix/
   -->  
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="/opt/robomaker/datasources/mybaggroup/myS3prefix/log_0.bag"/>
</launch>
```

### Play Multiple ROS Bag Files<a name="simulation-job-playback-rosbags-example-mult"></a>

In the following example, the messages in the ROS bag files `log_0.bag` and `log_1.bag` are played back\. The ROS bags are in the same ROS bag group `mybaggroup`\. Messages from both bag files are ordered by synchronized time\. 

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="/opt/robomaker/datasources/mybaggroup/myS3prefix/log_0.bag
               /opt/robomaker/datasources/mybaggroup/myS3prefix/log_1.bag"/>
</launch>
```

The time between messages are simulated\. For example, if there are two ROS bags with a 30\-minute gap between them, the simulation ticks for 30 \(simulation\) minutes\. 

Use \-\-skip\-empty=SEC to skip regions where there are no messages for `SEC` seconds\. In the following example, any gaps more than 60 seconds are skipped\. 

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="--skip-empty=60 /opt/robomaker/datasources/mybaggroup/myS3prefix/log_0.bag
               /opt/robomaker/datasources/mybaggroup/myS3prefix/log_1.bag"/>
</launch>
```

### Play ROS Bag Files from Different Bag Groups<a name="simulation-job-playback-rosbags-example-multigroup"></a>

In the following example, the messages in the ROS bag files `log_0.bag` and `log_1.bag` are played back ordered by synchronized time\. The files are from different ROS bag groups `mybaggroup_1` and `mybaggroup_2`\. 

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="/opt/robomaker/datasources/mybaggroup_1/myS3prefix/log_0.bag
               /opt/robomaker/datasources/mybaggroup_2/myS3prefix/log_0.bag"/> 
</launch>
```

### Use a Different Starting Offset and Duration<a name="simulation-job-playback-rosbags-example-start"></a>

You can control when playback begins by specifying a time offset in seconds\. In the following example, the messages in the ROS bag file `log_0.bag` begin playback at 10 seconds\. It ends when the end of the ROS bag is reached\. 

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="--start 10 /opt/robomaker/datasources/mybaggroup_1/myS3prefix/log_0.bag"/>
</launch>
```

You can also play back a range a subset of messages by specifying `start` and `duration` times\. In the following example, the messages in the ROS bag file `log_0.bag` begin playback at 10 seconds\. It ends after 100 seconds\. 

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="--start 10 --duration 100 /opt/robomaker/datasources/mybaggroup_1/myS3prefix/log_0.bag"/>
</launch>
```

To play a subset of the messages starting at the beginning of the ROS bag, specify only a `duration`\.

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="--duration 100 /opt/robomaker/datasources/mybaggroup_1/myS3prefix/log_0.bag"/>
</launch>
```

### Pausing and Playing Messages Interactively<a name="simulation-job-playback-rosbags-example-pauseplay"></a>

ROS bag messages begin playback automatically\. You can manually start and stop message playback\. Use `--pause` to start ROS bag message playback as paused\. You can then interact with playback using tools such as `rviz` and `rqt`\. This is helpful when debugging your robot application\. 

For more information, see [rosservice command line tool](http://wiki.ros.org/rosservice#rosservice_command-line_tool)\.

In the following launch file, playback begins in a paused state\. 

```
<launch>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="--pause /opt/robomaker/datasources/mybaggroup_1/myS3prefix/log_0.bag"/>
</launch>
```

From the terminal, use the following commands to resume message playback and pause message playback\.

```
robomaker@9cc6d11dfa46:~$rosservice call /rosbag_play/pause_playback '{data: True}'
success: True
message: "Playback is now paused"
robomaker@9cc6d11dfa46:~$rosservice call /rosbag_play/pause_playback '{data: False}'
success: True
message: "Playback is now resumed"
```

#### Using Environment Variables to Configure Play Back<a name="simulation-job-playback-rosbags-example-envvars"></a>

You can use environment variables as arguments in the `launch.xml` file\. Environment variables can be defined when creating a simulation job\. Use them to make it easier to specify the location of ROS bags, playback arguments like `start`, and other details\. 

In the following launch file, two arguments `bags` and `args` are created\. Their values are captured from the environment variables `BAGS` and `ARGS` defined when you create the simulation job\. 

```
<launch>
  <arg name="bags"  default="$(optenv BAGS)" doc="space separated list of bag files"/>
  <arg name="args"  default="$(optenv ARGS)" doc="rosbag play args"/>
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="$(arg bags) $(arg args)"/>
</launch>
```

When you create the simulation job, create the `BAGS` and `ARGS` environment variables\. For example, if you create environment variables with the values below, playback uses two ROS bag files\. Playback begins at 10 seconds and last for 100 seconds\. 

```
BAGS="/opt/robomaker/datasources/bags/myS3prefix/log_0.bag /opt/robomaker/datasources/bags/myS3prefix/log_1.bag"
ARGS="--start 10 --duration 100"
```

## Avoiding a Failed Simulation Job when Play Back Ends<a name="simulation-job-playback-rosbags-failed"></a>

When the playback node exits and it is `required`, the simulation application closes\. The simulation job status is set to `Failed` and the failure reason is `Simulation application exited abnormally (segfault, etc.)`\. Avoid this by using the `keep-alive` option\.

In the following example, the simulation job runs for the simulation job duration time specified\. If playback has not completed at the end of the simulation job, it is stopped\. In both cases, the simulation job status is set to `Completed`\.

```
<launch>
  <!-- Other ROS launch nodes... -->
   <node pkg="rosbag" type="play" name="rosbag_play" output="screen" required="true"
         args="--keep-alive /opt/robomaker/datasources/mybaggroup_1/myS3prefix/log_0.bag"/>
</launch>
```

You can also cancel a simulation job early\. For more information, see [Canceling a Simulation Job Early](#simulation-job-playback-rosbags-cancel)\.

## Using Tags for Custom Status and Property Values<a name="simulation-job-playback-rosbags-tags"></a>

To help you manage your simulation jobs, you can optionally assign your own metadata\. For more information, see [Managing Tags in a Simulation Job](simulation-job-tags.md)\.

## Canceling a Simulation Job Early<a name="simulation-job-playback-rosbags-cancel"></a>

You can choose to cancel your simulation job early with custom application logic or manually from the terminal\. When you cancel, the simulation job status is set to `Cancelled`\. This can be helpful when reviewing simulation jobs\. If a simulation job is `Cancelled`, it was done intentionally\. If a simulation job has a job status of `Failed`, it exited unexpectedly\. 

 A simulation job can be cancelled manually from the terminal or programmatically within your simulation application\. 

**Note**  
You must have permissions to call `CancelSimulationJob` to cancel a simulation job\. For more information about permissions, see [Authentication and Access Control for AWS RoboMaker](auth-and-access-control.md)\.

### Canceling Manually from the Terminal<a name="simulation-job-playback-rosbags-cancel-term"></a>

The following example shows how to use `rosservice` to manually cancel a simulation job\.

**Note**  
The connection is closed when the simulation job terminates\.

```
robomaker@9cc6d11dfa46:~$rosservice call /robomaker/job/cancel
success: True
message: ''
```

### Canceling from Python<a name="simulation-job-playback-rosbags-cancel-py"></a>

To cancel using Python in your simulation application:

1. To access the service types \(`.srv`\), add a dependency on the AWS RoboMaker package in your `package.xml`\.

   ```
   <package>
      ...
      <depend>aws_robomaker_simulation_ros_pkgs</depend>
   </package>
   ```

1. Copy the following code into a new Python file as a ROS Python node\. The code uses service proxies to add a tag and cancel the simulation job based on elapsed time\. Your cancel conditions might depend on sensor data, robot conditions, or other information\. 

   For more information about ROS nodes, see [Understanding ROS Nodes](http://wiki.ros.org/ROS/Tutorials/UnderstandingNodes)\.

   ```
   #!/usr/bin/env python
   
   import rospy
   from rosgraph_msgs.msg import Clock
   from robomaker_simulation_msgs.msg import Tag
   from robomaker_simulation_msgs.srv import Cancel, AddTags
   
   is_cancelled = False
   
   # cancels the simulation job
   def cancel_job():
       # proxy for simulation job cancel 
       requestCancel = rospy.ServiceProxy('/robomaker/job/cancel', Cancel)
       response = requestCancel()
       if response.success:
           global is_cancelled
           is_cancelled = True
           rospy.loginfo("Successfully requested cancel job")
       else:
           rospy.logerr("Cancel request failed: %s", response.message)
   
   # adds the key=value tag to the simulation job
   def add_tags(tags):
       requestAddTags = rospy.ServiceProxy('/robomaker/job/add_tags', AddTags)
       response = requestAddTags(tags)
       if response.success:
           rospy.loginfo("Successfully added tags: %s", tags)
       else:
           rospy.logerr("Add tags request failed for tags (%s): %s", tags, response.message)
   
   # checks for simulation job cancel conditions
   def check_complete(msg):
       # when clock time is 30 seconds, add a tag indicating results
       # and cancel the simulation job
       global is_cancelled
       if msg.clock.secs > 30.0 and not is_cancelled:
          add_tags(key="result", value="pass")
          is_cancelled = cancel_job()
   
   # timer callback that cancels the job 
   def cancel_timeout(timer):
       global is_cancelled
       if not is_cancelled: 
           rospy.loginfo("Timed out, canceling job")
           add_tags([Tag(key="status", value="timeout")])
           cancel_job()
       
   if __name__ == "__main__":
       rospy.init_node('cancel_node')
       # wait for the required services to become available
       rospy.wait_for_service('/robomaker/job/cancel') 
       rospy.wait_for_service('/robomaker/job/add_tags')
       # tag the simulation job with a descriptive name
       add_tags(key="name", value="my_test")            
       # add a timer to tag status as timeout and cancel the job after 5 minutes
       rospy.Timer(rospy.Duration(secs=300), cancel_timeout, oneshot=True)
       # add a subscriber to tag status as pass and cancel the job
       clock = rospy.Subscriber('/clock', Clock, check_complete)
       # keep the node alive
       rospy.spin()
   ```