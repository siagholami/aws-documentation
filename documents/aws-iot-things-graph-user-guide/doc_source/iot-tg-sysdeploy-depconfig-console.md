--------

--------

# Creating a Flow Configuration in the AWS IoT Things Graph console<a name="iot-tg-sysdeploy-depconfig-console"></a>

These instructions are a subset of the procedure for creating and deploying the flow in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html)\. See that topic for complete instructions on setting up your environment, creating things, creating the flow \(and the system\), and associating things with devices\.

1. Create the flow configuration\.

   Select the menu icon at the upper left of the page, and then select **Flows** to return to the **Flows** page\. On the **Flows** page, select the box next to the flow that you just created, and then choose **Create flow configuration**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCreateRekDeployment.png)

1. Name the flow configuration\.

   On the **Describe flow configuration** page, select your flow, and then enter a flow configuration name\. The flow configuration name can't contain spaces\. Choose **Greengrass**, and then choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekDeploymentDetails.png)

1. Configure the target\.

   On the **Configure target page**, enter the name of your Amazon S3 bucket and the AWS IoT Greengrass group to which your AWS IoT Greengrass core device belongs\. Choose **Next**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekDeploymentDetails2.png)

1. Select things for your deployment\.

   The **Map Things** page provides an interface for selecting the specific things that you'll include in your deployment\. The menus under each device in your deployment contain all of the things that you associated with the device\. Because you're getting started, the menus for each device on this page will include only one thing \(the thing that you've associated with each device\)\.

   On the **Map Things** page, under the **motionSensor** device, select the motion sensor thing that you created earlier\. Select the camera and screen things for the **Camera** and **Screen** devices\. Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekSelectThings.png)

1. View the trigger\.

   On the **Define trigger** page, the GraphQL that defines the motion event trigger for the flow appears in the editor\. When the motion sensor detects motion, the `ThingsGraph.startFlow` function initiates the flow\. You don't need to edit this code\.

   Choose **Review**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekDefineTrigger.png)

1. Review and create\.

   On the **Review and create** page, review the information you entered for your flow configuration\. Choose **Create**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGReviewDeployment.png)

1. Deploy\.

   When the **Flow configuration created** message appears, choose **Deploy now**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeploymentCreated.png)

   After a successful deployment, the **Deployments** page displays **Deployed in target** in the **Status** column\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeploySuccess.png)