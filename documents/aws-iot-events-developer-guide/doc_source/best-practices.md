# Best practices for AWS IoT Events<a name="best-practices"></a>

Follow these best practices to get the maximum benefit from AWS IoT Events\.

**Topics**
+ [Enable Amazon CloudWatch logging when developing AWS IoT Events detector models](#best-practices-cw-logs)
+ [Publish regularly to save your detector model when working in the AWS IoT Events console](#best-practices-console)
+ [Store your AWS IoT Events data to avoid possible data loss due to a long period of inactivity](#best-practices-inactivity)

## Enable Amazon CloudWatch logging when developing AWS IoT Events detector models<a name="best-practices-cw-logs"></a>

Amazon CloudWatch monitors your AWS resources and the applications that you run on AWS in real time\. With CloudWatch, you gain systemwide visibility into resource use, application performance, and operational health\. When you develop or debug an AWS IoT Events detector model, CloudWatch helps you know what AWS IoT Events is doing, and any errors it encounters\.

**To enable CloudWatch**

1. If you haven't already, follow the steps in [Setting up permissions for AWS IoT Events](iotevents-start.md#iotevents-permissions) to create a role with an attached policy that grants permission to create and manage CloudWatch logs for AWS IoT Events\.

1. In the AWS IoT Events console, choose the menu icon in the upper\-left corner to open the navigation pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/start.png)

   If you're on the **Getting started** page, choose the **X** in the upper right to close that page and go to the **Detector model palette**\. Choose the menu icon in the upper\-left corner\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/welcomeX.png)

1. In the navigation pane, choose **Settings**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/left-nav.png)

1. On the **Settings** page, choose **Edit**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/settings.png)

1. On the **Edit logging options** page, do the following\.

   1.  Choose the **Level of verbosity**\.

   1. For **Select role**, select a role with sufficient permissions to perform the logging actions that you chose\.

   1. If you chose **Debug** for the **Level of verbosity**, you can also choose **Add Model Option** and add a **Detector Model Name** and \(optional\) **KeyValue** to specify the detector model\(s\) and specific detectors \(instances\) to log\.

   1. Choose **Update**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/edit-logging-options.png)

   Your logging options are successfully updated\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/logging-options-updated.png)

## Publish regularly to save your detector model when working in the AWS IoT Events console<a name="best-practices-console"></a>

When you use the AWS IoT Events console, your work in progress is saved locally in your browser \(cookies\)\. But you must choose **Publish** to save your detector model to AWS IoT Events\. After you publish a detector model, your published work is available in any browser that you use to access your account\. Before you publish, your work isn't saved\. 

**Note**  
After you publish a detector model, you can't change its name but you can continue to modify its definition\.

## Store your AWS IoT Events data to avoid possible data loss due to a long period of inactivity<a name="best-practices-inactivity"></a>

If you don't use AWS IoT Events for a significant period of time \(that is, don't incur charges and don't create detector models\) your data, including your detector models, might be deleted automatically\. However, we won't delete data or detector models without providing you with at least 30 days prior notice\. If you need to store data for an extended period of time, consider using [AWS storage services](https://docs.aws.amazon.com/whitepapers/latest/cost-optimization-storage-optimization/aws-storage-services.html)\.