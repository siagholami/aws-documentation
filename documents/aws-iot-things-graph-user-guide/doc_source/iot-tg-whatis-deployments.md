--------

--------

# How a Flow Configuration Works<a name="iot-tg-whatis-deployments"></a>

 An AWS IoT Things Graph [flow configuration](iot-tg-models-tdm-iot-sdc-deployconfig.html) implements a [workflow \(flow\)](iot-tg-models-tdm-iot-workflow.html) for a specific location or deployment\. A flow configuration consists of a flow, associated [triggers](iot-tg-models-tdm-iot-trigger.html), and all the corresponding physical things that interact with each other in the flows\. 

The following diagram shows the elements of a flow configuration and how they relate to each other\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeploymentDiagram.png)

## Contents of a Flow Configuration<a name="iot-tg-whatis-deployments-content"></a>

A flow configuration contains the following elements\.

### Flow<a name="iot-tg-whatis-deployments-content-flow"></a>

A flow \(or workflow\) consists of [device models](iot-tg-models-tdm-iot-device-model.html) and [services](iot-tg-models-tdm-iot-service.html)\. Flows deﬁne how the devices and services interact with each other after a triggering event occurs\. A flow lists these interactions as a sequence of steps\. Each step contains an action on a device or web service and the related inputs to and outputs from that action\. The ﬂow deﬁnes the logical interactions and orders of execution between the devices and services\.

For more information, see [How a Flow Works](iot-tg-whatis-howitworks.html)\.

### Device and Service Models<a name="iot-tg-whatis-deployments-content-models"></a>

Device and service models are representations of the agents that interact in a flow\. Device and service models generically define the attributes, inputs, and outputs of the devices and services that interact with each other in flows\. AWS IoT Things Graph enables you to define device and service interactions without considering the low\-level implementations of devices produced by different manufacturers\.

### Triggers<a name="iot-tg-whatis-deployments-content-triggers"></a>

Triggers are the events that start flows\. Triggers define the conditions \(such as an interval of time passing, a sensor detecting motion, or a change in temperature\) that cause a flow to start\. You define triggers for each flow when you create a flow configuration, so different triggers can start a given flow in different deployments\.

### Things<a name="iot-tg-whatis-deployments-content-things"></a>

Things are the physical devices used in the flows\. When you create a flow configuration, you associate specific things with the device models used in the flows\. For example, if your flow contains a thermostat device model, your flow configuration will contain a thermostat from your AWS IoT things registry that is associated with the thermostat device model\.

## How to Create a Flow Configuration<a name="iot-tg-whatis-deployments-create"></a>

You can create flow configurations by writing the GraphQL directly and using the [AWS IoT Things Graph APIs](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/)\. The [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home) provides an easy way to create, maintain, and deploy your flow configurations\.

For detailed instructions on how to create and deploy flow configurations using both the AWS CLI and the AWS IoT Things Graph console, see [Creating and Deploying Flows](iot-tg-workflows-gs.html)\.