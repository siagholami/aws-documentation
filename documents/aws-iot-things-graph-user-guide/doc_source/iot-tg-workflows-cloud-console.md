--------

--------

# Create and Deploy a Flow \(AWS IoT Things Graph console\)<a name="iot-tg-workflows-cloud-console"></a>

1. Sign in to the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home)\.

   Choose **Create flow**\.  
![\[Choose the Create flow button at the upper right of the page.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleCreateFlow.png)

1. **Name the flow\.**

   In the **Flow configuration** pane, enter a name for your flow\. This name can't contain any spaces\.

   Choose **Create flow**\.

1. **Add the trigger and devices to the flow\.**

   On the **Logic** tab, choose **Clock**, and then drag it into the flow designer\. 

   Search for **DeviceA**, which is a barcode reader that you created in [Creating and Uploading Models](iot-tg-models-gs.html)\. Select the device and drag it into the flow designer\. Do the same for **DeviceB**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowConfigExample.png)

1. **Connect the devices\.**

   In the flow designer, select the edge of **ClockTrigger** and connect it to **DeviceA**\. Connect **DeviceA** and **DeviceB** in the same way\.  
![\[ClockTrigger, DeviceA, and DeviceB connected by straight lines.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowConfigExample2.png)

   The event appears between the two devices because **DeviceA** passes an output \(the bar code\) to **DeviceB**\. You can pass this output to multiple devices and services by connecting this event to them, as in the following image\.  
![\[DeviceA passes output to two instances of DeviceB through the event.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-flow-two-outputs.png)

   This is the correct way to pass output to multiple entities\. Directly connecting one device or service to multiple devices or services causes a syntax error when you try to publish the flow\.

1. **Update the **ClockTrigger**\.**

   In the trigger editor that appears in the right pane, for **Frequency**, enter 10, and then select seconds from the menu on the right\. For **Action**, choose **ThingsGraph\.startFlow**\. 

1. **Update the device action for **DeviceA**\.**

   In the flow designer, select **DeviceB**\. Select **No action configured** in the action editor that appears in the right pane\. Select **readBarcode** from the drop\-down box that appears\. Select the arrow that appears to the left of the **Output** option\. Enter **deviceAResult** in the text box that appears under **Output**\.

   Click the surface of the flow designer to close the action editor\.

1. **Update the device action for **DeviceB**\.**

   In the flow designer, select **DeviceB**\. Select **No action configured** in the action editor that appears in the right pane\. Select **doSomething** from the drop\-down box that appears\. Select **Define Input** under the **Inputs** option\. Enter **$\{deviceAResult\}** in the pop\-up box that appears\. Select the **Save Input** button

   Click the surface of the flow designer to close the action editor\.

1. **Publish the flow\.**

   Choose **Publish** at the upper right of the page\. This creates the flow and adds it to the list of flows that can be deployed\. Then choose **Go to flow list** to verify that your flow is created\.

1. **Start creating the flow configuration\.**

    On the **Flows** list page, select the check box next to the flow that you just created, and then choose **Create flow configuration**\.  
![\[When the check box next to the flow is checked, the Create flow configuration button appears.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCreateDeploymentExample.png)

1. **Name the flow configuration\.**

   On the **Describe flow configuration** page, select your flow and enter a deployment name\. The deployment name can't contain spaces\. Choose **Cloud**, and then choose **Next**\.

1. **Configure the target\.**

   On the **Configure target** page, enter the ARN of the role that you created in [Prepare for Cloud Deployments](iot-tg-gs-environment-cloud.html)\. Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGExampleCreateCloudDeployment2.png)

1. **Select things\.**

   On the **Map Things** page, from the menu under **deviceA**, select the thing that you associated with this device in [Creating and Uploading Models](iot-tg-models-gs.html)\. Do the same for **deviceB**\. Choose **Next**\.  
![\[Associated things appear in drop-down menus under devices. Select the associated thing for each device.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGExampleConfigureDeployment.png)

1. **View the trigger\.**

   On the **Set up triggers** page, the following GraphQL appears in the editor\. This GraphQL specifies the time intervals at which the flow runs\. This flow runs every 10 seconds\. You don't need to edit this code\.

   Choose **Review**\.  
![\[Trigger definition that starts the flow every 10 seconds.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDefineTriggerExample.png)

1. **Review and create**

   On the **Review and create** page, review the information you entered for your flow configuration\.

   Choose **Create**\.

1. Deploy

   When the **Flow configuration created** message appears, choose **Deploy now**\.

   After a successful deployment, the **Deployments** page displays **Deployed in target** in the **Status** column\.