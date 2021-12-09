--------

--------

# Creating a Flow in the Cloud with Devices<a name="iot-tg-gs-thing-sample-cloud"></a>

This topic walks you through the steps to create and deploy a simple workflow \(flow\) that consists of three mock devices running in the cloud: a motion sensor, a camera, and a screen\. The mock devices pretend to be devices running on a Raspberry Pi\.

**Note**  
The flow that you create in this example is the cloud version of the flow in [Creating a Flow with Devices](iot-tg-gs-thing-sample.html) in [AWS IoT Greengrass Flow Examples]()\. This cloud example currently shows how to run the flow only with mock devices\.

The flow in this example is triggered when the motion sensor detects motion\. The motion sensor sends a message to the camera, which takes a picture and sends it to the screen for display\.

Find the code for the mock devices in the [CloudMockDevices\.zip](samples/CloudMockDevices.zip) file\. You can run these scripts on any Linux environment, such as a Raspberry Pi or an [Amazon EC2 instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/), on which Python 2\.7 is installed\.

## Prerequisites<a name="iot-tg-gs-thing-sample-cloud-reqs"></a>

To create this example, you need the following AWS resources: 
+ An [AWS account](http://aws.amazon.com)
+ An IAM role that is configured according to the instructions in [Prepare for Cloud Deployments](iot-tg-gs-environment-cloud.html)

## Create Things<a name="iot-tg-gs-thing-sample-cloud-thingssetup"></a>

Open the [AWS IoT console](https://console.aws.amazon.com/iot/home) and create three things: one thing for your motion sensor, and two things for the camera and screen that are attached to your Raspberry Pi\. 

For instructions on how to create things in the registry, see [Register a Device in the Registry](https://docs.aws.amazon.com/iot/latest/developerguide/register-device.html)\. Be sure to create and activate certificates for each thing\.

For more information about AWS IoT concepts, see [What is AWS IoT?](https://docs.aws.amazon.com/iot/latest/developerguide/what-is-iot.html)

## Set Up Your Mock Devices<a name="iot-tg-gs-thing-sample-cloud-mocksetup"></a>

To run the workflow \(flow\) with mock devices, you need to copy the Python scripts in the [CloudMockDevices\.zip](samples/CloudMockDevices.zip) file to your Linux environment\. These scripts mimic the actions of real devices\.

1. Install the [AWS IoT Device SDK for Python](https://github.com/aws/aws-iot-device-sdk-python)\.

1. Download and extract the [CloudMockDevices\.zip](samples/CloudMockDevices.zip) file\. The extracted directory contains three files named `cloudms.py`, `cloudcamera.py`, and `cloudscreen.py`\.

1. Create folders named `ms`, `camera`, and `screen`\.

1. Copy the `cloudms.py` file into the `ms` directory, the `cloudcamera.py` file into the `camera` directory, and the `cloudscreen.py` file into the `screen` directory\.

1. Copy the certificate and private key for each of the three things that you created into the appropriate directory on your Linux environment\. Also copy the root certificate authority \(CA\) for AWS IoT into each directory\. For example, the motion sensor certificate and private key should be in the `ms` directory, with the root CA for AWS IoT and the `cloudms.py` file\.

   If you haven't created and activated certificates for your things, follow the steps in [Register a Device in the Registry](https://docs.aws.amazon.com/iot/latest/developerguide/register-device.html)\. Make sure to attach a policy to each certificate\.

## Create and Publish the Flow<a name="iot-tg-gs-thing-sample-cloud-publish"></a>

To create this flow with the AWS CLI instead of the AWS IoT Things Graph console, follow the instructions in [Creating a Flow with Devices by Using the AWS CLI](iot-tg-gs-thing-sample-deploy-cli.html)\.

1. Open the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home), and then choose **Create flow**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleCreateFlow.png)

1. Create a flow\.

   In the **Flow configuration** pane that appears, name your flow \(such as **SecurityFlow**\)\. Choose **Create flow**\.

1. Add the device models to the flow\.

   Search for the **MotionSensor** device model\. Select the device model and drag it into the flow designer\. Do the same for the **Camera** and **Screen** device models\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleDevices.png)

1. Connect the device models\.

   In the flow designer, select the edge of the **MotionSensor** device model and connect it to the **Camera** device model\. Also connect the **Camera** device model to the **Screen** device model\.   
![\[Camera and Screen devices connected by a straight line.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleDevices2.png)

1. Update the motion sensor trigger\.

   In the trigger editor that appears in the right pane, for **Condition**, choose **StateChanged**\. For **Action**, choose **ThingsGraph\.startFlow**\.

1. Update the camera device action\.

   1. In the flow designer, select the **Camera** device model\.

   1. In the action editor that appears in the right pane, choose **No action configured**\.

   1. For **Action**, choose **capture**\.

   1. Expand **Output**, and then enter **cameraResult**\.

1. Update the screen device model action\.

   1. In the flow designer, select the **Screen** device model\.

   1. In the action editor that appears in the right pane, choose **No action configured**\.

   1. For **Action**, choose **display**\.

   1. Expand **Inputs**, and then choose **Define Input**\.

   1. For **Inputs**, enter **$\{cameraResult\.lastClickedImage\}**\.

1. Publish the flow\.

   Choose **Publish** at the upper right of the page\. This creates the flow and adds it to the list of flows that can be deployed\.

## Associate Things to Device Models<a name="iot-tg-gs-thing-sample-cloud-associate"></a>

1. Select the menu icon at the upper left of the page\. Choose **Things**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGThingsMenu.png)

   On the **Things** page, choose the motion sensor thing that you created earlier\. Then choose **Associate with device**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGAssociateThingDevice.png)

1. On the **Select device model** page, choose **HCSR501MotionSensor**\. Choose **Associate**\. This step associates the HCSR501MotionSensor motion sensor thing in your registry with the motion sensor device model in your flow\. The HCSR501MotionSensor device implements the capability of the motion sensor device model\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSelectDevice.png)

