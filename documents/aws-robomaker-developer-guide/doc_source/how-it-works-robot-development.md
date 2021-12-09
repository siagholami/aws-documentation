# Robotics Development with AWS RoboMaker<a name="how-it-works-robot-development"></a>

This section shows a typical robot development workflow\. It tells how you accomplish the tasks with AWS RoboMaker\.

Robot application development usually starts after you choose your physical robot hardware\. First, you create a development environment and load the tools to build an application\. Next, create the robot application\. Write custom logic that responds to environmental data\. Next, build simulations, or models of the world that your robot will inhabit\. Collect data about how your robot performs in simulation jobs\. When your tests are complete, deploy your application to physical robots\. Monitor them and update the software when needed\. 

As a robot developer, you typically perform the following activities\.

1. Create a ROS development environment\. To create a robot application, you need an environment configured for ROS development along with tools like Colcon to build and bundle the application\. You'll also need tools to help you cross\-compile the application for your physical robot\. Using an integrated development environment makes it easier\. 

   In AWS RoboMaker, you can create an AWS Cloud9 development environment that is already configured with the tools to develop robot applications\. You can also use your existing environment\.

1. Create the robot application\. This is where you get to write code\. Build on the foundation provided by ROS and integrate functions you find elsewhere\. The application you create works with your robot hardware, provides intelligence, and works with the cloud\. 

1. Develop simulation and testing data\. In this stage, run your robot application in simulated environments\. Collect sensor data and other performance data from the simulation\. It can take many simulation tests to complete the robot programming\. 

1. Deploy an application to robot fleets\. When your application performs as expected, you are ready to deploy it to a robot\. In AWS RoboMaker, a robot must belong to a group of robots \(a fleet\) in order to receive deployed software\. Each virtual robot in AWS RoboMaker represents a physical robot\. 

1. Monitor and update robots\. Your robots are interacting in the world\! Refine them by using data you collect with AWS RoboMaker cloud extensions\. 

The following sections explore the details of each step\.