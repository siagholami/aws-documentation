# Connecting to a Simulation Job<a name="simulation-job-remote-connectivity"></a>

When you want to interact with the applications in your simulation job, connect with port forwarding\. When you configure port forwarding, traffic is forwarded from the simulation job port to the application port\. Port forwarding makes it easy to connect with tools such as ROS Bridge and other tools\. This can be useful when you want to debug or run custom tools to interact with your applications\. 

**Topics**
+ [Before You Enable Port Forwarding](#simulation-job-remote-connectivity-beforestart)
+ [Enabling Port Forwarding](#simulation-job-remote-connectivity-enable)
+ [Port Forwarding Examples](#simulation-job-remote-connectivity-example)

## Before You Enable Port Forwarding<a name="simulation-job-remote-connectivity-beforestart"></a>

Who requires access to your instance? A single host or a specific network that you trust such as your local computer's public IPv4 address\. The security group editor in the Amazon EC2 console can automatically detect the public IPv4 address of your local computer for you\. You could also search the internet for "what is my IP address" in an internet browser, or use the following service: [Check IP](http://checkip.amazonaws.com/)\. If you are connecting through an ISP or from behind your firewall without a static IP address, you must find out the range of IP addresses used by clients\. 

**Warning**  
You are responsible for configuring a secure remote connection to the simulation job\. We recommend that you implement a strong authentication method and encryption in transit for the ports you are opening\. 

For more information about security groups, see [Security Groups for your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html)\.

## Enabling Port Forwarding<a name="simulation-job-remote-connectivity-enable"></a>

To enable port forwarding:

1. Determine which ports you need for your robot application and simulation application\. A port on your application is called an *application port*\.

   For example, you might want to use ROS Bridge on port 8085 in your simulation application and port 8080 for HTTP in your robot application\. 

1. Identify the ports on the simulation job instance you want to use as remote connection points\. A port on the simulation job is called a *job port*\.

   For example, you can use port 8085 for ROS Bridge and 80 for HTTP\. The job port and the application ports can be different\.

1. Determine which port mappings you want to enable on a public IP\. A public IP address is an IPv4 address that is reachable from the internet\. You can use public address for communication between your application and the internet\. 

   You can connect to your simulation job without enabling a public address using solutions such as [Linux bastion](https://aws.amazon.com/quickstart/architecture/linux-bastion/) or [AWS VPN](https://aws.amazon.com/vpn/)\. 

1. [Create a simulation job](create-simulation-job.md) and provide the application port mappings\. For example, you can provide a simulation application mapping for ROS Bridge such as job port 8085 to application port 8085\. You can also provide robot application mapping for HTTP such as job port 8080 to application port 80\. 

1. Configure one or more VPC security groups to enable traffic on the simulation job ports\. Create rules to configure inbound traffic or outbound traffic\.

   For example, if you are using HTTP on port 80, you can create rules to allow inbound and outbound traffic on port 80\. You can restrict access to a single IP address, range of addresses, or use other criteria\.

   For more information about working with security groups, see [Working with Security Groups](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html#WorkingWithSecurityGroups)

## Port Forwarding Examples<a name="simulation-job-remote-connectivity-example"></a>

You can connect to your simulation job remotely using different tools\. This section shows how to connect using ROS Bridge and HTTP\. 

**Topics**
+ [Port Forwarding with ROS Bridge](#simulation-job-remote-connectivity-example-bridge)
+ [Port Forwarding with HTTP Server](#simulation-job-remote-connectivity-example-html)

### Port Forwarding with ROS Bridge<a name="simulation-job-remote-connectivity-example-bridge"></a>

You can access ROS functionality from non\-ROS programs using ROS Bridge\. ROS Bridge provides a JSON API\. Tools and applications that support JSON APIs can interface with ROS Bridge and access ROS functionality\. For more information about ROS Bridge, see [rosbridge\_suite](http://wiki.ros.org/rosbridge_suite)\. 

To connect to your application using ROS Bridge

1. Add a dependency on the ROS Bridge package in your `package.xml` file:

   ```
   <package>
      ...
      <exec_depend>rosbridge_suite</exec_depend>
   </package>
   ```

1. Update your launch file to enable ROS Bridge\. It uses port 8080 by default\. 

   ```
   <launch>
     <arg name="rosbridge_port" value="$(optenv ROSBRIDGE_PORT 8080)"/>
     <include file="$(find rosbridge_server)/launch/rosbridge_websocket.launch" > 
        <arg name="port" value="$(arg rosbridge_port)"/>
     </include>
   </launch>
   ```

1. When you create your simulation job, enable remote connectivity and open port 8080 for the robot application or simulation application\. When your simulation job is running, you can connect\. 

### Port Forwarding with HTTP Server<a name="simulation-job-remote-connectivity-example-html"></a>

Copy the following code into a new Python file as a ROS Python node in your nodes directory\. The code creates a node named `webserver` that hosts a web server\. 

For more information about ROS nodes, see [Understanding ROS Nodes](http://wiki.ros.org/ROS/Tutorials/UnderstandingNodes)\.

1.  Add a dependency on [rospy](http://wiki.ros.org/rospy), a Python client library for ROS in your `package.xml` file: 

   ```
   <package>
      ...
      <exec_depend>rospy</exec_depend>
   </package>
   ```

1. Update your launch file to enable ROS Bridge\. It uses port 8080 by default\. 

   ```
   <launch>
     <arg name="server_port" value="$(optenv SERVER_PORT 8080)"/>
     <node pkg="python_launcher" type="run_webserver.sh" name="webserver" output="screen" required="true" args="$(arg server_port)" />
   </launch>
   ```

1. Copy the following code into a new shell script named `run_webserver.sh`\. 

   ```
   #!/usr/bin/env python
   set -ex
   python3 -m webserver.node $1
   ```

1. Copy the following code into a new Python file\. The code creates a node named `webserver` that launches a simple web server\.

   ```
   #!/usr/bin/env python
               
   import rospy
   import http.server
   import socketserver
   import sys
   
   def start_server(port):
       # Start a webserver
       httpd = socketserver.TCPServer(("", int(port)), http.server.SimpleHTTPRequestHandler)
       rospy.loginfo('Webserver at port {}'.format(port))
       httpd.serve_forever()
   
   def main():
   
       rospy.init_node("webserver")
       if len(sys.argv) > 1:
           server_port = sys.argv[1]
   
       start_server(server_port)
       rospy.spin()
   
   if __name__ == '__main__':
       main()
   ```

1. When you create your simulation job, enable port forwarding and open port 8080 for the robot application or simulation application\. When your simulation job is running, you can connect using HTTP\. 