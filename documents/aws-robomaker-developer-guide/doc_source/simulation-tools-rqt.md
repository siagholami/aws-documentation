# rqt<a name="simulation-tools-rqt"></a>

rqt hosts a number of different plugins for visualizing ROS information\. Multiple plugins can be displayed on a custom dashboard, providing a unique view of your robot\. rqt includes many useful plugins and provides a framework to write custom plugins\.

To perform the tasks below, rqt must be open and connected to a running simulation job\. You can open rqt from the **Simulation jobs detail** page of a running simulation job\. 

**Topics**
+ [View Image Data from Robot](#simulation-tools-rqt-view-image)
+ [View Node Graph](#simulation-tools-rqt-node-graph)
+ [View Currently Advertised Topics](#simulation-tools-rqt-view-topics)

## View Image Data from Robot<a name="simulation-tools-rqt-view-image"></a>

rqt provides a plugin to help visualize image data from a robot\. The image data is updated as the robot moves in the simulated world\. 

1. In **rqt**, choose **Plugins**, **Visualization**, **Image View**\. 

1. In the **Image View** view, choose **/camera/rgb/image\_raw** from the dropdown\. To pause the simulation, see [Pause a Running Simulation](simulation-tools-gazebo.md#simulation-tools-gazebo-pause)\. 

## View Node Graph<a name="simulation-tools-rqt-node-graph"></a>

The node graph is a visual representation of all of the ROS nodes and topics in your application\. Directional arrows indicate which nodes \(ovals\) are advertising or subscribing to a topic \(squares\)\. You can filter the graph to show all topics, active topics, or nodes only\. There are also options to hide or display group, topic and node inforamtion\. 

The graph node view is helpful for verifying which nodes are running and to confirm that nodes and topics are connected as expected\. 

**To view the node graph**

1. In **rqt**, select **Plugins**, then select **Introspection**, and then choose **Node Graph**\. 

1. Use the mouse or keyboard to zoom in on the graph\. Select a node or a topic to see subscriptions \(purple arrows\) and advertisements \(green arrows\)\. 

1. The filter defaults to **Nodes only**\. Choose **Nodes/Topics \(all\)** to see all of the nodes and topics\. Toggle checkboxes to display additional information such as unreachable nodes or dead sinks\. 

## View Currently Advertised Topics<a name="simulation-tools-rqt-view-topics"></a>

The **Topic Monitor** plugin makes it easy to view information about ROS topics including publishers, subscribers and publishing rate, and ROS messages\. It is also helpful for validating message data, identifying nodes that are not publishing messages, and look for bandwidth issues\. 

**To monitor topics**

1. In **rqt**, select **Plugins**, then select **Topics**, and then choose **Topic Monitor**\. 

1. Use the mouse or keyboard to scroll the list of currently advertised topics\. Expand a topic to see message details\. 

1. Select the checkbox to the left of the expanded topic to subscribe to its messages\. As new message arrive, messages data, message bandwidth, and publication frequency are updated\. 