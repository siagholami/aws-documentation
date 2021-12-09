# Creating a Workflow<a name="cloud9-create-workflow"></a>

This section describes how to create an AWS RoboMaker workflow for an existing application\. 

A workflow is a collection of tasks that will be run sequentially in order\. Tasks include building an application, bundling an application, and creating a simulation job\. Workflows and tasks are created in the AWS RoboMaker AWS Cloud9 development environment\. Workflows can be selected and run from **AWS RoboMaker Run** menu\.

Workflows are useful for performing repetitive tasks during iterative development\. In this section, you create a workflow that performs the following tasks: 
+ Build a robot application and simulation application with colcon\. 
+ Bundle a robot application and simulation application with colcon\. 
+ Create a simulation job\. 

**Topics**
+ [Prerequisites](#cloud9-create-workflow-prereq)
+ [Create Source and Output Amazon S3 Buckets](#cloud9-create-workflow-bucket)
+ [Create a Simulation Job Role](#cloud9-create-workflow-security)
+ [Create Application Build Configurations](#cloud9-create-workflow-build)
+ [Create Application Bundle Configurations](#cloud9-create-workflow-bundle)
+ [Create a Simulation Configuration](#cloud9-create-workflow-simjob)
+ [Create a Workflow Configuration](#cloud9-create-workflow-simjob)

## Prerequisites<a name="cloud9-create-workflow-prereq"></a>

To create an AWS RoboMaker simulation job from the command line, you need the following:
+ A AWS RoboMaker development environment\. For more information about creating a development environment, see [Creating a Development Environment](cloud9-create-ide.md)\. 
+ A robot application and a simulation application\. To create a simple robotics application and simulation application from scratch, see [Creating a New Robotic Application](application-create-new.md)\. 

Optionally, you can use the the AWS RoboMaker console for easy access to simulation tools like Gazebo, rqt, rviz and terminal\. These tools are available on the **Simulation Job Detail** page\. 

## Create Source and Output Amazon S3 Buckets<a name="cloud9-create-workflow-bucket"></a>

Before you create a simulation job, you need to create a bucket to use as source location for your applications\. To create your buckets, follow the steps in [Create Source and Output Amazon S3 Buckets](application-create-simjob.md#application-simjob-bucket)\. 

## Create a Simulation Job Role<a name="cloud9-create-workflow-security"></a>

A simulation job requires an IAM role with access to resources like source Amazon S3 buckets and Amazon CloudWatch Logs\. To create a simulation job role, follow the steps in [Create a Simulation Job Role](application-create-simjob.md#application-simjob-security)\. 

## Create Application Build Configurations<a name="cloud9-create-workflow-build"></a>

AWS RoboMaker uses colcon to build robot applications and simulation applications\. 

**To create robot application and simulation application build configurations**

1. Open your AWS RoboMaker development environment containing your robotic application\. 

1. In the AWS Cloud9 menu, choose **RoboMaker Run**, then choose **Build**, and then select **Add or Edit Configurations**\. 

1. In the **RoboMaker Configuration** dialog, under **Create New Configuration**, select **Colcon build**\. 

1. In the **RoboMaker Configuration** dialog, under **Colcon Build Configuration**, provide a name for the robot application build configuration\. For example, `MyRobot v3 build, bundle, and create simulation`\. 

1. Type in the path to the robot application working directory\. You can also select **\.\.\.** to use the file picker to select the working directory\. The working directory will contain `CMakeLists.txt`\. 

1. Repeate the steps to create a simulation application build configuration\. Set the **Working directory** to the simulation application work space\. 

1. To start a build, choose **RoboMaker Run**, then choose **Build**, and then select a build configuration\. A new terminal window will open at the bottom of the IDE\. Use it to track build progress\. 

## Create Application Bundle Configurations<a name="cloud9-create-workflow-bundle"></a>

AWS RoboMaker uses colcon to bundle robot applications and simulation applications\. 

**To create robot application and simulation application build configurations**

1. Open your AWS RoboMaker development environment containing your robotic application\. 

1. In the AWS Cloud9 menu, choose **RoboMaker Run**, then choose **Bundle**, and then select **Add or Edit Configurations**\. 

1. Under **Create New Configuration**, select **Colcon bundle**\. 

1. In the **RoboMaker Configuration** dialog, under **Colcon Bundle Configuration**, provide a name for the robot application bundle configuration\. 

1. Type in the path to the robot application working directory\. You can also select **\.\.\.** to use the file picker to select the working directory\. The working directory will contain `CMakeLists.txt`\. For example, `./MySample/robot_ws`\. 

1. Repeate the steps to create a simulation application bundle configuration\. Set the **Working directory** to the simulation application work space\. 

1. To start a bundle process, choose **RoboMaker Run**, then choose **Bundle**, and then select a bundle configuration\. A new terminal window will open at the bottom of the IDE\. Use it to track bundle progress\. You must build the application before it can be bundled\. 

## Create a Simulation Configuration<a name="cloud9-create-workflow-simjob"></a>

**To create a simulation configuration**

1. Open your AWS RoboMaker development environment containing your robotic application\. 

1. In the AWS Cloud9 menu, choose **RoboMaker Run**, then choose **Launch Simulation**, and then select **Add or Edit Configurations**\. 

1. Under **Create New Configuration**, select **Simulation**\. 

1. In the **RoboMaker Configuration** dialog, under **Simulation Configuration**, provide a name for the robot application bundle configuration\. 

1. Provide a **Simulation job duration** in seconds\. For example, to run the simulation job for an hour, type in 3600\.

1. In **Failure behavior**, select **fail**\. 

1. Select the **IAM role** you created for the simulation job\. 

1. Select an optional Amazon S3 bucket for simulation job output\. 

1. Under **Robot application**, provide a robot application name\. 

1. Specify the **Robot app bundle path**\. This is the path to the file created by the bundle process for the robot application\. For example, `./MySample/robot_ws/output.tar`\. Optionally, select **\.\.** to locate the file\. 

1. For **Architecture**, select `X86_64`

1. Select the Amazon S3 bucket to use for the robot application source\. The bundle will be uploaded this location with a prefix created from the path to the bundle file\. For example, if your application bundle is `./MySample/robot_ws/output.tar`, the filename will be `output.tar` and the prefix will be `./MySample/robot_ws/`\. 

1. Specify the **Launch package name** and **Launch file**\. If you are using the example project from [Creating a New Robotic Application](application-create-new.md), the launch package name is `robot_app` and the launch file is `rotate.launch`\. 

1. Under **Simulation application**, type in a simulation application name\. 

1. Specify the **Sim app bundle path**\. This is the path to the file created by the bundle process for the simulation application\. For example, `./MySample/simulation_ws/output.tar`\. Optionally, select **\.\.** to locate the file\. 

1. Select the Amazon S3 bucket to use for the simulation application source\. The bundle will be uploaded this location with a prefix created from the path to the bundle file\. 

1. Specify the **Launch package name** and **Launch file**\. If you are using the example project from [Creating a New Robotic Application](application-create-new.md), the launch package name is `simulation_app` and the launch file is `example.launch`\. 

1. Select **Save** to save the configuration\.

1. To start a simulation job, choose **RoboMaker Run**, then choose **Launch Simulation**, and then select a simulation configuration\. 

## Create a Workflow Configuration<a name="cloud9-create-workflow-simjob"></a>

**To create a workflow configuration**

1. Open your AWS RoboMaker development environment containing your robotic application\. 

1. In the AWS Cloud9 menu, choose **RoboMaker Run**, then choose **Workflow**, and then select **Add or Edit Configurations**\. 

1. Under **Create New Configuration**, select **Workflow**\. 

1. In the **RoboMaker Configuration** dialog, under **Colcon Bundle Configuration**, provide a name for the workflow configuration\. 

1. For **Action 1**, select the colcon build step for your robot application\. 

1. Select add action, then select select the colcon build step for your simulation application as the action\. 

1. Select add action, then select select the colcon bundle step for your robot application as the action\. 

1. Select add action, then select select the colcon bundle step for your simulation application as the action\. 

1. Select add action, then select select the simulation step for your applicatio as the action\. 

1. Choose save\.

1. To run a workflow, choose **RoboMaker Run**, then choose **Workflow**, and then select a workflow configuration\. Use the terminal window to track workflow progress\. 

   Use Gazebo and other simulation tools to connect to the running simulation job and explore sensor data and other information\. You can find the tools in the **RoboMaker Simulation** menu under **Applications**\. 