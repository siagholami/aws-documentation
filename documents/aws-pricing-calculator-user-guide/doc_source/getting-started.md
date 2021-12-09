# Getting started<a name="getting-started"></a>

The Getting Started chapter walks you through a task using AWS Pricing Calculator so that you can get an idea of how to use AWS Pricing Calculator\. In this case, we walk you through getting an estimate for an Amazon EC2 instance using the Amazon EC2 **Quick estimate** option\. The Amazon EC2 quick estimate enables you to add an Amazon EC2 instance to your estimate without delving deeply into the different Amazon EC2 options\. This enables you to get an estimate without knowing the technical details of all of the Amazon EC2 instance types\.

**Topics**
+ [Understanding your estimates](#overview)
+ [Prerequisites](#prereqs)
+ [Step 1: Create an estimate](#step-1)
+ [Step 2: \(Optional\) Add a group](#step-2)
+ [Step 3: Add and configure a service](#step-3)

## Understanding your estimates<a name="overview"></a>

 When you generate an estimate, you can either add services directly to your estimate or create a group and add the services to your group\.

This guide shows you how to set up a group with an Amazon EC2 instance that you can use to perform tasks such as run a small program or host a website\. 

### Tasks<a name="overview-tasks"></a>

To complete this tutorial, perform the following tasks:

1. [Step 1: Create an estimate](#step-1)

1. [Step 2: \(Optional\) Add a group](#step-2)

1. [Step 3: Add and configure a service](#step-3)

## Prerequisites<a name="prereqs"></a>

This tutorial doesn't require any initial setup\. You can use it without an AWS account and without committing to anything\. 

## Step 1: Create an estimate<a name="step-1"></a>

To get started generating an estimate, create your estimate and assign your estimate a Region\. <a name="create-estimate"></a>

**To create your estimate**

1. Open AWS Pricing Calculator at [https://calculator\.aws/\#/](https://calculator.aws/#/)\.

1. Choose **Create estimate**\.

1. On the **Select service** page, find the service of your choice and choose **Configure**\.

1. Select a **Region**\.

1. Enter your settings in the **Service settings** section\.

1. Choose **Add to my estimate**\.

## Step 2: \(Optional\) Add a group<a name="step-2"></a>

A group enables you to organize services together\. You can add one or more services to each group\. You can use groups to organize your estimate in different ways, such as by cost center, service stack, product architecture, or client\.

**Note**  
You can customize Regions for each service at a service level, by using the Region dropdown menu\. You can't change Regions at a group level\. For more information about customizing Regions for services, see [Step 3: Add and configure a service](#step-3)\.<a name="add-group"></a>

**To add a group to your estimate**

1. To create a group, in the upper\-right header, choose **Add group**\.

1. For **Group name**, enter *My service group*\. 

1. Choose **Add group**\.

## Step 3: Add and configure a service<a name="step-3"></a>

After you have an estimate and \(optionally\) a group, add and configure services to your estimate to generate estimated costs\. If you didn't create a group, use the **My estimate** view instead of the **My service group** view\. Everything else in the following procedure remains the same\.

In this case, we're adding Amazon EC2 using the Amazon EC2 **Quick estimate** option\. <a name="generate-quick-estimate"></a>

**To add and configure a service for your estimate**

1. On the **My service group** page choose **Add service**, which brings you to a page of services that you can add to your estimate\.

1. On the **Add service** page, select **Amazon EC2** and choose **Configure** in the upper\-right header\. This adds Amazon EC2 to your group and takes you to the **Quick estimate** view, where you can configure what you want in an Amazon EC2 instance\.

   The **Quick estimate** view is preloaded with default values, enabling you to see a starting estimate without adding or changing any information\. You can change any of the values for the following parameters or keep the defaults when applicable:
   + Region
   + The operating system
   + The number of Amazon EC2 instances
   + The Amazon EC2 instance search options
   + The pricing model
   + The reservation term
   + The payment options
   + The storage volume
   + The storage amount

1. Choose **Add to my estimate**\.

   This adds an Amazon EC2 instance with the selected parameters to the group that you created in step 1 and returns you to the **My estimate** page\. The **Services** section lists the service estimates that you added\.

   The **My service group** page shows you how much the selected default instance would likely cost you\. The **Service** section lists your service names with the Region that you specified for each service\. You can create multiple estimates for the same service with different Regions to compare price differences\. Note that estimates are just that: estimates\. AWS charges are calculated using the actual AWS usage for an account\.