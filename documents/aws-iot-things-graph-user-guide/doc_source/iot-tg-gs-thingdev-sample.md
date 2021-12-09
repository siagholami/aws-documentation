--------

--------

# Creating a Flow with Devices and a Service<a name="iot-tg-gs-thingdev-sample"></a>

This topic walks you through the steps to create and deploy a simple workflow \(flow\) that consists of a Raspberry Pi connected to three devices: an [Aukru HC\-SR501 motion sensor](https://www.amazon.com/Aukru-Pyroelectricity-Raspberry-Microcontrollers-Electronic/dp/B019SX734A), a [Raspberry Pi camera](https://www.amazon.com/Raspberry-Pi-Camera-Module-Megapixel/dp/B01ER2SKFS), and a [Raspberry Pi screen](https://www.amazon.com/Raspberry-Pi-7-Touchscreen-Display/dp/B0153R2A9I)\. It also contains an AWS IoT Things Graph service model that exposes the face detection capability of [Amazon Rekognition](https://docs.aws.amazon.com/rekognition/latest/dg/)\.

The flow is triggered when the motion detector detects a person moving\. The motion detector sends a message to the camera, which takes a picture and sends it to the Amazon Rekognition service model\. The service model sends the image to display to the screen\. The service model doesn't process the results of the `DetectFaces` API or send anything other than the image to the screen\. 

You can modify this example by adding a service model between the Amazon Rekognition service and the screen\. The additional service model can process the results \(such as determining whether the image should be displayed on the screen\) before sending the image to the screen\.

## Prerequisites<a name="iot-tg-gs-thingdev-sample-reqs"></a>

To create this example, you need the following resources: 
+ An [AWS account](http://aws.amazon.com)
+ A [Raspberry Pi](https://www.amazon.com/s/?field-keywords=raspberry+pi) running [AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html) version 1\.7 or later
+ An [Aukru HC\-SR501 motion sensor](https://www.amazon.com/Aukru-Pyroelectricity-Raspberry-Microcontrollers-Electronic/dp/B019SX734A)
+ A [Raspberry Pi 7" touchscreen display](https://www.amazon.com/Raspberry-Pi-7-Touchscreen-Display/dp/B0153R2A9I)
+ A [Raspberry Pi camera module v2\-8 megapixel,1080p](https://www.amazon.com/Raspberry-Pi-Camera-Module-Megapixel/dp/B01ER2SKFS)
+ An [Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html) bucket

## Set Up Your Raspberry Pi<a name="iot-tg-gs-thingdev-sample-rpi"></a>

To run the workflow \(flow\), you need to set up your Raspberry Pi\.
+  Attach your motion sensor to [Raspberry Pi GPIO pin 1](https://pi4j.com/1.2/pins/model-3b-plus-rev1.html)\. 
+  Attach the camera by following the instructions in the [Raspberry Pi camera board documentation](https://www.raspberrypi.org/documentation/usage/camera/)\. Attach the screen by following the instructions in the [Raspberry Pi 7" touch screen assembly guide](https://thepihut.com/blogs/raspberry-pi-tutorials/45295044-raspberry-pi-7-touch-screen-assembly-guide)\. 
+  Download and install the drivers included in the [ThingsGraphPrototypeDevices\.zip](samples/ThingsGraphPrototypeDevices.zip) file\. Follow the instructions in the README to install the drivers\.

Now you've configured your Raspberry Pi to communicate with the motion sensor, camera, and screen\.

## Create an AWS IoT Greengrass Group<a name="iot-tg-gs-thingdev-sample-gg"></a>

**Note**  
For information about using AWS CloudFormation to create and manage AWS IoT Greengrass groups and resources, see [AWS IoT Greengrass Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/AWS_Greengrass.html)\.

Install AWS IoT Greengrass on the same Raspberry Pi to which you attached your motion sensor, camera, and screen\. 

Perform the steps in [Setting Up Your Environment](iot-tg-gs-environment.html) on your Raspberry Pi\. Make sure that you've created an IAM role for AWS IoT Greengrass \(step 4 in the **Create an AWS IoT Greengrass group** procedure in that topic\)\. Attach the `AmazonS3FullAccess` policy to give it access to your S3 bucket\.

**Note**  
The AWS IoT Greengrass group and Amazon S3 bucket that you use in this example must be created in the same AWS Region\. The AWS IoT Things Graph entities that you create must also be in the same Region as these resources\.

## Create Things<a name="iot-tg-gs-thingdev-sample-thingssetup"></a>

Open the [AWS IoT console](https://console.aws.amazon.com/iot/home) and create three things: one thing for your motion sensor, and two things for the camera and screen that are attached to your Raspberry Pi\. 

For instructions on how to create things in the registry, see [Register a Device in the Registry](https://docs.aws.amazon.com/iot/latest/developerguide/register-device.html)\. 

On the **Greengrass** tab in the [AWS IoT console](https://console.aws.amazon.com/iot/home), choose your group, choose **Devices**, and then add the three new things to your AWS IoT Greengrass group\.

For general information about AWS IoT concepts, see [What is AWS IoT?](https://docs.aws.amazon.com/iot/latest/developerguide/what-is-iot.html)

## Create and Publish the Flow<a name="iot-tg-gs-thingdev-sample-publish"></a>

To create this flow with the AWS CLI instead of the AWS IoT Things Graph console, follow the instructions in [Creating a Flow with Devices and a Service by Using the AWS CLI](iot-tg-gs-thingdev-sample-deploy-cli.html)\.

1. Open the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home)\.

   Choose **Create flow**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleCreateFlow.png)

1. Create a flow\.

   In the **Flow configuration** pane that appears, name your flow \(such as **RekognitionFlow**\)\. Choose **Create flow**\.

1. Add the device models and service model to the flow\.

   1. Search for the **MotionSensor** device model\. Select the device and drag it into the flow designer\.

   1. Search for the **CameraRkgnExample** device model\. Select the device model and drag it into the flow designer\. 

   1. On the **Services** tab, search for the **Rekognition** service model\. Select the service model and drag it into the flow designer\. 

   1. On the **Devices** tab, do the same for the **Screen** device model\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekognitionDevices.png)

1. Connect the device models\.

   In the flow designer, select the edge of the **MotionSensor** device model and connect it to the **CameraRkgnExample** device model\. Then connect the **CameraRkgnExample** device model, **Rekognition** service model, and the **Screen** device model in the same way\.   
![\[CameraRkgnExample device model, Rekognition service model, and Screen device model connected by straight lines.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekognitionDevices2.png)

1. Update the motion sensor trigger\.

   In the trigger editor that appears in the right pane, for **Condition**, choose **StateChanged**\. For **Action**, choose **ThingsGraph\.startFlow**\.

1. Update the camera device model action\.

   1. In the flow designer, select the **CameraRkgnExample** device model\.

   1. In the action editor that appears in the right pane, select **No action configured**\.

   1. For **Action**, choose **capture**\.

   1. Expand **Output**, and then enter **cameraRkgnExampleResult**\.

1. Update the **Rekognition** service model activity\.

   1. In the flow designer, select the **Rekognition** service model\.

   1. In the action editor that appears in the right pane, select **No action configured**\.

   1. For **Action**, choose **detectFaces**\.

   1. Expand **Inputs**, and then choose **Define Input**\.

   1. For **bucketName**, enter **$\{cameraRkgnExampleResult\.s3BucketName\}**\.

   1. For **itemName**, enter **$\{cameraRkgnExampleResult\.s3ItemName\}**\.

   1. Expand **Output**, and then enter **rekognitionResult**\.

1. Update the screen device model activity\.

   1. In the flow designer, select the **Screen** device model\.

   1. In the action editor that appears in the right pane, select **No action configured**\.

   1. For **Action**, choose **display**\.

   1. Expand **Inputs**, and then choose **Define Input**\.

   1. For **imageUrl**, enter **$\{cameraRkgnExampleResult\.lastClickedImage\}**\.

1. Publish the flow\.

   Choose **Publish** at the upper right of the page\. This creates the flow and adds it to the list of flows that can be deployed\.

## Asscoiate Things to Device Models<a name="iot-tg-gs-thingdev-sample-associate"></a>

1. Associate things to device models\.

   Select the menu icon at the upper left of the page\. Then choose **Things**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGThingsMenu.png)

   On the **Things** page, select the motion sensor thing that you created earlier\. Then choose **Associate with device**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGAssociateThingDevice.png)

1. On the **Select device model** page, choose **HCSR501MotionSensor**\. Choose **Associate**\. This step associates the HCSR501MotionSensor motion sensor thing in your registry with the motion sensor device model in your flow\. The HCSR501MotionSensor device implements the capability of the motion sensor device model\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSelectDevice.png)

1. After you return to the **Select device model** page, refresh the page to verify that the motion sensor thing is associate with the HCSR501MotionSensor device\. Repeat the previous two steps for the `RaspberryPiCameraRkgnExample` and `RaspberryPiScreen` devices\.

## Create and Deploy the Flow Configuration<a name="iot-tg-gs-thingdev-sample-deploy"></a>

1. Create the flow configuration\.

   Select the menu icon at the upper left of the page, and then select **Flows** to return to the **Flows** page\. On the **Flows** page, select the box next to the flow that you just created, and then choose **Create flow configuration**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCreateRekDeployment.png)

1. Name the flow configuration\.

   On the **Describe flow configuration** page, select your flow, and then enter a flow configuration name\. The flow configuration name can't contain spaces\. Choose **Greengrass**, and then choose **Next**\.

1. Configure the target\.

   On the **Configure target page**, enter the name of your Amazon S3 bucket and the AWS IoT Greengrass group to which your AWS IoT Greengrass core device belongs\. Amazon S3 buckets are globally unique, so your bucket name will be different from the one in the following screen shot\. Choose **Next**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekDeploymentDetails2.png)

1. Select things for your deployment\.

   The **Map Things** page provides an interface for selecting the specific things that you'll include in your deployment\. The menus under each device model in your deployment contain all of the things that you associated with the device model\. Because you're getting started, the menus for each device model on this page will include only one thing \(the thing that you've associated with each device model\)\.

   On the **Map Things** page, for **motionSensor**, select the motion sensor thing that you created earlier\. Select the camera and screen things for the **Camera** and **Screen** device models\. Choose **Next**\.

1. View the trigger\.

   On the **Define trigger** page, the GraphQL that defines the motion event trigger for the flow appears in the editor\. When the motion sensor detects motion, the `ThingsGraph.startFlow` function initiates the flow\. You don't need to edit this code\.

   Choose **Review**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGRekDefineTrigger.png)

1. Review and create\.

   On the **Review and create** page, review the information you entered for your flow configuration\. Choose **Create**\.

1. Deploy\.

   When the **Flow configuration created** message appears, choose **Deploy now**\.

   Refresh the **Deployments** page to verify that the flow has deployed\. After a successful deployment, the **Deployments** page displays **Deployed in target** in the **Status** column\.

## Run the Flow<a name="iot-tg-gs-thingdev-sample-run"></a>

Because the screen doesn't use information returned by the Amazon Rekognition service model, the steps for running this flow are the same as those in [Creating a Flow with Devices](iot-tg-gs-thing-sample.html#iot-tg-gs-thing-sample-runreal)\. 

## Delete the Flow and Flow Configuration \(Optional\)<a name="iot-tg-gs-thingdev-sample-cleanup"></a>

For instructions on how to undeploy a flow configuration, and delete the flow configuration and flow that you've created, see [Deleting Flow Configurations](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingflowconfig) and [Deleting Systems, Flows, and Namespaces](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingsysflow) in [Lifecycle Management for AWS IoT Things Graph Entities, Flows, Systems, and Deployments](iot-tg-lifecycle.html)\.