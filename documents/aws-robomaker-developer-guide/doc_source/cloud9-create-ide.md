# Creating a Development Environment<a name="cloud9-create-ide"></a>

In this section, you create a development environment and access it from the browser\.

**Note**  
Completing these procedures might result in charges to your AWS account\. These include possible charges for services such as Amazon EC2 and AWS RoboMaker\. For more information, see [Amazon EC2 Pricing](https://aws.amazon.com/ec2/pricing/), [AWS RoboMaker Pricing](https://aws.amazon.com/robomaker/pricing/), and [Cloud Services Pricing](https://aws.amazon.com/pricing/services/)\. 

**To create a development environment**  
Follow these steps:

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Development**, and then choose **IDEs**\.

1. In the **Create AWS RoboMaker development environment** page, type a **name** for the environment\.

1. Choose a **ROS Distribution**\. For more information about the Robot Operating System \(ROS\), see [www\.ros\.org](http://www.ros.org/)\. For more information about using ROS 2 with AWS RoboMaker, see [ROS 2 Dashing \(Beta\)](robomaker-ros2-beta.md)\.

1. For **Instance type**, choose an instance type with the amount of RAM and vCPUs you think you need for the kinds of tasks you want to do\. Or leave the default choice\.
**Note**  
Choosing instance types with more RAM and vCPUs might result in additional charges to your AWS account for Amazon EC2\. 

1. In **Networking**, if your development environment needs to access resources on an Amazon VPC, select the **VPC** and subnets\. 

1. Choose **Create** to create the development environment\. 

1. On the **Environment details** page, choose **Open environment**\. It might take a few moments to prepare the environment\. 

You can list available development environments by choosing **Development** in the left navigation pane, then choosing **Development environments**\.