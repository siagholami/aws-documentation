--------

--------

# Viewing Models and Things in the AWS IoT Things Graph Console<a name="iot-tg-models-console"></a>

The models section of the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home) shows you all of the available services, devices, and device models in your namespace and in the public namespace\. It also provides important information about each device and device model, including its definition and associated things\. The things section of the console shows you all of the things in your AWS IoT registry\. It also enables you to associate those things with devices in your namespace and in the public namespace\. 

This topic describes the features of the models and things sections and explains how to use them\.

## Models List<a name="iot-tg-models-console-list"></a>

The main page of the models section contains a list of all of the devices and device models in your namespace and in the public namespace, as shown in the following screenshot\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGModelsList.png)

To create a model, choose **Create Model**\. Follow the instructions to upload a file that contains all the components \(properties, state, actions, events, and capability\) of your service, device, or device model\. You can also edit the model in a GraphQL editor in the browser, as shown in the following screenshot\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGModelEditor.png)

For more information about creating device definitions with the AWS IoT Things Graph Data Model, see the [AWS IoT Things Graph Data Model Reference](iot-tg-models.html) and [Example Device and Service Definitions](iot-tg-examples.html)\.

## Model Details<a name="iot-tg-models-console-details"></a>

To see details about each service, device, or device model, select the linked name in the **Device class/subclass** column\. \(You can also select the box next to the name, and then choose **View details**\.\) The default **Details** tab on the page that's displayed provides summary information about the definition, as shown in the following screenshot\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGModelDetails.png)

If you're viewing a device model, the **Device models** and **Associated things** tabs also appear\. The **Device models** tab displays all of the devices in your namespace and in the public namespace that implement the device model and its capability\. The following screenshot shows one device that implements the **MotionSensor** device model\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGMSDetails.png)

If you're viewing a device model, the **Associated things** tab displays all of the things in your AWS IoT registry that are associated with the devices that implement the device model\. You can also search for associated things from this page\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGMSThings.png)

## Model Definition<a name="iot-tg-models-console-definition"></a>

You can view the definition of a service, device, or device model in two ways\. To download a file that contains the definition, choose **Download model**\. To view the definition in the browser, choose **View definition**\. The complete model definition appears in a new window\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGMSDefinition.png)

When you select the **Details** tab, **Edit model** and **Edit** appear on the right side of the screen and are enabled\. The two buttons perform the same operation\. To edit the definition, choose **Edit** or **Edit Model**\. Follow the instructions to upload a file containing updated versions of the components \(properties, state, actions, events, and capability\) of your service, device, or device model\. You can also edit the model in a GraphQL editor in the browser\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGEditModel.png)

## Associating Things with Devices<a name="iot-tg-models-console-things"></a>

The things section of the AWS IoT Things Graph console lists all of the things in your AWS IoT registry\. You can use this page to associate each thing with a device in your namespace or in the public namespace\. 

After you associate a thing with a device, you can include that thing in a deployment that includes a flow that contains the device or a device model from which the device inherits\. The following screenshot shows an example of the things list\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGThingsList.png)

To associate a thing with a device, select the thing and then choose **Associate with model**\. The **Select device model** list appears\. You can page through the list or use the **Search device models** box to find the device you want\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGThingsPageSelect.png)

A thing can be associated with only one device\. To dissociate a thing with a device, select the thing and then choose **Dissociate with model**\.