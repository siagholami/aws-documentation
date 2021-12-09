# Getting started with the AWS IoT Events console<a name="iotevents-getting-started"></a>

This section shows you how to create an input and a detector model using the [AWS IoT Events console](https://console.aws.amazon.com/iotevents/)\. You model two states of an engine: a normal state and an over\-pressure condition\. When the measured pressure in the engine exceeds a certain threshold, the model transitions from the normal state to the over\-pressure state\. Then it sends an Amazon SNS message to alert a technician about the condition\. When the pressure again drops below the threshold for three consecutive pressure readings, the model returns to the normal state and sends another Amazon SNS message as a confirmation\.

We check for three consecutive readings below the pressure threshold to eliminate possible stuttering of over\-pressure/normal messages, in case of a nonlinear recovery phase or an anomalous pressure reading\.

On the console you can also find several pre\-made detector model templates which you can customize\. You can also use the console to import detector models that others have written or export your detector models and use them in different AWS Regions\. If you import a detector model, make sure that you create the required inputs or recreate them for the new Region, and update any role ARNs used\.

Use the AWS IoT Events console to learn about the following\.

**Define inputs**  
To monitor your devices and processes, they must have a way to get telemetry data into AWS IoT Events\. This is done by sending messages as *inputs* to AWS IoT Events\. You can do this in several ways:  
+ Use the [ BatchPutMessage](https://docs.aws.amazon.com/iotevents/latest/apireference/API_iotevents-data_BatchPutMessage.html) operation\.
+ In AWS IoT Core write an [AWS IoT Events action](https://docs.aws.amazon.com/iot/latest/developerguide/iot-rule-actions.html#iotevents-rule) rule for the AWS IoT rules engine that forwards your message data into AWS IoT Events\. You must identify the input by name\.
+ In AWS IoT Analytics, use the [ CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate-create-dataset) operation to create a data set with `contentDeliveryRules`\. These rules specify the AWS IoT Events input where data set contents are sent automatically\.
Before your devices can send data in this way, you must define one or more inputs\. To do so, give each input a name and specify which fields in the incoming message data that the input will monitor\.

**Create a detector model**  
Define a *detector model* \(a model of your equipment or process\) using *states*\. For each state, define conditional \(Boolean\) logic that evaluates the incoming inputs to detect significant events\. When an event is detected, it can change the state or trigger custom\-built or predefined actions using other AWS services\. You can define additional events that trigger actions when entering or exiting a state and, optionally, when a condition is met\.   
In this tutorial, you send an Amazon SNS message as the action when the model enters or exits a certain state\.

**Monitor a device or process**  
If you monitor several devices or processes, specify a field in each input that identifies the particular device or process the input comes from\. See the `key` field in `CreateDetectorModel`\. When a new device is identified \(a new value is seen in the input field identified by the `key`\), a detector is created\. Each detector is an instance of the detector model\. The new detector continues responding to inputs coming from that device until its detector model is updated or deleted\.  
If you monitor a single process \(even if several devices or subprocesses are sending inputs\), you don't specify a unique identifying `key` field\. In this case, a single detector \(instance\) is created when the first input arrives\.

**Send messages as inputs to your detector model**  
There are several ways to send a message from a device or process as an input into an AWS IoT Events detector that don't require you to perform additional formatting on the message\. In this tutorial, you use the AWS IoT console to write an [ AWS IoT Events action](https://docs.aws.amazon.com/iot/latest/developerguide/iot-rule-actions.html#iotevents-rule) rule for the AWS IoT rules engine that forwards your message data into AWS IoT Events\.  
To do this, identify the input by name and continue to use the AWS IoT console to generate messages that are forwarded as inputs to AWS IoT Events\.

**Note**  
This tutorial uses the console to create the same `input` and `detector model` shown in the example at [Tutorials](iotevents-tutorials.md)\. You can use the this JSON example to help you follow the tutorial\.

**Topics**
+ [Prerequisites](iotevents-getting-started-prereqs.md)
+ [Create an input](iotevents-detector-input.md)
+ [Create a detector model](iotevents-detector-model.md)
+ [Send inputs to test the detector model](iotevents-iot-rules-engine.md)