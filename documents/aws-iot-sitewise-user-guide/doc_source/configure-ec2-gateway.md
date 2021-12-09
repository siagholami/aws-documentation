# Configuring gateway dependencies on Amazon Elastic Compute Cloud<a name="configure-ec2-gateway"></a>

You can configure a gateway that runs on Amazon EC2\. The gateway runs in the AWS Cloud and ingests data from your industrial data sources to AWS IoT SiteWise\. For more information, see [What is Amazon EC2?](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/) in the *Amazon EC2 User Guide for Linux Instances*\.

AWS IoT SiteWise provides an AWS CloudFormation template that you can use to easily create gateway dependencies on an Amazon EC2 instance\. When you create a stack from the template, AWS CloudFormation creates the required AWS resources for you to run a gateway\. Then, you can create a gateway that uses the AWS IoT Greengrass Core running on the Amazon EC2 instance\.

The AWS CloudFormation template creates the following resources:
+ An Amazon EC2 instance with AWS IoT Greengrass Core software
+ An AWS IoT Greengrass group with info\-level logging for CloudWatch Logs and the local file system
+ An Amazon Virtual Private Cloud
+ AWS Identity and Access Management \(IAM\) roles

**Important**  
You will be charged for the resources that this AWS CloudFormation template creates and uses\. These charges include an AWS IoT Greengrass device and compute capacity and data transfer for Amazon EC2\.

## Prerequisites<a name="ec2-gateway-stack-prerequisites"></a>

To create gateway dependencies on Amazon EC2 from this stack template, you need the following:
+ The AWS IoT SiteWise service\-linked role in your AWS account\. This role creates automatically when you use the AWS IoT SiteWise console\. For more information, see [Using service\-linked roles for AWS IoT SiteWise](using-service-linked-roles.md)\.
+ An AWS IoT Greengrass service role attached to your AWS account in the Region where you create this stack\. For more information, see [AWS IoT Greengrass service role](https://docs.aws.amazon.com/greengrass/latest/developerguide/service-role.html) in the *AWS IoT Greengrass Developer Guide*\.

## Creating the AWS CloudFormation stack<a name="create-ec2-gateway-stack"></a>

You can create a stack in AWS CloudFormation to create an Amazon EC2 instance with AWS IoT Greengrass gateway dependencies\.

**To create gateway dependencies on Amazon EC2**

1. Open the [AWS CloudFormation template](https://console.aws.amazon.com/cloudformation/home?#/stacks/new?stackName=IoTSiteWiseEC2GatewayQuickStart&templateURL=https%3A%2F%2Fs3.amazonaws.com%2Faws-iot-sitewise%2Fquick-start%2FSiteWiseQuickStartCloudFormation.yml) and sign in to the AWS Management Console\.

1. On the **Create stack** page, choose **Next** at the bottom of the page\.

1. On the **Specify stack details** page, enter a **GroupName** for the AWS IoT Greengrass group that this template creates for the gateway\.

1. \(Optional\) Change any of the template's other parameters:
   + **InstanceType** – The Amazon EC2 instance type\. For more information, see [Instance types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-types.html) in the *Amazon EC2 User Guide for Linux Instances*\.
   + **SecurityAccessCIDR** – The CIDR block for the virtual private cloud \(VPC\)\. For more information, see [VPCs and subnets](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Subnets.html) in the *Amazon VPC User Guide*\.

1. Choose **Next**\.

1. On the **Configure stack options** page, choose **Next**\.

1. At the bottom of the page, choose the check boxes that acknowledge that AWS CloudFormation requires access capabilities\.

1. Choose **Create stack**\.

   The stack takes around 5 minutes to create\. If the stack fails to create, your account might have insufficient permissions, or you might not have the prerequisite IAM roles\. Follow these steps to delete the stack and try again:

   1. Choose **Delete** in the upper\-right corner\.

      The stack takes a few minutes to delete\.

   1. If the stack fails to delete, choose **Delete** again\.

   1. If the stack fails to delete again, follow the steps in the AWS CloudFormation console to skip the resources that failed to delete, and try again\.

1. After the stack creates successfully, you can create a gateway with the AWS IoT Greengrass group that deploys to the Amazon EC2 instance\. For more information, see [Adding the gateway to AWS IoT SiteWise](configure-gateway.md#add-gateway)\.

**Important**  
After you create the stack, you can see the new resources in your AWS account\. Your gateway might stop working correctly if you delete or modify these resources\. We recommend that you don't modify these resources unless you want to change settings on your gateway's AWS IoT Greengrass group\.