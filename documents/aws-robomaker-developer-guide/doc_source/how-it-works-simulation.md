# Develop Simulation and Testing Data<a name="how-it-works-simulation"></a>

Robot application developers use simulations to help refine behavior\. They use simulations to test robotics algorithms and perform regression tests\. Simulations use realistic scenarios and detailed virtual environments to model the world and mimic robot behavior\. 

In AWS RoboMaker, a *simulation application* contains models for the robot, terrain, and assets organized in a scene\. The simulation application is responsible for simulating the physical aspects of a robot such as its sensors, kinematics, and dynamics\. Sensors may include cameras, lidars, and even GPS devices\. Kinematics and dynamics are required to allow the robot to move its joints or wheels and interact physically, such as colliding, with objects in a simulated environment\.

To run a simulation, pair a robot application with a simulation application in a simulation job\. The simulation job can run up to 14 days\. You can restart it with a new application while it is running\. You can interact with a running simulation by using Gazebo, rviz, rqt, and a terminal to interact at the command line\. For example, use Gazebo to see a rendered model of the robot in the environment and use the terminal to listen or send ROS messages to your robot\. 

The robot is unaware that it is inside a simulated environment\. The simulator uses the same interfaces and data types as the robot's physical devices\. This makes it possible to test the same robot software in a simulation and then deploy it to your robots\. 