1. After you return to the **Select device model** page, refresh the page to verify that the motion sensor thing is associated with the HCSR501MotionSensor device\. Repeat the previous two steps for the `RaspberryPiCamera` and `RaspberryPiScreen` devices\.

## Create and Deploy the Flow Configuration<a name="iot-tg-gs-thing-sample-cloud-deploy"></a>

1. Create the flow configuration\.

   Select the menu icon at the upper left of the page, and then choose **Flows** to return to the **Flows** page\. Select the box next to the flow that you just created, and then choose **Create flow configuration**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCreateDeployment.png)

1. Name the flow configuration\.

   A flow configuration contains the details that are specific to a single deployment\. On the **Describe flow configuration** page, select your flow and enter a flow configuration name\. The flow configuration name can't contain spaces\. 

   Choose **Cloud**, and then choose **Next**\.

1. Configure the target\.

   On the **Configure target** page, enter the ARN of the role that you created in [Prepare for Cloud Deployments](iot-tg-gs-environment-cloud.html)\. Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCloudDeploymentDetails2.png)

1. Select things for your deployment\.

   The **Map Things** page provides an interface for selecting the specific things to include in your deployment\. The menus under each device model in your deployment contain all of the things that you associated with the device model\. Because you're getting started, the menus for each device on this page will include only one thing \(the thing that you've associated with each device model\)\.

   On the **Map Things** page, from the menu under the **motionSensor** device model, select the motion sensor thing that you created earlier\. Select the camera and screen things for the **Camera** and **Screen** device models\. Choose **Next**\.

1. View the trigger\.

   On the **Set up triggers** page, the GraphQL that defines the motion event trigger appears in the editor\. This GraphQL specifies the event that triggers the flow\. When the motion sensor detects a person moving, the `ThingsGraph.startFlow` function initiates the flow\. You don't need to edit this code\.

   Choose **Review**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDefineTrigger.png)

1. Review and create\.

   On the **Review and create** page, review the information you entered for your flow configuration\. Then choose **Create**\.

   When the **Flow configuration created** message appears, choose **Deploy now**\.

   Refresh the **Deployments** page to verify that the flow has deployed\. After a successful deployment, the **Deployments** page displays **Deployed in target** in the **Status** column\.

## Run the Flow with Mock Devices<a name="iot-tg-gs-thing-sample-cloud-runmock"></a>

To run the Python scripts for each mock device, you need to know your AWS IoT custom endpoint\. This enables you to connect to AWS IoT\. 

To find this endpoint, open the AWS IoT console \([https://console\.aws\.amazon\.com/iot/](https://console.aws.amazon.com/iot/)\), and then choose **Settings**\. You can also find the endpoint by using the aws iot describe\-endpoint AWS CLI command\.

If you're using an Amazon Trust Services \(ATS\) root CA, use the following AWS CLI command to find your custom endpoint\. For more information about certificates and ATS endpoints, see [X\.509 Certificates and AWS IoT](https://docs.aws.amazon.com/iot/latest/developerguide/managing-device-certs.html)\.

```
aws iot describe-endpoint --endpoint-type iot:Data-ATS
```

Follow these steps to run all three Python scripts and observe the mock devices interacting in the flow\.

1. Open three terminal sessions on your Linux environment\. In one terminal, navigate to the `ms` directory\. To run the `ms.py` script, run the following command\.

   ```
   python cloudms.py -e custom endpoint -r root CA file path -c certificate file path -k private key file path -n motion sensor thing name
   ```

   After the script starts running, it displays the following output every 10 seconds\. This indicates that the mock motion sensor has detected motion\.

   ```
   Published topic TG_MS/motion: {"isMotionDetected": true}
   ```

1. In the second terminal, navigate to the `camera` directory\. Run the `camera.py` script by using the following command\.

   ```
   python cloudcamera.py -e custom endpoint -r root CA file path -c certificate file path -k private key file path -n camera thing name
   ```

   After the script starts running, it displays the following output every 10 seconds\. This indicates that the motion sensor trigger has prompted the mock camera to capture an image and publish it to the `/capture/finished` MQTT topic\.

   ```
   Received message on topic TG_Camera/capture: {}
   
   2019-02-11 21:37:33,430 - AWSIoTPythonSDK.core.protocol.mqtt_core - INFO - Performing sync publish...
   Published topic TG_Camera/capture/finished: {"lastClickedImage": "https://images-na.ssl-images-amazon.com/images/I/41+K4pC74XL._AC_US218_.jpg"}
   ```

1. In the third terminal, navigate to the `screen` directory\. Run the `screen.py` script by using the following command\.

   ```
   python cloudscreen.py -e custom endpoint -r root CA file path -c certificate file path -k private key file path -n screen thing name
   ```

   After the script starts running, it displays the following output every 10 seconds\. This indicates that the mock screen has received the image from the mock camera\.

   ```
   Received message on topic TG_Screen/display: {"imageUri":"https://images-na.ssl-images-amazon.com/images/I/51rMLSWgwRL._AC_US218_.jpg"}
   ```

## Delete the Flow and Flow Configuration \(Optional\)<a name="iot-tg-gs-thing-sample-cloud-cleanup"></a>

For instructions on how to undeploy a flow configuration, and delete the flow configuration and flow that you've created, see [Deleting Flow Configurations](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingflowconfig) and [Deleting Systems, Flows, and Namespaces](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingsysflow) in [Lifecycle Management for AWS IoT Things Graph Entities, Flows, Systems, and Deployments](iot-tg-lifecycle.html)\.