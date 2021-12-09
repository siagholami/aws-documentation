# Step 1: Find Your Scalable Resources<a name="gs-select-application"></a>

In the Getting Started section, you create a scaling plan and get a hands\-on introduction to using AWS Auto Scaling through the AWS Management Console\. 

This tutorial focuses on the most straightforward configuration for a scaling plan\. However, we also describe the Create Scaling Plan wizard and all of the ways that you can use it to configure a scaling plan\. 

The first step in the wizard asks you to find your scalable resources\. There are two ways to locate the resources for a new scaling plan from the AWS Auto Scaling console:
+ You choose an application source \(an AWS CloudFormation stack or a set of tags\) for AWS Auto Scaling to use to automatically discover your scalable resources\. As you define your scaling plan, you can then choose which of these resources to include or exclude\. 
+ Alternatively, you can choose one or more Amazon EC2 Auto Scaling groups to add to your scaling plan\.

**Specifying a CloudFormation stack as the application source**  
When you use CloudFormation, you work with stacks\. All of the resources in a stack are defined by the stack's template\. Your scaling plan adds an orchestration layer on top of the stack that makes it easier to configure scaling for multiple resources\. Without a scaling plan, you would need to set up scaling for each scalable resource individually\. This means figuring out the order for provisioning resources and scaling policies, and understanding the subtleties of how these dependencies work\.

To use a stack as the application source, AWS Auto Scaling must be able to discover the resources\. AWS Auto Scaling only finds resources that are defined in the selected stack\. It does not traverse through nested stacks\. 

For your ECS services to be discoverable in a CloudFormation stack, AWS Auto Scaling must know which ECS cluster is running the service\. This requires that your ECS services be in the same CloudFormation stack as the ECS cluster that is running the service\. Otherwise, they must be part of the default cluster\. To be identified correctly, the ECS service name must also be unique across each of these ECS clusters\.

**Specifying tags as the application source**  
Tags provide metadata that can be used to discover related resources in the AWS Auto Scaling console, using tag filters\.

To use tags as the application source, you must first apply one or more tags to your Amazon DynamoDB tables and global secondary indexes, Amazon EC2 Auto Scaling groups, and Amazon Aurora read replicas\. Currently, ECS services and Spot Fleet requests cannot be discovered using tags\. Tags can be assigned in a number of ways\. 

**Important**  
For a beginner\-friendly tutorial, you can start more simply by choosing an Auto Scaling group to add to your scaling plan\. By using an Auto Scaling group, you can enable the predictive scaling feature and the dynamic scaling feature\. You must enable both features to use the full set of advanced features that are available in your scaling plan\.

## Prerequisites<a name="gs-select-application-prereq"></a>

Before you begin, use the Amazon EC2 console to create a new Auto Scaling group by following the steps for [Getting Started with Amazon EC2 Auto Scaling](https://docs.aws.amazon.com/autoscaling/ec2/userguide/GettingStartedTutorial.html) in the *Amazon EC2 Auto Scaling User Guide*\. You can choose any group, but let's use a new group for this tutorial, so that you can delete it afterwards\. As soon as the group is deleted, you stop incurring charges for the Amazon EC2 instances it ran\.

You need IAM permissions to create a scaling plan and to enable predictive scaling\. For information about the required IAM permissions, see the [AWS Auto Scaling Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md) in this guide\.

## Discovering or Choosing Your Scalable Resources<a name="gs-choose-discovery-method"></a>

Complete the following procedure to find your scalable resources\. 

**Note**  
For this tutorial, choose **Choose EC2 Auto Scaling groups** and then choose the Auto Scaling group that you created in the previous section\.

**To find scalable resources to add to your scaling plan**

1. Open the AWS Auto Scaling console at [https://console\.aws\.amazon\.com/awsautoscaling/](https://console.aws.amazon.com/awsautoscaling/)\.

1. On the navigation bar at the top of the screen, choose the same Region that you used when you created your scalable resources\. 

   You can choose any Region that supports AWS Auto Scaling\. For a list of available Regions, see the [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#autoscaling_region) documentation in the *AWS General Reference*\.

1. From the welcome page, choose **Get started**\.  
![\[AWS welcome screen\]](http://docs.aws.amazon.com/autoscaling/plans/userguide/images/aws-as-gs-welcome-screen.PNG)

1. On the **Find scalable resources** page, choose **Search by CloudFormation stack**, **Search by tag**, or **Choose EC2 Auto Scaling groups**\.
   + If you chose **Search by CloudFormation stack**, choose the AWS CloudFormation stack to use\.
   + If you chose **Search by tag**, then for each tag, choose a tag key from **Key** and tag values from **Value**\. To add tags, choose **Add another row**\. To remove tags, choose **Remove**\.
   + If you chose **Choose EC2 Auto Scaling groups**, then for **Auto Scaling groups**, choose one or more Auto Scaling groups\.

1. Choose **Next**\.