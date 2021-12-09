# Step 3: Configure Environment and Build Applications<a name="gs-build"></a>

In this section, you create an AWS Cloud9 environment with AWS RoboMaker\. You then install sample code\. In the development environment, you modify the robot application, and then build the robot and simulation application\. 

**Topics**
+ [Create a Development Environment](#gs-build-createide)
+ [Modify and Build Applications](#gs-build-apps)

## Create a Development Environment<a name="gs-build-createide"></a>

The AWS Cloud9 development environment provides the tools to develop robot applications and simulation applications with ROS and AWS RoboMaker\.

**To create a development environment:**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\. 

1. On the left, expand **Development**, choose **Development environments**, and then choose **Create environment**\. 

1. In the **Create AWS RoboMaker development environment** page, enter **HelloWorld** as the environment **name**\. 

1. For **ROS Distribution**, select **ROS Melodic**\.

1. Accept the default **Instance type** \(**m4\.large**\)\. You can select different instances type to improve bundling performance\.

1. Select a **VPC**\. Use the default VPC\.

1. Select a **Subnet**\. Use a public Subnet\.

1. Choose **Create** to create the AWS Cloud9 development environment\.

## Modify and Build Applications<a name="gs-build-apps"></a>

In this section, you use the AWS Cloud9 development environment to modify the robot application\. The steps show how to rotate the robot counter\-clockwise and then build the robot and the simulation application\. 

**To build the robot and simulation applications**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\. 

1. On the left, expand **Development**, choose **Development environments**, select **HelloWorld**, and then choose **Open environment**\. It might take a few minutes to prepare the development environment\. 

1. In the **HelloWorld** AWS Cloud9 development environment, choose **AWS RoboMaker Resources**, then choose **Download samples**, and then select **1\. Hello World**\.

1. On the left, in the **Environment** tab, expand **HelloWorld**, **HelloWorld**, **robot\_ws**\. **src**, **hello\_world\_robot**, and then **nodes**\. Select the file **rotate** to load into the editor\.

1. In the **rotate** tab, modify the code to make the robot turn clockwise by making the rate negative: `self.twist.angular.z = -0.1`\. Save the file by selecting **File** and then **Save**\. 

1. Build the robot application\. On the menu, choose **Run**, then choose **Build**, and then select **HelloWorld Robot**\. 

1. Build the simulation application\. On the menu, choose **Run**, then choose **Build**, and then select **HelloWorld Simulation**\. 

**Next Step**  
[Step 4: Run Simulation](gs-simulation.md)