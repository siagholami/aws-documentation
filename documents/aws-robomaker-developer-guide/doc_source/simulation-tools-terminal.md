# Terminal<a name="simulation-tools-terminal"></a>

The Terminal provides access to a command\-line on the simulation job host\.

To perform the tasks below, the Terminal must be open and connected to a running simulation job\. You can open the Terminal from the **Simulation jobs detail** page of a running simulation job\. 

**Note**  
Launching GUI applications in the terminal window is unsupported\.

**Topics**
+ [Inspect ROS Topics and Messages](#simulation-tools-terminal-debug-topics)
+ [Inspect ROS Nodes and Services](#simulation-tools-terminal-debug-nodes)
+ [View Log Files in Real Time](#simulation-tools-terminal-view-logs)

## Inspect ROS Topics and Messages<a name="simulation-tools-terminal-debug-topics"></a>

Use `rostopic` to display information about ROS topics\. For more information about `rostopic`, see [http://wiki\.ros\.org/rostopic](http://wiki.ros.org/rostopic)\. 

1. In **terminal**, type in the following commands to set up the ROS environment:

   ```
   eval $AWS_ROBOMAKER_ROBOT_APPLICATION_SETUP
   ```

1. Type the following command to see a list of available topics:

   ```
   rostopic list
   ```

1. Use the following command to view messages associated with a listed topic:

   ```
   rostopic echo /topic_name
   ```

## Inspect ROS Nodes and Services<a name="simulation-tools-terminal-debug-nodes"></a>

Use `rosnode` to display information about ROS nodes and services\. For more information about `rosnode`, see [http://wiki\.ros\.org/rosnode](http://wiki.ros.org/rosnode)\. 

1. In **terminal**, type in the following commands to set up the ROS environment:

   ```
   eval $AWS_ROBOMAKER_ROBOT_APPLICATION_SETUP
   ```

1. Type the following command to see a list of available topics:

   ```
   rosnode list
   ```

1. Use the following command to view messages associated with a listed topic:

   ```
   rostopic info /node_name
   ```

## View Log Files in Real Time<a name="simulation-tools-terminal-view-logs"></a>

Log files are written to `tmp/robot-logs/stdout_and_stderror` and `tmp/simulation-logs/stdout_and_stderror`\. For example, to view the last part of the robot application log, use the following command: 

```
tail -f /tmp/robot-logs/stdout_and_stderror
```