# Using the AWS IoT SiteWise demo<a name="getting-started-demo"></a>

You can easily explore AWS IoT SiteWise by using the AWS IoT SiteWise demo\. AWS IoT SiteWise provides the demo as an AWS CloudFormation template that you can deploy to create assets and generate sample data for up to a week\.

**Important**  
You will be charged for the resources that this demo creates and consumes\. 

**Topics**
+ [Creating the AWS IoT SiteWise demo](#create-getting-started-demo)
+ [Deleting the AWS IoT SiteWise demo](#delete-getting-started-demo)

## Creating the AWS IoT SiteWise demo<a name="create-getting-started-demo"></a>

You can create the AWS IoT SiteWise demo from the AWS IoT SiteWise or AWS CloudFormation consoles\.

**Note**  
The demo AWS CloudFormation template creates three Lambda functions, one CloudWatch Events rule, and the IAM roles required for the demo\. You might see these resources in your AWS account\. We recommend that you keep these resources until you're done with the demo\. If you delete the resources, the demo might stop working correctly\.\.

**To create the demo in the AWS IoT SiteWise console**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/) and find the **SiteWise demo** in the upper\-right corner of the page\.

1. \(Optional\) Under **SiteWise demo**, change the **Days to keep demo assets** field to specify how many days to keep the demo before deleting it\.

1. Choose **Create demo**\.

   The demo takes around 3 minutes to create\. If the demo fails to create, your account might have insufficient permissions\. Switch to an account that has administrative permissions, or use the following steps to delete the demo and try again:

   1. Choose **Delete demo**\.

      The demo takes around 15 minutes to delete\.

   1. If the demo doesn't delete, open the [AWS CloudFormation console](https://console.aws.amazon.com/cloudformation/), choose the stack named **IoTSiteWiseDemoAssets**, and choose **Delete** in the upper\-right corner\.

   1. If the demo fails to delete again, follow the steps in the AWS CloudFormation console to skip the resources that failed to delete, and try again\.

1. After the demo creates successfully, you can explore the demo assets and data in the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

**To create the demo in AWS CloudFormation**

1. Open the [AWS CloudFormation template](https://console.aws.amazon.com/cloudformation/home?#/stacks/new?stackName=IoTSiteWiseDemoAssets&templateURL=https%3A%2F%2Fs3.amazonaws.com%2Faws-iot-sitewise%2Fdemo%2FSiteWiseDemoCloudFormation.yml) for the demo\.

1. On the **Create stack** page, choose **Next** at the bottom of the page\.

1. On the **Specify stack details** page, choose **Next**\.

1. \(Optional\) On the **Configure stack options page** page, change the **DemoDurationDays** field to specify how many days to keep the demo before deleting it\.

1. Choose **Next**\.

1. At the bottom of the page, select the check box that says **I acknowledge that AWS CloudFormation might create IAM resources**\.

1. Choose **Create stack**\.

   The stack takes around 3 minutes to create\. If the stack fails to create, your account might have insufficient permissions\. Switch to an account that has administrative permissions, or use the following steps to delete the demo and try again:

   1. Choose **Delete** in the upper\-right corner\.

      The stack takes around 15 minutes to delete\.

   1. If the demo fails to delete, choose **Delete** in the upper right corner again\.

   1. If the demo fails to delete again, follow the steps in the AWS CloudFormation console to skip the resources that failed to delete, and try again\.

1. After the AWS CloudFormation stack creates successfully, you can explore the demo assets and data in the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

## Deleting the AWS IoT SiteWise demo<a name="delete-getting-started-demo"></a>

The AWS IoT SiteWise demo deletes itself after a week, or the number of days you chose if you created the demo stack from the AWS CloudFormation console\. You can delete the demo before if you're done using the demo resources\. You can also delete the demo if the demo fails to create\. Use the following steps to delete the demo manually\.

**To delete the AWS IoT SiteWise demo**

1. Navigate to the [AWS CloudFormation console](https://console.aws.amazon.com/cloudformation)\.

1. Choose **IoTSiteWiseDemoAssets** from the list of **Stacks**\.

1. Choose **Delete**\.

   When you delete the stack, all of the resources created for the demo are deleted\.

1. In the confirmation dialog, choose **Delete stack**\.

   The stack takes around 15 minutes to delete\. If the demo fails to delete, choose **Delete** in the upper\-right corner again\. If the demo fails to delete again, follow the steps in the AWS CloudFormation console to skip the resources that failed to delete, and try again\.